package id.dana.social.view.activity.detail;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.social.state.ViewHolderState;
import id.dana.social.state.ViewHolderStateKt;
import id.dana.social.view.BaseFeedRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ+\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00182\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001a\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e"}, d2 = {"Lid/dana/social/view/activity/detail/FeedCommentAdapter;", "Lid/dana/social/view/BaseFeedRecyclerViewAdapter;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/ui/model/FeedCommentModel;)I", "", "moveToNextValue", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/state/ViewHolderState;", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "", "Lkotlin/Function1;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lid/dana/social/view/activity/detail/FeedCommentInteraction;", "Lid/dana/social/view/activity/detail/FeedCommentInteraction;", "Z", "PlaceComponentResult", "getAuthRequestContext", "p2", "p3", "<init>", "(ZZZLid/dana/social/view/activity/detail/FeedCommentInteraction;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedCommentAdapter extends BaseFeedRecyclerViewAdapter<FeedCommentModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedCommentInteraction MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((FeedCommentAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentAdapter(boolean z, boolean z2, boolean z3, final FeedCommentInteraction feedCommentInteraction) {
        super(new Function0<Unit>() { // from class: id.dana.social.view.activity.detail.FeedCommentAdapter.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                feedCommentInteraction.getAuthRequestContext();
            }
        });
        Intrinsics.checkNotNullParameter(feedCommentInteraction, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.PlaceComponentResult = z2;
        this.getAuthRequestContext = z3;
        this.MyBillsEntityDataFactory = feedCommentInteraction;
    }

    @Override // id.dana.social.view.BaseFeedRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        ViewHolderState item = getItem(p0);
        Intrinsics.checkNotNullExpressionValue(item, "");
        return ViewHolderStateKt.BuiltInFictitiousFunctionClassFactory(item);
    }

    @Override // id.dana.social.view.BaseFeedRecyclerViewAdapter
    public final BaseRecyclerViewHolder<ViewHolderState<FeedCommentModel>> KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new FeedCommentViewHolder(viewGroup, new Function1<Integer, FeedCommentModel>() { // from class: id.dana.social.view.activity.detail.FeedCommentAdapter$onCreateViewHolderChild$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ FeedCommentModel invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final FeedCommentModel invoke(int i) {
                Object item = FeedCommentAdapter.this.getItem(i);
                if (item != null) {
                    return (FeedCommentModel) ((ViewHolderState.Item) item).BuiltInFictitiousFunctionClassFactory;
                }
                throw new NullPointerException("null cannot be cast to non-null type id.dana.social.state.ViewHolderState.Item<id.dana.feeds.ui.model.FeedCommentModel>");
            }
        }, this.MyBillsEntityDataFactory, new Function1<Integer, Unit>() { // from class: id.dana.social.view.activity.detail.FeedCommentAdapter$onCreateViewHolderChild$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                FeedCommentAdapter.this.removeItem(i);
            }
        }, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.getAuthRequestContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<ViewHolderState<FeedCommentModel>> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.bindData(getItem(p1));
    }

    @Override // id.dana.social.view.BaseFeedRecyclerViewAdapter, id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        List<ViewHolderState<? extends T>> items = getItems();
        if (items != 0) {
            return items.size();
        }
        return 0;
    }

    public final boolean moveToNextValue() {
        Iterable items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (obj instanceof ViewHolderState.Item) {
                arrayList.add(obj);
            }
        }
        return arrayList.isEmpty();
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        Intrinsics.checkNotNullExpressionValue(getItems(), "");
        if ((!r0.isEmpty()) != false) {
            List<ViewHolderState<? extends T>> items = getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            if (CollectionsKt.first((List) items) instanceof ViewHolderState.Shimmer) {
                return true;
            }
        }
        return false;
    }

    public final int BuiltInFictitiousFunctionClassFactory(FeedCommentModel p0) {
        Object obj;
        FeedCommentModel feedCommentModel;
        Intrinsics.checkNotNullParameter(p0, "");
        if (BuiltInFictitiousFunctionClassFactory()) {
            Iterable items = getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : items) {
                if (obj2 instanceof ViewHolderState.Item) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCommentModel) ((ViewHolderState.Item) obj).BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory, p0.moveToNextValue)) {
                    break;
                }
            }
            ViewHolderState.Item item = (ViewHolderState.Item) obj;
            if (item != null && (feedCommentModel = (FeedCommentModel) item.BuiltInFictitiousFunctionClassFactory) != null) {
                return getItems().indexOf(new ViewHolderState.Item(feedCommentModel));
            }
        }
        return -1;
    }

    public final void MyBillsEntityDataFactory(String p0, Function1<? super FeedCommentModel, Unit> p1) {
        Object obj;
        FeedCommentModel feedCommentModel;
        if (BuiltInFictitiousFunctionClassFactory()) {
            Iterable items = getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : items) {
                if (obj2 instanceof ViewHolderState.Item) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCommentModel) ((ViewHolderState.Item) obj).BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory, p0)) {
                    break;
                }
            }
            ViewHolderState.Item item = (ViewHolderState.Item) obj;
            if (item == null || (feedCommentModel = (FeedCommentModel) item.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            int indexOf = getItems().indexOf(new ViewHolderState.Item(feedCommentModel));
            p1.invoke(feedCommentModel);
            notifyItemChanged(indexOf, feedCommentModel);
        }
    }
}
