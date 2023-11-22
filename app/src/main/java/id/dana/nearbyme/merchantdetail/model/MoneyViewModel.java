package id.dana.nearbyme.merchantdetail.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.core.ui.extension.StringExtKt;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.util.NumberUtils;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.model.CurrencyAmountModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0016J\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u001d"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "MyBillsEntityDataFactory", "()D", "", "BuiltInFictitiousFunctionClassFactory", "()J", "", "getAuthRequestContext", "()Ljava/lang/String;", "hashCode", "PlaceComponentResult", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)Z", "(J)Z", "toString", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MoneyViewModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MoneyViewModel> CREATOR = new Creator();

    public MoneyViewModel() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MoneyViewModel) {
            MoneyViewModel moneyViewModel = (MoneyViewModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, moneyViewModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, moneyViewModel.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.PlaceComponentResult.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MoneyViewModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.getAuthRequestContext);
    }

    public MoneyViewModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.getAuthRequestContext = str3;
    }

    public /* synthetic */ MoneyViewModel(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        String KClassImpl$Data$declaredNonStaticMembers$2 = NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), MyBillsEntityDataFactory());
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            KClassImpl$Data$declaredNonStaticMembers$2 = "";
        }
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }

    public final double MyBillsEntityDataFactory() {
        if ((this.KClassImpl$Data$declaredNonStaticMembers$2.length() > 0) && !Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "Rp") && !Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, GlobalNetworkConstants.IDR_CURRENCY)) {
            Double doubleOrNull = StringsKt.toDoubleOrNull(StringExtKt.getAuthRequestContext(this.PlaceComponentResult));
            return doubleOrNull != null ? doubleOrNull.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        Double doubleOrNull2 = StringsKt.toDoubleOrNull(StringsKt.replace$default(StringExtKt.KClassImpl$Data$declaredNonStaticMembers$2(StringsKt.removeSuffix(this.PlaceComponentResult, (CharSequence) ".0")), ",", ".", false, 4, (Object) null));
        return doubleOrNull2 != null ? doubleOrNull2.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final boolean getAuthRequestContext(MoneyViewModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return BuiltInFictitiousFunctionClassFactory() > p0.BuiltInFictitiousFunctionClassFactory();
    }

    public final boolean PlaceComponentResult(MoneyViewModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return BuiltInFictitiousFunctionClassFactory() < p0.BuiltInFictitiousFunctionClassFactory();
    }

    public final boolean PlaceComponentResult(long p0) {
        return BuiltInFictitiousFunctionClassFactory() < p0;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\b\u001a\u00020\u0002*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel$Companion;", "", "Lid/dana/model/CurrencyAmountModel;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getAuthRequestContext", "(Lid/dana/model/CurrencyAmountModel;)Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/domain/nearbyme/model/MoneyView;", "PlaceComponentResult", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)Lid/dana/model/CurrencyAmountModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static MoneyViewModel PlaceComponentResult(MoneyView p0) {
            String amount = p0 != null ? p0.getAmount() : null;
            if (amount == null) {
                amount = "";
            }
            String currency = p0 != null ? p0.getCurrency() : null;
            if (currency == null) {
                currency = "";
            }
            String currencyCode = p0 != null ? p0.getCurrencyCode() : null;
            return new MoneyViewModel(amount, currency, currencyCode != null ? currencyCode : "");
        }

        public static MoneyViewModel getAuthRequestContext(CurrencyAmountModel p0) {
            String str = p0 != null ? p0.MyBillsEntityDataFactory : null;
            if (str == null) {
                str = "";
            }
            String str2 = p0 != null ? p0.BuiltInFictitiousFunctionClassFactory : null;
            if (str2 == null) {
                str2 = "";
            }
            return new MoneyViewModel(str, str2, "");
        }

        public static CurrencyAmountModel PlaceComponentResult(MoneyViewModel moneyViewModel) {
            String str;
            if (moneyViewModel != null) {
                str = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
                if (str == null) {
                    str = "0";
                }
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String str2 = moneyViewModel != null ? moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            return new CurrencyAmountModel(str, str2 != null ? str2 : "");
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MoneyViewModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MoneyViewModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MoneyViewModel(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MoneyViewModel[] newArray(int i) {
            return new MoneyViewModel[i];
        }
    }

    public static /* synthetic */ MoneyViewModel BuiltInFictitiousFunctionClassFactory(MoneyViewModel moneyViewModel, String str) {
        String str2 = moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = moneyViewModel.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        return new MoneyViewModel(str, str2, str3);
    }

    public final long BuiltInFictitiousFunctionClassFactory() {
        String cleanAll = NumberUtils.getCleanAll(this.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(cleanAll);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }
}
