package biweekly87;

import java.util.Arrays;

public class MaximumMatchingPlayersAndTrainers {

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0;
        int j=0;
        int output = 0;
        while(i<players.length && j<trainers.length){
            if(players[i]>trainers[j]){
                j++;
            }else{
                output++;
                i++;
                j++;
            }

        }
        return output;
    }

    public static void main(String[] args) {
        int [] players = {4,7,9};
        int[] trainers = {8,2,5,8};
        System.out.print(matchPlayersAndTrainers(players,trainers)+" ");

        int[] players1 = {1,1,1};
        int[] trainers1 = {10};
        System.out.print(matchPlayersAndTrainers(players1,trainers1));
    }
}
