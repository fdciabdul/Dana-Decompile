package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.yaml.snakeyaml.internal.Logger;

/* loaded from: classes6.dex */
public class PropertySubstitute extends Property {
    private static final Logger KClassImpl$Data$declaredNonStaticMembers$2 = Logger.KClassImpl$Data$declaredNonStaticMembers$2(PropertySubstitute.class.getPackage().getName());
    private Property BuiltInFictitiousFunctionClassFactory;
    protected Class<?>[] MyBillsEntityDataFactory;
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Field PlaceComponentResult;
    protected Class<?> getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private transient Method moveToNextValue;
    private transient Method scheduleImpl;

    @Override // org.yaml.snakeyaml.introspector.Property
    public final Class<?>[] BuiltInFictitiousFunctionClassFactory() {
        Property property;
        Class<?>[] clsArr = this.MyBillsEntityDataFactory;
        return (clsArr != null || (property = this.BuiltInFictitiousFunctionClassFactory) == null) ? clsArr : property.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final void PlaceComponentResult(Object obj, Object obj2) throws Exception {
        Method method = this.scheduleImpl;
        if (method != null) {
            if (!this.getErrorConfigVersion) {
                method.invoke(obj, obj2);
                return;
            } else if (obj2 != null) {
                if (obj2 instanceof Collection) {
                    Iterator it = ((Collection) obj2).iterator();
                    while (it.hasNext()) {
                        this.scheduleImpl.invoke(obj, it.next());
                    }
                    return;
                } else if (obj2 instanceof Map) {
                    for (Map.Entry entry : ((Map) obj2).entrySet()) {
                        this.scheduleImpl.invoke(obj, entry.getKey(), entry.getValue());
                    }
                    return;
                } else if (obj2.getClass().isArray()) {
                    int length = Array.getLength(obj2);
                    for (int i = 0; i < length; i++) {
                        this.scheduleImpl.invoke(obj, Array.get(obj2, i));
                    }
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Field field = this.PlaceComponentResult;
        if (field != null) {
            field.set(obj, obj2);
            return;
        }
        Property property = this.BuiltInFictitiousFunctionClassFactory;
        if (property != null) {
            property.PlaceComponentResult(obj, obj2);
            return;
        }
        Logger logger = KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("No setter/delegate for '");
        String authRequestContext = super.getAuthRequestContext();
        if (authRequestContext == null) {
            Property property2 = this.BuiltInFictitiousFunctionClassFactory;
            authRequestContext = property2 != null ? property2.getAuthRequestContext() : null;
        }
        sb.append(authRequestContext);
        sb.append("' on object ");
        sb.append(obj);
        logger.PlaceComponentResult.log(Logger.Level.WARNING.level, sb.toString());
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final String getAuthRequestContext() {
        String authRequestContext = super.getAuthRequestContext();
        if (authRequestContext != null) {
            return authRequestContext;
        }
        Property property = this.BuiltInFictitiousFunctionClassFactory;
        if (property != null) {
            return property.getAuthRequestContext();
        }
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final Class<?> KClassImpl$Data$declaredNonStaticMembers$2() {
        Class<?> KClassImpl$Data$declaredNonStaticMembers$22 = super.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            return KClassImpl$Data$declaredNonStaticMembers$22;
        }
        Property property = this.BuiltInFictitiousFunctionClassFactory;
        if (property != null) {
            return property.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final boolean PlaceComponentResult() {
        Property property;
        return (this.moveToNextValue == null && this.PlaceComponentResult == null && ((property = this.BuiltInFictitiousFunctionClassFactory) == null || !property.PlaceComponentResult())) ? false : true;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final boolean MyBillsEntityDataFactory() {
        Property property;
        return (this.scheduleImpl == null && this.PlaceComponentResult == null && ((property = this.BuiltInFictitiousFunctionClassFactory) == null || !property.MyBillsEntityDataFactory())) ? false : true;
    }

    public final void MyBillsEntityDataFactory(Property property) {
        Method method;
        this.BuiltInFictitiousFunctionClassFactory = property;
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str == null || this.scheduleImpl != null || this.getErrorConfigVersion) {
            return;
        }
        this.getErrorConfigVersion = true;
        Class<?> cls = this.getAuthRequestContext;
        Class<?>[] clsArr = this.MyBillsEntityDataFactory;
        if (clsArr == null && property != null) {
            clsArr = property.BuiltInFictitiousFunctionClassFactory();
        }
        loop0: while (true) {
            method = null;
            if (cls != null) {
                for (Method method2 : cls.getDeclaredMethods()) {
                    if (str.equals(method2.getName())) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        if (parameterTypes.length == clsArr.length) {
                            boolean z = true;
                            for (int i = 0; i < parameterTypes.length; i++) {
                                if (!parameterTypes[i].isAssignableFrom(clsArr[i])) {
                                    z = false;
                                }
                            }
                            if (z) {
                                method2.setAccessible(true);
                                method = method2;
                                break loop0;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                cls = cls.getSuperclass();
            } else {
                Logger logger = KClassImpl$Data$declaredNonStaticMembers$2;
                if (logger.PlaceComponentResult(Logger.Level.WARNING)) {
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = Integer.valueOf(clsArr.length);
                    objArr[2] = this.getAuthRequestContext.getName();
                    String authRequestContext = super.getAuthRequestContext();
                    if (authRequestContext == null) {
                        Property property2 = this.BuiltInFictitiousFunctionClassFactory;
                        authRequestContext = property2 != null ? property2.getAuthRequestContext() : null;
                    }
                    objArr[3] = authRequestContext;
                    logger.PlaceComponentResult.log(Logger.Level.WARNING.level, String.format("Failed to find [%s(%d args)] for %s.%s", objArr));
                }
            }
        }
        this.scheduleImpl = method;
    }
}
