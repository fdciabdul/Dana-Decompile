package id.dana.core.ui.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/core/ui/dialog/LinksString;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lid/dana/core/ui/dialog/ClickableString;", "KClassImpl$Data$declaredNonStaticMembers$2", "[Lid/dana/core/ui/dialog/ClickableString;", "getAuthRequestContext", "<init>", "([Lid/dana/core/ui/dialog/ClickableString;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LinksString implements Parcelable {
    public static final Parcelable.Creator<LinksString> CREATOR = new Creator();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final ClickableString[] getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ClickableString[] clickableStringArr = this.getAuthRequestContext;
        int length = clickableStringArr.length;
        p0.writeInt(length);
        for (int i = 0; i != length; i++) {
            clickableStringArr[i].writeToParcel(p0, p1);
        }
    }

    public LinksString(ClickableString[] clickableStringArr) {
        Intrinsics.checkNotNullParameter(clickableStringArr, "");
        this.getAuthRequestContext = clickableStringArr;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<LinksString> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LinksString createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            int readInt = parcel.readInt();
            ClickableString[] clickableStringArr = new ClickableString[readInt];
            for (int i = 0; i != readInt; i++) {
                clickableStringArr[i] = ClickableString.CREATOR.createFromParcel(parcel);
            }
            return new LinksString(clickableStringArr);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LinksString[] newArray(int i) {
            return new LinksString[i];
        }
    }
}
