package ru.wherebackend.vtbmoretech.service;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.wherebackend.vtbmoretech.entity.employee.Employee;
import ru.wherebackend.vtbmoretech.entity.event.NFT;
import ru.wherebackend.vtbmoretech.nftapi.data.GeneratedNftListDTO;
import ru.wherebackend.vtbmoretech.nftapi.data.TransactionDTO;
import ru.wherebackend.vtbmoretech.utils.MappingUtils;
import ru.wherebackend.vtbmoretech.vtbwallet.WorkingWithWallet;

@Service
public class NftServiceImpl implements NftService {
    private final CurrentAuthentication currentAuthentication;
    private final DataManager dataManager;
    private final WorkingWithWallet walletService;

    public NftServiceImpl(
            CurrentAuthentication currentAuthentication,
            DataManager dataManager,
            WorkingWithWallet walletService) {
        this.currentAuthentication = currentAuthentication;
        this.dataManager = dataManager;
        this.walletService = walletService;
    }

    @Override
    public NFT fromUrl(String url, String name, String description) {
        UserDetails user = currentAuthentication.getUser();
        Employee employee = dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.username = :user")
                .parameter("user", user.getUsername())
                .fetchPlan("for-employee")
                .one();
        NFT nft = dataManager.create(NFT.class);
        nft.setDescription(description);
        nft.setName(name);
        nft.setOwner(employee);
        String transactionData = walletService.generateNFT(url);
        TransactionDTO transactionDTO =
                MappingUtils.mapJson(transactionData, TransactionDTO.class);
        String nftInto = walletService.getGenerateListNFT(transactionDTO.getTransactionHash());
        GeneratedNftListDTO genNftListDTO =
                MappingUtils.mapJson(nftInto, GeneratedNftListDTO.class);
        nft.setToken(
                genNftListDTO
                        .getTokens()
                        .stream()
                        .findFirst()
                        .get()
        );
        return dataManager.save(nft);
    }

    public NFT moveNFTToEmployee(Employee newEmployee, NFT nft) {
        // TODO
        //  1. ?????????????????? ?? ???????????????? ?????????????????????? ?????????????????? ?????????????????? ???? ?????????????? ???????????? ??????????????????
        //  2. ?????????????? ???????????? ?? NFT
        throw new RuntimeException("not yet");
    }

}
