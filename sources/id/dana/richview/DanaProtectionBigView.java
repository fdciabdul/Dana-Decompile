package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import butterknife.OnClick;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCommonRichViewComponent;

/* loaded from: classes9.dex */
public class DanaProtectionBigView extends BaseRichView {
    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_dana_protection_big;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public DanaProtectionBigView(Context context) {
        super(context);
    }

    public DanaProtectionBigView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaProtectionBigView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DanaProtectionBigView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerCommonRichViewComponent.Builder authRequestContext = DaggerCommonRichViewComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        ApplicationComponent applicationComponent2 = authRequestContext.MyBillsEntityDataFactory;
        new DaggerCommonRichViewComponent.CommonRichViewComponentImpl();
    }

    @OnClick({R.id.cl_main_parent})
    public void onMainParentClicked() {
        DanaH5.startContainerFullUrl("https://m.dana.id/m/standalone/protection");
    }
}
