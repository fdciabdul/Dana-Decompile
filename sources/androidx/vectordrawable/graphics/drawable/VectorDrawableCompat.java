package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon implements FSDraw {
    static final PorterDuff.Mode KClassImpl$Data$declaredNonStaticMembers$2 = PorterDuff.Mode.SRC_IN;
    private ColorFilter MyBillsEntityDataFactory;
    private PorterDuffColorFilter NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean PlaceComponentResult;
    private Drawable.ConstantState getAuthRequestContext;
    private final Rect getErrorConfigVersion;
    private VectorDrawableCompatState initRecordTimeStamp;
    private boolean lookAheadTest;
    private final Matrix moveToNextValue;
    private final float[] scheduleImpl;

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    VectorDrawableCompat() {
        this.PlaceComponentResult = true;
        this.scheduleImpl = new float[9];
        this.moveToNextValue = new Matrix();
        this.getErrorConfigVersion = new Rect();
        this.initRecordTimeStamp = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.PlaceComponentResult = true;
        this.scheduleImpl = new float[9];
        this.moveToNextValue = new Matrix();
        this.getErrorConfigVersion = new Rect();
        this.initRecordTimeStamp = vectorDrawableCompatState;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, vectorDrawableCompatState.moveToNextValue, vectorDrawableCompatState.initRecordTimeStamp);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.mutate();
            return this;
        }
        if (!this.lookAheadTest && super.mutate() == this) {
            this.initRecordTimeStamp = new VectorDrawableCompatState(this.initRecordTimeStamp);
            this.lookAheadTest = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object BuiltInFictitiousFunctionClassFactory(String str) {
        return this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.BuiltInFictitiousFunctionClassFactory != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.BuiltInFictitiousFunctionClassFactory.getConstantState());
        }
        this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda0 = getChangingConfigurations();
        return this.initRecordTimeStamp;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.draw(canvas);
            return;
        }
        copyBounds(this.getErrorConfigVersion);
        if (this.getErrorConfigVersion.width() <= 0 || this.getErrorConfigVersion.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.MyBillsEntityDataFactory;
        if (colorFilter == null) {
            colorFilter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        canvas.getMatrix(this.moveToNextValue);
        this.moveToNextValue.getValues(this.scheduleImpl);
        float abs = Math.abs(this.scheduleImpl[0]);
        float abs2 = Math.abs(this.scheduleImpl[4]);
        float abs3 = Math.abs(this.scheduleImpl[1]);
        float abs4 = Math.abs(this.scheduleImpl[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.getErrorConfigVersion.width() * abs));
        int min2 = Math.min(2048, (int) (this.getErrorConfigVersion.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.getErrorConfigVersion.left, this.getErrorConfigVersion.top);
        if (MyBillsEntityDataFactory()) {
            canvas.translate(this.getErrorConfigVersion.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.getErrorConfigVersion.offsetTo(0, 0);
        this.initRecordTimeStamp.MyBillsEntityDataFactory(min, min2);
        if (!this.PlaceComponentResult) {
            this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(min, min2);
        } else if (!this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory()) {
            this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(min, min2);
            this.initRecordTimeStamp.MyBillsEntityDataFactory();
        }
        this.initRecordTimeStamp.MyBillsEntityDataFactory(canvas, colorFilter, this.getErrorConfigVersion);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return DrawableCompat.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        }
        return this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.setAlpha(i);
        } else if (this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2.getRootAlpha() != i) {
            this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.setColorFilter(colorFilter);
            return;
        }
        this.MyBillsEntityDataFactory = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return DrawableCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        }
        return this.MyBillsEntityDataFactory;
    }

    PorterDuffColorFilter MyBillsEntityDataFactory(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.initRecordTimeStamp;
        if (vectorDrawableCompatState.moveToNextValue != colorStateList) {
            vectorDrawableCompatState.moveToNextValue = colorStateList;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, colorStateList, vectorDrawableCompatState.initRecordTimeStamp);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.initRecordTimeStamp;
        if (vectorDrawableCompatState.initRecordTimeStamp != mode) {
            vectorDrawableCompatState.initRecordTimeStamp = mode;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, vectorDrawableCompatState.moveToNextValue, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.isStateful();
        }
        return super.isStateful() || ((vectorDrawableCompatState = this.initRecordTimeStamp) != null && (vectorDrawableCompatState.KClassImpl$Data$declaredNonStaticMembers$2() || (this.initRecordTimeStamp.moveToNextValue != null && this.initRecordTimeStamp.moveToNextValue.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.initRecordTimeStamp;
        boolean z = false;
        if (vectorDrawableCompatState.moveToNextValue != null && vectorDrawableCompatState.initRecordTimeStamp != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, vectorDrawableCompatState.moveToNextValue, vectorDrawableCompatState.initRecordTimeStamp);
            invalidateSelf();
            z = true;
        }
        if (vectorDrawableCompatState.KClassImpl$Data$declaredNonStaticMembers$2() && vectorDrawableCompatState.getAuthRequestContext(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getIntrinsicWidth();
        }
        return (int) this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getIntrinsicHeight();
        }
        return (int) this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return DrawableCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(this.BuiltInFictitiousFunctionClassFactory);
        }
        return this.initRecordTimeStamp.getAuthRequestContext;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, z);
        } else {
            this.initRecordTimeStamp.getAuthRequestContext = z;
        }
    }

    public static VectorDrawableCompat MyBillsEntityDataFactory(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.BuiltInFictitiousFunctionClassFactory = ResourcesCompat.BuiltInFictitiousFunctionClassFactory(resources, i, theme);
            vectorDrawableCompat.getAuthRequestContext = new VectorDrawableDelegateState(vectorDrawableCompat.BuiltInFictitiousFunctionClassFactory.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return BuiltInFictitiousFunctionClassFactory(resources, xml, asAttributeSet, theme);
        } catch (IOException e) {
            InstrumentInjector.log_e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            InstrumentInjector.log_e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static VectorDrawableCompat BuiltInFictitiousFunctionClassFactory(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    static int MyBillsEntityDataFactory(int i, float f) {
        return (((int) (Color.alpha(i) * f)) << 24) | (16777215 & i);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.initRecordTimeStamp;
        vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2 = new VPathRenderer();
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.NetworkUserEntityData$$ExternalSyntheticLambda1);
        BuiltInFictitiousFunctionClassFactory(authRequestContext, xmlPullParser, theme);
        authRequestContext.recycle();
        vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0 = getChangingConfigurations();
        vectorDrawableCompatState.PlaceComponentResult = true;
        getAuthRequestContext(resources, xmlPullParser, attributeSet, theme);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, vectorDrawableCompatState.moveToNextValue, vectorDrawableCompatState.initRecordTimeStamp);
    }

    private static PorterDuff.Mode PlaceComponentResult(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i == 9) {
                    return PorterDuff.Mode.SRC_ATOP;
                }
                switch (i) {
                    case 14:
                        return PorterDuff.Mode.MULTIPLY;
                    case 15:
                        return PorterDuff.Mode.SCREEN;
                    case 16:
                        return PorterDuff.Mode.ADD;
                    default:
                        return mode;
                }
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void BuiltInFictitiousFunctionClassFactory(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.initRecordTimeStamp;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2;
        vectorDrawableCompatState.initRecordTimeStamp = PlaceComponentResult(TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList authRequestContext = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, theme, "tint");
        if (authRequestContext != null) {
            vectorDrawableCompatState.moveToNextValue = authRequestContext;
        }
        vectorDrawableCompatState.getAuthRequestContext = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.getAuthRequestContext);
        vPathRenderer.DatabaseTableConfigUtil = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.DatabaseTableConfigUtil);
        vPathRenderer.scheduleImpl = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.scheduleImpl);
        if (vPathRenderer.DatabaseTableConfigUtil <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append(typedArray.getPositionDescription());
            sb.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(sb.toString());
        } else if (vPathRenderer.scheduleImpl <= 0.0f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(typedArray.getPositionDescription());
            sb2.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(sb2.toString());
        } else {
            vPathRenderer.MyBillsEntityDataFactory = typedArray.getDimension(3, vPathRenderer.MyBillsEntityDataFactory);
            vPathRenderer.getAuthRequestContext = typedArray.getDimension(2, vPathRenderer.getAuthRequestContext);
            if (vPathRenderer.MyBillsEntityDataFactory <= 0.0f) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(typedArray.getPositionDescription());
                sb3.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(sb3.toString());
            } else if (vPathRenderer.getAuthRequestContext <= 0.0f) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(typedArray.getPositionDescription());
                sb4.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(sb4.toString());
            } else {
                vPathRenderer.setAlpha(TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.getErrorConfigVersion = string;
                    vPathRenderer.NetworkUserEntityData$$ExternalSyntheticLambda0.put(string, vPathRenderer);
                }
            }
        }
    }

    private void getAuthRequestContext(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.initRecordTimeStamp;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.lookAheadTest);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth();
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth + 1 || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.BuiltInFictitiousFunctionClassFactory(resources, attributeSet, theme, xmlPullParser);
                    vGroup.BuiltInFictitiousFunctionClassFactory.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.NetworkUserEntityData$$ExternalSyntheticLambda0.put(vFullPath.getPathName(), vFullPath);
                    }
                    z = false;
                    vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0 = vFullPath.NetworkUserEntityData$$ExternalSyntheticLambda2 | vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.KClassImpl$Data$declaredNonStaticMembers$2(resources, attributeSet, theme, xmlPullParser);
                    vGroup.BuiltInFictitiousFunctionClassFactory.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.NetworkUserEntityData$$ExternalSyntheticLambda0.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0 = vClipPath.NetworkUserEntityData$$ExternalSyntheticLambda2 | vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else if ("group".equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.PlaceComponentResult(resources, attributeSet, theme, xmlPullParser);
                    vGroup.BuiltInFictitiousFunctionClassFactory.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.NetworkUserEntityData$$ExternalSyntheticLambda0.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0 = vGroup2.getAuthRequestContext | vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult(boolean z) {
        this.PlaceComponentResult = z;
    }

    private boolean MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.PlaceComponentResult(this) == 1;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.initRecordTimeStamp.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* loaded from: classes.dex */
    static class VectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState KClassImpl$Data$declaredNonStaticMembers$2;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.BuiltInFictitiousFunctionClassFactory = (VectorDrawable) this.KClassImpl$Data$declaredNonStaticMembers$2.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.BuiltInFictitiousFunctionClassFactory = (VectorDrawable) this.KClassImpl$Data$declaredNonStaticMembers$2.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.BuiltInFictitiousFunctionClassFactory = (VectorDrawable) this.KClassImpl$Data$declaredNonStaticMembers$2.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getChangingConfigurations();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class VectorDrawableCompatState extends Drawable.ConstantState {
        Bitmap BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        VPathRenderer NetworkUserEntityData$$ExternalSyntheticLambda2;
        boolean PlaceComponentResult;
        boolean getAuthRequestContext;
        PorterDuff.Mode getErrorConfigVersion;
        PorterDuff.Mode initRecordTimeStamp;
        Paint lookAheadTest;
        ColorStateList moveToNextValue;
        ColorStateList scheduleImpl;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.moveToNextValue = null;
            this.initRecordTimeStamp = VectorDrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            if (vectorDrawableCompatState != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda0;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new VPathRenderer(vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2);
                if (vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2 = new Paint(vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = new Paint(vectorDrawableCompatState.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue);
                }
                this.moveToNextValue = vectorDrawableCompatState.moveToNextValue;
                this.initRecordTimeStamp = vectorDrawableCompatState.initRecordTimeStamp;
                this.getAuthRequestContext = vectorDrawableCompatState.getAuthRequestContext;
            }
        }

        public void MyBillsEntityDataFactory(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.BuiltInFictitiousFunctionClassFactory, (Rect) null, rect, KClassImpl$Data$declaredNonStaticMembers$2(colorFilter));
        }

        public boolean getAuthRequestContext() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2.getRootAlpha() < 255;
        }

        public Paint KClassImpl$Data$declaredNonStaticMembers$2(ColorFilter colorFilter) {
            if (getAuthRequestContext() || colorFilter != null) {
                if (this.lookAheadTest == null) {
                    Paint paint = new Paint();
                    this.lookAheadTest = paint;
                    paint.setFilterBitmap(true);
                }
                this.lookAheadTest.setAlpha(this.NetworkUserEntityData$$ExternalSyntheticLambda2.getRootAlpha());
                this.lookAheadTest.setColorFilter(colorFilter);
                return this.lookAheadTest;
            }
            return null;
        }

        public void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            this.BuiltInFictitiousFunctionClassFactory.eraseColor(0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory(new Canvas(this.BuiltInFictitiousFunctionClassFactory), i, i2, null);
        }

        public void MyBillsEntityDataFactory(int i, int i2) {
            if (this.BuiltInFictitiousFunctionClassFactory == null || !KClassImpl$Data$declaredNonStaticMembers$2(i, i2)) {
                this.BuiltInFictitiousFunctionClassFactory = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.PlaceComponentResult = true;
            }
        }

        public boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            return i == this.BuiltInFictitiousFunctionClassFactory.getWidth() && i2 == this.BuiltInFictitiousFunctionClassFactory.getHeight();
        }

        public boolean BuiltInFictitiousFunctionClassFactory() {
            return !this.PlaceComponentResult && this.scheduleImpl == this.moveToNextValue && this.getErrorConfigVersion == this.initRecordTimeStamp && this.KClassImpl$Data$declaredNonStaticMembers$2 == this.getAuthRequestContext && this.MyBillsEntityDataFactory == this.NetworkUserEntityData$$ExternalSyntheticLambda2.getRootAlpha();
        }

        public void MyBillsEntityDataFactory() {
            this.scheduleImpl = this.moveToNextValue;
            this.getErrorConfigVersion = this.initRecordTimeStamp;
            this.MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getRootAlpha();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext;
            this.PlaceComponentResult = false;
        }

        public VectorDrawableCompatState() {
            this.moveToNextValue = null;
            this.initRecordTimeStamp = VectorDrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new VPathRenderer();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory();
        }

        public boolean getAuthRequestContext(int[] iArr) {
            boolean BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory(iArr);
            this.PlaceComponentResult |= BuiltInFictitiousFunctionClassFactory;
            return BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class VPathRenderer {
        private static final Matrix NetworkUserEntityData$$ExternalSyntheticLambda1 = new Matrix();
        Boolean BuiltInFictitiousFunctionClassFactory;
        float DatabaseTableConfigUtil;
        private final Matrix GetContactSyncConfig;
        Paint KClassImpl$Data$declaredNonStaticMembers$2;
        float MyBillsEntityDataFactory;
        final ArrayMap<String, Object> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final Path NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final Path NetworkUserEntityData$$ExternalSyntheticLambda8;
        int PlaceComponentResult;
        float getAuthRequestContext;
        String getErrorConfigVersion;
        private int initRecordTimeStamp;
        final VGroup lookAheadTest;
        Paint moveToNextValue;
        private PathMeasure newProxyInstance;
        float scheduleImpl;

        private static float getAuthRequestContext(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public VPathRenderer() {
            this.GetContactSyncConfig = new Matrix();
            this.MyBillsEntityDataFactory = 0.0f;
            this.getAuthRequestContext = 0.0f;
            this.DatabaseTableConfigUtil = 0.0f;
            this.scheduleImpl = 0.0f;
            this.PlaceComponentResult = 255;
            this.getErrorConfigVersion = null;
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayMap<>();
            this.lookAheadTest = new VGroup();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Path();
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Path();
        }

        public void setRootAlpha(int i) {
            this.PlaceComponentResult = i;
        }

        public int getRootAlpha() {
            return this.PlaceComponentResult;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.GetContactSyncConfig = new Matrix();
            this.MyBillsEntityDataFactory = 0.0f;
            this.getAuthRequestContext = 0.0f;
            this.DatabaseTableConfigUtil = 0.0f;
            this.scheduleImpl = 0.0f;
            this.PlaceComponentResult = 255;
            this.getErrorConfigVersion = null;
            this.BuiltInFictitiousFunctionClassFactory = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arrayMap;
            this.lookAheadTest = new VGroup(vPathRenderer.lookAheadTest, arrayMap);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Path(vPathRenderer.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Path(vPathRenderer.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.MyBillsEntityDataFactory = vPathRenderer.MyBillsEntityDataFactory;
            this.getAuthRequestContext = vPathRenderer.getAuthRequestContext;
            this.DatabaseTableConfigUtil = vPathRenderer.DatabaseTableConfigUtil;
            this.scheduleImpl = vPathRenderer.scheduleImpl;
            this.initRecordTimeStamp = vPathRenderer.initRecordTimeStamp;
            this.PlaceComponentResult = vPathRenderer.PlaceComponentResult;
            this.getErrorConfigVersion = vPathRenderer.getErrorConfigVersion;
            String str = vPathRenderer.getErrorConfigVersion;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.BuiltInFictitiousFunctionClassFactory = vPathRenderer.BuiltInFictitiousFunctionClassFactory;
        }

        private void PlaceComponentResult(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            vGroup.KClassImpl$Data$declaredNonStaticMembers$2.set(matrix);
            vGroup.KClassImpl$Data$declaredNonStaticMembers$2.preConcat(vGroup.PlaceComponentResult);
            canvas.save();
            for (int i3 = 0; i3 < vGroup.BuiltInFictitiousFunctionClassFactory.size(); i3++) {
                VObject vObject = vGroup.BuiltInFictitiousFunctionClassFactory.get(i3);
                if (vObject instanceof VGroup) {
                    PlaceComponentResult((VGroup) vObject, vGroup.KClassImpl$Data$declaredNonStaticMembers$2, canvas, i, i2, colorFilter);
                } else if (vObject instanceof VPath) {
                    BuiltInFictitiousFunctionClassFactory(vGroup, (VPath) vObject, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void MyBillsEntityDataFactory(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            PlaceComponentResult(this.lookAheadTest, NetworkUserEntityData$$ExternalSyntheticLambda1, canvas, i, i2, colorFilter);
        }

        private void BuiltInFictitiousFunctionClassFactory(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f;
            float f2 = i / this.DatabaseTableConfigUtil;
            float f3 = i2 / this.scheduleImpl;
            float min = Math.min(f2, f3);
            Matrix matrix = vGroup.KClassImpl$Data$declaredNonStaticMembers$2;
            this.GetContactSyncConfig.set(matrix);
            this.GetContactSyncConfig.postScale(f2, f3);
            float MyBillsEntityDataFactory = MyBillsEntityDataFactory(matrix);
            if (MyBillsEntityDataFactory == 0.0f) {
                return;
            }
            vPath.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            Path path = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.reset();
            if (vPath.MyBillsEntityDataFactory()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setFillType(vPath.initRecordTimeStamp == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.addPath(path, this.GetContactSyncConfig);
                canvas.clipPath(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            if (vFullPath.DatabaseTableConfigUtil != 0.0f || vFullPath.NetworkUserEntityData$$ExternalSyntheticLambda0 != 1.0f) {
                float f4 = vFullPath.DatabaseTableConfigUtil;
                float f5 = vFullPath.moveToNextValue;
                float f6 = vFullPath.NetworkUserEntityData$$ExternalSyntheticLambda0;
                float f7 = vFullPath.moveToNextValue;
                if (this.newProxyInstance == null) {
                    this.newProxyInstance = new PathMeasure();
                }
                this.newProxyInstance.setPath(this.NetworkUserEntityData$$ExternalSyntheticLambda2, false);
                float length = this.newProxyInstance.getLength();
                float f8 = ((f4 + f5) % 1.0f) * length;
                float f9 = ((f6 + f7) % 1.0f) * length;
                path.reset();
                if (f8 > f9) {
                    this.newProxyInstance.getSegment(f8, length, path, true);
                    f = 0.0f;
                    this.newProxyInstance.getSegment(0.0f, f9, path, true);
                } else {
                    f = 0.0f;
                    this.newProxyInstance.getSegment(f8, f9, path, true);
                }
                path.rLineTo(f, f);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.addPath(path, this.GetContactSyncConfig);
            if (vFullPath.PlaceComponentResult.MyBillsEntityDataFactory()) {
                ComplexColorCompat complexColorCompat = vFullPath.PlaceComponentResult;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    Paint paint = new Paint(1);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (complexColorCompat.BuiltInFictitiousFunctionClassFactory()) {
                    Shader authRequestContext = complexColorCompat.getAuthRequestContext();
                    authRequestContext.setLocalMatrix(this.GetContactSyncConfig);
                    paint2.setShader(authRequestContext);
                    paint2.setAlpha(Math.round(vFullPath.KClassImpl$Data$declaredNonStaticMembers$2 * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(VectorDrawableCompat.MyBillsEntityDataFactory(complexColorCompat.KClassImpl$Data$declaredNonStaticMembers$2(), vFullPath.KClassImpl$Data$declaredNonStaticMembers$2));
                }
                paint2.setColorFilter(colorFilter);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setFillType(vFullPath.initRecordTimeStamp == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda8, paint2);
            }
            if (vFullPath.getAuthRequestContext.MyBillsEntityDataFactory()) {
                ComplexColorCompat complexColorCompat2 = vFullPath.getAuthRequestContext;
                if (this.moveToNextValue == null) {
                    Paint paint3 = new Paint(1);
                    this.moveToNextValue = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.moveToNextValue;
                if (vFullPath.lookAheadTest != null) {
                    paint4.setStrokeJoin(vFullPath.lookAheadTest);
                }
                if (vFullPath.BuiltInFictitiousFunctionClassFactory != null) {
                    paint4.setStrokeCap(vFullPath.BuiltInFictitiousFunctionClassFactory);
                }
                paint4.setStrokeMiter(vFullPath.getErrorConfigVersion);
                if (complexColorCompat2.BuiltInFictitiousFunctionClassFactory()) {
                    Shader authRequestContext2 = complexColorCompat2.getAuthRequestContext();
                    authRequestContext2.setLocalMatrix(this.GetContactSyncConfig);
                    paint4.setShader(authRequestContext2);
                    paint4.setAlpha(Math.round(vFullPath.MyBillsEntityDataFactory * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(VectorDrawableCompat.MyBillsEntityDataFactory(complexColorCompat2.KClassImpl$Data$declaredNonStaticMembers$2(), vFullPath.MyBillsEntityDataFactory));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(vFullPath.scheduleImpl * min * MyBillsEntityDataFactory);
                canvas.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda8, paint4);
            }
        }

        private float MyBillsEntityDataFactory(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float authRequestContext = getAuthRequestContext(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(authRequestContext) / max;
            }
            return 0.0f;
        }

        public boolean BuiltInFictitiousFunctionClassFactory() {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = Boolean.valueOf(this.lookAheadTest.getAuthRequestContext());
            }
            return this.BuiltInFictitiousFunctionClassFactory.booleanValue();
        }

        public boolean BuiltInFictitiousFunctionClassFactory(int[] iArr) {
            return this.lookAheadTest.MyBillsEntityDataFactory(iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class VObject {
        public boolean MyBillsEntityDataFactory(int[] iArr) {
            return false;
        }

        public boolean getAuthRequestContext() {
            return false;
        }

        private VObject() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class VGroup extends VObject {
        final ArrayList<VObject> BuiltInFictitiousFunctionClassFactory;
        private float DatabaseTableConfigUtil;
        private float GetContactSyncConfig;
        final Matrix KClassImpl$Data$declaredNonStaticMembers$2;
        float MyBillsEntityDataFactory;
        private float NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Matrix PlaceComponentResult;
        int getAuthRequestContext;
        private float getErrorConfigVersion;
        private int[] initRecordTimeStamp;
        private float lookAheadTest;
        private float moveToNextValue;
        private String scheduleImpl;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VPath vClipPath;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Matrix();
            this.BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
            this.MyBillsEntityDataFactory = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
            this.lookAheadTest = 0.0f;
            this.getErrorConfigVersion = 1.0f;
            this.moveToNextValue = 1.0f;
            this.GetContactSyncConfig = 0.0f;
            this.DatabaseTableConfigUtil = 0.0f;
            Matrix matrix = new Matrix();
            this.PlaceComponentResult = matrix;
            this.scheduleImpl = null;
            this.MyBillsEntityDataFactory = vGroup.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = vGroup.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.lookAheadTest = vGroup.lookAheadTest;
            this.getErrorConfigVersion = vGroup.getErrorConfigVersion;
            this.moveToNextValue = vGroup.moveToNextValue;
            this.GetContactSyncConfig = vGroup.GetContactSyncConfig;
            this.DatabaseTableConfigUtil = vGroup.DatabaseTableConfigUtil;
            this.initRecordTimeStamp = vGroup.initRecordTimeStamp;
            String str = vGroup.scheduleImpl;
            this.scheduleImpl = str;
            this.getAuthRequestContext = vGroup.getAuthRequestContext;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.PlaceComponentResult);
            ArrayList<VObject> arrayList = vGroup.BuiltInFictitiousFunctionClassFactory;
            for (int i = 0; i < arrayList.size(); i++) {
                VObject vObject = arrayList.get(i);
                if (vObject instanceof VGroup) {
                    this.BuiltInFictitiousFunctionClassFactory.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vClipPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.BuiltInFictitiousFunctionClassFactory.add(vClipPath);
                    if (vClipPath.GetContactSyncConfig != null) {
                        arrayMap.put(vClipPath.GetContactSyncConfig, vClipPath);
                    }
                }
            }
        }

        public VGroup() {
            super();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Matrix();
            this.BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
            this.MyBillsEntityDataFactory = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
            this.lookAheadTest = 0.0f;
            this.getErrorConfigVersion = 1.0f;
            this.moveToNextValue = 1.0f;
            this.GetContactSyncConfig = 0.0f;
            this.DatabaseTableConfigUtil = 0.0f;
            this.PlaceComponentResult = new Matrix();
            this.scheduleImpl = null;
        }

        public String getGroupName() {
            return this.scheduleImpl;
        }

        public Matrix getLocalMatrix() {
            return this.PlaceComponentResult;
        }

        public void PlaceComponentResult(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.scheduleImpl);
            BuiltInFictitiousFunctionClassFactory(authRequestContext, xmlPullParser);
            authRequestContext.recycle();
        }

        private void BuiltInFictitiousFunctionClassFactory(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.initRecordTimeStamp = null;
            this.MyBillsEntityDataFactory = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "rotation", 5, this.MyBillsEntityDataFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getFloat(1, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.lookAheadTest = typedArray.getFloat(2, this.lookAheadTest);
            this.getErrorConfigVersion = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "scaleX", 3, this.getErrorConfigVersion);
            this.moveToNextValue = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "scaleY", 4, this.moveToNextValue);
            this.GetContactSyncConfig = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "translateX", 6, this.GetContactSyncConfig);
            this.DatabaseTableConfigUtil = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "translateY", 7, this.DatabaseTableConfigUtil);
            String string = typedArray.getString(0);
            if (string != null) {
                this.scheduleImpl = string;
            }
            PlaceComponentResult();
        }

        private void PlaceComponentResult() {
            this.PlaceComponentResult.reset();
            this.PlaceComponentResult.postTranslate(-this.NetworkUserEntityData$$ExternalSyntheticLambda0, -this.lookAheadTest);
            this.PlaceComponentResult.postScale(this.getErrorConfigVersion, this.moveToNextValue);
            this.PlaceComponentResult.postRotate(this.MyBillsEntityDataFactory, 0.0f, 0.0f);
            this.PlaceComponentResult.postTranslate(this.GetContactSyncConfig + this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.DatabaseTableConfigUtil + this.lookAheadTest);
        }

        public float getRotation() {
            return this.MyBillsEntityDataFactory;
        }

        public void setRotation(float f) {
            if (f != this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = f;
                PlaceComponentResult();
            }
        }

        public float getPivotX() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        public void setPivotX(float f) {
            if (f != this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
                PlaceComponentResult();
            }
        }

        public float getPivotY() {
            return this.lookAheadTest;
        }

        public void setPivotY(float f) {
            if (f != this.lookAheadTest) {
                this.lookAheadTest = f;
                PlaceComponentResult();
            }
        }

        public float getScaleX() {
            return this.getErrorConfigVersion;
        }

        public void setScaleX(float f) {
            if (f != this.getErrorConfigVersion) {
                this.getErrorConfigVersion = f;
                PlaceComponentResult();
            }
        }

        public float getScaleY() {
            return this.moveToNextValue;
        }

        public void setScaleY(float f) {
            if (f != this.moveToNextValue) {
                this.moveToNextValue = f;
                PlaceComponentResult();
            }
        }

        public float getTranslateX() {
            return this.GetContactSyncConfig;
        }

        public void setTranslateX(float f) {
            if (f != this.GetContactSyncConfig) {
                this.GetContactSyncConfig = f;
                PlaceComponentResult();
            }
        }

        public float getTranslateY() {
            return this.DatabaseTableConfigUtil;
        }

        public void setTranslateY(float f) {
            if (f != this.DatabaseTableConfigUtil) {
                this.DatabaseTableConfigUtil = f;
                PlaceComponentResult();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean getAuthRequestContext() {
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.size(); i++) {
                if (this.BuiltInFictitiousFunctionClassFactory.get(i).getAuthRequestContext()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean MyBillsEntityDataFactory(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.size(); i++) {
                z |= this.BuiltInFictitiousFunctionClassFactory.get(i).MyBillsEntityDataFactory(iArr);
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class VPath extends VObject {
        String GetContactSyncConfig;
        protected PathParser.PathDataNode[] NetworkUserEntityData$$ExternalSyntheticLambda1;
        int NetworkUserEntityData$$ExternalSyntheticLambda2;
        int initRecordTimeStamp;

        public boolean MyBillsEntityDataFactory() {
            return false;
        }

        public VPath() {
            super();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
            this.initRecordTimeStamp = 0;
        }

        public VPath(VPath vPath) {
            super();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
            this.initRecordTimeStamp = 0;
            this.GetContactSyncConfig = vPath.GetContactSyncConfig;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = vPath.NetworkUserEntityData$$ExternalSyntheticLambda2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PathParser.PlaceComponentResult(vPath.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.MyBillsEntityDataFactory(pathDataNodeArr, path);
            }
        }

        public String getPathName() {
            return this.GetContactSyncConfig;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, pathDataNodeArr)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PathParser.PlaceComponentResult(pathDataNodeArr);
            } else {
                PathParser.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, pathDataNodeArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class VClipPath extends VPath {
        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean MyBillsEntityDataFactory() {
            return true;
        }

        VClipPath() {
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "pathData")) {
                TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.getErrorConfigVersion);
                KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser);
                authRequestContext.recycle();
            }
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.GetContactSyncConfig = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PathParser.KClassImpl$Data$declaredNonStaticMembers$2(string2);
            }
            this.initRecordTimeStamp = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class VFullPath extends VPath {
        Paint.Cap BuiltInFictitiousFunctionClassFactory;
        float DatabaseTableConfigUtil;
        float KClassImpl$Data$declaredNonStaticMembers$2;
        float MyBillsEntityDataFactory;
        float NetworkUserEntityData$$ExternalSyntheticLambda0;
        ComplexColorCompat PlaceComponentResult;
        ComplexColorCompat getAuthRequestContext;
        float getErrorConfigVersion;
        private int[] isLayoutRequested;
        Paint.Join lookAheadTest;
        float moveToNextValue;
        float scheduleImpl;

        VFullPath() {
            this.scheduleImpl = 0.0f;
            this.MyBillsEntityDataFactory = 1.0f;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
            this.DatabaseTableConfigUtil = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1.0f;
            this.moveToNextValue = 0.0f;
            this.BuiltInFictitiousFunctionClassFactory = Paint.Cap.BUTT;
            this.lookAheadTest = Paint.Join.MITER;
            this.getErrorConfigVersion = 4.0f;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.scheduleImpl = 0.0f;
            this.MyBillsEntityDataFactory = 1.0f;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
            this.DatabaseTableConfigUtil = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1.0f;
            this.moveToNextValue = 0.0f;
            this.BuiltInFictitiousFunctionClassFactory = Paint.Cap.BUTT;
            this.lookAheadTest = Paint.Join.MITER;
            this.getErrorConfigVersion = 4.0f;
            this.isLayoutRequested = vFullPath.isLayoutRequested;
            this.getAuthRequestContext = vFullPath.getAuthRequestContext;
            this.scheduleImpl = vFullPath.scheduleImpl;
            this.MyBillsEntityDataFactory = vFullPath.MyBillsEntityDataFactory;
            this.PlaceComponentResult = vFullPath.PlaceComponentResult;
            this.initRecordTimeStamp = vFullPath.initRecordTimeStamp;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = vFullPath.KClassImpl$Data$declaredNonStaticMembers$2;
            this.DatabaseTableConfigUtil = vFullPath.DatabaseTableConfigUtil;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = vFullPath.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.moveToNextValue = vFullPath.moveToNextValue;
            this.BuiltInFictitiousFunctionClassFactory = vFullPath.BuiltInFictitiousFunctionClassFactory;
            this.lookAheadTest = vFullPath.lookAheadTest;
            this.getErrorConfigVersion = vFullPath.getErrorConfigVersion;
        }

        private Paint.Cap PlaceComponentResult(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join MyBillsEntityDataFactory(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        public void BuiltInFictitiousFunctionClassFactory(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.initRecordTimeStamp);
            PlaceComponentResult(authRequestContext, xmlPullParser, theme);
            authRequestContext.recycle();
        }

        private void PlaceComponentResult(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.isLayoutRequested = null;
            if (TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.GetContactSyncConfig = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PathParser.KClassImpl$Data$declaredNonStaticMembers$2(string2);
                }
                this.PlaceComponentResult = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, theme, "fillColor", 1);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "fillAlpha", 12, this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult(TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.BuiltInFictitiousFunctionClassFactory);
                this.lookAheadTest = MyBillsEntityDataFactory(TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.lookAheadTest);
                this.getErrorConfigVersion = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.getErrorConfigVersion);
                this.getAuthRequestContext = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, theme, "strokeColor", 3);
                this.MyBillsEntityDataFactory = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "strokeAlpha", 11, this.MyBillsEntityDataFactory);
                this.scheduleImpl = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "strokeWidth", 4, this.scheduleImpl);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "trimPathEnd", 6, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                this.moveToNextValue = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "trimPathOffset", 7, this.moveToNextValue);
                this.DatabaseTableConfigUtil = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "trimPathStart", 5, this.DatabaseTableConfigUtil);
                this.initRecordTimeStamp = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "fillType", 13, this.initRecordTimeStamp);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean getAuthRequestContext() {
            return this.PlaceComponentResult.PlaceComponentResult() || this.getAuthRequestContext.PlaceComponentResult();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean MyBillsEntityDataFactory(int[] iArr) {
            return this.getAuthRequestContext.MyBillsEntityDataFactory(iArr) | this.PlaceComponentResult.MyBillsEntityDataFactory(iArr);
        }

        int getStrokeColor() {
            return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        void setStrokeColor(int i) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        float getStrokeWidth() {
            return this.scheduleImpl;
        }

        void setStrokeWidth(float f) {
            this.scheduleImpl = f;
        }

        float getStrokeAlpha() {
            return this.MyBillsEntityDataFactory;
        }

        void setStrokeAlpha(float f) {
            this.MyBillsEntityDataFactory = f;
        }

        int getFillColor() {
            return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        void setFillColor(int i) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        float getFillAlpha() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        void setFillAlpha(float f) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        }

        float getTrimPathStart() {
            return this.DatabaseTableConfigUtil;
        }

        void setTrimPathStart(float f) {
            this.DatabaseTableConfigUtil = f;
        }

        float getTrimPathEnd() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        void setTrimPathEnd(float f) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
        }

        float getTrimPathOffset() {
            return this.moveToNextValue;
        }

        void setTrimPathOffset(float f) {
            this.moveToNextValue = f;
        }
    }
}
