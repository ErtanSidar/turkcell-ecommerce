package com.turkcell.ecommerce.service.dtos.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(max = 50)
    private String name;

    @Size(max = 500)
    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be greater than 0")
    private double price;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock quantity cannot be negative")
    private int stock;

    @NotNull(message = "Category ID is required")
    private int categoryId;

    private String imageUrl;
}
