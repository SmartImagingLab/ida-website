package com.bjpowernode.ajax.web.action;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


public class one_to_more {
	public static void main(String[] args) throws JSONException {
		String s="{\"result\":0,\"msg\":\"³É¹¦\",\"info\":{\"saleUnit\":\"\",\"weight\":\"0.04\"}}";
		JSONObject jso=new JSONObject(s);
		Map<String,Object> m=new HashMap();
		Iterator it = jso.keys();  
		while (it.hasNext()) {  
			String key = (String) it.next();  
			Object value = jso.get(key);  
			m.put(key, value);
		}
		System.out.println(m.toString());
		System.out.println(m);
		System.out.println(m.get("info"));
	}
 
}