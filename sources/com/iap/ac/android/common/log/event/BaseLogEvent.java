package com.iap.ac.android.common.log.event;

import com.iap.ac.android.common.a.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BaseLogEvent implements Serializable {
    public String bizCode;
    public Map<String, String> params = new HashMap();

    public String toString() {
        StringBuilder a2 = a.a("BaseLogEvent{params=");
        a2.append(this.params);
        a2.append(", bizCode='");
        a2.append(this.bizCode);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
