package org.yaml.snakeyaml.representer;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.introspector.PropertyUtils;

/* loaded from: classes6.dex */
public class Representer extends SafeRepresenter {
    protected Map<Class<? extends Object>, TypeDescription> getErrorConfigVersion;

    @Override // org.yaml.snakeyaml.representer.SafeRepresenter
    public final /* bridge */ /* synthetic */ TimeZone MyBillsEntityDataFactory() {
        return super.MyBillsEntityDataFactory();
    }

    @Override // org.yaml.snakeyaml.representer.SafeRepresenter
    public final /* bridge */ /* synthetic */ void PlaceComponentResult(TimeZone timeZone) {
        super.PlaceComponentResult(timeZone);
    }

    public Representer(DumperOptions dumperOptions) {
        super(dumperOptions);
        this.getErrorConfigVersion = Collections.emptyMap();
        this.scheduleImpl.put(null, new RepresentJavaBean());
    }

    @Override // org.yaml.snakeyaml.representer.BaseRepresenter
    public final void BuiltInFictitiousFunctionClassFactory(PropertyUtils propertyUtils) {
        super.BuiltInFictitiousFunctionClassFactory(propertyUtils);
        Iterator<TypeDescription> it = this.getErrorConfigVersion.values().iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2 = propertyUtils;
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentJavaBean implements Represent {
        protected RepresentJavaBean() {
        }
    }
}
