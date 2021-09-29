import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import dao.Sql2oAnimalsDao;
//import models.AnimalsAbstract;
import dao.Sql2oSightingsDao;
import models.Animal;
import models.Endangered;


import models.Sighting;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        staticFileLocation("/public");

        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "1234");
        Sql2oAnimalsDao  sql2oAnimalsDao=new Sql2oAnimalsDao(sql2o);
        Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao(sql2o);


        //homepage path
//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            Animal animals = wildlifeTrackerDao.findAll();
//            model.put("animals", animals);
            //ArrayList<Sighting> sightings = Sighting.findAll();
            //model.put(" sightings",  sightings);
            //ArrayList<Endangered> endangered = Endangered.addAll();
            //model.put(" endangered",  endangered);
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
        get("/", (req, res) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            ArrayList<Animal> animals = sql2oAnimalsDao.findAll();
          //  List<Animal> posts = postDao.findAll();
            //model.put("posts", posts);
            model.put("animals", animals);
            ArrayList<Endangered> endangered = Endangered.addAll();
            model.put(" endangered",  endangered);
            return  new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());


        //adding new animal path
        get("/animalsgeneral", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "addAnimal.hbs");
        }, new HandlebarsTemplateEngine());
        //animalform path
        get("/sightinganimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "addanimalform.hbs");
        }, new HandlebarsTemplateEngine());
        post("/successAnimal",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("animalName");
            String age = req.queryParams("animalAge");
            req.session().attribute("animalName", name);
            req.session().attribute("animalAge", age);
            Animal animal = new Animal(name,age);
            model.put("animalName", name);
            model.put("animalAge", age);
            return new ModelAndView(model,"successAnimal.hbs");
        },new HandlebarsTemplateEngine());
        //end of the path

        //adding endangered animals
        get("/animalsgeneral", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "addAnimal.hbs");
        }, new HandlebarsTemplateEngine());
        //endangered animalform
        get("/sightingendangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());
        post("/successEndangered",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("animalNameEndangered");
            String age = req.queryParams("animalAgeEndangered");
            String health = req.queryParams("animalHealth");
            req.session().attribute("animalNameEndangered", name);
            req.session().attribute("animalAgeEndangered", age);
            Endangered newEndangered = new  Endangered(name,age,health);
            model.put("animalNameEndangered", name);
            model.put("animalAgeEndangered", age);
            model.put("animalHealth", health);
            return new ModelAndView(model,"successEndangered.hbs");
        },new HandlebarsTemplateEngine());

        //end of path


      //adding a newly sighted animal
        get("/allsightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newsightings.hbs");
        }, new HandlebarsTemplateEngine());
        post("allAnimals/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String animalType = request.queryParams("animalType");
            model.put("animalType", animalType);
            String locationSpotted = request.queryParams("locationSpotted");
            model.put("locationSpotted ", locationSpotted );
            String rangerName = request.queryParams("rangerName");
            model.put("rangerName", rangerName);
            Sighting newSighting = new Sighting(animalType,locationSpotted,rangerName);
            sql2oSightingsDao.add(newSighting);
            return new ModelAndView(model, "successSightings.hbs");

        }, new HandlebarsTemplateEngine());
       //end of path












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



    //Animal newAnimal = new Animal(animalName);
//           // model.put("animal", newAnimal);
//            return new ModelAndView(model,"successAnimal.hbs");
//        },new HandlebarsTemplateEngine());
//        post("/successAnimal", (req, res) -> { //URL to make new post on POST route
//            Map<String, Object> model = new HashMap<String, Object>();
//            String animalName = req.queryParams("animalName");
//            String animalAge = req.queryParams(" animalAge");
//            //req.session().attribute(" animalAge", animalAge);
//           // req.session().attribute(" animalAge", animalAge);
//           // Animal newAnimal = new Animal( animalAge, animalAge);
//            model.put(" animalName",  animalName);
//            model.put(" animalAge",  animalAge);
//             Animal newAnimal = new Animal(animalName,animalAge);
//            wildlifeTrackerDao.add(newAnimal);
//            return new ModelAndView(model, "successAnimal.hbs");
//
//        }, new HandlebarsTemplateEngine());

}



