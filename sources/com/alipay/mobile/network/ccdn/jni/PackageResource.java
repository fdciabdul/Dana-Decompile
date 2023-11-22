package com.alipay.mobile.network.ccdn.jni;

/* loaded from: classes6.dex */
public class PackageResource {
    public byte[] data;
    public int state;
    public String url;

    public PackageResource(String str) {
        this.url = str;
    }

    public PackageResource(byte[] bArr) {
        this.data = bArr;
    }
}
