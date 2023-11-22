package id.dana.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.sendmoney.recipienthome.SendMoneyScenarioActionType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b,\b\u0086\b\u0018\u0000 <2\u00020\u0001:\u0001<B\u0093\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u0012\b\b\u0002\u0010/\u001a\u00020\u000b\u0012\b\b\u0002\u00100\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u000b\u0012\b\b\u0002\u00103\u001a\u00020\u000b\u0012\b\b\u0002\u00104\u001a\u00020\u000b\u0012\b\b\u0002\u00105\u001a\u00020\u0007\u0012\b\b\u0002\u00106\u001a\u00020\u0007\u0012\b\b\u0002\u00107\u001a\u00020\u000b\u0012\b\b\u0002\u00108\u001a\u00020\u000b\u0012\b\b\u0002\u00109\u001a\u00020\u000b¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u0013\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0012\u0010\u001b\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001aR\u0011\u0010 \u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0017\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010!\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\"\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010#\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010$\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u001a\u0010%\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u0011\u0010&\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001aR\u0012\u0010'\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0012\u0010(\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0012\u0010)\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0012\u0010*\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0012\u0010+\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0012\u0010,\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0012\u0010-\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b$\u0010\u0014"}, d2 = {"Lid/dana/model/SendMoneyScenarioModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "initRecordTimeStamp", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda6", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SendMoneyScenarioModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String PlaceComponentResult;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String PrepareContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String isLayoutRequested;
    public static final Parcelable.Creator<SendMoneyScenarioModel> CREATOR = new Creator();

    public SendMoneyScenarioModel() {
        this(null, null, null, null, null, false, null, null, null, false, false, null, null, null, 16383, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SendMoneyScenarioModel) {
            SendMoneyScenarioModel sendMoneyScenarioModel = (SendMoneyScenarioModel) p0;
            return Intrinsics.areEqual(this.PrepareContext, sendMoneyScenarioModel.PrepareContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda6, sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda6) && Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, sendMoneyScenarioModel.FragmentBottomSheetPaymentSettingBinding) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda3, sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda3) && this.NetworkUserEntityData$$ExternalSyntheticLambda7 == sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda7 && Intrinsics.areEqual(this.MyBillsEntityDataFactory, sendMoneyScenarioModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.isLayoutRequested, sendMoneyScenarioModel.isLayoutRequested) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && this.BuiltInFictitiousFunctionClassFactory == sendMoneyScenarioModel.BuiltInFictitiousFunctionClassFactory && this.NetworkUserEntityData$$ExternalSyntheticLambda1 == sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda1 && Intrinsics.areEqual(this.PlaceComponentResult, sendMoneyScenarioModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, sendMoneyScenarioModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda4, sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda4);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.PrepareContext.hashCode();
        int hashCode2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.hashCode();
        int hashCode3 = this.FragmentBottomSheetPaymentSettingBinding.hashCode();
        int hashCode4 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode5 = this.NetworkUserEntityData$$ExternalSyntheticLambda3.hashCode();
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode6 = this.MyBillsEntityDataFactory.hashCode();
        int hashCode7 = this.isLayoutRequested.hashCode();
        int hashCode8 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode();
        boolean z2 = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i2) * 31) + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda4.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SendMoneyScenarioModel(PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        sb.append(", FragmentBottomSheetPaymentSettingBinding=");
        sb.append(this.FragmentBottomSheetPaymentSettingBinding);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda3=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PrepareContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        p0.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda7 ? 1 : 0);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.isLayoutRequested);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? 1 : 0);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    public SendMoneyScenarioModel(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, boolean z2, boolean z3, String str9, String str10, String str11) {
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
        this.PrepareContext = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str2;
        this.FragmentBottomSheetPaymentSettingBinding = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z;
        this.MyBillsEntityDataFactory = str6;
        this.isLayoutRequested = str7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str8;
        this.BuiltInFictitiousFunctionClassFactory = z2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z3;
        this.PlaceComponentResult = str9;
        this.getAuthRequestContext = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str11;
    }

    public /* synthetic */ SendMoneyScenarioModel(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, boolean z2, boolean z3, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? false : z, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? false : z2, (i & 1024) == 0 ? z3 : false, (i & 2048) != 0 ? "" : str9, (i & 4096) != 0 ? "" : str10, (i & 8192) == 0 ? str11 : "");
    }

    @JvmName(name = "GetContactSyncConfig")
    /* renamed from: GetContactSyncConfig  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "lookAheadTest")
    /* renamed from: lookAheadTest  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @JvmName(name = "PlaceComponentResult")
    public final boolean PlaceComponentResult() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "globalTransfer");
    }

    @JvmName(name = "moveToNextValue")
    public final boolean moveToNextValue() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "group");
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final boolean MyBillsEntityDataFactory() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "bank");
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda2")
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "phoneNumber");
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "chat");
    }

    @JvmName(name = "getAuthRequestContext")
    public final boolean getAuthRequestContext() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "external");
    }

    @JvmName(name = "initRecordTimeStamp")
    public final boolean initRecordTimeStamp() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, SendMoneyScenarioActionType.SALDO_DIGITAL);
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "other");
    }

    @JvmName(name = "scheduleImpl")
    public final boolean scheduleImpl() {
        return Intrinsics.areEqual(this.getAuthRequestContext, "POST");
    }

    @JvmName(name = "getErrorConfigVersion")
    public final boolean getErrorConfigVersion() {
        return Intrinsics.areEqual(this.getAuthRequestContext, "GET");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<SendMoneyScenarioModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SendMoneyScenarioModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new SendMoneyScenarioModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SendMoneyScenarioModel[] newArray(int i) {
            return new SendMoneyScenarioModel[i];
        }
    }
}
