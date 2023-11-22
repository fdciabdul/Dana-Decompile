package com.zhuinden.simplestack;

import com.zhuinden.simplestack.GlobalServices;
import com.zhuinden.simplestack.ScopeKey;
import com.zhuinden.simplestack.ScopedServices;
import com.zhuinden.statebundle.StateBundle;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ScopeManager {
    private static final GlobalServices EMPTY_GLOBAL_SERVICES = GlobalServices.builder().build();
    private static final String GLOBAL_SCOPE_TAG = "__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__";
    private Backstack backstack;
    private final ScopeRegistration globalScopeRegistration = new ScopeRegistration(null, "__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__", Collections.emptyList(), true, true, false);
    private final ScopeRegistrations scopes = new ScopeRegistrations();
    private final IdentityHashMap<ScopedServices.HandlesBack, Boolean> backDispatchedServices = new IdentityHashMap<>();
    private final LinkedHashSet<Object> trackedKeys = new LinkedHashSet<>();
    private final IdentityHashMap<Object, Set<String>> scopeEnteredServices = new IdentityHashMap<>();
    private final IdentityHashMap<Object, Set<String>> scopeActivatedServices = new IdentityHashMap<>();
    private final IdentityHashMap<Object, Integer> untrackEventInvocationTracker = new IdentityHashMap<>();
    private boolean isGlobalScopePendingActivation = true;
    private GlobalServices globalServices = EMPTY_GLOBAL_SERVICES;
    private GlobalServices.Factory globalServiceFactory = null;
    private ScopedServices scopedServices = new AssertingScopedServices();
    private final StateBundle rootBundle = new StateBundle();
    private boolean isInitialized = false;
    private boolean isFinalized = false;
    private IdentityHashMap<Object, String> dummyScopeTags = new IdentityHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ScopeRegistrations {
        private final Map<ScopeRegistration, ScopeNode> scopeRegistrations;

        private ScopeRegistrations() {
            this.scopeRegistrations = new LinkedHashMap();
        }

        public boolean containsKey(String str) {
            Iterator<ScopeRegistration> it = this.scopeRegistrations.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().scopeTag.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public Set<String> keySet() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (ScopeRegistration scopeRegistration : this.scopeRegistrations.keySet()) {
                linkedHashSet.add(scopeRegistration.scopeTag);
                linkedHashSet.addAll(scopeRegistration.explicitParentScopes);
            }
            return Collections.unmodifiableSet(linkedHashSet);
        }

        public Set<Map.Entry<String, ScopeNode>> entrySet() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Map.Entry<ScopeRegistration, ScopeNode> entry : this.scopeRegistrations.entrySet()) {
                linkedHashSet.add(new AbstractMap.SimpleEntry(entry.getKey().scopeTag, entry.getValue()));
            }
            return Collections.unmodifiableSet(linkedHashSet);
        }

        public void putKey(Object obj, String str, ScopeNode scopeNode, boolean z, boolean z2, boolean z3) {
            List<String> emptyList;
            if (obj instanceof ScopeKey.Child) {
                emptyList = ((ScopeKey.Child) obj).getParentScopes();
            } else {
                emptyList = Collections.emptyList();
            }
            put(new ScopeRegistration(obj, str, emptyList, z, z2, z3), scopeNode);
        }

        @Nullable
        public ScopeNode get(String str) {
            for (ScopeRegistration scopeRegistration : this.scopeRegistrations.keySet()) {
                if (scopeRegistration.scopeTag.equals(str)) {
                    return this.scopeRegistrations.get(scopeRegistration);
                }
            }
            return null;
        }

        public void put(ScopeRegistration scopeRegistration, ScopeNode scopeNode) {
            this.scopeRegistrations.put(scopeRegistration, scopeNode);
        }

        @Nullable
        public ScopeNode remove(String str) {
            Iterator<Map.Entry<ScopeRegistration, ScopeNode>> it = this.scopeRegistrations.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ScopeRegistration, ScopeNode> next = it.next();
                if (next.getKey().scopeTag.equals(str)) {
                    ScopeNode value = next.getValue();
                    it.remove();
                    return value;
                }
            }
            return null;
        }

        public List<String> getScopeTagsInTraversalOrder() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            ArrayList arrayList = new ArrayList(this.scopeRegistrations.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ScopeRegistration scopeRegistration = (ScopeRegistration) arrayList.get(size);
                if (!scopeRegistration.isDummyScope) {
                    linkedHashSet.add(scopeRegistration.scopeTag);
                }
                for (int size2 = scopeRegistration.explicitParentScopes.size() - 1; size2 >= 0; size2--) {
                    linkedHashSet.add(scopeRegistration.explicitParentScopes.get(size2));
                }
            }
            return Collections.unmodifiableList(new ArrayList(linkedHashSet));
        }

        public LinkedHashSet<String> findScopesForKey(@Nonnull Object obj, boolean z) {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            ArrayList arrayList = new ArrayList(this.scopeRegistrations.keySet());
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                }
                ScopeRegistration scopeRegistration = (ScopeRegistration) arrayList.get(size);
                if (scopeRegistration.key != null && scopeRegistration.key.equals(obj)) {
                    break;
                }
                size--;
            }
            if (size >= 0) {
                int i = z ? size : 0;
                while (size >= i) {
                    ScopeRegistration scopeRegistration2 = (ScopeRegistration) arrayList.get(size);
                    if (!scopeRegistration2.isGlobalScope) {
                        if (!scopeRegistration2.isDummyScope) {
                            linkedHashSet.add(scopeRegistration2.scopeTag);
                        }
                        ArrayList arrayList2 = new ArrayList(scopeRegistration2.explicitParentScopes);
                        Collections.reverse(arrayList2);
                        linkedHashSet.addAll(arrayList2);
                    }
                    size--;
                }
            }
            return linkedHashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public LinkedHashSet<String> findScopesForScopeTag(@Nonnull String str, boolean z) {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            ArrayList arrayList = new ArrayList(this.scopeRegistrations.keySet());
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    size = -1;
                    break;
                } else if (str.equals(((ScopeRegistration) arrayList.get(size)).scopeTag)) {
                    break;
                }
            }
            if (size >= 0) {
                int i = z ? size : 0;
                while (size >= i) {
                    ScopeRegistration scopeRegistration = (ScopeRegistration) arrayList.get(size);
                    int indexOf = scopeRegistration.explicitParentScopes.indexOf(str);
                    if (indexOf != -1) {
                        while (indexOf >= 0) {
                            linkedHashSet.add(scopeRegistration.explicitParentScopes.get(indexOf));
                            indexOf--;
                        }
                    } else {
                        if (!scopeRegistration.isDummyScope) {
                            linkedHashSet.add(scopeRegistration.scopeTag);
                        }
                        ArrayList arrayList2 = new ArrayList(scopeRegistration.explicitParentScopes);
                        Collections.reverse(arrayList2);
                        linkedHashSet.addAll(arrayList2);
                    }
                    size--;
                }
            }
            return linkedHashSet;
        }

        public ScopeRegistration findScopeRegistrationForScopeTag(@Nonnull String str) {
            for (ScopeRegistration scopeRegistration : this.scopeRegistrations.keySet()) {
                if (str.equals(scopeRegistration.scopeTag)) {
                    return scopeRegistration;
                }
            }
            return null;
        }

        void reorderToEnd(@Nonnull String str) {
            ScopeRegistration findScopeRegistrationForScopeTag = findScopeRegistrationForScopeTag(str);
            if (findScopeRegistrationForScopeTag != null) {
                this.scopeRegistrations.put(findScopeRegistrationForScopeTag, this.scopeRegistrations.remove(findScopeRegistrationForScopeTag));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ScopeRegistration {
        private List<String> explicitParentScopes;
        private boolean isDummyScope;
        private boolean isExplicitParent;
        private boolean isGlobalScope;
        private Object key;
        private String scopeTag;

        public ScopeRegistration(@Nullable Object obj, @Nonnull String str, @Nonnull List<String> list, boolean z, boolean z2, boolean z3) {
            if (str == null) {
                throw new NullPointerException("scopeTag must not be null!");
            }
            if (list == null) {
                throw new NullPointerException("explicitParentScopes must not be null!");
            }
            this.key = obj;
            this.scopeTag = str;
            this.explicitParentScopes = list;
            this.isExplicitParent = z;
            this.isGlobalScope = z2;
            this.isDummyScope = z3;
        }

        public int hashCode() {
            return this.scopeTag.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof ScopeRegistration) && ((ScopeRegistration) obj).scopeTag.equals(this.scopeTag);
        }

        @Nonnull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ScopeRegistration[scopeTag=[");
            sb.append(this.scopeTag);
            sb.append("], explicitParents=[");
            sb.append(Arrays.toString(this.explicitParentScopes.toArray()));
            sb.append("]]");
            return sb.toString();
        }
    }

    void activateGlobalScope() {
        notifyScopeActivation("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__", this.globalServices.getScope());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deactivateGlobalScope() {
        notifyScopeDeactivation("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__", this.globalServices.getScope());
    }

    /* loaded from: classes2.dex */
    static class AssertingScopedServices implements ScopedServices {
        AssertingScopedServices() {
        }

        @Override // com.zhuinden.simplestack.ScopedServices
        public void bindServices(@Nonnull ServiceBinder serviceBinder) {
            throw new IllegalStateException("No scoped services are defined. To create scoped services, an instance of ScopedServices must be provided to configure the services that are available in a given scope.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackstack(Backstack backstack) {
        this.backstack = backstack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Backstack getBackstack() {
        return this.backstack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScopedServices(ScopedServices scopedServices) {
        this.scopedServices = scopedServices;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGlobalServices(GlobalServices globalServices) {
        this.globalServices = globalServices;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGlobalServices(GlobalServices.Factory factory) {
        this.globalServiceFactory = factory;
    }

    private void buildGlobalScope() {
        if (this.scopes.containsKey("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__")) {
            return;
        }
        GlobalServices.Factory factory = this.globalServiceFactory;
        if (factory != null) {
            GlobalServices create = factory.create(this.backstack);
            this.globalServices = create;
            Iterator<Map.Entry<String, Object>> it = create.services().iterator();
            while (it.hasNext()) {
                if (it.next().getValue() == this.backstack) {
                    throw new IllegalArgumentException("The root backstack should not be added as a service, as it would cause a circular save-state loop. Adding it as an alias would work, but should typically not be necessary because of `serviceBinder.getBackstack()`.");
                }
            }
        }
        ScopeNode scope = this.globalServices.getScope();
        this.scopes.put(this.globalScopeRegistration, scope);
        restoreAndNotifyServices("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__", scope);
    }

    private void buildScope(Object obj, String str, boolean z, boolean z2) {
        if (str == null) {
            throw new IllegalArgumentException("Scope tag provided by scope key cannot be null!");
        }
        if (this.scopes.containsKey(str)) {
            return;
        }
        ScopeNode scopeNode = new ScopeNode();
        this.scopes.putKey(obj, str, scopeNode, z, false, z2);
        if (z2) {
            return;
        }
        this.scopedServices.bindServices(new ServiceBinder(this, obj, str, scopeNode));
        Iterator<Map.Entry<String, Object>> it = scopeNode.services().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == this.backstack) {
                throw new IllegalArgumentException("The root backstack should not be added as a service, as it would cause a circular save-state loop. Adding it as an alias would work, but should typically not be necessary because of `serviceBinder.getBackstack()`.");
            }
        }
        restoreAndNotifyServices(str, scopeNode);
    }

    private void restoreAndNotifyServices(String str, ScopeNode scopeNode) {
        StateBundle authRequestContext;
        for (Map.Entry<String, Object> entry : scopeNode.services()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (isServiceNotRegistered(value)) {
                if (this.rootBundle.KClassImpl$Data$declaredNonStaticMembers$2(str) && (value instanceof Bundleable) && (authRequestContext = this.rootBundle.getAuthRequestContext(str)) != null && authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(key)) {
                    ((Bundleable) value).fromBundle(authRequestContext.getAuthRequestContext(key));
                }
                if (value instanceof ScopedServices.Registered) {
                    ((ScopedServices.Registered) value).onServiceRegistered();
                }
            }
            if (isServiceNotTrackedInScope(this.scopeEnteredServices, value, str)) {
                trackServiceInScope(this.scopeEnteredServices, value, str);
            }
        }
    }

    public boolean dispatchBack(@Nonnull Object obj) {
        this.backDispatchedServices.clear();
        try {
            Iterator it = new ArrayList(this.scopes.findScopesForKey(obj, true)).iterator();
            while (it.hasNext()) {
                ArrayList arrayList = new ArrayList(this.scopes.get((String) it.next()).services());
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Object value = ((Map.Entry) arrayList.get(size)).getValue();
                    if (value instanceof ScopedServices.HandlesBack) {
                        ScopedServices.HandlesBack handlesBack = (ScopedServices.HandlesBack) value;
                        if (!this.backDispatchedServices.containsKey(handlesBack)) {
                            this.backDispatchedServices.put(handlesBack, Boolean.TRUE);
                            if (handlesBack.onBackEvent()) {
                                return true;
                            }
                        }
                    }
                }
            }
            this.backDispatchedServices.clear();
            return false;
        } finally {
            this.backDispatchedServices.clear();
        }
    }

    private boolean isServiceNotRegistered(Object obj) {
        return !this.scopeEnteredServices.containsKey(obj) || this.scopeEnteredServices.get(obj).isEmpty();
    }

    private boolean isServiceNotActivated(Object obj) {
        return !this.scopeActivatedServices.containsKey(obj) || this.scopeActivatedServices.get(obj).isEmpty();
    }

    private boolean isServiceNotTrackedInScope(Map<Object, Set<String>> map, Object obj, String str) {
        return (map.containsKey(obj) && map.get(obj).contains(str)) ? false : true;
    }

    private void trackServiceInScope(Map<Object, Set<String>> map, Object obj, String str) {
        Set<String> set = map.get(obj);
        if (set == null) {
            set = new LinkedHashSet<>();
            map.put(obj, set);
        }
        set.add(str);
    }

    private void untrackServiceInScope(Map<Object, Set<String>> map, Object obj, String str) {
        Set<String> set = map.get(obj);
        set.remove(str);
        if (set.isEmpty()) {
            map.remove(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFinalized() {
        return this.isFinalized;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finalizeScopes() {
        this.isFinalized = true;
        destroyScope("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__");
        this.isInitialized = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildScopes(List<Object> list) {
        String obj;
        if (this.isFinalized) {
            this.isFinalized = false;
            this.isGlobalScopePendingActivation = true;
        }
        if (!this.isInitialized) {
            buildGlobalScope();
        }
        this.isInitialized = true;
        this.trackedKeys.addAll(list);
        for (Object obj2 : list) {
            if (obj2 instanceof ScopeKey.Child) {
                ScopeKey.Child child = (ScopeKey.Child) obj2;
                checkParentScopes(child);
                Iterator<String> it = child.getParentScopes().iterator();
                while (it.hasNext()) {
                    buildScope(obj2, it.next(), true, false);
                }
            }
            if (obj2 instanceof ScopeKey) {
                buildScope(obj2, ((ScopeKey) obj2).getScopeTag(), false, false);
            } else {
                if (this.dummyScopeTags.containsKey(obj2)) {
                    obj = this.dummyScopeTags.get(obj2);
                } else {
                    obj = UUID.randomUUID().toString();
                }
                this.dummyScopeTags.put(obj2, obj);
                buildScope(obj2, obj, false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cleanupScopesBy(List<Object> list) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__");
        for (Object obj : list) {
            if (obj instanceof ScopeKey.Child) {
                ScopeKey.Child child = (ScopeKey.Child) obj;
                checkParentScopes(child);
                linkedHashSet.addAll(child.getParentScopes());
            }
            if (obj instanceof ScopeKey) {
                linkedHashSet.add(((ScopeKey) obj).getScopeTag());
            } else if (this.dummyScopeTags.containsKey(obj)) {
                linkedHashSet.add(this.dummyScopeTags.get(obj));
            }
        }
        ArrayList<String> arrayList = new ArrayList(this.scopes.keySet());
        Collections.reverse(arrayList);
        for (String str : arrayList) {
            if (!linkedHashSet.contains(str)) {
                destroyScope(str);
            }
        }
        this.trackedKeys.retainAll(list);
        this.dummyScopeTags.keySet().retainAll(list);
        for (String str2 : linkedHashSet) {
            if (arrayList.contains(str2)) {
                this.scopes.reorderToEnd(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyScope(String str) {
        if (this.scopes.containsKey(str)) {
            destroyServicesAndRemoveState(str, this.scopes.remove(str));
        }
    }

    private void destroyServicesAndRemoveState(String str, ScopeNode scopeNode) {
        Set<Map.Entry<String, Object>> services = scopeNode.services();
        ArrayList arrayList = new ArrayList(services.size());
        Iterator<Map.Entry<String, Object>> it = services.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        Collections.reverse(arrayList);
        this.untrackEventInvocationTracker.clear();
        for (Object obj : arrayList) {
            if (!isServiceNotTrackedInScope(this.scopeEnteredServices, obj, str)) {
                untrackServiceInScope(this.scopeEnteredServices, obj, str);
            }
            if (isServiceNotRegistered(obj) && (obj instanceof ScopedServices.Registered) && !this.untrackEventInvocationTracker.containsKey(obj)) {
                this.untrackEventInvocationTracker.put(obj, 1);
                ((ScopedServices.Registered) obj).onServiceUnregistered();
            }
        }
        this.untrackEventInvocationTracker.clear();
        StateBundle stateBundle = this.rootBundle;
        stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
        stateBundle.MyBillsEntityDataFactory.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivation(@Nonnull Set<String> set, @Nonnull Set<String> set2) {
        if (this.isGlobalScopePendingActivation) {
            this.isGlobalScopePendingActivation = false;
            activateGlobalScope();
        }
        for (String str : set2) {
            if (!this.scopes.containsKey(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The new scope [");
                sb.append(str);
                sb.append("] should exist, but it doesn't exist in [");
                sb.append(Arrays.toString(this.scopes.keySet().toArray()));
                sb.append("]! This shouldn't happen. If you see this error, this functionality is broken.");
                throw new AssertionError(sb.toString());
            }
            notifyScopeActivation(str, this.scopes.get(str));
        }
        for (String str2 : set) {
            if (!this.scopes.containsKey(str2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The previous scope [");
                sb2.append(str2);
                sb2.append("] should exist in [");
                sb2.append(Arrays.toString(this.scopes.keySet().toArray()));
                sb2.append("]! This shouldn't happen. If you see this error, this functionality is broken.");
                throw new AssertionError(sb2.toString());
            }
            notifyScopeDeactivation(str2, this.scopes.get(str2));
        }
    }

    private void notifyScopeActivation(String str, ScopeNode scopeNode) {
        Iterator<Map.Entry<String, Object>> it = scopeNode.services().iterator();
        while (it.hasNext()) {
            Object value = it.next().getValue();
            if (isServiceNotActivated(value) && (value instanceof ScopedServices.Activated)) {
                ((ScopedServices.Activated) value).onServiceActive();
            }
            if (isServiceNotTrackedInScope(this.scopeActivatedServices, value, str)) {
                trackServiceInScope(this.scopeActivatedServices, value, str);
            }
        }
    }

    private void notifyScopeDeactivation(String str, ScopeNode scopeNode) {
        Set<Map.Entry<String, Object>> services = scopeNode.services();
        ArrayList arrayList = new ArrayList(services.size());
        Iterator<Map.Entry<String, Object>> it = services.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        Collections.reverse(arrayList);
        this.untrackEventInvocationTracker.clear();
        for (Object obj : arrayList) {
            if (!isServiceNotTrackedInScope(this.scopeActivatedServices, obj, str)) {
                untrackServiceInScope(this.scopeActivatedServices, obj, str);
            }
            if (isServiceNotActivated(obj) && (obj instanceof ScopedServices.Activated) && !this.untrackEventInvocationTracker.containsKey(obj)) {
                this.untrackEventInvocationTracker.put(obj, 1);
                ((ScopedServices.Activated) obj).onServiceInactive();
            }
        }
        this.untrackEventInvocationTracker.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StateBundle saveStates() {
        StateBundle stateBundle = new StateBundle();
        for (Map.Entry<String, ScopeNode> entry : this.scopes.entrySet()) {
            String key = entry.getKey();
            ScopeNode value = entry.getValue();
            StateBundle stateBundle2 = new StateBundle();
            for (Map.Entry<String, Object> entry2 : value.services()) {
                String key2 = entry2.getKey();
                Object value2 = entry2.getValue();
                if (value2 instanceof Bundleable) {
                    stateBundle2.KClassImpl$Data$declaredNonStaticMembers$2.put(key2, ((Bundleable) value2).toBundle());
                    stateBundle2.MyBillsEntityDataFactory.put(key2, 26);
                }
            }
            stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.put(key, stateBundle2);
            stateBundle.MyBillsEntityDataFactory.put(key, 26);
        }
        return stateBundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRestoredStates(StateBundle stateBundle) {
        if (stateBundle != null) {
            this.rootBundle.BuiltInFictitiousFunctionClassFactory(stateBundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasService(@Nonnull String str, @Nonnull String str2) {
        checkScopeTag(str);
        checkServiceTag(str2);
        if (this.scopes.containsKey(str)) {
            return this.scopes.get(str).hasService(str2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public <T> T getService(@Nonnull String str, @Nonnull String str2) {
        checkScopeTag(str);
        checkServiceTag(str2);
        if (!this.scopes.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The specified scope with tag [");
            sb.append(str);
            sb.append("] does not exist!");
            throw new IllegalArgumentException(sb.toString());
        }
        ScopeNode scopeNode = this.scopes.get(str);
        if (!scopeNode.hasService(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The specified service with tag [");
            sb2.append(str2);
            sb2.append("] does not exist in scope [");
            sb2.append(str);
            sb2.append("]! Did you accidentally try to use the same scope tag with different services?");
            throw new IllegalArgumentException(sb2.toString());
        }
        return (T) scopeNode.getService(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasScope(@Nonnull String str) {
        checkScopeTag(str);
        return this.scopes.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public Set<String> findScopesForKey(@Nonnull Object obj, @Nonnull ScopeLookupMode scopeLookupMode) {
        checkKey(obj);
        checkScopeLookupMode(scopeLookupMode);
        return scopeLookupMode.executeFindScopesForKey(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public Set<String> findScopesForKeyAll(Object obj) {
        if (!this.isInitialized) {
            return Collections.emptySet();
        }
        LinkedHashSet<String> findScopesForKey = this.scopes.findScopesForKey(obj, false);
        if (!this.isFinalized && !this.globalServices.isEmpty()) {
            findScopesForKey.add("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__");
        }
        return Collections.unmodifiableSet(findScopesForKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public Set<String> findScopesForKeyExplicit(Object obj) {
        if (!this.isInitialized) {
            return Collections.emptySet();
        }
        LinkedHashSet<String> findScopesForKey = this.scopes.findScopesForKey(obj, true);
        if (!this.isFinalized && !this.globalServices.isEmpty()) {
            findScopesForKey.add("__SIMPLE_STACK_INTERNAL_GLOBAL_SCOPE__");
        }
        return Collections.unmodifiableSet(findScopesForKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canFindFromScope(String str, String str2, ScopeLookupMode scopeLookupMode) {
        checkServiceTag(str2);
        checkScopeTag(str);
        checkScopeLookupMode(scopeLookupMode);
        return scopeLookupMode.executeCanFindFromService(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canFindScope(Object obj, String str, ScopeLookupMode scopeLookupMode) {
        checkScopeTag(str);
        checkScopeLookupMode(scopeLookupMode);
        if (this.isInitialized) {
            return this.scopes.findScopesForKey(obj, scopeLookupMode == ScopeLookupMode.EXPLICIT).contains(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canFindFromScopeExplicit(String str, String str2) {
        if (this.isInitialized) {
            Iterator<String> it = this.scopes.findScopesForScopeTag(str, true).iterator();
            while (it.hasNext()) {
                ScopeNode scopeNode = this.scopes.get(it.next());
                if (scopeNode != null && scopeNode.hasService(str2)) {
                    return true;
                }
            }
            return !this.isFinalized && this.globalServices.hasService(str2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canFindFromScopeAll(String str, String str2) {
        if (this.isInitialized) {
            Iterator<String> it = this.scopes.findScopesForScopeTag(str, false).iterator();
            while (it.hasNext()) {
                ScopeNode scopeNode = this.scopes.get(it.next());
                if (scopeNode != null && scopeNode.hasService(str2)) {
                    return true;
                }
            }
            return !this.isFinalized && this.globalServices.hasService(str2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T lookupFromScope(String str, String str2, ScopeLookupMode scopeLookupMode) {
        checkScopeTag(str);
        checkServiceTag(str2);
        checkScopeLookupMode(scopeLookupMode);
        return (T) scopeLookupMode.executeLookupFromScope(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T lookupFromScopeExplicit(String str, String str2) {
        verifyStackIsInitialized();
        LinkedHashSet<String> findScopesForScopeTag = this.scopes.findScopesForScopeTag(str, true);
        Iterator<String> it = findScopesForScopeTag.iterator();
        while (it.hasNext()) {
            ScopeNode scopeNode = this.scopes.get(it.next());
            if (scopeNode != null && scopeNode.hasService(str2)) {
                return (T) scopeNode.getService(str2);
            }
        }
        if (!this.isFinalized && this.globalServices.hasService(str2)) {
            return (T) this.globalServices.getService(str2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The service [");
        sb.append(str2);
        sb.append("] does not exist in any scope that is accessible from [");
        sb.append(str);
        sb.append("], scopes are [");
        sb.append(Arrays.toString(findScopesForScopeTag.toArray()));
        sb.append("]!");
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T lookupFromScopeAll(String str, String str2) {
        verifyStackIsInitialized();
        LinkedHashSet<String> findScopesForScopeTag = this.scopes.findScopesForScopeTag(str, false);
        Iterator<String> it = findScopesForScopeTag.iterator();
        while (it.hasNext()) {
            ScopeNode scopeNode = this.scopes.get(it.next());
            if (scopeNode != null && scopeNode.hasService(str2)) {
                return (T) scopeNode.getService(str2);
            }
        }
        if (!this.isFinalized && this.globalServices.hasService(str2)) {
            return (T) this.globalServices.getService(str2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The service [");
        sb.append(str2);
        sb.append("] does not exist in any scope that is accessible from [");
        sb.append(str);
        sb.append("], scopes are [");
        sb.append(Arrays.toString(findScopesForScopeTag.toArray()));
        sb.append("]!");
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canFindService(@Nonnull String str) {
        checkServiceTag(str);
        Iterator<String> it = this.scopes.getScopeTagsInTraversalOrder().iterator();
        while (it.hasNext()) {
            ScopeNode scopeNode = this.scopes.get(it.next());
            if (scopeNode != null && scopeNode.hasService(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public <T> T lookupService(@Nonnull String str) {
        checkServiceTag(str);
        verifyStackIsInitialized();
        List<String> scopeTagsInTraversalOrder = this.scopes.getScopeTagsInTraversalOrder();
        Iterator<String> it = scopeTagsInTraversalOrder.iterator();
        while (it.hasNext()) {
            ScopeNode scopeNode = this.scopes.get(it.next());
            if (scopeNode != null && scopeNode.hasService(str)) {
                return (T) scopeNode.getService(str);
            }
        }
        if (!this.isFinalized && this.globalServices.hasService(str)) {
            return (T) this.globalServices.getService(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The service [");
        sb.append(str);
        sb.append("] does not exist in any scopes, which are ");
        sb.append(Arrays.toString(scopeTagsInTraversalOrder.toArray()));
        sb.append("! Is the scope tag registered via a ScopeKey? If yes, make sure the StateChanger has been set by this time, and that you've bound and are trying to lookup the service with the correct service tag. Otherwise, it is likely that the scope you intend to inherit the service from does not exist.");
        throw new IllegalStateException(sb.toString());
    }

    private void verifyStackIsInitialized() {
        if (!this.isInitialized) {
            throw new IllegalStateException("Cannot lookup from an empty stack.");
        }
    }

    private static void checkKey(@Nonnull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
    }

    private static void checkScopeTag(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Scope tag cannot be null!");
        }
    }

    private static void checkServiceTag(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Service tag cannot be null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkParentScopes(ScopeKey.Child child) {
        if (child.getParentScopes() == null) {
            throw new IllegalArgumentException("Parent scopes cannot be null!");
        }
    }

    private static void checkScopeLookupMode(ScopeLookupMode scopeLookupMode) {
        if (scopeLookupMode == null) {
            throw new IllegalArgumentException("Mode cannot be null!");
        }
    }
}
