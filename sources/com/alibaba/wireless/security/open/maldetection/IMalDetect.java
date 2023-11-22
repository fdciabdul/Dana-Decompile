package com.alibaba.wireless.security.open.maldetection;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;

@InterfacePluginInfo(pluginName = "securitybody")
/* loaded from: classes.dex */
public interface IMalDetect extends IComponent {

    /* loaded from: classes.dex */
    public interface ICallBack {
        void onDetection(int i, String str, String str2);
    }

    void registerCallBack(ICallBack iCallBack);

    void unregisterCallBack(ICallBack iCallBack);
}
