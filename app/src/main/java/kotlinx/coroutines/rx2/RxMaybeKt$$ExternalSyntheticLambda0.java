package kotlinx.coroutines.rx2;

import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes9.dex */
public final /* synthetic */ class RxMaybeKt$$ExternalSyntheticLambda0 implements MaybeOnSubscribe {
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ CoroutineContext f$1;
    public final /* synthetic */ Function2 f$2;

    @Override // io.reactivex.MaybeOnSubscribe
    public final void subscribe(MaybeEmitter maybeEmitter) {
        RxMaybeKt.m4675rxMaybeInternal$lambda1(this.f$0, this.f$1, this.f$2, maybeEmitter);
    }
}
