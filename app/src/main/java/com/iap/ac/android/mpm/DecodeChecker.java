package com.iap.ac.android.mpm;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.ACConstants;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.base.model.route.ACDecodeConfig;
import com.iap.ac.android.mpm.base.model.route.RouterType;
import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import com.iap.ac.android.mpm.biz.gof.GofCollectionCodeBiz;
import com.iap.ac.android.mpm.biz.gof.GofOrderCodeBiz;
import com.iap.ac.android.mpm.biz.gol.GolOrderCodeBiz;

/* loaded from: classes3.dex */
public class DecodeChecker {
    public static void decode(final Context context, final DecodeParameter decodeParameter, final IDecodeCallback iDecodeCallback) {
        final DecodeParamsCheckResult checkDecodeParams = checkDecodeParams(context, decodeParameter, iDecodeCallback);
        if (!"SUCCESS".equals(checkDecodeParams.result.resultCode)) {
            ACLog.w(Constants.TAG, checkDecodeParams.errMsg);
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_DECODE_PARAMS_ERROR, checkDecodeParams.errMsg);
            BaseBizProcessor.sendResult(checkDecodeParams.result, iDecodeCallback);
            return;
        }
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.mpm.DecodeChecker.1
            @Override // java.lang.Runnable
            public final void run() {
                DecodeChecker.bizRoute(context, decodeParameter, checkDecodeParams.validCodeValue, checkDecodeParams.acDecodeConfig, iDecodeCallback);
            }
        });
    }

    private static DecodeParamsCheckResult checkDecodeParams(Context context, DecodeParameter decodeParameter, IDecodeCallback iDecodeCallback) {
        if (context == null) {
            return buildErrorResult("PARAM_ILLEGAL", "Oops! System busy. Try again later!", "DecodeChecker context is null");
        }
        if (decodeParameter == null) {
            return buildErrorResult("PARAM_ILLEGAL", "Oops! System busy. Try again later!", "DecodeChecker parameter is null");
        }
        if (iDecodeCallback == null) {
            return buildErrorResult("PARAM_ILLEGAL", "Oops! System busy. Try again later!", "DecodeChecker decodeCallback is null");
        }
        String str = decodeParameter.codeValue;
        if (TextUtils.isEmpty(str)) {
            return buildErrorResult("PARAM_ILLEGAL", "Oops! System busy. Try again later!", "DecodeChecker code value is empty");
        }
        try {
            ACDecodeConfig aCDecodeConfig = (ACDecodeConfig) JsonUtils.fromJson(decodeParameter.acDecodeConfigFromServer, ACDecodeConfig.class);
            if (haveToUpgrade(aCDecodeConfig)) {
                return buildErrorResult(ResultCode.SDK_NOT_SUPPORT, ResultCode.SDK_NOT_SUPPORT_MESSAGE, "DecodeChecker sdk have to upgrade = true");
            }
            DecodeParamsCheckResult decodeParamsCheckResult = new DecodeParamsCheckResult();
            decodeParamsCheckResult.validCodeValue = str;
            decodeParamsCheckResult.acDecodeConfig = aCDecodeConfig;
            Result result = new Result();
            result.resultCode = "SUCCESS";
            decodeParamsCheckResult.result = result;
            return decodeParamsCheckResult;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("DecodeChecker decode error fromJson:");
            sb.append(e);
            return buildErrorResult(ResultCode.UNKNOWN_EXCEPTION, "Oops! System busy. Try again later!", sb.toString());
        }
    }

    private static DecodeParamsCheckResult buildErrorResult(String str, String str2, String str3) {
        DecodeParamsCheckResult decodeParamsCheckResult = new DecodeParamsCheckResult();
        Result result = new Result();
        result.resultCode = str;
        result.resultMessage = str2;
        decodeParamsCheckResult.result = result;
        decodeParamsCheckResult.errMsg = str3;
        return decodeParamsCheckResult;
    }

    public static void bizRoute(Context context, DecodeParameter decodeParameter, String str, ACDecodeConfig aCDecodeConfig, IDecodeCallback iDecodeCallback) {
        ACManager.getInstance().fetchConfigAsync(null);
        StringBuilder sb = new StringBuilder();
        sb.append("acDecodeConfig.userAgent :");
        sb.append(aCDecodeConfig != null ? aCDecodeConfig.toString() : null);
        ACLog.i(Constants.TAG, sb.toString());
        String str2 = decodeParameter.scene;
        if (ACConstants.Scene.SOURCE_FROM_OTHER_APP.equalsIgnoreCase(str2)) {
            new GolOrderCodeBiz(context, str, false, decodeParameter, aCDecodeConfig, iDecodeCallback).onProcessBegin();
        } else if (aCDecodeConfig == null || RouterType.AC_CODE.equalsIgnoreCase(aCDecodeConfig.routerType)) {
            new GofOrderCodeBiz(context, str, false, aCDecodeConfig, str2, iDecodeCallback).onProcessBegin();
        } else if (RouterType.AC_URL.equalsIgnoreCase(aCDecodeConfig.routerType)) {
            new GofCollectionCodeBiz(context, !TextUtils.isEmpty(aCDecodeConfig.redirectUrl) ? aCDecodeConfig.redirectUrl : str, str2, aCDecodeConfig, iDecodeCallback).onProcessBegin();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DecodeChecker PARAM_ILLEGAL ");
            sb2.append(aCDecodeConfig);
            ACLog.w(Constants.TAG, sb2.toString());
            Result result = new Result();
            result.resultCode = "PARAM_ILLEGAL";
            result.resultMessage = "Oops! System busy. Try again later!";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("PARAM_ILLEGAL ");
            sb3.append(aCDecodeConfig);
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_DECODE_PARAMS_ERROR, sb3.toString());
            BaseBizProcessor.sendResult(result, iDecodeCallback);
        }
    }

    private static boolean haveToUpgrade(ACDecodeConfig aCDecodeConfig) {
        if (aCDecodeConfig != null && !TextUtils.isEmpty(aCDecodeConfig.minAndroidAcSdkVersion)) {
            try {
                String[] split = "2.37.0".split("\\.");
                String[] split2 = aCDecodeConfig.minAndroidAcSdkVersion.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i = 0;
                for (int i2 = 0; i2 < min; i2++) {
                    i = split[i2].length() - split2[i2].length();
                    if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                        break;
                    }
                }
                if (i == 0) {
                    i = split.length - split2.length;
                }
                return i < 0;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("isBelowMinSDKVersion error:");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
            }
        }
        return false;
    }
}
