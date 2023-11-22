package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View implements FSDraw, FSDispatchDraw {
    private WeakReference<View> BuiltInFictitiousFunctionClassFactory;
    private OnInflateListener KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private LayoutInflater getAuthRequestContext;

    /* loaded from: classes3.dex */
    public interface OnInflateListener {
        void getAuthRequestContext(ViewStubCompat viewStubCompat, View view);
    }

    @Override // android.view.View
    protected final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public final boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_a3ef97675b3c5200e26589d5f044ced0(canvas, view, j);
    }

    public final void fsSuperDispatchDraw_a3ef97675b3c5200e26589d5f044ced0(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public final boolean fsSuperDrawChild_a3ef97675b3c5200e26589d5f044ced0(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerifyPasswordFacade, i, 0);
        this.MyBillsEntityDataFactory = obtainStyledAttributes.getResourceId(R.styleable.ListPopupWindow$Api29Impl, -1);
        this.PlaceComponentResult = obtainStyledAttributes.getResourceId(R.styleable.clearMerchantList, 0);
        setId(obtainStyledAttributes.getResourceId(R.styleable.QueryPayMethod, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final int getInflatedId() {
        return this.MyBillsEntityDataFactory;
    }

    public final void setInflatedId(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    public final int getLayoutResource() {
        return this.PlaceComponentResult;
    }

    public final void setLayoutResource(int i) {
        this.PlaceComponentResult = i;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.getAuthRequestContext = layoutInflater;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.getAuthRequestContext;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        WeakReference<View> weakReference = this.BuiltInFictitiousFunctionClassFactory;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }

    public final View inflate() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.PlaceComponentResult != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.getAuthRequestContext;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.PlaceComponentResult, viewGroup, false);
                int i = this.MyBillsEntityDataFactory;
                if (i != -1) {
                    inflate.setId(i);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(inflate);
                OnInflateListener onInflateListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (onInflateListener != null) {
                    onInflateListener.getAuthRequestContext(this, inflate);
                }
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public final void setOnInflateListener(OnInflateListener onInflateListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onInflateListener;
    }
}
