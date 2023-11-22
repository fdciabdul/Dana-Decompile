package com.iap.ac.android.biz.common.storage;

import android.content.Context;
import com.iap.ac.android.biz.common.encrypt.SecurityGuardEncrypt;
import com.iap.ac.android.common.data.ACSecurityData;
import com.iap.ac.android.common.data.IDataEncrypt;
import com.iap.ac.android.common.data.IDataStorage;

/* loaded from: classes3.dex */
public class ACEncryptStorageProvider implements IDataEncrypt, IDataStorage {
    public static final String BIZ_TYPE_FOR_SECURITY_STORAGE = "ACManagerSecData";
    public static volatile ACEncryptStorageProvider instance;
    public ACSecurityData mACSecurityData = ACSecurityData.newInstance(this, this);
    public ACStorageProvider mACStorageProvider;
    public SecurityGuardEncrypt mSecurityGuardEncrypt;

    public ACEncryptStorageProvider(Context context) {
        this.mSecurityGuardEncrypt = new SecurityGuardEncrypt(context);
        this.mACStorageProvider = new ACStorageProvider(context, "ACManagerSecData");
    }

    public static ACEncryptStorageProvider getInstance(Context context) {
        if (instance == null) {
            synchronized (ACEncryptStorageProvider.class) {
                if (instance == null) {
                    instance = new ACEncryptStorageProvider(context);
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
