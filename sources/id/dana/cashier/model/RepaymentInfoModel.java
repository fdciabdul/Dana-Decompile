package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/cashier/model/RepaymentInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "scheduleImpl", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RepaymentInfoModel implements Parcelable {
    public static final Parcelable.Creator<RepaymentInfoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MoneyViewModel MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MoneyViewModel PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final MoneyViewModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;
    public final MoneyViewModel getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RepaymentInfoModel) {
            RepaymentInfoModel repaymentInfoModel = (RepaymentInfoModel) p0;
            return Intrinsics.areEqual(this.scheduleImpl, repaymentInfoModel.scheduleImpl) && Intrinsics.areEqual(this.getAuthRequestContext, repaymentInfoModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, repaymentInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, repaymentInfoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, repaymentInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, repaymentInfoModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.scheduleImpl.hashCode();
        MoneyViewModel moneyViewModel = this.getAuthRequestContext;
        int hashCode2 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        MoneyViewModel moneyViewModel2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        MoneyViewModel moneyViewModel3 = this.MyBillsEntityDataFactory;
        int hashCode4 = moneyViewModel3 == null ? 0 : moneyViewModel3.hashCode();
        MoneyViewModel moneyViewModel4 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode5 = moneyViewModel4 == null ? 0 : moneyViewModel4.hashCode();
        MoneyViewModel moneyViewModel5 = this.PlaceComponentResult;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (moneyViewModel5 != null ? moneyViewModel5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RepaymentInfoModel(scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.scheduleImpl);
        MoneyViewModel moneyViewModel = this.getAuthRequestContext;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel3 = this.MyBillsEntityDataFactory;
        if (moneyViewModel3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel3.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel4 = this.BuiltInFictitiousFunctionClassFactory;
        if (moneyViewModel4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel4.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel5 = this.PlaceComponentResult;
        if (moneyViewModel5 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        moneyViewModel5.writeToParcel(p0, p1);
    }

    public RepaymentInfoModel(String str, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, MoneyViewModel moneyViewModel4, MoneyViewModel moneyViewModel5) {
        Intrinsics.checkNotNullParameter(str, "");
        this.scheduleImpl = str;
        this.getAuthRequestContext = moneyViewModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyViewModel2;
        this.MyBillsEntityDataFactory = moneyViewModel3;
        this.BuiltInFictitiousFunctionClassFactory = moneyViewModel4;
        this.PlaceComponentResult = moneyViewModel5;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<RepaymentInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RepaymentInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new RepaymentInfoModel(parcel.readString(), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? MoneyViewModel.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RepaymentInfoModel[] newArray(int i) {
            return new RepaymentInfoModel[i];
        }
    }
}
