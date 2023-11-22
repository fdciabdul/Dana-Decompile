package kotlinx.coroutines.reactive;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final /* synthetic */ class PublishKt$$ExternalSyntheticLambda0 implements Publisher {
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ CoroutineContext f$1;
    public final /* synthetic */ Function2 f$2;
    public final /* synthetic */ Function2 f$3;

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber subscriber) {
        PublishKt.m4670publishInternal$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, subscriber);
    }
}
