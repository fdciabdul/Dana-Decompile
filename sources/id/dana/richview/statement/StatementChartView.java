package id.dana.richview.statement;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.LineRadarDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import id.dana.R;
import id.dana.richview.statement.mapper.StatementChartMapper;
import id.dana.statement.marker.PointMarker;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 V2\u00020\u0001:\u0001VB\u0011\b\u0016\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QB\u0019\b\u0016\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010R\u001a\u00020\u000e¢\u0006\u0004\bP\u0010SB!\b\u0016\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010R\u001a\u00020\u000e\u0012\u0006\u0010T\u001a\u00020\t¢\u0006\u0004\bP\u0010UJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00118\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\"\u0010%\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\"\u0010)\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\"\u0010-\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\"\u00101\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\"\u00109\u001a\u0002028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u0002028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010A\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0019\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010\u001dR\"\u0010E\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0012\u001a\u0004\bC\u0010\u0014\"\u0004\bD\u0010\u0016R\"\u0010I\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0019\u001a\u0004\bG\u0010\u001b\"\u0004\bH\u0010\u001dR\"\u0010M\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0019\u001a\u0004\bK\u0010\u001b\"\u0004\bL\u0010\u001d"}, d2 = {"Lid/dana/richview/statement/StatementChartView;", "Lcom/github/mikephil/charting/charts/LineChart;", "", "build", "()V", "Landroid/graphics/Canvas;", "canvas", "drawMarkers", "(Landroid/graphics/Canvas;)V", "", "p0", "Landroid/graphics/drawable/Drawable;", "getAuthRequestContext", "(I)Landroid/graphics/drawable/Drawable;", "Landroid/util/AttributeSet;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/util/AttributeSet;)V", "", "Z", "getAnimationEnable", "()Z", "setAnimationEnable", "(Z)V", "animationEnable", "PlaceComponentResult", "I", "getBackgroudColor", "()I", "setBackgroudColor", "(I)V", "backgroudColor", "getCircleEnabled", "setCircleEnabled", "circleEnabled", "BuiltInFictitiousFunctionClassFactory", "getDataset1Color", "setDataset1Color", "dataset1Color", "MyBillsEntityDataFactory", "getDataset2Color", "setDataset2Color", "dataset2Color", "moveToNextValue", "getGridColor", "setGridColor", "gridColor", "getErrorConfigVersion", "getLabelColor", "setLabelColor", "labelColor", "Lcom/github/mikephil/charting/data/LineDataSet;", "scheduleImpl", "Lcom/github/mikephil/charting/data/LineDataSet;", "getLineDataSet1", "()Lcom/github/mikephil/charting/data/LineDataSet;", "setLineDataSet1", "(Lcom/github/mikephil/charting/data/LineDataSet;)V", "lineDataSet1", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getLineDataSet2", "setLineDataSet2", "lineDataSet2", "lookAheadTest", "getMaxXAxisRange", "setMaxXAxisRange", "maxXAxisRange", "DatabaseTableConfigUtil", "getShowAllData", "setShowAllData", "showAllData", "NetworkUserEntityData$$ExternalSyntheticLambda2", "getStartPosition", "setStartPosition", "startPosition", "NetworkUserEntityData$$ExternalSyntheticLambda1", "getVisibleXRangeMaximum", "setVisibleXRangeMaximum", "visibleXRangeMaximum", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementChartView extends LineChart {
    public static final float CHART_X_HALF_RANGE_SPACE = 0.255f;
    public static final float CHART_X_RANGE_SPACE = 0.51f;
    public static final int DURATION_CHART_ANIMATION = 300;
    public static final int MAX_DATE = 31;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int dataset1Color;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean showAllData;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean animationEnable;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int dataset2Color;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private LineDataSet lineDataSet2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int visibleXRangeMaximum;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private int startPosition;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int backgroudColor;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean circleEnabled;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int labelColor;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int maxXAxisRange;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int gridColor;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private LineDataSet lineDataSet1;

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

    @JvmName(name = "getShowAllData")
    public final boolean getShowAllData() {
        return this.showAllData;
    }

    @JvmName(name = "setShowAllData")
    public final void setShowAllData(boolean z) {
        this.showAllData = z;
    }

    @JvmName(name = "getVisibleXRangeMaximum")
    public final int getVisibleXRangeMaximum() {
        return this.visibleXRangeMaximum;
    }

    @JvmName(name = "setVisibleXRangeMaximum")
    public final void setVisibleXRangeMaximum(int i) {
        this.visibleXRangeMaximum = i;
    }

    @JvmName(name = "getGridColor")
    public final int getGridColor() {
        return this.gridColor;
    }

    @JvmName(name = "setGridColor")
    public final void setGridColor(int i) {
        this.gridColor = i;
    }

    @JvmName(name = "getLabelColor")
    public final int getLabelColor() {
        return this.labelColor;
    }

    @JvmName(name = "setLabelColor")
    public final void setLabelColor(int i) {
        this.labelColor = i;
    }

    @JvmName(name = "getDataset1Color")
    public final int getDataset1Color() {
        return this.dataset1Color;
    }

    @JvmName(name = "setDataset1Color")
    public final void setDataset1Color(int i) {
        this.dataset1Color = i;
    }

    @JvmName(name = "getDataset2Color")
    public final int getDataset2Color() {
        return this.dataset2Color;
    }

    @JvmName(name = "setDataset2Color")
    public final void setDataset2Color(int i) {
        this.dataset2Color = i;
    }

    @JvmName(name = "getStartPosition")
    public final int getStartPosition() {
        return this.startPosition;
    }

    @JvmName(name = "setStartPosition")
    public final void setStartPosition(int i) {
        this.startPosition = i;
    }

    @JvmName(name = "getBackgroudColor")
    public final int getBackgroudColor() {
        return this.backgroudColor;
    }

    @JvmName(name = "setBackgroudColor")
    public final void setBackgroudColor(int i) {
        this.backgroudColor = i;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementChartView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.lineDataSet1 = new LineDataSet(new ArrayList(), "");
        this.lineDataSet2 = new LineDataSet(new ArrayList(), "");
        this.animationEnable = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.lineDataSet1 = new LineDataSet(new ArrayList(), "");
        this.lineDataSet2 = new LineDataSet(new ArrayList(), "");
        this.animationEnable = true;
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.lineDataSet1 = new LineDataSet(new ArrayList(), "");
        this.lineDataSet2 = new LineDataSet(new ArrayList(), "");
        this.animationEnable = true;
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet p0) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(p0, R.styleable.HttpClientAttributesExtractorBuilder);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        this.showAllData = obtainStyledAttributes.getBoolean(6, false);
        this.visibleXRangeMaximum = obtainStyledAttributes.getInteger(8, 4);
        this.gridColor = obtainStyledAttributes.getInteger(4, -1);
        this.labelColor = obtainStyledAttributes.getInteger(5, -1);
        this.dataset1Color = obtainStyledAttributes.getInteger(2, -1);
        this.dataset2Color = obtainStyledAttributes.getInteger(3, -1);
        this.backgroudColor = obtainStyledAttributes.getInteger(0, ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22912131099753));
        this.startPosition = obtainStyledAttributes.getInteger(7, 0);
        this.circleEnabled = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final void drawMarkers(Canvas canvas) {
        if (this.mMarker != null && isDrawMarkersEnabled() && valuesToHighlight()) {
            int length = this.mIndicesToHighlight.length;
            int i = 0;
            while (i < length) {
                Highlight highlight = this.mIndicesToHighlight[i];
                Entry BuiltInFictitiousFunctionClassFactory = ((LineData) this.mData).BuiltInFictitiousFunctionClassFactory(this.mIndicesToHighlight[i]);
                float[] markerPosition = getMarkerPosition(highlight);
                if (this.mViewPortHandler.PlaceComponentResult(markerPosition[0], markerPosition[1])) {
                    boolean z = i > 0;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    setMarker(new PointMarker(context, R.layout.custom_marker_view, z));
                    IMarker marker = getMarker();
                    if (marker == null) {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.statement.marker.PointMarker");
                    }
                    StatementChartMapper statementChartMapper = StatementChartMapper.INSTANCE;
                    ((PointMarker) marker).update(StatementChartMapper.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                    this.mMarker.refreshContent(BuiltInFictitiousFunctionClassFactory, highlight);
                    this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                }
                i++;
            }
        }
    }

    private static Drawable getAuthRequestContext(int p0) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{p0, 0});
        gradientDrawable.setCornerRadius(0.0f);
        return gradientDrawable;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r7v8, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    public static final /* synthetic */ void access$highlightSelectedValues(StatementChartView statementChartView, Entry entry, Highlight highlight) {
        if (entry != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(highlight);
            String obj = entry.KClassImpl$Data$declaredNonStaticMembers$2.toString();
            if (Intrinsics.areEqual(obj, "income")) {
                ?? authRequestContext = statementChartView.lineDataSet2.getAuthRequestContext(entry.MyBillsEntityDataFactory(), entry.getAuthRequestContext());
                if (entry.MyBillsEntityDataFactory() == authRequestContext.MyBillsEntityDataFactory()) {
                    arrayList.add(new Highlight(authRequestContext.MyBillsEntityDataFactory(), authRequestContext.getAuthRequestContext(), 1));
                }
            } else if (Intrinsics.areEqual(obj, "expense")) {
                ?? authRequestContext2 = statementChartView.lineDataSet1.getAuthRequestContext(entry.MyBillsEntityDataFactory(), entry.getAuthRequestContext());
                if (entry.MyBillsEntityDataFactory() == authRequestContext2.MyBillsEntityDataFactory()) {
                    arrayList.add(new Highlight(authRequestContext2.MyBillsEntityDataFactory(), authRequestContext2.getAuthRequestContext(), 0));
                }
            }
            StatementChartView statementChartView2 = (StatementChartView) statementChartView._$_findCachedViewById(R.id.SQLiteDatabaseCorruptException);
            Object[] array = arrayList.toArray(new Highlight[0]);
            if (array != null) {
                statementChartView2.highlightValues((Highlight[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public final void build() {
        LineDataSet lineDataSet = this.lineDataSet1;
        lineDataSet.PlaceComponentResult(getAuthRequestContext(this.dataset1Color));
        ((LineRadarDataSet) lineDataSet).PrepareContext = true;
        lineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.backgroudColor;
        lineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda0(this.dataset1Color);
        lineDataSet.isLayoutRequested = this.circleEnabled;
        lineDataSet.KClassImpl$Data$declaredNonStaticMembers$2(this.dataset1Color);
        lineDataSet.getSupportButtonTintMode();
        lineDataSet.J();
        lineDataSet.M();
        lineDataSet.MyBillsEntityDataFactory(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22682131099704));
        LineDataSet lineDataSet2 = this.lineDataSet2;
        lineDataSet2.PlaceComponentResult(getAuthRequestContext(this.dataset2Color));
        lineDataSet2.NetworkUserEntityData$$ExternalSyntheticLambda0(this.dataset2Color);
        lineDataSet2.isLayoutRequested = this.circleEnabled;
        lineDataSet2.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.backgroudColor;
        lineDataSet2.KClassImpl$Data$declaredNonStaticMembers$2(this.dataset2Color);
        ((LineRadarDataSet) lineDataSet2).PrepareContext = true;
        lineDataSet2.getSupportButtonTintMode();
        lineDataSet2.J();
        lineDataSet2.M();
        lineDataSet2.MyBillsEntityDataFactory(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22682131099704));
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.lineDataSet1);
        arrayList.add(this.lineDataSet2);
        LineData lineData = new LineData(arrayList);
        final StatementChartView statementChartView = (StatementChartView) _$_findCachedViewById(R.id.SQLiteDatabaseCorruptException);
        statementChartView.setData(lineData);
        statementChartView.getDescription().KClassImpl$Data$declaredNonStaticMembers$2(false);
        statementChartView.setTouchEnabled(true);
        statementChartView.setDrawGridBackground(false);
        statementChartView.getXAxis().getAuthRequestContext(false);
        statementChartView.getAxisRight().getAuthRequestContext(false);
        statementChartView.getXAxis().AppCompatEmojiTextHelper = XAxis.XAxisPosition.BOTTOM;
        statementChartView.getXAxis().PlaceComponentResult(statementChartView.labelColor);
        statementChartView.getXAxis().MyBillsEntityDataFactory(10.0f);
        if (statementChartView.maxXAxisRange > 0) {
            statementChartView.getXAxis().BuiltInFictitiousFunctionClassFactory(statementChartView.maxXAxisRange + 0.1f);
        }
        if (statementChartView.maxXAxisRange >= 30) {
            statementChartView.getXAxis().BuiltInFictitiousFunctionClassFactory(statementChartView.maxXAxisRange + 2.25f);
        }
        statementChartView.getAxis(YAxis.AxisDependency.RIGHT).PlaceComponentResult(false);
        statementChartView.getAxis(YAxis.AxisDependency.RIGHT).KClassImpl$Data$declaredNonStaticMembers$2(false);
        statementChartView.getAxis(YAxis.AxisDependency.LEFT).PlaceComponentResult(false);
        statementChartView.getAxisLeft().NetworkUserEntityData$$ExternalSyntheticLambda5 = statementChartView.gridColor;
        statementChartView.getAxisLeft().NetworkUserEntityData$$ExternalSyntheticLambda1();
        statementChartView.getAxisLeft().readMicros();
        statementChartView.getAxisLeft().PlaceComponentResult(0.0f);
        statementChartView.getAxisRight().NetworkUserEntityData$$ExternalSyntheticLambda1();
        statementChartView.getAxisRight().readMicros();
        statementChartView.getAxisRight().PlaceComponentResult(0.0f);
        statementChartView.getLegend().KClassImpl$Data$declaredNonStaticMembers$2(false);
        Context context = statementChartView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        statementChartView.setMarker(new PointMarker(context, R.layout.custom_marker_view));
        statementChartView.setDragEnabled(true);
        statementChartView.setDragDecelerationFrictionCoef(0.6f);
        statementChartView.setPinchZoom(false);
        statementChartView.setScaleEnabled(false);
        statementChartView.setViewPortOffsets(0.0f, 0.0f, 0.0f, 80.0f);
        if (statementChartView.showAllData) {
            statementChartView.getXAxis().PlaceComponentResult(0.0f);
            XAxis xAxis = statementChartView.getXAxis();
            xAxis.BuiltInFictitiousFunctionClassFactory(xAxis.BuiltInFictitiousFunctionClassFactory + 1.0f);
            statementChartView.setVisibleXRangeMaximum(statementChartView.getXAxis().BuiltInFictitiousFunctionClassFactory);
            statementChartView.getXAxis().BuiltInFictitiousFunctionClassFactory((int) statementChartView.getXAxis().BuiltInFictitiousFunctionClassFactory, false);
            statementChartView.getXAxis().PlaceComponentResult(new ValueFormatter() { // from class: id.dana.richview.statement.StatementChartView$build$1$1
                @Override // com.github.mikephil.charting.formatter.ValueFormatter
                public final String MyBillsEntityDataFactory(float p0) {
                    return (p0 < 1.0f || p0 >= StatementChartView.this.getXAxis().BuiltInFictitiousFunctionClassFactory) ? "" : String.valueOf((int) p0);
                }
            });
        } else {
            statementChartView.getXAxis().PlaceComponentResult(-1.255f);
            statementChartView.setVisibleXRangeMaximum(statementChartView.visibleXRangeMaximum + 0.51f);
            statementChartView.getXAxis().BuiltInFictitiousFunctionClassFactory(statementChartView.visibleXRangeMaximum, false);
            statementChartView.getXAxis().PlaceComponentResult(new ValueFormatter() { // from class: id.dana.richview.statement.StatementChartView$build$1$2
                @Override // com.github.mikephil.charting.formatter.ValueFormatter
                public final String MyBillsEntityDataFactory(float p0) {
                    return (p0 < 1.0f || p0 > ((float) StatementChartView.this.getMaxXAxisRange())) ? "" : String.valueOf((int) p0);
                }
            });
        }
        statementChartView.moveViewToX(statementChartView.startPosition - 0.255f);
        if (statementChartView.animationEnable) {
            statementChartView.animateY(300);
        }
        ((StatementChartView) statementChartView._$_findCachedViewById(R.id.SQLiteDatabaseCorruptException)).setOnChartValueSelectedListener(new OnChartValueSelectedListener() { // from class: id.dana.richview.statement.StatementChartView$build$1$3
            @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
            public final void PlaceComponentResult(Entry p0, Highlight p1) {
                StatementChartView statementChartView2 = StatementChartView.this;
                Intrinsics.checkNotNullExpressionValue(statementChartView2, "");
                StatementChartView.access$highlightSelectedValues(statementChartView2, p0, p1);
            }
        });
    }
}
