package Raceevents.Racingpost;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckFutureDate {

    public static void main(String[] args)
    {
        System.out.print("Enter Date - Dividend\n");
        Scanner a = new Scanner(System.in);
        String c = a.next();
        System.out.println("date:" +c);
        try {
            System.out.print(new CheckFutureDate().checkGivenDate(c));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private boolean checkGivenDate(String givenDate) throws ParseException {
        boolean futureDate=false;
        //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        //30 Jul 21
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        Date enteredDate = sdf.parse(givenDate);
        Date currentDate = new Date();
        System.out.println("entered date: " +enteredDate);
        System.out.println("Current date: " +currentDate);
        if(enteredDate.after(currentDate)) {
            futureDate= true;
        }

        return futureDate;
    }






}






