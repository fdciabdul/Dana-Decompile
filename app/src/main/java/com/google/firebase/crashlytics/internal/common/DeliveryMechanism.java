package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* renamed from: id  reason: collision with root package name */
    private final int f7439id;

    DeliveryMechanism(int i) {
        this.f7439id = i;
    }

    public final int getId() {
        return this.f7439id;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f7439id);
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }
}
