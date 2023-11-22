package id.dana.sendmoney.ui.groupsend.groupdetail.viewholder;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemMemberGridviewBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/GridMemberViewHolder;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/BaseGroupDetailViewHolder;", "Lid/dana/sendmoney/databinding/ItemMemberGridviewBinding;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;)V", "Landroid/content/Context;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/sendmoney/databinding/ItemMemberGridviewBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridMemberViewHolder extends BaseGroupDetailViewHolder<ItemMemberGridviewBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridMemberViewHolder(Context context, ItemMemberGridviewBinding itemMemberGridviewBinding) {
        super(itemMemberGridviewBinding, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(itemMemberGridviewBinding, "");
    }

    @Override // id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.BaseGroupDetailViewHolder
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GroupDetailModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ItemMemberGridviewBinding MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        CircleImageView circleImageView = MyBillsEntityDataFactory.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        String str = p0.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(circleImageView, "");
        Intrinsics.checkNotNullParameter(str, "");
        GlideApp.getAuthRequestContext(circleImageView.getContext()).PlaceComponentResult(str).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
        TextView textView = MyBillsEntityDataFactory.MyBillsEntityDataFactory;
        String str2 = p0.PlaceComponentResult;
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        if (NumberUtil.scheduleImpl(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str2))) {
            NumberUtil numberUtil2 = NumberUtil.INSTANCE;
            str2 = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str2);
        }
        textView.setText(str2);
        AppCompatImageView appCompatImageView = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        AppCompatImageView appCompatImageView2 = appCompatImageView;
        Boolean bool = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        appCompatImageView2.setVisibility(bool != null ? bool.booleanValue() : false ? 0 : 8);
    }
}
