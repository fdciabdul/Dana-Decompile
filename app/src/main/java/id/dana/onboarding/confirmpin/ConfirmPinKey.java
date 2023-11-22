package id.dana.onboarding.confirmpin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import id.dana.base.BaseKey;
import id.dana.onboarding.confirmpin.ConfirmPinFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0086\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B9\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018"}, d2 = {"Lid/dana/onboarding/confirmpin/ConfirmPinKey;", "Landroid/os/Parcelable;", "Lid/dana/base/BaseKey;", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "()Landroidx/fragment/app/Fragment;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmPinKey extends BaseKey implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ConfirmPinKey> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ConfirmPinKey) {
            ConfirmPinKey confirmPinKey = (ConfirmPinKey) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, confirmPinKey.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, confirmPinKey.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, confirmPinKey.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, confirmPinKey.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, confirmPinKey.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.PlaceComponentResult;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.getAuthRequestContext;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfirmPinKey(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
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
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public ConfirmPinKey(String str, String str2, String str3, String str4, String str5) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
        this.getAuthRequestContext = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
    }

    @Override // id.dana.base.BaseKey
    public final Fragment MyBillsEntityDataFactory() {
        ConfirmPinFragment.Companion companion = ConfirmPinFragment.INSTANCE;
        return ConfirmPinFragment.Companion.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/onboarding/confirmpin/ConfirmPinKey$Companion;", "", "", "p0", "p1", "p2", "p3", "p4", "Lid/dana/onboarding/confirmpin/ConfirmPinKey;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/onboarding/confirmpin/ConfirmPinKey;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ConfirmPinKey BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3, String p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            return new ConfirmPinKey(p0, p1, p2, p3, p4);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ConfirmPinKey> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ConfirmPinKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ConfirmPinKey(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ConfirmPinKey[] newArray(int i) {
            return new ConfirmPinKey[i];
        }
    }
}
