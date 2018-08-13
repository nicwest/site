---
title: "Scale Notify-OSD on HDPI monitor"
date: "2015-05-25 10:27:24"
version: 1.0
tags: [ubuntu, linux, laptop]
---

![blurry notifications](/images/notify.png)

One of the rough edges of the linux/ubuntu HDPI experience is that that
notify-osd scales weirdly and you get really bad anti-aliasing on fonts and
images.

A brief google turned up [Bug #1374301 “osd notifications blurry”][bug], in
which Steffen Coenen points out that starting notify-osd with the GDK_SCALE=1
enviromental variable fixes the problem.

I attempted to adjust this in the dbus services file like so:

{{< highlight ini >}}
#/usr/share/dbus-1/services/org.freedesktop.Notifications.service
[D-BUS Service]
Name=org.freedesktop.Notifications
Exec=/usr/lib/x86_64-linux-gnu/notify-osd
Environment=GDK_SCALE=1
{{</ highlight >}}

sadly this didn't work :(

Instead I wrote a bash script and changed the path in the service. pretty hacky
but it works:

{{< highlight bash >}}
#/home/nic/bin/notify-osd
#!/bin/bash
GDK_SCALE=1 /usr/lib/x86_64-linux-gnu/notify-osd
{{</ highlight >}}

{{< highlight ini >}}
#/usr/share/dbus-1/services/org.freedesktop.Notifications.service
[D-BUS Service]
Name=org.freedesktop.Notifications
Exec=/home/nic/bin/notify-osd
{{</ highlight >}}

Seems to be working well, will update if I find issues.


[bug]: https://bugs.launchpad.net/ubuntu/+source/notify-osd/+bug/1374301
