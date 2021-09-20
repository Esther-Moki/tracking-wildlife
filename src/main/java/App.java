

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import models.Animal;
import models.Ranger;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        staticFileLocation("/public");


//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
         get("/", (request, response) -> {
           Map<String, Object> model = new HashMap<>();
             ArrayList<Animal> animal = Animal.getAll();
             model.put("animal", animal);
           return new ModelAndView(model, "index.hbs");
      }, new HandlebarsTemplateEngine());

        // Sighting form
        get("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newsightings.hbs");
        }, new HandlebarsTemplateEngine());
        post("/successSightings",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String animalName = req.queryParams("animalName");
            String animalAge = req.queryParams("animalAge");
            model.put("animalName", animalName);
            model.put("animalAge", animalAge);

            return new ModelAndView(model,"successSightings.hbs");
        },new HandlebarsTemplateEngine());

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



        //adding new animal whether endangered or not
        get("/animalsgeneral", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "addAnimal.hbs");
        }, new HandlebarsTemplateEngine());
        //animalform
        get("/sightinganimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "addanimalform.hbs");
        }, new HandlebarsTemplateEngine());
        post("/successAnimal",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String animalName = req.queryParams("animalName");
            model.put("animalName", animalName);

            return new ModelAndView(model,"successAnimal.hbs");
        },new HandlebarsTemplateEngine());

        //for endangered animals
        get("/animalsgeneral", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "addAnimal.hbs");
        }, new HandlebarsTemplateEngine());
        //animalform
        get("/sightingendangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());
        post("/successEndangered",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String animalNameEndangered = req.queryParams("animalNameEndangered");
            model.put("animalNameEndangered}", animalNameEndangered);
            String animalAgeEndangered = req.queryParams("animalAgeEndangered");
            model.put("animalAgeEndangered", animalAgeEndangered);
            String animalHealth = req.queryParams("animalHealth");
            model.put("animalHealth", animalHealth);

            return new ModelAndView(model,"successEndangered.hbs");
        },new HandlebarsTemplateEngine());





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



