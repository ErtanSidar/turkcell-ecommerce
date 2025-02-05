package com.turkcell.ecommerce.service.dtos.order;

import com.turkcell.ecommerce.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private OrderStatus status;
}
