package com.hugh.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * @author hugh.liu
 * @date 2020-01-20
 * @Company: htah.com.cn
 */
public class DateUtil {

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final String YYYYMMDD = "yyyyMMdd";

	/**
	 * 获取当前系统日期
	 * @param format 日期格式
	 * @return 系统日期
	 */
	public static String getSysDate(String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 获取当前系统日期
	 * @return 系统日期
	 */
	public static String getSysDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 获取指定时间的 前（后）任意天数的时间
	 * @param specifiedDate 指定时间
	 * @param intDays 天数
	 * @return 时间
	 */
	public static Date addDays(Date specifiedDate, int intDays) {
		return addDate(specifiedDate, Calendar.DATE, intDays);
	}

	/** 
	 * 获取指定月的前一月（年）或后一月（年） 
	 * @param dateStr 
	 * @param addYear 
	 * @param addMonth 
	 * @param addDate 
	 * @return 输入的时期格式为yyyy-MM，输出的日期格式为yyyy-MM 
	 * @throws Exception 
	 */
	public static String getLastMonth(String dateStr, int addYear, int addMonth, int addDate) throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date sourceDate = sdf.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(sourceDate);
			cal.add(Calendar.YEAR, addYear);
			cal.add(Calendar.MONTH, addMonth);
			cal.add(Calendar.DATE, addDate);
			SimpleDateFormat returnSdf = new SimpleDateFormat("yyyy-MM");
			String dateTmp = returnSdf.format(cal.getTime());
			return dateTmp;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		String date = "2021-10-28";
		String afterDate = DateUtil.dateToString(DateUtil.addDays(DateUtil.stringToDate(date, DateUtil.YYYY_MM_DD), 1), DateUtil.YYYY_MM_DD) + " 08:00:00";
		System.out.println(afterDate);

		System.out.println(getLastMonth("2011-06", 0, 1, 0)+"-01 08:00:00");// 2011-05

	}

	/**
	 * 时间加小时（负数则减）
	 * @param specifiedDate 指定时间
	 * @param intHours 小时数
	 * @return 时间
	 */
	public static Date addHours(Date specifiedDate, int intHours) {
		return addDate(specifiedDate, Calendar.HOUR, intHours);
	}

	/**
	 * 时间加分钟（负数则减）
	 * @param specifiedDate 指定时间
	 * @param intMinutes 分钟数
	 * @return 时间
	 */
	public static Date addMinutes(Date specifiedDate, int intMinutes) {
		return addDate(specifiedDate, Calendar.MINUTE, intMinutes);
	}

