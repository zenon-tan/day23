package day23.workshop.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import day23.workshop.models.Order;

@Repository
public class OrderRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String GET_BY_ID_SQL = """
        select o.id order_id, o.order_date, o.customer_id,
        d.quantity*d.unit_price as total_price,
        d.quantity*p.standard_cost as cost_price
        from orders o inner join order_details d
        on o.id = d.order_id inner join products p
        on d.product_id = p.id where order_id = ?
            """;

    public List<Order> getOrderById(int id) {

        return jdbcTemplate.query(GET_BY_ID_SQL, 
        BeanPropertyRowMapper.newInstance(Order.class), id);
        
    }
    
}
