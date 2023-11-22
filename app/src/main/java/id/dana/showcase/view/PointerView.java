package id.dana.showcase.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.showcase.AnimatorListener;
import id.dana.showcase.constant.PointerViewPositioningConstant;
import id.dana.showcase.contentviewmanager.BottomPointerPositionManager;
import id.dana.showcase.contentviewmanager.PointerPositionManager;
import id.dana.showcase.contentviewmanager.PointerPositionManagerFactory;
import id.dana.showcase.contentviewmanager.TopPointerPositionManager;
import id.dana.showcase.target.Target;
import id.dana.utils.OSUtil;
import id.dana.utils.SizeUtil;

/* loaded from: classes5.dex */
public class PointerView extends FrameLayout {
    public static final long DEFAULT_ANIMATION_DURATION = 300;
    public static final float DEFAULT_CONTAINER_PADDING = SizeUtil.getAuthRequestContext(8);
    private boolean BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private Target MyBillsEntityDataFactory;
    private PointerViewPositioningConstant NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float PlaceComponentResult;
    private boolean getAuthRequestContext;
    private ImageView getErrorConfigVersion;
    private PointerPositionManager lookAheadTest;
    private int moveToNextValue;
    private RoundedView scheduleImpl;

    public PointerView(Context context, Target target, boolean z, boolean z2, PointerViewPositioningConstant pointerViewPositioningConstant) {
        super(context);
        this.PlaceComponentResult = DEFAULT_CONTAINER_PADDING;
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory = true;
        PointerViewPositioningConstant pointerViewPositioningConstant2 = PointerViewPositioningConstant.DYNAMIC;
        this.getAuthRequestContext = z;
        this.BuiltInFictitiousFunctionClassFactory = z2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pointerViewPositioningConstant;
        init(context, target);
    }

    public PointerView(Context context, Target target, boolean z, boolean z2, PointerViewPositioningConstant pointerViewPositioningConstant, int i, int i2) {
        super(context);
        this.PlaceComponentResult = DEFAULT_CONTAINER_PADDING;
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory = true;
        PointerViewPositioningConstant pointerViewPositioningConstant2 = PointerViewPositioningConstant.DYNAMIC;
        this.getAuthRequestContext = z;
        this.BuiltInFictitiousFunctionClassFactory = z2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pointerViewPositioningConstant;
        this.moveToNextValue = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        init(context, target);
    }

    public PointerView(Context context, AttributeSet attributeSet, Target target) {
        super(context, attributeSet);
        this.PlaceComponentResult = DEFAULT_CONTAINER_PADDING;
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = PointerViewPositioningConstant.DYNAMIC;
        init(context, target);
    }

