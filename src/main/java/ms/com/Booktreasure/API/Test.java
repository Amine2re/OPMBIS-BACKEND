package ms.com.Booktreasure.API;

import java.time.LocalDate;
import java.util.HashMap;

public class Test {


    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020,05,12);
        HashMap hash = new HashMap();
        hash.put("1",date);

        date.compareTo(date);


        //System.out.println(hash.get("1"));
        //date = (LocalDate) hash.get("1");
     //   System.out.println(date.plusDays(1));

        System.out.println(date.getMonthValue());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());

    }
}
