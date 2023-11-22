package id.dana.danah5.deeplink.scanQr;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
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
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.TrackerQRScanner;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.scanner.handler.nativepages.ScannerSceneType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0012\u001a\u00020\u00072\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u001b"}, d2 = {"Lid/dana/danah5/deeplink/scanQr/OpenScanQrBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "onInitialized", "()V", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.OPEN_SCAN_QR, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "openScanQR", "(Landroid/app/Activity;Lcom/alibaba/fastjson/JSONObject;)V", "", "getSourceInfo", "(Lcom/alibaba/fastjson/JSONObject;)Ljava/lang/String;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenScanQrBridge extends BaseBridge {
    public static final String CLOSE_AFTER_SCAN = "closeAfterScan";
    public static final String QRIS_TOP_UP_KYB = "qris_topup_kyb";
    public static final String SOURCE = "source";
    private BridgeCallback bridgeCallback;

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

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void openQRScanner(@BindingParam(name = {"info"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity != null) {
            openScanQR(activity, jSONObject);
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.NATIVE_NODE_NULL);
        }
    }

    private final void openScanQR(Activity r5, JSONObject info) {
        String string = info != null ? info.getString("Source") : null;
        if (string == null) {
            string = TrackerKey.SourceType.JS_API;
        }
        TrackerQRScanner.PlaceComponentResult(string);
        Intent intent = new Intent(r5, ScannerActivity.class);
        String sourceInfo = info != null ? getSourceInfo(info) : null;
        if (sourceInfo == null) {
            sourceInfo = "";
        }
        intent.putExtra("scene", sourceInfo);
        Boolean bool = info != null ? info.getBoolean(CLOSE_AFTER_SCAN) : null;
        intent.putExtra(ScannerActivity.CLOSE_AFTER_SCAN, bool == null ? false : bool.booleanValue());
        startActivityForResult(r5, intent, ScannerActionFactory.BuiltInFictitiousFunctionClassFactory);
    }

    private final String getSourceInfo(JSONObject jSONObject) {
        return Intrinsics.areEqual(QRIS_TOP_UP_KYB, jSONObject.getString("source")) ? ScannerSceneType.SCENE_QRIS_TOP_UP_KYB : jSONObject.getString("source");
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int r1, int resultCode, Intent data) {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }
}
