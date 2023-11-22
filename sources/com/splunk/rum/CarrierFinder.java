package com.splunk.rum;

import android.telephony.TelephonyManager;

/* loaded from: classes3.dex */
class CarrierFinder {
    final TelephonyManager getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CarrierFinder(TelephonyManager telephonyManager) {
        this.getAuthRequestContext = telephonyManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean MyBillsEntityDataFactory(CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0) ? false : true;
    }
}
