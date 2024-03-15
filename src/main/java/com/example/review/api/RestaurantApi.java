package com.example.review.api;

import com.example.review.api.request.CreateAndEditRestaurantRequest;
import com.example.review.api.response.RestaurantDetailView;
import com.example.review.api.response.RestaurantView;
import com.example.review.model.RestaurantEntity;
import com.example.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantApi {
    private final RestaurantService restaurantService;

     @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants(){
        return restaurantService.getAllRestaurants();
    }

     @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ){
         return restaurantService.getRestaurantDetail(restaurantId);
    }

//    @PostMapping("/restaurant")
//    public String createRestaurant(
//            @RequestBody CreateAndEditRestaurantRequest request
//            ){
//        StringBuilder menus = new StringBuilder();
//        request.getMenus().forEach((menu)->{
//            menus.append(menu.getName()).append(", ").append(menu.getPrice());
//        });
//        return "This is createRestaurant(), name=" + request.getName() + " , address=" + request.getAddress() + ", menus=" + menus ;
//    }

    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ){
        restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ){
         restaurantService.editRestaurant(restaurantId, request);
//        return "This is editRestaurant(), name=" + request.getName() + " , address=" + request.getAddress();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        restaurantService.deleteRestaurant(restaurantId);
    }







}
