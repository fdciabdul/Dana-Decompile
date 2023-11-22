package at.wirecube.additiveanimations.helper.propertywrappers;

import android.util.Property;
import android.view.View;
import at.wirecube.additiveanimations.helper.FloatProperty;

/* loaded from: classes6.dex */
public class ScrollProperties {
    public static Property<View, Float> BuiltInFictitiousFunctionClassFactory = new FloatProperty<View>("SCROLL_X") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.ScrollProperties.1
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            view.setScrollX(f.intValue());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getScrollX());
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((View) obj).setScrollX(f.intValue());
        }
    };
    public static Property<View, Float> MyBillsEntityDataFactory = new FloatProperty<View>("SCROLL_Y") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.ScrollProperties.2
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            view.setScrollY(f.intValue());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getScrollY());
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((View) obj).setScrollY(f.intValue());
        }
    };
}
