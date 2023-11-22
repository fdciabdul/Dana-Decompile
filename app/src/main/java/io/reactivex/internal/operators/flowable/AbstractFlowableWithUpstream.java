package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;

/* loaded from: classes2.dex */
abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {
    protected final Flowable<T> BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractFlowableWithUpstream(Flowable<T> flowable) {
        this.BuiltInFictitiousFunctionClassFactory = (Flowable) ObjectHelper.PlaceComponentResult(flowable, "source is null");
    }
}
