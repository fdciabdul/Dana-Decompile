package id.dana.mybills.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.mybills.model.BizProductModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/viewholder/QuickBuyBillsViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/mybills/model/BizProductModel;", "Lkotlin/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuickBuyBillsViewHolder extends BaseRecyclerViewHolder<BizProductModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<BizProductModel, Unit> PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(BizProductModel bizProductModel) {
        String format;
        final BizProductModel bizProductModel2 = bizProductModel;
        if (bizProductModel2 != null) {
            View view = this.itemView;
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(view.getContext()).getAuthRequestContext(bizProductModel2.PlaceComponentResult).MyBillsEntityDataFactory((int) R.drawable.service_skeleton_circle).MyBillsEntityDataFactory((ImageView) ((CircleImageView) view.findViewById(R.id.iv_bill_icon)));
            ((TextView) view.findViewById(R.id.tv_customer_id)).setText(bizProductModel2.MyBillsEntityDataFactory);
            ((TextView) view.findViewById(R.id.tv_customer_name)).setText(bizProductModel2.moveToNextValue);
            ((TextView) view.findViewById(R.id.tv_bill_type)).setText(bizProductModel2.getErrorConfigVersion);
            TextView textView = (TextView) view.findViewById(R.id.tv_bill_subtype);
            MoneyViewModel moneyViewModel = bizProductModel2.KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
            format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
            if (format == null) {
                format = "";
            }
            sb.append(format);
            textView.setText(sb.toString());
            view.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.viewholder.QuickBuyBillsViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickBuyBillsViewHolder.MyBillsEntityDataFactory(QuickBuyBillsViewHolder.this, bizProductModel2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuickBuyBillsViewHolder(ViewGroup viewGroup, Function1<? super BizProductModel, Unit> function1) {
        super(viewGroup.getContext(), R.layout.item_bills_quick_buy, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = function1;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(QuickBuyBillsViewHolder quickBuyBillsViewHolder, BizProductModel bizProductModel) {
        Intrinsics.checkNotNullParameter(quickBuyBillsViewHolder, "");
        quickBuyBillsViewHolder.PlaceComponentResult.invoke(bizProductModel);
    }
}
