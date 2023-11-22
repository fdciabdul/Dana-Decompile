package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes9.dex */
public final /* synthetic */ class RxObservableKt$$ExternalSyntheticLambda0 implements ObservableOnSubscribe {
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ CoroutineContext f$1;
    public final /* synthetic */ Function2 f$2;

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter observableEmitter) {
        RxObservableKt.m4676rxObservableInternal$lambda1(this.f$0, this.f$1, this.f$2, observableEmitter);
    }
}
