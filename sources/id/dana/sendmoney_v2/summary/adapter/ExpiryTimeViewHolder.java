package id.dana.sendmoney_v2.summary.adapter;

import android.view.View;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemExpiryTimeBinding;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/summary/adapter/ExpiryTimeViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "Lid/dana/databinding/ItemExpiryTimeBinding;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpiryTimeViewHolder extends ViewBindingRecyclerViewHolder<ExpiryTimeConfig, ItemExpiryTimeBinding> {
    public final BaseRecyclerViewHolder.OnItemClickListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String str;
        ExpiryTimeConfig expiryTimeConfig = (ExpiryTimeConfig) obj;
        if (expiryTimeConfig != null) {
            getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.summary.adapter.ExpiryTimeViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpiryTimeViewHolder.PlaceComponentResult(ExpiryTimeViewHolder.this);
                }
            });
            getBinding().getAuthRequestContext.setChecked(expiryTimeConfig.isDefault());
            TextView textView = getBinding().PlaceComponentResult;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[2];
            objArr[0] = expiryTimeConfig.getValue();
            String unit = expiryTimeConfig.getUnit();
            String value = expiryTimeConfig.getValue();
            if (Intrinsics.areEqual(unit, SummaryActivity.HOURS)) {
                if (Integer.parseInt(value) == 1) {
                    str = this.itemView.getContext().getString(R.string.expiry_hour);
                } else {
                    str = this.itemView.getContext().getString(R.string.expiry_hours);
                }
                Intrinsics.checkNotNullExpressionValue(str, "");
            } else if (Intrinsics.areEqual(unit, SummaryActivity.DAYS)) {
                str = this.itemView.getContext().getString(R.string.expiry_days);
                Intrinsics.checkNotNullExpressionValue(str, "");
            } else {
                str = "";
            }
            objArr[1] = str;
            String format = String.format("%s %s", Arrays.copyOf(objArr, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemExpiryTimeBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemExpiryTimeBinding PlaceComponentResult = ItemExpiryTimeBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExpiryTimeViewHolder(android.view.ViewGroup r3, id.dana.base.BaseRecyclerViewHolder.OnItemClickListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559098(0x7f0d02ba, float:1.874353E38)
            r2.<init>(r1, r0, r3)
            r2.BuiltInFictitiousFunctionClassFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.summary.adapter.ExpiryTimeViewHolder.<init>(android.view.ViewGroup, id.dana.base.BaseRecyclerViewHolder$OnItemClickListener):void");
    }

    public static /* synthetic */ void PlaceComponentResult(ExpiryTimeViewHolder expiryTimeViewHolder) {
        Intrinsics.checkNotNullParameter(expiryTimeViewHolder, "");
        expiryTimeViewHolder.BuiltInFictitiousFunctionClassFactory.onItemClick(expiryTimeViewHolder.getBindingAdapterPosition());
    }
}
