package com.alibaba.griver.beehive.lottie.player;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class DynamicLayerAction implements Serializable {
    public String actionUrl;
    public boolean clickable;

    public DynamicLayerAction(boolean z, String str) {
        this.clickable = z;
        this.actionUrl = str;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setClickable(boolean z) {
        this.clickable = z;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }
}
