SELECT * FROM netology.Orders INNER JOIN netology.Customers
ON (netology.Orders.customer_id = netology.Customers.id)
WHERE lower(Customers.name)=:name
