package id.dana.nearbyme.merchantdetail.merchantphoto;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u000b\u0010\fR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Lkotlin/Function1;", "", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "p0", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotoAdapter extends BaseRecyclerViewAdapter<MerchantPhotoViewHolder, MerchantImageModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<Integer, Unit> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        MerchantPhotoViewHolder merchantPhotoViewHolder = new MerchantPhotoViewHolder(viewGroup);
        final Function1<Integer, Unit> function1 = this.getAuthRequestContext;
        merchantPhotoViewHolder.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoAdapter$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i2) {
                MerchantPhotoAdapter.getAuthRequestContext(Function1.this, i2);
            }
        });
        return merchantPhotoViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantPhotoAdapter(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = function1;
    }

    public static /* synthetic */ void getAuthRequestContext(Function1 function1, int i) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(Integer.valueOf(i));
    }
}
