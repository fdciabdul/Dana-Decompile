package com.iap.ac.android.mpm.interceptor.event;

import android.net.Uri;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.biz.common.model.remoteconfig.mpm.HookUrlConfig;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.constant.ContainerEventAction;
import com.iap.ac.android.common.container.event.ContainerEvent;
import com.iap.ac.android.common.container.event.ContainerEventFilter;
import com.iap.ac.android.common.container.plugin.BaseContainerPlugin;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.mpm.base.model.interceptor.HookUrlMappingParams;
import com.iap.ac.android.mpm.biz.BizProcessResumeParams;
import com.iap.ac.android.mpm.biz.BizProcessorManager;
import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import com.iap.ac.android.mpm.biz.base.EntranceType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;
import com.iap.ac.android.mpm.node.hook.CommonHookNodeRequest;
import com.iap.ac.android.mpm.node.oauth.PrepareAuthNodeRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class PageEventPlugin extends BaseContainerPlugin {
    private static final String AUTH_URL = "AUTH_URL";
    private static final String CONTAIN = "CONTAIN";
    private static final String DECODE_URL = "DECODE_URL";
    private static final String REGEX = "REGEX";
    private static final String TAG = "PageEventPlugin";
    private ContainerEvent event;

    @Override // com.iap.ac.android.common.container.plugin.BaseContainerPlugin, com.iap.ac.android.common.container.plugin.IContainerPlugin
    public boolean interceptorEvent(ContainerEvent containerEvent) {
        if (ContainerEventAction.ACTION_WEB_PAGE_SHOULD_OVERRIDE_URL.equals(containerEvent.action)) {
            if (!shouldIntercept(containerEvent)) {
                ACLog.d(TAG, "PageEventPlugin, flag of bizScenario not match, should not intercept");
                return false;
            }
            this.event = containerEvent;
            try {
                return handleUrl((String) containerEvent.params.get("url"));
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("interceptorEvent error:");
                sb.append(th);
                ACLog.e(TAG, sb.toString());
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_INTERCEPTOR_URL_ERROR, Utils.e(th));
            }
        }
        return false;
    }

    @Override // com.iap.ac.android.common.container.plugin.BaseContainerPlugin, com.iap.ac.android.common.container.plugin.IContainerPlugin
    public ContainerEventFilter onPrepare(ContainerEventFilter containerEventFilter) {
        containerEventFilter.addAction(ContainerEventAction.ACTION_WEB_PAGE_SHOULD_OVERRIDE_URL);
        return containerEventFilter;
    }

    protected boolean shouldIntercept(ContainerEvent containerEvent) {
        try {
            return Constants.H5Param.PARAM_SDK_FLAG.equals(containerEvent.containerPresenter.getActivity().getIntent().getStringExtra("bizScenario"));
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean handleUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<HookUrlConfig> hookUrlConfig = ACManager.getInstance().getHookUrlConfig();
        StringBuilder sb = new StringBuilder();
        sb.append("handleUrl url:");
        sb.append(str);
        ACLog.d(TAG, sb.toString());
        if (hookUrlConfig != null && !hookUrlConfig.isEmpty()) {
            for (HookUrlConfig hookUrlConfig2 : hookUrlConfig) {
                Pattern compile = Pattern.compile(hookUrlConfig2.matchRule);
                Matcher matcher = compile != null ? compile.matcher(str) : null;
                ACLog.d(TAG, String.format("handleUrl config.matchType = %s, config.matchRule = %s", hookUrlConfig2.matchType, hookUrlConfig2.matchRule));
                if ((CONTAIN.equals(hookUrlConfig2.matchType) && str.contains(hookUrlConfig2.matchRule)) || (REGEX.equals(hookUrlConfig2.matchType) && matcher != null && matcher.matches())) {
                    ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_INTERCEPTOR_URL).addParams("url", str).event();
                    try {
                        String stringExtra = this.event.containerPresenter.getActivity().getIntent().getStringExtra(Constants.H5Param.PARAM_BIZ_KEY);
                        final BaseBizProcessor processor = BizProcessorManager.getProcessor(stringExtra);
                        if (processor == null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(stringExtra);
                            sb2.append("  biz processor is not exist");
                            String obj = sb2.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(stringExtra);
                            sb3.append(obj);
                            ACLog.e(TAG, sb3.toString());
                            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_BIZ_NOT_FOUND_ERROR, obj);
                            return false;
                        }
                        try {
                            HookUrlMappingParams hookUrlMappingParams = (HookUrlMappingParams) JsonUtils.fromJson(hookUrlConfig2.mappingParams, HookUrlMappingParams.class);
                            if (AUTH_URL.equals(hookUrlConfig2.hookType)) {
                                IContainerPresenter iContainerPresenter = this.event.containerPresenter;
                                if (iContainerPresenter != null) {
                                    iContainerPresenter.loadUrl(InnerConstants.LOADING_URL);
                                }
                                final PrepareAuthNodeRequest prepareAuthNodeRequest = new PrepareAuthNodeRequest(str);
                                final BizProcessResumeParams bizProcessResumeParams = new BizProcessResumeParams(EntranceType.PageEventPlugin, iContainerPresenter);
                                IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.mpm.interceptor.event.PageEventPlugin.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        processor.onProcessResume(prepareAuthNodeRequest, bizProcessResumeParams);
                                    }
                                });
                                return true;
                            } else if (DECODE_URL.equals(hookUrlConfig2.hookType)) {
                                Uri parse = Uri.parse(str);
                                String queryParameter = parse.getQueryParameter(hookUrlMappingParams.codeParamKey);
                                if (!TextUtils.isEmpty(hookUrlMappingParams.loadingUrl)) {
                                    String queryParameter2 = parse.getQueryParameter(hookUrlMappingParams.loadingUrl);
                                    if (str.startsWith(InnerConstants.PREFIX_INTERCEPT_AND_GET_CODE_URL) && !TextUtils.isEmpty(queryParameter2)) {
                                        this.event.containerPresenter.loadUrl(queryParameter2);
                                    }
                                }
                                if (!TextUtils.isEmpty(queryParameter)) {
                                    final DecodeOrderNodeRequest decodeOrderNodeRequest = new DecodeOrderNodeRequest(queryParameter, false);
                                    final BizProcessResumeParams bizProcessResumeParams2 = new BizProcessResumeParams(EntranceType.PageEventPlugin, this.event.containerPresenter);
                                    IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.mpm.interceptor.event.PageEventPlugin.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            processor.onProcessResume(decodeOrderNodeRequest, bizProcessResumeParams2);
                                        }
                                    });
                                    return true;
                                }
                            } else {
                                final CommonHookNodeRequest commonHookNodeRequest = new CommonHookNodeRequest(str);
                                final BizProcessResumeParams bizProcessResumeParams3 = new BizProcessResumeParams(EntranceType.PageEventPlugin, this.event.containerPresenter);
                                IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.mpm.interceptor.event.PageEventPlugin.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        processor.onProcessResume(commonHookNodeRequest, bizProcessResumeParams3);
                                    }
                                });
                                return true;
                            }
                        } catch (Exception e) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("handleUrl error:");
                            sb4.append(e);
                            ACLog.e(TAG, sb4.toString());
                            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_INTERCEPTOR_URL_ERROR, Utils.e(e));
                        }
                    } catch (Throwable th) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("get biz key error :");
                        sb5.append(th);
                        String obj2 = sb5.toString();
                        ACLog.e(TAG, obj2);
                        ACLogEvent.exceptionLog(obj2);
                    }
                }
            }
        }
        return false;
    }
}
