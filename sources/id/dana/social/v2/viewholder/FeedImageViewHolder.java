package id.dana.social.v2.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B@\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0019\u0010\u0011\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u0013\u0010\u0014R'\u0010\t\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/social/v2/viewholder/FeedImageViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "Lkotlin/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "Landroid/view/ViewGroup;", "p0", "Landroid/view/View;", "p1", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedImageViewHolder extends BaseRecyclerViewHolder<MerchantImageModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<Integer, Unit> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantImageModel merchantImageModel) {
        final MerchantImageModel merchantImageModel2 = merchantImageModel;
        if (merchantImageModel2 != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) this.itemView.findViewById(R.id.FirebaseCommonRegistrar);
            if (shapeableImageView != null) {
                ShapeableImageView shapeableImageView2 = shapeableImageView;
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(shapeableImageView.getContext()).getAuthRequestContext(merchantImageModel2.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory((int) R.drawable.bg_rounded_grey_20_4dp).MyBillsEntityDataFactory(R.drawable.bg_rounded_grey_20_4dp).PlaceComponentResult().MyBillsEntityDataFactory((ImageView) shapeableImageView2);
                if (merchantImageModel2.BuiltInFictitiousFunctionClassFactory()) {
                    ViewExtKt.getAuthRequestContext(shapeableImageView2, ContextCompat.BuiltInFictitiousFunctionClassFactory(shapeableImageView.getContext(), R.color.f22702131099711));
                } else {
                    shapeableImageView.clearColorFilter();
                }
            }
            TextView textView = (TextView) this.itemView.findViewById(R.id.getInstalledPath);
            if (textView != null) {
                textView.setVisibility(merchantImageModel2.BuiltInFictitiousFunctionClassFactory() ? 0 : 8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.viewholder.FeedImageViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedImageViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(FeedImageViewHolder.this, merchantImageModel2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedImageViewHolder(ViewGroup viewGroup, View view, Function1<? super Integer, Unit> function1, Function0<Unit> function0) {
        super(viewGroup.getContext(), view);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.PlaceComponentResult = function1;
        this.BuiltInFictitiousFunctionClassFactory = function0;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedImageViewHolder feedImageViewHolder, MerchantImageModel merchantImageModel) {
        Intrinsics.checkNotNullParameter(feedImageViewHolder, "");
        if (feedImageViewHolder.getBindingAdapterPosition() != -1) {
            if (merchantImageModel.BuiltInFictitiousFunctionClassFactory()) {
                feedImageViewHolder.BuiltInFictitiousFunctionClassFactory.invoke();
            } else {
                feedImageViewHolder.PlaceComponentResult.invoke(Integer.valueOf(feedImageViewHolder.getBindingAdapterPosition()));
            }
        }
    }
}
