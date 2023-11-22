package id.dana.core.ui.showcase.target;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.R;
import id.dana.core.ui.showcase.Content;
import id.dana.core.ui.showcase.shape.CircleShape;
import id.dana.core.ui.showcase.shape.Shape;
import id.dana.core.ui.showcase.target.AbstractTargetBuilder;
import id.dana.core.ui.showcase.target.Target;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public abstract class AbstractTargetBuilder<T extends AbstractTargetBuilder<T, S>, S extends Target> {
    private static final TimeInterpolator GetContactSyncConfig = new DecelerateInterpolator(2.0f);
    private static final Shape NetworkUserEntityData$$ExternalSyntheticLambda2 = new CircleShape();
    private static final PointF initRecordTimeStamp = new PointF(0.0f, 0.0f);
    private static final Content scheduleImpl = new Content("", "", R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2);
    protected WeakReference<Activity> PlaceComponentResult;
    protected View getErrorConfigVersion;
    protected long KClassImpl$Data$declaredNonStaticMembers$2 = 200;
    protected TimeInterpolator MyBillsEntityDataFactory = GetContactSyncConfig;
    protected Shape NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected PointF lookAheadTest = initRecordTimeStamp;
    protected Content BuiltInFictitiousFunctionClassFactory = scheduleImpl;
    protected Target.OnTargetStateListener getAuthRequestContext = null;
    protected boolean moveToNextValue = true;

    protected abstract T getAuthRequestContext();

    public AbstractTargetBuilder(Activity activity) {
        this.PlaceComponentResult = new WeakReference<>(activity);
    }

    public final T MyBillsEntityDataFactory(Shape shape) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = shape;
        return getAuthRequestContext();
    }

    public final T MyBillsEntityDataFactory(View view) {
        view.getLocationInWindow(new int[2]);
        PointF pointF = new PointF(r1[0] + (view.getWidth() / 2), r1[1] + (view.getHeight() / 2));
        this.lookAheadTest = pointF;
        double d = pointF.y;
        double authRequestContext = SizeUtil.getAuthRequestContext(this.PlaceComponentResult.get());
        Double.isNaN(authRequestContext);
        this.moveToNextValue = d < authRequestContext * 0.5d;
        return getAuthRequestContext();
    }

    public final T KClassImpl$Data$declaredNonStaticMembers$2(Content content) {
        this.BuiltInFictitiousFunctionClassFactory = content;
        return getAuthRequestContext();
    }

    public final T getAuthRequestContext(int i) {
        this.getErrorConfigVersion = this.PlaceComponentResult.get().getLayoutInflater().inflate(i, (ViewGroup) null);
        return getAuthRequestContext();
    }
}
