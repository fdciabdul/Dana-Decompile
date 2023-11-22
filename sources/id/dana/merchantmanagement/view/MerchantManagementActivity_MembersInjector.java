package id.dana.merchantmanagement.view;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.merchantmanagement.MerchantManagementContract;

/* loaded from: classes5.dex */
public final class MerchantManagementActivity_MembersInjector implements MembersInjector<MerchantManagementActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(MerchantManagementActivity merchantManagementActivity, MerchantManagementContract.Presenter presenter) {
        merchantManagementActivity.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MerchantManagementActivity merchantManagementActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        merchantManagementActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
