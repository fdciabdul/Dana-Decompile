package id.dana.sendmoney_v2.paymethod.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.paymethod.PaymentIconFactory;
import id.dana.utils.ImageResize;
import id.dana.utils.ImageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/viewholder/DirectDebitViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/PayMethodModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DirectDebitViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    private BaseRecyclerViewHolder.OnItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        int MyBillsEntityDataFactory;
        PayMethodModel payMethodModel2 = payMethodModel;
        if (payMethodModel2 != null) {
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setChecked(payMethodModel2.lookAheadTest());
            if (payMethodModel2.scheduleImpl()) {
                MyBillsEntityDataFactory = R.drawable.ic_dana_balance_v2;
            } else {
                MyBillsEntityDataFactory = payMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda0() ? R.drawable.ic_add_card : PaymentIconFactory.MyBillsEntityDataFactory(payMethodModel2.lookAheadTest);
            }
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult("").MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(MyBillsEntityDataFactory).PlaceComponentResult(MyBillsEntityDataFactory).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter));
            String KClassImpl$Data$declaredNonStaticMembers$2 = payMethodModel2.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            ((TextView) this.itemView.findViewById(R.id.setDrawValueAboveBar)).setText(KClassImpl$Data$declaredNonStaticMembers$2);
            this.PlaceComponentResult = payMethodModel2.getAuthRequestContext();
            boolean authRequestContext = payMethodModel2.getAuthRequestContext();
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setEnabled(authRequestContext);
            if (!authRequestContext) {
                ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter);
                Intrinsics.checkNotNullExpressionValue(imageView, "");
                ImageUtil.BuiltInFictitiousFunctionClassFactory(imageView);
                ImageUtil imageUtil2 = ImageUtil.PlaceComponentResult;
                ImageView imageView2 = (ImageView) this.itemView.findViewById(R.id.DanaDealsVoucherOrderMapper_Factory);
                Intrinsics.checkNotNullExpressionValue(imageView2, "");
                ImageUtil.BuiltInFictitiousFunctionClassFactory(imageView2);
            }
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.DirectDebitViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DirectDebitViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(DirectDebitViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectDebitViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_direct_debit_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.PlaceComponentResult) {
            super.setOnItemClickListener(p0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DirectDebitViewHolder directDebitViewHolder) {
        Intrinsics.checkNotNullParameter(directDebitViewHolder, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = directDebitViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(directDebitViewHolder.getAdapterPosition());
        }
    }
}
