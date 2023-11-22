package com.iap.ac.android.common.container.provider.ui;

/* loaded from: classes3.dex */
public enum ContainerMoreMenuItemType {
    Feedback(1),
    Notification(2),
    Favorite(3),
    Subscription(4);

    public int value;

    ContainerMoreMenuItemType(int i) {
        this.value = i;
    }

    public static ContainerMoreMenuItemType parseValue(int i) {
        ContainerMoreMenuItemType containerMoreMenuItemType = Feedback;
        if (i != 2) {
            if (i != 3) {
                return i == 4 ? Subscription : containerMoreMenuItemType;
            }
            return Favorite;
        }
        return Notification;
    }

    public final int getValue() {
        return this.value;
    }
}
