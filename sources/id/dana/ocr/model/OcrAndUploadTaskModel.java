package id.dana.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB)\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0017\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u000b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0016\u001a\u00020\u0019X\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a"}, d2 = {"Lid/dana/ocr/model/OcrAndUploadTaskModel;", "Lid/dana/ocr/model/SnapReceiptTaskModel;", "Landroid/os/Parcelable;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/ocr/model/OCRRequestModel;", "Lid/dana/ocr/model/OCRRequestModel;", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/ocr/model/OCRRequestModel;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class OcrAndUploadTaskModel extends SnapReceiptTaskModel implements Parcelable {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final OCRRequestModel PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public static final Parcelable.Creator<OcrAndUploadTaskModel> CREATOR = new Creator();

    @Override // id.dana.ocr.model.SnapReceiptTaskModel, android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeParcelable(this.PlaceComponentResult, p1);
        p0.writeString(this.MyBillsEntityDataFactory);
    }

    public /* synthetic */ OcrAndUploadTaskModel(String str, String str2, OCRRequestModel oCRRequestModel, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "ocr_and_upload_task_action" : str2, oCRRequestModel, str3);
    }

    @Override // id.dana.ocr.model.SnapReceiptTaskModel
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.ocr.model.SnapReceiptTaskModel
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OcrAndUploadTaskModel(String str, String str2, OCRRequestModel oCRRequestModel, String str3) {
        super(str, str2);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(oCRRequestModel, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = oCRRequestModel;
        this.MyBillsEntityDataFactory = str3;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<OcrAndUploadTaskModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OcrAndUploadTaskModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new OcrAndUploadTaskModel(parcel.readString(), parcel.readString(), (OCRRequestModel) parcel.readParcelable(OcrAndUploadTaskModel.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OcrAndUploadTaskModel[] newArray(int i) {
            return new OcrAndUploadTaskModel[i];
        }
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof OcrAndUploadTaskModel) {
            OcrAndUploadTaskModel ocrAndUploadTaskModel = (OcrAndUploadTaskModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ocrAndUploadTaskModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, ocrAndUploadTaskModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, ocrAndUploadTaskModel.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ocrAndUploadTaskModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OcrAndUploadTaskModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }
}
