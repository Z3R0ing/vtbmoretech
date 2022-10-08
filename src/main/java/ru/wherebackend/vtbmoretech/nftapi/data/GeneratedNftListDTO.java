package ru.wherebackend.vtbmoretech.nftapi.data;

import java.util.List;

public class GeneratedNftListDTO {

    private String wallet_id;
    private List<Long> tokens;

    public String getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(String wallet_id) {
        this.wallet_id = wallet_id;
    }

    public List<Long> getTokens() {
        return tokens;
    }

    public void setTokens(List<Long> tokens) {
        this.tokens = tokens;
    }
}
