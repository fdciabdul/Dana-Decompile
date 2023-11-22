package id.dana.danah5.bottomsheet;

import dagger.MembersInjector;
import id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BottomSheetBridge_MembersInjector implements MembersInjector<BottomSheetBridge> {
    private final Provider<ServicesBottomSheetManager> servicesBottomSheetManagerProvider;

    public BottomSheetBridge_MembersInjector(Provider<ServicesBottomSheetManager> provider) {
        this.servicesBottomSheetManagerProvider = provider;
    }

    public static MembersInjector<BottomSheetBridge> create(Provider<ServicesBottomSheetManager> provider) {
        return new BottomSheetBridge_MembersInjector(provider);
    }

    public final void injectMembers(BottomSheetBridge bottomSheetBridge) {
        injectServicesBottomSheetManager(bottomSheetBridge, this.servicesBottomSheetManagerProvider.get());
    }

    public static void injectServicesBottomSheetManager(BottomSheetBridge bottomSheetBridge, ServicesBottomSheetManager servicesBottomSheetManager) {
        bottomSheetBridge.servicesBottomSheetManager = servicesBottomSheetManager;
    }
}
