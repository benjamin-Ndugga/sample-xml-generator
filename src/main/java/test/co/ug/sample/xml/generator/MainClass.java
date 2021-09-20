
package test.co.ug.sample.xml.generator;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author benjie_en
 */
public class MainClass {

    public static void main(String[] args) throws Exception {

        String xml_request = convertJavaToXml();
        
        System.out.println("Request:\n"+xml_request);
        
        String token = "";

        URIBuilder builder = new URIBuilder("http://localhost:8080/service");
        URI uri = builder.build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setHeader("Accept", "text/xml");
        httpPost.setHeader("Content-type", "text/xml");
        //httpPost.setHeader("Authorization", "Bearer " + token);

        httpPost.setEntity(new StringEntity(xml_request));

        HttpClient httpclient = HttpClients.createDefault();

        HttpResponse response = httpclient.execute(httpPost);

        //read the http response status code i.e 200,500,404
        System.out.println("HTTP-STATUS: " + response.getStatusLine().getStatusCode());

        HttpEntity entity = response.getEntity();

        if (entity != null) {

            String xml_response_body = EntityUtils.toString(entity);
            //convert the xml to a java object
            Message message = convertXmltoJava(xml_response_body);
            
            System.out.println(message);
        } else {
        }

    }

    private static Message convertXmltoJava(String xml) throws Exception {
        //read a file from hdd
        //String xml = new String(Files.readAllBytes(Paths.get("account-lookup-response-xml-file.xml")));

        JAXBContext context = JAXBContext.newInstance(Message.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Message message = (Message) unmarshaller.unmarshal(new StringReader(xml));

        List<Field> field = message.getIsomsg().getField();
        field.forEach(field1 -> {
            System.out.println(field1);
        });
        
        return message;
        

    }

    private static String convertJavaToXml() throws Exception {

        JAXBContext context = JAXBContext.newInstance(Message.class);
        Message message = new Message();

        AuthHeader authHeader = new AuthHeader();
        authHeader.setPassword(300147);
        authHeader.setSourceid(5269);

        message.setAuthHeader(authHeader);

        Isomsg isomsg = new Isomsg();

        List<Field> fields = Stream.of(
                new Field("1", "CASH"),
                new Field("11", "DEBIT"),
                new Field("14", "CASH_IN"))
                .collect(Collectors.toList());
        isomsg.setField(fields);

        message.setIsomsg(isomsg);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(message, stringWriter);

        return stringWriter.toString();

    }

}
