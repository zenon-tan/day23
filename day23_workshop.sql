use northwind;

select * from orders;

select * from order_details;

select * from products;

select id, quantity, unit_price from order_details;

select id, product_id, quantity*unit_price as total, 
quantity*standard_cost as cost from order_details;

select id, customer_id, order_date, shipped_date, ship_address from orders;

select o.id order_id, o.order_date, o.customer_id,
d.quantity*d.unit_price as total_price,
d.quantity*p.standard_cost as cost_price
from orders o
inner join order_details d
on o.id = d.order_id
inner join products p
on d.product_id = p.id
where order_id = 25; 