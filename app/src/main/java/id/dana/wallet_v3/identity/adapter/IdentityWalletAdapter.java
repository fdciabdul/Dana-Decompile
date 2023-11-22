package id.dana.wallet_v3.identity.adapter;

import android.content.Context;
import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.identity.viewholder.IdentityEmptyCardViewHolder;
import id.dana.wallet_v3.identity.viewholder.KtpCardViewHolder;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.WalletV3CardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/wallet_v3/identity/adapter/IdentityWalletAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentityWalletAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<WalletV3CardModel>, WalletV3CardModel> {
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.wallet_v3.listener.WalletCardAssetClickListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public IdentityWalletAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.identity.adapter.IdentityWalletAdapter.<init>():void");
    }

    public /* synthetic */ IdentityWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : walletCardAssetClickListener);
    }

    public IdentityWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener) {
        this.walletCardAssetClickListener = walletCardAssetClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseRecyclerViewHolder<WalletV3CardModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        if (viewType == 14) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            return new KtpCardViewHolder(context, parent, this.walletCardAssetClickListener);
        }
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        return new IdentityEmptyCardViewHolder(context2, parent, this.walletCardAssetClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return getItem(position).getViewType();
    }
}
