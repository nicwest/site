---
title: "Deadly, yes! But how deadly?"
date: "2020-04-26"
tags: [dnd, clojure]
draft: true
vega: true
js: ["deadly.js"]
---


I have been playing a lot of Dungeons and Dragons recently and one of the
groups I'm playing with is made up of experienced dungeon masters (DM). Rather
than having a campaign in the traditional sense we have been doing a series of
stand alone adventures (one-shots) where the DM and some of the characters
rotate with each instalment. I ran the game last time out and asked the
previous DM how difficult he made the combat encounters.

**"Deadly" he replied.**

### 
So the following is quick overview of encounter difficulty in D&D. If you are
already familiar with how this works you might want to skip to the next
section.

5th edition Dungeons and Dragons has a system for a dungeon master to
calibrate the difficult of an encounter. Each monster has a challenge
rating (CR). The [Dungeon Masters
Guide](https://dnd.wizards.com/products/tabletop-games/rpg-products/dungeon-masters-guide)
(DMG) defines a complex system of determining a challenge rating for a
monster, but at a high level it's an average of the monsters offensive and
defensive capabilities.

For example a Dire Wolf (Basic Rules p.123) is a monster with a CR of 1

![Dire Wolf stat block](/images/direwolf.png)

Whereas a Troll (Basic Rules p.156) is a more significant threat with a CR of
5!

![Troll stat block](/images/troll.png)

Defeating each monster provides a certain amount of experience points (XP)
corresponding to it's challenge rating, in the examples above the dire wolf
gives 200XP where as the troll gives 1800XP! The DMG has the full table of CR
to XP values if you are interested.

So how much XP equals a deadly encounter? The basic rules describe 4
categories of encounter difficulty:

> **Easy.** An easy encounter doesn't tax the characters' resources or put
> them in serious peril. They might lose a few hit points, but victory is
> pretty much guaranteed.

> **Medium.** A medium encounter usually has one or two scary moments for the
> players, but the characters should emerge victorious with no casualties. One
> or more of them might need to use healing resources.

> **Hard.** A hard encounter could go badly for the adventurers.  Weaker
> characters might get taken out of the fight, and there's a slim chance that
> one or more characters might die.

> **Deadly.** A deadly encounter could be lethal for one or more player
> characters. Survival often requires good tactics and quick thinking, and the
> party risks defeat.

Now as a level 1 character with ~10 hit points (HP), no armour, and armed only
with a simple sword, an encounter with a troll might well end up being deadly.
Whereas a level 20 character with 100+HP, wearing enchanted armour and a
wielding a +3 magic sword might accidentally kill the troll when sneezing.

The basic rules defines these categories in relationship to a characters level
and the XP available for dispatching a monster like so:

| Character Level | Easy | Medium | Hard  | Deadly   |
|-----------------|------|--------|-------|----------|
| 1st             | 25   | 50     | 75    | 100      |
| 2nd             | 50   | 100    | 150   | 200      |
| 3rd             | 75   | 150    | 225   | 400      |
| 4th             | 125  | 250    | 375   | 500      |
| 5th             | 250  | 500    | 750   | 1,100    |
| 6th             | 300  | 600    | 900   | 1,400    |
| 7th             | 350  | 750    | 1,100 | 1,700    |
| 8th             | 450  | 900    | 1,400 | 2,100    |
| 9th             | 550  | 1,100  | 1,600 | 2,400    |
| 10th            | 600  | 1,200  | 1,900 | 2,800    |
| 11th            | 800  | 1,600  | 2,400 | 3,600    |
| 12th            | 1,000| 2,000  | 3,000 | 4,500    |
| 13th            | 1,100| 2,200  | 3,400 | 5,100    |
| 14th            | 1,250| 2,500  | 3,800 | 5,700    |
| 15th            | 1,400| 2,800  | 4,300 | 6,400    |
| 16th            | 1,600| 3,200  | 4,800 | 7,200    |
| 17th            | 2,000| 3,900  | 5,900 | 8,800    |
| 18th            | 2,100| 4,200  | 6,300 | 9,500    |
| 19th            | 2,400| 4,900  | 7,300 | 10,900   |
| 20th            | 2,800| 5,700  | 8,500 | 12,700   |

It's very unlikely that your adventure will involve consistent 1 vs 1
encounters and 5 players working together are probably going to have a better
time fighting our troll than than they would alone. You calculate this simply
by adding together the XP thresholds of each player, this is the party XP
threshold. For example a party of 3 level 5 players and 2 level 4 players will
have a deadly threshold of (1100 + 1100 + 1100 + 500 + 500) = 4300 and should
be able to face down roughly a CR 8 (3900XP) creature without much issue, a
CR 9 (5000XP) creature however starts to get pretty dangerous. 

The other side of the coin is that there might be more than one monster and
that too modifies the difficulty but this time in the monsters favour. This is
represented by a multiplier based on how many monsters are present in the
encounter

Number of Monsters | Multiplier
------------------ | ----------
1                  | x1
2                  | x1.5
3-6                | x2
7-10               | x2.5
11-14              | x3
15                 | x4




<div class="graph" id="graph-1"></div>
