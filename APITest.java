import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class APITest {
    public static void main(String[] args) {
        URL urlObject = new URL("https://certwebservices.ft.cashedge.com/sdk/Payments/Businesses");
        Client client = ClientBuilder.newClient();

        String requestID = "test";
        String pageSize = "10";
        String pageNumber = "1";
        String zipCode = "30004";
        Entity payload = Entity.json(requestID, pageSize, pageNumber, zipCode);
        Response response = client.target(urlObject)
          .request(MediaType.APPLICATION_JSON_TYPE)
          .header("apiKey", "prod-a6c8b38f02cfea598688434ed14f2f3919acf3e1d0220e7a18d825e1421f0c0f40c59538e6643f7468785ff29db27cf2f9147f180120474968cc051a6d70b36b", "Accept", "application/json")
          .post(payload);
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.toString());
    }
}
