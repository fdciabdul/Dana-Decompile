package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0007¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b&\u0010\u001c"}, d2 = {"Lid/dana/cashier/model/QueryInstallmentModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/ConsultAgreementModel;", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/ConsultAgreementModel;", "PlaceComponentResult", "Lid/dana/cashier/model/DanaCreditModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/DanaCreditModel;", "getAuthRequestContext", "Ljava/lang/String;", "Ljava/lang/Boolean;", "scheduleImpl", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "Lid/dana/cashier/model/RepaymentPlanModel;", "moveToNextValue", "Ljava/util/List;", "lookAheadTest", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/cashier/model/DanaCreditModel;Ljava/lang/String;Ljava/util/List;ZLid/dana/cashier/model/ConsultAgreementModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryInstallmentModel implements Parcelable {
    public static final Parcelable.Creator<QueryInstallmentModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final DanaCreditModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ConsultAgreementModel PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public Boolean scheduleImpl;
    public final List<RepaymentPlanModel> moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof QueryInstallmentModel) {
            QueryInstallmentModel queryInstallmentModel = (QueryInstallmentModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, queryInstallmentModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, queryInstallmentModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.moveToNextValue, queryInstallmentModel.moveToNextValue) && this.BuiltInFictitiousFunctionClassFactory == queryInstallmentModel.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.PlaceComponentResult, queryInstallmentModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, queryInstallmentModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, queryInstallmentModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, queryInstallmentModel.scheduleImpl);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        DanaCreditModel danaCreditModel = this.getAuthRequestContext;
        int hashCode = danaCreditModel == null ? 0 : danaCreditModel.hashCode();
        int hashCode2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        int hashCode3 = this.moveToNextValue.hashCode();
        boolean z = this.BuiltInFictitiousFunctionClassFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        ConsultAgreementModel consultAgreementModel = this.PlaceComponentResult;
        int hashCode4 = consultAgreementModel == null ? 0 : consultAgreementModel.hashCode();
        Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode5 = bool == null ? 0 : bool.hashCode();
        String str = this.MyBillsEntityDataFactory;
        int hashCode6 = str == null ? 0 : str.hashCode();
        Boolean bool2 = this.scheduleImpl;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryInstallmentModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaCreditModel danaCreditModel = this.getAuthRequestContext;
        if (danaCreditModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            danaCreditModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        List<RepaymentPlanModel> list = this.moveToNextValue;
        p0.writeInt(list.size());
        Iterator<RepaymentPlanModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
        ConsultAgreementModel consultAgreementModel = this.PlaceComponentResult;
        if (consultAgreementModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            consultAgreementModel.writeToParcel(p0, p1);
        }
        Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.MyBillsEntityDataFactory);
        Boolean bool2 = this.scheduleImpl;
        if (bool2 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(bool2.booleanValue() ? 1 : 0);
    }

    public QueryInstallmentModel(DanaCreditModel danaCreditModel, String str, List<RepaymentPlanModel> list, boolean z, ConsultAgreementModel consultAgreementModel, Boolean bool, String str2, Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = danaCreditModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.moveToNextValue = list;
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.PlaceComponentResult = consultAgreementModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bool;
        this.MyBillsEntityDataFactory = str2;
        this.scheduleImpl = bool2;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<QueryInstallmentModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ QueryInstallmentModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            DanaCreditModel createFromParcel = parcel.readInt() == 0 ? null : DanaCreditModel.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(RepaymentPlanModel.CREATOR.createFromParcel(parcel));
            }
            return new QueryInstallmentModel(createFromParcel, readString, arrayList, parcel.readInt() != 0, parcel.readInt() == 0 ? null : ConsultAgreementModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ QueryInstallmentModel[] newArray(int i) {
            return new QueryInstallmentModel[i];
        }
    }
}
