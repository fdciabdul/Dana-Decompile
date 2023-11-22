package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {
    private static final String TAG = "PendingResultImpl";
    private WeakReference<ApiClient> api;
    private CountDownLatch countLatch;
    protected DatagramTransport transport = null;
    private R result = null;
    private String url = null;
    private String transId = null;
    private boolean isNeedReport = true;

    /* loaded from: classes8.dex */
    class a implements DatagramTransport.a {
        a() {
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public final void BuiltInFictitiousFunctionClassFactory(int i, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.setResult(i, iMessageEntity);
            PendingResultImpl.this.countLatch.countDown();
        }
    }

    /* loaded from: classes8.dex */
    class b implements DatagramTransport.a {
        final /* synthetic */ AtomicBoolean getAuthRequestContext;

        b(AtomicBoolean atomicBoolean) {
            this.getAuthRequestContext = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public final void BuiltInFictitiousFunctionClassFactory(int i, IMessageEntity iMessageEntity) {
            if (!this.getAuthRequestContext.get()) {
                PendingResultImpl.this.setResult(i, iMessageEntity);
            }
            PendingResultImpl.this.countLatch.countDown();
        }
    }

    /* loaded from: classes8.dex */
    class c implements DatagramTransport.a {
        final /* synthetic */ ResultCallback MyBillsEntityDataFactory;
        final /* synthetic */ d PlaceComponentResult;

        c(d dVar, ResultCallback resultCallback) {
            this.PlaceComponentResult = dVar;
            this.MyBillsEntityDataFactory = resultCallback;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public final void BuiltInFictitiousFunctionClassFactory(int i, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.setResult(i, iMessageEntity);
            d dVar = this.PlaceComponentResult;
            dVar.sendMessage(dVar.obtainMessage(1, new Pair(this.MyBillsEntityDataFactory, PendingResultImpl.this.result)));
        }
    }

    /* loaded from: classes8.dex */
    protected static class d<R extends Result> extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Pair pair = (Pair) message.obj;
                ((ResultCallback) pair.first).onResult((Result) pair.second);
            }
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        init(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    private void biReportEvent(int i, int i2) {
        SubAppInfo subAppInfo;
        HMSLog.i(TAG, "biReportEvent ====== ");
        ApiClient apiClient = this.api.get();
        if (apiClient == null || this.url == null || HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package", apiClient.getPackageName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
        if (i2 == 1) {
            hashMap.put("direction", HiAnalyticsConstant.Direction.REQUEST);
        } else {
            hashMap.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
            hashMap.put("result", String.valueOf(i));
            R r = this.result;
            if (r != null && r.getStatus() != null) {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(this.result.getStatus().getStatusCode()));
            }
        }
        hashMap.put("version", "0");
        String appId = Util.getAppId(apiClient.getContext());
        if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
            appId = subAppInfo.getSubAppID();
        }
        hashMap.put("appid", appId);
        if (TextUtils.isEmpty(this.transId)) {
            String id2 = TransactionIdCreater.getId(appId, this.url);
            this.transId = id2;
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id2);
        } else {
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.transId);
            this.transId = null;
        }
        String[] split = this.url.split("\\.");
        if (split.length >= 2) {
            hashMap.put("service", split[0]);
            hashMap.put("apiName", split[1]);
        }
        hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, hashMap);
    }

    private void init(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("init uri:");
        sb.append(str);
        HMSLog.i(TAG, sb.toString());
        this.url = str;
        if (apiClient == null) {
            HMSLog.e(TAG, "client is null");
            return;
        }
        this.api = new WeakReference<>(apiClient);
        this.countLatch = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("gen transport error:");
            sb2.append(e.getMessage());
            HMSLog.e(TAG, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Instancing transport exception, ");
            sb3.append(e.getMessage());
            throw new IllegalStateException(sb3.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setResult(int i, IMessageEntity iMessageEntity) {
        Status status;
        StringBuilder sb = new StringBuilder();
        sb.append("setResult:");
        sb.append(i);
        HMSLog.i(TAG, sb.toString());
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i == 0) {
            this.result = onComplete(iMessageEntity);
        } else {
            this.result = onError(i);
        }
        if (this.isNeedReport) {
            biReportEvent(i, 2);
        }
        R r = this.result;
        if (r == null || (status = r.getStatus()) == null || commonStatus == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage();
        int statusCode2 = commonStatus.getStatusCode();
        String statusMessage2 = commonStatus.getStatusMessage();
        if (statusCode != statusCode2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("rstStatus code (");
            sb2.append(statusCode);
            sb2.append(") is not equal commonStatus code (");
            sb2.append(statusCode2);
            sb2.append(")");
            HMSLog.e(TAG, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("rstStatus msg (");
            sb3.append(statusMessage);
            sb3.append(") is not equal commonStatus msg (");
            sb3.append(statusMessage2);
            sb3.append(")");
            HMSLog.e(TAG, sb3.toString());
        } else if (!TextUtils.isEmpty(statusMessage) || TextUtils.isEmpty(statusMessage2)) {
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("rstStatus msg (");
            sb4.append(statusMessage);
            sb4.append(") is not equal commonStatus msg (");
            sb4.append(statusMessage2);
            sb4.append(")");
            HMSLog.i(TAG, sb4.toString());
            this.result.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.i(TAG, "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        HMSLog.e(TAG, "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        HMSLog.i(TAG, "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.api;
        if (weakReference == null) {
            HMSLog.e(TAG, "api is null");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e(TAG, "client invalid");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.send(apiClient, new a());
        try {
            this.countLatch.await();
        } catch (InterruptedException unused) {
            HMSLog.e(TAG, "await in anythread InterruptedException");
            setResult(CommonCode.ErrorCode.INTERNAL_ERROR, null);
        }
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    protected Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t);

    protected R onError(int i) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class<?> type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r = (R) type2.newInstance();
                this.result = r;
                r.setStatus(new Status(i));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("on Error:");
                sb.append(e.getMessage());
                HMSLog.e(TAG, sb.toString());
                return null;
            }
        }
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.isNeedReport = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        HMSLog.i(TAG, "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        d dVar = new d(looper);
        WeakReference<ApiClient> weakReference = this.api;
        if (weakReference == null) {
            HMSLog.e(TAG, "api is null");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e(TAG, "client is invalid");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            dVar.sendMessage(dVar.obtainMessage(1, new Pair(resultCallback, this.result)));
            return;
        }
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.post(apiClient, new c(dVar, resultCallback));
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        StringBuilder sb = new StringBuilder();
        sb.append("await timeout:");
        sb.append(j);
        sb.append(" unit:");
        sb.append(timeUnit.toString());
        HMSLog.i(TAG, sb.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread(j, timeUnit);
        }
        HMSLog.i(TAG, "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        init(apiClient, str, iMessageEntity, cls, 0);
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j, TimeUnit timeUnit) {
        StringBuilder sb = new StringBuilder();
        sb.append("awaitOnAnyThread timeout:");
        sb.append(j);
        sb.append(" unit:");
        sb.append(timeUnit.toString());
        HMSLog.i(TAG, sb.toString());
        WeakReference<ApiClient> weakReference = this.api;
        if (weakReference == null) {
            HMSLog.e(TAG, "api is null");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e(TAG, "client invalid");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.post(apiClient, new b(atomicBoolean));
        try {
            if (!this.countLatch.await(j, timeUnit)) {
                atomicBoolean.set(true);
                setResult(CommonCode.ErrorCode.EXECUTE_TIMEOUT, null);
            }
        } catch (InterruptedException unused) {
            HMSLog.e(TAG, "awaitOnAnyThread InterruptedException");
            setResult(CommonCode.ErrorCode.INTERNAL_ERROR, null);
        }
        return this.result;
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i) {
        init(apiClient, str, iMessageEntity, getResponseType(), i);
    }
}