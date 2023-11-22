package com.alipay.iap.android.aplog.network;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public class NetWorkProvider {
    public static NetWorkProvider INSTANCE = null;
    private static final long NETWORK_TYPE_FUZZ_TIME = 2000;
    public static final String NETWORK_UNKNOWN = "unknown";
    private static long mPreviousNetworkTime = 0;
    private static int mPreviousNetworkType = -1;
    private Context mContext;
    private LogNetworkConnReceiver mLogNetworkConnReceiver;

    public NetWorkProvider(Context context) {
        this.mContext = context;
        registerLogNetworkConnReceiver(context);
    }

    public static NetWorkProvider createInstance(Context context) {
        NetWorkProvider netWorkProvider;
        synchronized (NetWorkProvider.class) {
            if (INSTANCE == null) {
                INSTANCE = new NetWorkProvider(context);
            }
            netWorkProvider = INSTANCE;
        }
        return netWorkProvider;
    }

    public static NetWorkProvider getInstance() {
        NetWorkProvider netWorkProvider;
        synchronized (NetWorkProvider.class) {
            netWorkProvider = INSTANCE;
            if (netWorkProvider == null) {
                throw new IllegalStateException("need createInstance before use");
            }
        }
        return netWorkProvider;
    }

    public void registerLogNetworkConnReceiver(Context context) {
        LogNetworkConnReceiver logNetworkConnReceiver = new LogNetworkConnReceiver(context);
        this.mLogNetworkConnReceiver = logNetworkConnReceiver;
        logNetworkConnReceiver.register();
    }

    public String getCurrentNetworkType2Str() {
        int currentNetworkType = getCurrentNetworkType();
        return currentNetworkType != 1 ? currentNetworkType != 2 ? currentNetworkType != 3 ? currentNetworkType != 4 ? "unknown" : "4g" : "wifi" : "3g" : "2g";
    }

    public int getCurrentNetworkType() {
        int i = mPreviousNetworkType;
        if (i == -1 || i == 0) {
            updateNetworkTypeOptimized(this.mContext);
        }
        return mPreviousNetworkType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int updateNetworkTypeOptimized(Context context) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - mPreviousNetworkTime > NETWORK_TYPE_FUZZ_TIME) {
            mPreviousNetworkType = NetworkUtils.getNetworkType(context);
            mPreviousNetworkTime = uptimeMillis;
        }
        return mPreviousNetworkType;
    }

    /* loaded from: classes3.dex */
    public class LogNetworkConnReceiver extends RigorousNetworkConnReceiver {
        @Override // com.alipay.iap.android.aplog.network.RigorousNetworkConnReceiver, android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }

        public LogNetworkConnReceiver(Context context) {
            super(context);
        }

        @Override // com.alipay.iap.android.aplog.network.RigorousNetworkConnReceiver
        protected void onReceivee(Context context, Intent intent) {
            NetWorkProvider.this.updateNetworkTypeOptimized(context);
        }
    }
}
