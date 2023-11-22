package kotlinx.coroutines.rx2;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes9.dex */
public final /* synthetic */ class RxCompletableKt$$ExternalSyntheticLambda0 implements CompletableOnSubscribe {
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ CoroutineContext f$1;
    public final /* synthetic */ Function2 f$2;

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(CompletableEmitter completableEmitter) {
        RxCompletableKt.m4672rxCompletableInternal$lambda1(this.f$0, this.f$1, this.f$2, completableEmitter);
    }
}
