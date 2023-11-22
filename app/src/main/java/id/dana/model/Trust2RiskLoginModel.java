package id.dana.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.model.VerificationTreeNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0013\u0010!\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0016R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0013\u0010 \u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0013\u0010#\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b$\u0010%R\u0013\u0010$\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b&\u0010\u0016"}, d2 = {"Lid/dana/model/Trust2RiskLoginModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/domain/model/VerificationTreeNode;", "Lid/dana/domain/model/VerificationTreeNode;", "PlaceComponentResult", "Ljava/lang/Integer;", "MyBillsEntityDataFactory", "getErrorConfigVersion", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "lookAheadTest", "GetContactSyncConfig", "initRecordTimeStamp", "DatabaseTableConfigUtil", "Ljava/lang/Boolean;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/model/VerificationTreeNode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Trust2RiskLoginModel implements Parcelable {
    public static final Parcelable.Creator<Trust2RiskLoginModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final VerificationTreeNode KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final Boolean GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Integer PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Integer BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Integer MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final Integer NetworkUserEntityData$$ExternalSyntheticLambda0;

    public Trust2RiskLoginModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof Trust2RiskLoginModel) {
            Trust2RiskLoginModel trust2RiskLoginModel = (Trust2RiskLoginModel) p0;
            return Intrinsics.areEqual(this.DatabaseTableConfigUtil, trust2RiskLoginModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.initRecordTimeStamp, trust2RiskLoginModel.initRecordTimeStamp) && Intrinsics.areEqual(this.moveToNextValue, trust2RiskLoginModel.moveToNextValue) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, trust2RiskLoginModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.lookAheadTest, trust2RiskLoginModel.lookAheadTest) && Intrinsics.areEqual(this.getErrorConfigVersion, trust2RiskLoginModel.getErrorConfigVersion) && Intrinsics.areEqual(this.getAuthRequestContext, trust2RiskLoginModel.getAuthRequestContext) && Intrinsics.areEqual(this.scheduleImpl, trust2RiskLoginModel.scheduleImpl) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, trust2RiskLoginModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, trust2RiskLoginModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, trust2RiskLoginModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, trust2RiskLoginModel.PlaceComponentResult) && Intrinsics.areEqual(this.GetContactSyncConfig, trust2RiskLoginModel.GetContactSyncConfig);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.DatabaseTableConfigUtil;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.initRecordTimeStamp;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.moveToNextValue;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        VerificationTreeNode verificationTreeNode = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode4 = verificationTreeNode == null ? 0 : verificationTreeNode.hashCode();
        String str4 = this.lookAheadTest;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.getErrorConfigVersion;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.getAuthRequestContext;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.scheduleImpl;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode9 = num == null ? 0 : num.hashCode();
        Integer num2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode10 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.MyBillsEntityDataFactory;
        int hashCode11 = num3 == null ? 0 : num3.hashCode();
        Integer num4 = this.PlaceComponentResult;
        int hashCode12 = num4 == null ? 0 : num4.hashCode();
        Boolean bool = this.GetContactSyncConfig;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trust2RiskLoginModel(DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.DatabaseTableConfigUtil);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.moveToNextValue);
        p0.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, p1);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.scheduleImpl);
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        Integer num2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (num2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num2.intValue());
        }
        Integer num3 = this.MyBillsEntityDataFactory;
        if (num3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num3.intValue());
        }
        Integer num4 = this.PlaceComponentResult;
        if (num4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num4.intValue());
        }
        Boolean bool = this.GetContactSyncConfig;
        if (bool == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public Trust2RiskLoginModel(String str, String str2, String str3, VerificationTreeNode verificationTreeNode, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool) {
        this.DatabaseTableConfigUtil = str;
        this.initRecordTimeStamp = str2;
        this.moveToNextValue = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = verificationTreeNode;
        this.lookAheadTest = str4;
        this.getErrorConfigVersion = str5;
        this.getAuthRequestContext = str6;
        this.scheduleImpl = str7;
        this.BuiltInFictitiousFunctionClassFactory = num;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = num2;
        this.MyBillsEntityDataFactory = num3;
        this.PlaceComponentResult = num4;
        this.GetContactSyncConfig = bool;
    }

    public /* synthetic */ Trust2RiskLoginModel(String str, String str2, String str3, VerificationTreeNode verificationTreeNode, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : verificationTreeNode, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : num4, (i & 4096) == 0 ? bool : null);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        List<VerificationTreeNode> children;
        VerificationTreeNode verificationTreeNode;
        VerificationTreeNode verificationTreeNode2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return Intrinsics.areEqual((verificationTreeNode2 == null || (children = verificationTreeNode2.getChildren()) == null || (verificationTreeNode = (VerificationTreeNode) CollectionsKt.first((List) children)) == null) ? null : verificationTreeNode.getValue(), "PASSKEYS");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<Trust2RiskLoginModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Trust2RiskLoginModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            VerificationTreeNode verificationTreeNode = (VerificationTreeNode) parcel.readParcelable(Trust2RiskLoginModel.class.getClassLoader());
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf5 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Trust2RiskLoginModel(readString, readString2, readString3, verificationTreeNode, readString4, readString5, readString6, readString7, valueOf2, valueOf3, valueOf4, valueOf5, valueOf);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Trust2RiskLoginModel[] newArray(int i) {
            return new Trust2RiskLoginModel[i];
        }
    }
}
