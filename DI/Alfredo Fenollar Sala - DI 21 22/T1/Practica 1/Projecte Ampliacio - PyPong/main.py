import pygame
import config
from network import Network
# Import pygame.locals for easier access to key coordinates
# Updated to conform to flake8 and black standards
from pygame.locals import (K_ESCAPE, KEYDOWN, QUIT)

# Setup for sounds. Defaults are good.
pygame.mixer.init()

# Draw the scenario
pygame.init()
config.screen.fill(config.color_bg)

# Caption & Client
pygame.display.set_caption("Client")
clientNumber = 0


def redraw_window(screen, player1, player2, ball):
    # Paint the screen black
    screen.fill(config.color_bg)
    # Visualize the changes made
    player1.draw(config.color_p1)
    player2.draw(config.color_p2)
    ball.update(player1, player2)
    pygame.display.update()


# Setup the clock for a decent framerate
clock = pygame.time.Clock()

running = True
run = True
n = Network()
objectes_rebuts1 = n.get_p()

p1 = objectes_rebuts1[0]
bola = objectes_rebuts1[1]

while running:
    objectes_rebuts2 = n.send(p1)
    p2 = objectes_rebuts2[0]
    # bola = objectes_rebuts2[1]

    for event in pygame.event.get():
        if event.type == KEYDOWN:
            if event.key == K_ESCAPE:
                running = False
        elif event.type == QUIT:
            running = False

    p1.update(pygame.Color("white"))
    redraw_window(config.screen, p1, p2, bola)
    clock.tick(config.FRAMERATE)

# Exit pygame imports
pygame.mixer.music.stop()
pygame.mixer.quit()
pygame.quit()
