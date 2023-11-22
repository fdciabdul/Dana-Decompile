package id.dana.core.ui.showcase.target;

import android.animation.TimeInterpolator;
import android.graphics.PointF;
import android.view.View;
import id.dana.core.ui.showcase.Content;
import id.dana.core.ui.showcase.shape.Shape;

/* loaded from: classes4.dex */
public class Target {
    public final Content BuiltInFictitiousFunctionClassFactory;
    public final TimeInterpolator KClassImpl$Data$declaredNonStaticMembers$2;
    public final long MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View PlaceComponentResult;
    public OnTargetStateListener getAuthRequestContext;
    private final boolean lookAheadTest;
    public final Shape moveToNextValue;
    public final PointF scheduleImpl;

    /* loaded from: classes4.dex */
    public interface OnTargetStateListener {
    }

    public Target(Shape shape, PointF pointF, long j, TimeInterpolator timeInterpolator, Content content, View view, boolean z) {
        this.moveToNextValue = shape;
        this.scheduleImpl = pointF;
        this.MyBillsEntityDataFactory = j;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = timeInterpolator;
        this.BuiltInFictitiousFunctionClassFactory = content;
        this.PlaceComponentResult = view;
        this.lookAheadTest = z;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.lookAheadTest;
    }

    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
