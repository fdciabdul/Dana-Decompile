package com.zhuinden.simplestack;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface KeyParceler {
    Object fromParcelable(Parcelable parcelable);

    Parcelable toParcelable(Object obj);
}
