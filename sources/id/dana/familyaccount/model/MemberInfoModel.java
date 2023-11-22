package id.dana.familyaccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014"}, d2 = {"Lid/dana/familyaccount/model/MemberInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "MyBillsEntityDataFactory", "lookAheadTest", "getErrorConfigVersion", "scheduleImpl", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MemberInfoModel implements Parcelable {
    public static final Parcelable.Creator<MemberInfoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;
    public final String scheduleImpl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MemberInfoModel) {
            MemberInfoModel memberInfoModel = (MemberInfoModel) p0;
            return Intrinsics.areEqual(this.scheduleImpl, memberInfoModel.scheduleImpl) && Intrinsics.areEqual(this.PlaceComponentResult, memberInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, memberInfoModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, memberInfoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, memberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, memberInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, memberInfoModel.getErrorConfigVersion);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.scheduleImpl.hashCode() * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.getErrorConfigVersion.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MemberInfoModel(scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getErrorConfigVersion);
    }

    public MemberInfoModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.scheduleImpl = str;
        this.PlaceComponentResult = str2;
        this.getAuthRequestContext = str3;
        this.MyBillsEntityDataFactory = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.BuiltInFictitiousFunctionClassFactory = str6;
        this.getErrorConfigVersion = str7;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MemberInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MemberInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MemberInfoModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MemberInfoModel[] newArray(int i) {
            return new MemberInfoModel[i];
        }
    }
}
