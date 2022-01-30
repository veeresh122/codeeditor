package SimplifyQACodeeditor;

import java.io.IOException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;


import com.simplifyqa.customMethod.SqaAutowired;
import com.simplifyqa.sqadrivers.webdriver;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;



public class CustomWebMethods {

	@SqaAutowired
	public Object web_object;
	
	public boolean DemoMethod(String url) {
		return webdriver.launchapplication(url);
    }
    
    public boolean stringswap(String str1,String str2,String runtime)
    { str1 = str1 + str2;  
        str2 = str1.substring(0, str1.length() - str2.length());  
        str1 = str1.substring(str2.length());  
        //System.out.println("After : " + str1 + " " + str2); 
        str1=str1.concat(str2);
        //GeneralMethod gm=new GeneralMethod();
         webdriver.storeruntime(runtime, str1);
        return true;

    }

    public Boolean getjsonobject(String Jsonbody,String key, String Store) {
        try {
            JSONArray sportsArray = new JSONArray(Jsonbody);
                JSONObject jsonobj=sportsArray.getJSONObject(Integer.parseInt(key));
            
                String jsonobjkey=jsonobj.toString();
                System.out.println(jsonobjkey);
            if (jsonobj != null) {
            
                //GeneralMethod gm=new GeneralMethod();
                webdriver.storeruntime(Store,jsonobjkey );
            } 
        } catch (Exception e) {
            webdriver.logger.info(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean demoapi(String m_baseURI,String m_Method,String m_Header,String m_Parameters,String m_Body,String responseBodyRuntime,String responseCodeRuntime,String responseMsgRuntime){
        webdriver.restapi(m_baseURI, m_Method, m_Header, m_Parameters, m_Body, responseBodyRuntime, responseCodeRuntime, responseMsgRuntime);
        return true;
    }

    
    
    public boolean getapi(String url,String ResponseBody,String ResponseCode) throws ClientProtocolException, IOException {
        try{
            CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);  // http get Request
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);    // hit Get URL
        
        //a. Status Code
        int StatusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("Response Code :"+StatusCode);
    
        webdriver.storeruntime(ResponseCode, String.valueOf(StatusCode));
        
        //b.Json String
        String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        
        JSONObject responseBody = new JSONObject(responseString);
        System.out.println("Response Body :"+responseBody);
        
        webdriver.storeruntime(ResponseBody,responseBody.toString());
        
        }catch(Exception e){
             e.printStackTrace();
        }
       
    return true;
       
        
    }

    public boolean getmail(String servername, String portno, String username, String password, String subject,
            String runtimparam) {
        try {
            Properties props = new Properties();
            // props.put("mail.imaps.tls", "true");
            Session session = Session.getDefaultInstance(props);
            Store store = session.getStore("imaps");
            // System.setProperty("mail.imap.ssl.protocols", "TLSv1.2");
            store.connect(servername, Integer.parseInt(portno), username, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            String content = null;
            Calendar cal = Calendar.getInstance();
            ReceivedDateTerm term = new ReceivedDateTerm(ComparisonTerm.EQ, new Date(cal.getTimeInMillis()));
            Message[] messages = inbox.search(term);
            // Sort messages from recent to oldest
            Arrays.sort(messages, (m1, m2) -> {
                try {
                    return m2.getSentDate().compareTo(m1.getSentDate());
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            });
            for (Message message : messages) {
                if (message.getSubject().contains(subject)) {
                    content = getTextFromMessage(message);
                    break;
                    // System.out.println(content);
                }
            }
            webdriver.storeruntime(runtimparam, content);
        } catch (Exception e) {
            e.printStackTrace();
            //return true;
        }
        return true;
        
    }

    public static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        MimeMultipart mimeMultipart = null;
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        } else {
            mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    public static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        String html;
        BodyPart bodyPart = mimeMultipart.getBodyPart(0);
        if (bodyPart.isMimeType("text/plain")) {
            result = (String) bodyPart.getContent();
        } else if (bodyPart.isMimeType("text/html")) {
            html = (String) bodyPart.getContent();
            result = org.jsoup.Jsoup.parse(html).text();
        } else if (bodyPart.getContent() instanceof MimeMultipart) {
            result = getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
        }
        return result;

    }



}
