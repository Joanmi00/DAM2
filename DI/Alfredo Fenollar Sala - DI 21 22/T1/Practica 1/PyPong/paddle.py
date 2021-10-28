import pygame
from pygame.constants import WINDOWCLOSE
from table import (
    WIDTH, HEIGHT, VELOCITY, FRAMERATE, screen, bgColor, fgColor, blue)


class Paddle:
    PADDLE_WIDTH = 20
    PADDLE_HEIGHT = 120

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def show(self, colour):
        pygame.draw.rect(screen, colour, pygame.Rect((
            WIDTH - self.PADDLE_WIDTH,
            self.y - self.PADDLE_HEIGHT // 2,
            self.PADDLE_WIDTH,
            self.PADDLE_HEIGHT)))

    def update(self):
        new_y = pygame.mouse.get_pos()[1]
        if new_y - self.PADDLE_HEIGHT//2 > 0 \
                and new_y + self.PADDLE_HEIGHT//2 < HEIGHT:
            self.show(bgColor)
            self.y = new_y
            self.show(blue)
