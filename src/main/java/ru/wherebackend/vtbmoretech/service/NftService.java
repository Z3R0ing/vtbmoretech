package ru.wherebackend.vtbmoretech.service;

import ru.wherebackend.vtbmoretech.entity.event.NFT;

public interface NftService {

    NFT fromUrl(String url, String name, String description);

}
