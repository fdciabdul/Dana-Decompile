package id.dana.cashier;

import id.dana.cashier.utils.CashierTimerType;
import id.dana.pay.model.PayResultEmoneyBannerListenerModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0007\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierEventListener;", "", "", "p0", "Lid/dana/pay/model/PayResultEmoneyBannerListenerModel;", "p1", "", "PlaceComponentResult", "(Ljava/lang/String;Lid/dana/pay/model/PayResultEmoneyBannerListenerModel;)V", "", "", "p2", "(Ljava/lang/String;JZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierEventListener {
    void PlaceComponentResult(@CashierTimerType String p0, long p1, boolean p2);

    void PlaceComponentResult(String p0, PayResultEmoneyBannerListenerModel p1);
}
