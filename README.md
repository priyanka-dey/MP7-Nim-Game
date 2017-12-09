# MP7-Nim-Game

Nim: Basic Math Game

How to play the game:
There are two players: the human and the computer bot. Each player takes turns taking a certain number of objects from each heap. In this version, there are 3 heaps and each heap consists of 1 to 10 objects. The last player to take at least one object from a single heap is the winner.

Computer Alogrithm:
The basic algorithm is based on x-or sums (nim sums). The goal of the game is to end a turn with a nim sum of zero. Basically, the nim sum of all of the heaps (X) must be calculated at the beginning of each round. Then, the nim sum of X and each heap size is calculated. If this sum is less than the heap size, the heap size must be reduced to the sum. This ensures that the nim sum of all the heaps (X) will be reduced to 0. Once the other player receives a set of heaps with nim sum equal to 0, regardless of which move he/she makes, he will lose assuming the other player does not make a mistake.
