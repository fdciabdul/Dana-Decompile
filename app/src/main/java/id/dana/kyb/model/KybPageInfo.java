package id.dana.kyb.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u001a\u0010\u0015\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a"}, d2 = {"Lid/dana/kyb/model/KybPageInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "Ljava/lang/String;", "p2", "p3", "<init>", "(ZZLjava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class KybPageInfo implements Parcelable {
    public static final Parcelable.Creator<KybPageInfo> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    private final boolean PlaceComponentResult;

    public KybPageInfo() {
        this(false, false, null, false, 15, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybPageInfo) {
            KybPageInfo kybPageInfo = (KybPageInfo) p0;
            return this.PlaceComponentResult == kybPageInfo.PlaceComponentResult && this.KClassImpl$Data$declaredNonStaticMembers$2 == kybPageInfo.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.getAuthRequestContext, kybPageInfo.getAuthRequestContext) && this.MyBillsEntityDataFactory == kybPageInfo.MyBillsEntityDataFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.PlaceComponentResult;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int hashCode = this.getAuthRequestContext.hashCode();
        boolean z2 = this.MyBillsEntityDataFactory;
        return (((((r0 * 31) + i) * 31) + hashCode) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybPageInfo(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
        p0.writeString(this.getAuthRequestContext);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
    }

    public KybPageInfo(boolean z, boolean z2, String str, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = z3;
    }

    public /* synthetic */ KybPageInfo(boolean z, boolean z2, String str, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "User" : str, (i & 8) != 0 ? false : z3);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<KybPageInfo> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ KybPageInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new KybPageInfo(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ KybPageInfo[] newArray(int i) {
            return new KybPageInfo[i];
        }
    }
}
