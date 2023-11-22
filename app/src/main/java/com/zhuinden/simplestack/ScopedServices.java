package com.zhuinden.simplestack;

import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public interface ScopedServices {

    /* loaded from: classes2.dex */
    public interface Activated {
        void onServiceActive();

        void onServiceInactive();
    }

    /* loaded from: classes2.dex */
    public interface HandlesBack {
        boolean onBackEvent();
    }

    /* loaded from: classes2.dex */
    public interface Registered {
        void onServiceRegistered();

        void onServiceUnregistered();
    }

    void bindServices(@Nonnull ServiceBinder serviceBinder);
}
