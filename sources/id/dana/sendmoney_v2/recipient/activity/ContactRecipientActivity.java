package id.dana.sendmoney_v2.recipient.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.danah5.DanaH5;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ActivityRecipientV2Binding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.di.modules.ReferralTrackerModule;
import id.dana.di.modules.SendMoneyModule;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.ReferralWidgetModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.model.ReferralBannerContent;
import id.dana.referral.referraltracker.model.ReferralTrackerModel;
import id.dana.referral.view.ReferralPopupDialog;
import id.dana.sendmoney.di.module.SendMoneyCoreModule;
import id.dana.sendmoney.external.SmartFrictionBottomSheetFragment;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.model.TransferUserInfoModel;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$referralPopupDialogListener$2;
import id.dana.sendmoney_v2.recipient.di.component.DaggerContactRecipientActivityComponent;
import id.dana.sendmoney_v2.recipient.view.RecipientView;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0007¢\u0006\u0004\b]\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0011\u0010\u0018\u001a\u00020\u0012*\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u0010*R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b1\u00102R\u0013\u00107\u001a\u000204X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b5\u00106R\"\u00109\u001a\u0002088\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010K\u001a\u00020J8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0013\u0010S\u001a\u00020QX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bR\u00106R\u0016\u0010U\u001a\u00020%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bT\u0010'R\u0016\u0010&\u001a\u00020V8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bZ\u0010["}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/ContactRecipientActivity;", "Lid/dana/sendmoney_v2/recipient/activity/BaseRecipientActivity;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initInjector", "initRecipientView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/sendmoney/model/RecipientModel;", "recipientModel", "onRecipientSelected", "(Lid/dana/sendmoney/model/RecipientModel;)V", "onResume", "", "p0", "MyBillsEntityDataFactory", "(Z)V", "processRecipientListData", "saveLastReferralCampaignAndDismissDialog", "isNewNumber", "(Lid/dana/sendmoney/model/RecipientModel;)Z", "Lid/dana/domain/sendmoney/model/TransferInit;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/sendmoney/model/TransferInit;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "calculatorPresenter", "Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "getCalculatorPresenter", "()Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "setCalculatorPresenter", "(Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;)V", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/String;", "getAuthRequestContext", "DatabaseTableConfigUtil", "Z", "PlaceComponentResult", "initRecordTimeStamp", "Lid/dana/sendmoney/model/RecipientModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "newProxyInstance", "Lid/dana/referral/view/ReferralPopupDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/referral/view/ReferralPopupDialog;", "lookAheadTest", "Lid/dana/sendmoney_v2/recipient/activity/ContactRecipientActivity$referralPopupDialogListener$2$1;", "PrepareContext", "Lkotlin/Lazy;", "moveToNextValue", "Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;", "referralTrackerPresenter", "Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;", "getReferralTrackerPresenter", "()Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;", "setReferralTrackerPresenter", "(Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "scheduleImpl", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "sendMoneyCorePresenter", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "getSendMoneyCorePresenter", "()Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "setSendMoneyCorePresenter", "(Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda5", "getErrorConfigVersion", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "GetContactSyncConfig", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactRecipientActivity extends BaseRecipientActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private TransferInit BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private TransferInitResultModel GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private SmartFrictionConfig NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private ReferralPopupDialog lookAheadTest;
    @Inject
    public SendMoneyContract.Presenter calculatorPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private RecipientModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    @Inject
    public ReferralTrackerContract.Presenter referralTrackerPresenter;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    @Inject
    public SendMoneyCoreContract.Presenter sendMoneyCorePresenter;
    public static final byte[] $$a = {75, 108, -123, 87, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 109;
    public static final byte[] getAuthRequestContext = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 195;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String getErrorConfigVersion = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private SendMoneyApiMigrationConfigModel scheduleImpl = new SendMoneyApiMigrationConfigModel(false);

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy moveToNextValue = LazyKt.lazy(new Function0<ContactRecipientActivity$referralPopupDialogListener$2.AnonymousClass1>() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$referralPopupDialogListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$referralPopupDialogListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final ContactRecipientActivity contactRecipientActivity = ContactRecipientActivity.this;
            return new ReferralPopupDialog.ReferralPopupActionListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$referralPopupDialogListener$2.1
                @Override // id.dana.referral.view.ReferralPopupDialog.ReferralPopupActionListener
                public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                    ContactRecipientActivity.this.MyBillsEntityDataFactory = p0;
                }

                @Override // id.dana.referral.view.ReferralPopupDialog.ReferralPopupActionListener
                public final void getAuthRequestContext() {
                    ContactRecipientActivity.this.disableClick();
                    ContactRecipientActivity.this.saveLastReferralCampaignAndDismissDialog();
                    ContactRecipientActivity.access$openHowToUrl(ContactRecipientActivity.this);
                }

                @Override // id.dana.referral.view.ReferralPopupDialog.ReferralPopupActionListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    ContactRecipientActivity.this.saveLastReferralCampaignAndDismissDialog();
                }
            };
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        FragmentBottomSheetPaymentSettingBinding = 269894704;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 16
            int r8 = r8 + 97
            int r7 = 56 - r7
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity.getAuthRequestContext
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2f
        L13:
            r3 = 0
        L14:
            r6 = r9
            r9 = r8
            r8 = r6
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            int r7 = r7 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity.a(byte, short, int, java.lang.Object[]):void");
    }

    private static void c(int i, int i2, byte b, Object[] objArr) {
        byte[] bArr = $$a;
        int i3 = (i * 2) + 75;
        int i4 = (b * 3) + 21;
        int i5 = 47 - i2;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            int i8 = i5 + 1;
            int i9 = (i5 + i7) - 7;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i5 = i8;
            i3 = i9;
        }
        while (true) {
            int i10 = i6 + 1;
            bArr2[i10] = (byte) i3;
            if (i10 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i10;
            i5++;
            i3 = (i3 + bArr[i5]) - 7;
        }
    }

    @JvmStatic
    public static final Intent createTransferIntent(Context context, QrTransferModel qrTransferModel, String str) {
        return Companion.getAuthRequestContext(context, qrTransferModel, str);
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

    /* JADX WARN: Removed duplicated region for block: B:112:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0905  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0ad7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0270 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0264  */
    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r29) {
        /*
            Method dump skipped, instructions count: 3070
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity.attachBaseContext(android.content.Context):void");
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
            int length = super.getResources().getString(R.string.hide_dana_balance).substring(13, 14).length() + 119;
            try {
                Object[] objArr = new Object[1];
                a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(false, length, ((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 30, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 26, new char[]{2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(false, 127 - Drawable.resolveOpacity(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 3, 18 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n'}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        super.onPause();
    }

    @JvmName(name = "getReferralTrackerPresenter")
    public final ReferralTrackerContract.Presenter getReferralTrackerPresenter() {
        ReferralTrackerContract.Presenter presenter = this.referralTrackerPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReferralTrackerPresenter")
    public final void setReferralTrackerPresenter(ReferralTrackerContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.referralTrackerPresenter = presenter;
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
        setCenterTitle(getString(R.string.sendmoney_summary_x2p_toolbar_title));
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        super.init();
        setData(getIntent().getExtras());
        getSendMoneyCorePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getRecipientPresenter().getAuthRequestContext();
        getRecipientPresenter().PlaceComponentResult();
        getRecipientPresenter().MyBillsEntityDataFactory();
        getBinding().BuiltInFictitiousFunctionClassFactory.initRecipientView();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$setOnBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = ContactRecipientActivity.access$getSendMoneyFeatureTime(ContactRecipientActivity.this);
                Intrinsics.checkNotNullParameter("OPEN CONTACT LIST PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN CONTACT LIST PAGE");
                SendMoneyFeatureTime access$getSendMoneyFeatureTime2 = ContactRecipientActivity.access$getSendMoneyFeatureTime(ContactRecipientActivity.this);
                Intrinsics.checkNotNullParameter("INIT ON CONTACT PAGE SELECTION", "");
                access$getSendMoneyFeatureTime2.getAuthRequestContext.remove("INIT ON CONTACT PAGE SELECTION");
                ContactRecipientActivity.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(false, getPackageName().codePointAt(5) + 10, super.getResources().getString(R.string.payment_failed_message).substring(42, 43).codePointAt(0) - 107, getPackageName().length() + 19, new char[]{2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(false, getPackageName().codePointAt(3) + 27, super.getResources().getString(R.string.citcall_otp_reach_limit_message).substring(8, 10).length() + 1, super.getResources().getString(R.string.text_sort_alphabet).substring(0, 14).length() + 4, new char[]{65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n'}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
        sendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("OPEN CONTACT LIST PAGE", "");
        if (sendMoneyFeatureTime.getAuthRequestContext.get("OPEN CONTACT LIST PAGE") == null) {
            long MyBillsEntityDataFactory = sendMoneyFeatureTime.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("OPEN CONTACT LIST PAGE", "");
            sendMoneyFeatureTime.getAuthRequestContext.put("OPEN CONTACT LIST PAGE", Long.valueOf(MyBillsEntityDataFactory));
        }
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    protected final void initInjector() {
        DaggerContactRecipientActivityComponent.Builder PlaceComponentResult2 = DaggerContactRecipientActivityComponent.PlaceComponentResult();
        PlaceComponentResult2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (RecipientActivityModule) Preconditions.getAuthRequestContext(new RecipientActivityModule(new RecipientContract.View() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$getRecipientActivityModule$1
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
                ContactRecipientActivity.this.setBelowKitkatDialog(p0);
            }

            @Override // id.dana.contract.sendmoney.RecipientContract.View
            public final void onFinishCheckReferralSendMoney(boolean p0, String p1) {
                ActivityRecipientV2Binding binding;
                if (p0) {
                    ContactRecipientActivity contactRecipientActivity = ContactRecipientActivity.this;
                    if (p1 == null) {
                        p1 = "";
                    }
                    contactRecipientActivity.getErrorConfigVersion = p1;
                    ContactRecipientActivity.this.getReferralTrackerPresenter().getAuthRequestContext();
                    binding = ContactRecipientActivity.this.getBinding();
                    binding.BuiltInFictitiousFunctionClassFactory.setEnableInvite(true);
                }
            }

            @Override // id.dana.contract.sendmoney.RecipientContract.View
            public final void onGetSmartFrictionConfig(SmartFrictionConfig p0) {
                ActivityRecipientV2Binding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                ContactRecipientActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0;
                binding = ContactRecipientActivity.this.getBinding();
                binding.BuiltInFictitiousFunctionClassFactory.setNotContactListRecent(p0.getNotContactListRecent());
            }
        }));
        PlaceComponentResult2.getAuthRequestContext = (ReferralTrackerModule) Preconditions.getAuthRequestContext(new ReferralTrackerModule(new ReferralTrackerContract.View() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$getReferralTrackerModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onCheckRegisteredUser(boolean p0, String p1) {
                Intrinsics.checkNotNullParameter(p1, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetDeeplinkReferralSuccess(DeepLink p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetMessageTemplateError() {
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetMessageTemplateSuccess(ReferralMessageTemplateConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetReferralBannerError() {
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetReferralBannerSuccess(List<ReferralBannerContent> p0) {
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetReferralConsultSuccess(MyReferralConsult p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetReferralTrackerError() {
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onGetReferralTrackerSuccess(ReferralTrackerModel p0) {
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void setReferralWidgetFeatureValue(List<? extends ReferralWidgetModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
            public final void onFinishCheckLatestReferralCampaign(MyReferralConsult p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ContactRecipientActivity contactRecipientActivity = ContactRecipientActivity.this;
                String str = p0.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(str, "");
                contactRecipientActivity.getAuthRequestContext = str;
                ContactRecipientActivity contactRecipientActivity2 = ContactRecipientActivity.this;
                CurrencyAmountModel currencyAmountModel = p0.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(currencyAmountModel, "");
                ContactRecipientActivity.access$showReferralPopup(contactRecipientActivity2, currencyAmountModel);
            }
        }));
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (SendMoneyModule) Preconditions.getAuthRequestContext(new SendMoneyModule(new ContactRecipientActivity$getSendMoneyModule$1(this)));
        PlaceComponentResult2.PlaceComponentResult = (SendMoneyCoreModule) Preconditions.getAuthRequestContext(new SendMoneyCoreModule(new ContactRecipientActivity$getSendMoneyCoreModule$1(this)));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, RecipientActivityModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, ReferralTrackerModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, SendMoneyModule.class);
        if (PlaceComponentResult2.moveToNextValue == null) {
            PlaceComponentResult2.moveToNextValue = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, SendMoneyCoreModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerContactRecipientActivityComponent.ContactRecipientActivityComponentImpl(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2.moveToNextValue, PlaceComponentResult2.PlaceComponentResult, PlaceComponentResult2.MyBillsEntityDataFactory, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getRecipientPresenter(), getReferralTrackerPresenter(), getCalculatorPresenter());
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    protected final void initRecipientView() {
        final RecipientView recipientView = getBinding().BuiltInFictitiousFunctionClassFactory;
        recipientView.setRecipientContactType(2);
        recipientView.setEnableViewSection(true);
        recipientView.setRecipientSelectedListener(this);
        recipientView.setOnContactSyncEnabled(new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$initRecipientView$1$1
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
        String string = getString(R.string.txt_search_phone_number);
        Intrinsics.checkNotNullExpressionValue(string, "");
        recipientView.setSearchViewContentDescription(string);
    }

    public final void saveLastReferralCampaignAndDismissDialog() {
        if (this.MyBillsEntityDataFactory) {
            getReferralTrackerPresenter().BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
        }
        ReferralPopupDialog referralPopupDialog = this.lookAheadTest;
        if (referralPopupDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralPopupDialog = null;
        }
        referralPopupDialog.getAuthRequestContext();
    }

    @Override // id.dana.sendmoney.view.BaseRecipientListener
    public final void onRecipientSelected(RecipientModel recipientModel) {
        if (!isClickable()) {
            recipientModel = null;
        }
        if (recipientModel != null) {
            processRecipientListData(recipientModel);
            recipientModel.readMicros = "contact";
            this.KClassImpl$Data$declaredNonStaticMembers$2 = recipientModel;
            if (recipientModel.moveToNextValue()) {
                trackSendMoneyContactListPageOpen$default(this, null, 1, null);
                MyBillsEntityDataFactory(isNewNumber(recipientModel));
                return;
            }
            this.PlaceComponentResult = false;
            ((SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            if (this.scheduleImpl.getGetAuthRequestContext()) {
                SendMoneyCoreContract.Presenter sendMoneyCorePresenter = getSendMoneyCorePresenter();
                String KClassImpl$Data$declaredNonStaticMembers$2 = recipientModel.KClassImpl$Data$declaredNonStaticMembers$2();
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                String string = getString(R.string.unregistered_number_title);
                Intrinsics.checkNotNullExpressionValue(string, "");
                sendMoneyCorePresenter.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "", TrackerKey.SourceType.SEND_TO_FRIEND_CONTACT_SELECT, string);
                return;
            }
            getCalculatorPresenter().PlaceComponentResult("BALANCE", recipientModel, "3.0", getString(R.string.unregistered_number_title));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(boolean p0) {
        RecipientModel recipientModel;
        TransferInitResultModel transferInitResultModel;
        RecipientModel recipientModel2;
        TransferInit transferInit;
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            ContactRecipientActivity contactRecipientActivity = this;
            RecipientModel recipientModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientModel2 = null;
            } else {
                recipientModel2 = recipientModel3;
            }
            TransferInit transferInit2 = this.BuiltInFictitiousFunctionClassFactory;
            if (transferInit2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                transferInit = null;
            } else {
                transferInit = transferInit2;
            }
            BaseRecipientActivity.openSummary$default(contactRecipientActivity, recipientModel2, transferInit, null, p0, 4, null);
        } else if (this.GetContactSyncConfig != null) {
            ContactRecipientActivity contactRecipientActivity2 = this;
            RecipientModel recipientModel4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientModel = null;
            } else {
                recipientModel = recipientModel4;
            }
            TransferInitResultModel transferInitResultModel2 = this.GetContactSyncConfig;
            if (transferInitResultModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                transferInitResultModel = null;
            } else {
                transferInitResultModel = transferInitResultModel2;
            }
            BaseRecipientActivity.openSummary$default(contactRecipientActivity2, recipientModel, null, transferInitResultModel, p0, 2, null);
        } else {
            RecipientModel recipientModel5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientModel5 = null;
            }
            openSummary(recipientModel5, null, null, p0);
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getSendMoneyCorePresenter().PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/ContactRecipientActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/sendmoney/model/QrTransferModel;", "p1", "", "p2", "Landroid/content/Intent;", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/sendmoney/model/QrTransferModel;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent getAuthRequestContext(Context p0, QrTransferModel p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, ContactRecipientActivity.class);
            intent.putExtra("scanner_data", p1);
            intent.putExtra("transactionType", p2);
            return intent;
        }
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(ContactRecipientActivity contactRecipientActivity) {
        return (SendMoneyFeatureTime) contactRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ void access$openHowToUrl(ContactRecipientActivity contactRecipientActivity) {
        String authRequestContext = UrlUtil.getAuthRequestContext(contactRecipientActivity.getErrorConfigVersion);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext);
    }

    public static final /* synthetic */ void access$showReferralPopup(ContactRecipientActivity contactRecipientActivity, CurrencyAmountModel currencyAmountModel) {
        ReferralPopupDialog.Builder builder = new ReferralPopupDialog.Builder(contactRecipientActivity);
        builder.scheduleImpl = contactRecipientActivity.getString(R.string.referral_popup_title);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = contactRecipientActivity.getString(R.string.referral_popup_description);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{currencyAmountModel.getAuthRequestContext()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = format;
        builder.PlaceComponentResult = contactRecipientActivity.getString(R.string.referral_checkbox_description);
        builder.MyBillsEntityDataFactory = (ContactRecipientActivity$referralPopupDialogListener$2.AnonymousClass1) contactRecipientActivity.moveToNextValue.getValue();
        ReferralPopupDialog referralPopupDialog = new ReferralPopupDialog(builder.BuiltInFictitiousFunctionClassFactory, builder.getAuthRequestContext, builder, (byte) 0);
        Intrinsics.checkNotNullExpressionValue(referralPopupDialog, "");
        contactRecipientActivity.lookAheadTest = referralPopupDialog;
        referralPopupDialog.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void access$showUnregisteredUserDialog(final ContactRecipientActivity contactRecipientActivity) {
        if (contactRecipientActivity.isActivityAvailable()) {
            SmartFrictionBottomSheetFragment smartFrictionBottomSheetFragment = new SmartFrictionBottomSheetFragment(new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$showUnregisteredUserDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ContactRecipientActivity.this.getSendMoneyAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(false, TrackerKey.SmartFrictionProperties.NON_DANA_USER);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$showUnregisteredUserDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RecipientModel recipientModel;
                    RecipientModel recipientModel2;
                    recipientModel = ContactRecipientActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    RecipientModel recipientModel3 = null;
                    if (recipientModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recipientModel = null;
                    }
                    if (Intrinsics.areEqual(recipientModel.SubSequence, "Manual Input")) {
                        recipientModel2 = ContactRecipientActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (recipientModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            recipientModel3 = recipientModel2;
                        }
                        recipientModel3.SubSequence = RecipientSource.CONTACT_PAGE_MANUAL_INPUT;
                        ContactRecipientActivity.this.MyBillsEntityDataFactory(true);
                    } else {
                        ContactRecipientActivity.this.MyBillsEntityDataFactory(false);
                    }
                    ContactRecipientActivity.this.getSendMoneyAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(true, TrackerKey.SmartFrictionProperties.NON_DANA_USER);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            Intrinsics.checkNotNullParameter("UNREGISTERED_NUMBER", "");
            smartFrictionBottomSheetFragment.PlaceComponentResult = "UNREGISTERED_NUMBER";
            FragmentManager supportFragmentManager = contactRecipientActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            smartFrictionBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager);
            contactRecipientActivity.getSendMoneyAnalyticTracker().PlaceComponentResult(TrackerKey.SmartFrictionProperties.NON_DANA_USER, "DANA Balance");
        }
    }

    public static final /* synthetic */ void access$updateRecipientModel(ContactRecipientActivity contactRecipientActivity, TransferUserInfoModel transferUserInfoModel) {
        RecipientModel recipientModel = null;
        if (transferUserInfoModel.MyBillsEntityDataFactory()) {
            RecipientModel recipientModel2 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientModel2 = null;
            }
            recipientModel2.MyBillsEntityDataFactory = transferUserInfoModel.FragmentBottomSheetPaymentSettingBinding;
            recipientModel2.NetworkUserEntityData$$ExternalSyntheticLambda6 = "userid";
            RecipientModel recipientModel3 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                recipientModel = recipientModel3;
            }
            recipientModel.GetContactSyncConfig = true;
            recipientModel2.PlaceComponentResult = transferUserInfoModel.BuiltInFictitiousFunctionClassFactory;
            String str = recipientModel2.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str, "");
            Intrinsics.checkNotNullParameter(str, "");
            if (!NumberUtils.isValidIndoPhoneNumberPrefix(str)) {
                str = transferUserInfoModel.GetContactSyncConfig;
            }
            recipientModel2.getErrorConfigVersion = str;
            String PlaceComponentResult2 = recipientModel2.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            recipientModel2.scheduleImpl = transferUserInfoModel.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, recipientModel2.NetworkUserEntityData$$ExternalSyntheticLambda2());
            return;
        }
        RecipientModel recipientModel4 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (recipientModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientModel = recipientModel4;
        }
        recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = "phonenumber";
        recipientModel.PlaceComponentResult = transferUserInfoModel.BuiltInFictitiousFunctionClassFactory;
    }

    static /* synthetic */ void trackSendMoneyContactListPageOpen$default(ContactRecipientActivity contactRecipientActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        contactRecipientActivity.getSendMoneyAnalyticTracker().PlaceComponentResult(str);
    }

    public final boolean isNewNumber(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        return Intrinsics.areEqual(recipientModel.SubSequence, "Manual Input") || Intrinsics.areEqual(recipientModel.SubSequence, RecipientSource.SEARCH_MANUAL_INPUT);
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        int length = super.getResources().getString(R.string.error_google_oauth_description).substring(6, 7).length() + 119;
        try {
            Object[] objArr = new Object[1];
            a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], new Object[1]);
            Object[] objArr2 = new Object[1];
            b(true, length, ((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 30, super.getResources().getString(R.string.error_promo_description).substring(4, 5).codePointAt(0) - 14, new char[]{1, 11, 65534, 16, 16, 2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15}, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(false, super.getResources().getString(R.string.ticket_failed_button).substring(0, 7).length() + 118, 3 - (ViewConfiguration.getScrollBarSize() >> 8), 6 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{65517, 1, 65532, 5, 17}, objArr3);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    int codePointAt = getPackageName().codePointAt(4) + 23;
                    try {
                        Object[] objArr4 = new Object[1];
                        a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], new Object[1]);
                        Object[] objArr5 = new Object[1];
                        b(false, codePointAt, ((ApplicationInfo) cls3.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 30, Color.red(0) + 26, new char[]{2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15}, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        b(false, 127 - View.MeasureSpec.getMode(0), MotionEvent.axisFromString("") + 4, 18 - ExpandableListView.getPackedPositionType(0L), new char[]{65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n'}, objArr6);
                        baseContext = (Context) cls4.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 35 - ExpandableListView.getPackedPositionType(0L), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        try {
                            Object[] objArr7 = new Object[1];
                            a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr7);
                            Class<?> cls5 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], objArr8);
                            Object[] objArr9 = new Object[1];
                            b(false, ((ApplicationInfo) cls5.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 59, super.getResources().getString(R.string.family_status_invited_canceled_description).substring(3, 4).length() + 1, (ViewConfiguration.getEdgeSlop() >> 16) + 48, new char[]{65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516}, objArr9);
                            String str = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            b(false, TextUtils.indexOf((CharSequence) "", '0', 0) + 88, 30 - (Process.myPid() >> 22), 64 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote}, objArr10);
                            String str2 = (String) objArr10[0];
                            int length2 = super.getResources().getString(R.string.error_saving_insufficient_balance).substring(31, 32).length() + 88;
                            try {
                                Object[] objArr11 = new Object[1];
                                a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], objArr12);
                                Object[] objArr13 = new Object[1];
                                b(false, length2, ((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 11, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 63, new char[]{65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER}, objArr13);
                                String str3 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                b(false, 118 - View.resolveSize(0, 0), getPackageName().length() + 10, super.getResources().getString(R.string.ticket_asset_empty_subtitle).substring(33, 34).codePointAt(0) + 28, new char[]{65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b'}, objArr14);
                                String str4 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                b(true, 70 - TextUtils.lastIndexOf("", '0', 0), super.getResources().getString(R.string.bank_account_confirm).substring(1, 7).codePointAt(3) - 102, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 6, new char[]{2, 65532, 7, 65535, 0, 65532}, objArr15);
                                try {
                                    Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, 17 - TextUtils.lastIndexOf("", '0'), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr16);
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
            }
            try {
                Object[] objArr17 = new Object[1];
                a(getAuthRequestContext[31], getAuthRequestContext[32], getAuthRequestContext[25], objArr17);
                Class<?> cls7 = Class.forName((String) objArr17[0]);
                byte b = (byte) (getAuthRequestContext[34] + 1);
                Object[] objArr18 = new Object[1];
                a(b, (byte) (b & 40), getAuthRequestContext[25], objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 494, TextUtils.lastIndexOf("", '0', 0) + 5, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr20 = new Object[1];
                        c(b2, b2, $$a[8], objArr20);
                        obj3 = cls8.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr22 = {-523985868, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr22);
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
                    ((SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).getAuthRequestContext();
                    ((SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    super.onCreate(savedInstanceState);
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
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity
    public final void processRecipientListData(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        recipientModel.BottomSheetCardBindingView$watcherCardNumberView$1 = "sendMoney";
        super.processRecipientListData(recipientModel);
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (FragmentBottomSheetPaymentSettingBinding ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
