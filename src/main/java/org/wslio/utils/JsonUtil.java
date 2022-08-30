package org.wslio.utils;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonUtil {

	public static String parseObject(final Object object) {
		ObjectMapper om=new ObjectMapper();
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return ret;
	}
	public static String parseObject(final Object object, final String filterob,final String[] specifypro){
		ObjectMapper om = new ObjectMapper();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		om.getSerializationConfig().setDateFormat(df);
		SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
		filter.addFilter(filterob, SimpleBeanPropertyFilter.filterOutAllExcept(specifypro));
		om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		om.setFilters(filter);
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
		}
		return ret;
	}
	public static String parseObject(Object object,Map<String, String[]> filterMap,String dateFormat){

		ObjectMapper om = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		om.setDateFormat(format);
		SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
		for (Map.Entry<String, String[]> mapItem : filterMap.entrySet()) {
			filter.addFilter(mapItem.getKey(), SimpleBeanPropertyFilter.filterOutAllExcept(mapItem.getValue()));
		}
		om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		om.setFilters(filter);
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
		}
		return ret;
	}
	public static String parseObject(Object object,Map<String, String[]> filterMap){
		ObjectMapper om = new ObjectMapper();
		SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
		for (Map.Entry<String, String[]> mapItem : filterMap.entrySet()) {
			filter.addFilter(mapItem.getKey(), SimpleBeanPropertyFilter.filterOutAllExcept(mapItem.getValue()));
		}
		om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		om.setFilters(filter);
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
		}
		return ret;
	}

	public static  Object readJson2Entity(String jsonstr,Class<?> oclass) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper om = new ObjectMapper();
		Object acc = om.readValue(jsonstr, oclass);
		return acc;
	}

	public static  List<?> paseJson2Collection(String string,Class<?> x) throws Exception{
    	ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = getCollectionType(ArrayList.class, x);
        List<Class<?>> list =  (List<Class<?>>)mapper.readValue(string, javaType);
        return list;
    }

	/**
	 * @author ldl
	 * 把json字符串转化为Map对象
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public static Map paseJson2Map(String string) throws Exception{
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(string, Map.class);
		} catch (Exception e) {
			throw new  Exception(e.getMessage());
		}
	}
       /**
        * 获取泛型的Collection Type
        * @param collectionClass 泛型的Collection
        * @param elementClasses 元素类
        * @return JavaType Java类型
        * @since 1.0
        */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
    	ObjectMapper mapper = new ObjectMapper();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> List<T> json2Array(String jsonstr, Class<T[]> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		mapper.setDateFormat(df);
		T[] resultArr = null;
		try {
			resultArr = (T[]) mapper.readValue(jsonstr, clazz);
			return Arrays.asList(resultArr);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<T>();
	}

}
