

    /**
     * STUDENT table has ID/NAME/SCORE columns.
     * FIND 3 highest scores students, PRINT their ID and NAME
     * NAME in descending order and then ID in ascending order
     */
 
    SELECT id, name
    FROM student
    ORDER BY score DESC, name DESC, id ASC
    LIMIT 3



