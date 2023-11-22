package id.dana.onboarding.welcome;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import id.dana.base.BaseKey;
import id.dana.onboarding.welcome.WelcomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/onboarding/welcome/WelcomeKey;", "Landroid/os/Parcelable;", "Lid/dana/base/BaseKey;", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "()Landroidx/fragment/app/Fragment;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WelcomeKey extends BaseKey implements Parcelable {
    public static final Parcelable.Creator<WelcomeKey> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(1);
    }

    @Override // id.dana.base.BaseKey
    public final Fragment MyBillsEntityDataFactory() {
        WelcomeFragment.Companion companion = WelcomeFragment.INSTANCE;
        return WelcomeFragment.Companion.MyBillsEntityDataFactory();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<WelcomeKey> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WelcomeKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.readInt();
            return new WelcomeKey();
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WelcomeKey[] newArray(int i) {
            return new WelcomeKey[i];
        }
    }
}
