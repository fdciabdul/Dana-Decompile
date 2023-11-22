package com.alibaba.griver.base.common.security;

import com.alibaba.griver.api.common.security.GriverEncryptProxy;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverSecurity implements GriverEncryptProxy {

    /* renamed from: a  reason: collision with root package name */
    private static final GriverSecurity f6302a = new GriverSecurity();
    private GriverEncryptProxy b = new GriverEncryptProxy() { // from class: com.alibaba.griver.base.common.security.GriverSecurity.1
        @Override // com.alibaba.griver.api.common.security.GriverEncryptProxy
        public String encrypt(String str) {
            GriverLogger.d("GriverSecurity", "use default encrypt, return original content");
            return str;
        }

        @Override // com.alibaba.griver.api.common.security.GriverEncryptProxy
        public String decrypt(String str) {
            GriverLogger.d("GriverSecurity", "use default encrypt, return original content");
            return str;
        }
    };

    private GriverSecurity() {
    }

    public static GriverSecurity getInstance() {
        return f6302a;
    }

    @Override // com.alibaba.griver.api.common.security.GriverEncryptProxy
    public String encrypt(String str) {
        return this.b.encrypt(str);
    }

    @Override // com.alibaba.griver.api.common.security.GriverEncryptProxy
    public String decrypt(String str) {
        return this.b.decrypt(str);
    }

    public void setEncryptProxy(GriverEncryptProxy griverEncryptProxy) {
        if (griverEncryptProxy != null) {
            this.b = griverEncryptProxy;
        } else {
            GriverLogger.e("GriverSecurity", "should not set null proxy to GriverSecurity");
        }
    }
}
