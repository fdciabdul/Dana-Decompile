package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018"}, d2 = {"Lid/dana/cashier/model/CashierKybOrderDetailModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "p2", "p3", "p4", "<init>", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierKybOrderDetailModel implements Parcelable {
    public static final Parcelable.Creator<CashierKybOrderDetailModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MoneyViewModel MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MoneyViewModel BuiltInFictitiousFunctionClassFactory;
    public final MoneyViewModel PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierKybOrderDetailModel) {
            CashierKybOrderDetailModel cashierKybOrderDetailModel = (CashierKybOrderDetailModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, cashierKybOrderDetailModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, cashierKybOrderDetailModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierKybOrderDetailModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, cashierKybOrderDetailModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, cashierKybOrderDetailModel.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        MoneyViewModel moneyViewModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        MoneyViewModel moneyViewModel2 = this.MyBillsEntityDataFactory;
        int hashCode2 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = str == null ? 0 : str.hashCode();
        MoneyViewModel moneyViewModel3 = this.PlaceComponentResult;
        int hashCode4 = moneyViewModel3 == null ? 0 : moneyViewModel3.hashCode();
        String str2 = this.getAuthRequestContext;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierKybOrderDetailModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        MoneyViewModel moneyViewModel = this.BuiltInFictitiousFunctionClassFactory;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel2 = this.MyBillsEntityDataFactory;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        MoneyViewModel moneyViewModel3 = this.PlaceComponentResult;
        if (moneyViewModel3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel3.writeToParcel(p0, p1);
        }
        p0.writeString(this.getAuthRequestContext);
    }

    public CashierKybOrderDetailModel(MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str, MoneyViewModel moneyViewModel3, String str2) {
        this.BuiltInFictitiousFunctionClassFactory = moneyViewModel;
        this.MyBillsEntityDataFactory = moneyViewModel2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = moneyViewModel3;
        this.getAuthRequestContext = str2;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CashierKybOrderDetailModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CashierKybOrderDetailModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new CashierKybOrderDetailModel(parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0 ? MoneyViewModel.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CashierKybOrderDetailModel[] newArray(int i) {
            return new CashierKybOrderDetailModel[i];
        }
    }
}
