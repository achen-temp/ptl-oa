package com.ptl.exercise.Redolent;

/**
 * this code passed the tests in hackerrank
 */
public class Sql_CitiesWithMoreCustomersThanAverage {
    /*

SELECT co.country_name, ci.city_name, count(cu.id)
FROM country co
JOIN city ci
ON co.id = ci.country_id
JOIN customer cu
ON cu.city_id = ci.id
GROUP BY co.country_name, ci.city_name
HAVING count(cu.id) > (
   SELECT AVG(customer_count) FROM (
       SELECT ci.id, count(cu.id) as customer_count
       FROM city ci
       JOIN customer cu
       ON ci.id = cu.city_id
       GROUP BY ci.id
   ) avg_count
)
ORDER BY co.country_name, ci.city_name 

     */
}
