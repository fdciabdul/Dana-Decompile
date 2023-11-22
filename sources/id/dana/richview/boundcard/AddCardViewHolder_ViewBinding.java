package id.dana.richview.boundcard;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class AddCardViewHolder_ViewBinding implements Unbinder {
    private AddCardViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public AddCardViewHolder_ViewBinding(AddCardViewHolder addCardViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addCardViewHolder;
        addCardViewHolder.addCardContainer = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.card_add, "field 'addCardContainer'", ConstraintLayout.class);
        addCardViewHolder.cardView = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dana_card, "field 'cardView'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        AddCardViewHolder addCardViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (addCardViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        addCardViewHolder.addCardContainer = null;
        addCardViewHolder.cardView = null;
    }
}
