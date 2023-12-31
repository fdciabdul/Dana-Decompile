package com.alipay.mobile.verifyidentity.framework.engine;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.ProductConstants;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.activity.SecVIVerify;
import com.alipay.mobile.verifyidentity.business.activity.SecVIVerifyInterface;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.framework.R;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.alipay.mobile.verifyidentity.uitools.JsonUtils;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ProductUtils {
    public static void getFaceState(final Context context, Map<String, Object> map, final QueryStateInterface queryStateInterface) {
        SecVIVerifyInterface secVIVerifyInterface;
        SecVIVerifyInterface secVIVerifyInterface2;
        final Dialog createLoadingDialog = CustomUi.createLoadingDialog((Activity) context);
        createLoadingDialog.show();
        if (!map.containsKey("userId") && (secVIVerifyInterface2 = SecVIVerify.secVIVerifyInterface) != null) {
            String userId = secVIVerifyInterface2.userId();
            if (!TextUtils.isEmpty(userId)) {
                map.put("userId", userId);
            }
        }
        if (!map.containsKey(RequestConstants.SecVIKeyTntInstId) && (secVIVerifyInterface = SecVIVerify.secVIVerifyInterface) != null) {
            String tntInstId = secVIVerifyInterface.tntInstId();
            if (!TextUtils.isEmpty(tntInstId)) {
                map.put(RequestConstants.SecVIKeyTntInstId, tntInstId);
            }
        }
        final String str = (String) map.get("sceneId");
        final String str2 = (String) map.get("userId");
        final String str3 = (String) map.get(RequestConstants.SecVIKeyTntInstId);
        final String str4 = (String) map.get("productCode");
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.framework.engine.ProductUtils.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final MICRpcResponse execute() throws Exception {
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = RequestConstants.BUILD_MENU;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(context)).toString();
                mICRpcRequest.module = str4;
                mICRpcRequest.prodmngId = "query";
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userId", str2);
                jSONObject.put(RequestConstants.SecVIKeyTntInstId, str3);
                jSONObject.put("sceneId", str);
                mICRpcRequest.data = jSONObject.toString();
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(MICRpcResponse mICRpcResponse) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (mICRpcResponse == null) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a4.b3.c2", "1", ""}, null, "", "SecVI_Seed_SecQuestion_QueryStatus", "", "", false);
                    Context context2 = context;
                    CustomUi.showCenterToast((Activity) context2, context2.getResources().getString(R.string.system_busy_error));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new Message(mICRpcResponse.toString()).getData());
                    JSONObject jSONObject2 = ((JSONObject) ((JSONObject) jSONObject.getJSONObject(SecurityConstants.KEY_MENU_DATA).getJSONArray(SecurityConstants.KEY_MENUGROUPS).get(0)).getJSONArray(SecurityConstants.KEY_MENUITEMS).get(0)).getJSONObject("extInfo");
                    String string = JsonUtils.getString(jSONObject2, "type");
                    String string2 = JsonUtils.getString(jSONObject2, "status");
                    String string3 = JsonUtils.getString(jSONObject.getJSONObject("extInfo"), "allSet");
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    if (string.equals("FACEID_PAY")) {
                        jSONObject5.put(MaintenanceBroadcastResult.KEY_VISIBLE, true);
                        if (string2.equals("CLOSED")) {
                            jSONObject5.put("enable", false);
                        } else {
                            jSONObject5.put("enable", true);
                        }
                    } else {
                        jSONObject5.put(MaintenanceBroadcastResult.KEY_VISIBLE, false);
                    }
                    jSONObject5.put("verifyId", string3);
                    jSONObject4.put(ProductConstants.KEY_PRODUCT_STATE_ZOLOZ, jSONObject5);
                    jSONObject3.put(ProductConstants.KEY_PRODUCT_ENV_ZOLOZ, jSONObject4);
                    QueryStateInterface queryStateInterface2 = queryStateInterface;
                    if (queryStateInterface2 != null) {
                        queryStateInterface2.getFaceState(jSONObject3.toString());
                    }
                } catch (JSONException unused) {
                    QueryStateInterface queryStateInterface3 = queryStateInterface;
                    if (queryStateInterface3 != null) {
                        queryStateInterface3.getFaceState("");
                    }
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                Dialog dialog = createLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }
}
