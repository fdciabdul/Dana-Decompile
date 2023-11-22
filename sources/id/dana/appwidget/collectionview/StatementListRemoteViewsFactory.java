package id.dana.appwidget.collectionview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioTrack;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.appwidget.model.IncomeAndExpenseEntryChartModel;
import id.dana.base.AbstractContractKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDanaWidgetComponent;
import id.dana.di.modules.DanaAppWidgetModule;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.model.UserStatement;
import id.dana.model.CurrencyAmountModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.statement.StatementTransactionType;
import id.dana.statement.model.StatementSummaryModel;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.StatementViewModelKt;
import id.dana.statement.model.UserStatementDetailModel;
import id.dana.statement.model.UserStatementModelKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00010B!\u0012\u0006\u0010\u0005\u001a\u00020\u001d\u0012\u0006\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0012\u0010!\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b!\u0010\"R,\u0010\u0013\u001a\u001a\u0012\b\u0012\u00060$R\u00020\u00000#j\f\u0012\b\u0012\u00060$R\u00020\u0000`%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'R,\u0010&\u001a\u001a\u0012\b\u0012\u00060$R\u00020\u00000#j\f\u0012\b\u0012\u00060$R\u00020\u0000`%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lid/dana/appwidget/collectionview/StatementListRemoteViewsFactory;", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "", "getCount", "()I", "p0", "", "getItemId", "(I)J", "Landroid/widget/RemoteViews;", "getLoadingView", "()Landroid/widget/RemoteViews;", "getViewAt", "(I)Landroid/widget/RemoteViews;", "getViewTypeCount", "", "hasStableIds", "()Z", "", "getAuthRequestContext", "()V", "Lid/dana/statement/model/StatementViewModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/statement/model/StatementViewModel;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "onCreate", "onDataSetChanged", "onDestroy", "I", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "danaAppWidgetPresenter", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "Ljava/util/ArrayList;", "Lid/dana/appwidget/collectionview/StatementListRemoteViewsFactory$StatementItem;", "Lkotlin/collections/ArrayList;", "MyBillsEntityDataFactory", "Ljava/util/ArrayList;", "scheduleImpl", "moveToNextValue", "Z", "Landroid/content/Intent;", "p1", "p2", "<init>", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "StatementItem"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class StatementListRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ArrayList<StatementItem> getAuthRequestContext;
    @Inject
    public DanaAppWidgetContract.Presenter danaAppWidgetPresenter;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ArrayList<StatementItem> MyBillsEntityDataFactory;
    public static final byte[] $$a = {Ascii.ETB, -59, 18, 83, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 243;
    public static final byte[] PlaceComponentResult = {68, -4, -93, 76, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 142;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = 106 - r8
            byte[] r0 = id.dana.appwidget.collectionview.StatementListRemoteViewsFactory.PlaceComponentResult
            int r9 = r9 + 4
            int r7 = r7 * 2
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r7
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L32:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.appwidget.collectionview.StatementListRemoteViewsFactory.a(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = 4 - r7
            int r9 = r9 * 4
            int r9 = 75 - r9
            byte[] r0 = id.dana.appwidget.collectionview.StatementListRemoteViewsFactory.$$a
            int r8 = r8 * 2
            int r8 = 42 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r4 = 0
            r9 = r8
            goto L2c
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r6
        L2c:
            int r3 = -r3
            int r7 = r7 + 1
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.appwidget.collectionview.StatementListRemoteViewsFactory.b(byte, int, byte, java.lang.Object[]):void");
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final long getItemId(int p0) {
        return p0;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final RemoteViews getLoadingView() {
        return null;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final void onCreate() {
        try {
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 | 14), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            byte b4 = PlaceComponentResult[5];
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (-b4), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 3, (char) Color.argb(0, 0, 0, 0));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), 35 - View.resolveSizeAndState(0, 0, 0), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {932740245, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, 18 - View.MeasureSpec.getSize(0), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    public StatementListRemoteViewsFactory(Context context, Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(intent, "");
        this.PlaceComponentResult = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.MyBillsEntityDataFactory = new ArrayList<>();
        this.getAuthRequestContext = new ArrayList<>();
        this.BuiltInFictitiousFunctionClassFactory = intent.getIntExtra("appWidgetId", 0);
        getAuthRequestContext();
    }

    public /* synthetic */ StatementListRemoteViewsFactory(Context context, Intent intent, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, intent, (i & 4) != 0 ? true : z);
    }

    private final void getAuthRequestContext() {
        Context applicationContext = this.PlaceComponentResult.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        ApplicationComponent applicationComponent = ((DanaApplication) applicationContext).getApplicationComponent();
        if (applicationComponent != null) {
            DaggerDanaWidgetComponent.Builder PlaceComponentResult2 = DaggerDanaWidgetComponent.PlaceComponentResult();
            PlaceComponentResult2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaAppWidgetModule) Preconditions.getAuthRequestContext(new DanaAppWidgetModule(new DanaAppWidgetContract.View() { // from class: id.dana.appwidget.collectionview.StatementListRemoteViewsFactory$getDanaWidgetModule$1
                @Override // id.dana.appwidget.DanaAppWidgetContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                    DanaAppWidgetContract.View.CC.PlaceComponentResult();
                }

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
            }));
            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(this);
        }
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final int getCount() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return this.MyBillsEntityDataFactory.size();
        }
        return this.getAuthRequestContext.size();
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final RemoteViews getViewAt(int p0) {
        String str;
        String str2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            str = this.MyBillsEntityDataFactory.get(p0).MyBillsEntityDataFactory;
            str2 = this.MyBillsEntityDataFactory.get(p0).PlaceComponentResult;
        } else {
            str = this.getAuthRequestContext.get(p0).MyBillsEntityDataFactory;
            str2 = this.getAuthRequestContext.get(p0).PlaceComponentResult;
        }
        RemoteViews remoteViews = new RemoteViews(this.PlaceComponentResult.getPackageName(), (int) R.layout.list_item_statement_list);
        StatementTransactionType.Companion companion = StatementTransactionType.INSTANCE;
        remoteViews.setImageViewResource(R.id.iv_list_item_statement_icon, StatementTransactionType.Companion.BuiltInFictitiousFunctionClassFactory(str2).getDrawableIcon());
        Context context = this.PlaceComponentResult;
        StatementTransactionType.Companion companion2 = StatementTransactionType.INSTANCE;
        remoteViews.setTextViewText(R.id.tv_list_item_statement_statement_purpose, context.getString(StatementTransactionType.Companion.BuiltInFictitiousFunctionClassFactory(str2).getLocalizedTitle()));
        StringBuilder sb = new StringBuilder();
        sb.append("Rp");
        sb.append(str);
        remoteViews.setTextViewText(R.id.tv_list_item_statement_statement_purpose_amount, sb.toString());
        return remoteViews;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final void onDataSetChanged() {
        List<StatementSummaryModel> list;
        if (this.danaAppWidgetPresenter == null) {
            getAuthRequestContext();
        }
        DanaAppWidgetContract.Presenter presenter = this.danaAppWidgetPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        List<UserStatement> KClassImpl$Data$declaredNonStaticMembers$2 = presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        if ((!KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) == true) {
            this.MyBillsEntityDataFactory.clear();
            this.getAuthRequestContext.clear();
            for (StatementViewModel statementViewModel : StatementViewModelKt.PlaceComponentResult(UserStatementModelKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2))) {
                if (!KClassImpl$Data$declaredNonStaticMembers$2(statementViewModel)) {
                    if (BuiltInFictitiousFunctionClassFactory(statementViewModel) && (list = statementViewModel.PlaceComponentResult.MyBillsEntityDataFactory) != null) {
                        for (StatementSummaryModel statementSummaryModel : list) {
                            ArrayList<StatementItem> arrayList = this.getAuthRequestContext;
                            int hashCode = statementSummaryModel.hashCode();
                            String str = statementSummaryModel.getAuthRequestContext;
                            String str2 = statementSummaryModel.PlaceComponentResult;
                            String str3 = statementSummaryModel.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(str3, "");
                            arrayList.add(new StatementItem(this, hashCode, str, str2, str3));
                        }
                    }
                } else {
                    List<StatementSummaryModel> list2 = statementViewModel.PlaceComponentResult.MyBillsEntityDataFactory;
                    if (list2 != null) {
                        for (StatementSummaryModel statementSummaryModel2 : list2) {
                            ArrayList<StatementItem> arrayList2 = this.MyBillsEntityDataFactory;
                            int hashCode2 = statementSummaryModel2.hashCode();
                            String str4 = statementSummaryModel2.getAuthRequestContext;
                            String str5 = statementSummaryModel2.PlaceComponentResult;
                            String str6 = statementSummaryModel2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(str6, "");
                            arrayList2.add(new StatementItem(this, hashCode2, str4, str5, str6));
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/appwidget/collectionview/StatementListRemoteViewsFactory$StatementItem;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "", "I", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/appwidget/collectionview/StatementListRemoteViewsFactory;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public final class StatementItem {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        String MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String getAuthRequestContext;
        final /* synthetic */ StatementListRemoteViewsFactory getAuthRequestContext;

        public StatementItem(StatementListRemoteViewsFactory statementListRemoteViewsFactory, int i, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.getAuthRequestContext = statementListRemoteViewsFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = str2;
            this.MyBillsEntityDataFactory = str3;
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(StatementViewModel p0) {
        return 1 == p0.getAuthRequestContext && Intrinsics.areEqual(StatementType.EXPENSE.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(StatementViewModel p0) {
        return 1 == p0.getAuthRequestContext && Intrinsics.areEqual(StatementType.INCOME.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public final void onDestroy() {
        DanaAppWidgetContract.Presenter presenter = this.danaAppWidgetPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.onDestroy();
    }
}
