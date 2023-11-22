package id.dana.domain.investment.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b4\u00105J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJX\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\tJ \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\"\u0010#R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010'R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010$\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010'R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010'R$\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010,\u001a\u0004\b-\u0010\t\"\u0004\b.\u0010/R$\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010/R$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010,\u001a\u0004\b2\u0010\t\"\u0004\b3\u0010/"}, d2 = {"Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Long;", "component2", "component3", "", "component4", "()Ljava/lang/String;", "component5", "component6", "amount", "cent", "centFactor", FirebaseAnalytics.Param.CURRENCY, AppsFlyerProperties.CURRENCY_CODE, "currencyValue", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "getAmount", "setAmount", "(Ljava/lang/Long;)V", "getCent", "setCent", "getCentFactor", "setCentFactor", "Ljava/lang/String;", "getCurrency", "setCurrency", "(Ljava/lang/String;)V", "getCurrencyCode", "setCurrencyCode", "getCurrencyValue", "setCurrencyValue", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MultiCurrencyMoneyView implements Parcelable {
    public static final Parcelable.Creator<MultiCurrencyMoneyView> CREATOR = new Creator();
    private Long amount;
    private Long cent;
    private Long centFactor;
    private String currency;
    private String currencyCode;
    private String currencyValue;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<MultiCurrencyMoneyView> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MultiCurrencyMoneyView createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MultiCurrencyMoneyView(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MultiCurrencyMoneyView[] newArray(int i) {
            return new MultiCurrencyMoneyView[i];
        }
    }

    public MultiCurrencyMoneyView() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MultiCurrencyMoneyView copy$default(MultiCurrencyMoneyView multiCurrencyMoneyView, Long l, Long l2, Long l3, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = multiCurrencyMoneyView.amount;
        }
        if ((i & 2) != 0) {
            l2 = multiCurrencyMoneyView.cent;
        }
        Long l4 = l2;
        if ((i & 4) != 0) {
            l3 = multiCurrencyMoneyView.centFactor;
        }
        Long l5 = l3;
        if ((i & 8) != 0) {
            str = multiCurrencyMoneyView.currency;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = multiCurrencyMoneyView.currencyCode;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = multiCurrencyMoneyView.currencyValue;
        }
        return multiCurrencyMoneyView.copy(l, l4, l5, str4, str5, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final Long getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getCent() {
        return this.cent;
    }

    /* renamed from: component3  reason: from getter */
    public final Long getCentFactor() {
        return this.centFactor;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCurrencyValue() {
        return this.currencyValue;
    }

    public final MultiCurrencyMoneyView copy(Long amount, Long cent, Long centFactor, String currency, String currencyCode, String currencyValue) {
        return new MultiCurrencyMoneyView(amount, cent, centFactor, currency, currencyCode, currencyValue);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MultiCurrencyMoneyView) {
            MultiCurrencyMoneyView multiCurrencyMoneyView = (MultiCurrencyMoneyView) other;
            return Intrinsics.areEqual(this.amount, multiCurrencyMoneyView.amount) && Intrinsics.areEqual(this.cent, multiCurrencyMoneyView.cent) && Intrinsics.areEqual(this.centFactor, multiCurrencyMoneyView.centFactor) && Intrinsics.areEqual(this.currency, multiCurrencyMoneyView.currency) && Intrinsics.areEqual(this.currencyCode, multiCurrencyMoneyView.currencyCode) && Intrinsics.areEqual(this.currencyValue, multiCurrencyMoneyView.currencyValue);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.amount;
        int hashCode = l == null ? 0 : l.hashCode();
        Long l2 = this.cent;
        int hashCode2 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.centFactor;
        int hashCode3 = l3 == null ? 0 : l3.hashCode();
        String str = this.currency;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.currencyCode;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.currencyValue;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiCurrencyMoneyView(amount=");
        sb.append(this.amount);
        sb.append(", cent=");
        sb.append(this.cent);
        sb.append(", centFactor=");
        sb.append(this.centFactor);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(", currencyCode=");
        sb.append(this.currencyCode);
        sb.append(", currencyValue=");
        sb.append(this.currencyValue);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        Long l = this.amount;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        Long l2 = this.cent;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        Long l3 = this.centFactor;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeString(this.currency);
        parcel.writeString(this.currencyCode);
        parcel.writeString(this.currencyValue);
    }

    public MultiCurrencyMoneyView(Long l, Long l2, Long l3, String str, String str2, String str3) {
        this.amount = l;
        this.cent = l2;
        this.centFactor = l3;
        this.currency = str;
        this.currencyCode = str2;
        this.currencyValue = str3;
    }

    public /* synthetic */ MultiCurrencyMoneyView(Long l, Long l2, Long l3, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) == 0 ? l3 : null, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3);
    }

    @JvmName(name = "getAmount")
    public final Long getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(Long l) {
        this.amount = l;
    }

    @JvmName(name = "getCent")
    public final Long getCent() {
        return this.cent;
    }

    @JvmName(name = "setCent")
    public final void setCent(Long l) {
        this.cent = l;
    }

    @JvmName(name = "getCentFactor")
    public final Long getCentFactor() {
        return this.centFactor;
    }

    @JvmName(name = "setCentFactor")
    public final void setCentFactor(Long l) {
        this.centFactor = l;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "setCurrency")
    public final void setCurrency(String str) {
        this.currency = str;
    }

    @JvmName(name = "getCurrencyCode")
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    @JvmName(name = "setCurrencyCode")
    public final void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    @JvmName(name = "getCurrencyValue")
    public final String getCurrencyValue() {
        return this.currencyValue;
    }

    @JvmName(name = "setCurrencyValue")
    public final void setCurrencyValue(String str) {
        this.currencyValue = str;
    }
}
