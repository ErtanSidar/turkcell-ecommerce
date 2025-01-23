package com.turkcell.ecommerce.service.dtos.basketItem;

import com.turkcell.ecommerce.service.dtos.BasketItemList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketItemRequest {
    private int basketId;
    private List<BasketItemList> basketItems;
}
