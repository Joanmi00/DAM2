#!/bin/bash

clear
firefox &
echo "esperando 15 segundos para que firefox se abra completamente"
echo
sleep 5
echo "PIDs firefox:"
pidof firefox
echo "========================"
echo "ps -ef | grep firefox:"
echo
ps -ef | grep firefox
echo "========================"
echo "ps -o pid,ppid,cmd,state,user | grep firefox:"
echo
ps -o pid,ppid,cmd,state,user | grep firefox
echo "========================"
echo "[killall firefox]"
echo "No va"
echo "========================"
echo "ps -o pid,ppid,cmd,state,user | grep firefox:"
echo
ps -o pid,ppid,cmd,state,user | grep firefox