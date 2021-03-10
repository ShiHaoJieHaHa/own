package com.struts.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateTypeConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try { 
			if(toType == Date.class){//当字符串向Date类型转换时
				String[] params = (String[]) value;// request.getParameterValues() 
				return dateFormat.parse(params[0]);
			}else if(toType == String.class){//当Date转换成字符串时
				Date date = (Date) value;
				return dateFormat.format(date);
			}
		} catch (ParseException e) {}
		return null;
	}
}
