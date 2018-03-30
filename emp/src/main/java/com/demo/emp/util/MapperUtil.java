package com.demo.emp.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;

@SuppressWarnings("unchecked")
public class MapperUtil {

	private static org.dozer.Mapper instance;   

	
	static {
		List<String> mappingFiles = new ArrayList<String>();
		//mappingFiles.add("config/mappings/dozer-global-configuration.xml");     
		
		instance = new DozerBeanMapper(mappingFiles);
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
	}

	
	
	public static Object map(Object source, Class destClass)
			throws MappingException {

		return instance.map(source, destClass);
	}
	
	/*public static ArrayList<Object> map(List<Object> source, Class destClass)
			throws MappingException {
		ArrayList<Object> list = new ArrayList<Object>();

		for (int i = 0; i < source.size(); i++) {
			list.add(map(source.get(i), destClass));
		}
		return list;
	}*/
	
	public static <T, U> List<U> mapList(final List<T> source, final Class<U> destType) {

	    final List<U> dest = new ArrayList<U>();

	    for (T element : source) {
	        dest.add(instance.map(element, destType));
	    }

	    return dest;
	}


}
