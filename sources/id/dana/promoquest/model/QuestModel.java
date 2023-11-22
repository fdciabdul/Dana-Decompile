package id.dana.promoquest.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.R;
import id.dana.extension.lang.StringExtKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0013\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B}\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R \u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0015\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0017\u0010\fR\u0011\u0010\u0019\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010 \u001a\u0004\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010!\u001a\u0004\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\u0016"}, d2 = {"Lid/dana/promoquest/model/QuestModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "Ljava/util/Map;", "PlaceComponentResult", "getErrorConfigVersion", "Z", "lookAheadTest", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QuestModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Map<String, String> PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String moveToNextValue;
    public static final Parcelable.Creator<QuestModel> CREATOR = new Creator();

    public QuestModel() {
        this(null, null, null, null, null, null, null, false, null, 511, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof QuestModel) {
            QuestModel questModel = (QuestModel) p0;
            return Intrinsics.areEqual(this.getErrorConfigVersion, questModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, questModel.lookAheadTest) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, questModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, questModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, questModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.moveToNextValue, questModel.moveToNextValue) && Intrinsics.areEqual(this.scheduleImpl, questModel.scheduleImpl) && this.MyBillsEntityDataFactory == questModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.PlaceComponentResult, questModel.PlaceComponentResult);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.getErrorConfigVersion;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.lookAheadTest;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.moveToNextValue;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.scheduleImpl;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        Map<String, String> map = this.PlaceComponentResult;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuestModel(getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.scheduleImpl);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        Map<String, String> map = this.PlaceComponentResult;
        if (map == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            p0.writeString(entry.getKey());
            p0.writeString(entry.getValue());
        }
    }

    public QuestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, Map<String, String> map) {
        this.getErrorConfigVersion = str;
        this.lookAheadTest = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.moveToNextValue = str6;
        this.scheduleImpl = str7;
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = map;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public /* synthetic */ QuestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) == 0 ? str7 : null, (i & 128) != 0 ? false : z, (i & 256) != 0 ? new HashMap() : map);
    }

    @JvmName(name = "getAuthRequestContext")
    public final int getAuthRequestContext() {
        if (!this.MyBillsEntityDataFactory) {
            return StringExtKt.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, "COMPLETE", "FINISH") ? R.drawable.ic_promo_quest_item_success : R.drawable.ic_promo_quest_item_incomplete;
        }
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return Intrinsics.areEqual(str, "FINISH") ? R.drawable.ic_promo_quest_item_claimed : Intrinsics.areEqual(str, "COMPLETE") ? R.drawable.ic_promo_quest_item_not_claimed : R.drawable.ic_promo_quest_item_not_available;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, "COMPLETE");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<QuestModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ QuestModel createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                }
                linkedHashMap = linkedHashMap2;
            }
            return new QuestModel(readString, readString2, readString3, readString4, readString5, readString6, readString7, z, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ QuestModel[] newArray(int i) {
            return new QuestModel[i];
        }
    }
}
