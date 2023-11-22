package id.dana.social.v2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.social.v2.viewholder.FeedImageViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B0\u0012\u0019\u0010\u0005\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR'\u0010\t\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/social/v2/adapter/FeedNearbyUgcAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/social/v2/viewholder/FeedImageViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "", "p0", "getItemViewType", "(I)I", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedNearbyUgcAdapter extends BaseRecyclerViewAdapter<FeedImageViewHolder, MerchantImageModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<Integer, Unit> MyBillsEntityDataFactory;
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<MerchantImageModel> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_feed_image, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        }
        StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
        if (i == 2) {
            layoutParams2.height = viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.f29202131165459);
        } else {
            layoutParams2.height = viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.f29192131165458);
        }
        layoutParams2.BuiltInFictitiousFunctionClassFactory = i == 0;
        inflate.setLayoutParams(layoutParams2);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        return new FeedImageViewHolder(viewGroup, inflate, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedNearbyUgcAdapter(Function1<? super Integer, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.MyBillsEntityDataFactory = function1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        int placeComponentResult = getPlaceComponentResult();
        if (placeComponentResult != 1) {
            if (placeComponentResult != 2) {
                return (placeComponentResult == 3 && p0 == 0) ? 1 : 2;
            }
            return 1;
        }
        return 0;
    }
}
