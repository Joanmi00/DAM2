import pygame

# CONSTANTS
WIDTH = 600
HEIGHT = 600
VELOCITY = 10
FRAMERATE = 30
PADDLE_WIDTH = 20
PADDLE_HEIGHT = 120
RADIUS = 20

color_white = pygame.Color("white")
color_bg = pygame.Color("black")
color_ball = pygame.Color("green")
color_p1 = pygame.Color("blue")
color_p2 = pygame.Color("red")

# Draw the scenario
screen = pygame.display.set_mode((WIDTH, HEIGHT))
