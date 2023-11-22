package com.alipay.mobile.rome.syncservice.c;

import com.alipay.mobile.rome.syncservice.model.DownstreamDataRequest;

/* loaded from: classes3.dex */
final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7277a;

    static {
        int[] iArr = new int[DownstreamDataRequest.DataSource.values().length];
        f7277a = iArr;
        try {
            iArr[DownstreamDataRequest.DataSource.mmtp.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7277a[DownstreamDataRequest.DataSource.longlink.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7277a[DownstreamDataRequest.DataSource.push.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
