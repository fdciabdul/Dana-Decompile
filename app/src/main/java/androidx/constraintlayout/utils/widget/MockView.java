package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* loaded from: classes6.dex */
public class MockView extends View {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private Paint NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Paint PlaceComponentResult;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private Paint lookAheadTest;
    protected String mText;
    private Rect moveToNextValue;
    private int scheduleImpl;

    public MockView(Context context) {
        super(context);
        this.PlaceComponentResult = new Paint();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Paint();
        this.lookAheadTest = new Paint();
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = true;
        this.mText = null;
        this.moveToNextValue = new Rect();
        this.getAuthRequestContext = Color.argb(255, 0, 0, 0);
        this.getErrorConfigVersion = Color.argb(255, 200, 200, 200);
        this.scheduleImpl = Color.argb(255, 50, 50, 50);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 4;
        PlaceComponentResult(context, null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = new Paint();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Paint();
        this.lookAheadTest = new Paint();
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = true;
        this.mText = null;
        this.moveToNextValue = new Rect();
        this.getAuthRequestContext = Color.argb(255, 0, 0, 0);
        this.getErrorConfigVersion = Color.argb(255, 200, 200, 200);
        this.scheduleImpl = Color.argb(255, 50, 50, 50);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 4;
        PlaceComponentResult(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = new Paint();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Paint();
        this.lookAheadTest = new Paint();
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = true;
        this.mText = null;
        this.moveToNextValue = new Rect();
        this.getAuthRequestContext = Color.argb(255, 0, 0, 0);
        this.getErrorConfigVersion = Color.argb(255, 200, 200, 200);
        this.scheduleImpl = Color.argb(255, 50, 50, 50);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 4;
        PlaceComponentResult(context, attributeSet);
    }

    private void PlaceComponentResult(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.requiresTunnel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.mirrorYUV420) {
                    this.mText = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.standardListIterator) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getBoolean(index, this.BuiltInFictitiousFunctionClassFactory);
                } else if (index == R.styleable.JvmProtoBuf$JvmPropertySignature$Builder) {
                    this.getAuthRequestContext = obtainStyledAttributes.getColor(index, this.getAuthRequestContext);
                } else if (index == R.styleable.f16$r8$lambda$uWKmRJxSRV4LU7FfXKveI54DNk) {
                    this.scheduleImpl = obtainStyledAttributes.getColor(index, this.scheduleImpl);
                } else if (index == R.styleable.FirebaseCommonRegistrar) {
                    this.getErrorConfigVersion = obtainStyledAttributes.getColor(index, this.getErrorConfigVersion);
                } else if (index == R.styleable.access$setBufferAt) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getBoolean(index, this.MyBillsEntityDataFactory);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mText == null) {
            try {
                this.mText = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.PlaceComponentResult.setColor(this.getAuthRequestContext);
        this.PlaceComponentResult.setAntiAlias(true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(this.getErrorConfigVersion);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setAntiAlias(true);
        this.lookAheadTest.setColor(this.scheduleImpl);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.round(this.KClassImpl$Data$declaredNonStaticMembers$2 * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.BuiltInFictitiousFunctionClassFactory) {
            width--;
            height--;
            float f = width;
            float f2 = height;
            canvas.drawLine(0.0f, 0.0f, f, f2, this.PlaceComponentResult);
            canvas.drawLine(0.0f, f2, f, 0.0f, this.PlaceComponentResult);
            canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.PlaceComponentResult);
            canvas.drawLine(f, 0.0f, f, f2, this.PlaceComponentResult);
            canvas.drawLine(f, f2, 0.0f, f2, this.PlaceComponentResult);
            canvas.drawLine(0.0f, f2, 0.0f, 0.0f, this.PlaceComponentResult);
        }
        String str = this.mText;
        if (str == null || !this.MyBillsEntityDataFactory) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getTextBounds(str, 0, str.length(), this.moveToNextValue);
        float width2 = (width - this.moveToNextValue.width()) / 2.0f;
        float height2 = ((height - this.moveToNextValue.height()) / 2.0f) + this.moveToNextValue.height();
        this.moveToNextValue.offset((int) width2, (int) height2);
        Rect rect = this.moveToNextValue;
        rect.set(rect.left - this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue.top - this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue.right + this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue.bottom + this.KClassImpl$Data$declaredNonStaticMembers$2);
        canvas.drawRect(this.moveToNextValue, this.lookAheadTest);
        canvas.drawText(this.mText, width2, height2, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
