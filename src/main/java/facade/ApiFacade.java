package facade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {
  public String getAttributeValueFromJson(String urlString, String attributeName)
          throws Exception {
    String json = getJsonFromUrl(urlString);
    return extractAttributeFromJson(json, attributeName);
  }

  private String getJsonFromUrl(String apiUrl) throws Exception {
    URL url = new URL(apiUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
      String inputLine;
      StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      return content.toString();
    } finally {
      con.disconnect();
    }
  }

  private String extractAttributeFromJson(String json, String attributeName) throws Exception {
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = (JSONObject) parser.parse(json);

    return (String) jsonObject.get(attributeName);
  }
}
