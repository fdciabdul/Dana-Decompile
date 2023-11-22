package id.dana.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import id.dana.model.CurrencyAmountModel;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.statement.model.UserStatementDetailModel;
import id.dana.util.MinApiUtils;
import id.dana.utils.BalanceUtil;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\b\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010\b\u001a\u00020'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010(R\u0018\u0010\u001e\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010*"}, d2 = {"Lid/dana/appwidget/DanaQuickActionMediumWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "", "p0", "Landroid/app/PendingIntent;", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)Landroid/app/PendingIntent;", "Landroid/content/Context;", "PlaceComponentResult", "(Landroid/content/Context;)Landroid/app/PendingIntent;", "", "getAuthRequestContext", "()V", HummerConstants.CONTEXT, "onDisabled", "(Landroid/content/Context;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "Lid/dana/model/CurrencyAmountModel;", "(Lid/dana/model/CurrencyAmountModel;)V", "[I", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "danaAppWidgetPresenter", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "getDanaAppWidgetPresenter", "()Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "setDanaAppWidgetPresenter", "(Lid/dana/appwidget/DanaAppWidgetContract$Presenter;)V", "", "Z", "Landroid/widget/RemoteViews;", "Landroid/widget/RemoteViews;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DanaQuickActionMediumWidgetProvider extends AppWidgetProvider {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Context getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int[] MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    @Inject
    public DanaAppWidgetContract.Presenter danaAppWidgetPresenter;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private RemoteViews BuiltInFictitiousFunctionClassFactory;

    @JvmStatic
    public static final void refreshQuickActionMediumWidgets(Context context, Parcelable parcelable) {
        Companion.getAuthRequestContext(context, parcelable);
    }

    @JvmStatic
    public static final void toggleLoginView(Context context, boolean z) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, z);
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
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(appWidgetManager, "");
        Intrinsics.checkNotNullParameter(appWidgetIds, "");
        this.MyBillsEntityDataFactory = appWidgetIds;
        getAuthRequestContext();
        for (int i : appWidgetIds) {
            RemoteViews remoteViews = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews != null) {
                remoteViews.setOnClickPendingIntent(R.id.vg_quick_action_m_top_up, KClassImpl$Data$declaredNonStaticMembers$2(2));
            }
            RemoteViews remoteViews2 = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews2 != null) {
                remoteViews2.setOnClickPendingIntent(R.id.vg_quick_action_m_wallet, KClassImpl$Data$declaredNonStaticMembers$2(5));
            }
            RemoteViews remoteViews3 = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews3 != null) {
                remoteViews3.setOnClickPendingIntent(R.id.vg_quick_action_m_send, KClassImpl$Data$declaredNonStaticMembers$2(3));
            }
            RemoteViews remoteViews4 = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews4 != null) {
                remoteViews4.setOnClickPendingIntent(R.id.vg_quick_action_m_request, KClassImpl$Data$declaredNonStaticMembers$2(4));
            }
            RemoteViews remoteViews5 = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews5 != null) {
                remoteViews5.setOnClickPendingIntent(R.id.ib_widget_quick_action_m_refresh, PlaceComponentResult(context));
            }
            RemoteViews remoteViews6 = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews6 != null) {
                remoteViews6.setOnClickPendingIntent(R.id.dana_statement_refresh_shimmer, PlaceComponentResult(context));
            }
            RemoteViews remoteViews7 = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews7 != null) {
                Context context2 = this.getAuthRequestContext;
                Context context3 = null;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    context2 = null;
                }
                Intent intent = new Intent(context2, LocalConfigSplashActivity.class);
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("CATEGORY_LOGIN_QUICK_ACTION_M");
                intent.setFlags(268468224);
                intent.addCategory("android.shortcut.conversation");
                int i2 = MinApiUtils.PlaceComponentResult() ? 33554432 : 0;
                Context context4 = this.getAuthRequestContext;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    context3 = context4;
                }
                PendingIntent activity = PendingIntent.getActivity(context3, 0, intent, i2);
                Intrinsics.checkNotNullExpressionValue(activity, "");
                remoteViews7.setOnClickPendingIntent(R.id.vg_login_view_login_button, activity);
            }
            appWidgetManager.updateAppWidget(i, this.BuiltInFictitiousFunctionClassFactory);
        }
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
        if (intent.hasExtra("QUICK_ACTION_MEDIUM_WIDGET_IDS_KEY")) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new RemoteViews(context.getPackageName(), (int) R.layout.widget_quick_action_medium);
            }
            Bundle extras = intent.getExtras();
            int[] intArray = extras != null ? extras.getIntArray("QUICK_ACTION_MEDIUM_WIDGET_IDS_KEY") : null;
            if (intArray == null) {
                intArray = new int[0];
            }
            this.MyBillsEntityDataFactory = intArray;
            if (Intrinsics.areEqual(intent.getAction(), "REFRESH_BUTTON_ACTION_TAG_QUICK_ACTION_MEDIUM")) {
                RemoteViews remoteViews = this.BuiltInFictitiousFunctionClassFactory;
                if (remoteViews != null) {
                    remoteViews.setDisplayedChild(R.id.vf_quick_action_medium, 2);
                    beginWidgetUpdatePartially$default(this, null, remoteViews, null, 5, null);
                }
                if (this.danaAppWidgetPresenter == null) {
                    getAuthRequestContext();
                } else {
                    this.PlaceComponentResult = true;
                    getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaQuickActionMediumWidgetProvider$loadBalanceData$1(this));
                }
            }
            CurrencyAmountModel currencyAmountModel = (CurrencyAmountModel) intent.getParcelableExtra("QUICK_ACTION_MEDIUM_WIDGET_DATA_KEY");
            if (currencyAmountModel != null) {
                PlaceComponentResult(currencyAmountModel);
            }
            boolean booleanExtra = intent.getBooleanExtra("QUICK_ACTION_MEDIUM_WIDGET_DATA_LOGIN_VIEW_KEY", false);
            AppWidgetPendingIntentCoordinator.Companion companion = AppWidgetPendingIntentCoordinator.INSTANCE;
            int KClassImpl$Data$declaredNonStaticMembers$2 = AppWidgetPendingIntentCoordinator.Companion.KClassImpl$Data$declaredNonStaticMembers$2(booleanExtra, this.PlaceComponentResult);
            RemoteViews remoteViews2 = this.BuiltInFictitiousFunctionClassFactory;
            if (remoteViews2 != null) {
                remoteViews2.setDisplayedChild(R.id.vf_quick_action_medium, KClassImpl$Data$declaredNonStaticMembers$2);
                beginWidgetUpdatePartially$default(this, null, remoteViews2, null, 5, null);
                return;
            }
            return;
        }
        super.onReceive(context, intent);
    }

    private final void getAuthRequestContext() {
        Context context = null;
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            Context context2 = this.getAuthRequestContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context2 = null;
            }
            this.BuiltInFictitiousFunctionClassFactory = new RemoteViews(context2.getPackageName(), (int) R.layout.widget_quick_action_medium);
        }
        Context context3 = this.getAuthRequestContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            context = context3;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        ApplicationComponent applicationComponent = ((DanaApplication) applicationContext).getApplicationComponent();
        DaggerDanaWidgetComponent.Builder PlaceComponentResult = DaggerDanaWidgetComponent.PlaceComponentResult();
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaAppWidgetModule) Preconditions.getAuthRequestContext(new DanaAppWidgetModule(new DanaAppWidgetContract.View() { // from class: id.dana.appwidget.DanaQuickActionMediumWidgetProvider$getDanaWidgetModule$1
            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(IncomeAndExpenseEntryChartModel incomeAndExpenseEntryChartModel) {
                DanaAppWidgetContract.View.CC.getAuthRequestContext(incomeAndExpenseEntryChartModel);
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(UserStatementDetailModel userStatementDetailModel) {
                Intrinsics.checkNotNullParameter(userStatementDetailModel, "");
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(UserStatementDetailModel userStatementDetailModel) {
                DanaAppWidgetContract.View.CC.MyBillsEntityDataFactory(userStatementDetailModel);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final /* synthetic */ void getAuthRequestContext(List list) {
                DanaAppWidgetContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
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
            public final void MyBillsEntityDataFactory(CurrencyAmountModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaQuickActionMediumWidgetProvider.this.PlaceComponentResult(p0);
                DanaQuickActionMediumWidgetProvider.access$toggleWidgetLoginView(DanaQuickActionMediumWidgetProvider.this, 0);
                DanaQuickActionMediumWidgetProvider.this.PlaceComponentResult = false;
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                DanaQuickActionMediumWidgetProvider.access$toggleWidgetLoginView(DanaQuickActionMediumWidgetProvider.this, 1);
            }
        }));
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(this);
        this.PlaceComponentResult = true;
        getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaQuickActionMediumWidgetProvider$loadBalanceData$1(this));
    }

    private final PendingIntent KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        Context context = this.getAuthRequestContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        Intent intent = new Intent(context, LocalConfigSplashActivity.class);
        String str = "android.intent.action.VIEW";
        intent.setAction("android.intent.action.VIEW");
        if (p0 == 2) {
            str = "QUICK_ACTION_M_OPEN_TOP_UP";
        } else if (p0 == 3) {
            str = "QUICK_ACTION_M_OPEN_SEND";
        } else if (p0 == 4) {
            str = "QUICK_ACTION_M_OPEN_REQUEST";
        } else if (p0 == 5) {
            str = "QUICK_ACTION_M_OPEN_WALLET";
        }
        intent.addCategory(str);
        intent.setFlags(268468224);
        intent.addCategory("android.shortcut.conversation");
        intent.putExtra("APP_SHORTCUT_ACTION", true);
        intent.putExtra("APP_SHORTCUT_ACTION_TARGET", p0);
        int i = MinApiUtils.PlaceComponentResult() ? 33554432 : 0;
        Context context3 = this.getAuthRequestContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            context2 = context3;
        }
        PendingIntent activity = PendingIntent.getActivity(context2, 0, intent, i);
        Intrinsics.checkNotNullExpressionValue(activity, "");
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(CurrencyAmountModel p0) {
        RemoteViews remoteViews = this.BuiltInFictitiousFunctionClassFactory;
        if (remoteViews != null) {
            String BuiltInFictitiousFunctionClassFactory = BalanceUtil.BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory);
            String str = BuiltInFictitiousFunctionClassFactory;
            if (str == null || str.length() == 0) {
                Context context = this.getAuthRequestContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    context = null;
                }
                BuiltInFictitiousFunctionClassFactory = context.getString(R.string.widget_balance_amount_placeholder);
            }
            remoteViews.setTextViewText(R.id.tv_quick_action_m_balance_amount, BuiltInFictitiousFunctionClassFactory);
            beginWidgetUpdatePartially$default(this, null, remoteViews, null, 5, null);
        }
    }

    static /* synthetic */ void beginWidgetUpdatePartially$default(DanaQuickActionMediumWidgetProvider danaQuickActionMediumWidgetProvider, Context context, RemoteViews remoteViews, int[] iArr, int i, Object obj) {
        if ((i & 1) != 0 && (context = danaQuickActionMediumWidgetProvider.getAuthRequestContext) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        if ((i & 4) != 0 && (iArr = danaQuickActionMediumWidgetProvider.MyBillsEntityDataFactory) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            iArr = null;
        }
        AppWidgetManager.getInstance(context).partiallyUpdateAppWidget(iArr, remoteViews);
    }

    private final PendingIntent PlaceComponentResult(Context p0) {
        Intent intent = new Intent(p0, getClass());
        intent.setAction("REFRESH_BUTTON_ACTION_TAG_QUICK_ACTION_MEDIUM");
        int[] iArr = this.MyBillsEntityDataFactory;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            iArr = null;
        }
        intent.putExtra("QUICK_ACTION_MEDIUM_WIDGET_IDS_KEY", iArr);
        PendingIntent broadcast = PendingIntent.getBroadcast(p0, 0, intent, MinApiUtils.PlaceComponentResult() ? 167772160 : 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "");
        return broadcast;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lid/dana/appwidget/DanaQuickActionMediumWidgetProvider$Companion;", "", "()V", "INTENT_CATEGORY_LOGIN", "", "QUICK_ACTION_M_OPEN_REQUEST", "QUICK_ACTION_M_OPEN_SEND", "QUICK_ACTION_M_OPEN_TOP_UP", "QUICK_ACTION_M_OPEN_WALLET", "REFRESH_BUTTTON_ACTION_TAG", "WIDGET_DATA_KEY", "WIDGET_DATA_LOGIN_VIEW_KEY", "WIDGET_ID_KEY", "WIDGET_LAYOUT", "", "refreshQuickActionMediumWidgets", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "data", "Landroid/os/Parcelable;", "toggleLoginView", "showLoginView", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void getAuthRequestContext(Context context, Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(context, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, DanaQuickActionMediumWidgetProvider.class));
            Intent intent = new Intent();
            intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("QUICK_ACTION_MEDIUM_WIDGET_IDS_KEY", appWidgetIds);
            if (parcelable != null) {
                intent.putExtra("QUICK_ACTION_MEDIUM_WIDGET_DATA_KEY", parcelable);
            }
            context.sendBroadcast(intent);
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, DanaQuickActionMediumWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("QUICK_ACTION_MEDIUM_WIDGET_IDS_KEY", appWidgetIds);
            intent.putExtra("QUICK_ACTION_MEDIUM_WIDGET_DATA_LOGIN_VIEW_KEY", z);
            context.sendBroadcast(intent);
        }
    }

    public static final /* synthetic */ void access$toggleWidgetLoginView(DanaQuickActionMediumWidgetProvider danaQuickActionMediumWidgetProvider, int i) {
        RemoteViews remoteViews = danaQuickActionMediumWidgetProvider.BuiltInFictitiousFunctionClassFactory;
        if (remoteViews != null) {
            remoteViews.setDisplayedChild(R.id.vf_quick_action_medium, i);
            beginWidgetUpdatePartially$default(danaQuickActionMediumWidgetProvider, null, remoteViews, null, 5, null);
        }
    }

    @JvmStatic
    public static final void refreshQuickActionMediumWidgets(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        Companion.getAuthRequestContext(context, null);
    }
}
