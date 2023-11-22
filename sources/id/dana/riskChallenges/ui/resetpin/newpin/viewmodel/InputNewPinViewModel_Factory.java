package id.dana.riskChallenges.ui.resetpin.newpin.viewmodel;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class InputNewPinViewModel_Factory implements Factory<InputNewPinViewModel> {
    public static InputNewPinViewModel_Factory getAuthRequestContext() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final InputNewPinViewModel_Factory getAuthRequestContext = new InputNewPinViewModel_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InputNewPinViewModel();
    }
}
