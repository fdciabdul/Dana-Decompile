package com.alibaba.griver.api.common.menu;

/* loaded from: classes3.dex */
public abstract class GRVBaseAppFavoriteMenuItem extends GRVMPMoreMenuItem {

    /* loaded from: classes3.dex */
    public @interface AppFavoriteStatus {
        public static final int COLLECTED = 1;
        public static final int UNCOLLECTED = 0;
        public static final int UNKNOW = -1;
    }

    /* loaded from: classes3.dex */
    public @interface AppTitleFavoriteStatus {
        public static final int GONE = -1;
        public static final int VISIBLE = 1;
    }

    public abstract boolean canShowTitle();

    public abstract int getAppFavoriteStatus();

    public abstract int getAppTitleFavoriteStatus();
}
