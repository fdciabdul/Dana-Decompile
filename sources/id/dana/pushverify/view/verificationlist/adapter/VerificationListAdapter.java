package id.dana.pushverify.view.verificationlist.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.pushverify.model.VerificationDetailDiffUtil;
import id.dana.pushverify.model.VerificationDetailModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u001e\u0010\u0006\u001a\f\u0012\b\u0012\u0006*\u00020\u00030\u00030\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0013"}, d2 = {"Lid/dana/pushverify/view/verificationlist/adapter/VerificationListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/pushverify/model/VerificationDetailModel;", "", "p0", "getAuthRequestContext", "(I)Lid/dana/pushverify/model/VerificationDetailModel;", "getItemCount", "()I", "getItemViewType", "(I)I", "", "PlaceComponentResult", "(I)Z", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Landroidx/recyclerview/widget/AsyncListDiffer;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationListAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder<VerificationDetailModel>> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final AsyncListDiffer<VerificationDetailModel> getAuthRequestContext = new AsyncListDiffer<>(this, new VerificationDetailDiffUtil());

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public BaseRecyclerViewHolder.OnItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseRecyclerViewHolder<VerificationDetailModel> baseRecyclerViewHolder, int i) {
        BaseRecyclerViewHolder<VerificationDetailModel> baseRecyclerViewHolder2 = baseRecyclerViewHolder;
        Intrinsics.checkNotNullParameter(baseRecyclerViewHolder2, "");
        baseRecyclerViewHolder2.bindData(getAuthRequestContext(i));
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onItemClickListener != null) {
            baseRecyclerViewHolder2.setOnItemClickListener(onItemClickListener);
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, id.dana.base.BaseRecyclerViewHolder<id.dana.pushverify.model.VerificationDetailModel>] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseRecyclerViewHolder<VerificationDetailModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            viewHolder = (BaseRecyclerViewHolder) new VerificationActiveViewHolder(viewGroup);
        } else if (i == 98) {
            viewHolder = (BaseRecyclerViewHolder) new VerificationLoadMoreViewHolder(viewGroup);
        } else if (i == 99) {
            viewHolder = (BaseRecyclerViewHolder) new VerificationShimmerViewHolder(viewGroup);
        } else {
            viewHolder = (BaseRecyclerViewHolder) new VerificationHistoryViewHolder(viewGroup);
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        VerificationDetailModel authRequestContext = getAuthRequestContext(p0);
        if (authRequestContext != null) {
            return authRequestContext.scheduleImpl;
        }
        return 1;
    }

    public final VerificationDetailModel getAuthRequestContext(int p0) {
        if (PlaceComponentResult(p0)) {
            List<VerificationDetailModel> list = this.getAuthRequestContext.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(list, "");
            return list.get(p0);
        }
        return null;
    }

    public final boolean PlaceComponentResult(int p0) {
        return p0 >= 0 && p0 < getItemCount();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerificationListAdapter verificationListAdapter, List list) {
        Intrinsics.checkNotNullParameter(list, "");
        verificationListAdapter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(list, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<VerificationDetailModel> list = this.getAuthRequestContext.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        return list.size();
    }
}
