package day23.workshop.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private Date orderDate;
    private int customerId;
    private Float totalPrice;
    private Float costPrice;

    
}
