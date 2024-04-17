/* output tier and total */
SELECT tier, 
    CONCAT( 
         FLOOR(SUM(TIMESTAMPDIFF(SECOND, dt_start, dt_end)) / 86400), ' days ', 
         MOD(FLOOR(SUM(TIMESTAMPDIFF(SECOND, dt_start, dt_end)) / 3600), 24), ' hours ', 
         MOD(FLOOR(SUM(TIMESTAMPDIFF(SECOND, dt_start, dt_end)) / 60), 60), ' minutes ', 
         MOD(SUM(TIMESTAMPDIFF(SECOND, dt_start, dt_end)), 60), ' seconds' 
    ) AS total 
FROM configurations c 
JOIN deployments d 
ON c.id = d.configuration_id 
WHERE YEAR(dt_start) = 2021 
AND YEAR(dt_end) = 2021
GROUP BY tier 
ORDER BY tier;
