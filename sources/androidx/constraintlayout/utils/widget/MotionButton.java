package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class MotionButton extends AppCompatButton implements FSDraw {
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private Path MyBillsEntityDataFactory;
    private float getAuthRequestContext;
    RectF mRect;
    ViewOutlineProvider mViewOutlineProvider;

    public void fsSuperDraw_16c34b5c2f162ad7763aff116f72fe36(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public MotionButton(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.getAuthRequestContext = Float.NaN;
        getAuthRequestContext(null);
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.getAuthRequestContext = Float.NaN;
        getAuthRequestContext(attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.getAuthRequestContext = Float.NaN;
        getAuthRequestContext(attributeSet);
    }

    private void getAuthRequestContext(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.setLastTelemetrySync);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.getHashMap) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R.styleable.parseLineAndAppendValue && Build.VERSION.SDK_INT >= 21) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2 != f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        if (f != 0.0f) {
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), (Math.min(r3, r4) * MotionButton.this.KClassImpl$Data$declaredNonStaticMembers$2) / 2.0f);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.KClassImpl$Data$declaredNonStaticMembers$2) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.MyBillsEntityDataFactory.reset();
            this.MyBillsEntityDataFactory.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.getAuthRequestContext = f;
            float f2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.getAuthRequestContext != f;
        this.getAuthRequestContext = f;
        if (f != 0.0f) {
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.getAuthRequestContext);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.MyBillsEntityDataFactory.reset();
            Path path = this.MyBillsEntityDataFactory;
            RectF rectF = this.mRect;
            float f3 = this.getAuthRequestContext;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public float getRoundPercent() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public float getRound() {
        return this.getAuthRequestContext;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.getAuthRequestContext == 0.0f || this.MyBillsEntityDataFactory == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.MyBillsEntityDataFactory);
        }
        fsSuperDraw_16c34b5c2f162ad7763aff116f72fe36(canvas);
        if (z) {
            canvas.restore();
        }
    }
}
