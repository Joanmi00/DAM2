import pygame

from table import (
    WIDTH, HEIGHT, VELOCITY, FRAMERATE, screen, bgColor, fgColor, blue)


class Ball:
    RADIUS = 20

    def __init__(self, x, y, vx, vy):
        self.x = x
        self.y = y
        self.vx = vx
        self.vy = vy

    def show(self, colour):
        pygame.draw.circle(screen, colour, (self.x, self.y), Ball.RADIUS)

    def update(self):
        newx = self.x + self.vx
        newy = self.y + self.vy

        if newx < self.RADIUS or newx > WIDTH - self.RADIUS:
            print("F")
            self.vx = -self.vx
        elif newy < self.RADIUS or newy > HEIGHT - self.RADIUS:
            self.vy = -self.vy
        else:
            self.show(bgColor)
            self.x = newx
            self.y = newy
            self.show(fgColor)
