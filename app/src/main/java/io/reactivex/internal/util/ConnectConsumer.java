package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* loaded from: classes9.dex */
public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable PlaceComponentResult;

    @Override // io.reactivex.functions.Consumer
    public final /* bridge */ /* synthetic */ void accept(Disposable disposable) throws Exception {
        this.PlaceComponentResult = disposable;
    }
}
