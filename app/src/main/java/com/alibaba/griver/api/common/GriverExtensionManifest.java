package com.alibaba.griver.api.common;

/* loaded from: classes3.dex */
public class GriverExtensionManifest {

    /* renamed from: a  reason: collision with root package name */
    private Class<? extends GriverExtension> f6270a;
    private GriverExtension b;

    public Class<? extends GriverExtension> getExtensionClass() {
        return this.f6270a;
    }

    public void setExtensionClass(Class<? extends GriverExtension> cls) {
        this.f6270a = cls;
    }

    public GriverExtension getExtensionImpl() {
        return this.b;
    }

    public void setExtensionImpl(GriverExtension griverExtension) {
        this.b = griverExtension;
    }

    public GriverExtensionManifest(Class<? extends GriverExtension> cls, GriverExtension griverExtension) {
        this.f6270a = cls;
        this.b = griverExtension;
    }
}
