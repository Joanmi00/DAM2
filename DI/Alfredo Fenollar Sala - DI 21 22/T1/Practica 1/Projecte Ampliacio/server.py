import pickle
import socket
from _thread import *
# Import the Player Class from the player File
from player import Player
from client import width, height

# IPV4 of server Device (same ip on network.py)
server = "192.168.1.49"
port = 5555

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    s.bind((server, port))
except socket.error as e:
    str(e)

# Limit connection to 2 people
s.listen(2)
print("Waiting for a connection, server started")

# players = [Player(width + 10, height / 2, 50, 50, (255, 0, 0)), Player(width - 10, height / 2, 50, 50, (0, 0, 255))]
players = [Player(0, 0, 50, 50, (255, 0, 0)), Player(100, 100, 50, 50, (0, 0, 255))]


def threaded_client(conn_, player):
    conn_.send(pickle.dumps(players[player]))
    reply = ""
    while True:
        try:
            # We can increase by how much we multiply 2048 to recieve more data at once
            data = pickle.loads(conn_.recv(2048))
            players[player] = data

            if not data:
                print("Disconnected")
                break
            else:
                if player == 1:
                    reply = players[0]
                else:
                    reply = players[1]

                print("Received: ", data)
                print("Sending : ", reply)

            conn_.sendall(pickle.dumps(reply))
        except:
            break

    print("Lost connection")
    conn_.close()


current_player = 0
while True:
    conn, addr = s.accept()
    print("Connected to: ", addr)

    start_new_thread(threaded_client, (conn, current_player))
    current_player += 1
