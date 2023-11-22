package id.dana.promoquest.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u00103\u001a\u00020\u0007\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u00105\u001a\u00020\u0007\u0012\b\b\u0002\u00106\u001a\u00020\u000b¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010#\u001a\u0004\u0018\u00010!X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0014\u0010$\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010 R\u0014\u0010%\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010 R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010 R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010 R\u0014\u0010&\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0014\u0010'\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0012\u0010(\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)X\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010+"}, d2 = {"Lid/dana/promoquest/model/MissionModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "GetContactSyncConfig", "Z", "getAuthRequestContext", "()Z", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "DatabaseTableConfigUtil", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "Ljava/lang/String;", "Ljava/util/Date;", "Ljava/util/Date;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "PrepareContext", "isLayoutRequested", "", "Lid/dana/promoquest/model/QuestModel;", "Ljava/util/List;", "newProxyInstance", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MissionModel implements Parcelable {
    public static final Parcelable.Creator<MissionModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String initRecordTimeStamp;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Date lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String GetContactSyncConfig;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public List<QuestModel> newProxyInstance;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String isLayoutRequested;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MissionModel) {
            MissionModel missionModel = (MissionModel) p0;
            return Intrinsics.areEqual(this.initRecordTimeStamp, missionModel.initRecordTimeStamp) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, missionModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, missionModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.getErrorConfigVersion, missionModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, missionModel.lookAheadTest) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, missionModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.GetContactSyncConfig, missionModel.GetContactSyncConfig) && Intrinsics.areEqual(this.PrepareContext, missionModel.PrepareContext) && this.MyBillsEntityDataFactory == missionModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.newProxyInstance, missionModel.newProxyInstance) && this.PlaceComponentResult == missionModel.PlaceComponentResult && Intrinsics.areEqual(this.isLayoutRequested, missionModel.isLayoutRequested);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.initRecordTimeStamp;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.DatabaseTableConfigUtil;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.getErrorConfigVersion;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Date date = this.lookAheadTest;
        int hashCode5 = date == null ? 0 : date.hashCode();
        String str5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.GetContactSyncConfig;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.PrepareContext;
        int hashCode8 = str7 != null ? str7.hashCode() : 0;
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode9 = this.newProxyInstance.hashCode();
        boolean z2 = this.PlaceComponentResult;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i) * 31) + hashCode9) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.isLayoutRequested.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MissionModel(initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.DatabaseTableConfigUtil);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeSerializable(this.lookAheadTest);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.PrepareContext);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        List<QuestModel> list = this.newProxyInstance;
        p0.writeInt(list.size());
        Iterator<QuestModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        p0.writeString(this.isLayoutRequested);
    }

    public MissionModel(String str, String str2, String str3, String str4, Date date, String str5, String str6, String str7, boolean z, List<QuestModel> list, boolean z2, String str8) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.initRecordTimeStamp = str;
        this.DatabaseTableConfigUtil = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str3;
        this.getErrorConfigVersion = str4;
        this.lookAheadTest = date;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str5;
        this.GetContactSyncConfig = str6;
        this.PrepareContext = str7;
        this.MyBillsEntityDataFactory = z;
        this.newProxyInstance = list;
        this.PlaceComponentResult = z2;
        this.isLayoutRequested = str8;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return StringsKt.equals("ACTIVE", this.NetworkUserEntityData$$ExternalSyntheticLambda2, true);
    }

    @JvmName(name = "getErrorConfigVersion")
    private boolean getErrorConfigVersion() {
        return StringsKt.equals("FINISH", this.NetworkUserEntityData$$ExternalSyntheticLambda2, true);
    }

    @JvmName(name = "moveToNextValue")
    private boolean moveToNextValue() {
        return StringsKt.equals("COMPLETE", this.NetworkUserEntityData$$ExternalSyntheticLambda2, true);
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return StringsKt.equals("CLOSE", this.NetworkUserEntityData$$ExternalSyntheticLambda2, true);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final boolean MyBillsEntityDataFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2() || moveToNextValue();
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return getErrorConfigVersion() || NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MissionModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MissionModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Date date = (Date) parcel.readSerializable();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(QuestModel.CREATOR.createFromParcel(parcel));
            }
            return new MissionModel(readString, readString2, readString3, readString4, date, readString5, readString6, readString7, z, arrayList, parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MissionModel[] newArray(int i) {
            return new MissionModel[i];
        }
    }
}
