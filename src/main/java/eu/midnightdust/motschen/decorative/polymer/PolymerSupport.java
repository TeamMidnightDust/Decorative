package eu.midnightdust.motschen.decorative.polymer;

import eu.midnightdust.motschen.decorative.polymer.model.*;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;

import static eu.midnightdust.motschen.decorative.DecorativeMain.MOD_ID;

public class PolymerSupport {
    public static void init() {
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        
        DirectionalItemDisplayModel.initModels();
        SimpleItemDisplayModel.initModels();
        VariedItemDisplayModel.initModels();
        ItemDisplayBirdBathModel.initModels();
        ItemDisplayCeilingFanModel.initModels();
        ItemDisplayChristmasLightsModel.initModels();
        ItemDisplayChristmasTreeModel.initModels();
        ItemDisplayDigitalClockModel.initModels();
        ItemDisplayDoubleLampModel.initModels();
        ItemDisplayLampModel.initModels();
        ItemDisplayPoolWallModel.initModels();
        ItemDisplaySlidingDoorModel.initModels();
        ItemDisplaySpringboardModel.initModels();
        ItemDisplayTelevisionModel.initModels();
        ItemDisplayWallClockModel.initModels();
    }
}
