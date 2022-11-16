package com.ptl.exercise.Redolent;

public class Sql_BinaryTree {

    /*

    SELECT ID,
        CASE
            WHEN P_ID IS NULL THEN "ROOT"
            WHEN ID IN (SELECT P_ID FROM TREE) AND ID IN (SELECT ID FROM TREE) THEN "INNER"
        ELSE "LEAF"
        END AS Output
    FROM TREE
    ORDER BY ID ASC;

     */
}
