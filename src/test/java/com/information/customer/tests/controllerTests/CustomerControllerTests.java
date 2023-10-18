package com.information.customer.tests.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.information.customer.controllers.CustomerController;
import com.information.customer.model.Customer;
import com.information.customer.services.CustomerService;
import com.information.customer.tests.testUtils.CustomerListUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    public void postCustomer() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/customers/addCustomer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CustomerListUtility.getCustomerlist().get(1)))

        ).andDo(MockMvcResultHandlers.print());


        verify(customerService, times(1)).addCustomer(any(Customer.class));
    }

    @Test
    public void getCustomersByFirstName() throws Exception {
        final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/customers/name/{name}", "Harry").contentType(MediaType.APPLICATION_JSON);
        when(customerService.getCustomersByFirstName("Harry")).thenReturn(CustomerListUtility.getCustomerlist().stream().filter(customer -> customer.getFirstName().equals("Harry")).toList());
        mockMvc.perform(builder).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", is("Harry")));
        verify(customerService, times(1)).getCustomersByFirstName("Harry");
    }

    @Test
    public void getAllCustomers() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/customers/allCustomers")
        );
        verify(customerService, times(1)).getAllCustomers();
    }

    @Test
    public void updateCustomer() throws Exception {
        Customer customer = CustomerListUtility.getCustomerlist().get(1);
        customer.setCustomerId((long) 1);
        customer.setPhoneNumber("13245678");
        customer.getAddress().setId((long) 1);
        when(customerService.getCustomerById((long) 1)).thenReturn(customer);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/customers/updateCustomer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer))
        );
        verify(customerService, times(1)).updateCustomer(any(Customer.class));
    }

    @Test
    public void deleteCustomer() throws Exception {
        Customer customer = CustomerListUtility.getCustomerlist().get(1);
        when(customerService.getCustomerById((long) 1)).thenReturn(customer);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/customers/deleteCustomer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer))
        );
        verify(customerService, times(1)).deleteCustomer(any(Customer.class));
    }

}
