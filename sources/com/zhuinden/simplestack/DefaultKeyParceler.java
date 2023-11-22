package com.zhuinden.simplestack;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DefaultKeyParceler implements KeyParceler {
    @Override // com.zhuinden.simplestack.KeyParceler
    public Object fromParcelable(Parcelable parcelable) {
        return parcelable;
    }

    @Override // com.zhuinden.simplestack.KeyParceler
    public Parcelable toParcelable(Object obj) {
        return (Parcelable) obj;
    }
}
