package id.dana.kyb.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.kyb.model.KybServiceModel;
import id.dana.sendmoney_v2.landing.adapter.ExpandableAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000b2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000b\fB%\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/kyb/adapter/KybServiceAdapter;", "Lid/dana/sendmoney_v2/landing/adapter/ExpandableAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/kyb/model/KybServiceModel;", "", "p0", "p1", "", "p2", "<init>", "(IIZ)V", "Companion", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceAdapter extends ExpandableAdapter<BaseRecyclerViewHolder<KybServiceModel>, KybServiceModel> {
    public KybServiceAdapter() {
        this(0, 0, false, 7, null);
    }

    public /* synthetic */ KybServiceAdapter(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 4 : i2, (i3 & 4) != 0 ? false : z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ViewHolder(viewGroup);
    }

    private KybServiceAdapter(int i, int i2, boolean z) {
        super(i, i2, z, false, 8, null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/adapter/KybServiceAdapter$ViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/kyb/model/KybServiceModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class ViewHolder extends BaseRecyclerViewHolder<KybServiceModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(KybServiceModel kybServiceModel) {
            KybServiceModel kybServiceModel2 = kybServiceModel;
            if (kybServiceModel2 != null) {
                String str = kybServiceModel2.getAuthRequestContext;
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.iv_icon)));
                String str2 = kybServiceModel2.getErrorConfigVersion;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tv_title);
                if (str2 == null) {
                    str2 = "";
                }
                appCompatTextView.setText(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_kyb_service, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}
