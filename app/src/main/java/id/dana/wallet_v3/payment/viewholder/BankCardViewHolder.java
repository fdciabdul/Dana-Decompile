package id.dana.wallet_v3.payment.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.WalletBankCardViewHolderBinding;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/wallet_v3/payment/viewholder/BankCardViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "Lid/dana/databinding/WalletBankCardViewHolderBinding;", "item", "", "bindData", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/WalletBankCardViewHolderBinding;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BankCardViewHolder extends ViewBindingRecyclerViewHolder<WalletV3CardModel, WalletBankCardViewHolderBinding> {
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    public /* synthetic */ BankCardViewHolder(Context context, ViewGroup viewGroup, WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : walletCardAssetClickListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardViewHolder(Context context, ViewGroup viewGroup, WalletCardAssetClickListener walletCardAssetClickListener) {
        super(context, R.layout.wallet_bank_card_view_holder, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.walletCardAssetClickListener = walletCardAssetClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final WalletBankCardViewHolderBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        WalletBankCardViewHolderBinding BuiltInFictitiousFunctionClassFactory = WalletBankCardViewHolderBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(WalletV3CardModel item) {
        super.bindData((BankCardViewHolder) item);
        if (item == null || !(item instanceof PaymentCardModel.BankCard)) {
            return;
        }
        getBinding().PlaceComponentResult.setCard((PaymentCardModel.BankCard) item);
        getBinding().PlaceComponentResult.setOnBankClickListener(this.walletCardAssetClickListener);
    }
}
