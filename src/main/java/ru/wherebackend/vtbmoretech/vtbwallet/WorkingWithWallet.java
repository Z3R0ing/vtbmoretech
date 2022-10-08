package ru.wherebackend.vtbmoretech.vtbwallet;

import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.wherebackend.vtbmoretech.exception.CouldNotCreateNftException;
import ru.wherebackend.vtbmoretech.url.BaseUrl;

import java.util.Objects;

@Service("vtbmt_UserInfo")
public class WorkingWithWallet {

    @Autowired
    private CreateWallet createWallet;

    @Autowired
    private BaseUrl baseUrl;

    public String publicKey = Objects.requireNonNull(createWallet.getKeys()).getPublicKey();

    //Получение баланса
    public JSONObject getBalance() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/wallets/" + publicKey +"/balance")
                    .method("GET", body)
                    .build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            JSONObject jsonObject = new JSONObject(responseData);
            jsonObject.getString("maticAmount");
            jsonObject.getString("coinsAmount");

            JSONObject jsonObjectResult = new JSONObject();
            jsonObjectResult.put("maticAmount", jsonObject.getString("maticAmount"));
            jsonObjectResult.put("coinsAmount", jsonObject.getString("coinsAmount"));
            response.close();
            return jsonObjectResult;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    //Получение истории
    public String getHistory() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"page\": 100,\r\n  \"offset\": 20,\r\n  \"sort\": \"asc\"\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/wallets/" + publicKey + "/history")
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

    //Генерация NFT
    public String generateNFT() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"toPublicKey\": \"" + publicKey + "\",\r\n  \"uri\": \"ipfs://bafybeifesqvvmmtcjlmeso3zaqh56mhttgza2eglw7zwy4ryuyifduy4i/images/star.png\",\r\n  \"nftCount\": 1\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/nft/generate")
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

    public String generateNFT(String url) {
        String publicKey = Objects.requireNonNull(createWallet.getKeys()).getPublicKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"toPublicKey\": \"" + publicKey + "\",\r\n  \"uri\": \"" + url + "\",\r\n  \"nftCount\": 1\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/nft/generate")
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
        throw new CouldNotCreateNftException();
    }

    //Получение баланса NFT
    public String getBalanceNFT() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/wallets/" + publicKey +"/nft/balance")
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
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/nft/" + tokenId)
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

    //Получение списка сгенерированных NFT
    public String getGenerateListNFT(String transactionHash) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/nft/generate/" + transactionHash)
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