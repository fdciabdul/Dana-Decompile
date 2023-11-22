package id.dana.savings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.savings.model.SavingBenefitModel;
import id.dana.savings.viewholder.SavingBenefitViewHolder;
import id.dana.utils.ResourceUtils;
import id.dana.utils.SizeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/savings/adapter/SavingBenefitAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/savings/viewholder/SavingBenefitViewHolder;", "Lid/dana/savings/model/SavingBenefitModel;", "", "p0", "", "p1", "Landroid/widget/TextView;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;FLandroid/widget/TextView;)I", "BuiltInFictitiousFunctionClassFactory", "I", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingBenefitAdapter extends BaseRecyclerViewAdapter<SavingBenefitViewHolder, SavingBenefitModel> {
    private int BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        SavingBenefitViewHolder savingBenefitViewHolder = (SavingBenefitViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(savingBenefitViewHolder, "");
        savingBenefitViewHolder.PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory;
        super.onBindViewHolder((SavingBenefitAdapter) savingBenefitViewHolder, i);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final /* synthetic */ void onBindViewHolder(SavingBenefitViewHolder savingBenefitViewHolder, int i) {
        SavingBenefitViewHolder savingBenefitViewHolder2 = savingBenefitViewHolder;
        Intrinsics.checkNotNullParameter(savingBenefitViewHolder2, "");
        savingBenefitViewHolder2.PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory;
        super.onBindViewHolder((SavingBenefitAdapter) savingBenefitViewHolder2, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_benefit, viewGroup, false);
        this.BuiltInFictitiousFunctionClassFactory = 0;
        for (SavingBenefitModel savingBenefitModel : getItems()) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String PlaceComponentResult = ResourceUtils.PlaceComponentResult(context, savingBenefitModel.BuiltInFictitiousFunctionClassFactory, savingBenefitModel.BuiltInFictitiousFunctionClassFactory);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_benefit_title);
            Intrinsics.checkNotNullExpressionValue(textView, "");
            int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, 14.0f, textView);
            Context context2 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            String PlaceComponentResult2 = ResourceUtils.PlaceComponentResult(context2, savingBenefitModel.getAuthRequestContext, savingBenefitModel.getAuthRequestContext);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_benefit_desc);
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            int KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2 + KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, 12.0f, textView2);
            if (KClassImpl$Data$declaredNonStaticMembers$22 > this.BuiltInFictitiousFunctionClassFactory) {
                this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$22;
            }
        }
        Context context3 = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "");
        return new SavingBenefitViewHolder(context3, viewGroup);
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(String p0, float p1, TextView p2) {
        p2.setText(p0);
        p2.setTextSize(2, p1);
        p2.measure(View.MeasureSpec.makeMeasureSpec(SizeUtil.getAuthRequestContext(150), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return p2.getLineCount() * (p2.getPaint().getFontMetricsInt().bottom - p2.getPaint().getFontMetricsInt().top);
    }
}
