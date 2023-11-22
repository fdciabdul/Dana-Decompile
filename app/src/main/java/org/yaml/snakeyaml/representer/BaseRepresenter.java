package org.yaml.snakeyaml.representer;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.AnchorNode;
import org.yaml.snakeyaml.nodes.Node;

/* loaded from: classes6.dex */
public abstract class BaseRepresenter {
    protected Represent KClassImpl$Data$declaredNonStaticMembers$2;
    public PropertyUtils PlaceComponentResult;
    protected final Map<Class<?>, Represent> scheduleImpl = new HashMap();
    protected final Map<Class<?>, Represent> getAuthRequestContext = new LinkedHashMap();
    protected DumperOptions.ScalarStyle BuiltInFictitiousFunctionClassFactory = null;
    protected DumperOptions.FlowStyle MyBillsEntityDataFactory = DumperOptions.FlowStyle.AUTO;
    protected final Map<Object, Node> NetworkUserEntityData$$ExternalSyntheticLambda0 = new IdentityHashMap<Object, Node>() { // from class: org.yaml.snakeyaml.representer.BaseRepresenter.1
        private static final long serialVersionUID = -5576159264232131854L;

        @Override // java.util.IdentityHashMap, java.util.AbstractMap, java.util.Map
        public Node put(Object obj, Node node) {
            return (Node) super.put((AnonymousClass1) obj, (Object) new AnchorNode(node));
        }
    };
    private boolean lookAheadTest = false;

    public final void PlaceComponentResult(DumperOptions.ScalarStyle scalarStyle) {
        this.BuiltInFictitiousFunctionClassFactory = scalarStyle;
    }

    public final DumperOptions.ScalarStyle BuiltInFictitiousFunctionClassFactory() {
        DumperOptions.ScalarStyle scalarStyle = this.BuiltInFictitiousFunctionClassFactory;
        return scalarStyle == null ? DumperOptions.ScalarStyle.PLAIN : scalarStyle;
    }

    public final void MyBillsEntityDataFactory(DumperOptions.FlowStyle flowStyle) {
        this.MyBillsEntityDataFactory = flowStyle;
    }

    public final DumperOptions.FlowStyle KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    public void BuiltInFictitiousFunctionClassFactory(PropertyUtils propertyUtils) {
        this.PlaceComponentResult = propertyUtils;
        this.lookAheadTest = true;
    }

    public final boolean getAuthRequestContext() {
        return this.lookAheadTest;
    }
}
