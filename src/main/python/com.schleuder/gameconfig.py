class GameConfig:

    def __init__(self):
        self.dimension = 2
        self.El = 2
        self.Eu = 3
        self.Fl = 3
        self.Fu = 3
        
class SpawnConfig:

    def __init__(self):
        self.initSpawnRate = 0.3
        self.initSpawnDistance = 50
        self.initTotal = 0.5 * pow(self.initSpawnDistance, 2)
