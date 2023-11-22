package id.dana.danapoly.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.danapoly.ui.enums.RewardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/danapoly/ui/model/CardListWrapperModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "hasMore", "Z", "getHasMore", "()Z", "", "Lid/dana/danapoly/ui/model/CardItemModel;", FirebaseAnalytics.Param.ITEMS, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lid/dana/danapoly/ui/enums/RewardType;", "rewardType", "Lid/dana/danapoly/ui/enums/RewardType;", "getRewardType", "()Lid/dana/danapoly/ui/enums/RewardType;", "<init>", "(Lid/dana/danapoly/ui/enums/RewardType;ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardListWrapperModel implements Parcelable {
    public static final Parcelable.Creator<CardListWrapperModel> CREATOR = new Creator();
    private final boolean hasMore;
    private final List<CardItemModel> items;
    private final RewardType rewardType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CardListWrapperModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardListWrapperModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            RewardType valueOf = RewardType.valueOf(parcel.readString());
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(CardItemModel.CREATOR.createFromParcel(parcel));
            }
            return new CardListWrapperModel(valueOf, z, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardListWrapperModel[] newArray(int i) {
            return new CardListWrapperModel[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.rewardType.name());
        parcel.writeInt(this.hasMore ? 1 : 0);
        List<CardItemModel> list = this.items;
        parcel.writeInt(list.size());
        Iterator<CardItemModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public CardListWrapperModel(RewardType rewardType, boolean z, List<CardItemModel> list) {
        Intrinsics.checkNotNullParameter(rewardType, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.rewardType = rewardType;
        this.hasMore = z;
        this.items = list;
    }

    @JvmName(name = "getRewardType")
    public final RewardType getRewardType() {
        return this.rewardType;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public /* synthetic */ CardListWrapperModel(RewardType rewardType, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rewardType, (i & 2) != 0 ? false : z, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getItems")
    public final List<CardItemModel> getItems() {
        return this.items;
    }
}
