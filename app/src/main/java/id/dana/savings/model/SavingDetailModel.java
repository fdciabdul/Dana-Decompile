package id.dana.savings.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0006\u001a\u00020\u0018\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u0018X\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/savings/model/SavingDetailModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "MyBillsEntityDataFactory", "Lid/dana/savings/model/SavingModel;", "Lid/dana/savings/model/SavingModel;", "", "Lid/dana/savings/model/TopUpModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "p2", "<init>", "(Lid/dana/savings/model/SavingModel;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SavingDetailModel implements Parcelable {
    public static final Parcelable.Creator<SavingDetailModel> CREATOR = new Creator();
    public final SavingModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<TopUpModel> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SavingDetailModel) {
            SavingDetailModel savingDetailModel = (SavingDetailModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, savingDetailModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, savingDetailModel.getAuthRequestContext) && this.MyBillsEntityDataFactory == savingDetailModel.MyBillsEntityDataFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingDetailModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
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
        this.BuiltInFictitiousFunctionClassFactory.writeToParcel(p0, p1);
        List<TopUpModel> list = this.getAuthRequestContext;
        p0.writeInt(list.size());
        Iterator<TopUpModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
    }

    public SavingDetailModel(SavingModel savingModel, List<TopUpModel> list, boolean z) {
        Intrinsics.checkNotNullParameter(savingModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = savingModel;
        this.getAuthRequestContext = list;
        this.MyBillsEntityDataFactory = z;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<SavingDetailModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SavingDetailModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            SavingModel createFromParcel = SavingModel.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(TopUpModel.CREATOR.createFromParcel(parcel));
            }
            return new SavingDetailModel(createFromParcel, arrayList, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SavingDetailModel[] newArray(int i) {
            return new SavingDetailModel[i];
        }
    }
}
