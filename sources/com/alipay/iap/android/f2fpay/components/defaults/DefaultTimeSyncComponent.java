package com.alipay.iap.android.f2fpay.components.defaults;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.ap.mobileprod.biz.f2fpay.rpc.F2fPayTickSyncFacade;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.iap.android.common.timesync.TimeSyncManager;
import com.alipay.iap.android.common.utils.NetworkUtils;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent;
import com.alipayplus.mobile.component.common.facade.base.request.BaseServiceRequest;
import com.alipayplus.mobile.component.f2fpay.service.result.F2fPayTickSyncResult;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DefaultTimeSyncComponent extends DefaultBaseComponent implements IF2FPayTimeSyncComponent {

    /* renamed from: a  reason: collision with root package name */
    private static final long f6961a = TimeUnit.HOURS.toMillis(6);
    protected long mPreviousSyncTimestamp = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SyncTimeResult {
        public int rpcTimeCostMillisecond;
        public String serverTimeMillisecond;

        private SyncTimeResult() {
        }
    }

    private boolean a() {
        long lastSyncTime = TimeSyncManager.getInstance(getContext()).getLastSyncTime();
        return lastSyncTime < 0 || System.currentTimeMillis() - lastSyncTime >= f6961a;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent
    public long getServerTime() {
        long serverTime = TimeSyncManager.getInstance(getContext()).getServerTime();
        LoggerWrapper.d(F2FPayConstants.TAG, String.format("localTime = %d, serverTime = %d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(serverTime)));
        return serverTime;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent
    public void setServerTime(String str, int i) {
        LoggerWrapper.d(F2FPayConstants.TAG, String.format("setServerTime = %s, currentClientTimestamp = %d, rpcRequestCost: %d", str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return;
        }
        keyValueAccessor().save("serverTimeGap", (int) (System.currentTimeMillis() - (Long.parseLong(str) + (i / 2))));
        this.mPreviousSyncTimestamp = SystemClock.elapsedRealtime();
        TimeSyncManager.getInstance(getContext()).setServerTime(i, Long.parseLong(str));
    }

    public SyncTimeResult syncTimeTickRpc() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        F2fPayTickSyncFacade f2fPayTickSyncFacade = (F2fPayTickSyncFacade) RPCProxyHost.getInterfaceProxy(F2fPayTickSyncFacade.class);
        BaseServiceRequest baseServiceRequest = new BaseServiceRequest();
        baseServiceRequest.userId = getUserDelegate().getUserId();
        F2fPayTickSyncResult tick = f2fPayTickSyncFacade.tick(baseServiceRequest);
        int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
        if (tick == null || !tick.success) {
            LoggerWrapper.e(F2FPayConstants.TAG, "Server tick sync FAILED!");
            return null;
        }
        SyncTimeResult syncTimeResult = new SyncTimeResult();
        syncTimeResult.rpcTimeCostMillisecond = currentTimeMillis2;
        if (tick != null) {
            syncTimeResult.serverTimeMillisecond = tick.serviceTime;
        }
        return syncTimeResult;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent
    public void synchronizeTime() {
        if (NetworkUtils.isNetworkAvailable(getContext()) && a()) {
            try {
                SyncTimeResult syncTimeTickRpc = syncTimeTickRpc();
                if (syncTimeTickRpc != null) {
                    setServerTime(syncTimeTickRpc.serverTimeMillisecond, syncTimeTickRpc.rpcTimeCostMillisecond);
                }
            } catch (Exception e) {
                LoggerWrapper.e(F2FPayConstants.TAG, "synchronizeTime", e);
            }
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent
    public void synchronizeTimeInWorker() {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultTimeSyncComponent.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeSyncComponent.this.synchronizeTime();
            }
        });
    }
}
