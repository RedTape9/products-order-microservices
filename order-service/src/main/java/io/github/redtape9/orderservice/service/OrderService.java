package io.github.redtape9.orderservice.service;

import lombok.RequiredArgsConstructor;
import io.github.redtape9.orderservice.dto.OrderLineItemsDto;
import io.github.redtape9.orderservice.dto.OrderRequest;
import io.github.redtape9.orderservice.model.Order;
import io.github.redtape9.orderservice.model.OrderLineItems;
import io.github.redtape9.orderservice.repo.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {


    private final OrderRepository orderRepository;
    private final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        // call inventoryservice to check if the items are available and place order
        Boolean result = webClient.get()
                .uri("http://localhost:8082/api/inventory")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if(result){
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not availible in inventory.");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
