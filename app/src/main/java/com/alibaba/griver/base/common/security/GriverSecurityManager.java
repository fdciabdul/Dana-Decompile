package com.alibaba.griver.base.common.security;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.common.security.GriverSecurityExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes2.dex */
public class GriverSecurityManager {
    public static String encrypt(String str) {
        synchronized (GriverSecurityManager.class) {
            if (TextUtils.isEmpty(str)) {
                GriverLogger.d("GriverBase:GriverSecurityManager", "encrypt data is empty, return itself");
                return str;
            }
            GriverSecurityExtension a2 = a();
            if (a2 != null && !TextUtils.isEmpty(a2.getIdentifier())) {
                StringBuilder sb = new StringBuilder();
                sb.append("find the security extension ");
                sb.append(a2.toString());
                GriverLogger.d("GriverBase:GriverSecurityManager", sb.toString());
                if (a2.getIdentifier().contains("_com_grv_")) {
                    GriverLogger.d("GriverBase:GriverSecurityManager", "but the security extension identifier is illegal, do not encrypt");
                    return null;
                }
                String encrypt = a2.encrypt(str);
                if (encrypt == null) {
                    return null;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a2.getIdentifier());
                sb2.append("_com_grv_");
                sb2.append(encrypt);
                return sb2.toString();
            }
            GriverLogger.d("GriverBase:GriverSecurityManager", "can not find the security extension, do not encrypt");
            return str;
        }
    }

    public static String decrypt(String str) {
        synchronized (GriverSecurityManager.class) {
            if (TextUtils.isEmpty(str)) {
                GriverLogger.d("GriverBase:GriverSecurityManager", "decrypt data is empty, return itself");
                return str;
            }
            int indexOf = str.indexOf("_com_grv_");
            if (indexOf == -1 || indexOf == 0) {
                GriverLogger.d("GriverBase:GriverSecurityManager", "can not find the prefix, do not decrypt");
                return str;
            }
            GriverLogger.d("GriverBase:GriverSecurityManager", "find the prefix, start to decrypt");
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 9);
            GriverSecurityExtension a2 = a();
            if (a2 != null && !TextUtils.isEmpty(a2.getIdentifier())) {
                String decrypt = a2.decrypt(substring2, substring);
                if (decrypt == null) {
                    GriverLogger.w("GriverBase:GriverSecurityManager", "decrypt failed");
                    return null;
                }
                return decrypt;
            }
            GriverLogger.d("GriverBase:GriverSecurityManager", "find the prefix, but no decryptor, return failed");
            return null;
        }
    }

    private static GriverSecurityExtension a() {
        return (GriverSecurityExtension) RVProxy.get(GriverSecurityExtension.class);
    }
}
