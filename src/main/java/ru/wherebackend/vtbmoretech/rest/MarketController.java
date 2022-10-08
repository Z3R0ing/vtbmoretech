package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.data.SaleNftDTO;
import ru.wherebackend.vtbmoretech.entity.event.NFT;
import ru.wherebackend.vtbmoretech.entity.market.SaleNFT;
import ru.wherebackend.vtbmoretech.entity.market.Thing;
import ru.wherebackend.vtbmoretech.nftapi.data.NftInfoDTO;
import ru.wherebackend.vtbmoretech.service.NftService;
import ru.wherebackend.vtbmoretech.utils.MappingUtils;
import ru.wherebackend.vtbmoretech.vtbwallet.TransfersBetweenWallets;
import ru.wherebackend.vtbmoretech.vtbwallet.WorkingWithWallet;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private WorkingWithWallet workingWithWallet;

    @Autowired
    private TransfersBetweenWallets transfersBetweenWallets;

    @Autowired
    private NftService nftService;


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
    public List<SaleNftDTO> getSaleNFTs() {
        return dataManager
                .load(SaleNFT.class)
                .all()
                .fetchPlan("_instance_name")
                .list()
                .stream()
                .map(saleNFT -> new SaleNftDTO(
                        saleNFT.getId(),
                        saleNFT.getPrice(),
                        saleNFT.getNft().getName(),
                        saleNFT.getNft().getDescription(),
                        saleNFT.getNft().getOwner().getName(),
                        nftService.getUri(saleNFT.getNft().getToken().toString())
                ))
                .collect(Collectors.toList());
    }

    //Получение NFT продажи
    @RequestMapping(value = "/getSaleNFT",method = RequestMethod.GET)
    public SaleNftDTO getSaleNFT(@RequestParam("saleNFT") UUID saleNFT) {
        SaleNFT nft = dataManager
                .load(SaleNFT.class)
                .id(saleNFT)
                .fetchPlan("_base")
                .one();
        return new SaleNftDTO(
            nft.getId(),
            nft.getPrice(),
            nft.getNft().getName(),
            nft.getNft().getDescription(),
            nft.getNft().getOwner().getName(),
            nftService.getUri(nft.getNft().getToken().toString())
        );
    }

    @RequestMapping(value = "/saleNFT",method = RequestMethod.POST)
    public SaleNFT saleNFT(@RequestParam("idOfNFT") UUID idOfNFT, @RequestParam("price") Double price) {
        NFT nft = dataManager.load(NFT.class)
                .id(idOfNFT)
                .fetchPlan("_base")
                .one();
        SaleNFT newSaleNFT = dataManager.create(SaleNFT.class);
        newSaleNFT.setNft(nft);
        newSaleNFT.setPrice(price);
        return dataManager.save(newSaleNFT);
    }

    @RequestMapping(value = "/buyNFT",method = RequestMethod.POST)
    public boolean buyNFT(@RequestParam("idOfSaleNFT") UUID idOfSaleNFT) {
        SaleNFT saleNFT = dataManager.load(SaleNFT.class)
                .id(idOfSaleNFT)
                .fetchPlan("_base")
                .one();
        JSONObject jsonObject = new JSONObject(workingWithWallet.getBalance());
        Double balance = jsonObject.getDouble("coinsAmount");
        return saleNFT.getPrice().equals(balance);
    }

}
