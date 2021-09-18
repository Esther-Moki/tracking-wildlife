

import java.util.Map;
import java.util.HashMap;

import models.Ranger;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        staticFileLocation("/public");


//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());

//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());


        get("/successSightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "successSightings.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());

//        post("/posts/new", (request, response) -> { //URL to make new post on POST route
//            Map<String, Object> model = new HashMap<String, Object>();
//            Ranger ranger = new Ranger();
//            String name = request.queryParams("name");
//            String location = request.queryParams("location");
//            model.put("name", name);
//            model.put("location", location);
//
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//

    }
}



