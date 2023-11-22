package id.dana.sendmoney.summary.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", BridgeDSL.INVOKE, "()Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SummaryView$sendMoneyFeatureTime$2 extends Lambda implements Function0<SendMoneyFeatureTime> {
    public static final SummaryView$sendMoneyFeatureTime$2 INSTANCE = new SummaryView$sendMoneyFeatureTime$2();

    SummaryView$sendMoneyFeatureTime$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SendMoneyFeatureTime invoke() {
        return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
    }
}
