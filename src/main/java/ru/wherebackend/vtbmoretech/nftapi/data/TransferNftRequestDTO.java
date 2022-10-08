package ru.wherebackend.vtbmoretech.nftapi.data;

import java.io.Serializable;

public class TransferNftRequestDTO implements Serializable {

    private String fromPrivateKey;
    private String toPublicKey;
    private Long tokenId;

    public TransferNftRequestDTO() {
    }

    public TransferNftRequestDTO(String fromPrivateKey, String toPublicKey, Long tokenId) {
        this.fromPrivateKey = fromPrivateKey;
        this.toPublicKey = toPublicKey;
        this.tokenId = tokenId;
    }

    public String getFromPrivateKey() {
        return fromPrivateKey;
    }

    public void setFromPrivateKey(String fromPrivateKey) {
        this.fromPrivateKey = fromPrivateKey;
    }

    public String getToPublicKey() {
        return toPublicKey;
    }

    public void setToPublicKey(String toPublicKey) {
        this.toPublicKey = toPublicKey;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }
}
