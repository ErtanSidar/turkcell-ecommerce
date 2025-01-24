package com.turkcell.ecommerce.service.dtos.basketItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBasketItemRequest {
    private int productQuantity;
}
