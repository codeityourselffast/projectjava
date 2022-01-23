import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


/*
Your API Access Key: ab83e920a928aa3f18f215f0f23a83be

    https://api.aviationstack.com/v1/flights
    ? access_key = YOUR_ACCESS_KEY
    & callback = MY_FUNCTION
*/


public class Flight
{
     Flight()
     {

         HttpClient client=HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://api.aviationstack.com/v1/flights?access_key=ab83e920a928aa3f18f215f0f23a83be&arr_iata=CDG")).build();
         client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                 .thenApply(HttpResponse::body)
                 .thenAccept(System.out::println)//Afficher les donneés dans un string
                 .join();
     }
}



/*
public JsonFlightFiller(String jsonString,World w)
{
    try
    {
        InputStream is = new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
        JsonReader rdr = Json.createReader(is);
        JsonObject obj = rdr.readObject();
        JsonArray results = obj.getJsonArray("data");
        for (JsonObject result : results.getValuesAs(JsonObject.class))
        {
            try
            {

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

*/









