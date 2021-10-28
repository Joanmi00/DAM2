if __name__ == '__main__':
    import pygame
    from ball import Ball
    from paddle import Paddle
    from table import (
        WIDTH, HEIGHT,  VELOCITY, FRAMERATE, screen, bgColor, fgColor, blue)
    # Import pygame.locals for easier access to key coordinates
    # Updated to conform to flake8 and black standards
    from pygame.locals import (
        K_UP, K_DOWN, K_LEFT, K_RIGHT, K_w, K_s, K_a, K_d, K_ESCAPE, KEYDOWN, QUIT, RLEACCEL)

    # Setup for sounds. Defaults are good.
    pygame.mixer.init()

    # Draw the scenario
    pygame.init()
    screen.fill(bgColor)

    # Setup the clock for a decent framerate
    clock = pygame.time.Clock()

    # Draw the walls
    # pygame.draw.rect(screen, fgColor, pygame.Rect(0, 0, BORDER, HEIGHT))
    # pygame.draw.rect(screen, fgColor, pygame.Rect((WIDTH - BORDER, 0), (WIDTH, HEIGHT)))
    pygame.draw.rect(screen, fgColor, pygame.Rect(
        (0, 0), (WIDTH, 0)))
    pygame.draw.rect(screen, fgColor, pygame.Rect(
        (0, HEIGHT, WIDTH, 0)))

    # Create and draw the paddles
    paddle1 = Paddle(Paddle.PADDLE_WIDTH, HEIGHT // 2)
    paddle1.show(fgColor)
    paddle2 = Paddle(WIDTH - Paddle.PADDLE_WIDTH, HEIGHT // 2)
    paddle2.show(fgColor)

    # Create and draw the ball
    ball = Ball(Ball.RADIUS, HEIGHT // 2, VELOCITY, VELOCITY)
    ball.show(fgColor)

    running = True
    while running:
        for event in pygame.event.get():
            if event.type == KEYDOWN:
                if event.key == K_ESCAPE:
                    running = False
            elif event.type == QUIT:
                running = False

        # Visualize the changes made
        paddle1.update()
        paddle2.update()
        ball.update()
        pygame.display.flip()
        clock.tick(FRAMERATE)

    # Exit pygame imports
    pygame.mixer.music.stop()
    pygame.mixer.quit()
    pygame.quit()
