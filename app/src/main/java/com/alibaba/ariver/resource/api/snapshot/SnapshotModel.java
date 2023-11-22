package com.alibaba.ariver.resource.api.snapshot;

/* loaded from: classes6.dex */
public class SnapshotModel {

    /* renamed from: a  reason: collision with root package name */
    private String f6219a;
    private byte[] b;
    private byte[] c;

    public SnapshotModel(String str, byte[] bArr, byte[] bArr2) {
        this.f6219a = str;
        this.b = bArr;
        this.c = bArr2;
    }

    public String getUrl() {
        return this.f6219a;
    }

    public byte[] getSnapshotHtml() {
        return this.b;
    }

    public byte[] getPreRenderSnapshotHtml() {
        return this.c;
    }

    public void setSnapshotHtml(byte[] bArr) {
        this.b = bArr;
    }

    public void setPreRenderSnapshotHtml(byte[] bArr) {
        this.c = bArr;
    }
}
