package id.dana.richview.camera;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.ComponentActivity;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;
import com.otaliastudios.cameraview.markers.DefaultAutoFocusMarker;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.richview.camera.DanaCameraAttributesHints;
import id.dana.richview.camera.DanaCameraView;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0016\u0018\u0000 02\u00020\u0001:\u000201B'\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010-B+\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010+\u001a\u00020\b\u0012\u0006\u0010.\u001a\u00020\b¢\u0006\u0004\b,\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0004R\u0016\u0010\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010(\u001a\u0004\u0018\u00010\u00168\u0005@\u0005X\u0084\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0019R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010)"}, d2 = {"Lid/dana/richview/camera/DanaCameraView;", "Lid/dana/base/BaseRichView;", "", "MyBillsEntityDataFactory", "()V", "Lcom/otaliastudios/cameraview/controls/Flash;", "getFlash", "()Lcom/otaliastudios/cameraview/controls/Flash;", "", "getLayout", "()I", "initCameraView", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "isTakingPicture", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lid/dana/richview/camera/DanaCameraView$DanaCameraListener;", "danaCameraListener", "setDanaCameraListener", "(Lid/dana/richview/camera/DanaCameraView$DanaCameraListener;)V", "setup", "", "message", "showToast", "(Ljava/lang/String;)V", "takePicture", "toggleTorch", "BuiltInFictitiousFunctionClassFactory", "I", "getAuthRequestContext", "Lid/dana/richview/camera/DanaCameraView$DanaCameraListener;", "getCameraListener", "()Lid/dana/richview/camera/DanaCameraView$DanaCameraListener;", "setCameraListener", "cameraListener", "Z", "PlaceComponentResult", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "DanaCameraListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public class DanaCameraView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private DanaCameraListener cameraListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/camera/DanaCameraView$DanaCameraListener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lcom/otaliastudios/cameraview/PictureResult;", "p0", "getAuthRequestContext", "(Lcom/otaliastudios/cameraview/PictureResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface DanaCameraListener {
        void BuiltInFictitiousFunctionClassFactory();

        void getAuthRequestContext(PictureResult p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaCameraView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_dana_camera;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = 8;
    }

    public /* synthetic */ DanaCameraView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCameraView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = 8;
    }

    @JvmName(name = "getCameraListener")
    public final DanaCameraListener getCameraListener() {
        return this.cameraListener;
    }

    @JvmName(name = "setCameraListener")
    protected final void setCameraListener(DanaCameraListener danaCameraListener) {
        this.cameraListener = danaCameraListener;
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attrs) {
        Resources.Theme theme;
        if (attrs == null || context == null || (theme = context.getTheme()) == null) {
            return;
        }
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attrs, R.styleable.i, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        if (obtainStyledAttributes.hasValue(0)) {
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(0, DanaCameraAttributesHints.ActionButton.SHOW.getVisibility()) != DanaCameraAttributesHints.ActionButton.SHOW.getVisibility() ? 8 : 0;
        }
        this.PlaceComponentResult = obtainStyledAttributes.getBoolean(1, false);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(2, false);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) baseActivity);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.richview.camera.DanaCameraView$setup$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    DanaCameraView.this.initCameraView();
                    return;
                }
                DanaCameraView.DanaCameraListener cameraListener = DanaCameraView.this.getCameraListener();
                if (cameraListener != null) {
                    cameraListener.BuiltInFictitiousFunctionClassFactory();
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        builder.PlaceComponentResult().check();
    }

    public final void initCameraView() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).setLifecycleOwner(baseActivity);
        }
        ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).open();
        ((ConstraintLayout) _$_findCachedViewById(R.id.createJavaMethod_res_0x7f0a034a)).setVisibility(this.MyBillsEntityDataFactory);
        if (this.PlaceComponentResult) {
            ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).mapGesture(Gesture.PINCH, GestureAction.ZOOM);
        }
        ((Button) _$_findCachedViewById(R.id.res_0x7f0a027c_access_setshowcaseshowing_p)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.camera.DanaCameraView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaCameraView.m2832$r8$lambda$isbGjF4U0iZme5V12SUeGB_8n4(DanaCameraView.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.ActivityPreviewImageBinding)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.camera.DanaCameraView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaCameraView.$r8$lambda$E3CGoKoCPJDcWjtcmtzdz6U8p_o(DanaCameraView.this, view);
            }
        });
        this.getAuthRequestContext = 0;
        MyBillsEntityDataFactory();
        ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).addCameraListener(new CameraListener() { // from class: id.dana.richview.camera.DanaCameraView$initCameraView$4
            @Override // com.otaliastudios.cameraview.CameraListener
            public final void onPictureTaken(PictureResult p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onPictureTaken(p0);
                DanaCameraView.DanaCameraListener cameraListener = DanaCameraView.this.getCameraListener();
                if (cameraListener != null) {
                    cameraListener.getAuthRequestContext(p0);
                }
            }

            @Override // com.otaliastudios.cameraview.CameraListener
            public final void onCameraError(CameraException p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onCameraError(p0);
                DanaCameraView.this.showToast(String.valueOf(p0.getReason()));
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DANA_CAMERA, p0.getMessage());
            }
        });
    }

    private final void MyBillsEntityDataFactory() {
        addDisposable(Observable.timer(300L, TimeUnit.MILLISECONDS, Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.richview.camera.DanaCameraView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DanaCameraView.$r8$lambda$kHGAiDdd0EPgNH2iHeLK1PwvVaI(DanaCameraView.this, (Long) obj);
            }
        }));
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        CameraOptions cameraOptions;
        CameraView cameraView = (CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView == null || (cameraOptions = cameraView.getCameraOptions()) == null) {
            return false;
        }
        return cameraOptions.lookAheadTest();
    }

    public final void showToast(String message) {
        Toast.makeText(getContext(), message, 0).show();
    }

    public final Flash getFlash() {
        Flash flash = ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).getFlash();
        Intrinsics.checkNotNullExpressionValue(flash, "");
        return flash;
    }

    public final void toggleTorch() {
        Flash flash;
        CameraView cameraView = (CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (Flash.TORCH == ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).getFlash()) {
            flash = Flash.OFF;
        } else {
            flash = Flash.TORCH;
        }
        cameraView.setFlash(flash);
    }

    public final void setDanaCameraListener(DanaCameraListener danaCameraListener) {
        Intrinsics.checkNotNullParameter(danaCameraListener, "");
        this.cameraListener = danaCameraListener;
    }

    public final void takePicture() {
        if (((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).isOpened()) {
            ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).takePicture();
        }
    }

    public final boolean isTakingPicture() {
        return ((CameraView) _$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).isTakingPicture();
    }

    public static /* synthetic */ void $r8$lambda$E3CGoKoCPJDcWjtcmtzdz6U8p_o(DanaCameraView danaCameraView, View view) {
        Intrinsics.checkNotNullParameter(danaCameraView, "");
        danaCameraView.toggleTorch();
    }

    /* renamed from: $r8$lambda$is-bGjF4U0iZme5V12SUeGB_8n4  reason: not valid java name */
    public static /* synthetic */ void m2832$r8$lambda$isbGjF4U0iZme5V12SUeGB_8n4(DanaCameraView danaCameraView, View view) {
        Intrinsics.checkNotNullParameter(danaCameraView, "");
        ((CameraView) danaCameraView._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).takePicture();
    }

    public static /* synthetic */ void $r8$lambda$kHGAiDdd0EPgNH2iHeLK1PwvVaI(DanaCameraView danaCameraView, Long l) {
        Intrinsics.checkNotNullParameter(danaCameraView, "");
        if (danaCameraView.KClassImpl$Data$declaredNonStaticMembers$2()) {
            ((CameraView) danaCameraView._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).mapGesture(Gesture.TAP, GestureAction.AUTO_FOCUS);
            if (danaCameraView.KClassImpl$Data$declaredNonStaticMembers$2) {
                ((CameraView) danaCameraView._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)).setAutoFocusMarker(new DefaultAutoFocusMarker());
                return;
            }
            return;
        }
        int i = danaCameraView.getAuthRequestContext + 1;
        danaCameraView.getAuthRequestContext = i;
        if (i < 5) {
            danaCameraView.MyBillsEntityDataFactory();
        }
    }
}
