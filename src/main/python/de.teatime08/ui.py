import pygame
import threading
import sys
from pygame.locals import *

class CellsUI:

    def __init__(self, screen_width=800, screen_height=600, cell_size=10, alive_color=(0, 255, 255),
                 dead_color=(0, 0, 0)):
        pygame.init()
        self.max_fps = 60
        self.livingCells = set()
        self.numCols = int((screen_height / cell_size) * 0.9)
        self.numRows = int((screen_width / cell_size) * 0.9)
        self.screen_width = screen_width
        self.screen_height = screen_height
        self.cell_size = cell_size
        self.alive_color = alive_color
        self.dead_color = dead_color
        self.coordinate_color = (250, 7 , 102)

        self.screen = pygame.display.set_mode((self.screen_width, self.screen_height),HWSURFACE|DOUBLEBUF|RESIZABLE)
        self.screen.fill(self.dead_color)
        pygame.display.flip()


    def run(self):
        try:
            t1 = threading.Thread(target=self.draw, args=())
            t1.start()
        except:
            print
            "Error: unable to start thread"

    def update(self, livingCells):
        self.livingCells = livingCells


    def draw(self):
        clock = pygame.time.Clock()
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()
            self.screen.fill(self.dead_color)
            cOffset = (self.numCols * self.cell_size) / 2
            rOffset = (self.numRows * self.cell_size) / 2
            pygame.draw.line(self.screen,self.coordinate_color,(rOffset, 0),(rOffset, cOffset * 2),3)
            pygame.draw.line(self.screen,self.coordinate_color,(0, cOffset),(rOffset * 2, cOffset),3)
            for cell in self.livingCells:
                c = list(cell)[0]
                r = list(cell)[1]
                cell_rad = int(self.cell_size / 2)
                pygame.draw.circle(self.screen,
                                   self.alive_color,
                                   (int(cOffset + c * self.cell_size + cell_rad),
                                    int(rOffset + r * self.cell_size + cell_rad)),
                                   cell_rad,
                                   0)
            pygame.display.flip()
            clock.tick(self.max_fps)