# N-dim-Con-Ways Project

## Introduction
The goal of the project is to create an n-dimensional simulation of the well-known Conways Game of life(GoL). With this simulation it will be tested, which rules do apply good for a specific rule combination. Based on the evaluation of the applied rules on different dimensions, we try generalization methods for possible good rules.
The simulation should be fast enough to simulate some rules up to 10th dimension.

## Background
The simulation should support testing with multiple rulsets. The ruleset is furthermore based on the definition of Carter Bays publication “Candidates for the Game of Life in Three Dimensions”.
The GoL describes, if a cell is alive or dead and a ruleset of the cells, if a position on the gameboard is a living cell or dead cell in the next round of calculation. - Cellular Automata -

## Implementation in Java
For finding shapes tha "hard way" by an optimized brute force search across different configurations and state, a Java application was developed.
It supports different Configurations for a rule-set. Natively Conways Configuration.
![Screenshot 2024-03-29 103234](https://github.com/TeaTiMe08/N-dim-Con-Ways/assets/19726327/7f05ac70-40ac-44dd-b922-761b4f897a8f)
The following condigufations are supported:
- N-dimentional calculus of the ruleset for Conways
- Simple GUI for displaying the n-dim process
- ShapesDetector for finding stable shapes in n-th dimension using graph isomorphisms to avoid distingulishing rotated states 

## Shapes found
# 2D Shapes
<input style="width:100%" type="text" value="[-6, -3], [-5, -2], [-7, -4], [-7, -2], [-6, -1], [-8, -3]">

# 3D Shapes

# 4D Shapes
