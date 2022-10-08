package ru.wherebackend.vtbmoretech.screen.rest;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.wherebackend.vtbmoretech.entity.Employee;
import ru.wherebackend.vtbmoretech.entity.User;
import org.json.JSONObject;

import java.util.Objects;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/wallet")
public class ApiController {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentAuthentication currentAuthentication;

    String baseUrl = "https://hackathon.lsp.team/hk";

    private Employee getKeys() {
        UserDetails user = currentAuthentication.getUser();
        try {
        Employee employee = dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.username = :user")
                .parameter("user", user.getUsername())
                .fetchPlan("for-employee")
                .one();
            if (employee.getPrivateKey() == null && employee.getPublicKey() == null) {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("text/plain");
                RequestBody body = RequestBody.create(mediaType, "");
                Request request = new Request.Builder()
                        .url(baseUrl + "/v1/wallets/new")
                        .method("POST", body)
                        .build();
                Response response = client.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                String publicKey = jsonObject.getString("publicKey");
                String privateKey = jsonObject.getString("privateKey");
                response.close();
                //Сохранение ключей
                employee.setPublicKey(publicKey);
                employee.setPrivateKey(privateKey);
                dataManager.save(employee);
                return employee;
            } else {
                System.out.println("Key already save");
            }
            return employee;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @RequestMapping(value = "/getBalance",method = RequestMethod.GET)
    public String getBalance() {
        String publicKey = Objects.requireNonNull(getKeys()).getPublicKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl + "/v1/wallets/" + publicKey + "/balance")
                    .method("GET", body)
                    .build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            System.out.println(responseData);
            response.close();
            return responseData;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
