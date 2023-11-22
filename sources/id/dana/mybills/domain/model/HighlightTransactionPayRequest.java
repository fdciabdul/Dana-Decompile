package id.dana.mybills.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006"}, d2 = {"Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "adminFee", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAdminFee", "()Lid/dana/domain/nearbyme/model/MoneyView;", "baseAmount", "getBaseAmount", "", "payMode", "Ljava/lang/String;", "getPayMode", "()Ljava/lang/String;", "subscriptionId", "getSubscriptionId", "transactionAmount", "getTransactionAmount", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightTransactionPayRequest {
    private final MoneyView adminFee;
    private final MoneyView baseAmount;
    private final String payMode;
    private final String subscriptionId;
    private final MoneyView transactionAmount;

    public HighlightTransactionPayRequest(String str, MoneyView moneyView, String str2, MoneyView moneyView2, MoneyView moneyView3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.subscriptionId = str;
        this.transactionAmount = moneyView;
        this.payMode = str2;
        this.adminFee = moneyView2;
        this.baseAmount = moneyView3;
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getTransactionAmount")
    public final MoneyView getTransactionAmount() {
        return this.transactionAmount;
    }

    @JvmName(name = "getPayMode")
    public final String getPayMode() {
        return this.payMode;
    }

    @JvmName(name = "getAdminFee")
    public final MoneyView getAdminFee() {
        return this.adminFee;
    }

    @JvmName(name = "getBaseAmount")
    public final MoneyView getBaseAmount() {
        return this.baseAmount;
    }
}
