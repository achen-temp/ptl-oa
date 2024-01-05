
## find companies with compaign profit as positive
    

     SELECT companies.name, (campaigns.revenue - campaigns.expenses) AS profit
     FROM companies
     JOIN campaigns
     ON companies.id = campaigns.company_id
     ORDER BY (campaigns.revenue - campaigns.expenses) DESC
     LIMIT 3;



