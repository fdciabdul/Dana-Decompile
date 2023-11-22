package com.alipay.multimedia.adjuster.config;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: classes2.dex */
public class HostItem {
    @JSONField(name = "gp")
    public int grayPercent;
    @JSONField(name = "hs")
    public String host;

    public HostItem() {
        this.host = "";
        this.grayPercent = 0;
    }

    public HostItem(String str, int i) {
        this.host = str;
        this.grayPercent = i;
    }

    public boolean checkPercent() {
        int i = this.grayPercent;
        return i > 0 && i <= 100;
    }

    public boolean checkGraySwitch(int i) {
        return i > 0 && i <= this.grayPercent;
    }
}
