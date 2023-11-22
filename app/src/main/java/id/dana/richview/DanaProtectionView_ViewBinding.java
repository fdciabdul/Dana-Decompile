package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class DanaProtectionView_ViewBinding implements Unbinder {
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private DanaProtectionView MyBillsEntityDataFactory;

    public DanaProtectionView_ViewBinding(final DanaProtectionView danaProtectionView, View view) {
        this.MyBillsEntityDataFactory = danaProtectionView;
        danaProtectionView.ivSecureBadge = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_secure_badge, "field 'ivSecureBadge'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_main_parent, "method 'onMainParentClicked'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.DanaProtectionView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                danaProtectionView.onMainParentClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DanaProtectionView danaProtectionView = this.MyBillsEntityDataFactory;
        if (danaProtectionView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        danaProtectionView.ivSecureBadge = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
