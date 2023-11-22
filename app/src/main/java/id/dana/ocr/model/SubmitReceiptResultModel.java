package id.dana.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b)\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010(\u001a\u00020\u000b\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\u0006\u0010*\u001a\u00020\u000b\u0012\u0006\u0010+\u001a\u00020\u000b\u0012\u0006\u0010,\u001a\u00020\u000b\u0012\u0006\u0010-\u001a\u00020\u000b\u0012\u0006\u0010.\u001a\u00020\u000b\u0012\u0006\u0010/\u001a\u00020\u000b\u0012\u0006\u00100\u001a\u00020\u000b\u0012\u0006\u00101\u001a\u00020\u000b\u0012\u0006\u00102\u001a\u00020\u000b\u0012\u0006\u00103\u001a\u00020\u000b\u0012\u0006\u00104\u001a\u00020\u000b\u0012\u0006\u00105\u001a\u00020\u000b\u0012\u0006\u00106\u001a\u00020\u000b\u0012\u0006\u00107\u001a\u00020\u000b¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0013\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0012\u0010\u0017\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0012\u0010\u0018\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0012\u0010\u0019\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0012\u0010\u001b\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0012\u0010\u001c\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0012\u0010\u001a\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0012\u0010\u001d\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0012\u0010\u001e\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0012\u0010 \u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0012\u0010\"\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0012\u0010!\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0014R\u0012\u0010\u001f\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0012\u0010$\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b#\u0010\u0014R\u0012\u0010&\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b%\u0010\u0014R\u0012\u0010'\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b&\u0010\u0014"}, d2 = {"Lid/dana/ocr/model/SubmitReceiptResultModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class SubmitReceiptResultModel implements Parcelable {
    public static final Parcelable.Creator<SubmitReceiptResultModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String GetContactSyncConfig;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public String isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public String PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public String scheduleImpl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SubmitReceiptResultModel) {
            SubmitReceiptResultModel submitReceiptResultModel = (SubmitReceiptResultModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, submitReceiptResultModel.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, submitReceiptResultModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, submitReceiptResultModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.lookAheadTest, submitReceiptResultModel.lookAheadTest) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, submitReceiptResultModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.scheduleImpl, submitReceiptResultModel.scheduleImpl) && Intrinsics.areEqual(this.getAuthRequestContext, submitReceiptResultModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, submitReceiptResultModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.moveToNextValue, submitReceiptResultModel.moveToNextValue) && Intrinsics.areEqual(this.getErrorConfigVersion, submitReceiptResultModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, submitReceiptResultModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PrepareContext, submitReceiptResultModel.PrepareContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, submitReceiptResultModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.isLayoutRequested, submitReceiptResultModel.isLayoutRequested) && Intrinsics.areEqual(this.GetContactSyncConfig, submitReceiptResultModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, submitReceiptResultModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.initRecordTimeStamp, submitReceiptResultModel.initRecordTimeStamp) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, submitReceiptResultModel.DatabaseTableConfigUtil);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((this.PlaceComponentResult.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.scheduleImpl.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode()) * 31) + this.moveToNextValue.hashCode()) * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.PrepareContext.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode()) * 31) + this.isLayoutRequested.hashCode()) * 31) + this.GetContactSyncConfig.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode()) * 31) + this.initRecordTimeStamp.hashCode()) * 31) + this.DatabaseTableConfigUtil.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubmitReceiptResultModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeString(this.isLayoutRequested);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.DatabaseTableConfigUtil);
    }

    public SubmitReceiptResultModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str16, "");
        Intrinsics.checkNotNullParameter(str17, "");
        Intrinsics.checkNotNullParameter(str18, "");
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str3;
        this.lookAheadTest = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.scheduleImpl = str6;
        this.getAuthRequestContext = str7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str8;
        this.moveToNextValue = str9;
        this.getErrorConfigVersion = str10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str11;
        this.PrepareContext = str12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str13;
        this.isLayoutRequested = str14;
        this.GetContactSyncConfig = str15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str16;
        this.initRecordTimeStamp = str17;
        this.DatabaseTableConfigUtil = str18;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<SubmitReceiptResultModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubmitReceiptResultModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new SubmitReceiptResultModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubmitReceiptResultModel[] newArray(int i) {
            return new SubmitReceiptResultModel[i];
        }
    }
}
