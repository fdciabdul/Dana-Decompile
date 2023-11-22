package id.dana.statement.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\t¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\t¢\u0006\u0004\b!\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f"}, d2 = {"Lid/dana/statement/view/StatementOnBoardingView;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "MyBillsEntityDataFactory", "()V", "", "PlaceComponentResult", "I", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "layoutHeight", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onClickListener", "KClassImpl$Data$declaredNonStaticMembers$2", "getOverlayColor", "setOverlayColor", "overlayColor", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementOnBoardingView extends FrameLayout {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int overlayColor;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function0<Unit> onClickListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int layoutHeight;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatementOnBoardingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatementOnBoardingView(Context context, AttributeSet attributeSet) {
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
    public StatementOnBoardingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.overlayColor = R.color.f22692131099709;
        this.onClickListener = StatementOnBoardingView$onClickListener$1.INSTANCE;
        MyBillsEntityDataFactory();
        setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.view.StatementOnBoardingView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatementOnBoardingView.m2984$r8$lambda$Z5HHGrXbEy8Y7AwoWS66pct3kQ(StatementOnBoardingView.this, view);
            }
        });
    }

    public /* synthetic */ StatementOnBoardingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementOnBoardingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.overlayColor = R.color.f22692131099709;
        this.onClickListener = StatementOnBoardingView$onClickListener$1.INSTANCE;
        MyBillsEntityDataFactory();
        setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.view.StatementOnBoardingView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatementOnBoardingView.m2984$r8$lambda$Z5HHGrXbEy8Y7AwoWS66pct3kQ(StatementOnBoardingView.this, view);
            }
        });
    }

    @JvmName(name = "getLayoutHeight")
    public final int getLayoutHeight() {
        return this.layoutHeight;
    }

    @JvmName(name = "setLayoutHeight")
    public final void setLayoutHeight(int i) {
        this.layoutHeight = i;
    }

    @JvmName(name = "getOverlayColor")
    public final int getOverlayColor() {
        return this.overlayColor;
    }

    @JvmName(name = "setOverlayColor")
    public final void setOverlayColor(int i) {
        this.overlayColor = i;
    }

    @JvmName(name = "getOnClickListener")
    public final Function0<Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @JvmName(name = "setOnClickListener")
    public final void setOnClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onClickListener = function0;
    }

    private final void MyBillsEntityDataFactory() {
        bringToFront();
        setWillNotDraw(false);
        setLayerType(2, null);
        setFitsSystemWindows(true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View.inflate(getContext(), R.layout.layout_statement_swipe_lottie, this);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "");
        float width = getWidth();
        float f = this.layoutHeight;
        Paint paint = new Paint();
        paint.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.overlayColor));
        canvas.drawRect(0.0f, 0.0f, width, f, paint);
    }

    /* renamed from: $r8$lambda$Z5HHGrXbEy8Y7AwoWS66-pct3kQ  reason: not valid java name */
    public static /* synthetic */ void m2984$r8$lambda$Z5HHGrXbEy8Y7AwoWS66pct3kQ(StatementOnBoardingView statementOnBoardingView, View view) {
        Intrinsics.checkNotNullParameter(statementOnBoardingView, "");
        statementOnBoardingView.onClickListener.invoke();
    }
}
