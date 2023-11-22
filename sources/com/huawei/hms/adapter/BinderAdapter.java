package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* loaded from: classes7.dex */
public class BinderAdapter implements ServiceConnection {
    private static final int BINDER_SYSTEM_ERROR = -1;
    private static final int DELAY_MILLIS = 1800000;
    private static final String TAG = "BinderAdapter";
    private BinderCallBack callback;
    private final String mAction;
    private Context mContext;
    private final String mService;
    private IBinder serviceBinder;
    public static final byte[] getAuthRequestContext = {125, -100, 71, Ascii.FS, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int MyBillsEntityDataFactory = 117;
    private final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    private boolean bindFail = false;
    private Handler mBinderTimeoutHandler = null;
    private Handler delayDisconnectHandler = null;

    /* loaded from: classes7.dex */
    public interface BinderCallBack {
        void onBinderFailed(int i);

        void onBinderFailed(int i, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.mContext = context;
        this.mAction = str;
        this.mService = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 6
            int r7 = r7 + 97
            int r9 = r9 * 5
            int r9 = r9 + 18
            int r8 = r8 * 22
            int r8 = 25 - r8
            byte[] r0 = com.huawei.hms.adapter.BinderAdapter.getAuthRequestContext
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L33
        L19:
            r3 = 0
        L1a:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L33:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-8)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.BinderAdapter.a(byte, int, short, java.lang.Object[]):void");
    }

    private void bindCoreService() {
        if (TextUtils.isEmpty(this.mAction) || TextUtils.isEmpty(this.mService)) {
            getBindFailPendingIntent();
        }
        Intent intent = new Intent(this.mAction);
        intent.setPackage(this.mService);
        synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
            if (this.mContext.bindService(intent, this, 1)) {
                postConnDelayHandle();
                return;
            }
            this.bindFail = true;
            getBindFailPendingIntent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void binderServiceFailed() {
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onBinderFailed(-1);
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
            Handler handler = this.mBinderTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.mBinderTimeoutHandler = null;
            }
        }
    }

    private void delayedUnbind() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.i(BinderAdapter.TAG, "The serviceConnection has been bind for 60s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack callBack = BinderAdapter.this.getCallBack();
                if (callBack != null) {
                    callBack.onTimedDisconnected();
                    return true;
                }
                return true;
            }
        });
        this.delayDisconnectHandler = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    private void getBindFailPendingIntent() {
        HMSLog.e(TAG, "In connect, bind core service fail");
        Context context = this.mContext;
        try {
            byte b = getAuthRequestContext[41];
            byte b2 = (byte) (b + 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory & 3);
            byte b4 = getAuthRequestContext[41];
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            ComponentName componentName = new ComponentName(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack callBack = getCallBack();
            if (callBack != null) {
                callBack.onBinderFailed(-1, intent);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack getCallBack() {
        return this.callback;
    }

    private void postConnDelayHandle() {
        Handler handler = this.mBinderTimeoutHandler;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.mBinderTimeoutHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.e(BinderAdapter.TAG, "In connect, bind core service time out");
                    BinderAdapter.this.binderServiceFailed();
                    return true;
                }
            });
        }
        this.mBinderTimeoutHandler.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
    }

    private void removeDelayDisconnectTask() {
        HMSLog.d(TAG, "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.delayDisconnectHandler;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.callback = binderCallBack;
        bindCoreService();
    }

    protected int getConnTimeOut() {
        return 0;
    }

    protected int getMsgDelayDisconnect() {
        return 0;
    }

    public IBinder getServiceBinder() {
        return this.serviceBinder;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.e(TAG, "Enter onNullBinding, than unBind.");
        if (this.bindFail) {
            this.bindFail = false;
            return;
        }
        unBind();
        cancelConnDelayHandle();
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i(TAG, "BinderAdapter Enter onServiceConnected.");
        this.serviceBinder = iBinder;
        cancelConnDelayHandle();
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onServiceConnected(componentName, iBinder);
        }
        delayedUnbind();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i(TAG, "Enter onServiceDisconnected.");
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onServiceDisconnected(componentName);
        }
        removeDelayDisconnectTask();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.mContext, this);
    }

    public void updateDelayTask() {
        HMSLog.d(TAG, "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.delayDisconnectHandler;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.delayDisconnectHandler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
            }
        }
    }
}
