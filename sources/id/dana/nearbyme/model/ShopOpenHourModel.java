package id.dana.nearbyme.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.iap.ac.android.mpm.base.model.hook.HookConstants;
import id.dana.R;
import id.dana.data.foundation.utils.CommonUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0002()B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b!\u0010$B9\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0018\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0007¢\u0006\u0004\b!\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0012\u0010\u001d\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u001a\u0010\u001b\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u0012\u0010 \u001a\u00020\u0018X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019"}, d2 = {"Lid/dana/nearbyme/model/ShopOpenHourModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Ljava/lang/String;", "Lid/dana/nearbyme/model/ShopOpenHourModel$OpenHourType;", "()Lid/dana/nearbyme/model/ShopOpenHourModel$OpenHourType;", "hashCode", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "J", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "()Z", "PlaceComponentResult", "<init>", "(Landroid/os/Parcel;)V", "p2", "(Ljava/lang/String;JJ)V", "p3", "p4", "(Ljava/lang/String;JJZZ)V", "CREATOR", "OpenHourType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ShopOpenHourModel implements Parcelable {

    /* renamed from: CREATOR  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public long PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public long getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b"}, d2 = {"Lid/dana/nearbyme/model/ShopOpenHourModel$OpenHourType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", HookConstants.HookAction.HOOK_ACTION_OPEN, "OPENING_SOON", "CLOSING_SOON", "CLOSE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum OpenHourType {
        NONE,
        OPEN,
        OPENING_SOON,
        CLOSING_SOON,
        CLOSE
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[OpenHourType.values().length];
            iArr[OpenHourType.NONE.ordinal()] = 1;
            iArr[OpenHourType.OPEN.ordinal()] = 2;
            iArr[OpenHourType.OPENING_SOON.ordinal()] = 3;
            iArr[OpenHourType.CLOSING_SOON.ordinal()] = 4;
            iArr[OpenHourType.CLOSE.ordinal()] = 5;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public ShopOpenHourModel() {
        this(null, 0L, 0L, false, false, 31, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ShopOpenHourModel) {
            ShopOpenHourModel shopOpenHourModel = (ShopOpenHourModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, shopOpenHourModel.BuiltInFictitiousFunctionClassFactory) && this.PlaceComponentResult == shopOpenHourModel.PlaceComponentResult && this.getAuthRequestContext == shopOpenHourModel.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2 == shopOpenHourModel.KClassImpl$Data$declaredNonStaticMembers$2 && this.MyBillsEntityDataFactory == shopOpenHourModel.MyBillsEntityDataFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.PlaceComponentResult);
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.getAuthRequestContext);
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.MyBillsEntityDataFactory;
        return (((((((hashCode * 31) + m) * 31) + m2) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopOpenHourModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    private ShopOpenHourModel(String str, long j, long j2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = j;
        this.getAuthRequestContext = j2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.MyBillsEntityDataFactory = z2;
    }

    public /* synthetic */ ShopOpenHourModel(String str, long j, long j2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ShopOpenHourModel(android.os.Parcel r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r1 = r9.readString()
            if (r1 != 0) goto Ld
            r3 = r0
            goto Le
        Ld:
            r3 = r1
        Le:
            long r4 = r9.readLong()
            long r6 = r9.readLong()
            r2 = r8
            r2.<init>(r3, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.model.ShopOpenHourModel.<init>(android.os.Parcel):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShopOpenHourModel(String str, long j, long j2) {
        this(str, j, j2, false, false);
        Intrinsics.checkNotNullParameter(str, "");
    }

    public final String MyBillsEntityDataFactory(Context p0) {
        String string;
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[MyBillsEntityDataFactory().ordinal()];
        if (i != 1) {
            if (i == 2) {
                string = p0.getString(R.string.open);
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else if (i == 3) {
                string = p0.getString(R.string.opening_soon);
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else if (i == 4) {
                string = p0.getString(R.string.closing_soon);
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else if (i != 5) {
                throw new NoWhenBranchMatchedException();
            } else {
                string = p0.getString(R.string.closed);
                Intrinsics.checkNotNullExpressionValue(string, "");
            }
            return string;
        }
        return "";
    }

    public final OpenHourType MyBillsEntityDataFactory() {
        if (this.PlaceComponentResult == 0 || this.getAuthRequestContext == 0) {
            return OpenHourType.NONE;
        }
        long KClassImpl$Data$declaredNonStaticMembers$2 = CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        long j = this.PlaceComponentResult;
        long j2 = (j - KClassImpl$Data$declaredNonStaticMembers$2) / 60;
        long j3 = (this.getAuthRequestContext - KClassImpl$Data$declaredNonStaticMembers$2) / 60;
        if (1 <= j2 && j2 < 31) {
            return OpenHourType.OPENING_SOON;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 <= j || j3 <= 30) {
            if (1 <= j3 && j3 < 31) {
                return OpenHourType.CLOSING_SOON;
            }
            return OpenHourType.CLOSE;
        }
        return OpenHourType.OPEN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeLong(this.PlaceComponentResult);
        p0.writeLong(this.getAuthRequestContext);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/nearbyme/model/ShopOpenHourModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lid/dana/nearbyme/model/ShopOpenHourModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.nearbyme.model.ShopOpenHourModel$CREATOR  reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion implements Parcelable.Creator<ShopOpenHourModel> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ShopOpenHourModel[] newArray(int i) {
            while (true) {
            }
        }

        private Companion() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ShopOpenHourModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ShopOpenHourModel(parcel);
        }
    }
}
