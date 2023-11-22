package id.dana.onboarding.splash;

import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.domain.DefaultObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/onboarding/splash/SslPinningHelper$startSslPinning$1;", "Lid/dana/domain/DefaultObserver;", "", "", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SslPinningHelper$startSslPinning$1 extends DefaultObserver<Boolean> {
    SslPinningHelper$startSslPinning$1() {
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            return;
        }
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        SslPinningException sslPinningException = new SslPinningException(new Exception("SSL Pinning unsuccessful"));
        Intrinsics.checkNotNullParameter(sslPinningException, "");
        authRequestContext.getAuthRequestContext.recordException(sslPinningException);
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final void onError(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onError(p0);
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        SslPinningException sslPinningException = new SslPinningException(new Exception(p0));
        Intrinsics.checkNotNullParameter(sslPinningException, "");
        authRequestContext.getAuthRequestContext.recordException(sslPinningException);
    }
}
