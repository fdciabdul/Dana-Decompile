package com.zhuinden.simplestack;

import java.util.Set;

/* loaded from: classes2.dex */
public enum ScopeLookupMode {
    ALL { // from class: com.zhuinden.simplestack.ScopeLookupMode.1
        @Override // com.zhuinden.simplestack.ScopeLookupMode
        protected final boolean executeCanFindFromService(ScopeManager scopeManager, String str, String str2) {
            return scopeManager.canFindFromScopeAll(str, str2);
        }

        @Override // com.zhuinden.simplestack.ScopeLookupMode
        protected final <T> T executeLookupFromScope(ScopeManager scopeManager, String str, String str2) {
            return (T) scopeManager.lookupFromScopeAll(str, str2);
        }

        @Override // com.zhuinden.simplestack.ScopeLookupMode
        protected final Set<String> executeFindScopesForKey(ScopeManager scopeManager, Object obj) {
            return scopeManager.findScopesForKeyAll(obj);
        }
    },
    EXPLICIT { // from class: com.zhuinden.simplestack.ScopeLookupMode.2
        @Override // com.zhuinden.simplestack.ScopeLookupMode
        protected final boolean executeCanFindFromService(ScopeManager scopeManager, String str, String str2) {
            return scopeManager.canFindFromScopeExplicit(str, str2);
        }

        @Override // com.zhuinden.simplestack.ScopeLookupMode
        protected final <T> T executeLookupFromScope(ScopeManager scopeManager, String str, String str2) {
            return (T) scopeManager.lookupFromScopeExplicit(str, str2);
        }

        @Override // com.zhuinden.simplestack.ScopeLookupMode
        protected final Set<String> executeFindScopesForKey(ScopeManager scopeManager, Object obj) {
            return scopeManager.findScopesForKeyExplicit(obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean executeCanFindFromService(ScopeManager scopeManager, String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Set<String> executeFindScopesForKey(ScopeManager scopeManager, Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract <T> T executeLookupFromScope(ScopeManager scopeManager, String str, String str2);
}
