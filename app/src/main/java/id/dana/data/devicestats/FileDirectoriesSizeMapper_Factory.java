package id.dana.data.devicestats;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FileDirectoriesSizeMapper_Factory implements Factory<FileDirectoriesSizeMapper> {
    public static FileDirectoriesSizeMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FileDirectoriesSizeMapper_Factory MyBillsEntityDataFactory = new FileDirectoriesSizeMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FileDirectoriesSizeMapper();
    }
}
