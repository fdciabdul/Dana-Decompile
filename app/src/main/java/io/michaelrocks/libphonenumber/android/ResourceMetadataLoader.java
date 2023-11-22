package io.michaelrocks.libphonenumber.android;

import java.io.InputStream;

/* loaded from: classes9.dex */
class ResourceMetadataLoader implements MetadataLoader {
    private final Class<?> loaderClass;

    public ResourceMetadataLoader() {
        this(ResourceMetadataLoader.class);
    }

    public ResourceMetadataLoader(Class<?> cls) {
        this.loaderClass = cls;
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataLoader
    public InputStream loadMetadata(String str) {
        return this.loaderClass.getResourceAsStream(str);
    }
}
