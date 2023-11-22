package id.dana.miniprogram.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.danah5.DanaH5;
import id.dana.domain.miniprogram.model.MiniProgram;
import id.dana.miniprogram.MiniProgramStoreActivity;
import id.dana.miniprogram.adapter.GridMiniProgramAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/miniprogram/adapter/GridMiniProgramAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/miniprogram/adapter/GridMiniProgramAdapter$ViewHolder;", "Lid/dana/domain/miniprogram/model/MiniProgram;", "<init>", "()V", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridMiniProgramAdapter extends BaseRecyclerViewAdapter<ViewHolder, MiniProgram> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ViewHolder(viewGroup);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/miniprogram/adapter/GridMiniProgramAdapter$ViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/miniprogram/model/MiniProgram;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends BaseRecyclerViewHolder<MiniProgram> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MiniProgram miniProgram) {
            MiniProgram miniProgram2 = miniProgram;
            Intrinsics.checkNotNullParameter(miniProgram2, "");
            View view = this.itemView;
            view.setTag(miniProgram2.getAppId());
            ((TextView) view.findViewById(R.id.tvMiniProgramTitle)).setText(miniProgram2.getTitle());
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(view.getContext()).getAuthRequestContext(miniProgram2.getLogo()).MyBillsEntityDataFactory((ImageView) ((CircleImageView) this.itemView.findViewById(R.id.ivMiniProgramLogo)));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_item_favorit_recent_mini_program, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.miniprogram.adapter.GridMiniProgramAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i) {
                    GridMiniProgramAdapter.ViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(GridMiniProgramAdapter.ViewHolder.this);
                }
            });
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ViewHolder viewHolder) {
            String obj;
            Intrinsics.checkNotNullParameter(viewHolder, "");
            Object tag = viewHolder.itemView.getTag();
            if (tag == null || (obj = tag.toString()) == null) {
                return;
            }
            DanaH5.openApp$default(obj, null, null, 6, null);
            Context context = viewHolder.itemView.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.miniprogram.MiniProgramStoreActivity");
            }
            ((MiniProgramStoreActivity) context).getPresenter().MyBillsEntityDataFactory(obj);
        }
    }
}
