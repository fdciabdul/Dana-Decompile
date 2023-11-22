package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0016\u0018\u00002\u00020\u0001:\u0001$B[\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0011\u0010\u0013R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0019\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R$\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u0015\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/model/QrTransferModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "getErrorConfigVersion", "()Z", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "scheduleImpl", "GetContactSyncConfig", "initRecordTimeStamp", "moveToNextValue", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class QrTransferModel implements Parcelable {
    public static final Parcelable.Creator<QrTransferModel> CREATOR = new Creator();
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String GetContactSyncConfig;

    public QrTransferModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.GetContactSyncConfig);
    }

    public QrTransferModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.MyBillsEntityDataFactory = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
        this.moveToNextValue = str6;
        this.GetContactSyncConfig = str7;
    }

    public /* synthetic */ QrTransferModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public void MyBillsEntityDataFactory(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public String getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public void BuiltInFictitiousFunctionClassFactory(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public String getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public String getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @JvmName(name = "getAuthRequestContext")
    public void getAuthRequestContext(String str) {
        this.GetContactSyncConfig = str;
    }

    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public String getGetContactSyncConfig() {
        return this.GetContactSyncConfig;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String networkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
        if (networkUserEntityData$$ExternalSyntheticLambda0 == null || StringsKt.isBlank(networkUserEntityData$$ExternalSyntheticLambda0)) {
            String getContactSyncConfig = getGetContactSyncConfig();
            if (getContactSyncConfig == null || StringsKt.isBlank(getContactSyncConfig)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "GetContactSyncConfig")
    public final boolean GetContactSyncConfig() {
        String getContactSyncConfig = getGetContactSyncConfig();
        if (!(getContactSyncConfig == null || StringsKt.isBlank(getContactSyncConfig))) {
            String kClassImpl$Data$declaredNonStaticMembers$2 = getKClassImpl$Data$declaredNonStaticMembers$2();
            if (!(kClassImpl$Data$declaredNonStaticMembers$2 == null || StringsKt.isBlank(kClassImpl$Data$declaredNonStaticMembers$2))) {
                return true;
            }
        }
        return false;
    }

    public final boolean getErrorConfigVersion() {
        String kClassImpl$Data$declaredNonStaticMembers$2 = getKClassImpl$Data$declaredNonStaticMembers$2();
        return !(kClassImpl$Data$declaredNonStaticMembers$2 == null || StringsKt.isBlank(kClassImpl$Data$declaredNonStaticMembers$2)) && TextUtils.isDigitsOnly(getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @JvmName(name = "lookAheadTest")
    public final boolean lookAheadTest() {
        String getContactSyncConfig = getGetContactSyncConfig();
        if (!(getContactSyncConfig == null || StringsKt.isBlank(getContactSyncConfig))) {
            String kClassImpl$Data$declaredNonStaticMembers$2 = getKClassImpl$Data$declaredNonStaticMembers$2();
            if (!(kClassImpl$Data$declaredNonStaticMembers$2 == null || StringsKt.isBlank(kClassImpl$Data$declaredNonStaticMembers$2))) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "initRecordTimeStamp")
    public final boolean initRecordTimeStamp() {
        return Intrinsics.areEqual(getBuiltInFictitiousFunctionClassFactory(), DecodeQrBizType.USER_BANK_ACCOUNT_CODE) || Intrinsics.areEqual(getBuiltInFictitiousFunctionClassFactory(), DecodeQrBizType.TRANSFER_BANK_ACCOUNT_CODE);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/model/QrTransferModel$Builder;", "", "Lid/dana/sendmoney/model/QrTransferModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/sendmoney/model/QrTransferModel;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "getAuthRequestContext", "PlaceComponentResult", "getErrorConfigVersion", "moveToNextValue", "lookAheadTest", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static class Builder {
        public String BuiltInFictitiousFunctionClassFactory = "";

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory = "";

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String PlaceComponentResult = "";

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String getAuthRequestContext = "";

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2 = "";
        public String getErrorConfigVersion = "";

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String lookAheadTest = "";

        public final QrTransferModel KClassImpl$Data$declaredNonStaticMembers$2() {
            return new QrTransferModel(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion, this.lookAheadTest);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<QrTransferModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ QrTransferModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new QrTransferModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ QrTransferModel[] newArray(int i) {
            return new QrTransferModel[i];
        }
    }
}
