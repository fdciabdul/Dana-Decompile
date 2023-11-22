package com.ipification.mobile.sdk.im.util;

import androidx.view.LifecycleOwner;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00018\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\b\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\f"}, d2 = {"Lcom/ipification/mobile/sdk/im/util/SingleLiveEvent;", "T", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LifecycleOwner;", "p0", "Landroidx/lifecycle/Observer;", "p1", "", "PlaceComponentResult", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V", "(Ljava/lang/Object;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "MyBillsEntityDataFactory", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SingleLiveEvent<T> extends MutableLiveData<T> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AtomicBoolean MyBillsEntityDataFactory = new AtomicBoolean(false);

    @Override // androidx.view.LiveData
    public final void PlaceComponentResult(LifecycleOwner p0, final Observer<? super T> p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        MyBillsEntityDataFactory();
        super.PlaceComponentResult(p0, new Observer() { // from class: com.ipification.mobile.sdk.im.util.SingleLiveEvent$$ExternalSyntheticLambda0
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                SingleLiveEvent.getAuthRequestContext(SingleLiveEvent.this, p1, obj);
            }
        });
    }

    @Override // androidx.view.MutableLiveData, androidx.view.LiveData
    public final void PlaceComponentResult(T p0) {
        this.MyBillsEntityDataFactory.set(true);
        super.PlaceComponentResult((SingleLiveEvent<T>) p0);
    }

    public static /* synthetic */ void getAuthRequestContext(SingleLiveEvent singleLiveEvent, Observer observer, Object obj) {
        Intrinsics.checkParameterIsNotNull(singleLiveEvent, "");
        Intrinsics.checkParameterIsNotNull(observer, "");
        if (singleLiveEvent.MyBillsEntityDataFactory.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }
}
