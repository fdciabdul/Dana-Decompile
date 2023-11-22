package id.dana.base;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/base/BaseAsyncRecyclerViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/Object;)V", "Lid/dana/base/BaseAsyncView;", "<init>", "(Lid/dana/base/BaseAsyncView;)V", "OnItemClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseAsyncRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/base/BaseAsyncRecyclerViewHolder$OnItemClickListener;", "", "", "p0", "", "getAuthRequestContext", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnItemClickListener {
        void getAuthRequestContext(int p0);
    }

    public abstract void MyBillsEntityDataFactory(T p0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAsyncRecyclerViewHolder(BaseAsyncView baseAsyncView) {
        super(baseAsyncView);
        Intrinsics.checkNotNullParameter(baseAsyncView, "");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseAsyncRecyclerViewHolder baseAsyncRecyclerViewHolder, OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(baseAsyncRecyclerViewHolder, "");
        if (baseAsyncRecyclerViewHolder.getAbsoluteAdapterPosition() >= 0) {
            onItemClickListener.getAuthRequestContext(baseAsyncRecyclerViewHolder.getAbsoluteAdapterPosition());
        }
    }
}
