(ns deadly
  (:require [clojure.algo.generic.math-functions :refer [approx=]]
            [clojure.test :refer [testing is deftest]]))


(def barbarian
  ; https://www.dndbeyond.com/profile/Phoodstuff/characters/28588926
  {:hp 95
   :dice [6 6]
   :hit +9
   :dmg +5
   :ac 14
   :attacks 2
   :raging false
   :rage true
   :rage-dmg +3
   :brutal-critical true
   :reckless false
   :frenzy false
   :init +2
   :init-adv true
   :res false
   :p {0 1/1}})

(def earth-elemental
  ; https://www.dndbeyond.com/monsters/earth-elemental
  {:hp 126
   :dice [8 8]
   :hit +8
   :dmg +5
   :ac 17
   :attacks 2
   :raging false
   :rage false
   :rage-dmg 0
   :brutal-critical false
   :reckless false
   :frenzy false
   :init 0
   :init-adv false
   :res true
   :p {0 1/1}})

(def ogre
  ; https://www.dndbeyond.com/monsters/ogre
  {:hp 59
   :dice [8 8]
   :hit +6
   :dmg +4
   :ac 11
   :attacks 1
   :raging false
   :rage false
   :rage-dmg 0
   :brutal-critical false
   :reckless false
   :frenzy false
   :init 0
   :init-adv false
   :res false
   :p {0 1/1}}
  )

(def ettin
  {:hp 85
   :dice [8 8]
   :hit +7
   :dmg +5
   :ac 12
   :attacks 2
   :raging false
   :rage false
   :rage-dmg 0
   :brutal-critical false
   :reckless false
   :frenzy false
   :init 0
   :init-adv false
   :res false
   :p {0 1/1}}
   )

