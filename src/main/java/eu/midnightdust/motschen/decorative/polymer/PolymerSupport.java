package eu.midnightdust.motschen.decorative.polymer;

import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayBirdBathModel;
import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayCeilingFanModel;
import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayChristmasLightsModel;
import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayChristmasTreeModel;
import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayDigitalClockModel;

public class PolymerSupport {
    public static void init() {
        ItemDisplayBirdBathModel.initModels();
        ItemDisplayCeilingFanModel.initModels();
        ItemDisplayChristmasLightsModel.initModels();
        ItemDisplayChristmasTreeModel.initModels();
        ItemDisplayDigitalClockModel.initModels();
    }
}
