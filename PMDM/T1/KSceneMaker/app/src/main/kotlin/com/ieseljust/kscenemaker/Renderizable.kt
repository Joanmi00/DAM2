@file:JvmName("Renderizable")

package com.ieseljust.kscenemaker

import java.awt.Graphics

/*
Intefície que s'assegura que els mètode que la implementen
ofereixen un mètide anomenat "render", per dibuixar a
un objecte de tipus Graphics.
*/

interface Renderizable {
  // Rep un objecte Graphics de Java
  fun render(g: Graphics)
}

