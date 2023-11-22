package id.dana.miniprogram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.extension.view.ViewExtKt;
import id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B+\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\f\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0012\u0010\n\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/miniprogram/adapter/MiniProgramAgreementsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/miniprogram/adapter/MiniProgramAgreementsAdapter$ViewHolder;", "", "getItemCount", "()I", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "PlaceComponentResult", "MyBillsEntityDataFactory", "p0", "p1", "p2", "<init>", "(Ljava/util/List;II)V", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MiniProgramAgreementsAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    public MiniProgramAgreementsAdapter() {
        this(null, 0, 0, 7, null);
    }

    public /* synthetic */ MiniProgramAgreementsAdapter(List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? 6 : i, (i3 & 4) != 0 ? 6 : i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        Intrinsics.checkNotNullParameter(viewHolder2, "");
        View view = viewHolder2.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "");
        ViewExtKt.PlaceComponentResult(view, 0, Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), 0, Integer.valueOf(this.PlaceComponentResult));
        viewHolder2.BuiltInFictitiousFunctionClassFactory.setText(this.BuiltInFictitiousFunctionClassFactory.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(viewGroup.getContext() instanceof AbstractTncMiniProgramDialogActivity ? R.layout.view_item_mini_program_scope_dialog : R.layout.view_item_mini_program_scope_activity, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        return new ViewHolder(inflate);
    }

    public MiniProgramAgreementsAdapter(List<String> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0002X\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/miniprogram/adapter/MiniProgramAgreementsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/TextView;", "Landroid/view/View;", "p0", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        final TextView BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "");
            View findViewById = view.findViewById(R.id.tvScope);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            this.BuiltInFictitiousFunctionClassFactory = (TextView) findViewById;
        }
    }
}
