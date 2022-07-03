
import com.google.gson.Gson;
import models.Doctor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import sql2o.Sql2oDoctor;


//import java.sql.Connection;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        Gson gson = new Gson();
        Sql2oDoctor sql2oDoctor = new Sql2oDoctor();

        port(getHerokuAssignedPort());
//        Connection conn;

//        ProcessBuilder process = new ProcessBuilder();
//        int port;
//
//        if (process.environment().get("PORT") != null) {
//            port = Integer.parseInt(process.environment().get("PORT"));
//        } else {
//            port = 4567;
//        }
//        port(port);

        /*----------------Local DB--------------------*/
//        String connectionString = "jdbc:postgresql://localhost:5432/my_doctors";
//        Sql2o sql2o = new Sql2o(connectionString, "postgres", "korir");

        /*-------------------Heroku DB----------------*/
//        String connectionString = "jdbc:postgresql://ec2-44-206-11-200.compute-1.amazonaws.com:5432/d6euguqkrru9qd"; //!
//        Sql2o sql2o = new Sql2o(connectionString, "qpstpvwvotbcun", "8b899125c91b8105f836644c67708ec52fb07c6b4293a64c2bb17b421d4dda37");


//        conn = sql2o.open();

        staticFileLocation("/public");
        get("/doctor","application/json",(request, response) -> {
            System.out.println(sql2oDoctor.getAll());

            if(sql2oDoctor.getAll().size()>0){
                return gson.toJson(sql2oDoctor.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
            }
        });
        post("/doctor/new", "application/json", (request,response)->{
            Doctor doctor = gson.fromJson(request.body(), Doctor.class);
            sql2oDoctor.add(doctor);
            response.status(201);

            return gson.toJson(doctor);
        });

    }
}