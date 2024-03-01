/**
 *
 * @author Ghiarasim Alexandru
 */

public class Homework {
    private static Boolean isKReductible(int nr, int k)
    {
        int sum;
        while(nr > 9)
        {
            sum = 0;
            while(nr > 0) {
                sum = sum + (nr % 10) * (nr % 10);
                nr = nr / 10;
            }
            nr = sum;
        }
        return nr == k;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        if (args.length != 3)
        {
            System.out.println("Number of parameters incorrect!");
            System.exit(-1);
        }
        int a=0,b=0,k=0;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
        if(a > b)
        {
            System.out.println("a > b - interval incorrect!");
            System.exit(-1);
        }
        if(k < 0 || k > 9)
        {
            System.out.println("k is not in [0,9]");
            System.exit(-1);
        }
        StringBuilder numbers = new StringBuilder();
        for(int i = a; i <= b; i++)
        {
            if(isKReductible(i,k))
            {
                numbers.append(i);
                numbers.append(" ");
            }
        }
        System.out.println("Numbers " + k +"-reductible : " + numbers);
        long end = System.currentTimeMillis();
        long elapsedTime = end - start; 
        System.out.println("Running time in miliseconds is: " + elapsedTime);
    }
}
