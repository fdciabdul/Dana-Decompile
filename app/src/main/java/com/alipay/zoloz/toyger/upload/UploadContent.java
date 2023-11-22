package com.alipay.zoloz.toyger.upload;

/* loaded from: classes7.dex */
public class UploadContent {
    public final byte[] content;
    public final byte[] contentSig;
    public final boolean isUTF8;

    public UploadContent(byte[] bArr, byte[] bArr2, boolean z) {
        this.content = bArr;
        this.contentSig = bArr2;
        this.isUTF8 = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UploadContent{content=");
        sb.append(this.content == null ? "null" : "***");
        sb.append(", contentSig=");
        sb.append(this.contentSig == null ? "null" : "***");
        sb.append(", isUTF8=");
        sb.append(this.isUTF8);
        sb.append('}');
        return sb.toString();
    }
}
