package com.alipay.zoloz.toyger.h5;

import com.alipay.zoloz.toyger.algorithm.ToygerBlobConfig;

/* loaded from: classes7.dex */
public class ToygerH5BlobConfig extends ToygerBlobConfig {
    public int desiredWidth;
    public float uploadRatio;

    @Override // com.alipay.zoloz.toyger.algorithm.ToygerBlobConfig
    public float getCompressRate() {
        return this.uploadRatio;
    }
}
