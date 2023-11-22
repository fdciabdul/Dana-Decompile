package id.dana.richview.boundcard;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class BoundCardView_ViewBinding implements Unbinder {
    private BoundCardView MyBillsEntityDataFactory;

    public BoundCardView_ViewBinding(BoundCardView boundCardView, View view) {
        this.MyBillsEntityDataFactory = boundCardView;
        boundCardView.rvStackView = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_stack_view, "field 'rvStackView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        BoundCardView boundCardView = this.MyBillsEntityDataFactory;
        if (boundCardView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        boundCardView.rvStackView = null;
    }
}
