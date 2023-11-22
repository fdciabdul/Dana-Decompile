package com.splunk.rum;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class VisibleScreenTracker {
    final AtomicReference<String> KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicReference<>();
    final AtomicReference<String> MyBillsEntityDataFactory = new AtomicReference<>();
    final AtomicReference<String> PlaceComponentResult = new AtomicReference<>();
    final AtomicReference<String> getAuthRequestContext = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String PlaceComponentResult() {
        String str = this.PlaceComponentResult.get();
        if (str != null) {
            return str;
        }
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        return str2 != null ? str2 : "unknown";
    }
}
