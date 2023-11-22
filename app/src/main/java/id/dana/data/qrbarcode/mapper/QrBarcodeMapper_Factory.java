package id.dana.data.qrbarcode.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class QrBarcodeMapper_Factory implements Factory<QrBarcodeMapper> {
    @Override // javax.inject.Provider
    public final QrBarcodeMapper get() {
        return newInstance();
    }

    public static QrBarcodeMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static QrBarcodeMapper newInstance() {
        return new QrBarcodeMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final QrBarcodeMapper_Factory getAuthRequestContext = new QrBarcodeMapper_Factory();

        private InstanceHolder() {
        }
    }
}
