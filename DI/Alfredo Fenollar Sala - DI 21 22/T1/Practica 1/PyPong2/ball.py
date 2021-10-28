import pygame
from pygame.draw import circle
import config


class Ball():
    def __init__(self, x, y, vx, vy, radius, color, screen):
        # A ball need a position (x,y), a radius, a color and the screen where we will paint it, therefore
        # the constructor will take these as arguments and save their values in variables of the ball class by using the word self
        self.x = x
        self.y = y
        self.vx = vx
        self.vy = vy
        self.radius = radius
        self.screen = screen
        self.color = color

    # The draw function will be responsible for drawing the ball in the screen
    def draw(self):
        pygame.draw.circle(
            config.screen, self.color, [self.x, self.y], self.radius)

    def update(self):
        newx = self.x + self.vx
        newy = self.y + self.vy

        if newx < config.RADIUS or newx > config.WIDTH - config.RADIUS:
            print("F")
            self.vx = -self.vx
        elif newy < config.RADIUS + config.PADDLE_WIDTH or newy > config.HEIGHT - config.RADIUS - config.PADDLE_WIDTH:
            self.vy = -self.vy
        else:
            self.x = newx
            self.y = newy
            self.draw()
