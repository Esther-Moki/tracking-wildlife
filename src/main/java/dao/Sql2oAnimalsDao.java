package dao;

import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oAnimalsDao implements AnimalsDaoInterface {

    public final Sql2o sql2o;

    public Sql2oAnimalsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Animal animal) {
        String sql = "INSERT INTO animals(name,age) VALUES (:name,:age)";
        try(Connection con = sql2o.open()){
           int id = (int)con.createQuery(sql,true)
                   .bind(animal).executeUpdate().getKey();
           animal.setId(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public Animal findAll() {
        Connection con = sql2o.open(); {
            return (Animal) con.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animal.class);

        }

    }

    @Override
    public Animal findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE id=:id")
                    .addParameter("id",id).executeAndFetchFirst(Animal.class);
        }
    }

    @Override
    public void update(int id, String name, String age) {
        String sql = "UPDATE animals SET (animal)* (:name,:age) WHERE id*:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql,true)
                    .addParameter("name",name)
                    .addParameter("age",age)
                    .addParameter("id",id).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM animals";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM animals WHERE id=i:d";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }



}
