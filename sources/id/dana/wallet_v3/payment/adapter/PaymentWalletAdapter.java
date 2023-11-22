package id.dana.wallet_v3.payment.adapter;

import android.content.Context;
import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.listener.DanaBalanceClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.payment.viewholder.BankCardViewHolder;
import id.dana.wallet_v3.payment.viewholder.DanaBalanceCardViewHolder;
import id.dana.wallet_v3.payment.viewholder.PaylaterCardViewHolder;
import id.dana.wallet_v3.payment.viewholder.PaymentEmptyCardViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/wallet_v3/payment/adapter/PaymentWalletAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "position", "getItemViewType", "(I)I", "assetType", "", "notifyDataSetChangeByAsset", "(I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/listener/DanaBalanceClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentWalletAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<WalletV3CardModel>, WalletV3CardModel> {
    private final DanaBalanceClickListener danaBalanceClickListener;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.listener.DanaBalanceClickListener, kotlin.jvm.internal.DefaultConstructorMarker, id.dana.wallet_v3.listener.WalletCardAssetClickListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PaymentWalletAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.adapter.PaymentWalletAdapter.<init>():void");
    }

    public /* synthetic */ PaymentWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener, DanaBalanceClickListener danaBalanceClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : walletCardAssetClickListener, (i & 2) != 0 ? null : danaBalanceClickListener);
    }

    public PaymentWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener, DanaBalanceClickListener danaBalanceClickListener) {
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.danaBalanceClickListener = danaBalanceClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseRecyclerViewHolder<WalletV3CardModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        if (viewType == 0) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            return new BankCardViewHolder(context, parent, this.walletCardAssetClickListener);
        } else if (viewType == 1) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            return new DanaBalanceCardViewHolder(context2, parent, this.danaBalanceClickListener);
        } else if (viewType == 2) {
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "");
            return new PaylaterCardViewHolder(context3, parent, this.walletCardAssetClickListener);
        } else if (viewType == 3) {
            Context context4 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "");
            return new PaymentEmptyCardViewHolder(context4, parent, this.walletCardAssetClickListener);
        } else {
            Context context5 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "");
            return new BankCardViewHolder(context5, parent, this.walletCardAssetClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return getItems().get(position).getViewType();
    }

    private final void notifyDataSetChangeByAsset(int assetType) {
        List<WalletV3CardModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        int i = 0;
        for (Object obj : items) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((WalletV3CardModel) obj).getViewType() == assetType) {
                notifyItemChanged(i);
            }
            i++;
        }
    }
}
