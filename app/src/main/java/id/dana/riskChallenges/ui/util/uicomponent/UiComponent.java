package id.dana.riskChallenges.ui.util.uicomponent;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "I", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/ui/util/uicomponent/UIComponentType;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/util/uicomponent/UIComponentType;", "p2", "<init>", "(Lid/dana/riskChallenges/ui/util/uicomponent/UIComponentType;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UiComponent implements Parcelable {
    public static final Parcelable.Creator<UiComponent> CREATOR = new Creator();
    public final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final UIComponentType getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof UiComponent) {
            UiComponent uiComponent = (UiComponent) p0;
            return this.getAuthRequestContext == uiComponent.getAuthRequestContext && this.MyBillsEntityDataFactory == uiComponent.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory == uiComponent.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.getAuthRequestContext.hashCode() * 31) + this.MyBillsEntityDataFactory) * 31) + this.BuiltInFictitiousFunctionClassFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UiComponent(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
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
        p0.writeString(this.getAuthRequestContext.name());
        p0.writeInt(this.MyBillsEntityDataFactory);
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory);
    }

    public UiComponent(UIComponentType uIComponentType, int i, int i2) {
        Intrinsics.checkNotNullParameter(uIComponentType, "");
        this.getAuthRequestContext = uIComponentType;
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<UiComponent> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UiComponent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new UiComponent(UIComponentType.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UiComponent[] newArray(int i) {
            return new UiComponent[i];
        }
    }
}
