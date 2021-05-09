from gameconfig import GameConfig
from gameconfig import SpawnConfig
from neighbours import Neighbours
from random import *
import math



class Game:
    livingCells = []
    gen = 0

    def __init__(self):
        self.config = GameConfig()
        self.spawn = SpawnConfig()
        self.livingCells = []
        self.gen = 0
        self.initialize()

    def initialize(self):
        for x in range(1, int(self.spawn.initTotal)):
             point = [None for _ in range(self.config.dimension)]
             for dim in range(0, self.config.dimension):
                 point[dim] = self.spawn.initSpawnDistance + randint(-50, 50)
             self.livingCells.append(point)

    def next(self):
        # kill
        next = self.livingCells.copy()
        potentials = set()
        for cell in self.livingCells:
            n = self.neighbours(cell, True)
            potentials.update(n.toEnliven)
            if self.ruleE(n.number):
                next.append(cell)
        print("{} potentials found".format(len(potentials)))
        for pot in potentials:
            n = self.neighbours(pot)
            if self.ruleF(n.number):
                next.append(pot)
        self.livingCells = next
    
    def ruleE(self, numberNeighbors):
        return (self.config.El <= numberNeighbors <= self.config.Eu)
    
    def ruleF(self, numberNeighbors):
        return (self.config.Fl <= numberNeighbors <= self.config.Fu)

    def neighbours(self, cell, potentials=False):
        neighbours = []
        toEnliven = set()
        for i in self.livingCells:
            print("{} neighbours".format(i))
            for j in self.livingCells:
                if i == j:
                    continue
                dist = 0
                distVec = [None for _ in range(self.config.dimension)]
                for dim in range(0, self.config.dimension):
                    distVec[dim] = i[dim] - j[dim]
                    dist += abs(distVec[dim])
                if (dist <= self.config.dimension):
                    neighbours.append(j)
                    continue
                if (potentials and dist <= self.config.dimension * 2):
                    permutRounding = set()
                    for dim in range(0, self.config.dimension):
                        v1 = i[dim] + math.floor(distVec[dim] / 2.0)
                        v2 = i[dim] + math.ceil(distVec[dim] / 2.0)
                        # calculate permutations for ceil/floor (mostly important for higher-dimentional stuff)
                        for teilv in permutRounding:
                            if (v1 != v2):
                                double = teilv.copy()
                                double.append(v1)
                                v.add(double)
                            teilv.append(v2)
                    toEnliven.update(permutRounding)
        return Neighbours(len(neighbours), toEnliven)

    def status(self):
        print(self.livingCells)
        if (self.config.dimension == 2):
            for y in range(0,99):
                str = ""
                for x in range(0,99):
                    if ([x, y] in self.livingCells):
                        str += "#"
                    else:
                        str += "."
                print(str)
        print("{} Generation".format(self.gen))
        print("{} alive".format(len(self.livingCells)))
        print("")
