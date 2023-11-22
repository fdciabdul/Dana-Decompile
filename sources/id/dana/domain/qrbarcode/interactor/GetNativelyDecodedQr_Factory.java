package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class GetNativelyDecodedQr_Factory implements Factory<GetNativelyDecodedQr> {
    @Override // javax.inject.Provider
    public final GetNativelyDecodedQr get() {
        return newInstance();
    }

    public static GetNativelyDecodedQr_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static GetNativelyDecodedQr newInstance() {
        return new GetNativelyDecodedQr();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final GetNativelyDecodedQr_Factory PlaceComponentResult = new GetNativelyDecodedQr_Factory();

        private InstanceHolder() {
        }
    }
}
