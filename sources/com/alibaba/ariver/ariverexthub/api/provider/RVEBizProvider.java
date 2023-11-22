package com.alibaba.ariver.ariverexthub.api.provider;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo;
import com.alibaba.ariver.ariverexthub.api.model.RVEAriverExthubSource;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class RVEBizProvider {
    public void appDidDestory(String str) {
    }

    public boolean enableApi(String str) {
        return false;
    }

    public String getConfig(String str) {
        return null;
    }

    public Context getCurrentContext() {
        return null;
    }

    public Map<List<String>, RVEApiInfo> getRVEBizApiList() {
        return null;
    }

    public RVELogProvider getRveLogger() {
        return null;
    }

    public RVEThreadService getThreadService() {
        return null;
    }

    public Activity getTopActivity() {
        return null;
    }

    public boolean interceptAPI(String str) {
        return false;
    }

    public boolean isLiteProcess() {
        return false;
    }

    public void onInit() {
    }

    public RVEAriverExthubSource getCurrentAriverExthubSource() {
        return RVEAriverExthubSource.DEFAULT;
    }
}
