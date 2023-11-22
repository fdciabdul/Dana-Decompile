package id.dana.nearbyme.merchantdetail.viewcomponent;

import dagger.MembersInjector;
import id.dana.H5Launcher;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;

/* loaded from: classes5.dex */
public final class MerchantDetailMenuView_MembersInjector implements MembersInjector<MerchantDetailMenuView> {
    public static void getAuthRequestContext(MerchantDetailMenuView merchantDetailMenuView, H5Launcher h5Launcher) {
        merchantDetailMenuView.h5Launcher = h5Launcher;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MerchantDetailMenuView merchantDetailMenuView, MerchantDetailConfigContract.Presenter presenter) {
        merchantDetailMenuView.configPresenter = presenter;
    }
}
