package id.dana.phototips.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.databinding.ItemPhotoTipsDescriptionBinding;
import id.dana.phototips.viewholder.PhotoTipsDescriptionViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/phototips/adapter/PhotoTipsDescriptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/phototips/viewholder/PhotoTipsDescriptionViewHolder;", "", "getItemCount", "()I", "", "", "getAuthRequestContext", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PhotoTipsDescriptionAdapter extends RecyclerView.Adapter<PhotoTipsDescriptionViewHolder> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<String> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(PhotoTipsDescriptionViewHolder photoTipsDescriptionViewHolder, int i) {
        PhotoTipsDescriptionViewHolder photoTipsDescriptionViewHolder2 = photoTipsDescriptionViewHolder;
        Intrinsics.checkNotNullParameter(photoTipsDescriptionViewHolder2, "");
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        Intrinsics.checkNotNullParameter(str, "");
        ItemPhotoTipsDescriptionBinding itemPhotoTipsDescriptionBinding = photoTipsDescriptionViewHolder2.KClassImpl$Data$declaredNonStaticMembers$2;
        itemPhotoTipsDescriptionBinding.PlaceComponentResult.setText("·");
        itemPhotoTipsDescriptionBinding.MyBillsEntityDataFactory.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ PhotoTipsDescriptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemPhotoTipsDescriptionBinding authRequestContext = ItemPhotoTipsDescriptionBinding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return new PhotoTipsDescriptionViewHolder(authRequestContext);
    }

    public PhotoTipsDescriptionAdapter(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }
}
