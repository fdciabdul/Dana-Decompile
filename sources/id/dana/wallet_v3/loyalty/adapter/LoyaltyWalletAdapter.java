package id.dana.wallet_v3.loyalty.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.griver.video.H5Constants;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.loyalty.adapter.viewholder.LoadingSpinnerViewHolder;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\nR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/wallet_v3/loyalty/adapter/LoyaltyWalletAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "position", "getItemViewType", "(I)I", "", H5Constants.PARAM_HIDE_LOADING_VIEW, "()V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/base/BaseRecyclerViewHolder;", "showLoadingViewOnTheLastItem", "currentLoadingViewIndex", "I", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoyaltyWalletAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<WalletV3CardModel>, WalletV3CardModel> {
    private int currentLoadingViewIndex;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.wallet_v3.listener.WalletCardAssetClickListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LoyaltyWalletAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.loyalty.adapter.LoyaltyWalletAdapter.<init>():void");
    }

    public /* synthetic */ LoyaltyWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : walletCardAssetClickListener);
    }

    public LoyaltyWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener) {
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.currentLoadingViewIndex = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseRecyclerViewHolder<WalletV3CardModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        if (viewType == 11) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            return new LoadingSpinnerViewHolder(context, parent);
        } else if (viewType == 13) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            return new DanaLoyaltyCardViewHolder(context2, parent, this.walletCardAssetClickListener);
        } else {
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "");
            return new LoyaltyEmptyCardViewHolder(context3, parent, this.walletCardAssetClickListener);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final void showLoadingViewOnTheLastItem() {
        ?? r2 = 0;
        appendItem(new LoyaltyCardModel.LoadingState(r2, 1, r2));
        this.currentLoadingViewIndex = getItems().size() - 1;
    }

    public final void hideLoadingView() {
        removeItem(this.currentLoadingViewIndex);
        this.currentLoadingViewIndex = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return getItems().get(position).getViewType();
    }
}
