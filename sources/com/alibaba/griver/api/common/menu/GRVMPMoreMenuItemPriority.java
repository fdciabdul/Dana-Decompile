package com.alibaba.griver.api.common.menu;

/* loaded from: classes3.dex */
public enum GRVMPMoreMenuItemPriority {
    GRVMPMoreMenuItemPriorityDefault(100),
    GRVMPMoreMenuItemPriorityLow(10),
    GRVMPMoreMenuItemPriorityHigh(1000);

    int value;

    GRVMPMoreMenuItemPriority(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final GRVMPMoreMenuItemPriority parseValue(int i) {
        GRVMPMoreMenuItemPriority gRVMPMoreMenuItemPriority = GRVMPMoreMenuItemPriorityDefault;
        if (i != 10) {
            return (i == 100 || i != 1000) ? gRVMPMoreMenuItemPriority : GRVMPMoreMenuItemPriorityHigh;
        }
        return GRVMPMoreMenuItemPriorityLow;
    }
}
