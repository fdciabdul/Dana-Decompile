package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    private final AtomicReference<Subscription> PlaceComponentResult = new AtomicReference<>();
    private final ListCompositeDisposable MyBillsEntityDataFactory = new ListCompositeDisposable();
    private final AtomicLong BuiltInFictitiousFunctionClassFactory = new AtomicLong();
}
