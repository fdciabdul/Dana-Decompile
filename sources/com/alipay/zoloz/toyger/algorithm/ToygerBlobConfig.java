package com.alipay.zoloz.toyger.algorithm;

/* loaded from: classes7.dex */
public abstract class ToygerBlobConfig {
    public String pubkey;

    public abstract float getCompressRate();

    public Integer getDesiredWidth() {
        return -1;
    }
}
