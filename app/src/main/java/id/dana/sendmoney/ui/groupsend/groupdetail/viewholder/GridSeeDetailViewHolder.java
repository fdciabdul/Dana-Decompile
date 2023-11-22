package id.dana.sendmoney.ui.groupsend.groupdetail.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemSeeDetailGridviewBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.activity.MemberListActivity;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\t"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/GridSeeDetailViewHolder;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/BaseGroupDetailViewHolder;", "Lid/dana/sendmoney/databinding/ItemSeeDetailGridviewBinding;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;)V", "", "Ljava/util/List;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/sendmoney/databinding/ItemSeeDetailGridviewBinding;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridSeeDetailViewHolder extends BaseGroupDetailViewHolder<ItemSeeDetailGridviewBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<GroupDetailModel> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridSeeDetailViewHolder(Context context, ItemSeeDetailGridviewBinding itemSeeDetailGridviewBinding, List<GroupDetailModel> list) {
        super(itemSeeDetailGridviewBinding, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(itemSeeDetailGridviewBinding, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.MyBillsEntityDataFactory = list;
    }

    @Override // id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.BaseGroupDetailViewHolder
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GroupDetailModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ItemSeeDetailGridviewBinding MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        TextView textView = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getKClassImpl$Data$declaredNonStaticMembers$2().getString(R.string.see_detail_member);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.MyBillsEntityDataFactory.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
        final ConstraintLayout constraintLayout = MyBillsEntityDataFactory.PlaceComponentResult;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.GridSeeDetailViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GridSeeDetailViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(ConstraintLayout.this, this);
            }
        });
        constraintLayout.setContentDescription(constraintLayout.getContext().getString(R.string.btn_see_details));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintLayout constraintLayout, GridSeeDetailViewHolder gridSeeDetailViewHolder) {
        Intrinsics.checkNotNullParameter(constraintLayout, "");
        Intrinsics.checkNotNullParameter(gridSeeDetailViewHolder, "");
        MemberListActivity.Companion companion = MemberListActivity.INSTANCE;
        Context context = constraintLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        MemberListActivity.Companion.getAuthRequestContext(context, gridSeeDetailViewHolder.MyBillsEntityDataFactory);
    }
}
