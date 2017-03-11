import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Created by macbook on 4/3/17.
 */
public class Main {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/alife", (request, response) -> {
            response.type("application/json");
            return "I am alive.";
        }, gson::toJson);
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080; //return default port if heroku-port isn't set (i.e. on localhost)
    }


}
