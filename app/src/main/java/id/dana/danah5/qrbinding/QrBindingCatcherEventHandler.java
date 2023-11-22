package id.dana.danah5.qrbinding;

import android.app.Application;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.data.miniprogram.provider.DeeplinkServiceProvider;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.lib.gcontainer.app.bridge.core.GriverH5ActivityLifecycleCallbacks;
import id.dana.utils.UrlUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\u0012J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\fJ!\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0019\u0010\u0017\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\""}, d2 = {"Lid/dana/danah5/qrbinding/QrBindingCatcherEventHandler;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "", "url", "", "identifier", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "checkWhitelistUrl", "(Ljava/lang/String;Ljava/util/List;Lcom/alibaba/ariver/app/api/Page;)V", "getConfig", "(Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)V", "getFullUrl", "Ljava/net/URL;", "handleFullUrl", "(Ljava/net/URL;Lcom/alibaba/ariver/app/api/Page;)V", "initComponent", "()V", "", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "onInitialized", "onPageDestroy", "(Lcom/alibaba/ariver/app/api/Page;)V", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/domain/oauth/interactor/GetQrBindingConfig;", "getQrBindingConfig", "Lid/dana/domain/oauth/interactor/GetQrBindingConfig;", "getGetQrBindingConfig", "()Lid/dana/domain/oauth/interactor/GetQrBindingConfig;", "setGetQrBindingConfig", "(Lid/dana/domain/oauth/interactor/GetQrBindingConfig;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrBindingCatcherEventHandler extends UrlTransportEventHandler {
    private CompositeDisposable disposable = new CompositeDisposable();
    @Inject
    public GetQrBindingConfig getQrBindingConfig;

    @JvmName(name = "getGetQrBindingConfig")
    public final GetQrBindingConfig getGetQrBindingConfig() {
        GetQrBindingConfig getQrBindingConfig = this.getQrBindingConfig;
        if (getQrBindingConfig != null) {
            return getQrBindingConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetQrBindingConfig")
    public final void setGetQrBindingConfig(GetQrBindingConfig getQrBindingConfig) {
        Intrinsics.checkNotNullParameter(getQrBindingConfig, "");
        this.getQrBindingConfig = getQrBindingConfig;
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        initComponent();
    }

    private final void initComponent() {
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

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(Page page, String url) {
        if (url != null) {
            getConfig(url, page);
            return false;
        }
        return false;
    }

    private final void getConfig(final String url, final Page page) {
        BaseUseCase.execute$default(getGetQrBindingConfig(), NoParams.INSTANCE, new Function1<QrBindingConfig, Unit>() { // from class: id.dana.danah5.qrbinding.QrBindingCatcherEventHandler$getConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QrBindingConfig qrBindingConfig) {
                invoke2(qrBindingConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QrBindingConfig qrBindingConfig) {
                Intrinsics.checkNotNullParameter(qrBindingConfig, "");
                QrBindingCatcherEventHandler.this.checkWhitelistUrl(url, qrBindingConfig.getQrIdentifier(), page);
            }
        }, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkWhitelistUrl(String url, List<String> identifier, Page page) {
        Iterator<T> it = identifier.iterator();
        while (it.hasNext()) {
            try {
                if (Intrinsics.areEqual(new URL(url).getHost(), (String) it.next())) {
                    getFullUrl(url, page);
                }
            } catch (MalformedURLException unused) {
            }
        }
    }

    private final void getFullUrl(final String url, final Page page) {
        this.disposable.getAuthRequestContext(Observable.fromCallable(new Callable() { // from class: id.dana.danah5.qrbinding.QrBindingCatcherEventHandler$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                URL m713getFullUrl$lambda2;
                m713getFullUrl$lambda2 = QrBindingCatcherEventHandler.m713getFullUrl$lambda2(url);
                return m713getFullUrl$lambda2;
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.danah5.qrbinding.QrBindingCatcherEventHandler$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QrBindingCatcherEventHandler.m714getFullUrl$lambda4(QrBindingCatcherEventHandler.this, page, (URL) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFullUrl$lambda-2  reason: not valid java name */
    public static final URL m713getFullUrl$lambda2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return ExpandUrlUtil.INSTANCE.invoke(new URL(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFullUrl$lambda-4  reason: not valid java name */
    public static final void m714getFullUrl$lambda4(QrBindingCatcherEventHandler qrBindingCatcherEventHandler, Page page, URL url) {
        Intrinsics.checkNotNullParameter(qrBindingCatcherEventHandler, "");
        if (url != null) {
            qrBindingCatcherEventHandler.handleFullUrl(url, page);
        }
    }

    private final void handleFullUrl(URL url, Page page) {
        String obj = url.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        if (UrlUtil.getErrorConfigVersion(obj)) {
            EventBus.getDefault().post(new DeeplinkServiceProvider.OpenDeeplinkMessageEvent(obj));
            EventBus.getDefault().post(new GriverH5ActivityLifecycleCallbacks.FinishAllSessionsMessageEvent());
        }
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public final void onPageDestroy(Page page) {
        super.onPageDestroy(page);
        this.disposable.dispose();
    }
}
