package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public abstract class ResourceObserver<T> implements Observer<T>, Disposable {
    private final AtomicReference<Disposable> getAuthRequestContext = new AtomicReference<>();
    private final ListCompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2 = new ListCompositeDisposable();
}
