import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@WebServlet("/webclient")
public class WebClient extends HttpServlet
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
	

	

	//public static void main(String[] args) throws IOException, JSONException
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
	
		StringBuilder response = new StringBuilder();
		
		//String url1= "http://192.168.29.225:8081/getAliens";
		String url1= "https://jsonplaceholder.typicode.com/posts";
		
		System.out.println("URL:- "+ url1);
		
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
		
		JSONArray jsonArr = null;
		
			try {
				
						jsonArr = new JSONArray(response.toString());
						
						//res.setContentType("application/json");
						res.setContentType("text/html");
						PrintWriter out = res.getWriter();
						out.println("<html> \n <body>");
						out.println("<table border='1' >");	 
						out.println("<tr><th colspan='2'>WebService Client</th></tr>");
				        for (int i = 0; i < jsonArr.length(); i++)
				        {
				            JSONObject jsonObj = jsonArr.getJSONObject(i);
			
				            System.out.println(jsonObj);
				            
				            System.out.println(jsonObj.get("title"));
				            	
				            out.print("<tr><th> UserId: </th><td>" + jsonObj.get("userId") + "</td></tr>");
				            out.print("<tr><th> Id: </th><td>" + jsonObj.get("id") + "</td></tr>");
				            out.print("<tr><th> Title: </th><td>" + jsonObj.get("title") + "</td></tr>");
				            out.print("<tr><th>Body: </th><td>" + jsonObj.get("body") + "</td></tr>");
				            out.print("<tr><td colspan='2'>----------------------------------</td></tr>");
				            
				            
						 }
				        
				        out.println("</table>");
				        out.println(" </body> \n </html> ");
				        
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
}

