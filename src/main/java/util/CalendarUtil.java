package util;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具
 * JokerYG
 * Date: 2019-04-10
 * Time: 16:41
 */
public class CalendarUtil {

    /**
     * 获得日期所在周的所有日期（周一到周日）
     * @param date
     * @return
     */
    public static List<Date> getWeekDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        Date begin = cal.getTime();
        // System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        Date end = cal.getTime();
        // System.out.println("所在周星期日的日期：" + imptimeEnd);
        return findDates(begin,end);
    }


    /**
     * 获得两个日期之间的所有日期
     */
    public static List<Date> findDates(Date begin, Date end)
    {
        List lDate = new ArrayList();
        lDate.add(begin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(begin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(end);
        // 测试此日期是否在指定日期之后
        while (end.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    /**
     * 以一个时间为基础设置时间，字段为空则不改变
     * @param date 要设置的时间,不能为空
     * @param year 年份,为空则不变
     * @param month 月份(1-12),为空则不变
     * @param day 天,为空则不变
     * @param hour 小时(0-23),为空则不变
     * @param minute 分钟(0-59),为空则不变
     * @param second 秒,为空则不变
     * @param millisecond 毫秒,为空则不变
     */
    public static void setDate(Calendar date, Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second, Integer millisecond){
        if(date == null){
            return;
        }
        if(year != null){
            date.set(Calendar.YEAR,year);
        }
        if(month != null){
            date.set(Calendar.MONTH,month-1);
        }
        if(day != null){
            date.set(Calendar.DAY_OF_MONTH,day);
        }
        if(hour != null){
            date.set(Calendar.HOUR_OF_DAY,hour);
        }
        if(minute != null){
            date.set(Calendar.MINUTE,minute);
        }
        if(second != null){
            date.set(Calendar.SECOND,second);
        }
        if(millisecond != null){
            date.set(Calendar.MILLISECOND,millisecond);
        }

    }

    /**
     * 将source上指定的时间段克隆到target相应时间段上
     * @param source 源,不能为空
     * @param target 目标，不能为空
     * @param year 是否克隆年份
     * @param month 是否克隆月份
     * @param day 是否克隆天
     * @param hour 是否克隆小时
     * @param minute 是否克隆分钟
     * @param second 是否克隆秒
     * @param millisecond 是否克隆毫秒
     */
    public static void cloneDate(Calendar source,Calendar target,boolean year,boolean month,boolean day, boolean hour, boolean minute, boolean second, boolean millisecond){
        if(source == null || target == null){
            return;
        }
        if(year){
            target.set(Calendar.YEAR,source.get(Calendar.YEAR));
        }
        if(month){
            target.set(Calendar.MONTH,source.get(Calendar.MONTH));
        }
        if(day){
            target.set(Calendar.DAY_OF_MONTH,source.get(Calendar.DAY_OF_MONTH));
        }
        if(hour){
            target.set(Calendar.HOUR_OF_DAY,source.get(Calendar.HOUR_OF_DAY));
        }
        if(minute){
            target.set(Calendar.MINUTE,source.get(Calendar.MINUTE));
        }
        if(second){
            target.set(Calendar.SECOND,source.get(Calendar.SECOND));
        }
        if(millisecond){
            target.set(Calendar.MILLISECOND,source.get(Calendar.MILLISECOND));
        }
    }
}
