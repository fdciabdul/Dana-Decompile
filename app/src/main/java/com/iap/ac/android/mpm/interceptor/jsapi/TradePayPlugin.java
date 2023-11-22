package com.iap.ac.android.mpm.interceptor.jsapi;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.spi.APIContextFactory;
import com.iap.ac.android.biz.common.utils.AcBizUtils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.js.AlipayJSAPI;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.base.model.hook.request.TradePayParams;
import com.iap.ac.android.mpm.base.model.tradepay.TradePayResultUtils;
import com.iap.ac.android.mpm.biz.BizProcessResumeParams;
import com.iap.ac.android.mpm.biz.BizProcessorManager;
import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import com.iap.ac.android.mpm.biz.base.EntranceType;
import com.iap.ac.android.mpm.biz.miniprogram.MiniProgramTradePayBiz;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeRequest;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeResponse;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TradePayPlugin extends BaseJSPlugin {
    private static final String ACQUIRE_SITE = "acquireSite";
    private static final String AC_MERCHANT_ID = "acMerchantId";
    private static final String APP_ID = "appId";
    private static final String CROSS_PAY = "crossPay";
    private static final String NEW_SOURCE_SITE = "newSourceSite";
    private static final String ORDER_STRING = "orderStr";
    private static final String PAYMENT_URL = "paymentUrl";
    private static final String SOURCE_SITE = "sourceSite";
    private static final String TAG = "TradePayPlugin";
    private static final String TRADE_NO = "tradeNO";
    private static final String TRADE_PAY = "tradePay";
    private Handler handler = new Handler(Looper.getMainLooper());

    @AlipayJSAPI(api = CROSS_PAY)
    public void tradePayCrossApp(Map<String, String> map, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        apiInternal(map, iContainerPresenter, containerBridgeContext);
    }

    @AlipayJSAPI(api = "tradePay")
    public void api(Map<String, String> map, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        apiInternal(map, iContainerPresenter, containerBridgeContext);
    }

    private void apiInternal(final Map<String, String> map, final IContainerPresenter iContainerPresenter, final ContainerBridgeContext containerBridgeContext) {
        ACLog.d(TAG, "api tradePay");
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_INTERCEPTOR_JSAPI).addParams("action", "tradePay").addParams("params", map).event();
        String str = map.get("appId");
        boolean isAcBizPay = AcBizUtils.isAcBizPay(str, map.get("sourceSite"), map.get("acquireSite"));
        final TradePayParams tradePayParams = new TradePayParams();
        tradePayParams.tradeNo = map.get("tradeNO");
        tradePayParams.orderStr = map.get("orderStr");
        tradePayParams.paymentUrl = map.get("paymentUrl");
        if (!(str == null || !WebContainer.getInstance("ac_biz").isMiniProgram(str)) && !isAcBizPay) {
            ACLog.e(TAG, "neither h5 nor ac mini program");
            ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_JSAPI_TRADEPAY_FAIL).addParams("resultCode", "PARAM_ILLEGAL").addParams("resultMessage", "neither h5 nor ac mini program").setEventType(LogEventType.CRUCIAL_LOG).event();
            sendErrorResult(containerBridgeContext);
        } else if (isAcBizPay) {
            handleAcMiniProgramBiz(map, tradePayParams, APIContextFactory.createACMiniProgramAPIContext(str, map.get(AC_MERCHANT_ID)), containerBridgeContext);
        } else {
            try {
                String stringExtra = iContainerPresenter.getActivity().getIntent().getStringExtra(Constants.H5Param.PARAM_BIZ_KEY);
                final BaseBizProcessor processor = BizProcessorManager.getProcessor(stringExtra);
                if (processor == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(stringExtra);
                    sb.append("  biz processor is not exist");
                    String obj = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(stringExtra);
                    sb2.append(obj);
                    ACLog.e(TAG, sb2.toString());
                    ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_BIZ_NOT_FOUND_ERROR, obj);
                    sendErrorResult(containerBridgeContext);
                    return;
                }
                IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2 = tradePayParams.tradeNo;
                        if (TextUtils.isEmpty(str2)) {
                            SwapOrderNodeResponse swapOrderNodeResponse = new SwapOrderNodeResponse();
                            Result result = new Result();
                            swapOrderNodeResponse.logResultCode = "PARAM_ILLEGAL";
                            result.resultCode = "PARAM_ILLEGAL";
                            result.resultMessage = "Oops! System busy. Try again later!";
                            swapOrderNodeResponse.logResultMsg = "tradeNO is empty.";
                            swapOrderNodeResponse.result = result;
                            swapOrderNodeResponse.endNode = LogConstants.Mpm.EndNodeType.SWAPORDER;
                            processor.onProcessFinish(swapOrderNodeResponse);
                            return;
                        }
                        processor.onProcessResume(new SwapOrderNodeRequest(map, str2, false), new BizProcessResumeParams(EntranceType.TradePayPlugin, iContainerPresenter, containerBridgeContext));
                    }
                });
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("get biz key error :");
                sb3.append(th);
                String obj2 = sb3.toString();
                ACLog.e(TAG, obj2);
                ACLogEvent.exceptionLog(obj2);
                sendErrorResult(containerBridgeContext);
            }
        }
    }

    private void handleAcMiniProgramBiz(Map<String, String> map, TradePayParams tradePayParams, AclAPIContext aclAPIContext, final ContainerBridgeContext containerBridgeContext) {
        final MiniProgramTradePayBiz miniProgramTradePayBiz = new MiniProgramTradePayBiz(map, tradePayParams, aclAPIContext, new IDecodeCallback() { // from class: com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin.2
            @Override // com.iap.ac.android.mpm.base.interfaces.IDecodeCallback
            public void dismissLoading() {
            }

            @Override // com.iap.ac.android.mpm.base.interfaces.IDecodeCallback
            public void showLoading() {
            }

            @Override // com.iap.ac.android.mpm.base.interfaces.IDecodeCallback
            public void onResult(Result result) {
                final JSONObject tradePayResultJsonObject = TradePayResultUtils.getTradePayResultJsonObject(result == null ? null : result.resultCode);
                TradePayPlugin.this.handler.post(new Runnable() { // from class: com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        containerBridgeContext.sendBridgeResult(tradePayResultJsonObject);
                    }
                });
            }
        });
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                miniProgramTradePayBiz.onProcessBegin();
            }
        });
    }

    @Override // com.iap.ac.android.common.container.js.plugin.BaseJSPlugin
    public Class<? extends BaseJSPlugin> getJSPluginClass() {
        return TradePayPlugin.class;
    }

    private void sendErrorResult(ContainerBridgeContext containerBridgeContext) {
        Result result = new Result();
        result.resultCode = "PARAM_ILLEGAL";
        result.resultMessage = "Oops! System busy. Try again later!";
        containerBridgeContext.sendBridgeResult(TradePayResultUtils.getTradePayResultJsonObject(result.resultCode));
    }
}
