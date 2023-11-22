package id.dana.ocr.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\b\u0018\u0000 !2\u00020\u0001:\u0002!\"B-\u0012\u0006\u0010\u0006\u001a\u00020\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u001aX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/ocr/model/SnapReceiptBroadcastData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Landroid/content/Intent;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/content/Intent;", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "Lid/dana/ocr/model/SubmitReceiptResultModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/ocr/model/SubmitReceiptResultModel;", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/ocr/model/SubmitReceiptResultModel;)V", "Companion", "Status"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SnapReceiptBroadcastData implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final SubmitReceiptResultModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public static final Parcelable.Creator<SnapReceiptBroadcastData> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SnapReceiptBroadcastData) {
            SnapReceiptBroadcastData snapReceiptBroadcastData = (SnapReceiptBroadcastData) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, snapReceiptBroadcastData.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, snapReceiptBroadcastData.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, snapReceiptBroadcastData.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, snapReceiptBroadcastData.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        String str = this.MyBillsEntityDataFactory;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.getAuthRequestContext;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        SubmitReceiptResultModel submitReceiptResultModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (submitReceiptResultModel != null ? submitReceiptResultModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SnapReceiptBroadcastData(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.getAuthRequestContext);
        SubmitReceiptResultModel submitReceiptResultModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (submitReceiptResultModel == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        submitReceiptResultModel.writeToParcel(p0, p1);
    }

    public SnapReceiptBroadcastData(String str, String str2, String str3, SubmitReceiptResultModel submitReceiptResultModel) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = str2;
        this.getAuthRequestContext = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = submitReceiptResultModel;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/ocr/model/SnapReceiptBroadcastData$Status;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Status {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
        public static final String Completed = "Completed";
        public static final String Error = "Error";
        public static final String InProgress = "InProgress";
        public static final String Success = "Success";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/ocr/model/SnapReceiptBroadcastData$Status$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

            private Companion() {
            }
        }
    }

    public final Intent KClassImpl$Data$declaredNonStaticMembers$2() {
        Intent intent = new Intent("IAPAppContainer_UPLOAD_LOCAL_IMAGE_SERVICE_LISTENER");
        intent.putExtra("status", this.PlaceComponentResult);
        intent.putExtra("statusMessage", this.MyBillsEntityDataFactory);
        intent.putExtra("errorCode", this.getAuthRequestContext);
        intent.putExtra("submitReceiptResult", this.KClassImpl$Data$declaredNonStaticMembers$2);
        return intent;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<SnapReceiptBroadcastData> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SnapReceiptBroadcastData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new SnapReceiptBroadcastData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : SubmitReceiptResultModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SnapReceiptBroadcastData[] newArray(int i) {
            return new SnapReceiptBroadcastData[i];
        }
    }
}
