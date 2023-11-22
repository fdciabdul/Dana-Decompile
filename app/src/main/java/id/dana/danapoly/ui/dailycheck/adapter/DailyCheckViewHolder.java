package id.dana.danapoly.ui.dailycheck.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.danapoly.databinding.ItemDailyCheckPointBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/danapoly/databinding/ItemDailyCheckPointBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/databinding/ItemDailyCheckPointBinding;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "p0", "p1", "", "p2", "<init>", "(Landroid/content/Context;Lid/dana/danapoly/databinding/ItemDailyCheckPointBinding;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyCheckViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final ItemDailyCheckPointBinding MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Context PlaceComponentResult;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[DailyCheckItemState.values().length];
            iArr[DailyCheckItemState.UPCOMING.ordinal()] = 1;
            iArr[DailyCheckItemState.ACTIVE.ordinal()] = 2;
            iArr[DailyCheckItemState.MISSED.ordinal()] = 3;
            iArr[DailyCheckItemState.COMPLETED.ordinal()] = 4;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyCheckViewHolder(Context context, ItemDailyCheckPointBinding itemDailyCheckPointBinding, int i) {
        super(itemDailyCheckPointBinding.getErrorConfigVersion);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(itemDailyCheckPointBinding, "");
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = itemDailyCheckPointBinding;
        ViewGroup.LayoutParams layoutParams = itemDailyCheckPointBinding.MyBillsEntityDataFactory.getLayoutParams();
        layoutParams.width = i;
        itemDailyCheckPointBinding.MyBillsEntityDataFactory.setLayoutParams(layoutParams);
    }
}
