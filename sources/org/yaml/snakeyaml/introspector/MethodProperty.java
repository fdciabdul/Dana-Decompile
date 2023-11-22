package org.yaml.snakeyaml.introspector;

import java.beans.PropertyDescriptor;
import org.yaml.snakeyaml.error.YAMLException;

/* loaded from: classes6.dex */
public class MethodProperty extends GenericProperty {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final PropertyDescriptor MyBillsEntityDataFactory;
    private final boolean getAuthRequestContext;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MethodProperty(java.beans.PropertyDescriptor r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getName()
            java.lang.Class r1 = r6.getPropertyType()
            java.lang.reflect.Method r2 = r6.getReadMethod()
            r3 = 0
            if (r2 == 0) goto L14
            java.lang.reflect.Type r2 = r2.getGenericReturnType()
            goto L25
        L14:
            java.lang.reflect.Method r2 = r6.getWriteMethod()
            if (r2 == 0) goto L24
            java.lang.reflect.Type[] r2 = r2.getGenericParameterTypes()
            int r4 = r2.length
            if (r4 <= 0) goto L24
            r2 = r2[r3]
            goto L25
        L24:
            r2 = 0
        L25:
            r5.<init>(r0, r1, r2)
            r5.MyBillsEntityDataFactory = r6
            java.lang.reflect.Method r0 = r6.getReadMethod()
            r1 = 1
            if (r0 == 0) goto L33
            r0 = 1
            goto L34
        L33:
            r0 = 0
        L34:
            r5.getAuthRequestContext = r0
            java.lang.reflect.Method r6 = r6.getWriteMethod()
            if (r6 == 0) goto L3d
            r3 = 1
        L3d:
            r5.BuiltInFictitiousFunctionClassFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.introspector.MethodProperty.<init>(java.beans.PropertyDescriptor):void");
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final void PlaceComponentResult(Object obj, Object obj2) throws Exception {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            StringBuilder sb = new StringBuilder();
            sb.append("No writable property '");
            sb.append(getAuthRequestContext());
            sb.append("' on class: ");
            sb.append(obj.getClass().getName());
            throw new YAMLException(sb.toString());
        }
        this.MyBillsEntityDataFactory.getWriteMethod().invoke(obj, obj2);
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final boolean MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final boolean PlaceComponentResult() {
        return this.getAuthRequestContext;
    }
}
