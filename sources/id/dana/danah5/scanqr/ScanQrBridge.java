package id.dana.danah5.scanqr;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.H5ExtKt;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.TrackerQRScanner;
import id.dana.scanner.handler.ScannerActionFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u001a"}, d2 = {"Lid/dana/danah5/scanqr/ScanQrBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "onInitialized", "()V", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "scene", "codeConsumer", "openScannerActivity", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", BridgeName.SCAN_QR, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Ljava/lang/String;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScanQrBridge extends BaseBridge {
    public static final String CODE_CONSUMER_AUTO = "auto";
    public static final String CODE_CONSUMER_MINIPROGRAM = "miniprogram";
    public static final String CODE_CONSUMER_NATIVE = "native";
    private BridgeCallback bridgeCallback;
    private String codeConsumer;

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void scanQr(@BindingParam(name = {"info"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        String string = jSONObject.getString("codeConsumer");
        if (string == null) {
            string = CODE_CONSUMER_NATIVE;
        }
        this.codeConsumer = string;
        String string2 = jSONObject.getString("scene");
        if (string2 == null) {
            string2 = "";
        }
        String str = this.codeConsumer;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        openScannerActivity(page, string2, str);
    }

    public final void openScannerActivity(Page page, String scene, String codeConsumer) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(scene, "");
        Intrinsics.checkNotNullParameter(codeConsumer, "");
        TrackerQRScanner.PlaceComponentResult("Mini Program");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, ScannerActivity.class);
        intent.putExtra("scene", scene);
        intent.putExtra(ScannerActivity.CLOSE_AFTER_SCAN, true);
        intent.putExtra(ScannerActivity.CODE_CONSUMER, codeConsumer);
        intent.putExtra(ScannerActivity.SERVICE_KEY, H5ExtKt.getServiceKey(page));
        intent.putExtra("APP_ID", H5ExtKt.getAppId(page));
        startActivityForResult(activity, intent, ScannerActionFactory.BuiltInFictitiousFunctionClassFactory);
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
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int r8, int resultCode, Intent data) {
        Boolean bool = Boolean.FALSE;
        BridgeCallback bridgeCallback = null;
        if (resultCode == -1 && data != null) {
            boolean booleanExtra = data.getBooleanExtra("success", false);
            String str = this.codeConsumer;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            int hashCode = str.hashCode();
            if (hashCode == -1052618729) {
                if (str.equals(CODE_CONSUMER_NATIVE)) {
                    if (booleanExtra) {
                        BridgeCallback bridgeCallback2 = this.bridgeCallback;
                        if (bridgeCallback2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bridgeCallback = bridgeCallback2;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
                        bridgeCallback.sendJSONResponse(jSONObject);
                        return;
                    }
                    BridgeCallback bridgeCallback3 = this.bridgeCallback;
                    if (bridgeCallback3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback = bridgeCallback3;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put((JSONObject) "success", (String) bool);
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    return;
                }
                return;
            } else if (hashCode == -707675571) {
                if (str.equals("miniprogram")) {
                    BridgeCallback bridgeCallback4 = this.bridgeCallback;
                    if (bridgeCallback4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback = bridgeCallback4;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = jSONObject3;
                    jSONObject4.put((JSONObject) "success", (String) Boolean.TRUE);
                    String stringExtra = data.getStringExtra("code");
                    jSONObject4.put((JSONObject) "code", stringExtra != null ? stringExtra : "");
                    bridgeCallback.sendJSONResponse(jSONObject3);
                    return;
                }
                return;
            } else if (hashCode == 3005871 && str.equals("auto")) {
                if (booleanExtra) {
                    BridgeCallback bridgeCallback5 = this.bridgeCallback;
                    if (bridgeCallback5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback = bridgeCallback5;
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put((JSONObject) "success", (String) Boolean.TRUE);
                    bridgeCallback.sendJSONResponse(jSONObject5);
                    return;
                }
                BridgeCallback bridgeCallback6 = this.bridgeCallback;
                if (bridgeCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback6;
                }
                JSONObject jSONObject6 = new JSONObject();
                JSONObject jSONObject7 = jSONObject6;
                jSONObject7.put((JSONObject) "success", (String) bool);
                String stringExtra2 = data.getStringExtra("code");
                jSONObject7.put((JSONObject) "code", stringExtra2 != null ? stringExtra2 : "");
                bridgeCallback.sendJSONResponse(jSONObject6);
                return;
            } else {
                return;
            }
        }
        BridgeCallback bridgeCallback7 = this.bridgeCallback;
        if (bridgeCallback7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bridgeCallback = bridgeCallback7;
        }
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put((JSONObject) "success", (String) bool);
        bridgeCallback.sendJSONResponse(jSONObject8);
    }
}
