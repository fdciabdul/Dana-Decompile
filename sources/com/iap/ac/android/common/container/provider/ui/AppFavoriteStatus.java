package com.iap.ac.android.common.container.provider.ui;

/* loaded from: classes3.dex */
public enum AppFavoriteStatus {
    Unknow(-1),
    Uncollected(0),
    Collected(1);

    public int value;

    AppFavoriteStatus(int i) {
        this.value = i;
    }

    public static AppFavoriteStatus parseValue(int i) {
        AppFavoriteStatus appFavoriteStatus = Unknow;
        if (i != -1) {
            if (i != 0) {
                return i != 1 ? appFavoriteStatus : Collected;
            }
            return Uncollected;
        }
        return appFavoriteStatus;
    }

    public final int getValue() {
        return this.value;
    }
}
