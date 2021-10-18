#!/bin/bash
echo "Hola, soc el procés 2, i puc accedir a $MYVAR"
echo "Estat dels processos:"
ps -o pid,ppid,cmd,state
sleep 5
exit 3