package id.dana.richview.statement;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.LineRadarDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.utils.NumberFormatterUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BB\u0019\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bA\u0010EB!\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010F\u001a\u00020\u0005¢\u0006\u0004\bA\u0010GJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u00020\u0005X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0013\u0010\u000b\u001a\u00020\u0005X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0012\u001a\u00020\u00188\u0002X\u0083D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0017\u001a\u00020\u0005X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\"\u0010#\u001a\u00020\u001c8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010.\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R2\u00108\u001a\u0012\u0012\u0004\u0012\u0002000/j\b\u0012\u0004\u0012\u000200`18\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010<\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010)\u001a\u0004\b:\u0010+\"\u0004\b;\u0010-R\u0013\u0010\u0019\u001a\u00020\u0005X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b=\u0010\u0016R\u0013\u0010$\u001a\u00020\u0005X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b>\u0010\u0016"}, d2 = {"Lid/dana/richview/statement/StatementWidgetChartView;", "Lcom/github/mikephil/charting/charts/LineChart;", "", "build", "()V", "", "p0", "Landroid/graphics/drawable/Drawable;", "getAuthRequestContext", "(I)Landroid/graphics/drawable/Drawable;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "getAnimationEnable", "()Z", "setAnimationEnable", "(Z)V", "animationEnable", "MyBillsEntityDataFactory", "getCircleEnabled", "setCircleEnabled", "circleEnabled", "Lkotlin/Lazy;", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", LogConstants.RESULT_FALSE, "lookAheadTest", "Lcom/github/mikephil/charting/data/LineDataSet;", "moveToNextValue", "Lcom/github/mikephil/charting/data/LineDataSet;", "getLineDataSet1", "()Lcom/github/mikephil/charting/data/LineDataSet;", "setLineDataSet1", "(Lcom/github/mikephil/charting/data/LineDataSet;)V", "lineDataSet1", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getLineDataSet2", "setLineDataSet2", "lineDataSet2", "getErrorConfigVersion", "I", "getMaxXAxisRange", "()I", "setMaxXAxisRange", "(I)V", "maxXAxisRange", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "scheduleImpl", "Ljava/util/ArrayList;", "getMonths", "()Ljava/util/ArrayList;", "setMonths", "(Ljava/util/ArrayList;)V", "months", "DatabaseTableConfigUtil", "getStartPosition", "setStartPosition", "startPosition", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class StatementWidgetChartView extends LineChart {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean animationEnable;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private int startPosition;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final float MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean circleEnabled;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private LineDataSet lineDataSet2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    private final Lazy getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int maxXAxisRange;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private LineDataSet lineDataSet1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ArrayList<String> months;

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

    @JvmName(name = "getStartPosition")
    public final int getStartPosition() {
        return this.startPosition;
    }

    @JvmName(name = "setStartPosition")
    public final void setStartPosition(int i) {
        this.startPosition = i;
    }

    @JvmName(name = "getMaxXAxisRange")
    public final int getMaxXAxisRange() {
        return this.maxXAxisRange;
    }

    @JvmName(name = "setMaxXAxisRange")
    public final void setMaxXAxisRange(int i) {
        this.maxXAxisRange = i;
    }

    @JvmName(name = "getCircleEnabled")
    public final boolean getCircleEnabled() {
        return this.circleEnabled;
    }

    @JvmName(name = "setCircleEnabled")
    public final void setCircleEnabled(boolean z) {
        this.circleEnabled = z;
    }

    @JvmName(name = "getLineDataSet1")
    public final LineDataSet getLineDataSet1() {
        return this.lineDataSet1;
    }

    @JvmName(name = "setLineDataSet1")
    public final void setLineDataSet1(LineDataSet lineDataSet) {
        Intrinsics.checkNotNullParameter(lineDataSet, "");
        this.lineDataSet1 = lineDataSet;
    }

    @JvmName(name = "getLineDataSet2")
    public final LineDataSet getLineDataSet2() {
        return this.lineDataSet2;
    }

    @JvmName(name = "setLineDataSet2")
    public final void setLineDataSet2(LineDataSet lineDataSet) {
        Intrinsics.checkNotNullParameter(lineDataSet, "");
        this.lineDataSet2 = lineDataSet;
    }

    @JvmName(name = "getAnimationEnable")
    public final boolean getAnimationEnable() {
        return this.animationEnable;
    }

    @JvmName(name = "setAnimationEnable")
    public final void setAnimationEnable(boolean z) {
        this.animationEnable = z;
    }

    @JvmName(name = "getMonths")
    public final ArrayList<String> getMonths() {
        return this.months;
    }

    @JvmName(name = "setMonths")
    public final void setMonths(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "");
        this.months = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementWidgetChartView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$statementChartGridColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.getAuthRequestContext_res_0x7f060068));
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$labelColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f27092131100492));
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$dataset1Color$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f25552131100201));
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$dataset2Color$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f25542131100200));
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$widgetChartBackground$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f22912131099753));
            }
        });
        this.MyBillsEntityDataFactory = 2.0f;
        this.circleEnabled = true;
        this.lineDataSet1 = new LineDataSet(new ArrayList(), "");
        this.lineDataSet2 = new LineDataSet(new ArrayList(), "");
        this.animationEnable = true;
        this.months = CollectionsKt.arrayListOf("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "NOV", "DES");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementWidgetChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$statementChartGridColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.getAuthRequestContext_res_0x7f060068));
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$labelColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f27092131100492));
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$dataset1Color$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f25552131100201));
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$dataset2Color$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f25542131100200));
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$widgetChartBackground$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f22912131099753));
            }
        });
        this.MyBillsEntityDataFactory = 2.0f;
        this.circleEnabled = true;
        this.lineDataSet1 = new LineDataSet(new ArrayList(), "");
        this.lineDataSet2 = new LineDataSet(new ArrayList(), "");
        this.animationEnable = true;
        this.months = CollectionsKt.arrayListOf("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "NOV", "DES");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementWidgetChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$statementChartGridColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.getAuthRequestContext_res_0x7f060068));
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$labelColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f27092131100492));
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$dataset1Color$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f25552131100201));
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$dataset2Color$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f25542131100200));
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.richview.statement.StatementWidgetChartView$widgetChartBackground$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(StatementWidgetChartView.this.getContext(), R.color.f22912131099753));
            }
        });
        this.MyBillsEntityDataFactory = 2.0f;
        this.circleEnabled = true;
        this.lineDataSet1 = new LineDataSet(new ArrayList(), "");
        this.lineDataSet2 = new LineDataSet(new ArrayList(), "");
        this.animationEnable = true;
        this.months = CollectionsKt.arrayListOf("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "NOV", "DES");
    }

    private static Drawable getAuthRequestContext(int p0) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{p0, 0});
        gradientDrawable.setCornerRadius(0.0f);
        return gradientDrawable;
    }

    public final void build() {
        LineDataSet lineDataSet = this.lineDataSet1;
        lineDataSet.PlaceComponentResult(getAuthRequestContext(((Number) this.getAuthRequestContext.getValue()).intValue()));
        ((LineRadarDataSet) lineDataSet).PrepareContext = true;
        float f = this.MyBillsEntityDataFactory * 2.0f;
        if (f >= 1.0f) {
            lineDataSet.newProxyInstance = Utils.PlaceComponentResult(f);
        } else {
            InstrumentInjector.log_e("LineDataSet", "Circle radius cannot be < 1");
        }
        float f2 = this.MyBillsEntityDataFactory;
        if (f2 >= 0.5f) {
            lineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7 = Utils.PlaceComponentResult(f2);
        } else {
            InstrumentInjector.log_e("LineDataSet", "Circle radius cannot be < 0.5");
        }
        float f3 = this.MyBillsEntityDataFactory;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 10.0f) {
            f3 = 10.0f;
        }
        lineDataSet.readMicros = Utils.PlaceComponentResult(f3);
        lineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda2 = ((Number) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).intValue();
        lineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda0(((Number) this.getAuthRequestContext.getValue()).intValue());
        lineDataSet.isLayoutRequested = this.circleEnabled;
        lineDataSet.KClassImpl$Data$declaredNonStaticMembers$2(((Number) this.getAuthRequestContext.getValue()).intValue());
        lineDataSet.getSupportButtonTintMode();
        lineDataSet.J();
        lineDataSet.M();
        lineDataSet.MyBillsEntityDataFactory(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22682131099704));
        LineDataSet lineDataSet2 = this.lineDataSet2;
        lineDataSet2.PlaceComponentResult(getAuthRequestContext(((Number) this.BuiltInFictitiousFunctionClassFactory.getValue()).intValue()));
        lineDataSet2.NetworkUserEntityData$$ExternalSyntheticLambda0(((Number) this.BuiltInFictitiousFunctionClassFactory.getValue()).intValue());
        float f4 = this.MyBillsEntityDataFactory * 2.0f;
        if (f4 >= 1.0f) {
            lineDataSet2.newProxyInstance = Utils.PlaceComponentResult(f4);
        } else {
            InstrumentInjector.log_e("LineDataSet", "Circle radius cannot be < 1");
        }
        float f5 = this.MyBillsEntityDataFactory;
        if (f5 >= 0.5f) {
            lineDataSet2.NetworkUserEntityData$$ExternalSyntheticLambda7 = Utils.PlaceComponentResult(f5);
        } else {
            InstrumentInjector.log_e("LineDataSet", "Circle radius cannot be < 0.5");
        }
        float f6 = this.MyBillsEntityDataFactory;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        lineDataSet2.readMicros = Utils.PlaceComponentResult(f6 <= 10.0f ? f6 : 10.0f);
        lineDataSet2.isLayoutRequested = this.circleEnabled;
        lineDataSet2.NetworkUserEntityData$$ExternalSyntheticLambda2 = ((Number) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).intValue();
        lineDataSet2.KClassImpl$Data$declaredNonStaticMembers$2(((Number) this.BuiltInFictitiousFunctionClassFactory.getValue()).intValue());
        ((LineRadarDataSet) lineDataSet2).PrepareContext = true;
        lineDataSet2.getSupportButtonTintMode();
        lineDataSet2.J();
        lineDataSet2.M();
        lineDataSet2.MyBillsEntityDataFactory(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22682131099704));
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.lineDataSet1);
        arrayList.add(this.lineDataSet2);
        setData(new LineData(arrayList));
        getDescription().KClassImpl$Data$declaredNonStaticMembers$2(false);
        setTouchEnabled(false);
        getXAxis().getAuthRequestContext(false);
        getXAxis().AppCompatEmojiTextHelper = XAxis.XAxisPosition.BOTTOM;
        getXAxis().PlaceComponentResult(((Number) this.PlaceComponentResult.getValue()).intValue());
        getXAxis().MyBillsEntityDataFactory(8.0f);
        if (this.maxXAxisRange > 0) {
            getXAxis().BuiltInFictitiousFunctionClassFactory(this.maxXAxisRange + 0.1f);
        }
        if (this.maxXAxisRange >= 30) {
            getXAxis().BuiltInFictitiousFunctionClassFactory(this.maxXAxisRange + 2.25f);
        }
        YAxis axisRight = getAxisRight();
        axisRight.KClassImpl$Data$declaredNonStaticMembers$2(true);
        axisRight.PlaceComponentResult(true);
        axisRight.BuiltInFictitiousFunctionClassFactory(3, true);
        axisRight.NetworkUserEntityData$$ExternalSyntheticLambda5 = ((Number) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).intValue();
        axisRight.GetContactSyncConfig();
        axisRight.getAuthRequestContext(true);
        axisRight.NetworkUserEntityData$$ExternalSyntheticLambda1();
        axisRight.H = YAxis.YAxisLabelPosition.INSIDE_CHART;
        axisRight.E = false;
        axisRight.PlaceComponentResult(new ValueFormatter() { // from class: id.dana.richview.statement.StatementWidgetChartView$configureXaxis$1$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public final String MyBillsEntityDataFactory(float p0) {
                String MyBillsEntityDataFactory = NumberFormatterUtil.MyBillsEntityDataFactory(String.valueOf(p0));
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                return MyBillsEntityDataFactory;
            }
        });
        axisRight.MyBillsEntityDataFactory(-5.0f);
        axisRight.PlaceComponentResult(((Number) this.PlaceComponentResult.getValue()).intValue());
        axisRight.KClassImpl$Data$declaredNonStaticMembers$2(6.0f);
        axisRight.PlaceComponentResult(0.0f);
        getAxisLeft().KClassImpl$Data$declaredNonStaticMembers$2(false);
        getLegend().KClassImpl$Data$declaredNonStaticMembers$2(false);
        setDragEnabled(false);
        setPinchZoom(false);
        setScaleEnabled(false);
        getXAxis().KClassImpl$Data$declaredNonStaticMembers$2(6.0f);
        getXAxis().PlaceComponentResult(0.0f);
        XAxis xAxis = getXAxis();
        xAxis.BuiltInFictitiousFunctionClassFactory(xAxis.BuiltInFictitiousFunctionClassFactory + 1.0f);
        setVisibleXRangeMaximum(getXAxis().BuiltInFictitiousFunctionClassFactory);
        getXAxis().BuiltInFictitiousFunctionClassFactory((int) getXAxis().BuiltInFictitiousFunctionClassFactory, false);
        getXAxis().PlaceComponentResult(new ValueFormatter() { // from class: id.dana.richview.statement.StatementWidgetChartView$setupAllDataChart$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public final String MyBillsEntityDataFactory(float p0) {
                if (p0 < 0.0f || p0 >= StatementWidgetChartView.this.getXAxis().BuiltInFictitiousFunctionClassFactory) {
                    return "";
                }
                int i = (int) p0;
                if (i <= StatementWidgetChartView.this.getMonths().size()) {
                    String str = StatementWidgetChartView.this.getMonths().get(i);
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    return str;
                }
                String MyBillsEntityDataFactory = super.MyBillsEntityDataFactory(p0);
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                return MyBillsEntityDataFactory;
            }
        });
        setBackgroundColor(((Number) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).intValue());
    }
}
