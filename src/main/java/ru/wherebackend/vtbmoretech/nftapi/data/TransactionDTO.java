package ru.wherebackend.vtbmoretech.nftapi.data;

import java.io.Serializable;

public class TransactionDTO implements Serializable {

    private String transactionHash;

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }
}