	/**
	 * 增加时间
	 * @param specifiedDate 指定时间
	 * @param type 年、月、日、时、分、秒{1:年/2:月/3or4:可能是周/5:日}
	 * @param number 数
	 * @return
	 */
	public static Date addDate(Date specifiedDate, int type, int number) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(specifiedDate);
		calendar.add(type, number);
		return calendar.getTime();
	}

	/**
	 * 时间格式转换
	 * 
	 * @param date 时间字符串
	 * @param oldFormat 原始时间字符串格式
	 * @param newFormat 新时间字符串格式
	 * @return
	 * @throws Exception
	 */
	public static String changeDateFormat(String date, String oldFormat, String newFormat) throws Exception {
		SimpleDateFormat oldDateFormat = new SimpleDateFormat(oldFormat);
		SimpleDateFormat newDateFormat = new SimpleDateFormat(newFormat);
		Date dateTemp;
		try {
			dateTemp = oldDateFormat.parse(date);
		} catch (ParseException e) {
			throw new Exception("时间格式转换错误: " + date + " 不是[" + oldFormat + "]格式");
		}
		return newDateFormat.format(dateTemp);
	}

	/**
	 * String转date类型
	 * @param date 时间字符串
	 * @param format 时间字符串格式
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String date, String format) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.parse(date);
	}

	/**
	 * String转date类型
	 * @param date 时间字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return simpleDateFormat.parse(date);
	}

	/**
	 * date转String类型
	 * @param date 时间
	 * @param format 时间格式
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * date转String类型
	 * @param date 时间
	 * @return
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return simpleDateFormat.format(date);
	}

	/**
	 * 获取年
	 * @param date 时间
	 * @return
	 */
	public static int getYear(Date date) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取月
	 * @param date 时间
	 * @return
	 */
	public static int getMonth(Date date) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH);
	}

	/**
	 * 获取天
	 * @param date 时间
	 * @return
	 */
	public static int getDay(Date date) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获取时
	 * @param date 时间
	 * @return
	 */
	public static int getHour(Date date) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期的星期
	 * @param dates 字符串日期
	 * @return
	 */
	public static String getWeek(String dates) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = f.parse(dates);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		cal.setTime(d);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDays[w];
	}

	/**
	 * 获取两个日期之间的所有日期
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getBetweenDates(String startDate, String endDate) throws ParseException {
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);// 定义起始日期
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);// 定义结束日期
		return getBetweenDates(start, end);
	}

	/**
	 * 获取两个日期之间的所有日期
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getBetweenDates(Date startDate, Date endDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> result = new ArrayList<String>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(startDate);
		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(endDate);
		while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
			result.add(sdf.format(tempStart.getTime()));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		return result;
	}

	/**
	 * 获取字符串日期对应的天
	 * @param date
	 * @return
	 */
	public static int getDayOfDateStr(String dates) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = f.parse(dates);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		calendar.setTime(d);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获取两个时间相差的时间
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param type 类型
	 * @return
	 * @throws ParseException
	 */
	public static double getDateBetweenTowDays(Date startTime, Date endTime, String type) throws ParseException {
		long startTimes = startTime.getTime();
		long endTimes = endTime.getTime();
		long between = Math.abs(endTimes - startTimes);
		double num = 1000;
		// 相差天数 
		double day = between / (24 * 60 * 60 * num);
		if (type.equals("day"))
			return round(day, 3, BigDecimal.ROUND_HALF_UP);
		// 相差小时数 一共相差的毫秒数 - 天所占的毫秒数
		double hour = between / (60 * 60 * num);
		if (type.equals("hour"))
			return round(hour, 3, BigDecimal.ROUND_HALF_UP);
		// 相差分钟数 一共相差的毫秒数 - 天所占的毫秒数-小时所占的毫秒数
		double minute = between / (60 * num);
		if (type.equals("minute"))
			return round(minute, 3, BigDecimal.ROUND_HALF_UP);
		// 相差秒数
		return round(between / num, 3, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 精度位数(保留的小数位数)
	 * @param value
	 * @param scale
	 * @param roundingMode
	 * @return
	 */
	public static double round(double value, int scale, int roundingMode) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(scale, roundingMode);
		double d = bd.doubleValue();
		bd = null;
		return d;
	}

	/**
	 * 计算时间字符串对应的描述
	 * @param timeStr 时间字符串 hh:mm:ss
	 * @return
	 */
	public static int getTimeStrSeconds(String timeStr) {
		String[] strings = timeStr.split(":");
		return Integer.valueOf(strings[0]) * 3600 + Integer.valueOf(strings[1]) * 60 + Integer.valueOf(strings[2]);
	}

	/**
	 * 小时转秒
	 * @param hour 小时
	 * @return
	 */
	public static BigDecimal hourToSecond(BigDecimal hour) {
		return hour.multiply(new BigDecimal(60)).multiply(new BigDecimal(60));
	}

	/**
	 * 秒转小时
	 * @param second 秒
	 * @return
	 */
	public static BigDecimal secondToHour(BigDecimal second) {
		return second.divide(new BigDecimal(60), 4, BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(60), 4, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 获取当前时间往前推2周的日期
	 */
	public static String getTopTwoWeekTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -14);// 过去14天
		Date d = c.getTime();
		String day = format.format(d);
		return day;
	}

	/**
	 * 获取某个日期的当月开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthFistDayTime(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取某个日期的当月结束时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthLastDayTime(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 根据指定日期获取涉及月份
	 * 
	 * @param y1  开始时间
	 * @param y2  结束时间
	 * @return
	 */
	public static List<String> calculationMonth(String y1, String y2) {
		List<String> list = new ArrayList<String>();
		try {
			Date startDate = new SimpleDateFormat("yyyy-MM").parse(y1);
			Date endDate = new SimpleDateFormat("yyyy-MM").parse(y2);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			// 获取开始年份和开始月份
			int startYear = calendar.get(Calendar.YEAR);
			int startMonth = calendar.get(Calendar.MONTH);
			// 获取结束年份和结束月份
			calendar.setTime(endDate);
			int endYear = calendar.get(Calendar.YEAR);
			int endMonth = calendar.get(Calendar.MONTH);
			for (int i = startYear; i <= endYear; i++) {
				String date = "";
				if (startYear == endYear) {
					for (int j = startMonth; j <= endMonth; j++) {
						if (j < 9) {
							date = i + "-0" + (j + 1);
						} else {
							date = i + "-" + (j + 1);
						}
						list.add(date);
					}
				} else {
					if (i == startYear) {
						for (int j = startMonth; j < 12; j++) {
							if (j < 9) {
								date = i + "-0" + (j + 1);
							} else {
								date = i + "-" + (j + 1);
							}
							list.add(date);
						}
					} else if (i == endYear) {
						for (int j = 0; j <= endMonth; j++) {
							if (j < 9) {
								date = i + "-0" + (j + 1);
							} else {
								date = i + "-" + (j + 1);
							}
							list.add(date);
						}
					} else {
						for (int j = 0; j < 12; j++) {
							if (j < 9) {
								date = i + "-0" + (j + 1);
							} else {
								date = i + "-" + (j + 1);
							}
							list.add(date);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
