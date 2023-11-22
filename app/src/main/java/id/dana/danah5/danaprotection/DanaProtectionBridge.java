package id.dana.danah5.danaprotection;

import android.app.Activity;
import android.app.Application;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.animation.danaprotection.DanaProtectionRecommendationManager;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.danaprotection.DanaProtectionKey;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionInfo;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation;
import id.dana.domain.danaprotection.model.DanaProtectionInfoModel;
import id.dana.domain.danaprotection.model.DanaProtectionRecommendationModel;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b>\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\r2\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\r0\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0011R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010\u0010\u001a\u00020'8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u0015\u001a\u0002048\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010="}, d2 = {"Lid/dana/danah5/danaprotection/DanaProtectionBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/fastjson/JSONObject;", "assembleFailedResponse", "()Lcom/alibaba/fastjson/JSONObject;", "assembleRecommendationResponse", "", IpcMessageConstants.EXTRA_EVENT, "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.DANA_PROTECTION, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "getDanaProtectionInfo", "()V", "Lkotlin/Function1;", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "callback", "getDanaProtectionWidgetConfig", "(Lkotlin/jvm/functions/Function1;)V", "getRecommendationData", "onFinalized", "onInitialized", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "danaProtectionInfoModel", "Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "Lid/dana/home/danaprotection/DanaProtectionRecommendationManager;", "danaProtectionRecommendationManager$delegate", "Lkotlin/Lazy;", "getDanaProtectionRecommendationManager", "()Lid/dana/home/danaprotection/DanaProtectionRecommendationManager;", "danaProtectionRecommendationManager", "Lid/dana/domain/danaprotection/interactor/GetDanaProtectionInfo;", "Lid/dana/domain/danaprotection/interactor/GetDanaProtectionInfo;", "getGetDanaProtectionInfo", "()Lid/dana/domain/danaprotection/interactor/GetDanaProtectionInfo;", "setGetDanaProtectionInfo", "(Lid/dana/domain/danaprotection/interactor/GetDanaProtectionInfo;)V", "Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation;", "getDanaProtectionRecommendation", "Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation;", "getGetDanaProtectionRecommendation", "()Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation;", "setGetDanaProtectionRecommendation", "(Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation;)V", "Lid/dana/domain/featureconfig/interactor/GetDanaProtectionWidgetConfig;", "Lid/dana/domain/featureconfig/interactor/GetDanaProtectionWidgetConfig;", "getGetDanaProtectionWidgetConfig", "()Lid/dana/domain/featureconfig/interactor/GetDanaProtectionWidgetConfig;", "setGetDanaProtectionWidgetConfig", "(Lid/dana/domain/featureconfig/interactor/GetDanaProtectionWidgetConfig;)V", "", "Lid/dana/domain/danaprotection/model/DanaProtectionRecommendationModel;", DanaProtectionKey.DanaProtectionResultParamsKey.RECOMMENDATION_DATA, "Ljava/util/List;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaProtectionBridge extends BaseBridge {
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private DanaProtectionInfoModel danaProtectionInfoModel;

    /* renamed from: danaProtectionRecommendationManager$delegate  reason: from kotlin metadata */
    private final Lazy danaProtectionRecommendationManager = LazyKt.lazy(new Function0<DanaProtectionRecommendationManager>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$danaProtectionRecommendationManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaProtectionRecommendationManager invoke() {
            return new DanaProtectionRecommendationManager();
        }
    });
    @Inject
    public GetDanaProtectionInfo getDanaProtectionInfo;
    @Inject
    public GetDanaProtectionRecommendation getDanaProtectionRecommendation;
    @Inject
    public GetDanaProtectionWidgetConfig getDanaProtectionWidgetConfig;
    private List<DanaProtectionRecommendationModel> recommendationData;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getDanaProtectionRecommendationManager")
    public final DanaProtectionRecommendationManager getDanaProtectionRecommendationManager() {
        return (DanaProtectionRecommendationManager) this.danaProtectionRecommendationManager.getValue();
    }

    @JvmName(name = "getGetDanaProtectionWidgetConfig")
    public final GetDanaProtectionWidgetConfig getGetDanaProtectionWidgetConfig() {
        GetDanaProtectionWidgetConfig getDanaProtectionWidgetConfig = this.getDanaProtectionWidgetConfig;
        if (getDanaProtectionWidgetConfig != null) {
            return getDanaProtectionWidgetConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetDanaProtectionWidgetConfig")
    public final void setGetDanaProtectionWidgetConfig(GetDanaProtectionWidgetConfig getDanaProtectionWidgetConfig) {
        Intrinsics.checkNotNullParameter(getDanaProtectionWidgetConfig, "");
        this.getDanaProtectionWidgetConfig = getDanaProtectionWidgetConfig;
    }

    @JvmName(name = "getGetDanaProtectionRecommendation")
    public final GetDanaProtectionRecommendation getGetDanaProtectionRecommendation() {
        GetDanaProtectionRecommendation getDanaProtectionRecommendation = this.getDanaProtectionRecommendation;
        if (getDanaProtectionRecommendation != null) {
            return getDanaProtectionRecommendation;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetDanaProtectionRecommendation")
    public final void setGetDanaProtectionRecommendation(GetDanaProtectionRecommendation getDanaProtectionRecommendation) {
        Intrinsics.checkNotNullParameter(getDanaProtectionRecommendation, "");
        this.getDanaProtectionRecommendation = getDanaProtectionRecommendation;
    }

    @JvmName(name = "getGetDanaProtectionInfo")
    public final GetDanaProtectionInfo getGetDanaProtectionInfo() {
        GetDanaProtectionInfo getDanaProtectionInfo = this.getDanaProtectionInfo;
        if (getDanaProtectionInfo != null) {
            return getDanaProtectionInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetDanaProtectionInfo")
    public final void setGetDanaProtectionInfo(GetDanaProtectionInfo getDanaProtectionInfo) {
        Intrinsics.checkNotNullParameter(getDanaProtectionInfo, "");
        this.getDanaProtectionInfo = getDanaProtectionInfo;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void danaProtection(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        if (Intrinsics.areEqual(eventName, DanaProtectionKey.EventName.GET_RECOMMENDATION)) {
            getRecommendationData();
        }
    }

    private final void getRecommendationData() {
        getGetDanaProtectionRecommendation().execute(new GetDanaProtectionRecommendation.Params("1.0.0", true), new Function1<List<DanaProtectionRecommendationModel>, Unit>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$getRecommendationData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<DanaProtectionRecommendationModel> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<DanaProtectionRecommendationModel> list) {
                Activity activity;
                Intrinsics.checkNotNullParameter(list, "");
                DanaProtectionBridge.this.getDanaProtectionRecommendationManager();
                activity = DanaProtectionBridge.this.activity;
                if (activity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    activity = null;
                }
                Intrinsics.checkNotNullParameter(activity, "");
                list.add(new DanaProtectionRecommendationModel("location_permission", DanaProtectionRecommendationManager.getAuthRequestContext(activity), null, 4, null));
                DanaProtectionBridge.this.recommendationData = list;
                DanaProtectionBridge.this.getDanaProtectionInfo();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$getRecommendationData$2
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
                BridgeCallback bridgeCallback;
                JSONObject assembleFailedResponse;
                Intrinsics.checkNotNullParameter(th, "");
                bridgeCallback = DanaProtectionBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                assembleFailedResponse = DanaProtectionBridge.this.assembleFailedResponse();
                bridgeCallback.sendJSONResponse(assembleFailedResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getDanaProtectionInfo() {
        getDanaProtectionWidgetConfig(new Function1<DanaProtectionWidgetConfig, Unit>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$getDanaProtectionInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DanaProtectionWidgetConfig danaProtectionWidgetConfig) {
                invoke2(danaProtectionWidgetConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DanaProtectionWidgetConfig danaProtectionWidgetConfig) {
                GetDanaProtectionInfo getDanaProtectionInfo = DanaProtectionBridge.this.getGetDanaProtectionInfo();
                Integer valueOf = Integer.valueOf(danaProtectionWidgetConfig != null ? danaProtectionWidgetConfig.getExpiredCacheTimeInMinute() : 0);
                final DanaProtectionBridge danaProtectionBridge = DanaProtectionBridge.this;
                Function1<DanaProtectionInfoModel, Unit> function1 = new Function1<DanaProtectionInfoModel, Unit>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$getDanaProtectionInfo$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(DanaProtectionInfoModel danaProtectionInfoModel) {
                        invoke2(danaProtectionInfoModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DanaProtectionInfoModel danaProtectionInfoModel) {
                        BridgeCallback bridgeCallback;
                        JSONObject assembleRecommendationResponse;
                        Intrinsics.checkNotNullParameter(danaProtectionInfoModel, "");
                        DanaProtectionBridge.this.danaProtectionInfoModel = danaProtectionInfoModel;
                        bridgeCallback = DanaProtectionBridge.this.bridgeCallback;
                        if (bridgeCallback == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            bridgeCallback = null;
                        }
                        assembleRecommendationResponse = DanaProtectionBridge.this.assembleRecommendationResponse();
                        bridgeCallback.sendJSONResponse(assembleRecommendationResponse);
                    }
                };
                final DanaProtectionBridge danaProtectionBridge2 = DanaProtectionBridge.this;
                getDanaProtectionInfo.execute(valueOf, function1, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$getDanaProtectionInfo$1.2
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
                        BridgeCallback bridgeCallback;
                        JSONObject assembleFailedResponse;
                        Intrinsics.checkNotNullParameter(th, "");
                        bridgeCallback = DanaProtectionBridge.this.bridgeCallback;
                        if (bridgeCallback == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            bridgeCallback = null;
                        }
                        assembleFailedResponse = DanaProtectionBridge.this.assembleFailedResponse();
                        bridgeCallback.sendJSONResponse(assembleFailedResponse);
                    }
                });
            }
        });
    }

    private final void getDanaProtectionWidgetConfig(final Function1<? super DanaProtectionWidgetConfig, Unit> callback) {
        getGetDanaProtectionWidgetConfig().execute(NoParams.INSTANCE, new Function1<DanaProtectionWidgetConfig, Unit>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$getDanaProtectionWidgetConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DanaProtectionWidgetConfig danaProtectionWidgetConfig) {
                invoke2(danaProtectionWidgetConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DanaProtectionWidgetConfig danaProtectionWidgetConfig) {
                callback.invoke(danaProtectionWidgetConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.danaprotection.DanaProtectionBridge$getDanaProtectionWidgetConfig$2
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
                BridgeCallback bridgeCallback;
                JSONObject assembleFailedResponse;
                Intrinsics.checkNotNullParameter(th, "");
                bridgeCallback = DanaProtectionBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                assembleFailedResponse = DanaProtectionBridge.this.assembleFailedResponse();
                bridgeCallback.sendJSONResponse(assembleFailedResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject assembleRecommendationResponse() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put(DanaProtectionKey.DanaProtectionResultParamsKey.RECOMMENDATION_DATA, (Object) this.recommendationData);
        DanaProtectionInfoModel danaProtectionInfoModel = this.danaProtectionInfoModel;
        Integer num = null;
        jSONObject.put(DanaProtectionKey.DanaProtectionResultParamsKey.SUSPICIOUS_ACTIVITY, (Object) (danaProtectionInfoModel != null ? Integer.valueOf(danaProtectionInfoModel.getSuspiciousActivity()) : null));
        DanaProtectionInfoModel danaProtectionInfoModel2 = this.danaProtectionInfoModel;
        jSONObject.put(DanaProtectionKey.DanaProtectionResultParamsKey.PROTECTED_ACTIVITY, (Object) (danaProtectionInfoModel2 != null ? Integer.valueOf(danaProtectionInfoModel2.getProtectedActivity()) : null));
        List<DanaProtectionRecommendationModel> list = this.recommendationData;
        if (list != null) {
            List<DanaProtectionRecommendationModel> list2 = list;
            int i = 0;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if ((!((DanaProtectionRecommendationModel) it.next()).getEnable()) != false && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            num = Integer.valueOf(i);
        }
        jSONObject.put(DanaProtectionKey.DanaProtectionResultParamsKey.RECOMMENDATION, (Object) num);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject assembleFailedResponse() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        return jSONObject;
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getGetDanaProtectionWidgetConfig().dispose();
        getGetDanaProtectionRecommendation().dispose();
        getGetDanaProtectionInfo().dispose();
    }
}
