package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0010\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/cashier/model/ConsultAgreementModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", "PlaceComponentResult", "Ljava/util/List;", "getAuthRequestContext", "", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "MyBillsEntityDataFactory", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultAgreementModel implements Parcelable {
    public static final Parcelable.Creator<ConsultAgreementModel> CREATOR = new Creator();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<AgreementInfo> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        List<AgreementInfo> list = this.getAuthRequestContext;
        if (list == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(list.size());
        Iterator<AgreementInfo> it = list.iterator();
        while (it.hasNext()) {
            p0.writeParcelable(it.next(), p1);
        }
    }

    public ConsultAgreementModel(boolean z, List<AgreementInfo> list) {
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext = list;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<ConsultAgreementModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ConsultAgreementModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "");
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(parcel.readParcelable(ConsultAgreementModel.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new ConsultAgreementModel(z, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ConsultAgreementModel[] newArray(int i) {
            return new ConsultAgreementModel[i];
        }
    }
}
