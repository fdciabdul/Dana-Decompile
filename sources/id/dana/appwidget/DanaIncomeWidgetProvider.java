package id.dana.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.ap.zoloz.hummer.biz.HummerConstants;
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
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementDetailModel;
import id.dana.util.MinApiUtils;
import id.dana.utils.DateTimeUtil;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b.\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010\u0005\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0006"}, d2 = {"Lid/dana/appwidget/DanaIncomeWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "Landroid/widget/RemoteViews;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/widget/RemoteViews;)V", "Landroid/content/Context;", "Landroid/app/PendingIntent;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Landroid/app/PendingIntent;", "()V", "Lid/dana/statement/model/StatementViewModel;", "", "MyBillsEntityDataFactory", "(Lid/dana/statement/model/StatementViewModel;)Z", HummerConstants.CONTEXT, "onDisabled", "(Landroid/content/Context;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "PlaceComponentResult", "[I", "Landroid/content/Context;", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "danaAppWidgetPresenter", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "getDanaAppWidgetPresenter", "()Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "setDanaAppWidgetPresenter", "(Lid/dana/appwidget/DanaAppWidgetContract$Presenter;)V", "getAuthRequestContext", "Z", "Landroid/widget/RemoteViews;", "getRemoteViews", "()Landroid/widget/RemoteViews;", "setRemoteViews", "remoteViews", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DanaIncomeWidgetProvider extends AppWidgetProvider {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int[] MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Context PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private RemoteViews remoteViews;
    @Inject
    public DanaAppWidgetContract.Presenter danaAppWidgetPresenter;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    @JvmStatic
    public static final void toggleLoginView(Context context, boolean z) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, z);
    }

    @JvmStatic
    public static final void updateIncomeBalance(Context context, String str) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, str);
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

    @JvmName(name = "getRemoteViews")
    public final RemoteViews getRemoteViews() {
        return this.remoteViews;
    }

    @JvmName(name = "setRemoteViews")
    public final void setRemoteViews(RemoteViews remoteViews) {
        this.remoteViews = remoteViews;
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(appWidgetManager, "");
        Intrinsics.checkNotNullParameter(appWidgetIds, "");
        this.MyBillsEntityDataFactory = appWidgetIds;
        KClassImpl$Data$declaredNonStaticMembers$2();
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
        String stringExtra;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(intent, "");
        this.PlaceComponentResult = context;
        if (intent.hasExtra("INCOME_WIDGET_IDS_KEY")) {
            if (this.remoteViews == null) {
                this.remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.widget_dana_statement_income);
            }
            Bundle extras = intent.getExtras();
            int[] intArray = extras != null ? extras.getIntArray("INCOME_WIDGET_IDS_KEY") : null;
            if (intArray == null) {
                intArray = new int[0];
            }
            this.MyBillsEntityDataFactory = intArray;
            if (!Intrinsics.areEqual(intent.getAction(), "REFRESH_BUTTON_ACTION_TAG_STATEMENT_INCOME")) {
                if (intent.hasExtra("INCOME_WIDGET_DATA_LOGIN_VIEW_KEY")) {
                    boolean booleanExtra = intent.getBooleanExtra("INCOME_WIDGET_DATA_LOGIN_VIEW_KEY", false);
                    AppWidgetPendingIntentCoordinator.Companion companion = AppWidgetPendingIntentCoordinator.INSTANCE;
                    int KClassImpl$Data$declaredNonStaticMembers$2 = AppWidgetPendingIntentCoordinator.Companion.KClassImpl$Data$declaredNonStaticMembers$2(booleanExtra, this.BuiltInFictitiousFunctionClassFactory);
                    if (!this.BuiltInFictitiousFunctionClassFactory && KClassImpl$Data$declaredNonStaticMembers$2 != 1) {
                        RemoteViews remoteViews = this.remoteViews;
                        if (remoteViews != null) {
                            remoteViews.setDisplayedChild(R.id.vf_dana_statement_income, 2);
                        }
                        BuiltInFictitiousFunctionClassFactory(remoteViews);
                        PlaceComponentResult();
                        return;
                    }
                    RemoteViews remoteViews2 = this.remoteViews;
                    if (remoteViews2 != null) {
                        remoteViews2.setDisplayedChild(R.id.vf_dana_statement_income, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    BuiltInFictitiousFunctionClassFactory(remoteViews2);
                    return;
                } else if (!intent.hasExtra("INCOME_DATA") || (stringExtra = intent.getStringExtra("INCOME_DATA")) == null) {
                    return;
                } else {
                    RemoteViews remoteViews3 = this.remoteViews;
                    if (remoteViews3 != null) {
                        remoteViews3.setTextViewText(R.id.tv_dana_statement_income_balance_amount, stringExtra);
                    }
                    BuiltInFictitiousFunctionClassFactory(this.remoteViews);
                    return;
                }
            }
            RemoteViews remoteViews4 = this.remoteViews;
            if (remoteViews4 != null) {
                remoteViews4.setDisplayedChild(R.id.vf_dana_statement_income, 2);
            }
            BuiltInFictitiousFunctionClassFactory(remoteViews4);
            PlaceComponentResult();
            return;
        }
        super.onReceive(context, intent);
    }

    private final void PlaceComponentResult() {
        if (this.danaAppWidgetPresenter == null) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
        getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaIncomeWidgetProvider$loadStatementIncomeData$1(this));
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Context context = null;
        if (this.remoteViews == null) {
            Context context2 = this.PlaceComponentResult;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context2 = null;
            }
            this.remoteViews = new RemoteViews(context2.getPackageName(), (int) R.layout.widget_dana_statement_income);
        }
        Context context3 = this.PlaceComponentResult;
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaAppWidgetModule) Preconditions.getAuthRequestContext(new DanaAppWidgetModule(new DanaAppWidgetContract.View() { // from class: id.dana.appwidget.DanaIncomeWidgetProvider$getDanaWidgetModule$1
            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(IncomeAndExpenseEntryChartModel incomeAndExpenseEntryChartModel) {
                DanaAppWidgetContract.View.CC.getAuthRequestContext(incomeAndExpenseEntryChartModel);
            }

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
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final void getAuthRequestContext(List<StatementViewModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaIncomeWidgetProvider.access$setStatementSummary(DanaIncomeWidgetProvider.this, p0);
                DanaIncomeWidgetProvider.this.MyBillsEntityDataFactory();
                DanaIncomeWidgetProvider.access$toggleWidgetLoginView(DanaIncomeWidgetProvider.this, 0);
                DanaIncomeWidgetProvider.this.BuiltInFictitiousFunctionClassFactory = false;
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                DanaIncomeWidgetProvider.access$toggleWidgetLoginView(DanaIncomeWidgetProvider.this, 1);
            }
        }));
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(this);
        MyBillsEntityDataFactory();
        RemoteViews remoteViews = this.remoteViews;
        if (remoteViews != null) {
            Context context4 = this.PlaceComponentResult;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context4 = null;
            }
            remoteViews.setOnClickPendingIntent(R.id.ib_dana_statement_income_refresh, KClassImpl$Data$declaredNonStaticMembers$2(context4));
        }
        RemoteViews remoteViews2 = this.remoteViews;
        if (remoteViews2 != null) {
            Context context5 = this.PlaceComponentResult;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context5 = null;
            }
            remoteViews2.setOnClickPendingIntent(R.id.ib_dana_statement_income_refresh_shimmer, KClassImpl$Data$declaredNonStaticMembers$2(context5));
        }
        RemoteViews remoteViews3 = this.remoteViews;
        if (remoteViews3 != null) {
            Context context6 = this.PlaceComponentResult;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context6 = null;
            }
            Intent intent = new Intent(context6, LocalConfigSplashActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("CATEGORY_LOGIN_INCOME_WIDGET");
            intent.setFlags(268468224);
            intent.addCategory("android.shortcut.conversation");
            int i = MinApiUtils.PlaceComponentResult() ? 67108864 : 0;
            Context context7 = this.PlaceComponentResult;
            if (context7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context7 = null;
            }
            PendingIntent activity = PendingIntent.getActivity(context7, 0, intent, i);
            Intrinsics.checkNotNullExpressionValue(activity, "");
            remoteViews3.setOnClickPendingIntent(R.id.vg_login_view_login_button, activity);
        }
        RemoteViews remoteViews4 = this.remoteViews;
        if (remoteViews4 != null) {
            AppWidgetPendingIntentCoordinator.Companion companion = AppWidgetPendingIntentCoordinator.INSTANCE;
            Context context8 = this.PlaceComponentResult;
            if (context8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                context = context8;
            }
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "");
            remoteViews4.setOnClickPendingIntent(R.id.vg_dana_statement_income_widget_root, AppWidgetPendingIntentCoordinator.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, simpleName, StatementType.INCOME.name()));
        }
        BuiltInFictitiousFunctionClassFactory(this.remoteViews);
        this.BuiltInFictitiousFunctionClassFactory = true;
        getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaIncomeWidgetProvider$loadStatementIncomeData$1(this));
    }

    private static boolean MyBillsEntityDataFactory(StatementViewModel p0) {
        return Intrinsics.areEqual(StatementType.INCOME.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    private final PendingIntent KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intent intent = new Intent(p0, getClass());
        intent.setAction("REFRESH_BUTTON_ACTION_TAG_STATEMENT_INCOME");
        int[] iArr = this.MyBillsEntityDataFactory;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            iArr = null;
        }
        intent.putExtra("INCOME_WIDGET_IDS_KEY", iArr);
        PendingIntent broadcast = PendingIntent.getBroadcast(p0, 0, intent, MinApiUtils.PlaceComponentResult() ? 167772160 : 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "");
        return broadcast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        String PlaceComponentResult = DateTimeUtil.PlaceComponentResult("d MMM yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("1-");
        sb.append(PlaceComponentResult);
        String obj = sb.toString();
        RemoteViews remoteViews = this.remoteViews;
        if (remoteViews != null) {
            remoteViews.setTextViewText(R.id.tv_dana_statement_income_date, obj);
        }
        BuiltInFictitiousFunctionClassFactory(this.remoteViews);
    }

    private final void BuiltInFictitiousFunctionClassFactory(RemoteViews p0) {
        if (p0 != null) {
            Context context = this.PlaceComponentResult;
            int[] iArr = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] iArr2 = this.MyBillsEntityDataFactory;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                iArr = iArr2;
            }
            appWidgetManager.partiallyUpdateAppWidget(iArr, p0);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0007\u0010\n"}, d2 = {"Lid/dana/appwidget/DanaIncomeWidgetProvider$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Z)V", "", "(Landroid/content/Context;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(p0).getAppWidgetIds(new ComponentName(p0, DanaIncomeWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("INCOME_WIDGET_IDS_KEY", appWidgetIds);
            String str = p1;
            if (!(str == null || str.length() == 0)) {
                intent.putExtra("INCOME_DATA", p1);
            }
            p0.sendBroadcast(intent);
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, boolean p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(p0).getAppWidgetIds(new ComponentName(p0, DanaIncomeWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("INCOME_WIDGET_IDS_KEY", appWidgetIds);
            intent.putExtra("INCOME_WIDGET_DATA_LOGIN_VIEW_KEY", p1);
            p0.sendBroadcast(intent);
        }
    }

    public static final /* synthetic */ Unit access$setStatementSummary(DanaIncomeWidgetProvider danaIncomeWidgetProvider, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                StatementViewModel statementViewModel = (StatementViewModel) it.next();
                if (1 == statementViewModel.getAuthRequestContext && MyBillsEntityDataFactory(statementViewModel)) {
                    CurrencyAmountModel currencyAmountModel = statementViewModel.PlaceComponentResult.getAuthRequestContext;
                    String authRequestContext = currencyAmountModel != null ? currencyAmountModel.getAuthRequestContext() : null;
                    if (authRequestContext == null) {
                        authRequestContext = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    }
                    RemoteViews remoteViews = danaIncomeWidgetProvider.remoteViews;
                    if (remoteViews != null) {
                        remoteViews.setTextViewText(R.id.tv_dana_statement_income_balance_amount, authRequestContext);
                    }
                    danaIncomeWidgetProvider.BuiltInFictitiousFunctionClassFactory(danaIncomeWidgetProvider.remoteViews);
                }
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ void access$toggleWidgetLoginView(DanaIncomeWidgetProvider danaIncomeWidgetProvider, int i) {
        RemoteViews remoteViews = danaIncomeWidgetProvider.remoteViews;
        if (remoteViews != null) {
            remoteViews.setDisplayedChild(R.id.vf_dana_statement_income, i);
        }
        danaIncomeWidgetProvider.BuiltInFictitiousFunctionClassFactory(remoteViews);
    }
}
