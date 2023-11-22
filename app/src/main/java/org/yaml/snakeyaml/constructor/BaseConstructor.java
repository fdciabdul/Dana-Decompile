package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes6.dex */
public abstract class BaseConstructor {
    protected static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    protected Composer BuiltInFictitiousFunctionClassFactory;
    protected final Map<Tag, Class<? extends Object>> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Set<Node> NetworkUserEntityData$$ExternalSyntheticLambda8;
    final Map<Node, Object> PlaceComponentResult;
    private final ArrayList<RecursiveTuple<Set<Object>, Object>> PrepareContext;
    protected LoaderOptions getAuthRequestContext;
    protected Tag lookAheadTest;
    public PropertyUtils moveToNextValue;
    private final ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> newProxyInstance;
    protected final Map<Class<? extends Object>, TypeDescription> scheduleImpl;
    protected final Map<NodeId, Construct> DatabaseTableConfigUtil = new EnumMap(NodeId.class);
    protected final Map<Tag, Construct> initRecordTimeStamp = new HashMap();
    protected final Map<String, Construct> GetContactSyncConfig = new HashMap();
    public boolean MyBillsEntityDataFactory = true;
    public boolean getErrorConfigVersion = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;

    public BaseConstructor(LoaderOptions loaderOptions) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        this.PlaceComponentResult = new HashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new HashSet();
        this.newProxyInstance = new ArrayList<>();
        this.PrepareContext = new ArrayList<>();
        HashMap hashMap = new HashMap();
        this.scheduleImpl = hashMap;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashMap();
        this.lookAheadTest = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        hashMap.put(SortedMap.class, new TypeDescription(SortedMap.class, Tag.lookAheadTest, TreeMap.class));
        hashMap.put(SortedSet.class, new TypeDescription(SortedSet.class, Tag.NetworkUserEntityData$$ExternalSyntheticLambda2, TreeSet.class));
        this.getAuthRequestContext = loaderOptions;
    }

    public final void getAuthRequestContext(Composer composer) {
        this.BuiltInFictitiousFunctionClassFactory = composer;
    }

    public final boolean PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    public final Object BuiltInFictitiousFunctionClassFactory() throws NoSuchElementException {
        if (!this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            throw new NoSuchElementException("No document is available.");
        }
        Node authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        Tag tag = this.lookAheadTest;
        if (tag != null) {
            if (tag == null) {
                throw new NullPointerException("tag in a Node is required.");
            }
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = tag;
        }
        return getAuthRequestContext(authRequestContext);
    }

    public final Object KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls) {
        Node MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory != null && !Tag.moveToNextValue.equals(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            if (Object.class == cls) {
                Tag tag = this.lookAheadTest;
                if (tag != null) {
                    if (tag == null) {
                        throw new NullPointerException("tag in a Node is required.");
                    }
                    MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = tag;
                }
            } else {
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Tag((Class<? extends Object>) cls);
            }
            return getAuthRequestContext(MyBillsEntityDataFactory);
        }
        return this.initRecordTimeStamp.get(Tag.moveToNextValue).getAuthRequestContext(MyBillsEntityDataFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object BuiltInFictitiousFunctionClassFactory(Node node) {
        if (this.PlaceComponentResult.containsKey(node)) {
            return this.PlaceComponentResult.get(node);
        }
        return MyBillsEntityDataFactory(node);
    }

    private Object MyBillsEntityDataFactory(Node node) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.contains(node)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", node.initRecordTimeStamp);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.add(node);
        Construct KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(node);
        Object authRequestContext = this.PlaceComponentResult.containsKey(node) ? this.PlaceComponentResult.get(node) : KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext(node);
        PlaceComponentResult(node, authRequestContext);
        this.PlaceComponentResult.put(node, authRequestContext);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.remove(node);
        if (node.MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext(node, authRequestContext);
        }
        return authRequestContext;
    }

    public Construct KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        if (node.moveToNextValue()) {
            return this.DatabaseTableConfigUtil.get(node.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        Tag tag = node.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Construct construct = this.initRecordTimeStamp.get(tag);
        if (construct == null) {
            for (String str : this.GetContactSyncConfig.keySet()) {
                if (tag.MyBillsEntityDataFactory(str)) {
                    return this.GetContactSyncConfig.get(str);
                }
            }
            return this.initRecordTimeStamp.get(null);
        }
        return construct;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Set<Object> getAuthRequestContext(int i) {
        return new LinkedHashSet(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Map<Object, Object> PlaceComponentResult(int i) {
        return new LinkedHashMap(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object MyBillsEntityDataFactory(Class<?> cls, int i) {
        return Array.newInstance(cls.getComponentType(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object PlaceComponentResult(Node node) {
        return MyBillsEntityDataFactory(Object.class, node, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<Object> BuiltInFictitiousFunctionClassFactory(CollectionNode<?> collectionNode) {
        Object MyBillsEntityDataFactory = MyBillsEntityDataFactory(Set.class, collectionNode, true);
        if (MyBillsEntityDataFactory != KClassImpl$Data$declaredNonStaticMembers$2) {
            return (Set) MyBillsEntityDataFactory;
        }
        return new LinkedHashSet(collectionNode.PlaceComponentResult().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Object> PlaceComponentResult(SequenceNode sequenceNode) {
        Object MyBillsEntityDataFactory = MyBillsEntityDataFactory(List.class, sequenceNode, true);
        if (MyBillsEntityDataFactory != KClassImpl$Data$declaredNonStaticMembers$2) {
            return (List) MyBillsEntityDataFactory;
        }
        return new ArrayList(sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<Object, Object> BuiltInFictitiousFunctionClassFactory(MappingNode mappingNode) {
        Object MyBillsEntityDataFactory = MyBillsEntityDataFactory(Map.class, mappingNode, true);
        if (MyBillsEntityDataFactory != KClassImpl$Data$declaredNonStaticMembers$2) {
            return (Map) MyBillsEntityDataFactory;
        }
        return new LinkedHashMap(mappingNode.BuiltInFictitiousFunctionClassFactory.size());
    }

    public final List<? extends Object> getAuthRequestContext(SequenceNode sequenceNode) {
        List<Object> PlaceComponentResult = PlaceComponentResult(sequenceNode);
        PlaceComponentResult(sequenceNode, (Collection<Object>) PlaceComponentResult);
        return PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<? extends Object> MyBillsEntityDataFactory(SequenceNode sequenceNode) {
        Set<Object> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory((CollectionNode<?>) sequenceNode);
        PlaceComponentResult(sequenceNode, (Collection<Object>) BuiltInFictitiousFunctionClassFactory);
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<Object> PlaceComponentResult(MappingNode mappingNode) {
        Set<Object> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory((CollectionNode<?>) mappingNode);
        BuiltInFictitiousFunctionClassFactory(mappingNode, BuiltInFictitiousFunctionClassFactory);
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<Object, Object> getAuthRequestContext(MappingNode mappingNode) {
        Map<Object, Object> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(mappingNode);
        PlaceComponentResult(mappingNode, BuiltInFictitiousFunctionClassFactory);
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void BuiltInFictitiousFunctionClassFactory(PropertyUtils propertyUtils) {
        this.moveToNextValue = propertyUtils;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        Iterator<TypeDescription> it = this.scheduleImpl.values().iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2 = propertyUtils;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class RecursiveTuple<T, K> {
        final T KClassImpl$Data$declaredNonStaticMembers$2;
        final K MyBillsEntityDataFactory;

        public RecursiveTuple(T t, K k) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
            this.MyBillsEntityDataFactory = k;
        }
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    public final LoaderOptions getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public final TypeDescription getAuthRequestContext(TypeDescription typeDescription) {
        if (typeDescription == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(typeDescription.MyBillsEntityDataFactory, typeDescription.scheduleImpl);
        if (this.moveToNextValue == null) {
            this.moveToNextValue = new PropertyUtils();
        }
        typeDescription.KClassImpl$Data$declaredNonStaticMembers$2 = this.moveToNextValue;
        return this.scheduleImpl.put(typeDescription.scheduleImpl, typeDescription);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SequenceNode sequenceNode) {
        Class<? extends Object> cls = sequenceNode.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return getAuthRequestContext(sequenceNode, Array.newInstance(cls.getComponentType(), sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object getAuthRequestContext(SequenceNode sequenceNode, Object obj) {
        Object MyBillsEntityDataFactory;
        Class componentType = sequenceNode.NetworkUserEntityData$$ExternalSyntheticLambda1.getComponentType();
        int i = 0;
        for (Node node : sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (node.NetworkUserEntityData$$ExternalSyntheticLambda1 == Object.class && !componentType.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                node.NetworkUserEntityData$$ExternalSyntheticLambda1 = componentType;
            }
            if (this.PlaceComponentResult.containsKey(node)) {
                MyBillsEntityDataFactory = this.PlaceComponentResult.get(node);
            } else {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(node);
            }
            if (!componentType.isPrimitive()) {
                Array.set(obj, i, MyBillsEntityDataFactory);
            } else if (MyBillsEntityDataFactory == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to construct element value for ");
                sb.append(node);
                throw new NullPointerException(sb.toString());
            } else if (Byte.TYPE.equals(componentType)) {
                Array.setByte(obj, i, ((Number) MyBillsEntityDataFactory).byteValue());
            } else if (Short.TYPE.equals(componentType)) {
                Array.setShort(obj, i, ((Number) MyBillsEntityDataFactory).shortValue());
            } else if (Integer.TYPE.equals(componentType)) {
                Array.setInt(obj, i, ((Number) MyBillsEntityDataFactory).intValue());
            } else if (Long.TYPE.equals(componentType)) {
                Array.setLong(obj, i, ((Number) MyBillsEntityDataFactory).longValue());
            } else if (Float.TYPE.equals(componentType)) {
                Array.setFloat(obj, i, ((Number) MyBillsEntityDataFactory).floatValue());
            } else if (Double.TYPE.equals(componentType)) {
                Array.setDouble(obj, i, ((Number) MyBillsEntityDataFactory).doubleValue());
            } else if (Character.TYPE.equals(componentType)) {
                Array.setChar(obj, i, ((Character) MyBillsEntityDataFactory).charValue());
            } else if (Boolean.TYPE.equals(componentType)) {
                Array.setBoolean(obj, i, ((Boolean) MyBillsEntityDataFactory).booleanValue());
            } else {
                throw new YAMLException("unexpected primitive type");
            }
            i++;
        }
        return obj;
    }

    private Object getAuthRequestContext(Node node) {
        Object MyBillsEntityDataFactory;
        try {
            try {
                if (this.PlaceComponentResult.containsKey(node)) {
                    MyBillsEntityDataFactory = this.PlaceComponentResult.get(node);
                } else {
                    MyBillsEntityDataFactory = MyBillsEntityDataFactory(node);
                }
                if (!this.newProxyInstance.isEmpty()) {
                    Iterator<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> it = this.newProxyInstance.iterator();
                    while (it.hasNext()) {
                        RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>> next = it.next();
                        RecursiveTuple<Object, Object> recursiveTuple = next.MyBillsEntityDataFactory;
                        next.KClassImpl$Data$declaredNonStaticMembers$2.put(recursiveTuple.KClassImpl$Data$declaredNonStaticMembers$2, recursiveTuple.MyBillsEntityDataFactory);
                    }
                    this.newProxyInstance.clear();
                }
                if (!this.PrepareContext.isEmpty()) {
                    Iterator<RecursiveTuple<Set<Object>, Object>> it2 = this.PrepareContext.iterator();
                    while (it2.hasNext()) {
                        RecursiveTuple<Set<Object>, Object> next2 = it2.next();
                        next2.KClassImpl$Data$declaredNonStaticMembers$2.add(next2.MyBillsEntityDataFactory);
                    }
                    this.PrepareContext.clear();
                }
                return MyBillsEntityDataFactory;
            } catch (RuntimeException e) {
                if (this.getErrorConfigVersion && !(e instanceof YAMLException)) {
                    throw new YAMLException(e);
                }
                throw e;
            }
        } finally {
            this.PlaceComponentResult.clear();
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PlaceComponentResult(MappingNode mappingNode, Map<Object, Object> map) {
        Object MyBillsEntityDataFactory;
        Object MyBillsEntityDataFactory2;
        for (NodeTuple nodeTuple : mappingNode.BuiltInFictitiousFunctionClassFactory) {
            Node node = nodeTuple.BuiltInFictitiousFunctionClassFactory;
            Node node2 = nodeTuple.KClassImpl$Data$declaredNonStaticMembers$2;
            if (this.PlaceComponentResult.containsKey(node)) {
                MyBillsEntityDataFactory = this.PlaceComponentResult.get(node);
            } else {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(node);
            }
            if (MyBillsEntityDataFactory != null) {
                try {
                    MyBillsEntityDataFactory.hashCode();
                } catch (Exception e) {
                    Mark mark = mappingNode.initRecordTimeStamp;
                    StringBuilder sb = new StringBuilder();
                    sb.append("found unacceptable key ");
                    sb.append(MyBillsEntityDataFactory);
                    throw new ConstructorException("while constructing a mapping", mark, sb.toString(), nodeTuple.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp, e);
                }
            }
            if (this.PlaceComponentResult.containsKey(node2)) {
                MyBillsEntityDataFactory2 = this.PlaceComponentResult.get(node2);
            } else {
                MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(node2);
            }
            if (node.MyBillsEntityDataFactory()) {
                if (!this.getAuthRequestContext.getAuthRequestContext()) {
                    throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                }
                this.newProxyInstance.add(0, new RecursiveTuple<>(map, new RecursiveTuple(MyBillsEntityDataFactory, MyBillsEntityDataFactory2)));
            } else {
                map.put(MyBillsEntityDataFactory, MyBillsEntityDataFactory2);
            }
        }
    }

    public static String getAuthRequestContext(ScalarNode scalarNode) {
        return scalarNode.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void PlaceComponentResult(SequenceNode sequenceNode, Collection<Object> collection) {
        Object MyBillsEntityDataFactory;
        for (Node node : sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (this.PlaceComponentResult.containsKey(node)) {
                MyBillsEntityDataFactory = this.PlaceComponentResult.get(node);
            } else {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(node);
            }
            collection.add(MyBillsEntityDataFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BuiltInFictitiousFunctionClassFactory(MappingNode mappingNode, Set<Object> set) {
        Object MyBillsEntityDataFactory;
        for (NodeTuple nodeTuple : mappingNode.BuiltInFictitiousFunctionClassFactory) {
            Node node = nodeTuple.BuiltInFictitiousFunctionClassFactory;
            if (this.PlaceComponentResult.containsKey(node)) {
                MyBillsEntityDataFactory = this.PlaceComponentResult.get(node);
            } else {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(node);
            }
            if (MyBillsEntityDataFactory != null) {
                try {
                    MyBillsEntityDataFactory.hashCode();
                } catch (Exception e) {
                    Mark mark = mappingNode.initRecordTimeStamp;
                    StringBuilder sb = new StringBuilder();
                    sb.append("found unacceptable key ");
                    sb.append(MyBillsEntityDataFactory);
                    throw new ConstructorException("while constructing a Set", mark, sb.toString(), nodeTuple.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp, e);
                }
            }
            if (!node.MyBillsEntityDataFactory()) {
                set.add(MyBillsEntityDataFactory);
            } else {
                this.PrepareContext.add(0, new RecursiveTuple<>(set, MyBillsEntityDataFactory));
            }
        }
    }

    private Object PlaceComponentResult(Node node, Object obj) {
        Class<? extends Object> cls = node.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (this.scheduleImpl.containsKey(cls)) {
            this.scheduleImpl.get(cls);
            return TypeDescription.BuiltInFictitiousFunctionClassFactory(obj);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object MyBillsEntityDataFactory(Class<?> cls, Node node, boolean z) {
        Object MyBillsEntityDataFactory;
        try {
            Class<? extends Object> cls2 = node.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (!this.scheduleImpl.containsKey(cls2) || (MyBillsEntityDataFactory = this.scheduleImpl.get(cls2).MyBillsEntityDataFactory()) == null) {
                if (z && cls.isAssignableFrom(cls2) && !Modifier.isAbstract(cls2.getModifiers())) {
                    java.lang.reflect.Constructor<? extends Object> declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    return declaredConstructor.newInstance(new Object[0]);
                }
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return MyBillsEntityDataFactory;
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }
}
