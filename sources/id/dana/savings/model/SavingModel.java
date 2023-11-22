package id.dana.savings.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\b\b\u0002\u0010,\u001a\u00020\u001b\u0012\b\b\u0002\u0010-\u001a\u00020\u001b\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\b\u00103\u001a\u0004\u0018\u00010\u0017\u0012\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001f\u0012\b\b\u0002\u00105\u001a\u00020\u0007¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fX\u0006¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010\u001c\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u001a\u0010$R\u0011\u0010%\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b%\u0010\u0014R\u0013\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0011\u0010'\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b&\u0010\u0014R\u0011\u0010(\u001a\u00020\u001bX\u0007¢\u0006\u0006\n\u0004\b(\u0010\u001dR\u0011\u0010*\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b)\u0010\u0014"}, d2 = {"Lid/dana/savings/model/SavingModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "Lid/dana/savings/model/SavingCategoryModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/savings/model/SavingCategoryModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "moveToNextValue", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "lookAheadTest", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/Map;", "getErrorConfigVersion", "Z", "()Z", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "DatabaseTableConfigUtil", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/savings/model/SavingCategoryModel;Ljava/util/Map;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SavingModel implements Parcelable {
    public static final Parcelable.Creator<SavingModel> CREATOR = new Creator();
    public final SavingCategoryModel BuiltInFictitiousFunctionClassFactory;
    public final MoneyViewModel DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public boolean moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final MoneyViewModel lookAheadTest;
    public final String scheduleImpl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SavingModel) {
            SavingModel savingModel = (SavingModel) p0;
            return Intrinsics.areEqual(this.GetContactSyncConfig, savingModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, savingModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.PlaceComponentResult, savingModel.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, savingModel.lookAheadTest) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, savingModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.scheduleImpl, savingModel.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, savingModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, savingModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, savingModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, savingModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, savingModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, savingModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.moveToNextValue == savingModel.moveToNextValue;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.GetContactSyncConfig.hashCode();
        int hashCode2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode();
        int hashCode3 = this.PlaceComponentResult.hashCode();
        int hashCode4 = this.lookAheadTest.hashCode();
        int hashCode5 = this.DatabaseTableConfigUtil.hashCode();
        int hashCode6 = this.scheduleImpl.hashCode();
        String str = this.getErrorConfigVersion;
        int hashCode7 = str == null ? 0 : str.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode8 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.getAuthRequestContext;
        int hashCode9 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.MyBillsEntityDataFactory;
        int hashCode10 = str4 == null ? 0 : str4.hashCode();
        SavingCategoryModel savingCategoryModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode11 = savingCategoryModel != null ? savingCategoryModel.hashCode() : 0;
        int hashCode12 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        boolean z = this.moveToNextValue;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingModel(GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.PlaceComponentResult);
        this.lookAheadTest.writeToParcel(p0, p1);
        this.DatabaseTableConfigUtil.writeToParcel(p0, p1);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.MyBillsEntityDataFactory);
        SavingCategoryModel savingCategoryModel = this.BuiltInFictitiousFunctionClassFactory;
        if (savingCategoryModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            savingCategoryModel.writeToParcel(p0, p1);
        }
        Map<String, String> map = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        p0.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            p0.writeString(entry.getKey());
            p0.writeString(entry.getValue());
        }
        p0.writeInt(this.moveToNextValue ? 1 : 0);
    }

    public SavingModel(String str, String str2, String str3, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str4, String str5, String str6, String str7, String str8, SavingCategoryModel savingCategoryModel, Map<String, String> map, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.GetContactSyncConfig = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str2;
        this.PlaceComponentResult = str3;
        this.lookAheadTest = moneyViewModel;
        this.DatabaseTableConfigUtil = moneyViewModel2;
        this.scheduleImpl = str4;
        this.getErrorConfigVersion = str5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str6;
        this.getAuthRequestContext = str7;
        this.MyBillsEntityDataFactory = str8;
        this.BuiltInFictitiousFunctionClassFactory = savingCategoryModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = map;
        this.moveToNextValue = z;
    }

    public /* synthetic */ SavingModel(String str, String str2, String str3, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str4, String str5, String str6, String str7, String str8, SavingCategoryModel savingCategoryModel, Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel, (i & 16) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel2, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, savingCategoryModel, (i & 2048) != 0 ? MapsKt.emptyMap() : map, (i & 4096) != 0 ? false : z);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<SavingModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SavingModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            MoneyViewModel createFromParcel = MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel2 = MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            SavingCategoryModel createFromParcel3 = parcel.readInt() == 0 ? null : SavingCategoryModel.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new SavingModel(readString, readString2, readString3, createFromParcel, createFromParcel2, readString4, readString5, readString6, readString7, readString8, createFromParcel3, linkedHashMap, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SavingModel[] newArray(int i) {
            return new SavingModel[i];
        }
    }
}
