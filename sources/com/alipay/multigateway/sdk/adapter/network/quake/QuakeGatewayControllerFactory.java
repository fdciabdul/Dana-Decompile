package com.alipay.multigateway.sdk.adapter.network.quake;

import android.content.Context;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.multigateway.sdk.GatewayController;

/* loaded from: classes7.dex */
public class QuakeGatewayControllerFactory {
    private static GatewayController sController;

    public static GatewayController createController(Context context) {
        GatewayController gatewayController = sController;
        if (gatewayController != null) {
            return gatewayController;
        }
        sController = new GatewayController();
        QuakeNetworkDelegate quakeNetworkDelegate = new QuakeNetworkDelegate();
        Quake.instance().addRequestInterceptor(quakeNetworkDelegate);
        sController.init(context, quakeNetworkDelegate);
        return sController;
    }

    public static GatewayController getController() {
        return sController;
    }
}
