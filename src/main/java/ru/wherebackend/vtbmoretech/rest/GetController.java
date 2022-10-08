package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.wherebackend.vtbmoretech.entity.Employee;
import org.json.JSONObject;

import java.util.Objects;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/wallet")
public class GetController {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentAuthentication currentAuthentication;

    String baseUrl = "https://hackathon.lsp.team/hk";

    //Сохранение ключей
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
            } else {
                System.out.println("Key already save");
            }
            return employee;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    //Получение баланса
    @RequestMapping(value = "/getBalance",method = RequestMethod.GET)
    public String getBalance() {
        String publicKey = Objects.requireNonNull(getKeys()).getPublicKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl + "/v1/wallets/" + publicKey +"/balance")
                    .method("GET", body)
                    .build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            response.close();
            return responseData;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    //Получение истории
    @RequestMapping(value = "/getHistory",method = RequestMethod.GET)
    public String getHistory() {
        String publicKey = Objects.requireNonNull(getKeys()).getPublicKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"page\": 100,\r\n  \"offset\": 20,\r\n  \"sort\": \"asc\"\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl + "/v1/wallets/" + publicKey + "/history")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            response.close();
            return responseData;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
