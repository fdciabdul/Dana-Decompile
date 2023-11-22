package id.dana.richview.imageview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ScaleGestureDetectorCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u0001:\u0002bcB%\u0012\u0006\u0010\\\u001a\u00020[\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010]\u0012\b\b\u0002\u0010_\u001a\u00020\u0002¢\u0006\u0004\b`\u0010aJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\u001cJ\u0019\u0010,\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0016R\u0014\u0010\u000e\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00107R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00109R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010:R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00109R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00109R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010:R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010>\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010DR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010F\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u00109R\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00109R\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010:R\u0018\u0010J\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u00109R\u0016\u0010M\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010<R\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010TR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00109R\u0016\u0010U\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010GR\u0016\u0010Z\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010T"}, d2 = {"Lid/dana/richview/imageview/ZoomableImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "p0", "", "p1", "Landroid/animation/ValueAnimator;", "MyBillsEntityDataFactory", "(IF)Landroid/animation/ValueAnimator;", "Landroid/graphics/Matrix;", "", "PlaceComponentResult", "(Landroid/graphics/Matrix;I)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "getAuthRequestContext", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "reset", "()V", "doubleTapToZoomScaleFactor", "setDoubleTapToZoomScaleFactor", "(F)V", "durationAnimationReset", "setDurationAnimationReset", "(I)V", "enabled", "setEnabled", "(Z)V", "Landroid/graphics/Bitmap;", "bm", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "resId", "setImageResource", "Landroid/net/Uri;", "uri", "setImageURI", "(Landroid/net/Uri;)V", "minScale", "maxScale", "setScaleRange", "(FF)V", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "BuiltInFictitiousFunctionClassFactory", LogConstants.RESULT_FALSE, "I", "scheduleImpl", "Z", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/GestureDetector;", "moveToNextValue", "Landroid/view/GestureDetector;", "Landroid/graphics/PointF;", "Landroid/graphics/PointF;", "", "initRecordTimeStamp", "[F", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "Landroid/animation/ValueAnimator;", "isLayoutRequested", "PrepareContext", "Landroid/view/ScaleGestureDetector;", "newProxyInstance", "Landroid/view/ScaleGestureDetector;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Landroid/graphics/Matrix;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Landroid/widget/ImageView$ScaleType;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "SimpleAnimatorListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ZoomableImageView extends AppCompatImageView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private float PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private float NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private ValueAnimator NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final RectF KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private float initRecordTimeStamp;
    private ImageView.ScaleType NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private Matrix FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private float newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private float MyBillsEntityDataFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private Matrix NetworkUserEntityData$$ExternalSyntheticLambda8;
    public Map<Integer, View> _$_findViewCache;
    private float getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private PointF lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private float[] DatabaseTableConfigUtil;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private float PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private GestureDetector moveToNextValue;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private ScaleGestureDetector isLayoutRequested;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006"}, d2 = {"Lid/dana/richview/imageview/ZoomableImageView$SimpleAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationCancel", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    static class SimpleAnimatorListener implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZoomableImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.95f;
        this.initRecordTimeStamp = 10.0f;
        this.MyBillsEntityDataFactory = 0.95f;
        this.PlaceComponentResult = 10.0f;
        this.isLayoutRequested = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: id.dana.richview.imageview.ZoomableImageView$scaleGestureListener$1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public final boolean onScaleBegin(ScaleGestureDetector p0) {
                float[] fArr;
                Intrinsics.checkNotNullParameter(p0, "");
                ZoomableImageView zoomableImageView = ZoomableImageView.this;
                fArr = zoomableImageView.DatabaseTableConfigUtil;
                zoomableImageView.newProxyInstance = fArr[0];
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public final void onScaleEnd(ScaleGestureDetector p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ZoomableImageView.this.PrepareContext = 1.0f;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public final boolean onScale(ScaleGestureDetector p0) {
                float f;
                float[] fArr;
                float f2;
                float[] fArr2;
                float f3;
                float f4;
                float f5;
                float[] fArr3;
                float f6;
                float[] fArr4;
                Intrinsics.checkNotNullParameter(p0, "");
                ZoomableImageView zoomableImageView = ZoomableImageView.this;
                f = zoomableImageView.newProxyInstance;
                float scaleFactor = f * p0.getScaleFactor();
                fArr = ZoomableImageView.this.DatabaseTableConfigUtil;
                zoomableImageView.PrepareContext = scaleFactor / fArr[0];
                f2 = ZoomableImageView.this.PrepareContext;
                fArr2 = ZoomableImageView.this.DatabaseTableConfigUtil;
                float f7 = f2 * fArr2[0];
                f3 = ZoomableImageView.this.MyBillsEntityDataFactory;
                if (f7 >= f3) {
                    f4 = ZoomableImageView.this.PlaceComponentResult;
                    if (f7 > f4) {
                        ZoomableImageView zoomableImageView2 = ZoomableImageView.this;
                        f5 = zoomableImageView2.PlaceComponentResult;
                        fArr3 = ZoomableImageView.this.DatabaseTableConfigUtil;
                        zoomableImageView2.PrepareContext = f5 / fArr3[0];
                    }
                } else {
                    ZoomableImageView zoomableImageView3 = ZoomableImageView.this;
                    f6 = zoomableImageView3.MyBillsEntityDataFactory;
                    fArr4 = ZoomableImageView.this.DatabaseTableConfigUtil;
                    zoomableImageView3.PrepareContext = f6 / fArr4[0];
                }
                return false;
            }
        });
        this.moveToNextValue = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: id.dana.richview.imageview.ZoomableImageView$gestureListener$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ZoomableImageView.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onSingleTapConfirmed(MotionEvent p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ZoomableImageView.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTapEvent(MotionEvent p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (1 == p0.getAction()) {
                    ZoomableImageView.this.getErrorConfigVersion = true;
                }
                ZoomableImageView.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
                return false;
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Matrix();
        this.FragmentBottomSheetPaymentSettingBinding = new Matrix();
        this.DatabaseTableConfigUtil = new float[9];
        this.lookAheadTest = new PointF(0.0f, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 3.0f;
        this.PrepareContext = 1.0f;
        this.newProxyInstance = 1.0f;
        this.GetContactSyncConfig = 1;
        this.getAuthRequestContext = 1.0f;
        this.scheduleImpl = 200;
        ScaleGestureDetectorCompat.MyBillsEntityDataFactory(this.isLayoutRequested, false);
        ImageView.ScaleType scaleType = getScaleType();
        Intrinsics.checkNotNullExpressionValue(scaleType, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = scaleType;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogTncInformation_ViewBinding);
        if (obtainStyledAttributes != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getFloat(2, 0.95f);
            this.initRecordTimeStamp = obtainStyledAttributes.getFloat(1, 10.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getFloat(0, 3.0f);
            PlaceComponentResult();
            obtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ ZoomableImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void PlaceComponentResult() {
        float f = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        float f2 = this.initRecordTimeStamp;
        if (!(f < f2)) {
            throw new IllegalStateException("minScale must be less than maxScale".toString());
        }
        if (!(f >= 0.0f)) {
            throw new IllegalStateException("minScale must be greater than 0".toString());
        }
        if (!(f2 >= 0.0f)) {
            throw new IllegalStateException("maxScale must be greater than 0".toString());
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 > f2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 < f) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
        }
    }

    public final void setScaleRange(float minScale, float maxScale) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = minScale;
        this.initRecordTimeStamp = maxScale;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        PlaceComponentResult();
    }

    public final void setDoubleTapToZoomScaleFactor(float doubleTapToZoomScaleFactor) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = doubleTapToZoomScaleFactor;
        PlaceComponentResult();
    }

    public final void setDurationAnimationReset(int durationAnimationReset) {
        if (!(durationAnimationReset <= 0)) {
            throw new IllegalStateException("durationAnimationReset must be greater than 0".toString());
        }
        this.scheduleImpl = durationAnimationReset;
    }

    @Override // android.widget.ImageView
    public final void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            super.setScaleType(scaleType);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = scaleType;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        }
    }

    @Override // android.view.View
    public final void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            return;
        }
        setScaleType(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public final void setImageResource(int resId) {
        super.setImageResource(resId);
        setScaleType(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setScaleType(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public final void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        setScaleType(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public final void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setScaleType(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        if (event == null || isClickable() || !isEnabled()) {
            return super.onTouchEvent(event);
        }
        if (getScaleType() != ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new float[9];
            Matrix matrix = new Matrix(getImageMatrix());
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = matrix;
            matrix.getValues(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (fArr != null) {
                float f = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                float f2 = fArr[0];
                this.MyBillsEntityDataFactory = f * f2;
                this.PlaceComponentResult = this.initRecordTimeStamp * f2;
            }
        }
        this.BuiltInFictitiousFunctionClassFactory = event.getPointerCount();
        this.FragmentBottomSheetPaymentSettingBinding.set(getImageMatrix());
        this.FragmentBottomSheetPaymentSettingBinding.getValues(this.DatabaseTableConfigUtil);
        float[] fArr2 = this.DatabaseTableConfigUtil;
        if (getDrawable() != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.set(fArr2[2], fArr2[5], (r2.getIntrinsicWidth() * fArr2[0]) + fArr2[2], (r2.getIntrinsicHeight() * fArr2[4]) + fArr2[5]);
        }
        this.isLayoutRequested.onTouchEvent(event);
        this.moveToNextValue.onTouchEvent(event);
        if (!this.getErrorConfigVersion) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
                if (event.getActionMasked() == 0 || this.BuiltInFictitiousFunctionClassFactory != this.GetContactSyncConfig) {
                    this.lookAheadTest.set(this.isLayoutRequested.getFocusX(), this.isLayoutRequested.getFocusY());
                } else if (2 == event.getActionMasked()) {
                    float focusX = this.isLayoutRequested.getFocusX();
                    float focusY = this.isLayoutRequested.getFocusY();
                    float f3 = focusX - this.lookAheadTest.x;
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2.right + f3 < 0.0f) {
                        f3 = -this.KClassImpl$Data$declaredNonStaticMembers$2.right;
                    } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.left + f3 > getWidth()) {
                        f3 = getWidth() - this.KClassImpl$Data$declaredNonStaticMembers$2.left;
                    }
                    float f4 = focusY - this.lookAheadTest.y;
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2.bottom + f4 < 0.0f) {
                        f4 = -this.KClassImpl$Data$declaredNonStaticMembers$2.bottom;
                    } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.top + f4 > getHeight()) {
                        f4 = getHeight() - this.KClassImpl$Data$declaredNonStaticMembers$2.top;
                    }
                    this.FragmentBottomSheetPaymentSettingBinding.postTranslate(f3, f4);
                    Matrix matrix2 = this.FragmentBottomSheetPaymentSettingBinding;
                    float f5 = this.PrepareContext;
                    matrix2.postScale(f5, f5, focusX, focusY);
                    float[] fArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    if (fArr3 != null) {
                        this.getAuthRequestContext = this.DatabaseTableConfigUtil[0] / fArr3[0];
                    }
                    setImageMatrix(this.FragmentBottomSheetPaymentSettingBinding);
                    this.lookAheadTest.set(focusX, focusY);
                }
                if (1 == event.getActionMasked() || 3 == event.getActionMasked()) {
                    this.PrepareContext = 1.0f;
                    float[] fArr4 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    if (fArr4 != null) {
                        if (((this.DatabaseTableConfigUtil[0] > fArr4[0] ? 1 : (this.DatabaseTableConfigUtil[0] == fArr4[0] ? 0 : -1)) <= 0 ? fArr4 : null) != null) {
                            reset();
                        }
                    }
                    if ((getDrawable() != null ? getDrawable().getIntrinsicWidth() * this.DatabaseTableConfigUtil[0] : 0.0f) > getWidth()) {
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.left > 0.0f) {
                            MyBillsEntityDataFactory(2, 0.0f);
                        } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.right < getWidth()) {
                            MyBillsEntityDataFactory(2, (this.KClassImpl$Data$declaredNonStaticMembers$2.left + getWidth()) - this.KClassImpl$Data$declaredNonStaticMembers$2.right);
                        }
                    } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.left < 0.0f) {
                        MyBillsEntityDataFactory(2, 0.0f);
                    } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.right > getWidth()) {
                        MyBillsEntityDataFactory(2, (this.KClassImpl$Data$declaredNonStaticMembers$2.left + getWidth()) - this.KClassImpl$Data$declaredNonStaticMembers$2.right);
                    }
                    if ((getDrawable() != null ? getDrawable().getIntrinsicHeight() * this.DatabaseTableConfigUtil[4] : 0.0f) > getHeight()) {
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.top > 0.0f) {
                            MyBillsEntityDataFactory(5, 0.0f);
                        } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.bottom < getHeight()) {
                            MyBillsEntityDataFactory(5, (this.KClassImpl$Data$declaredNonStaticMembers$2.top + getHeight()) - this.KClassImpl$Data$declaredNonStaticMembers$2.bottom);
                        }
                    } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.top < 0.0f) {
                        MyBillsEntityDataFactory(5, 0.0f);
                    } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.bottom > getHeight()) {
                        MyBillsEntityDataFactory(5, (this.KClassImpl$Data$declaredNonStaticMembers$2.top + getHeight()) - this.KClassImpl$Data$declaredNonStaticMembers$2.bottom);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(KClassImpl$Data$declaredNonStaticMembers$2());
            this.GetContactSyncConfig = this.BuiltInFictitiousFunctionClassFactory;
            return true;
        }
        this.getErrorConfigVersion = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        float[] fArr5 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (fArr5 != null) {
            float f6 = fArr5[0];
            if ((this.DatabaseTableConfigUtil[0] >= this.PlaceComponentResult ? fArr5 : null) != null) {
                reset();
                return true;
            }
        }
        Matrix matrix3 = new Matrix(this.FragmentBottomSheetPaymentSettingBinding);
        float f7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        matrix3.postScale(f7, f7, this.isLayoutRequested.getFocusX(), this.isLayoutRequested.getFocusY());
        PlaceComponentResult(matrix3, this.scheduleImpl);
        return true;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory > 1 || this.getAuthRequestContext > 1.0f || getAuthRequestContext();
    }

    private final boolean getAuthRequestContext() {
        ValueAnimator valueAnimator = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    static /* synthetic */ void PlaceComponentResult$default(ZoomableImageView zoomableImageView, Matrix matrix, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 200;
        }
        zoomableImageView.PlaceComponentResult(matrix, i);
    }

    private final void PlaceComponentResult(final Matrix p0, int p1) {
        float[] fArr = new float[9];
        p0.getValues(fArr);
        final Matrix matrix = new Matrix(getImageMatrix());
        matrix.getValues(this.DatabaseTableConfigUtil);
        float f = fArr[0];
        float[] fArr2 = this.DatabaseTableConfigUtil;
        float f2 = fArr2[0];
        float f3 = fArr[4];
        float f4 = fArr2[4];
        float f5 = fArr[2];
        float f6 = fArr2[2];
        float f7 = fArr[5];
        float f8 = fArr2[5];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (ofFloat != null) {
            final float f9 = f5 - f6;
            final float f10 = f7 - f8;
            final float f11 = f - f2;
            final float f12 = f3 - f4;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.richview.imageview.ZoomableImageView$animateScaleAndTranslationToMatrix$1$1

                /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
                public final float[] PlaceComponentResult = new float[9];

                /* renamed from: moveToNextValue  reason: from kotlin metadata */
                public final Matrix BuiltInFictitiousFunctionClassFactory;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.BuiltInFictitiousFunctionClassFactory = new Matrix(ZoomableImageView.this.getImageMatrix());
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator p02) {
                    Intrinsics.checkNotNullParameter(p02, "");
                    Object animatedValue = p02.getAnimatedValue();
                    if (animatedValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    float floatValue = ((Float) animatedValue).floatValue();
                    this.BuiltInFictitiousFunctionClassFactory.set(matrix);
                    this.BuiltInFictitiousFunctionClassFactory.getValues(this.PlaceComponentResult);
                    float[] fArr3 = this.PlaceComponentResult;
                    fArr3[2] = fArr3[2] + (f9 * floatValue);
                    fArr3[5] = fArr3[5] + (f10 * floatValue);
                    fArr3[0] = fArr3[0] + (f11 * floatValue);
                    fArr3[4] = fArr3[4] + (f12 * floatValue);
                    this.BuiltInFictitiousFunctionClassFactory.setValues(fArr3);
                    ZoomableImageView.this.setImageMatrix(this.BuiltInFictitiousFunctionClassFactory);
                }
            });
            ofFloat.addListener(new SimpleAnimatorListener() { // from class: id.dana.richview.imageview.ZoomableImageView$animateScaleAndTranslationToMatrix$1$2
                @Override // id.dana.richview.imageview.ZoomableImageView.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator p02) {
                    Intrinsics.checkNotNullParameter(p02, "");
                    ZoomableImageView.this.setImageMatrix(p0);
                }
            });
            ofFloat.setDuration(p1);
            ofFloat.start();
        }
    }

    private final ValueAnimator MyBillsEntityDataFactory(final int p0, float p1) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.DatabaseTableConfigUtil[p0], p1);
        if (ofFloat != null) {
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.richview.imageview.ZoomableImageView$animateMatrixIndex$1$1
                public final float[] PlaceComponentResult = new float[9];
                public Matrix MyBillsEntityDataFactory = new Matrix();

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator p02) {
                    Intrinsics.checkNotNullParameter(p02, "");
                    this.MyBillsEntityDataFactory.set(ZoomableImageView.this.getImageMatrix());
                    this.MyBillsEntityDataFactory.getValues(this.PlaceComponentResult);
                    float[] fArr = this.PlaceComponentResult;
                    int i = p0;
                    Object animatedValue = p02.getAnimatedValue();
                    if (animatedValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    fArr[i] = ((Float) animatedValue).floatValue();
                    this.MyBillsEntityDataFactory.setValues(this.PlaceComponentResult);
                    ZoomableImageView.this.setImageMatrix(this.MyBillsEntityDataFactory);
                }
            });
            ofFloat.setDuration(this.scheduleImpl);
            ofFloat.start();
            return ofFloat;
        }
        return null;
    }

    public final void reset() {
        PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.scheduleImpl);
    }
}
