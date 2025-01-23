package com.turkcell.ecommerce.service.dtos.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    @Size(max = 50)
    private String name;

    @Min(value = 0, message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Stock quantity cannot be negative")
    private int stock;
}
