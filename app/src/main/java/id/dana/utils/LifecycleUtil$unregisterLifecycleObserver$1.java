package id.dana.utils;

import androidx.view.LifecycleObserver;
import androidx.view.ProcessLifecycleOwner;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class LifecycleUtil$unregisterLifecycleObserver$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LifecycleObserver $$observer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LifecycleUtil$unregisterLifecycleObserver$1(LifecycleObserver lifecycleObserver) {
        super(0);
        this.$$observer = lifecycleObserver;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this.$$observer);
    }
}
