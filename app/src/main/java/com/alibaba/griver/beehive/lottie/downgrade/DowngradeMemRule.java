package com.alibaba.griver.beehive.lottie.downgrade;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class DowngradeMemRule {
    private long downgradeMem;
    private String scene;

    public DowngradeMemRule(String str, long j) {
        this.scene = str;
        this.downgradeMem = j;
    }

    public boolean matchScene(String str, long j) {
        return !TextUtils.isEmpty(str) && str.startsWith(getScene()) && j < this.downgradeMem;
    }

    public String getScene() {
        return this.scene;
    }

    public long getDowngradeMem() {
        return this.downgradeMem;
    }
}
