package id.dana.onboarding.verify;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import id.dana.base.BaseKey;
import id.dana.onboarding.verify.VerifyNumberFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002&%BA\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001cR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberKey;", "Landroid/os/Parcelable;", "Lid/dana/base/BaseKey;", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "()Landroidx/fragment/app/Fragment;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Z", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "lookAheadTest", "getErrorConfigVersion", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;)V", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VerifyNumberKey extends BaseKey implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final boolean getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<VerifyNumberKey> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof VerifyNumberKey) {
            VerifyNumberKey verifyNumberKey = (VerifyNumberKey) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, verifyNumberKey.PlaceComponentResult) && this.MyBillsEntityDataFactory == verifyNumberKey.MyBillsEntityDataFactory && Intrinsics.areEqual(this.getErrorConfigVersion, verifyNumberKey.getErrorConfigVersion) && this.BuiltInFictitiousFunctionClassFactory == verifyNumberKey.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext == verifyNumberKey.getAuthRequestContext && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, verifyNumberKey.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.PlaceComponentResult;
        int hashCode = str == null ? 0 : str.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str2 = this.getErrorConfigVersion;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        boolean z2 = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.getAuthRequestContext;
        int i3 = z3 ? 1 : z3 ? 1 : 0;
        String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((hashCode * 31) + i) * 31) + hashCode2) * 31) + i2) * 31) + i3) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyNumberKey(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
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
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
        p0.writeInt(this.getAuthRequestContext ? 1 : 0);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public /* synthetic */ VerifyNumberKey(String str, boolean z, String str2, boolean z2, boolean z3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, str2, z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? "" : str3);
    }

    public VerifyNumberKey(String str, boolean z, String str2, boolean z2, boolean z3, String str3) {
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = z;
        this.getErrorConfigVersion = str2;
        this.BuiltInFictitiousFunctionClassFactory = z2;
        this.getAuthRequestContext = z3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
    }

    @Override // id.dana.base.BaseKey
    public final Fragment MyBillsEntityDataFactory() {
        if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
            VerifyNumberFragment.Companion companion = VerifyNumberFragment.INSTANCE;
            return VerifyNumberFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.getErrorConfigVersion, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (this.BuiltInFictitiousFunctionClassFactory) {
            VerifyNumberFragment.Companion companion2 = VerifyNumberFragment.INSTANCE;
            return VerifyNumberFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
        } else {
            VerifyNumberFragment.Companion companion3 = VerifyNumberFragment.INSTANCE;
            return VerifyNumberFragment.Companion.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberKey$Builder;", "", "Lid/dana/onboarding/verify/VerifyNumberKey;", "PlaceComponentResult", "()Lid/dana/onboarding/verify/VerifyNumberKey;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public boolean getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String BuiltInFictitiousFunctionClassFactory;

        public final VerifyNumberKey PlaceComponentResult() {
            return new VerifyNumberKey(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, false, null, 48, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberKey$Companion;", "", "Lid/dana/onboarding/verify/VerifyNumberKey$Builder;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/onboarding/verify/VerifyNumberKey$Builder;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Builder BuiltInFictitiousFunctionClassFactory() {
            Builder builder = new Builder();
            builder.PlaceComponentResult = "";
            Boolean bool = Boolean.TRUE;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = bool != null ? bool.booleanValue() : false;
            builder.BuiltInFictitiousFunctionClassFactory = "";
            Boolean bool2 = Boolean.FALSE;
            builder.getAuthRequestContext = bool2 != null ? bool2.booleanValue() : false;
            return builder;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<VerifyNumberKey> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VerifyNumberKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new VerifyNumberKey(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VerifyNumberKey[] newArray(int i) {
            return new VerifyNumberKey[i];
        }
    }
}
