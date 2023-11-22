package id.dana.globalsearch.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;
import id.dana.contract.staticqr.ScanQrContract;

/* loaded from: classes5.dex */
public final class GlobalSearchBottomSheetDialog_MembersInjector implements MembersInjector<GlobalSearchBottomSheetDialog> {
    public static void BuiltInFictitiousFunctionClassFactory(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog, GlobalSearchBottomSheetContract.Presenter presenter) {
        globalSearchBottomSheetDialog.presenter = presenter;
    }

    public static void PlaceComponentResult(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog, ReadLinkPropertiesContract.Presenter presenter) {
        globalSearchBottomSheetDialog.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void PlaceComponentResult(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog, ScanQrContract.Presenter presenter) {
        globalSearchBottomSheetDialog.qrPresenter = presenter;
    }
}
