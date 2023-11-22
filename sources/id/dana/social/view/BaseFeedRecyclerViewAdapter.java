package id.dana.social.view;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.friendsheader.LoadMoreViewHolder;
import id.dana.social.state.ViewHolderState;
import id.dana.social.state.ViewHolderStateKt;
import id.dana.social.view.activity.detail.EmptyViewHolder;
import id.dana.social.view.activity.detail.ShimmerViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012 \u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0#¢\u0006\u0004\b%\u0010&J%\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u0015J+\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u001fJ%\u0010!\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\nJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\fJ\r\u0010\"\u001a\u00020\b¢\u0006\u0004\b\"\u0010\fR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010$"}, d2 = {"Lid/dana/social/view/BaseFeedRecyclerViewAdapter;", "", "T", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/state/ViewHolderState;", "", "p0", "", "appendItems", "(Ljava/util/List;)V", "getAuthRequestContext", "()V", "moveToNextValue", "", "getItemCount", "()I", "getItemViewType", "(I)I", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "lookAheadTest", "PlaceComponentResult", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "(Lid/dana/social/state/ViewHolderState;)V", "", "prependItems", "getErrorConfigVersion", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseFeedRecyclerViewAdapter<T> extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ViewHolderState<? extends T>>, ViewHolderState<? extends T>> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function0<Unit> MyBillsEntityDataFactory;

    public abstract BaseRecyclerViewHolder<ViewHolderState<T>> KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup);

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public /* synthetic */ void appendItem(int i, Object obj) {
        moveToNextValue();
        super.appendItem(i, (ViewHolderState) obj);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public /* synthetic */ void appendItem(Object obj) {
        moveToNextValue();
        super.appendItem((ViewHolderState) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LoadMoreViewHolder loadMoreViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        int i2 = 2;
        if (i == 2) {
            loadMoreViewHolder = new LoadMoreViewHolder(viewGroup, this.MyBillsEntityDataFactory);
        } else if (i == 3) {
            loadMoreViewHolder = new ShimmerViewHolder(viewGroup);
        } else if (i == 4) {
            loadMoreViewHolder = new EmptyViewHolder(viewGroup, 0, i2, null);
        } else {
            loadMoreViewHolder = KClassImpl$Data$declaredNonStaticMembers$2(viewGroup);
        }
        return loadMoreViewHolder;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public /* synthetic */ void prependItem(Object obj) {
        moveToNextValue();
        super.prependItem((ViewHolderState) obj);
    }

    public BaseFeedRecyclerViewAdapter(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.MyBillsEntityDataFactory = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int p0) {
        T item = getItem(p0);
        Intrinsics.checkNotNullExpressionValue(item, "");
        return ViewHolderStateKt.BuiltInFictitiousFunctionClassFactory((ViewHolderState) item);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        List<T> items = getItems();
        if (items != null) {
            return items.size();
        }
        return 0;
    }

    public final boolean MyBillsEntityDataFactory() {
        return !PlaceComponentResult() && (getItem(getPlaceComponentResult() - 1) instanceof ViewHolderState.LoadingMore);
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return !PlaceComponentResult() && (getItem(getPlaceComponentResult() - 1) instanceof ViewHolderState.Item);
    }

    private boolean scheduleImpl() {
        return !PlaceComponentResult() && (getItem(getPlaceComponentResult() - 1) instanceof ViewHolderState.Shimmer);
    }

    public final boolean PlaceComponentResult() {
        return getPlaceComponentResult() <= 0;
    }

    public final void getAuthRequestContext() {
        if (PlaceComponentResult() || !NetworkUserEntityData$$ExternalSyntheticLambda0() || MyBillsEntityDataFactory()) {
            return;
        }
        ViewHolderState.LoadingMore loadingMore = ViewHolderState.LoadingMore.INSTANCE;
        moveToNextValue();
        super.appendItem(loadingMore);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ViewHolderState.Empty empty = ViewHolderState.Empty.INSTANCE;
        moveToNextValue();
        super.appendItem(empty);
    }

    public final void getErrorConfigVersion() {
        if (!PlaceComponentResult() || scheduleImpl()) {
            return;
        }
        ViewHolderState.Shimmer shimmer = ViewHolderState.Shimmer.INSTANCE;
        moveToNextValue();
        super.appendItem(shimmer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void getAuthRequestContext(ViewHolderState<? extends T> p0) {
        moveToNextValue();
        super.prependItem(p0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void prependItems(List<ViewHolderState<T>> p0) {
        moveToNextValue();
        super.prependItems(p0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void appendItems(List<? extends ViewHolderState<? extends T>> p0) {
        moveToNextValue();
        super.appendItems(p0);
    }

    private final void moveToNextValue() {
        if (!PlaceComponentResult() && lookAheadTest()) {
            removeItem(getPlaceComponentResult() - 1);
        }
        if (!PlaceComponentResult() && scheduleImpl()) {
            removeItem(getPlaceComponentResult() - 1);
        }
        if (PlaceComponentResult() || !MyBillsEntityDataFactory()) {
            return;
        }
        removeItem(getPlaceComponentResult() - 1);
    }

    private final boolean lookAheadTest() {
        return getItem(getPlaceComponentResult() - 1) instanceof ViewHolderState.Empty;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        ViewHolderState viewHolderState = (ViewHolderState) getItem(getPlaceComponentResult() - 1);
        return !PlaceComponentResult() && ((viewHolderState instanceof ViewHolderState.Item) || (viewHolderState instanceof ViewHolderState.LoadingMore));
    }
}
