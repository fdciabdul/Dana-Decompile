package id.dana.richview.boundcard;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class AddCardTextViewHolder_ViewBinding implements Unbinder {
    private AddCardTextViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public AddCardTextViewHolder_ViewBinding(AddCardTextViewHolder addCardTextViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addCardTextViewHolder;
        addCardTextViewHolder.llCardAdd = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_card_add, "field 'llCardAdd'", LinearLayout.class);
        addCardTextViewHolder.tvAddCard = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_add_card, "field 'tvAddCard'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        AddCardTextViewHolder addCardTextViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (addCardTextViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        addCardTextViewHolder.llCardAdd = null;
        addCardTextViewHolder.tvAddCard = null;
    }
}
