package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\u0018\u00002\u00020\u0001B«\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010'\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\n\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0011\u0010\n\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u000e\u0010\fR$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0013\u0010\fR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0011\u0010\rR\u0011\u0010\u0014\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0011\u0010\u001b\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u001b\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/model/QrRequestBankTransferModel;", "Lid/dana/sendmoney/model/QrTransferModel;", "Landroid/os/Parcel;", "p0", "", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "GetContactSyncConfig", "scheduleImpl", "initRecordTimeStamp", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda2", "lookAheadTest", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrRequestBankTransferModel extends QrTransferModel {
    public static final Parcelable.Creator<QrRequestBankTransferModel> CREATOR = new Creator();
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String scheduleImpl;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String moveToNextValue;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    public QrRequestBankTransferModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @Override // id.dana.sendmoney.model.QrTransferModel, android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.DatabaseTableConfigUtil);
    }

    public /* synthetic */ QrRequestBankTransferModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) != 0 ? "" : str14, (i & 16384) == 0 ? str15 : "");
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(String str) {
        this.PlaceComponentResult = str;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final String getScheduleImpl() {
        return this.scheduleImpl;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        this.getErrorConfigVersion = str;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final String getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final String getLookAheadTest() {
        return this.lookAheadTest;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
    }

    @Override // id.dana.sendmoney.model.QrTransferModel
    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final String getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrRequestBankTransferModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        super(str, str2, str3, str4, str5, str6, str7);
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.moveToNextValue = str3;
        this.scheduleImpl = str4;
        this.getErrorConfigVersion = str5;
        this.lookAheadTest = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str7;
        this.BuiltInFictitiousFunctionClassFactory = str8;
        this.getAuthRequestContext = str9;
        this.GetContactSyncConfig = str10;
        this.MyBillsEntityDataFactory = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str12;
        this.initRecordTimeStamp = str13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str14;
        this.DatabaseTableConfigUtil = str15;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<QrRequestBankTransferModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ QrRequestBankTransferModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new QrRequestBankTransferModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ QrRequestBankTransferModel[] newArray(int i) {
            return new QrRequestBankTransferModel[i];
        }
    }
}
