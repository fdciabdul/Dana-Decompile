package id.dana.danah5.faceverificationenablement;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.challenge.ChallengeControl;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationManager;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\u0018J-\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!"}, d2 = {"Lid/dana/danah5/faceverificationenablement/FaceAuthenticationBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "source", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.DANA_VIZ, "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)V", IpcMessageConstants.EXTRA_EVENT, "", "dismissFromNative", BridgeName.FACE_VERIFICATION_ENABLEMENT, "(Ljava/lang/String;ZLcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onInitialized", "()V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Ljava/lang/String;", "Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "faceAuthenticationManager", "Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "getFaceAuthenticationManager", "()Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "setFaceAuthenticationManager", "(Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceAuthenticationBridge extends BaseBridge {
    public static final String EVENT_NAME_ENABLE_FACE_AUTH_SWITCH = "enableFaceAuthSwitch";
    public static final String EVENT_NAME_ENROLL_FACE_AUTH = "enrollFaceAuth";
    private BridgeCallback bridgeCallback;
    private String eventName;
    @Inject
    public FaceAuthenticationManager faceAuthenticationManager;

    @JvmName(name = "getFaceAuthenticationManager")
    public final FaceAuthenticationManager getFaceAuthenticationManager() {
        FaceAuthenticationManager faceAuthenticationManager = this.faceAuthenticationManager;
        if (faceAuthenticationManager != null) {
            return faceAuthenticationManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFaceAuthenticationManager")
    public final void setFaceAuthenticationManager(FaceAuthenticationManager faceAuthenticationManager) {
        Intrinsics.checkNotNullParameter(faceAuthenticationManager, "");
        this.faceAuthenticationManager = faceAuthenticationManager;
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void danaViz(@BindingCallback BridgeCallback bridgeCallback, @BindingParam(name = {"source"}) String source, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(source, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        final Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        String str = source;
        if (str.length() == 0) {
            str = DefaultFaceAuthenticationManager.SOURCE_REGISTRATION;
        }
        FaceAuthenticationManager faceAuthenticationManager = getFaceAuthenticationManager();
        faceAuthenticationManager.setActivity(activity);
        faceAuthenticationManager.setBridgeCallback(bridgeCallback);
        faceAuthenticationManager.setActivityResult(new Function2<Intent, Integer, Unit>() { // from class: id.dana.danah5.faceverificationenablement.FaceAuthenticationBridge$danaViz$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Intent intent, Integer num) {
                invoke(intent, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Intent intent, int i) {
                if (intent != null) {
                    FaceAuthenticationBridge.this.startActivityForResult(activity, intent, i);
                }
            }
        });
        FaceAuthenticationManager.CC.launchFaceAuth$default(faceAuthenticationManager, null, str, null, false, 13, null);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void faceVerificationEnablement(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"dismissFromNative"}) boolean dismissFromNative, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        final Activity activity;
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        this.eventName = eventName;
        if (dismissFromNative && Intrinsics.areEqual(eventName, EVENT_NAME_ENROLL_FACE_AUTH)) {
            WithdrawBalanceFaceAuthActivationBottomSheet.Companion companion = WithdrawBalanceFaceAuthActivationBottomSheet.INSTANCE;
            WithdrawBalanceFaceAuthActivationBottomSheet.moveToNextValue = true;
            Activity activity2 = BridgeExtensionExtKt.getActivity(page);
            if (activity2 != null) {
                activity2.finish();
            }
        } else if ((Intrinsics.areEqual(eventName, EVENT_NAME_ENABLE_FACE_AUTH_SWITCH) || Intrinsics.areEqual(eventName, EVENT_NAME_ENROLL_FACE_AUTH)) && (activity = BridgeExtensionExtKt.getActivity(page)) != null) {
            FaceAuthenticationManager faceAuthenticationManager = getFaceAuthenticationManager();
            faceAuthenticationManager.setActivity(activity);
            faceAuthenticationManager.setBridgeCallback(bridgeCallback);
            faceAuthenticationManager.setActivityResult(new Function2<Intent, Integer, Unit>() { // from class: id.dana.danah5.faceverificationenablement.FaceAuthenticationBridge$faceVerificationEnablement$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Unit invoke(Intent intent, Integer num) {
                    invoke(intent, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Intent intent, int i) {
                    if (intent != null) {
                        FaceAuthenticationBridge.this.startActivityForResult(activity, intent, i);
                    }
                }
            });
            FaceAuthenticationManager.CC.launchFaceAuth$default(faceAuthenticationManager, eventName, null, null, false, 14, null);
        }
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        if (requestCode == 1002) {
            BridgeCallback bridgeCallback = null;
            if (resultCode == -1) {
                BridgeCallback bridgeCallback2 = this.bridgeCallback;
                if (bridgeCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback2;
                }
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            } else if (resultCode == 0) {
                if (Intrinsics.areEqual((data == null || (extras = data.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON), ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED)) {
                    BridgeCallback bridgeCallback3 = this.bridgeCallback;
                    if (bridgeCallback3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback = bridgeCallback3;
                    }
                    bridgeCallback.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getPIN_TEMPORARY_LOCKED());
                    return;
                }
                BridgeCallback bridgeCallback4 = this.bridgeCallback;
                if (bridgeCallback4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback4;
                }
                bridgeCallback.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getUSER_CANCEL());
            }
        }
    }
}
