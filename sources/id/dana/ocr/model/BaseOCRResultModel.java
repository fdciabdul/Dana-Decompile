package id.dana.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00118\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/ocr/model/BaseOCRResultModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "", "Z", "PlaceComponentResult", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroid/os/Parcel;)V", "(ZLjava/lang/String;)V", "CREATOR"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public class BaseOCRResultModel implements Parcelable {

    /* renamed from: CREATOR  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaseOCRResultModel(boolean z, String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.MyBillsEntityDataFactory = str;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public String getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseOCRResultModel(Parcel parcel) {
        this(parcel.readByte() != 0, parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeByte(getKClassImpl$Data$declaredNonStaticMembers$2() ? (byte) 1 : (byte) 0);
        p0.writeString(getMyBillsEntityDataFactory());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/ocr/model/BaseOCRResultModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lid/dana/ocr/model/BaseOCRResultModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.ocr.model.BaseOCRResultModel$CREATOR  reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<BaseOCRResultModel> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BaseOCRResultModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new BaseOCRResultModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BaseOCRResultModel[] newArray(int i) {
            return new BaseOCRResultModel[i];
        }
    }
}
