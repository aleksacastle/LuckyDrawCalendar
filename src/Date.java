import sun.util.BuddhistCalendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Oleksandra on 07.03.2017.
 */
public class Date {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        //get start date
        System.out.println("Please enter start date year in format XXXX");
        int startYear = Integer.parseInt(reader.readLine());
        System.out.println("Please enter start date month in format XX(starting from 0)");
        int startMonth = Integer.parseInt(reader.readLine());
        System.out.println("Please enter start date day in format XX");
        int startDay = Integer.parseInt(reader.readLine());

        //set start date
        startDate.set(startYear,startMonth,startDay, 0, 0,0);

        //get end date
        System.out.println("Please enter end date year in format XXXX");
        int endYear = Integer.parseInt(reader.readLine());
        System.out.println("Please enter end date month in format XX(starting from 0)");
        int endMonth = Integer.parseInt(reader.readLine());
        System.out.println("Please enter start date day in format XX");
        int endDay = Integer.parseInt(reader.readLine());

        //set end date
        endDate.set(endYear,endMonth,endDay, 24, 0,0);

        //calculate total milliseconds of Lucky Draw
        long durationTotal = endDate.getTimeInMillis() - startDate.getTimeInMillis();

        //get time left until lucky draw
        System.out.println("Please enter day left in format XX");
        int dayLeft = Integer.parseInt(reader.readLine());
        System.out.println("Please enter hours left in format XX");
        int hoursLeft = Integer.parseInt(reader.readLine());
        System.out.println("Please enter minutes left in format XX");
        int minutesLeft = Integer.parseInt(reader.readLine());
        System.out.println("Please enter seconds left in format XX");
        int secondsLeft = Integer.parseInt(reader.readLine());

        //calculate current time
        endDate.add(Calendar.DAY_OF_MONTH,-dayLeft);
        endDate.add(Calendar.HOUR_OF_DAY, -hoursLeft);
        endDate.add(Calendar.MINUTE,-minutesLeft);
        endDate.add(Calendar.SECOND,-secondsLeft);

        //calculate duration pass
        long durationPass = endDate.getTimeInMillis() - startDate.getTimeInMillis();

        //enter number of replies on current time
        System.out.println("Please enter number of replies");
        int numberReply = Integer.parseInt(reader.readLine());

        //extrapolate
       int repliesAll = (int)extrapolate(durationTotal, durationPass, numberReply);

       //get winning percent
        ArrayList<Integer> listPercent = new ArrayList<>();
        System.out.println("Please enter winning percent");
        int percent;
        do{
             percent = Integer.parseInt(reader.readLine());
            listPercent.add(percent);
        }
        while (percent!=0);



       //check winning numbers
        ArrayList<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < listPercent.size();i++){
            listNumber.add((listPercent.get(i)*repliesAll)/100);
        }

        //print winning numbers
        for(int k = 0; k<listNumber.size();k++){
            System.out.println(listNumber.get(k));
        }

        //check
//        System.out.println(startDate.getTime());
//        System.out.println(endDate.getTime());
//        System.out.println(durationTotal);
//        System.out.println(durationPass);
    }
    public static long extrapolate(long total, long pass, int reply){
        long repliesAll = (total*reply)/pass;
        System.out.println(repliesAll) ;
        return repliesAll;
    }
}
