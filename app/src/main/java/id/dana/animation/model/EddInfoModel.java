package id.dana.animation.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/home/model/EddInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "", "Lid/dana/home/model/EddQuestionInfoDTOModel;", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EddInfoModel implements Parcelable {
    public static final Parcelable.Creator<EddInfoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<EddQuestionInfoDTOModel> MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EddInfoModel() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.model.EddInfoModel.<init>():void");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof EddInfoModel) {
            EddInfoModel eddInfoModel = (EddInfoModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, eddInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, eddInfoModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (this.PlaceComponentResult.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EddInfoModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        List<EddQuestionInfoDTOModel> list = this.MyBillsEntityDataFactory;
        p0.writeInt(list.size());
        Iterator<EddQuestionInfoDTOModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
    }

    public EddInfoModel(String str, List<EddQuestionInfoDTOModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = list;
    }

    public /* synthetic */ EddInfoModel(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<EddInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EddInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(EddQuestionInfoDTOModel.CREATOR.createFromParcel(parcel));
            }
            return new EddInfoModel(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EddInfoModel[] newArray(int i) {
            return new EddInfoModel[i];
        }
    }
}
