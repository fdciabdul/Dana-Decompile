package com.alibaba.griver.core.rpc;

import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.rpc.BaseGriverNetwork;
import com.alibaba.griver.base.common.rpc.BaseGriverRpcResult;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.core.common.monitor.UrlContentDecoderMonitorHelper;
import com.alibaba.griver.core.model.aboutinfo.GetAboutInfoRequest;
import com.alibaba.griver.core.model.aboutinfo.GetAboutInfoResult;
import com.alibaba.griver.core.model.applist.AppInfosResult;
import com.alibaba.griver.core.model.applist.FetchAppListResult;
import com.alibaba.griver.core.model.applist.FetchAppsByIdsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsByKeyWordsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsResult;
import com.alibaba.griver.core.model.codec.UrlCodecRequest;
import com.alibaba.griver.core.model.codec.UrlCodecResult;
import com.alibaba.griver.core.model.codec.cancodec.UrlCanCodecRequest;
import com.alibaba.griver.core.model.codec.cancodec.UrlCanCodecResult;
import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.acs.plugin.utils.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public class MiniProgramProcessor extends BaseGriverNetwork<MiniProgramFacade> {
    @Override // com.alibaba.griver.base.common.rpc.BaseGriverNetwork
    public Class<MiniProgramFacade> getFacadeClass() {
        return MiniProgramFacade.class;
    }

    public void fetchApps(final FetchAppsRequest fetchAppsRequest, final OnRpcResultListener onRpcResultListener) {
        if (fetchAppsRequest == null) {
            if (onRpcResultListener != null) {
                onRpcResultListener.onResultFailed(0, "request is null");
                return;
            }
            return;
        }
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.append("operationType", GriverRpcContants.FETCH_APP_LIST);
        GriverMonitor.event(GriverMonitorConstants.EVENT_RPC_START, "GriverAppContainer", builder.build());
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.core.rpc.MiniProgramProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FetchAppsResult fetchAppList = ((MiniProgramFacade) MiniProgramProcessor.this.getFacade()).fetchAppList(fetchAppsRequest);
                    if (onRpcResultListener != null) {
                        if (fetchAppList != null && fetchAppList.success) {
                            onRpcResultListener.onResultSuccess(fetchAppList);
                            return;
                        }
                        try {
                            onRpcResultListener.onResultFailed(Integer.parseInt(fetchAppList.errorCode), fetchAppList.errorMessage);
                        } catch (NumberFormatException e) {
                            GriverLogger.e("MiniProgramProcessor", "fetchAppInfoListByIds NumberFormatException");
                            onRpcResultListener.onResultFailed(2, e.getMessage());
                        }
                    }
                } catch (RpcException e2) {
                    GriverLogger.e("MiniProgramProcessor", "rpc exception == ", e2);
                    OnRpcResultListener onRpcResultListener2 = onRpcResultListener;
                    if (onRpcResultListener2 != null) {
                        onRpcResultListener2.onResultFailed(10104, e2.getMessage());
                    }
                    MonitorMap.Builder builder2 = new MonitorMap.Builder();
                    builder2.append("operationType", GriverRpcContants.FETCH_APP_LIST).exception(e2).code(String.valueOf(e2.getCode())).message(GriverMonitorConstants.MESSAGE_FETCH_APPS_ERROR);
                    GriverMonitor.error(GriverMonitorConstants.ERROR_RPC_EXCEPTION, "GriverAppContainer", builder2.build());
                } catch (Throwable th) {
                    GriverLogger.e("MiniProgramProcessor", "rpc exception == ", th);
                    OnRpcResultListener onRpcResultListener3 = onRpcResultListener;
                    if (onRpcResultListener3 != null) {
                        onRpcResultListener3.onResultFailed(3, th.getMessage());
                    }
                }
            }
        });
    }

    public void fetchAppInfosByIds(List<String> list, String str, final OnRpcResultListener<AppInfosResult> onRpcResultListener) {
        a(list, str, new OnRpcResultListener<FetchAppListResult>() { // from class: com.alibaba.griver.core.rpc.MiniProgramProcessor.2
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultSuccess(FetchAppListResult fetchAppListResult) {
                OnRpcResultListener onRpcResultListener2 = onRpcResultListener;
                if (onRpcResultListener2 != null) {
                    onRpcResultListener2.onResultSuccess(AppInfosResult.convertAppInfos(fetchAppListResult));
                }
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultFailed(int i, String str2) {
                OnRpcResultListener onRpcResultListener2 = onRpcResultListener;
                if (onRpcResultListener2 != null) {
                    onRpcResultListener2.onResultFailed(i, str2);
                }
            }
        });
    }

    private void a(final List<String> list, final String str, final OnRpcResultListener<FetchAppListResult> onRpcResultListener) {
        if (list != null && list.size() != 0) {
            GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.core.rpc.MiniProgramProcessor.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GriverLogger.e("MiniProgramProcessor", "fetchAppInfoListByIds has been invoking first time ");
                        HashSet hashSet = new HashSet();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            hashSet.add(String.valueOf(it.next()));
                        }
                        FetchAppsByIdsRequest fetchAppsByIdsRequest = new FetchAppsByIdsRequest(Arrays.asList(hashSet.toArray(new String[0])));
                        fetchAppsByIdsRequest.setCategory(str);
                        FetchAppListResult fetchAppInfoListByIds = ((MiniProgramFacade) MiniProgramProcessor.this.getFacade()).fetchAppInfoListByIds(fetchAppsByIdsRequest);
                        MiniProgramProcessor.this.a(fetchAppInfoListByIds, fetchAppInfoListByIds.getExceedAppIdList(), 1, str);
                        if (!fetchAppInfoListByIds.success) {
                            onRpcResultListener.onResultFailed(10000, fetchAppInfoListByIds.errorMessage);
                            return;
                        }
                        fetchAppInfoListByIds.setTotalCount(fetchAppInfoListByIds.getAppInfoList().size());
                        fetchAppInfoListByIds.setDeployAppInfoList(fetchAppInfoListByIds.getAppInfoList());
                        fetchAppInfoListByIds.setExceedAppIdList(new ArrayList());
                        StringBuilder sb = new StringBuilder();
                        sb.append("repeatGetAppInfoByids result = ");
                        sb.append(JSON.toJSONString(fetchAppInfoListByIds));
                        GriverLogger.e("MiniProgramProcessor", sb.toString());
                        if (onRpcResultListener != null) {
                            if (fetchAppInfoListByIds != null && fetchAppInfoListByIds.success) {
                                onRpcResultListener.onResultSuccess((BaseGriverRpcResult) JSON.parseObject(JSON.toJSONString(fetchAppInfoListByIds, SerializerFeature.DisableCircularReferenceDetect), FetchAppListResult.class));
                                return;
                            }
                            try {
                                onRpcResultListener.onResultFailed(Integer.parseInt(fetchAppInfoListByIds.errorCode), fetchAppInfoListByIds.errorMessage);
                            } catch (NumberFormatException e) {
                                GriverLogger.e("MiniProgramProcessor", "fetchAppInfoListByIds NumberFormatException");
                                onRpcResultListener.onResultFailed(2, e.getMessage());
                            }
                        }
                    } catch (RpcException e2) {
                        GriverLogger.e("MiniProgramProcessor", "rpc exception == ", e2);
                        OnRpcResultListener onRpcResultListener2 = onRpcResultListener;
                        if (onRpcResultListener2 != null) {
                            onRpcResultListener2.onResultFailed(10104, e2.getMessage());
                        }
                        MonitorMap.Builder builder = new MonitorMap.Builder();
                        builder.append("operationType", "alipay.intl.gmp.rpc.app.info.list.query fetchAppInfoListByIds").exception(e2).code(String.valueOf(e2.getCode())).message(GriverMonitorConstants.MESSAGE_FETCH_APPS_ERROR);
                        GriverMonitor.error(GriverMonitorConstants.ERROR_FETCH_APP_INFOS, "GriverAppContainer", builder.build());
                    } catch (Throwable th) {
                        GriverLogger.e("MiniProgramProcessor", "rpc exception == ", th);
                        OnRpcResultListener onRpcResultListener3 = onRpcResultListener;
                        if (onRpcResultListener3 != null) {
                            onRpcResultListener3.onResultFailed(3, th.getMessage());
                        }
                    }
                }
            });
        } else if (onRpcResultListener != null) {
            onRpcResultListener.onResultFailed(2, "Invalid parameters");
        }
    }

    public void requestAppInfosByIds(List<String> list, String str, final OnRpcResultListener<FetchAppListResult> onRpcResultListener) {
        a(list, str, new OnRpcResultListener<FetchAppListResult>() { // from class: com.alibaba.griver.core.rpc.MiniProgramProcessor.4
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultSuccess(FetchAppListResult fetchAppListResult) {
                if (onRpcResultListener != null) {
                    if (fetchAppListResult != null && fetchAppListResult.success) {
                        onRpcResultListener.onResultSuccess(fetchAppListResult);
                    } else {
                        onRpcResultListener.onResultFailed(fetchAppListResult.hashCode(), fetchAppListResult.errorMessage);
                    }
                }
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultFailed(int i, String str2) {
                onRpcResultListener.onResultFailed(i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FetchAppListResult fetchAppListResult, List<String> list, int i, String str) {
        if (list == null || list.size() == 0 || fetchAppListResult == null) {
            if (fetchAppListResult != null) {
                fetchAppListResult.setExceedAppIdList(new ArrayList());
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("fetchAppInfoListByIds has been invoking ");
        sb.append(i);
        sb.append(" times");
        GriverLogger.d("MiniProgramProcessor", sb.toString());
        try {
            FetchAppsByIdsRequest fetchAppsByIdsRequest = new FetchAppsByIdsRequest(list);
            fetchAppsByIdsRequest.setCategory(str);
            FetchAppListResult fetchAppInfoListByIds = getFacade().fetchAppInfoListByIds(fetchAppsByIdsRequest);
            fetchAppListResult.getAppInfoList().addAll(fetchAppInfoListByIds.getAppInfoList());
            if (fetchAppInfoListByIds.getExceedAppIdList() == null) {
                return;
            }
            if (fetchAppInfoListByIds.getExceedAppIdList().size() >= list.size()) {
                GriverLogger.e("MiniProgramProcessor", "fetchAppInfoListByIds server_unknown_error");
                fetchAppListResult.success = false;
                fetchAppListResult.errorCode = "3";
                fetchAppListResult.errorMessage = ErrorCode.ERROR_UNKNOWN_ERROR_MESSAGE;
                return;
            }
            a(fetchAppListResult, fetchAppInfoListByIds.getExceedAppIdList(), i + 1, str);
        } catch (RpcException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchAppInfoListByIds rpc exception for ");
            sb2.append(i);
            sb2.append(" time , exception == ");
            GriverLogger.e("MiniProgramProcessor", sb2.toString(), e);
            MonitorMap.Builder builder = new MonitorMap.Builder();
            MonitorMap.Builder append = builder.append("operationType", "alipay.intl.gmp.rpc.app.info.list.query repeatGetAppInfoByIds");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i);
            append.append("requestCount", sb3.toString()).exception(e).code(String.valueOf(e.getCode())).message(GriverMonitorConstants.MESSAGE_FETCH_APPS_ERROR);
            GriverMonitor.error(GriverMonitorConstants.ERROR_FETCH_APP_INFOS, "GriverAppContainer", builder.build());
            fetchAppListResult.success = false;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(e.getCode());
            fetchAppListResult.errorCode = sb4.toString();
            fetchAppListResult.errorMessage = e.getMessage();
        } catch (Throwable th) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fetchAppInfoListByIds rpc exception for ");
            sb5.append(i);
            sb5.append(" time , exception == ");
            GriverLogger.e("MiniProgramProcessor", sb5.toString(), th);
        }
    }

    public void fetchAppInfoListByKeyword(final FetchAppsByKeyWordsRequest fetchAppsByKeyWordsRequest, final OnRpcResultListener<FetchAppListResult> onRpcResultListener) {
        if (fetchAppsByKeyWordsRequest == null) {
            if (onRpcResultListener != null) {
                onRpcResultListener.onResultFailed(2, "Invalid parameters");
            }
        } else if (fetchAppsByKeyWordsRequest.getKeyword() == null || fetchAppsByKeyWordsRequest.getKeyword().trim().length() == 0) {
            if (onRpcResultListener != null) {
                onRpcResultListener.onResultFailed(2, "parameter keyword can not be null or empty");
            }
        } else {
            MonitorMap.Builder builder = new MonitorMap.Builder();
            builder.append("operationType", GriverRpcContants.SEARCH_APP_LIST_BY_KEYWORD);
            GriverMonitor.event(GriverMonitorConstants.EVENT_RPC_START, "GriverAppContainer", builder.build());
            GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.core.rpc.MiniProgramProcessor.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FetchAppListResult fetchAppInfoListByKeyword = ((MiniProgramFacade) MiniProgramProcessor.this.getFacade()).fetchAppInfoListByKeyword(fetchAppsByKeyWordsRequest);
                        fetchAppInfoListByKeyword.setDeployAppInfoList(fetchAppInfoListByKeyword.getAppInfoList());
                        OnRpcResultListener onRpcResultListener2 = onRpcResultListener;
                        if (onRpcResultListener2 != null) {
                            if (fetchAppInfoListByKeyword != null) {
                                if (fetchAppInfoListByKeyword.success) {
                                    onRpcResultListener.onResultSuccess((BaseGriverRpcResult) JSON.parseObject(JSON.toJSONString(fetchAppInfoListByKeyword, SerializerFeature.DisableCircularReferenceDetect), FetchAppListResult.class));
                                    return;
                                } else {
                                    onRpcResultListener.onResultFailed(2, JSON.toJSONString(fetchAppInfoListByKeyword));
                                    return;
                                }
                            }
                            onRpcResultListener2.onResultFailed(3, "result is null");
                        }
                    } catch (RpcException e) {
                        GriverLogger.e("MiniProgramProcessor", "rpc exception == ", e);
                        OnRpcResultListener onRpcResultListener3 = onRpcResultListener;
                        if (onRpcResultListener3 != null) {
                            onRpcResultListener3.onResultFailed(e.getCode(), e.getMessage());
                        }
                        MonitorMap.Builder builder2 = new MonitorMap.Builder();
                        builder2.append("operationType", GriverRpcContants.SEARCH_APP_LIST_BY_KEYWORD).exception(e).code(String.valueOf(e.getCode())).message(GriverMonitorConstants.MESSAGE_FETCH_APPS_ERROR);
                        GriverMonitor.error(GriverMonitorConstants.ERROR_RPC_EXCEPTION, "GriverAppContainer", builder2.build());
                    } catch (Throwable th) {
                        GriverLogger.e("MiniProgramProcessor", "rpc exception == ", th);
                        OnRpcResultListener onRpcResultListener4 = onRpcResultListener;
                        if (onRpcResultListener4 != null) {
                            onRpcResultListener4.onResultFailed(3, th.getMessage());
                        }
                    }
                }
            });
        }
    }

    public void getAboutInfo(final GetAboutInfoRequest getAboutInfoRequest, final OnRpcResultListener onRpcResultListener) {
        if (getAboutInfoRequest == null) {
            if (onRpcResultListener != null) {
                onRpcResultListener.onResultFailed(0, "request is null");
                return;
            }
            return;
        }
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.append("operationType", GriverRpcContants.GET_ABOUT_INFO).appId(getAboutInfoRequest.getAppId()).version(getAboutInfoRequest.getVersion()).needAsynAppType(true);
        GriverMonitor.event(GriverMonitorConstants.EVENT_RPC_START, "GriverAppContainer", builder.build());
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.core.rpc.MiniProgramProcessor.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GetAboutInfoResult aboutInfo = ((MiniProgramFacade) MiniProgramProcessor.this.getFacade()).getAboutInfo(getAboutInfoRequest);
                    OnRpcResultListener onRpcResultListener2 = onRpcResultListener;
                    if (onRpcResultListener2 != null) {
                        onRpcResultListener2.onResultSuccess(aboutInfo);
                    }
                } catch (RpcException e) {
                    GriverLogger.e("MiniProgramProcessor", "rpc exception == ", e);
                    OnRpcResultListener onRpcResultListener3 = onRpcResultListener;
                    if (onRpcResultListener3 != null) {
                        onRpcResultListener3.onResultFailed(e.getCode(), e.getMessage());
                    }
                    MonitorMap.Builder builder2 = new MonitorMap.Builder();
                    builder2.append("operationType", GriverRpcContants.GET_ABOUT_INFO).appId(getAboutInfoRequest.getAppId()).version(getAboutInfoRequest.getVersion()).needAsynAppType(true).code(String.valueOf(e.getCode())).message(e.getMessage()).exception(e);
                    GriverMonitor.error(GriverMonitorConstants.ERROR_RPC_EXCEPTION, "GriverAppContainer", builder2.build());
                } catch (Throwable th) {
                    GriverLogger.e("MiniProgramProcessor", "rpc exception == ", th);
                    OnRpcResultListener onRpcResultListener4 = onRpcResultListener;
                    if (onRpcResultListener4 != null) {
                        onRpcResultListener4.onResultFailed(3, th.getMessage());
                    }
                }
            }
        });
    }

    public void getUrlCodec(final UrlCodecRequest urlCodecRequest, final OnRpcResultListener onRpcResultListener) {
        if (urlCodecRequest == null) {
            if (onRpcResultListener != null) {
                onRpcResultListener.onResultFailed(0, "request is null");
                return;
            }
            return;
        }
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.append("operationType", GriverRpcContants.APP_CODEC_ROUTE).url(urlCodecRequest.getCode());
        GriverMonitor.event(GriverMonitorConstants.EVENT_RPC_START, "GriverAppContainer", builder.build());
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.core.rpc.MiniProgramProcessor.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UrlCodecResult urlCodec = ((MiniProgramFacade) MiniProgramProcessor.this.getFacade()).getUrlCodec(urlCodecRequest);
                    OnRpcResultListener onRpcResultListener2 = onRpcResultListener;
                    if (onRpcResultListener2 != null) {
                        onRpcResultListener2.onResultSuccess(urlCodec);
                    }
                } catch (RpcException e) {
                    GriverLogger.e("MiniProgramProcessor", "rpc exception == ", e);
                    OnRpcResultListener onRpcResultListener3 = onRpcResultListener;
                    if (onRpcResultListener3 != null) {
                        onRpcResultListener3.onResultFailed(e.getCode(), e.getMessage());
                    }
                } catch (Throwable th) {
                    OnRpcResultListener onRpcResultListener4 = onRpcResultListener;
                    if (onRpcResultListener4 != null) {
                        onRpcResultListener4.onResultFailed(3, th.getMessage());
                    }
                }
            }
        });
    }

    public FutureTask<Boolean> getUrlCanDecode(UrlCanCodecRequest urlCanCodecRequest) {
        if (urlCanCodecRequest == null) {
            return null;
        }
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.append("operationType", GriverRpcContants.APP_CAN_DECODE_ROUTE).url(urlCanCodecRequest.getCode());
        GriverMonitor.event(GriverMonitorConstants.EVENT_RPC_START, "GriverAppContainer", builder.build());
        FutureTask<Boolean> futureTask = new FutureTask<>(new GetUrlCanDecodeRpcCallable(urlCanCodecRequest));
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(futureTask);
        return futureTask;
    }

    /* loaded from: classes6.dex */
    class GetUrlCanDecodeRpcCallable implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final UrlCanCodecRequest f6461a;

        private GetUrlCanDecodeRpcCallable(UrlCanCodecRequest urlCanCodecRequest) {
            this.f6461a = urlCanCodecRequest;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            boolean z = false;
            try {
                UrlCanCodecResult urlCanCodec = ((MiniProgramFacade) MiniProgramProcessor.this.getFacade()).getUrlCanCodec(this.f6461a);
                if (urlCanCodec != null && urlCanCodec.success && urlCanCodec.isCanDecode()) {
                    z = true;
                }
                if (urlCanCodec == null || !urlCanCodec.success) {
                    UrlContentDecoderMonitorHelper.monitor(UrlContentDecoderMonitorHelper.Scene.CanDecodeURL, UrlContentDecoderMonitorHelper.ErrorType.ServerError, urlCanCodec == null ? "" : urlCanCodec.errorMessage);
                }
            } catch (Throwable th) {
                GriverLogger.e("MiniProgramProcessor", "rpc exception == ", th);
                UrlContentDecoderMonitorHelper.monitor(UrlContentDecoderMonitorHelper.Scene.CanDecodeURL, UrlContentDecoderMonitorHelper.ErrorType.NetworkError, th.getMessage());
            }
            return Boolean.valueOf(z);
        }
    }
}
