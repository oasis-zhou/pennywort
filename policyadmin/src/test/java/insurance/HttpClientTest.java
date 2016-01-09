package insurance;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;


public class HttpClientTest extends AbstractTest{

//	@Test
	public void temTest(){
		String requestXml = getResponse();

		String url = "http://210.13.77.89:2000/pa_web/api/axatppayment/notifications";
		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);   

		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestHeader("Content-Type", "text/xml;charset=GBK");
		postMethod.setRequestBody(requestXml);

		try {
			client.executeMethod(postMethod);
			if (HttpStatus.SC_OK != postMethod.getStatusCode()){
				System.out.println("http服务接口请求失败！返回结果："+postMethod.getStatusCode());
				
			}else{
				String result = postMethod.getResponseBodyAsString();
				
				System.out.println("output:" + result);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void temTest2(){
		String requestXml = getResponse();
		String url = "http://210.13.77.89:2000/pa_web/api/axatppayment/notifications";
		
		String response = postRest(url,requestXml);
		
		System.out.println("output:" + response);
		
	}
	
	public String postRest(String urlStr, String content) {
		URL url = null;
		HttpURLConnection connection = null;

		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "text/xml;charset=GBK");
			connection.setUseCaches(false);
			connection.connect();

			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.write(content.getBytes("GBK"));
			out.flush();
			out.close();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader =
						new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				reader.close();
				return buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return null;
	}
	
	private String getResponse(){
		String str = "<?xml version='1.0' encoding='GBK'?><Package><Header><RequestType>110</RequestType><SystemNo>001</SystemNo><SendTime>2015-04-2211:01:19</SendTime><Status>100</Status><ErrorMessage/></Header><Sign>StABEpRTWHaNVQjOd6r2egObsne0vg3rLxsKyluIXdX9q4aVUGw5uTFrBxX+QrfOfzfiih3pn0sdh3/Cttz4+VtEIU6U0B2QdV9U3UmWzW0JdVWPiwGLWOFIGie8cQE8IXDNXqQlG+4xos652DIPytG7nqt4mQwMuvhmSfGehD0=</Sign><Response><DepartmentCode>30</DepartmentCode><TransSourceCode>tpPay</TransSourceCode><PayNo>2015000007744582</PayNo><PayAmount>1250</PayAmount><RealPayAmount>1250</RealPayAmount><PaymentTime>2015-04-2210:58:49</PaymentTime><DealTime>2015-04-2210:59:17</DealTime><PayType>1</PayType><PlatformCode>2</PlatformCode><PlatformName>快钱网上支付</PlatformName><OrderId>1000000000012649</OrderId><OrderStatus>2</OrderStatus><PageUrl>http://test.tpis.tpaic.com:8888/payResult.do</PageUrl><AutoErrMsg/><ProductList><Product><ProductId>10903015042200361078</ProductId><ApplyPolicyNo>1000105000009636076</ApplyPolicyNo><PlanCode>105</PlanCode><ProductName>机动车交强险</ProductName><ProductAmt>950</ProductAmt><IsVerify/><ViewProductUrl/><InsuranceBeginTime/></Product></ProductList></Response></Package>";
		return str;
	}
}
