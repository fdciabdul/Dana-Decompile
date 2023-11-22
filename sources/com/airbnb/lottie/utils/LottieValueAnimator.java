package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes3.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    public LottieComposition MyBillsEntityDataFactory;
    public float getErrorConfigVersion = 1.0f;
    private boolean scheduleImpl = false;
    private long lookAheadTest = 0;
    public float KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public float PlaceComponentResult = -2.14748365E9f;
    public float getAuthRequestContext = 2.14748365E9f;
    protected boolean BuiltInFictitiousFunctionClassFactory = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAuthRequestContext());
    }

    public final float getAuthRequestContext() {
        LottieComposition lottieComposition = this.MyBillsEntityDataFactory;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 - lottieComposition.DatabaseTableConfigUtil) / (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory - this.MyBillsEntityDataFactory.DatabaseTableConfigUtil);
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6 = 0.0f;
        if (this.MyBillsEntityDataFactory == null) {
            return 0.0f;
        }
        if (!getErrorConfigVersion()) {
            float f7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            LottieComposition lottieComposition = this.MyBillsEntityDataFactory;
            if (lottieComposition == null) {
                f = 0.0f;
            } else {
                f = this.PlaceComponentResult;
                if (f == -2.14748365E9f) {
                    f = lottieComposition.DatabaseTableConfigUtil;
                }
            }
            f2 = f7 - f;
            LottieComposition lottieComposition2 = this.MyBillsEntityDataFactory;
            if (lottieComposition2 == null) {
                f3 = 0.0f;
            } else {
                f3 = this.getAuthRequestContext;
                if (f3 == 2.14748365E9f) {
                    f3 = lottieComposition2.MyBillsEntityDataFactory;
                }
            }
            LottieComposition lottieComposition3 = this.MyBillsEntityDataFactory;
            if (lottieComposition3 != null) {
                f6 = this.PlaceComponentResult;
                if (f6 == -2.14748365E9f) {
                    f4 = lottieComposition3.DatabaseTableConfigUtil;
                    f6 = f4;
                }
            }
            return f2 / (f3 - f6);
        }
        LottieComposition lottieComposition4 = this.MyBillsEntityDataFactory;
        if (lottieComposition4 == null) {
            f5 = 0.0f;
        } else {
            f5 = this.getAuthRequestContext;
            if (f5 == 2.14748365E9f) {
                f5 = lottieComposition4.MyBillsEntityDataFactory;
            }
        }
        f2 = f5 - this.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition5 = this.MyBillsEntityDataFactory;
        if (lottieComposition5 == null) {
            f3 = 0.0f;
        } else {
            f3 = this.getAuthRequestContext;
            if (f3 == 2.14748365E9f) {
                f3 = lottieComposition5.MyBillsEntityDataFactory;
            }
        }
        LottieComposition lottieComposition6 = this.MyBillsEntityDataFactory;
        if (lottieComposition6 != null) {
            f6 = this.PlaceComponentResult;
            if (f6 == -2.14748365E9f) {
                f4 = lottieComposition6.DatabaseTableConfigUtil;
                f6 = f4;
            }
        }
        return f2 / (f3 - f6);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.MyBillsEntityDataFactory == null) {
            return 0L;
        }
        return ((r0.MyBillsEntityDataFactory - r0.DatabaseTableConfigUtil) / r0.PlaceComponentResult) * 1000.0f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final void getAuthRequestContext(float f) {
        float f2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == f) {
            return;
        }
        LottieComposition lottieComposition = this.MyBillsEntityDataFactory;
        float f3 = 0.0f;
        if (lottieComposition == null) {
            f2 = 0.0f;
        } else {
            f2 = this.PlaceComponentResult;
            if (f2 == -2.14748365E9f) {
                f2 = lottieComposition.DatabaseTableConfigUtil;
            }
        }
        LottieComposition lottieComposition2 = this.MyBillsEntityDataFactory;
        if (lottieComposition2 != null) {
            f3 = this.getAuthRequestContext;
            if (f3 == 2.14748365E9f) {
                f3 = lottieComposition2.MyBillsEntityDataFactory;
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MiscUtils.MyBillsEntityDataFactory(f, f2, f3);
        this.lookAheadTest = 0L;
        BuiltInFictitiousFunctionClassFactory();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        LottieComposition lottieComposition = this.MyBillsEntityDataFactory;
        float f3 = lottieComposition == null ? -3.4028235E38f : lottieComposition.DatabaseTableConfigUtil;
        LottieComposition lottieComposition2 = this.MyBillsEntityDataFactory;
        float f4 = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.MyBillsEntityDataFactory;
        float MyBillsEntityDataFactory = MiscUtils.MyBillsEntityDataFactory(f, f3, f4);
        float MyBillsEntityDataFactory2 = MiscUtils.MyBillsEntityDataFactory(f2, f3, f4);
        if (MyBillsEntityDataFactory == this.PlaceComponentResult && MyBillsEntityDataFactory2 == this.getAuthRequestContext) {
            return;
        }
        this.PlaceComponentResult = MyBillsEntityDataFactory;
        this.getAuthRequestContext = MyBillsEntityDataFactory2;
        getAuthRequestContext((int) MiscUtils.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory, MyBillsEntityDataFactory2));
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.scheduleImpl) {
            return;
        }
        this.scheduleImpl = false;
        this.getErrorConfigVersion = -this.getErrorConfigVersion;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        float f;
        this.BuiltInFictitiousFunctionClassFactory = true;
        BuiltInFictitiousFunctionClassFactory(getErrorConfigVersion());
        float f2 = 0.0f;
        if (getErrorConfigVersion()) {
            LottieComposition lottieComposition = this.MyBillsEntityDataFactory;
            if (lottieComposition != null) {
                f2 = this.getAuthRequestContext;
                if (f2 == 2.14748365E9f) {
                    f = lottieComposition.MyBillsEntityDataFactory;
                    f2 = f;
                }
            }
        } else {
            LottieComposition lottieComposition2 = this.MyBillsEntityDataFactory;
            if (lottieComposition2 != null) {
                f2 = this.PlaceComponentResult;
                if (f2 == -2.14748365E9f) {
                    f = lottieComposition2.DatabaseTableConfigUtil;
                    f2 = f;
                }
            }
        }
        getAuthRequestContext((int) f2);
        this.lookAheadTest = 0L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        if (isRunning()) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public final void scheduleImpl() {
        float f;
        float f2;
        this.BuiltInFictitiousFunctionClassFactory = true;
        if (isRunning()) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
        this.lookAheadTest = 0L;
        float f3 = 0.0f;
        if (getErrorConfigVersion()) {
            float f4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            LottieComposition lottieComposition = this.MyBillsEntityDataFactory;
            if (lottieComposition == null) {
                f2 = 0.0f;
            } else {
                f2 = this.PlaceComponentResult;
                if (f2 == -2.14748365E9f) {
                    f2 = lottieComposition.DatabaseTableConfigUtil;
                }
            }
            if (f4 == f2) {
                LottieComposition lottieComposition2 = this.MyBillsEntityDataFactory;
                if (lottieComposition2 != null) {
                    float f5 = this.getAuthRequestContext;
                    f3 = f5 == 2.14748365E9f ? lottieComposition2.MyBillsEntityDataFactory : f5;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = f3;
                return;
            }
        }
        if (getErrorConfigVersion()) {
            return;
        }
        float f6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition3 = this.MyBillsEntityDataFactory;
        if (lottieComposition3 == null) {
            f = 0.0f;
        } else {
            f = this.getAuthRequestContext;
            if (f == 2.14748365E9f) {
                f = lottieComposition3.MyBillsEntityDataFactory;
            }
        }
        if (f6 == f) {
            LottieComposition lottieComposition4 = this.MyBillsEntityDataFactory;
            if (lottieComposition4 != null) {
                float f7 = this.PlaceComponentResult;
                f3 = f7 == -2.14748365E9f ? lottieComposition4.DatabaseTableConfigUtil : f7;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = f3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    public final void PlaceComponentResult() {
        super.PlaceComponentResult();
        MyBillsEntityDataFactory(getErrorConfigVersion());
    }

    private boolean getErrorConfigVersion() {
        return this.getErrorConfigVersion < 0.0f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        super.PlaceComponentResult();
        MyBillsEntityDataFactory(getErrorConfigVersion());
        Choreographer.getInstance().removeFrameCallback(this);
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (isRunning()) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
        if (this.MyBillsEntityDataFactory == null || !isRunning()) {
            return;
        }
        L.getAuthRequestContext("LottieValueAnimator#doFrame");
        long j2 = this.lookAheadTest;
        long j3 = j2 != 0 ? j - j2 : 0L;
        LottieComposition lottieComposition = this.MyBillsEntityDataFactory;
        float abs = ((float) j3) / (lottieComposition == null ? Float.MAX_VALUE : (1.0E9f / lottieComposition.PlaceComponentResult) / Math.abs(this.getErrorConfigVersion));
        float f8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (getErrorConfigVersion()) {
            abs = -abs;
        }
        float f9 = f8 + abs;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f9;
        LottieComposition lottieComposition2 = this.MyBillsEntityDataFactory;
        float f10 = 0.0f;
        if (lottieComposition2 == null) {
            f = 0.0f;
        } else {
            f = this.PlaceComponentResult;
            if (f == -2.14748365E9f) {
                f = lottieComposition2.DatabaseTableConfigUtil;
            }
        }
        LottieComposition lottieComposition3 = this.MyBillsEntityDataFactory;
        if (lottieComposition3 == null) {
            f2 = 0.0f;
        } else {
            f2 = this.getAuthRequestContext;
            if (f2 == 2.14748365E9f) {
                f2 = lottieComposition3.MyBillsEntityDataFactory;
            }
        }
        boolean authRequestContext = MiscUtils.getAuthRequestContext(f9, f, f2);
        float f11 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition4 = this.MyBillsEntityDataFactory;
        if (lottieComposition4 == null) {
            f3 = 0.0f;
        } else {
            f3 = this.PlaceComponentResult;
            if (f3 == -2.14748365E9f) {
                f3 = lottieComposition4.DatabaseTableConfigUtil;
            }
        }
        LottieComposition lottieComposition5 = this.MyBillsEntityDataFactory;
        if (lottieComposition5 == null) {
            f4 = 0.0f;
        } else {
            f4 = this.getAuthRequestContext;
            if (f4 == 2.14748365E9f) {
                f4 = lottieComposition5.MyBillsEntityDataFactory;
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MiscUtils.MyBillsEntityDataFactory(f11, f3, f4);
        this.lookAheadTest = j;
        BuiltInFictitiousFunctionClassFactory();
        if ((!authRequestContext) != false) {
            if (getRepeatCount() == -1 || this.NetworkUserEntityData$$ExternalSyntheticLambda0 < getRepeatCount()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0++;
                if (getRepeatMode() == 2) {
                    this.scheduleImpl = !this.scheduleImpl;
                    this.getErrorConfigVersion = -this.getErrorConfigVersion;
                } else if (getErrorConfigVersion()) {
                    LottieComposition lottieComposition6 = this.MyBillsEntityDataFactory;
                    if (lottieComposition6 != null) {
                        float f12 = this.getAuthRequestContext;
                        if (f12 == 2.14748365E9f) {
                            f5 = lottieComposition6.MyBillsEntityDataFactory;
                            f10 = f5;
                        } else {
                            f10 = f12;
                        }
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = f10;
                } else {
                    LottieComposition lottieComposition7 = this.MyBillsEntityDataFactory;
                    if (lottieComposition7 != null) {
                        f10 = this.PlaceComponentResult;
                        if (f10 == -2.14748365E9f) {
                            f5 = lottieComposition7.DatabaseTableConfigUtil;
                            f10 = f5;
                        }
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = f10;
                }
                this.lookAheadTest = j;
            } else if (this.getErrorConfigVersion < 0.0f) {
                LottieComposition lottieComposition8 = this.MyBillsEntityDataFactory;
                if (lottieComposition8 != null) {
                    f6 = this.PlaceComponentResult;
                    if (f6 == -2.14748365E9f) {
                        f7 = lottieComposition8.DatabaseTableConfigUtil;
                        f10 = f7;
                    }
                    f10 = f6;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = f10;
                Choreographer.getInstance().removeFrameCallback(this);
                this.BuiltInFictitiousFunctionClassFactory = false;
                MyBillsEntityDataFactory(getErrorConfigVersion());
            } else {
                LottieComposition lottieComposition9 = this.MyBillsEntityDataFactory;
                if (lottieComposition9 != null) {
                    f6 = this.getAuthRequestContext;
                    if (f6 == 2.14748365E9f) {
                        f7 = lottieComposition9.MyBillsEntityDataFactory;
                        f10 = f7;
                    }
                    f10 = f6;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = f10;
                Choreographer.getInstance().removeFrameCallback(this);
                this.BuiltInFictitiousFunctionClassFactory = false;
                MyBillsEntityDataFactory(getErrorConfigVersion());
            }
        }
        if (this.MyBillsEntityDataFactory != null) {
            float f13 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (f13 < this.PlaceComponentResult || f13 > this.getAuthRequestContext) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.PlaceComponentResult), Float.valueOf(this.getAuthRequestContext), Float.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2)));
            }
        }
        L.MyBillsEntityDataFactory("LottieValueAnimator#doFrame");
    }

    public final void MyBillsEntityDataFactory() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.BuiltInFictitiousFunctionClassFactory = false;
        MyBillsEntityDataFactory(getErrorConfigVersion());
    }

    public final void moveToNextValue() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.BuiltInFictitiousFunctionClassFactory = false;
    }
}
