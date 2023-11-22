package com.iap.ac.android.acs.operation.biz.region.storage;

import android.content.Context;
import com.iap.ac.android.biz.common.storage.ACStorageProvider;

/* loaded from: classes3.dex */
public class RegionEncryptStorageProvider {
    public static final String BIZ_TYPE_FOR_SECURITY_STORAGE = "RegionManagerSecData";
    public static volatile RegionEncryptStorageProvider instance;
    public ACStorageProvider mACStorageProvider;

    public RegionEncryptStorageProvider(Context context) {
        this.mACStorageProvider = new ACStorageProvider(context, BIZ_TYPE_FOR_SECURITY_STORAGE);
    }

    public static RegionEncryptStorageProvider getInstance(Context context) {
        if (instance == null) {
            synchronized (RegionEncryptStorageProvider.class) {
                if (instance == null) {
                    instance = new RegionEncryptStorageProvider(context);
                }
            }
        }
        return instance;
    }

    public boolean clear() {
        return this.mACStorageProvider.clear();
    }

    public boolean delete(String str) {
        return this.mACStorageProvider.delete(str);
    }

    public String get(String str) {
        return this.mACStorageProvider.fetch(str);
    }

    public boolean save(String str, String str2) {
        return this.mACStorageProvider.save(str, str2);
    }
}
