// You are given an m x n grid grid where:
// '.' is an empty cell.
// '#' is a wall.
// '@' is the starting point.
// Lowercase letters represent keys.
// Uppercase letters represent locks.
// You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.
// If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
// For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
// Return the lowest number of moves to acquire all keys. If it is impossible, return -1.

// Example 1:
// Input: grid = ["@.a..","###.#","b.A.B"]
// Output: 8
// Explanation: Note that the goal is to obtain all the keys not to open all the locks.

// Example 2:
// Input: grid = ["@..aA","..B#.","....b"]
// Output: 6

// Example 3:
// Input: grid = ["@Aa"]
// Output: -1
 
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 30
// grid[i][j] is either an English letter, '.', '#', or '@'. 
// There is exactly one '@' in the grid.
// The number of keys in the grid is in the range [1, 6].
// Each key in the grid is unique.
// Each key in the grid has a matching lock.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static boolean withinBoundary(int i, int j, int R, int C){
        return (i >= 0 && i < R && j >= 0 && j < C);
    }

    public int shortestPathAllKeys(String[] grid) {
        int R = grid.length, C = grid[0].length();
        char[][] mat = new char[R][C];

        for(int i=0; i<R; i++)
            mat[i] = grid[i].toCharArray();
        
        int total_keys = 0;
        int row = 0, col = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(mat[i][j] >= 'a' && mat[i][j] <= 'z')
                    total_keys++;
                else if(mat[i][j] == '@'){
                    row = i;
                    col = j;
                }    
            }
        }
        
        int goal_keys = (1 << total_keys) - 1;

        Set<State> set = new HashSet<>(); // keep track of visited
        Queue<State> queue = new LinkedList<>();    // order of traversal

        queue.offer(new State(row, col, 0, 0));    // statring point
        set.add(new State(row, col, 0, 0));    //record initial state

        while(!queue.isEmpty()){
            State current = queue.poll();

            for(int i=0; i<dirs.length; i++){
                int nextR = current.row + dirs[i][0];
                int nextC = current.col + dirs[i][1];

                if((!withinBoundary(nextR, nextC, R, C)) || mat[nextR][nextC] == '#') // handle next state is wall or out of bounds
                    continue;

                State nextState = new State(nextR, nextC, current.keys, current.moves + 1);
                char idx = mat[nextR][nextC];

                if(idx >= 'a' && idx <= 'z'){
                    int val = idx - 'a';
                    nextState.keys |= (1 << val);

                    if((goal_keys & nextState.keys) == goal_keys){
                        return current.moves + 1;
                    }
                }    
                else if(idx >= 'A' && idx <= 'Z'){
                    int key = idx - 'A';
                    
                    if((current.keys & (1 << key)) == 0)
                        continue;
                }
                
                nextState.row = nextR;
                nextState.col = nextC;

                if(set.contains(nextState))
                    continue;

                set.add(nextState);
                queue.offer(nextState);    
                
            }
        }

        return -1;


        
    }
}

class State{
    int row;
    int col;
    int keys;
    int moves;

    State(int row, int col, int keys, int moves){
        this.row = row;
        this.col = col;
        this.keys = keys;
        this.moves = moves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State other = (State) o;
        return this.row == other.row && this.col == other.col && this.keys == other.keys;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, keys);
    }
}