package androidx.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\n\u0010\u0001\u001a\u0006*\u00028\u00008\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "p0", "", "onChanged", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes6.dex */
public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer {
    final /* synthetic */ Function1<T, Unit> $PlaceComponentResult;

    @Override // androidx.view.Observer
    public final void onChanged(T t) {
        this.$PlaceComponentResult.invoke(t);
    }
}
