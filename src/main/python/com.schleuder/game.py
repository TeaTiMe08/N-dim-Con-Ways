from gameconfig import GameConfig
from gameconfig import SpawnConfig
from neighbours import Neighbours
from random import *
import math



class Game:
    livingCells = set
    gen = 0

    def __init__(self, gameConfig = GameConfig(), spawnConfig = SpawnConfig()):
        self.config = gameConfig
        self.spawn = spawnConfig
        self.livingCells = set()
        self.gen = 0
        self.initialize()

    def initialize(self):
        if (self.spawn.initSet != None):
            self.livingCells = self.spawn.initSet
        else:
            for x in range(1, int(self.spawn.initTotal)):
                point = [None for _ in range(self.config.dimension)]
                for dim in range(0, self.config.dimension):
                  point[dim] = self.spawn.initSpawnDistance + randint(-self.spawn.initSpawnDistance, self.spawn.initSpawnDistance)
                self.livingCells.add(tuple(point))

    def next(self):
        # kill
        next = set()
        potentials = set()
        for cell in self.livingCells:
            n = self.neighbours(cell, True)
            potentials.update(n.toEnliven)
            if self.ruleE(n.number):
                next.add(cell)

        for pot in potentials:
            n = self.neighbours(pot)
            if self.ruleF(n.number):
                next.add(pot)
        self.livingCells = next
        return self.livingCells
    
    def ruleE(self, numberNeighbors):
        return (self.config.El <= numberNeighbors <= self.config.Eu)
    
    def ruleF(self, numberNeighbors):
        return (self.config.Fl <= numberNeighbors <= self.config.Fu)

    def neighbours(self, cell, potentials=False):
        neighbours = []
        toEnliven = set()
        for j in self.livingCells:
            if cell == j:
                continue
            dist = 0
            distVec = [None for _ in range(self.config.dimension)]
            for dim in range(0, self.config.dimension):
                distVec[dim] = cell[dim] - j[dim]
                dist += pow(distVec[dim], 2)
            dist = math.sqrt(dist)
            staticDistOneNodes = set()
            for dim in range(0, self.config.dimension):
                plus = list(cell)
                minus = plus.copy()
                plus[dim] = plus[dim] + 1
                minus[dim] = minus[dim] - 1
                plus = tuple(plus)
                minus = tuple(minus)
                if (plus not in self.livingCells):
                    staticDistOneNodes.add(plus)
                if (minus not in self.livingCells):
                    staticDistOneNodes.add(minus)
            toEnliven.update(staticDistOneNodes)
            if (dist <= math.sqrt(self.config.dimension)):
                neighbours.append(j)
            elif (potentials and dist <= self.config.dimension * 2 and max(max(distVec), abs(min(distVec))) <= 2):
                    permutRounding = set()
                    for dim in range(0, self.config.dimension):
                        v1 = j[dim] + math.floor(distVec[dim] / 2.0)
                        v2 = j[dim] + math.ceil(distVec[dim] / 2.0)
                        # calculate permutations for ceil/floor (mostly important for higher-dimentional stuff)
                        if (len(permutRounding) == 0):
                            permutRounding.add(tuple([v1]))
                            permutRounding.add(tuple([v2]))
                        else:
                            newPermuts = set()
                            for teilv in permutRounding:
                                if (v1 != v2):
                                    newPermuts.add(teilv + tuple([v1]))
                                newPermuts.add(teilv + tuple([v2]))
                            permutRounding = newPermuts
                    toEnliven.update(permutRounding)
        return Neighbours(len(neighbours), toEnliven)

    def status(self, size = 30, printField = False):
        print(self.livingCells)
        if (self.config.dimension == 2 and printField):
            for y in range(size, 0, -1):
                str = ""
                for x in range(0, size):
                    if ((x, y) in self.livingCells):
                        str += "#"
                    else:
                        str += "."
                print(str)
        print("{} Generation".format(self.gen))
        print("{} alive".format(len(self.livingCells)))
        print("")
