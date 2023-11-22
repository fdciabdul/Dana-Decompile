package id.dana.showcase;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.view.animation.DecelerateInterpolator;
import id.dana.R;
import id.dana.showcase.AbstractShowcaseBuilder;
import id.dana.showcase.view.PointerView;
import id.dana.utils.SizeUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class AbstractShowcaseBuilder<T extends AbstractShowcaseBuilder> {
    public static final int getAuthRequestContext = SizeUtil.getAuthRequestContext(12);
    private static final TimeInterpolator initRecordTimeStamp = new DecelerateInterpolator(2.0f);
    protected float BuiltInFictitiousFunctionClassFactory;
    protected boolean KClassImpl$Data$declaredNonStaticMembers$2;
    protected WeakReference<Activity> MyBillsEntityDataFactory;
    protected long NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected TimeInterpolator PlaceComponentResult;
    protected int getErrorConfigVersion;
    protected int lookAheadTest;
    protected OnShowcaseStateListener moveToNextValue;
    protected int scheduleImpl;

    protected abstract T MyBillsEntityDataFactory();

    protected abstract Params getAuthRequestContext();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractShowcaseBuilder(Activity activity) {
        int i = getAuthRequestContext;
        this.lookAheadTest = i;
        this.scheduleImpl = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 300L;
        this.PlaceComponentResult = initRecordTimeStamp;
        this.getErrorConfigVersion = R.color.PlaceComponentResult_res_0x7f060058;
        this.BuiltInFictitiousFunctionClassFactory = PointerView.DEFAULT_CONTAINER_PADDING;
        this.MyBillsEntityDataFactory = new WeakReference<>(activity);
    }

    public T BuiltInFictitiousFunctionClassFactory(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        return MyBillsEntityDataFactory();
    }

    public T BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        return MyBillsEntityDataFactory();
    }

    public T getAuthRequestContext(TimeInterpolator timeInterpolator) {
        this.PlaceComponentResult = timeInterpolator;
        return MyBillsEntityDataFactory();
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.getErrorConfigVersion = i;
        return MyBillsEntityDataFactory();
    }

    public T BuiltInFictitiousFunctionClassFactory(OnShowcaseStateListener onShowcaseStateListener) {
        this.moveToNextValue = onShowcaseStateListener;
        return MyBillsEntityDataFactory();
    }

    public T MyBillsEntityDataFactory(int i) {
        this.lookAheadTest = i;
        return MyBillsEntityDataFactory();
    }

    public T getAuthRequestContext(int i) {
        this.scheduleImpl = i;
        return MyBillsEntityDataFactory();
    }
}
