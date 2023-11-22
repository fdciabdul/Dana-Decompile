package kotlinx.coroutines.rx2;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes9.dex */
public final /* synthetic */ class RxSingleKt$$ExternalSyntheticLambda0 implements SingleOnSubscribe {
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ CoroutineContext f$1;
    public final /* synthetic */ Function2 f$2;

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter singleEmitter) {
        RxSingleKt.m4679rxSingleInternal$lambda1(this.f$0, this.f$1, this.f$2, singleEmitter);
    }
}
