package com.zhuinden.simplestack;

import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public class GlobalServices {
    public static final String SCOPE_TAG = "__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__";
    private final ScopeNode scope;

    /* loaded from: classes2.dex */
    public interface Factory {
        @Nonnull
        GlobalServices create(@Nonnull Backstack backstack);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScopeNode getScope() {
        return this.scope;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.scope.isEmpty();
    }

    private GlobalServices(ScopeNode scopeNode) {
        this.scope = scopeNode;
    }

    public boolean hasService(@Nonnull String str) {
        return this.scope.hasService(str);
    }

    @Nonnull
    public <T> T getService(@Nonnull String str) {
        return (T) this.scope.getService(str);
    }

    @Nonnull
    public Set<Map.Entry<String, Object>> services() {
        return this.scope.services();
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private final ScopeNode scope;

        private Builder() {
            this.scope = new ScopeNode();
        }

        @Nonnull
        public Builder addService(@Nonnull String str, @Nonnull Object obj) {
            this.scope.addService(str, obj);
            return this;
        }

        @Nonnull
        public Builder addAlias(@Nonnull String str, @Nonnull Object obj) {
            this.scope.addAlias(str, obj);
            return this;
        }

        @Nonnull
        public GlobalServices build() {
            return new GlobalServices(new ScopeNode(this.scope));
        }
    }
}
