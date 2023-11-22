package id.dana.animation.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.animation.tab.HomeTabs;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u001c\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u0012\u0010\u001b\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0012\u0010\u0017\u001a\u00020\u001cX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001d"}, d2 = {"Lid/dana/home/model/SnackbarEvent;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/home/tab/HomeTabs;", "getAuthRequestContext", "Lid/dana/home/tab/HomeTabs;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "I", "PlaceComponentResult", "MyBillsEntityDataFactory", "Lid/dana/component/customsnackbarcomponent/SnackbarState;", "Lid/dana/component/customsnackbarcomponent/SnackbarState;", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Lid/dana/component/customsnackbarcomponent/SnackbarState;Lid/dana/home/tab/HomeTabs;Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SnackbarEvent implements Parcelable {
    public static final Parcelable.Creator<SnackbarEvent> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public int PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;
    public String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public SnackbarState KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public HomeTabs BuiltInFictitiousFunctionClassFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SnackbarEvent) {
            SnackbarEvent snackbarEvent = (SnackbarEvent) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, snackbarEvent.MyBillsEntityDataFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == snackbarEvent.KClassImpl$Data$declaredNonStaticMembers$2 && this.BuiltInFictitiousFunctionClassFactory == snackbarEvent.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.getAuthRequestContext, snackbarEvent.getAuthRequestContext) && this.PlaceComponentResult == snackbarEvent.PlaceComponentResult;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        int hashCode2 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        HomeTabs homeTabs = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = homeTabs == null ? 0 : homeTabs.hashCode();
        String str = this.getAuthRequestContext;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.PlaceComponentResult;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SnackbarEvent(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2.name());
        HomeTabs homeTabs = this.BuiltInFictitiousFunctionClassFactory;
        if (homeTabs == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeString(homeTabs.name());
        }
        p0.writeString(this.getAuthRequestContext);
        p0.writeInt(this.PlaceComponentResult);
    }

    public SnackbarEvent(String str, SnackbarState snackbarState, HomeTabs homeTabs, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(snackbarState, "");
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = snackbarState;
        this.BuiltInFictitiousFunctionClassFactory = homeTabs;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = i;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<SnackbarEvent> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SnackbarEvent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new SnackbarEvent(parcel.readString(), SnackbarState.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : HomeTabs.valueOf(parcel.readString()), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SnackbarEvent[] newArray(int i) {
            return new SnackbarEvent[i];
        }
    }
}
