package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/OrderCreateExtendInfo;", "", "Lid/dana/cashier/domain/model/TncUrl;", "tncUrl", "Lid/dana/cashier/domain/model/TncUrl;", "getTncUrl", "()Lid/dana/cashier/domain/model/TncUrl;", "<init>", "(Lid/dana/cashier/domain/model/TncUrl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OrderCreateExtendInfo {
    private final TncUrl tncUrl;

    public OrderCreateExtendInfo(TncUrl tncUrl) {
        this.tncUrl = tncUrl;
    }

    @JvmName(name = "getTncUrl")
    public final TncUrl getTncUrl() {
        return this.tncUrl;
    }
}
