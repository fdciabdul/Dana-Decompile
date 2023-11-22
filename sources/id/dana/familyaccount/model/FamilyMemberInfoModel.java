package id.dana.familyaccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000e\u0010\fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0014\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u001aX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015"}, d2 = {"Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "PlaceComponentResult", "()Ljava/lang/String;", "hashCode", "toString", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/familyaccount/model/LimitInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/familyaccount/model/LimitInfoModel;", "Lid/dana/familyaccount/model/MemberInfoModel;", "getAuthRequestContext", "Lid/dana/familyaccount/model/MemberInfoModel;", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Lid/dana/familyaccount/model/MemberInfoModel;Ljava/lang/String;Ljava/lang/String;Lid/dana/familyaccount/model/LimitInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FamilyMemberInfoModel implements Parcelable {
    public static final Parcelable.Creator<FamilyMemberInfoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public LimitInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final MemberInfoModel getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FamilyMemberInfoModel) {
            FamilyMemberInfoModel familyMemberInfoModel = (FamilyMemberInfoModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, familyMemberInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, familyMemberInfoModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, familyMemberInfoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, familyMemberInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.PlaceComponentResult.hashCode() * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FamilyMemberInfoModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        this.getAuthRequestContext.writeToParcel(p0, p1);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        this.KClassImpl$Data$declaredNonStaticMembers$2.writeToParcel(p0, p1);
    }

    public FamilyMemberInfoModel(String str, MemberInfoModel memberInfoModel, String str2, String str3, LimitInfoModel limitInfoModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(memberInfoModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(limitInfoModel, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = memberInfoModel;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = limitInfoModel;
    }

    public final String PlaceComponentResult() {
        String str = this.getAuthRequestContext.getAuthRequestContext;
        if (str.length() == 0) {
            str = this.getAuthRequestContext.PlaceComponentResult;
        }
        return str;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<FamilyMemberInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FamilyMemberInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new FamilyMemberInfoModel(parcel.readString(), MemberInfoModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), LimitInfoModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FamilyMemberInfoModel[] newArray(int i) {
            return new FamilyMemberInfoModel[i];
        }
    }
}
