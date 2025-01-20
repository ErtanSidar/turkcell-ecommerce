package com.turkcell.ecommerce.service.dtos.requests.productRequests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {

    @Size(max = 50)
    private String name;

    @Size(max = 500)
    private String description;

    @Min(value = 1)
    private double price;

    @Min(value = 0)
    private int stock;
    private String imageUrl;
    private int categoryId;
}
