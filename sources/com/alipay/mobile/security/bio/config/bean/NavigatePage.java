package com.alipay.mobile.security.bio.config.bean;

/* loaded from: classes7.dex */
public class NavigatePage {
    private boolean enable = false;
    private String url = "";

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavigatePage{enable=");
        sb.append(this.enable);
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
