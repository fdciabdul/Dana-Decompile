package id.dana.core.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.core.ui.util.NumberUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000eJ\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b(\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b)\u0010\u0004"}, d2 = {"Lid/dana/core/ui/model/MoneyViewModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "amount", FirebaseAnalytics.Param.CURRENCY, AppsFlyerProperties.CURRENCY_CODE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/core/ui/model/MoneyViewModel;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "getAmountLong", "()J", "getCleanAmount", "getDisplayAmount", "hashCode", "maxTargetAmount", "isLessThan", "(Lid/dana/core/ui/model/MoneyViewModel;)Z", "(J)Z", "isMoreThan", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAmount", "getCurrency", "getCurrencyCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MoneyViewModel implements Parcelable {
    private final String amount;
    private final String currency;
    private final String currencyCode;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MoneyViewModel> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<MoneyViewModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MoneyViewModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MoneyViewModel(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MoneyViewModel[] newArray(int i) {
            return new MoneyViewModel[i];
        }
    }

    public MoneyViewModel() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MoneyViewModel copy$default(MoneyViewModel moneyViewModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = moneyViewModel.amount;
        }
        if ((i & 2) != 0) {
            str2 = moneyViewModel.currency;
        }
        if ((i & 4) != 0) {
            str3 = moneyViewModel.currencyCode;
        }
        return moneyViewModel.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final MoneyViewModel copy(String amount, String currency, String currencyCode) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(currency, "");
        Intrinsics.checkNotNullParameter(currencyCode, "");
        return new MoneyViewModel(amount, currency, currencyCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MoneyViewModel) {
            MoneyViewModel moneyViewModel = (MoneyViewModel) other;
            return Intrinsics.areEqual(this.amount, moneyViewModel.amount) && Intrinsics.areEqual(this.currency, moneyViewModel.currency) && Intrinsics.areEqual(this.currencyCode, moneyViewModel.currencyCode);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.amount.hashCode() * 31) + this.currency.hashCode()) * 31) + this.currencyCode.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MoneyViewModel(amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(", currencyCode=");
        sb.append(this.currencyCode);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.amount);
        parcel.writeString(this.currency);
        parcel.writeString(this.currencyCode);
    }

    public MoneyViewModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.amount = str;
        this.currency = str2;
        this.currencyCode = str3;
    }

    public /* synthetic */ MoneyViewModel(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "getCurrencyCode")
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getDisplayAmount() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.currency);
        sb.append(this.amount);
        return sb.toString();
    }

    public final String getCleanAmount() {
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String str = this.amount;
        Intrinsics.checkNotNullParameter(str, "");
        String KClassImpl$Data$declaredNonStaticMembers$2 = NumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(NumberUtil.PlaceComponentResult(str));
        return KClassImpl$Data$declaredNonStaticMembers$2 == null ? "0" : KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final long getAmountLong() {
        Long longOrNull = StringsKt.toLongOrNull(getCleanAmount());
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final boolean isMoreThan(MoneyViewModel maxTargetAmount) {
        Intrinsics.checkNotNullParameter(maxTargetAmount, "");
        return getAmountLong() > maxTargetAmount.getAmountLong();
    }

    public final boolean isLessThan(MoneyViewModel maxTargetAmount) {
        Intrinsics.checkNotNullParameter(maxTargetAmount, "");
        return getAmountLong() < maxTargetAmount.getAmountLong();
    }

    public final boolean isLessThan(long maxTargetAmount) {
        return getAmountLong() < maxTargetAmount;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0002*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/core/ui/model/MoneyViewModel$Companion;", "", "Lid/dana/core/ui/model/CurrencyAmountModel;", "currencyAmountModel", "Lid/dana/core/ui/model/MoneyViewModel;", "fromCurrencyAmountModel", "(Lid/dana/core/ui/model/CurrencyAmountModel;)Lid/dana/core/ui/model/MoneyViewModel;", "toCurrencyAmountModel", "(Lid/dana/core/ui/model/MoneyViewModel;)Lid/dana/core/ui/model/CurrencyAmountModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MoneyViewModel fromCurrencyAmountModel(CurrencyAmountModel currencyAmountModel) {
            String amount = currencyAmountModel != null ? currencyAmountModel.getAmount() : null;
            if (amount == null) {
                amount = "";
            }
            String currency = currencyAmountModel != null ? currencyAmountModel.getCurrency() : null;
            if (currency == null) {
                currency = "";
            }
            return new MoneyViewModel(amount, currency, "");
        }

        public final CurrencyAmountModel toCurrencyAmountModel(MoneyViewModel moneyViewModel) {
            String cleanAmount = moneyViewModel != null ? moneyViewModel.getCleanAmount() : null;
            String str = cleanAmount == null ? "" : cleanAmount;
            String currency = moneyViewModel != null ? moneyViewModel.getCurrency() : null;
            return new CurrencyAmountModel(str, currency == null ? "" : currency, false, 4, null);
        }
    }
}
