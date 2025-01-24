package com.turkcell.ecommerce.service.dtos.orderItem;

import com.turkcell.ecommerce.entity.BasketItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderItemRequest {

    private int orderId;
    private List<BasketItem> basketItems;
}
