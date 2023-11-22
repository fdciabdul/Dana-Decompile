package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

/* loaded from: classes2.dex */
abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
    protected final ObservableSource<T> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.getAuthRequestContext = observableSource;
    }
}
