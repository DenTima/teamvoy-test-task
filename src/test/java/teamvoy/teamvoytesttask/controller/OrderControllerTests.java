package teamvoy.teamvoytesttask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import teamvoy.teamvoytesttask.dto.OrderRequestDto;
import teamvoy.teamvoytesttask.model.Order;
import teamvoy.teamvoytesttask.service.OrderService;
import teamvoy.teamvoytesttask.service.mapper.OrderMapper;
import java.math.BigDecimal;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static teamvoy.teamvoytesttask.model.ItemType.PHONE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderController.class)
public class OrderControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private OrderService orderService;
    @MockBean
    private OrderMapper orderMapper;

    private OrderRequestDto orderRequest;

    @BeforeEach
    public void setUp() {
        orderRequest = new OrderRequestDto(new BigDecimal(12), 3, PHONE);
    }

    @Test
    public void createOrder_Ok() throws Exception {
        Order order = new Order();
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        order.setItem(orderRequest.getItem());
        when(orderService.save(any(Order.class))).thenReturn(order);

        mockMvc.perform(post("/orders")
                .content(mapper.writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
