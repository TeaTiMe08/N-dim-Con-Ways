class GameConfig:

    def __init__(self):
        self.dimension = 2
        self.El = 2
        self.Eu = 3
        self.Fl = 3
        self.Fu = 3
        
class SpawnConfig:

    @staticmethod
    def Block(other=None):
        return SpawnConfig({(1, 1), (1, 2), (2, 1), (2, 2)}, other)
    @staticmethod
    def Blinker(other=None):
        return SpawnConfig({(5, 2), (5, 1), (5, 3)}, other)
    @staticmethod
    def Tub(other=None):
        return SpawnConfig({(9, 2), (10, 1), (10, 3), (11, 2)}, other)

    @staticmethod
    def All():
        return SpawnConfig.Block(SpawnConfig.Tub(SpawnConfig.Blinker()))

    def __init__(self, initSet=None, other=None):
        self.initSet = initSet
        if other is not None:
            self.initSet.update(other.initSet)
        self.initSpawnRate = 0.3
        self.initSpawnDistance = 5
        self.initTotal = 300#0.5 * pow(self.initSpawnDistance, 2)
