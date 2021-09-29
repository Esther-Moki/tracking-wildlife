package dao;

import models.Animal;
import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oSightingsDao implements SightingsDaoInterface{

    public final Sql2o sql2o;

    public Sql2oSightingsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Sighting sighting) {
        String sql = "INSERT INTO sighting(type,location,ranger) VALUES (:type,:location,:ranger)";
        try(Connection con = sql2o.open()){
            int id = (int)con.createQuery(sql,true)
                    .bind(sighting).executeUpdate().getKey();
            sighting.setId(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public Sighting findAll() {
        Connection con = sql2o.open(); {
            return (Sighting) con.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Sighting.class);

        }
    }

    @Override
    public Sighting findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id=:id")
                    .addParameter("id",id).executeAndFetchFirst(Sighting.class);
        }
    }

    @Override
    public void update(int id, String type, String location, String ranger) {
        String sql = "UPDATE sightings SET (sighting)* (:type,:location,:ranger) WHERE id*:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql,true)
                    .addParameter("type",type)
                    .addParameter("location",location)
                    .addParameter("ranger",ranger)
                    .addParameter("id",id).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM sightings";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM sightings WHERE id=i:d";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }
}
