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
    print(e)

s.listen(2)
print("Waiting for a connection, Server Started")

# Create the paddles
paddle1 = Paddle(0, config.HEIGHT // 2 - config.PADDLE_HEIGHT // 2)
paddle2 = Paddle(config.WIDTH - config.PADDLE_WIDTH, config.HEIGHT // 2 - config.PADDLE_HEIGHT // 2)
# Create the ball
ball = Ball(config.RADIUS + config.PADDLE_WIDTH + 10, config.HEIGHT // 2, config.VELOCITY,
            config.VELOCITY, config.RADIUS, config.color_ball)

# Put them in an array
objects = [paddle1, paddle2]


def threaded_client(conn_, player):
    conn_.send(pickle.dumps([objects[player], ball]))
    while True:
        try:
            data = pickle.loads(conn_.recv(2048))
            objects[player] = data

            if not data:
                print("Disconnected")
                break
            else:
                if player == 0:
                    # objects[0] is player 1, objects[2] is ball
                    # reply = objects[0]
                    reply = [objects[1], ball]
                else:
                    # objects[1] is player 2, objects[2] is ball
                    # reply = objects[1]
                    reply = [objects[0], ball]

                print("Received: ", data)
                print("Sending : ", reply)

            conn_.sendall(pickle.dumps(reply))
        except socket.error as err:
            print(err)
            conn_.close()

    print("Lost connection")
    conn_.close()


current_player = 0
while True:
    conn, addr = s.accept()
    print("Connected to:", addr)

    start_new_thread(threaded_client, (conn, current_player))
    current_player += 1
