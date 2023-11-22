package io.reactivex.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public abstract class ResourceSingleObserver<T> implements SingleObserver<T>, Disposable {
    private final AtomicReference<Disposable> PlaceComponentResult = new AtomicReference<>();
    private final ListCompositeDisposable MyBillsEntityDataFactory = new ListCompositeDisposable();
}
