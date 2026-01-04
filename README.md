Below is a clear, exam-ready description of your PuzzleSwing (8Puzzle) Java Swing program. You can use this directly in project reports, viva, or lab records.
📘 Description: 8-Puzzle Game using Java Swing
This program implements the classic 8-Puzzle Game using Java Swing.
The game consists of a 3×3 grid containing 8 numbered tiles and one blank space. The objective is to arrange the tiles in ascending order (1–8) with the blank space at the last position.

🎯 Objective of the Program
To create an interactive GUI-based puzzle game
To demonstrate event-driven programming using Java Swing
To allow users to solve the puzzle using mouse clicks
To track the number of moves taken to solve the puzzle

🧩 How the Game Works
The puzzle is randomly shuffled at the start.
One tile is always kept blank (0).
The player can click any tile adjacent to the blank space.
The clicked tile swaps its position with the blank space.
Each valid move increments the move counter.
When the tiles are arranged correctly, a success dialog is displayed.

🛠️ Technologies & Components Used
Java Swing GUI Components
JFrame – Main window
JPanel – Grid container
JButton – Puzzle tiles
JLabel – Move counter
Layout Managers
BorderLayout
GridLayout
Event Handling
Lambda-based ActionListener
Core Java Concepts
2D Arrays
Random number generation
Conditional logic

⚙️ Key Methods Explanation
genPuzzle()
Generates and initializes the puzzle with random numbers.
shuffle()
Randomly shuffles the numbers using the Fisher-Yates algorithm.
moveTile()
Checks whether the clicked tile is adjacent to the blank space and swaps them.
updateBoard()
Updates button labels and enables/disables the blank tile.

isSolved()
Verifies whether the puzzle is in the correct solved state.
