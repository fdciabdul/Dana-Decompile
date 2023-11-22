package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.sendmoney_v2.recipient.view.RecipientView;

/* loaded from: classes4.dex */
public final class ActivityRecipientV2Binding implements ViewBinding {
    public final RecipientView BuiltInFictitiousFunctionClassFactory;
    private final LinearLayout MyBillsEntityDataFactory;

    private ActivityRecipientV2Binding(LinearLayout linearLayout, RecipientView recipientView) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = recipientView;
    }

    public static ActivityRecipientV2Binding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_recipient_v2, (ViewGroup) null, false);
        RecipientView recipientView = (RecipientView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewRecipient);
        if (recipientView != null) {
            return new ActivityRecipientV2Binding((LinearLayout) inflate, recipientView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.viewRecipient)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
