
import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        } return 4567;
    }

    //Main method starts here
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        Map<String, Object> model = new HashMap<>();

        //Home index.hbs or starting point
        get("/", (request, response) -> {
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //Adds New heros
        get("/heroes/new", (request, response) -> {
            return new ModelAndView(model, "heroes-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/heroes/new", (request, response) -> {
            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String specialpower = request.queryParams("specialpower");
            String weakness = request.queryParams("weakness");
            request.session().attribute("name", name);
            request.session().attribute("age", age);
            request.session().attribute("specialpower", specialpower);
            request.session().attribute("weakness", weakness);
            Hero myHero = new Hero(name,age,specialpower,weakness);
            model.put("myHero", request.session().attributes());
            model.put("name", name);
            model.put("age", age);
            model.put("specialpower", specialpower);
            model.put("weakness", weakness);
            return new ModelAndView(model, "newhero.hbs");

        }, new HandlebarsTemplateEngine());


        //Adds new Squads
        get("/squads/new", (request, response) -> {
           return new ModelAndView(model, "squad-form.hbs");

        }, new HandlebarsTemplateEngine());

        //Posts new Squad to a session
        post("/squads/new", (request, response) -> {
            String maxSize = request.queryParams("maxsize");
            String naming = request.queryParams("naming");
            String cause = request.queryParams("cause");
            Squad squad = new Squad(maxSize, naming, cause);
            request.session().attribute("name", naming);
            request.session().attribute("maxSize", maxSize);
            request.session().attribute("cause", cause);
            model.put("maxsize", maxSize);
            model.put("name", naming);
            model.put("cause", cause);

            return new ModelAndView(model, "squad-form.hbs");

        }, new HandlebarsTemplateEngine());

    }
}
