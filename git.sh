#!/usr/bin/env bash

if [ $1 == "status" ]
then
    git status
    exit 1
fi

if [ $1 == "add" ]
then
    git add .
    exit 1
fi

if [ $1 == "commit" ]
then
    git add .
    git pull
    git commit -m $2
    exit 1
fi

if [ $1 == "push" ]
then
    git add .
    git pull
    git commit -m "$2"
    git push
    exit 1
fi