package id.dana.data.devicestats.entity;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FileSystemStorageEntity_Factory implements Factory<FileSystemStorageEntity> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private FileSystemStorageEntity_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static FileSystemStorageEntity_Factory getAuthRequestContext(Provider<Context> provider) {
        return new FileSystemStorageEntity_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FileSystemStorageEntity(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
