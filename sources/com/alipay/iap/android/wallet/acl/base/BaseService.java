package com.alipay.iap.android.wallet.acl.base;

/* loaded from: classes.dex */
public interface BaseService {

    /* loaded from: classes.dex */
    public static class NoServiceMetaInfoException extends Exception {
        public NoServiceMetaInfoException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static class ServiceRegisterException extends Exception {
        public ServiceRegisterException(String str) {
            super(str);
        }

        public ServiceRegisterException(String str, Exception exc) {
            super(str, exc);
        }
    }
}
