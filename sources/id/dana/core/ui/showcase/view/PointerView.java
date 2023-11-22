package id.dana.core.ui.showcase.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.R;
import id.dana.core.ui.showcase.AnimatorListener;
import id.dana.core.ui.showcase.constant.PointerViewPositioningConstant;
import id.dana.core.ui.showcase.contentviewmanager.BottomPointerPositionManager;
import id.dana.core.ui.showcase.contentviewmanager.PointerPositionManager;
import id.dana.core.ui.showcase.contentviewmanager.PointerPositionManagerFactory;
import id.dana.core.ui.showcase.contentviewmanager.TopPointerPositionManager;
import id.dana.core.ui.showcase.target.Target;

/* loaded from: classes4.dex */
public class PointerView extends FrameLayout {
    public static final long DEFAULT_ANIMATION_DURATION = 300;
    public static final float DEFAULT_CONTAINER_PADDING = SizeUtil.PlaceComponentResult(8);
    private boolean BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private ImageView MyBillsEntityDataFactory;
    private Target PlaceComponentResult;
    private float getAuthRequestContext;
    private PointerViewPositioningConstant getErrorConfigVersion;
    private PointerPositionManager lookAheadTest;
    private RoundedView moveToNextValue;

    public PointerView(Context context) {
        super(context);
        this.getAuthRequestContext = DEFAULT_CONTAINER_PADDING;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getErrorConfigVersion = PointerViewPositioningConstant.DYNAMIC;
        init(context, null);
    }

