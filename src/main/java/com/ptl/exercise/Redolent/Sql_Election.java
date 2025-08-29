package com.ptl.exercise.redolent;

public class Sql_Election {
    /**
     * SELECT c.party, count(constituency_id) AS 'Seats_won'
     * FROM Candidates c
     * INNER JOIN (
     *          SELECT *
     *          FROM Results
     *          WHERE votes in (SELECT MAX(votes) FROM Results r GROUP BY constituency_id )
     *          ) AS won
     * ON c.id = won.candidate_id
     * GROUP BY c.party;
     *
     */
}
