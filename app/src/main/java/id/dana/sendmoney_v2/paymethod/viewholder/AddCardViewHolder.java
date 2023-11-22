package id.dana.sendmoney_v2.paymethod.viewholder;

import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemPaymethodAddCardV2Binding;
import id.dana.domain.payasset.model.Institution;
import id.dana.model.PayMethodModel;
import id.dana.utils.ImageResize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/viewholder/AddCardViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/model/PayMethodModel;", "Lid/dana/databinding/ItemPaymethodAddCardV2Binding;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddCardViewHolder extends ViewBindingRecyclerViewHolder<PayMethodModel, ItemPaymethodAddCardV2Binding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private BaseRecyclerViewHolder.OnItemClickListener MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        PayMethodModel payMethodModel = (PayMethodModel) obj;
        if (payMethodModel != null) {
            getBinding().BuiltInFictitiousFunctionClassFactory.setChecked(payMethodModel.lookAheadTest());
            getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.AddCardViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddCardViewHolder.BuiltInFictitiousFunctionClassFactory(AddCardViewHolder.this);
                }
            });
            String BuiltInFictitiousFunctionClassFactory = payMethodModel.BuiltInFictitiousFunctionClassFactory(getContext());
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(BuiltInFictitiousFunctionClassFactory);
            int MyBillsEntityDataFactory = payMethodModel.MyBillsEntityDataFactory();
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult("").MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(MyBillsEntityDataFactory).PlaceComponentResult(MyBillsEntityDataFactory).MyBillsEntityDataFactory(getBinding().MyBillsEntityDataFactory);
            char c = (payMethodModel.lookAheadTest != null || payMethodModel.moveToNextValue()) ? (char) 0 : (char) 2074;
            if (!payMethodModel.getErrorConfigVersion() && !payMethodModel.moveToNextValue()) {
                getBinding().getAuthRequestContext.setVisibility(8);
                getBinding().PlaceComponentResult.setVisibility(0);
            } else {
                getBinding().getAuthRequestContext.setVisibility(0);
                getBinding().PlaceComponentResult.setVisibility(8);
            }
            if (StringsKt.equals(Institution.BCA_ONEKLIK, payMethodModel.lookAheadTest, true)) {
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult("").MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_oneklik_v2).MyBillsEntityDataFactory(getBinding().getAuthRequestContext);
            } else if (payMethodModel.moveToNextValue()) {
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult("").MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_express_pay_v2).MyBillsEntityDataFactory(getBinding().getAuthRequestContext);
            } else if (c != 0) {
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult("").MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_card_type).MyBillsEntityDataFactory(getBinding().PlaceComponentResult);
            }
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemPaymethodAddCardV2Binding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemPaymethodAddCardV2Binding MyBillsEntityDataFactory = ItemPaymethodAddCardV2Binding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AddCardViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559204(0x7f0d0324, float:1.8743745E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.paymethod.viewholder.AddCardViewHolder.<init>(android.view.ViewGroup):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.setOnItemClickListener(p0);
        this.MyBillsEntityDataFactory = p0;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AddCardViewHolder addCardViewHolder) {
        Intrinsics.checkNotNullParameter(addCardViewHolder, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = addCardViewHolder.MyBillsEntityDataFactory;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(addCardViewHolder.getBindingAdapterPosition());
        }
    }
}
