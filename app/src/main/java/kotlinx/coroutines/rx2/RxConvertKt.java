package kotlinx.coroutines.rx2;

import com.ap.zoloz.hummer.biz.HummerConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "T", "Lio/reactivex/ObservableSource;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lio/reactivex/ObservableSource;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lio/reactivex/Observable;", "asObservable", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lio/reactivex/Observable;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RxConvertKt {
    public static final <T> Flow<T> asFlow(ObservableSource<T> observableSource) {
        return FlowKt.callbackFlow(new RxConvertKt$asFlow$1(observableSource, null));
    }

    public static final <T> Observable<T> asObservable(final Flow<? extends T> flow, final CoroutineContext coroutineContext) {
        return Observable.create(new ObservableOnSubscribe() { // from class: kotlinx.coroutines.rx2.RxConvertKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RxConvertKt.m4673asObservable$lambda0(CoroutineContext.this, flow, observableEmitter);
            }
        });
    }

    public static /* synthetic */ Observable asObservable$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }

    /* renamed from: asObservable$lambda-0 */
    public static final void m4673asObservable$lambda0(CoroutineContext coroutineContext, Flow flow, ObservableEmitter observableEmitter) {
        observableEmitter.setCancellable(new RxCancellable(BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), CoroutineStart.ATOMIC, new RxConvertKt$asObservable$1$job$1(flow, observableEmitter, null))));
    }
}
