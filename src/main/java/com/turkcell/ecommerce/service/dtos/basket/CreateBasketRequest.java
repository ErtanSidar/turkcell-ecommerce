package com.turkcell.ecommerce.service.dtos.basket;

import com.turkcell.ecommerce.service.dtos.BasketItemList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketRequest {
    private int userId;
    private List<BasketItemList> basketItems;
}
