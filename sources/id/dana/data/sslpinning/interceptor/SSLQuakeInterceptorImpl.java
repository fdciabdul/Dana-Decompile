package id.dana.data.sslpinning.interceptor;

import com.alipay.imobile.network.quake.exception.ServerException;
import id.dana.data.sslpinning.SSLQuakeInterceptor;
import id.dana.domain.sslpinning.SSLPinningRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/sslpinning/interceptor/SSLQuakeInterceptorImpl;", "Lid/dana/data/sslpinning/SSLQuakeInterceptor;", "T", "Lio/reactivex/Observable;", "observable", "sslWatchRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "", "sslErrorMessage", "Ljava/lang/String;", "Lid/dana/domain/sslpinning/SSLPinningRepository;", "sslPinningRepository", "Lid/dana/domain/sslpinning/SSLPinningRepository;", "getSslPinningRepository", "()Lid/dana/domain/sslpinning/SSLPinningRepository;", "<init>", "(Lid/dana/domain/sslpinning/SSLPinningRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SSLQuakeInterceptorImpl implements SSLQuakeInterceptor {
    private final String sslErrorMessage;
    private final SSLPinningRepository sslPinningRepository;

    @Inject
    public SSLQuakeInterceptorImpl(SSLPinningRepository sSLPinningRepository) {
        Intrinsics.checkNotNullParameter(sSLPinningRepository, "");
        this.sslPinningRepository = sSLPinningRepository;
        this.sslErrorMessage = "Certificate pinning failure";
    }

    @JvmName(name = "getSslPinningRepository")
    public final SSLPinningRepository getSslPinningRepository() {
        return this.sslPinningRepository;
    }

    @Override // id.dana.data.sslpinning.SSLQuakeInterceptor
    public final <T> Observable<T> sslWatchRequest(final Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> onErrorResumeNext = observable.onErrorResumeNext(new Function() { // from class: id.dana.data.sslpinning.interceptor.SSLQuakeInterceptorImpl$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable m2049sslWatchRequest$lambda1;
                m2049sslWatchRequest$lambda1 = SSLQuakeInterceptorImpl.m2049sslWatchRequest$lambda1(SSLQuakeInterceptorImpl.this, observable, (Throwable) obj);
                return m2049sslWatchRequest$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sslWatchRequest$lambda-1  reason: not valid java name */
    public static final Observable m2049sslWatchRequest$lambda1(SSLQuakeInterceptorImpl sSLQuakeInterceptorImpl, final Observable observable, Throwable th) {
        Intrinsics.checkNotNullParameter(sSLQuakeInterceptorImpl, "");
        Intrinsics.checkNotNullParameter(observable, "");
        Intrinsics.checkNotNullParameter(th, "");
        ServerException serverException = th instanceof ServerException ? (ServerException) th : null;
        if (serverException != null) {
            String msg = serverException.getMsg();
            Intrinsics.checkNotNullExpressionValue(msg, "");
            if (StringsKt.contains$default((CharSequence) msg, (CharSequence) sSLQuakeInterceptorImpl.sslErrorMessage, false, 2, (Object) null)) {
                return sSLQuakeInterceptorImpl.sslPinningRepository.pinCertificateRemote().concatMap(new Function() { // from class: id.dana.data.sslpinning.interceptor.SSLQuakeInterceptorImpl$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        ObservableSource m2050sslWatchRequest$lambda1$lambda0;
                        m2050sslWatchRequest$lambda1$lambda0 = SSLQuakeInterceptorImpl.m2050sslWatchRequest$lambda1$lambda0(Observable.this, (Boolean) obj);
                        return m2050sslWatchRequest$lambda1$lambda0;
                    }
                });
            }
        }
        return Observable.error(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sslWatchRequest$lambda-1$lambda-0  reason: not valid java name */
    public static final ObservableSource m2050sslWatchRequest$lambda1$lambda0(Observable observable, Boolean bool) {
        Intrinsics.checkNotNullParameter(observable, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return observable;
    }
}
