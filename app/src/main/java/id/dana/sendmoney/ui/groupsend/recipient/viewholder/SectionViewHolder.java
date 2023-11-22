package id.dana.sendmoney.ui.groupsend.recipient.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemGroupRecipientSectionBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\t"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/SectionViewHolder;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/BaseRecipientViewHolder;", "Lid/dana/sendmoney/databinding/ItemGroupRecipientSectionBinding;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;)V", "", "(I)V", "<init>", "(Lid/dana/sendmoney/databinding/ItemGroupRecipientSectionBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionViewHolder extends BaseRecipientViewHolder<ItemGroupRecipientSectionBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionViewHolder(ItemGroupRecipientSectionBinding itemGroupRecipientSectionBinding) {
        super(itemGroupRecipientSectionBinding);
        Intrinsics.checkNotNullParameter(itemGroupRecipientSectionBinding, "");
    }

    private final void MyBillsEntityDataFactory(int p0) {
        TextView textView = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2;
        String string = PlaceComponentResult().MyBillsEntityDataFactory.getContext().getString(p0);
        Intrinsics.checkNotNullExpressionValue(string, "");
        textView.setText(string);
        TextView textView2 = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(0);
    }

    @Override // id.dana.sendmoney.ui.groupsend.recipient.viewholder.BaseRecipientViewHolder
    public final void MyBillsEntityDataFactory(RecipientViewModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = p0.getSupportButtonTintMode;
        boolean z = true;
        if (i == 1) {
            String str = p0.DatabaseTableConfigUtil;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                MyBillsEntityDataFactory(R.string.MyBillsEntityDataFactory_res_0x7f1300e8);
            } else {
                MyBillsEntityDataFactory(R.string.getNameOrBuilderList);
            }
        } else if (i == 7) {
            MyBillsEntityDataFactory(R.string.containsObjectForKey);
        } else if (i == 21) {
            MyBillsEntityDataFactory(R.string.getNameOrBuilderList);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2, R.style.MyBillsEntityDataFactory);
        } else {
            View view = PlaceComponentResult().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(8);
            TextView textView = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
        }
    }
}
