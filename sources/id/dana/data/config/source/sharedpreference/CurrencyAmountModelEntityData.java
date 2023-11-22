package id.dana.data.config.source.sharedpreference;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/config/source/sharedpreference/CurrencyAmountModelEntityData;", "", "", "amount", "Ljava/lang/String;", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", FirebaseAnalytics.Param.CURRENCY, "getCurrency", "", "placeholder", "Ljava/lang/Boolean;", "getPlaceholder", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CurrencyAmountModelEntityData {
    private String amount;
    private final String currency;
    private final Boolean placeholder;

    public CurrencyAmountModelEntityData() {
        this(null, null, null, 7, null);
    }

    public CurrencyAmountModelEntityData(String str, String str2, Boolean bool) {
        this.amount = str;
        this.currency = str2;
        this.placeholder = bool;
    }

    public /* synthetic */ CurrencyAmountModelEntityData(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool);
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(String str) {
        this.amount = str;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "getPlaceholder")
    public final Boolean getPlaceholder() {
        return this.placeholder;
    }
}
