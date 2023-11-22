package id.dana.sendmoney_v2.recipient.groupsend.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemGroupsendBinding;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.utils.ImageResize;
import java.security.InvalidParameterException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney_v2/recipient/groupsend/viewholder/GroupSendViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "Lid/dana/databinding/ItemGroupsendBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendViewHolder extends ViewBindingRecyclerViewHolder<RecipientViewModel, ItemGroupsendBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        int i;
        RecipientViewModel recipientViewModel = (RecipientViewModel) obj;
        if (recipientViewModel != null) {
            getBinding().MyBillsEntityDataFactory.setText(recipientViewModel.PlaceComponentResult());
            String BuiltInFictitiousFunctionClassFactory = recipientViewModel.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = "";
            }
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_group_avatar_first).PlaceComponentResult((int) R.drawable.ic_group_avatar_first).MyBillsEntityDataFactory((ImageView) getBinding().PlaceComponentResult);
            TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory;
            int i2 = recipientViewModel.PrepareContext;
            Context context = getContext();
            if (i2 == 25) {
                i = R.string.group_send_type_contact;
            } else if (i2 != 27) {
                throw new InvalidParameterException();
            } else {
                i = R.string.group_send_type_bank;
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "");
            textView.setText(string);
            TextView textView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            Integer num = recipientViewModel.moveToNextValue;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = getContext().getString(R.string.group_send_member_count);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String format = String.format(string2, Arrays.copyOf(new Object[]{num}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView2.setText(format);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemGroupsendBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemGroupsendBinding PlaceComponentResult = ItemGroupsendBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GroupSendViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559124(0x7f0d02d4, float:1.8743583E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.groupsend.viewholder.GroupSendViewHolder.<init>(android.view.ViewGroup):void");
    }
}
