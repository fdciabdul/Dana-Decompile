package id.dana.danah5.bca;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.animation.HomeTabActivity;
import id.dana.danah5.DanaH5;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.webviewinterceptor.interactor.GetListWebviewInterceptorDataConfig;
import id.dana.domain.webviewinterceptor.model.WebviewInterceptorData;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b/\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u0012J!\u0010\u001b\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-"}, d2 = {"Lid/dana/danah5/bca/BcaWebviewEventHandler;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "", "url", "", "bcaObaRegistration", "(Ljava/lang/String;)Z", "bcaObaRegistrationSuccess", "bcaOneKlikBindFailed", "()Z", "Lcom/alibaba/ariver/app/api/Page;", "page", "Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;", "data", "bcaOneKlikBindSuccess", "(Lcom/alibaba/ariver/app/api/Page;Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;)Z", "", "getDataConfig", "()V", "interceptorData", "handleRedirectIntercept", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;)Z", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "onFinalized", "onInitialized", "redirectToHome", "redirectToPlayStore", "(Lcom/alibaba/ariver/app/api/Page;Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;)V", "Lid/dana/domain/webviewinterceptor/interactor/GetListWebviewInterceptorDataConfig;", "getListWebviewInterceptorDataConfig", "Lid/dana/domain/webviewinterceptor/interactor/GetListWebviewInterceptorDataConfig;", "getGetListWebviewInterceptorDataConfig", "()Lid/dana/domain/webviewinterceptor/interactor/GetListWebviewInterceptorDataConfig;", "setGetListWebviewInterceptorDataConfig", "(Lid/dana/domain/webviewinterceptor/interactor/GetListWebviewInterceptorDataConfig;)V", "", "listInterceptorData$delegate", "Lkotlin/Lazy;", "getListInterceptorData", "()Ljava/util/List;", "listInterceptorData", "Lid/dana/danah5/bca/ObaBcaWebview;", "obaBcaWebview$delegate", "getObaBcaWebview", "()Lid/dana/danah5/bca/ObaBcaWebview;", "obaBcaWebview", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BcaWebviewEventHandler extends UrlTransportEventHandler {
    public static final long HANDLER_DELAY = 500;
    @Inject
    public GetListWebviewInterceptorDataConfig getListWebviewInterceptorDataConfig;

    /* renamed from: listInterceptorData$delegate  reason: from kotlin metadata */
    private final Lazy listInterceptorData = LazyKt.lazy(new Function0<List<WebviewInterceptorData>>() { // from class: id.dana.danah5.bca.BcaWebviewEventHandler$listInterceptorData$2
        @Override // kotlin.jvm.functions.Function0
        public final List<WebviewInterceptorData> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: obaBcaWebview$delegate  reason: from kotlin metadata */
    private final Lazy obaBcaWebview = LazyKt.lazy(new Function0<ObaBcaWebview>() { // from class: id.dana.danah5.bca.BcaWebviewEventHandler$obaBcaWebview$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ObaBcaWebview invoke() {
            return new ObaBcaWebview(null, null, null, 7, null);
        }
    });

    @JvmName(name = "getGetListWebviewInterceptorDataConfig")
    public final GetListWebviewInterceptorDataConfig getGetListWebviewInterceptorDataConfig() {
        GetListWebviewInterceptorDataConfig getListWebviewInterceptorDataConfig = this.getListWebviewInterceptorDataConfig;
        if (getListWebviewInterceptorDataConfig != null) {
            return getListWebviewInterceptorDataConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetListWebviewInterceptorDataConfig")
    public final void setGetListWebviewInterceptorDataConfig(GetListWebviewInterceptorDataConfig getListWebviewInterceptorDataConfig) {
        Intrinsics.checkNotNullParameter(getListWebviewInterceptorDataConfig, "");
        this.getListWebviewInterceptorDataConfig = getListWebviewInterceptorDataConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getListInterceptorData")
    public final List<WebviewInterceptorData> getListInterceptorData() {
        return (List) this.listInterceptorData.getValue();
    }

    @JvmName(name = "getObaBcaWebview")
    private final ObaBcaWebview getObaBcaWebview() {
        return (ObaBcaWebview) this.obaBcaWebview.getValue();
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
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
        getDataConfig();
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(final Page page, final String url) {
        if (url != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.danah5.bca.BcaWebviewEventHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BcaWebviewEventHandler.m632interceptUrl$lambda2$lambda1(BcaWebviewEventHandler.this, url, page);
                }
            }, 500L);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: interceptUrl$lambda-2$lambda-1  reason: not valid java name */
    public static final void m632interceptUrl$lambda2$lambda1(BcaWebviewEventHandler bcaWebviewEventHandler, String str, Page page) {
        Intrinsics.checkNotNullParameter(bcaWebviewEventHandler, "");
        for (WebviewInterceptorData webviewInterceptorData : bcaWebviewEventHandler.getListInterceptorData()) {
            if (StringsKt.startsWith$default(str, webviewInterceptorData.getUrl(), false, 2, (Object) null)) {
                bcaWebviewEventHandler.handleRedirectIntercept(page, str, webviewInterceptorData);
            }
        }
    }

    private final boolean handleRedirectIntercept(Page page, String url, WebviewInterceptorData interceptorData) {
        String key = interceptorData.getKey();
        switch (key.hashCode()) {
            case -776518728:
                if (key.equals("BCA_OPENING_BANK_ACCOUNT_REGISTRATION_URL")) {
                    return bcaObaRegistration(url);
                }
                break;
            case 59871531:
                if (key.equals("BCA_ONE_KLIK_BIND_FAILED_URL")) {
                    return bcaOneKlikBindFailed();
                }
                break;
            case 208240597:
                if (key.equals("BCA_ONE_KLIK_BIND_SUCCESS_URL")) {
                    return bcaOneKlikBindSuccess(page, interceptorData);
                }
                break;
            case 637279324:
                if (key.equals("BCA_OPENING_BANK_ACCOUNT_REGISTRATION_SUCCESS_URL")) {
                    return bcaObaRegistrationSuccess(url);
                }
                break;
        }
        return false;
    }

    private final boolean bcaOneKlikBindSuccess(Page page, WebviewInterceptorData data) {
        DanaH5.closeAllContainers();
        redirectToHome();
        redirectToPlayStore(page, data);
        return true;
    }

    private final boolean bcaOneKlikBindFailed() {
        DanaH5.closeAllContainers();
        redirectToHome();
        return true;
    }

    private final boolean bcaObaRegistration(String url) {
        getObaBcaWebview().parseBcaObaRegistraion(url);
        return true;
    }

    private final boolean bcaObaRegistrationSuccess(String url) {
        getObaBcaWebview().parseBcaObaRegistrationSuccess(url);
        DanaH5.closeAllContainers();
        DanaH5.startContainerFullUrl(getObaBcaWebview().constructBcaUrl());
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
    private final void redirectToHome() {
        ?? r2 = 0;
        EventBus.getDefault().post(new HomeTabActivity.FinishSubActivitiesMessageEvent(r2, 1, r2));
    }

    private final void redirectToPlayStore(Page page, WebviewInterceptorData data) {
        Activity activity;
        if (page == null || (activity = BridgeExtensionExtKt.getActivity(page)) == null) {
            return;
        }
        ContentExtKt.startActivitySafely(activity, new Intent("android.intent.action.VIEW", Uri.parse(data.getRedirectUrlAndroid())));
    }

    private final void getDataConfig() {
        getGetListWebviewInterceptorDataConfig().execute(NoParams.INSTANCE, new Function1<List<? extends WebviewInterceptorData>, Unit>() { // from class: id.dana.danah5.bca.BcaWebviewEventHandler$getDataConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends WebviewInterceptorData> list) {
                invoke2((List<WebviewInterceptorData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<WebviewInterceptorData> list) {
                List listInterceptorData;
                List listInterceptorData2;
                Intrinsics.checkNotNullParameter(list, "");
                listInterceptorData = BcaWebviewEventHandler.this.getListInterceptorData();
                listInterceptorData.clear();
                listInterceptorData2 = BcaWebviewEventHandler.this.getListInterceptorData();
                listInterceptorData2.addAll(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.bca.BcaWebviewEventHandler$getDataConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.BCA_WEBVIEW_INTERCEPT, th.toString());
            }
        });
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        getGetListWebviewInterceptorDataConfig().dispose();
    }
}
