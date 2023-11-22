package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.utils.StringWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/TitleModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "Lid/dana/utils/StringWrapper;", "component1", "()Lid/dana/utils/StringWrapper;", "title", "copy", "(Lid/dana/utils/StringWrapper;)Lid/dana/wallet_v3/model/TitleModel;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/utils/StringWrapper;", "getTitle", "<init>", "(Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TitleModel extends WalletV3CardModel {
    public static final Parcelable.Creator<TitleModel> CREATOR = new Creator();
    private final StringWrapper title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TitleModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TitleModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new TitleModel((StringWrapper) parcel.readParcelable(TitleModel.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TitleModel[] newArray(int i) {
            return new TitleModel[i];
        }
    }

    public static /* synthetic */ TitleModel copy$default(TitleModel titleModel, StringWrapper stringWrapper, int i, Object obj) {
        if ((i & 1) != 0) {
            stringWrapper = titleModel.title;
        }
        return titleModel.copy(stringWrapper);
    }

    /* renamed from: component1  reason: from getter */
    public final StringWrapper getTitle() {
        return this.title;
    }

    public final TitleModel copy(StringWrapper title) {
        Intrinsics.checkNotNullParameter(title, "");
        return new TitleModel(title);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TitleModel) && Intrinsics.areEqual(this.title, ((TitleModel) other).title);
    }

    public final int hashCode() {
        return this.title.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TitleModel(title=");
        sb.append(this.title);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeParcelable(this.title, flags);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleModel(StringWrapper stringWrapper) {
        super(17, null);
        Intrinsics.checkNotNullParameter(stringWrapper, "");
        this.title = stringWrapper;
    }

    @JvmName(name = "getTitle")
    public final StringWrapper getTitle() {
        return this.title;
    }
}
