package com.iap.ac.android.mpm.biz.gol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.DecodeParameter;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.base.model.route.ACDecodeConfig;
import com.iap.ac.android.mpm.biz.BizProcessResumeParams;
import com.iap.ac.android.mpm.biz.DecodeBizProcessor;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeResponse;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeRequest;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class GolOrderCodeBiz extends DecodeBizProcessor {
    private boolean isAcMiniProgram;
    private String merchantAppType;
    private GolOrderCodeRoute route;
    private String sourceAppPackageName;

    public GolOrderCodeBiz(Context context, String str, boolean z, DecodeParameter decodeParameter, ACDecodeConfig aCDecodeConfig, IDecodeCallback iDecodeCallback) {
        super(LogConstants.Mpm.BizScenarioType.GOL_ORDER_CODE, context, str, decodeParameter.scene, iDecodeCallback);
        this.isAcMiniProgram = z;
        this.merchantAppType = decodeParameter.merchantType;
        this.sourceAppPackageName = decodeParameter.sourceAppPackageName;
        this.acDecodeConfig = aCDecodeConfig;
        parsePkgName(context);
        this.route = new GolOrderCodeRoute();
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessBegin() {
        if (!isToggleBiz()) {
            sendToggleOffResult();
            return;
        }
        super.onProcessBegin();
        this.route.navigate(this, (NodeRequest) new DecodeOrderNodeRequest(this.codeValue, this.isAcMiniProgram));
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessResume(NodeRequest nodeRequest, BizProcessResumeParams bizProcessResumeParams) {
        super.onProcessResume(nodeRequest, bizProcessResumeParams);
        NodeType nodeType = nodeRequest.getNodeType();
        if (NodeType.DecodeOrder.equals(nodeType)) {
            this.containerPresenter = bizProcessResumeParams.containerPresenter;
            this.route.changeEntranceType(bizProcessResumeParams.entranceType);
            this.route.navigate(this, (NodeRequest) ((DecodeOrderNodeRequest) nodeRequest));
            return;
        }
        handleOnResumeError(nodeType);
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeBegin(NodeRequest nodeRequest) {
        super.onNodeBegin(nodeRequest);
        NodeType nodeType = nodeRequest.getNodeType();
        if (NodeType.DecodeOrder.equals(nodeType)) {
            showLoading();
        } else if (NodeType.OpenUrl.equals(nodeType)) {
            updateOpenUrlRequestParams((OpenUrlNodeRequest) nodeRequest);
        }
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeEnd(NodeRequest nodeRequest, NodeResponse nodeResponse) {
        super.onNodeEnd(nodeRequest, nodeResponse);
        if (NodeType.DecodeOrder.equals(nodeResponse.nodeType())) {
            DecodeOrderNodeResponse decodeOrderNodeResponse = (DecodeOrderNodeResponse) nodeResponse;
            if ("pay".equalsIgnoreCase(decodeOrderNodeResponse.decodeAction)) {
                this.paymentRedirectUrl = decodeOrderNodeResponse.paymentRedirectUrl;
                this.paymentCancelUrl = decodeOrderNodeResponse.paymentCancelUrl;
                if (!TextUtils.isEmpty(decodeOrderNodeResponse.terminalType)) {
                    this.merchantAppType = decodeOrderNodeResponse.terminalType;
                }
            }
            this.thirdPartyError = decodeOrderNodeResponse.thirdPartyError;
            dismissLoading();
        }
    }

    private void parsePkgName(Context context) {
        if ((context instanceof Activity) && TextUtils.isEmpty(this.sourceAppPackageName)) {
            try {
                Uri BuiltInFictitiousFunctionClassFactory = ActivityCompat.BuiltInFictitiousFunctionClassFactory((Activity) context);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    this.sourceAppPackageName = BuiltInFictitiousFunctionClassFactory.getHost();
                }
            } catch (Throwable th) {
                ACLog.e(Constants.TAG, th.getMessage());
                StringBuilder sb = new StringBuilder();
                sb.append("parsePkgName error:");
                sb.append(th.getMessage());
                ACLogEvent.exceptionLog(sb.toString());
            }
            if (TextUtils.isEmpty(this.sourceAppPackageName)) {
                this.sourceAppPackageName = ((Activity) context).getCallingPackage();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sourceAppPackageName is ");
            sb2.append(this.sourceAppPackageName);
            ACLog.i(Constants.TAG, sb2.toString());
        }
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor
    public void handlePaymentRedirectUrl(Result result) {
        closeWebView();
        if (TextUtils.isEmpty(this.paymentRedirectUrl)) {
            ACLog.i(Constants.TAG, "GolOrderCodeBiz payment redirect url is empty");
        } else {
            jumpToSourceApp();
        }
    }

    private void jumpToSourceApp() {
        if ("H5".equalsIgnoreCase(this.merchantAppType)) {
            ACLog.e(Constants.TAG, "merchant is h5, redirect to source app");
            if (TextUtils.isEmpty(this.sourceAppPackageName)) {
                ACLog.e(Constants.TAG, String.format("merchant is h5, but sourceAppPackageName is invalid: %s, can not jump to source APP", this.sourceAppPackageName));
            } else {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(this.sourceAppPackageName);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setPackage(null);
                    launchIntentForPackage.setFlags(274726912);
                    try {
                        this.context.startActivity(launchIntentForPackage);
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("H5 startActivity error:");
                        sb.append(e);
                        String obj = sb.toString();
                        ACLog.e(Constants.TAG, obj);
                        ACLogEvent.exceptionLog(obj);
                    }
                }
            }
        } else if ("APP".equalsIgnoreCase(this.merchantAppType)) {
            ACLog.e(Constants.TAG, "merchant is app, redirect to payRedirectUrl");
            openSourceActivity(this.paymentRedirectUrl);
        }
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_REDIRECT_TO_MERCHANT).addParams(LogConstants.Mpm.CodeInfo.SOURCE_PACKAGE_NAME, this.sourceAppPackageName).addParams("redirectUrl", this.paymentRedirectUrl).addParams("merchantType", this.merchantAppType).event();
    }

    private void openSourceActivity(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            this.context.startActivity(intent);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("App startActivity error:");
            sb.append(th);
            String obj = sb.toString();
            ACLog.e(Constants.TAG, obj);
            ACLogEvent.exceptionLog(obj);
        }
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public boolean isToggleBiz() {
        ConfigCenter.INSTANCE.refreshConfigs();
        boolean mpmGolOrderToggle = ConfigCenter.INSTANCE.getMpmGolOrderToggle();
        StringBuilder sb = new StringBuilder();
        sb.append("GolOrderCodeBiz toggle is ");
        sb.append(mpmGolOrderToggle);
        ACLog.i(Constants.TAG, sb.toString());
        return mpmGolOrderToggle;
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor
    public void handleProcessFinish(NodeResponse nodeResponse) {
        if (nodeResponse.isSuccess() && NodeType.Pay.equals(nodeResponse.nodeType())) {
            handlePaymentRedirectUrl(nodeResponse.result);
        } else if (nodeResponse.result != null && TextUtils.equals(nodeResponse.result.resultCode, "USER_CANCEL") && this.merchantAppType.equals("APP")) {
            String str = null;
            if (!TextUtils.isEmpty(this.paymentCancelUrl)) {
                str = this.paymentCancelUrl;
            } else if (!TextUtils.isEmpty(this.paymentRedirectUrl)) {
                str = this.paymentRedirectUrl;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            openSourceActivity(str);
            ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_CANCEL_REDIRECT_TO_MERCHANT).addParams("redirectUrl", str).addParams("merchantType", this.merchantAppType).event();
        }
    }
}
