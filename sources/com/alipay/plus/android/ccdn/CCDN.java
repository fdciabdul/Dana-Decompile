package com.alipay.plus.android.ccdn;

import com.alipay.mobile.network.ccdn.jni.JNIPort;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public class CCDN {
    private static final String TAG = "CCDN";
    private static ICCDNLog mLog = new ICCDNLog() { // from class: com.alipay.plus.android.ccdn.CCDN.1
        @Override // com.alipay.plus.android.ccdn.ICCDNLog
        public final void e(String str, String str2) {
            InstrumentInjector.log_e(str, str2);
        }

        @Override // com.alipay.plus.android.ccdn.ICCDNLog
        public final void d(String str, String str2) {
            InstrumentInjector.log_d(str, str2);
        }
    };
    private static boolean sInitialized;

    /* loaded from: classes7.dex */
    interface CCDNManagerFactory {
        public static final CCDN mInstance = new CCDN();
    }

    private CCDN() {
        init();
    }

    public static CCDN getInstance() {
        return CCDNManagerFactory.mInstance;
    }

    public void setLog(ICCDNLog iCCDNLog) {
        if (iCCDNLog != null) {
            mLog = iCCDNLog;
        }
    }

    public boolean init() {
        if (!sInitialized) {
            if (JNIPort.initialize() != 0) {
                InstrumentInjector.log_e(TAG, "failed to init ccdn lib");
                return false;
            }
            try {
                System.loadLibrary("j71063");
                sInitialized = true;
            } catch (Exception unused) {
                mLog.e(TAG, "failed to load demo lib");
                return false;
            }
        }
        return true;
    }

    public static void log(int i, String str, String str2) {
        mLog.d(str, str2);
    }
}
