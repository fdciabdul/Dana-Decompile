package id.dana.richview;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class DanaProtectionBigView_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private DanaProtectionBigView MyBillsEntityDataFactory;

    public DanaProtectionBigView_ViewBinding(final DanaProtectionBigView danaProtectionBigView, View view) {
        this.MyBillsEntityDataFactory = danaProtectionBigView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_main_parent, "method 'onMainParentClicked'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.DanaProtectionBigView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                danaProtectionBigView.onMainParentClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.MyBillsEntityDataFactory == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
