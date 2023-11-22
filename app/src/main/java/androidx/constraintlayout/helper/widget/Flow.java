package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

/* loaded from: classes6.dex */
public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private androidx.constraintlayout.core.widgets.Flow getAuthRequestContext;

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        androidx.constraintlayout.core.widgets.Flow flow = this.getAuthRequestContext;
        int i = flow.onDecodeSuccess;
        if (i > 0 || flow.getDefaultSenderId > 0) {
            if (z) {
                flow.checkRegisteredUserAndSendOtp = flow.getDefaultSenderId;
                flow.f7reduceIndexedz1zDJgo = i;
                return;
            }
            flow.checkRegisteredUserAndSendOtp = i;
            flow.f7reduceIndexedz1zDJgo = flow.getDefaultSenderId;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int i, int i2) {
        onMeasure(this.getAuthRequestContext, i, i2);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (virtualLayout != null) {
            virtualLayout.MyBillsEntityDataFactory(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.getCardNumberOCR, virtualLayout.FlowableReduce$ReduceSubscriber);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            if (layoutParams.O != -1) {
                flow.w = layoutParams.O;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.getAuthRequestContext = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index != R.styleable.getValueOfTouchPositionAbsolute) {
                    if (index == R.styleable.D) {
                        androidx.constraintlayout.core.widgets.Flow flow = this.getAuthRequestContext;
                        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        flow.secondaryHash = dimensionPixelSize;
                        flow.getIndexName = dimensionPixelSize;
                        flow.getContainerAuth = dimensionPixelSize;
                        flow.JsonParseException = dimensionPixelSize;
                        flow.onDecodeSuccess = dimensionPixelSize;
                        flow.getDefaultSenderId = dimensionPixelSize;
                    } else if (index == R.styleable.I) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            androidx.constraintlayout.core.widgets.Flow flow2 = this.getAuthRequestContext;
                            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                            flow2.onDecodeSuccess = dimensionPixelSize2;
                            flow2.checkRegisteredUserAndSendOtp = dimensionPixelSize2;
                            flow2.f7reduceIndexedz1zDJgo = dimensionPixelSize2;
                        }
                    } else if (index == R.styleable.E) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.getAuthRequestContext.getDefaultSenderId = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        }
                    } else if (index == R.styleable.H) {
                        androidx.constraintlayout.core.widgets.Flow flow3 = this.getAuthRequestContext;
                        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        flow3.secondaryHash = dimensionPixelSize3;
                        flow3.checkRegisteredUserAndSendOtp = dimensionPixelSize3;
                    } else if (index != R.styleable.F) {
                        if (index == R.styleable.G) {
                            androidx.constraintlayout.core.widgets.Flow flow4 = this.getAuthRequestContext;
                            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                            flow4.getContainerAuth = dimensionPixelSize4;
                            flow4.f7reduceIndexedz1zDJgo = dimensionPixelSize4;
                        } else if (index != R.styleable.VerifyPinStateManager$executeRiskChallenge$2$2) {
                            if (index != R.styleable.b) {
                                if (index != R.styleable.X) {
                                    if (index != R.styleable.c) {
                                        if (index != R.styleable.R) {
                                            if (index != R.styleable.Y) {
                                                if (index != R.styleable.isAuth) {
                                                    if (index != R.styleable.Z) {
                                                        if (index != R.styleable.W) {
                                                            if (index != R.styleable.SummaryVoucherView$$ExternalSyntheticLambda1) {
                                                                if (index != R.styleable.V) {
                                                                    if (index != R.styleable.S) {
                                                                        if (index != R.styleable.isAuto) {
                                                                            if (index != R.styleable.QrExpiredActivity) {
                                                                                if (index != R.styleable.U) {
                                                                                    if (index != R.styleable.shouldRecycleViewType) {
                                                                                        if (index != R.styleable.T) {
                                                                                            if (index != R.styleable.d) {
                                                                                                if (index == R.styleable.flip) {
                                                                                                    this.getAuthRequestContext.u = obtainStyledAttributes.getInt(index, -1);
                                                                                                }
                                                                                            } else {
                                                                                                this.getAuthRequestContext.RequestMoneyQrContract$View = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                                                            }
                                                                                        } else {
                                                                                            this.getAuthRequestContext.t = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                                                        }
                                                                                    } else {
                                                                                        this.getAuthRequestContext.v = obtainStyledAttributes.getInt(index, 2);
                                                                                    }
                                                                                } else {
                                                                                    this.getAuthRequestContext.f5942o = obtainStyledAttributes.getInt(index, 2);
                                                                                }
                                                                            } else {
                                                                                this.getAuthRequestContext.setNetAuthId = obtainStyledAttributes.getFloat(index, 0.5f);
                                                                            }
                                                                        } else {
                                                                            this.getAuthRequestContext.x = obtainStyledAttributes.getFloat(index, 0.5f);
                                                                        }
                                                                    } else {
                                                                        this.getAuthRequestContext.PlaceComponentResult = obtainStyledAttributes.getFloat(index, 0.5f);
                                                                    }
                                                                } else {
                                                                    this.getAuthRequestContext.s = obtainStyledAttributes.getFloat(index, 0.5f);
                                                                }
                                                            } else {
                                                                this.getAuthRequestContext.MyBillsEntityDataFactory = obtainStyledAttributes.getFloat(index, 0.5f);
                                                            }
                                                        } else {
                                                            this.getAuthRequestContext.r = obtainStyledAttributes.getFloat(index, 0.5f);
                                                        }
                                                    } else {
                                                        this.getAuthRequestContext.TypefaceCompatApi26Impl = obtainStyledAttributes.getInt(index, 0);
                                                    }
                                                } else {
                                                    this.getAuthRequestContext.getAuthRequestContext = obtainStyledAttributes.getInt(index, 0);
                                                }
                                            } else {
                                                this.getAuthRequestContext.SizeSelectors$OrSelector = obtainStyledAttributes.getInt(index, 0);
                                            }
                                        } else {
                                            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(index, 0);
                                        }
                                    } else {
                                        this.getAuthRequestContext.y = obtainStyledAttributes.getInt(index, 0);
                                    }
                                } else {
                                    this.getAuthRequestContext.q = obtainStyledAttributes.getInt(index, 0);
                                }
                            } else {
                                this.getAuthRequestContext.initAnimators = obtainStyledAttributes.getInt(index, 0);
                            }
                        } else {
                            this.getAuthRequestContext.JsonParseException = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        }
                    } else {
                        this.getAuthRequestContext.getIndexName = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    }
                } else {
                    this.getAuthRequestContext.w = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mHelperWidget = this.getAuthRequestContext;
        validateParams();
    }

    public void setOrientation(int i) {
        this.getAuthRequestContext.w = i;
        requestLayout();
    }

    public void setPadding(int i) {
        androidx.constraintlayout.core.widgets.Flow flow = this.getAuthRequestContext;
        flow.secondaryHash = i;
        flow.getIndexName = i;
        flow.getContainerAuth = i;
        flow.JsonParseException = i;
        flow.onDecodeSuccess = i;
        flow.getDefaultSenderId = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        androidx.constraintlayout.core.widgets.Flow flow = this.getAuthRequestContext;
        flow.secondaryHash = i;
        flow.checkRegisteredUserAndSendOtp = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.getAuthRequestContext.getIndexName = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        androidx.constraintlayout.core.widgets.Flow flow = this.getAuthRequestContext;
        flow.getContainerAuth = i;
        flow.f7reduceIndexedz1zDJgo = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.getAuthRequestContext.JsonParseException = i;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.getAuthRequestContext.SizeSelectors$OrSelector = i;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.getAuthRequestContext.TypefaceCompatApi26Impl = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.getAuthRequestContext.s = f;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.getAuthRequestContext.x = f;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.getAuthRequestContext.initAnimators = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.getAuthRequestContext.q = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.getAuthRequestContext.y = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.getAuthRequestContext.r = f;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.getAuthRequestContext.setNetAuthId = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = i;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.getAuthRequestContext.getAuthRequestContext = i;
        requestLayout();
    }

    public void setFirstHorizontalBias(float f) {
        this.getAuthRequestContext.MyBillsEntityDataFactory = f;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.getAuthRequestContext.PlaceComponentResult = f;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.getAuthRequestContext.f5942o = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.getAuthRequestContext.v = i;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.getAuthRequestContext.t = i;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.getAuthRequestContext.RequestMoneyQrContract$View = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.getAuthRequestContext.u = i;
        requestLayout();
    }
}
