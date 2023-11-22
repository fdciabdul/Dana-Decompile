package com.iap.ac.android.biz.b;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.ac.pa.foundation.PSAadpterAC;
import com.iap.ac.android.acs.operation.biz.region.RegionManager;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginManager;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4getPaymentCode;
import com.iap.ac.android.acs.translation.TranslateManager;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.callback.InquireQuoteCallback;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.model.InitErrorCode;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.gol.SignContractRequest;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.CPMConfig;
import com.iap.ac.android.biz.common.risk.RiskControlManager;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.biz.core.ACCoreManager;
import com.iap.ac.android.biz.internal.IIAPConnect;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.cpm.online.manager.OnlinePaymentCodeManager;
import com.iap.ac.android.gol.SignContractManager;
import com.iap.ac.android.mpm.DecodeChecker;
import com.iap.ac.android.mpm.DecodeParameter;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class c implements IIAPConnect {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7540a = false;

    /* loaded from: classes3.dex */
    public class a implements InitCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InitCallback f7541a;

        public a(InitCallback initCallback) {
            this.f7541a = initCallback;
        }

        @Override // com.iap.ac.android.biz.common.callback.InitCallback
        public void onFailure(InitErrorCode initErrorCode, String str) {
            this.f7541a.onFailure(initErrorCode, str);
        }

        @Override // com.iap.ac.android.biz.common.callback.InitCallback
        public void onSuccess() {
            c.this.f7540a = true;
            this.f7541a.onSuccess();
        }
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void clear() {
        ACManager.getInstance().clear();
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_AC_CORE_MANAGER)) {
            ACCoreManager.getInstance().clear();
        }
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_PA_CORE_MANAGER)) {
            PSAadpterAC.getInstance().logout();
        }
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_MANAGER)) {
            RegionManager.getInstance().logout();
        }
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void decode(Context context, String str, String str2, IDecodeCallback iDecodeCallback) {
        synchronized (this) {
            if (Utils.checkClassExist(Constants.PACKAGE_NAME_DECODE_CHECKER)) {
                DecodeParameter decodeParameter = new DecodeParameter();
                decodeParameter.codeValue = str;
                decodeParameter.acDecodeConfigFromServer = str2;
                decode(context, decodeParameter, iDecodeCallback);
                return;
            }
            if (iDecodeCallback != null) {
                Result result = new Result();
                result.resultCode = ResultCode.SDK_NOT_SUPPORT;
                result.resultMessage = ResultCode.SDK_NOT_SUPPORT_MESSAGE;
                iDecodeCallback.onResult(result);
            }
        }
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public List<String> getJSApiPermissionConfig(String str) {
        return ConfigCenter.INSTANCE.getDomains(str);
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void getPaymentCode(String str, IPaymentCodeListener iPaymentCodeListener) {
        if (!Utils.checkClassExist(Constants.PACKAGE_NAME_PAYMENTCODE_MANAGER)) {
            if (iPaymentCodeListener != null) {
                iPaymentCodeListener.onPaymentCodeUpdateFailed(ResultCode.SDK_NOT_SUPPORT, ResultCode.SDK_NOT_SUPPORT_MESSAGE);
                return;
            }
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ConfigCenter.INSTANCE.refreshConfigs();
        ACManager.getInstance().fetchConfigAsync(null);
        String codeType = ACManager.getInstance().getCodeType(str);
        if (TextUtils.isEmpty(codeType) && TextUtils.isEmpty(str)) {
            codeType = "AC19";
        }
        CPMConfig cpmConfig = ACManager.getInstance().getCpmConfig(codeType);
        if (cpmConfig != null) {
            if (cpmConfig.onlineCode) {
                OnlinePaymentCodeManager.getInstance().setRegion(str);
                OnlinePaymentCodeManager.getInstance().getPaymentCode(codeType, cpmConfig, iPaymentCodeListener);
            } else {
                if (iPaymentCodeListener != null) {
                    iPaymentCodeListener.onPaymentCodeUpdateFailed("PARAM_ILLEGAL", "Oops! System busy. Try again later!");
                }
                ACLogEvent.commonFailEvent("iapconnect_center", LogConstants.EVENT_ID_CPM_PAYMENT_CODE_ENTER, "PARAM_ILLEGAL", Interceptor4getPaymentCode.ERROR_MESSAGE_UNSUPPORTED, SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            ACLogEvent.commonSuccessEvent("iapconnect_center", LogConstants.EVENT_ID_CPM_PAYMENT_CODE_ENTER, SystemClock.elapsedRealtime() - elapsedRealtime);
            return;
        }
        if (iPaymentCodeListener != null) {
            iPaymentCodeListener.onPaymentCodeUpdateFailed("PARAM_ILLEGAL", "Oops! System busy. Try again later!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get CPM configurations, region: ");
        sb.append(str);
        sb.append(", codeType: ");
        sb.append(codeType);
        sb.append(", config: ");
        sb.append(cpmConfig);
        String obj = sb.toString();
        ACLogEvent.commonFailEvent("iapconnect_center", LogConstants.EVENT_ID_CPM_PAYMENT_CODE_ENTER, "PARAM_ILLEGAL", obj, SystemClock.elapsedRealtime() - elapsedRealtime);
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_CPM_PAYMENT_CODE_FAIL, obj);
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public TranslateManager getTranslateManager(Context context) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_TRANSLATE_MANAGER)) {
            return TranslateManager.getInstance(context);
        }
        return null;
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void init(Application application, InitConfig initConfig, InitCallback initCallback) {
        synchronized (c.class) {
            if (this.f7540a) {
                initCallback.onSuccess();
            } else {
                com.iap.ac.android.biz.b.a.a(application, initConfig, new a(initCallback));
            }
        }
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void initWithContext(Context context, InitConfig initConfig) {
        if (context != null && initConfig != null) {
            com.iap.ac.android.biz.b.a.a(context, initConfig);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("empty input parameters, context: ");
        sb.append(context);
        sb.append(", initConfig:");
        sb.append(initConfig);
        String obj = sb.toString();
        ACLog.e(Constants.TAG, obj);
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_AC_COMMON_INIT).addParams("sdkVersion", "2.39.0").addParams("result", LogConstants.RESULT_FALSE).addParams("resultMessage", obj).event();
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void inquireQuote(QuoteCurrency quoteCurrency, InquireQuoteCallback inquireQuoteCallback) {
        ACManager.getInstance().inquireQuote(quoteCurrency, inquireQuoteCallback);
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void notifyAgreePaymentAuthCode(AuthResult authResult) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_PLUGIN_MANAGER)) {
            IAPConnectPluginManager.getInstance().notifyAuthResult(authResult);
        }
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public boolean openACCenter() {
        if (ACManager.getInstance().getContext() == null) {
            ACLog.e(Constants.TAG, "openACCenter error, null context");
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_OPEN_AC_CENTER_FAIL, "openACCenter error, null context");
            return false;
        }
        ACManager.getInstance().fetchConfigAsync(null);
        ConfigCenter.INSTANCE.refreshConfigs();
        CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
        if (commonConfig != null && !TextUtils.isEmpty(commonConfig.acsAppId)) {
            RiskControlManager.getInstance().reportApdidToken();
            StringBuilder sb = new StringBuilder();
            sb.append("begin to open ACS with appId: ");
            sb.append(commonConfig.acsAppId);
            ACLog.i(Constants.TAG, sb.toString());
            WebContainer.getInstance("ac_biz").startContainer(ACManager.getInstance().getContext(), ContainerParams.createForMniProgram(commonConfig.acsAppId));
            return true;
        }
        ACLog.e(Constants.TAG, "openACCenter error, fetch acsAppId error");
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_OPEN_AC_CENTER_FAIL, "openACCenter error, fetch acsAppId error");
        return false;
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void signContract(SignContractRequest signContractRequest, AcCallback<AcBaseResult> acCallback) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_SIGNCONTRACT_MANAGER)) {
            SignContractManager.getInstance().signContract(false, signContractRequest, acCallback);
        } else if (acCallback != null) {
            AcBaseResult acBaseResult = new AcBaseResult();
            acBaseResult.success = false;
            acBaseResult.errorCode = ResultCode.SDK_NOT_SUPPORT;
            acBaseResult.errorMessage = ResultCode.SDK_NOT_SUPPORT_MESSAGE;
            acCallback.onResult(acBaseResult);
        }
    }

    @Override // com.iap.ac.android.biz.internal.IIAPConnect
    public void decode(Context context, DecodeParameter decodeParameter, IDecodeCallback iDecodeCallback) {
        synchronized (this) {
            if (Utils.checkClassExist(Constants.PACKAGE_NAME_DECODE_CHECKER)) {
                DecodeChecker.decode(context, decodeParameter, iDecodeCallback);
                ACLog.e("IAPConnectImpl", "check in");
            } else if (iDecodeCallback != null) {
                ACLog.e("IAPConnectImpl", "check callback");
                Result result = new Result();
                result.resultCode = ResultCode.SDK_NOT_SUPPORT;
                result.resultMessage = ResultCode.SDK_NOT_SUPPORT_MESSAGE;
                iDecodeCallback.onResult(result);
            }
            ACLog.e("IAPConnectImpl", "check end");
        }
    }
}
