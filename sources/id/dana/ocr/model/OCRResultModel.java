package id.dana.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002*)B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u000f¢\u0006\u0004\b \u0010!BK\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\f\u0012\u0006\u0010$\u001a\u00020\f\u0012\u0006\u0010%\u001a\u00020\f\u0012\u0006\u0010&\u001a\u00020\f\u0012\u0006\u0010'\u001a\u00020\f¢\u0006\u0004\b \u0010(J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0014\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0018\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0019\u0010\u001eR\u0011\u0010\u001c\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015"}, d2 = {"Lid/dana/ocr/model/OCRResultModel;", "Lid/dana/ocr/model/BaseOCRResultModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "moveToNextValue", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "()Z", "lookAheadTest", "<init>", "(Landroid/os/Parcel;)V", "p2", "p3", "p4", "p5", "p6", "p7", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "CREATOR", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class OCRResultModel extends BaseOCRResultModel implements Parcelable {

    /* renamed from: CREATOR  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final boolean lookAheadTest;
    public final String PlaceComponentResult;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public /* synthetic */ OCRResultModel(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, str3, str4, str5, str6, str7);
    }

    @Override // id.dana.ocr.model.BaseOCRResultModel, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // id.dana.ocr.model.BaseOCRResultModel
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getLookAheadTest() {
        return this.lookAheadTest;
    }

    @Override // id.dana.ocr.model.BaseOCRResultModel
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public OCRResultModel(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        super(z, str);
        this.lookAheadTest = z;
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.MyBillsEntityDataFactory = str5;
        this.getErrorConfigVersion = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OCRResultModel(android.os.Parcel r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            byte r1 = r12.readByte()
            if (r1 == 0) goto Le
            r1 = 1
            r3 = 1
            goto L10
        Le:
            r1 = 0
            r3 = 0
        L10:
            java.lang.String r4 = r12.readString()
            java.lang.String r1 = r12.readString()
            if (r1 != 0) goto L1c
            r5 = r0
            goto L1d
        L1c:
            r5 = r1
        L1d:
            java.lang.String r1 = r12.readString()
            if (r1 != 0) goto L25
            r6 = r0
            goto L26
        L25:
            r6 = r1
        L26:
            java.lang.String r1 = r12.readString()
            if (r1 != 0) goto L2e
            r7 = r0
            goto L2f
        L2e:
            r7 = r1
        L2f:
            java.lang.String r1 = r12.readString()
            if (r1 != 0) goto L37
            r8 = r0
            goto L38
        L37:
            r8 = r1
        L38:
            java.lang.String r1 = r12.readString()
            if (r1 != 0) goto L40
            r9 = r0
            goto L41
        L40:
            r9 = r1
        L41:
            java.lang.String r12 = r12.readString()
            if (r12 != 0) goto L49
            r10 = r0
            goto L4a
        L49:
            r10 = r12
        L4a:
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.model.OCRResultModel.<init>(android.os.Parcel):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OCRResultModel(success=");
        sb.append(getLookAheadTest());
        sb.append(", errorCode=");
        sb.append(this.getAuthRequestContext);
        sb.append(", merchantName=");
        sb.append(this.PlaceComponentResult);
        sb.append(", billNumber=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", timestamp=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", amount=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", rawText=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", filePath=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public final boolean equals(Object p0) {
        if (p0 instanceof OCRResultModel) {
            OCRResultModel oCRResultModel = (OCRResultModel) p0;
            if (getLookAheadTest() == oCRResultModel.getLookAheadTest() && Intrinsics.areEqual(this.getAuthRequestContext, oCRResultModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, oCRResultModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, oCRResultModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, oCRResultModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, oCRResultModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, oCRResultModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, oCRResultModel.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(getLookAheadTest()), this.getAuthRequestContext, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0014B\u001d\b\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0012\u0010\t\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0012\u0010\u0010\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0012\u0010\n\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007"}, d2 = {"Lid/dana/ocr/model/OCRResultModel$Builder;", "", "Lid/dana/ocr/model/OCRResultModel;", "getAuthRequestContext", "()Lid/dana/ocr/model/OCRResultModel;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "Z", "getErrorConfigVersion", "<init>", "()V", "p0", "(Ljava/lang/String;)V", "p1", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String lookAheadTest;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public boolean getErrorConfigVersion;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private String PlaceComponentResult;
        private String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String getAuthRequestContext;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        private String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        private String MyBillsEntityDataFactory;

        private Builder(boolean z, String str) {
            this.getErrorConfigVersion = z;
            this.getAuthRequestContext = str;
            this.MyBillsEntityDataFactory = "";
            this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
            this.lookAheadTest = "";
            this.PlaceComponentResult = "";
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
            this.BuiltInFictitiousFunctionClassFactory = "";
        }

        /* synthetic */ Builder(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Builder() {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                r2 = 2
                r3.<init>(r1, r0, r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.model.OCRResultModel.Builder.<init>():void");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(String str) {
            this(false, str);
            Intrinsics.checkNotNullParameter(str, "");
        }

        public final OCRResultModel getAuthRequestContext() {
            return new OCRResultModel(this.getErrorConfigVersion, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, null);
        }
    }

    @Override // id.dana.ocr.model.BaseOCRResultModel, android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.writeToParcel(p0, p1);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/ocr/model/OCRResultModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lid/dana/ocr/model/OCRResultModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.ocr.model.OCRResultModel$CREATOR  reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<OCRResultModel> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OCRResultModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new OCRResultModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OCRResultModel[] newArray(int i) {
            return new OCRResultModel[i];
        }
    }
}
