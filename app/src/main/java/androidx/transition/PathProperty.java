package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PathProperty<T> extends Property<T, Float> {
    private final float[] BuiltInFictitiousFunctionClassFactory;
    private final PointF KClassImpl$Data$declaredNonStaticMembers$2;
    private final float MyBillsEntityDataFactory;
    private final PathMeasure PlaceComponentResult;
    private float getAuthRequestContext;
    private final Property<T, PointF> lookAheadTest;

    @Override // android.util.Property
    public /* synthetic */ void set(Object obj, Float f) {
        Float f2 = f;
        this.getAuthRequestContext = f2.floatValue();
        this.PlaceComponentResult.getPosTan(this.MyBillsEntityDataFactory * f2.floatValue(), this.BuiltInFictitiousFunctionClassFactory, null);
        this.KClassImpl$Data$declaredNonStaticMembers$2.x = this.BuiltInFictitiousFunctionClassFactory[0];
        this.KClassImpl$Data$declaredNonStaticMembers$2.y = this.BuiltInFictitiousFunctionClassFactory[1];
        this.lookAheadTest.set(obj, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.BuiltInFictitiousFunctionClassFactory = new float[2];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new PointF();
        this.lookAheadTest = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.PlaceComponentResult = pathMeasure;
        this.MyBillsEntityDataFactory = pathMeasure.getLength();
    }

    @Override // android.util.Property
    public /* synthetic */ Float get(Object obj) {
        return Float.valueOf(this.getAuthRequestContext);
    }
}
