package id.dana.bottomsheet;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.data.config.DeviceInformationProvider;

/* loaded from: classes4.dex */
public final class ServicesBottomSheetDialog_MembersInjector implements MembersInjector<ServicesBottomSheetDialog> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(ServicesBottomSheetDialog servicesBottomSheetDialog, ServicesContract.Presenter presenter) {
        servicesBottomSheetDialog.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ServicesBottomSheetDialog servicesBottomSheetDialog, DeviceInformationProvider deviceInformationProvider) {
        servicesBottomSheetDialog.deviceInformationProvider = deviceInformationProvider;
    }

    public static void PlaceComponentResult(ServicesBottomSheetDialog servicesBottomSheetDialog, ReadLinkPropertiesContract.Presenter presenter) {
        servicesBottomSheetDialog.readLinkPropertiesPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ServicesBottomSheetDialog servicesBottomSheetDialog, FeatureContract.Presenter presenter) {
        servicesBottomSheetDialog.featurePresenter = presenter;
    }
}
