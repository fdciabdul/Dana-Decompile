package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import id.dana.analytics.tracker.TrackerKey;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BaseAdapter {
    private static final String HMS_SESSION_INVALID = "com.huawei.hms.core.action.SESSION_INVALID";
    private static final String TAG = "BaseAdapter";
    private WeakReference<Activity> activityWeakReference;
    private WeakReference<ApiClient> api;
    private Context appContext;
    private BaseCallBack baseCallBackReplay;
    private BaseCallBack callback;
    private String jsonHeaderReplay;
    private String jsonObjectReplay;
    private SystemObserver observer;
    private Parcelable parcelableReplay;
    private RequestHeader requestHeader = new RequestHeader();
    private ResponseHeader responseHeader = new ResponseHeader();
    private String transactionId;

    /* loaded from: classes7.dex */
    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    /* loaded from: classes7.dex */
    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {
        private AtomicBoolean isFirstRsp = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
            BaseAdapter.this = r2;
        }

        private void handleSolutionForHms(final BaseCallBack baseCallBack) {
            if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                Activity cpActivity = BaseAdapter.this.getCpActivity();
                if (cpActivity != null && !cpActivity.isFinishing()) {
                    HMSLog.i(BaseAdapter.TAG, "start handleSolutionForHMS");
                    AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
                    availableAdapter.setCalledBySolutionInstallHms(true);
                    availableAdapter.startResolution(cpActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1
                        {
                            BaseRequestResultCallback.this = this;
                        }

                        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                        public void onComplete(int i) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("complete handleSolutionForHMS, result: ");
                            sb.append(i);
                            HMSLog.i(BaseAdapter.TAG, sb.toString());
                            if (i == 0) {
                                HMSPackageManager.getInstance(BaseAdapter.this.appContext).resetMultiServiceState();
                                BaseAdapter baseAdapter = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter.buildResponseWrap(11, baseAdapter.buildBodyStr(11)).toJson());
                                BaseAdapter.this.sendBroadcastAfterResolutionHms();
                                return;
                            }
                            BaseAdapter baseAdapter2 = BaseAdapter.this;
                            baseCallBack.onError(baseAdapter2.buildResponseWrap(i, baseAdapter2.buildBodyStr(i)).toJson());
                        }
                    });
                    return;
                }
                HMSLog.e(BaseAdapter.TAG, "activity is null");
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseCallBack.onError(baseAdapter.buildResponseWrap(-3, baseAdapter.buildBodyStr(-3)).toJson());
                return;
            }
            HMSLog.i(BaseAdapter.TAG, "handleSolutionForHms: no Available lib exist");
            baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
        }

        private void handleSolutionIntent(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            HMSLog.i(BaseAdapter.TAG, "baseCallBack.onComplete");
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
                return;
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intent);
            } else {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
            }
        }

        private void resolutionResult(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i) {
            if ("intent".equals(str)) {
                Activity cpActivity = BaseAdapter.this.getCpActivity();
                StringBuilder sb = new StringBuilder();
                sb.append("activity is: ");
                sb.append(cpActivity);
                HMSLog.i(BaseAdapter.TAG, sb.toString());
                if (cpActivity != null && !cpActivity.isFinishing()) {
                    PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
                    if (pendingIntent != null) {
                        if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                            BaseAdapter.this.startResolution(cpActivity, pendingIntent);
                            return;
                        } else {
                            baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
                            return;
                        }
                    }
                    Intent intent = coreBaseResponse.getIntent();
                    if (intent != null) {
                        if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                            BaseAdapter.this.startResolution(cpActivity, intent);
                            return;
                        } else {
                            baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
                            return;
                        }
                    } else if (i == 2) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.getResponseHeaderForError(baseAdapter.responseHeader.getErrorCode()));
                        return;
                    } else {
                        HMSLog.e(BaseAdapter.TAG, "hasResolution is true but NO_SOLUTION");
                        baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-4));
                        return;
                    }
                }
                HMSLog.e(BaseAdapter.TAG, "activity null");
                handleSolutionIntent(baseCallBack, coreBaseResponse);
            } else if ("installHMS".equals(str)) {
                HMSLog.i(BaseAdapter.TAG, "has resolutin: installHMS, but base-sdk can't support to install HMS");
                handleSolutionForHms(baseCallBack);
            } else {
                handleSolutionIntent(baseCallBack, coreBaseResponse);
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            BaseCallBack callBack = BaseAdapter.this.getCallBack();
            if (callBack == null) {
                HMSLog.e(BaseAdapter.TAG, "onResult baseCallBack null");
            } else if (resolveResult == null) {
                HMSLog.e(BaseAdapter.TAG, "result null");
                callBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
            } else {
                CoreBaseResponse value = resolveResult.getValue();
                if (value == null) {
                    HMSLog.e(BaseAdapter.TAG, "response null");
                    callBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
                } else if (!TextUtils.isEmpty(value.getJsonHeader())) {
                    JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.responseHeader);
                    if (this.isFirstRsp.compareAndSet(true, false)) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.biReportRequestReturnIpc(baseAdapter.appContext, BaseAdapter.this.responseHeader);
                    }
                    String resolution = BaseAdapter.this.responseHeader.getResolution();
                    int statusCode = BaseAdapter.this.responseHeader.getStatusCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append("api is: ");
                    sb.append(BaseAdapter.this.responseHeader.getApiName());
                    sb.append(", resolution: ");
                    sb.append(resolution);
                    sb.append(", status_code: ");
                    sb.append(statusCode);
                    HMSLog.i(BaseAdapter.TAG, sb.toString());
                    resolutionResult(resolution, callBack, value, statusCode);
                } else {
                    HMSLog.e(BaseAdapter.TAG, "jsonHeader null");
                    callBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class MPendingResultImpl extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public MPendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.api = new WeakReference<>(apiClient);
        this.appContext = apiClient.getContext().getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append("In constructor, WeakReference is ");
        sb.append(this.api);
        HMSLog.i(TAG, sb.toString());
    }

    private void biReportRequestEntryIpc(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put("direction", HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    private void biReportRequestEntrySolution(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put("direction", HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    public void biReportRequestReturnIpc(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    public void biReportRequestReturnSolution(Context context, ResponseHeader responseHeader, long j) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    public String buildBodyStr(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("buildBodyStr failed: ");
            sb.append(e.getMessage());
            HMSLog.e(TAG, sb.toString());
        }
        return jSONObject.toString();
    }

    public ResponseWrap buildResponseWrap(int i, String str) {
        setResponseHeader(i);
        ResponseWrap responseWrap = new ResponseWrap(this.responseHeader);
        responseWrap.setBody(str);
        return responseWrap;
    }

    private BaseCallBack getBaseCallBackReplay() {
        return this.baseCallBackReplay;
    }

    public BaseCallBack getCallBack() {
        BaseCallBack baseCallBack = this.callback;
        if (baseCallBack == null) {
            HMSLog.e(TAG, "callback null");
            return null;
        }
        return baseCallBack;
    }

    public Activity getCpActivity() {
        if (this.activityWeakReference == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("activityWeakReference is ");
            sb.append(this.activityWeakReference);
            HMSLog.i(TAG, sb.toString());
            return null;
        }
        ApiClient apiClient = this.api.get();
        if (apiClient == null) {
            HMSLog.i(TAG, "tmpApi is null");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("activityWeakReference has ");
        sb2.append(this.activityWeakReference.get());
        HMSLog.i(TAG, sb2.toString());
        return Util.getActiveActivity(this.activityWeakReference.get(), apiClient.getContext());
    }

    private String getJsonHeaderReplay() {
        return this.jsonHeaderReplay;
    }

    private String getJsonObjectReplay() {
        return this.jsonObjectReplay;
    }

    private Parcelable getParcelableReplay() {
        return this.parcelableReplay;
    }

    public String getResponseHeaderForError(int i) {
        setResponseHeader(i);
        return this.responseHeader.toJson();
    }

    public boolean hasExtraPrivacyResult(Intent intent, BaseCallBack baseCallBack) {
        if (intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            if (intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001) == 1001) {
                HMSLog.i(TAG, "privacy_statement_confirm_result agreed, replay request");
                replayRequest();
                return true;
            }
            HMSLog.i(TAG, "privacy_statement_confirm_result rejected");
            baseCallBack.onError(buildResponseWrap(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, buildBodyStr(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
            return true;
        }
        return false;
    }

    public boolean hasExtraUpdateResult(Intent intent, BaseCallBack baseCallBack) {
        if (intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("kit_update_result is ");
            sb.append(intExtra);
            HMSLog.i(TAG, sb.toString());
            if (intExtra == 1) {
                HMSLog.e(TAG, "kit update success,replay request");
                replayRequest();
            } else {
                HMSLog.e(TAG, "kit update failed");
                baseCallBack.onError(buildResponseWrap(-10, buildBodyStr(intExtra)).toJson());
            }
            return true;
        }
        return false;
    }

    private void initObserver() {
        this.observer = new SystemObserver() { // from class: com.huawei.hms.adapter.BaseAdapter.1
            {
                BaseAdapter.this = this;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(BaseAdapter.this.transactionId)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onSolutionResult + id is :");
                        sb.append(str);
                        HMSLog.i(BaseAdapter.TAG, sb.toString());
                        BaseCallBack callBack = BaseAdapter.this.getCallBack();
                        if (callBack == null) {
                            HMSLog.e(BaseAdapter.TAG, "onResult baseCallBack null");
                            return true;
                        } else if (intent != null) {
                            if (BaseAdapter.this.hasExtraUpdateResult(intent, callBack) || BaseAdapter.this.hasExtraPrivacyResult(intent, callBack)) {
                                return true;
                            }
                            HMSLog.e(BaseAdapter.TAG, "onComplete for on activity result");
                            BaseAdapter.this.onCompleteResult(intent, callBack);
                            return true;
                        } else {
                            HMSLog.e(BaseAdapter.TAG, "onSolutionResult but data is null");
                            String responseHeaderForError = BaseAdapter.this.getResponseHeaderForError(-7);
                            BaseAdapter baseAdapter = BaseAdapter.this;
                            baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, BaseAdapter.this.responseHeader, 0L);
                            callBack.onError(responseHeaderForError);
                            return true;
                        }
                    }
                    return false;
                }
                HMSLog.e(BaseAdapter.TAG, "onSolutionResult but id is null");
                BaseCallBack callBack2 = BaseAdapter.this.getCallBack();
                if (callBack2 != null) {
                    callBack2.onError(BaseAdapter.this.getResponseHeaderForError(-6));
                    return true;
                }
                HMSLog.e(BaseAdapter.TAG, "onSolutionResult baseCallBack null");
                return true;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i) {
                return false;
            }
        };
    }

    public void onCompleteResult(Intent intent, BaseCallBack baseCallBack) {
        long j;
        String stringExtra = intent.getStringExtra(CommonCode.MapKey.JSON_HEADER);
        String stringExtra2 = intent.getStringExtra(CommonCode.MapKey.JSON_BODY);
        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, TrackerKey.Property.ERROR_CODE_FIREBASE);
        if (intent.hasExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
            if (infoFromJsonobject3 instanceof Long) {
                j = ((Long) infoFromJsonobject3).longValue();
                if (!(infoFromJsonobject instanceof Integer) && (infoFromJsonobject2 instanceof Integer)) {
                    int intValue = ((Integer) infoFromJsonobject).intValue();
                    getResponseHeaderForError(((Integer) infoFromJsonobject2).intValue());
                    this.responseHeader.setStatusCode(intValue);
                    biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                } else {
                    getResponseHeaderForError(-8);
                    biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                }
                baseCallBack.onComplete(stringExtra, stringExtra2, null);
            }
        }
        j = 0;
        if (!(infoFromJsonobject instanceof Integer)) {
        }
        getResponseHeaderForError(-8);
        biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
        baseCallBack.onComplete(stringExtra, stringExtra2, null);
    }

    private void replayRequest() {
        if (this.jsonHeaderReplay == null || this.baseCallBackReplay == null) {
            return;
        }
        this.responseHeader = null;
        this.responseHeader = new ResponseHeader();
        baseRequest(getJsonHeaderReplay(), getJsonObjectReplay(), getParcelableReplay(), getBaseCallBackReplay());
    }

    public void sendBroadcastAfterResolutionHms() {
        if (this.appContext == null) {
            HMSLog.e(TAG, "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent(HMS_SESSION_INVALID);
        intent.setPackage(this.appContext.getPackageName());
        this.appContext.sendBroadcast(intent);
    }

    private void setBaseCallBackReplay(BaseCallBack baseCallBack) {
        this.baseCallBackReplay = baseCallBack;
    }

    private void setJsonHeaderReplay(String str) {
        this.jsonHeaderReplay = str;
    }

    private void setJsonObjectReplay(String str) {
        this.jsonObjectReplay = str;
    }

    private void setParcelableReplay(Parcelable parcelable) {
        this.parcelableReplay = parcelable;
    }

    private void setReplayData(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        setJsonHeaderReplay(str);
        setJsonObjectReplay(str2);
        setParcelableReplay(parcelable);
        setBaseCallBackReplay(baseCallBack);
    }

    private void setResponseHeader(int i) {
        this.responseHeader.setTransactionId(this.requestHeader.getTransactionId());
        this.responseHeader.setAppID(this.requestHeader.getAppID());
        this.responseHeader.setApiName(this.requestHeader.getApiName());
        this.responseHeader.setSrvName(this.requestHeader.getSrvName());
        this.responseHeader.setPkgName(this.requestHeader.getPkgName());
        this.responseHeader.setStatusCode(1);
        this.responseHeader.setErrorCode(i);
        this.responseHeader.setErrorReason("Core error");
    }

    public void startResolution(Activity activity, Parcelable parcelable) {
        HMSLog.i(TAG, "startResolution");
        RequestHeader requestHeader = this.requestHeader;
        if (requestHeader != null) {
            biReportRequestEntrySolution(this.appContext, requestHeader);
        }
        if (this.observer == null) {
            initObserver();
        }
        SystemManager.getSystemNotifier().registerObserver(this.observer);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra("transaction_id", this.transactionId);
        activity.startActivity(intentStartBridgeActivity);
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        setReplayData(str, str2, parcelable, baseCallBack);
        if (this.api == null) {
            HMSLog.e(TAG, "client is null");
            baseCallBack.onError(getResponseHeaderForError(-2));
            return;
        }
        this.callback = baseCallBack;
        JsonUtil.jsonToEntity(str, this.requestHeader);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.requestHeader.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.e(TAG, "get uri null");
            baseCallBack.onError(getResponseHeaderForError(-5));
            return;
        }
        String transactionId = this.requestHeader.getTransactionId();
        this.transactionId = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.e(TAG, "get transactionId null");
            baseCallBack.onError(getResponseHeaderForError(-6));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("in baseRequest + uri is :");
        sb.append(apiName);
        sb.append(", transactionId is : ");
        sb.append(this.transactionId);
        HMSLog.i(TAG, sb.toString());
        biReportRequestEntryIpc(this.appContext, this.requestHeader);
        baseRequest(this.api.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.api = new WeakReference<>(apiClient);
        this.activityWeakReference = new WeakReference<>(activity);
        this.appContext = activity.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append("In constructor, activityWeakReference is ");
        sb.append(this.activityWeakReference);
        sb.append(", activity is ");
        sb.append(this.activityWeakReference.get());
        HMSLog.i(TAG, sb.toString());
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> baseRequest(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new MPendingResultImpl(apiClient, str, coreBaseRequest);
    }
}
