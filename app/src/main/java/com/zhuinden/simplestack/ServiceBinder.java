package com.zhuinden.simplestack;

import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public class ServiceBinder {
    private final Object key;
    private final ScopeNode scope;
    private final ScopeManager scopeManager;
    private final String scopeTag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceBinder(ScopeManager scopeManager, Object obj, String str, ScopeNode scopeNode) {
        this.scopeManager = scopeManager;
        this.key = obj;
        this.scopeTag = str;
        this.scope = scopeNode;
    }

    @Nonnull
    public <T> T getKey() {
        return (T) this.key;
    }

    @Nonnull
    public final String getScopeTag() {
        return this.scopeTag;
    }

    public void addService(@Nonnull String str, @Nonnull Object obj) {
        this.scope.addService(str, obj);
    }

    public boolean hasService(@Nonnull String str) {
        return this.scope.hasService(str);
    }

    @Nonnull
    public <T> T getService(@Nonnull String str) {
        return (T) this.scope.getService(str);
    }

    public void addAlias(@Nonnull String str, @Nonnull Object obj) {
        this.scope.addAlias(str, obj);
    }

    public boolean canFindService(@Nonnull String str) {
        return this.scopeManager.canFindService(str);
    }

    @Nonnull
    public <T> T lookupService(@Nonnull String str) {
        return (T) this.scopeManager.lookupService(str);
    }

    public boolean canFindFromScope(String str, String str2) {
        return this.scopeManager.canFindFromScope(str, str2, ScopeLookupMode.ALL);
    }

    @Nonnull
    public <T> T lookupFromScope(String str, String str2) {
        return (T) this.scopeManager.lookupFromScope(str, str2, ScopeLookupMode.ALL);
    }

    @Nonnull
    public Backstack getBackstack() {
        return this.scopeManager.getBackstack();
    }
}
