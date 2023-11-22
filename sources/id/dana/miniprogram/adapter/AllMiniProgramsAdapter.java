package id.dana.miniprogram.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.cellcomponent.DanaCellLeftView;
import id.dana.danah5.DanaH5;
import id.dana.domain.miniprogram.interactor.SetFavoriteMiniPrograms;
import id.dana.domain.miniprogram.model.MiniProgram;
import id.dana.miniprogram.MiniProgramStoreActivity;
import id.dana.miniprogram.adapter.AllMiniProgramsAdapter;
import id.dana.miniprogram.di.MiniProgramContract;
import id.dana.miniprogram.di.MiniProgramPresenter;
import id.dana.miniprogram.view.FavoriteButton;
import id.dana.miniprogram.view.OnCheckedChangeListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/miniprogram/adapter/AllMiniProgramsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/miniprogram/adapter/AllMiniProgramsAdapter$ViewHolder;", "Lid/dana/domain/miniprogram/model/MiniProgram;", "<init>", "()V", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AllMiniProgramsAdapter extends BaseRecyclerViewAdapter<ViewHolder, MiniProgram> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ViewHolder(viewGroup);
    }

    public AllMiniProgramsAdapter() {
        setItems(CollectionsKt.emptyList());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/miniprogram/adapter/AllMiniProgramsAdapter$ViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/miniprogram/model/MiniProgram;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends BaseRecyclerViewHolder<MiniProgram> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MiniProgram miniProgram) {
            MiniProgram miniProgram2 = miniProgram;
            Intrinsics.checkNotNullParameter(miniProgram2, "");
            View view = this.itemView;
            view.setTag(miniProgram2.getAppId());
            ((FavoriteButton) view.findViewById(R.id.btnFavorite)).setState(miniProgram2.isFavorite());
            DanaCellLeftView danaCellLeftView = (DanaCellLeftView) view.findViewById(R.id.cellMiniProgram);
            Intrinsics.checkNotNullExpressionValue(danaCellLeftView, "");
            DanaCellLeftView.setCellLeftLabelDesc$default(danaCellLeftView, miniProgram2.getTitle(), miniProgram2.getDescription(), (Integer) null, 4, (Object) null);
            RequestBuilder<Drawable> authRequestContext = Glide.KClassImpl$Data$declaredNonStaticMembers$2(view.getContext()).getAuthRequestContext(miniProgram2.getLogo());
            ImageView iconCell = ((DanaCellLeftView) view.findViewById(R.id.cellMiniProgram)).getIconCell();
            if (iconCell != null) {
                authRequestContext.MyBillsEntityDataFactory(iconCell);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_mini_program_horizontal, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.miniprogram.adapter.AllMiniProgramsAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i) {
                    AllMiniProgramsAdapter.ViewHolder.getAuthRequestContext(AllMiniProgramsAdapter.ViewHolder.this);
                }
            });
            ((FavoriteButton) this.itemView.findViewById(R.id.btnFavorite)).setOnCheckedChangeListener(new OnCheckedChangeListener() { // from class: id.dana.miniprogram.adapter.AllMiniProgramsAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // id.dana.miniprogram.view.OnCheckedChangeListener
                public final void MyBillsEntityDataFactory(boolean z) {
                    AllMiniProgramsAdapter.ViewHolder.PlaceComponentResult(AllMiniProgramsAdapter.ViewHolder.this, z);
                }
            });
        }

        public static /* synthetic */ void PlaceComponentResult(ViewHolder viewHolder, final boolean z) {
            final String obj;
            Intrinsics.checkNotNullParameter(viewHolder, "");
            Object tag = viewHolder.itemView.getTag();
            if (tag == null || (obj = tag.toString()) == null) {
                return;
            }
            Context context = viewHolder.itemView.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.miniprogram.MiniProgramStoreActivity");
            }
            MiniProgramStoreActivity miniProgramStoreActivity = (MiniProgramStoreActivity) context;
            final MiniProgramPresenter presenter = miniProgramStoreActivity.getPresenter();
            List<String> allMiniProgramAppIds = miniProgramStoreActivity.getAllMiniProgramAppIds();
            Intrinsics.checkNotNullParameter(obj, "");
            Intrinsics.checkNotNullParameter(allMiniProgramAppIds, "");
            presenter.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new SetFavoriteMiniPrograms.Params(obj, z, allMiniProgramAppIds), new Function1<Unit, Unit>() { // from class: id.dana.miniprogram.di.MiniProgramPresenter$setFavoriteMiniProgram$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Unit unit) {
                    MiniProgramContract.View view;
                    Intrinsics.checkNotNullParameter(unit, "");
                    view = MiniProgramPresenter.this.PlaceComponentResult;
                    view.onSetFavoriteMiniPrograms(obj, z);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.di.MiniProgramPresenter$setFavoriteMiniProgram$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    MiniProgramContract.View view;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = MiniProgramPresenter.this.PlaceComponentResult;
                    view.onFavoriteLimitExceeded(obj);
                }
            });
        }

        public static /* synthetic */ void getAuthRequestContext(ViewHolder viewHolder) {
            String obj;
            Intrinsics.checkNotNullParameter(viewHolder, "");
            Object tag = viewHolder.itemView.getTag();
            if (tag == null || (obj = tag.toString()) == null) {
                return;
            }
            Context context = viewHolder.itemView.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.miniprogram.MiniProgramStoreActivity");
            }
            ((MiniProgramStoreActivity) context).getPresenter().MyBillsEntityDataFactory(obj);
            DanaH5.openApp$default(obj, null, null, 6, null);
        }
    }
}
