package id.dana.sendmoney_v2.recipient.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.bank.BankSelectorActivity;
import id.dana.base.AbstractContractKt;
import id.dana.contract.sendmoney.QueryPrefixErrorHandler;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.core.ui.model.UiTextModel;
import id.dana.danah5.DanaH5;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ActivityRecipientV2Binding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSearchActivityComponent;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.di.modules.SendMoneyModule;
import id.dana.dialog.BillerX2BDialog;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.di.module.SendMoneyCoreModule;
import id.dana.sendmoney.external.SmartFrictionBottomSheetFragment;
import id.dana.sendmoney.model.BaseRecipientModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.model.TransferUserInfoModel;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import id.dana.sendmoney_v2.recipient.view.RecipientView;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bZ\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0011\u0010\u001e\u001a\u00020\u0014*\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fR\u0013\u0010#\u001a\u00020 X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010\u0016\u001a\u00020+8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\r8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u00020:8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010F\u001a\u00020E8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0013\u0010N\u001a\u00020LX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bM\u0010\"R\u0013\u0010Q\u001a\u00020OX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bP\u0010\"R\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bW\u0010X"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/SearchRecipientActivity;", "Lid/dana/sendmoney_v2/recipient/activity/BaseRecipientActivity;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initInjector", "initRecipientView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/sendmoney/model/RecipientModel;", "recipientModel", "onRecipientSelected", "(Lid/dana/sendmoney/model/RecipientModel;)V", "onResume", "openSummary", "p0", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/model/RecipientModel;Z)V", "", "bankId", "bankNumber", "startAddBankAccountActivity", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthRequestContext", "isNewNumber", "(Lid/dana/sendmoney/model/RecipientModel;)Z", "Lid/dana/di/modules/BillerX2BModule;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "PlaceComponentResult", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "billerX2BPresenter", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "getBillerX2BPresenter", "()Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "setBillerX2BPresenter", "(Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "initRecordTimeStamp", "Lid/dana/domain/sendmoney/model/TransferInit;", "Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "calculatorPresenter", "Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "getCalculatorPresenter", "()Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "setCalculatorPresenter", "(Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/model/RecipientModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "sendMoneyCorePresenter", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "getSendMoneyCorePresenter", "()Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "setSendMoneyCorePresenter", "(Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "PrepareContext", "getErrorConfigVersion", "Lid/dana/di/modules/SendMoneyModule;", "newProxyInstance", "lookAheadTest", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "isLayoutRequested", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "moveToNextValue", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "scheduleImpl", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchRecipientActivity extends BaseRecipientActivity {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private RecipientModel MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private TransferInitResultModel scheduleImpl;
    @Inject
    public BillerX2BContract.Presenter billerX2BPresenter;
    @Inject
    public SendMoneyContract.Presenter calculatorPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private TransferInit BuiltInFictitiousFunctionClassFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private SmartFrictionConfig moveToNextValue;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    @Inject
    public SendMoneyCoreContract.Presenter sendMoneyCorePresenter;
    public static final byte[] $$a = {36, -18, 4, 125, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 108;
    public static final byte[] PlaceComponentResult = {2, -87, 98, TarHeader.LF_FIFO, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 64;
    private static char[] FragmentBottomSheetPaymentSettingBinding = {39498, 39615, 39497, 39611, 39612, 39490, 39551, 39608, 39517, 39496, 39494, 39614, 39602, 39510, 39613, 39530, 39609, 39607, 39513, 39493, 39606, 39489, 39540, 39543, 39541, 39549, 39538, 39495, 39547, 39546, 39544, 39545, 39499, 39542, 39539, 39548, 39492, 39610};
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda3 = 909154861;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private SendMoneyApiMigrationConfigModel KClassImpl$Data$declaredNonStaticMembers$2 = new SendMoneyApiMigrationConfigModel(false);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<BillerX2BModule>() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\b\u0010\u0012"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/SearchRecipientActivity$billerX2BModule$2$1;", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$View;", "", "p0", "", "PlaceComponentResult", "(Z)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/sendmoney/model/BaseRecipientModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/model/BaseRecipientModel;)V", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney_v2/model/BillerX2BModel;)V", "", "Lid/dana/domain/sendmoney/model/BillerX2B;", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public static final class AnonymousClass1 implements BillerX2BContract.View {
            final /* synthetic */ SearchRecipientActivity getAuthRequestContext;

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<BillerX2B> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final /* synthetic */ void getAuthRequestContext(String str) {
                BillerX2BContract.View.CC.PlaceComponentResult(str);
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

            AnonymousClass1(SearchRecipientActivity searchRecipientActivity) {
                this.getAuthRequestContext = searchRecipientActivity;
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (this.getAuthRequestContext.isClickable()) {
                    new BillerX2BDialog(r0, new DialogInterface.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SearchRecipientActivity.m2935$r8$lambda$RJfBk749ywamCceNhpHQFYrpc(SearchRecipientActivity.this, p0, dialogInterface, i);
                        }
                    }).KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void getAuthRequestContext(BaseRecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (this.getAuthRequestContext.isClickable() && (p0 instanceof RecipientModel)) {
                    RecipientModel recipientModel = (RecipientModel) p0;
                    this.getAuthRequestContext.processRecipientListData(recipientModel);
                    this.getAuthRequestContext.openSummary(recipientModel);
                }
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaH5.startContainerFullUrl(p0);
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void PlaceComponentResult(final BaseRecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SearchRecipientActivity searchRecipientActivity = this.getAuthRequestContext;
                searchRecipientActivity.addDisposable(QueryPrefixErrorHandler.MyBillsEntityDataFactory(searchRecipientActivity).subscribe(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: INVOKE 
                      (r0v1 'searchRecipientActivity' id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity)
                      (wrap: io.reactivex.disposables.Disposable : 0x0013: INVOKE 
                      (wrap: io.reactivex.Observable<java.lang.Long> : 0x000a: INVOKE (r0v1 'searchRecipientActivity' id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity) type: STATIC call: id.dana.contract.sendmoney.QueryPrefixErrorHandler.MyBillsEntityDataFactory(android.app.Activity):io.reactivex.Observable A[MD:(android.app.Activity):io.reactivex.Observable<java.lang.Long> (m), WRAPPED] (LINE:337))
                      (wrap: io.reactivex.functions.Consumer<? super java.lang.Long> : 0x0010: CONSTRUCTOR 
                      (r3v0 'this' id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1 A[DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r4v0 'p0' id.dana.sendmoney.model.BaseRecipientModel A[DONT_INLINE])
                     A[MD:(id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1, id.dana.sendmoney.model.BaseRecipientModel):void (m), WRAPPED] (LINE:338) call: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0.<init>(id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1, id.dana.sendmoney.model.BaseRecipientModel):void type: CONSTRUCTOR)
                     type: VIRTUAL call: io.reactivex.Observable.subscribe(io.reactivex.functions.Consumer):io.reactivex.disposables.Disposable A[MD:(io.reactivex.functions.Consumer<? super T>):io.reactivex.disposables.Disposable (m), WRAPPED] (LINE:338))
                     type: VIRTUAL call: id.dana.base.BaseActivity.addDisposable(io.reactivex.disposables.Disposable):void A[MD:(io.reactivex.disposables.Disposable):void (m)] (LINE:336) in method: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2.1.PlaceComponentResult(id.dana.sendmoney.model.BaseRecipientModel):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                    	... 15 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                    id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity r0 = r3.getAuthRequestContext
                    r1 = r0
                    android.app.Activity r1 = (android.app.Activity) r1
                    io.reactivex.Observable r1 = id.dana.contract.sendmoney.QueryPrefixErrorHandler.MyBillsEntityDataFactory(r1)
                    id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0 r2 = new id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0
                    r2.<init>(r3, r4)
                    io.reactivex.disposables.Disposable r4 = r1.subscribe(r2)
                    r0.addDisposable(r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$billerX2BModule$2.AnonymousClass1.PlaceComponentResult(id.dana.sendmoney.model.BaseRecipientModel):void");
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void PlaceComponentResult(boolean p0) {
                if (p0) {
                    DanaLoadingDialog danaLoadingDialog = this.getAuthRequestContext.getDanaLoadingDialog();
                    if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                        return;
                    }
                    danaLoadingDialog.MyBillsEntityDataFactory.show();
                    danaLoadingDialog.getAuthRequestContext.startRefresh();
                    return;
                }
                this.getAuthRequestContext.getDanaLoadingDialog().PlaceComponentResult();
            }

            public static /* synthetic */ void getAuthRequestContext(AnonymousClass1 anonymousClass1, BaseRecipientModel baseRecipientModel) {
                Intrinsics.checkNotNullParameter(anonymousClass1, "");
                Intrinsics.checkNotNullParameter(baseRecipientModel, "");
                anonymousClass1.getAuthRequestContext(baseRecipientModel);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BillerX2BModule invoke() {
            return new BillerX2BModule(new AnonymousClass1(SearchRecipientActivity.this));
        }
    });

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<SendMoneyModule>() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\r\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J#\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\u0018\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004JA\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u001dJ7\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u001eJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\r\u0010 "}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/SearchRecipientActivity$sendMoneyModule$2$1;", "Lid/dana/contract/sendmoney/SendMoneyContract$View;", "", "dismissProgress", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "Lid/dana/core/ui/model/UiTextModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "getAuthRequestContext", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "", "(Ljava/lang/Throwable;)V", "PlaceComponentResult", "Lid/dana/sendmoney/model/RecipientModel;", "p1", "(Lid/dana/sendmoney/model/RecipientModel;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "p2", "p3", "p4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "showProgress", "(Lid/dana/sendmoney/model/RecipientModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public static final class AnonymousClass1 implements SendMoneyContract.View {
            final /* synthetic */ SearchRecipientActivity MyBillsEntityDataFactory;

            public static /* synthetic */ void PlaceComponentResult() {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void BuiltInFictitiousFunctionClassFactory(RecipientModel p0) {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void MyBillsEntityDataFactory(String p0) {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1) {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void PlaceComponentResult(TransferInit p0) {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void PlaceComponentResult(RecipientModel p0, String p1) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            AnonymousClass1(SearchRecipientActivity searchRecipientActivity) {
                this.MyBillsEntityDataFactory = searchRecipientActivity;
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4) {
                ActivityRecipientV2Binding binding;
                RecipientModel recipientModel;
                RecipientModel recipientModel2;
                RecipientModel recipientModel3;
                RecipientModel recipientModel4;
                RecipientModel recipientModel5;
                RecipientModel recipientModel6;
                RecipientModel recipientModel7;
                this.MyBillsEntityDataFactory.getAuthRequestContext = true;
                binding = this.MyBillsEntityDataFactory.getBinding();
                RecipientView recipientView = binding.BuiltInFictitiousFunctionClassFactory;
                SearchRecipientActivity searchRecipientActivity = this.MyBillsEntityDataFactory;
                recipientModel = searchRecipientActivity.MyBillsEntityDataFactory;
                RecipientModel recipientModel8 = null;
                if (recipientModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel = null;
                }
                if (p4 == null) {
                    p4 = "";
                }
                recipientModel.PlaceComponentResult = p4;
                recipientModel2 = searchRecipientActivity.MyBillsEntityDataFactory;
                if (recipientModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel2 = null;
                }
                recipientModel2.GetContactSyncConfig = true;
                recipientModel3 = searchRecipientActivity.MyBillsEntityDataFactory;
                if (recipientModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel3 = null;
                }
                if (Intrinsics.areEqual(recipientModel3.SubSequence, "Manual Input")) {
                    recipientModel7 = searchRecipientActivity.MyBillsEntityDataFactory;
                    if (recipientModel7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recipientModel7 = null;
                    }
                    recipientModel7.SubSequence = RecipientSource.SEARCH_MANUAL_INPUT;
                } else {
                    recipientModel4 = searchRecipientActivity.MyBillsEntityDataFactory;
                    if (recipientModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recipientModel4 = null;
                    }
                    recipientModel4.SubSequence = RecipientSource.SEARCH;
                }
                recipientModel5 = searchRecipientActivity.MyBillsEntityDataFactory;
                if (recipientModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel5 = null;
                }
                recipientModel6 = searchRecipientActivity.MyBillsEntityDataFactory;
                if (recipientModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recipientModel8 = recipientModel6;
                }
                searchRecipientActivity.BuiltInFictitiousFunctionClassFactory(recipientModel5, searchRecipientActivity.isNewNumber(recipientModel8));
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                RecipientModel recipientModel;
                RecipientModel recipientModel2;
                boolean z;
                boolean z2;
                RecipientModel recipientModel3;
                recipientModel = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                RecipientModel recipientModel4 = null;
                if (recipientModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel = null;
                }
                recipientModel.GetContactSyncConfig = false;
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SearchRecipientActivity.access$getSendMoneyFeatureTime(this.MyBillsEntityDataFactory);
                access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
                SearchRecipientActivity searchRecipientActivity = this.MyBillsEntityDataFactory;
                recipientModel2 = searchRecipientActivity.MyBillsEntityDataFactory;
                if (recipientModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel2 = null;
                }
                String str = recipientModel2.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(str, "");
                z = this.MyBillsEntityDataFactory.getAuthRequestContext;
                searchRecipientActivity.getAuthRequestContext(str, z ? null : TrackerKey.SmartFrictionProperties.NON_DANA_USER);
                z2 = this.MyBillsEntityDataFactory.getAuthRequestContext;
                if (z2) {
                    return;
                }
                SearchRecipientActivity searchRecipientActivity2 = this.MyBillsEntityDataFactory;
                recipientModel3 = searchRecipientActivity2.MyBillsEntityDataFactory;
                if (recipientModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recipientModel4 = recipientModel3;
                }
                SearchRecipientActivity.access$showUnregisteredUserDialog(searchRecipientActivity2, recipientModel4);
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
                RecipientModel recipientModel;
                RecipientModel recipientModel2;
                boolean z;
                RecipientModel recipientModel3;
                RecipientModel recipientModel4;
                RecipientModel recipientModel5;
                recipientModel = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                RecipientModel recipientModel6 = null;
                if (recipientModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel = null;
                }
                recipientModel.GetContactSyncConfig = false;
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SearchRecipientActivity.access$getSendMoneyFeatureTime(this.MyBillsEntityDataFactory);
                access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
                SearchRecipientActivity searchRecipientActivity = this.MyBillsEntityDataFactory;
                recipientModel2 = searchRecipientActivity.MyBillsEntityDataFactory;
                if (recipientModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel2 = null;
                }
                String str = recipientModel2.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(str, "");
                searchRecipientActivity.getAuthRequestContext(str, TrackerKey.SmartFrictionProperties.NON_DANA_USER);
                z = this.MyBillsEntityDataFactory.getAuthRequestContext;
                if (z) {
                    SearchRecipientActivity searchRecipientActivity2 = this.MyBillsEntityDataFactory;
                    recipientModel4 = searchRecipientActivity2.MyBillsEntityDataFactory;
                    if (recipientModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recipientModel4 = null;
                    }
                    SearchRecipientActivity searchRecipientActivity3 = this.MyBillsEntityDataFactory;
                    recipientModel5 = searchRecipientActivity3.MyBillsEntityDataFactory;
                    if (recipientModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        recipientModel6 = recipientModel5;
                    }
                    searchRecipientActivity2.BuiltInFictitiousFunctionClassFactory(recipientModel4, searchRecipientActivity3.isNewNumber(recipientModel6));
                    return;
                }
                SearchRecipientActivity searchRecipientActivity4 = this.MyBillsEntityDataFactory;
                recipientModel3 = searchRecipientActivity4.MyBillsEntityDataFactory;
                if (recipientModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recipientModel6 = recipientModel3;
                }
                SearchRecipientActivity.access$showUnregisteredUserDialog(searchRecipientActivity4, recipientModel6);
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void getAuthRequestContext(TransferInit p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = p0;
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void PlaceComponentResult(Throwable p0, String p1, String p2, String p3) {
                String str = p2;
                if (str == null || str.length() == 0) {
                    return;
                }
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, p1, p2, p3, p0);
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                if (p0) {
                    DanaLoadingDialog danaLoadingDialog = this.MyBillsEntityDataFactory.getDanaLoadingDialog();
                    if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                        return;
                    }
                    danaLoadingDialog.MyBillsEntityDataFactory.show();
                    danaLoadingDialog.getAuthRequestContext.startRefresh();
                    return;
                }
                this.MyBillsEntityDataFactory.getDanaLoadingDialog().PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                RecipientModel recipientModel;
                RecipientModel recipientModel2;
                SearchRecipientActivity searchRecipientActivity = this.MyBillsEntityDataFactory;
                recipientModel = searchRecipientActivity.MyBillsEntityDataFactory;
                RecipientModel recipientModel3 = null;
                if (recipientModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel = null;
                }
                SearchRecipientActivity searchRecipientActivity2 = this.MyBillsEntityDataFactory;
                recipientModel2 = searchRecipientActivity2.MyBillsEntityDataFactory;
                if (recipientModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recipientModel3 = recipientModel2;
                }
                searchRecipientActivity.BuiltInFictitiousFunctionClassFactory(recipientModel, searchRecipientActivity2.isNewNumber(recipientModel3));
            }

            @Override // id.dana.contract.sendmoney.SendMoneyContract.View
            public final void BuiltInFictitiousFunctionClassFactory(UiTextModel p0) {
                SearchRecipientActivity searchRecipientActivity = this.MyBillsEntityDataFactory;
                searchRecipientActivity.showWarningDialog(p0.asString(searchRecipientActivity), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE 
                      (r0v0 'searchRecipientActivity' id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity)
                      (wrap: java.lang.String : 0x0005: INVOKE 
                      (r5v0 'p0' id.dana.core.ui.model.UiTextModel)
                      (r0v0 'searchRecipientActivity' id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity)
                     type: VIRTUAL call: id.dana.core.ui.model.UiTextModel.asString(android.content.Context):java.lang.String A[MD:(android.content.Context):java.lang.String (m), WRAPPED])
                      (wrap: android.content.DialogInterface$OnDismissListener : 0x000b: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2$1$$ExternalSyntheticLambda0.<init>():void type: CONSTRUCTOR)
                      true
                      (3000 int)
                     type: VIRTUAL call: id.dana.base.BaseActivity.showWarningDialog(java.lang.String, android.content.DialogInterface$OnDismissListener, boolean, int):void A[MD:(java.lang.String, android.content.DialogInterface$OnDismissListener, boolean, int):void (m)] in method: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2.1.BuiltInFictitiousFunctionClassFactory(id.dana.core.ui.model.UiTextModel):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                    	... 15 more
                    */
                /*
                    this = this;
                    id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity r0 = r4.MyBillsEntityDataFactory
                    r1 = r0
                    android.content.Context r1 = (android.content.Context) r1
                    java.lang.String r5 = r5.asString(r1)
                    id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2$1$$ExternalSyntheticLambda0 r1 = new id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2$1$$ExternalSyntheticLambda0
                    r1.<init>()
                    r2 = 1
                    r3 = 3000(0xbb8, float:4.204E-42)
                    r0.showWarningDialog(r5, r1, r2, r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$sendMoneyModule$2.AnonymousClass1.BuiltInFictitiousFunctionClassFactory(id.dana.core.ui.model.UiTextModel):void");
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyModule invoke() {
            return new SendMoneyModule(new AnonymousClass1(SearchRecipientActivity.this));
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = 55 - r7
            int r8 = 106 - r8
            int r9 = r9 + 16
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity.PlaceComponentResult
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2d
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            int r7 = r7 + 1
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2d:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity.a(byte, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity.$$a
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1a:
            r3 = 0
        L1b:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity.c(short, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(null, 126 - Process.getGidForName(""), new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(null, 127 - TextUtils.indexOf("", ""), new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 35 - Color.alpha(0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(null, 126 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(null, 127 - TextUtils.indexOf("", "", 0, 0), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(null, KeyEvent.keyCodeFromString("") + 127, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(null, 127 - Color.blue(0), new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(null, 127 - (ViewConfiguration.getTapTimeout() >> 16), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, View.resolveSizeAndState(0, 0, 0) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                byte b = (byte) (-PlaceComponentResult[31]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                a(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(Ascii.RS, PlaceComponentResult[9], PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - MotionEvent.axisFromString(""), TextUtils.indexOf("", "", 0, 0) + 3, (char) Gravity.getAbsoluteGravity(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], $$a[47], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.green(0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 14, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 800, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 14, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 815, View.getDefaultSize(0, 0) + 29, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (KeyEvent.getMaxKeyCode() >> 16), View.MeasureSpec.getSize(0) + 15, (char) Color.argb(0, 0, 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {142062383, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 18 - KeyEvent.getDeadChar(0, 0), (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                byte b3 = (byte) (-PlaceComponentResult[31]);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                a(b3, b4, b4, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(Ascii.RS, PlaceComponentResult[9], PlaceComponentResult[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 60, KeyEvent.keyCodeFromString("") + 46, (char) View.resolveSizeAndState(0, 0, 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[28], $$a[8], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, Color.green(0) + 35, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {142062383, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, 18 - Color.argb(0, 0, 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                byte b5 = (byte) (-PlaceComponentResult[31]);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                a(b5, b6, b6, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(Ascii.RS, PlaceComponentResult[9], PlaceComponentResult[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 118, KeyEvent.keyCodeFromString("") + 3, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 38969));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[28], $$a[8], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 930, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {142062383, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                byte b7 = (byte) (-PlaceComponentResult[31]);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                a(b7, b8, b8, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(Ascii.RS, PlaceComponentResult[9], PlaceComponentResult[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 107, Color.blue(0) + 3, (char) TextUtils.getOffsetBefore("", 0));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {142062383, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, super.getResources().getString(R.string.transfer_purpose_title).substring(2, 3).length() + 126, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(null, super.getResources().getString(R.string.desc_tap_card_please).substring(4, 5).length() + 126, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, TextUtils.lastIndexOf("", '0', 0) + 19, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
    }

    @JvmName(name = "getBillerX2BPresenter")
    public final BillerX2BContract.Presenter getBillerX2BPresenter() {
        BillerX2BContract.Presenter presenter = this.billerX2BPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBillerX2BPresenter")
    public final void setBillerX2BPresenter(BillerX2BContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.billerX2BPresenter = presenter;
    }

    @JvmName(name = "getCalculatorPresenter")
    public final SendMoneyContract.Presenter getCalculatorPresenter() {
        SendMoneyContract.Presenter presenter = this.calculatorPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCalculatorPresenter")
    public final void setCalculatorPresenter(SendMoneyContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.calculatorPresenter = presenter;
    }

    @JvmName(name = "getSendMoneyCorePresenter")
    public final SendMoneyCoreContract.Presenter getSendMoneyCorePresenter() {
        SendMoneyCoreContract.Presenter presenter = this.sendMoneyCorePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyCorePresenter")
    public final void setSendMoneyCorePresenter(SendMoneyCoreContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendMoneyCorePresenter = presenter;
    }

    @JvmName(name = "getSendMoneyAnalyticTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticTracker;
        if (sendMoneyAnalyticTracker != null) {
            return sendMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyAnalyticTracker")
    public final void setSendMoneyAnalyticTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.BaseActivity
    public final void configToolbar() {
        super.configToolbar();
        setCenterTitle(getString(R.string.sendmoney_searching));
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, super.getResources().getString(R.string.referral_tracker_hidden_button_play).substring(4, 15).length() + 116, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(null, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 127, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), 18 - View.resolveSizeAndState(0, 0, 0), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onResume();
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.getErrorConfigVersion.getValue();
        sendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("OPEN SEARCH PAGE", "");
        if (sendMoneyFeatureTime.getAuthRequestContext.get("OPEN SEARCH PAGE") == null) {
            getSendMoneyAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2();
        }
        sendMoneyFeatureTime.getAuthRequestContext();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        super.init();
        getBinding().BuiltInFictitiousFunctionClassFactory.initRecipientView();
        getRecipientPresenter().MyBillsEntityDataFactory();
        getSendMoneyCorePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$setOnBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SearchRecipientActivity.access$getSendMoneyFeatureTime(SearchRecipientActivity.this);
                Intrinsics.checkNotNullParameter("OPEN SEARCH PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN SEARCH PAGE");
                SendMoneyFeatureTime access$getSendMoneyFeatureTime2 = SearchRecipientActivity.access$getSendMoneyFeatureTime(SearchRecipientActivity.this);
                Intrinsics.checkNotNullParameter("INIT ON SEARCH SELECTION", "");
                access$getSendMoneyFeatureTime2.getAuthRequestContext.remove("INIT ON SEARCH SELECTION");
                SearchRecipientActivity.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    protected final void initInjector() {
        DaggerSearchActivityComponent.Builder authRequestContext = DaggerSearchActivityComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (RecipientActivityModule) Preconditions.getAuthRequestContext(new RecipientActivityModule(new RecipientContract.View() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$recipientActivityModule$1
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

            @Override // id.dana.contract.sendmoney.RecipientContract.View
            public final void onFinishCheckReferralSendMoney(boolean p0, String p1) {
                Intrinsics.checkNotNullParameter(p1, "");
            }

            @Override // id.dana.contract.sendmoney.RecipientContract.View
            public final void onSuccessRemoveOldFavoriteState(boolean p0) {
            }

            @Override // id.dana.contract.sendmoney.RecipientContract.View
            public final void onSuccessUpdateFavoriteState(boolean p0, RecentRecipientModel p1) {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.sendmoney.RecipientContract.View
            public final void onGetFeatureBelowKitkatConfigSuccess(boolean p0) {
                SearchRecipientActivity.this.setBelowKitkatDialog(p0);
            }

            @Override // id.dana.contract.sendmoney.RecipientContract.View
            public final void onGetSmartFrictionConfig(SmartFrictionConfig p0) {
                ActivityRecipientV2Binding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                SearchRecipientActivity.this.moveToNextValue = p0;
                binding = SearchRecipientActivity.this.getBinding();
                RecipientView recipientView = binding.BuiltInFictitiousFunctionClassFactory;
                recipientView.setNotBankListRecent(p0.getNotBankListRecent());
                recipientView.setNotContactListRecent(p0.getNotContactListRecent());
            }
        }));
        authRequestContext.getAuthRequestContext = (SendMoneyModule) Preconditions.getAuthRequestContext((SendMoneyModule) this.lookAheadTest.getValue());
        authRequestContext.PlaceComponentResult = (BillerX2BModule) Preconditions.getAuthRequestContext((BillerX2BModule) this.PlaceComponentResult.getValue());
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (SendMoneyCoreModule) Preconditions.getAuthRequestContext(new SendMoneyCoreModule(new SearchRecipientActivity$getSendMoneyCoreModule$1(this)));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, RecipientActivityModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult, BillerX2BModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, SendMoneyModule.class);
        if (authRequestContext.moveToNextValue == null) {
            authRequestContext.moveToNextValue = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, SendMoneyCoreModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerSearchActivityComponent.SearchActivityComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.PlaceComponentResult, authRequestContext.getAuthRequestContext, authRequestContext.moveToNextValue, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.MyBillsEntityDataFactory, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getRecipientPresenter(), getBillerX2BPresenter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(RecipientModel p0, boolean p1) {
        TransferInitResultModel transferInitResultModel;
        TransferInit transferInit;
        TransferInit transferInit2 = this.BuiltInFictitiousFunctionClassFactory;
        if (transferInit2 != null) {
            SearchRecipientActivity searchRecipientActivity = this;
            if (transferInit2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                transferInit = null;
            } else {
                transferInit = transferInit2;
            }
            BaseRecipientActivity.openSummary$default(searchRecipientActivity, p0, transferInit, null, p1, 4, null);
            return;
        }
        TransferInitResultModel transferInitResultModel2 = this.scheduleImpl;
        if (transferInitResultModel2 != null) {
            SearchRecipientActivity searchRecipientActivity2 = this;
            if (transferInitResultModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                transferInitResultModel = null;
            } else {
                transferInitResultModel = transferInitResultModel2;
            }
            BaseRecipientActivity.openSummary$default(searchRecipientActivity2, p0, null, transferInitResultModel, p1, 2, null);
            return;
        }
        openSummary(p0, null, null, p1);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    public final void openSummary(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        if (OSUtil.getErrorConfigVersion() || !getBelowKitkatDialog()) {
            super.openSummary(recipientModel);
            return;
        }
        ?? r2 = 0;
        MaterialDialog.positiveButton$default(MaterialDialog.message$default(new MaterialDialog(this, r2, 2, r2), Integer.valueOf((int) R.string.dialog_warning_below_kitkat), null, null, 6, null), null, null, null, 7, null).cancelable(false).show();
    }

    public final void startAddBankAccountActivity(String bankId, String bankNumber) {
        Intrinsics.checkNotNullParameter(bankId, "");
        Intrinsics.checkNotNullParameter(bankNumber, "");
        Bundle bundle = new Bundle();
        bundle.putBoolean(BankSelectorActivity.EXTRA_BELOW_KITKAT, getBelowKitkatDialog());
        String stringExtra = getIntent().getStringExtra("transferScenario");
        if (stringExtra == null) {
            stringExtra = "";
        }
        bundle.putString(BankSelectorActivity.EXTRA_TRANSFER_SCENARIO, stringExtra);
        bundle.putString(BankSelectorActivity.EXTRA_OPENED_FROM, RecipientSource.SEARCH_PAGE_ADD_NEW_BANK);
        BankSelectorActivity.Companion companion = BankSelectorActivity.INSTANCE;
        SearchRecipientActivity searchRecipientActivity = this;
        ArrayList<String> recentBank = getBinding().BuiltInFictitiousFunctionClassFactory.getRecentBank();
        SmartFrictionConfig smartFrictionConfig = this.moveToNextValue;
        if (smartFrictionConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            smartFrictionConfig = null;
        }
        startActivity(BankSelectorActivity.Companion.PlaceComponentResult(searchRecipientActivity, bankId, bankNumber, false, false, true, bundle, recentBank, smartFrictionConfig.getNotBankListRecent(), "Send Money", 24));
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    protected final void initRecipientView() {
        final RecipientView recipientView = getBinding().BuiltInFictitiousFunctionClassFactory;
        recipientView.setRecipientContactType(3);
        recipientView.setEnableViewSection(false);
        recipientView.setRecipientSelectedListener(this);
        recipientView.setOnContactSyncEnabled(new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$initRecipientView$1$1
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
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                sb.append(RecipientView.this.getClass().getName());
                sb.append(":init");
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.SYNC_CONTACT_TAG, sb.toString());
                RecipientView.this.checkContactSyncState();
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.getViewSearch().focusEtSearchContact();
    }

    static /* synthetic */ void getAuthRequestContext$default(SearchRecipientActivity searchRecipientActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        searchRecipientActivity.getAuthRequestContext(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(String p0, String p1) {
        RecipientView recipientView = getBinding().BuiltInFictitiousFunctionClassFactory;
        String indoPhoneNumber = NumberUtils.getIndoPhoneNumber(p0);
        Intrinsics.checkNotNullExpressionValue(indoPhoneNumber, "");
        SendMoneyAnalyticTracker.CC.MyBillsEntityDataFactory(getSendMoneyAnalyticTracker(), "DANA Balance", recipientView.isNumberInRecentContact(indoPhoneNumber), p1, false, 8);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getSendMoneyCorePresenter().PlaceComponentResult();
    }

    /* renamed from: $r8$lambda$RJ-fBk749ywamC-ceNhpHQFYrpc  reason: not valid java name */
    public static /* synthetic */ void m2935$r8$lambda$RJfBk749ywamCceNhpHQFYrpc(SearchRecipientActivity searchRecipientActivity, BillerX2BModel billerX2BModel, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(searchRecipientActivity, "");
        Intrinsics.checkNotNullParameter(billerX2BModel, "");
        if (-1 == i) {
            searchRecipientActivity.getBillerX2BPresenter().KClassImpl$Data$declaredNonStaticMembers$2(billerX2BModel);
            dialogInterface.dismiss();
        }
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(SearchRecipientActivity searchRecipientActivity) {
        return (SendMoneyFeatureTime) searchRecipientActivity.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void access$showUnregisteredUserDialog(final SearchRecipientActivity searchRecipientActivity, final RecipientModel recipientModel) {
        if (searchRecipientActivity.isActivityAvailable()) {
            SmartFrictionBottomSheetFragment smartFrictionBottomSheetFragment = new SmartFrictionBottomSheetFragment(new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$showUnregisteredUserDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SearchRecipientActivity.this.getSendMoneyAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(false, TrackerKey.SmartFrictionProperties.NON_DANA_USER);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$showUnregisteredUserDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (Intrinsics.areEqual(RecipientModel.this.SubSequence, "Manual Input")) {
                        RecipientModel.this.SubSequence = RecipientSource.SEARCH_MANUAL_INPUT;
                        searchRecipientActivity.BuiltInFictitiousFunctionClassFactory(RecipientModel.this, true);
                    } else {
                        RecipientModel.this.SubSequence = RecipientSource.SEARCH;
                        searchRecipientActivity.BuiltInFictitiousFunctionClassFactory(RecipientModel.this, false);
                    }
                    searchRecipientActivity.getSendMoneyAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(true, TrackerKey.SmartFrictionProperties.NON_DANA_USER);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            Intrinsics.checkNotNullParameter("UNREGISTERED_NUMBER", "");
            smartFrictionBottomSheetFragment.PlaceComponentResult = "UNREGISTERED_NUMBER";
            FragmentManager supportFragmentManager = searchRecipientActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            smartFrictionBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager);
            searchRecipientActivity.getSendMoneyAnalyticTracker().PlaceComponentResult(TrackerKey.SmartFrictionProperties.NON_DANA_USER, "DANA Balance");
        }
    }

    public static final /* synthetic */ void access$updateRecipientModel(SearchRecipientActivity searchRecipientActivity, TransferUserInfoModel transferUserInfoModel) {
        RecipientModel recipientModel = null;
        if (transferUserInfoModel.MyBillsEntityDataFactory()) {
            RecipientModel recipientModel2 = searchRecipientActivity.MyBillsEntityDataFactory;
            if (recipientModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                recipientModel = recipientModel2;
            }
            recipientModel.MyBillsEntityDataFactory = transferUserInfoModel.FragmentBottomSheetPaymentSettingBinding;
            recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = "userid";
            recipientModel.GetContactSyncConfig = true;
            recipientModel.PlaceComponentResult = transferUserInfoModel.BuiltInFictitiousFunctionClassFactory;
            String str = recipientModel.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str, "");
            Intrinsics.checkNotNullParameter(str, "");
            if (!NumberUtils.isValidIndoPhoneNumberPrefix(str)) {
                str = transferUserInfoModel.GetContactSyncConfig;
            }
            recipientModel.getErrorConfigVersion = str;
            String PlaceComponentResult2 = recipientModel.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            recipientModel.scheduleImpl = transferUserInfoModel.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2());
            return;
        }
        RecipientModel recipientModel3 = searchRecipientActivity.MyBillsEntityDataFactory;
        if (recipientModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientModel = recipientModel3;
        }
        recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = "phonenumber";
        recipientModel.PlaceComponentResult = transferUserInfoModel.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean isNewNumber(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        return Intrinsics.areEqual(recipientModel.SubSequence, "Manual Input") || Intrinsics.areEqual(recipientModel.SubSequence, RecipientSource.SEARCH_MANUAL_INPUT);
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Method method;
        try {
            Object[] objArr2 = new Object[1];
            a((byte) (PlaceComponentResult[49] - 1), (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(PlaceComponentResult[25], PlaceComponentResult[48], PlaceComponentResult[0], objArr3);
            Object[] objArr4 = new Object[1];
            b(null, ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(null, (ViewConfiguration.getJumpTapTimeout() >> 16) + 127, new byte[]{-125, -122, -114, -115, -116}, null, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    b(null, 127 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    b(null, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 128, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        b(null, View.MeasureSpec.makeMeasureSpec(0, 0) + 127, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(null, (ViewConfiguration.getPressedStateDuration() >> 16) + 127, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(null, getPackageName().length() + 120, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(null, super.getResources().getString(R.string.m_away_with_dot).substring(0, 9).length() + 118, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b(null, 127 - KeyEvent.getDeadChar(0, 0), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            }
            try {
                byte b = (byte) (-PlaceComponentResult[31]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                a(b, b2, b2, objArr14);
                Class<?> cls4 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a(Ascii.RS, PlaceComponentResult[9], PlaceComponentResult[25], objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 494, 4 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr17 = new Object[1];
                        c($$a[9], (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr17);
                        obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                    int i = ((int[]) objArr18[1])[0];
                    if (((int[]) objArr18[0])[0] != i) {
                        long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                method = obj4;
                                objArr = null;
                            } else {
                                objArr = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), 35 - View.combineMeasuredStates(0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke2 = ((Method) method).invoke(objArr, objArr);
                            try {
                                Object[] objArr19 = {843399316, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr19);
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
                    ((SendMoneyFeatureTime) this.getErrorConfigVersion.getValue()).getAuthRequestContext();
                    ((SendMoneyFeatureTime) this.getErrorConfigVersion.getValue()).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    super.onCreate(savedInstanceState);
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            } catch (Throwable th6) {
                Throwable cause6 = th6.getCause();
                if (cause6 == null) {
                    throw th6;
                }
                throw cause6;
            }
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    @Override // id.dana.sendmoney.view.BaseRecipientListener
    public final void onRecipientSelected(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        boolean areEqual = Intrinsics.areEqual(recipientModel.readMicros, "bank");
        boolean z = Intrinsics.areEqual(recipientModel.readMicros, "contact") && !recipientModel.moveToNextValue();
        if (areEqual) {
            getBillerX2BPresenter().PlaceComponentResult(recipientModel);
            recipientModel.SubSequence = RecipientSource.SEARCH;
            String str = recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
            Intrinsics.checkNotNullExpressionValue(str, "");
            ArrayList<String> recentBank = getBinding().BuiltInFictitiousFunctionClassFactory.getRecentBank();
            SendMoneyAnalyticTracker.CC.MyBillsEntityDataFactory(getSendMoneyAnalyticTracker(), "BANK", (recentBank != null ? Boolean.valueOf(recentBank.contains(str)) : null).booleanValue(), null, false, 12);
        } else if (z) {
            this.MyBillsEntityDataFactory = recipientModel;
            this.getAuthRequestContext = false;
            ((SendMoneyFeatureTime) this.getErrorConfigVersion.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext()) {
                boolean areEqual2 = Intrinsics.areEqual(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6, "phonenumber");
                boolean areEqual3 = Intrinsics.areEqual(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6, "userid");
                String KClassImpl$Data$declaredNonStaticMembers$2 = areEqual2 ? recipientModel.KClassImpl$Data$declaredNonStaticMembers$2() : "";
                String KClassImpl$Data$declaredNonStaticMembers$22 = areEqual3 ? recipientModel.KClassImpl$Data$declaredNonStaticMembers$2() : "";
                SendMoneyCoreContract.Presenter sendMoneyCorePresenter = getSendMoneyCorePresenter();
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
                String string = getString(R.string.unregistered_number_title);
                Intrinsics.checkNotNullExpressionValue(string, "");
                sendMoneyCorePresenter.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, TrackerKey.SourceType.SEND_TO_FRIEND_SEARCH_SELECT, string);
                return;
            }
            getCalculatorPresenter().PlaceComponentResult("BALANCE", recipientModel, "3.0", getString(R.string.unregistered_number_title));
        } else {
            processRecipientListData(recipientModel);
            if (Intrinsics.areEqual(recipientModel.SubSequence, "Manual Input")) {
                recipientModel.SubSequence = RecipientSource.SEARCH_MANUAL_INPUT;
                BuiltInFictitiousFunctionClassFactory(recipientModel, true);
                return;
            }
            recipientModel.SubSequence = RecipientSource.SEARCH;
            String str2 = recipientModel.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            getAuthRequestContext(str2, null);
            BuiltInFictitiousFunctionClassFactory(recipientModel, false);
        }
    }

    private static void b(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = FragmentBottomSheetPaymentSettingBinding;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda3);
        if (NetworkUserEntityData$$ExternalSyntheticLambda6) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda5) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
