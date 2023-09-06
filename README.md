# N-dim-Con-Ways Project

## Introduction
The goal of the project is to create an n-dimensional simulation of the well-known Conways Game of life(GoL). With this simulation it will be tested, which rules do apply good for a specific rule combination. Based on the evaluation of the applied rules on different dimensions, we try generalization methods for possible good rules.
The simulation should be fast enough to simulate some rules up to 10th dimension.

## Background
The simulation should support testing with multiple rulsets. The ruleset is furthermore based on the definition of Carter Bays publication “Candidates for the Game of Life in Three Dimensions”.
The GoL describes, if a cell is alive or dead and a ruleset of the cells, if a position on the gameboard is a living cell or dead cell in the next round of calculation. - Cellular Automata -

For mor information on the topis, research will be displayed in the sub directory

## Problems

1. Make Simulation fast enough
1.1 Optimize Vector data structure for optimizing the search for nearest neighbour
1.2 Optimize multithreaded search for nodes
1.3 Optmize Space of Vector
2. Visual Interface for Testing
3. Find a good evaluation function which judges/scores a future generation for successful ruleset.