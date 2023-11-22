package id.dana.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f\u0012\u0006\u0010$\u001a\u00020\u0014\u0012\u0006\u0010%\u001a\u00020\u0014\u0012\u0006\u0010&\u001a\u00020\u0014¢\u0006\u0004\b!\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0014X\u0007¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0007¢\u0006\u0006\n\u0004\b\u001d\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0014X\u0007¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0011\u0010\u0003\u001a\u00020\u0014X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0014X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u001e"}, d2 = {"Lid/dana/ocr/model/OCRRequestModel;", "Landroid/os/Parcelable;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "", "describeContents", "()I", "", "p0", "equals", "(Ljava/lang/Object;)Z", "hashCode", "MyBillsEntityDataFactory", "lookAheadTest", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "PlaceComponentResult", "Ljava/lang/String;", "", "Ljava/util/List;", "<init>", "(Landroid/os/Parcel;)V", "p2", "p3", "p4", "p5", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "CREATOR"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class OCRRequestModel implements Parcelable {

    /* renamed from: CREATOR  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<String> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof OCRRequestModel) {
            OCRRequestModel oCRRequestModel = (OCRRequestModel) p0;
            return this.PlaceComponentResult == oCRRequestModel.PlaceComponentResult && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, oCRRequestModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, oCRRequestModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, oCRRequestModel.getAuthRequestContext) && Intrinsics.areEqual(this.moveToNextValue, oCRRequestModel.moveToNextValue) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, oCRRequestModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean z = this.PlaceComponentResult;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((r0 * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.moveToNextValue.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OCRRequestModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public OCRRequestModel(boolean z, String str, List<String> list, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.PlaceComponentResult = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = list;
        this.getAuthRequestContext = str2;
        this.moveToNextValue = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    private final boolean getErrorConfigVersion() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (str == null || str.length() == 0) || Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "{}");
    }

    private final boolean MyBillsEntityDataFactory() {
        List<String> list = this.MyBillsEntityDataFactory;
        return list == null || list.isEmpty();
    }

    private final boolean lookAheadTest() {
        return this.getAuthRequestContext.length() == 0;
    }

    private final boolean moveToNextValue() {
        return this.moveToNextValue.length() == 0;
    }

    private final boolean scheduleImpl() {
        return this.BuiltInFictitiousFunctionClassFactory.length() == 0;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.PlaceComponentResult) {
            return BuiltInFictitiousFunctionClassFactory();
        }
        return getAuthRequestContext();
    }

    private final boolean getAuthRequestContext() {
        return getErrorConfigVersion() | MyBillsEntityDataFactory();
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        boolean errorConfigVersion = getErrorConfigVersion();
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        return errorConfigVersion | MyBillsEntityDataFactory | lookAheadTest() | moveToNextValue() | scheduleImpl();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OCRRequestModel(android.os.Parcel r10) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            byte r1 = r10.readByte()
            if (r1 == 0) goto Le
            r1 = 1
            r3 = 1
            goto L10
        Le:
            r1 = 0
            r3 = 0
        L10:
            java.lang.String r4 = r10.readString()
            java.util.ArrayList r1 = r10.createStringArrayList()
            if (r1 == 0) goto L21
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.toList(r1)
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 != 0) goto L28
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L28:
            r5 = r1
            java.lang.String r1 = r10.readString()
            if (r1 != 0) goto L31
            r6 = r0
            goto L32
        L31:
            r6 = r1
        L32:
            java.lang.String r1 = r10.readString()
            if (r1 != 0) goto L3a
            r7 = r0
            goto L3b
        L3a:
            r7 = r1
        L3b:
            java.lang.String r10 = r10.readString()
            if (r10 != 0) goto L43
            r8 = r0
            goto L44
        L43:
            r8 = r10
        L44:
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.model.OCRRequestModel.<init>(android.os.Parcel):void");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeByte(this.PlaceComponentResult ? (byte) 1 : (byte) 0);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeStringList(this.MyBillsEntityDataFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/ocr/model/OCRRequestModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lid/dana/ocr/model/OCRRequestModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.ocr.model.OCRRequestModel$CREATOR  reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<OCRRequestModel> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OCRRequestModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new OCRRequestModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OCRRequestModel[] newArray(int i) {
            return new OCRRequestModel[i];
        }
    }
}
