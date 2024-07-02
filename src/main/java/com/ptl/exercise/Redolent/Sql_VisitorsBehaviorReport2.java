package com.ptl.exercise.Redolent;

    //this code is not tested in hackerrank
public class Sql_VisitorsBehaviorReport2 {

    /*
    SELECT 
    CONCAT('Q', QUARTER(dt), '''', RIGHT(YEAR(dt), 2)) AS period,
    TRIM(BOTH ';' FROM CONCAT_WS('; ',
        IF(SUM(CASE WHEN type = 'buy' THEN 1 ELSE 0 END) > 0, 
           CONCAT('buy=', SUM(CASE WHEN type = 'buy' THEN 1 ELSE 0 END)), 
           NULL),
        IF(SUM(CASE WHEN type = 'other' THEN 1 ELSE 0 END) > 0, 
           CONCAT('other=', SUM(CASE WHEN type = 'other' THEN 1 ELSE 0 END)), 
           NULL),
        IF(SUM(CASE WHEN type = 'sell' THEN 1 ELSE 0 END) > 0, 
           CONCAT('sell=', SUM(CASE WHEN type = 'sell' THEN 1 ELSE 0 END)), 
           NULL)
    )) AS type_counts
    FROM events
    WHERE YEAR(dt) = 2021
    GROUP BY YEAR(dt), QUARTER(dt)
    ORDER BY YEAR(dt), QUARTER(dt);

     */
}
