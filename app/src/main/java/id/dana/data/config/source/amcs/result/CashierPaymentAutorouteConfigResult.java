package id.dana.data.config.source.amcs.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/config/source/amcs/result/CashierPaymentAutorouteConfigResult;", "", "", "cooldownPeriod", "I", "getCooldownPeriod", "()I", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CashierPaymentAutorouteConfigResult {
    public int cooldownPeriod;

    public /* synthetic */ CashierPaymentAutorouteConfigResult() {
    }

    public CashierPaymentAutorouteConfigResult(int i) {
        this.cooldownPeriod = i;
    }

    @JvmName(name = "getCooldownPeriod")
    public final int getCooldownPeriod() {
        return this.cooldownPeriod;
    }
}
