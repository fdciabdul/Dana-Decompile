package id.dana.richview.moreforyou;

import android.content.Context;
import android.view.ViewGroup;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.richview.moreforyou.model.MoreForYouModel;
import id.dana.richview.moreforyou.viewholder.MoreForYouItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/richview/moreforyou/MoreForYouAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/richview/moreforyou/viewholder/MoreForYouItem;", "Lid/dana/richview/moreforyou/model/MoreForYouModel;", "", "bizScenario", "", "getIndexMoreForYouModel", "(Ljava/lang/String;)I", "position", "getItem", "(I)Lid/dana/richview/moreforyou/model/MoreForYouModel;", "", "isPositionValid", "(I)Z", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/richview/moreforyou/viewholder/MoreForYouItem;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoreForYouAdapter extends BaseRecyclerViewAdapter<MoreForYouItem, MoreForYouModel> {
    private final Context context;

    public MoreForYouAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final MoreForYouItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        return new MoreForYouItem(this.context, parent);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final MoreForYouModel getItem(int position) {
        if (isPositionValid(position)) {
            MoreForYouModel moreForYouModel = getItems().get(position);
            Intrinsics.checkNotNullExpressionValue(moreForYouModel, "");
            return moreForYouModel;
        }
        return new MoreForYouModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public final int getIndexMoreForYouModel(String bizScenario) {
        Intrinsics.checkNotNullParameter(bizScenario, "");
        int placeComponentResult = getPlaceComponentResult();
        for (int i = 0; i < placeComponentResult; i++) {
            if (Intrinsics.areEqual(bizScenario, getItem(i).getBizScenario())) {
                return i;
            }
        }
        return -1;
    }

    private final boolean isPositionValid(int position) {
        return position >= 0 && position < getPlaceComponentResult();
    }
}
