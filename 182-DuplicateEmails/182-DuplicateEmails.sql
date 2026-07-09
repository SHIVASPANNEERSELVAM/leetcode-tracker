-- Last updated: 7/9/2026, 10:06:24 AM
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;