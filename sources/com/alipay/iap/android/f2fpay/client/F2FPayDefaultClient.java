package com.alipay.iap.android.f2fpay.client;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.log.MonitorWrapper;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCallback;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback;
import com.alipay.iap.android.common.syncintegration.impl.SyncProvider;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayResultCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder;
import com.alipay.iap.android.f2fpay.common.KeyValueRegistry;
import com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayUserSwitchComponent;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultPaymentCodeComponent;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultTimeSyncComponent;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultUserSwitchComponent;
import com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.alipay.iap.android.f2fpay.util.ConvertUtils;
import com.alipay.iap.android.f2fpay.util.MonitorUtils;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class F2FPayDefaultClient implements IF2FPayClient, IF2FPayOpenCallback {
    protected F2FPayClientContext mClientContext;
    protected WeakReference<Context> mContext;
    protected IF2FPayInitializeComponent mInitializeComponent;
    protected boolean mInitialized;
    protected IF2FPayPaymentCodeComponent mPaymentCodeComponent;
    protected IF2FPayResultHandleComponent mResultHandleComponent;
    protected Map<Class<? extends IF2FPayBaseComponent>, IF2FPayBaseComponent> mComponents = new LinkedHashMap();
    protected boolean startRefreshFlag = true;

    /* renamed from: a  reason: collision with root package name */
    private String f6951a = "";
    private IAPSyncCallback b = null;

    public F2FPayDefaultClient() {
        createComponents();
    }

    private void a() {
        if (this.b == null) {
            this.b = new IAPSyncMessageParsedCallback() { // from class: com.alipay.iap.android.f2fpay.client.F2FPayDefaultClient.1
                @Override // com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback
                public void onReceiveParsedSyncMessage(IAPSyncMessage iAPSyncMessage, String str, List<String> list) {
                    String str2;
                    boolean z = false;
                    LoggerWrapper.d(F2FPayConstants.TAG, String.format("Receive sync message!\nmessageId = %s, userId = %s, biz = %s, message = %s", iAPSyncMessage.messageId, iAPSyncMessage.userId, iAPSyncMessage.biz, iAPSyncMessage.msgData));
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            if ("INIT".equals(new JSONObject(it.next()).optString(F2FPayConstants.SyncBiz.SYNC_MODEL_KEY_FUNCTION_CODE))) {
                                z = true;
                            }
                        } catch (Exception e) {
                            LoggerWrapper.e(F2FPayConstants.TAG, "", e);
                        }
                    }
                    MonitorUtils.syncInitOtp(z);
                    if (z) {
                        F2FPayDefaultClient f2FPayDefaultClient = F2FPayDefaultClient.this;
                        if (f2FPayDefaultClient.mInitializeComponent != null) {
                            Context context = f2FPayDefaultClient.mContext.get();
                            if (context == null) {
                                str2 = HummerZCodeConstant.CONTEXT_ERROR_MSG;
                            } else {
                                String userId = UserInfoManager.instance().getUserId();
                                if (!TextUtils.isEmpty(userId)) {
                                    LoggerWrapper.e(F2FPayConstants.TAG, "re-init otp seed");
                                    String generateDeviceId = F2FPayDefaultClient.this.getClientContext().getDeviceIdGenerator().generateDeviceId(context);
                                    F2FPayDefaultClient.this.mInitializeComponent.initializeOtpInfoInWorker(generateDeviceId, ConvertUtils.getIdentity(userId, generateDeviceId));
                                    return;
                                }
                                str2 = "user id is null";
                            }
                            LoggerWrapper.e(F2FPayConstants.TAG, str2);
                        }
                    }
                }
            };
            SyncProvider syncProvider = new SyncProvider();
            syncProvider.registerReceiveCallback(F2FPayConstants.SyncBiz.F2FPAY_SYNC_GLOBAL, this.b);
            syncProvider.registerReceiveCallback(F2FPayConstants.SyncBiz.F2FPAY_SYNC_USER, this.b);
        }
    }

    public <T extends IF2FPayBaseComponent> void addComponent(Class<T> cls, T t) {
        if (t != null) {
            this.mComponents.put(cls, t);
        }
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public IF2FPayCallbackHolder addPayOpenCallback(IF2FPayOpenCallback iF2FPayOpenCallback) {
        IF2FPayOpenComponent iF2FPayOpenComponent = (IF2FPayOpenComponent) getComponent(IF2FPayOpenComponent.class);
        if (iF2FPayOpenComponent != null) {
            return iF2FPayOpenComponent.addOpenCallback(iF2FPayOpenCallback);
        }
        return null;
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public IF2FPayCallbackHolder addPaymentCodeCallback(IF2FPaymentCodeCallback iF2FPaymentCodeCallback) {
        return this.mPaymentCodeComponent.addPaymentCodeCallback(iF2FPaymentCodeCallback);
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void closeF2FPay() {
        if (!isInitialized()) {
            LoggerWrapper.e(F2FPayConstants.TAG, "[Client] failed to close f2f pay");
            MonitorWrapper.behaviour(BehaviorLogger.Event.FAILED_TO_CLOSE_F2FPAY, null);
            return;
        }
        IF2FPayOpenComponent iF2FPayOpenComponent = (IF2FPayOpenComponent) getComponent(IF2FPayOpenComponent.class);
        LoggerWrapper.d(F2FPayConstants.TAG, "[client] closeF2FPay");
        if (iF2FPayOpenComponent != null) {
            iF2FPayOpenComponent.switchOff();
        }
    }

    protected void createComponents() {
        this.mInitializeComponent = createInitializeComponent();
        this.mPaymentCodeComponent = createPaymentCodeComponent();
        this.mResultHandleComponent = createResultHandleComponent();
        addPayOpenCallback(this);
        addComponent(IF2FPayOpenComponent.class, createOpenComponent());
        addComponent(IF2FPayInitializeComponent.class, this.mInitializeComponent);
        addComponent(IF2FPayPaymentCodeComponent.class, this.mPaymentCodeComponent);
        addComponent(IF2FPayResultHandleComponent.class, this.mResultHandleComponent);
        addComponent(IF2FPayTimeSyncComponent.class, createTimeSyncComponent());
        addComponent(IF2FPayUserSwitchComponent.class, createUserSwitchComponent());
    }

    protected IF2FPayInitializeComponent createInitializeComponent() {
        return new DefaultInitializeComponent();
    }

    protected IF2FPayOpenComponent createOpenComponent() {
        return new DefaultOpenComponent();
    }

    protected IF2FPayPaymentCodeComponent createPaymentCodeComponent() {
        return new DefaultPaymentCodeComponent();
    }

    protected IF2FPayResultHandleComponent createResultHandleComponent() {
        return new PollingSyncResultHandleComponent();
    }

    protected IF2FPayTimeSyncComponent createTimeSyncComponent() {
        return new DefaultTimeSyncComponent();
    }

    protected IF2FPayUserSwitchComponent createUserSwitchComponent() {
        return new DefaultUserSwitchComponent();
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void deleteOtpSeed() {
        if (!isInitialized()) {
            LoggerWrapper.e(F2FPayConstants.TAG, "[Client] failed to delete OTP seed");
            MonitorWrapper.behaviour(BehaviorLogger.Event.FAILED_TO_DELETE_OTP_SEED, null);
            return;
        }
        F2FPayClientContext f2FPayClientContext = this.mClientContext;
        if (f2FPayClientContext != null) {
            f2FPayClientContext.getSecureStorage().clear();
        }
    }

    public String getBizType() {
        return "f2fpay";
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public F2FPayClientContext getClientContext() {
        return this.mClientContext;
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public <T extends IF2FPayBaseComponent> T getComponent(Class<T> cls) {
        synchronized (this) {
            T t = (T) this.mComponents.get(cls);
            if (t != null) {
                return t;
            }
            Iterator<IF2FPayBaseComponent> it = this.mComponents.values().iterator();
            while (it.hasNext()) {
                T t2 = (T) it.next();
                if (cls.isAssignableFrom(t2.getClass())) {
                    this.mComponents.put(cls, t2);
                    return t2;
                }
            }
            return null;
        }
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public Context getContext() {
        return this.mContext.get();
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public String getSeedExtra() {
        return this.f6951a;
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public boolean getStartRefreshFlag() {
        return this.startRefreshFlag;
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void initialize(Application application, F2FPayClientContext f2FPayClientContext) {
        this.mContext = new WeakReference<>(application);
        this.mClientContext = f2FPayClientContext;
        MonitorUtils.funnelInitClient();
        initializeComponents();
        a();
    }

    public void initializeComponents() {
        synchronized (this) {
            if (this.mInitialized) {
                return;
            }
            KeyValueRegistry.getInstance().initialize(getContext());
            Iterator<IF2FPayBaseComponent> it = this.mComponents.values().iterator();
            while (it.hasNext()) {
                it.next().initialize(this);
            }
            this.mInitialized = true;
        }
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public boolean isInitialized() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Client] isInitialized: ");
        sb.append(this.mInitialized);
        LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
        return this.mInitialized;
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void onDestroy() {
        if (!isInitialized()) {
            LoggerWrapper.e(F2FPayConstants.TAG, "[Client] failed to destroy");
            MonitorWrapper.behaviour(BehaviorLogger.Event.FAILED_TO_DESTROY, null);
            return;
        }
        LoggerWrapper.d(F2FPayConstants.TAG, "[Client] onDestroy.");
        IF2FPayUserSwitchComponent iF2FPayUserSwitchComponent = (IF2FPayUserSwitchComponent) getComponent(IF2FPayUserSwitchComponent.class);
        if (iF2FPayUserSwitchComponent != null && (iF2FPayUserSwitchComponent instanceof DefaultUserSwitchComponent)) {
            ((DefaultUserSwitchComponent) iF2FPayUserSwitchComponent).onDestroy();
        }
        SyncProvider syncProvider = new SyncProvider();
        syncProvider.unregisterReceiveCallback(F2FPayConstants.SyncBiz.F2FPAY_SYNC_USER);
        syncProvider.unregisterReceiveCallback(F2FPayConstants.SyncBiz.F2FPAY_SYNC_GLOBAL);
        this.b = null;
    }

    @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
    public void onSwitchOffFailed(String str) {
    }

    @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
    public void onSwitchOnCanceled() {
    }

    @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
    public void onSwitchOnFailed(String str) {
    }

    @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
    public void onSwitchStatusChanged(boolean z, IF2FPayOpenCallback.StatusChangeCausedBy statusChangeCausedBy) {
        if (z) {
            this.mInitializeComponent.asyncInitializeOtpInfo();
        }
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void refreshPaymentCode(int i) {
        if (isInitialized()) {
            this.mPaymentCodeComponent.requestRefresh(i);
            return;
        }
        LoggerWrapper.e(F2FPayConstants.TAG, "[Client] failed to refresh payment code");
        MonitorWrapper.behaviour(BehaviorLogger.Event.FAILED_TO_REFRESH_PAYMENT_CODE, null);
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void setPayResultCallback(IF2FPayResultCallback iF2FPayResultCallback) {
        this.mResultHandleComponent.setPayResultCallback(iF2FPayResultCallback);
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void setSeedExtra(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f6951a = str;
        stopRefreshTask();
        startRefreshTask();
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void setStartRefreshFlag(boolean z) {
        this.startRefreshFlag = z;
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void startF2FPay() {
        if (!isInitialized()) {
            LoggerWrapper.e(F2FPayConstants.TAG, "[Client] failed to start f2f pay");
            MonitorWrapper.behaviour(BehaviorLogger.Event.FAILED_TO_START_F2FPAY, null);
            return;
        }
        MonitorUtils.funnelStart();
        LoggerWrapper.d(F2FPayConstants.TAG, "[Client] start f2fpay.");
        this.startRefreshFlag = true;
        IF2FPayOpenComponent iF2FPayOpenComponent = (IF2FPayOpenComponent) getComponent(IF2FPayOpenComponent.class);
        if (iF2FPayOpenComponent == null) {
            this.mInitializeComponent.asyncInitializeOtpInfo();
        } else {
            iF2FPayOpenComponent.checkOpen();
        }
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void startRefreshTask() {
        if (!isInitialized()) {
            LoggerWrapper.e(F2FPayConstants.TAG, "[Client] failed to start refresh task");
            MonitorWrapper.behaviour(BehaviorLogger.Event.FAILED_TO_START_REFRESH_TASK, null);
            return;
        }
        this.startRefreshFlag = true;
        LoggerWrapper.d(F2FPayConstants.TAG, "[client] startRefreshTask. (PaymentCode-generate, PayResult-polling)");
        this.mPaymentCodeComponent.startRefreshTask();
        this.mResultHandleComponent.startHandleResult();
    }

    @Override // com.alipay.iap.android.f2fpay.client.IF2FPayClient
    public void stopRefreshTask() {
        if (!isInitialized()) {
            LoggerWrapper.e(F2FPayConstants.TAG, "[Client] failed to stop refresh task");
            MonitorWrapper.behaviour(BehaviorLogger.Event.FAILED_TO_STOP_REFRESH_TASK, null);
            return;
        }
        this.startRefreshFlag = false;
        LoggerWrapper.d(F2FPayConstants.TAG, "[Client] stopRefreshTask. (PaymentCode-generate, PayResult-polling)");
        this.mPaymentCodeComponent.stopRefreshTask();
        this.mResultHandleComponent.stopHandleResult();
    }
}
