package id.dana.data.usersecurityquestions.repository.source.network;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alibaba.fastjson.JSONObject;
import com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.usersecurityquestions.UserSecurityQuestionStateEntityData;
import id.dana.data.usersecurityquestions.repository.source.network.request.UserSecurityQuestionRequest;
import id.dana.data.usersecurityquestions.repository.source.network.result.UserSecurityQuestionEntityResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class NetworkUserSecurityQuestionStateEntityData extends SecureBaseNetwork<UserSecurityQuestionsStateApi> implements UserSecurityQuestionStateEntityData {
    private static final String ACTION = "BUILD_MENU";
    private static final String DEVICE_TYPE = "android";
    private static final String MODULE = "APP_SETTING_NATIVE";
    private static final String PRODMNG_ID = "query";
    private static final String SCENE_ID = "dana_app_securitysetting";
    private static final String TAG = "NetworkUserSecurityQuestionStateEntityData";
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final SecurityGuardFacade securityGuardFacade;

    public NetworkUserSecurityQuestionStateEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, SecurityGuardFacade securityGuardFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.apSecurityFacade = apSecurityFacade;
        this.securityGuardFacade = securityGuardFacade;
        this.context = context;
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<UserSecurityQuestionsStateApi> getFacadeClass() {
        return UserSecurityQuestionsStateApi.class;
    }

    @Override // id.dana.data.usersecurityquestions.UserSecurityQuestionStateEntityData
    public Observable<UserSecurityQuestionEntityResult> getSecurityQuestionState(String str, String str2) {
        final UserSecurityQuestionRequest userSecurityQuestionRequest = new UserSecurityQuestionRequest();
        userSecurityQuestionRequest.action = "BUILD_MENU";
        userSecurityQuestionRequest.data = generateData(str);
        userSecurityQuestionRequest.envData = generateEnvData(str2);
        userSecurityQuestionRequest.isDisplaySensitiveField = false;
        userSecurityQuestionRequest.module = MODULE;
        userSecurityQuestionRequest.prodmngId = "query";
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.usersecurityquestions.repository.source.network.NetworkUserSecurityQuestionStateEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserSecurityQuestionEntityResult securityQuestionState;
                securityQuestionState = ((UserSecurityQuestionsStateApi) obj).getSecurityQuestionState(UserSecurityQuestionRequest.this);
                return securityQuestionState;
            }
        });
    }

    private String generateData(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", (Object) str);
        jSONObject.put("sceneId", (Object) SCENE_ID);
        return jSONObject.toString();
    }

    private String generateEnvData(String str) {
        String str2;
        try {
            str2 = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, e.getMessage());
            str2 = "";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceType", (Object) DEVICE_TYPE);
        jSONObject.put("appVersion", (Object) str2);
        jSONObject.put("osVersion", (Object) Build.VERSION.RELEASE);
        jSONObject.put("clientKey", (Object) CommonUtil.PlaceComponentResult(this.securityGuardFacade, ""));
        jSONObject.put("apdidToken", (Object) this.apSecurityFacade.BuiltInFictitiousFunctionClassFactory());
        jSONObject.put("sdkVersion", (Object) str);
        jSONObject.put("deviceModel", (Object) Build.MODEL);
        jSONObject.put("language", (Object) "en_US");
        jSONObject.put("apdid", (Object) APSecuritySdk.getInstance(this.apSecurityFacade.BuiltInFictitiousFunctionClassFactory).getTokenResult().apdid);
        jSONObject.put("umidToken", (Object) APSecuritySdk.getInstance(this.apSecurityFacade.BuiltInFictitiousFunctionClassFactory).getTokenResult().umidToken);
        return jSONObject.toString();
    }
}
