package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date d = sdf.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);

            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            return days[dayOfWeek - 1]; // Calendar.DAY_OF_WEEKは1 (Sunday) から 7 (Saturday)
        } catch (ParseException e) {
            return "Invalid date format. Please use yyyymmdd.";
        }
    }
    //足し算
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 + val2;
        return String.valueOf(result);
    }

    //引き算
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 - val2;
        return String.valueOf(result);
    }

    //掛け算
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 * val2;
        return String.valueOf(result);
    }

    //割り算
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        if (val2 == 0) {
            return "Division by zero is not allowed.";
        }
        int result = val1 / val2;
        return String.valueOf(result);
    }
}
