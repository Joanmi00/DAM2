if __name__ == '__main__':
    import pygame
    import config
    from paddle import Paddle
    from ball import Ball
    # Import pygame.locals for easier access to key coordinates
    # Updated to conform to flake8 and black standards
    from pygame.locals import (K_ESCAPE, KEYDOWN, QUIT, RLEACCEL)

    # def check_collision():
    #     # Check if the ball has collided with any paddle
    #     if ball.x <= paddle1.paddle_width or ball.x >= paddle2.paddle_width and (
    #             ball.y <= paddle1.paddle_height or ball.y >= paddle2.paddle_height):
    #         print("toque")

    # Setup for sounds. Defaults are good.
    pygame.mixer.init()

    # Draw the scenario
    pygame.init()
    config.screen.fill(config.color_bg)

    # Setup the clock for a decent framerate
    clock = pygame.time.Clock()

    # Draw the walls
    # pygame.draw.rect(config.screen, config.fgColor, pygame.Rect(
    #     0, 0, BORDER, config.HEIGHT))
    # pygame.draw.rect(config.screen, config.fgColor, pygame.Rect(
    #     (config.WIDTH - BORDER, 0), (config.WIDTH, config.HEIGHT)))
    # pygame.draw.rect(config.screen, config.color_ball, pygame.Rect(
    #     (0, 0), (config.WIDTH, 0)))
    # pygame.draw.rect(config.screen, config.color_ball, pygame.Rect(
    #     (0, config.HEIGHT, config.WIDTH, 0)))

    # Create and draw the paddles
    paddle1 = Paddle(0, config.HEIGHT // 2 - config.PADDLE_HEIGHT // 2)
    paddle1.draw(config.color_p1)
    paddle2 = Paddle(config.WIDTH - config.PADDLE_WIDTH, config.HEIGHT // 2 - config.PADDLE_HEIGHT // 2)
    paddle2.draw(config.color_p2)

    # Create and draw the ball
    ball = Ball(config.RADIUS + config.PADDLE_WIDTH + 10, config.HEIGHT // 2, config.VELOCITY,
                config.VELOCITY, config.RADIUS, config.color_ball, config.screen)
    ball.draw()

    running = True
    while running:
        for event in pygame.event.get():
            if event.type == KEYDOWN:
                if event.key == K_ESCAPE:
                    running = False
            elif event.type == QUIT:
                running = False

        # # Check if the ball has collided with any paddle
        # if ball.:
        #     # If so, then play sound, remove the player and stop the loop
        #     collision_sound.play()
        #     player.kill()
        #     running = False
        #     # Sleep 0.5s so sound effect plays completely
        #     time.sleep(0.5)

        # Paint the screen black
        config.screen.fill(config.color_bg)

        # Visualize the changes made
        # check_collision() !!!!!
        paddle1.update(config.color_p1)
        paddle2.update(config.color_p2)
        ball.update(paddle1, paddle2)
        pygame.display.flip()
        clock.tick(config.FRAMERATE)

    # Exit pygame imports
    pygame.mixer.music.stop()
    pygame.mixer.quit()
    pygame.quit()
