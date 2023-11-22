package org.yaml.snakeyaml.introspector;

import java.beans.FeatureDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.PlatformFeatureDetector;

/* loaded from: classes6.dex */
public class PropertyUtils {
    private final Map<Class<?>, Map<String, Property>> BuiltInFictitiousFunctionClassFactory;
    private final PlatformFeatureDetector KClassImpl$Data$declaredNonStaticMembers$2;
    public final Map<Class<?>, Set<Property>> MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean PlaceComponentResult;
    public BeanAccess getAuthRequestContext;

    public PropertyUtils() {
        this(new PlatformFeatureDetector());
    }

    private PropertyUtils(PlatformFeatureDetector platformFeatureDetector) {
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        this.MyBillsEntityDataFactory = new HashMap();
        this.getAuthRequestContext = BeanAccess.DEFAULT;
        this.PlaceComponentResult = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = platformFeatureDetector;
        if (platformFeatureDetector.BuiltInFictitiousFunctionClassFactory()) {
            this.getAuthRequestContext = BeanAccess.FIELD;
        }
    }

    public final Map<String, Property> KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls, BeanAccess beanAccess) {
        if (this.BuiltInFictitiousFunctionClassFactory.containsKey(cls)) {
            return this.BuiltInFictitiousFunctionClassFactory.get(cls);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        if (beanAccess == BeanAccess.FIELD) {
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                for (Field field : cls2.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && !linkedHashMap.containsKey(field.getName())) {
                        linkedHashMap.put(field.getName(), new FieldProperty(field));
                    }
                }
            }
        } else {
            try {
                for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(cls).getPropertyDescriptors()) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if ((readMethod == null || !readMethod.getName().equals("getClass")) && !BuiltInFictitiousFunctionClassFactory(propertyDescriptor)) {
                        linkedHashMap.put(propertyDescriptor.getName(), new MethodProperty(propertyDescriptor));
                    }
                }
                boolean z2 = false;
                for (Class<?> cls3 = cls; cls3 != null; cls3 = cls3.getSuperclass()) {
                    for (Field field2 : cls3.getDeclaredFields()) {
                        int modifiers2 = field2.getModifiers();
                        if (!Modifier.isStatic(modifiers2) && !Modifier.isTransient(modifiers2)) {
                            if (Modifier.isPublic(modifiers2)) {
                                linkedHashMap.put(field2.getName(), new FieldProperty(field2));
                            } else {
                                z2 = true;
                            }
                        }
                    }
                }
                z = z2;
            } catch (IntrospectionException e) {
                throw new YAMLException((Throwable) e);
            }
        }
        if (linkedHashMap.isEmpty() && z) {
            StringBuilder sb = new StringBuilder();
            sb.append("No JavaBean properties found in ");
            sb.append(cls.getName());
            throw new YAMLException(sb.toString());
        }
        this.BuiltInFictitiousFunctionClassFactory.put(cls, linkedHashMap);
        return linkedHashMap;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(FeatureDescriptor featureDescriptor) {
        return Boolean.TRUE.equals(featureDescriptor.getValue("transient"));
    }

    public final Property MyBillsEntityDataFactory(Class<? extends Object> cls, String str, BeanAccess beanAccess) {
        Property property = KClassImpl$Data$declaredNonStaticMembers$2(cls, beanAccess).get(str);
        if (property == null && this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            property = new MissingProperty(str);
        }
        if (property != null) {
            return property;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find property '");
        sb.append(str);
        sb.append("' on class: ");
        sb.append(cls.getName());
        throw new YAMLException(sb.toString());
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
