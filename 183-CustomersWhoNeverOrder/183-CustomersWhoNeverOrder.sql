-- Last updated: 7/9/2026, 10:06:21 AM
SELECT
    name AS Customers
FROM Customers
WHERE id NOT IN (
    SELECT customerId
    FROM Orders
);