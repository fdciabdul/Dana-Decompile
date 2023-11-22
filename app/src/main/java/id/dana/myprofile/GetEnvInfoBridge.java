package id.dana.myprofile;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.profilemenu.interactor.GetMobileEnvInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\rX\u0087\"¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/myprofile/GetEnvInfoBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BridgeName.GET_ENV_INFO, "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "onFinalized", "()V", "onInitialized", "BuiltInFictitiousFunctionClassFactory", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "MyBillsEntityDataFactory", "Lid/dana/domain/profilemenu/interactor/GetMobileEnvInfo;", "getMobileEnvInfo", "Lid/dana/domain/profilemenu/interactor/GetMobileEnvInfo;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetEnvInfoBridge extends SimpleBridgeExtension {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private BridgeCallback MyBillsEntityDataFactory;
    @Inject
    public GetMobileEnvInfo getMobileEnvInfo;

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void getEnvInfo(@BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        this.MyBillsEntityDataFactory = bridgeCallback;
        GetMobileEnvInfo getMobileEnvInfo = this.getMobileEnvInfo;
        if (getMobileEnvInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getMobileEnvInfo = null;
        }
        getMobileEnvInfo.execute(NoParams.INSTANCE, new Function1<MobileEnvInfo, Unit>() { // from class: id.dana.myprofile.GetEnvInfoBridge$getMobileEnvInfoFromEntityData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MobileEnvInfo mobileEnvInfo) {
                invoke2(mobileEnvInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MobileEnvInfo mobileEnvInfo) {
                BridgeCallback bridgeCallback2;
                Intrinsics.checkNotNullParameter(mobileEnvInfo, "");
                bridgeCallback2 = GetEnvInfoBridge.this.MyBillsEntityDataFactory;
                if (bridgeCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback2 = null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", (Object) Boolean.TRUE);
                jSONObject.put("envInfo", (Object) mobileEnvInfo);
                bridgeCallback2.sendJSONResponse(jSONObject);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.GetEnvInfoBridge$getMobileEnvInfoFromEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BridgeCallback bridgeCallback2;
                Intrinsics.checkNotNullParameter(th, "");
                bridgeCallback2 = GetEnvInfoBridge.this.MyBillsEntityDataFactory;
                if (bridgeCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback2 = null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", (Object) Boolean.FALSE);
                bridgeCallback2.sendJSONResponse(jSONObject);
            }
        });
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
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        GetMobileEnvInfo getMobileEnvInfo = this.getMobileEnvInfo;
        if (getMobileEnvInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getMobileEnvInfo = null;
        }
        getMobileEnvInfo.dispose();
    }
}
