package id.dana.mybills.ui.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b"}, d2 = {"Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "", "Lid/dana/mybills/ui/model/MoneyViewModel;", "adminFee", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getAdminFee", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "setAdminFee", "(Lid/dana/mybills/ui/model/MoneyViewModel;)V", "baseAmount", "getBaseAmount", "setBaseAmount", "", "payMode", "Ljava/lang/String;", "getPayMode", "()Ljava/lang/String;", "setPayMode", "(Ljava/lang/String;)V", "subscriptionId", "getSubscriptionId", "setSubscriptionId", "transactionAmount", "getTransactionAmount", "setTransactionAmount", "<init>", "(Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Lid/dana/mybills/ui/model/MoneyViewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HighlightTransactionPayRequestModel {
    private MoneyViewModel adminFee;
    private MoneyViewModel baseAmount;
    private String payMode;
    private String subscriptionId;
    private MoneyViewModel transactionAmount;

    public HighlightTransactionPayRequestModel() {
        this(null, null, null, null, null, 31, null);
    }

    public HighlightTransactionPayRequestModel(String str, MoneyViewModel moneyViewModel, String str2, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.subscriptionId = str;
        this.transactionAmount = moneyViewModel;
        this.payMode = str2;
        this.adminFee = moneyViewModel2;
        this.baseAmount = moneyViewModel3;
    }

    public /* synthetic */ HighlightTransactionPayRequestModel(String str, MoneyViewModel moneyViewModel, String str2, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : moneyViewModel, (i & 4) != 0 ? "DIRECT" : str2, (i & 8) != 0 ? null : moneyViewModel2, (i & 16) == 0 ? moneyViewModel3 : null);
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "setSubscriptionId")
    public final void setSubscriptionId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.subscriptionId = str;
    }

    @JvmName(name = "getTransactionAmount")
    public final MoneyViewModel getTransactionAmount() {
        return this.transactionAmount;
    }

    @JvmName(name = "setTransactionAmount")
    public final void setTransactionAmount(MoneyViewModel moneyViewModel) {
        this.transactionAmount = moneyViewModel;
    }

    @JvmName(name = "getPayMode")
    public final String getPayMode() {
        return this.payMode;
    }

    @JvmName(name = "setPayMode")
    public final void setPayMode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.payMode = str;
    }

    @JvmName(name = "getAdminFee")
    public final MoneyViewModel getAdminFee() {
        return this.adminFee;
    }

    @JvmName(name = "setAdminFee")
    public final void setAdminFee(MoneyViewModel moneyViewModel) {
        this.adminFee = moneyViewModel;
    }

    @JvmName(name = "getBaseAmount")
    public final MoneyViewModel getBaseAmount() {
        return this.baseAmount;
    }

    @JvmName(name = "setBaseAmount")
    public final void setBaseAmount(MoneyViewModel moneyViewModel) {
        this.baseAmount = moneyViewModel;
    }
}
