---
title: "Slim files: Vim"
date: "2015-02-13 22:11:47"
version: 0.1
tags: [vim, slimfiles]
---

I have been ssh-ing into servers/vm's recently and been editing things. Installing
[my dotfiles][dotfiles] was a pain. 

This is my attempt at making a set of viable slim config files, aimed
specifically at what I might require when ssh-ing into a remote server.

First post was getting quite long so I'm going to split it up into parts. This
article will be about vim.

[The full files are on github][slimfiles]

# Vim

![Elflord colour scheme][elflord]

I'm a heavy [Vim][vim] user. Specifically console Vim. It's at the hub of my
development environment in the terminal. I have spent many an hour heavily
modifying this program to do more or less exactly what I want it to do. Some of
this time was spent configuring settings, creating keyboard mappings,
researching and trying out third party plugins, and even writing 
[a few of][templatebucket] [plugins of][arrow] [my own][QQ]. 
[My .vimrc][bigvimrc] is monolithically large.

However the use case here is much more temporal with a focus on a quick set up,
minimal side effects, and easy tear down.

I won't go line by line through my configuration as there is a lot of
common/preferential things, but only highlight the things that are interesting.

**Note:** I looked long and hard at my plugin list, and decided that pretty much
all of them I can live without. Specifically the biggest barrier was the cost of
implementing or installing a plugin manager, and no single plugin added enough
value to warrant paying it. If I was to utilise plugins (and I might later), 
my list would probably look something like this: [nerdcommenter][nerdcommenter],
[endwise][endwise], [surround][surround], and [targets][targets].

{{< highlight vim >}}
let g:nicwest_remote = 1
let g:nicwest_os = 'linux'
{{</ highlight >}}

I'm thinking of adding some form of colour coding to both vim and tmux so can
identify what machine I'm on regardless of content/hostname.

Similarly I'm not going to waste time working out what type of system I'm on,
changing this when I need to work on a specific type of machine will be simple.
99% of the time this will be a machine running linux.

{{< highlight vim >}}
set background=dark
colorscheme elflord
hi Pmenu ctermfg=15
hi PmenuSel ctermfg=15
hi Folded ctermbg=8
{{</ highlight >}}

Elflord seems like a colour scheme that I don't hate. I did however have to
fix a couple of highlight groups that had poor legibility with my terminal
colours.

{{< highlight vim >}}
set noundofile
set nobackup 
set noswapfile
{{</ highlight >}}

This one might be slightly questionable. Here is my thought process. If I ever
found my self in a situation where I was able to do catastrophic and
irreversible damage to a system simply by editing a single text file, then I 
think I would recognise this and make sure I had a manual and off server backup.
Second I don't want to litter files all over the system. I was thinking that
there might even be a privacy/security side to this argument, but instead I'm
going to err of the side of tidiness.

{{< highlight vim >}}
nnoremap <c-b> :buffers<CR>
{{</ highlight >}}

[I have included a few personal key bindings in this config][keybindings], but 
this is the only one that might need some explanation. I have decided against
including any file manager plugins (such as [nerdtree][nerdtree], [unite][unite]
or [ctrlp][ctrlp]). I see Vim being used here as method of editing files 
*in situ* which will mean that the majority of the time I see my self passing
the file name(s) as arguments when starting the program. If multiple files have
been opened after vim started, or even with wildcards (`vim ./*`), this is a 
quick short cut to show how to bring up target files.

{{< highlight vim >}}
command! -bang Fuck if "<bang>" == "!" |
      \ execute 'w !sudo tee > /dev/null %' |
      \ echohl WarningMsg |
      \ echo 'PEWPEW! SUDO!' |
      \ echohl None |
      \ endif
{{</ highlight >}}

Finally because I always forget it; here is the command to let you save as root
when you forget to start the program under sudo. `:Fuck` will do nothing,
`:Fuck!` will do the dirty.

# Yup
I have been actively using this config for the last few days for preping some
ansible set ups in vagrant. I'm actually surprised how much of a difference this
makes. Just having the few sanity settings and a few familiar binds makes
editing super comfortable.

One thing I have noticed that I'm missing the commenting functionality I got
from [nerdcommenter][nerdcommenter]. It's not really big enough to install the
plugin, but I might take a look at implementing something light and similar
later.

[dotfiles]: http://github.com/nicwest/.dotfiles
[slimfiles]: http://github.com/nicwest/slimfiles
[vim]: http://vim.org
[templatebucket]: https://github.com/nicwest/template-bucket
[arrow]: https://github.com/nicwest/vim-arrow
[QQ]: https://github.com/nicwest/QQ.vim
[nerdcommenter]: https://github.com/scrooloose/nerdcommenter
[endwise]: https://github.com/tpope/vim-endwise
[surround]: https://github.com/tpope/vim-surround
[targets]: https://github.com/wellle/targets.vim
[keybindings]: https://github.com/nicwest/slimfiles/blob/master/.vimrc#L57-L79
[nerdtree]: https://github.com/scrooloose/nerdtree
[unite]: https://github.com/Shougo/unite.vim
[ctrlp]: https://github.com/ctrlpvim/ctrlp.vim
[bigvimrc]: https://github.com/nicwest/.dotfiles/blob/master/vim/.vimrc

[elflord]: /images/elflord.png "Elflord colorscheme"
