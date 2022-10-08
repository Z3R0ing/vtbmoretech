package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.Employee;
import org.json.JSONObject;
import ru.wherebackend.vtbmoretech.entity.Event;
import ru.wherebackend.vtbmoretech.entity.News;
import ru.wherebackend.vtbmoretech.vtbwallet.WorkingWithWallet;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/get")
public class GetController {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private WorkingWithWallet workingWithWallet;

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
