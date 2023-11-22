package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCommonRichViewComponent;

/* loaded from: classes5.dex */
public class DanaProtectionView extends BaseRichView {
    private String BuiltInFictitiousFunctionClassFactory;
    @BindView(R.id.iv_secure_badge)
    ImageView ivSecureBadge;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_dana_protection;
    }

    public DanaProtectionView(Context context) {
        super(context);
    }

    public DanaProtectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaProtectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DanaProtectionView(Context context, AttributeSet attributeSet, int i, int i2) {
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

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.p, 0, 0);
            try {
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getString(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        setImageDanaProtection(this.BuiltInFictitiousFunctionClassFactory);
    }

    public void setImageDanaProtection(String str) {
        if (str != null) {
            if (str.equals("small_dark")) {
                InstrumentInjector.Resources_setImageResource(this.ivSecureBadge, R.drawable.ic_dana_protection_small_dark);
            } else if (str.equals("small_light")) {
                InstrumentInjector.Resources_setImageResource(this.ivSecureBadge, R.drawable.ic_dana_protection_small_light);
            }
        }
    }

    @OnClick({R.id.cl_main_parent})
    public void onMainParentClicked() {
        DanaH5.startContainerFullUrl("https://m.dana.id/m/standalone/protection");
    }
}
