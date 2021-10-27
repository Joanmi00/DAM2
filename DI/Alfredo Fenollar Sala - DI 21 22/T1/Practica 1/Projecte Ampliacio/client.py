# Import the pygame module
import pygame
# Import the Network Class from the network File
from network import Network
from player import Player

width = 500
height = 500
win = pygame.display.set_mode((width, height))
pygame.display.set_caption("Client")


def redraw_window(win_, player1, player2):
    win_.fill((255, 255, 255))
    player1.draw(win_)
    player2.draw(win_)
    pygame.display.update()


def main():
    run = True
    n = Network()
    p1 = n.get_p()
    clock = pygame.time.Clock()

    while run:
        clock.tick(60)
        p2 = n.send(p1)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                pygame.quit()

        p1.move()
        redraw_window(win, p1, p2)


main()
