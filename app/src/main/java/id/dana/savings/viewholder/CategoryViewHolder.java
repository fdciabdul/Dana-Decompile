package id.dana.savings.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.saving.constant.SavingConstant;
import id.dana.richview.CircleImageSelectionView;
import id.dana.savings.model.SavingCategoryModel;
import id.dana.utils.ImageOss;
import id.dana.utils.ResourceUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/savings/viewholder/CategoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/savings/model/SavingCategoryModel;", "Landroid/content/Context;", "p0", "", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryViewHolder extends BaseRecyclerViewHolder<SavingCategoryModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SavingCategoryModel savingCategoryModel) {
        String str;
        SavingCategoryModel savingCategoryModel2 = savingCategoryModel;
        if (savingCategoryModel2 != null) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
            if (textView != null) {
                String str2 = savingCategoryModel2.getErrorConfigVersion;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                String PlaceComponentResult = ResourceUtils.PlaceComponentResult(context, str2, str2);
                if (Intrinsics.areEqual(PlaceComponentResult, str2)) {
                    String lowerCase = str2.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    PlaceComponentResult = StringsKt.capitalize(lowerCase);
                }
                textView.setText(PlaceComponentResult);
            }
            CircleImageSelectionView circleImageSelectionView = (CircleImageSelectionView) this.itemView.findViewById(R.id.BottomSheetType);
            if (circleImageSelectionView != null) {
                if (savingCategoryModel2.getMoveToNextValue()) {
                    str = savingCategoryModel2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else {
                    str = savingCategoryModel2.KClassImpl$Data$declaredNonStaticMembers$2;
                }
                boolean moveToNextValue = savingCategoryModel2.getMoveToNextValue();
                if (circleImageSelectionView != null) {
                    if (moveToNextValue) {
                        circleImageSelectionView.setCheckTopVisibleState();
                    } else {
                        circleImageSelectionView.setCheckTopInvisibleState();
                    }
                    circleImageSelectionView.loadImage(ImageOss.KClassImpl$Data$declaredNonStaticMembers$2(circleImageSelectionView.getContext(), str, ((CircleImageSelectionView) this.itemView.findViewById(R.id.BottomSheetType)).getWidth()), R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2);
                }
            }
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.res_0x7f0a0d8c_pagingdatatransforms_insertseparators_1);
            if (linearLayout != null) {
                String string = getContext().getString(R.string.btnCategory);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Object[] objArr = new Object[1];
                String str3 = savingCategoryModel2.BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append(SavingConstant.SAVING_CATEGORY_KEY_PREFIX);
                sb.append(str3);
                String obj = sb.toString();
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                String PlaceComponentResult2 = ResourceUtils.PlaceComponentResult(context2, obj, str3);
                if (Intrinsics.areEqual(PlaceComponentResult2, str3)) {
                    String lowerCase2 = str3.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
                    PlaceComponentResult2 = StringsKt.capitalize(lowerCase2);
                }
                objArr[0] = PlaceComponentResult2;
                String format = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                linearLayout.setContentDescription(format);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_category, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
