package io.opentelemetry.sdk.trace.samplers;

import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class ParentBasedSamplerBuilder {
    @Nullable
    private Sampler localParentNotSampled;
    @Nullable
    private Sampler localParentSampled;
    @Nullable
    private Sampler remoteParentNotSampled;
    @Nullable
    private Sampler remoteParentSampled;
    private final Sampler root;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParentBasedSamplerBuilder(Sampler sampler) {
        this.root = sampler;
    }

    public final ParentBasedSamplerBuilder setRemoteParentSampled(Sampler sampler) {
        this.remoteParentSampled = sampler;
        return this;
    }

    public final ParentBasedSamplerBuilder setRemoteParentNotSampled(Sampler sampler) {
        this.remoteParentNotSampled = sampler;
        return this;
    }

    public final ParentBasedSamplerBuilder setLocalParentSampled(Sampler sampler) {
        this.localParentSampled = sampler;
        return this;
    }

    public final ParentBasedSamplerBuilder setLocalParentNotSampled(Sampler sampler) {
        this.localParentNotSampled = sampler;
        return this;
    }

    public final Sampler build() {
        return new ParentBasedSampler(this.root, this.remoteParentSampled, this.remoteParentNotSampled, this.localParentSampled, this.localParentNotSampled);
    }
}
