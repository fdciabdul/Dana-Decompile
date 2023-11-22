package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b"}, d2 = {"Lid/dana/cashier/model/RiskVerificationMethodModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Boolean;", "", "Lid/dana/cashier/model/OneKlikPhonesModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RiskVerificationMethodModel implements Parcelable {
    public static final Parcelable.Creator<RiskVerificationMethodModel> CREATOR = new Creator();
    public final String BuiltInFictitiousFunctionClassFactory;
    public final Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<OneKlikPhonesModel> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final List<String> lookAheadTest;

    public RiskVerificationMethodModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RiskVerificationMethodModel) {
            RiskVerificationMethodModel riskVerificationMethodModel = (RiskVerificationMethodModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, riskVerificationMethodModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, riskVerificationMethodModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, riskVerificationMethodModel.scheduleImpl) && Intrinsics.areEqual(this.PlaceComponentResult, riskVerificationMethodModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, riskVerificationMethodModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, riskVerificationMethodModel.getAuthRequestContext) && Intrinsics.areEqual(this.lookAheadTest, riskVerificationMethodModel.lookAheadTest);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.MyBillsEntityDataFactory;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.scheduleImpl;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.PlaceComponentResult;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode5 = bool == null ? 0 : bool.hashCode();
        List<OneKlikPhonesModel> list = this.getAuthRequestContext;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (list != null ? list.hashCode() : 0)) * 31) + this.lookAheadTest.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskVerificationMethodModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.PlaceComponentResult);
        Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        List<OneKlikPhonesModel> list = this.getAuthRequestContext;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<OneKlikPhonesModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }
        p0.writeStringList(this.lookAheadTest);
    }

    public RiskVerificationMethodModel(String str, String str2, String str3, String str4, Boolean bool, List<OneKlikPhonesModel> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list2, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = str2;
        this.scheduleImpl = str3;
        this.PlaceComponentResult = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bool;
        this.getAuthRequestContext = list;
        this.lookAheadTest = list2;
    }

    public /* synthetic */ RiskVerificationMethodModel(String str, String str2, String str3, String str4, Boolean bool, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) == 0 ? bool : null, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<RiskVerificationMethodModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RiskVerificationMethodModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            ArrayList arrayList = null;
            Boolean valueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(OneKlikPhonesModel.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new RiskVerificationMethodModel(readString, readString2, readString3, readString4, valueOf, arrayList, parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RiskVerificationMethodModel[] newArray(int i) {
            return new RiskVerificationMethodModel[i];
        }
    }
}
