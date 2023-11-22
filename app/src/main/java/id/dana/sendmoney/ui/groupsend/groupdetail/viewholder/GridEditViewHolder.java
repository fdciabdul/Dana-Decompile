package id.dana.sendmoney.ui.groupsend.groupdetail.viewholder;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemEditGridviewBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/GridEditViewHolder;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/BaseGroupDetailViewHolder;", "Lid/dana/sendmoney/databinding/ItemEditGridviewBinding;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;)V", "Lkotlin/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/sendmoney/databinding/ItemEditGridviewBinding;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridEditViewHolder extends BaseGroupDetailViewHolder<ItemEditGridviewBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function0<Unit> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridEditViewHolder(Context context, ItemEditGridviewBinding itemEditGridviewBinding, Function0<Unit> function0) {
        super(itemEditGridviewBinding, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(itemEditGridviewBinding, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.MyBillsEntityDataFactory = function0;
    }

    @Override // id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.BaseGroupDetailViewHolder
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GroupDetailModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ConstraintLayout constraintLayout = MyBillsEntityDataFactory().PlaceComponentResult;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.GridEditViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GridEditViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(GridEditViewHolder.this);
            }
        });
        constraintLayout.setContentDescription(constraintLayout.getContext().getString(R.string.res_0x7f1302f7_networkuserentitydata_externalsyntheticlambda8));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GridEditViewHolder gridEditViewHolder) {
        Intrinsics.checkNotNullParameter(gridEditViewHolder, "");
        gridEditViewHolder.MyBillsEntityDataFactory.invoke();
    }
}
