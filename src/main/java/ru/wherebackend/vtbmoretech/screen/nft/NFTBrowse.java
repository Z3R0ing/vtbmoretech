package ru.wherebackend.vtbmoretech.screen.nft;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.event.NFT;

@UiController("vtbmt_NFT.browse")
@UiDescriptor("nft-browse.xml")
@LookupComponent("nFTsTable")
public class NFTBrowse extends StandardLookup<NFT> {
}