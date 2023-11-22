package id.dana.riskChallenges.ui.passkey.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.riskChallenges.databinding.ItemFaqPasskeyBinding;
import id.dana.riskChallenges.ui.passkey.model.FaqPasskeyModel;
import id.dana.utils.safeonclicklistener.SafeClickListenerExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/adapter/DropdownFaqAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/riskChallenges/ui/passkey/model/FaqPasskeyModel;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "", "p2", "PlaceComponentResult", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "MyBillsEntityDataFactory", "Ljava/lang/Integer;", "getAuthRequestContext", "<init>", "()V", "FaqViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DropdownFaqAdapter extends BaseRecyclerViewDiffUtilAdapter<FaqPasskeyModel, BaseViewBindingViewHolder<FaqPasskeyModel>> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Integer getAuthRequestContext;

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final BaseViewBindingViewHolder<FaqPasskeyModel> PlaceComponentResult(LayoutInflater p0, ViewGroup p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ItemFaqPasskeyBinding PlaceComponentResult = ItemFaqPasskeyBinding.PlaceComponentResult(LayoutInflater.from(p1.getContext()), p1);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return new FaqViewHolder(this, PlaceComponentResult);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/adapter/DropdownFaqAdapter$FaqViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/riskChallenges/ui/passkey/model/FaqPasskeyModel;", "Lid/dana/riskChallenges/databinding/ItemFaqPasskeyBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/databinding/ItemFaqPasskeyBinding;", "p0", "<init>", "(Lid/dana/riskChallenges/ui/passkey/adapter/DropdownFaqAdapter;Lid/dana/riskChallenges/databinding/ItemFaqPasskeyBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class FaqViewHolder extends BaseViewBindingViewHolder<FaqPasskeyModel> {
        final /* synthetic */ DropdownFaqAdapter BuiltInFictitiousFunctionClassFactory;
        private final ItemFaqPasskeyBinding KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public FaqViewHolder(id.dana.riskChallenges.ui.passkey.adapter.DropdownFaqAdapter r3, id.dana.riskChallenges.databinding.ItemFaqPasskeyBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                r3 = r4
                androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.passkey.adapter.DropdownFaqAdapter.FaqViewHolder.<init>(id.dana.riskChallenges.ui.passkey.adapter.DropdownFaqAdapter, id.dana.riskChallenges.databinding.ItemFaqPasskeyBinding):void");
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FaqPasskeyModel faqPasskeyModel, int i) {
            final FaqPasskeyModel faqPasskeyModel2 = faqPasskeyModel;
            Intrinsics.checkNotNullParameter(faqPasskeyModel2, "");
            ItemFaqPasskeyBinding itemFaqPasskeyBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
            final DropdownFaqAdapter dropdownFaqAdapter = this.BuiltInFictitiousFunctionClassFactory;
            itemFaqPasskeyBinding.BuiltInFictitiousFunctionClassFactory.setText(faqPasskeyModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            TextView textView = itemFaqPasskeyBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            textView.setText(faqPasskeyModel2.getAuthRequestContext);
            Intrinsics.checkNotNullExpressionValue(textView, "");
            TextView textView2 = textView;
            int i2 = faqPasskeyModel2.PlaceComponentResult;
            Integer num = dropdownFaqAdapter.getAuthRequestContext;
            textView2.setVisibility(num != null && i2 == num.intValue() ? 0 : 8);
            int i3 = faqPasskeyModel2.PlaceComponentResult;
            Integer num2 = dropdownFaqAdapter.getAuthRequestContext;
            float f = 0.0f;
            if (num2 != null && i3 == num2.intValue()) {
                textView.animate().alpha(1.0f).setDuration(200L);
            } else {
                textView.animate().alpha(0.0f).setDuration(200L);
            }
            ViewPropertyAnimator animate = itemFaqPasskeyBinding.MyBillsEntityDataFactory.animate();
            int i4 = faqPasskeyModel2.PlaceComponentResult;
            Integer num3 = dropdownFaqAdapter.getAuthRequestContext;
            if (num3 != null && i4 == num3.intValue()) {
                f = 180.0f;
            }
            animate.rotation(f).setDuration(200L);
            if (i + 1 == dropdownFaqAdapter.getItemCount()) {
                DanaDividerView danaDividerView = itemFaqPasskeyBinding.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(danaDividerView, "");
                danaDividerView.setVisibility(4);
            }
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "");
            SafeClickListenerExtKt.MyBillsEntityDataFactory(view, new Function1<View, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.adapter.DropdownFaqAdapter$FaqViewHolder$bindData$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view2) {
                    Intrinsics.checkNotNullParameter(view2, "");
                    int i5 = FaqPasskeyModel.this.PlaceComponentResult;
                    Integer num4 = dropdownFaqAdapter.getAuthRequestContext;
                    if (num4 != null && i5 == num4.intValue()) {
                        dropdownFaqAdapter.getAuthRequestContext = null;
                        dropdownFaqAdapter.notifyDataSetChanged();
                        return;
                    }
                    dropdownFaqAdapter.getAuthRequestContext = Integer.valueOf(FaqPasskeyModel.this.PlaceComponentResult);
                    dropdownFaqAdapter.notifyDataSetChanged();
                }
            });
        }
    }
}
