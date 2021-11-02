import pygame
import config


class Ball:
    def __init__(self, x, y, vx, vy, radius, color):
        # A ball need a position (x,y), a radius, a color and the screen where we will paint it,
        # therefore the constructor will take these as arguments and save their values
        # in variables of the ball class by using the word self
        self.x = x
        self.y = y
        self.vx = vx
        self.vy = vy
        self.radius = radius
        self.color = color

    # The draw function will be responsible for drawing the ball in the screen
    def draw(self):
        pygame.draw.circle(
            config.screen, self.color, [self.x, self.y], self.radius)

    def update(self, paddle1, paddle2):
        newx = self.x + self.vx
        newy = self.y + self.vy

        if newx < config.RADIUS:
            self.vx = -self.vx
            print("Guanya jugador 2")
        elif newx > config.WIDTH - config.RADIUS:
            self.vx = -self.vx
            print("Guanya jugador 1")
        elif newy < config.RADIUS or newy > config.HEIGHT - config.RADIUS:
            self.vy = -self.vy
        elif newx - config.RADIUS < config.PADDLE_WIDTH \
                and paddle1.y <= newy <= (paddle1.y + config.PADDLE_HEIGHT):
            self.vx = -self.vx
            print("TOQUE P1")
        elif newx + config.RADIUS > config.WIDTH - config.PADDLE_WIDTH \
                and paddle1.y <= newy <= (paddle2.y + config.PADDLE_HEIGHT):
            self.vx = -self.vx
            print("TOQUE P2")
        else:
            self.x = newx
            self.y = newy
            self.draw()  # draw new ball in new position
