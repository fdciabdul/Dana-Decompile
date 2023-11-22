package com.alipay.mobile.rome.syncsdk.transport.c;

import com.alipay.mobile.rome.syncsdk.service.ConnStateFsm;

/* loaded from: classes3.dex */
final /* synthetic */ class k {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7252a;

    static {
        int[] iArr = new int[ConnStateFsm.State.values().length];
        f7252a = iArr;
        try {
            iArr[ConnStateFsm.State.DEVICE_BINDED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7252a[ConnStateFsm.State.REGISTERED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7252a[ConnStateFsm.State.USER_BINDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
