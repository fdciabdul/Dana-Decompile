package at.wirecube.additiveanimations.helper.propertywrappers;

import android.graphics.drawable.ColorDrawable;
import android.util.Property;
import android.view.View;
import at.wirecube.additiveanimations.helper.FloatProperty;

/* loaded from: classes6.dex */
public class ColorProperties {
    public static Property<View, Float> getAuthRequestContext = new FloatProperty<View>("BACKGROUND_COLOR") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.ColorProperties.1
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            view.setBackgroundColor(f.intValue());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return KClassImpl$Data$declaredNonStaticMembers$2((View) obj);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((View) obj).setBackgroundColor(f.intValue());
        }

        private static Float KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            try {
                return Float.valueOf(((ColorDrawable) view.getBackground()).getColor());
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        }
    };
}
