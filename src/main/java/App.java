import com.google.gson.Gson;
import dao.Sql2oLeaveDao;
import models.DB;
import models.Leave;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;

public class App {
    public static void main(String [] args){
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if(process.environment().get("PORT") != null) {
           port = Integer.parseInt(process.environment().get("PORT"));
        }   else {
            port = 4567;
        }  port(port);


        Sql2o sql2o = DB.sql2o;
        Sql2oLeaveDao leaveDao = new Sql2oLeaveDao();
        Gson gson = new Gson();

        get("/", (requst, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show all articles
        get("/leave", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Leave> allLeaves = leaveDao.getAll();
            model.put("leave", allLeaves);
            return new ModelAndView(model, "leave.hbs");
        }, new HandlebarsTemplateEngine());


        get("/leave/api", "application/json", (req, res) -> {
            return gson.toJson(leaveDao.getAll());
        });

    }


}
