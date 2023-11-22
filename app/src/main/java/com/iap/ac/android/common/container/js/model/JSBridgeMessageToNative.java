package com.iap.ac.android.common.container.js.model;

import com.iap.ac.android.common.a.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSBridgeMessageToNative {
    public String clientId;
    public String func;
    public String msgType;
    public JSONObject param;

    public String toString() {
        StringBuilder a2 = a.a("JSBridgeMessageToNative{func='");
        a2.append(this.func);
        a2.append('\'');
        a2.append(", param=");
        a2.append(this.param);
        a2.append(", msgType='");
        a2.append(this.msgType);
        a2.append('\'');
        a2.append(", clientId='");
        a2.append(this.clientId);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
