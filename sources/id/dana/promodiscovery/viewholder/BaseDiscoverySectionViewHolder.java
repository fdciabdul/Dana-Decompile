package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.model.SectionState;
import id.dana.utils.ShimmeringUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH&¢\u0006\u0004\b\u0005\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0012\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0015"}, d2 = {"Lid/dana/promodiscovery/viewholder/BaseDiscoverySectionViewHolder;", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "MyBillsEntityDataFactory", "()Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "", "PlaceComponentResult", "()I", "Landroid/view/View;", "getAuthRequestContext", "()Landroid/view/View;", "", "p0", "", "(Ljava/util/List;)V", "Lid/dana/promodiscovery/model/SectionState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promodiscovery/model/SectionState;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lkotlin/Lazy;", "Landroid/view/ViewGroup;", "p1", "<init>", "(ILandroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseDiscoverySectionViewHolder<T> extends BaseRecyclerViewHolder<DiscoverySectionModel<T>> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[SectionState.values().length];
            iArr[SectionState.ACTIVE.ordinal()] = 1;
            iArr[SectionState.LOADING.ordinal()] = 2;
            iArr[SectionState.ERROR_GENERAL.ordinal()] = 3;
            iArr[SectionState.ERROR_NETWORK.ordinal()] = 4;
            iArr[SectionState.ERROR_LOCATION_PERMISSION.ordinal()] = 5;
            PlaceComponentResult = iArr;
        }
    }

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(SectionState p0);

    public abstract BaseDiscoveryItemAdapter<T> MyBillsEntityDataFactory();

    public abstract void MyBillsEntityDataFactory(List<? extends T> p0);

    public abstract int PlaceComponentResult();

    public abstract View getAuthRequestContext();

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(Object obj) {
        DiscoverySectionModel discoverySectionModel = (DiscoverySectionModel) obj;
        Intrinsics.checkNotNullParameter(discoverySectionModel, "");
        super.bindData(discoverySectionModel);
        SectionState sectionState = discoverySectionModel.BuiltInFictitiousFunctionClassFactory;
        List<? extends T> list = discoverySectionModel.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(sectionState, "");
        Intrinsics.checkNotNullParameter(list, "");
        int i = WhenMappings.PlaceComponentResult[sectionState.ordinal()];
        if (i == 1) {
            Object value = this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "");
            ((SkeletonScreen) value).PlaceComponentResult();
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(0);
            MyBillsEntityDataFactory(list);
        } else if (i == 2) {
            Object value2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "");
            ((SkeletonScreen) value2).MyBillsEntityDataFactory();
        } else if (i == 3 || i == 4 || i == 5) {
            Object value3 = this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            Intrinsics.checkNotNullExpressionValue(value3, "");
            ((SkeletonScreen) value3).PlaceComponentResult();
            KClassImpl$Data$declaredNonStaticMembers$2(sectionState);
        }
        BaseDiscoveryItemAdapter<T> MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter(sectionState, "");
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = sectionState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDiscoverySectionViewHolder(int i, ViewGroup viewGroup) {
        super(viewGroup.getContext(), i, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ViewSkeletonScreen>(this) { // from class: id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder$skeletonScreen$2
            final /* synthetic */ BaseDiscoverySectionViewHolder<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                return ShimmeringUtil.PlaceComponentResult(this.this$0.getAuthRequestContext(), this.this$0.PlaceComponentResult());
            }
        });
    }
}
