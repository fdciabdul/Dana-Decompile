package at.wirecube.additiveanimations.helper.propertywrappers;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import at.wirecube.additiveanimations.helper.FloatProperty;

/* loaded from: classes6.dex */
public class MarginProperties {
    public static Property<View, Float> PlaceComponentResult = new FloatProperty<View>("MARGIN_LEFT") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.MarginProperties.1
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin = f.intValue();
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).leftMargin);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).leftMargin = f.intValue();
        }
    };
    public static Property<View, Float> MyBillsEntityDataFactory = new FloatProperty<View>("MARGIN_RIGHT") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.MarginProperties.2
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin = f.intValue();
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).rightMargin);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).rightMargin = f.intValue();
        }
    };
    public static Property<View, Float> BuiltInFictitiousFunctionClassFactory = new FloatProperty<View>("MARGIN_TOP") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.MarginProperties.3
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin = f.intValue();
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).topMargin);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).topMargin = f.intValue();
        }
    };
    public static Property<View, Float> KClassImpl$Data$declaredNonStaticMembers$2 = new FloatProperty<View>("MARGIN_BOTTOM") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.MarginProperties.4
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin = f.intValue();
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).bottomMargin);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((ViewGroup.MarginLayoutParams) ((View) obj).getLayoutParams()).bottomMargin = f.intValue();
        }
    };
}
