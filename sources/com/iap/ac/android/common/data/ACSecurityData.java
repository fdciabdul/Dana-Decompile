package com.iap.ac.android.common.data;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class ACSecurityData {
    public static final String TAG = "ACSecurityData";
    public IDataEncrypt dataEncrypt;
    public IDataStorage dataStorage;

    public ACSecurityData(IDataStorage iDataStorage, IDataEncrypt iDataEncrypt) {
        this.dataStorage = iDataStorage;
        this.dataEncrypt = iDataEncrypt;
    }

    public static ACSecurityData newInstance(IDataStorage iDataStorage, IDataEncrypt iDataEncrypt) {
        return new ACSecurityData(iDataStorage, iDataEncrypt);
    }

    private void noStorageImplError() {
        ACLog.e(TAG, "No storage implementation found. Please setDataStorage first.");
    }

    public boolean clear() {
        IDataStorage iDataStorage = this.dataStorage;
        if (iDataStorage == null) {
            noStorageImplError();
            return false;
        }
        return iDataStorage.clear();
    }

    public boolean delete(String str) {
        IDataStorage iDataStorage = this.dataStorage;
        if (iDataStorage == null) {
            noStorageImplError();
            return false;
        }
        return iDataStorage.delete(str);
    }

    public String get(String str) {
        IDataEncrypt iDataEncrypt;
        IDataStorage iDataStorage = this.dataStorage;
        if (iDataStorage == null) {
            noStorageImplError();
            return null;
        }
        String str2 = iDataStorage.get(str);
        return (TextUtils.isEmpty(str2) || (iDataEncrypt = this.dataEncrypt) == null) ? str2 : iDataEncrypt.decrypt(str2);
    }

    public boolean save(String str, String str2) {
        if (this.dataStorage == null) {
            noStorageImplError();
            return false;
        }
        IDataEncrypt iDataEncrypt = this.dataEncrypt;
        if (iDataEncrypt != null) {
            str2 = iDataEncrypt.encrypt(str2);
        } else {
            ACLog.w(TAG, "No implementation of data encryption found. Will not encrypt the data. Please setDataEncrypt if you want to encrypt the data.");
        }
        return this.dataStorage.save(str, str2);
    }

    public void setDataEncrypt(IDataEncrypt iDataEncrypt) {
        this.dataEncrypt = iDataEncrypt;
    }

    public void setDataStorage(IDataStorage iDataStorage) {
        this.dataStorage = iDataStorage;
    }
}
