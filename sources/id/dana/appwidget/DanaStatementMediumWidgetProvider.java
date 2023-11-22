package id.dana.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.github.mikephil.charting.data.LineDataSet;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.appwidget.AppWidgetPendingIntentCoordinator;
import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.appwidget.model.IncomeAndExpenseEntryChartModel;
import id.dana.base.AbstractContractKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDanaWidgetComponent;
import id.dana.di.modules.DanaAppWidgetModule;
import id.dana.domain.statement.StatementType;
import id.dana.model.CurrencyAmountModel;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.richview.statement.StatementWidgetChartView;
import id.dana.statement.StatementTransactionType;
import id.dana.statement.model.StatementSummaryModel;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementDetailModel;
import id.dana.statement.view.StatementDateView;
import id.dana.util.MinApiUtils;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b?\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0005\u0010\u0013J#\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\"J5\u0010\u000e\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020$0%2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000e\u0010(J\u001f\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010*R\u0016\u0010\u0012\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010+R\u0013\u0010\u0005\u001a\u00020,X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b)\u0010-R\u0013\u0010\u000e\u001a\u00020,X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010-R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u00106R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u0010;\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0013\u0010=\u001a\u00020<X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b;\u0010-R\u0018\u00107\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010>"}, d2 = {"Lid/dana/appwidget/DanaStatementMediumWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "Landroid/widget/RemoteViews;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/widget/RemoteViews;)V", "Landroid/content/Context;", "Landroid/app/PendingIntent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Landroid/app/PendingIntent;", "", "Lid/dana/statement/StatementTransactionType;", "(Ljava/lang/String;)Lid/dana/statement/StatementTransactionType;", "BuiltInFictitiousFunctionClassFactory", "()V", "Lid/dana/statement/model/StatementViewModel;", "", "getAuthRequestContext", "(Lid/dana/statement/model/StatementViewModel;)Z", HummerConstants.CONTEXT, "", "appWidgetIds", "onDeleted", "(Landroid/content/Context;[I)V", "onEnabled", "(Landroid/content/Context;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "", "", "", "p1", "p2", "(Ljava/util/List;Ljava/util/List;Landroid/widget/RemoteViews;)V", "PlaceComponentResult", "(Lid/dana/statement/model/StatementViewModel;Z)V", "[I", "", "Lkotlin/Lazy;", "Landroid/content/Context;", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "danaAppWidgetPresenter", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "getDanaAppWidgetPresenter", "()Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "setDanaAppWidgetPresenter", "(Lid/dana/appwidget/DanaAppWidgetContract$Presenter;)V", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "getErrorConfigVersion", "Z", "moveToNextValue", "Lid/dana/richview/statement/StatementWidgetChartView;", "lookAheadTest", "Landroid/widget/RemoteViews;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DanaStatementMediumWidgetProvider extends AppWidgetProvider {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_MONTH_SUMMARY_CHART_COUNT = 3;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Context MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int[] getAuthRequestContext;
    @Inject
    public DanaAppWidgetContract.Presenter danaAppWidgetPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private RemoteViews NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private List<Integer> scheduleImpl = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.iv_list_item_statement_income_icon_1), Integer.valueOf((int) R.id.iv_list_item_statement_income_icon_2), Integer.valueOf((int) R.id.iv_list_item_statement_income_icon_3), Integer.valueOf((int) R.id.iv_list_item_statement_income_icon_4)});

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private List<Integer> PlaceComponentResult = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.iv_list_item_statement_expense_icon_1), Integer.valueOf((int) R.id.iv_list_item_statement_expense_icon_2), Integer.valueOf((int) R.id.iv_list_item_statement_expense_icon_3), Integer.valueOf((int) R.id.iv_list_item_statement_expense_icon_4)});

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Float>() { // from class: id.dana.appwidget.DanaStatementMediumWidgetProvider$chartWidth$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            Context context;
            context = DanaStatementMediumWidgetProvider.this.MyBillsEntityDataFactory;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            return Float.valueOf(context.getResources().getDimension(R.dimen.f34242131166219));
        }
    });

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Float>() { // from class: id.dana.appwidget.DanaStatementMediumWidgetProvider$chartHeight$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            Context context;
            context = DanaStatementMediumWidgetProvider.this.MyBillsEntityDataFactory;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            return Float.valueOf(context.getResources().getDimension(R.dimen.f34232131166218));
        }
    });

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<StatementWidgetChartView>() { // from class: id.dana.appwidget.DanaStatementMediumWidgetProvider$lineChartView$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StatementWidgetChartView invoke() {
            float floatValue;
            float floatValue2;
            Context context;
            float floatValue3;
            float floatValue4;
            float floatValue5;
            float floatValue6;
            float floatValue7;
            float floatValue8;
            floatValue = ((Number) DanaStatementMediumWidgetProvider.this.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            floatValue2 = ((Number) DanaStatementMediumWidgetProvider.this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).floatValue();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) floatValue, (int) floatValue2);
            context = DanaStatementMediumWidgetProvider.this.MyBillsEntityDataFactory;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            StatementWidgetChartView statementWidgetChartView = new StatementWidgetChartView(context);
            DanaStatementMediumWidgetProvider danaStatementMediumWidgetProvider = DanaStatementMediumWidgetProvider.this;
            statementWidgetChartView.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = statementWidgetChartView.getLayoutParams();
            floatValue3 = ((Number) danaStatementMediumWidgetProvider.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            layoutParams2.width = (int) floatValue3;
            ViewGroup.LayoutParams layoutParams3 = statementWidgetChartView.getLayoutParams();
            floatValue4 = ((Number) danaStatementMediumWidgetProvider.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).floatValue();
            layoutParams3.height = (int) floatValue4;
            floatValue5 = ((Number) danaStatementMediumWidgetProvider.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            floatValue6 = ((Number) danaStatementMediumWidgetProvider.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).floatValue();
            statementWidgetChartView.measure((int) floatValue5, (int) floatValue6);
            int left = statementWidgetChartView.getLeft();
            int top = statementWidgetChartView.getTop();
            floatValue7 = ((Number) danaStatementMediumWidgetProvider.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            floatValue8 = ((Number) danaStatementMediumWidgetProvider.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).floatValue();
            statementWidgetChartView.layout(left, top, (int) floatValue7, (int) floatValue8);
            return statementWidgetChartView;
        }
    });

    @JvmStatic
    public static final void toggleLoginView(Context context, boolean z) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, z);
    }

    @JvmStatic
    public static final void updateStatementWidget(Context context) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(context);
    }

    @JvmName(name = "getDanaAppWidgetPresenter")
    public final DanaAppWidgetContract.Presenter getDanaAppWidgetPresenter() {
        DanaAppWidgetContract.Presenter presenter = this.danaAppWidgetPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDanaAppWidgetPresenter")
    public final void setDanaAppWidgetPresenter(DanaAppWidgetContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.danaAppWidgetPresenter = presenter;
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(appWidgetManager, "");
        Intrinsics.checkNotNullParameter(appWidgetIds, "");
        this.getAuthRequestContext = appWidgetIds;
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        int i;
        Context context = null;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            Context context2 = this.MyBillsEntityDataFactory;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context2 = null;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new RemoteViews(context2.getPackageName(), (int) R.layout.widget_dana_statement_medium);
        }
        if (this.danaAppWidgetPresenter == null) {
            Context context3 = this.MyBillsEntityDataFactory;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context3 = null;
            }
            Context applicationContext = context3.getApplicationContext();
            if (applicationContext == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
            }
            ApplicationComponent applicationComponent = ((DanaApplication) applicationContext).getApplicationComponent();
            DaggerDanaWidgetComponent.Builder PlaceComponentResult = DaggerDanaWidgetComponent.PlaceComponentResult();
            PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaAppWidgetModule) Preconditions.getAuthRequestContext(new DanaAppWidgetModule(new DanaAppWidgetContract.View() { // from class: id.dana.appwidget.DanaStatementMediumWidgetProvider$getDanaWidgetModule$1
                @Override // id.dana.appwidget.DanaAppWidgetContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(UserStatementDetailModel userStatementDetailModel) {
                    Intrinsics.checkNotNullParameter(userStatementDetailModel, "");
                }

                @Override // id.dana.appwidget.DanaAppWidgetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(CurrencyAmountModel currencyAmountModel) {
                    DanaAppWidgetContract.View.CC.MyBillsEntityDataFactory(currencyAmountModel);
                }

                @Override // id.dana.appwidget.DanaAppWidgetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(UserStatementDetailModel userStatementDetailModel) {
                    DanaAppWidgetContract.View.CC.MyBillsEntityDataFactory(userStatementDetailModel);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    DanaStatementMediumWidgetProvider.access$toggleWidgetLoginView(DanaStatementMediumWidgetProvider.this, 2);
                }

                @Override // id.dana.appwidget.DanaAppWidgetContract.View
                public final void getAuthRequestContext(List<StatementViewModel> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    DanaStatementMediumWidgetProvider.access$setStatementSummary(DanaStatementMediumWidgetProvider.this, p0);
                    DanaStatementMediumWidgetProvider.access$toggleWidgetLoginView(DanaStatementMediumWidgetProvider.this, 0);
                    DanaStatementMediumWidgetProvider.this.moveToNextValue = false;
                }

                @Override // id.dana.appwidget.DanaAppWidgetContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    DanaStatementMediumWidgetProvider.access$toggleWidgetLoginView(DanaStatementMediumWidgetProvider.this, 1);
                }

                @Override // id.dana.appwidget.DanaAppWidgetContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(IncomeAndExpenseEntryChartModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    DanaStatementMediumWidgetProvider.access$setupChartView(DanaStatementMediumWidgetProvider.this, p0);
                    DanaStatementMediumWidgetProvider.access$toggleWidgetLoginView(DanaStatementMediumWidgetProvider.this, 0);
                    DanaStatementMediumWidgetProvider.this.moveToNextValue = false;
                }
            }));
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        RemoteViews remoteViews = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (remoteViews != null) {
            Context context4 = this.MyBillsEntityDataFactory;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context4 = null;
            }
            remoteViews.setOnClickPendingIntent(R.id.ib_dana_statement_medium_refresh, MyBillsEntityDataFactory(context4));
        }
        RemoteViews remoteViews2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (remoteViews2 != null) {
            Context context5 = this.MyBillsEntityDataFactory;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context5 = null;
            }
            remoteViews2.setOnClickPendingIntent(R.id.dana_statement_medium_refresh, MyBillsEntityDataFactory(context5));
        }
        RemoteViews remoteViews3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (remoteViews3 != null) {
            Context context6 = this.MyBillsEntityDataFactory;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context6 = null;
            }
            Intent intent = new Intent(context6, LocalConfigSplashActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("CATEGORY_LOGIN_STATEMENT_ACTION_M");
            intent.setFlags(268468224);
            intent.addCategory("android.shortcut.conversation");
            int i2 = MinApiUtils.PlaceComponentResult() ? 33554432 : 0;
            Context context7 = this.MyBillsEntityDataFactory;
            if (context7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                context = context7;
            }
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, i2);
            Intrinsics.checkNotNullExpressionValue(activity, "");
            remoteViews3.setOnClickPendingIntent(R.id.vg_login_view_login_button, activity);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        String PlaceComponentResult2 = DateTimeUtil.PlaceComponentResult("d MMM yyyy");
        i = Calendar.getInstance().get(2);
        String authRequestContext = DateTimeUtil.getAuthRequestContext(i);
        if (DateTimeUtil.getAuthRequestContext() == 1) {
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("1-");
            sb.append(PlaceComponentResult2);
            PlaceComponentResult2 = sb.toString();
        }
        RemoteViews remoteViews4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (remoteViews4 != null) {
            remoteViews4.setTextViewText(R.id.tv_dana_statement_medium_date, PlaceComponentResult2);
        }
        RemoteViews remoteViews5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (remoteViews5 != null) {
            remoteViews5.setTextViewText(R.id.tv_dana_statement_medium_title_month, authRequestContext);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        ((StatementWidgetChartView) this.lookAheadTest.getValue()).setStartPosition(DateTimeUtil.getAuthRequestContext() - 2);
        ((StatementWidgetChartView) this.lookAheadTest.getValue()).build();
        this.moveToNextValue = true;
        getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.appwidget.DanaStatementMediumWidgetProvider$initAll$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaStatementMediumWidgetProvider.this.getDanaAppWidgetPresenter().BuiltInFictitiousFunctionClassFactory();
            }
        });
        getDanaAppWidgetPresenter().getAuthRequestContext();
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        if (this.danaAppWidgetPresenter != null) {
            getDanaAppWidgetPresenter().onDestroy();
        }
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(intent, "");
        this.MyBillsEntityDataFactory = context;
        if (intent.hasExtra("STATEMENT_MEDIUM_WIDGET_IDS_KEY")) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new RemoteViews(context.getPackageName(), (int) R.layout.widget_dana_statement_medium);
            }
            Bundle extras = intent.getExtras();
            int[] intArray = extras != null ? extras.getIntArray("STATEMENT_MEDIUM_WIDGET_IDS_KEY") : null;
            if (intArray == null) {
                intArray = new int[0];
            }
            this.getAuthRequestContext = intArray;
            if (!Intrinsics.areEqual(intent.getAction(), "REFRESH_BUTTON_ACTION_TAG_STATEMENT_STATEMENT_MEDIUM")) {
                if (intent.hasExtra("STATEMENT_MEDIUM_WIDGET_DATA_LOGIN_VIEW_KEY")) {
                    boolean booleanExtra = intent.getBooleanExtra("STATEMENT_MEDIUM_WIDGET_DATA_LOGIN_VIEW_KEY", false);
                    AppWidgetPendingIntentCoordinator.Companion companion = AppWidgetPendingIntentCoordinator.INSTANCE;
                    int KClassImpl$Data$declaredNonStaticMembers$2 = AppWidgetPendingIntentCoordinator.Companion.KClassImpl$Data$declaredNonStaticMembers$2(booleanExtra, this.moveToNextValue);
                    RemoteViews remoteViews = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (remoteViews != null) {
                        remoteViews.setDisplayedChild(R.id.vf_dana_statement_medium_widget, KClassImpl$Data$declaredNonStaticMembers$2);
                        KClassImpl$Data$declaredNonStaticMembers$2(remoteViews);
                    }
                    if (this.moveToNextValue || KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                        return;
                    }
                    RemoteViews remoteViews2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (remoteViews2 != null) {
                        remoteViews2.setDisplayedChild(R.id.vf_dana_statement_medium_widget, 2);
                        KClassImpl$Data$declaredNonStaticMembers$2(remoteViews2);
                    }
                    BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                return;
            }
            RemoteViews remoteViews3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (remoteViews3 != null) {
                remoteViews3.setDisplayedChild(R.id.vf_dana_statement_medium_widget, 2);
                KClassImpl$Data$declaredNonStaticMembers$2(remoteViews3);
            }
            BuiltInFictitiousFunctionClassFactory();
            return;
        }
        super.onReceive(context, intent);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(StatementViewModel p0) {
        return Intrinsics.areEqual(StatementType.INCOME.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    private static boolean getAuthRequestContext(StatementViewModel p0) {
        return Intrinsics.areEqual(StatementType.EXPENSE.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    private final PendingIntent MyBillsEntityDataFactory(Context p0) {
        Intent intent = new Intent(p0, getClass());
        intent.setAction("REFRESH_BUTTON_ACTION_TAG_STATEMENT_STATEMENT_MEDIUM");
        int[] iArr = this.getAuthRequestContext;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            iArr = null;
        }
        intent.putExtra("STATEMENT_MEDIUM_WIDGET_IDS_KEY", iArr);
        PendingIntent broadcast = PendingIntent.getBroadcast(p0, 0, intent, MinApiUtils.PlaceComponentResult() ? 167772160 : 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "");
        return broadcast;
    }

    private final void BuiltInFictitiousFunctionClassFactory(List<Integer> p0, List<Integer> p1, RemoteViews p2) {
        if (p1.size() > 4) {
            return;
        }
        int size = p1.size();
        int i = 0;
        for (Object obj : p1) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) obj).intValue();
            if (p2 != null) {
                p2.setImageViewResource(p0.get(i).intValue(), intValue);
            }
            if (p2 != null) {
                p2.setViewVisibility(p0.get(i).intValue(), 0);
            }
            i++;
        }
        int i2 = 4 - (4 - size);
        int i3 = 3;
        if (i2 <= 3) {
            while (true) {
                if (p2 != null) {
                    p2.setViewVisibility(p0.get(i3).intValue(), 4);
                }
                if (i3 == i2) {
                    break;
                }
                i3--;
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2(p2);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(RemoteViews p0) {
        if (p0 != null) {
            Context context = this.MyBillsEntityDataFactory;
            int[] iArr = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] iArr2 = this.getAuthRequestContext;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                iArr = iArr2;
            }
            appWidgetManager.partiallyUpdateAppWidget(iArr, p0);
        }
    }

    private static StatementTransactionType MyBillsEntityDataFactory(String p0) {
        return Intrinsics.areEqual(p0, StatementTransactionType.TOPUP.getBizType()) ? StatementTransactionType.TOPUP : Intrinsics.areEqual(p0, StatementTransactionType.CASHBACK.getBizType()) ? StatementTransactionType.CASHBACK : Intrinsics.areEqual(p0, StatementTransactionType.RECEIVEMONEY.getBizType()) ? StatementTransactionType.RECEIVEMONEY : Intrinsics.areEqual(p0, StatementTransactionType.DANAKAGET.getBizType()) ? StatementTransactionType.DANAKAGET : Intrinsics.areEqual(p0, StatementTransactionType.SERVICES.getBizType()) ? StatementTransactionType.SERVICES : Intrinsics.areEqual(p0, StatementTransactionType.MERCHANT.getBizType()) ? StatementTransactionType.MERCHANT : Intrinsics.areEqual(p0, StatementTransactionType.SENDMONEY.getBizType()) ? StatementTransactionType.SENDMONEY : Intrinsics.areEqual(p0, StatementTransactionType.CASHOUT.getBizType()) ? StatementTransactionType.CASHOUT : StatementTransactionType.DEFAULT;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/appwidget/DanaStatementMediumWidgetProvider$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)V", "", "MAX_MONTH_SUMMARY_CHART_COUNT", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(p0).getAppWidgetIds(new ComponentName(p0, DanaStatementMediumWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("STATEMENT_MEDIUM_WIDGET_IDS_KEY", appWidgetIds);
            intent.setAction("REFRESH_BUTTON_ACTION_TAG_STATEMENT_STATEMENT_MEDIUM");
            p0.sendBroadcast(intent);
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context p0, boolean p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(p0).getAppWidgetIds(new ComponentName(p0, DanaStatementMediumWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("STATEMENT_MEDIUM_WIDGET_IDS_KEY", appWidgetIds);
            intent.putExtra("STATEMENT_MEDIUM_WIDGET_DATA_LOGIN_VIEW_KEY", p1);
            p0.sendBroadcast(intent);
        }
    }

    public static final /* synthetic */ Unit access$setStatementSummary(DanaStatementMediumWidgetProvider danaStatementMediumWidgetProvider, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                StatementViewModel statementViewModel = (StatementViewModel) it.next();
                if (1 == statementViewModel.getAuthRequestContext && KClassImpl$Data$declaredNonStaticMembers$2(statementViewModel)) {
                    danaStatementMediumWidgetProvider.PlaceComponentResult(statementViewModel, true);
                } else if (1 == statementViewModel.getAuthRequestContext && getAuthRequestContext(statementViewModel)) {
                    danaStatementMediumWidgetProvider.PlaceComponentResult(statementViewModel, false);
                }
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ void access$setupChartView(DanaStatementMediumWidgetProvider danaStatementMediumWidgetProvider, IncomeAndExpenseEntryChartModel incomeAndExpenseEntryChartModel) {
        StatementWidgetChartView statementWidgetChartView = (StatementWidgetChartView) danaStatementMediumWidgetProvider.lookAheadTest.getValue();
        statementWidgetChartView.invalidate();
        statementWidgetChartView.clear();
        Calendar calendar = Calendar.getInstance();
        List<String> KClassImpl$Data$declaredNonStaticMembers$2 = DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(calendar.getTimeInMillis(), 3, StatementDateView.SHORT_MONTH, Boolean.TRUE);
        calendar.add(2, 1);
        List<String> KClassImpl$Data$declaredNonStaticMembers$22 = DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(calendar.getTimeInMillis(), 3, StatementDateView.SHORT_MONTH, Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        KClassImpl$Data$declaredNonStaticMembers$2.addAll(KClassImpl$Data$declaredNonStaticMembers$22);
        ((StatementWidgetChartView) danaStatementMediumWidgetProvider.lookAheadTest.getValue()).setMonths((ArrayList) KClassImpl$Data$declaredNonStaticMembers$2);
        ((StatementWidgetChartView) danaStatementMediumWidgetProvider.lookAheadTest.getValue()).setLineDataSet1(new LineDataSet(incomeAndExpenseEntryChartModel.KClassImpl$Data$declaredNonStaticMembers$2, "income"));
        ((StatementWidgetChartView) danaStatementMediumWidgetProvider.lookAheadTest.getValue()).setLineDataSet2(new LineDataSet(incomeAndExpenseEntryChartModel.getAuthRequestContext, "expense"));
        ((StatementWidgetChartView) danaStatementMediumWidgetProvider.lookAheadTest.getValue()).setMaxXAxisRange(3);
        ((StatementWidgetChartView) danaStatementMediumWidgetProvider.lookAheadTest.getValue()).build();
        Bitmap chartBitmap = ((StatementWidgetChartView) danaStatementMediumWidgetProvider.lookAheadTest.getValue()).getChartBitmap();
        RemoteViews remoteViews = danaStatementMediumWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (remoteViews != null) {
            remoteViews.setImageViewBitmap(R.id.iv_dana_statement_medium_chart_preview, chartBitmap);
        }
        danaStatementMediumWidgetProvider.KClassImpl$Data$declaredNonStaticMembers$2(danaStatementMediumWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public static final /* synthetic */ void access$toggleWidgetLoginView(DanaStatementMediumWidgetProvider danaStatementMediumWidgetProvider, int i) {
        RemoteViews remoteViews = danaStatementMediumWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (remoteViews != null) {
            remoteViews.setDisplayedChild(R.id.vf_dana_statement_medium_widget, i);
            danaStatementMediumWidgetProvider.KClassImpl$Data$declaredNonStaticMembers$2(remoteViews);
        }
    }

    private final void PlaceComponentResult(StatementViewModel p0, boolean p1) {
        List<Integer> list;
        List<StatementSummaryModel> list2 = p0.PlaceComponentResult.MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList();
        if (p1) {
            list = this.scheduleImpl;
            RemoteViews remoteViews = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (remoteViews != null) {
                CurrencyAmountModel currencyAmountModel = p0.PlaceComponentResult.getAuthRequestContext;
                remoteViews.setTextViewText(R.id.tv_dana_statement_medium_income_balance_amount, currencyAmountModel != null ? currencyAmountModel.getAuthRequestContext() : null);
            }
        } else {
            list = this.PlaceComponentResult;
            RemoteViews remoteViews2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (remoteViews2 != null) {
                CurrencyAmountModel currencyAmountModel2 = p0.PlaceComponentResult.getAuthRequestContext;
                remoteViews2.setTextViewText(R.id.tv_dana_statement_medium_expense_balance_amount, currencyAmountModel2 != null ? currencyAmountModel2.getAuthRequestContext() : null);
            }
        }
        if (list2 == null) {
            return;
        }
        int size = list2.size();
        for (int i = 0; i < size && i <= 4; i++) {
            arrayList.add(Integer.valueOf(MyBillsEntityDataFactory(list2.get(i).getAuthRequestContext).getDrawableIcon()));
        }
        BuiltInFictitiousFunctionClassFactory(list, arrayList, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
