---
title: "eight years of vim plugins"
date: "2020-04-26"
tags: [vim]
---

I've kept my vimrc more or less under version control for most of the last 8
years, so I thought it might be a fun adventure to look at my plugin use from
vim noob -> long in the tooth veteran.

I've marked anything that has survived to my current vimc with a :star:

Trigger warning: if you are vim plugin or vimrc minimalist this post may not
be for you.

## March 2014

https://github.com/nicwest/.dotfiles/blob/91fc2dbed4a84a3b110571c6837435222753f936/vim/.vimrc

So it's march 2014. [Pawel](https://github.com/qazwsxpawel) has just
introduced me to vim, bootstrapped my vimrc, and got my stuff under version
control. (Thanks Pawel!).

plugins:

```viml
Bundle 'FuzzyFinder'
Bundle 'L9'
Bundle 'Lokaltog/vim-easymotion'
Bundle 'airblade/vim-gitgutter'
Bundle 'bling/vim-airline'
Bundle 'edkolev/tmuxline.vim'
Bundle 'git://git.wincent.com/command-t.git'
Bundle 'gmarik/vundle'
Bundle 'jpythonfold.vim'
Bundle 'kien/ctrlp.vim'
Bundle 'mhinz/vim-signify'
" Bundle 'nvie/vim-flake8'
Bundle 'python.vim'
Bundle 'rstacruz/sparkup', {'rtp': 'vim/'}
Bundle 'scrooloose/syntastic'
Bundle 'tomasr/molokai'
Bundle 'tpope/vim-fugitive'
Bundle 'tpope/vim-rails.git'
Bundle 'tpope/vim-surround'
```
so brief round up of what we have here

### Aesthetic stuff

