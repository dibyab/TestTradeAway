package com.thoughtworks.assignment.controller;

import com.thoughtworks.assignment.controller.dto.CreateStockDTO;
import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.domain.Stock;
import com.thoughtworks.assignment.repository.StockRepository;
import com.thoughtworks.assignment.service.ItemService;
import com.thoughtworks.assignment.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vrushali on 6/21/17.
 */
@RestController
@RequestMapping(value = "/seller")
public class SellerController {

    @Resource
    private SellerService sellerService;

    @Resource
    private ItemService itemService;

    @Resource
    private StockRepository stockRepository;

    @RequestMapping(value = "/{sellerId}/getNewItems", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Item> getNewItemsForSeller( @PathVariable("sellerId") final int sellerId) {
        return sellerService.getNewItemsForSeller( sellerId);
    }

    @RequestMapping(value = "/{sellerId}/items",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewItem(@RequestBody final CreateStockDTO itemDTO, @PathVariable("sellerId") final int sellerId) {

        final Item item = itemService.find(itemDTO.getItemId());
        final Seller seller = sellerService.find(sellerId);

        Stock stock = new Stock(item,seller);
        stock.setQuantity( itemDTO.getQuantity());
        stock.setPrice( itemDTO.getPrice());

        stockRepository.save( stock);
    }
}
