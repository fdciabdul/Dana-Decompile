package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u0013\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0015\u0010\u001eR\u0012\u0010\u001c\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "moveToNextValue", "Z", "()Z", "p2", "p3", "p4", "p5", "<init>", "(IIIIZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MediaViewerModel implements Parcelable {
    public static final Parcelable.Creator<MediaViewerModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public int moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<MerchantImageModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MediaViewerModel) {
            MediaViewerModel mediaViewerModel = (MediaViewerModel) p0;
            return this.BuiltInFictitiousFunctionClassFactory == mediaViewerModel.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == mediaViewerModel.MyBillsEntityDataFactory && this.getAuthRequestContext == mediaViewerModel.getAuthRequestContext && this.moveToNextValue == mediaViewerModel.moveToNextValue && this.PlaceComponentResult == mediaViewerModel.PlaceComponentResult && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, mediaViewerModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = this.MyBillsEntityDataFactory;
        int i3 = this.getAuthRequestContext;
        int i4 = this.moveToNextValue;
        boolean z = this.PlaceComponentResult;
        int i5 = z;
        if (z != 0) {
            i5 = 1;
        }
        return (((((((((i * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaViewerModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeInt(this.MyBillsEntityDataFactory);
        p0.writeInt(this.getAuthRequestContext);
        p0.writeInt(this.moveToNextValue);
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        List<MerchantImageModel> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        p0.writeInt(list.size());
        Iterator<MerchantImageModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
    }

    public MediaViewerModel(int i, int i2, int i3, int i4, boolean z, List<MerchantImageModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = i2;
        this.getAuthRequestContext = i3;
        this.moveToNextValue = i4;
        this.PlaceComponentResult = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    public /* synthetic */ MediaViewerModel(int i, int i2, int i3, int i4, boolean z, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? 1 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? true : z, list);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MediaViewerModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MediaViewerModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            int readInt5 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt5);
            for (int i = 0; i != readInt5; i++) {
                arrayList.add(MerchantImageModel.CREATOR.createFromParcel(parcel));
            }
            return new MediaViewerModel(readInt, readInt2, readInt3, readInt4, z, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MediaViewerModel[] newArray(int i) {
            return new MediaViewerModel[i];
        }
    }
}
