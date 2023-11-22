package id.dana.cancelsurvey.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014"}, d2 = {"Lid/dana/cancelsurvey/model/BottomSheetCancelReasonModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/cancelsurvey/model/CancelReasonModel;", "Ljava/util/List;", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BottomSheetCancelReasonModel implements Parcelable {
    public static final Parcelable.Creator<BottomSheetCancelReasonModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<CancelReasonModel> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        List<CancelReasonModel> list = this.MyBillsEntityDataFactory;
        p0.writeInt(list.size());
        Iterator<CancelReasonModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        p0.writeString(this.PlaceComponentResult);
    }

    public BottomSheetCancelReasonModel(String str, String str2, String str3, List<CancelReasonModel> list, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.MyBillsEntityDataFactory = list;
        this.PlaceComponentResult = str4;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<BottomSheetCancelReasonModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BottomSheetCancelReasonModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(CancelReasonModel.CREATOR.createFromParcel(parcel));
            }
            return new BottomSheetCancelReasonModel(readString, readString2, readString3, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BottomSheetCancelReasonModel[] newArray(int i) {
            return new BottomSheetCancelReasonModel[i];
        }
    }
}
