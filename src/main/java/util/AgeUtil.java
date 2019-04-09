package util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 年龄工具类
 * JokerYG
 * Date: 2019-04-09
 * Time: 14:31
 */
public class AgeUtil {

    /**
     * 根据生日计算年龄(只有岁数)
     *
     * @param birthDay 生日
     * @return 年龄(岁数)
     */
    public static int getAgeByBirth(Date birthDay) {
        int age = 0;
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            return -1;
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    //当前日期在生日之前，年龄减一
                    age--;
                }
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }


    /**
     * 根据生日计算年龄(岁数+月数)
     *
     * @param birthDay 生日
     * @return 年龄(岁数 + 月数)
     */
    public static String getAgeAndMonthByBirth(Date birthDay) {
        int age = 0;
        int month = 0;
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            return null;
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    //当前日期在生日之前，年龄减一
                    age--;
                    month = 11;
                }
            } else {
                age--;//当前月份在生日之前，年龄减一
                month = monthNow + 12 - monthBirth;
                if (dayOfMonthNow < dayOfMonthBirth) {
                    month--;
                }
            }
        } else {
            month = monthNow - monthBirth;
            if (dayOfMonthNow < dayOfMonthBirth) {
                month--;
            }
        }
        String result = age+"岁";
        if(month > 0){
            result+=month+"个月";
        }
        return result;
    }
}
