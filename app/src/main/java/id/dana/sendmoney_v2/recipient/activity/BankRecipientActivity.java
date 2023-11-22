package id.dana.sendmoney_v2.recipient.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.bank.BankSelectorActivity;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.contract.sendmoney.QueryPrefixErrorHandler;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.danah5.DanaH5;
import id.dana.databinding.ActivityRecipientV2Binding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerBankActivityComponent;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.dialog.BillerX2BDialog;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.model.BaseRecipientModel;
import id.dana.sendmoney.model.QrRequestBankTransferModel;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.recipient.RecipientIdType;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import id.dana.sendmoney_v2.recipient.view.RecipientView;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.OSUtil;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u0007¢\u0006\u0004\bd\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0014¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010\u001eJ!\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b.\u0010&J\u0015\u0010/\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b/\u0010&J\r\u00100\u001a\u00020\u0003¢\u0006\u0004\b0\u0010\u0005J'\u00104\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00192\b\b\u0002\u00103\u001a\u00020\u0017¢\u0006\u0004\b4\u00105J\u0013\u00107\u001a\u00020\u0003*\u000206H\u0014¢\u0006\u0004\b7\u00108R\u0013\u0010<\u001a\u000209X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010>\u001a\u00020=8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0013\u0010M\u001a\u00020KX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bL\u0010;R\u0018\u0010P\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010V\u001a\u0004\u0018\u00010#8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010&R\"\u0010X\u001a\u00020W8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0013\u0010`\u001a\u00020^X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b_\u0010;R\u0016\u0010c\u001a\u00020\u001f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\ba\u0010b"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/BankRecipientActivity;", "Lid/dana/sendmoney_v2/recipient/activity/BaseRecipientActivity;", "Lid/dana/contract/sendmoney/RecipientContract$View;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initInjector", "initRecipientView", "Lid/dana/databinding/ActivityRecipientV2Binding;", "initViewBinding", "()Lid/dana/databinding/ActivityRecipientV2Binding;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "enable", "", "howToUrl", "onFinishCheckReferralSendMoney", "(ZLjava/lang/String;)V", "onGetFeatureBelowKitkatConfigSuccess", "(Z)V", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "smartFrictionConfig", "onGetSmartFrictionConfig", "(Lid/dana/domain/sendmoney/model/SmartFrictionConfig;)V", "Lid/dana/sendmoney/model/RecipientModel;", "recipientModel", "onRecipientSelected", "(Lid/dana/sendmoney/model/RecipientModel;)V", "onResume", "success", "onSuccessRemoveOldFavoriteState", "Lid/dana/sendmoney/model/RecentRecipientModel;", "recentRecipientModel", "onSuccessUpdateFavoriteState", "(ZLid/dana/sendmoney/model/RecentRecipientModel;)V", "openSummary", "showManageAccountBottomSheet", "showSnackbarRemoved", "bankId", "bankNumber", "finishOnAddBankCanceled", "startAddBankAccountActivity", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lid/dana/sendmoney/model/QrTransferModel;", "handleTransferData", "(Lid/dana/sendmoney/model/QrTransferModel;)V", "Lid/dana/di/modules/BillerX2BModule;", "DatabaseTableConfigUtil", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "billerX2BPresenter", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "getBillerX2BPresenter", "()Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "setBillerX2BPresenter", "(Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;)V", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney_v2/recipient/activity/ManageAccountBottomSheet;", "initRecordTimeStamp", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/sendmoney/model/QrTransferModel;", "BuiltInFictitiousFunctionClassFactory", "newProxyInstance", "Lid/dana/sendmoney/model/RecipientModel;", "getRecipientSelectedMoreAction", "()Lid/dana/sendmoney/model/RecipientModel;", "setRecipientSelectedMoreAction", "recipientSelectedMoreAction", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "PrepareContext", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "getErrorConfigVersion", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankRecipientActivity extends BaseRecipientActivity implements RecipientContract.View {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private CustomSnackbar PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private SmartFrictionConfig getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private QrTransferModel BuiltInFictitiousFunctionClassFactory;
    @Inject
    public BillerX2BContract.Presenter billerX2BPresenter;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private RecipientModel recipientSelectedMoreAction;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    public static final byte[] $$a = {111, -54, 77, -36, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = FileUtils.JPEG_MARKER_EOI;
    public static final byte[] getAuthRequestContext = {4, -20, -33, -123, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 14;
    private static long isLayoutRequested = 6051957081172619378L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ManageAccountBottomSheet>() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$manageAccountBottomSheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ManageAccountBottomSheet invoke() {
            final BankRecipientActivity bankRecipientActivity = BankRecipientActivity.this;
            Function1<RecipientModel, Unit> function1 = new Function1<RecipientModel, Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$manageAccountBottomSheet$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(RecipientModel recipientModel) {
                    invoke2(recipientModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(RecipientModel recipientModel) {
                    ActivityRecipientV2Binding binding;
                    Intrinsics.checkNotNullParameter(recipientModel, "");
                    binding = BankRecipientActivity.this.getBinding();
                    binding.BuiltInFictitiousFunctionClassFactory.getSavedBankPresenter().MyBillsEntityDataFactory();
                }
            };
            final BankRecipientActivity bankRecipientActivity2 = BankRecipientActivity.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$manageAccountBottomSheet$2.2
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
                    ActivityRecipientV2Binding binding;
                    binding = BankRecipientActivity.this.getBinding();
                    binding.BuiltInFictitiousFunctionClassFactory.getSavedBankPresenter().PlaceComponentResult();
                }
            };
            final BankRecipientActivity bankRecipientActivity3 = BankRecipientActivity.this;
            return new ManageAccountBottomSheet(function1, function0, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$manageAccountBottomSheet$2.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    BankRecipientActivity bankRecipientActivity4 = BankRecipientActivity.this;
                    SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                    BankRecipientActivity.access$showSnackbarRemoveFailed(bankRecipientActivity4, SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory.asString(BankRecipientActivity.this));
                }
            }, null, 8, null);
        }
    });

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy scheduleImpl = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<BillerX2BModule>() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\b\u0010\u0012"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/BankRecipientActivity$billerX2BModule$2$1;", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$View;", "", "p0", "", "PlaceComponentResult", "(Z)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/sendmoney/model/BaseRecipientModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/model/BaseRecipientModel;)V", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney_v2/model/BillerX2BModel;)V", "", "Lid/dana/domain/sendmoney/model/BillerX2B;", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public static final class AnonymousClass1 implements BillerX2BContract.View {
            final /* synthetic */ BankRecipientActivity MyBillsEntityDataFactory;

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

            AnonymousClass1(BankRecipientActivity bankRecipientActivity) {
                this.MyBillsEntityDataFactory = bankRecipientActivity;
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (this.MyBillsEntityDataFactory.isClickable()) {
                    new BillerX2BDialog(r0, new DialogInterface.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            BankRecipientActivity.$r8$lambda$0sUzTXtWvBNdCHvOH6M7ERNpx2U(BankRecipientActivity.this, p0, dialogInterface, i);
                        }
                    }).KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void getAuthRequestContext(BaseRecipientModel p0) {
                QrTransferModel qrTransferModel;
                Intrinsics.checkNotNullParameter(p0, "");
                if (this.MyBillsEntityDataFactory.isClickable() && (p0 instanceof RecipientModel)) {
                    qrTransferModel = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                    if (qrTransferModel != null) {
                        if (!qrTransferModel.getErrorConfigVersion()) {
                            qrTransferModel = null;
                        }
                        if (qrTransferModel != null) {
                            ((RecipientModel) p0).PrepareContext = qrTransferModel.getKClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    }
                    RecipientModel recipientModel = (RecipientModel) p0;
                    this.MyBillsEntityDataFactory.processRecipientListData(recipientModel);
                    this.MyBillsEntityDataFactory.openSummary(recipientModel);
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
                BankRecipientActivity bankRecipientActivity = this.MyBillsEntityDataFactory;
                bankRecipientActivity.addDisposable(QueryPrefixErrorHandler.MyBillsEntityDataFactory(bankRecipientActivity).subscribe(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: INVOKE 
                      (r0v1 'bankRecipientActivity' id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity)
                      (wrap: io.reactivex.disposables.Disposable : 0x0013: INVOKE 
                      (wrap: io.reactivex.Observable<java.lang.Long> : 0x000a: INVOKE (r0v1 'bankRecipientActivity' id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity) type: STATIC call: id.dana.contract.sendmoney.QueryPrefixErrorHandler.MyBillsEntityDataFactory(android.app.Activity):io.reactivex.Observable A[MD:(android.app.Activity):io.reactivex.Observable<java.lang.Long> (m), WRAPPED])
                      (wrap: io.reactivex.functions.Consumer<? super java.lang.Long> : 0x0010: CONSTRUCTOR 
                      (r3v0 'this' id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1 A[DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r4v0 'p0' id.dana.sendmoney.model.BaseRecipientModel A[DONT_INLINE])
                     A[MD:(id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1, id.dana.sendmoney.model.BaseRecipientModel):void (m), WRAPPED] (LINE:127) call: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0.<init>(id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1, id.dana.sendmoney.model.BaseRecipientModel):void type: CONSTRUCTOR)
                     type: VIRTUAL call: io.reactivex.Observable.subscribe(io.reactivex.functions.Consumer):io.reactivex.disposables.Disposable A[MD:(io.reactivex.functions.Consumer<? super T>):io.reactivex.disposables.Disposable (m), WRAPPED] (LINE:127))
                     type: VIRTUAL call: id.dana.base.BaseActivity.addDisposable(io.reactivex.disposables.Disposable):void A[MD:(io.reactivex.disposables.Disposable):void (m)] (LINE:126) in method: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2.1.PlaceComponentResult(id.dana.sendmoney.model.BaseRecipientModel):void, file: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0, state: NOT_LOADED
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
                    id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity r0 = r3.MyBillsEntityDataFactory
                    r1 = r0
                    android.app.Activity r1 = (android.app.Activity) r1
                    io.reactivex.Observable r1 = id.dana.contract.sendmoney.QueryPrefixErrorHandler.MyBillsEntityDataFactory(r1)
                    id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0 r2 = new id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2$1$$ExternalSyntheticLambda0
                    r2.<init>(r3, r4)
                    io.reactivex.disposables.Disposable r4 = r1.subscribe(r2)
                    r0.addDisposable(r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$billerX2BModule$2.AnonymousClass1.PlaceComponentResult(id.dana.sendmoney.model.BaseRecipientModel):void");
            }

            @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
            public final void PlaceComponentResult(boolean p0) {
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

            public static /* synthetic */ void getAuthRequestContext(AnonymousClass1 anonymousClass1, BaseRecipientModel baseRecipientModel) {
                Intrinsics.checkNotNullParameter(anonymousClass1, "");
                Intrinsics.checkNotNullParameter(baseRecipientModel, "");
                anonymousClass1.getAuthRequestContext(baseRecipientModel);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BillerX2BModule invoke() {
            return new BillerX2BModule(new AnonymousClass1(BankRecipientActivity.this));
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = 56 - r8
            int r9 = r9 + 16
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity.getAuthRequestContext
            int r7 = 106 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L31
        L14:
            r3 = 0
        L15:
            r6 = r8
            r8 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L31:
            int r8 = r8 + 1
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity.a(int, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity.$$a
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = 46 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity.c(short, byte, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createBankRecipientIntent(Context context, String str, boolean z) {
        return Companion.BuiltInFictitiousFunctionClassFactory(context, str, z);
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
        b(KeyEvent.getMaxKeyCode() >> 16, new char[]{18072, 18169, 44893, 53929, 18086, 48630, 6106, 28518, 45215, 56118, 19470, 30914, 43559, 50500, 21980, 29204, 42450, 53216, 25593, 19385, 40779, 63508}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(ViewConfiguration.getKeyRepeatTimeout() >> 16, new char[]{44094, 44115, 29621, 3670, 12771, 51842, 57747, 39220, 23090}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), Color.green(0) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{52840, 52831, 6250, 26003, 52214, 12532, 63819, 33213, 14384, 27660, 49489, 38469, 8847, 29285, 55443, 40115, 11573, 30858, 61097, 42363, 6137, 20321, 58390, 43844, 7684, 21931, 64427, 45483, 2172, 23635, 61800, 50705, 29314, 8828, 34969, 52360, 32017, 10374, 40626, 54652, 26534, 16145, 37904, 56077, 28239, 1446, 43908, 57763, 22642, 3147, 41326, 63080}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(KeyEvent.getMaxKeyCode() >> 16, new char[]{45427, 45330, 61702, 36009, 48488, 18026, 55502, 41060, 18301, 34109, 47046, 47040, 24007, 39695, 44631, 48485, 21039, 37349, 38967, 34044, 26849, 42510, 37592, 35473, 24863, 48277, 36192, 36907, 30517, 46446, 34807, 59285, 3475, 51984, 65108, 60762, 592, 49592, 59434, 62712, 6328, 54823, 57990, 64139, 4438, 60572, 56651, 49185, 10088, 58659, 55287, 55231, 15776, 64335, 52809, 56665, 12802, 61907, 14374, 9449, 51443, 1661, 13037, 10962, 49498, 7308, 11586, 12315}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{9928, 9978, 32057, 146, 49555, 15042, 46493, 52529, 53401, 2316, 52076, 55967, 51744, 5995, 54014, 53298, 50625, 7640, 58526, 59820, 65289, 10854, 60962, 59287, 63218, 12537, 61855, 64888, 57487, 14677, 64351, 35483, 39542, 18221, 33529, 32856, 38335, 19847, 38020, 39339, 36610, 23116, 40488, 38867, 34528, 24821, 41399, 44407, 45192, 26907, 43791, 47801, 43598, 30586, 45749, 45142, 42418, 32234, 17624, 18878, 24399, 35398, 19999, 18389, 22198, 37054, 20923, 23874}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(TextUtils.indexOf("", "", 0), new char[]{2541, 2437, 11883, 21381, 62192, 2480, 19527, 13561, 65526, 23123, 63491, 9054, 58713, 17504, 57818, 10680, 60155, 20173, 55220, 4147, 53288, 31024, 56592, 7754, 55684, 25530, 49912, 1215, 53242, 27156, 51317, 29451, 46417, 5226, 45517, 31124, 47820, 7875, 42913, 24679, 40998, 2374, 44289, 28190, 43420, 13233, 37533, 21686, 40956, 14871, 39035, 17252, 34174, 9317, 33163, 18847, 35479, 11942, 30633, 45095, 28728, 55631, 32032, 48714}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(ViewConfiguration.getMaximumDrawingCacheSize() >> 24, new char[]{42376, 42417, 34724, 64016, 288, 64032, 13222, 19270, 21458, 62359}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = new Object[1];
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[9], (byte) (PlaceComponentResult | 16), getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.indexOf("", "", 0), 2 - TextUtils.lastIndexOf("", '0', 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], $$a[53], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 800, Color.green(0) + 15, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 800, TextUtils.indexOf("", "", 0) + 15, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 814, (ViewConfiguration.getTouchSlop() >> 8) + 29, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 800, 16 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "")));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1681694015, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = new Object[1];
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(getAuthRequestContext[9], (byte) (PlaceComponentResult | 16), getAuthRequestContext[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 62, TextUtils.getOffsetBefore("", 0) + 46, (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[8], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, Drawable.resolveOpacity(0, 0) + 35, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1681694015, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, TextUtils.getOffsetBefore("", 0) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr25 = new Object[1];
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(getAuthRequestContext[9], (byte) (PlaceComponentResult | 16), getAuthRequestContext[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 3 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[8], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1681694015, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr31 = new Object[1];
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(getAuthRequestContext[9], (byte) (PlaceComponentResult | 16), getAuthRequestContext[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 106, ImageFormat.getBitsPerPixel(0) + 4, (char) ((-1) - ImageFormat.getBitsPerPixel(0)));
                        byte b = $$a[9];
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b, b2, b2, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), View.getDefaultSize(0, 0) + 35, (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1681694015, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, KeyEvent.getDeadChar(0, 0) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public final void onFinishCheckReferralSendMoney(boolean enable, String howToUrl) {
        Intrinsics.checkNotNullParameter(howToUrl, "");
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(ViewConfiguration.getPressedStateDuration() >> 16, new char[]{17563, 17658, 17796, 14448, 26062, 40606, 4284, 26624, 45724, 12783, 28518, 32676, 43050, 12190, 30442, 29964, 42978, 9525, 16518, 19667, 40269, 4823, 19006, 17067, 38087, 2126, 21968, 22543, 33418, 490}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(super.getResources().getString(R.string.split_bill_section_title).substring(1, 2).length() - 1, new char[]{46611, 46704, 17140, 16155, 53842, 10516, 56124, 41856, 16414, 13976, 55548, 46155, 23219, 10478, 49532, 48843, 21832, 8775, 63244, 34643, 28636, 5536}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public final void onSuccessRemoveOldFavoriteState(boolean success) {
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public final void onSuccessUpdateFavoriteState(boolean success, RecentRecipientModel recentRecipientModel) {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
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

    @JvmName(name = "getRecipientSelectedMoreAction")
    public final RecipientModel getRecipientSelectedMoreAction() {
        return this.recipientSelectedMoreAction;
    }

    @JvmName(name = "setRecipientSelectedMoreAction")
    public final void setRecipientSelectedMoreAction(RecipientModel recipientModel) {
        this.recipientSelectedMoreAction = recipientModel;
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

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(getPackageName().codePointAt(2) - 46, new char[]{17563, 17658, 17796, 14448, 26062, 40606, 4284, 26624, 45724, 12783, 28518, 32676, 43050, 12190, 30442, 29964, 42978, 9525, 16518, 19667, 40269, 4823, 19006, 17067, 38087, 2126, 21968, 22543, 33418, 490}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b((-1) - ImageFormat.getBitsPerPixel(0), new char[]{46611, 46704, 17140, 16155, 53842, 10516, 56124, 41856, 16414, 13976, 55548, 46155, 23219, 10478, 49532, 48843, 21832, 8775, 63244, 34643, 28636, 5536}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, ExpandableListView.getPackedPositionChild(0L) + 19, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.scheduleImpl.getValue();
        sendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("OPEN BANK LIST PAGE", "");
        if (sendMoneyFeatureTime.getAuthRequestContext.get("OPEN BANK LIST PAGE") == null) {
            getSendMoneyAnalyticTracker().BuiltInFictitiousFunctionClassFactory();
        }
        sendMoneyFeatureTime.getAuthRequestContext();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.BaseActivity
    public final void configToolbar() {
        super.configToolbar();
        setCenterTitle(getString(R.string.sendmoney_summary_x2b_toolbar_title));
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        super.init();
        setData(getIntent().getExtras());
        getRecipientPresenter().getAuthRequestContext();
        getBinding().BuiltInFictitiousFunctionClassFactory.initRecipientView();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$setOnBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = BankRecipientActivity.access$getSendMoneyFeatureTime(BankRecipientActivity.this);
                Intrinsics.checkNotNullParameter("OPEN BANK LIST PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN BANK LIST PAGE");
                Bundle extras = BankRecipientActivity.this.getIntent().getExtras();
                if (extras != null && extras.getBoolean("is_from_payroll")) {
                    BankRecipientActivity.this.backToHomepage(null);
                } else {
                    BankRecipientActivity.this.finish();
                }
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    protected final void initRecipientView() {
        RecipientView recipientView = getBinding().BuiltInFictitiousFunctionClassFactory;
        recipientView.setRecipientContactType(1);
        recipientView.setRecipientSelectedListener(this);
        String string = getString(R.string.txtSearchListBank);
        Intrinsics.checkNotNullExpressionValue(string, "");
        recipientView.setSearchViewContentDescription(string);
        getRecipientPresenter().MyBillsEntityDataFactory();
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    protected final void initInjector() {
        DaggerBankActivityComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerBankActivityComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (RecipientActivityModule) Preconditions.getAuthRequestContext(new RecipientActivityModule(this));
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (BillerX2BModule) Preconditions.getAuthRequestContext((BillerX2BModule) this.getAuthRequestContext.getValue());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, RecipientActivityModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, BillerX2BModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerBankActivityComponent.BankActivityComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getRecipientPresenter(), getBillerX2BPresenter());
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r1, int resultCode, Intent data) {
        super.onActivityResult(r1, resultCode, data);
        if (resultCode == -1) {
            if (r1 == 69) {
                getBinding().BuiltInFictitiousFunctionClassFactory.getSortingSendMoneyPresenter().getAuthRequestContext();
                getBinding().BuiltInFictitiousFunctionClassFactory.getSavedBankPresenter().PlaceComponentResult();
            }
        } else if (resultCode == 0 && this.KClassImpl$Data$declaredNonStaticMembers$2) {
            finish();
        }
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityRecipientV2Binding initViewBinding() {
        ActivityRecipientV2Binding MyBillsEntityDataFactory = ActivityRecipientV2Binding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    protected final void handleTransferData(QrTransferModel qrTransferModel) {
        String str;
        Intrinsics.checkNotNullParameter(qrTransferModel, "");
        this.BuiltInFictitiousFunctionClassFactory = qrTransferModel;
        if (!qrTransferModel.initRecordTimeStamp()) {
            RecipientView recipientView = getBinding().BuiltInFictitiousFunctionClassFactory;
            String stringExtra = getIntent().getStringExtra("recipientType");
            Intrinsics.checkNotNull(stringExtra);
            recipientView.redirectDeeplink(stringExtra);
            return;
        }
        QrRequestBankTransferModel qrRequestBankTransferModel = qrTransferModel instanceof QrRequestBankTransferModel ? (QrRequestBankTransferModel) qrTransferModel : null;
        if (qrRequestBankTransferModel != null) {
            RecipientModel.Builder builder = new RecipientModel.Builder("bank");
            builder.PrepareContext = RecipientIdType.INSTITUTION;
            builder.initRecordTimeStamp = qrRequestBankTransferModel.BuiltInFictitiousFunctionClassFactory;
            builder.GetContactSyncConfig = qrRequestBankTransferModel.getAuthRequestContext;
            builder.scheduleImpl = qrRequestBankTransferModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
            builder.getAuthRequestContext = qrRequestBankTransferModel.MyBillsEntityDataFactory;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = qrRequestBankTransferModel.GetContactSyncConfig;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = qrRequestBankTransferModel.initRecordTimeStamp;
            builder.DatabaseTableConfigUtil = qrRequestBankTransferModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            builder.lookAheadTest = qrRequestBankTransferModel.DatabaseTableConfigUtil;
            String str2 = qrRequestBankTransferModel.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str2 == null) {
                str2 = "";
            }
            builder.getErrorConfigVersion = str2;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = qrRequestBankTransferModel.PlaceComponentResult;
            builder.BuiltInFictitiousFunctionClassFactory = qrRequestBankTransferModel.getErrorConfigVersion();
            QrRequestBankTransferModel qrRequestBankTransferModel2 = qrRequestBankTransferModel;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = getTransferScenario(qrRequestBankTransferModel2);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = getTransactionType();
            String builtInFictitiousFunctionClassFactory = qrRequestBankTransferModel2.getBuiltInFictitiousFunctionClassFactory();
            if (Intrinsics.areEqual(builtInFictitiousFunctionClassFactory, DecodeQrBizType.USER_BANK_ACCOUNT_CODE)) {
                str = RecipientSource.REQ_MONEY_BANK_WITHOUT_AMOUNT;
            } else {
                str = Intrinsics.areEqual(builtInFictitiousFunctionClassFactory, DecodeQrBizType.TRANSFER_BANK_ACCOUNT_CODE) ? RecipientSource.REQ_MONEY_BANK_WITH_AMOUNT : "";
            }
            builder.newProxyInstance = str;
            RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
            String myBillsEntityDataFactory = qrTransferModel.getMyBillsEntityDataFactory();
            openSummary(KClassImpl$Data$declaredNonStaticMembers$2, myBillsEntityDataFactory != null ? myBillsEntityDataFactory : "");
        }
        getBinding().BuiltInFictitiousFunctionClassFactory.setFirstTime(false);
    }

    public final void showManageAccountBottomSheet(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        this.recipientSelectedMoreAction = recipientModel;
        ManageAccountBottomSheet manageAccountBottomSheet = (ManageAccountBottomSheet) this.MyBillsEntityDataFactory.getValue();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        AndroidComponentUtilsKt.MyBillsEntityDataFactory(manageAccountBottomSheet, supportFragmentManager, "MANAGE_SAVED_BANK");
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public final void onGetFeatureBelowKitkatConfigSuccess(boolean enable) {
        setBelowKitkatDialog(enable);
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.View
    public final void onGetSmartFrictionConfig(SmartFrictionConfig smartFrictionConfig) {
        Intrinsics.checkNotNullParameter(smartFrictionConfig, "");
        this.getErrorConfigVersion = smartFrictionConfig;
        getBinding().BuiltInFictitiousFunctionClassFactory.setNotBankListRecent(smartFrictionConfig.getNotBankListRecent());
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

    public static /* synthetic */ void startAddBankAccountActivity$default(BankRecipientActivity bankRecipientActivity, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        bankRecipientActivity.startAddBankAccountActivity(str, str2, z);
    }

    public final void startAddBankAccountActivity(String bankId, String bankNumber, boolean finishOnAddBankCanceled) {
        Intrinsics.checkNotNullParameter(bankId, "");
        Intrinsics.checkNotNullParameter(bankNumber, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = finishOnAddBankCanceled;
        Bundle bundle = new Bundle();
        bundle.putBoolean(BankSelectorActivity.EXTRA_BELOW_KITKAT, getBelowKitkatDialog());
        bundle.putString(BankSelectorActivity.EXTRA_TRANSFER_SCENARIO, getIntent().getStringExtra("transferScenario"));
        bundle.putString(BankSelectorActivity.EXTRA_OPENED_FROM, RecipientSource.BANK_LIST_PAGE_ADD_NEW_BANK);
        BankSelectorActivity.Companion companion = BankSelectorActivity.INSTANCE;
        BankRecipientActivity bankRecipientActivity = this;
        ArrayList<String> recentBank = getBinding().BuiltInFictitiousFunctionClassFactory.getRecentBank();
        SmartFrictionConfig smartFrictionConfig = this.getErrorConfigVersion;
        if (smartFrictionConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            smartFrictionConfig = null;
        }
        startActivity(BankSelectorActivity.Companion.PlaceComponentResult(bankRecipientActivity, bankId, bankNumber, false, false, true, bundle, recentBank, smartFrictionConfig.getNotBankListRecent(), "Send Money", 24));
    }

    public final void showSnackbarRemoved() {
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        StringBuilder sb = new StringBuilder();
        RecipientModel recipientModel = this.recipientSelectedMoreAction;
        String str = recipientModel != null ? recipientModel.getAuthRequestContext : null;
        if (str == null) {
            RecipientModel recipientModel2 = this.recipientSelectedMoreAction;
            str = String.valueOf(recipientModel2 != null ? recipientModel2.PlaceComponentResult() : null);
        }
        sb.append(str);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(getString(R.string.send_money_wording_snackbar_remove_saved_bank));
        builder.initRecordTimeStamp = sb.toString();
        builder.lookAheadTest = getString(R.string.send_money_undo);
        builder.moveToNextValue = 0;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_green_50;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankRecipientActivity.m2934$r8$lambda$Qg9oyt_JY9ti6ZofOC6XyBMto8(BankRecipientActivity.this, view);
            }
        };
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/BankRecipientActivity$Companion;", "", "()V", "OPEN_BANK_RECIPIENT", "", "createBankRecipientIntent", "Landroid/content/Intent;", HummerConstants.CONTEXT, "Landroid/content/Context;", "source", "isBankRecipient", "", "createTransferIntent", "qrTransferModel", "Lid/dana/sendmoney/model/QrTransferModel;", "transactionType", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent BuiltInFictitiousFunctionClassFactory(Context context, String str, boolean z) {
            Intent intent = new Intent(context, BankRecipientActivity.class);
            intent.putExtra("source", str);
            Bundle bundle = new Bundle();
            bundle.putBoolean("open_bank_recipient", z);
            intent.putExtra("data", bundle);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$0sUzTXtWvBNdCHvOH6M7ERNpx2U(BankRecipientActivity bankRecipientActivity, BillerX2BModel billerX2BModel, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(bankRecipientActivity, "");
        Intrinsics.checkNotNullParameter(billerX2BModel, "");
        if (-1 == i) {
            bankRecipientActivity.getBillerX2BPresenter().KClassImpl$Data$declaredNonStaticMembers$2(billerX2BModel);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: $r8$lambda$Qg9oyt_JY9ti6ZofOC6XyBMto-8 */
    public static /* synthetic */ void m2934$r8$lambda$Qg9oyt_JY9ti6ZofOC6XyBMto8(BankRecipientActivity bankRecipientActivity, View view) {
        Intrinsics.checkNotNullParameter(bankRecipientActivity, "");
        ManageAccountContract.Presenter presenter = ((ManageAccountBottomSheet) bankRecipientActivity.MyBillsEntityDataFactory.getValue()).presenter;
        RecipientModel recipientModel = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        RecipientModel recipientModel2 = ((ManageAccountBottomSheet) bankRecipientActivity.MyBillsEntityDataFactory.getValue()).getErrorConfigVersion;
        if (recipientModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel2 = null;
        }
        RecipientModel recipientModel3 = ((ManageAccountBottomSheet) bankRecipientActivity.MyBillsEntityDataFactory.getValue()).getErrorConfigVersion;
        if (recipientModel3 != null) {
            recipientModel = recipientModel3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.BuiltInFictitiousFunctionClassFactory(recipientModel2, recipientModel.getAuthRequestContext, true);
        CustomSnackbar customSnackbar = bankRecipientActivity.PlaceComponentResult;
        if (customSnackbar != null) {
            customSnackbar.dismiss();
        }
    }

    public static /* synthetic */ void $r8$lambda$u_y7ll89MKfVNhgqf7aF2Km47dE(BankRecipientActivity bankRecipientActivity, View view) {
        Intrinsics.checkNotNullParameter(bankRecipientActivity, "");
        CustomSnackbar customSnackbar = bankRecipientActivity.PlaceComponentResult;
        if (customSnackbar != null) {
            customSnackbar.dismiss();
        }
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(BankRecipientActivity bankRecipientActivity) {
        return (SendMoneyFeatureTime) bankRecipientActivity.scheduleImpl.getValue();
    }

    public static final /* synthetic */ void access$showSnackbarRemoveFailed(final BankRecipientActivity bankRecipientActivity, String str) {
        View findViewById = bankRecipientActivity.getWindow().getDecorView().findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = str;
        builder.lookAheadTest = bankRecipientActivity.getString(R.string.close);
        builder.moveToNextValue = 0;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_red_50;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankRecipientActivity.$r8$lambda$u_y7ll89MKfVNhgqf7aF2Km47dE(BankRecipientActivity.this, view);
            }
        };
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        bankRecipientActivity.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    @JvmStatic
    public static final Intent createBankRecipientIntent(Context context, String str) {
        return Companion.BuiltInFictitiousFunctionClassFactory(context, str, false);
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            a((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[30], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[8], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{18072, 18169, 44893, 53929, 18086, 48630, 6106, 28518, 45215, 56118, 19470, 30914, 43559, 50500, 21980, 29204, 42450, 53216, 25593, 19385, 40779, 63508}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(getPackageName().codePointAt(4) - 97, new char[]{44094, 44115, 29621, 3670, 12771, 51842, 57747, 39220, 23090}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b(getPackageName().codePointAt(1) - 100, new char[]{17563, 17658, 17796, 14448, 26062, 40606, 4284, 26624, 45724, 12783, 28518, 32676, 43050, 12190, 30442, 29964, 42978, 9525, 16518, 19667, 40269, 4823, 19006, 17067, 38087, 2126, 21968, 22543, 33418, 490}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(super.getResources().getString(R.string.voucher_list_header).substring(3, 4).length() - 1, new char[]{46611, 46704, 17140, 16155, 53842, 10516, 56124, 41856, 16414, 13976, 55548, 46155, 23219, 10478, 49532, 48843, 21832, 8775, 63244, 34643, 28636, 5536}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        b((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{52840, 52831, 6250, 26003, 52214, 12532, 63819, 33213, 14384, 27660, 49489, 38469, 8847, 29285, 55443, 40115, 11573, 30858, 61097, 42363, 6137, 20321, 58390, 43844, 7684, 21931, 64427, 45483, 2172, 23635, 61800, 50705, 29314, 8828, 34969, 52360, 32017, 10374, 40626, 54652, 26534, 16145, 37904, 56077, 28239, 1446, 43908, 57763, 22642, 3147, 41326, 63080}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b(getPackageName().codePointAt(4) - 97, new char[]{45427, 45330, 61702, 36009, 48488, 18026, 55502, 41060, 18301, 34109, 47046, 47040, 24007, 39695, 44631, 48485, 21039, 37349, 38967, 34044, 26849, 42510, 37592, 35473, 24863, 48277, 36192, 36907, 30517, 46446, 34807, 59285, 3475, 51984, 65108, 60762, 592, 49592, 59434, 62712, 6328, 54823, 57990, 64139, 4438, 60572, 56651, 49185, 10088, 58659, 55287, 55231, 15776, 64335, 52809, 56665, 12802, 61907, 14374, 9449, 51443, 1661, 13037, 10962, 49498, 7308, 11586, 12315}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{9928, 9978, 32057, 146, 49555, 15042, 46493, 52529, 53401, 2316, 52076, 55967, 51744, 5995, 54014, 53298, 50625, 7640, 58526, 59820, 65289, 10854, 60962, 59287, 63218, 12537, 61855, 64888, 57487, 14677, 64351, 35483, 39542, 18221, 33529, 32856, 38335, 19847, 38020, 39339, 36610, 23116, 40488, 38867, 34528, 24821, 41399, 44407, 45192, 26907, 43791, 47801, 43598, 30586, 45749, 45142, 42418, 32234, 17624, 18878, 24399, 35398, 19999, 18389, 22198, 37054, 20923, 23874}, objArr9);
                        String str3 = (String) objArr9[0];
                        try {
                            Object[] objArr10 = new Object[1];
                            a((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[30], objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            a(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[8], new Object[1]);
                            Object[] objArr11 = new Object[1];
                            b(((ApplicationInfo) cls4.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{2541, 2437, 11883, 21381, 62192, 2480, 19527, 13561, 65526, 23123, 63491, 9054, 58713, 17504, 57818, 10680, 60155, 20173, 55220, 4147, 53288, 31024, 56592, 7754, 55684, 25530, 49912, 1215, 53242, 27156, 51317, 29451, 46417, 5226, 45517, 31124, 47820, 7875, 42913, 24679, 40998, 2374, 44289, 28190, 43420, 13233, 37533, 21686, 40956, 14871, 39035, 17252, 34174, 9317, 33163, 18847, 35479, 11942, 30633, 45095, 28728, 55631, 32032, 48714}, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            b(super.getResources().getString(R.string.investment_me_desc_non_registered).substring(0, 5).codePointAt(3) + SecLiteException.ERROR_API_KEY_OR_SIGN, new char[]{42376, 42417, 34724, 64016, 288, 64032, 13222, 19270, 21458, 62359}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                }
            }
            try {
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr14);
                Class<?> cls5 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a(getAuthRequestContext[9], (byte) (PlaceComponentResult | 16), getAuthRequestContext[25], objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 3 - ImageFormat.getBitsPerPixel(0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        byte b = $$a[9];
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr17 = new Object[1];
                        c(b, b2, b2, objArr17);
                        obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                    int i = ((int[]) objArr18[1])[0];
                    if (((int[]) objArr18[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), View.resolveSizeAndState(0, 0, 0) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr19 = {1728207982, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr19);
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
                    ((SendMoneyFeatureTime) this.scheduleImpl.getValue()).getAuthRequestContext();
                    ((SendMoneyFeatureTime) this.scheduleImpl.getValue()).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    super.onCreate(savedInstanceState);
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
    }

    @Override // id.dana.sendmoney.view.BaseRecipientListener
    public final void onRecipientSelected(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        recipientModel.SubSequence = RecipientSource.BANK_PAGE;
        getBillerX2BPresenter().PlaceComponentResult(recipientModel);
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(isLayoutRequested ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (isLayoutRequested ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
