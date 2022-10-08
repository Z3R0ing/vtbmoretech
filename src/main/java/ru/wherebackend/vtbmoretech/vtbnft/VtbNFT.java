package ru.wherebackend.vtbmoretech.vtbnft;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.wherebackend.vtbmoretech.entity.Employee;

import java.util.Objects;

@Component("vtbmt_VtbNFT")
@Service
public class VtbNFT {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Autowired
    private GetKeys getKeys;

    String baseUrl = "https://hackathon.lsp.team/hk";

    //Генерация NFT
    public String generateNFT() {
        String publicKey = Objects.requireNonNull(getKeys.getKeys()).getPublicKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"toPublicKey\": \"" + publicKey + "\",\r\n  \"uri\": \"ipfs://bafybeifesqvvmmtcjlmeso3zaqh56mhttgza2eglw7zwy4ryuyifduy4i/images/star.png\",\r\n  \"nftCount\": 1\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl + "/v1/nft/generate")
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

    //Получение баланса NFT
    public String getBalanceNFT() {
        String publicKey = Objects.requireNonNull(getKeys.getKeys()).getPublicKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl + "/v1/wallets/" + publicKey +"/nft/balance")
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

    //Получение информации по NFT
    public String getInformationNFT(String tokenId) {
        String publicKey = Objects.requireNonNull(getKeys.getKeys()).getPublicKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl + "/v1/nft/" + tokenId)
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