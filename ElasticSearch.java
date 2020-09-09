package elastic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.apache.http.HttpHost;

import org.apache.http.util.EntityUtils;

import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;


public class ElasticSearch {
	
	
	public static void main(String args[])
	{
		
		Map<String, String> paramMap = new HashMap<String, String>();
		
		paramMap.put("firstname", "madhu");
		paramMap.put("lastname","sudhan");
		
		paramMap.put("age", "22");
		
		
		RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
		try {
			
			
			Response response = restClient.performRequest("GET", "/index2/_doc/1");
			
			
			System.out.println(response.getStatusLine());
			
			String responseBody = EntityUtils.toString(response.getEntity());
			
			
			
			System.out.println(responseBody);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
