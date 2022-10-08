package ru.wherebackend.vtbmoretech.service;

import ru.wherebackend.vtbmoretech.entity.employee.Employee;
import ru.wherebackend.vtbmoretech.entity.event.NFT;

public interface NftService {

    NFT fromUrl(String url, String name, String description);

    NFT moveNFTToEmployee(Employee newEmployee, NFT nft);

}
