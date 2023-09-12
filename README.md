# N-dim-Con-Ways Project

## Introduction
The goal of the project is to create an n-dimensional simulation of the well-known Conways Game of life(GoL). With this simulation it will be tested, which rules do apply good for a specific rule combination. Based on the evaluation of the applied rules on different dimensions, we try generalization methods for possible good rules.
The simulation should be fast enough to simulate some rules up to 10th dimension.

## Background
The simulation should support testing with multiple rulsets. The ruleset is furthermore based on the definition of Carter Bays publication “Candidates for the Game of Life in Three Dimensions”.
The GoL describes, if a cell is alive or dead and a ruleset of the cells, if a position on the gameboard is a living cell or dead cell in the next round of calculation. - Cellular Automata -

For mor information on the topis, research will be displayed in the sub directory

## Shapes found
# 2D Shapes
<input style="width:100%" type="text" value="">
[0, 4, 2], [0, 4, 3], [0, 3, 2], [0, 3, 3]
[3, 1, -6], [4, 1, -6], [3, -1, -6], [4, -1, -6], [3, -2, -6], [4, -2, -6]
[2, 5, 4], [1, 4, 4], [2, 4, 4], [-1, 5, 4], [-2, 4, 4], [-1, 4, 4], [1, 5, 4]
[-4, 2, -6], [-4, 1, -6], [-3, 2, -6], [-3, 1, -6], [-4, -1, -6], [-3, -1, -6]
[1, 0, 0], [2, 0, -1], [2, 0, 0], [-2, 0, -1], [-2, 0, 0], [-1, 0, -1], [-1, 0, 0], [1, 0, -1]
[-1, 3, -2, -2], [1, 3, -3, -2], [-2, 3, -3, -2], [-1, 3, -3, -2], [-2, 3, -2, -2], [2, 3, -3, -2], [-2, 3, 3, -2], [-1, 3, 2, -2], [2, 3, -2, -2], [1, 3, -2, -2], [-1, 3, 3, -2], [-2, 3, 2, -2], [1, 3, 3, -2], [2, 3, 2, -2], [1, 3, 2, -2], [2, 3, 3, -2]
[-2, -3, -3, -2], [-2, -3, -2, -2], [-1, -3, -3, -2], [1, -3, -3, -2], [-2, -3, 2, -2], [-1, -3, -2, -2], [2, -3, -2, -2], [1, -3, -2, -2], [2, -3, -3, -2], [-1, -3, 2, -2], [-2, -3, 3, -2], [1, -3, 3, -2], [2, -3, 2, -2], [1, -3, 2, -2], [-1, -3, 3, -2], [2, -3, 3, -2]

# 3D Shapes
<input style="width:100%" type="text" value="[-2, 2, -1], [-1, 2, -1], [-2, 1, -1], [-2, 2, 1], [-1, 1, -1], [-1, 2, 1], [-2, 1, 1], [-1, 1, 1]">
<input style="width:100%" type="text" value="[-4, 5, -6], [-3, 5, -6], [-4, 5, -5], [-4, 3, -6], [-3, 5, -5], [-3, 3, -6], [-4, 3, -5], [-3, 3, -5]">
After random reflection was implemented
<input style="width:100%" type="text" value="[2, -1, -2], [2, -2, -3], [2, -2, -2], [-2, -1, -3], [-2, -2, -3], [-2, -1, -2], [0, 1, -2], [-2, -2, -2], [0, 0, -2], [0, 1, -1], [0, 0, -1], [2, -1, -3]">
<input style="width:100%" type="text" value="[-2, 2, 1, 1], [-2, 1, 0, 1], [-2, 1, 1, 1], [-2, 2, 0, 1], [-2, -2, 1, 1], [2, 2, 0, 1], [-2, -1, 0, 1], [2, 2, 1, 1], [2, 1, 0, 1], [-2, -1, 1, 1], [-2, -2, 0, 1], [2, 1, 1, 1], [2, -1, 1, 1], [2, -2, 0, 1], [2, -1, 0, 1], [2, -2, 1, 1]">
