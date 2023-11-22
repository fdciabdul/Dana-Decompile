package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0014\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0019R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010 "}, d2 = {"Lid/dana/cashier/model/RepaymentPlanModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Integer;", "MyBillsEntityDataFactory", "Ljava/lang/Boolean;", "", "Lid/dana/cashier/model/RepaymentInfoModel;", "Ljava/util/List;", "p2", "p3", "p4", "<init>", "(Ljava/lang/Integer;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/util/List;Ljava/lang/Boolean;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RepaymentPlanModel implements Parcelable {
    public static final Parcelable.Creator<RepaymentPlanModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Integer getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<RepaymentInfoModel> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RepaymentPlanModel) {
            RepaymentPlanModel repaymentPlanModel = (RepaymentPlanModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, repaymentPlanModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, repaymentPlanModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, repaymentPlanModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, repaymentPlanModel.BuiltInFictitiousFunctionClassFactory) && this.PlaceComponentResult == repaymentPlanModel.PlaceComponentResult;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        Integer num = this.getAuthRequestContext;
        int hashCode = num == null ? 0 : num.hashCode();
        MoneyViewModel moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode2 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        int hashCode3 = this.MyBillsEntityDataFactory.hashCode();
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = bool != null ? bool.hashCode() : 0;
        boolean z = this.PlaceComponentResult;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RepaymentPlanModel(getAuthRequestContext=");
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
        Integer num = this.getAuthRequestContext;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        MoneyViewModel moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        List<RepaymentInfoModel> list = this.MyBillsEntityDataFactory;
        p0.writeInt(list.size());
        Iterator<RepaymentInfoModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
    }

    public RepaymentPlanModel(Integer num, MoneyViewModel moneyViewModel, List<RepaymentInfoModel> list, Boolean bool, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = num;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyViewModel;
        this.MyBillsEntityDataFactory = list;
        this.BuiltInFictitiousFunctionClassFactory = bool;
        this.PlaceComponentResult = z;
    }

    public /* synthetic */ RepaymentPlanModel(Integer num, MoneyViewModel moneyViewModel, List list, Boolean bool, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, moneyViewModel, list, bool, (i & 16) != 0 ? false : z);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<RepaymentPlanModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RepaymentPlanModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            MoneyViewModel createFromParcel = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(RepaymentInfoModel.CREATOR.createFromParcel(parcel));
            }
            return new RepaymentPlanModel(valueOf, createFromParcel, arrayList, parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RepaymentPlanModel[] newArray(int i) {
            return new RepaymentPlanModel[i];
        }
    }
}
