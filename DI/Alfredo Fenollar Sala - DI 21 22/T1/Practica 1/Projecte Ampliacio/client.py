import pygame

from network import Network

width = 500
height = 500
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Client")

clientNumber = 0


def redraw_window(screen, player1, player2):
    screen.fill((255, 255, 255))
    player1.draw(screen)
    player2.draw(screen)
    pygame.display.update()


def main():
    run = True
    n = Network()
    p1 = n.get_p()
    clock = pygame.time.Clock()

    while run:
        clock.tick(30)
        p2 = n.send(p1)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                pygame.quit()

        p1.move()
        redraw_window(screen, p1, p2)


main()
