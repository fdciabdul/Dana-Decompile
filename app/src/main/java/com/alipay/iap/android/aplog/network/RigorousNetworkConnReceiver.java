package com.alipay.iap.android.aplog.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.zoloz.toyger.blob.BlobStatic;

/* loaded from: classes3.dex */
public abstract class RigorousNetworkConnReceiver extends BroadcastReceiver {
    private static final int NETWORK_CHANGE = 1;
    private static final int NETWORK_NO_CHANGE = 2;
    private static final int NON_NETWORK = 0;
    private static final String TAG = "NetworkConnReceiver";
    private Context mContext;
    private Boolean lastConnected = null;
    private int netType = -1;
    private int netSubType = -1;

    protected abstract void onReceivee(Context context, Intent intent);

    public RigorousNetworkConnReceiver(Context context) {
        this.mContext = context;
    }

    public void register() {
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                this.mContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
            } else {
                this.mContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        } catch (Exception e) {
            LoggerFactory.getTraceLogger().warn(TAG, e.toString());
        }
    }

    public void unregister() {
        try {
            this.mContext.unregisterReceiver(this);
        } catch (Exception e) {
            LoggerFactory.getTraceLogger().warn(TAG, e.toString());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("onReceive at: ");
            sb.append(getClass().getName());
            sb.append(", Intent: ");
            sb.append(intent);
            traceLogger.info(BlobStatic.INVTP_TYPE_MONITOR, sb.toString());
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int networkState = getNetworkState(context);
                if (networkState == 0) {
                    LoggerFactory.getTraceLogger().debug(TAG, "NetworkConnectivityReceiver#onReceive network is not available");
                    onReceivee(context, intent);
                } else if (networkState == 1) {
                    LoggerFactory.getTraceLogger().debug(TAG, "NetworkConnectivityReceiver#onReceive network is changed");
                    onReceivee(context, intent);
                }
            }
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().error(TAG, th.toString());
        }
    }

    private int getNetworkState(Context context) {
        NetworkInfo networkInfo;
        Boolean bool;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("getActiveNetworkInfo exception. ");
            sb.append(th.toString());
            traceLogger.error(TAG, sb.toString());
            networkInfo = null;
        }
        if (networkInfo == null) {
            LoggerFactory.getTraceLogger().debug(TAG, "No network now!");
            this.lastConnected = Boolean.FALSE;
            return 0;
        }
        boolean isAvailable = networkInfo.isAvailable();
        boolean isConnected = networkInfo.isConnected();
        int type = networkInfo.getType();
        int subtype = networkInfo.getSubtype();
        String extraInfo = networkInfo.getExtraInfo();
        if (this.netType == -1 || this.netSubType == -1 || (bool = this.lastConnected) == null) {
            LoggerFactory.getTraceLogger().debug(TAG, " New contivity broadcast!");
        } else if (bool.booleanValue() == isConnected && this.netType == type && this.netSubType == subtype) {
            LoggerFactory.getTraceLogger().debug(TAG, " Old contivity broadcast!");
            return 2;
        }
        this.lastConnected = Boolean.valueOf(isConnected);
        this.netType = type;
        this.netSubType = subtype;
        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" type=[");
        sb2.append(type);
        sb2.append("] subType=[");
        sb2.append(subtype);
        sb2.append("]  available=[");
        sb2.append(isAvailable);
        sb2.append("] connected=[");
        sb2.append(isConnected);
        sb2.append("] detailedState=[");
        sb2.append(networkInfo.getDetailedState());
        sb2.append("] extraInfo=[");
        sb2.append(extraInfo);
        sb2.append("]");
        traceLogger2.debug(TAG, sb2.toString());
        TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" activeNetworkInfo hashcode=");
        sb3.append(networkInfo.hashCode());
        sb3.append("  activeNetworkInfo = [");
        sb3.append(networkInfo.toString());
        sb3.append("]\n\n\n");
        traceLogger3.debug(TAG, sb3.toString());
        return !this.lastConnected.booleanValue() ? 0 : 1;
    }
}
