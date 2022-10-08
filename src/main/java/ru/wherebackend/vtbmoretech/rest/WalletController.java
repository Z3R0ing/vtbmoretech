package ru.wherebackend.vtbmoretech.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.vtbwallet.TransfersBetweenWallets;
import ru.wherebackend.vtbmoretech.vtbwallet.WorkingWithWallet;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WorkingWithWallet workingWithWallet;

    @Autowired
    private TransfersBetweenWallets transfersBetweenWallets;

    //Получение баланса
    @RequestMapping(value = "/getBalance",method = RequestMethod.GET)
    public String getBalance() {
        return workingWithWallet.getBalance();
    }

    //Получение истории
    @RequestMapping(value = "/getHistory",method = RequestMethod.GET)
    public String getHistory() {
        return workingWithWallet.getHistory();
    }

    //Получение баланса NFT
    @RequestMapping(value = "/getBalanceNFT",method = RequestMethod.GET)
    public String getBalanceNFT() {
        return workingWithWallet.getBalanceNFT();
    }

    //Получение информации по NFT
    @RequestMapping(value = "/getInformationNFT",method = RequestMethod.GET)
    public String getInformationNFT(@RequestParam("tokenId") String tokenId) {
        return workingWithWallet.getInformationNFT(tokenId);
    }

    //Получение списка сгенерированных NFT
    @RequestMapping(value = "/getGenerateListNFT",method = RequestMethod.GET)
    public String getGenerateListNFT(@RequestParam("transactionHash") String transactionHash) {
        return workingWithWallet.getGenerateListNFT(transactionHash);
    }

    //Генерация NFT
    @RequestMapping(value = "/generateNFT",method = RequestMethod.GET)
    public String generateNFT() {
        return workingWithWallet.generateNFT();
    }

    //Перевод Matic с кошелька на кошелек
    @RequestMapping(value = "/transferMatic",method = RequestMethod.GET)
    public String transferMatic(@RequestParam("toPublicKey") String toPublicKey, @RequestParam("amount") String amount) {
        return transfersBetweenWallets.transferMatic(toPublicKey, amount);
    }

    //Перевод Ruble с кошелька на кошелек
    @RequestMapping(value = "/transferRuble",method = RequestMethod.GET)
    public String transferRuble(@RequestParam("toPublicKey") String toPublicKey, @RequestParam("amount") String amount) {
        return transfersBetweenWallets.transferRuble(toPublicKey, amount);
    }

    //Перевод NFT с кошелька на кошелек
    @RequestMapping(value = "/transferNFT",method = RequestMethod.GET)
    public String transferNFT(@RequestParam("toPublicKey") String toPublicKey, @RequestParam("amount") String amount) {
        return transfersBetweenWallets.transferNFT(toPublicKey, amount);
    }

    //Запрос статуса выполнения транзакции
    @RequestMapping(value = "/transferStatus",method = RequestMethod.GET)
    public String transferStatus(@RequestParam("transactionHash") String transactionHash) {
        return transfersBetweenWallets.transferStatus(transactionHash);
    }

}
