package com.iap.ac.android.mpm.utils;

/* loaded from: classes3.dex */
public class EntryCodeData {
    private static volatile EntryCodeData mInstance;
    public String codeValue;

    public static EntryCodeData getInstance() {
        if (mInstance == null) {
            synchronized (EntryCodeData.class) {
                if (mInstance == null) {
                    mInstance = new EntryCodeData();
                }
            }
        }
        return mInstance;
    }
}
