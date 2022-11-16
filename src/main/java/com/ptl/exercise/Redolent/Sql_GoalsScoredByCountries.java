package com.ptl.exercise.Redolent;

public class Sql_GoalsScoredByCountries {

    /**
     SELECT c.name, SUM(g.goals)
     FROM Goals g
     JOIN Countries c
     ON g.country_id = c.id
     GROUP BY c.name
     ORDER BY SUM(g.goals) DESC;
     */
}
