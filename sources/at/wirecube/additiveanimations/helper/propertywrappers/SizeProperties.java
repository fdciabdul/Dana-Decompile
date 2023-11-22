package at.wirecube.additiveanimations.helper.propertywrappers;

import android.util.Property;
import android.view.View;
import at.wirecube.additiveanimations.helper.FloatProperty;

/* loaded from: classes6.dex */
public class SizeProperties {
    public static Property<View, Float> getAuthRequestContext = new FloatProperty<View>("VIEW_WIDTH") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.SizeProperties.1
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            view.getLayoutParams().width = f.intValue();
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getLayoutParams().width);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((View) obj).getLayoutParams().width = f.intValue();
        }
    };
    public static Property<View, Float> MyBillsEntityDataFactory = new FloatProperty<View>("VIEW_HEIGHT") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.SizeProperties.2
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            view.getLayoutParams().height = f.intValue();
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getLayoutParams().height);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            ((View) obj).getLayoutParams().height = f.intValue();
        }
    };
}
