package elastic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.simple.JSONObject;




public class ElasticSearch {
	
	
	public static void main(String args[])
	{
		
		Map<String, String> paramMap = new HashMap<String, String>();
		
		paramMap.put("firstname", "madhuhjjbkj");
		paramMap.put("lastname","sudhan");
		
		paramMap.put("age", "22");
		
		
		
		
	    JSONObject obj=new JSONObject(paramMap);
	   
		
		
		 try {
			    //post method to create a document

				HttpPost postRequest = new HttpPost("http://localhost:9200/index1/_doc/3");
				
				StringEntity requestEntity = new StringEntity(obj.toString(), ContentType.APPLICATION_JSON);
				
				postRequest.setEntity(requestEntity);
				
				
				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpResponse response1 = httpClient.execute(postRequest);
				String responseBody1 = EntityUtils.toString(response1.getEntity());
				
				System.out.println(response1.getStatusLine());
				
			} 
		 catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		 catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
		
		
		
		
		
		
		RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
		
		
		
		
		try {
			
			//get method to fetch the document
			Response response = restClient.performRequest("GET", "/index1/_doc/3");
			
			
			
			System.out.println(response.getStatusLine());
			
			String responseBody = EntityUtils.toString(response.getEntity());
			
			
			
			System.out.println(responseBody);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

}
