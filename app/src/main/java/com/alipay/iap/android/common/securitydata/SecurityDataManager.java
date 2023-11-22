package com.alipay.iap.android.common.securitydata;

import android.content.Context;
import com.alipay.iap.android.common.securitydata.encrypt.provider.IDataEncryptProvider;
import com.alipay.iap.android.common.securitydata.encrypt.provider.SecurityGuardProvider;
import com.alipay.iap.android.common.securitydata.storage.provider.IDataStorageProvider;
import com.alipay.iap.android.common.securitydata.storage.provider.SpDataStorageProvider;

/* loaded from: classes6.dex */
public class SecurityDataManager implements ISecurityData {
    private IDataEncryptProvider dataEncryptProvider;
    private IDataStorageProvider dataStorageProvider;

    private SecurityDataManager(IDataStorageProvider iDataStorageProvider, IDataEncryptProvider iDataEncryptProvider) {
        this.dataStorageProvider = iDataStorageProvider;
        this.dataEncryptProvider = iDataEncryptProvider;
    }

    public static SecurityDataManager newInstance(IDataStorageProvider iDataStorageProvider, IDataEncryptProvider iDataEncryptProvider) {
        return new SecurityDataManager(iDataStorageProvider, iDataEncryptProvider);
    }

    public static SecurityDataManager newDefaultInstance(Context context, String str) {
        return newInstance(new SpDataStorageProvider(context, str), SecurityGuardProvider.getInstance(context));
    }

    @Override // com.alipay.iap.android.common.securitydata.ISecurityData
    public String securityEncrypt(String str) {
        return this.dataEncryptProvider.encrypt(str);
    }

    @Override // com.alipay.iap.android.common.securitydata.ISecurityData
    public String securityDecrypt(String str) {
        return this.dataEncryptProvider.decrypt(str);
    }

    @Override // com.alipay.iap.android.common.securitydata.ISecurityData
    public boolean save(String str, String str2) {
        return this.dataStorageProvider.save(str, securityEncrypt(str2));
    }

    @Override // com.alipay.iap.android.common.securitydata.ISecurityData
    public String fetch(String str) {
        return securityDecrypt(this.dataStorageProvider.fetch(str));
    }

    @Override // com.alipay.iap.android.common.securitydata.ISecurityData
    public boolean delete(String str) {
        return this.dataStorageProvider.delete(str);
    }

    @Override // com.alipay.iap.android.common.securitydata.ISecurityData
    public boolean clear() {
        return this.dataStorageProvider.clear();
    }
}
