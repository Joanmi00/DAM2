#!/bin/bash
# Definim una funció que compta d'1 a 5,
# amb pauses d'un segon

compta(){
    for i in {0..5}; do
        echo $i
        sleep 1
    done
}

# Escrivim els següents missatges quan es reben les senyals 15 i 9
trap 'echo capturant SIGKILL?' 9    # Compte, podem fer el
# procés "indestructible"!
trap 'echo capturant SIGTERM' 15

# Ignorem la interrupció 2 (SIGINT), mentre
# executem la funció compta.
trap '' 2 # Si no posem cap ordre, simplement ignorem la senyal
echo "Ignorant SIGINT"
compta

# Ara la capturem i executem una funció quan es rep SIGINT
trap 'capturadora' 2
echo "Capturant SIGINT"

capturadora(){
    echo "Has polsat Ctrl+C. Espera un moment."
}

compta
# Ara deixem de capturar la senyal
trap - 2
echo "Ara podeu interromple l'execució"
compta