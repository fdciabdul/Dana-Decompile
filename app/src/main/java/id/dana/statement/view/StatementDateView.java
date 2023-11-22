package id.dana.statement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.statement.StatementDateChangeListener;
import id.dana.statement.StatementMenuListener;
import id.dana.utils.DateTimeUtil;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u0002¢\u0006\u0004\b2\u00103B+\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00101\u001a\u00020\u0002\u0012\u0006\u00104\u001a\u00020\u0002¢\u0006\u0004\b2\u00105J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\fJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0007J\u0017\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010\u001aJ\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0012R\u0018\u0010\u0006\u001a\u0006*\u00020\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010%R$\u0010,\u001a\u0004\u0018\u00010&8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+"}, d2 = {"Lid/dana/statement/view/StatementDateView;", "Lid/dana/base/BaseRichView;", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(II)V", "", "getAuthRequestContext", "(ILjava/lang/String;)Ljava/lang/String;", "PlaceComponentResult", "()Ljava/lang/String;", "getLayout", "()I", "getMonth", "getRunningDate", "hideRollingMonthArrow", "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(II)Z", "(Z)I", "BuiltInFictitiousFunctionClassFactory", "month", "setMonth", "(Ljava/lang/String;)V", "Lid/dana/statement/StatementDateChangeListener;", "statementDateChangeListener", "setOnStatementDateChangeListener", "(Lid/dana/statement/StatementDateChangeListener;)V", "runningDate", "setRunningDate", "setup", "Ljava/util/Calendar;", "Ljava/util/Calendar;", "I", "Lid/dana/statement/StatementDateChangeListener;", "Lid/dana/statement/StatementMenuListener;", "Lid/dana/statement/StatementMenuListener;", "getStatementMenuListener", "()Lid/dana/statement/StatementMenuListener;", "setStatementMenuListener", "(Lid/dana/statement/StatementMenuListener;)V", "statementMenuListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementDateView extends BaseRichView {
    public static final String FULL_MONTH = "MMMM";
    public static final String NEXT_MONTH_LAST_DATE = "01";
    public static final String SHORT_MONTH = "MMM";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private StatementMenuListener statementMenuListener;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Calendar MyBillsEntityDataFactory;
    private StatementDateChangeListener PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    private int getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatementDateView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatementDateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
        return p1 == 2020 && p0 < 7;
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_statement_date;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementDateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = Calendar.getInstance();
        this.getAuthRequestContext = -1;
    }

    public /* synthetic */ StatementDateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementDateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = Calendar.getInstance();
        this.getAuthRequestContext = -1;
    }

    @JvmName(name = "getStatementMenuListener")
    public final StatementMenuListener getStatementMenuListener() {
        return this.statementMenuListener;
    }

    @JvmName(name = "setStatementMenuListener")
    public final void setStatementMenuListener(StatementMenuListener statementMenuListener) {
        this.statementMenuListener = statementMenuListener;
    }

    private final void MyBillsEntityDataFactory(int p0, int p1) {
        if (DateTimeUtil.MyBillsEntityDataFactory(p0) && DateTimeUtil.BuiltInFictitiousFunctionClassFactory(p1)) {
            setRunningDate(PlaceComponentResult());
        } else if ((DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0) && DateTimeUtil.BuiltInFictitiousFunctionClassFactory(p1)) || DateTimeUtil.PlaceComponentResult(p1)) {
            setRunningDate(PlaceComponentResult(p0, "01"));
        } else {
            setRunningDate(PlaceComponentResult(p0, String.valueOf(this.MyBillsEntityDataFactory.getActualMaximum(5))));
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2(p0, p1)) {
            ((ImageView) _$_findCachedViewById(R.id.iv_arrow_left)).setVisibility(8);
        } else {
            ((ImageView) _$_findCachedViewById(R.id.iv_arrow_left)).setVisibility(0);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
        int i = this.MyBillsEntityDataFactory.get(1);
        int i2 = p0 + 1;
        long BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory(i2, i);
        if (DateTimeUtil.MyBillsEntityDataFactory(p0) && DateTimeUtil.BuiltInFictitiousFunctionClassFactory(p1)) {
            long lookAheadTest = DateTimeUtil.lookAheadTest();
            StatementDateChangeListener statementDateChangeListener = this.PlaceComponentResult;
            if (statementDateChangeListener != null) {
                statementDateChangeListener.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, lookAheadTest);
            }
        } else if ((DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0) && DateTimeUtil.BuiltInFictitiousFunctionClassFactory(p1)) || DateTimeUtil.PlaceComponentResult(p1)) {
            long MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(i2, i);
            StatementDateChangeListener statementDateChangeListener2 = this.PlaceComponentResult;
            if (statementDateChangeListener2 != null) {
                statementDateChangeListener2.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory);
            }
        } else {
            long KClassImpl$Data$declaredNonStaticMembers$2 = DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(i2, i);
            StatementDateChangeListener statementDateChangeListener3 = this.PlaceComponentResult;
            if (statementDateChangeListener3 != null) {
                statementDateChangeListener3.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            StatementDateChangeListener statementDateChangeListener4 = this.PlaceComponentResult;
            if (statementDateChangeListener4 != null) {
                statementDateChangeListener4.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    private final String PlaceComponentResult(int p0, String p1) {
        String authRequestContext = getAuthRequestContext(p0, SHORT_MONTH);
        int i = this.MyBillsEntityDataFactory.get(1);
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        sb.append(authRequestContext);
        sb.append(" - ");
        sb.append(p1);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(authRequestContext);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(i);
        return sb.toString();
    }

    private final String getAuthRequestContext(int p0, String p1) {
        this.MyBillsEntityDataFactory.set(2, p0);
        String MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.getTime(), p1, Locale.getDefault());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    private static String PlaceComponentResult() {
        String PlaceComponentResult = DateTimeUtil.PlaceComponentResult("d MMM yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        String PlaceComponentResult2 = DateTimeUtil.PlaceComponentResult(SHORT_MONTH);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        sb.append(PlaceComponentResult2);
        sb.append(" - ");
        sb.append(PlaceComponentResult);
        return sb.toString();
    }

    private final int KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        Calendar calendar = this.MyBillsEntityDataFactory;
        calendar.add(2, p0 ? 1 : -1);
        StatementMenuListener statementMenuListener = this.statementMenuListener;
        if (statementMenuListener != null) {
            statementMenuListener.MyBillsEntityDataFactory(calendar.getTimeInMillis());
        }
        this.getAuthRequestContext = calendar.get(1);
        return calendar.get(2);
    }

    public final void setMonth(String month) {
        ((TextView) _$_findCachedViewById(R.id.getQualifiedNames)).setText(month);
    }

    public final String getMonth() {
        CharSequence text = ((TextView) _$_findCachedViewById(R.id.getQualifiedNames)).getText();
        if (text != null) {
            return (String) text;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void setRunningDate(String runningDate) {
        ((TextView) _$_findCachedViewById(R.id.tv_running_date)).setText(runningDate);
    }

    public final String getRunningDate() {
        CharSequence text = ((TextView) _$_findCachedViewById(R.id.tv_running_date)).getText();
        if (text != null) {
            return (String) text;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void hideRollingMonthArrow() {
        ((LinearLayout) _$_findCachedViewById(R.id.ll_arrow)).setVisibility(8);
    }

    public final void setOnStatementDateChangeListener(StatementDateChangeListener statementDateChangeListener) {
        Intrinsics.checkNotNullParameter(statementDateChangeListener, "");
        this.PlaceComponentResult = statementDateChangeListener;
    }

    /* renamed from: $r8$lambda$CwiXCOK-BGyncF9hZom9nor3Ewc  reason: not valid java name */
    public static /* synthetic */ void m2983$r8$lambda$CwiXCOKBGyncF9hZom9nor3Ewc(StatementDateView statementDateView, View view) {
        Intrinsics.checkNotNullParameter(statementDateView, "");
        int KClassImpl$Data$declaredNonStaticMembers$2 = statementDateView.KClassImpl$Data$declaredNonStaticMembers$2(true);
        statementDateView.setMonth(statementDateView.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, FULL_MONTH));
        statementDateView.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, statementDateView.getAuthRequestContext);
        statementDateView.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, statementDateView.getAuthRequestContext);
    }

    public static /* synthetic */ void $r8$lambda$T0Vdmw3wBRFaUlFRP1DuwCWpjX8(StatementDateView statementDateView, View view) {
        Intrinsics.checkNotNullParameter(statementDateView, "");
        int KClassImpl$Data$declaredNonStaticMembers$2 = statementDateView.KClassImpl$Data$declaredNonStaticMembers$2(false);
        statementDateView.setMonth(statementDateView.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, FULL_MONTH));
        statementDateView.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, statementDateView.getAuthRequestContext);
        statementDateView.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, statementDateView.getAuthRequestContext);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        String PlaceComponentResult = DateTimeUtil.PlaceComponentResult(FULL_MONTH);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        setMonth(PlaceComponentResult);
        setRunningDate(PlaceComponentResult());
        ((ImageView) _$_findCachedViewById(R.id.iv_arrow_left)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.view.StatementDateView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatementDateView.$r8$lambda$T0Vdmw3wBRFaUlFRP1DuwCWpjX8(StatementDateView.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.res_0x7f0a0a7c_nearbyplaceentityrepository_externalsyntheticlambda2)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.view.StatementDateView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatementDateView.m2983$r8$lambda$CwiXCOKBGyncF9hZom9nor3Ewc(StatementDateView.this, view);
            }
        });
    }
}
