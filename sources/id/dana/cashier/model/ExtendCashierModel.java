package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0014"}, d2 = {"Lid/dana/cashier/model/ExtendCashierModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Boolean;", "GetContactSyncConfig", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ExtendCashierModel implements Parcelable {
    public static final Parcelable.Creator<ExtendCashierModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String scheduleImpl;
    final Boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final String lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String moveToNextValue;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ExtendCashierModel) {
            ExtendCashierModel extendCashierModel = (ExtendCashierModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, extendCashierModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, extendCashierModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, extendCashierModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, extendCashierModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.moveToNextValue, extendCashierModel.moveToNextValue) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, extendCashierModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, extendCashierModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, extendCashierModel.lookAheadTest) && Intrinsics.areEqual(this.scheduleImpl, extendCashierModel.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, extendCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.GetContactSyncConfig, extendCashierModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, extendCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.getAuthRequestContext;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.PlaceComponentResult;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.moveToNextValue;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.MyBillsEntityDataFactory;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.getErrorConfigVersion;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.lookAheadTest;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.scheduleImpl;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.GetContactSyncConfig;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtendCashierModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.GetContactSyncConfig);
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bool == null) {
            i = 0;
        } else {
            p0.writeInt(1);
            i = bool.booleanValue();
        }
        p0.writeInt(i);
    }

    public ExtendCashierModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.moveToNextValue = str5;
        this.MyBillsEntityDataFactory = str6;
        this.getErrorConfigVersion = str7;
        this.lookAheadTest = str8;
        this.scheduleImpl = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str10;
        this.GetContactSyncConfig = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = bool;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<ExtendCashierModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ExtendCashierModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ExtendCashierModel(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, valueOf);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ExtendCashierModel[] newArray(int i) {
            return new ExtendCashierModel[i];
        }
    }
}
