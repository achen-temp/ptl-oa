
####
SELECT cities.name, sum(sessions.duration) 
FROM cities
JOIN clients
ON cities.id = clients.city_id
JOIN sessions
ON clients.id = sessions.client_id
GROUP BY cities.name
ORDER BY sum(sessions.duration) ASC, cities.name ASC;