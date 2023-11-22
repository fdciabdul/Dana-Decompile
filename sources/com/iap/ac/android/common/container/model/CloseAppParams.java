package com.iap.ac.android.common.container.model;

import com.iap.ac.android.common.a.a;

/* loaded from: classes3.dex */
public class CloseAppParams {
    public boolean animated;
    public String appId;
    public String closeActionType;

    public String toString() {
        StringBuilder a2 = a.a("CloseAppParams{appId='");
        a2.append(this.appId);
        a2.append('\'');
        a2.append(", closeActionType='");
        a2.append(this.closeActionType);
        a2.append('\'');
        a2.append(", animated=");
        a2.append(this.animated);
        a2.append('}');
        return a2.toString();
    }
}
