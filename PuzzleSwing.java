import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PuzzleSwing extends JFrame {

    int[][] board = new int[3][3];
    JButton[][] buttons = new JButton[3][3];
    int blankRow, blankCol, moves = 0;
    JLabel status = new JLabel("Moves: 0");

    public PuzzleSwing() {
        setTitle("8-Puzzle Game");
        setSize(400, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel grid = new JPanel(new GridLayout(3, 3));
        Font font = new Font("Arial", Font.BOLD, 32);

        genPuzzle();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                btn.setFont(font);
                buttons[i][j] = btn;
                grid.add(btn);

                int r = i, c = j;
                btn.addActionListener(e -> moveTile(r, c));
            }
        }

        updateBoard();

        status.setHorizontalAlignment(JLabel.CENTER);
        status.setFont(new Font("Arial", Font.BOLD, 16));

        add(grid, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

        setVisible(true);
    }

    void genPuzzle() {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) nums[i] = i;

        shuffle(nums);

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = nums[k++];
                if (board[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
            }
        }
    }

    void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    void moveTile(int r, int c) {
        if ((Math.abs(r - blankRow) + Math.abs(c - blankCol)) == 1) {
            swap(r, c, blankRow, blankCol);
            blankRow = r;
            blankCol = c;
            moves++;
            updateBoard();

            if (isSolved()) {
                JOptionPane.showMessageDialog(this,
                        "🎉 Puzzle Solved in " + moves + " moves!");
            }
        }
    }

    void swap(int r1, int c1, int r2, int c2) {
        int temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    void updateBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(false);
                } else {
                    buttons[i][j].setText(String.valueOf(board[i][j]));
                    buttons[i][j].setEnabled(true);
                }
            }
        }
        status.setText("Moves: " + moves);
    }

    boolean isSolved() {
        int expected = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2)
                    return board[i][j] == 0;
                if (board[i][j] != expected++)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new PuzzleSwing();
    }
}
