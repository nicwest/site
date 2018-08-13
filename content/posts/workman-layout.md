---
title: "Workman layout"
date: "2015-03-08 22:18:55"
version: 0.1
tags: [keyboard, workman, vim, bash, arch]
---

![workman](/images/workman.png)

[The workman layout][workman] is the first non qwerty layout I have tried to
learn. It's taken me an inordinate amount of time to get used to it, but I'm
finally getting to point where I'm considering swapping to it cold turkey.

Here are a couple of things to help out if you are thinking of switching

Vim
---

Vim has an awesome method called `langmap` that allows you to use an alternative
set of keys and map them back to their qwerty equivalents in normal mode. This
saves you the pain of actually mapping all the keys yourself.

This is a basic qwerty to workman langmap:

{{< highlight vim >}}
set langmap=qq,dw,re,wr,bt,jy,fu,ui,po,\\;p,aa,ss,hd,tf,gg,yh,nj,ek,ol,i\\;,zz,xx,mc,cv,vb,kn,lm,QQ,DW,RE,WR,BT,JY,FU,UI,PO,:P,AA,SS,HD,TF,GG,YH,NJ,EK,OL,I:,ZZ,XX,MC,CV,VB,KN,LM
{{</ highlight >}}

I also tried moving the home row one key to the right and putting colon on the
`h` key (but I just couldn't get my head around it):

{{< highlight vim >}}
set langmap=qq,dw,re,wr,bt,jy,fu,ui,po,\\;p,aa,ss,hd,tf,gg,y\\;,nh,ej,ok,il,zz,xx,mc,cv,vb,kn,lm,QQ,DW,RE,WR,BT,JY,FU,UI,PO,:P,AA,SS,HD,TF,GG,Y:,NH,EJ,OK,IL,ZZ,XX,MC,CV,VB,KN,LM
{{</ highlight >}}

langmap is magic it sorts out your keybindings and operators, however it doesn't
do function keys. I'm working on adding some other peripheral stuff as vim 
plugin in this repo [nicwest/vim-workman][vim-workman]

Arch
----

[The workman repo is in the AUR][workman-aur] and can be installed via
[yaourt][yaourt] (or similar):

{{< highlight bash >}}
$ sudo yaourt -S workman-git
{{</ highlight >}}

If like me you use a keyboard layout other than US standard you may want to go
edit the workman layout config and change the included layout to your
preference:

{{< highlight bash >}}
// /usr/share/X11/xkb/symbols/workman
include "gb(basic)"
{{</ highlight >}}


Bash/Zsh
--------

Also it seems that I'm unable to do anything without adding aliases to my zsh, I
wouldn't really bother putting this up apart from I'm strangely proud of
`qdrwbj` which of course is `qwerty` in workman.

{{< highlight bash >}}
alias workman="setxkbmap -v workman && xset r 66"
alias qwerty="setxkbmap gb && xset -r 66"
alias qdrwbj="setxkbmap gb && xset -r 66"
{{</ highlight >}}

Practice
--------

If you want to practise then I would suggest you try out [keybr.com][keybr]. It
has a clever (but infuriating) method of incremental learning where it won't let
you use more letters utill you have masted the current set. Here are my stats.
You are now all witness to the hours of my life that I'm never going to get
back...

![bad at keyboards](/images/keybr.png)


[workman]: http://www.workmanlayout.com/blog/
[vim-workman]: https://github.com/nicwest/vim-workman
[workman-aur]: https://aur.archlinux.org/packages/workman-git/
[yaourt]: https://github.com/archlinuxfr/yaourt
[keybr]: http://keybr.com