    public PointerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = DEFAULT_CONTAINER_PADDING;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getErrorConfigVersion = PointerViewPositioningConstant.DYNAMIC;
        init(context, null);
    }

    public PointerView(Context context, Target target, boolean z, boolean z2, PointerViewPositioningConstant pointerViewPositioningConstant) {
        super(context);
        this.getAuthRequestContext = DEFAULT_CONTAINER_PADDING;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        PointerViewPositioningConstant pointerViewPositioningConstant2 = PointerViewPositioningConstant.DYNAMIC;
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
        this.getErrorConfigVersion = pointerViewPositioningConstant;
        init(context, target);
    }

    public PointerView(Context context, AttributeSet attributeSet, Target target) {
        super(context, attributeSet);
        this.getAuthRequestContext = DEFAULT_CONTAINER_PADDING;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getErrorConfigVersion = PointerViewPositioningConstant.DYNAMIC;
        init(context, target);
    }

    public PointerView(Context context, AttributeSet attributeSet, int i, Target target) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = DEFAULT_CONTAINER_PADDING;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getErrorConfigVersion = PointerViewPositioningConstant.DYNAMIC;
        init(context, target);
    }

    protected void init(Context context, Target target) {
        this.PlaceComponentResult = target;
        View inflate = View.inflate(context, R.layout.res_0x7f0d0697_networkuserentitydata_externalsyntheticlambda8, this);
        this.MyBillsEntityDataFactory = (ImageView) inflate.findViewById(R.id.FragmentBottomSheetPaymentSettingBinding);
        if (this.BuiltInFictitiousFunctionClassFactory && getAuthRequestContext()) {
            this.MyBillsEntityDataFactory.setElevation(SizeUtil.PlaceComponentResult(2));
            if (this.PlaceComponentResult.getAuthRequestContext()) {
                InstrumentInjector.Resources_setImageResource(this.MyBillsEntityDataFactory, R.drawable.res_0x7f080af2_networkuserentitydata_externalsyntheticlambda3);
            } else {
                InstrumentInjector.Resources_setImageResource(this.MyBillsEntityDataFactory, R.drawable.ic_pointer_outline);
            }
        } else if (this.PlaceComponentResult.getAuthRequestContext()) {
            InstrumentInjector.Resources_setImageResource(this.MyBillsEntityDataFactory, R.drawable.FragmentBottomSheetPaymentSettingBinding_res_0x7f080af1);
        }
        this.moveToNextValue = (RoundedView) inflate.findViewById(R.id.rounded_view);
        if (this.BuiltInFictitiousFunctionClassFactory && getAuthRequestContext()) {
            this.moveToNextValue.setElevation(SizeUtil.PlaceComponentResult(2));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                layoutParams.setMargins(SizeUtil.PlaceComponentResult(3), SizeUtil.PlaceComponentResult(16), SizeUtil.PlaceComponentResult(3), SizeUtil.PlaceComponentResult(16));
            } else {
                layoutParams.setMargins(SizeUtil.PlaceComponentResult(3), SizeUtil.PlaceComponentResult(0), SizeUtil.PlaceComponentResult(3), SizeUtil.PlaceComponentResult(16));
            }
            this.moveToNextValue.setLayoutParams(layoutParams);
        }
        this.lookAheadTest = PlaceComponentResult();
        moveContainerToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.core.ui.showcase.view.PointerView$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[PointerViewPositioningConstant.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[PointerViewPositioningConstant.TOP_OF_HIGHLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[PointerViewPositioningConstant.BOTTOM_OF_HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private PointerPositionManager PlaceComponentResult() {
        int i = AnonymousClass4.KClassImpl$Data$declaredNonStaticMembers$2[this.getErrorConfigVersion.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new TopPointerPositionManager(this.MyBillsEntityDataFactory, this, this.PlaceComponentResult);
            }
            return PointerPositionManagerFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this, this.PlaceComponentResult);
        }
        return new BottomPointerPositionManager(this.MyBillsEntityDataFactory, this, this.PlaceComponentResult);
    }

    public void moveContainerToTarget() {
        setY(this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public float getContainerPadding() {
        return this.getAuthRequestContext;
    }

    public void setContainerPadding(float f) {
        this.getAuthRequestContext = f;
    }

    public void addContentView(View view) {
        this.moveToNextValue.addView(view);
    }

    public void showPointer(Target target, Animator.AnimatorListener animatorListener) {
        this.PlaceComponentResult = target;
        PointerPositionManager PlaceComponentResult = PlaceComponentResult();
        this.lookAheadTest = PlaceComponentResult;
        ImageView imageView = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        float f = PlaceComponentResult.MyBillsEntityDataFactory.scheduleImpl.x;
        float x = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getX();
        float f2 = PlaceComponentResult.PlaceComponentResult;
        float f3 = (f - x) - f2;
        if (f3 < 0.0f) {
            f3 = -f2;
        } else if (f3 > PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getWidth() - PlaceComponentResult.PlaceComponentResult) {
            f3 = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getWidth() - PlaceComponentResult.PlaceComponentResult;
        }
        imageView.setX(f3);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setY(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
        long abs = Math.abs(getY() - this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2());
        if (abs > 300) {
            abs = 300;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "y", this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2());
        ofFloat.setInterpolator(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
        ofFloat.setDuration(abs);
        ofFloat.addListener(animatorListener);
        ofFloat.addListener(new AnimatorListener() { // from class: id.dana.core.ui.showcase.view.PointerView.1
            @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PointerView.access$000(PointerView.this);
            }
        });
        ofFloat.start();
    }

    public void hidePointer() {
        if (hasActiveTarget()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.MyBillsEntityDataFactory, "y", this.lookAheadTest.BuiltInFictitiousFunctionClassFactory());
            ofFloat.setDuration(this.PlaceComponentResult.MyBillsEntityDataFactory);
            ofFloat.setInterpolator(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
            ofFloat.addListener(new AnimatorListener() { // from class: id.dana.core.ui.showcase.view.PointerView.3
                @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PointerView.this.MyBillsEntityDataFactory.setVisibility(4);
                }
            });
            ofFloat.start();
        }
    }

    public boolean hasActiveTarget() {
        return this.PlaceComponentResult != null;
    }

    private static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 21;
    }

    static /* synthetic */ void access$000(PointerView pointerView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(pointerView.MyBillsEntityDataFactory, "y", pointerView.lookAheadTest.getAuthRequestContext());
        ofFloat.setInterpolator(pointerView.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
        ofFloat.setDuration(pointerView.PlaceComponentResult.MyBillsEntityDataFactory);
        ofFloat.addListener(new AnimatorListener() { // from class: id.dana.core.ui.showcase.view.PointerView.2
            @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PointerView.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    PointerView.this.MyBillsEntityDataFactory.setVisibility(0);
                }
            }
        });
        ofFloat.start();
    }
}
