package co.edu.escuelaing.arep_parcialt2.RoundRobin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author jeison.barreto
 */
public class SparkWebServerRR {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "";
    String service1 = "http://ec2-3-82-64-83.compute-1.amazonaws.com:4567/lucasseq?value=";
    String service2 = "http://ec2-3-82-64-83.compute-1.amazonaws.com:4567/lucasseq?value=";
    int flag = 0;

    public String connect(String cadena) throws IOException {
        URL obj = new URL(GET_URL + cadena);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        System.out.println(GET_URL);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                if (inputLine.contains("{")) {
                    return inputLine;
                }
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return null;
    }

    /**
     * Es la encargada de cambiar entre los servicedores, 0 ó 1.
     */
    public void changeServer() {
        this.flag += 1;
        if (flag % 2 == 0) {
            GET_URL = service1;
        } else {
            GET_URL = service2;
        }
    }
}
