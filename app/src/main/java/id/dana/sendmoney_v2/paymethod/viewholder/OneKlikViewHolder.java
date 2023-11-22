package id.dana.sendmoney_v2.paymethod.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.PayMethodModel;
import id.dana.utils.ImageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/viewholder/OneKlikViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/PayMethodModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "", "getAuthRequestContext", "Z", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OneKlikViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BaseRecyclerViewHolder.OnItemClickListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        PayMethodModel payMethodModel2 = payMethodModel;
        if (payMethodModel2 != null) {
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setChecked(payMethodModel2.lookAheadTest());
            String KClassImpl$Data$declaredNonStaticMembers$2 = payMethodModel2.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            ((TextView) this.itemView.findViewById(R.id.setDrawValueAboveBar)).setText(KClassImpl$Data$declaredNonStaticMembers$2);
            this.PlaceComponentResult = payMethodModel2.getAuthRequestContext();
            boolean authRequestContext = payMethodModel2.getAuthRequestContext();
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setEnabled(authRequestContext);
            if (!authRequestContext) {
                ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.asEntryTransformer);
                Intrinsics.checkNotNullExpressionValue(imageView, "");
                ImageUtil.BuiltInFictitiousFunctionClassFactory(imageView);
                ImageUtil imageUtil2 = ImageUtil.PlaceComponentResult;
                ImageView imageView2 = (ImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter);
                Intrinsics.checkNotNullExpressionValue(imageView2, "");
                ImageUtil.BuiltInFictitiousFunctionClassFactory(imageView2);
            }
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.OneKlikViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneKlikViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(OneKlikViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneKlikViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_one_klik_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        if (this.PlaceComponentResult) {
            super.setOnItemClickListener(p0);
            this.BuiltInFictitiousFunctionClassFactory = p0;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OneKlikViewHolder oneKlikViewHolder) {
        Intrinsics.checkNotNullParameter(oneKlikViewHolder, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = oneKlikViewHolder.BuiltInFictitiousFunctionClassFactory;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(oneKlikViewHolder.getAdapterPosition());
        }
    }
}
