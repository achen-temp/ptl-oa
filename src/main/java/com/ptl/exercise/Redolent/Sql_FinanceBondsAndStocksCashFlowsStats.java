package com.ptl.exercise.redolent;

public class Sql_FinanceBondsAndStocksCashFlowsStats {
    
}

/* -- passed all tests
1. SQL: Finance Bonds and stocks Cash Flows stats
// 

SELECT b.name AS name, 'Bond' AS asset_type, ROUND(SUM(bp.cash_flow), 2) AS sum_cash_flows
FROM bonds b
JOIN bond_payments bp 
ON b.id = bp.bond_id
GROUP BY b.name
HAVING SUM(bp.cash_flow) > 2000.00

UNION ALL

SELECT s.name AS name, 'Stock' AS asset_type, ROUND(SUM(sp.dividend), 2) AS sum_cash_flows
FROM stocks s
JOIN stock_payments sp 
ON s.id = sp.stock_id
GROUP BY s.name
HAVING SUM(sp.dividend) > 2000.00

ORDER BY name;

 
 */