---
title: "Dell XPS 13 2015 developer edition, Ubuntu 14.04"
date: "2015-05-01 23:08:31"
version: 1.0
tags: [linux, laptop]
---

[![ubuntu][screenshot]][screenshot]

I recently purchased the [Dell XPS 13 2015 developer edition][dell], currently
it's day two and I'm thoroughly enjoying using this machine.

It doesn't quite work out of the box, and there are couple of little things you
have to do to get it working sensibly. Also there are a couple of rough edges
like coming back after suspension and low dpi external displays that I still
need to fix, but it's 95% there.

Bios
----
The laptop bios has been updated several times since first release, as of
writing this the most current release is [A03][A03]. This came pre-installed on
my machine so there was no need to install windows to update the bios (thank
fuck!). To check the  bios version reboot the machine and hold the F12 button at
the screen with the Dell logo. 

Kernel
------
The first thing I noticed was that the touchpad was jerky and unresponsive. This
fixed it's self when I updated the kernel. [I went with 3.19.6, the most recent
non 4.0 kernel in the ubuntu mainline][kernel]. You can make your own decisions
here.

{{< highlight bash >}}
wget "http://kernel.ubuntu.com/~kernel-ppa/mainline/v3.19.6-vivid/linux-headers-3.19.6-031906-generic_3.19.6-031906.201504290535_amd64.deb"
wget "http://kernel.ubuntu.com/~kernel-ppa/mainline/v3.19.6-vivid/linux-headers-3.19.6-031906_3.19.6-031906.201504290535_all.deb"
wget "http://kernel.ubuntu.com/~kernel-ppa/mainline/v3.19.6-vivid/linux-image-3.19.6-031906-generic_3.19.6-031906.201504290535_amd64.deb"
dkpg -i linux-headers-3.19.6-*.deb linux-image-3.19.6.*.deb
{{</ highlight >}}

Touchpad
--------

After updating the kernel I saw a marked improvement in the touchpad. It no
longer seemed broken, just misconfigured. I used [Alessio Treglia trackpad
config][config] from the xps13 support repo. This lives in 
`/etc/X11/xorg.conf.d`, don't worry if the directory doesn't exist just
`sudo mkdir /etc/X11/xorg.conf.d`. After installing this restart the X server in
your preferred method (logout, kill the process, reboot, etc) and the touch pad
should work nicely.

Virtualization
--------------

Being able to quickly spin up VMs is important to my workflow. Grab the latest
version of virtualbox as it has support for your newly upgraded kernel:

{{< highlight bash >}}
sudo sh -c 'echo "deb http://download.virtualbox.org/virtualbox/debian trusty contrib" >> /etc/apt/sources.list'
wget http://download.virtualbox.org/virtualbox/debian/oracle_vbox.asc -O- | sudo apt-key add -
sudo apt-get update
sudo apt-get install virtualbox-4.3
{{</ highlight >}}

The host machine (laptop) kept crashing about 5 seconds after starting a new VM.
This seems to be a [known][bug1] [bug][bug2] and the fix has been merged into
the most recent versions of virtualbox. The only thing you need to do adjust
your kernel boot parameters and add `nosmap` and `nosmep` and everything should
work fine. The place to do this is in `/etc/default/grub` and the setting should
be something like this: 

{{< highlight bash >}}
GRUB_CMDLINE_LINUX_DEFAULT="quiet splash nosmap nosmep"
{{</ highlight >}}

afterwards you want to update the grub config with `update-grub`


[dell]: http://www.dell.com/uk/business/p/xps-13-linux/pd
[A03]: http://www.dell.com/support/home/uk/en/ukbsdt1/Drivers/DriversDetails?driverId=XY677
[kernel]: http://kernel.ubuntu.com/~kernel-ppa/mainline/v3.19.6-vivid/
[config]: https://github.com/mpalourdio/xps13/blob/master/config9/50-synaptics.conf
[bug1]: https://www.virtualbox.org/ticket/13820
[bug2]: https://www.virtualbox.org/ticket/13961
[screenshot]: /images/ubuntu.jpg

