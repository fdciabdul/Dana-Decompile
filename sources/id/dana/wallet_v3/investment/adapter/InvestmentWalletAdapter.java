package id.dana.wallet_v3.investment.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.investment.viewholder.DanaEmasCardViewHolder;
import id.dana.wallet_v3.investment.viewholder.DanaGoalsCardViewHolder;
import id.dana.wallet_v3.investment.viewholder.DanaPlusWalletViewHolder;
import id.dana.wallet_v3.investment.viewholder.InvestmentEmptyCardViewHolder;
import id.dana.wallet_v3.listener.DanaEmasClickListener;
import id.dana.wallet_v3.listener.DanaPlusClickListener;
import id.dana.wallet_v3.listener.GoalsClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.WalletV3CardModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R.\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010#\u001a\u0004\u0018\u00010\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R.\u0010%\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R.\u0010(\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u0016\u0010,\u001a\u0004\u0018\u00010+8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/wallet_v3/investment/adapter/InvestmentWalletAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "position", "getItemViewType", "(I)I", "assetType", "", "notifyDataSetChangeByAsset", "(I)V", "holder", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "danaGoalsClickListener", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "", "value", "danaPlusBalanceVisibility", "Ljava/lang/Boolean;", "getDanaPlusBalanceVisibility", "()Ljava/lang/Boolean;", "setDanaPlusBalanceVisibility", "(Ljava/lang/Boolean;)V", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "danaPlusClickListener", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "emasBalanceVisibility", "getEmasBalanceVisibility", "setEmasBalanceVisibility", "goalsBalanceVisibility", "getGoalsBalanceVisibility", "setGoalsBalanceVisibility", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/listener/DanaEmasClickListener;Lid/dana/wallet_v3/listener/GoalsClickListener;Lid/dana/wallet_v3/listener/DanaPlusClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvestmentWalletAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<WalletV3CardModel>, WalletV3CardModel> {
    private final DanaEmasClickListener danaEmasClickListener;
    private final GoalsClickListener danaGoalsClickListener;
    private Boolean danaPlusBalanceVisibility;
    private final DanaPlusClickListener danaPlusClickListener;
    private Boolean emasBalanceVisibility;
    private Boolean goalsBalanceVisibility;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    public InvestmentWalletAdapter() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ InvestmentWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener, DanaEmasClickListener danaEmasClickListener, GoalsClickListener goalsClickListener, DanaPlusClickListener danaPlusClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : walletCardAssetClickListener, (i & 2) != 0 ? null : danaEmasClickListener, (i & 4) != 0 ? null : goalsClickListener, (i & 8) != 0 ? null : danaPlusClickListener);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((InvestmentWalletAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    public InvestmentWalletAdapter(WalletCardAssetClickListener walletCardAssetClickListener, DanaEmasClickListener danaEmasClickListener, GoalsClickListener goalsClickListener, DanaPlusClickListener danaPlusClickListener) {
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.danaEmasClickListener = danaEmasClickListener;
        this.danaGoalsClickListener = goalsClickListener;
        this.danaPlusClickListener = danaPlusClickListener;
    }

    @JvmName(name = "getGoalsBalanceVisibility")
    public final Boolean getGoalsBalanceVisibility() {
        return this.goalsBalanceVisibility;
    }

    @JvmName(name = "setGoalsBalanceVisibility")
    public final void setGoalsBalanceVisibility(Boolean bool) {
        this.goalsBalanceVisibility = bool;
        notifyDataSetChangeByAsset(6);
    }

    @JvmName(name = "getEmasBalanceVisibility")
    public final Boolean getEmasBalanceVisibility() {
        return this.emasBalanceVisibility;
    }

    @JvmName(name = "setEmasBalanceVisibility")
    public final void setEmasBalanceVisibility(Boolean bool) {
        this.emasBalanceVisibility = bool;
        notifyDataSetChangeByAsset(5);
    }

    @JvmName(name = "getDanaPlusBalanceVisibility")
    public final Boolean getDanaPlusBalanceVisibility() {
        return this.danaPlusBalanceVisibility;
    }

    @JvmName(name = "setDanaPlusBalanceVisibility")
    public final void setDanaPlusBalanceVisibility(Boolean bool) {
        this.danaPlusBalanceVisibility = bool;
        notifyDataSetChangeByAsset(4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseRecyclerViewHolder<WalletV3CardModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        if (viewType == 4) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            Boolean bool = this.danaPlusBalanceVisibility;
            return new DanaPlusWalletViewHolder(context, parent, bool != null ? bool.booleanValue() : false, this.walletCardAssetClickListener, this.danaPlusClickListener);
        } else if (viewType == 5) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            Boolean bool2 = this.emasBalanceVisibility;
            return new DanaEmasCardViewHolder(context2, parent, bool2 != null ? bool2.booleanValue() : false, this.walletCardAssetClickListener, this.danaEmasClickListener);
        } else if (viewType == 6) {
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "");
            Boolean bool3 = this.goalsBalanceVisibility;
            return new DanaGoalsCardViewHolder(context3, parent, bool3 != null ? bool3.booleanValue() : false, this.walletCardAssetClickListener, this.danaGoalsClickListener);
        } else if (viewType == 7) {
            Context context4 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "");
            return new InvestmentEmptyCardViewHolder(context4, parent, this.walletCardAssetClickListener);
        } else {
            Context context5 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "");
            return new InvestmentEmptyCardViewHolder(context5, parent, this.walletCardAssetClickListener);
        }
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<WalletV3CardModel> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "");
        if (holder instanceof DanaGoalsCardViewHolder) {
            DanaGoalsCardViewHolder danaGoalsCardViewHolder = (DanaGoalsCardViewHolder) holder;
            Boolean bool = this.goalsBalanceVisibility;
            danaGoalsCardViewHolder.setBalanceVisible(bool != null ? bool.booleanValue() : false);
        } else if (holder instanceof DanaEmasCardViewHolder) {
            DanaEmasCardViewHolder danaEmasCardViewHolder = (DanaEmasCardViewHolder) holder;
            Boolean bool2 = this.emasBalanceVisibility;
            danaEmasCardViewHolder.setBalanceVisible(bool2 != null ? bool2.booleanValue() : false);
        } else if (holder instanceof DanaPlusWalletViewHolder) {
            DanaPlusWalletViewHolder danaPlusWalletViewHolder = (DanaPlusWalletViewHolder) holder;
            Boolean bool3 = this.danaPlusBalanceVisibility;
            danaPlusWalletViewHolder.setBalanceVisible(bool3 != null ? bool3.booleanValue() : false);
        }
        super.onBindViewHolder((InvestmentWalletAdapter) holder, position);
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