    public PointerView(Context context, AttributeSet attributeSet, int i, Target target) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = DEFAULT_CONTAINER_PADDING;
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = PointerViewPositioningConstant.DYNAMIC;
        init(context, target);
    }

    protected void init(Context context, Target target) {
        this.MyBillsEntityDataFactory = target;
        View inflate = View.inflate(context, R.layout.view_tooltip_pointer, this);
        this.getErrorConfigVersion = (ImageView) inflate.findViewById(R.id.iv_pointer);
        if (this.getAuthRequestContext && OSUtil.scheduleImpl()) {
            this.getErrorConfigVersion.setElevation(SizeUtil.getAuthRequestContext(2));
            int i = this.moveToNextValue;
            if (i != 0) {
                InstrumentInjector.Resources_setImageResource(this.getErrorConfigVersion, i);
            } else if (this.MyBillsEntityDataFactory.PlaceComponentResult()) {
                InstrumentInjector.Resources_setImageResource(this.getErrorConfigVersion, R.drawable.res_0x7f080af2_networkuserentitydata_externalsyntheticlambda3);
            } else {
                InstrumentInjector.Resources_setImageResource(this.getErrorConfigVersion, R.drawable.ic_pointer_outline);
            }
        } else if (this.MyBillsEntityDataFactory.PlaceComponentResult()) {
            InstrumentInjector.Resources_setImageResource(this.getErrorConfigVersion, R.drawable.FragmentBottomSheetPaymentSettingBinding_res_0x7f080af1);
        } else {
            int i2 = this.moveToNextValue;
            if (i2 != 0) {
                InstrumentInjector.Resources_setImageResource(this.getErrorConfigVersion, i2);
            }
        }
        RoundedView roundedView = (RoundedView) inflate.findViewById(R.id.rounded_view);
        this.scheduleImpl = roundedView;
        int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i3 != 0) {
            roundedView.setBackgroundResource(i3);
        }
        if (this.getAuthRequestContext && OSUtil.scheduleImpl()) {
            this.scheduleImpl.setElevation(SizeUtil.getAuthRequestContext(2));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                layoutParams.setMargins(SizeUtil.getAuthRequestContext(3), SizeUtil.getAuthRequestContext(16), SizeUtil.getAuthRequestContext(3), SizeUtil.getAuthRequestContext(16));
            } else {
                layoutParams.setMargins(SizeUtil.getAuthRequestContext(3), SizeUtil.getAuthRequestContext(0), SizeUtil.getAuthRequestContext(3), SizeUtil.getAuthRequestContext(16));
            }
            this.scheduleImpl.setLayoutParams(layoutParams);
        }
        this.lookAheadTest = MyBillsEntityDataFactory();
        moveContainerToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.showcase.view.PointerView$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[PointerViewPositioningConstant.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[PointerViewPositioningConstant.TOP_OF_HIGHLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[PointerViewPositioningConstant.BOTTOM_OF_HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private PointerPositionManager MyBillsEntityDataFactory() {
        int i = AnonymousClass4.getAuthRequestContext[this.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new TopPointerPositionManager(this.getErrorConfigVersion, this, this.MyBillsEntityDataFactory);
            }
            return PointerPositionManagerFactory.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this, this.MyBillsEntityDataFactory);
        }
        return new BottomPointerPositionManager(this.getErrorConfigVersion, this, this.MyBillsEntityDataFactory);
    }

    public void moveContainerToTarget() {
        setY(this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public float getContainerPadding() {
        return this.PlaceComponentResult;
    }

    public void setContainerPadding(float f) {
        this.PlaceComponentResult = f;
    }

    public void addContentView(View view) {
        this.scheduleImpl.addView(view);
    }

    public void showPointer(Target target, Animator.AnimatorListener animatorListener) {
        this.MyBillsEntityDataFactory = target;
        PointerPositionManager MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        this.lookAheadTest = MyBillsEntityDataFactory;
        ImageView imageView = MyBillsEntityDataFactory.PlaceComponentResult;
        float f = MyBillsEntityDataFactory.MyBillsEntityDataFactory.lookAheadTest.x;
        float x = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getX();
        float f2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        float f3 = (f - x) - f2;
        if (f3 < 0.0f) {
            f3 = -f2;
        } else if (f3 > MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getWidth() - MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
            f3 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getWidth() - MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        imageView.setX(f3);
        MyBillsEntityDataFactory.PlaceComponentResult.setY(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
        long abs = Math.abs(getY() - this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2());
        if (abs > 300) {
            abs = 300;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "y", this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2());
        ofFloat.setInterpolator(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        ofFloat.setDuration(abs);
        ofFloat.addListener(animatorListener);
        ofFloat.addListener(new AnimatorListener() { // from class: id.dana.showcase.view.PointerView.1
            @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PointerView.access$000(PointerView.this);
            }
        });
        ofFloat.start();
    }

    public void hidePointer() {
        if (hasActiveTarget()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.getErrorConfigVersion, "y", this.lookAheadTest.BuiltInFictitiousFunctionClassFactory());
            ofFloat.setDuration(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            ofFloat.setInterpolator(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
            ofFloat.addListener(new AnimatorListener() { // from class: id.dana.showcase.view.PointerView.3
                @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PointerView.this.getErrorConfigVersion.setVisibility(4);
                }
            });
            ofFloat.start();
        }
    }

    public boolean hasActiveTarget() {
        return this.MyBillsEntityDataFactory != null;
    }

    static /* synthetic */ void access$000(PointerView pointerView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(pointerView.getErrorConfigVersion, "y", pointerView.lookAheadTest.MyBillsEntityDataFactory());
        ofFloat.setInterpolator(pointerView.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        ofFloat.setDuration(pointerView.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
        ofFloat.addListener(new AnimatorListener() { // from class: id.dana.showcase.view.PointerView.2
            @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PointerView.this.BuiltInFictitiousFunctionClassFactory) {
                    PointerView.this.getErrorConfigVersion.setVisibility(0);
                }
            }
        });
        ofFloat.start();
    }
}
