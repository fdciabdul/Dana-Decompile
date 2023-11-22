package id.dana.drawable.merchantdetail.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Executors;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantdetail.adapter.MerchantPromoAdapter;
import id.dana.nearbyme.model.PromoInfoModel;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB$\u0012\u001b\u0010\n\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR)\u0010\t\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/PromoInfoModel;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "MerchantPromoViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPromoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PromoInfoModel>, PromoInfoModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<PromoInfoModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MerchantPromoViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantPromoAdapter(Function1<? super PromoInfoModel, Unit> function1) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u001d\b\u0002\u0010\u000b\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR)\u0010\b\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoAdapter$MerchantPromoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/PromoInfoModel;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantPromoViewHolder extends BaseRecyclerViewHolder<PromoInfoModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final Function1<PromoInfoModel, Unit> getAuthRequestContext;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(PromoInfoModel promoInfoModel) {
            Executor executor;
            final PromoInfoModel promoInfoModel2 = promoInfoModel;
            if (promoInfoModel2 != null) {
                RequestBuilder MyBillsEntityDataFactory = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(Integer.valueOf((int) R.drawable.ic_promo_deals_background)).MyBillsEntityDataFactory((Transformation<Bitmap>) new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28552131165359), 0, RoundedCornersTransformation.CornerType.LEFT));
                CustomTarget<Drawable> customTarget = new CustomTarget<Drawable>() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantPromoAdapter$MerchantPromoViewHolder$bindData$1
                    @Override // com.bumptech.glide.request.target.Target
                    public final void onLoadCleared(Drawable p0) {
                    }

                    @Override // com.bumptech.glide.request.target.Target
                    public final /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                        Drawable drawable = (Drawable) obj;
                        Intrinsics.checkNotNullParameter(drawable, "");
                        AppCompatImageView appCompatImageView = (AppCompatImageView) MerchantPromoAdapter.MerchantPromoViewHolder.this.itemView.findViewById(R.id.GetLeaderboardEntryBanner);
                        if (appCompatImageView != null) {
                            appCompatImageView.setBackground(drawable);
                        }
                    }
                };
                executor = Executors.PlaceComponentResult;
                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(customTarget, null, MyBillsEntityDataFactory, executor);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.GetLeaderboardEntryBanner);
                if (appCompatImageView != null) {
                    if (appCompatImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_promo_tag);
                    } else {
                        appCompatImageView.setImageResource(R.drawable.ic_promo_tag);
                    }
                }
                TextView textView = (TextView) this.itemView.findViewById(R.id.getLogSourceName);
                if (textView != null) {
                    String str = promoInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (str == null) {
                        str = "";
                    }
                    textView.setText(str);
                }
                TextView textView2 = (TextView) this.itemView.findViewById(R.id.isHelperTextDisplayed);
                if (textView2 != null) {
                    textView2.setText(getContext().getString(R.string.promo_description, promoInfoModel2.BuiltInFictitiousFunctionClassFactory(), promoInfoModel2.MyBillsEntityDataFactory()));
                }
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantPromoAdapter$MerchantPromoViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MerchantPromoAdapter.MerchantPromoViewHolder.getAuthRequestContext(MerchantPromoAdapter.MerchantPromoViewHolder.this, promoInfoModel2);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MerchantPromoViewHolder(ViewGroup viewGroup, Function1<? super PromoInfoModel, Unit> function1) {
            super(viewGroup.getContext(), R.layout.item_promo_deals, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.getAuthRequestContext = function1;
        }

        public static /* synthetic */ void getAuthRequestContext(MerchantPromoViewHolder merchantPromoViewHolder, PromoInfoModel promoInfoModel) {
            Intrinsics.checkNotNullParameter(merchantPromoViewHolder, "");
            Function1<PromoInfoModel, Unit> function1 = merchantPromoViewHolder.getAuthRequestContext;
            if (function1 != null) {
                function1.invoke(promoInfoModel);
            }
        }
    }
}
