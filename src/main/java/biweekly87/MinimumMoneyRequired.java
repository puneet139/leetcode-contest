package biweekly87;

public class MinimumMoneyRequired {

    public static long minimumMoney(int[][] transactions) {
        long sum = 0L;
        //step 1. compute sum for transactions where cost > cashback
        for(int[] t : transactions) {
            if(t[0] > t[1]) {
                sum += t[0] - t[1]; // add cost and remove cashback
            }
        }
        //step 2. if cost > cashback, add the cashBack again which we removed  in step 1.
        //else add max cost from remaining transactions
        long max = 0;
        for(int[] t : transactions) {
            max = t[0] > t[1]? Math.max(max, sum + t[1]): Math.max(max, sum + t[0]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] transactions = {{2,1},{5,0},{4,2}};
        System.out.print(minimumMoney(transactions)+" ");

        int[][] transactions1 = {{3,0},{0,3}};
        System.out.print(minimumMoney(transactions1)+" ");
    }
}
