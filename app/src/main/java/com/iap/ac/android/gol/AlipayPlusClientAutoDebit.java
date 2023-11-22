package com.iap.ac.android.gol;

import com.iap.ac.android.gol.google.service.TopUpService;

/* loaded from: classes2.dex */
public class AlipayPlusClientAutoDebit {
    private static volatile AlipayPlusClientAutoDebit mInstance;
    private String clientId;
    private String envType = "PROD";
    private TopUpService topUpService;

    public static AlipayPlusClientAutoDebit getInstance() {
        if (mInstance == null) {
            synchronized (AlipayPlusClientAutoDebit.class) {
                if (mInstance == null) {
                    mInstance = new AlipayPlusClientAutoDebit();
                }
            }
        }
        return mInstance;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public String getEnvType() {
        return this.envType;
    }

    public void setEnvType(String str) {
        this.envType = str;
    }

    public TopUpService getTopUpService() {
        return this.topUpService;
    }

    public void setTopUpService(TopUpService topUpService) {
        this.topUpService = topUpService;
    }
}
