package biweekly87;

public class CountDaysSpentTogether {

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] numDays = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //num days in each month

        int ans = 1;
        String arrival, departure;
        arrival  = (arriveAlice.compareTo(arriveBob)<0) ? arriveBob : arriveAlice;
        departure = (leaveAlice.compareTo(leaveBob)<0) ? leaveAlice : leaveBob;

        if(arrival.compareTo(departure)>0){
            return 0;
        }
        int arriveMonth = Integer.valueOf(arrival.split("-")[0]);
        int aarriveDate = Integer.valueOf(arrival.split("-")[1]);
        int leaveMonth = Integer.valueOf(departure.split("-")[0]);
        int leaveDate = Integer.valueOf(departure.split("-")[1]);

        for(int i = arriveMonth + 1;i<leaveMonth;i++){
            ans += numDays[i];
        }

        if(arriveMonth==leaveMonth){
            ans += leaveDate - aarriveDate;
        }else{
            ans += numDays[arriveMonth] - aarriveDate;
            ans += leaveDate;
        }

        return ans;
    }

    public static void main(String[] args) {
        String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";
        System.out.print(countDaysTogether(arriveAlice,leaveAlice,arriveBob,leaveBob)+" ");
        arriveAlice = "10-01";
        leaveAlice = "10-31";
        arriveBob = "11-01";
        leaveBob = "12-31";

        System.out.print(countDaysTogether(arriveAlice,leaveAlice,arriveBob,leaveBob));
    }
}
