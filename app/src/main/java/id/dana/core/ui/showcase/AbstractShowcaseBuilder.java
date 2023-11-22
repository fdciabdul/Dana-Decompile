package id.dana.core.ui.showcase;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.view.animation.DecelerateInterpolator;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.R;
import id.dana.core.ui.showcase.AbstractShowcaseBuilder;
import id.dana.core.ui.showcase.view.PointerView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractShowcaseBuilder<T extends AbstractShowcaseBuilder> {
    protected TimeInterpolator BuiltInFictitiousFunctionClassFactory;
    protected WeakReference<Activity> KClassImpl$Data$declaredNonStaticMembers$2;
    protected boolean MyBillsEntityDataFactory;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected float getAuthRequestContext;
    protected OnShowcaseStateListener getErrorConfigVersion;
    protected int lookAheadTest;
    protected int moveToNextValue;
    protected long scheduleImpl;
    public static final int PlaceComponentResult = SizeUtil.PlaceComponentResult(12);
    private static final int initRecordTimeStamp = R.color.PlaceComponentResult_res_0x7f060058;
    private static final TimeInterpolator GetContactSyncConfig = new DecelerateInterpolator(2.0f);

    protected abstract T PlaceComponentResult();

    protected abstract Params getAuthRequestContext();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractShowcaseBuilder(Activity activity) {
        int i = PlaceComponentResult;
        this.lookAheadTest = i;
        this.moveToNextValue = i;
        this.MyBillsEntityDataFactory = true;
        this.scheduleImpl = 300L;
        this.BuiltInFictitiousFunctionClassFactory = GetContactSyncConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = initRecordTimeStamp;
        this.getAuthRequestContext = PointerView.DEFAULT_CONTAINER_PADDING;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.MyBillsEntityDataFactory = z;
        return PlaceComponentResult();
    }

    public T getAuthRequestContext(OnShowcaseStateListener onShowcaseStateListener) {
        this.getErrorConfigVersion = onShowcaseStateListener;
        return PlaceComponentResult();
    }
}
