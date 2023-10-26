package co.edu.escuelaing.arep_parcialt2;


import co.edu.escuelaing.arep_parcialt2.services.MathServices;
import static java.lang.Integer.parseInt;
import static spark.Spark.*;

/**
 *
 * @author jeison.barreto
 */
public class SparkWebServer {

    public static void main(String... args) {
        port(getPort());
        get("hello", (req, res) -> "Hello Docker!");
        get("/lucasseq", ((req, res) -> {
            res.type("application/json");
            String n = req.queryParams("value");
            return MathServices.lucas(parseInt(n));
        }));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
