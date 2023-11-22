package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010.\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010/\u001a\u0004\u0018\u00010\u001b\u0012\b\u00100\u001a\u0004\u0018\u00010\u001b\u0012\b\u00101\u001a\u0004\u0018\u00010\u001b\u0012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0018\u0012\b\u00103\u001a\u0004\u0018\u00010\u000b\u0012\b\u00104\u001a\u0004\u0018\u00010\u000b\u0012\b\u00105\u001a\u0004\u0018\u00010\u0007\u0012\b\u00106\u001a\u0004\u0018\u00010\u0002\u0012\b\u00107\u001a\u0004\u0018\u00010\u000b\u0012\b\u00108\u001a\u0004\u0018\u00010\u000b\u0012\b\u00109\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010:\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010;\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0013\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0013\u0010 \u001a\u0004\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0013\u0010!\u001a\u0004\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0013\u0010$\u001a\u0004\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0013\u0010&\u001a\u0004\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b%\u0010\u001cR\u0019\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0013\u0010#\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0013\u0010%\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010+\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0013\u0010*\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b,\u0010\u0014"}, d2 = {"Lid/dana/cashier/model/TopUpConsultModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Ljava/lang/Boolean;", "", "Ljava/util/List;", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "lookAheadTest", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "initRecordTimeStamp", "Lid/dana/cashier/model/PayMethodViewDtoModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/Integer;", "PrepareContext", "isLayoutRequested", "newProxyInstance", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpConsultModel implements Parcelable {
    public static final Parcelable.Creator<TopUpConsultModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final MoneyViewModel initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final Boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final Boolean DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final Integer GetContactSyncConfig;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<String> getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final Boolean isLayoutRequested;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final List<PayMethodViewDtoModel> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final MoneyViewModel scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String PrepareContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String lookAheadTest;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TopUpConsultModel) {
            TopUpConsultModel topUpConsultModel = (TopUpConsultModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, topUpConsultModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, topUpConsultModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, topUpConsultModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, topUpConsultModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.scheduleImpl, topUpConsultModel.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, topUpConsultModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.initRecordTimeStamp, topUpConsultModel.initRecordTimeStamp) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, topUpConsultModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.getErrorConfigVersion, topUpConsultModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, topUpConsultModel.lookAheadTest) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, topUpConsultModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.GetContactSyncConfig, topUpConsultModel.GetContactSyncConfig) && Intrinsics.areEqual(this.PrepareContext, topUpConsultModel.PrepareContext) && Intrinsics.areEqual(this.PlaceComponentResult, topUpConsultModel.PlaceComponentResult) && Intrinsics.areEqual(this.isLayoutRequested, topUpConsultModel.isLayoutRequested) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, topUpConsultModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.moveToNextValue, topUpConsultModel.moveToNextValue);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.MyBillsEntityDataFactory;
        int hashCode = bool == null ? 0 : bool.hashCode();
        List<String> list = this.getAuthRequestContext;
        int hashCode2 = list == null ? 0 : list.hashCode();
        MoneyViewModel moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        MoneyViewModel moneyViewModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode4 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        MoneyViewModel moneyViewModel3 = this.scheduleImpl;
        int hashCode5 = moneyViewModel3 == null ? 0 : moneyViewModel3.hashCode();
        MoneyViewModel moneyViewModel4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode6 = moneyViewModel4 == null ? 0 : moneyViewModel4.hashCode();
        MoneyViewModel moneyViewModel5 = this.initRecordTimeStamp;
        int hashCode7 = moneyViewModel5 == null ? 0 : moneyViewModel5.hashCode();
        List<PayMethodViewDtoModel> list2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode8 = list2 == null ? 0 : list2.hashCode();
        String str = this.getErrorConfigVersion;
        int hashCode9 = str == null ? 0 : str.hashCode();
        String str2 = this.lookAheadTest;
        int hashCode10 = str2 == null ? 0 : str2.hashCode();
        Boolean bool2 = this.DatabaseTableConfigUtil;
        int hashCode11 = bool2 == null ? 0 : bool2.hashCode();
        Integer num = this.GetContactSyncConfig;
        int hashCode12 = num == null ? 0 : num.hashCode();
        String str3 = this.PrepareContext;
        int hashCode13 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.PlaceComponentResult;
        int hashCode14 = str4 == null ? 0 : str4.hashCode();
        Boolean bool3 = this.isLayoutRequested;
        int hashCode15 = bool3 == null ? 0 : bool3.hashCode();
        String str5 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode16 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.moveToNextValue;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpConsultModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Boolean bool = this.MyBillsEntityDataFactory;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeStringList(this.getAuthRequestContext);
        MoneyViewModel moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel3 = this.scheduleImpl;
        if (moneyViewModel3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel3.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (moneyViewModel4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel4.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel5 = this.initRecordTimeStamp;
        if (moneyViewModel5 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel5.writeToParcel(p0, p1);
        }
        List<PayMethodViewDtoModel> list = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<PayMethodViewDtoModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.lookAheadTest);
        Boolean bool2 = this.DatabaseTableConfigUtil;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Integer num = this.GetContactSyncConfig;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        p0.writeString(this.PrepareContext);
        p0.writeString(this.PlaceComponentResult);
        Boolean bool3 = this.isLayoutRequested;
        if (bool3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.moveToNextValue);
    }

    public TopUpConsultModel(Boolean bool, List<String> list, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, MoneyViewModel moneyViewModel4, MoneyViewModel moneyViewModel5, List<PayMethodViewDtoModel> list2, String str, String str2, Boolean bool2, Integer num, String str3, String str4, Boolean bool3, String str5, String str6) {
        this.MyBillsEntityDataFactory = bool;
        this.getAuthRequestContext = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyViewModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = moneyViewModel2;
        this.scheduleImpl = moneyViewModel3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = moneyViewModel4;
        this.initRecordTimeStamp = moneyViewModel5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = list2;
        this.getErrorConfigVersion = str;
        this.lookAheadTest = str2;
        this.DatabaseTableConfigUtil = bool2;
        this.GetContactSyncConfig = num;
        this.PrepareContext = str3;
        this.PlaceComponentResult = str4;
        this.isLayoutRequested = bool3;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.moveToNextValue = str6;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<TopUpConsultModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TopUpConsultModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "");
            Boolean valueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            MoneyViewModel createFromParcel = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel2 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel3 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel4 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel5 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(PayMethodViewDtoModel.CREATOR.createFromParcel(parcel));
                }
            }
            return new TopUpConsultModel(valueOf, createStringArrayList, createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, arrayList, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TopUpConsultModel[] newArray(int i) {
            return new TopUpConsultModel[i];
        }
    }
}
