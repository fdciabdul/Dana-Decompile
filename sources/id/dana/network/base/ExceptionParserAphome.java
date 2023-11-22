package id.dana.network.base;

import id.dana.network.base.BaseRpcResultAphome;
import id.dana.network.exception.NetworkException;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public class ExceptionParserAphome<T extends BaseRpcResultAphome> implements Function<T, Observable<T>> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
        return apply((ExceptionParserAphome<T>) ((BaseRpcResultAphome) obj));
    }

    public Observable<T> apply(T t) {
        if (!t.success) {
            return Observable.error(new NetworkException((BaseRpcResultAphome) t));
        }
        return Observable.just(t);
    }
}
