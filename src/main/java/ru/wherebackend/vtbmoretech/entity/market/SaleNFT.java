package ru.wherebackend.vtbmoretech.entity.market;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import ru.wherebackend.vtbmoretech.entity.event.NFT;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "VTBMT_SALE_NFT")
@Entity(name = "vtbmt_SaleNFT")
public class SaleNFT {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NFT_ID")
    private NFT nft;

    @Column(name = "PRICE")
    private Double price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public NFT getNft() {
        return nft;
    }

    public void setNft(NFT nft) {
        this.nft = nft;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @InstanceName
    @DependsOnProperties({"nft", "price"})
    public String getInstanceName() {
        return String.format("%s: %s", nft, price);
    }
}