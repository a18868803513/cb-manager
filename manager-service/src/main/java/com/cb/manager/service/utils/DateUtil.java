package com.cb.manager.service.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间工具类
 * 
 * @Title： 
 * @Author： alvin.wyh
 * @Date： 2017年3月10日 上午8:11:22
 * @Description：
 */
public class DateUtil {
	
	private static Log log = LogFactory.getLog(DateUtil.class);
	
	//时间格式
	public static final String YM = "yyyyMM";
	public static final String Y_M = "yyyy-MM";
	public static final String YMD = "yyyyMMdd";
	public static final String Y_M_D = "yyyy-MM-dd";
	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String YMDHMS = "yyyyMMddHHmmss";
	public static final String Y_M_D_ZW = "yyyy年MM月dd日";
	public static final String Y_M_D_H_M_ZW = "yyyy年MM月dd日HH:mm";
	//当前日期
	public static String currentDate;
	
	/***************************************************************
	 * 获取yyyy-MM-dd格式的时间串
	 * @return
	 **************************************************************/
	public static String getCurrentDate(){
		return getCurrentDate(Y_M_D);
	}
	
	/***************************************************************
	 * 获取yyyy-MM-dd HH:mm:ss格式的时间串
	 * @return
	 ***************************************************************/
	public static String getCurrentDateTime(){
		return getCurrentDate(Y_M_D_H_M_S);
	}
	
	/****************************************************************
	 * 获取自定义格式的时间串
	 * @param format
	 * @return
	 ***************************************************************/
	public static String getCurrentDate(String format){
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/****************************************************************
	 * 获取某格式的时间
	 * @param date
	 * @param format
	 * @return
	 ***************************************************************/
	public static Date getDate(String date, String format){
		
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			log.error("获取某格式的时间异常", e);
		}
		return null;
	}
	/****************************************************************
	 * @功能 取得与某天相隔n天的那一天的日期
	 * @param date
	 * @param num (可正可负)
	 * @return Date
	 ***************************************************************/
	public static Date getAnotherDate(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return calendar.getTime();
	}
	
	/****************************************************************
	 * 获取字符串
	 * @param date 时间
	 * @param format 格式
	 * @return
	 ***************************************************************/
	public static String getDateToString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	/****************************************************************
	 * 获取其他月的当前时间
	 * @param num 正数为之后num个月，负数为之前num个月
	 * @return
	 ****************************************************************/
	public static Date getAnotherMonthDate(int num){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, num);
		return c.getTime();
	}
	
	/**
	 * 转化成 XMLGregorianCalendar格式
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate(Date date){  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        DatatypeFactory dtf = null;  
         try {  
            dtf = DatatypeFactory.newInstance();  
        } catch (DatatypeConfigurationException e) {  
        }  
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();  
        dateType.setYear(cal.get(Calendar.YEAR));  
        //由于Calendar.MONTH取值范围为0~11,需要加1  
        dateType.setMonth(cal.get(Calendar.MONTH)+1);  
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));  
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));  
        dateType.setMinute(cal.get(Calendar.MINUTE));  
        dateType.setSecond(cal.get(Calendar.SECOND));  
        return dateType;  
    }

	/**  
	* 字符串日期转换成中文格式日期  
	* @param date  字符串日期 yyyy-MM-dd  
	* @return  yyyy年MM月dd日  
	* @throws Exception  
	*/  
	public static String dateToCnDate(String date) {
		String result = "";
		String[] cnDate = new String[] { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String ten = "十";
		String[] dateStr = date.split("-");
		for (int i = 0; i < dateStr.length; i++) {
			for (int j = 0; j < dateStr[i].length(); j++) {
				String charStr = dateStr[i];
				String str = String.valueOf(charStr.charAt(j));
				if (charStr.length() == 2) {
					if (charStr.equals("10")) {
						result += ten;
						break;
					} else {
						if (j == 0) {
							if (charStr.charAt(j) == '1')
								result += ten;
							else if (charStr.charAt(j) == '0')
								result += "";
							else
								result += cnDate[Integer.parseInt(str)] + ten;
						}
						if (j == 1) {
							if (charStr.charAt(j) == '0')
								result += "";
							else
								result += cnDate[Integer.parseInt(str)];
						}
					}
				} else {
					result += cnDate[Integer.parseInt(str)];
				}
			}
			if (i == 0) {
				result += "年";
				continue;
			} else if (i == 1) {
				result += "月";
				continue;
			} else if (i == 2) {
				result += "日";
				continue;
			}
		}
		return result;
	}

	/**
	 * 计算间隔月数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthSpace(String beginDate, String endDate) throws ParseException {
		int result = 0;
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.Y_M_D);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(sdf.parse(beginDate));
		c2.setTime(sdf.parse(endDate));
		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
		return result == 0 ? 1 : Math.abs(result);
	}

	/**
	 * 返回num天后的日期
	 * 
	 * @param date
	 *            开始日期
	 * @param num
	 *            天数
	 * @param format
	 *            返回格式
	 * @return
	 */
	public static String getAnotherDate(String date, int num, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
			calendar.add(Calendar.DAY_OF_MONTH, num);
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
			log.error("获取某格式的时间异常", e);
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(daysBetween("2017-09-06", "2017-09-15"));
		
		System.out.println(getDateToString(getAnotherDate(new Date(), 8), Y_M_D));
		
		System.out.println(getDateToString(getAnotherMonthDate(-11), Y_M_D_H_M_S));
		
		System.out.println(getDateToString(new Date(), "YYYY-MM-DD'T'HH:mm:ss.sss'Z'"));
		
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(sdf.format(d));
		
		System.out.println(getAnotherDate("2017-12-13", -1,Y_M_D));
		
		System.out.println(getFirstDateOfMonth("2017-12-13",Y_M_D));
		
		System.out.println(getLastDateOfMonth("2017-12-13",Y_M_D));
		
		Date date = DateUtil.getDate("2017-12-13", DateUtil.YMD);
		System.out.println(StringUtils.substring(DateUtil.getDateToString(date,DateUtil.YMD),0,6));
		
		System.out.println(getDateString("2017-09-13",Y_M));
	}
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
	public static int daysBetween(Date smdate,Date bdate) throws ParseException  {    
        SimpleDateFormat sdf=new SimpleDateFormat(Y_M_D);  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    } 
	
	public static int daysBetween(String begin,String end) { 
		try {   
			SimpleDateFormat sdf=new SimpleDateFormat(Y_M_D);  
	        Date bdate;
			bdate = sdf.parse(begin);
	        Date edate = sdf.parse(end);  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(bdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(edate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	        return Integer.parseInt(String.valueOf(between_days));  
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
    } 
    
    /**
	 * 计算间隔月数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthSpace(Date beginDate, Date endDate) throws ParseException {
		int result = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(beginDate);
		c2.setTime(endDate);
		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
		return result == 0 ? 1 : Math.abs(result);
	}
	
	/**
	 * 获取指定日期，月份的第一天
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFirstDateOfMonth(String date, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
			calendar.add(Calendar.MONTH, 0);
			calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 	       
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
			log.error("获取某格式的时间异常", e);
		}
		return null;
	}
	
	/**
	 * 获取指定日期，月份的最后一天
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getLastDateOfMonth(String date, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
			calendar.add(Calendar.MONTH, 0);
			calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 	       
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
			log.error("获取某格式的时间异常", e);
		}
		return null;
	}
	
	/**
	 * 获取指定日期，月份的最后一天
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateString(String date, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));				       
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
			log.error("获取某格式的时间异常", e);
		}
		return null;
	}	
	
}
