package id.dana.phototips.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0006\u001a\u00020\r\u0012\b\b\u0002\u0010\u0007\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0012\u0010\u000e\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0012\u0010\u0012\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f"}, d2 = {"Lid/dana/phototips/model/PhotoTipsModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "I", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhotoTipsModel implements Parcelable {
    public static final Parcelable.Creator<PhotoTipsModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public List<String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String lookAheadTest;
    public int PlaceComponentResult;
    public int getAuthRequestContext;

    public PhotoTipsModel() {
        this(null, null, 0, 0, 0, null, 63, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeInt(this.PlaceComponentResult);
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeInt(this.getAuthRequestContext);
        p0.writeStringList(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public PhotoTipsModel(String str, String str2, int i, int i2, int i3, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.lookAheadTest = str;
        this.MyBillsEntityDataFactory = str2;
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.getAuthRequestContext = i3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    public /* synthetic */ PhotoTipsModel(String str, String str2, int i, int i2, int i3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) == 0 ? str2 : "", (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<PhotoTipsModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PhotoTipsModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PhotoTipsModel(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PhotoTipsModel[] newArray(int i) {
            return new PhotoTipsModel[i];
        }
    }
}
