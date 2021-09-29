SET MODE PostgreSQL;

--CREATE DATABASE wildlife_tracker;
--\c wildlife_tracker
CREATE TABLE IF NOT EXISTS animals (
      id int PRIMARY KEY auto_increment,
      name VARCHAR,
      age VARCHAR

);
CREATE TABLE IF NOT EXISTS sightings (
      id int PRIMARY KEY auto_increment,
      type VARCHAR,
      location VARCHAR,
      ranger VARCHAR,

);
CREATE TABLE IF NOT EXISTS animals_sightings (
      id int PRIMARY KEY auto_increment,
      animalsid INTEGER,
      sightingsid INTEGER
)
--CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;