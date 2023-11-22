package id.dana.myprofile.mepagerevamp.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/myprofile/mepagerevamp/adapter/GridUserServiceAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/myprofile/mepagerevamp/adapter/GridUserServiceAdapter$ViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "<init>", "()V", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridUserServiceAdapter extends BaseRecyclerViewAdapter<ViewHolder, SettingModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ViewHolder(viewGroup);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/myprofile/mepagerevamp/adapter/GridUserServiceAdapter$ViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends BaseRecyclerViewHolder<SettingModel> {
        private SkeletonScreen MyBillsEntityDataFactory;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x017a, code lost:
        
            if (r2 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x017d, code lost:
        
            if (r2 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x017f, code lost:
        
            r2 = "";
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01b0  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01ca  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01f3  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x020e  */
        @Override // id.dana.base.BaseRecyclerViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final /* synthetic */ void bindData(id.dana.domain.profilemenu.model.SettingModel r13) {
            /*
                Method dump skipped, instructions count: 592
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.adapter.GridUserServiceAdapter.ViewHolder.bindData(java.lang.Object):void");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.layout_custom_gridview_user_service, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}
