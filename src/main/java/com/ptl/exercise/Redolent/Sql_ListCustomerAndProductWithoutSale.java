package com.ptl.exercise.redolent;

//passed all tests
/*
SELECT 
    'customer' AS category, 
    c.id AS id, 
    c.customer_name AS name
FROM 
    customer c
LEFT JOIN 
    invoice i ON c.id = i.customer_id
WHERE 
    i.id IS NULL

UNION

SELECT 
    'product' AS category, 
    p.id AS id, 
    p.product_name AS name
FROM 
    product p
LEFT JOIN 
    invoice_item ii ON p.id = ii.product_id
WHERE 
    ii.id IS NULL

ORDER BY id;
*/