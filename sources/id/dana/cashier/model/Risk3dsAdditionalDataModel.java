package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014"}, d2 = {"Lid/dana/cashier/model/Risk3dsAdditionalDataModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "getAuthRequestContext", "Ljava/lang/Integer;", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Risk3dsAdditionalDataModel implements Parcelable {
    public static final Parcelable.Creator<Risk3dsAdditionalDataModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final Integer getAuthRequestContext;

    public Risk3dsAdditionalDataModel() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof Risk3dsAdditionalDataModel) {
            Risk3dsAdditionalDataModel risk3dsAdditionalDataModel = (Risk3dsAdditionalDataModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, risk3dsAdditionalDataModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, risk3dsAdditionalDataModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, risk3dsAdditionalDataModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, risk3dsAdditionalDataModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, risk3dsAdditionalDataModel.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.MyBillsEntityDataFactory;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.PlaceComponentResult;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Integer num = this.getAuthRequestContext;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Risk3dsAdditionalDataModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        int intValue;
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        Integer num = this.getAuthRequestContext;
        if (num == null) {
            intValue = 0;
        } else {
            p0.writeInt(1);
            intValue = num.intValue();
        }
        p0.writeInt(intValue);
    }

    public Risk3dsAdditionalDataModel(String str, String str2, String str3, String str4, Integer num) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.PlaceComponentResult = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.getAuthRequestContext = num;
    }

    public /* synthetic */ Risk3dsAdditionalDataModel(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<Risk3dsAdditionalDataModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Risk3dsAdditionalDataModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new Risk3dsAdditionalDataModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Risk3dsAdditionalDataModel[] newArray(int i) {
            return new Risk3dsAdditionalDataModel[i];
        }
    }
}
