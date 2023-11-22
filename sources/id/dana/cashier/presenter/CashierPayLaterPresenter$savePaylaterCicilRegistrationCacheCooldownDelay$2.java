package id.dana.cashier.presenter;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$2 INSTANCE = new CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$2();

    CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        StringBuilder sb = new StringBuilder();
        sb.append("[CashierSavePaylaterCicilRegistrationCacheCooldownDelay]: cashier_native_fail");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
    }
}
