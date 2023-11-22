package id.dana.cashier.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.OSUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0006\u0086\u0001\u0087\u0001\u0088\u0001B+\b\u0016\u0012\u0006\u0010\u007f\u001a\u00020~\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0014\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001B0\b\u0016\u0012\u0006\u0010\u007f\u001a\u00020~\u0012\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0014\u0012\u0007\u0010\u0081\u0001\u001a\u00020\u0002\u0012\u0007\u0010\u0084\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0085\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0002H\u0014¢\u0006\u0004\b'\u0010(J/\u0010-\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0014¢\u0006\u0004\b-\u0010.J\u001d\u00100\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b0\u0010(J\u0015\u00102\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0002¢\u0006\u0004\b2\u0010\u001bJ\u0015\u00104\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0002¢\u0006\u0004\b4\u0010\u001bJ\u0015\u00106\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0002¢\u0006\u0004\b6\u0010\u001bJ\u0015\u00108\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010\u001bJ\u0015\u0010:\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0002¢\u0006\u0004\b:\u0010\u001bJ\u0015\u0010=\u001a\u00020\u00162\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u001d\u0010@\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010@\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b@\u0010BJ\u0015\u0010C\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0002¢\u0006\u0004\bC\u0010\u001bJ\u0015\u0010E\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u001e¢\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0002¢\u0006\u0004\bH\u0010\u001bJ\u0015\u0010J\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u0002¢\u0006\u0004\bJ\u0010\u001bJ\u0015\u0010L\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u0002¢\u0006\u0004\bL\u0010\u001bJ\u0015\u0010N\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u0002¢\u0006\u0004\bN\u0010\u001bJ\u0015\u0010P\u001a\u00020\u00162\u0006\u0010O\u001a\u00020;¢\u0006\u0004\bP\u0010>J\u0015\u0010R\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u001e¢\u0006\u0004\bR\u0010FJ\u001d\u0010S\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\bS\u0010(R\u0017\u0010X\u001a\u00020T8\u0007¢\u0006\f\n\u0004\b\u0017\u0010U\u001a\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010ZR\u0016\u0010\u0017\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010\\\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010\u001d\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010`\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0016\u0010b\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010^\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bf\u0010cR\u0016\u0010e\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bh\u0010aR\u0014\u0010j\u001a\u00020i8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010f\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010aR\u0016\u0010g\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010aR\u0016\u0010l\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bn\u0010aR\u0016\u0010h\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bo\u0010aR\u0018\u0010n\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010o\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\br\u0010]R\u0016\u0010r\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bs\u0010aR\u0016\u0010p\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bt\u0010aR\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bu\u0010aR\u0016\u0010s\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bv\u0010aR\u0016\u0010u\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bw\u0010aR\u0016\u0010t\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bx\u0010]R\u0016\u0010v\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\by\u0010aR\u0016\u0010w\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bz\u0010cR\u0016\u0010y\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b{\u0010cR\u0016\u0010x\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b|\u0010cR\u0016\u0010{\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b}\u0010c"}, d2 = {"Lid/dana/cashier/view/PaylaterTimelineView;", "Landroid/view/View;", "", "getEndLineColor", "()I", "getLineOrientation", "getLinePadding", "getLineStyle", "getLineStyleDashGap", "getLineStyleDashLength", "getLineWidth", "Landroid/graphics/drawable/Drawable;", "getMarker", "()Landroid/graphics/drawable/Drawable;", "getMarkerPaddingBottom", "getMarkerPaddingLeft", "getMarkerPaddingRight", "getMarkerPaddingTop", "getMarkerSize", "getStartLineColor", "Landroid/util/AttributeSet;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/util/AttributeSet;)V", "viewType", "initLine", "(I)V", "()V", "getAuthRequestContext", "", "isMarkerInCenter", "()Z", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "oldWidth", "oldHeight", "onSizeChanged", "(IIII)V", "color", "setEndLineColor", "lineOrientation", "setLineOrientation", ZebraData.ATTR_PADDING, "setLinePadding", "lineStyle", "setLineStyle", "lineStyleDashGap", "setLineStyleDashGap", "lineStyleDashLength", "setLineStyleDashLength", "", "lineWidth", "setLineWidth", "(F)V", "marker", "setMarker", "(Landroid/graphics/drawable/Drawable;I)V", "(Landroid/graphics/drawable/Drawable;)V", "setMarkerColor", "markerInCenter", "setMarkerInCenter", "(Z)V", "markerPaddingBottom", "setMarkerPaddingBottom", "markerPaddingLeft", "setMarkerPaddingLeft", "markerPaddingRight", "setMarkerPaddingRight", "markerPaddingTop", "setMarkerPaddingTop", "markerSize", "setMarkerSize", "inShimmerMode", "setShimmerMode", "setStartLineColor", "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Z", "scheduleImpl", "PlaceComponentResult", "lookAheadTest", "I", "moveToNextValue", LogConstants.RESULT_FALSE, "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/graphics/Paint;", "DatabaseTableConfigUtil", "Landroid/graphics/Paint;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "Landroid/graphics/drawable/Drawable;", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "getCallingPid", "whenAvailable", "getSupportButtonTintMode", "readMicros", "SubSequence", "BottomSheetCardBindingView$watcherCardNumberView$1", "Landroid/content/Context;", HummerConstants.CONTEXT, "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LineOrientation", "LineStyle", "LineType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaylaterTimelineView extends View {

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private float readMicros;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final Paint DatabaseTableConfigUtil;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private float scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private float moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private int getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private int newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private int isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private int initRecordTimeStamp;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private float getCallingPid;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Rect MyBillsEntityDataFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private float lookAheadTest;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private float NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private int GetContactSyncConfig;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private float getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private Drawable PrepareContext;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private float whenAvailable;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private int FragmentBottomSheetPaymentSettingBinding;
    public static final byte[] PlaceComponentResult = {93, 18, 67, -65, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 123;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterTimelineView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterTimelineView(Context context, AttributeSet attributeSet) {
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
    public PaylaterTimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        Intrinsics.checkNotNullExpressionValue("PaylaterTimelineView", "");
        this.TAG = "PaylaterTimelineView";
        this.DatabaseTableConfigUtil = new Paint();
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    public /* synthetic */ PaylaterTimelineView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterTimelineView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        Intrinsics.checkNotNullExpressionValue("PaylaterTimelineView", "");
        this.TAG = "PaylaterTimelineView";
        this.DatabaseTableConfigUtil = new Paint();
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    @JvmName(name = "getTAG")
    public final String getTAG() {
        return this.TAG;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/cashier/view/PaylaterTimelineView$LineOrientation;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LineOrientation {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.PlaceComponentResult;
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/view/PaylaterTimelineView$LineOrientation$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion PlaceComponentResult = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/cashier/view/PaylaterTimelineView$LineType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LineType {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
        public static final int END = 2;
        public static final int NORMAL = 0;
        public static final int ONLY_ONE = 3;
        public static final int START = 1;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/view/PaylaterTimelineView$LineType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/cashier/view/PaylaterTimelineView$LineStyle;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LineStyle {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
        public static final int DASHED = 1;
        public static final int NORMAL = 0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/view/PaylaterTimelineView$LineStyle$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

            private Companion() {
            }
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet p0) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(p0, R.styleable.MapPageContract$Presenter);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        this.PrepareContext = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 7);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = obtainStyledAttributes.getDimensionPixelSize(13, ViewExtKt.PlaceComponentResult(24.0f));
        this.newProxyInstance = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getDimensionPixelSize(11, 0);
        this.isLayoutRequested = obtainStyledAttributes.getDimensionPixelSize(9, 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainStyledAttributes.getBoolean(8, true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = obtainStyledAttributes.getBoolean(14, false);
        this.FragmentBottomSheetPaymentSettingBinding = obtainStyledAttributes.getColor(15, ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23952131099990));
        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getColor(0, ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23952131099990));
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getDimensionPixelSize(6, ViewExtKt.PlaceComponentResult(5.0f));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getInt(1, 1);
        this.getErrorConfigVersion = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.GetContactSyncConfig = obtainStyledAttributes.getInt(3, 0);
        this.initRecordTimeStamp = obtainStyledAttributes.getDimensionPixelSize(5, ViewExtKt.PlaceComponentResult(8.0f));
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getDimensionPixelSize(4, ViewExtKt.PlaceComponentResult(4.0f));
        if (this.PrepareContext == null) {
            this.PrepareContext = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.timeline_paylater_circle);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            this.PlaceComponentResult = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        obtainStyledAttributes.recycle();
        if (isInEditMode()) {
            this.PlaceComponentResult = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        getAuthRequestContext();
        KClassImpl$Data$declaredNonStaticMembers$2();
        setLayerType(1, null);
    }

    @Override // android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(View.resolveSizeAndState(i + paddingLeft + paddingRight, widthMeasureSpec, 0), View.resolveSizeAndState(i2 + paddingTop + getPaddingBottom(), heightMeasureSpec, 0));
        getAuthRequestContext();
    }

    @Override // android.view.View
    protected final void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        int i;
        int i2;
        int i3;
        Rect rect;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = getWidth();
        int height = getHeight();
        int coerceAtMost = RangesKt.coerceAtMost(this.NetworkUserEntityData$$ExternalSyntheticLambda5, RangesKt.coerceAtMost((width - paddingLeft) - paddingRight, (height - paddingTop) - paddingBottom));
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            int i4 = width / 2;
            int i5 = coerceAtMost / 2;
            int i6 = i4 - i5;
            int i7 = height / 2;
            int i8 = i7 - i5;
            int i9 = i4 + i5;
            int i10 = i7 + i5;
            int i11 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i11 == 0) {
                int i12 = this.newProxyInstance - this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                i6 += i12;
                i9 += i12;
            } else if (i11 == 1) {
                int i13 = this.NetworkUserEntityData$$ExternalSyntheticLambda6 - this.isLayoutRequested;
                i8 += i13;
                i10 += i13;
            }
            Drawable drawable = this.PrepareContext;
            if (drawable != null) {
                drawable.setBounds(i6, i8, i9, i10);
                this.MyBillsEntityDataFactory = drawable.getBounds();
            }
        } else {
            int i14 = paddingLeft + coerceAtMost;
            int i15 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i15 == 0) {
                int i16 = height / 2;
                int i17 = coerceAtMost / 2;
                i = i16 - i17;
                i2 = i17 + i16;
                int i18 = this.newProxyInstance - this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                i3 = i18 + paddingLeft;
                i14 += i18;
            } else if (i15 != 1) {
                i3 = paddingLeft;
                i2 = paddingTop;
                i = i2;
            } else {
                int i19 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                int i20 = this.isLayoutRequested;
                i = (i19 - i20) + paddingTop;
                i2 = ((coerceAtMost + i19) - i20) + paddingTop;
                i3 = paddingLeft;
            }
            Drawable drawable2 = this.PrepareContext;
            if (drawable2 != null) {
                drawable2.setBounds(i3, i, i14, i2);
                this.MyBillsEntityDataFactory = drawable2.getBounds();
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
            if (this.PlaceComponentResult && (rect4 = this.MyBillsEntityDataFactory) != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = paddingLeft;
                this.whenAvailable = rect4.centerY();
                this.getCallingPid = rect4.left - this.getErrorConfigVersion;
                this.readMicros = rect4.centerY();
            }
            boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (z && this.GetContactSyncConfig == 1) {
                if (this.MyBillsEntityDataFactory != null) {
                    this.getAuthRequestContext = getWidth() - this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    this.lookAheadTest = r0.centerY();
                    this.moveToNextValue = r0.right + this.getErrorConfigVersion;
                    this.scheduleImpl = r0.centerY();
                }
            } else if (z && this.GetContactSyncConfig == 0 && (rect3 = this.MyBillsEntityDataFactory) != null) {
                this.getAuthRequestContext = rect3.right + this.getErrorConfigVersion;
                this.lookAheadTest = rect3.centerY();
                this.moveToNextValue = getWidth();
                this.scheduleImpl = rect3.centerY();
            }
        } else {
            if (this.PlaceComponentResult && (rect2 = this.MyBillsEntityDataFactory) != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = rect2.centerX();
                this.whenAvailable = paddingTop;
                this.getCallingPid = rect2.centerX();
                this.readMicros = rect2.top - this.getErrorConfigVersion;
            }
            boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (z2 && this.GetContactSyncConfig == 1) {
                if (this.MyBillsEntityDataFactory != null) {
                    this.getAuthRequestContext = r0.centerX();
                    this.lookAheadTest = getHeight() - this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    this.moveToNextValue = r0.centerX();
                    this.scheduleImpl = r0.bottom + this.getErrorConfigVersion;
                }
            } else if (z2 && this.GetContactSyncConfig == 0 && (rect = this.MyBillsEntityDataFactory) != null) {
                this.getAuthRequestContext = rect.centerX();
                this.lookAheadTest = rect.bottom + this.getErrorConfigVersion;
                this.moveToNextValue = rect.centerX();
                this.scheduleImpl = getHeight();
            }
        }
        invalidate();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.DatabaseTableConfigUtil.setAlpha(0);
        this.DatabaseTableConfigUtil.setAntiAlias(true);
        this.DatabaseTableConfigUtil.setColor(this.FragmentBottomSheetPaymentSettingBinding);
        this.DatabaseTableConfigUtil.setStyle(Paint.Style.STROKE);
        this.DatabaseTableConfigUtil.setStrokeWidth(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        if (this.GetContactSyncConfig == 1) {
            this.DatabaseTableConfigUtil.setPathEffect(new DashPathEffect(new float[]{this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda1}, 0.0f));
        } else {
            this.DatabaseTableConfigUtil.setPathEffect(new PathEffect());
        }
        invalidate();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "");
        super.onDraw(canvas);
        Drawable drawable = this.PrepareContext;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (this.PlaceComponentResult) {
            this.DatabaseTableConfigUtil.setColor(this.FragmentBottomSheetPaymentSettingBinding);
            canvas.drawLine(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.whenAvailable, this.getCallingPid, this.readMicros, this.DatabaseTableConfigUtil);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.DatabaseTableConfigUtil.setColor(this.BuiltInFictitiousFunctionClassFactory);
            canvas.drawLine(this.getAuthRequestContext, this.lookAheadTest, this.moveToNextValue, this.scheduleImpl, this.DatabaseTableConfigUtil);
        }
    }

    public final void setMarker(Drawable marker) {
        this.PrepareContext = marker;
        getAuthRequestContext();
    }

    /* renamed from: getMarker  reason: from getter */
    public final Drawable getPrepareContext() {
        return this.PrepareContext;
    }

    public final void setMarker(Drawable marker, int color) {
        Intrinsics.checkNotNullParameter(marker, "");
        this.PrepareContext = marker;
        if (marker != null) {
            if (OSUtil.MyBillsEntityDataFactory()) {
                marker.setColorFilter(new BlendModeColorFilter(color, BlendMode.SRC_ATOP));
            } else {
                marker.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            }
            getAuthRequestContext();
        }
    }

    public final void setMarkerColor(int color) {
        Drawable drawable = this.PrepareContext;
        if (drawable != null) {
            if (OSUtil.MyBillsEntityDataFactory()) {
                drawable.setColorFilter(new BlendModeColorFilter(color, BlendMode.SRC_ATOP));
            } else {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            }
            getAuthRequestContext();
        }
    }

    public final void setStartLineColor(int color, int viewType) {
        this.FragmentBottomSheetPaymentSettingBinding = color;
        initLine(viewType);
    }

    /* renamed from: getStartLineColor  reason: from getter */
    public final int getFragmentBottomSheetPaymentSettingBinding() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    public final void setEndLineColor(int color, int viewType) {
        this.BuiltInFictitiousFunctionClassFactory = color;
        initLine(viewType);
    }

    /* renamed from: getEndLineColor  reason: from getter */
    public final int getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final void setMarkerSize(float markerSize) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = ViewExtKt.PlaceComponentResult(markerSize);
        getAuthRequestContext();
    }

    /* renamed from: getMarkerSize  reason: from getter */
    public final int getNetworkUserEntityData$$ExternalSyntheticLambda5() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    public final void setMarkerPaddingLeft(int markerPaddingLeft) {
        this.newProxyInstance = markerPaddingLeft;
        getAuthRequestContext();
    }

    /* renamed from: getMarkerPaddingLeft  reason: from getter */
    public final int getNewProxyInstance() {
        return this.newProxyInstance;
    }

    public final void setMarkerPaddingTop(int markerPaddingTop) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = markerPaddingTop;
        getAuthRequestContext();
    }

    /* renamed from: getMarkerPaddingTop  reason: from getter */
    public final int getNetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public final void setMarkerPaddingRight(int markerPaddingRight) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = markerPaddingRight;
        getAuthRequestContext();
    }

    /* renamed from: getMarkerPaddingRight  reason: from getter */
    public final int getNetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    public final void setMarkerPaddingBottom(int markerPaddingBottom) {
        this.isLayoutRequested = markerPaddingBottom;
        getAuthRequestContext();
    }

    /* renamed from: getMarkerPaddingBottom  reason: from getter */
    public final int getIsLayoutRequested() {
        return this.isLayoutRequested;
    }

    /* renamed from: isMarkerInCenter  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    public final void setMarkerInCenter(boolean markerInCenter) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = markerInCenter;
        getAuthRequestContext();
    }

    public final void setShimmerMode(boolean inShimmerMode) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = inShimmerMode;
        getAuthRequestContext();
    }

    public final void setLineWidth(float lineWidth) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ViewExtKt.PlaceComponentResult(lineWidth);
        getAuthRequestContext();
    }

    /* renamed from: getLineWidth  reason: from getter */
    public final int getNetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final void setLinePadding(int padding) {
        this.getErrorConfigVersion = padding;
        getAuthRequestContext();
    }

    /* renamed from: getLineOrientation  reason: from getter */
    public final int getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final void setLineOrientation(int lineOrientation) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lineOrientation;
    }

    /* renamed from: getLineStyle  reason: from getter */
    public final int getGetContactSyncConfig() {
        return this.GetContactSyncConfig;
    }

    public final void setLineStyle(int lineStyle) {
        this.GetContactSyncConfig = lineStyle;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: getLineStyleDashLength  reason: from getter */
    public final int getInitRecordTimeStamp() {
        return this.initRecordTimeStamp;
    }

    public final void setLineStyleDashLength(int lineStyleDashLength) {
        this.initRecordTimeStamp = lineStyleDashLength;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: getLineStyleDashGap  reason: from getter */
    public final int getNetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final void setLineStyleDashGap(int lineStyleDashGap) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lineStyleDashGap;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: getLinePadding  reason: from getter */
    public final int getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.cashier.view.PaylaterTimelineView.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 4
            r4 = 0
            if (r0 != 0) goto L15
            r6 = r1
            r5 = 4
            r7 = 22
            r8 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L47
        L15:
            r5 = 97
            r3 = r1
            r5 = 4
            r6 = 97
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1f:
            byte r8 = (byte) r6
            r3[r7] = r8
            int r8 = r7 + 1
            if (r7 != r2) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3c
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3c:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L41:
            r7 = r1[r5]
            r9 = r6
            r6 = r3
            r3 = r7
            r7 = r9
        L47:
            int r3 = -r3
            int r7 = r7 + r3
            int r3 = r7 + (-8)
            int r5 = r5 + 1
            r7 = r8
            r9 = r6
            r6 = r3
            r3 = r9
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.PaylaterTimelineView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    public final void initLine(int viewType) {
        if (viewType == 1) {
            this.PlaceComponentResult = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        } else if (viewType == 2) {
            this.PlaceComponentResult = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        } else if (viewType != 3) {
            this.PlaceComponentResult = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        } else {
            this.PlaceComponentResult = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
        getAuthRequestContext();
    }
}
