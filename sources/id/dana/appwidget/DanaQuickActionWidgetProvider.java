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
import id.dana.appshortcut.DanaAppShortcut;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0005\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010\t\u001a\u00020&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010)"}, d2 = {"Lid/dana/appwidget/DanaQuickActionWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "Landroid/widget/RemoteViews;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/widget/RemoteViews;)V", "Landroid/content/Context;", "Landroid/app/PendingIntent;", "getAuthRequestContext", "(Landroid/content/Context;)Landroid/app/PendingIntent;", "()V", HummerConstants.CONTEXT, "onDisabled", "(Landroid/content/Context;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "Lid/dana/model/CurrencyAmountModel;", "(Lid/dana/model/CurrencyAmountModel;)V", "PlaceComponentResult", "[I", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "danaAppWidgetPresenter", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "getDanaAppWidgetPresenter", "()Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "setDanaAppWidgetPresenter", "(Lid/dana/appwidget/DanaAppWidgetContract$Presenter;)V", "", "BuiltInFictitiousFunctionClassFactory", "Z", "Landroid/widget/RemoteViews;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DanaQuickActionWidgetProvider extends AppWidgetProvider {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private RemoteViews PlaceComponentResult;
    private Context MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int[] KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public DanaAppWidgetContract.Presenter danaAppWidgetPresenter;

    @JvmStatic
    public static final void refreshQuickActionWidgets(Context context, Parcelable parcelable) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, parcelable);
    }

    @JvmStatic
    public static final void toggleLoginView(Context context, boolean z) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, z);
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
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appWidgetIds;
        getAuthRequestContext();
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
        this.MyBillsEntityDataFactory = context;
        if (intent.hasExtra("QUICK_ACTION_WIDGET_IDS_KEY")) {
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new RemoteViews(context.getPackageName(), (int) R.layout.widget_quick_action);
            }
            Bundle extras = intent.getExtras();
            int[] intArray = extras != null ? extras.getIntArray("QUICK_ACTION_WIDGET_IDS_KEY") : null;
            if (intArray == null) {
                intArray = new int[0];
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = intArray;
            if (Intrinsics.areEqual(intent.getAction(), "REFRESH_BUTTON_ACTION_TAG_QUICK_ACTION")) {
                RemoteViews remoteViews = this.PlaceComponentResult;
                if (remoteViews != null) {
                    remoteViews.setDisplayedChild(R.id.vf_quick_action, 2);
                    MyBillsEntityDataFactory(remoteViews);
                }
                if (this.danaAppWidgetPresenter == null) {
                    getAuthRequestContext();
                } else {
                    this.getAuthRequestContext = true;
                    getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaQuickActionWidgetProvider$loadBalanceData$1(this));
                }
            }
            CurrencyAmountModel currencyAmountModel = (CurrencyAmountModel) intent.getParcelableExtra("QUICK_ACTION_WIDGET_DATA_KEY");
            if (currencyAmountModel != null) {
                MyBillsEntityDataFactory(currencyAmountModel);
                RemoteViews remoteViews2 = this.PlaceComponentResult;
                if (remoteViews2 != null) {
                    remoteViews2.setDisplayedChild(R.id.vf_quick_action, 0);
                    MyBillsEntityDataFactory(remoteViews2);
                }
            }
            boolean booleanExtra = intent.getBooleanExtra("QUICK_ACTION_WIDGET_DATA_LOGIN_VIEW_KEY", false);
            AppWidgetPendingIntentCoordinator.Companion companion = AppWidgetPendingIntentCoordinator.INSTANCE;
            int KClassImpl$Data$declaredNonStaticMembers$2 = AppWidgetPendingIntentCoordinator.Companion.KClassImpl$Data$declaredNonStaticMembers$2(booleanExtra, this.getAuthRequestContext);
            RemoteViews remoteViews3 = this.PlaceComponentResult;
            if (remoteViews3 != null) {
                remoteViews3.setDisplayedChild(R.id.vf_quick_action, KClassImpl$Data$declaredNonStaticMembers$2);
                MyBillsEntityDataFactory(remoteViews3);
                return;
            }
            return;
        }
        super.onReceive(context, intent);
    }

    private final void getAuthRequestContext() {
        Context context = null;
        if (this.PlaceComponentResult == null) {
            Context context2 = this.MyBillsEntityDataFactory;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context2 = null;
            }
            this.PlaceComponentResult = new RemoteViews(context2.getPackageName(), (int) R.layout.widget_quick_action);
        }
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaAppWidgetModule) Preconditions.getAuthRequestContext(new DanaAppWidgetModule(new DanaAppWidgetContract.View() { // from class: id.dana.appwidget.DanaQuickActionWidgetProvider$getDanaWidgetModule$1
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
                DanaQuickActionWidgetProvider.this.MyBillsEntityDataFactory(p0);
                DanaQuickActionWidgetProvider.access$toggleWidgetLoginView(DanaQuickActionWidgetProvider.this, 0);
                DanaQuickActionWidgetProvider.this.getAuthRequestContext = false;
            }

            @Override // id.dana.appwidget.DanaAppWidgetContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                DanaQuickActionWidgetProvider.access$toggleWidgetLoginView(DanaQuickActionWidgetProvider.this, 1);
            }
        }));
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(this);
        RemoteViews remoteViews = this.PlaceComponentResult;
        if (remoteViews != null) {
            Context context4 = this.MyBillsEntityDataFactory;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context4 = null;
            }
            remoteViews.setOnClickPendingIntent(R.id.dana_statement_refresh_shimmer, getAuthRequestContext(context4));
        }
        RemoteViews remoteViews2 = this.PlaceComponentResult;
        if (remoteViews2 != null) {
            Context context5 = this.MyBillsEntityDataFactory;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context5 = null;
            }
            remoteViews2.setOnClickPendingIntent(R.id.dana_statement_refresh_shimmer, getAuthRequestContext(context5));
        }
        RemoteViews remoteViews3 = this.PlaceComponentResult;
        if (remoteViews3 != null) {
            DanaAppShortcut.Companion companion = DanaAppShortcut.INSTANCE;
            Context context6 = this.MyBillsEntityDataFactory;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context6 = null;
            }
            Intrinsics.checkNotNullParameter(context6, "");
            Intent BuiltInFictitiousFunctionClassFactory = DanaAppShortcut.Companion.BuiltInFictitiousFunctionClassFactory(context6, 1);
            int i = MinApiUtils.PlaceComponentResult() ? 67108864 : 0;
            Context context7 = this.MyBillsEntityDataFactory;
            if (context7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context7 = null;
            }
            PendingIntent activity = PendingIntent.getActivity(context7, 0, BuiltInFictitiousFunctionClassFactory, i);
            Intrinsics.checkNotNullExpressionValue(activity, "");
            remoteViews3.setOnClickPendingIntent(R.id.btn_quick_action_pay, activity);
        }
        RemoteViews remoteViews4 = this.PlaceComponentResult;
        if (remoteViews4 != null) {
            Context context8 = this.MyBillsEntityDataFactory;
            if (context8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context8 = null;
            }
            remoteViews4.setOnClickPendingIntent(R.id.ib_widget_quick_action_refresh, getAuthRequestContext(context8));
        }
        RemoteViews remoteViews5 = this.PlaceComponentResult;
        if (remoteViews5 != null) {
            Context context9 = this.MyBillsEntityDataFactory;
            if (context9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context9 = null;
            }
            Intent intent = new Intent(context9, LocalConfigSplashActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("CATEGORY_LOGIN_QUICK_ACTION_WIDGET");
            intent.setFlags(268468224);
            intent.addCategory("android.shortcut.conversation");
            int i2 = MinApiUtils.PlaceComponentResult() ? 33554432 : 0;
            Context context10 = this.MyBillsEntityDataFactory;
            if (context10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                context = context10;
            }
            PendingIntent activity2 = PendingIntent.getActivity(context, 0, intent, i2);
            Intrinsics.checkNotNullExpressionValue(activity2, "");
            remoteViews5.setOnClickPendingIntent(R.id.vg_login_view_login_button, activity2);
        }
        MyBillsEntityDataFactory(this.PlaceComponentResult);
        this.getAuthRequestContext = true;
        getDanaAppWidgetPresenter().MyBillsEntityDataFactory(new DanaQuickActionWidgetProvider$loadBalanceData$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(CurrencyAmountModel p0) {
        RemoteViews remoteViews = this.PlaceComponentResult;
        if (remoteViews != null) {
            String BuiltInFictitiousFunctionClassFactory = BalanceUtil.BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory);
            String str = BuiltInFictitiousFunctionClassFactory;
            if (str == null || str.length() == 0) {
                Context context = this.MyBillsEntityDataFactory;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    context = null;
                }
                BuiltInFictitiousFunctionClassFactory = context.getString(R.string.widget_balance_amount_placeholder);
            }
            remoteViews.setTextViewText(R.id.tv_quick_action_balance_amount, BuiltInFictitiousFunctionClassFactory);
            MyBillsEntityDataFactory(remoteViews);
        }
    }

    private final void MyBillsEntityDataFactory(RemoteViews p0) {
        Context context = this.MyBillsEntityDataFactory;
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

    private final PendingIntent getAuthRequestContext(Context p0) {
        Intent intent = new Intent(p0, getClass());
        intent.setAction("REFRESH_BUTTON_ACTION_TAG_QUICK_ACTION");
        int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            iArr = null;
        }
        intent.putExtra("QUICK_ACTION_WIDGET_IDS_KEY", iArr);
        PendingIntent broadcast = PendingIntent.getBroadcast(p0, 0, intent, MinApiUtils.PlaceComponentResult() ? 167772160 : 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "");
        return broadcast;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lid/dana/appwidget/DanaQuickActionWidgetProvider$Companion;", "", "()V", "INTENT_CATEGORY_LOGIN", "", "REFRESH_BUTTTON_ACTION_TAG", "WIDGET_DATA_KEY", "WIDGET_DATA_LOGIN_VIEW_KEY", "WIDGET_ID_KEY", "WIDGET_LAYOUT", "", "refreshQuickActionWidgets", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "data", "Landroid/os/Parcelable;", "toggleLoginView", "showLoginView", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context context, Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(context, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, DanaQuickActionWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("QUICK_ACTION_WIDGET_IDS_KEY", appWidgetIds);
            if (parcelable != null) {
                intent.putExtra("QUICK_ACTION_WIDGET_DATA_KEY", parcelable);
            }
            context.sendBroadcast(intent);
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "");
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, DanaQuickActionWidgetProvider.class));
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("QUICK_ACTION_WIDGET_IDS_KEY", appWidgetIds);
            intent.putExtra("QUICK_ACTION_WIDGET_DATA_LOGIN_VIEW_KEY", z);
            context.sendBroadcast(intent);
        }
    }

    public static final /* synthetic */ void access$toggleWidgetLoginView(DanaQuickActionWidgetProvider danaQuickActionWidgetProvider, int i) {
        RemoteViews remoteViews = danaQuickActionWidgetProvider.PlaceComponentResult;
        if (remoteViews != null) {
            remoteViews.setDisplayedChild(R.id.vf_quick_action, i);
            danaQuickActionWidgetProvider.MyBillsEntityDataFactory(remoteViews);
        }
    }

    @JvmStatic
    public static final void refreshQuickActionWidgets(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        Companion.BuiltInFictitiousFunctionClassFactory(context, null);
    }
}
