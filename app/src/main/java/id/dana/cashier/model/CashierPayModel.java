package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/cashier/model/CashierPayModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/AttributeCashierPayModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/AttributeCashierPayModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "Ljava/lang/Boolean;", "p2", "p3", "p4", "<init>", "(Lid/dana/cashier/model/AttributeCashierPayModel;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CashierPayModel implements Parcelable {
    public static final Parcelable.Creator<CashierPayModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final AttributeCashierPayModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierPayModel) {
            CashierPayModel cashierPayModel = (CashierPayModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, cashierPayModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, cashierPayModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, cashierPayModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, cashierPayModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        AttributeCashierPayModel attributeCashierPayModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = attributeCashierPayModel == null ? 0 : attributeCashierPayModel.hashCode();
        String str = this.MyBillsEntityDataFactory;
        int hashCode2 = str == null ? 0 : str.hashCode();
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = bool == null ? 0 : bool.hashCode();
        String str2 = this.getAuthRequestContext;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.PlaceComponentResult;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierPayModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        AttributeCashierPayModel attributeCashierPayModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (attributeCashierPayModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            attributeCashierPayModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.MyBillsEntityDataFactory);
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.PlaceComponentResult);
    }

    public CashierPayModel(AttributeCashierPayModel attributeCashierPayModel, String str, Boolean bool, String str2, String str3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = attributeCashierPayModel;
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = bool;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = str3;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CashierPayModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CashierPayModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            Boolean bool = null;
            AttributeCashierPayModel createFromParcel = parcel.readInt() == 0 ? null : AttributeCashierPayModel.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new CashierPayModel(createFromParcel, readString, bool, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CashierPayModel[] newArray(int i) {
            return new CashierPayModel[i];
        }
    }
}
