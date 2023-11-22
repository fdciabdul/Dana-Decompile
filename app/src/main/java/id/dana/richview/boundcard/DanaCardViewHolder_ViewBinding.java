package id.dana.richview.boundcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class DanaCardViewHolder_ViewBinding implements Unbinder {
    private DanaCardViewHolder BuiltInFictitiousFunctionClassFactory;

    public DanaCardViewHolder_ViewBinding(DanaCardViewHolder danaCardViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = danaCardViewHolder;
        danaCardViewHolder.clCardDana = (DanaBalanceCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.card_dana, "field 'clCardDana'", DanaBalanceCardView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DanaCardViewHolder danaCardViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (danaCardViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        danaCardViewHolder.clCardDana = null;
    }
}
