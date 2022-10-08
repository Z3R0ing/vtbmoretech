package ru.wherebackend.vtbmoretech.nftapi;

import ru.wherebackend.vtbmoretech.nftapi.data.WalletDTO;

public interface VTBApiService {

    WalletDTO newWallet();

    void transferMatic();

    void transferRuble();

    void transferNft();

    void transactionStatus();

    void getBalance();

    void geNftBalance();

    void generateNft();

    void getGeneratedNft();

    void getNftInfo();

    void getTransactionHistory();

}
