package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u008b\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0013\u0010!\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0019"}, d2 = {"Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "PlaceComponentResult", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/Boolean;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "scheduleImpl", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExternalWithdrawChannelModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Boolean MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String getErrorConfigVersion;
    public static final Parcelable.Creator<ExternalWithdrawChannelModel> CREATOR = new Creator();

    public ExternalWithdrawChannelModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ExternalWithdrawChannelModel) {
            ExternalWithdrawChannelModel externalWithdrawChannelModel = (ExternalWithdrawChannelModel) p0;
            return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.scheduleImpl, externalWithdrawChannelModel.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, externalWithdrawChannelModel.moveToNextValue) && Intrinsics.areEqual(this.lookAheadTest, externalWithdrawChannelModel.lookAheadTest) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, externalWithdrawChannelModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, externalWithdrawChannelModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, externalWithdrawChannelModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, externalWithdrawChannelModel.PlaceComponentResult) && Intrinsics.areEqual(this.getErrorConfigVersion, externalWithdrawChannelModel.getErrorConfigVersion) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, externalWithdrawChannelModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.scheduleImpl;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.moveToNextValue;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.lookAheadTest;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode6 = bool == null ? 0 : bool.hashCode();
        String str6 = this.getAuthRequestContext;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.PlaceComponentResult;
        int hashCode9 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.getErrorConfigVersion;
        int hashCode10 = str9 == null ? 0 : str9.hashCode();
        Boolean bool2 = this.MyBillsEntityDataFactory;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExternalWithdrawChannelModel(NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.getErrorConfigVersion);
        Boolean bool2 = this.MyBillsEntityDataFactory;
        if (bool2 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(bool2.booleanValue() ? 1 : 0);
    }

    public ExternalWithdrawChannelModel(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, Boolean bool2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.scheduleImpl = str2;
        this.moveToNextValue = str3;
        this.lookAheadTest = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str5;
        this.BuiltInFictitiousFunctionClassFactory = bool;
        this.getAuthRequestContext = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
        this.PlaceComponentResult = str8;
        this.getErrorConfigVersion = str9;
        this.MyBillsEntityDataFactory = bool2;
    }

    public /* synthetic */ ExternalWithdrawChannelModel(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? Boolean.FALSE : bool, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) == 0 ? str9 : "", (i & 1024) != 0 ? Boolean.FALSE : bool2);
    }

    public final boolean PlaceComponentResult() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "AE13112148999315");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ExternalWithdrawChannelModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ExternalWithdrawChannelModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ExternalWithdrawChannelModel(readString, readString2, readString3, readString4, readString5, valueOf, readString6, readString7, readString8, readString9, valueOf2);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ExternalWithdrawChannelModel[] newArray(int i) {
            return new ExternalWithdrawChannelModel[i];
        }
    }
}
