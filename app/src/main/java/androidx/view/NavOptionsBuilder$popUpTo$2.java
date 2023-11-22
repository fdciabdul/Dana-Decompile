package androidx.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/PopUpToBuilder;", "", BridgeDSL.INVOKE, "(Landroidx/navigation/PopUpToBuilder;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
final class NavOptionsBuilder$popUpTo$2 extends Lambda implements Function1<PopUpToBuilder, Unit> {
    public static final NavOptionsBuilder$popUpTo$2 INSTANCE = new NavOptionsBuilder$popUpTo$2();

    NavOptionsBuilder$popUpTo$2() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
        invoke2(popUpToBuilder);
        return Unit.INSTANCE;
    }
}
