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

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/viewholder/DebitCardViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/PayMethodModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "", "MyBillsEntityDataFactory", "Z", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DebitCardViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BaseRecyclerViewHolder.OnItemClickListener PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

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
            this.BuiltInFictitiousFunctionClassFactory = payMethodModel2.getAuthRequestContext();
            boolean authRequestContext = payMethodModel2.getAuthRequestContext();
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setEnabled(authRequestContext);
            if (!authRequestContext) {
                ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter);
                Intrinsics.checkNotNullExpressionValue(imageView, "");
                ImageUtil.BuiltInFictitiousFunctionClassFactory(imageView);
            }
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.DebitCardViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DebitCardViewHolder.getAuthRequestContext(DebitCardViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebitCardViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_debit_card_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            super.setOnItemClickListener(p0);
            this.PlaceComponentResult = p0;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(DebitCardViewHolder debitCardViewHolder) {
        Intrinsics.checkNotNullParameter(debitCardViewHolder, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = debitCardViewHolder.PlaceComponentResult;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(debitCardViewHolder.getAdapterPosition());
        }
    }
}
