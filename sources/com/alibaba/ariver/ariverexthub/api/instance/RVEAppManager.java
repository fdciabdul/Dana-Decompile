package com.alibaba.ariver.ariverexthub.api.instance;

import android.os.Bundle;
import com.alibaba.ariver.ariverexthub.api.model.RVEAriverExthubSource;
import com.alibaba.ariver.ariverexthub.api.provider.RVEBizProvider;

/* loaded from: classes6.dex */
public class RVEAppManager {
    public static void destoryApp(String str) {
        RVEHandlerCenter.getInstance().appDidDestory(str);
        if (RVEProxyCenter.getInstance().isLiteProcess()) {
            if (RVEProxyCenter.getInstance().getCurrentSource() != RVEAriverExthubSource.ALIPAY) {
                Bundle bundle = new Bundle();
                bundle.putString("appId", str);
                RVEProxyCenter.getInstance().sendMessage(bundle);
                return;
            }
            RVEBizProvider rVEBizProvider = RVEProxyCenter.getInstance().getRVEBizProvider();
            if (rVEBizProvider != null) {
                rVEBizProvider.appDidDestory(str);
            }
        }
    }
}
