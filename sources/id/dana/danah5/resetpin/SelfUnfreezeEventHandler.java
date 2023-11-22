package id.dana.danah5.resetpin;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.core.os.BundleKt;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.model.ResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.GetTempRegistrationPhoneNumber;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J#\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J#\u0010\u0014\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010("}, d2 = {"Lid/dana/danah5/resetpin/SelfUnfreezeEventHandler;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "", "getConfig", "()V", "getLocalPhoneNumber", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "url", "", "handleSelfUnfreeze", "(Landroid/app/Activity;Ljava/lang/String;)Z", "injectComponent", "Lcom/alibaba/ariver/app/api/Page;", "page", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "onFinalized", "onInitialized", "onPageStarted", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)V", "Lid/dana/domain/featureconfig/model/ResetAndChangePinNativeEntryConfig;", "config", "Lid/dana/domain/featureconfig/model/ResetAndChangePinNativeEntryConfig;", "Lid/dana/domain/resetpin/interactor/GetResetAndChangePinNativeEntryConfig;", "getResetAndChangePinNativeEntryConfig", "Lid/dana/domain/resetpin/interactor/GetResetAndChangePinNativeEntryConfig;", "getGetResetAndChangePinNativeEntryConfig", "()Lid/dana/domain/resetpin/interactor/GetResetAndChangePinNativeEntryConfig;", "setGetResetAndChangePinNativeEntryConfig", "(Lid/dana/domain/resetpin/interactor/GetResetAndChangePinNativeEntryConfig;)V", "Lid/dana/domain/resetpin/interactor/GetTempRegistrationPhoneNumber;", "getTempRegistrationPhoneNumber", "Lid/dana/domain/resetpin/interactor/GetTempRegistrationPhoneNumber;", "getGetTempRegistrationPhoneNumber", "()Lid/dana/domain/resetpin/interactor/GetTempRegistrationPhoneNumber;", "setGetTempRegistrationPhoneNumber", "(Lid/dana/domain/resetpin/interactor/GetTempRegistrationPhoneNumber;)V", "phoneNumber", "Ljava/lang/String;", "selfUnfreezeDeeplink", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelfUnfreezeEventHandler extends UrlTransportEventHandler {
    private static final String DEFAULT_SELF_UNFREEZE_DEEPLINK = "self-unfreeze";
    private ResetAndChangePinNativeEntryConfig config;
    @Inject
    public GetResetAndChangePinNativeEntryConfig getResetAndChangePinNativeEntryConfig;
    @Inject
    public GetTempRegistrationPhoneNumber getTempRegistrationPhoneNumber;
    private String phoneNumber = "";
    private String selfUnfreezeDeeplink = "https://link.dana.id/self-unfreeze";

    @JvmName(name = "getGetResetAndChangePinNativeEntryConfig")
    public final GetResetAndChangePinNativeEntryConfig getGetResetAndChangePinNativeEntryConfig() {
        GetResetAndChangePinNativeEntryConfig getResetAndChangePinNativeEntryConfig = this.getResetAndChangePinNativeEntryConfig;
        if (getResetAndChangePinNativeEntryConfig != null) {
            return getResetAndChangePinNativeEntryConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetResetAndChangePinNativeEntryConfig")
    public final void setGetResetAndChangePinNativeEntryConfig(GetResetAndChangePinNativeEntryConfig getResetAndChangePinNativeEntryConfig) {
        Intrinsics.checkNotNullParameter(getResetAndChangePinNativeEntryConfig, "");
        this.getResetAndChangePinNativeEntryConfig = getResetAndChangePinNativeEntryConfig;
    }

    @JvmName(name = "getGetTempRegistrationPhoneNumber")
    public final GetTempRegistrationPhoneNumber getGetTempRegistrationPhoneNumber() {
        GetTempRegistrationPhoneNumber getTempRegistrationPhoneNumber = this.getTempRegistrationPhoneNumber;
        if (getTempRegistrationPhoneNumber != null) {
            return getTempRegistrationPhoneNumber;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetTempRegistrationPhoneNumber")
    public final void setGetTempRegistrationPhoneNumber(GetTempRegistrationPhoneNumber getTempRegistrationPhoneNumber) {
        Intrinsics.checkNotNullParameter(getTempRegistrationPhoneNumber, "");
        this.getTempRegistrationPhoneNumber = getTempRegistrationPhoneNumber;
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        injectComponent();
        getLocalPhoneNumber();
    }

    private final void getLocalPhoneNumber() {
        BaseUseCase.execute$default(getGetTempRegistrationPhoneNumber(), NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.danah5.resetpin.SelfUnfreezeEventHandler$getLocalPhoneNumber$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                SelfUnfreezeEventHandler.this.phoneNumber = str;
            }
        }, null, 4, null);
    }

    private final void getConfig() {
        getGetResetAndChangePinNativeEntryConfig().execute(NoParams.INSTANCE, new Function1<ResetAndChangePinNativeEntryConfig, Unit>() { // from class: id.dana.danah5.resetpin.SelfUnfreezeEventHandler$getConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig) {
                invoke2(resetAndChangePinNativeEntryConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig) {
                Intrinsics.checkNotNullParameter(resetAndChangePinNativeEntryConfig, "");
                SelfUnfreezeEventHandler.this.config = resetAndChangePinNativeEntryConfig;
                SelfUnfreezeEventHandler selfUnfreezeEventHandler = SelfUnfreezeEventHandler.this;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaUrl.DEEPLINK_URL);
                sb.append(resetAndChangePinNativeEntryConfig.getDeeplinkSelfUnfreeze());
                selfUnfreezeEventHandler.selfUnfreezeDeeplink = sb.toString();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.resetpin.SelfUnfreezeEventHandler$getConfig$2
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
                SelfUnfreezeEventHandler.this.config = new ResetAndChangePinNativeEntryConfig(false, false, false, false, null, 31, null);
            }
        });
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public final void onPageStarted(Page page, String url) {
        super.onPageStarted(page, url);
        if (this.config == null) {
            getConfig();
        }
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(Page page, String url) {
        Activity activity;
        if (page == null || (activity = BridgeExtensionExtKt.getActivity(page)) == null || url == null) {
            return false;
        }
        return handleSelfUnfreeze(activity, url);
    }

    private final boolean handleSelfUnfreeze(Activity activity, String url) {
        if (Intrinsics.areEqual(url, this.selfUnfreezeDeeplink)) {
            Intent intent = new Intent(activity, SelfUnfreezeActivity.class);
            intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_PHONE_NUMBER", this.phoneNumber)));
            activity.startActivity(intent);
            activity.finish();
            return true;
        }
        return false;
    }

    private final void injectComponent() {
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        ApplicationComponent applicationComponent = ((DanaApplication) applicationContext).getApplicationComponent();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getGetTempRegistrationPhoneNumber().dispose();
        getGetResetAndChangePinNativeEntryConfig().dispose();
    }
}
