package id.dana.danah5.referralengagement;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/danah5/referralengagement/ShowReferralEngagementDialogBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "onInitialized", "()V", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", BridgeName.SHOW_REFERRAL_ENGAGEMENT_DIALOG, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", ShowReferralEngagementDialogBridge.SHOW_DIALOG_KEY, "", "source", "startReferralDialogWithTimer", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;ZLjava/lang/String;)V", "Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "saveReferralEngagementDialogCache", "Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "getSaveReferralEngagementDialogCache", "()Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "setSaveReferralEngagementDialogCache", "(Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShowReferralEngagementDialogBridge extends SimpleBridgeExtension {
    private static final String SHOW_DIALOG_KEY = "showDialog";
    private static final String SOURCE_KEY = "source";
    @Inject
    public SaveReferralEngagementDialogCache saveReferralEngagementDialogCache;

    @JvmName(name = "getSaveReferralEngagementDialogCache")
    public final SaveReferralEngagementDialogCache getSaveReferralEngagementDialogCache() {
        SaveReferralEngagementDialogCache saveReferralEngagementDialogCache = this.saveReferralEngagementDialogCache;
        if (saveReferralEngagementDialogCache != null) {
            return saveReferralEngagementDialogCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSaveReferralEngagementDialogCache")
    public final void setSaveReferralEngagementDialogCache(SaveReferralEngagementDialogCache saveReferralEngagementDialogCache) {
        Intrinsics.checkNotNullParameter(saveReferralEngagementDialogCache, "");
        this.saveReferralEngagementDialogCache = saveReferralEngagementDialogCache;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void showReferralEngagementDialog(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (info.containsKey(SHOW_DIALOG_KEY) && info.containsKey("source")) {
            Boolean bool = info.getBoolean(SHOW_DIALOG_KEY);
            Intrinsics.checkNotNullExpressionValue(bool, "");
            boolean booleanValue = bool.booleanValue();
            String string = info.getString("source");
            Intrinsics.checkNotNullExpressionValue(string, "");
            startReferralDialogWithTimer(bridgeCallback, booleanValue, string);
        }
    }

    public final void startReferralDialogWithTimer(final BridgeCallback bridgeCallback, boolean showDialog, String source) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(source, "");
        getSaveReferralEngagementDialogCache().execute(new SaveReferralEngagementDialogCache.Param(source, showDialog, System.currentTimeMillis() / 1000), new Function1<Boolean, Unit>() { // from class: id.dana.danah5.referralengagement.ShowReferralEngagementDialogBridge$startReferralDialogWithTimer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                BridgeCallback.this.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.referralengagement.ShowReferralEngagementDialogBridge$startReferralDialogWithTimer$2
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
                Intrinsics.checkNotNullParameter(th, "");
                BridgeCallback.this.sendBridgeResponse(BridgeResponse.newError(6, th.getMessage()));
            }
        });
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this);
    }
}
