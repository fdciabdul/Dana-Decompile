package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemDisabledTransferDestinationBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final CardView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final TextView getAuthRequestContext;

    private ItemDisabledTransferDestinationBinding(CardView cardView, CircleImageView circleImageView, TextView textView, TextView textView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardView;
        this.MyBillsEntityDataFactory = circleImageView;
        this.getAuthRequestContext = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
    }

    public static ItemDisabledTransferDestinationBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_disabled_transfer_destination, viewGroup, false);
        int i = R.id.WithdrawSavedCardChannelView_res_0x7f0a0a59;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.VerifyPasswordFacade;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.tvTitleTransferDestination;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    return new ItemDisabledTransferDestinationBinding((CardView) inflate, circleImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
