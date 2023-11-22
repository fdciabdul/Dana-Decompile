package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

/* loaded from: classes6.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    public static final int WEST = 3;
    private int BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private int moveToNextValue;
    private int scheduleImpl;

    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    public boolean isDecorator() {
        return true;
    }

    public MotionEffect(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = 0.1f;
        this.getAuthRequestContext = 49;
        this.BuiltInFictitiousFunctionClassFactory = 50;
        this.moveToNextValue = 0;
        this.scheduleImpl = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getErrorConfigVersion = -1;
        this.PlaceComponentResult = -1;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = 0.1f;
        this.getAuthRequestContext = 49;
        this.BuiltInFictitiousFunctionClassFactory = 50;
        this.moveToNextValue = 0;
        this.scheduleImpl = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getErrorConfigVersion = -1;
        this.PlaceComponentResult = -1;
        MyBillsEntityDataFactory(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = 0.1f;
        this.getAuthRequestContext = 49;
        this.BuiltInFictitiousFunctionClassFactory = 50;
        this.moveToNextValue = 0;
        this.scheduleImpl = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getErrorConfigVersion = -1;
        this.PlaceComponentResult = -1;
        MyBillsEntityDataFactory(context, attributeSet);
    }

    private void MyBillsEntityDataFactory(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.getChildViewHolder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.DeviceLimitErrorKey) {
                    int i2 = obtainStyledAttributes.getInt(index, this.getAuthRequestContext);
                    this.getAuthRequestContext = i2;
                    this.getAuthRequestContext = Math.max(Math.min(i2, 99), 0);
                } else if (index == R.styleable.getJsonStringKybInfo) {
                    int i3 = obtainStyledAttributes.getInt(index, this.BuiltInFictitiousFunctionClassFactory);
                    this.BuiltInFictitiousFunctionClassFactory = i3;
                    this.BuiltInFictitiousFunctionClassFactory = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.f10$r8$lambda$NPxYYF3ZGctldyLJuApQ7CVOU4) {
                    this.moveToNextValue = obtainStyledAttributes.getDimensionPixelOffset(index, this.moveToNextValue);
                } else if (index == R.styleable.OauthPresenter$GetNicknameCallback) {
                    this.scheduleImpl = obtainStyledAttributes.getDimensionPixelOffset(index, this.scheduleImpl);
                } else if (index == R.styleable.DropShadowKeyframeAnimation$1) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getFloat(index, this.MyBillsEntityDataFactory);
                } else if (index == R.styleable.InterruptibleKt) {
                    this.PlaceComponentResult = obtainStyledAttributes.getInt(index, this.PlaceComponentResult);
                } else if (index == R.styleable.getBCCs) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.TncUrlResult) {
                    this.getErrorConfigVersion = obtainStyledAttributes.getResourceId(index, this.getErrorConfigVersion);
                }
            }
            int i4 = this.getAuthRequestContext;
            int i5 = this.BuiltInFictitiousFunctionClassFactory;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.getAuthRequestContext = i4 - 1;
                } else {
                    this.BuiltInFictitiousFunctionClassFactory = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0181, code lost:
    
        if (r14 == 0.0f) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0194, code lost:
    
        if (r14 == 0.0f) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a4, code lost:
    
        if (r15 == 0.0f) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b6, code lost:
    
        if (r15 == 0.0f) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01be  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r21, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r22) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }
}
