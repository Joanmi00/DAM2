import pygame
import config


class Paddle:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.paddle_width = config.PADDLE_WIDTH
        self.paddle_height = config.PADDLE_HEIGHT

    def draw(self, colour):
        pygame.draw.rect(config.screen, colour, pygame.Rect(
            (self.x, self.y),  # x1, y1
            (self.paddle_width, self.paddle_height)))  # x2, y2

    def update(self, colour):
        self.y = pygame.mouse.get_pos()[1]
        if self.y < 0:
            self.y = 0
        elif self.y > config.HEIGHT - self.paddle_height:
            self.y = config.HEIGHT - self.paddle_height
        self.draw(colour)
