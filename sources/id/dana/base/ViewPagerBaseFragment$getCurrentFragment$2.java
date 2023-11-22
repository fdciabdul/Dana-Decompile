package id.dana.base;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/base/BaseFragment;", "T", "", BridgeDSL.INVOKE, "(Lid/dana/base/BaseFragment;)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class ViewPagerBaseFragment$getCurrentFragment$2<T> extends Lambda implements Function1<T, Unit> {
    public static final ViewPagerBaseFragment$getCurrentFragment$2 INSTANCE = new ViewPagerBaseFragment$getCurrentFragment$2();

    public ViewPagerBaseFragment$getCurrentFragment$2() {
        super(1);
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public final void invoke(BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(baseFragment, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((BaseFragment) obj);
        return Unit.INSTANCE;
    }
}
