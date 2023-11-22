package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lid/dana/cashier/model/PaylaterOnboardingInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/cashier/model/PaylaterOnboardingBenefitModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "MyBillsEntityDataFactory", "getAuthRequestContext", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PaylaterOnboardingInfoModel implements Parcelable {
    public static final Parcelable.Creator<PaylaterOnboardingInfoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<PaylaterOnboardingBenefitModel> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String getAuthRequestContext;

    public PaylaterOnboardingInfoModel() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        List<PaylaterOnboardingBenefitModel> list = this.MyBillsEntityDataFactory;
        p0.writeInt(list.size());
        Iterator<PaylaterOnboardingBenefitModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
    }

    public PaylaterOnboardingInfoModel(String str, String str2, List<PaylaterOnboardingBenefitModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.MyBillsEntityDataFactory = list;
    }

    public /* synthetic */ PaylaterOnboardingInfoModel(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Creator implements Parcelable.Creator<PaylaterOnboardingInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PaylaterOnboardingInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(PaylaterOnboardingBenefitModel.CREATOR.createFromParcel(parcel));
            }
            return new PaylaterOnboardingInfoModel(readString, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PaylaterOnboardingInfoModel[] newArray(int i) {
            return new PaylaterOnboardingInfoModel[i];
        }
    }
}
