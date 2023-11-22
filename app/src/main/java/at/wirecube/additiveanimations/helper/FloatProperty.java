package at.wirecube.additiveanimations.helper;

import android.util.Property;

/* loaded from: classes6.dex */
public abstract class FloatProperty<T> extends Property<T, Float> {

    /* loaded from: classes6.dex */
    public interface Get<T> {
        float MyBillsEntityDataFactory();
    }

    /* loaded from: classes6.dex */
    public interface Set<T> {
    }

    @Override // android.util.Property
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public abstract void set(T t, Float f);

    /* renamed from: at.wirecube.additiveanimations.helper.FloatProperty$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends FloatProperty<T> {
        final /* synthetic */ Property MyBillsEntityDataFactory;

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* bridge */ /* synthetic */ void set(Object obj, Float f) {
            this.MyBillsEntityDataFactory.set(obj, f);
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final void set(T t, Float f) {
            this.MyBillsEntityDataFactory.set(t, f);
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ Float get(Object obj) {
            return (Float) this.MyBillsEntityDataFactory.get(obj);
        }
    }

    /* renamed from: at.wirecube.additiveanimations.helper.FloatProperty$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass2 extends FloatProperty<T> {
        final /* synthetic */ Get KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Set PlaceComponentResult;

        @Override // at.wirecube.additiveanimations.helper.FloatProperty
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final void set(T t, Float f) {
        }

        @Override // at.wirecube.additiveanimations.helper.FloatProperty, android.util.Property
        public final /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        }

        @Override // android.util.Property
        public final /* synthetic */ Float get(Object obj) {
            return Float.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
        }
    }

    public FloatProperty(String str) {
        super(Float.class, str);
    }
}
