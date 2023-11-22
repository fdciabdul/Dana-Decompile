package id.dana.domain.expresspurchase.interaction.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/QuickBuyDeals;", "", "", "acquirementId", "Ljava/lang/String;", "getAcquirementId", "()Ljava/lang/String;", "setAcquirementId", "(Ljava/lang/String;)V", "Lid/dana/domain/expresspurchase/interaction/model/DealsPaymentResult;", "quickBuyStatus", "Lid/dana/domain/expresspurchase/interaction/model/DealsPaymentResult;", "getQuickBuyStatus", "()Lid/dana/domain/expresspurchase/interaction/model/DealsPaymentResult;", "setQuickBuyStatus", "(Lid/dana/domain/expresspurchase/interaction/model/DealsPaymentResult;)V", "<init>", "(Ljava/lang/String;Lid/dana/domain/expresspurchase/interaction/model/DealsPaymentResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuickBuyDeals {
    private String acquirementId;
    private DealsPaymentResult quickBuyStatus;

    public QuickBuyDeals(String str, DealsPaymentResult dealsPaymentResult) {
        this.acquirementId = str;
        this.quickBuyStatus = dealsPaymentResult;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    @JvmName(name = "setAcquirementId")
    public final void setAcquirementId(String str) {
        this.acquirementId = str;
    }

    public /* synthetic */ QuickBuyDeals(String str, DealsPaymentResult dealsPaymentResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? DealsPaymentResult.PAYMENT_INPROGRESS : dealsPaymentResult);
    }

    @JvmName(name = "getQuickBuyStatus")
    public final DealsPaymentResult getQuickBuyStatus() {
        return this.quickBuyStatus;
    }

    @JvmName(name = "setQuickBuyStatus")
    public final void setQuickBuyStatus(DealsPaymentResult dealsPaymentResult) {
        this.quickBuyStatus = dealsPaymentResult;
    }
}
