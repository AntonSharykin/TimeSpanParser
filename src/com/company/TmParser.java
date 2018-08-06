package com.company;

import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TmParser {
    private static final long TIMESPAN_WEEK=604800000;
    private static final long TIMESPAN_DAY=86400000;
    private static final long TIMESPAN_HOUR=3600000;
    private static final long TIMESPAN_MINUTE=60000;
    private static final long TIMESPAN_SECOND=1000;
    private static Logger logger = LogManager.getLogManager().getLogger(TmParser.class.getName());



    public static long convertToMilliseconds(String timespan) throws IllegalArgumentException{
        long longDate;
        timespan=timespan.toLowerCase();
        Objects.requireNonNull(timespan, "timespan can't be null");
        String[] timespanArray = timespan.split("\\s");
        long tSpan=0;
        for (String pDate: timespanArray){
            char c = pDate.charAt(pDate.length()-1);
            pDate = pDate.replace(pDate.substring(pDate.length()-1),"");


            switch (c){
               case 'w':
                   longDate=Long.parseLong(pDate);
                   tSpan+=longDate*TIMESPAN_WEEK;
                   break;
               case 'd':
                   longDate=Long.parseLong(pDate);
                   tSpan+=longDate*TIMESPAN_DAY;
                   break;
                case 'h':
                    longDate=Long.parseLong(pDate);
                    tSpan+=longDate*TIMESPAN_HOUR;
                    break;

                case 'm':
                    longDate=Long.parseLong(pDate);
                    tSpan+=longDate*TIMESPAN_MINUTE;
                    break;

                case 's':
                    longDate=Long.parseLong(pDate);
                    tSpan+=longDate*TIMESPAN_SECOND;
                    break;

                default:
                    logger.warning("Please check your timespan " + timespan);
                    throw new IllegalArgumentException();

            }
        }

        return tSpan;

    }
}
