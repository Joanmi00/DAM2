#!/bin/bash

clear
echo "exec 3<>/dev/tcp/www.google.com/80"
exec 3<>/dev/tcp/www.google.com/80
echo "file /proc/$$/fd/*"
file /proc/$$/fd/*
#echo ""
echo "GET /" >&3
cat <&3 > arxiu.txt