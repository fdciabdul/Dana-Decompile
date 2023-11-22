package com.alibaba.griver.mobilecommon.multimedia.api.data;

/* loaded from: classes6.dex */
public class APRequestParam {
    private String ACL;
    private String UID;

    public APRequestParam(String str, String str2) {
        this.ACL = str;
        this.UID = str2;
    }

    public String getACL() {
        return this.ACL;
    }

    public void setACL(String str) {
        this.ACL = str;
    }

    public String getUID() {
        return this.UID;
    }

    public void setUID(String str) {
        this.UID = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APRequestParam{ACL='");
        sb.append(this.ACL);
        sb.append('\'');
        sb.append(", UID='");
        sb.append(this.UID);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
