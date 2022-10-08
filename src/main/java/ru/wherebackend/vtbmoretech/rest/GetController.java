package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.Employee;
import ru.wherebackend.vtbmoretech.entity.Event;
import ru.wherebackend.vtbmoretech.entity.News;
import ru.wherebackend.vtbmoretech.vtbwallet.TransfersBetweenWallets;
import ru.wherebackend.vtbmoretech.vtbwallet.WorkingWithWallet;

import java.util.List;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/get")
public class GetController {

    @Autowired
    private DataManager dataManager;

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
    @RequestMapping(value = "/getBalanceNFT",method = RequestMethod.GET)
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

    //Получение информации о пользователе
    @RequestMapping(value = "/getInfoEmployee",method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam("userId") UUID userId) {
        return dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.id = :userId")
                .parameter("userId", userId)
                .fetchPlan("for-employee")
                .one();
    }

    //Получение новостей
    @RequestMapping(value = "/getNews",method = RequestMethod.GET)
    public List<News> getNews() {
        return dataManager.load(News.class).all().list();
    }

    //Получение событий
    @RequestMapping(value = "/getEvent",method = RequestMethod.GET)
    public List<Event> getEvent() {
        return dataManager.load(Event.class).all().list();
    }
}
