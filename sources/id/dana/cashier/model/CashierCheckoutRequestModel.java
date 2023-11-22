package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010,\u001a\u00020\r\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001d\u0012\b\b\u0002\u0010.\u001a\u00020\r\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001d\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u00103\u001a\u00020\u0007\u0012\b\b\u0002\u00104\u001a\u00020\r¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001dX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0012\u0010 \u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u001a\u0010#\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0019\u0010\fR\u0014\u0010&\u001a\u0004\u0018\u00010\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b&\u0010\u0016R\u0012\u0010$\u001a\u00020\rX\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010'\u001a\u0004\u0018\u00010\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010%R\u001a\u0010(\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001dX\u0087\u0002¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0014\u0010)\u001a\u0004\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b'\u0010\u0016"}, d2 = {"Lid/dana/cashier/model/CashierCheckoutRequestModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "PlaceComponentResult", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "Ljava/lang/Integer;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "", "Ljava/util/List;", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "Ljava/lang/Boolean;", "scheduleImpl", "initRecordTimeStamp", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierCheckoutRequestModel implements Parcelable {
    public static final Parcelable.Creator<CashierCheckoutRequestModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public List<String> PlaceComponentResult;
    public List<String> GetContactSyncConfig;
    public CheckoutExternalInfo KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public Boolean initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Integer BuiltInFictitiousFunctionClassFactory;
    public String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public Boolean scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    public CashierCheckoutRequestModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, 8191, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierCheckoutRequestModel) {
            CashierCheckoutRequestModel cashierCheckoutRequestModel = (CashierCheckoutRequestModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, cashierCheckoutRequestModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.initRecordTimeStamp, cashierCheckoutRequestModel.initRecordTimeStamp) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierCheckoutRequestModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getErrorConfigVersion, cashierCheckoutRequestModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, cashierCheckoutRequestModel.lookAheadTest) && Intrinsics.areEqual(this.GetContactSyncConfig, cashierCheckoutRequestModel.GetContactSyncConfig) && Intrinsics.areEqual(this.moveToNextValue, cashierCheckoutRequestModel.moveToNextValue) && Intrinsics.areEqual(this.scheduleImpl, cashierCheckoutRequestModel.scheduleImpl) && Intrinsics.areEqual(this.PlaceComponentResult, cashierCheckoutRequestModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, cashierCheckoutRequestModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, cashierCheckoutRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == cashierCheckoutRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda0 && Intrinsics.areEqual(this.getAuthRequestContext, cashierCheckoutRequestModel.getAuthRequestContext);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.MyBillsEntityDataFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.initRecordTimeStamp;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        CheckoutExternalInfo checkoutExternalInfo = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = checkoutExternalInfo == null ? 0 : checkoutExternalInfo.hashCode();
        String str2 = this.getErrorConfigVersion;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        int hashCode5 = this.lookAheadTest.hashCode();
        List<String> list = this.GetContactSyncConfig;
        int hashCode6 = list == null ? 0 : list.hashCode();
        int hashCode7 = this.moveToNextValue.hashCode();
        Boolean bool2 = this.scheduleImpl;
        int hashCode8 = bool2 == null ? 0 : bool2.hashCode();
        List<String> list2 = this.PlaceComponentResult;
        int hashCode9 = list2 == null ? 0 : list2.hashCode();
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode10 = num == null ? 0 : num.hashCode();
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode11 = str3 != null ? str3.hashCode() : 0;
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + i) * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierCheckoutRequestModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.MyBillsEntityDataFactory);
        Boolean bool = this.initRecordTimeStamp;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, p1);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.lookAheadTest);
        p0.writeStringList(this.GetContactSyncConfig);
        p0.writeString(this.moveToNextValue);
        Boolean bool2 = this.scheduleImpl;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        p0.writeStringList(this.PlaceComponentResult);
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0);
        p0.writeString(this.getAuthRequestContext);
    }

    public CashierCheckoutRequestModel(String str, Boolean bool, CheckoutExternalInfo checkoutExternalInfo, String str2, String str3, List<String> list, String str4, Boolean bool2, List<String> list2, Integer num, String str5, boolean z, String str6) {
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.MyBillsEntityDataFactory = str;
        this.initRecordTimeStamp = bool;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkoutExternalInfo;
        this.getErrorConfigVersion = str2;
        this.lookAheadTest = str3;
        this.GetContactSyncConfig = list;
        this.moveToNextValue = str4;
        this.scheduleImpl = bool2;
        this.PlaceComponentResult = list2;
        this.BuiltInFictitiousFunctionClassFactory = num;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        this.getAuthRequestContext = str6;
    }

    public /* synthetic */ CashierCheckoutRequestModel(String str, Boolean bool, CheckoutExternalInfo checkoutExternalInfo, String str2, String str3, List list, String str4, Boolean bool2, List list2, Integer num, String str5, boolean z, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? null : checkoutExternalInfo, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? null : list, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? null : bool2, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : num, (i & 1024) == 0 ? str5 : null, (i & 2048) != 0 ? false : z, (i & 4096) == 0 ? str6 : "");
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final boolean PlaceComponentResult() {
        if (Intrinsics.areEqual(this.initRecordTimeStamp, Boolean.TRUE)) {
            String str = this.MyBillsEntityDataFactory;
            return !(str == null || str.length() == 0);
        }
        return false;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CashierCheckoutRequestModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CashierCheckoutRequestModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            CheckoutExternalInfo checkoutExternalInfo = (CheckoutExternalInfo) parcel.readParcelable(CashierCheckoutRequestModel.class.getClassLoader());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new CashierCheckoutRequestModel(readString, valueOf, checkoutExternalInfo, readString2, readString3, createStringArrayList, readString4, valueOf2, parcel.createStringArrayList(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CashierCheckoutRequestModel[] newArray(int i) {
            return new CashierCheckoutRequestModel[i];
        }
    }
}
