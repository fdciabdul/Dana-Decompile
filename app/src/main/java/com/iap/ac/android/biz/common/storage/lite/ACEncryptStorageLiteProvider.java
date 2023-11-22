package com.iap.ac.android.biz.common.storage.lite;

import android.content.Context;
import com.iap.ac.android.biz.common.encrypt.SecurityGuardLiteEncrypt;
import com.iap.ac.android.common.data.ACSecurityData;
import com.iap.ac.android.common.data.IDataEncrypt;
import com.iap.ac.android.common.data.IDataStorage;

/* loaded from: classes3.dex */
public class ACEncryptStorageLiteProvider implements IDataEncrypt, IDataStorage {
    public static final String BIZ_TYPE_FOR_SECURITY_STORAGE = "ACManagerSecData";
    public static volatile ACEncryptStorageLiteProvider instance;
    public ACSecurityData mACSecurityData = ACSecurityData.newInstance(this, this);
    public ACStorageLiteProvider mACStorageProvider;
    public SecurityGuardLiteEncrypt mSecurityGuardEncrypt;

    public ACEncryptStorageLiteProvider(Context context) {
        this.mSecurityGuardEncrypt = new SecurityGuardLiteEncrypt(context);
        this.mACStorageProvider = new ACStorageLiteProvider(context, "ACManagerSecData");
    }

    public static ACEncryptStorageLiteProvider getInstance(Context context) {
        if (instance == null) {
            synchronized (ACEncryptStorageLiteProvider.class) {
                if (instance == null) {
                    instance = new ACEncryptStorageLiteProvider(context);
                }
            }
        }
        return instance;
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public boolean clear() {
        return this.mACStorageProvider.clear();
    }

    @Override // com.iap.ac.android.common.data.IDataEncrypt
    public String decrypt(String str) {
        return this.mSecurityGuardEncrypt.dynamicDataDecrypt(str);
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public boolean delete(String str) {
        return this.mACStorageProvider.delete(str);
    }

    @Override // com.iap.ac.android.common.data.IDataEncrypt
    public String encrypt(String str) {
        return this.mSecurityGuardEncrypt.dynamicDataEncrypt(str);
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public String get(String str) {
        return this.mACStorageProvider.fetch(str);
    }

    public ACSecurityData getAcSecurityDataInstance() {
        ACSecurityData aCSecurityData;
        synchronized (this) {
            aCSecurityData = this.mACSecurityData;
        }
        return aCSecurityData;
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public boolean save(String str, String str2) {
        return this.mACStorageProvider.save(str, str2);
    }
}
