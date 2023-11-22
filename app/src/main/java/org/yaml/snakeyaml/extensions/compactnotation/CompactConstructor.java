package org.yaml.snakeyaml.extensions.compactnotation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.Construct;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;

/* loaded from: classes9.dex */
public class CompactConstructor extends Constructor {
    private Construct NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static final Pattern newProxyInstance = Pattern.compile("\\p{Alpha}.*\\s*\\((?:,?\\s*(?:(?:\\w*)|(?:\\p{Alpha}\\w*\\s*=.+))\\s*)+\\)");
    private static final Pattern PrepareContext = Pattern.compile("(\\p{Alpha}.*)(\\s*)\\((.*?)\\)");
    private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda8 = Pattern.compile("\\s*(\\p{Alpha}\\w*)\\s*=(.+)");

    public CompactConstructor() {
        super(new LoaderOptions());
    }

    public static CompactData PlaceComponentResult(String str) {
        if (str.endsWith(")") && str.indexOf(40) >= 0) {
            Matcher matcher = PrepareContext.matcher(str);
            if (matcher.matches()) {
                String trim = matcher.group(1).trim();
                String group = matcher.group(3);
                CompactData compactData = new CompactData(trim);
                if (group.length() == 0) {
                    return compactData;
                }
                for (String str2 : group.split("\\s*,\\s*")) {
                    if (str2.indexOf(61) < 0) {
                        compactData.PlaceComponentResult.add(str2);
                    } else {
                        Matcher matcher2 = NetworkUserEntityData$$ExternalSyntheticLambda8.matcher(str2);
                        if (!matcher2.matches()) {
                            return null;
                        }
                        compactData.getAuthRequestContext.put(matcher2.group(1), matcher2.group(2).trim());
                    }
                }
                return compactData;
            }
            return null;
        }
        return null;
    }

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    public final Construct KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        if (!(node instanceof MappingNode)) {
            if ((node instanceof ScalarNode) && newProxyInstance.matcher(((ScalarNode) node).KClassImpl$Data$declaredNonStaticMembers$2).matches()) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ConstructCompactObject();
                }
                return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            }
        } else {
            List<NodeTuple> list = ((MappingNode) node).BuiltInFictitiousFunctionClassFactory;
            if (list.size() == 1) {
                Node node2 = list.get(0).BuiltInFictitiousFunctionClassFactory;
                if ((node2 instanceof ScalarNode) && newProxyInstance.matcher(((ScalarNode) node2).KClassImpl$Data$declaredNonStaticMembers$2).matches()) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ConstructCompactObject();
                    }
                    return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                }
            }
        }
        return super.KClassImpl$Data$declaredNonStaticMembers$2(node);
    }

    /* loaded from: classes9.dex */
    public class ConstructCompactObject extends Constructor.ConstructMapping {
        public ConstructCompactObject() {
            super();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.yaml.snakeyaml.constructor.Constructor.ConstructMapping, org.yaml.snakeyaml.constructor.Construct
        public final void getAuthRequestContext(Node node, Object obj) {
            Set<Property> set;
            Node node2 = ((MappingNode) node).BuiltInFictitiousFunctionClassFactory.iterator().next().KClassImpl$Data$declaredNonStaticMembers$2;
            if (node2 instanceof MappingNode) {
                Class cls = obj.getClass();
                if (!cls.isAssignableFrom(node2.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                    node2.NetworkUserEntityData$$ExternalSyntheticLambda1 = cls;
                }
                PlaceComponentResult((MappingNode) node2, obj);
                return;
            }
            CompactConstructor compactConstructor = CompactConstructor.this;
            List authRequestContext = compactConstructor.getAuthRequestContext((SequenceNode) node2);
            try {
                if (compactConstructor.moveToNextValue == null) {
                    compactConstructor.moveToNextValue = new PropertyUtils();
                }
                PropertyUtils propertyUtils = compactConstructor.moveToNextValue;
                Class<?> cls2 = obj.getClass();
                Class<?> cls3 = obj.getClass();
                if (compactConstructor.moveToNextValue == null) {
                    compactConstructor.moveToNextValue = new PropertyUtils();
                }
                PropertyUtils propertyUtils2 = compactConstructor.moveToNextValue;
                BeanAccess beanAccess = propertyUtils2.getAuthRequestContext;
                if (propertyUtils2.MyBillsEntityDataFactory.containsKey(cls3)) {
                    set = propertyUtils2.MyBillsEntityDataFactory.get(cls3);
                } else {
                    TreeSet treeSet = new TreeSet();
                    for (Property property : propertyUtils2.KClassImpl$Data$declaredNonStaticMembers$2(cls3, beanAccess).values()) {
                        if (property.PlaceComponentResult() && (propertyUtils2.PlaceComponentResult || property.MyBillsEntityDataFactory())) {
                            treeSet.add(property);
                        }
                    }
                    propertyUtils2.MyBillsEntityDataFactory.put(cls3, treeSet);
                    set = treeSet;
                }
                Iterator<Property> it = set.iterator();
                while (it.hasNext()) {
                    if (!List.class.isAssignableFrom(it.next().KClassImpl$Data$declaredNonStaticMembers$2())) {
                        it.remove();
                    }
                }
                if (set.size() == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("No list property found in ");
                    sb.append(cls3);
                    throw new YAMLException(sb.toString());
                } else if (set.size() <= 1) {
                    propertyUtils.MyBillsEntityDataFactory(cls2, set.iterator().next().getAuthRequestContext(), propertyUtils.getAuthRequestContext).PlaceComponentResult(obj, authRequestContext);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Many list properties found in ");
                    sb2.append(cls3);
                    sb2.append("; Please override getSequencePropertyName() to specify which property to use.");
                    throw new YAMLException(sb2.toString());
                }
            } catch (Exception e) {
                throw new YAMLException(e);
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Constructor.ConstructMapping, org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            ScalarNode scalarNode;
            if (node instanceof MappingNode) {
                NodeTuple next = ((MappingNode) node).BuiltInFictitiousFunctionClassFactory.iterator().next();
                node.DatabaseTableConfigUtil = true;
                scalarNode = (ScalarNode) next.BuiltInFictitiousFunctionClassFactory;
            } else {
                scalarNode = (ScalarNode) node;
            }
            CompactData PlaceComponentResult = CompactConstructor.PlaceComponentResult(scalarNode.KClassImpl$Data$declaredNonStaticMembers$2);
            if (PlaceComponentResult != null) {
                return CompactConstructor.this.getAuthRequestContext(PlaceComponentResult);
            }
            return scalarNode.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final Object getAuthRequestContext(CompactData compactData) {
        try {
            Class<?> MyBillsEntityDataFactory = MyBillsEntityDataFactory(compactData.KClassImpl$Data$declaredNonStaticMembers$2);
            int size = compactData.PlaceComponentResult.size();
            Class<?>[] clsArr = new Class[size];
            for (int i = 0; i < size; i++) {
                clsArr[i] = String.class;
            }
            java.lang.reflect.Constructor<?> declaredConstructor = MyBillsEntityDataFactory.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(compactData.PlaceComponentResult.toArray());
            HashMap hashMap = new HashMap(compactData.getAuthRequestContext);
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                if (this.moveToNextValue == null) {
                    this.moveToNextValue = new PropertyUtils();
                }
                PropertyUtils propertyUtils = this.moveToNextValue;
                try {
                    propertyUtils.MyBillsEntityDataFactory(newInstance.getClass(), str, propertyUtils.getAuthRequestContext).PlaceComponentResult(newInstance, entry.getValue());
                } catch (IllegalArgumentException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot set property='");
                    sb.append(str);
                    sb.append("' with value='");
                    sb.append(hashMap.get(str));
                    sb.append("' (");
                    sb.append(hashMap.get(str).getClass());
                    sb.append(") in ");
                    sb.append(newInstance);
                    throw new YAMLException(sb.toString());
                }
            }
            return newInstance;
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }
}
