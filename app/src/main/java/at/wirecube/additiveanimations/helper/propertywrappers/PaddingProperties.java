package at.wirecube.additiveanimations.helper.propertywrappers;

import android.util.Property;
import android.view.View;
import at.wirecube.additiveanimations.helper.FloatProperty;

/* loaded from: classes6.dex */
public class PaddingProperties {
    public static Property<View, Float> getAuthRequestContext = new FloatProperty<View>("PADDING_LEFT") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.PaddingProperties.1
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            View view2 = view;
            view2.setPadding(f.intValue(), view2.getPaddingTop(), view2.getPaddingRight(), view2.getPaddingBottom());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getPaddingLeft());
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            View view = (View) obj;
            view.setPadding(f.intValue(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
    };
    public static Property<View, Float> MyBillsEntityDataFactory = new FloatProperty<View>("PADDING_RIGHT") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.PaddingProperties.2
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            View view2 = view;
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), f.intValue(), view2.getPaddingBottom());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getPaddingRight());
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            View view = (View) obj;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), f.intValue(), view.getPaddingBottom());
        }
    };
    public static Property<View, Float> PlaceComponentResult = new FloatProperty<View>("PADDING_TOP") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.PaddingProperties.3
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            View view2 = view;
            view2.setPadding(view2.getPaddingLeft(), f.intValue(), view2.getPaddingRight(), view2.getPaddingBottom());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getPaddingTop());
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            View view = (View) obj;
            view.setPadding(view.getPaddingLeft(), f.intValue(), view.getPaddingRight(), view.getPaddingBottom());
        }
    };
    public static Property<View, Float> KClassImpl$Data$declaredNonStaticMembers$2 = new FloatProperty<View>("PADDING_BOTTOM") { // from class: at.wirecube.additiveanimations.helper.propertywrappers.PaddingProperties.4
        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ void set(View view, Float f) {
            View view2 = view;
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), f.intValue());
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(((View) obj).getPaddingBottom());
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* synthetic */ void set(Object obj, Float f) {
            View view = (View) obj;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), f.intValue());
        }
    };
}
