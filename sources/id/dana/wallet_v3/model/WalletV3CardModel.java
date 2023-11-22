package id.dana.wallet_v3.model;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/wallet_v3/model/WalletV3CardModel;", "Landroid/os/Parcelable;", "", "viewType", "I", "getViewType", "()I", "<init>", "(I)V", "Lid/dana/wallet_v3/model/AssetCardModel;", "Lid/dana/wallet_v3/model/AssetSearchRecommendationModel;", "Lid/dana/wallet_v3/model/IdentityCardModel;", "Lid/dana/wallet_v3/model/LoyaltyCardModel;", "Lid/dana/wallet_v3/model/NoResult;", "Lid/dana/wallet_v3/model/TitleModel;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class WalletV3CardModel implements Parcelable {
    private final int viewType;

    public /* synthetic */ WalletV3CardModel(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private WalletV3CardModel(int i) {
        this.viewType = i;
    }

    @JvmName(name = "getViewType")
    public int getViewType() {
        return this.viewType;
    }
}
