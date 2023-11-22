package id.dana.danah5.getonlineconfig;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.DefaultObserver;
import id.dana.domain.h5onlineconfig.GetH5OnlineConfig;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/danah5/getonlineconfig/GetOnlineConfigBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/fastjson/JSONObject;", "info", "", "fetchOnlineConfigData", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/fastjson/JSONObject;)V", BridgeName.GET_ONLINE_CONFIG, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", "isValidInput", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/fastjson/JSONObject;)Z", "onFinalized", "()V", "onInitialized", "Lid/dana/domain/h5onlineconfig/GetH5OnlineConfig;", "getH5OnlineConfig", "Lid/dana/domain/h5onlineconfig/GetH5OnlineConfig;", "getGetH5OnlineConfig", "()Lid/dana/domain/h5onlineconfig/GetH5OnlineConfig;", "setGetH5OnlineConfig", "(Lid/dana/domain/h5onlineconfig/GetH5OnlineConfig;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetOnlineConfigBridge extends SimpleBridgeExtension {
    private static final String NAMES = "names";
    private static final String SECTION = "section";
    @Inject
    public GetH5OnlineConfig getH5OnlineConfig;

    @JvmName(name = "getGetH5OnlineConfig")
    public final GetH5OnlineConfig getGetH5OnlineConfig() {
        GetH5OnlineConfig getH5OnlineConfig = this.getH5OnlineConfig;
        if (getH5OnlineConfig != null) {
            return getH5OnlineConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetH5OnlineConfig")
    public final void setGetH5OnlineConfig(GetH5OnlineConfig getH5OnlineConfig) {
        Intrinsics.checkNotNullParameter(getH5OnlineConfig, "");
        this.getH5OnlineConfig = getH5OnlineConfig;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void getOnlineConfig(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (isValidInput(bridgeCallback, info)) {
            fetchOnlineConfigData(bridgeCallback, info);
        }
    }

    private final void fetchOnlineConfigData(final BridgeCallback bridgeCallback, JSONObject info) {
        JSONArray jSONArray = info.getJSONArray(NAMES);
        Intrinsics.checkNotNullExpressionValue(jSONArray, "");
        JSONArray jSONArray2 = jSONArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray2, 10));
        Iterator<Object> it = jSONArray2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        getGetH5OnlineConfig().execute(new DefaultObserver<String>() { // from class: id.dana.danah5.getonlineconfig.GetOnlineConfigBridge$fetchOnlineConfigData$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(String result) {
                Intrinsics.checkNotNullParameter(result, "");
                BridgeCallback.this.sendJSONResponse(GetOnlineConfigResultFactory.handleSuccess(result));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "");
                BridgeCallback.this.sendJSONResponse(GetOnlineConfigResultFactory.handleError("001"));
                this.getGetH5OnlineConfig().dispose();
            }
        }, GetH5OnlineConfig.Params.forGetOnlineConfig(info.getString("section"), CollectionsKt.toSet(arrayList)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[Catch: NullPointerException -> 0x0043, TryCatch #0 {NullPointerException -> 0x0043, blocks: (B:3:0x0003, B:5:0x0014, B:11:0x0020, B:13:0x002a, B:15:0x002e, B:21:0x003a), top: B:26:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[Catch: NullPointerException -> 0x0043, TryCatch #0 {NullPointerException -> 0x0043, blocks: (B:3:0x0003, B:5:0x0014, B:11:0x0020, B:13:0x002a, B:15:0x002e, B:21:0x003a), top: B:26:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: NullPointerException -> 0x0043, TRY_LEAVE, TryCatch #0 {NullPointerException -> 0x0043, blocks: (B:3:0x0003, B:5:0x0014, B:11:0x0020, B:13:0x002a, B:15:0x002e, B:21:0x003a), top: B:26:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isValidInput(com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r5, com.alibaba.fastjson.JSONObject r6) {
        /*
            r4 = this;
            java.lang.String r0 = "003"
            r1 = 0
            java.lang.String r2 = "section"
            java.lang.String r2 = r6.getString(r2)     // Catch: java.lang.NullPointerException -> L43
            java.lang.String r3 = "names"
            com.alibaba.fastjson.JSONArray r6 = r6.getJSONArray(r3)     // Catch: java.lang.NullPointerException -> L43
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.NullPointerException -> L43
            r3 = 1
            if (r2 == 0) goto L1d
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch: java.lang.NullPointerException -> L43
            if (r2 == 0) goto L1b
            goto L1d
        L1b:
            r2 = 0
            goto L1e
        L1d:
            r2 = 1
        L1e:
            if (r2 == 0) goto L2a
            java.lang.String r6 = "002"
            com.alibaba.fastjson.JSONObject r6 = id.dana.danah5.getonlineconfig.GetOnlineConfigResultFactory.handleError(r6)     // Catch: java.lang.NullPointerException -> L43
            r5.sendJSONResponse(r6)     // Catch: java.lang.NullPointerException -> L43
            return r1
        L2a:
            java.util.Collection r6 = (java.util.Collection) r6     // Catch: java.lang.NullPointerException -> L43
            if (r6 == 0) goto L37
            boolean r6 = r6.isEmpty()     // Catch: java.lang.NullPointerException -> L43
            if (r6 == 0) goto L35
            goto L37
        L35:
            r6 = 0
            goto L38
        L37:
            r6 = 1
        L38:
            if (r6 == 0) goto L42
            com.alibaba.fastjson.JSONObject r6 = id.dana.danah5.getonlineconfig.GetOnlineConfigResultFactory.handleError(r0)     // Catch: java.lang.NullPointerException -> L43
            r5.sendJSONResponse(r6)     // Catch: java.lang.NullPointerException -> L43
            return r1
        L42:
            return r3
        L43:
            com.alibaba.fastjson.JSONObject r6 = id.dana.danah5.getonlineconfig.GetOnlineConfigResultFactory.handleError(r0)
            r5.sendJSONResponse(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.getonlineconfig.GetOnlineConfigBridge.isValidInput(com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback, com.alibaba.fastjson.JSONObject):boolean");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        getGetH5OnlineConfig().dispose();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(this);
    }
}
