package id.dana.social.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a"}, d2 = {"Lid/dana/social/model/ReactionCountModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "I", "getAuthRequestContext", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "p3", "<init>", "(Ljava/lang/String;IZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ReactionCountModel implements Parcelable {
    public static final Parcelable.Creator<ReactionCountModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public int getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ReactionCountModel) {
            ReactionCountModel reactionCountModel = (ReactionCountModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, reactionCountModel.PlaceComponentResult) && this.getAuthRequestContext == reactionCountModel.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2 == reactionCountModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, reactionCountModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int i = this.getAuthRequestContext;
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        String str = this.BuiltInFictitiousFunctionClassFactory;
        return (((((hashCode * 31) + i) * 31) + i2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReactionCountModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeInt(this.getAuthRequestContext);
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
    }

    public ReactionCountModel(String str, int i, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.BuiltInFictitiousFunctionClassFactory = str2;
    }

    public /* synthetic */ ReactionCountModel(String str, int i, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str2);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ReactionCountModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ReactionCountModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ReactionCountModel(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ReactionCountModel[] newArray(int i) {
            return new ReactionCountModel[i];
        }
    }
}
