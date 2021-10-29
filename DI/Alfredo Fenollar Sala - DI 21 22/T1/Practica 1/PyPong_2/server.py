import pickle
import socket
from _thread import *

import config
from ball import Ball
from paddle import Paddle

server = "127.0.0.1"
port = 5555

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    s.bind((server, port))
except socket.error as e:
    str(e)

s.listen(2)
print("Waiting for a connection, Server Started")

# Create the paddles
paddle1 = Paddle(0, config.HEIGHT // 2 - config.PADDLE_HEIGHT // 2)
paddle2 = Paddle(config.WIDTH - config.PADDLE_WIDTH, config.HEIGHT // 2 - config.PADDLE_HEIGHT // 2)
# Create the ball
ball = Ball(config.RADIUS + config.PADDLE_WIDTH + 10, config.HEIGHT // 2, config.VELOCITY,
            config.VELOCITY, config.RADIUS, config.color_ball, config.screen)
# ball.draw()

# Put them in an array
objects = [paddle1, paddle2, ball]


def threaded_client(conn, player):
    conn.send(pickle.dumps(objects[player]))
    while True:
        try:
            data = pickle.loads(conn.recv(2048))
            objects[player] = data[0]
            objects[player] = data

            if not data:
                print("Disconnected")
                break
            else:
                if player == 1:
                    # objects[0] is player 1, objects[2] is ball
                    # reply = [objects[0], objects[2]]
                    reply = objects[0]
                else:
                    # objects[1] is player 2, objects[2] is ball
                    # reply = [objects[1], objects[2]]
                    reply = objects[1]

                # ball.update()
                print("Received: ", data)
                print("Sending : ", reply)

            conn.sendall(pickle.dumps(reply))
        except socket.error as err:
            print(err)

    print("Lost connection")
    conn.close()


current_player = 0
while True:
    conn, addr = s.accept()
    print("Connected to:", addr)

    start_new_thread(threaded_client, (conn, current_player))
    current_player += 1
