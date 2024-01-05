
     SELECT country, count(*)
     FROM event
     WHERE age >= 15
     AND age <= 20
     AND country in ('English', 'France', 'Germany')
     GROUP BY country
     ORDER BY country DESC;
