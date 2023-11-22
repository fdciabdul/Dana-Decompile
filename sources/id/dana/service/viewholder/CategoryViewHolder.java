package id.dana.service.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.ThirdPartyService;
import id.dana.utils.extension.LanguageExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/service/viewholder/CategoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryViewHolder extends BaseRecyclerViewHolder<ThirdPartyService> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ThirdPartyService thirdPartyService) {
        String str;
        ThirdPartyService thirdPartyService2 = thirdPartyService;
        Intrinsics.checkNotNullParameter(thirdPartyService2, "");
        if (LanguageExtKt.getAuthRequestContext()) {
            str = thirdPartyService2.NetworkUserEntityData$$ExternalSyntheticLambda3;
        } else {
            str = thirdPartyService2.FragmentBottomSheetPaymentSettingBinding;
        }
        TextView textView = (TextView) this.itemView.findViewById(R.id.tv_category);
        if (textView != null) {
            textView.setText(str != null ? str : thirdPartyService2.FragmentBottomSheetPaymentSettingBinding);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_item_category, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
