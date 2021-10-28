import pygame
import config


class Paddle:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.paddle_width = config.PADDLE_WIDTH
        self.paddle_height = config.PADDLE_HEIGHT

    def draw(self, colour):
        pygame.draw.rect(config.screen, colour, pygame.Rect((
            self.x,  # x1
            self.y - self.paddle_height // 2,  # y1
            self.paddle_width,  # x2
            self.paddle_height)))  # y2

    def update(self, colour):
        new_y = pygame.mouse.get_pos()[1]
        if new_y - self.paddle_height // 2 > 0 \
                and new_y + self.paddle_height // 2 < config.HEIGHT:
            self.y = new_y
            self.draw(colour)
