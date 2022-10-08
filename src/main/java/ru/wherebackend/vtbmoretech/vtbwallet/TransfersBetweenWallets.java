package ru.wherebackend.vtbmoretech.vtbwallet;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.wherebackend.vtbmoretech.url.BaseUrl;

@Component("vtbmt_VtbNFT")
@Service
public class TransfersBetweenWallets {

    @Autowired
    private CreateWallet createWallet;

    @Autowired
    private BaseUrl baseUrl;

    //Перевод Matic с кошелька на кошелек
    public String transferMatic(String toPublicKey, String amount) {
        String privateKey = createWallet.getKeys().getPrivateKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"fromPrivateKey\": \""+ privateKey +"\",\r\n  \"toPublicKey\": \"" + toPublicKey + "\",\r\n  \"amount\": "+ amount +"\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/transfers/matic")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            return "Успешно";
        } catch (Exception e) {
            e.getMessage();
        }
        return "Перевод не удался";
    }

    //Перевод Ruble с кошелька на кошелек
    public String transferRuble(String toPublicKey, String amount) {
        String privateKey = createWallet.getKeys().getPrivateKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"fromPrivateKey\": \""+ privateKey +"\",\r\n  \"toPublicKey\": \"" + toPublicKey + "\",\r\n  \"amount\": "+ amount +"\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/transfers/ruble")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            return "Успешно";
        } catch (Exception e) {
            e.getMessage();
        }
        return "Перевод не удался";
    }

    //Перевод NFT с кошелька на кошелек
    public String transferNFT(String toPublicKey, String amount) {
        String privateKey = createWallet.getKeys().getPrivateKey();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"fromPrivateKey\": \""+ privateKey +"\",\r\n  \"toPublicKey\": \"" + toPublicKey + "\",\r\n  \"amount\": "+ amount +"\r\n}");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/transfers/nft")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            return "Успешно";
        } catch (Exception e) {
            e.getMessage();
        }
        return "Перевод не удался";
    }

    //Запроса статуса выполнения транзакции
    public String transferStatus(String transactionHash) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(baseUrl.url + "/v1/transfers/status/" + transactionHash)
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            return "Успешно";
        } catch (Exception e) {
            e.getMessage();
        }
        return "Перевод не удался";
    }
}