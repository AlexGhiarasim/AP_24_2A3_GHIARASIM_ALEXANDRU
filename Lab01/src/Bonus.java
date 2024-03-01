/**
 *
 * @author Ghiarasim Alexandru
 */

public class Bonus {
    public static void main(String[] args) {
        int n = 5; //nr of vertices
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n-2; i++) {  //connect vertices in a cycle
            matrix[i][i + 1] = 1;
            matrix[i + 1][i] = 1;
        }
        matrix[0][n - 2] = 1; //connect the end of the list with the first node
        matrix[n - 2][0] = 1; //

        for (int i = 0; i < n - 1; i++)
        {
            matrix[i][n - 1] = 1;
            matrix[n - 1][i] = 1;
        }
        System.out.print("The adjacency matrix for a wheel-graph with n = " + n + " is: \n");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }

        int nrOfCycles = 0;
        for(int i = 0; i < n - 1; i++)
        {
            nrOfCycles += n - 2; // number of cycles starting with all the vertices from 0 to n-2. Position n-1 is for the last node.
        }
        nrOfCycles += 1; // the outer cycle

        if(nrOfCycles == (n*n - 3*n + 3))
            System.out.println("Number of cycles is equal with n^2 - 3n + 3!");
        else
            System.out.println("Not equal!");
    }
}
