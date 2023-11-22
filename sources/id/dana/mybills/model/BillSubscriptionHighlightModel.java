package id.dana.mybills.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u009d\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010.\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\b\u00100\u001a\u0004\u0018\u00010\u000b\u0012\b\u00101\u001a\u0004\u0018\u00010\u000b\u0012\b\u00102\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u00103\u001a\u00020\u001f\u0012\b\u00104\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00105\u001a\u00020%\u0012\u0006\u00106\u001a\u00020%\u0012\b\u00107\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00108\u001a\u00020\u0002\u0012\b\u00109\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010:\u001a\u00020\u0007\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0011\u0010!\u001a\u00020\u001fX\u0007¢\u0006\u0006\n\u0004\b\u001d\u0010 R\u0013\u0010$\u001a\u0004\u0018\u00010\u001fX\u0007¢\u0006\u0006\n\u0004\b\"\u0010#R\u0011\u0010\"\u001a\u00020%X\u0007¢\u0006\u0006\n\u0004\b$\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0013\u0010)\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b(\u0010\u0014R\u0011\u0010(\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b*\u0010\u0014R\u0013\u0010*\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b)\u0010\u0014R\u0011\u0010+\u001a\u00020%X\u0007¢\u0006\u0006\n\u0004\b'\u0010&R\u0011\u0010-\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/mybills/model/BillSubscriptionHighlightModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Ljava/lang/Boolean;", "newProxyInstance", "Z", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "", "J", "moveToNextValue", "getErrorConfigVersion", "Ljava/lang/Long;", "lookAheadTest", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "initRecordTimeStamp", "GetContactSyncConfig", "I", "PrepareContext", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillSubscriptionHighlightModel implements Parcelable {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final int PrepareContext;
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final long moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final MoneyViewModel GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Boolean getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final Long lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final MoneyViewModel getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;
    public final String scheduleImpl;
    public static final Parcelable.Creator<BillSubscriptionHighlightModel> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BillSubscriptionHighlightModel) {
            BillSubscriptionHighlightModel billSubscriptionHighlightModel = (BillSubscriptionHighlightModel) p0;
            return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, billSubscriptionHighlightModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, billSubscriptionHighlightModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, billSubscriptionHighlightModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.scheduleImpl, billSubscriptionHighlightModel.scheduleImpl) && Intrinsics.areEqual(this.lookAheadTest, billSubscriptionHighlightModel.lookAheadTest) && this.moveToNextValue == billSubscriptionHighlightModel.moveToNextValue && Intrinsics.areEqual(this.initRecordTimeStamp, billSubscriptionHighlightModel.initRecordTimeStamp) && Intrinsics.areEqual(this.GetContactSyncConfig, billSubscriptionHighlightModel.GetContactSyncConfig) && Intrinsics.areEqual(this.getErrorConfigVersion, billSubscriptionHighlightModel.getErrorConfigVersion) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, billSubscriptionHighlightModel.DatabaseTableConfigUtil) && this.PrepareContext == billSubscriptionHighlightModel.PrepareContext && Intrinsics.areEqual(this.MyBillsEntityDataFactory, billSubscriptionHighlightModel.MyBillsEntityDataFactory) && this.PlaceComponentResult == billSubscriptionHighlightModel.PlaceComponentResult && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode();
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.getAuthRequestContext;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.scheduleImpl;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        Long l = this.lookAheadTest;
        int hashCode7 = l == null ? 0 : l.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.moveToNextValue);
        String str5 = this.initRecordTimeStamp;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        int hashCode9 = this.GetContactSyncConfig.hashCode();
        int hashCode10 = this.getErrorConfigVersion.hashCode();
        String str6 = this.DatabaseTableConfigUtil;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        int i = this.PrepareContext;
        String str7 = this.MyBillsEntityDataFactory;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.PlaceComponentResult;
        int i2 = z ? 1 : z ? 1 : 0;
        String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return (((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + m) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + i) * 31) + hashCode12) * 31) + i2) * 31) + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillSubscriptionHighlightModel(NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        Boolean bool = this.getAuthRequestContext;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.scheduleImpl);
        Long l = this.lookAheadTest;
        if (l == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l.longValue());
        }
        p0.writeLong(this.moveToNextValue);
        p0.writeString(this.initRecordTimeStamp);
        this.GetContactSyncConfig.writeToParcel(p0, p1);
        this.getErrorConfigVersion.writeToParcel(p0, p1);
        p0.writeString(this.DatabaseTableConfigUtil);
        p0.writeInt(this.PrepareContext);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    public BillSubscriptionHighlightModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Long l, long j, String str6, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str7, int i, String str8, boolean z, String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.getAuthRequestContext = bool;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.scheduleImpl = str5;
        this.lookAheadTest = l;
        this.moveToNextValue = j;
        this.initRecordTimeStamp = str6;
        this.GetContactSyncConfig = moneyViewModel;
        this.getErrorConfigVersion = moneyViewModel2;
        this.DatabaseTableConfigUtil = str7;
        this.PrepareContext = i;
        this.MyBillsEntityDataFactory = str8;
        this.PlaceComponentResult = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str9;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<BillSubscriptionHighlightModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BillSubscriptionHighlightModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new BillSubscriptionHighlightModel(readString, readString2, readString3, valueOf, parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readLong(), parcel.readString(), MoneyViewModel.CREATOR.createFromParcel(parcel), MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BillSubscriptionHighlightModel[] newArray(int i) {
            return new BillSubscriptionHighlightModel[i];
        }
    }

    public static /* synthetic */ BillSubscriptionHighlightModel PlaceComponentResult(BillSubscriptionHighlightModel billSubscriptionHighlightModel, MoneyViewModel moneyViewModel) {
        String str = billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str2 = billSubscriptionHighlightModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = billSubscriptionHighlightModel.BuiltInFictitiousFunctionClassFactory;
        Boolean bool = billSubscriptionHighlightModel.getAuthRequestContext;
        String str4 = billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str5 = billSubscriptionHighlightModel.scheduleImpl;
        Long l = billSubscriptionHighlightModel.lookAheadTest;
        long j = billSubscriptionHighlightModel.moveToNextValue;
        String str6 = billSubscriptionHighlightModel.initRecordTimeStamp;
        MoneyViewModel moneyViewModel2 = billSubscriptionHighlightModel.getErrorConfigVersion;
        String str7 = billSubscriptionHighlightModel.DatabaseTableConfigUtil;
        int i = billSubscriptionHighlightModel.PrepareContext;
        String str8 = billSubscriptionHighlightModel.MyBillsEntityDataFactory;
        boolean z = billSubscriptionHighlightModel.PlaceComponentResult;
        String str9 = billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        return new BillSubscriptionHighlightModel(str, str2, str3, bool, str4, str5, l, j, str6, moneyViewModel, moneyViewModel2, str7, i, str8, z, str9);
    }
}
