package id.dana.cashier.domain.model;

import com.appsflyer.AppsFlyerProperties;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JL\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/CashierCurrencyFromCdn;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "countryName", AppsFlyerProperties.CURRENCY_CODE, "currencyLabel", "currencySymbol", "currencySymbolString", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/CashierCurrencyFromCdn;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCountryName", "getCurrencyCode", "getCurrencyLabel", "getCurrencySymbol", "getCurrencySymbolString", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierCurrencyFromCdn {
    private final String countryName;
    private final String currencyCode;
    private final String currencyLabel;
    private final String currencySymbol;
    private final String currencySymbolString;

    public CashierCurrencyFromCdn() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CashierCurrencyFromCdn copy$default(CashierCurrencyFromCdn cashierCurrencyFromCdn, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierCurrencyFromCdn.countryName;
        }
        if ((i & 2) != 0) {
            str2 = cashierCurrencyFromCdn.currencyCode;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = cashierCurrencyFromCdn.currencyLabel;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = cashierCurrencyFromCdn.currencySymbol;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = cashierCurrencyFromCdn.currencySymbolString;
        }
        return cashierCurrencyFromCdn.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCurrencyLabel() {
        return this.currencyLabel;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCurrencySymbolString() {
        return this.currencySymbolString;
    }

    public final CashierCurrencyFromCdn copy(String countryName, String currencyCode, String currencyLabel, String currencySymbol, String currencySymbolString) {
        return new CashierCurrencyFromCdn(countryName, currencyCode, currencyLabel, currencySymbol, currencySymbolString);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierCurrencyFromCdn) {
            CashierCurrencyFromCdn cashierCurrencyFromCdn = (CashierCurrencyFromCdn) other;
            return Intrinsics.areEqual(this.countryName, cashierCurrencyFromCdn.countryName) && Intrinsics.areEqual(this.currencyCode, cashierCurrencyFromCdn.currencyCode) && Intrinsics.areEqual(this.currencyLabel, cashierCurrencyFromCdn.currencyLabel) && Intrinsics.areEqual(this.currencySymbol, cashierCurrencyFromCdn.currencySymbol) && Intrinsics.areEqual(this.currencySymbolString, cashierCurrencyFromCdn.currencySymbolString);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.countryName;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.currencyCode;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.currencyLabel;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.currencySymbol;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.currencySymbolString;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierCurrencyFromCdn(countryName=");
        sb.append(this.countryName);
        sb.append(", currencyCode=");
        sb.append(this.currencyCode);
        sb.append(", currencyLabel=");
        sb.append(this.currencyLabel);
        sb.append(", currencySymbol=");
        sb.append(this.currencySymbol);
        sb.append(", currencySymbolString=");
        sb.append(this.currencySymbolString);
        sb.append(')');
        return sb.toString();
    }

    public CashierCurrencyFromCdn(String str, String str2, String str3, String str4, String str5) {
        this.countryName = str;
        this.currencyCode = str2;
        this.currencyLabel = str3;
        this.currencySymbol = str4;
        this.currencySymbolString = str5;
    }

    public /* synthetic */ CashierCurrencyFromCdn(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    @JvmName(name = "getCountryName")
    public final String getCountryName() {
        return this.countryName;
    }

    @JvmName(name = "getCurrencyCode")
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    @JvmName(name = "getCurrencyLabel")
    public final String getCurrencyLabel() {
        return this.currencyLabel;
    }

    @JvmName(name = "getCurrencySymbol")
    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    @JvmName(name = "getCurrencySymbolString")
    public final String getCurrencySymbolString() {
        return this.currencySymbolString;
    }
}
