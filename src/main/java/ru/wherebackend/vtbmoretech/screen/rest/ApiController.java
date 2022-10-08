package ru.wherebackend.vtbmoretech.screen.rest;

import io.jmix.core.DataManager;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.wherebackend.vtbmoretech.entity.Employee;
import ru.wherebackend.vtbmoretech.entity.User;
import org.json.JSONObject;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/wallet")
public class ApiController {

    @Autowired
    private DataManager dataManager;

    String baseUrl = "https://hackathon.lsp.team/hk";

    private Employee getEmployee() {
        User userCheck = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return getPrivateKey(userCheck);
    }

    private void getPrivateKey(User user) {
        Employee employee = dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user = :user")
                .parameter("user", user)
                .fetchPlan("for-employee")
                .one();
        try {
            if (getEmployee().getPrivateKey() == null) {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("text/plain");
                RequestBody body = RequestBody.create(mediaType, "");
                Request request = new Request.Builder()
                        .url(baseUrl + "/v1/wallets/new")
                        .method("POST", body)
                        .build();
                Response response = client.newCall(request).execute();
                JSONObject myObject = new JSONObject(response.body().string());
                String privateToken = response.body().string().split(":")[1];
                response.close();
                //Сохранение ключа
                employee = getEmployee();
                employee.setPublicKey(privateKeyResult);
                employee.setPrivateKey(privateKeyResult);
                dataManager.save(employee);
            } else {
                System.out.println("Ключ уже сохранен");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @RequestMapping(value = "/getBalance",method = RequestMethod.GET)
    public String getBalance() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl + "/v1/wallets/" + "" + "/balance")
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
}
