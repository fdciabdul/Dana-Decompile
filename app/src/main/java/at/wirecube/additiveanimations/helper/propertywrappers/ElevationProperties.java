package at.wirecube.additiveanimations.helper.propertywrappers;

import android.util.Property;
import android.view.View;
import at.wirecube.additiveanimations.helper.FloatProperty;

/* loaded from: classes6.dex */
public class ElevationProperties {
    public static Property<View, Float> KClassImpl$Data$declaredNonStaticMembers$2 = new FloatProperty<View>("ELEVATION") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.ElevationProperties.1
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            view.setElevation(f.floatValue());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getElevation());
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((View) obj).setElevation(f.floatValue());
        }
    };
}
