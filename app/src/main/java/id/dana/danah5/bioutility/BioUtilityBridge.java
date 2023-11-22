package id.dana.danah5.bioutility;

import android.app.Activity;
import android.app.Application;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationManager;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\u0015J7\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJC\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/danah5/bioutility/BioUtilityBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.BIO_UTILITY, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, BioUtilityBridge.SECURITY_ID, "token", "source", "doInvokeFaceAuth", "(Landroid/app/Activity;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onInitialized", "()V", "Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "defaultFaceAuthenticationManager", "Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "getDefaultFaceAuthenticationManager", "()Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "setDefaultFaceAuthenticationManager", "(Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BioUtilityBridge extends SimpleBridgeExtension {
    public static final String FACE_AUTHENTICATION = "faceAuthentication";
    public static final String SECURITY_ID = "securityId";
    public static final String TOKEN = "token";
    @Inject
    public FaceAuthenticationManager defaultFaceAuthenticationManager;

    @JvmName(name = "getDefaultFaceAuthenticationManager")
    public final FaceAuthenticationManager getDefaultFaceAuthenticationManager() {
        FaceAuthenticationManager faceAuthenticationManager = this.defaultFaceAuthenticationManager;
        if (faceAuthenticationManager != null) {
            return faceAuthenticationManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDefaultFaceAuthenticationManager")
    public final void setDefaultFaceAuthenticationManager(FaceAuthenticationManager faceAuthenticationManager) {
        Intrinsics.checkNotNullParameter(faceAuthenticationManager, "");
        this.defaultFaceAuthenticationManager = faceAuthenticationManager;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (FaceAuthenticationModule) Preconditions.getAuthRequestContext(new FaceAuthenticationModule());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void bioUtility(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        String string = info.getString("token");
        String string2 = info.getString(SECURITY_ID);
        if (Intrinsics.areEqual(eventName, FACE_AUTHENTICATION)) {
            if (string != null) {
                if (string.length() > 0) {
                    Activity activity = BridgeExtensionExtKt.getActivity(page);
                    if (activity == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    doInvokeFaceAuth(activity, string2, bridgeCallback, string, eventName, DefaultFaceAuthenticationManager.SOURCE_TRANSFER_ACCOUNT);
                    return;
                }
            }
            String str = string2;
            if (str == null || str.length() == 0) {
                bridgeCallback.sendJSONResponse(BioUtilityResultFactory.getError("005"));
                return;
            }
            Activity activity2 = BridgeExtensionExtKt.getActivity(page);
            if (activity2 == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(string2, "");
            doInvokeFaceAuth$default(this, activity2, string2, bridgeCallback, null, eventName, DefaultFaceAuthenticationManager.SOURCE_CASH_OUT, 8, null);
        }
    }

    static /* synthetic */ void doInvokeFaceAuth$default(BioUtilityBridge bioUtilityBridge, Activity activity, String str, BridgeCallback bridgeCallback, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        bioUtilityBridge.doInvokeFaceAuth(activity, str, bridgeCallback, str2, str3, str4);
    }

    private final void doInvokeFaceAuth(Activity activity, String securityId, BridgeCallback bridgeCallback, String token, String eventName, String source) {
        FaceAuthenticationManager defaultFaceAuthenticationManager = getDefaultFaceAuthenticationManager();
        defaultFaceAuthenticationManager.setActivity(activity);
        defaultFaceAuthenticationManager.setBridgeCallback(bridgeCallback);
        if (token != null) {
            defaultFaceAuthenticationManager.tokenTransferAccount(token);
        }
        defaultFaceAuthenticationManager.launchFaceAuth(eventName, source, securityId, true);
    }
}
