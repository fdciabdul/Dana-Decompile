package com.alipay.zoloz.toyger.blob.model;

import java.util.List;

/* loaded from: classes7.dex */
public class Blob {
    public List<BlobElem> blobElem;
    public String blobVersion;

    public Blob() {
    }

    public Blob(String str, List<BlobElem> list) {
        this.blobVersion = str;
        this.blobElem = list;
    }
}
