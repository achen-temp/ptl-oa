
        SELECT DISTINCT name
        FROM animals
        WHERE id in (SELECT animal_id FROM tracklog)
        ORDER BY name ASC;


