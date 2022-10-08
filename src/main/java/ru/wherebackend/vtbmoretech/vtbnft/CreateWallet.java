package ru.wherebackend.vtbmoretech.vtbnft;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.wherebackend.vtbmoretech.entity.Employee;

@Component("vtbmt_GetKeys")
@Service
public class CreateWallet {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentAuthentication currentAuthentication;
    String baseUrl = "https://hackathon.lsp.team/hk";

    //Получение ключей
    public Employee getKeys() {
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
}