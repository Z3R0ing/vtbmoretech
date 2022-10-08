package ru.wherebackend.vtbmoretech.screen.nft;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.event.NFT;

@UiController("vtbmt_NFT.edit")
@UiDescriptor("nft-edit.xml")
@EditedEntityContainer("nFTDc")
public class NFTEdit extends StandardEditor<NFT> {
}