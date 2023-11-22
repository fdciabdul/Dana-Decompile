package id.dana.data.ocr.repository.source.firebase;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FirebaseVisionOcrData_Factory implements Factory<FirebaseVisionOcrData> {
    @Override // javax.inject.Provider
    public final FirebaseVisionOcrData get() {
        return newInstance();
    }

    public static FirebaseVisionOcrData_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static FirebaseVisionOcrData newInstance() {
        return new FirebaseVisionOcrData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FirebaseVisionOcrData_Factory getAuthRequestContext = new FirebaseVisionOcrData_Factory();

        private InstanceHolder() {
        }
    }
}
