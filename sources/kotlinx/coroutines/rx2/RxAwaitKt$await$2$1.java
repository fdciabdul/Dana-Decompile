package kotlinx.coroutines.rx2;

import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.huawei.hms.push.e;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlinx/coroutines/rx2/RxAwaitKt$await$2$1;", "Lio/reactivex/CompletableObserver;", "", "onComplete", "()V", "", e.PlaceComponentResult, RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/Throwable;)V", "Lio/reactivex/disposables/Disposable;", d.f7256a, "onSubscribe", "(Lio/reactivex/disposables/Disposable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RxAwaitKt$await$2$1 implements CompletableObserver {
    final /* synthetic */ CancellableContinuation<Unit> $cont;

    @Override // io.reactivex.CompletableObserver
    public final void onSubscribe(Disposable d) {
        RxAwaitKt.disposeOnCancellation(this.$cont, d);
    }

    @Override // io.reactivex.CompletableObserver
    public final void onComplete() {
        CancellableContinuation<Unit> cancellableContinuation = this.$cont;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3179constructorimpl(Unit.INSTANCE));
    }

    @Override // io.reactivex.CompletableObserver
    public final void onError(Throwable e) {
        CancellableContinuation<Unit> cancellableContinuation = this.$cont;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
    }
}
