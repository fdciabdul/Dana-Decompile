package id.dana.network.base;

import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.exception.TimeoutException;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.network.exception.NoInternetConnectionException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import j$.util.function.Function;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/network/base/ConnectionExceptionParser;", "T", "Lj$/util/function/Function;", "", "Lio/reactivex/ObservableSource;", SecurityConstants.KEY_TEXT, "apply", "(Ljava/lang/Throwable;)Lio/reactivex/ObservableSource;", "<init>", "()V"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class ConnectionExceptionParser<T> implements Function<Throwable, ObservableSource<T>> {
    @Override // j$.util.function.Function
    /* renamed from: andThen */
    public final /* synthetic */ Function mo3169andThen(Function function) {
        return Function.CC.getAuthRequestContext(this, function);
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // j$.util.function.Function
    public final ObservableSource<T> apply(Throwable t) {
        Observable error;
        Intrinsics.checkNotNullParameter(t, "");
        int i = 1;
        ?? r3 = 0;
        if (t instanceof SocketTimeoutException ? true : t instanceof UnknownHostException ? true : t instanceof TimeoutException) {
            Observable error2 = Observable.error(new NoInternetConnectionException(r3, i, r3));
            Intrinsics.checkNotNullExpressionValue(error2, "");
            return error2;
        } else if (t instanceof ClientException) {
            String message = t.getMessage();
            boolean z = false;
            if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) ConnectionExceptionParserKt.NETWORK_IS_NOT_AVAILABLE, false, 2, (Object) null)) {
                z = true;
            }
            if (z) {
                error = Observable.error(new NoInternetConnectionException(r3, i, r3));
            } else {
                error = Observable.error(t);
            }
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        } else {
            Observable error3 = Observable.error(t);
            Intrinsics.checkNotNullExpressionValue(error3, "");
            return error3;
        }
    }
}
