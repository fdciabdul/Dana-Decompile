package id.dana.data.paylater.repository.source;

import id.dana.data.paylater.repository.source.network.result.PaylaterHomeInfoResult;
import id.dana.network.base.ExceptionParser;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/paylater/repository/source/PaylaterHomeInfoExceptionParser;", "Lid/dana/network/base/ExceptionParser;", "Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;", "baseResult", "Lio/reactivex/Observable;", "apply", "(Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterHomeInfoExceptionParser extends ExceptionParser<PaylaterHomeInfoResult> {
    @Override // id.dana.network.base.ExceptionParser, io.reactivex.functions.Function
    public final Observable<PaylaterHomeInfoResult> apply(PaylaterHomeInfoResult baseResult) {
        Intrinsics.checkNotNullParameter(baseResult, "");
        if (!baseResult.success && baseResult.getAction() != null) {
            Observable<PaylaterHomeInfoResult> just = Observable.just(baseResult);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<PaylaterHomeInfoResult> apply = super.apply((PaylaterHomeInfoExceptionParser) baseResult);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        return apply;
    }
}
