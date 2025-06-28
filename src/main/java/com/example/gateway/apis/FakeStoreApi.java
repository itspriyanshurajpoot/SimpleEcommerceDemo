package com.example.gateway.apis;

import com.example.dtos.FakeStoreProductDTO;
import com.example.dtos.ProductDTO;
import com.example.dtos.FakeStoreCategoryResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Component
public interface FakeStoreApi {

    @GET("products/category")
    Call<FakeStoreCategoryResponseDto> getAllFakeStoreCategories();

    @GET("products/category")
    Call<FakeStoreProductDTO> getAllFakeStoreProductsByCategory(@Query("type") String type);

    @GET("products/{id}")
    Call<FakeStoreProductDTO> getAllProductById(@Path("id") int id);
}
