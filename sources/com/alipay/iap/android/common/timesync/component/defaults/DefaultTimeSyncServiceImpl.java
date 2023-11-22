package com.alipay.iap.android.common.timesync.component.defaults;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.iap.android.common.timesync.component.ITimeSyncCallback;
import com.alipay.iap.android.common.timesync.component.ITimeSyncService;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipayplus.mobile.component.common.rpc.basic.BasicTimeRpcFacade;
import com.alipayplus.mobile.component.common.rpc.basic.request.BasicTimeTickRpcRequest;
import com.alipayplus.mobile.component.common.rpc.basic.result.BasicTimeTickRpcResult;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DefaultTimeSyncServiceImpl implements ITimeSyncService {
    private static final String SHARED_PREFERENCES_NAME = "Alipay_time_sp";
    private static final String SP_SYNC_TIME = "sp_sync_time";
    private static final String SP_TIME_GAP = "sp_time_gap";
    private static final String TAG = "com.alipay.iap.android.common.timesync.component.defaults.DefaultTimeSyncServiceImpl";
    private static SharedPreferences sharedPreferences;
    private long mLastSyncTime = 0;
    private long mTimeGap = 0;

    public DefaultTimeSyncServiceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    @Override // com.alipay.iap.android.common.timesync.component.ITimeSyncService
    public void syncTime(final ITimeSyncCallback iTimeSyncCallback) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.alipay.iap.android.common.timesync.component.defaults.DefaultTimeSyncServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                BasicTimeRpcFacade basicTimeRpcFacade = (BasicTimeRpcFacade) RPCProxyHost.getInterfaceProxy(BasicTimeRpcFacade.class);
                if (basicTimeRpcFacade == null) {
                    LoggerWrapper.e(DefaultTimeSyncServiceImpl.TAG, "getInterfaceProxy for BasicTimeRpcFacade error with null");
                    return;
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    BasicTimeTickRpcResult tick = basicTimeRpcFacade.tick(new BasicTimeTickRpcRequest());
                    String str = DefaultTimeSyncServiceImpl.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("syncTime in DefaultTimeSyncServiceImpl, callback is:");
                    sb.append(iTimeSyncCallback);
                    LoggerWrapper.i(str, sb.toString());
                    if (tick != null && tick.serviceTime > 0) {
                        DefaultTimeSyncServiceImpl.this.setServerTime(System.currentTimeMillis() - currentTimeMillis, tick.serviceTime);
                        ITimeSyncCallback iTimeSyncCallback2 = iTimeSyncCallback;
                        if (iTimeSyncCallback2 == null || !ITimeSyncCallback.class.isAssignableFrom(iTimeSyncCallback2.getClass())) {
                            return;
                        }
                        iTimeSyncCallback.onComplete(0);
                        return;
                    }
                    ITimeSyncCallback iTimeSyncCallback3 = iTimeSyncCallback;
                    if (iTimeSyncCallback3 == null || !ITimeSyncCallback.class.isAssignableFrom(iTimeSyncCallback3.getClass())) {
                        return;
                    }
                    iTimeSyncCallback.onComplete(5001);
                } catch (RpcException e) {
                    String str2 = DefaultTimeSyncServiceImpl.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("syncTime error:");
                    sb2.append(e.getMessage());
                    LoggerWrapper.e(str2, sb2.toString());
                    ITimeSyncCallback iTimeSyncCallback4 = iTimeSyncCallback;
                    if (iTimeSyncCallback4 == null || !ITimeSyncCallback.class.isAssignableFrom(iTimeSyncCallback4.getClass())) {
                        return;
                    }
                    iTimeSyncCallback.onComplete(5001);
                }
            }
        });
    }

    @Override // com.alipay.iap.android.common.timesync.component.ITimeSyncService
    public void setServerTime(long j, long j2) {
        String str = TAG;
        LoggerWrapper.i(str, String.format(Locale.getDefault(), "set serverTime = %d, requestCostTime = %d", Long.valueOf(j2), Long.valueOf(j)));
        if (sharedPreferences == null) {
            LoggerWrapper.e(str, "can not set server time because of none access to storage");
            return;
        }
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mLastSyncTime = currentTimeMillis;
            this.mTimeGap = currentTimeMillis - (j2 + (j / 2));
            sharedPreferences.edit().putLong("sp_time_gap", this.mTimeGap).putLong("sp_sync_time", this.mLastSyncTime).apply();
        }
    }

    @Override // com.alipay.iap.android.common.timesync.component.ITimeSyncService
    public long getServerTime() {
        if (sharedPreferences == null) {
            LoggerWrapper.e(TAG, "can not get server time because of none access to storage");
            return System.currentTimeMillis();
        }
        synchronized (this) {
            if (this.mTimeGap <= 0) {
                this.mTimeGap = sharedPreferences.getLong("sp_time_gap", 0L);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mTimeGap;
        LoggerWrapper.i(TAG, String.format(Locale.getDefault(), "get serverTime = %d, localTime = %d", Long.valueOf(j), Long.valueOf(currentTimeMillis)));
        return j;
    }

    @Override // com.alipay.iap.android.common.timesync.component.ITimeSyncService
    public long getLastSyncTime() {
        if (sharedPreferences == null) {
            LoggerWrapper.e(TAG, "can not get the latest sync time because of none access to storage");
            return -1L;
        }
        synchronized (this) {
            if (this.mLastSyncTime <= 0) {
                this.mLastSyncTime = sharedPreferences.getLong("sp_sync_time", -1L);
            }
        }
        LoggerWrapper.i(TAG, String.format(Locale.getDefault(), "get lastSyncTime = %d", Long.valueOf(this.mLastSyncTime)));
        return this.mLastSyncTime;
    }
}
