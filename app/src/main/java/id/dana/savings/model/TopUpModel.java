package id.dana.savings.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*B[\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u001a\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010$\u001a\u00020\u000b\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0017\u0012\b\b\u0002\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001e\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u0018\u001a\u00020\u001aX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001dX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0012\u0010\"\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/savings/model/TopUpModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "Ljava/util/Map;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/savings/model/TopUpStatus;", "Lid/dana/savings/model/TopUpStatus;", "scheduleImpl", "getErrorConfigVersion", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/savings/model/TopUpStatus;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TopUpModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public MoneyViewModel PlaceComponentResult;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public TopUpStatus BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Map<String, String> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String scheduleImpl;
    public static final Parcelable.Creator<TopUpModel> CREATOR = new Creator();

    public TopUpModel() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TopUpModel) {
            TopUpModel topUpModel = (TopUpModel) p0;
            return Intrinsics.areEqual(this.scheduleImpl, topUpModel.scheduleImpl) && Intrinsics.areEqual(this.PlaceComponentResult, topUpModel.PlaceComponentResult) && this.BuiltInFictitiousFunctionClassFactory == topUpModel.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.MyBillsEntityDataFactory, topUpModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, topUpModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, topUpModel.getAuthRequestContext) && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == topUpModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.scheduleImpl.hashCode();
        int hashCode2 = this.PlaceComponentResult.hashCode();
        TopUpStatus topUpStatus = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + (topUpStatus == null ? 0 : topUpStatus.hashCode())) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpModel(scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.scheduleImpl);
        this.PlaceComponentResult.writeToParcel(p0, p1);
        TopUpStatus topUpStatus = this.BuiltInFictitiousFunctionClassFactory;
        if (topUpStatus == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeString(topUpStatus.name());
        }
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Map<String, String> map = this.getAuthRequestContext;
        p0.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            p0.writeString(entry.getKey());
            p0.writeString(entry.getValue());
        }
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public TopUpModel(String str, MoneyViewModel moneyViewModel, TopUpStatus topUpStatus, String str2, String str3, Map<String, String> map, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.scheduleImpl = str;
        this.PlaceComponentResult = moneyViewModel;
        this.BuiltInFictitiousFunctionClassFactory = topUpStatus;
        this.MyBillsEntityDataFactory = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.getAuthRequestContext = map;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
    }

    public /* synthetic */ TopUpModel(String str, MoneyViewModel moneyViewModel, TopUpStatus topUpStatus, String str2, String str3, Map map, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel, (i2 & 4) != 0 ? null : topUpStatus, (i2 & 8) != 0 ? "" : str2, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? new HashMap() : map, (i2 & 64) != 0 ? 0 : i);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TopUpModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TopUpModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            MoneyViewModel createFromParcel = MoneyViewModel.CREATOR.createFromParcel(parcel);
            TopUpStatus valueOf = parcel.readInt() == 0 ? null : TopUpStatus.valueOf(parcel.readString());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new TopUpModel(readString, createFromParcel, valueOf, readString2, readString3, linkedHashMap, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TopUpModel[] newArray(int i) {
            return new TopUpModel[i];
        }
    }
}
