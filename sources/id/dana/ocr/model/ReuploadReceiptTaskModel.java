package id.dana.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB!\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0015\u001a\u00020\u0017X\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/ocr/model/ReuploadReceiptTaskModel;", "Lid/dana/ocr/model/SnapReceiptTaskModel;", "Landroid/os/Parcelable;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "Lid/dana/ocr/model/OCRRequestModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/ocr/model/OCRRequestModel;", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/ocr/model/OCRRequestModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ReuploadReceiptTaskModel extends SnapReceiptTaskModel implements Parcelable {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final OCRRequestModel getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public static final Parcelable.Creator<ReuploadReceiptTaskModel> CREATOR = new Creator();

    @Override // id.dana.ocr.model.SnapReceiptTaskModel, android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeParcelable(this.getAuthRequestContext, p1);
    }

    public /* synthetic */ ReuploadReceiptTaskModel(String str, String str2, OCRRequestModel oCRRequestModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "reupload_task_action" : str2, oCRRequestModel);
    }

    @Override // id.dana.ocr.model.SnapReceiptTaskModel
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.ocr.model.SnapReceiptTaskModel
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReuploadReceiptTaskModel(String str, String str2, OCRRequestModel oCRRequestModel) {
        super(str, str2);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(oCRRequestModel, "");
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = str2;
        this.getAuthRequestContext = oCRRequestModel;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<ReuploadReceiptTaskModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ReuploadReceiptTaskModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ReuploadReceiptTaskModel(parcel.readString(), parcel.readString(), (OCRRequestModel) parcel.readParcelable(ReuploadReceiptTaskModel.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ReuploadReceiptTaskModel[] newArray(int i) {
            return new ReuploadReceiptTaskModel[i];
        }
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ReuploadReceiptTaskModel) {
            ReuploadReceiptTaskModel reuploadReceiptTaskModel = (ReuploadReceiptTaskModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, reuploadReceiptTaskModel.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, reuploadReceiptTaskModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, reuploadReceiptTaskModel.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.PlaceComponentResult.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReuploadReceiptTaskModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }
}
