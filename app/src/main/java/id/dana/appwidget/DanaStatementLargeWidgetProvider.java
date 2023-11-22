package id.dana.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
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
import id.dana.appwidget.collectionview.StatementExpenseListWidgetService;
import id.dana.appwidget.collectionview.StatementWidgetService;
import id.dana.appwidget.model.IncomeAndExpenseEntryChartModel;
import id.dana.base.AbstractContractKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDanaWidgetComponent;
import id.dana.di.modules.DanaAppWidgetModule;
import id.dana.domain.statement.StatementType;
import id.dana.model.CurrencyAmountModel;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.richview.statement.StatementWidgetChartView;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b2\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\t\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\t\u0010\u000fJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u000bR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0013\u0010\u001e\u001a\u00020!X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0013\u0010\u000e\u001a\u00020!X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0016\u0010\u0005\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010#R\"\u0010%\u001a\u00020$8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010\t\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010+R\u0013\u0010.\u001a\u00020,X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b-\u0010\"R\u0018\u00101\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/appwidget/DanaStatementLargeWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "Landroid/widget/RemoteViews;", "p0", "", "getAuthRequestContext", "(Landroid/widget/RemoteViews;)V", "Landroid/content/Context;", "Landroid/app/PendingIntent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Landroid/app/PendingIntent;", "()V", "Lid/dana/statement/model/StatementViewModel;", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/statement/model/StatementViewModel;)Z", HummerConstants.CONTEXT, "onDisabled", "(Landroid/content/Context;)V", "onEnabled", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "[I", "", "Lkotlin/Lazy;", "Landroid/content/Context;", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "danaAppWidgetPresenter", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "getDanaAppWidgetPresenter", "()Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "setDanaAppWidgetPresenter", "(Lid/dana/appwidget/DanaAppWidgetContract$Presenter;)V", "Z", "Lid/dana/richview/statement/StatementWidgetChartView;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "Landroid/widget/RemoteViews;", "lookAheadTest", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DanaStatementLargeWidgetProvider extends AppWidgetProvider {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int[] KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public DanaAppWidgetContract.Presenter danaAppWidgetPresenter;
    private Context getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private RemoteViews lookAheadTest;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<StatementWidgetChartView>() { // from class: id.dana.appwidget.DanaStatementLargeWidgetProvider$lineChartView$2
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
            floatValue = ((Number) DanaStatementLargeWidgetProvider.this.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            floatValue2 = ((Number) DanaStatementLargeWidgetProvider.this.PlaceComponentResult.getValue()).floatValue();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) floatValue, (int) floatValue2);
            context = DanaStatementLargeWidgetProvider.this.getAuthRequestContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            StatementWidgetChartView statementWidgetChartView = new StatementWidgetChartView(context);
            DanaStatementLargeWidgetProvider danaStatementLargeWidgetProvider = DanaStatementLargeWidgetProvider.this;
            statementWidgetChartView.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = statementWidgetChartView.getLayoutParams();
            floatValue3 = ((Number) danaStatementLargeWidgetProvider.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            layoutParams2.width = (int) floatValue3;
            ViewGroup.LayoutParams layoutParams3 = statementWidgetChartView.getLayoutParams();
            floatValue4 = ((Number) danaStatementLargeWidgetProvider.PlaceComponentResult.getValue()).floatValue();
            layoutParams3.height = (int) floatValue4;
            floatValue5 = ((Number) danaStatementLargeWidgetProvider.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            floatValue6 = ((Number) danaStatementLargeWidgetProvider.PlaceComponentResult.getValue()).floatValue();
            statementWidgetChartView.measure((int) floatValue5, (int) floatValue6);
            int left = statementWidgetChartView.getLeft();
            int top = statementWidgetChartView.getTop();
            floatValue7 = ((Number) danaStatementLargeWidgetProvider.BuiltInFictitiousFunctionClassFactory.getValue()).floatValue();
            floatValue8 = ((Number) danaStatementLargeWidgetProvider.PlaceComponentResult.getValue()).floatValue();
            statementWidgetChartView.layout(left, top, (int) floatValue7, (int) floatValue8);
            return statementWidgetChartView;
        }
    });
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Float>() { // from class: id.dana.appwidget.DanaStatementLargeWidgetProvider$chartWidth$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            Context context;
            context = DanaStatementLargeWidgetProvider.this.getAuthRequestContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            return Float.valueOf(context.getResources().getDimension(R.dimen.f34222131166217));
        }
    });

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<Float>() { // from class: id.dana.appwidget.DanaStatementLargeWidgetProvider$chartHeight$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            Context context;
            context = DanaStatementLargeWidgetProvider.this.getAuthRequestContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            return Float.valueOf(context.getResources().getDimension(R.dimen.f34212131166216));
        }
    });

    @JvmStatic
    public static final void toggleLoginView(Context context, boolean z) {
        Companion.getAuthRequestContext(context, z);
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
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(appWidgetManager, "");
        Intrinsics.checkNotNullParameter(appWidgetIds, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appWidgetIds;
        for (int i : appWidgetIds) {
            this.getAuthRequestContext = context;
            getAuthRequestContext();
            Intent intent = new Intent(context, StatementWidgetService.class);
            intent.putExtra("appWidgetId", i);
            intent.setData(Uri.parse(intent.toUri(1)));
            RemoteViews remoteViews = this.lookAheadTest;
            if (remoteViews != null) {
                remoteViews.setRemoteAdapter(R.id.lv_dana_statement_large_income_list, intent);
            }
            Intent intent2 = new Intent(context, StatementExpenseListWidgetService.class);
            intent2.putExtra("appWidgetId", i);
            intent2.setData(Uri.parse(intent2.toUri(1)));
            RemoteViews remoteViews2 = this.lookAheadTest;
            if (remoteViews2 != null) {
                remoteViews2.setRemoteAdapter(R.id.lv_dana_statement_large_expense_list, intent2);
            }
            getAuthRequestContext(this.lookAheadTest);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (this.danaAppWidgetPresenter != null) {
            getDanaAppWidgetPresenter().onDestroy();
        }
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(intent, "");
        this.getAuthRequestContext = context;
        if (intent.hasExtra("STATEMENT_LARGE_WIDGET_IDS_KEY")) {
            if (this.lookAheadTest == null) {
                this.lookAheadTest = new RemoteViews(context.getPackageName(), (int) R.layout.widget_dana_statement_large);
            }
            Bundle extras = intent.getExtras();
            int[] intArray = extras != null ? extras.getIntArray("STATEMENT_LARGE_WIDGET_IDS_KEY") : null;
            if (intArray == null) {
                intArray = new int[0];
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = intArray;
            if (!Intrinsics.areEqual(intent.getAction(), "REFRESH_BUTTON_ACTION_TAG_STATEMENT_STATEMENT_LARGE")) {
                if (intent.hasExtra("STATEMENT_LARGE_WIDGET_DATA_LOGIN_VIEW_KEY")) {
                    boolean booleanExtra = intent.getBooleanExtra("STATEMENT_LARGE_WIDGET_DATA_LOGIN_VIEW_KEY", false);
                    AppWidgetPendingIntentCoordinator.Companion companion = AppWidgetPendingIntentCoordinator.INSTANCE;
                    int KClassImpl$Data$declaredNonStaticMembers$2 = AppWidgetPendingIntentCoordinator.Companion.KClassImpl$Data$declaredNonStaticMembers$2(booleanExtra, this.MyBillsEntityDataFactory);
                    RemoteViews remoteViews = this.lookAheadTest;
                    if (remoteViews != null) {
                        remoteViews.setDisplayedChild(R.id.vf_dana_statement_large_widget, KClassImpl$Data$declaredNonStaticMembers$2);
                        getAuthRequestContext(remoteViews);
                    }
                    if (!this.MyBillsEntityDataFactory && KClassImpl$Data$declaredNonStaticMembers$2 != 1) {
                        RemoteViews remoteViews2 = this.lookAheadTest;
                        if (remoteViews2 != null) {
                            remoteViews2.setDisplayedChild(R.id.vf_dana_statement_large_widget, 2);
                            getAuthRequestContext(remoteViews2);
                        }
                        PlaceComponentResult();
                    }
                }
            } else {
                RemoteViews remoteViews3 = this.lookAheadTest;
                if (remoteViews3 != null) {
                    remoteViews3.setDisplayedChild(R.id.vf_dana_statement_large_widget, 2);
                    getAuthRequestContext(remoteViews3);
                }
                PlaceComponentResult();
            }
        }
        super.onReceive(context, intent);
    }

    private final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory = true;
        if (this.danaAppWidgetPresenter != null) {
            MyBillsEntityDataFactory();
            getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaStatementLargeWidgetProvider$loadChartData$1(this));
            return;
        }
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        Context context = null;
        if (this.lookAheadTest == null) {
            Context context2 = this.getAuthRequestContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context2 = null;
            }
            this.lookAheadTest = new RemoteViews(context2.getPackageName(), (int) R.layout.widget_dana_statement_large);
        }
        Context context3 = this.getAuthRequestContext;
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaAppWidgetModule) Preconditions.getAuthRequestContext(new DanaAppWidgetModule(new DanaAppWidgetContract.View() { // from class: id.dana.appwidget.DanaStatementLargeWidgetProvider$getDanaWidgetModule$1
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
                DanaStatementLargeWidgetProvider.access$toggleWidgetLoginView(DanaStatementLargeWidgetProvider.this, 2);
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final void getAuthRequestContext(List<StatementViewModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaStatementLargeWidgetProvider.access$toggleWidgetLoginView(DanaStatementLargeWidgetProvider.this, 0);
                DanaStatementLargeWidgetProvider.this.MyBillsEntityDataFactory = false;
                DanaStatementLargeWidgetProvider.access$setStatementSummary(DanaStatementLargeWidgetProvider.this, p0);
                DanaStatementLargeWidgetProvider.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                DanaStatementLargeWidgetProvider.access$toggleWidgetLoginView(DanaStatementLargeWidgetProvider.this, 1);
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(IncomeAndExpenseEntryChartModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaStatementLargeWidgetProvider.access$toggleWidgetLoginView(DanaStatementLargeWidgetProvider.this, 0);
                DanaStatementLargeWidgetProvider.this.MyBillsEntityDataFactory = false;
                DanaStatementLargeWidgetProvider.access$setupChartView(DanaStatementLargeWidgetProvider.this, p0);
            }
        }));
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(this);
        ((StatementWidgetChartView) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).setStartPosition(DateTimeUtil.getAuthRequestContext() - 2);
        ((StatementWidgetChartView) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).build();
        KClassImpl$Data$declaredNonStaticMembers$2();
        RemoteViews remoteViews = this.lookAheadTest;
        if (remoteViews != null) {
            Context context4 = this.getAuthRequestContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context4 = null;
            }
            remoteViews.setOnClickPendingIntent(R.id.ib_dana_statement_large_refresh, MyBillsEntityDataFactory(context4));
        }
        RemoteViews remoteViews2 = this.lookAheadTest;
        if (remoteViews2 != null) {
            Context context5 = this.getAuthRequestContext;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context5 = null;
            }
            remoteViews2.setOnClickPendingIntent(R.id.dana_statement_large_refresh, MyBillsEntityDataFactory(context5));
        }
        RemoteViews remoteViews3 = this.lookAheadTest;
        if (remoteViews3 != null) {
            Context context6 = this.getAuthRequestContext;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context6 = null;
            }
            Intent intent = new Intent(context6, LocalConfigSplashActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("CATEGORY_LOGIN_STATEMENT_LARGE_WIDGET");
            intent.setFlags(268468224);
            intent.addCategory("android.shortcut.conversation");
            int i = MinApiUtils.PlaceComponentResult() ? 33554432 : 0;
            Context context7 = this.getAuthRequestContext;
            if (context7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context7 = null;
            }
            PendingIntent activity = PendingIntent.getActivity(context7, 0, intent, i);
            Intrinsics.checkNotNullExpressionValue(activity, "");
            remoteViews3.setOnClickPendingIntent(R.id.vg_login_view_login_button, activity);
        }
        RemoteViews remoteViews4 = this.lookAheadTest;
        if (remoteViews4 != null) {
            AppWidgetPendingIntentCoordinator.Companion companion = AppWidgetPendingIntentCoordinator.INSTANCE;
            Context context8 = this.getAuthRequestContext;
            if (context8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                context = context8;
            }
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "");
            remoteViews4.setOnClickPendingIntent(R.id.vg_dana_statement_large_widget_root, AppWidgetPendingIntentCoordinator.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, simpleName, StatementType.EXPENSE.name()));
        }
        getAuthRequestContext(this.lookAheadTest);
        this.MyBillsEntityDataFactory = true;
        MyBillsEntityDataFactory();
        getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaStatementLargeWidgetProvider$loadChartData$1(this));
    }

    private final void MyBillsEntityDataFactory() {
        getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.appwidget.DanaStatementLargeWidgetProvider$loadStatementData$1
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
                DanaStatementLargeWidgetProvider.this.getDanaAppWidgetPresenter().BuiltInFictitiousFunctionClassFactory();
            }
        });
        Context context = this.getAuthRequestContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, DanaStatementLargeWidgetProvider.class);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetManager.getAppWidgetIds(componentName), R.id.lv_dana_statement_large_income_list);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetManager.getAppWidgetIds(componentName), R.id.lv_dana_statement_large_expense_list);
    }

    private static boolean MyBillsEntityDataFactory(StatementViewModel p0) {
        return Intrinsics.areEqual(StatementType.INCOME.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(StatementViewModel p0) {
        return Intrinsics.areEqual(StatementType.EXPENSE.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    private final PendingIntent MyBillsEntityDataFactory(Context p0) {
        Intent intent = new Intent(p0, getClass());
        intent.setAction("REFRESH_BUTTON_ACTION_TAG_STATEMENT_STATEMENT_LARGE");
        int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            iArr = null;
        }
        intent.putExtra("STATEMENT_LARGE_WIDGET_IDS_KEY", iArr);
        PendingIntent broadcast = PendingIntent.getBroadcast(p0, 0, intent, MinApiUtils.PlaceComponentResult() ? 167772160 : 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "");
        return broadcast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i;
        String PlaceComponentResult = DateTimeUtil.PlaceComponentResult("d MMM yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("1-");
        sb.append(PlaceComponentResult);
        String obj = sb.toString();
        RemoteViews remoteViews = this.lookAheadTest;
        if (remoteViews != null) {
            remoteViews.setTextViewText(R.id.tv_dana_statement_large_date, obj);
        }
        RemoteViews remoteViews2 = this.lookAheadTest;
        if (remoteViews2 != null) {
            i = Calendar.getInstance().get(2);
            remoteViews2.setTextViewText(R.id.tv_dana_statement_large_title_month, DateTimeUtil.getAuthRequestContext(i));
        }
        getAuthRequestContext(this.lookAheadTest);
    }

    private final void getAuthRequestContext(RemoteViews p0) {
        Context context = this.getAuthRequestContext;
        int[] iArr = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] iArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            iArr = iArr2;
        }
        appWidgetManager.partiallyUpdateAppWidget(iArr, p0);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/appwidget/DanaStatementLargeWidgetProvider$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "getAuthRequestContext", "(Landroid/content/Context;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            int[] appWidgetIds = AppWidgetManager.getInstance(p0).getAppWidgetIds(new ComponentName(p0, DanaStatementLargeWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("STATEMENT_LARGE_WIDGET_IDS_KEY", appWidgetIds);
            intent.setAction("REFRESH_BUTTON_ACTION_TAG_STATEMENT_STATEMENT_LARGE");
            p0.sendBroadcast(intent);
        }

        @JvmStatic
        public static void getAuthRequestContext(Context p0, boolean p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(p0).getAppWidgetIds(new ComponentName(p0, DanaStatementLargeWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("STATEMENT_LARGE_WIDGET_IDS_KEY", appWidgetIds);
            intent.putExtra("STATEMENT_LARGE_WIDGET_DATA_LOGIN_VIEW_KEY", p1);
            p0.sendBroadcast(intent);
        }
    }

    public static final /* synthetic */ Unit access$setStatementSummary(DanaStatementLargeWidgetProvider danaStatementLargeWidgetProvider, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                StatementViewModel statementViewModel = (StatementViewModel) it.next();
                String str = "";
                if (1 == statementViewModel.getAuthRequestContext && MyBillsEntityDataFactory(statementViewModel)) {
                    CurrencyAmountModel currencyAmountModel = statementViewModel.PlaceComponentResult.getAuthRequestContext;
                    String authRequestContext = currencyAmountModel != null ? currencyAmountModel.getAuthRequestContext() : null;
                    if (authRequestContext != null) {
                        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                        str = authRequestContext;
                    }
                    RemoteViews remoteViews = danaStatementLargeWidgetProvider.lookAheadTest;
                    if (remoteViews != null) {
                        remoteViews.setTextViewText(R.id.tv_dana_statement_large_income_balance_amount, str);
                    }
                    danaStatementLargeWidgetProvider.getAuthRequestContext(danaStatementLargeWidgetProvider.lookAheadTest);
                } else if (1 == statementViewModel.getAuthRequestContext && BuiltInFictitiousFunctionClassFactory(statementViewModel)) {
                    CurrencyAmountModel currencyAmountModel2 = statementViewModel.PlaceComponentResult.getAuthRequestContext;
                    String authRequestContext2 = currencyAmountModel2 != null ? currencyAmountModel2.getAuthRequestContext() : null;
                    if (authRequestContext2 != null) {
                        Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
                        str = authRequestContext2;
                    }
                    RemoteViews remoteViews2 = danaStatementLargeWidgetProvider.lookAheadTest;
                    if (remoteViews2 != null) {
                        remoteViews2.setTextViewText(R.id.tv_dana_statement_large_expense_balance_amount, str);
                    }
                    danaStatementLargeWidgetProvider.getAuthRequestContext(danaStatementLargeWidgetProvider.lookAheadTest);
                }
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ void access$setupChartView(DanaStatementLargeWidgetProvider danaStatementLargeWidgetProvider, IncomeAndExpenseEntryChartModel incomeAndExpenseEntryChartModel) {
        StatementWidgetChartView statementWidgetChartView = (StatementWidgetChartView) danaStatementLargeWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
        statementWidgetChartView.invalidate();
        statementWidgetChartView.clear();
        Calendar calendar = Calendar.getInstance();
        List<String> KClassImpl$Data$declaredNonStaticMembers$2 = DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(calendar.getTimeInMillis(), 3, StatementDateView.SHORT_MONTH, Boolean.TRUE);
        calendar.add(2, 1);
        List<String> KClassImpl$Data$declaredNonStaticMembers$22 = DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(calendar.getTimeInMillis(), 3, StatementDateView.SHORT_MONTH, Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        KClassImpl$Data$declaredNonStaticMembers$2.addAll(KClassImpl$Data$declaredNonStaticMembers$22);
        ((StatementWidgetChartView) danaStatementLargeWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).setMonths((ArrayList) KClassImpl$Data$declaredNonStaticMembers$2);
        ((StatementWidgetChartView) danaStatementLargeWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).setLineDataSet1(new LineDataSet(incomeAndExpenseEntryChartModel.KClassImpl$Data$declaredNonStaticMembers$2, "income"));
        ((StatementWidgetChartView) danaStatementLargeWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).setLineDataSet2(new LineDataSet(incomeAndExpenseEntryChartModel.getAuthRequestContext, "expense"));
        ((StatementWidgetChartView) danaStatementLargeWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).setMaxXAxisRange(3);
        ((StatementWidgetChartView) danaStatementLargeWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).build();
        Bitmap chartBitmap = ((StatementWidgetChartView) danaStatementLargeWidgetProvider.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).getChartBitmap();
        RemoteViews remoteViews = danaStatementLargeWidgetProvider.lookAheadTest;
        if (remoteViews != null) {
            remoteViews.setImageViewBitmap(R.id.iv_dana_statement_large_chart_preview, chartBitmap);
        }
        danaStatementLargeWidgetProvider.getAuthRequestContext(danaStatementLargeWidgetProvider.lookAheadTest);
    }

    public static final /* synthetic */ void access$toggleWidgetLoginView(DanaStatementLargeWidgetProvider danaStatementLargeWidgetProvider, int i) {
        RemoteViews remoteViews = danaStatementLargeWidgetProvider.lookAheadTest;
        if (remoteViews != null) {
            remoteViews.setDisplayedChild(R.id.vf_dana_statement_large_widget, i);
            danaStatementLargeWidgetProvider.getAuthRequestContext(remoteViews);
        }
    }
}
