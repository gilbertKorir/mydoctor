package sql2o;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o=new Sql2o("jdbc:postgresql://ec2-34-201-95-176.compute-1.amazonaws.com:5432/d67oa7f1541clc","zpyufqzndmzlwe", "9ea59f6a176bf09990560c7049616ad8cc339c8f2ad94f9cbc0f66d8b1b233db");


//    private static URI dbUri;
//    public static Sql2o sql2o;
//    static Logger logger = LoggerFactory.getLogger(DB.class);
//
//    static {
//
//        try {
//            if (System.getenv("DATABASE_URL") == null) {
//                dbUri = new URI("postgres://localhost:5432/my_doctors");
//            } else {
//                dbUri = new URI(System.getenv("DATABASE_URL"));
//            }
//            int port = dbUri.getPort();
//            String host = dbUri.getHost();
//            String path = dbUri.getPath();
//            String username = (dbUri.getUserInfo() == null) ? "postgres" : dbUri.getUserInfo().split(":")[0];
//            String password = (dbUri.getUserInfo() == null) ? "korir" : dbUri.getUserInfo().split(":")[1];
//            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
//        } catch (URISyntaxException e) {
//            logger.error("Unable to connect to database.");
//        }
//    }
}