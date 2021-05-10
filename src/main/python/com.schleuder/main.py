from game import Game
from ui import CellsUI
from gameconfig import SpawnConfig
from gameconfig import GameConfig
import threading

def run():
    while True:
        #g.status(10, True)
        cells = g.next()
        ui.update(cells)

if __name__ == "__main__":
    #g = Game(spawnConfig=SpawnConfig.All())
    conf = GameConfig()
    conf.dimension = 6
    spawn = SpawnConfig()
    g = Game(spawnConfig=spawn, gameConfig=conf)
    #ui = CellsUI(dead_color=(250, 250, 250), screen_width=500, screen_height=500)
    ui = CellsUI(dead_color=(250, 250, 250), screen_width=500, screen_height=500)
    ui.run()
    t1 = threading.Thread(target=run, args=())
    t1.start()
    #for x in range(1,10000):
    #    #g.status(10, True)
    #    cells = g.next()
    #    ui.update(cells)
    #g.status(10, printField=True)
