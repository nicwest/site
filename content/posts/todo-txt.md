---
title: "Todo.txt"
date: "2015-02-21 15:43:48"
version: 0.1
tags: [bash, cli, org]
---

![Todo list](/images/todo.png)
I've started using a TODO list. I looked into a number of vim based solutions
like [vim-org-mode][vim-org-mode] and [vim-notes][vim-notes], but they all felt
a bit too complex.

In the end I settled on [todo.txt-cli][todo.txt-cli] which is a terminal program
that manages a set of text base todo lists. It has a bunch of base features such
as projects, tags, priorities, reports, and archiving. [There is also a bunch of
plugins][plugins] that give you things like syncing with git/google-tasks,
scheduling, recurring tasks, and printing. [There are also GUI based programs
and mobile apps][todo.txt].

I wrote a couple of bash functions and aliases to automatically workout what
project I'm working on based on git dir:

{{< highlight bash >}}
TODO_SH="path/to/script/todo.sh"
alias todo="$TODO_SH"
alias tdo="$TODO_SH do"

_get_project_todos() {
    local git_dir=$(git rev-parse --show-toplevel 2>/dev/null)
    if [ "$git_dir" != "" ] ; then
        local root_name=$( basename $git_dir )
        local num_proj_todo="$($TODO_SH ls +$root_name | wc -l | sed -e's/ *//')"
        echo $( expr $num_proj_todo - 2 )
    else
        local root_name=""
        echo "0"
    fi
}

_get_non_project_todos() {
    local git_dir=$(git rev-parse --show-toplevel 2>/dev/null)
    if [ "$git_dir" != "" ] ; then
        local root_name=$( basename $git_dir )
        local num_non_proj_todo="$($TODO_SH ls -+$root_name | wc -l | sed -e's/ *//')"
    else
        local root_name=""
        local num_non_proj_todo="$($TODO_SH ls | wc -l | sed -e's/ *//')"
    fi
    echo $( expr $num_non_proj_todo - 2 )
}

ta() {
    if [ $# -eq 0 ]; then
        echo "no arguments given fucktard :("
        return 0
    fi
    local git_dir=$(git rev-parse --show-toplevel 2>/dev/null)
    if [ "$git_dir" != "" ] ; then
       local root_name=$( basename $git_dir )
       $TODO_SH add +$root_name $@
    else
       local root_name=""
       $TODO_SH add $@
    fi
}

tls () {
    local git_dir=$(git rev-parse --show-toplevel 2>/dev/null)
    if [ "$git_dir" != "" ] ; then
       local root_name=$( basename $git_dir )
       $TODO_SH list +$root_name $@
    else
       local root_name=""
       $TODO_SH list $@
    fi
}

#right handside of oh-my-zsh theme
RPROMPT='%{$fg['cyan']%}$(_get_project_todos)%{$reset_color%}|%{$fg['blue']%}$(_get_non_project_todos)%{$reset_color%}'
{{</ highlight >}}

I really like the idea of the remote syncing and recurring tasks. I also would
like to be able to track time against these tasks using [toggl][toggl], so
that might be a plugin that needs writing!

[vim-org-mode]: https://github.com/jceb/vim-orgmode
[vim-notes]: https://github.com/xolox/vim-notes
[todo.txt-cli]: https://github.com/ginatrapani/todo.txt-cli
[todo.txt]: http://todotxt.com/
[plugins]: https://github.com/ginatrapani/todo.txt-cli/wiki/Todo.sh-Add-on-Directory
[toggl]: https://www.toggl.com
