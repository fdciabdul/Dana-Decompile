package id.dana.merchantmanagement.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemMerchantBinding;
import id.dana.merchantmanagement.adapter.LinkedMerchantClickListener;
import id.dana.merchantmanagement.model.LinkedMerchantModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\t"}, d2 = {"Lid/dana/merchantmanagement/view/viewholder/MerchantItemViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "Lid/dana/databinding/ItemMerchantBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;", "Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantItemViewHolder extends ViewBindingRecyclerViewHolder<LinkedMerchantModel, ItemMerchantBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final LinkedMerchantClickListener MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ MerchantItemViewHolder(ViewGroup viewGroup, LinkedMerchantClickListener linkedMerchantClickListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, linkedMerchantClickListener, (i & 4) != 0 ? false : z);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        final LinkedMerchantModel linkedMerchantModel = (LinkedMerchantModel) obj;
        Intrinsics.checkNotNullParameter(linkedMerchantModel, "");
        boolean z = true;
        String string = getContext().getString(R.string.linked_since, DateTimeUtil.BuiltInFictitiousFunctionClassFactory("dd MMM yyyy", LocaleUtil.getAuthRequestContext(), linkedMerchantModel.getAuthRequestContext));
        Intrinsics.checkNotNullExpressionValue(string, "");
        ItemMerchantBinding binding = getBinding();
        if (this.BuiltInFictitiousFunctionClassFactory) {
            binding.PlaceComponentResult.setBackground(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.item_bottom_rounded));
        } else {
            binding.PlaceComponentResult.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), 17170443));
        }
        binding.getAuthRequestContext.setVisibility(this.BuiltInFictitiousFunctionClassFactory ? 8 : 0);
        binding.getErrorConfigVersion.setText(linkedMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
        binding.scheduleImpl.setText(string);
        String str = linkedMerchantModel.scheduleImpl;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            TextView textView = binding.lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            binding.lookAheadTest.setText(linkedMerchantModel.scheduleImpl);
        }
        AppCompatImageView appCompatImageView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = linkedMerchantModel.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
        DanaButtonSecondaryView danaButtonSecondaryView = binding.BuiltInFictitiousFunctionClassFactory;
        danaButtonSecondaryView.setContentDescription(danaButtonSecondaryView.getContext().getString(R.string.btnRemoveMerchant));
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.viewholder.MerchantItemViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantItemViewHolder.getAuthRequestContext(MerchantItemViewHolder.this, linkedMerchantModel);
            }
        });
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemMerchantBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemMerchantBinding authRequestContext = ItemMerchantBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantItemViewHolder(android.view.ViewGroup r3, id.dana.merchantmanagement.adapter.LinkedMerchantClickListener r4, boolean r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559164(0x7f0d02fc, float:1.8743664E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r4
            r2.BuiltInFictitiousFunctionClassFactory = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.merchantmanagement.view.viewholder.MerchantItemViewHolder.<init>(android.view.ViewGroup, id.dana.merchantmanagement.adapter.LinkedMerchantClickListener, boolean):void");
    }

    public static /* synthetic */ void getAuthRequestContext(MerchantItemViewHolder merchantItemViewHolder, LinkedMerchantModel linkedMerchantModel) {
        Intrinsics.checkNotNullParameter(merchantItemViewHolder, "");
        Intrinsics.checkNotNullParameter(linkedMerchantModel, "");
        merchantItemViewHolder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(linkedMerchantModel, merchantItemViewHolder.getBindingAdapterPosition());
    }
}
