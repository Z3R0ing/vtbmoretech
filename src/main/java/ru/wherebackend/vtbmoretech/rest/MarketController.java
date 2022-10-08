package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.market.SaleNFT;
import ru.wherebackend.vtbmoretech.entity.market.Thing;

import java.util.List;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private DataManager dataManager;

    //Получение товаров
    @RequestMapping(value = "/getThings",method = RequestMethod.GET)
    public List<Thing> getThings() {
        return dataManager.load(Thing.class).all().fetchPlan("_instance_name").list();
    }

    //Получение товара
    @RequestMapping(value = "/getThing",method = RequestMethod.GET)
    public Thing getThing(@RequestParam("eventId") UUID thingId) {
        return dataManager.load(Thing.class).id(thingId).fetchPlan("_base").optional().orElse(null);
    }

    //Получение NFT продаж
    @RequestMapping(value = "/getSaleNFTs",method = RequestMethod.GET)
    public List<SaleNFT> getSaleNFTs() {
        return dataManager.load(SaleNFT.class).all().fetchPlan("_instance_name").list();
    }

    //Получение NFT продажи
    @RequestMapping(value = "/getSaleNFT",method = RequestMethod.GET)
    public SaleNFT getSaleNFT(@RequestParam("saleNFT") UUID saleNFT) {
        return dataManager.load(SaleNFT.class).id(saleNFT).fetchPlan("_base").optional().orElse(null);
    }

    @RequestMapping(value = "/saleNFT",method = RequestMethod.POST)
    public SaleNFT saleNFT(@RequestParam("idOfNFT") UUID idOfNFT, @RequestParam("price") Double price) {
        // TODO
        throw new RuntimeException("Not yet");
    }

    @RequestMapping(value = "/buyNFT",method = RequestMethod.POST)
    public boolean buyNFT(@RequestParam("idOfSaleNFT") UUID idOfSaleNFT) {
        // TODO тру, если купил; фалсе, если нет деняг
        throw new RuntimeException("Not yet");
    }

}
