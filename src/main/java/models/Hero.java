package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {

    private String name;
    private int id;
    private int age;
    private String special_powers;
    private String weaknesgit s;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, int id, int age, String special_powers, String weakness) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.special_powers = special_powers;
        this.weakness = weakness;
    }

    //getters

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getSpecial_powers() {
        return special_powers;
    }

    public String getWeakness() {
        return weakness;
    }


    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecial_powers(String special_powers) {
        this.special_powers = special_powers;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return id == hero.id &&
                age == hero.age &&
                Objects.equals(name, hero.name) &&
                Objects.equals(special_powers, hero.special_powers) &&
                Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}