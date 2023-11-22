package com.otaliastudios.cameraview.filter;

/* loaded from: classes8.dex */
public final class SimpleFilter extends BaseFilter {
    private final String getErrorConfigVersion;

    private SimpleFilter(String str) {
        this.getErrorConfigVersion = str;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.getErrorConfigVersion;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    protected final BaseFilter e_() {
        return new SimpleFilter(this.getErrorConfigVersion);
    }
}
