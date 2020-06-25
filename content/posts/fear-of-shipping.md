---
title: "A Fear of Shipping"
date: "2020-06-16"
tags: [dev, practice]
draft: true
---

It's 5 o'clock on a Friday evening. You have just made a minor change to your
employers application. You know the change is highly unlikely to break
anything, you've tested it pretty thoroughly and it appears to be working as
advertised. You move your mouse over the "deploy to production" button. And
you pause. Maybe this is not a great idea. Maybe this seeming innocent change
will break everything. No one will be here to spot that it's broken let alone
fix it! Pressing this button could cost your organisation 100's of money
units, or worse you might need to come to work a Saturday! Perhaps it's better
to leave it until everyone is back in the office and paying attention. Waiting
until Monday won't be the end of the world. You move your mouse away from the
button. A while later you pack up your stuff and go home for the weekend.

This is the fear of shipping.

* you ship things
* there is a non 0% chance that that thing will break
* there is a non 0% chance that that thing will break catastrophically
* the more things you ship, the more likely it is that you will see something
  break.
* eventually you will be responsible for something really bad happening

These painful memories build up like scar tissue. Each one adding another
layer to your paranoia related to deploying code. 

This paranoia only compounds when you get more that one person together. 





------------------------------------------------------------------------------


Oh I'm not going to ship that until Monday in case it breaks over the weekend.

Those features will need to wait for this other feature so we can ship this
all with minimal disruption

No shipping code after 4pm

As a developer I feel like these phrases come up a lot. I find my self saying
them regularly. Do anything to avoid shipping this code right now. 

It's because as I have built and shipped more things over my career,
intevitably some of those features/deployments/etc have gone badly, this is
embarassing, and frustrating, and in some circumstances might cost the
business money or repuation. 

Less experience == less scars == freeer to power through stuff
More experience == more scars == far less likely to be shipping stuff as
quickly

Not all of these things are game ending 100million pound bugs or GDPR incuring
security breaches. Some times it  might just be feature bouncing back a
handful of times from QA, or query that takes a second or two longer than it
ought to because you forgot to add and index to your database. 

Some times the most seemingly inconquis thing you
write blows up in your face. I work in the world of web development where the
operational risk of the occastional bad deployment or misfiring feature isn't
the end of the world. And honestly if you aren't experiencing the occasational
fuck up then you are probably not doing it right in the first place.

You were responsible for something getting done ,and for whatever reason, it
fucked up.

Those fuck ups addup over time like scar tissue. each one adding a bit more
paranoia to your approach to shipping code. You write unit tests, and
integration tests, and static analysis, and do code review, and hire
dedicated QA's, and fire up canary deploys, and have rappid role back
enviroments and hot secondary envirnments, and all manner of other safety nets
to ensure that nothing terrible leaves the building and/or when it does it is
easy to get back in to stable state. 

Bad things still happen though, and as you ship more things the likelyhood of
something breaking badly only increases.

You work with other developer who share horror stories and scar tissue, and
that all resonates off each other to make the whole situation worse. 

Then some idiot lets you make decisions about how a group of software
developers writes stuff and you build that paranoia institutionally into the
group process. That compounds the issue further.

Allowing unshipped changes to hang about for any longer than they need to only
increases the chances of scope creep. This is time wasted.

Suddenly you get to a place where do reduce number of breakages because you
have reduced the amount of output of working stuff.

We work in a world where expect 99.9999% up time from each other and you read
blogs and postmortems about how someone somewhere left a line of code
commented out and shut a bank down.

I probably don't have any answers to this problem. I'm just barely beginning
to be able to recognise it in my own work. The only advice I can offer is what
I tell myself when I find myself clutching my purse over when to deploy
something...

Just ship it. 

Chances are that your saftey nets would have caught most of the serious
issues, and if it didn't you can rollback to previous working version, or
submit a hotfix, or mitigate the issue in a 1000 different ways. There is
noway to stop the really bad, really big, really game breaking bug with your
name on it coming for you. It's a matter of when not if. What you can control
is the number of good features you get out the door before that happens.

