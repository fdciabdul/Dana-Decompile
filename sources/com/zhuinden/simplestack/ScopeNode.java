package com.zhuinden.simplestack;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ScopeNode {
    private final Map<String, Object> aliases;
    private final Map<String, Object> services;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScopeNode() {
        this.services = new LinkedHashMap();
        this.aliases = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScopeNode(@Nonnull ScopeNode scopeNode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.services = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.aliases = linkedHashMap2;
        if (scopeNode == null) {
            throw new IllegalArgumentException("services cannot be null!");
        }
        linkedHashMap.putAll(scopeNode.services);
        linkedHashMap2.putAll(scopeNode.aliases);
    }

    public boolean isEmpty() {
        return this.services.isEmpty();
    }

    public void addService(@Nonnull String str, @Nonnull Object obj) {
        checkServiceTag(str);
        checkService(obj);
        this.services.put(str, obj);
    }

    public boolean hasService(@Nonnull String str) {
        checkServiceTag(str);
        if (this.services.containsKey(str)) {
            return true;
        }
        checkAlias(str);
        return this.aliases.containsKey(str);
    }

    public void addAlias(@Nonnull String str, @Nonnull Object obj) {
        checkAlias(str);
        checkService(obj);
        this.aliases.put(str, obj);
    }

    public Set<Map.Entry<String, Object>> services() {
        return Collections.unmodifiableSet(this.services.entrySet());
    }

    public <T> T getService(@Nonnull String str) {
        checkServiceTag(str);
        if (this.services.containsKey(str)) {
            return (T) this.services.get(str);
        }
        checkAlias(str);
        if (this.aliases.containsKey(str)) {
            return (T) this.aliases.get(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Scope does not contain [");
        sb.append(str);
        sb.append("]");
        throw new IllegalArgumentException(sb.toString());
    }

    private static void checkServiceTag(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("serviceTag cannot be null!");
        }
    }

    private static void checkService(@Nonnull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("service cannot be null!");
        }
    }

    private static void checkAlias(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("alias cannot be null!");
        }
    }
}
