package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.entity.BasketItem;
import com.turkcell.ecommerce.entity.Order;
import com.turkcell.ecommerce.entity.OrderItem;
import com.turkcell.ecommerce.entity.Product;
import com.turkcell.ecommerce.repository.OrderItemRepository;
import com.turkcell.ecommerce.service.abstracts.OrderItemService;
import com.turkcell.ecommerce.service.abstracts.ProductService;
import com.turkcell.ecommerce.service.dtos.BasketItemList;
import com.turkcell.ecommerce.service.dtos.orderItem.CreateOrderItemRequest;
import com.turkcell.ecommerce.service.dtos.orderItem.UpdateOrderItemRequest;
import com.turkcell.ecommerce.service.rules.ProductBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductBusinessRules productBusinessRules;
    private final ProductService productService;


    @Override
    public OrderItem getById(int id) {
        return orderItemRepository.findById(id).get();
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public void add(CreateOrderItemRequest createOrderItemRequest) {

        checkProductStockForOrder(createOrderItemRequest.getBasketItems());

        List<OrderItem> orderItems = new ArrayList<>();

        for (BasketItem basketItem : createOrderItemRequest.getBasketItems()) {

            OrderItem orderItem = new OrderItem();

            Order order = new Order();
            order.setId(createOrderItemRequest.getOrderId());
            orderItem.setOrder(order);

            Product product = new Product();
            product.setId(basketItem.getProduct().getId());
            orderItem.setProduct(product);

            updateProductQuantity(basketItem.getProduct().getId(), basketItem.getQuantity());

            orderItem.setQuantity(basketItem.getQuantity());
            orderItem.setUnitPrice(basketItem.getTotalPrice());
            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

    }

    @Override
    public void update(UpdateOrderItemRequest updateOrderItemRequest, int id) {

    }

    @Override
    public void delete(int id) {
        orderItemRepository.deleteById(id);
    }

    private void checkProductStockForOrder(List<BasketItem> basketItems) {
        List<BasketItemList> basketItemLists = new ArrayList<>();
        for (BasketItem basketItem : basketItems) {
            BasketItemList basketItemList = new BasketItemList();
            basketItemList.setProductId(basketItem.getProduct().getId());
            basketItemList.setQuantity(basketItem.getQuantity());
            basketItemLists.add(basketItemList);
        }

        productBusinessRules.checkProductStock(basketItemLists);
    }

    private void updateProductQuantity(int productId, int quantity) {
        productService.updateProductQuantity(productId, quantity);
    }
}
