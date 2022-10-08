package ru.wherebackend.vtbmoretech.nftapi.data;

import java.io.Serializable;

public class NftInfoDTO implements Serializable {

    private String tokenId;
    private String uri;
    private String publicKey;

    public NftInfoDTO() {
    }

    public NftInfoDTO(String tokenId, String uri, String publicKey) {
        this.tokenId = tokenId;
        this.uri = uri;
        this.publicKey = publicKey;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
