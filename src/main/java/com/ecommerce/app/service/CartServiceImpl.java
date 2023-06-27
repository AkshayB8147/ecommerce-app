package com.ecommerce.app.service;

import com.ecommerce.app.dto.cart.AddToCartDto;
import com.ecommerce.app.dto.cart.CartDto;
import com.ecommerce.app.dto.cart.CartItemDto;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.repository.CartRepository;
import com.ecommerce.app.service.dao.CartService;
import com.ecommerce.app.service.mappers.CartItemDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemDtoMapper cartItemDtoMapper;

    @Override
    public CartDto getCart(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItemList = cartList
                .stream()
                .map(cartItemDtoMapper)
                .collect(Collectors.toList());
        double totalCost = cartItemList
                .stream()
                .mapToDouble(cartItem -> (cartItem.getProduct().getPrice() * cartItem.getQuantity()))
                .sum();
        return new CartDto(cartItemList, totalCost);
    }

    @Override
    public void addToCart(AddToCartDto addToCartDto, Product product, User user) {
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        log.info("Product added to cart: {}",cartRepository.save(cart));
    }

}
