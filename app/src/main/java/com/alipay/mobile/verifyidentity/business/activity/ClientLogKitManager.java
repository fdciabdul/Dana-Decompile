package com.alipay.mobile.verifyidentity.business.activity;

/* loaded from: classes3.dex */
public class ClientLogKitManager {
    public static ClientLogKit logKit = new DefaultClientLogKit();

    public static void injectClientLogKit(ClientLogKit clientLogKit) {
        if (clientLogKit == null) {
            return;
        }
        logKit = clientLogKit;
    }

    public static ClientLogKit getClientLogKit() {
        return logKit;
    }
}
