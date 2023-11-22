package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.syncsdk.service.ConnStateFsm;

/* loaded from: classes3.dex */
final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7233a;

    static {
        int[] iArr = new int[ConnStateFsm.State.values().length];
        f7233a = iArr;
        try {
            iArr[ConnStateFsm.State.INIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7233a[ConnStateFsm.State.WAIT_DEVICE_BINDED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7233a[ConnStateFsm.State.WAIT_USER_BINDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7233a[ConnStateFsm.State.WAIT_REGISTERED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7233a[ConnStateFsm.State.WAIT_USER_UNBINDED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
