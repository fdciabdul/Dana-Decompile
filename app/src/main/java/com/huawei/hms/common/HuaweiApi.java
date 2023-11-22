package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {
    private static final String TAG = "HuaweiApi";
    private String innerHmsPkg;
    private boolean isUseInnerHms;
    private WeakReference<Activity> mActivity;
    private String mAppID;
    private AbstractClientBuilder<?, TOption> mClientBuilder;
    private Context mContext;
    private String mHostAppid;
    private Context mHostContext;
    private int mKitSdkVersion;
    private TOption mOption;
    private SubAppInfo mSubAppInfo;
    private RequestManager requestManager;
    private int apiLevel = 1;
    private boolean isFirstReqSent = false;

    /* loaded from: classes7.dex */
    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {
        private final HuaweiApi<OptionsT> mApi;
        private final AnyClient mClient;
        private ResolveClientBean mResolveClientBean;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();
        private final Queue<TaskApiCallbackWrapper> callbackRunQueue = new LinkedList();
        private ConnectionResult mConnectionResult = null;

        RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.mApi = huaweiApi;
            this.mClient = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        private String errorReason(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.mApi.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode != 3) {
                        if (errorCode != 8) {
                            if (errorCode != 10) {
                                if (errorCode == 13) {
                                    return "update cancelled";
                                }
                                if (errorCode == 21) {
                                    return "device is too old to be support";
                                }
                                switch (errorCode) {
                                    case 25:
                                        return "failed to get update result";
                                    case 26:
                                        return "update failed, because no activity incoming, can't pop update page";
                                    case 27:
                                        return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                }
                            }
                        }
                        return "internal error";
                    }
                    return "HuaWei Mobile Service is disabled";
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 != 8) {
                    return errorCode2 != 10 ? "unknown errorReason" : "application configuration error, please developer check configuration";
                }
                return "internal error";
            }
            return "get update result, but has other error codes";
        }

        private String getTransactionId(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.mApi.getAppID(), str2) : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnected() {
            this.mConnectionResult = null;
            this.callbackRunQueue.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnectionFailed(ConnectionResult connectionResult) {
            this.mConnectionResult = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z = true;
            while (it.hasNext()) {
                TaskApiCallWrapper apiCallWrapper = it.next().getApiCallWrapper();
                StringBuilder sb = new StringBuilder();
                sb.append("Connection Failed:");
                sb.append(errorReason(connectionResult));
                sb.append("(");
                sb.append(connectionResult.getErrorCode());
                sb.append(")");
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, sb.toString());
                responseHeader.setTransactionId(apiCallWrapper.getTaskApiCall().getTransactionId());
                b.MyBillsEntityDataFactory(this.mApi.getContext(), responseHeader, String.valueOf(this.mApi.getKitSdkVersion()));
                if (this.mConnectionResult.getResolution() != null && z) {
                    responseHeader.setParcelable(this.mConnectionResult.getResolution());
                    if (Util.isAvailableLibExist(this.mApi.getContext()) && this.mConnectionResult.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                    z = false;
                }
                int errorCode = this.mConnectionResult.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                apiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, apiCallWrapper.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.callbackRunQueue.clear();
            this.mConnectionResult = null;
            this.mClient.disconnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnectionSuspended() {
            StringBuilder sb = new StringBuilder();
            sb.append("wait queue size = ");
            sb.append(this.callbackWaitQueue.size());
            HMSLog.i(HuaweiApi.TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("run queue size = ");
            sb2.append(this.callbackRunQueue.size());
            HMSLog.i(HuaweiApi.TAG, sb2.toString());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                sendConnectionSuspended(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it2 = this.callbackRunQueue.iterator();
            while (it2.hasNext()) {
                sendConnectionSuspended(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.callbackRunQueue.clear();
            this.mConnectionResult = null;
            this.mClient.disconnect();
        }

        private void sendConnectionSuspended(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper apiCallWrapper = taskApiCallbackWrapper.getApiCallWrapper();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(apiCallWrapper.getTaskApiCall().getTransactionId());
            apiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, apiCallWrapper.getTaskCompletionSource());
        }

        private TaskApiCallbackWrapper wrapperRequest(final TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1
                private AtomicBoolean isFirstRsp = new AtomicBoolean(true);

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.e(HuaweiApi.TAG, "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.disconnect();
                        HMSLog.i(HuaweiApi.TAG, "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Response has resolution: ");
                        sb.append(responseHeader.getResolution());
                        HMSLog.e(HuaweiApi.TAG, sb.toString());
                    }
                    if (this.isFirstRsp.compareAndSet(true, false)) {
                        b.MyBillsEntityDataFactory(RequestHandler.this.mApi.getContext(), responseHeader, String.valueOf(RequestHandler.this.mApi.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.mClient, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        void connect(int i, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            synchronized (this) {
                if (this.mClient.isConnected()) {
                    HMSLog.d(HuaweiApi.TAG, "client is connected");
                } else if (this.mClient.isConnecting()) {
                    HMSLog.d(HuaweiApi.TAG, "client is isConnecting");
                } else {
                    if (this.mApi.getActivity() != null) {
                        if (this.mResolveClientBean == null) {
                            this.mResolveClientBean = new ResolveClientBean(this.mClient, i);
                        }
                        if (BindResolveClients.getInstance().isClientRegistered(this.mResolveClientBean)) {
                            HMSLog.i(HuaweiApi.TAG, "mResolveClientBean has already register, return!");
                            return;
                        }
                        BindResolveClients.getInstance().register(this.mResolveClientBean);
                    }
                    this.mClient.connect(i);
                }
            }
        }

        void disconnect() {
            this.mClient.disconnect();
        }

        public AnyClient getClient() {
            return this.mClient;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.i(HuaweiApi.TAG, "onConnected");
            BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
            this.mResolveClientBean = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.innerConnected();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.i(HuaweiApi.TAG, "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
            this.mResolveClientBean = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.innerConnectionFailed(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            HMSLog.i(HuaweiApi.TAG, "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
            this.mResolveClientBean = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.innerConnectionSuspended();
                }
            });
        }

        public void postMessage(final TaskApiCallbackWrapper taskApiCallbackWrapper) {
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getTransactionId(), this);
            this.callbackRunQueue.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getUri();
            String packageName = (((HuaweiApi) this.mApi).mHostContext == null ? this.mApi.getContext() : ((HuaweiApi) this.mApi).mHostContext).getPackageName();
            if (((HuaweiApi) this.mApi).mHostContext != null) {
                HuaweiApi<OptionsT> huaweiApi = this.mApi;
                huaweiApi.setHostAppId(((HuaweiApi) huaweiApi).mHostContext);
            }
            final RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            StringBuilder sb = new StringBuilder();
            sb.append(this.mApi.getAppID());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(this.mApi.getSubAppID());
            requestHeader.setAppID(sb.toString());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.mClient.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall();
            requestHeader.setTransactionId(getTransactionId(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.mApi.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.mApi.getApiLevel(), taskApiCall.getApiLevel()));
            this.mClient.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack callBack = taskApiCallbackWrapper.getCallBack();
                    if (callBack != null) {
                        callBack.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.callbackRunQueue.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        void sendRequest(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.i(HuaweiApi.TAG, "sendRequest");
            TaskApiCallbackWrapper wrapperRequest = wrapperRequest(taskApiCallWrapper);
            if (this.mClient.isConnected()) {
                HMSLog.i(HuaweiApi.TAG, "isConnected:true.");
                BinderAdapter adapter = ((BaseHmsClient) this.mClient).getAdapter();
                adapter.updateDelayTask();
                ((HmsClient) this.mClient).setService(IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                postMessage(wrapperRequest);
                return;
            }
            HMSLog.i(HuaweiApi.TAG, "isConnected:false.");
            this.callbackWaitQueue.add(wrapperRequest);
            ConnectionResult connectionResult = this.mConnectionResult;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConnectionFailed, ErrorCode:");
                sb.append(this.mConnectionResult.getErrorCode());
                HMSLog.i(HuaweiApi.TAG, sb.toString());
                onConnectionFailed(this.mConnectionResult);
                return;
            }
            RequestManager.addRequestToQueue(this);
            AnyClient anyClient = this.mClient;
            if (anyClient instanceof BaseHmsClient) {
                ((BaseHmsClient) anyClient).setInternalRequest(this);
            }
            connect(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), wrapperRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class RequestRunnable<OptionsT extends Api.ApiOptions> implements Runnable {
        private final HuaweiApi<OptionsT> mApi;
        private final TaskApiCallWrapper mTaskApiCallWrapper;

        public RequestRunnable(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.mApi = huaweiApi;
            this.mTaskApiCallWrapper = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void notifyCpException(com.huawei.hms.common.HuaweiApi.RequestHandler r9, java.lang.Exception r10) {
            /*
                r8 = this;
                java.lang.String r0 = "HuaweiApi"
                r1 = 1
                r2 = 0
                com.huawei.hms.common.internal.AnyClient r9 = r9.getClient()     // Catch: java.lang.RuntimeException -> L38
                com.huawei.hms.common.internal.ResponseHeader r3 = new com.huawei.hms.common.internal.ResponseHeader     // Catch: java.lang.RuntimeException -> L35
                r4 = 907135001(0x3611c819, float:2.1723156E-6)
                java.lang.String r10 = r10.getMessage()     // Catch: java.lang.RuntimeException -> L35
                r3.<init>(r1, r4, r10)     // Catch: java.lang.RuntimeException -> L35
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.RuntimeException -> L30
                r10.<init>()     // Catch: java.lang.RuntimeException -> L30
                java.lang.String r10 = r10.toString()     // Catch: java.lang.RuntimeException -> L30
                com.huawei.hms.common.internal.TaskApiCallWrapper r4 = r8.mTaskApiCallWrapper     // Catch: java.lang.RuntimeException -> L2c
                com.huawei.hmf.tasks.TaskCompletionSource r4 = r4.getTaskCompletionSource()     // Catch: java.lang.RuntimeException -> L2c
                com.huawei.hms.common.internal.TaskApiCallWrapper r5 = r8.mTaskApiCallWrapper     // Catch: java.lang.RuntimeException -> L2a
                com.huawei.hms.common.internal.TaskApiCall r2 = r5.getTaskApiCall()     // Catch: java.lang.RuntimeException -> L2a
                goto L56
            L2a:
                r5 = move-exception
                goto L3e
            L2c:
                r4 = move-exception
                r5 = r4
                r4 = r2
                goto L3e
            L30:
                r10 = move-exception
                r5 = r10
                r10 = r2
                r4 = r10
                goto L3e
            L35:
                r10 = move-exception
                r5 = r10
                goto L3b
            L38:
                r9 = move-exception
                r5 = r9
                r9 = r2
            L3b:
                r10 = r2
                r3 = r10
                r4 = r3
            L3e:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "<notifyCpException> "
                r6.append(r7)
                java.lang.String r5 = r5.getMessage()
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                com.huawei.hms.support.log.HMSLog.e(r0, r5)
            L56:
                if (r9 == 0) goto L60
                if (r3 == 0) goto L60
                if (r10 == 0) goto L60
                if (r4 == 0) goto L60
                if (r2 != 0) goto L61
            L60:
                r1 = 0
            L61:
                if (r1 == 0) goto L67
                r2.onResponse(r9, r3, r10, r4)
                return
            L67:
                java.lang.String r9 = "<notifyCpException> isNotify is false, Can not notify CP."
                com.huawei.hms.support.log.HMSLog.e(r0, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.HuaweiApi.RequestRunnable.notifyCpException(com.huawei.hms.common.HuaweiApi$RequestHandler, java.lang.Exception):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.mApi);
            try {
                requestHandler.sendRequest(this.mTaskApiCallWrapper);
            } catch (RuntimeException e) {
                notifyCpException(requestHandler, e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class TaskApiCallbackWrapper {
        private final TaskApiCallWrapper mApiCallWrapper;
        private final AnyClient.CallBack mCallBack;

        TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.mApiCallWrapper = taskApiCallWrapper;
            this.mCallBack = callBack;
        }

        TaskApiCallWrapper getApiCallWrapper() {
            return this.mApiCallWrapper;
        }

        AnyClient.CallBack getCallBack() {
            return this.mCallBack;
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, null);
    }

    private void init(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        this.mContext = context.getApplicationContext();
        this.mOption = toption;
        this.mClientBuilder = abstractClientBuilder;
        setHostAppId(context);
        this.mSubAppInfo = new SubAppInfo("");
        this.mKitSdkVersion = i;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.mHostAppid)) {
                HMSLog.e(TAG, "subAppId is host appid");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("subAppId is ");
                sb.append(str);
                HMSLog.i(TAG, sb.toString());
                this.mSubAppInfo = new SubAppInfo(str);
            }
        }
        initBI(context);
    }

    private void initBI(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerDisconnect(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.i(TAG, "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.getAuthRequestContext(Boolean.TRUE);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("disconnect the binder failed for:");
            sb.append(e.getMessage());
            HMSLog.w(TAG, sb.toString());
        }
    }

    private <TResult, TClient extends AnyClient> Task<TResult> sendRequest(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new RequestRunnable(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHostAppId(Context context) {
        String appId = Util.getAppId(context);
        this.mHostAppid = appId;
        this.mAppID = appId;
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1
            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.innerDisconnect(this, taskCompletionSource);
            }
        });
        return taskCompletionSource.MyBillsEntityDataFactory;
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.isFirstReqSent = true;
        if (taskApiCall == null) {
            HMSLog.e(TAG, "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((Exception) new ApiException(Status.FAILURE));
            return taskCompletionSource.MyBillsEntityDataFactory;
        }
        b.MyBillsEntityDataFactory(this.mContext, taskApiCall.getUri(), TextUtils.isEmpty(this.mSubAppInfo.getSubAppID()) ? this.mAppID : this.mSubAppInfo.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.requestManager == null) {
            this.requestManager = RequestManager.getInstance();
        }
        return sendRequest(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getAppID() {
        return this.mAppID;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.huawei.hms.common.internal.AnyClient] */
    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.mClientBuilder.buildClient(this.mContext, getClientSetting(), requestHandler, requestHandler);
    }

    protected ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.mContext.getPackageName(), this.mContext.getClass().getName(), getScopes(), this.mHostAppid, null, this.mSubAppInfo);
        if (!this.isUseInnerHms) {
            this.innerHmsPkg = HMSPackageManager.getInstance(this.mContext).getHMSPackageNameForMultiService();
            StringBuilder sb = new StringBuilder();
            sb.append("No setInnerHms, hms pkg name is ");
            sb.append(this.innerHmsPkg);
            HMSLog.i(TAG, sb.toString());
        }
        clientSettings.setInnerHmsPkg(this.innerHmsPkg);
        clientSettings.setUseInnerHms(this.isUseInnerHms);
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getKitSdkVersion() {
        return this.mKitSdkVersion;
    }

    public TOption getOption() {
        return this.mOption;
    }

    protected List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.mSubAppInfo.getSubAppID();
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setHostContext(Context context) {
        this.mHostContext = context;
    }

    public void setInnerHms() {
        this.innerHmsPkg = this.mContext.getPackageName();
        this.isUseInnerHms = true;
        StringBuilder sb = new StringBuilder();
        sb.append("<setInnerHms> init inner hms pkg info:");
        sb.append(this.innerHmsPkg);
        HMSLog.i(TAG, sb.toString());
    }

    public void setKitSdkVersion(int i) {
        this.mKitSdkVersion = i;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i(TAG, "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.mSubAppInfo;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.e(TAG, "subAppInfo is already set");
            return false;
        } else if (subAppInfo == null) {
            HMSLog.e(TAG, "subAppInfo is null");
            return false;
        } else {
            String subAppID = subAppInfo.getSubAppID();
            if (TextUtils.isEmpty(subAppID)) {
                HMSLog.e(TAG, "subAppId is empty");
                return false;
            } else if (subAppID.equals(this.mHostAppid)) {
                HMSLog.e(TAG, "subAppId is host appid");
                return false;
            } else if (this.isFirstReqSent) {
                HMSLog.e(TAG, "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
                return false;
            } else {
                this.mSubAppInfo = new SubAppInfo(subAppInfo);
                return true;
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, str);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, 0, null);
    }
}
