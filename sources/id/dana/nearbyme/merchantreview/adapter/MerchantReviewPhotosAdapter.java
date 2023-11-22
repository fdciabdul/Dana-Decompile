package id.dana.nearbyme.merchantreview.adapter;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.nearbyme.merchantreview.viewholder.MerchantReviewPhotosViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0012\u0010\u0007\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewPhotosAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyme/merchantreview/viewholder/MerchantReviewPhotosViewHolder;", "Landroid/net/Uri;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewPhotosAdapter extends BaseRecyclerViewAdapter<MerchantReviewPhotosViewHolder, Uri> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        final MerchantReviewPhotosViewHolder merchantReviewPhotosViewHolder = new MerchantReviewPhotosViewHolder(viewGroup);
        CircleImageView circleImageView = (CircleImageView) merchantReviewPhotosViewHolder.itemView.findViewById(R.id.iv_delete);
        circleImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.adapter.MerchantReviewPhotosAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantReviewPhotosAdapter.BuiltInFictitiousFunctionClassFactory(MerchantReviewPhotosAdapter.this, merchantReviewPhotosViewHolder);
            }
        });
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        circleImageView.setVisibility(this.PlaceComponentResult ^ true ? 0 : 8);
        return merchantReviewPhotosViewHolder;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MerchantReviewPhotosAdapter merchantReviewPhotosAdapter, MerchantReviewPhotosViewHolder merchantReviewPhotosViewHolder) {
        Intrinsics.checkNotNullParameter(merchantReviewPhotosAdapter, "");
        Intrinsics.checkNotNullParameter(merchantReviewPhotosViewHolder, "");
        merchantReviewPhotosAdapter.removeItem(merchantReviewPhotosViewHolder.getAdapterPosition());
    }
}
