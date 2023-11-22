package id.dana.sendmoney.model;

import id.dana.sendmoney.recipient.RecipientType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011"}, d2 = {"Lid/dana/sendmoney/model/CashierFeatureEnum;", "", "", "cashierFeature", "Ljava/lang/String;", "getCashierFeature", "()Ljava/lang/String;", "setCashierFeature", "(Ljava/lang/String;)V", "recipientType", "getRecipientType", "setRecipientType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "PHONE", "BANK", "CHAT", "EXTERNAL"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum CashierFeatureEnum {
    PHONE("send_money_phone", "contact"),
    BANK("send_money_bank", "bank"),
    CHAT("send_money_chat", "link"),
    EXTERNAL("send_money_external", RecipientType.OTC);

    private String cashierFeature;
    private String recipientType;

    CashierFeatureEnum(String str, String str2) {
        this.cashierFeature = str;
        this.recipientType = str2;
    }

    @JvmName(name = "getCashierFeature")
    public final String getCashierFeature() {
        return this.cashierFeature;
    }

    @JvmName(name = "getRecipientType")
    public final String getRecipientType() {
        return this.recipientType;
    }

    @JvmName(name = "setCashierFeature")
    public final void setCashierFeature(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cashierFeature = str;
    }

    @JvmName(name = "setRecipientType")
    public final void setRecipientType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.recipientType = str;
    }
}
