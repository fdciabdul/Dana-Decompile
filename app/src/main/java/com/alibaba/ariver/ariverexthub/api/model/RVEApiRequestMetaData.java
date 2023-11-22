package com.alibaba.ariver.ariverexthub.api.model;

/* loaded from: classes6.dex */
public class RVEApiRequestMetaData {
    public boolean isAvailable;
    public boolean isRemote;

    public static RVEApiRequestMetaData unAvaliableRequest() {
        RVEApiRequestMetaData rVEApiRequestMetaData = new RVEApiRequestMetaData();
        rVEApiRequestMetaData.isAvailable = false;
        rVEApiRequestMetaData.isRemote = false;
        return rVEApiRequestMetaData;
    }

    public static RVEApiRequestMetaData avaliableRequest(boolean z) {
        RVEApiRequestMetaData rVEApiRequestMetaData = new RVEApiRequestMetaData();
        rVEApiRequestMetaData.isAvailable = true;
        rVEApiRequestMetaData.isRemote = z;
        return rVEApiRequestMetaData;
    }

    private RVEApiRequestMetaData() {
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean z) {
        this.isAvailable = z;
    }

    public boolean isRemote() {
        return this.isRemote;
    }

    public void setRemote(boolean z) {
        this.isRemote = z;
    }
}
