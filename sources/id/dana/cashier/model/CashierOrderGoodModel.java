package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u00100\u001a\u0004\u0018\u00010\u0007\u0012\b\u00101\u001a\u0004\u0018\u00010\u0007\u0012\b\u00102\u001a\u0004\u0018\u00010\u0019\u0012\b\u00103\u001a\u0004\u0018\u00010\u000b\u0012\b\u00104\u001a\u0004\u0018\u00010\u000b\u0012\b\u00105\u001a\u0004\u0018\u00010\u000b\u0012\b\u00106\u001a\u0004\u0018\u00010\u000b\u0012\b\u00107\u001a\u0004\u0018\u00010\u000b\u0012\b\u00108\u001a\u0004\u0018\u00010\u000b\u0012\b\u00109\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\"¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0013\u0010!\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0017R \u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\"X\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010#R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b$\u0010\u001dR\u0014\u0010 \u001a\u0004\u0018\u00010%X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010&R\u0013\u0010(\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b'\u0010\u0017R\u0013\u0010)\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0013\u0010*\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b(\u0010\u0017R\u0013\u0010+\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0013\u0010'\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b+\u0010\u0017R\u0013\u0010,\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b,\u0010\u0017R\u0012\u0010/\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/cashier/model/CashierOrderGoodModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/AddOnChannelSupportInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/AddOnChannelSupportInfo;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getAuthRequestContext", "Ljava/lang/Boolean;", "scheduleImpl", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "Ljava/util/Map;", "moveToNextValue", "Lid/dana/cashier/model/OrderCreateExtendInfoModel;", "Lid/dana/cashier/model/OrderCreateExtendInfoModel;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "I", "newProxyInstance", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/model/OrderCreateExtendInfoModel;ILid/dana/cashier/model/AddOnChannelSupportInfo;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierOrderGoodModel implements Parcelable {
    public static final Parcelable.Creator<CashierOrderGoodModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final Boolean GetContactSyncConfig;
    public AddOnChannelSupportInfo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public Map<String, AddOnChannelSupportInfo> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public int newProxyInstance;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MoneyViewModel getAuthRequestContext;
    public final String PrepareContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public OrderCreateExtendInfoModel lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final Boolean scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final Boolean getErrorConfigVersion;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierOrderGoodModel) {
            CashierOrderGoodModel cashierOrderGoodModel = (CashierOrderGoodModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, cashierOrderGoodModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, cashierOrderGoodModel.PlaceComponentResult) && Intrinsics.areEqual(this.getErrorConfigVersion, cashierOrderGoodModel.getErrorConfigVersion) && Intrinsics.areEqual(this.scheduleImpl, cashierOrderGoodModel.scheduleImpl) && Intrinsics.areEqual(this.getAuthRequestContext, cashierOrderGoodModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, cashierOrderGoodModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, cashierOrderGoodModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.initRecordTimeStamp, cashierOrderGoodModel.initRecordTimeStamp) && Intrinsics.areEqual(this.PrepareContext, cashierOrderGoodModel.PrepareContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.GetContactSyncConfig, cashierOrderGoodModel.GetContactSyncConfig) && Intrinsics.areEqual(this.lookAheadTest, cashierOrderGoodModel.lookAheadTest) && this.newProxyInstance == cashierOrderGoodModel.newProxyInstance && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.moveToNextValue, cashierOrderGoodModel.moveToNextValue);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.PlaceComponentResult;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.getErrorConfigVersion;
        int hashCode3 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.scheduleImpl;
        int hashCode4 = bool3 == null ? 0 : bool3.hashCode();
        MoneyViewModel moneyViewModel = this.getAuthRequestContext;
        int hashCode5 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.DatabaseTableConfigUtil;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.initRecordTimeStamp;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.PrepareContext;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode11 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        Boolean bool4 = this.GetContactSyncConfig;
        int hashCode13 = bool4 == null ? 0 : bool4.hashCode();
        OrderCreateExtendInfoModel orderCreateExtendInfoModel = this.lookAheadTest;
        int hashCode14 = orderCreateExtendInfoModel == null ? 0 : orderCreateExtendInfoModel.hashCode();
        int i = this.newProxyInstance;
        AddOnChannelSupportInfo addOnChannelSupportInfo = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode15 = addOnChannelSupportInfo == null ? 0 : addOnChannelSupportInfo.hashCode();
        Map<String, AddOnChannelSupportInfo> map = this.moveToNextValue;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + i) * 31) + hashCode15) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierOrderGoodModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        Boolean bool = this.PlaceComponentResult;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.getErrorConfigVersion;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.scheduleImpl;
        if (bool3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        MoneyViewModel moneyViewModel = this.getAuthRequestContext;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.DatabaseTableConfigUtil);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        Boolean bool4 = this.GetContactSyncConfig;
        if (bool4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        OrderCreateExtendInfoModel orderCreateExtendInfoModel = this.lookAheadTest;
        if (orderCreateExtendInfoModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            orderCreateExtendInfoModel.writeToParcel(p0, p1);
        }
        p0.writeInt(this.newProxyInstance);
        AddOnChannelSupportInfo addOnChannelSupportInfo = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (addOnChannelSupportInfo == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            addOnChannelSupportInfo.writeToParcel(p0, p1);
        }
        Map<String, AddOnChannelSupportInfo> map = this.moveToNextValue;
        if (map == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(map.size());
        for (Map.Entry<String, AddOnChannelSupportInfo> entry : map.entrySet()) {
            p0.writeString(entry.getKey());
            entry.getValue().writeToParcel(p0, p1);
        }
    }

    public CashierOrderGoodModel(String str, Boolean bool, Boolean bool2, Boolean bool3, MoneyViewModel moneyViewModel, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool4, OrderCreateExtendInfoModel orderCreateExtendInfoModel, int i, AddOnChannelSupportInfo addOnChannelSupportInfo, Map<String, AddOnChannelSupportInfo> map) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = bool;
        this.getErrorConfigVersion = bool2;
        this.scheduleImpl = bool3;
        this.getAuthRequestContext = moneyViewModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
        this.MyBillsEntityDataFactory = str3;
        this.DatabaseTableConfigUtil = str4;
        this.initRecordTimeStamp = str5;
        this.PrepareContext = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str8;
        this.GetContactSyncConfig = bool4;
        this.lookAheadTest = orderCreateExtendInfoModel;
        this.newProxyInstance = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addOnChannelSupportInfo;
        this.moveToNextValue = map;
    }

    public /* synthetic */ CashierOrderGoodModel(String str, Boolean bool, Boolean bool2, Boolean bool3, MoneyViewModel moneyViewModel, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool4, OrderCreateExtendInfoModel orderCreateExtendInfoModel, int i, AddOnChannelSupportInfo addOnChannelSupportInfo, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bool, bool2, bool3, moneyViewModel, str2, str3, str4, str5, str6, str7, str8, bool4, (i2 & 8192) != 0 ? null : orderCreateExtendInfoModel, (i2 & 16384) != 0 ? 1 : i, (32768 & i2) != 0 ? null : addOnChannelSupportInfo, (i2 & 65536) != 0 ? null : map);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CashierOrderGoodModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CashierOrderGoodModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            int i = 0;
            LinkedHashMap linkedHashMap = null;
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            MoneyViewModel createFromParcel = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            OrderCreateExtendInfoModel createFromParcel2 = parcel.readInt() == 0 ? null : OrderCreateExtendInfoModel.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            AddOnChannelSupportInfo createFromParcel3 = parcel.readInt() == 0 ? null : AddOnChannelSupportInfo.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                while (i != readInt2) {
                    linkedHashMap.put(parcel.readString(), AddOnChannelSupportInfo.CREATOR.createFromParcel(parcel));
                    i++;
                    readInt2 = readInt2;
                    readString8 = readString8;
                }
            }
            return new CashierOrderGoodModel(readString, valueOf, valueOf2, valueOf3, createFromParcel, readString2, readString3, readString4, readString5, readString6, readString7, readString8, valueOf4, createFromParcel2, readInt, createFromParcel3, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CashierOrderGoodModel[] newArray(int i) {
            return new CashierOrderGoodModel[i];
        }
    }

    public static /* synthetic */ CashierOrderGoodModel KClassImpl$Data$declaredNonStaticMembers$2(CashierOrderGoodModel cashierOrderGoodModel, String str, Boolean bool, Boolean bool2, Boolean bool3, MoneyViewModel moneyViewModel, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool4, OrderCreateExtendInfoModel orderCreateExtendInfoModel, int i, AddOnChannelSupportInfo addOnChannelSupportInfo, Map map, int i2) {
        return new CashierOrderGoodModel((i2 & 1) != 0 ? cashierOrderGoodModel.BuiltInFictitiousFunctionClassFactory : str, (i2 & 2) != 0 ? cashierOrderGoodModel.PlaceComponentResult : bool, (i2 & 4) != 0 ? cashierOrderGoodModel.getErrorConfigVersion : bool2, (i2 & 8) != 0 ? cashierOrderGoodModel.scheduleImpl : bool3, (i2 & 16) != 0 ? cashierOrderGoodModel.getAuthRequestContext : moneyViewModel, (i2 & 32) != 0 ? cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 : str2, (i2 & 64) != 0 ? cashierOrderGoodModel.MyBillsEntityDataFactory : str3, (i2 & 128) != 0 ? cashierOrderGoodModel.DatabaseTableConfigUtil : str4, (i2 & 256) != 0 ? cashierOrderGoodModel.initRecordTimeStamp : str5, (i2 & 512) != 0 ? cashierOrderGoodModel.PrepareContext : str6, (i2 & 1024) != 0 ? cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda1 : str7, (i2 & 2048) != 0 ? cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda2 : str8, (i2 & 4096) != 0 ? cashierOrderGoodModel.GetContactSyncConfig : bool4, (i2 & 8192) != 0 ? cashierOrderGoodModel.lookAheadTest : orderCreateExtendInfoModel, (i2 & 16384) != 0 ? cashierOrderGoodModel.newProxyInstance : i, (i2 & 32768) != 0 ? cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2 : addOnChannelSupportInfo, (i2 & 65536) != 0 ? cashierOrderGoodModel.moveToNextValue : map);
    }
}
