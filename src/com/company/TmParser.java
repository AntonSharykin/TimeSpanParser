package com.company;

public class TmParser {

    public static long convertToMilliseconds(String timespan){
        String[] timespanArr = timespan.split(" ");
        long tSpan=0;
        for (String pDate: timespanArr){
            char c = pDate.charAt(pDate.length()-1);
            pDate = pDate.replace(pDate.substring(pDate.length()-1),"");
            System.out.println(c);
            switch (c){
               case 'w':
                   tSpan+=(Long.parseLong(pDate)*86400000)*7;
                   break;
               case 'd':
                    tSpan+=(Long.parseLong(pDate)*86400000);
                    break;

                case 'h':
                    tSpan+=(Long.parseLong(pDate)*3600000);
                    break;

                case 'm':
                    tSpan+=(Long.parseLong(pDate)*60000);
                    break;

                case 's':
                    tSpan+=(Long.parseLong(pDate)*1000);
                    break;

                default: break;
            }
        }

        return tSpan;

    }
}
