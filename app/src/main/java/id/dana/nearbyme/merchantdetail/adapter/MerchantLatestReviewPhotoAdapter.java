package id.dana.nearbyme.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantLatestReviewPhotoViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewPhotoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyme/merchantdetail/viewholder/MerchantLatestReviewPhotoViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Z", "p0", "p1", "<init>", "(ZLkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLatestReviewPhotoAdapter extends BaseRecyclerViewAdapter<MerchantLatestReviewPhotoViewHolder, MerchantImageModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<MediaViewerModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ MerchantLatestReviewPhotoAdapter(boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, function1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        List<MerchantImageModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return new MerchantLatestReviewPhotoViewHolder(viewGroup, items, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantLatestReviewPhotoAdapter(boolean z, Function1<? super MediaViewerModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }
}