* [airline](https://github.com/vim-airline/vim-airline)
* [tmuxline](https://github.com/edkolev/tmuxline.vim)
* [molokai](https://github.com/tomasr/molokai)

Fairly standard "I am new to vim" bling here. I don't remember what molokai
looked like and sadly the images are gone. I was getting used to using tmux as
well.

### Project exploration

* [ctrl-p](https://github.com/kien/ctrlp.vim)
* [FuzzyFinder](https://www.vim.org/scripts/script.php?script_id=1984)
* [command-t](https://github.com/wincent/command-t)

Fuzzy Find for all the things. Fairly certain there is a fair amount of cross
over with these three, I was clearly searching for some kind of functionality
and not really finding it in it's entirety from just one of these plugins.

### Language utilities

* [jpythonfold.vim](https://www.vim.org/scripts/script.php?script_id=2527)
* [python.vim](https://www.vim.org/scripts/script.php?script_id=790)
* [vim-flake8](https://github.com/nvie/vim-flake8)
* [vim-rails](https://github.com/tpope/vim-rails)
* [syntastic](https://github.com/vim-syntastic/syntastic)
* [sparkup](https://github.com/rstacruz/sparkup)

I was predominantly working in python at this point. I think python.vim adds
syntax highlighting. vim-flake8 is commented out because I was probably
getting what I needed from syntastic.

Sparkup looks like a cool way to expand css paths into HTML. I was doing a lot
of django template work around this time so this one makes sense.

I have no idea what vim-rails is doing there, I don't think I've ever worked
in ruby/rails... 

### Git utilities 

* [vim-gitgutter](https://github.com/airblade/vim-gitgutter)
* [vim-signify](https://github.com/mhinz/vim-signify)
* [vim-fugitive](https://github.com/tpope/vim-fugitive)

It's probably fair to say that git was still a bit of a mystery to me in 2014.
I'm fairly certain that gitgutter and signify do the same thing. Fugitive is
of course a Tim Pope classic and needs no explaining.

### General utilities

* [L9](https://www.vim.org/scripts/script.php?script_id=3252)
* [vim-easymotion](https://github.com/easymotion/vim-easymotion)
* [vundle](https://github.com/VundleVim/Vundle.vim)
* [vim-surround](https://github.com/tpope/vim-surround) :star:

Easy motion looks like a cool navigating up and down plugin. I still had mouse
binds in my vimrc at this time so I probably wasn't super comfortable with
keyboard navigation yet.

Special mention for Tim Pope's surround here, as it's the only plugin in this
list to have survived to this day. It's so intuitive and so idiomatic that I
would argue that it should be the default behavior of the `s` key.

## April 2014

https://github.com/nicwest/.dotfiles/blob/173fc9ab58690648a7f408cb1ec4152f4c75e209/vim/.vimrc

In April 2014 I've cut the apron strings and I'm starting to head out on my
own vim adventure.

```
Bundle 'FuzzyFinder'
Bundle 'L9'
Bundle 'Raimondi/delimitMate'
Bundle 'airblade/vim-gitgutter'
Bundle 'edkolev/tmuxline.vim'
Bundle 'ervandew/supertab'
Bundle 'gitignore'
Bundle 'gmarik/vundle'
Bundle 'itchyny/lightline.vim'
Bundle 'jaxbot/github-issues.vim'
Bundle 'jpythonfold.vim'
Bundle 'junegunn/goyo.vim'
Bundle 'kien/ctrlp.vim'
Bundle 'mattn/emmet-vim'
Bundle 'rstacruz/sparkup', {'rtp': 'vim/'}
Bundle 'scratch.vim'
Bundle 'scrooloose/nerdcommenter'
Bundle 'scrooloose/nerdtree'
Bundle 'scrooloose/syntastic'
Bundle 'tacahiroy/ctrlp-funky'
Bundle 'terryma/vim-expand-region'
Bundle 'tpope/vim-eunuch'
Bundle 'tpope/vim-fugitive'
Bundle 'tpope/vim-repeat'
Bundle 'tpope/vim-surround'
Bundle 'w0ng/vim-hybrid'
```

### Aesthetic stuff
* [vim-hybrid](https://github.com/w0ng/vim-hybrid) :star:
* [lightline.vim](https://github.com/itchyny/lightline.vim)
* [goyo.vim](https://github.com/junegunn/goyo.vim)

Hybrid is the vim colorscheme I use to this day. I'm actually surprised how
early this entered my world, I thought it came a lot later.

Goyo adds a "focus" mode to vim and tries to cut out visual distractions. This
probably a good indication that my environment had a few too many bells and
whistles going on.


Lightline replaces airline

### Project exploration

* [ctrlp-funky](https://github.com/tacahiroy/ctrlp-funky)
* [nerdtree](https://github.com/preservim/nerdtree)

I'm still trying to figure out fuzzy searching, command-t dies and a mod for
ctrl-p is added to be able to search functions.

Nerd tree adds a "here are all of your files" side bar to vim. I was probably
missing the same behaviour from sublime text or pycharm.

### Language Utilities

* [emmet-vim](https://github.com/mattn/emmet-vim)

More HTML tools. python.vim and vim-flake8 and the rails plugin clearly didn't
survive long.

### Git utilities 

[github-issues.vim](https://github.com/jaxbot/github-issues.vim)
[gitignore](https://www.vim.org/scripts/script.php?script_id=2557)

At this time I'm at my first job where I've been able to work a)
professionally with git and b) with other developers using github.

### Tab completion

* [supertab](https://github.com/ervandew/supertab)

The start of a long running struggle to find some kind of tab completion that
I liked.

### General utilities

* [delimitMate](https://github.com/Raimondi/delimitMate) :star:
* [scratch.vim](https://www.vim.org/scripts/script.php?script_id=664)
* [vim-expand-region](https://github.com/terryma/vim-expand-region)
* [nerdcommenter](https://github.com/preservim/nerdcommenter) :star:
* [vim-eunuch](https://github.com/tpope/vim-eunuch)
* [vim-repeat](https://github.com/tpope/vim-repeat) :star:

DelimitMate automatically adds closing quotes, brackets, etc. simple, clever,
language agnostic, and is another plugin that has never left my vimrc.

NerdCommenter adds keybinds for commenting things in and out. It's language agnostic
and does pretty much exactly what it says on the tin. This is another plugin
that has never left my vimrc and I would argue is good enough to be included
in vim as default behaviour.

Repeat (another tpope classic) overloads the `.` keybind to allow allow
repeating of custom actions defined by plugins. This is another mainstay of my
vimrc to this day. 

## June 2014

Summer 2014 is when clojure entered my life. I don't exactly remember where
this came from, but I have sneaky suspicion that it was because Tim Pope was
into it.

```
Bundle 'gmarik/Vundle.vim'
Bundle 'FuzzyFinder'
Bundle 'L9'
Bundle 'gitignore'
Bundle 'Raimondi/delimitMate'
Bundle 'SirVer/ultisnips'
Bundle 'Valloric/YouCompleteMe'
Bundle 'airblade/vim-gitgutter'
Bundle 'christoomey/vim-tmux-navigator'
Bundle 'guns/vim-clojure-static'
Bundle 'honza/vim-snippets'
Bundle 'itchyny/lightline.vim'
Bundle 'jpythonfold.vim'
Bundle 'kien/ctrlp.vim'
Bundle 'kien/rainbow_parentheses.vim'
Bundle 'lord-garbage/tslime.vim'
Bundle 'rking/ag.vim'
Bundle 'scratch.vim'
Bundle 'scrooloose/nerdcommenter'
Bundle 'scrooloose/nerdtree'
Bundle 'scrooloose/syntastic'
Bundle 'tpope/vim-fireplace'
Bundle 'tpope/vim-fugitive'
Bundle 'tpope/vim-repeat'
Bundle 'tpope/vim-surround'
Bundle 'w0ng/vim-hybrid'
Bundle 'wellle/targets.vim'
```

### Aesthetic stuff

* [rainbow_parentheses.vim](https://github.com/kien/rainbow_parentheses.vim)

With a lisp in my life I was suddenly overwhelmed by the number brackets I was
having to deal with.

Light line looks to have finally won the status line war.

### Project exploration

* [ag.vim](https://github.com/rking/ag.vim)

Still trying to figure out how to get around a project sensibly. ag is yet
another fuzzy project search plugin.

### Snippets

* [ultisnips](https://github.com/SirVer/ultisnips)
* [vim-snippets](https://github.com/honza/vim-snippets)

Start of a (brief) adventure into snippets.

### Language Utilities

* [tslime.vim](https://github.com/lord-garbage/tslime.vim)
* [vim-clojure-static](https://github.com/guns/vim-clojure-static)
* [vim-fireplace](https://github.com/tpope/vim-fireplace)

Tslime is a poor man's [slime](https://en.wikipedia.org/wiki/SLIME) (a classic
emacs plugin and bread and butter in a traditional lisp enviroment). tslime
tries to do the same thing for vim using a tmux split.

vim-clojure-static was merged into vim in 7.3.803 and provides things like
syntax highlighting.

vim-fireplace is Tim Pope's answer to the slime problem above. Rather than
attempting to emulate emacs, it sort of does it's own thing in an ideomatic
vim way. For me this won out and was my main interface for the rest of my
clojuring, but I believe that tim moved to emacs in evil mode as the clojure
tooling at the time was just a lot better.

### Tab completion

* [YouCompleteMe](https://github.com/Valloric/YouCompleteMe)

YCM is a big unwieldy program with a vim interface and sort of adds a
predictive super power to your text editor. YCM would cycle in and out of my
vimrc for a number of years.

### General utilities

* [vim-tmux-navigator](https://github.com/christoomey/vim-tmux-navigator)
* [targets.vim](https://github.com/wellle/targets.vim) :star:
* [vim-plug](https://github.com/junegunn/vim-plug) :star:

vim-tmux-navigator is probably one of the cleverest vim plugins ever written.
it seamlessly allows you to use the same keybinds to navigate splits in both
vim and tmux and alleviates a massive headache in that particular set up.

Targets fills in the (arguably I guess) missing text objects in vim. This
plugin has survived to this day and has become such a staple part of how I
use vim that I really struggle on an environment without it. 

I also moved from vundle to vim-plug

## April 2015

ohttps://github.com/nicwest/.dotfiles/blob/866a713d3496e1c7bf4347e8801f1dc685366e17/vim/.vimrc

Fast forward most of a year to April 2015. I've discovered that writing vim
plugins is fun. Clojure is still a thing I'm into

https://github.com/nicwest/.dotfiles/blob/866a713d3496e1c7bf4347e8801f1dc685366e17/vim/.vimrc


```
Plug 'FuzzyFinder'
Plug 'L9'
Plug 'Raimondi/delimitMate'
Plug 'airblade/vim-gitgutter'
Plug 'chase/vim-ansible-yaml'
Plug 'christoomey/vim-tmux-navigator'
Plug 'guns/vim-clojure-static'
Plug 'haya14busa/incsearch.vim'
Plug 'jpythonfold.vim'
Plug 'junegunn/goyo.vim'
Plug 'luochen1990/rainbow'
Plug 'edkolev/tmuxline.vim'
Plug 'nicwest/tslime.vim'
Plug 'nicwest/vim-arrow'
Plug 'nicwest/vim-workman'
"Plug 'nicwest/vim-filebeagle', {'branch': 'gitignore'}
Plug 'nicwest/vim-after-syntax-vim'
Plug 'nicwest/QQ.vim', {'branch': 'feat-body'}
Plug 'nicwest/template-bucket'
Plug 'nicwest/vim-flake8'
Plug 'rking/ag.vim'
Plug 'scrooloose/nerdcommenter'
Plug 'chriskempson/base16-vim'
Plug 'jeetsukumaran/vim-filebeagle'
Plug 'scrooloose/syntastic'
Plug 'tpope/vim-endwise'
Plug 'tpope/vim-fireplace'
Plug 'tpope/vim-fugitive'
Plug 'tpope/vim-repeat'
Plug 'tpope/vim-surround'
Plug 'tpope/vim-scriptease'
Plug 'tpope/vim-projectionist'
Plug 'wellle/targets.vim'
```

### Aesthetic stuff

* [base16-vim](chriskempson/base16-vim')
* [rainbow](https://github.com/luochen1990/rainbow) :star:

I clearly had minor deviation into other color schemes, but ultimately
ended up returning to hybrid.

Notably light line dropped, but tmux line is back?

I also swapped to a lighter weight parenthesis highlighting plugin. If I
remember rightly this was due to performance issues. I still use this today
and it's useful way beyond just lisp based languages.

### Project exploration

* [vim-filebeagle](https://github.com/jeetsukumaran/vim-filebeagle) :star:
* [vim-projectionist](https://github.com/tpope/vim-projectionist)

I either read Drew Neil's [*Oil and vinegar - split windows and the project
drawer*](http://vimcasts.org/blog/2013/01/oil-and-vinegar-split-windows-and-project-drawer/)
or saw him talk about it at [vim london](https://www.meetup.com/Vim-London),
(possibly both). Any I was convinced (still am), threw away my nerdtree and
went, and went and found nice looking project drawer. I made a few quality of
life changes that the author was kind enough to merge, and it's been my
primary navigation tool ever since.

Projectionist is another tim pope classic that allows you to quickly swap to
common files or between tightly coupled files. Genuinely awesome but also
super dependant on your co-workers to either use the same plugin or follow you
project structure (or be OK with you constantly reorganising things)

### Me things

* [vim-arrow](http://github.com/nicwest/vim-arrow)
* [vim-workman](http://github.com/nicwest/vim-workman)
* [QQ.vim](http://github.com/nicwest/QQ.vim)
* [template-bucket](http://github.com/nicwest/template-bucket)

I'm not going to dive too deeply into these, most were itch scratching none of
of them survived that long.

QQ.vim is worth mentioning solely on the basis of how useless it is. It was an
attempt to do postman but in vim. I wrote it (somewhat drunkenly) over
Christmas that year, posted it to reddit and never really looked at it again.
I believe that people find it when looking for the chinese search engine and
think it must be related? Anyway I learnt a lot of vim script and was the
first real thing I'd open sourced that people had looked at in any significant
numbers.

### Language Utilities

* [vim-after-syntax-vim](https://github.com/trapd00r/vim-after-syntax-vim)
* [vim-endwise](https://github.com/tpope/vim-endwise)
* [vim-scriptease](https://github.com/tpope/vim-scriptease)

Some vim plugin writing flavoured addons joined the mix.

### General Utilities

* [incsearch.vim](https://github.com/haya14busa/incsearch.vim) :star:

Incrementally highlights ALL pattern matches unlike default 'incsearch'. Fun
fact this one is still in my vimrc [but the functionality was merged into vim
in Patch
8.0.1238](https://medium.com/@haya14busa/incsearch-vim-is-dead-long-live-incsearch-2b7070d55250)
(5 years ago!). I'm including it in my list of "still in my vimrc" purely on
the basis of a) still being in my vimrc and b) being so useful!

### August 2016

https://github.com/nicwest/.dotfiles/blob/9733f57f449ed53a4066531c4ee64934b81917c4/vim/.vimrc

Jump forward again, this time I've got a new job. I'm still writing a lot of
python, but I'm also writing C, Obj-C and Golang professional, and Clojure and
Vimscript in my spare time.

```
Plug 'FuzzyFinder'
Plug 'L9'
Plug 'Raimondi/delimitMate'
Plug 'chase/vim-ansible-yaml'
Plug 'christoomey/vim-tmux-navigator'
Plug 'fatih/vim-go'
Plug 'haya14busa/incsearch.vim'
Plug 'honza/vim-snippets'
Plug 'jpythonfold.vim'
Plug 'luochen1990/rainbow'
Plug 'nicwest/tslime.vim'
Plug 'majutsushi/tagbar'
"Plug 'nicwest/vim-arrow'
Plug '/home/nic/sideprojects/vim-workman'
Plug '/home/nic/sideprojects/vim-requester'
Plug 'nicwest/vim-after-syntax-vim'
Plug 'nicwest/QQ.vim'
Plug 'nicwest/cocoa.vim', {'branch': 'syntax-only'}
Plug 'nicwest/vim-bnext'
Plug 'git@github.com:nicwest/template-bucket.git'
Plug 'nicwest/vim-flake8'
Plug 'rking/ag.vim'
Plug 'scrooloose/nerdcommenter'
Plug 'SirVer/ultisnips'
Plug 'w0ng/vim-hybrid'
Plug 'jeetsukumaran/vim-filebeagle'
Plug 'scrooloose/syntastic'
Plug 'tommcdo/vim-fubitive'
Plug 'tpope/vim-endwise'
Plug 'tpope/vim-fireplace'
Plug 'tpope/vim-fugitive'
Plug 'tpope/vim-repeat'
Plug 'tpope/vim-surround'
Plug 'tpope/vim-scriptease'
Plug 'tpope/vim-projectionist'
Plug 'wellle/targets.vim'
Plug 'Valloric/YouCompleteMe'
Plug 'vim-jp/vital.vim'
Plug '/home/nic/sideprojects/vim-git-appraise'
```
### Language Utilities

* [vim-go](https://github.com/fatih/vim-go)
* [tagbar](https://github.com/majutsushi/tagbar)
* [cocoa.vim](https://github.com/msanders/cocoa.vim)
* [vital](https://github.com/vim-jp/vital.vim)
* [vim-ansible-yaml](https://github.com/chase/vim-ansible-yaml)

Go was probably the first language that I worked in (other than C I guess),
that really had first rate vim tooling. It's an opinionated language and
vim-go does a bunch of the heavy lifting it making that a good thing not a
bad thing.

Tagbar and Cocoa were related to the C/Obj-C work I was doing

Vital is an awesomely plugable vim standard library. Seriously it's worth
going and having a look at what those guys at vim-jp have put together. If I
were still writing a lot of vim plugins this would still be in my vimrc.

### me stuff
* [vim-bnext](https://github.com/nicwest/vim-bnext)
* [vim-git-appraise](https://github.com/nicwest/vim-git-appraise)
* vim-requester

More shitty me stuff that I started and didn't finish.

I don't have any recollection of what exactly vim-requester was but I would
like to believe it was a precursor to rewriting QQ.vim.

## October 2016 

https://github.com/nicwest/dotstow/blob/fe122807f35e04066e1e7659bb83e0ae9ab4ef71/vim/.vimrc

I finally got round to having a bit of vimrc spring cleaning in 2016 and
ditched a lot of the crap I'd picked up over the years. Additionally I moved to
using stow for dotfile management and change repositories. From this point
onwards maintaining a sensible linear time line becomes a bit more complicated
as I multiple machines I was working on, with different configuration in
different branches.

```
Plug 'Raimondi/delimitMate'
Plug 'SirVer/ultisnips'
Plug 'fatih/vim-go'
Plug 'guns/vim-slamhound'
Plug 'haya14busa/incsearch.vim'
Plug 'jeetsukumaran/vim-filebeagle'
Plug 'jpythonfold.vim'
Plug 'luochen1990/rainbow'
Plug 'nicwest/template-bucket'
Plug 'scrooloose/nerdcommenter'
Plug 'scrooloose/syntastic'
Plug 'tpope/vim-fireplace'
Plug 'tpope/vim-projectionist'
Plug 'tpope/vim-surround'
Plug 'wellle/targets.vim'
Plug '/home/nic/sideprojects/vim-http'
```

### Language Utilities

* [vim-slamhound](https://github.com/guns/vim-slamhound)

Slamhoud is a clojure tool for avoiding doing actual work your self. I liked
it a lot at the time, but it looks like it's no longer active :(

### Project exploration

Worth noting that all the fuzzy matching stuff is gone by this point. I  came
to conclusion that fuzzy searching codebases was a large code base anti
pattern. I was working in a team where we had all become highly dependant on
fuzzy searching and as such no one really paid much attention to organising
the code in a sensible manner. That useful tool had become a requirement and
that lack of organisation resulted in more wasted time than the use of the
tool saved in the first place. I think I still stand by this view point, and
I've not bothered with dedicated code base searching since.

### Tab completion

Also worth noting that all Tab completion stuff is gone by this point. It felt
like a crutch. I was going into environments where I couldn't install YCM and
was unable to function properly. I figured out that I could get almost all of
what I needed from vim's built in completion and just reading
documentation/source code. I removed YCM from my vimrc around this time and
honestly I've not missed it one bit.

### Me stuff

* [vim-http](https://github.com/nicwest/vim-http) :star:

I think this started off as just being syntax highlighting for raw HTTP
requests. I use these quite a lot in documentation to do a language agnostic
examples of API requests/responses. Then I thought about making those examples
executable. One thing lead to another and ended up trying to do QQ.vim but
in a way that made sense to me as a vim user rather than just blindly trying
to translate features from postman into vim script.

This is probably one of only two vim plugins that I have written that I really
like and actively use on a daily basis.

## October 2017

https://github.com/nicwest/dotstow/blob/0c01b456a5bf319b8337651a3f2061b449685dd1/vim/.vimrc

Jump forward another year. Largely writing python and go at work, and clojure
and vimscript at home.

```
Plug 'Raimondi/delimitMate'
Plug 'fatih/vim-go'
Plug 'guns/vim-slamhound'
Plug 'haya14busa/incsearch.vim'
Plug 'jeetsukumaran/vim-filebeagle'
Plug 'jpythonfold.vim'
Plug 'luochen1990/rainbow'
Plug 'scrooloose/nerdcommenter'
Plug 'scrooloose/syntastic'
Plug 'tpope/vim-fireplace'
Plug 'tpope/vim-projectionist'
Plug 'tpope/vim-scriptease'
Plug 'tpope/vim-surround'
Plug 'tpope/vim-repeat'
Plug 'tpope/vim-unimpaired'
Plug 'wellle/targets.vim'
Plug 'vim-jp/vital.vim'
Plug '/home/nic/src/vim-filebeagle'
Plug '/home/nic/sideprojects/vim-http'
Plug '/home/nic/sideprojects/vim-spacey'
Plug '/home/nic/sideprojects/template-bucket'
Plug '/home/nic/sideprojects/vim-generate'
Plug '/home/nic/sideprojects/vim-camelsnek'
```

### General Utilities

* [vim-unimpaired](https://github.com/tpope/vim-unimpaired)

Another Tpope classic makes a brief apperence, I don't remember why...

### Me stuff

* [vim-spacey](https://github.com/nicwest/vim-spacey)
* [vim-generate)](https://github.com/nicwest/vim-generate) :star:
* [vim-camelsnek](https://github.com/nicwest/vim-camelsnek) :star:

Spacey... I was clearly writing something with lots of underscores or hyphens
or something inplace of spaces, This pluggin toggles the space bar to
temporarily use a differnent character instead. Surfices to say this probably
only saw about 1 afternoon of daylight.

Camelsnek coverts between camel case and snake case. I've since been told that
this functionality already exists in https://github.com/tpope/vim-abolish.

Generate is like [faker](https://metacpan.org/pod/Data::Faker) for vim. oftern
in tests and what not you want some random example of an email address, or a
timestamp, or a uuid. currently missing from my vimrc and I need to put it
back.

### Jan 2019

https://github.com/nicwest/dotstow/blob/a88eca10169239ad717c21f966ee826f9d544357/vim/.vimrc

New job, new laptop. Only really writing python and terraform at this point.

```
Plug 'andreypopp/vim-colors-plain'
Plug 'Raimondi/delimitMate'
Plug 'fatih/vim-go'
Plug 'guns/vim-slamhound'
Plug 'haya14busa/incsearch.vim'
"Plug 'jeetsukumaran/vim-filebeagle'
Plug 'junegunn/vader.vim'
Plug 'luochen1990/rainbow'
Plug 'scrooloose/nerdcommenter'
Plug 'tpope/vim-fireplace'
Plug 'tpope/vim-projectionist'
Plug 'tpope/vim-scriptease'
Plug 'tpope/vim-surround'
Plug 'tpope/vim-repeat'
Plug 'tpope/vim-unimpaired'
Plug 'w0rp/ale'
Plug 'wellle/targets.vim'
Plug 'vim-jp/vital.vim'
Plug '/home/nic/src/vim-filebeagle'
Plug '/home/nic/sideprojects/vim-http'
Plug '/home/nic/sideprojects/vim-spacey'
Plug '/home/nic/sideprojects/template-bucket'
Plug '/home/nic/sideprojects/vim-generate'
Plug '/home/nic/sideprojects/vim-camelsnek'
Plug '/home/nic/sideprojects/vim-dict'
Plug '/home/nic/sideprojects/vim-folding'
Plug '/home/nic/sideprojects/vim-pipsearch'
```

### Aesthetic Utilities

* [vim-colors-plain](https://github.com/andreypopp/vim-colors-plain)

I was working out side a fair bit that summer and hybrid's dark background was
hard to read in direct sunlight. 

### Language Utilities

* [ale](https://github.com/dense-analysis/ale) :star:
* [vader.vim](https://github.com/junegunn/vader.vim)

The big addition to my vim life at this point in time was async syntax
highlighting and fixing. w0rp's ALE blew syntastic out of the water and has
been a staple of my vimrc ever since.

Vader is a testing lib for vimscript. 


### Me stuff

* [vim-folding](https://github.com/nicwest/vim-folding)
* [vim-dict](https://github.com/nicwest/vim-dict)

Jpythonfold had become a core part of my python tooling over the years. But
occasionally I would run into a code base that just wouldn't fold well, and
that was super frustrating. I tried to "fix" jpythonfold for a bit before
throwing up my hands and trying to write my own folding lib from scratch. I
think mine was an improvement generally, but it turned out to be a really
difficult problem to solve and I eventually gave up on folding all together.

## Feb 2021

https://github.com/nicwest/dotstow/blob/e364f8837780991b4a5943dce7e87468c7c80b3e/vim/.vimrc

Plug in wise, almost nothing changes for over 2 years. I'm super absorbed by
work and don't find a lot of time to write or learn anything in my free time.

```
Plug 'Raimondi/delimitMate'
Plug 'fatih/vim-go'
Plug 'guns/vim-slamhound'
Plug 'haya14busa/incsearch.vim'
Plug 'jeetsukumaran/vim-filebeagle'
Plug 'junegunn/vader.vim'
Plug 'leafgarland/typescript-vim'
Plug 'luochen1990/rainbow'
Plug 'scrooloose/nerdcommenter'
Plug 'tpope/vim-fireplace'
Plug 'tpope/vim-projectionist'
Plug 'tpope/vim-scriptease'
Plug 'tpope/vim-surround'
Plug 'tpope/vim-repeat'
Plug 'tpope/vim-unimpaired'
Plug 'w0rp/ale'
Plug 'wellle/targets.vim'
Plug 'vim-jp/vital.vim'

Plug '/home/nic.west/sideprojects/vim-http'
Plug '/home/nic.west/sideprojects/vim-generate'
Plug '/home/nic.west/sideprojects/vim-camelsnek'
Plug '/home/nic.west/sideprojects/vim-workman'
```

### Language Utilities

* [typescript-vim](https://github.com/leafgarland/typescript-vim)

I picked up a little bit of react so I could help out our frontend team when
they were understaffed. React is fun, I really really really don't see the
point of typescript though. 

## May 2022

https://github.com/nicwest/dotstow/blob/602f3f98e3b526d742c0db0c994e0fa09f7a58ec/vim/.vimrc

That brings us to today! May 2022. The nature of my job has changed, I'm
writing a lot more English than I'm writing python. ALE gets used largely for
proselint and writegood rather than flake8. Now adays I spend my free time
learning steno and reading books rather than programming.

```
Plug 'Raimondi/delimitMate'
Plug 'hashivim/vim-terraform'
Plug 'haya14busa/incsearch.vim'
Plug 'jeetsukumaran/vim-filebeagle'
Plug 'luochen1990/rainbow'
Plug 'scrooloose/nerdcommenter'
Plug 'tpope/vim-surround'
Plug 'tpope/vim-repeat'
Plug 'w0rp/ale'
Plug 'wellle/targets.vim'

Plug '/Users/nic.west/sideprojects/vim-http'
Plug '/home/nic.west/sideprojects/vim-generate'
Plug '/home/nic.west/sideprojects/vim-camelsnek'
```

Note: hybrid and vim-plug are natively installed and are not managed by
vim-plug

### Language Utilities

* [vim-terraform](hashivim/vim-terraform) :star:

My one programming addition is this great plugin for terraform. If you are
writing terraform config regularly and not using this I would strongly
recommend you try it.

## Wrapping up

I think it's interesting to see how many of the plugins that I use today were
added to my vimrc in those first few months of experimentation.

It's awesome that a couple of these plugins went on to get merged into vim
proper. I would love to discover/write something that ubiquitous someday and
have the energy to get it merged in the source code.

I've enjoyed watching past me struggle with concepts like project navigations
and tab completion, and what does and doesn't belong in vim (looking at you
git).
