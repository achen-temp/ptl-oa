package com.ptl.exercise.redolent;

    //this code is tested in hackerrank
public class Sql_VisitorsBehaviorReport2 {

    /*
    
WITH event_counts AS (
    SELECT
        CONCAT('Q', FLOOR((MONTH(dt) - 1) / 3) + 1, '''21') AS period,
        type,
        COUNT(*) AS count
    FROM events
    WHERE YEAR(dt) = 2021
    GROUP BY period, type
),
sorted_event_counts AS (
    SELECT
        period,
        type,
        count,
        ROW_NUMBER() OVER (PARTITION BY period ORDER BY count DESC, type) AS row_num
    FROM event_counts
    ---- ORDER BY period, count DESC, type
)
SELECT
    period,
    GROUP_CONCAT(CONCAT(type, '=', count) ORDER BY count DESC, type SEPARATOR '; ') AS events
FROM sorted_event_counts
GROUP BY period
ORDER BY period;


     */
}
