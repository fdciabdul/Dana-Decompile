package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public abstract class ResourceCompletableObserver implements CompletableObserver, Disposable {
    private final AtomicReference<Disposable> MyBillsEntityDataFactory = new AtomicReference<>();
    private final ListCompositeDisposable PlaceComponentResult = new ListCompositeDisposable();
}
