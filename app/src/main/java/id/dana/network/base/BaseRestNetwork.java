package id.dana.network.base;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\u000e\b\u0002\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ_\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\u000e\b\u0002\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0014¢\u0006\u0004\b\u000b\u0010\u000f"}, d2 = {"Lid/dana/network/base/BaseRestNetwork;", "A", "", "Lid/dana/network/base/BaseRpcResultAphome;", "R", "Lid/dana/network/base/BaseResultResponse;", "T", "realApi", "Lkotlin/Function1;", "Lio/reactivex/Observable;", "apiProcessor", "wrapper", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "Lid/dana/network/base/ExceptionParserAphome;", "exceptionParser", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lid/dana/network/base/ExceptionParserAphome;)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseRestNetwork<A> {
    /* JADX INFO: Access modifiers changed from: protected */
    public <R extends BaseRpcResultAphome, T extends BaseResultResponse<R>> Observable<R> wrapper(A realApi, Function1<? super A, ? extends Observable<T>> apiProcessor) {
        Intrinsics.checkNotNullParameter(apiProcessor, "");
        return wrapper(realApi, apiProcessor, new ExceptionParserAphome<>());
    }

    protected <R extends BaseRpcResultAphome, T extends BaseResultResponse<R>> Observable<R> wrapper(A realApi, Function1<? super A, ? extends Observable<T>> apiProcessor, ExceptionParserAphome<R> exceptionParser) {
        Intrinsics.checkNotNullParameter(apiProcessor, "");
        Intrinsics.checkNotNullParameter(exceptionParser, "");
        Observable<R> flatMap = apiProcessor.invoke(realApi).map(new Function() { // from class: id.dana.network.base.BaseRestNetwork$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BaseRpcResultAphome m2752wrapper$lambda0;
                m2752wrapper$lambda0 = BaseRestNetwork.m2752wrapper$lambda0((BaseResultResponse) obj);
                return m2752wrapper$lambda0;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wrapper$lambda-0  reason: not valid java name */
    public static final BaseRpcResultAphome m2752wrapper$lambda0(BaseResultResponse baseResultResponse) {
        Intrinsics.checkNotNullParameter(baseResultResponse, "");
        return (BaseRpcResultAphome) baseResultResponse.getResult();
    }
}
