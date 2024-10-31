package com.product.trial.master.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.trial.master.model.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateProduct() throws Exception {
        Product product = new Product();
        product.setCode("P123");
        product.setName("Test Product");
        product.setDescription("A sample product for testing.");
        product.setCategory("Electronics");
        product.setPrice(99.99);
        product.setQuantity(10);
        product.setInternalReference("REF123");
        product.setShellId(1L);
        product.setInventoryStatus(Product.InventoryStatus.INSTOCK);
        product.setRating(4);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Test Product"));
    }

    @Test
    public void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetProductById() throws Exception {
        Product product = new Product();
        product.setCode("P456");
        product.setName("Another Product");
        product.setCategory("Books");
        product.setPrice(45.00);
        product.setQuantity(5);
        product.setInternalReference("REF456");
        product.setShellId(2L);
        product.setInventoryStatus(Product.InventoryStatus.LOWSTOCK);
        product.setRating(5);

        String productJson = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isOk())
                .andReturn();

        Long productId = 1L; 
        mockMvc.perform(get("/products/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Another Product"));
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Product product = new Product();
        product.setCode("P789");
        product.setName("Update Test Product");
        product.setCategory("Home");
        product.setPrice(79.99);
        product.setQuantity(3);
        product.setInternalReference("REF789");
        product.setShellId(3L);
        product.setInventoryStatus(Product.InventoryStatus.OUTOFSTOCK);
        product.setRating(2);

        String productJson = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isOk());

        product.setName("Updated Product");
        product.setPrice(89.99);
        mockMvc.perform(patch("/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Product"))
                .andExpect(jsonPath("$.price").value(89.99));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Product product = new Product();
        product.setCode("P999");
        product.setName("Delete Test Product");
        product.setCategory("Toys");
        product.setPrice(15.50);
        product.setQuantity(1);
        product.setInternalReference("REF999");
        product.setShellId(4L);
        product.setInventoryStatus(Product.InventoryStatus.INSTOCK);
        product.setRating(3);

        String productJson = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        Long productId = 1L; 
        mockMvc.perform(delete("/products/" + productId))
                .andExpect(status().isNoContent());
    }
}