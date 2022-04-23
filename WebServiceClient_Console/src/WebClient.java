import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class WebClient 
{
	
	private static SSLSocketFactory getSSLSocketFactory() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
            };
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	


	public static void main(String[] args) throws IOException, JSONException
	{
	
		StringBuilder response = new StringBuilder();
		
		//String url1= "http://192.168.29.225:8081/getAliens";
		String url1= "https://jsonplaceholder.typicode.com/posts";
		
		URL url = new URL(url1);
		
		HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
		
		 if (url1.startsWith("https")) {
	         	System.out.println("Getting data from HTTPS connection");
	         	System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
	         	conn = (HttpsURLConnection) url.openConnection();            	
	         } else {
	         	System.out.println("Getting data from HTTP connection");
	         	conn = (HttpURLConnection) url.openConnection();
	         }
		
		
		conn.setRequestMethod("GET");
		
		conn.addRequestProperty("accept", "application/json");
		
		
		  if (url1.startsWith("https")){
				 //if(url.test("https")) {
		          	System.out.println("Ignoring SSL certificate for HTTPS connection");
			            ((HttpsURLConnection)conn).setSSLSocketFactory(getSSLSocketFactory());
			            ((HttpsURLConnection)conn).setHostnameVerifier(new HostnameVerifier() {
			                @Override
			                public boolean verify(String s, SSLSession sslSession) {
			                    return true;
			                }
			            });
		          }
		
		  
		conn.connect();
        int responseCode = conn.getResponseCode();
        System.out.println("Response code for web service " + responseCode);  
		  
		
		if(responseCode == HttpsURLConnection.HTTP_OK)
		{
			String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
		}
			
		conn.disconnect();
		
		System.out.println("Response:- " + response.toString());
		
//		JSONObject jo=new JSONObject(response.toString());
//		
//		JSONArray jaDV = (JSONArray) jo.get("dataValue");
		
		JSONArray jsonArr = new JSONArray(response.toString());

	        for (int i = 0; i < jsonArr.length(); i++)
	        {
	            JSONObject jsonObj = jsonArr.getJSONObject(i);

	            System.out.println(jsonObj);
	            
	          //  System.out.println(jsonObj.get("title"));
	        }
		
			
	}
}
