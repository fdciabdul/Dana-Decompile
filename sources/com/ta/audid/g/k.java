package com.ta.audid.g;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.util.HashMap;

/* loaded from: classes.dex */
public class k {
    private static String k = "";

    public static String u(Context context) {
        synchronized (k.class) {
            if (!TextUtils.isEmpty(k)) {
                return k;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                IUMIDComponent uMIDComp = SecurityGuardManager.getInstance(context).getUMIDComp();
                int initUMIDSync = uMIDComp.initUMIDSync(0);
                if (initUMIDSync != 200) {
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(initUMIDSync);
                    hashMap.put("errorCode", sb.toString());
                    l.a("umid", hashMap);
                }
                m.d("", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                String securityToken = uMIDComp.getSecurityToken(0);
                if (!TextUtils.isEmpty(securityToken) && securityToken.length() != 24) {
                    k = securityToken;
                    return securityToken;
                }
                return securityToken;
            } catch (Throwable th) {
                m.d("", th);
                return "";
            }
        }
    }
}
