package id.dana.cashier.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Ljava/lang/String;Z)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DailyLimitCashierView$inputDailyLimitListener$1 extends Lambda implements Function2<String, Boolean, Unit> {
    public static final DailyLimitCashierView$inputDailyLimitListener$1 INSTANCE = new DailyLimitCashierView$inputDailyLimitListener$1();

    DailyLimitCashierView$inputDailyLimitListener$1() {
        super(2);
    }

    public final void invoke(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Unit invoke(String str, Boolean bool) {
        invoke(str, bool.booleanValue());
        return Unit.INSTANCE;
    }
}