(defn base-p
  [d]
  (reduce #(assoc %1 (inc %2) (/ 1 d)) {} (range d)))

(deftest test-base-p
  (testing "n sided dice to probability"
    (testing "d2"
      (is (= (base-p 2) {1 1/2 2 1/2})))
    (testing "d4"
      (is (= (base-p 4) {1 1/4 2 1/4 3 1/4 4 1/4})))
    (testing "d6"
      (is (= (base-p 6) {1 1/6 2 1/6 3 1/6 4 1/6 5 1/6 6 1/6})))))


(defn combine-p
  [ps]
  (reduce (fn [d1 d2] 
                   (for [[v1 p1] d1
                         [v2 p2] d2]
                     [(+ v1 v2) (* p1 p2)])) ps))

(deftest test-combine-p
  (testing "combine chances of concurrent events"
    (is (= [[2 1/4] [3 1/4] [3 1/4] [4 1/4]] 
           (combine-p [{1 1/2 2 1/2} {1 1/2 2 1/2}])))))

(defn add-p
  [ps]
  (reduce (fn [out [v p]]
            (update out v 
                    (fn [old] (if (nil? old) p (+ p old))))){} ps))

(deftest test-add-p
  (testing "add together all chances of arriving at the same value"
    (is  (= {2 1/4 3 1/2 4 1/4} (add-p [[2 1/4] [3 1/4] [3 1/4] [4 1/4]])))
    (is  (= {6 1} (add-p [[6 1/2] [6 1/4] [6 1/8] [6 1/8]])))))

(defn calc-p-dice
  [dice]
  (->> dice
       (map base-p)
       (combine-p)
       (add-p)))

(deftest test-calc-p-dice
  (testing "probility of out come from rolling n number of dice"
    (testing "1d2"
      (is (= {1 1/2 2 1/2} (calc-p-dice [2]))))
    (testing "2d2"
      (is (= {2 1/4 3 1/2 4 1/4} (calc-p-dice [2 2]))))
    (testing "4d4"
      (is (= (calc-p-dice [4 4 4 4]) 
             {4 1/256
              5 1/64
              6 5/128
              7 5/64
              8 31/256
              9 5/32
              10 11/64
              11 5/32
              12 31/256
              13 5/64
              14 5/128
              15 1/64
              16 1/256})))))

(defn calc-p-miss
  [active target]
  ; AC - hitbous - 1 / 20 == miss p
  (-> (/ (- (:ac target) (:hit active)) 20)
      ; natural 1
      (max 1/20)
      ; natural 20
      (min 19/20)))

(deftest test-calc-p-miss
  (testing "AC 0 == 5% chance to miss (natural 1)"
    (is (= (calc-p-miss {:hit 0} {:ac 0}) 1/20)))
  (testing "AC 10 == 50% chance to miss"
    (is (= (calc-p-miss {:hit 0} {:ac 10}) 1/2)))
  (testing "AC 18 == 90% chance to miss"
    (is (= (calc-p-miss {:hit 0} {:ac 18}) 9/10))))

; couple of santity checking tools
(defn sum-p
  [values]
  (reduce (fn [total [_ p]]  (+ total p)) 0.0 values))

(defn sums-to-1?
  [values]
  (approx= (sum-p values) 1 1e-5))


(defn calc-p-dmg
  "Returns the probability of damage caused by a single attack"
  [active target]
  (let [p-miss (calc-p-miss active target)
        p-crit 1/20
        p-hit (- 1 p-miss p-crit)
        dice (:dice active)
        double-dice (concat dice dice)
        dmg (:dmg active)]

    (add-p (->> (concat 
                  (combine-p [(calc-p-dice dice) {dmg p-hit}])
                  (combine-p [(calc-p-dice double-dice) {dmg p-crit}])
                  [[0 p-miss]])
                (map (fn [[v p]] 
                       (if (:res target)
                         [(int (Math/floor (/ v 2))) p]
                         [v p])))))))

(deftest test-calc-p-dmg
  (testing "damage from a single attack"
    (testing "1d1"
      (is (= (calc-p-dmg {:hit 0 :dmg 0 :dice [1]} {:ac 0 :res false})
             {0 1/20
              1 18/20
              2 1/20}))
      (is (= (calc-p-dmg {:hit 0 :dmg 0 :dice [1]} {:ac 10 :res false})
             {0 1/2
              1 9/20
              2 1/20}))
      (is (= (calc-p-dmg {:hit 5 :dmg 0 :dice [1]} {:ac 10 :res false})
             {0 1/4
              1 14/20
              2 1/20}))
      (is (= (calc-p-dmg {:hit 0 :dmg 5 :dice [1]} {:ac 0 :res false})
             {0 1/20
              6 18/20
              7 1/20}))
      (is (= (calc-p-dmg {:hit 0 :dmg 0 :dice [1]} {:ac 0 :res true})
             {0 19/20
              1 1/20})))
    (testing "1d4"
      (is (= (calc-p-dmg {:hit 0 :dmg 0 :dice [4]} {:ac 0 :res false})
             {0 1/20
              1 (* 18/20 1/4)
              2 (+ (* 18/20 1/4) (* 1/20 1/4 1/4))
              3 (+ (* 18/20 1/4) (* 1/20 2/4 1/4))
              4 (+ (* 18/20 1/4) (* 1/20 3/4 1/4))
              5 (* 1/20 1/4)
              6 (* 1/20 3/4 1/4)
              7 (* 1/20 2/4 1/4)
              8 (* 1/20 1/4 1/4)})))
    (testing "2d2"
      (is (= (calc-p-dmg {:hit 0 :dmg 0 :dice [2 2]} {:ac 0 :res false})
             {0 1/20
              2 (* 18/20 1/4)
              3 (* 18/20 1/2)
              4 (+ (* 18/20 1/2 1/2) (* 1/20 1/16))  
              5 (* 1/20 1/4)
              6 (* 1/20 3/8)
              7 (* 1/20 1/4)
              8 (* 1/20 1/16)})))))

(defn apply-p-dmg
  [active target]
  (let [p (-> (iterate #(-> (combine-p [% (calc-p-dmg active target)])
                            (add-p)) (:p target))
              (nth (:attacks active)))]
        ; normalise anything above max hp
        ;p (reduce (fn [target-p [v p]]
                    ;(if (>= v (:hp target))
                      ;(assoc target-p (:hp target) (+ (get target-p v 0) p))
                      ;(assoc target-p v p))) {} p)]
  (assoc target :p p)))



