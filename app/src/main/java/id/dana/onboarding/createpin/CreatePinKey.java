package id.dana.onboarding.createpin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import id.dana.base.BaseKey;
import id.dana.onboarding.createpin.CreatePinFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB/\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018"}, d2 = {"Lid/dana/onboarding/createpin/CreatePinKey;", "Landroid/os/Parcelable;", "Lid/dana/base/BaseKey;", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "()Landroidx/fragment/app/Fragment;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreatePinKey extends BaseKey implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String getAuthRequestContext;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<CreatePinKey> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CreatePinKey) {
            CreatePinKey createPinKey = (CreatePinKey) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, createPinKey.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, createPinKey.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, createPinKey.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, createPinKey.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.getAuthRequestContext;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.PlaceComponentResult;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreatePinKey(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
    }

    public CreatePinKey(String str, String str2, String str3, String str4) {
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
    }

    @Override // id.dana.base.BaseKey
    public final Fragment MyBillsEntityDataFactory() {
        CreatePinFragment.Companion companion = CreatePinFragment.INSTANCE;
        return CreatePinFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/onboarding/createpin/CreatePinKey$Companion;", "", "", "p0", "p1", "p2", "p3", "Lid/dana/onboarding/createpin/CreatePinKey;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/onboarding/createpin/CreatePinKey;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CreatePinKey BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new CreatePinKey(p0, p1, p2, p3);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<CreatePinKey> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CreatePinKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new CreatePinKey(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CreatePinKey[] newArray(int i) {
            return new CreatePinKey[i];
        }
    }
}
