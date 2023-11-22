package id.dana.drawable.merchantdetail.sections;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.common.decoration.HorizontalItemDecoration;
import id.dana.drawable.merchantdetail.adapter.MerchantSpecialDealsItemAdapter;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.model.NearbyDealsSectionModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0019\u0010\u0011\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R)\u0010\n\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\t0\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/sections/MerchantSpecialDealsSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/NearbyDealsSectionModel;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantSpecialDealsItemAdapter;", "PlaceComponentResult", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantSpecialDealsItemAdapter;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "Lkotlin/ParameterName;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantSpecialDealsSectionViewHolder extends BaseRecyclerViewHolder<NearbyDealsSectionModel> {
    private Function1<? super MerchantProductInfoModel, Unit> BuiltInFictitiousFunctionClassFactory;
    private Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;
    private MerchantSpecialDealsItemAdapter PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(NearbyDealsSectionModel nearbyDealsSectionModel) {
        NearbyDealsSectionModel nearbyDealsSectionModel2 = nearbyDealsSectionModel;
        Intrinsics.checkNotNullParameter(nearbyDealsSectionModel2, "");
        super.bindData(nearbyDealsSectionModel2);
        this.PlaceComponentResult.setItems(nearbyDealsSectionModel2.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantSpecialDealsSectionViewHolder(ViewGroup viewGroup, Function1<? super MerchantProductInfoModel, Unit> function1, Function0<Unit> function0) {
        super(viewGroup.getContext(), R.layout.special_deals_section_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.BuiltInFictitiousFunctionClassFactory = function1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        this.PlaceComponentResult = new MerchantSpecialDealsItemAdapter(function1, function0);
        ((RecyclerView) this.itemView.findViewById(R.id.rv_special_deals)).setAdapter(this.PlaceComponentResult);
        ((RecyclerView) this.itemView.findViewById(R.id.rv_special_deals)).addItemDecoration(new HorizontalItemDecoration(ViewExtKt.PlaceComponentResult(4.0f), HorizontalItemDecoration.DecorationMode.HORIZONTAL_ONLY));
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rv_special_deals);
        final Context context = getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context) { // from class: id.dana.nearbyrevamp.merchantdetail.sections.MerchantSpecialDealsSectionViewHolder$setupLayoutManagerAndItemDecoration$1
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public final boolean checkLayoutParams(RecyclerView.LayoutParams p0) {
                if (p0 != null) {
                    double width = getWidth();
                    Double.isNaN(width);
                    p0.width = (int) (width * 0.448d);
                    return true;
                }
                return true;
            }
        });
        ((RecyclerView) this.itemView.findViewById(R.id.rv_special_deals)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyrevamp.merchantdetail.sections.MerchantSpecialDealsSectionViewHolder$setupScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) MerchantSpecialDealsSectionViewHolder.this.itemView.findViewById(R.id.rv_special_deals)).findViewHolderForAdapterPosition(0);
                Unit unit = null;
                View view = findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null;
                if (view != null) {
                    MerchantSpecialDealsSectionViewHolder merchantSpecialDealsSectionViewHolder = MerchantSpecialDealsSectionViewHolder.this;
                    if (view.getX() < 0.0f) {
                        MerchantSpecialDealsSectionViewHolder.PlaceComponentResult(merchantSpecialDealsSectionViewHolder, 1.0f - (Math.abs(view.getX()) / view.getWidth()));
                        ((TextView) merchantSpecialDealsSectionViewHolder.itemView.findViewById(R.id.tv_header)).setAlpha(Math.abs(view.getX()) / view.getWidth());
                    } else {
                        ((TextView) merchantSpecialDealsSectionViewHolder.itemView.findViewById(R.id.tv_header)).setAlpha(0.0f);
                        MerchantSpecialDealsSectionViewHolder.PlaceComponentResult(merchantSpecialDealsSectionViewHolder, 1.0f);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    MerchantSpecialDealsSectionViewHolder merchantSpecialDealsSectionViewHolder2 = MerchantSpecialDealsSectionViewHolder.this;
                    ((TextView) merchantSpecialDealsSectionViewHolder2.itemView.findViewById(R.id.tv_header)).setAlpha(1.0f);
                    MerchantSpecialDealsSectionViewHolder.PlaceComponentResult(merchantSpecialDealsSectionViewHolder2, 0.0f);
                }
            }
        });
    }

    public static final /* synthetic */ void PlaceComponentResult(MerchantSpecialDealsSectionViewHolder merchantSpecialDealsSectionViewHolder, float f) {
        ((ImageView) merchantSpecialDealsSectionViewHolder.itemView.findViewById(R.id.BottomSheetType)).setAlpha(f);
        ((TextView) merchantSpecialDealsSectionViewHolder.itemView.findViewById(R.id.setDrawValueAboveBar)).setAlpha(f);
        ((TextView) merchantSpecialDealsSectionViewHolder.itemView.findViewById(R.id.paramsForAnalyticsIntent)).setAlpha(f);
    }
}