(def crash-test-dummy
  "sadly D&D doesn't have monster that would tests easy"
  {:hp 10 :p {0 1/1} :dice [1] :ac 0 :hit +0 :dmg +0 :attacks 1})

(deftest test-apply-p-dmg
  (testing "single attack"
    (is (= (:p (apply-p-dmg crash-test-dummy crash-test-dummy))
           {1 9/10 2 1/20 0 1/20})))
  (testing "2 attacks"
    (is (= (:p (apply-p-dmg (assoc crash-test-dummy :attacks 2) crash-test-dummy))
           {2 163/200 3 9/100 1 9/100 4 1/400 0 1/400}))))

(defn p-dead
  [target]
  (reduce 
    (fn [total [v p]] 
      (if (>= v (:hp target))
        (+ total p)
        total))
    0
    (:p target)))


(defn dead?
  [target certainty]
  (>= (p-dead target) certainty))


(deftest test-dead?
  (testing "something that is deffo not dead"
    (is (not (dead? {:hp 10 :p {0 1}} 99/100))))
  (testing "something that is deffo dead"
    (is (dead? {:hp 10 :p {10 1}} 99/100)))
  (testing "overkill"
    (is (dead? {:hp 10 :p {11 1}} 99/100)))
  (testing "looking pretty rough"
    (is (not (dead? {:hp 10 :p {10 1/4 9 1/2 8 1/4}} 99/100))))
  (testing "dying breath"
    (is (not (dead? {:hp 10 :p {10 98/100 9 2/100}} 99/100)))))



(defn n->percentage
  [n]
  (format "%.1f" (float (* n 100))))

(defn p->human
  [[v p]]
  (format "%d: %.1f" v (float (* p 100))))

(defn print-id
  [x]
  (println x)
  x)

(defn find-target
  [enemy-combatants]
  (->> enemy-combatants
      (filter (fn [[_ target]] (not (dead? target 51/100))))
      (sort-by (fn [[_ target]] 
                 (max (- (:hp target) (apply max (keys (:p target)))) 0)))
      
      (first)
      (first )))


(deftest test-find-target
  (testing "lowest potential health target"
    (let [team-2 {:bobbo {:hp 10 :p {2 1/10 3 9/10}}
                  :davo {:hp 10 :p {1 1/1}}
                  :trevor {:hp 10 :p {5 1/2 4 1/2}}}]
    (is (= (find-target team-2) :trevor)))))

(defn combat-iter
  [turn [active-name & others] team-1 team-2]
  (let [team-a (if (contains? team-1 active-name) team-1 team-2)
        team-b (if (contains? team-1 active-name) team-2 team-1)
        active (active-name team-a)
        target-name (find-target team-b)
        target (apply-p-dmg active (target-name team-b))
        ; I WOULD LIKE TO RAGE!
        active (if (and (:rage active) (not (:raging active)))
                 (assoc active 
                        :raging true
                        :attacks (inc (:attacks active))
                        :res true
                        :dmg (+ (:dmg active) (:rage-dmg active)))
                 active)
        team-a (assoc team-a active-name active)
        team-b (assoc team-b target-name target)
        display (fn [[n v]] [n (n->percentage (p-dead v))])]
    (cond
      (every? #(dead? (last %) 51/100) team-b) 
      {:team-b (into {} (map display team-b))
       :team-a (into {} (map display team-a))
       :turn turn}
      (> turn 100) nil
      :else
      (recur (inc turn) (concat others [active-name]) team-a team-b))))

(deftest test-combat-iter
    (testing "crash test galditorial battle!"
      (is (= (combat-iter 1
                          [:steve :terrence]
                          {:steve crash-test-dummy}
                          {:terrence crash-test-dummy}

                          )
             {:team-b {:terrence "72.5"}
              :team-a {:steve "26.2"}
              :turn 19}))))

(defn -main
  []
  (combat-iter 1 
               ;[:rocky :derik-the-destroyer] 
               ;[:derik-the-destroyer :rocky] 
               [:derik-the-destroyer :rocky :florence-the-defiler] 
               {:derik-the-destroyer barbarian 
                :florence-the-defiler barbarian}
               {:rocky ettin}))
