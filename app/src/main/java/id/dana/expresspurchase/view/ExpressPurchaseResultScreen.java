package id.dana.expresspurchase.view;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.zebra.data.BoxData;
import id.dana.base.BaseScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0016¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseResultScreen;", "Lid/dana/base/BaseScreen;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", BoxData.ATTR_LAYOUT, "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "getAuthRequestContext", "I", "<init>", "(ILandroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class ExpressPurchaseResultScreen extends BaseScreen {
    public static final Parcelable.Creator<ExpressPurchaseResultScreen> CREATOR = new Creator();
    final Bundle BuiltInFictitiousFunctionClassFactory;
    private final int getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.getAuthRequestContext);
        p0.writeBundle(this.BuiltInFictitiousFunctionClassFactory);
    }

    public ExpressPurchaseResultScreen(int i, Bundle bundle) {
        super(bundle);
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = bundle;
    }

    @Override // com.zhuinden.simplestack.navigator.DefaultViewKey
    /* renamed from: layout  reason: from getter */
    public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Creator implements Parcelable.Creator<ExpressPurchaseResultScreen> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ExpressPurchaseResultScreen createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ExpressPurchaseResultScreen(parcel.readInt(), parcel.readBundle());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ExpressPurchaseResultScreen[] newArray(int i) {
            return new ExpressPurchaseResultScreen[i];
        }
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ExpressPurchaseResultScreen) {
            ExpressPurchaseResultScreen expressPurchaseResultScreen = (ExpressPurchaseResultScreen) p0;
            return this.getAuthRequestContext == expressPurchaseResultScreen.getAuthRequestContext && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, expressPurchaseResultScreen.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.getAuthRequestContext;
        Bundle bundle = this.BuiltInFictitiousFunctionClassFactory;
        return (i * 31) + (bundle == null ? 0 : bundle.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpressPurchaseResultScreen(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }
}
