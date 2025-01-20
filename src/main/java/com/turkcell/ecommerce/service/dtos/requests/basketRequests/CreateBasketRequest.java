package com.turkcell.ecommerce.service.dtos.requests.basketRequests;

import com.turkcell.ecommerce.entity.BasketDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketRequest {
    private List<BasketDetail> basketDetails;
}
