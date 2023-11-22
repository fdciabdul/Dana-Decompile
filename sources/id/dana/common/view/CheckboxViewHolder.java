package id.dana.common.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.common.model.OptionModel;
import id.dana.util.ContentDescriptorUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/common/view/CheckboxViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/common/model/OptionModel;", "Landroid/widget/CheckBox;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/CheckBox;", "getAuthRequestContext", "Lkotlin/Function2;", "", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function2;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckboxViewHolder extends BaseRecyclerViewHolder<OptionModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CheckBox getAuthRequestContext;
    private final Function2<Integer, Boolean, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(OptionModel optionModel) {
        OptionModel optionModel2 = optionModel;
        if (optionModel2 != null) {
            this.getAuthRequestContext.setText(optionModel2.PlaceComponentResult);
            this.getAuthRequestContext.setChecked(optionModel2.getKClassImpl$Data$declaredNonStaticMembers$2());
            CheckBox checkBox = this.getAuthRequestContext;
            ContentDescriptorUtil contentDescriptorUtil = ContentDescriptorUtil.INSTANCE;
            String string = getContext().getString(R.string.cd_promo_center_filter_item_prefix);
            Intrinsics.checkNotNullExpressionValue(string, "");
            checkBox.setContentDescription(ContentDescriptorUtil.KClassImpl$Data$declaredNonStaticMembers$2(string, optionModel2.PlaceComponentResult));
            this.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.common.view.CheckboxViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckboxViewHolder.BuiltInFictitiousFunctionClassFactory(CheckboxViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CheckboxViewHolder(ViewGroup viewGroup, Function2<? super Integer, ? super Boolean, Unit> function2) {
        super(viewGroup.getContext(), R.layout.item_checkbox, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function2;
        View findViewById = this.itemView.findViewById(R.id.cb_option);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.getAuthRequestContext = (CheckBox) findViewById;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CheckboxViewHolder checkboxViewHolder) {
        Intrinsics.checkNotNullParameter(checkboxViewHolder, "");
        checkboxViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke(Integer.valueOf(checkboxViewHolder.getAbsoluteAdapterPosition()), Boolean.valueOf(checkboxViewHolder.getAuthRequestContext.isChecked()));
    }
}
