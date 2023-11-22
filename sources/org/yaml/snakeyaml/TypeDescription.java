package org.yaml.snakeyaml;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.internal.Logger;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertySubstitute;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes6.dex */
public class TypeDescription {
    private static final Logger getErrorConfigVersion = Logger.KClassImpl$Data$declaredNonStaticMembers$2(TypeDescription.class.getPackage().getName());
    protected BeanAccess BuiltInFictitiousFunctionClassFactory;
    public transient PropertyUtils KClassImpl$Data$declaredNonStaticMembers$2;
    public final Tag MyBillsEntityDataFactory;
    private transient boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected Set<String> PlaceComponentResult;
    protected String[] getAuthRequestContext;
    private Class<?> lookAheadTest;
    private Map<String, PropertySubstitute> moveToNextValue;
    public final Class<? extends Object> scheduleImpl;

    public static Object BuiltInFictitiousFunctionClassFactory(Object obj) {
        return obj;
    }

    public TypeDescription(Class<? extends Object> cls, Tag tag, Class<?> cls2) {
        this.moveToNextValue = Collections.emptyMap();
        this.PlaceComponentResult = Collections.emptySet();
        this.getAuthRequestContext = null;
        this.scheduleImpl = cls;
        this.MyBillsEntityDataFactory = tag;
        this.lookAheadTest = cls2;
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    public TypeDescription(Class<? extends Object> cls) {
        this(cls, new Tag(cls), null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypeDescription for ");
        sb.append(this.scheduleImpl);
        sb.append(" (tag='");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("')");
        return sb.toString();
    }

    private Property PlaceComponentResult(String str) {
        PropertyUtils propertyUtils = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (propertyUtils != null) {
            BeanAccess beanAccess = this.BuiltInFictitiousFunctionClassFactory;
            if (beanAccess != null) {
                return propertyUtils.MyBillsEntityDataFactory(this.scheduleImpl, str, beanAccess);
            }
            return propertyUtils.MyBillsEntityDataFactory(this.scheduleImpl, str, propertyUtils.getAuthRequestContext);
        }
        return null;
    }

    public final Property getAuthRequestContext(String str) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            for (PropertySubstitute propertySubstitute : this.moveToNextValue.values()) {
                try {
                    propertySubstitute.MyBillsEntityDataFactory(PlaceComponentResult(propertySubstitute.getAuthRequestContext()));
                } catch (YAMLException unused) {
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
        return this.moveToNextValue.containsKey(str) ? this.moveToNextValue.get(str) : PlaceComponentResult(str);
    }

    public final Object MyBillsEntityDataFactory() {
        Class<?> cls = this.lookAheadTest;
        if (cls != null) {
            try {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            } catch (Exception e) {
                Logger logger = getErrorConfigVersion;
                logger.PlaceComponentResult.log(Logger.Level.WARNING.level, e.getLocalizedMessage());
                this.lookAheadTest = null;
            }
        }
        return null;
    }
}
