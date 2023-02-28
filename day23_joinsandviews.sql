use northwind;

SELECT Orders.ID, customers.first_name
FROM Orders
INNER JOIN Customers ON Orders.Customer_id = customers.id;

# Left Join - If record on the right does not intersect with left, it won't be shown
# But all records on the left will be shown
SELECT Orders.ID, customers.first_name
FROM customers
left JOIN orders ON Orders.Customer_id = customers.id
order by customers.first_name;

#Right join
SELECT Orders.ID, customers.first_name
FROM orders
right JOIN customers ON Orders.Customer_id = customers.id
order by orders.id;

# Create view
create view Orders2023 as
SELECT Orders.ID, customers.first_name
FROM customers
left JOIN orders ON Orders.Customer_id = customers.id
order by customers.first_name;

create view boston_customers as
select first_name, last_name, job_title
from customers
where city = 'boston';

# See the view
select * from orders2023;

create view customer_order_count as
select customer_id, count(customer_id) 
from orders
group by customer_id
order by count(customer_id) desc;

select * from customer_order_count;

select customers.first_name, orders.*
from orders
inner join customers on orders.customer_id = customers.id;

# Subqueries
# Select object from an already quried table
#Group by needs to include the columns you want displayed
select employee_id, ship_city, count(*) from
	#Subquery will be executed first, then it'll be filtered
	(select customers.first_name, orders.*
	from orders
	inner join customers on orders.customer_id = customers.id
	where employee_id in (9))
as customer_ship
group by employee_id, ship_city;

select employee_id, sum(cnt) from
	(select employee_id, ship_city, count(*) as cnt from
	#Subquery will be executed first, then it'll be filtered
		(select customers.first_name, orders.*
		from orders
		inner join customers on orders.customer_id = customers.id
		where employee_id in (9))
	as customer_ship
	group by employee_id, ship_city) overall
    group by employee_id;
    
/*
Steps:
1) Create the inner query in the brackets first
2) Give the inner query an alias
3) Query the inner query
*/
