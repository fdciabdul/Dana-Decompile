package id.dana.showcase.target;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import id.dana.R;
import id.dana.showcase.Content;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.shape.Shape;
import id.dana.showcase.target.AbstractTargetBuilder;
import id.dana.showcase.target.Target;
import id.dana.utils.SizeUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class AbstractTargetBuilder<T extends AbstractTargetBuilder<T, S>, S extends Target> {
    protected WeakReference<Activity> MyBillsEntityDataFactory;
    protected View getErrorConfigVersion;
    private static final TimeInterpolator initRecordTimeStamp = new DecelerateInterpolator(2.0f);
    private static final Shape NetworkUserEntityData$$ExternalSyntheticLambda1 = new CircleShape();
    private static final PointF GetContactSyncConfig = new PointF(0.0f, 0.0f);
    private static final Content scheduleImpl = new Content("", "", (int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2);
    protected long BuiltInFictitiousFunctionClassFactory = 200;
    protected TimeInterpolator PlaceComponentResult = initRecordTimeStamp;
    protected Shape moveToNextValue = NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected PointF NetworkUserEntityData$$ExternalSyntheticLambda0 = GetContactSyncConfig;
    protected Content KClassImpl$Data$declaredNonStaticMembers$2 = scheduleImpl;
    protected Target.OnTargetStateListener getAuthRequestContext = null;
    protected boolean lookAheadTest = true;

    protected abstract T PlaceComponentResult();

    public AbstractTargetBuilder(Activity activity) {
        this.MyBillsEntityDataFactory = new WeakReference<>(activity);
    }

    public final T BuiltInFictitiousFunctionClassFactory(Shape shape) {
        this.moveToNextValue = shape;
        return PlaceComponentResult();
    }

    public final T BuiltInFictitiousFunctionClassFactory(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        BuiltInFictitiousFunctionClassFactory(iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2));
        return PlaceComponentResult();
    }

    public final T getAuthRequestContext(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        BuiltInFictitiousFunctionClassFactory(iArr[0] + view.getWidth(), iArr[1] + (view.getHeight() / 2));
        return PlaceComponentResult();
    }

    public final T BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        PointF pointF = new PointF(i, i2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pointF;
        double d = pointF.y;
        double PlaceComponentResult = SizeUtil.PlaceComponentResult(this.MyBillsEntityDataFactory.get());
        Double.isNaN(PlaceComponentResult);
        this.lookAheadTest = d < PlaceComponentResult * 0.5d;
        return PlaceComponentResult();
    }

    public final T getAuthRequestContext() {
        this.lookAheadTest = true;
        return PlaceComponentResult();
    }

    public final T getAuthRequestContext(Content content) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = content;
        return PlaceComponentResult();
    }

    public final T BuiltInFictitiousFunctionClassFactory() {
        this.getErrorConfigVersion = this.MyBillsEntityDataFactory.get().getLayoutInflater().inflate(R.layout.view_gesture_animation, (ViewGroup) null);
        return PlaceComponentResult();
    }
}
