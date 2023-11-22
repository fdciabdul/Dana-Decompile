package id.dana.wallet_v3.investment.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.listener.DanaEmasClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/wallet_v3/investment/viewholder/DanaEmasCardViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "item", "", "bindData", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "", "isBalanceVisible", "Z", "()Z", "setBalanceVisible", "(Z)V", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;ZLid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/listener/DanaEmasClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaEmasCardViewHolder extends BaseRecyclerViewHolder<WalletV3CardModel> {
    private final DanaEmasClickListener danaEmasClickListener;
    private boolean isBalanceVisible;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    public /* synthetic */ DanaEmasCardViewHolder(Context context, ViewGroup viewGroup, boolean z, WalletCardAssetClickListener walletCardAssetClickListener, DanaEmasClickListener danaEmasClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, z, (i & 8) != 0 ? null : walletCardAssetClickListener, (i & 16) != 0 ? null : danaEmasClickListener);
    }

    @JvmName(name = "isBalanceVisible")
    /* renamed from: isBalanceVisible  reason: from getter */
    public final boolean getIsBalanceVisible() {
        return this.isBalanceVisible;
    }

    @JvmName(name = "setBalanceVisible")
    public final void setBalanceVisible(boolean z) {
        this.isBalanceVisible = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaEmasCardViewHolder(Context context, ViewGroup viewGroup, boolean z, WalletCardAssetClickListener walletCardAssetClickListener, DanaEmasClickListener danaEmasClickListener) {
        super(context, R.layout.wallet_card_view_holder, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.isBalanceVisible = z;
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.danaEmasClickListener = danaEmasClickListener;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(WalletV3CardModel item) {
        super.bindData((DanaEmasCardViewHolder) item);
        if (item == null || !(item instanceof InvestmentCardModel.EmasCard)) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        DanaEmasWalletV3CardView danaEmasWalletV3CardView = new DanaEmasWalletV3CardView(context, (InvestmentCardModel.EmasCard) item, this.isBalanceVisible, this.walletCardAssetClickListener, this.danaEmasClickListener);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.cl_item_wallet_container);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        danaEmasWalletV3CardView.addCardViewInto(constraintLayout);
    }
}
