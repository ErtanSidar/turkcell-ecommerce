package com.turkcell.ecommerce.service.dtos.requests.categoryRequests;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

    @Size(max = 100)
    private String name;

    private int parentId;

}
