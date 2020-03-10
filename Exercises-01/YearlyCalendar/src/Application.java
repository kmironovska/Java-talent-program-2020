import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String[] daysInYear;
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        if (year % 4 == 0) {
            daysInYear = new String[366];
        } else {
            daysInYear = new String[365];
        }

        int index=0;

            for(int i=1;i<=12;i++){
                switch (i){
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        for(int j=1;j<=30;j++){
                            daysInYear[index]= String.valueOf(year) + "-" + String.valueOf(String.format("%02d", i)) + "-" + String.valueOf(String.format("%02d", j));
                            index++;
                        }
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        for(int j=1;j<=31;j++){
                            daysInYear[index]= String.valueOf(year) + "-" + String.valueOf(String.format("%02d", i)) + "-" + String.valueOf(String.format("%02d", j));
                            index++;
                        }
                        break;
                    case 2:
                        if ( ((year % 4 == 0) && !(year % 100 == 0))
                                || (year % 400 == 0) )
                            for(int j=1;j<=29;j++){

                                daysInYear[index]= String.valueOf(year) + "-" + String.valueOf(String.format("%02d", i)) + "-" + String.valueOf(String.format("%02d", j));
                                index++;
                            }
                        else
                            for(int j=1;j<=28;j++){

                                daysInYear[index]= String.valueOf(year) + "-" + String.valueOf(String.format("%02d", i)) + "-" + String.valueOf(String.format("%02d", j));
                                index++;
                            }
                        break;

                }
            }
        for (String date : daysInYear) {
            System.out.println(date);
        }



    }
}
