package id.dana.savings.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013\u0012\u0006\u0010\"\u001a\u00020\u001b\u0012\u0006\u0010#\u001a\u00020\u000b\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\u0006\u0010&\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0017\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0014\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001e\u001a\u00020\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013X\u0006¢\u0006\u0006\n\u0004\b \u0010\u0015"}, d2 = {"Lid/dana/savings/model/SavingCreateInitModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "PlaceComponentResult", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getErrorConfigVersion", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "lookAheadTest", "Lid/dana/savings/model/SavingCategoryModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/util/List;Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SavingCreateInitModel implements Parcelable {
    public static final Parcelable.Creator<SavingCreateInitModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final List<SavingCategoryModel> scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2;
    public String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final MoneyViewModel lookAheadTest;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SavingCreateInitModel) {
            SavingCreateInitModel savingCreateInitModel = (SavingCreateInitModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, savingCreateInitModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.scheduleImpl, savingCreateInitModel.scheduleImpl) && Intrinsics.areEqual(this.lookAheadTest, savingCreateInitModel.lookAheadTest) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, savingCreateInitModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, savingCreateInitModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, savingCreateInitModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, savingCreateInitModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.scheduleImpl.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingCreateInitModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeStringList(this.KClassImpl$Data$declaredNonStaticMembers$2);
        List<SavingCategoryModel> list = this.scheduleImpl;
        p0.writeInt(list.size());
        Iterator<SavingCategoryModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        this.lookAheadTest.writeToParcel(p0, p1);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.MyBillsEntityDataFactory);
    }

    public SavingCreateInitModel(List<String> list, List<SavingCategoryModel> list2, MoneyViewModel moneyViewModel, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.scheduleImpl = list2;
        this.lookAheadTest = moneyViewModel;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = str2;
        this.getAuthRequestContext = str3;
        this.MyBillsEntityDataFactory = str4;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<SavingCreateInitModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SavingCreateInitModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(SavingCategoryModel.CREATOR.createFromParcel(parcel));
            }
            return new SavingCreateInitModel(createStringArrayList, arrayList, MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SavingCreateInitModel[] newArray(int i) {
            return new SavingCreateInitModel[i];
        }
    }
}
