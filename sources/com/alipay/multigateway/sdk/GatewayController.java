package com.alipay.multigateway.sdk;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.multigateway.sdk.GatewayInfo;
import com.alipay.multigateway.sdk.adapter.signature.SignatureManager;
import com.alipay.multigateway.sdk.decision.GatewayDecisionHelper;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.alipay.multigateway.sdk.decision.condition.getter.IGetter;
import com.alipay.multigateway.sdk.decision.condition.getter.impl.OperationTypeGetter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GatewayController {
    private static final String TAG = "GatewayController";
    private GatewayCallback callback;
    private GatewayCallback<Object> callbackWrap = new GatewayCallback<Object>() { // from class: com.alipay.multigateway.sdk.GatewayController.1
        @Override // com.alipay.multigateway.sdk.GatewayCallback
        public void onAfterGatewayApply(GatewayInfo gatewayInfo, Object obj) {
            if (GatewayController.this.callback != null) {
                try {
                    GatewayController.this.callback.onAfterGatewayApply(gatewayInfo, obj);
                } catch (Throwable th) {
                    LoggerWrapper.e(GatewayController.TAG, "callbackWrap onAfterGatewayApply occur exception.", th);
                }
            }
        }

        @Override // com.alipay.multigateway.sdk.GatewayCallback
        public void onNoRuleMatch(Object obj) {
            if (GatewayController.this.callback != null) {
                try {
                    GatewayController.this.callback.onNoRuleMatch(obj);
                } catch (Throwable th) {
                    LoggerWrapper.e(GatewayController.TAG, "callbackWrap onNoRuleMatch occur exception.", th);
                }
            }
        }

        @Override // com.alipay.multigateway.sdk.GatewayCallback
        public boolean shouldApplyGateway(GatewayInfo gatewayInfo, Object obj) {
            if (GatewayController.this.callback != null) {
                try {
                    return GatewayController.this.callback.shouldApplyGateway(gatewayInfo, obj);
                } catch (Throwable th) {
                    LoggerWrapper.e(GatewayController.TAG, "callbackWrap shouldApplyGateway occur exception.", th);
                    return true;
                }
            }
            return true;
        }

        @Override // com.alipay.multigateway.sdk.GatewayCallback
        public String getPlaintextForSign(GatewayInfo gatewayInfo, Object obj) {
            if (GatewayController.this.callback != null) {
                try {
                    return GatewayController.this.callback.getPlaintextForSign(gatewayInfo, obj);
                } catch (Throwable th) {
                    LoggerWrapper.e(GatewayController.TAG, "callbackWrap getPlaintextForSign occur exception.", th);
                    return null;
                }
            }
            return null;
        }
    };
    private NetworkDelegate delegate;
    private GatewayDecisionHelper gatewayDecisionHelper;
    private SignatureManager signatureManager;
    private ConditionValueGetter valueGetter;

    public void init(Context context, NetworkDelegate networkDelegate) {
        this.delegate = networkDelegate;
        ConditionValueGetter conditionValueGetter = new ConditionValueGetter();
        this.valueGetter = conditionValueGetter;
        this.gatewayDecisionHelper = new GatewayDecisionHelper(conditionValueGetter);
        this.signatureManager = new SignatureManager();
        addValueGetter(Condition.TYPE_OPERATION_TYPE, new OperationTypeGetter());
    }

    public void replaceRules(List<Rule> list) {
        this.gatewayDecisionHelper.replaceRules(list);
    }

    public void addRules(List<Rule> list) {
        this.gatewayDecisionHelper.addRules(list);
    }

    public void addRule(Rule rule) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(rule);
        addRules(arrayList);
    }

    public void setCallback(GatewayCallback gatewayCallback) {
        this.callback = gatewayCallback;
    }

    public void addValueGetter(String str, IGetter iGetter) {
        this.valueGetter.addGetter(str, iGetter);
    }

    public NetworkDelegate getDelegate() {
        return this.delegate;
    }

    public void processRequest(Object obj) {
        GatewayInfo decide = this.gatewayDecisionHelper.decide(obj);
        if (decide == null) {
            LoggerWrapper.i(TAG, "no gateway found");
            this.callbackWrap.onNoRuleMatch(obj);
        } else if (!this.callbackWrap.shouldApplyGateway(decide, obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ignore gateway from user, ");
            sb.append(decide.getTargetUrl());
            LoggerWrapper.i(TAG, sb.toString());
        } else {
            GatewayInfo.SignInfo signInfo = decide.signInfo;
            if (signInfo != null) {
                LoggerWrapper.i(TAG, "start sign request");
                String signRequest = this.signatureManager.signRequest(this.callbackWrap.getPlaintextForSign(decide, obj), signInfo);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("content signed, add to request: sign = ");
                sb2.append(signRequest);
                LoggerWrapper.i(TAG, sb2.toString());
                decide = decide.m86clone();
                this.signatureManager.setSignatureToGatewayInfo(signRequest, decide);
                LoggerWrapper.i(TAG, "added signature to request");
            }
            this.delegate.setGatewayInfo(decide, obj);
            this.callbackWrap.onAfterGatewayApply(decide, obj);
        }
    }
}
