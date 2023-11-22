package com.alipay.iap.android.common.product.delegate;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class IAPLoginUserInfo implements Serializable {
    public String loginID;
    public String sessionID;
    public String userID;

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public IAPLoginUserInfo m80clone() {
        IAPLoginUserInfo iAPLoginUserInfo = new IAPLoginUserInfo();
        iAPLoginUserInfo.userID = this.userID;
        iAPLoginUserInfo.sessionID = this.sessionID;
        iAPLoginUserInfo.loginID = this.loginID;
        return iAPLoginUserInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IAPLoginUserInfo iAPLoginUserInfo = (IAPLoginUserInfo) obj;
        String str = this.userID;
        if (str == null ? iAPLoginUserInfo.userID == null : str.equals(iAPLoginUserInfo.userID)) {
            String str2 = this.sessionID;
            if (str2 == null ? iAPLoginUserInfo.sessionID == null : str2.equals(iAPLoginUserInfo.sessionID)) {
                String str3 = this.loginID;
                String str4 = iAPLoginUserInfo.loginID;
                return str3 != null ? str3.equals(str4) : str4 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.userID;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.sessionID;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.loginID;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }
}
