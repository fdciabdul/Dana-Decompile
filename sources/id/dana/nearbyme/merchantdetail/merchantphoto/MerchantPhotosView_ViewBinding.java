package id.dana.nearbyme.merchantdetail.merchantphoto;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MerchantPhotosView_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private MerchantPhotosView KClassImpl$Data$declaredNonStaticMembers$2;

    public MerchantPhotosView_ViewBinding(final MerchantPhotosView merchantPhotosView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantPhotosView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_see_all_photos, "method 'onClick'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                merchantPhotosView.onClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
