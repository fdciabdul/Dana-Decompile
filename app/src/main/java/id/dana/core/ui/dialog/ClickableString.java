package id.dana.core.ui.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.core.ui.dialog.DanaAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u000eX\u0007¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0010X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/core/ui/dialog/ClickableString;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Ljava/lang/Integer;", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/Boolean;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "I", "p2", "p3", "<init>", "(Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClickableString implements Parcelable {
    public static final Parcelable.Creator<ClickableString> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Integer BuiltInFictitiousFunctionClassFactory;
    final int getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeInt(this.getAuthRequestContext);
        Boolean bool = this.PlaceComponentResult;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        if (num == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(num.intValue());
    }

    public ClickableString(@DanaAlertDialog.LinkKey String str, int i, Boolean bool, Integer num) {
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = i;
        this.PlaceComponentResult = bool;
        this.BuiltInFictitiousFunctionClassFactory = num;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<ClickableString> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ClickableString createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ClickableString(readString, readInt, valueOf, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ClickableString[] newArray(int i) {
            return new ClickableString[i];
        }
    }
}
