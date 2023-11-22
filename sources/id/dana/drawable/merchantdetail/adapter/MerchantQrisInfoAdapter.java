package id.dana.drawable.merchantdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantdetail.adapter.MerchantQrisInfoAdapter;
import id.dana.nearbyme.model.ShopModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantQrisInfoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "", "getItemCount", "()I", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "MyBillsEntityDataFactory", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "MerchantQrisInfoViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantQrisInfoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ShopModel>, ShopModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final BaseRecyclerViewHolder.OnItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getGetAuthRequestContext() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MerchantQrisInfoViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public MerchantQrisInfoAdapter(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onItemClickListener;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantQrisInfoAdapter$MerchantQrisInfoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantQrisInfoViewHolder extends BaseRecyclerViewHolder<ShopModel> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantQrisInfoViewHolder(ViewGroup viewGroup, final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
            super(viewGroup.getContext(), R.layout.item_merchant_qris_info, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(onItemClickListener, "");
            Button button = (Button) this.itemView.findViewById(R.id.setNetAuthId);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantQrisInfoAdapter$MerchantQrisInfoViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MerchantQrisInfoAdapter.MerchantQrisInfoViewHolder.BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                    }
                });
            }
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, MerchantQrisInfoViewHolder merchantQrisInfoViewHolder) {
            Intrinsics.checkNotNullParameter(onItemClickListener, "");
            Intrinsics.checkNotNullParameter(merchantQrisInfoViewHolder, "");
            onItemClickListener.onItemClick(merchantQrisInfoViewHolder.getAbsoluteAdapterPosition());
        }
    }
}
