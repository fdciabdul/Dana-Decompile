package id.dana.cashier.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "<anonymous parameter 4>", "", BridgeDSL.INVOKE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class CashierAddOnView$onClickCashierAddOnInfo$1 extends Lambda implements Function5<String, String, String, Boolean, String, Unit> {
    public static final CashierAddOnView$onClickCashierAddOnInfo$1 INSTANCE = new CashierAddOnView$onClickCashierAddOnInfo$1();

    CashierAddOnView$onClickCashierAddOnInfo$1() {
        super(5);
    }

    public final void invoke(String str, String str2, String str3, boolean z, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
    }

    @Override // kotlin.jvm.functions.Function5
    public final /* synthetic */ Unit invoke(String str, String str2, String str3, Boolean bool, String str4) {
        invoke(str, str2, str3, bool.booleanValue(), str4);
        return Unit.INSTANCE;
    }
}
