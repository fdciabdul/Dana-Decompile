package id.dana.sendmoney.summary;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.card.MaterialCardView;
import com.google.common.base.Ascii;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.SingleClickListener;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.common.IntentKeySource;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.richview.NumpadView;
import id.dana.core.ui.util.NumberUtil;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.util.NumberUtils;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.ExpiryModule;
import id.dana.di.modules.SendMoneyConfirmationModule;
import id.dana.di.modules.SendMoneySummaryModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.domain.sendmoney.TransferScenario;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.withdraw.model.TransferMethodView;
import id.dana.extension.view.ViewExtKt;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.lib.gcontainer.app.bridge.subapp.CloseSubAppBridge;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.pay.PayActivity;
import id.dana.sendmoney.Amount;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.external.SmartFrictionBottomSheetFragment;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.ShareActivityModel;
import id.dana.sendmoney.model.VoucherModel;
import id.dana.sendmoney.model.WithdrawOTCModel;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import id.dana.sendmoney.paymethod.PaymentIconFactory;
import id.dana.sendmoney.summary.amountcalculation.AmountCalculationExtKt;
import id.dana.sendmoney.summary.factory.SendMoneySummaryFactory;
import id.dana.sendmoney.summary.state.SendMoneySummary;
import id.dana.sendmoney.summary.state.model.SummaryConfirmationModel;
import id.dana.sendmoney.summary.state.model.SummaryValidateModel;
import id.dana.sendmoney.summary.state.model.UnitSymbolModel;
import id.dana.sendmoney.summary.sticky.DaggerStickySummaryComponent;
import id.dana.sendmoney.summary.view.SummaryView;
import id.dana.sendmoney.summary.view.SummaryViewState;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.voucher.SummaryVoucherView;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.view.NewShareToFeedsView;
import id.dana.sendmoney_v2.paymethod.PayMethodView;
import id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity;
import id.dana.sendmoney_v2.summary.ExpiryTimeBottomSheetFragment;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.social.contract.share.ShareToFeedsContract;
import id.dana.social.contract.share.ShareToFeedsModule;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.util.IapConnectKtx;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.B;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000\u0088\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 õ\u00012\u00020\u0001:\u0002õ\u0001B\b¢\u0006\u0005\bô\u0001\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u000bJ\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010\u000bJ\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0007H\u0002¢\u0006\u0004\b,\u0010\u000bJ\u000f\u0010-\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010.J'\u0010&\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020/2\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)H\u0002¢\u0006\u0004\b&\u00102J\u000f\u00103\u001a\u00020\u0007H\u0002¢\u0006\u0004\b3\u0010\u000bJ\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000504H\u0002¢\u0006\u0004\b\b\u00105J\u000f\u00107\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u00109J\u0015\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0015\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0007H\u0002¢\u0006\u0004\bB\u0010\u000bJ\u000f\u0010C\u001a\u00020\u0007H\u0002¢\u0006\u0004\bC\u0010\u000bJ\u000f\u0010D\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010\u000bJ\u000f\u0010E\u001a\u00020\u0007H\u0002¢\u0006\u0004\bE\u0010\u000bJ\u000f\u0010F\u001a\u00020\u0007H\u0002¢\u0006\u0004\bF\u0010\u000bJ\u000f\u0010G\u001a\u00020\u0007H\u0002¢\u0006\u0004\bG\u0010\u000bJ\u000f\u0010H\u001a\u00020\u0007H\u0016¢\u0006\u0004\bH\u0010\u000bJ\u000f\u0010I\u001a\u00020\u0007H\u0002¢\u0006\u0004\bI\u0010\u000bJ\u000f\u0010J\u001a\u00020\u0007H\u0002¢\u0006\u0004\bJ\u0010\u000bJ\u000f\u0010K\u001a\u00020\u0007H\u0002¢\u0006\u0004\bK\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020>H\u0002¢\u0006\u0004\b\u000e\u0010AJ\u000f\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0004\bL\u0010\u000bJ\u000f\u0010M\u001a\u00020\u0007H\u0002¢\u0006\u0004\bM\u0010\u000bJ\u000f\u0010N\u001a\u00020\u0007H\u0002¢\u0006\u0004\bN\u0010\u000bJ\u000f\u0010O\u001a\u00020\u0007H\u0002¢\u0006\u0004\bO\u0010\u000bJ\u000f\u0010P\u001a\u00020\u0007H\u0002¢\u0006\u0004\bP\u0010\u000bJ\u000f\u0010Q\u001a\u00020\u0007H\u0002¢\u0006\u0004\bQ\u0010\u000bJ\u000f\u0010R\u001a\u00020\u0007H\u0002¢\u0006\u0004\bR\u0010\u000bJ\u000f\u0010S\u001a\u00020\u0007H\u0002¢\u0006\u0004\bS\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010T\u001a\u00020\u0016H\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0016H\u0002¢\u0006\u0004\bV\u0010UJ\u000f\u0010W\u001a\u00020\u0016H\u0002¢\u0006\u0004\bW\u0010UJ\u000f\u0010X\u001a\u00020\u0007H\u0002¢\u0006\u0004\bX\u0010\u000bJ\u000f\u0010Y\u001a\u00020\u0007H\u0002¢\u0006\u0004\bY\u0010\u000bJ)\u0010^\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020)2\u0006\u0010[\u001a\u00020)2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0014¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\u0007H\u0002¢\u0006\u0004\b`\u0010\u000bJ\u0019\u0010b\u001a\u00020\u00072\b\u0010a\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u0007H\u0002¢\u0006\u0004\bd\u0010\u000bJ\u000f\u0010e\u001a\u00020\u0007H\u0002¢\u0006\u0004\be\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020fH\u0002¢\u0006\u0004\b\u000e\u0010gJ\u0015\u0010i\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0016¢\u0006\u0004\bi\u0010jJ\u0015\u0010l\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u0005¢\u0006\u0004\bl\u0010\tJ\u0015\u0010m\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u0005¢\u0006\u0004\bm\u0010\tJ\u000f\u0010n\u001a\u00020\u0007H\u0002¢\u0006\u0004\bn\u0010\u000bJ\u0011\u0010o\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bo\u0010.J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020pH\u0002¢\u0006\u0004\b&\u0010qJ\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\tJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\tJ\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\tJ\r\u0010r\u001a\u00020\u0007¢\u0006\u0004\br\u0010\u000bJ\u0017\u0010s\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020pH\u0002¢\u0006\u0004\bs\u0010qJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010tJ\u000f\u0010u\u001a\u00020\u0007H\u0002¢\u0006\u0004\bu\u0010\u000bJ\u000f\u0010v\u001a\u00020\u0007H\u0002¢\u0006\u0004\bv\u0010\u000bJ\u001b\u0010s\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010wH\u0002¢\u0006\u0004\bs\u0010xJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\b\u0010jJ\u000f\u0010y\u001a\u00020\u0007H\u0002¢\u0006\u0004\by\u0010\u000bJ\u000f\u0010z\u001a\u00020\u0007H\u0002¢\u0006\u0004\bz\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020)H\u0002¢\u0006\u0004\b\b\u0010{J\u0019\u0010\u000e\u001a\u00020|*\b\u0012\u0004\u0012\u00020|04H\u0002¢\u0006\u0004\b\u000e\u0010}J\u0013\u0010\b\u001a\u00020\u0007*\u00020~H\u0002¢\u0006\u0004\b\b\u0010\u007fJ\u0013\u0010\n\u001a\u00020\u0007*\u00020~H\u0002¢\u0006\u0004\b\n\u0010\u007fJ%\u0010s\u001a\u00020\u0007*\u00030\u0080\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00100\u001a\u00020)H\u0002¢\u0006\u0005\bs\u0010\u0081\u0001R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b!\u0010\u0082\u0001R\u0017\u0010\u000e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u0083\u0001R\u0018\u0010&\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0011\u0010\u0085\u0001R\u001a\u0010s\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010\u0087\u0001R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b,\u0010\u0082\u0001R\u0017\u0010\u001e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010\u0083\u0001R!\u0010!\u001a\f\u0012\u0005\u0012\u00030\u0089\u0001\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b-\u0010\u008a\u0001R \u0010\u0011\u001a\r\u0012\b\u0012\u0006*\u00020\\0\\0\u008b\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b$\u0010\u008c\u0001R\u001a\u0010\u001b\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R!\u0010\u0019\u001a\f\u0012\u0005\u0012\u00030\u008f\u0001\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b3\u0010\u008a\u0001R\u001b\u0010-\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R*\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0017\u0010(\u001a\u00030\u009a\u00018CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u009b\u0001R*\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u0082\u0001R\u0018\u0010,\u001a\u00030¤\u00018\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\b7\u0010¥\u0001R\u001f\u0010$\u001a\t\u0012\u0004\u0012\u00020|0¦\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001a\u0010£\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bE\u0010\u0082\u0001R\u0018\u0010\u0091\u0001\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bD\u0010\u0083\u0001R\u001e\u0010§\u0001\u001a\u00020\u00168CX\u0083\u0084\u0002¢\u0006\u000e\n\u0005\bC\u0010©\u0001\u001a\u0005\bª\u0001\u0010UR\u0017\u00103\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bB\u0010\u0083\u0001R\u0019\u00107\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bF\u0010\u0082\u0001R4\u0010°\u0001\u001a\u0004\u0018\u00010p2\t\u0010«\u0001\u001a\u0004\u0018\u00010p8\u0007@GX\u0087\u000e¢\u0006\u0016\n\u0005\bK\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0005\b¯\u0001\u0010qR\u001a\u0010B\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bJ\u0010²\u0001R%\u0010F\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058\u0002@CX\u0083\u000e¢\u0006\r\n\u0005\bI\u0010\u0082\u0001\"\u0004\bs\u0010\tR\u001a\u0010D\u001a\u0005\u0018\u00010³\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bG\u0010´\u0001R*\u0010¶\u0001\u001a\u00030µ\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¶\u0001\u0010·\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R\u001a\u0010E\u001a\u0005\u0018\u00010¼\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bL\u0010½\u0001R*\u0010¿\u0001\u001a\u00030¾\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R*\u0010Æ\u0001\u001a\u00030Å\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u001f\u0010C\u001a\u00030Ì\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\bN\u0010©\u0001\u001a\u0006\b§\u0001\u0010Í\u0001R\u0018\u0010G\u001a\u00030Î\u00018\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\bQ\u0010Ï\u0001R*\u0010Ñ\u0001\u001a\u00030Ð\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R\u0017\u0010K\u001a\u00030×\u00018CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010Ø\u0001R*\u0010Ú\u0001\u001a\u00030Ù\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R\u0017\u0010J\u001a\u00030à\u00018CX\u0082\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010á\u0001R*\u0010ã\u0001\u001a\u00030â\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R\u001a\u0010L\u001a\u0005\u0018\u00010é\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bP\u0010ê\u0001R\u0018\u0010I\u001a\u00030ë\u00018\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\bM\u0010ì\u0001R\u0017\u0010O\u001a\u00020\u00058\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\bO\u0010\u0082\u0001R\u0018\u0010M\u001a\u00030í\u00018\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\bR\u0010î\u0001R\u0019\u0010Q\u001a\u00030ï\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\bª\u0001\u0010ð\u0001R \u0010N\u001a\r\u0012\b\u0012\u0006*\u00020\\0\\0\u008b\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\bT\u0010\u008c\u0001R\u0017\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\bS\u0010ñ\u0001R\u0017\u0010V\u001a\u00020\u00028\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\bV\u0010ñ\u0001R\u0019\u0010S\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bW\u0010\u0082\u0001R\u0017\u0010T\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bY\u0010\u0083\u0001R\u001b\u0010ª\u0001\u001a\u0005\u0018\u00010ò\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b`\u0010ó\u0001"}, d2 = {"Lid/dana/sendmoney/summary/SummaryActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/model/CurrencyAmountModel;", "amountToSend", "()Lid/dana/model/CurrencyAmountModel;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "configToolbar", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/os/Bundle;", "Lid/dana/sendmoney/summary/state/model/UnitSymbolModel;", "scheduleImpl", "()Lid/dana/sendmoney/summary/state/model/UnitSymbolModel;", "dismissDanaLoadingDialog", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "moveToNextValue", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$View;", "getErrorConfigVersion", "()Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$View;", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$View;", "lookAheadTest", "()Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$View;", "Landroid/text/Spannable;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Landroid/text/Spannable;", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Landroid/text/Spannable;", "DatabaseTableConfigUtil", "", "getLayout", "()I", "initRecordTimeStamp", "GetContactSyncConfig", "()Ljava/lang/String;", "", "p1", "p2", "(Ljava/lang/CharSequence;II)Landroid/text/Spannable;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "", "(Ljava/util/List;)Ljava/lang/String;", "Lid/dana/sendmoney/summary/SummaryActivity$getSummaryVoucherListener$1;", "isLayoutRequested", "()Lid/dana/sendmoney/summary/SummaryActivity$getSummaryVoucherListener$1;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "transferInitResultModel", "getTransferBalanceInitCallback", "(Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "transferInit", "getTransferInitCallback", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "SubSequence", IAPSyncCommand.COMMAND_INIT, "whenAvailable", "readMicros", "getCallingPid", "getSupportButtonTintMode", "BottomSheetCardBindingView$watcherCardNumberView$1", DiskFormatter.B, "VerifyPinStateManager$executeRiskChallenge$2$1", "A", "C", SummaryActivity.DAYS, "getValueOfTouchPositionAbsolute", "VerifyPinStateManager$executeRiskChallenge$2$2", "()Z", "E", LogConstants.RESULT_FALSE, SummaryActivity.HOURS, "AppCompatEmojiTextHelper", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", DiskFormatter.GB, "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "I", "J", "Lid/dana/sendmoney/model/ConfirmationModel;", "(Lid/dana/sendmoney/model/ConfirmationModel;)V", "isVisible", "setCustomKeyboardVisibility", "(Z)V", "amount", "setDisabledWithAmount", "setEnableButtonWithAmount", DiskFormatter.MB, DiskFormatter.KB, "Lid/dana/model/PayMethodModel;", "(Lid/dana/model/PayMethodModel;)V", "showDanaLoadingDialog", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "getNameOrBuilderList", "L", "Lid/dana/sendmoney/model/ExpiryInfoModel;", "(Lid/dana/sendmoney/model/ExpiryInfoModel;)V", "O", "P", "(I)V", "Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "(Ljava/util/List;)Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "Lid/dana/sendmoney/summary/view/SummaryView;", "(Lid/dana/sendmoney/summary/view/SummaryView;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "(Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;I)V", "Ljava/lang/String;", "Z", "Lid/dana/globalnetwork/AlipayConnectInitializer;", "Lid/dana/globalnetwork/AlipayConnectInitializer;", "Lid/dana/sendmoney/Amount;", "Lid/dana/sendmoney/Amount;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/card/MaterialCardView;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/ActivityResultLauncher;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/sendmoney/model/ConfirmationModel;", "Landroid/view/View;", "Lid/dana/dialog/DanaLoadingDialog;", "PrepareContext", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/di/modules/ExpiryModule;", "()Lid/dana/di/modules/ExpiryModule;", "Lid/dana/contract/sendmoney/ExpiryContract$Presenter;", "expiryPresenter", "Lid/dana/contract/sendmoney/ExpiryContract$Presenter;", "getExpiryPresenter", "()Lid/dana/contract/sendmoney/ExpiryContract$Presenter;", "setExpiryPresenter", "(Lid/dana/contract/sendmoney/ExpiryContract$Presenter;)V", "newProxyInstance", "Lid/dana/sendmoney_v2/summary/ExpiryTimeBottomSheetFragment;", "Lid/dana/sendmoney_v2/summary/ExpiryTimeBottomSheetFragment;", "", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/util/List;", "Lkotlin/Lazy;", "getOnBoardingScenario", "value", "Lid/dana/model/PayMethodModel;", "getPayMethodModel", "()Lid/dana/model/PayMethodModel;", "setPayMethodModel", "payMethodModel", "Lid/dana/sendmoney/model/RecipientModel;", "Lid/dana/sendmoney/model/RecipientModel;", "Lid/dana/sendmoney/model/VoucherModel;", "Lid/dana/sendmoney/model/VoucherModel;", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticalTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticalTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticalTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/domain/sendmoney/model/SendMoneyConfirm;", "Lid/dana/domain/sendmoney/model/SendMoneyConfirm;", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;", "sendMoneyConfirmationBankPresenter", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;", "getSendMoneyConfirmationBankPresenter", "()Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;", "setSendMoneyConfirmationBankPresenter", "(Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;)V", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "sendMoneyConfirmationPresenter", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "getSendMoneyConfirmationPresenter", "()Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "setSendMoneyConfirmationPresenter", "(Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "()Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "Lid/dana/sendmoney/summary/state/SendMoneySummary;", "Lid/dana/sendmoney/summary/state/SendMoneySummary;", "Lid/dana/sendmoney/summary/factory/SendMoneySummaryFactory;", "sendMoneySummaryFactory", "Lid/dana/sendmoney/summary/factory/SendMoneySummaryFactory;", "getSendMoneySummaryFactory", "()Lid/dana/sendmoney/summary/factory/SendMoneySummaryFactory;", "setSendMoneySummaryFactory", "(Lid/dana/sendmoney/summary/factory/SendMoneySummaryFactory;)V", "Lid/dana/di/modules/SendMoneySummaryModule;", "()Lid/dana/di/modules/SendMoneySummaryModule;", "Lid/dana/sendmoney/namecheck/SendMoneySummaryContract$Presenter;", "sendMoneySummaryPresenter", "Lid/dana/sendmoney/namecheck/SendMoneySummaryContract$Presenter;", "getSendMoneySummaryPresenter", "()Lid/dana/sendmoney/namecheck/SendMoneySummaryContract$Presenter;", "setSendMoneySummaryPresenter", "(Lid/dana/sendmoney/namecheck/SendMoneySummaryContract$Presenter;)V", "Lid/dana/social/contract/share/ShareToFeedsModule;", "()Lid/dana/social/contract/share/ShareToFeedsModule;", "Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;", "shareToFeedsPresenter", "Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;", "getShareToFeedsPresenter", "()Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;", "setShareToFeedsPresenter", "(Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "Lid/dana/sendmoney/summary/view/SummaryViewState;", "Lid/dana/sendmoney/summary/view/SummaryViewState;", "Lid/dana/sendmoney/voucher/SummaryVoucherView;", "Lid/dana/sendmoney/voucher/SummaryVoucherView;", "Lid/dana/model/CurrencyAmountModel;", "Lid/dana/sendmoney/model/WithdrawOTCModel;", "Lid/dana/sendmoney/model/WithdrawOTCModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryActivity extends BaseActivity {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String ASTERISK = "*";
    public static final String BIZ_TRANSFER_INIT = "bizTransferInit";
    public static final String CHECKED = "true";
    public static final String DAYS = "D";
    public static final String FIRST_STATE_SHARE_FEED = "firstTime";
    private static char[] H = null;
    public static final String HOURS = "H";
    private static int I = 0;
    private static byte[] J = null;
    private static int K = 0;
    private static int M = 0;
    public static final String NO_NAME_CONTACT = "-";
    private static int P = 0;
    public static final float PAY_METHOD_TOP_PADDING = 8.0f;
    public static final int PlaceComponentResult;
    public static final String TRANSFER_BALANCE_INIT = "transferBalanceInit";
    public static final String UNCHECKED = "false";
    public static final String ZERO_AMOUNT = "0";
    public static final byte[] getAuthRequestContext;
    private static short[] getNameOrBuilderList;

    /* renamed from: A  reason: from kotlin metadata */
    private SkeletonScreen getSupportButtonTintMode;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    private boolean VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: B */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private SmartFrictionConfig whenAvailable;

    /* renamed from: C  reason: from kotlin metadata */
    private SendMoneySummary SubSequence;

    /* renamed from: D */
    private SummaryViewState BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean lookAheadTest;
    private CurrencyAmountModel E;

    /* renamed from: F */
    private String getValueOfTouchPositionAbsolute;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean PrepareContext;

    /* renamed from: G */
    private WithdrawOTCModel getOnBoardingScenario;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private BottomSheetBehavior<MaterialCardView> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private ConfirmationModel getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private String newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private String isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private List<ExpiryTimeConfig> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private BottomSheetBehavior<View> moveToNextValue;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private DanaLoadingDialog GetContactSyncConfig;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private VoucherModel FragmentBottomSheetPaymentSettingBinding;
    private String VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public ExpiryContract.Presenter expiryPresenter;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private PayMethodModel payMethodModel;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private SummaryVoucherView C;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private SendMoneyConfirm NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private CurrencyAmountModel A;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private ExpiryTimeBottomSheetFragment initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Amount getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private RecipientModel NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private AlipayConnectInitializer MyBillsEntityDataFactory;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticalTracker;
    @Inject
    public SendMoneyConfirmationBankContract.Presenter sendMoneyConfirmationBankPresenter;
    @Inject
    public SendMoneyConfirmationContract.Presenter sendMoneyConfirmationPresenter;
    @Inject
    public SendMoneySummaryFactory sendMoneySummaryFactory;
    @Inject
    public SendMoneySummaryContract.Presenter sendMoneySummaryPresenter;
    @Inject
    public ShareToFeedsContract.Presenter shareToFeedsPresenter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda4;
    public static final byte[] $$a = {62, -79, -77, -78, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 77;
    private static int L = 0;

    /* renamed from: $r8$lambda$-qvrPAfJJ_e36dUuqQrQupnvkUg */
    public static /* synthetic */ void m2909$r8$lambda$qvrPAfJJ_e36dUuqQrQupnvkUg(SummaryActivity summaryActivity, List list) {
        int i = P + 1;
        L = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(summaryActivity, list);
        int i3 = P + 95;
        L = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        int i4 = 98 / 0;
    }

    /* renamed from: $r8$lambda$6NtaDtDRYb9-A6FIw9OFX-Y3QQY */
    public static /* synthetic */ void m2910$r8$lambda$6NtaDtDRYb9A6FIw9OFXY3QQY(SummaryActivity summaryActivity, ActivityResult activityResult) {
        int i = L + 77;
        P = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(summaryActivity, activityResult);
        try {
            int i3 = L + 119;
            try {
                P = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$NQMNHV7oJIZncsC7M2i3zThUpYU(SummaryActivity summaryActivity, View view) {
        int i = L + 19;
        P = i % 128;
        if (!(i % 2 == 0)) {
            try {
                getAuthRequestContext(summaryActivity);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        getAuthRequestContext(summaryActivity);
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static /* synthetic */ void $r8$lambda$T73tMUc0n1CaC3zm7xpkMbMACbk(SummaryActivity summaryActivity, View view) {
        int i = P + 19;
        L = i % 128;
        if ((i % 2 != 0 ? 'S' : '\n') != '\n') {
            BuiltInFictitiousFunctionClassFactory(summaryActivity);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                BuiltInFictitiousFunctionClassFactory(summaryActivity);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = P + 9;
        L = i2 % 128;
        int i3 = i2 % 2;
    }

    /* renamed from: $r8$lambda$e2pmOOmAlQfhJ2dFWaTrUPkUQ-g */
    public static /* synthetic */ void m2911$r8$lambda$e2pmOOmAlQfhJ2dFWaTrUPkUQg(SummaryActivity summaryActivity, View view) {
        try {
            int i = P + 87;
            L = i % 128;
            int i2 = i % 2;
            PlaceComponentResult(summaryActivity);
            int i3 = P + 13;
            L = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$nhRO1w54EFbcUV88XET1embQtkc(SummaryActivity summaryActivity, ActivityResult activityResult) {
        try {
            int i = P + 101;
            L = i % 128;
            char c = i % 2 != 0 ? 'M' : 'P';
            getAuthRequestContext(summaryActivity, activityResult);
            if (c != 'P') {
                Object obj = null;
                obj.hashCode();
            }
            int i2 = L + 57;
            P = i2 % 128;
            if ((i2 % 2 == 0 ? 'T' : (char) 25) != 25) {
                int i3 = 47 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$pD3UzwOhVpDNv2ikqRz_oHgkLS4(SummaryActivity summaryActivity, View view) {
        int i = P + 27;
        L = i % 128;
        if (i % 2 == 0) {
            try {
                MyBillsEntityDataFactory(summaryActivity);
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                MyBillsEntityDataFactory(summaryActivity);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = P + 65;
        L = i2 % 128;
        if ((i2 % 2 != 0 ? 'M' : (char) 6) != 6) {
            int i3 = 37 / 0;
        }
    }

    static {
        P = 1;
        getAuthRequestContext();
        getAuthRequestContext = new byte[]{107, -40, -73, 40, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        PlaceComponentResult = 207;
        PlaceComponentResult();
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = L + 3;
        P = i % 128;
        if (i % 2 == 0) {
            defaultConstructorMarker.hashCode();
        }
    }

    static void PlaceComponentResult() {
        int i = L + 45;
        P = i % 128;
        int i2 = i % 2;
        H = new char[]{35498, 35570, 35566, 35573, 35575, 35577, 35572, 35565, 35570, 35578, 35575, 35566, 35583, 35489, 35534, 35567, 35536, 35543, 35498, 35576, 35574, 35565, 35577, 35569, 35394, 35395, 35451, 35449, 35398, 35454, 35438, 35446, 35447, 35447, 35446, 35451, 35410, 35375, 35415, 35444, 35452, 35423, 35421, 35454, 35448, 35444, 35451, 35453, 35455, 35528, 35379, 35381, 35379, 35383, 35391, 35387, 35383, 35379, 35377, 35337, 35335, 35374, 35382, 35380, 35375, 35372, 35381, 35458, 35497, 35538, 35539, 35536, 35539, 35498, 35540, 35538, 35499, 35539, 35536, 35501, 35498, 35494, 35537, 35537, 35499, 35498, 35497, 35537, 35581, 35580, 35541, 35541, 35536, 35499, 35541, 35539, 35538, 35581, 35581, 35580, 35541, 35501, 35503, 35501, 35501, 35503, 35541, 35579, 35578, 35578, 35536, 35497, 35494, 35536, 35540, 35463, 35501, 35499, 35498, 35498, 35539, 35540, 35541, 35540, 35500, 35498, 35503, 35543, 35581, 35539, 35496, 35538, 35581, 35540, 35500, 35541, 35536, 35536, 35537, 35539, 35538, 35498, 35498, 35501, 35540, 35540, 35541, 35538, 35500, 35501, 35500, 35503, 35540, 35538, 35497, 35536, 35581, 35536, 35498, 35498, 35537, 35579, 35539, 35499, 35541, 35540, 35541, 35536, 35498, 35543, 35580, 35540, 35502, 35502, 35502, 35501, 35494, 35495, 35494, 35509, 35531, 35569, 35353, 35567, 35522, 35526, 35529, 35524, 35522, 35522, 35526, 35531, 35528, 35531, 35529, 35566, 35353, 35566, 35566, 35569, 35568, 35355, 35568, 35527, 35564, 35565, 35522, 35565, 35348, 35564, 35567, 35567, 35567, 35569, 35527, 35567, 35566, 35524, 35525, 35522, 35565, 35569, 35528, 35524, 35526, 35570, 35355, 35350, 35565, 35564, 35350, 35569, 35531, 35569, 35567, 35524, 35524, 35525, 35525, 35564, 35567, 35527, 35525, 35503, 35573, 35572, 35581, 35573, 35571, 35568, 35535, 35545, 35577, 35577, 35580, 35543, 35505, 35498, 35528, 35567, 35564, 35562, 35568, 35571, 35565, 35567, 35575, 35571, 35571, 35540, 35502, 35530, 35532, 35535, 35565, 35570, 35576, 35572, 35573, 35538, 35538, 35570, 35574, 35542, 35536, 35568, 35575, 35542, 35543, 35573, 35575, 35573, 35565, 35564, 35573, 35573, 35575, 35573, 35568, 35540, 35535, 35565, 35572, 35462, 35503, 35502, 35503, 35503, 35501};
        int i3 = P + 33;
        L = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0038 -> B:47:0x003e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r9, int r10, short r11, java.lang.Object[] r12) {
        /*
            byte[] r0 = id.dana.sendmoney.summary.SummaryActivity.getAuthRequestContext
            int r10 = r10 + 4
            int r9 = 106 - r9
            int r11 = r11 * 2
            int r11 = 16 - r11
            byte[] r1 = new byte[r11]
            r2 = -1
            int r11 = r11 + r2
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L14
            r5 = 1
            goto L15
        L14:
            r5 = 0
        L15:
            if (r5 == r4) goto L1d
            r2 = r1
            r5 = -1
            r1 = r0
            r0 = r12
            r12 = r11
            goto L3e
        L1d:
            int r5 = id.dana.sendmoney.summary.SummaryActivity.P
            int r5 = r5 + 79
            int r6 = r5 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L2b
            r5 = 1
            goto L2c
        L2b:
            r5 = 0
        L2c:
            if (r5 == r4) goto L2f
            goto L32
        L2f:
            r5 = 61
            int r5 = r5 / r3
        L32:
            r2 = r1
            r5 = -1
            r1 = r0
            r0 = r12
            r12 = r11
            r11 = r10
        L38:
            int r9 = -r9
            int r10 = r10 + r9
            int r10 = r10 + 2
            r9 = r10
            r10 = r11
        L3e:
            int r5 = r5 + r4
            int r11 = r10 + 1
            byte r10 = (byte) r9
            r2[r5] = r10
            if (r5 != r12) goto L4e
            java.lang.String r9 = new java.lang.String
            r9.<init>(r2, r3)
            r0[r3] = r9
            return
        L4e:
            r10 = r1[r11]
            int r6 = id.dana.sendmoney.summary.SummaryActivity.P
            int r6 = r6 + 105
            int r7 = r6 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r7
            int r6 = r6 % 2
            r8 = r10
            r10 = r9
            r9 = r8
            goto L38
        L5e:
            r9 = move-exception
            goto L61
        L60:
            throw r9
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.c(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.sendmoney.summary.SummaryActivity.$$a
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = 47 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.g(short, byte, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        M = 1257195680;
        K = 234865438;
        J = new byte[]{90, -104, -113, -82};
        I = -889163649;
    }

    public final void _$_clearFindViewByIdCache() {
        int i = P + 121;
        L = i % 128;
        if (!(i % 2 != 0)) {
            this._$_findViewCache.clear();
            return;
        }
        this._$_findViewCache.clear();
        int i2 = 15 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0023, code lost:
    
        if ((r2 == null ? 'N' : '\n') != '\n') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x003f, code lost:
    
        if ((r2 == null ? '6' : '!') != '6') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0042, code lost:
    
        r2 = findViewById(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0046, code lost:
    
        if (r2 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0048, code lost:
    
        r3 = id.dana.sendmoney.summary.SummaryActivity.P + 89;
        id.dana.sendmoney.summary.SummaryActivity.L = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0053, code lost:
    
        if ((r3 % 2) == 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0055, code lost:
    
        r3 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0058, code lost:
    
        r3 = 'U';
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005a, code lost:
    
        r0.put(java.lang.Integer.valueOf(r7), r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0061, code lost:
    
        if (r3 == 'Y') goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0064, code lost:
    
        r7 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0068, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r7) {
        /*
            r6 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L2a
            java.util.Map<java.lang.Integer, android.view.View> r0 = r6._$_findViewCache
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            java.lang.Object r2 = r0.get(r2)
            android.view.View r2 = (android.view.View) r2
            int r3 = r1.length     // Catch: java.lang.Throwable -> L28
            r3 = 10
            if (r2 != 0) goto L21
            r4 = 78
            goto L23
        L21:
            r4 = 10
        L23:
            if (r4 == r3) goto L26
            goto L42
        L26:
            r1 = r2
            goto L68
        L28:
            r7 = move-exception
            throw r7
        L2a:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r6._$_findViewCache     // Catch: java.lang.Exception -> L6b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L69
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Exception -> L69
            android.view.View r2 = (android.view.View) r2     // Catch: java.lang.Exception -> L69
            r3 = 54
            if (r2 != 0) goto L3d
            r4 = 54
            goto L3f
        L3d:
            r4 = 33
        L3f:
            if (r4 == r3) goto L42
            goto L26
        L42:
            android.view.View r2 = r6.findViewById(r7)     // Catch: java.lang.Exception -> L6b
            if (r2 == 0) goto L68
            int r3 = id.dana.sendmoney.summary.SummaryActivity.P
            r4 = 89
            int r3 = r3 + r4
            int r5 = r3 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r5
            int r3 = r3 % 2
            if (r3 == 0) goto L58
            r3 = 89
            goto L5a
        L58:
            r3 = 85
        L5a:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.put(r7, r2)
            if (r3 == r4) goto L64
            goto L26
        L64:
            int r7 = r1.length     // Catch: java.lang.Throwable -> L66
            goto L26
        L66:
            r7 = move-exception
            throw r7
        L68:
            return r1
        L69:
            r7 = move-exception
            throw r7
        L6b:
            r7 = move-exception
            goto L6e
        L6d:
            throw r7
        L6e:
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity._$_findCachedViewById(int):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:353:0x0085, code lost:
    
        if (r3 > 99999) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x008e, code lost:
    
        if (r3 > 99999) goto L360;
     */
    /* JADX WARN: Removed duplicated region for block: B:388:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0896  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0a5d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x089f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:666:0x01f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r22) {
        /*
            Method dump skipped, instructions count: 2901
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        int i = P + 53;
        L = i % 128;
        int i2 = i % 2;
        Context applicationContext = super.getApplicationContext();
        try {
            int i3 = L + 1;
            P = i3 % 128;
            int i4 = i3 % 2;
            return applicationContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        try {
            int i = P + 53;
            L = i % 128;
            int i2 = i % 2;
            Context baseContext = super.getBaseContext();
            int i3 = P + 63;
            L = i3 % 128;
            if ((i3 % 2 != 0 ? '+' : 'N') != '+') {
                return baseContext;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return baseContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        int i = P + 67;
        L = i % 128;
        if ((i % 2 != 0 ? 'A' : '\t') != 'A') {
            return R.layout.activity_summary;
        }
        Object obj = null;
        obj.hashCode();
        return R.layout.activity_summary;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        try {
            int i = L + 45;
            P = i % 128;
            int i2 = i % 2;
            Resources resources = super.getResources();
            int i3 = P + 29;
            L = i3 % 128;
            int i4 = i3 % 2;
            return resources;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0120, code lost:
    
        super.onPause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0123, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0021, code lost:
    
        if ((r0 == null ? 'Y' : '6') != 'Y') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x002a, code lost:
    
        if (r0 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x002c, code lost:
    
        r7 = new java.lang.Object[1];
        b(true, new int[]{23, 26, 122, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, r7);
        r5 = java.lang.Class.forName((java.lang.String) r7[0]);
        r7 = new java.lang.Object[1];
        b(true, new int[]{49, 18, 63, 0}, new byte[]{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, r7);
        r0 = (android.content.Context) r5.getMethod((java.lang.String) r7[0], new java.lang.Class[0]).invoke(null, null);
        r5 = id.dana.sendmoney.summary.SummaryActivity.L + 65;
        id.dana.sendmoney.summary.SummaryActivity.P = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0071, code lost:
    
        if (r0 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0073, code lost:
    
        r6 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0076, code lost:
    
        r6 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0078, code lost:
    
        if (r6 == ':') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x007b, code lost:
    
        r0 = r0.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x007f, code lost:
    
        if (r0 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0081, code lost:
    
        r5 = o.SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x008e, code lost:
    
        if (r5 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0091, code lost:
    
        r5 = ((java.lang.Class) o.SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - android.graphics.Color.blue(0), (android.os.Process.myTid() >> 22) + 35, (char) ((-1) - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
        o.SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00bf, code lost:
    
        r3 = ((java.lang.reflect.Method) r5).invoke(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00c5, code lost:
    
        r5 = new java.lang.Object[]{r0};
        r0 = o.SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00d6, code lost:
    
        if (r0 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00d9, code lost:
    
        r0 = ((java.lang.Class) o.SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((android.os.SystemClock.elapsedRealtimeNanos() > 0 ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0 ? 0 : -1)) + 910, android.view.View.getDefaultSize(0, 0) + 18, (char) android.view.View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", android.content.Context.class);
        o.SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0108, code lost:
    
        ((java.lang.reflect.Method) r0).invoke(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x010e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x010f, code lost:
    
        r1 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0113, code lost:
    
        if (r1 != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0115, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0116, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0117, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0118, code lost:
    
        r1 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x011c, code lost:
    
        if (r1 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x011e, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x011f, code lost:
    
        throw r0;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onPause() {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.onPause():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0018, code lost:
    
        if (r0 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0021, code lost:
    
        if (r0 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0023, code lost:
    
        r8 = new java.lang.Object[1];
        b(true, new int[]{23, 26, 122, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, r8);
        r6 = java.lang.Class.forName((java.lang.String) r8[0]);
        r8 = new java.lang.Object[1];
        b(true, new int[]{49, 18, 63, 0}, new byte[]{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, r8);
        r0 = (android.content.Context) r6.getMethod((java.lang.String) r8[0], new java.lang.Class[0]).invoke(null, null);
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onResume() {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.onResume():void");
    }

    public SummaryActivity() {
        try {
            try {
                this._$_findViewCache = new LinkedHashMap();
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.sendmoney.summary.SummaryActivity$isFeedRevamp$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(SummaryActivity.this.getDanaApplication().isFeedRevamp());
                    }
                });
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = "";
                this.BuiltInFictitiousFunctionClassFactory = "";
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
                this.getValueOfTouchPositionAbsolute = "";
                this.isLayoutRequested = "";
                this.PlaceComponentResult = "";
                this.newProxyInstance = "";
                this.FragmentBottomSheetPaymentSettingBinding = new VoucherModel();
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney.summary.SummaryActivity$sendMoneyFeatureTime$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SendMoneyFeatureTime invoke() {
                        return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
                    }
                });
                ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda3
                    @Override // androidx.view.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        SummaryActivity.m2910$r8$lambda$6NtaDtDRYb9A6FIw9OFXY3QQY(SummaryActivity.this, (ActivityResult) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
                this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = registerForActivityResult;
                ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda4
                    @Override // androidx.view.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        SummaryActivity.$r8$lambda$nhRO1w54EFbcUV88XET1embQtkc(SummaryActivity.this, (ActivityResult) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "");
                this.scheduleImpl = registerForActivityResult2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$backToHomepage(SummaryActivity summaryActivity, Bundle bundle) {
        try {
            int i = L + 19;
            P = i % 128;
            boolean z = i % 2 == 0;
            summaryActivity.backToHomepage(bundle);
            if (z) {
                int i2 = 47 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$checkAmountToSent(SummaryActivity summaryActivity, String str) {
        try {
            int i = L + 57;
            P = i % 128;
            int i2 = i % 2;
            summaryActivity.PlaceComponentResult(str);
            int i3 = P + 35;
            L = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$collapsePayMethodView(SummaryActivity summaryActivity) {
        int i = L + 83;
        P = i % 128;
        int i2 = i % 2;
        summaryActivity.BuiltInFictitiousFunctionClassFactory();
        int i3 = P + 121;
        L = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ Bundle access$createSendMoneyBundleData(SummaryActivity summaryActivity) {
        int i = L + 5;
        P = i % 128;
        int i2 = i % 2;
        try {
            Bundle KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            int i3 = L + 107;
            P = i3 % 128;
            if ((i3 % 2 == 0 ? 'Z' : Typography.dollar) != 'Z') {
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            Object obj = null;
            obj.hashCode();
            return KClassImpl$Data$declaredNonStaticMembers$2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ UnitSymbolModel access$createUnitSymbol(SummaryActivity summaryActivity) {
        int i = P + 113;
        L = i % 128;
        int i2 = i % 2;
        UnitSymbolModel scheduleImpl = summaryActivity.scheduleImpl();
        int i3 = P + 75;
        L = i3 % 128;
        if ((i3 % 2 != 0 ? 'Q' : (char) 5) != 5) {
            int i4 = 15 / 0;
            return scheduleImpl;
        }
        return scheduleImpl;
    }

    public static final /* synthetic */ boolean access$getAccountFreeze$p(SummaryActivity summaryActivity) {
        int i = L + 103;
        P = i % 128;
        int i2 = i % 2;
        boolean z = summaryActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = P + 107;
        L = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    public static final /* synthetic */ AlipayConnectInitializer access$getAlipayConnectInitializer$p(SummaryActivity summaryActivity) {
        try {
            int i = L + 99;
            P = i % 128;
            int i2 = i % 2;
            AlipayConnectInitializer alipayConnectInitializer = summaryActivity.MyBillsEntityDataFactory;
            int i3 = P + 25;
            L = i3 % 128;
            if ((i3 % 2 != 0 ? 'P' : '\f') != '\f') {
                Object obj = null;
                obj.hashCode();
                return alipayConnectInitializer;
            }
            return alipayConnectInitializer;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getAmountToSend$p(SummaryActivity summaryActivity) {
        String str;
        int i = L + 95;
        P = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            try {
                str = summaryActivity.PlaceComponentResult;
            } catch (Exception e) {
                throw e;
            }
        } else {
            str = summaryActivity.PlaceComponentResult;
            objArr.hashCode();
        }
        int i2 = P + 3;
        L = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return str;
        }
        int length = objArr.length;
        return str;
    }

    public static final /* synthetic */ boolean access$getBlacklistedAccount$p(SummaryActivity summaryActivity) {
        boolean z;
        int i = L + 109;
        P = i % 128;
        if ((i % 2 == 0 ? 'E' : 'a') != 'a') {
            try {
                z = summaryActivity.lookAheadTest;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            z = summaryActivity.lookAheadTest;
        }
        int i2 = L + 53;
        P = i2 % 128;
        int i3 = i2 % 2;
        return z;
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(SummaryActivity summaryActivity) {
        int i = L + 83;
        P = i % 128;
        if ((i % 2 == 0 ? '4' : 'N') != 'N') {
            BottomSheetBehavior<MaterialCardView> bottomSheetBehavior = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Object obj = null;
            obj.hashCode();
            return bottomSheetBehavior;
        }
        return summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCashierResultLauncher$p(SummaryActivity summaryActivity) {
        int i = L + 25;
        P = i % 128;
        if (!(i % 2 == 0)) {
            try {
                return summaryActivity.scheduleImpl;
            } catch (Exception e) {
                throw e;
            }
        }
        ActivityResultLauncher<Intent> activityResultLauncher = summaryActivity.scheduleImpl;
        Object obj = null;
        obj.hashCode();
        return activityResultLauncher;
    }

    public static final /* synthetic */ ConfirmationModel access$getConfirmationModel$p(SummaryActivity summaryActivity) {
        int i = L + 19;
        P = i % 128;
        char c = i % 2 == 0 ? (char) 31 : (char) 22;
        Object[] objArr = null;
        ConfirmationModel confirmationModel = summaryActivity.getErrorConfigVersion;
        if (c != 22) {
            objArr.hashCode();
        }
        int i2 = P + 69;
        L = i2 % 128;
        if ((i2 % 2 != 0 ? '\b' : (char) 23) != 23) {
            int length = objArr.length;
            return confirmationModel;
        }
        return confirmationModel;
    }

    public static final /* synthetic */ BottomSheetBehavior access$getCustomKeyboardBehavior$p(SummaryActivity summaryActivity) {
        int i = L + 119;
        P = i % 128;
        int i2 = i % 2;
        BottomSheetBehavior<View> bottomSheetBehavior = summaryActivity.moveToNextValue;
        int i3 = L + 107;
        P = i3 % 128;
        int i4 = i3 % 2;
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ FeatureTimeModel access$getFeatureTime(SummaryActivity summaryActivity) {
        int i = L + 1;
        P = i % 128;
        int i2 = i % 2;
        FeatureTimeModel NetworkUserEntityData$$ExternalSyntheticLambda2 = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i3 = L + 31;
        P = i3 % 128;
        int i4 = i3 % 2;
        return NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public static final /* synthetic */ String access$getFreeMinAmount$p(SummaryActivity summaryActivity) {
        try {
            int i = P + 109;
            try {
                L = i % 128;
                int i2 = i % 2;
                String str = summaryActivity.newProxyInstance;
                int i3 = P + 71;
                L = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ String access$getOriginPayMethod$p(SummaryActivity summaryActivity) {
        int i = P + 37;
        L = i % 128;
        int i2 = i % 2;
        try {
            String str = summaryActivity.isLayoutRequested;
            int i3 = P + 99;
            L = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getRecipientDestinationType(SummaryActivity summaryActivity) {
        int i = L + 45;
        P = i % 128;
        char c = i % 2 == 0 ? '*' : (char) 30;
        String GetContactSyncConfig = summaryActivity.GetContactSyncConfig();
        if (c == '*') {
            Object obj = null;
            obj.hashCode();
        }
        return GetContactSyncConfig;
    }

    public static final /* synthetic */ RecipientModel access$getRecipientModel$p(SummaryActivity summaryActivity) {
        int i = L + 33;
        P = i % 128;
        int i2 = i % 2;
        RecipientModel recipientModel = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i3 = P + 73;
        L = i3 % 128;
        int i4 = i3 % 2;
        return recipientModel;
    }

    public static final /* synthetic */ String access$getRemarks$p(SummaryActivity summaryActivity) {
        try {
            int i = L + 113;
            try {
                P = i % 128;
                int i2 = i % 2;
                String str = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda4;
                int i3 = P + 83;
                L = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ VoucherModel access$getSelectedVoucher$p(SummaryActivity summaryActivity) {
        try {
            int i = L + 67;
            P = i % 128;
            int i2 = i % 2;
            try {
                VoucherModel voucherModel = summaryActivity.FragmentBottomSheetPaymentSettingBinding;
                int i3 = P + 125;
                L = i3 % 128;
                int i4 = i3 % 2;
                return voucherModel;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(SummaryActivity summaryActivity) {
        int i = L + 37;
        P = i % 128;
        int i2 = i % 2;
        SendMoneyFeatureTime NetworkUserEntityData$$ExternalSyntheticLambda7 = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda7();
        try {
            int i3 = L + 97;
            P = i3 % 128;
            int i4 = i3 % 2;
            return NetworkUserEntityData$$ExternalSyntheticLambda7;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ SendMoneySummary access$getSendMoneySummary$p(SummaryActivity summaryActivity) {
        int i = L + 51;
        P = i % 128;
        char c = i % 2 == 0 ? '0' : '.';
        SendMoneySummary sendMoneySummary = summaryActivity.SubSequence;
        if (c != '.') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = L + 41;
        P = i2 % 128;
        if ((i2 % 2 == 0 ? '!' : (char) 21) != '!') {
            return sendMoneySummary;
        }
        int i3 = 21 / 0;
        return sendMoneySummary;
    }

    public static final /* synthetic */ SmartFrictionConfig access$getSmartFrictionConfig$p(SummaryActivity summaryActivity) {
        int i = P + 33;
        L = i % 128;
        if (!(i % 2 != 0)) {
            try {
                return summaryActivity.whenAvailable;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            SmartFrictionConfig smartFrictionConfig = summaryActivity.whenAvailable;
            Object obj = null;
            obj.hashCode();
            return smartFrictionConfig;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$getStateShareFeed(SummaryActivity summaryActivity) {
        int i = L + 79;
        P = i % 128;
        char c = i % 2 == 0 ? (char) 6 : JSONLexer.EOI;
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda8();
        if (c == 6) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = P + 73;
        L = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ String access$getSummaryVersion(SummaryActivity summaryActivity, List list) {
        int i = P + 57;
        L = i % 128;
        int i2 = i % 2;
        String PlaceComponentResult2 = summaryActivity.PlaceComponentResult(list);
        int i3 = L + 25;
        P = i3 % 128;
        int i4 = i3 % 2;
        return PlaceComponentResult2;
    }

    public static final /* synthetic */ String access$getSummaryVersion$p(SummaryActivity summaryActivity) {
        int i = P + 125;
        L = i % 128;
        if (!(i % 2 != 0)) {
            return summaryActivity.VerifyPinStateManager$executeRiskChallenge$2$1;
        }
        try {
            String str = summaryActivity.VerifyPinStateManager$executeRiskChallenge$2$1;
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ SummaryViewState access$getSummaryViewState$p(SummaryActivity summaryActivity) {
        SummaryViewState summaryViewState;
        int i = P + 123;
        L = i % 128;
        if ((i % 2 != 0 ? (char) 22 : '`') != 22) {
            summaryViewState = summaryActivity.BottomSheetCardBindingView$watcherCardNumberView$1;
        } else {
            try {
                summaryViewState = summaryActivity.BottomSheetCardBindingView$watcherCardNumberView$1;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = L + 23;
        P = i2 % 128;
        int i3 = i2 % 2;
        return summaryViewState;
    }

    public static final /* synthetic */ CurrencyAmountModel access$getTransferMinAmount$p(SummaryActivity summaryActivity) {
        int i = P + 63;
        L = i % 128;
        int i2 = i % 2;
        try {
            CurrencyAmountModel currencyAmountModel = summaryActivity.E;
            int i3 = P + 123;
            L = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return currencyAmountModel;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return currencyAmountModel;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getTransferScenario$p(SummaryActivity summaryActivity) {
        int i = L + 17;
        P = i % 128;
        int i2 = i % 2;
        String str = summaryActivity.getValueOfTouchPositionAbsolute;
        int i3 = L + 95;
        P = i3 % 128;
        if ((i3 % 2 == 0 ? 'J' : (char) 22) != 22) {
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return str;
    }

    public static final /* synthetic */ boolean access$getVoucherEnable$p(SummaryActivity summaryActivity) {
        int i = L + 47;
        P = i % 128;
        int i2 = i % 2;
        boolean z = summaryActivity.VerifyPinStateManager$executeRiskChallenge$2$2;
        int i3 = L + 105;
        P = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 25 : (char) 29) != 25) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        return z;
    }

    public static final /* synthetic */ WithdrawOTCModel access$getWithdrawOTCModel$p(SummaryActivity summaryActivity) {
        WithdrawOTCModel withdrawOTCModel;
        try {
            int i = P + 45;
            L = i % 128;
            if ((i % 2 != 0 ? '\n' : '2') != '\n') {
                withdrawOTCModel = summaryActivity.getOnBoardingScenario;
            } else {
                withdrawOTCModel = summaryActivity.getOnBoardingScenario;
                int i2 = 93 / 0;
            }
            int i3 = L + 79;
            P = i3 % 128;
            int i4 = i3 % 2;
            return withdrawOTCModel;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$handleAccountFreezeSmartFriction(SummaryActivity summaryActivity) {
        try {
            int i = L + 85;
            try {
                P = i % 128;
                if ((i % 2 == 0 ? (char) 22 : 'R') != 'R') {
                    summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$handleBlacklistAccountSmartFriction(SummaryActivity summaryActivity) {
        int i = P + 111;
        L = i % 128;
        boolean z = i % 2 == 0;
        summaryActivity.FragmentBottomSheetPaymentSettingBinding();
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = L + 89;
        P = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        int i3 = 78 / 0;
    }

    public static final /* synthetic */ void access$handleSendMoneySubmit(SummaryActivity summaryActivity) {
        int i = L + 121;
        P = i % 128;
        if (i % 2 != 0) {
            summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda3();
        } else {
            summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda3();
            Object obj = null;
            obj.hashCode();
        }
        int i2 = P + 93;
        L = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void access$handleSmartFrictionSuspiciousAccount(SummaryActivity summaryActivity) {
        int i = L + 93;
        P = i % 128;
        char c = i % 2 == 0 ? Typography.amp : (char) 18;
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda4();
        if (c != 18) {
            int i2 = 2 / 0;
        }
    }

    public static final /* synthetic */ void access$hideShimmer(SummaryActivity summaryActivity) {
        try {
            int i = P + 83;
            try {
                L = i % 128;
                char c = i % 2 != 0 ? '_' : '1';
                Object[] objArr = null;
                summaryActivity.SubSequence();
                if (c != '1') {
                    int length = objArr.length;
                }
                int i2 = L + 75;
                P = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    return;
                }
                int length2 = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$initSendToLinkSummary(SummaryActivity summaryActivity) {
        try {
            int i = L + 43;
            P = i % 128;
            int i2 = i % 2;
            summaryActivity.C();
            int i3 = L + 17;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$initSummaryView(SummaryActivity summaryActivity, String str) {
        int i = L + 83;
        P = i % 128;
        int i2 = i % 2;
        summaryActivity.BuiltInFictitiousFunctionClassFactory(str);
        int i3 = L + 23;
        P = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ boolean access$isAlreadyShowSmartFriction$p(SummaryActivity summaryActivity) {
        boolean z;
        try {
            int i = P + 39;
            L = i % 128;
            if ((i % 2 != 0 ? ',' : '@') != '@') {
                try {
                    z = summaryActivity.PrepareContext;
                    int i2 = 58 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                z = summaryActivity.PrepareContext;
            }
            int i3 = L + 71;
            P = i3 % 128;
            if ((i3 % 2 == 0 ? 'I' : '#') != '#') {
                Object[] objArr = null;
                int length = objArr.length;
                return z;
            }
            return z;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ boolean access$isCashierEnable(SummaryActivity summaryActivity) {
        int i = L + 47;
        P = i % 128;
        boolean z = i % 2 != 0;
        Object obj = null;
        boolean VerifyPinStateManager$executeRiskChallenge$2$2 = summaryActivity.VerifyPinStateManager$executeRiskChallenge$2$2();
        if (!z) {
            obj.hashCode();
        }
        try {
            int i2 = P + 99;
            L = i2 % 128;
            if (i2 % 2 == 0) {
                return VerifyPinStateManager$executeRiskChallenge$2$2;
            }
            obj.hashCode();
            return VerifyPinStateManager$executeRiskChallenge$2$2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean access$isFeedRevamp(SummaryActivity summaryActivity) {
        try {
            int i = P + 51;
            L = i % 128;
            char c = i % 2 != 0 ? '`' : 'O';
            boolean onBoardingScenario = summaryActivity.getOnBoardingScenario();
            if (c != 'O') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = P + 31;
            L = i2 % 128;
            if (!(i2 % 2 == 0)) {
                int i3 = 47 / 0;
                return onBoardingScenario;
            }
            return onBoardingScenario;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean access$isFreeTransferAvailable(SummaryActivity summaryActivity) {
        int i = L + 15;
        P = i % 128;
        int i2 = i % 2;
        boolean E = summaryActivity.E();
        int i3 = P + 123;
        L = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.greater : '\'') != '\'') {
            Object obj = null;
            obj.hashCode();
            return E;
        }
        return E;
    }

    public static final /* synthetic */ boolean access$isNeedToShowUnregisteredUserNotes(SummaryActivity summaryActivity) {
        boolean F;
        try {
            int i = L + 123;
            P = i % 128;
            if (i % 2 == 0) {
                F = summaryActivity.F();
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                F = summaryActivity.F();
            }
            int i2 = L + 113;
            P = i2 % 128;
            int i3 = i2 % 2;
            return F;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean access$isShareFeedFeatureEnabled$p(SummaryActivity summaryActivity) {
        int i = P + 63;
        L = i % 128;
        char c = i % 2 != 0 ? (char) 14 : 'H';
        boolean z = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (c != 'H') {
            Object obj = null;
            obj.hashCode();
        }
        return z;
    }

    public static final /* synthetic */ void access$measureViewHeight(SummaryActivity summaryActivity) {
        int i = L + 43;
        P = i % 128;
        char c = i % 2 == 0 ? '0' : (char) 22;
        summaryActivity.AppCompatEmojiTextHelper();
        if (c != '0') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void access$onAmountValidAndActionConfirmed(SummaryActivity summaryActivity) {
        int i = L + 15;
        P = i % 128;
        boolean z = i % 2 == 0;
        summaryActivity.G();
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = P + 67;
        L = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void access$removeAmountEditTextFocus(SummaryActivity summaryActivity) {
        try {
            int i = P + 121;
            try {
                L = i % 128;
                int i2 = i % 2;
                summaryActivity.J();
                int i3 = L + 23;
                P = i3 % 128;
                if ((i3 % 2 == 0 ? 'G' : '6') != 'G') {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setAcceptTimeoutUnit$p(SummaryActivity summaryActivity, String str) {
        try {
            int i = P + 75;
            L = i % 128;
            if (i % 2 == 0) {
                summaryActivity.BuiltInFictitiousFunctionClassFactory = str;
            } else {
                summaryActivity.BuiltInFictitiousFunctionClassFactory = str;
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = P + 15;
            L = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setAmount$p(SummaryActivity summaryActivity, Amount amount) {
        int i = P + 9;
        L = i % 128;
        int i2 = i % 2;
        summaryActivity.getAuthRequestContext = amount;
        try {
            int i3 = P + 113;
            L = i3 % 128;
            if ((i3 % 2 != 0 ? '[' : InputCardNumberView.DIVIDER) != '[') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setAmountToSend$p(SummaryActivity summaryActivity, String str) {
        int i = L + 81;
        P = i % 128;
        if ((i % 2 == 0 ? (char) 16 : 'S') == 'S') {
            summaryActivity.PlaceComponentResult = str;
            return;
        }
        try {
            summaryActivity.PlaceComponentResult = str;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setBottomsheetCashier(SummaryActivity summaryActivity, String str) {
        int i = L + 61;
        P = i % 128;
        if ((i % 2 == 0 ? (char) 16 : 'B') != 16) {
            summaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(str);
        } else {
            summaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(str);
            Object obj = null;
            obj.hashCode();
        }
        int i2 = P + 63;
        L = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void access$setConfirmationModel$p(SummaryActivity summaryActivity, ConfirmationModel confirmationModel) {
        int i = P + 63;
        L = i % 128;
        if (!(i % 2 == 0)) {
            summaryActivity.getErrorConfigVersion = confirmationModel;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            summaryActivity.getErrorConfigVersion = confirmationModel;
        }
        try {
            int i2 = P + 59;
            L = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setConfirmationTransferMethod(SummaryActivity summaryActivity, ConfirmationModel confirmationModel) {
        int i = P + 97;
        L = i % 128;
        int i2 = i % 2;
        summaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(confirmationModel);
        int i3 = L + 95;
        P = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setExpiryTime$p(SummaryActivity summaryActivity, String str) {
        int i = P + 25;
        L = i % 128;
        if (!(i % 2 != 0)) {
            try {
                summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
            int i2 = 87 / 0;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setExpiryTimeConfigList$p(SummaryActivity summaryActivity, List list) {
        int i = P + 39;
        L = i % 128;
        int i2 = i % 2;
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = list;
        try {
            int i3 = P + 79;
            L = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setFreeMinAmount$p(SummaryActivity summaryActivity, String str) {
        int i = L + 45;
        P = i % 128;
        if (i % 2 == 0) {
            try {
                summaryActivity.newProxyInstance = str;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            summaryActivity.newProxyInstance = str;
        }
        int i2 = P + 69;
        L = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ String access$setOrderTitleCashierFromSummary(SummaryActivity summaryActivity) {
        int i = P + 111;
        L = i % 128;
        int i2 = i % 2;
        String K2 = summaryActivity.K();
        try {
            int i3 = P + 81;
            L = i3 % 128;
            if ((i3 % 2 != 0 ? 'E' : Typography.dollar) != 'E') {
                return K2;
            }
            int i4 = 73 / 0;
            return K2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setOriginPayMethod$p(SummaryActivity summaryActivity, String str) {
        int i = L + 33;
        P = i % 128;
        int i2 = i % 2;
        try {
            summaryActivity.isLayoutRequested = str;
            int i3 = L + 19;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setRecipientModel$p(SummaryActivity summaryActivity, RecipientModel recipientModel) {
        int i = L + 81;
        P = i % 128;
        boolean z = i % 2 == 0;
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda6 = recipientModel;
        if (!z) {
            return;
        }
        int i2 = 57 / 0;
    }

    public static final /* synthetic */ void access$setRemarks(SummaryActivity summaryActivity, String str) {
        int i = L + 47;
        P = i % 128;
        int i2 = i % 2;
        summaryActivity.getAuthRequestContext(str);
        try {
            int i3 = P + 9;
            L = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setSelectedVoucher$p(SummaryActivity summaryActivity, VoucherModel voucherModel) {
        try {
            int i = L + 69;
            P = i % 128;
            int i2 = i % 2;
            summaryActivity.FragmentBottomSheetPaymentSettingBinding = voucherModel;
            int i3 = L + 89;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setSendMoneyConfirm$p(SummaryActivity summaryActivity, SendMoneyConfirm sendMoneyConfirm) {
        int i = L + 43;
        P = i % 128;
        char c = i % 2 == 0 ? 'D' : '*';
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = sendMoneyConfirm;
        if (c == 'D') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = L + 27;
        P = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        int i3 = 37 / 0;
    }

    public static final /* synthetic */ void access$setShareFeedFeatureEnabled$p(SummaryActivity summaryActivity, boolean z) {
        int i = L + 79;
        P = i % 128;
        char c = i % 2 == 0 ? (char) 15 : '6';
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = z;
        if (c != '6') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$setSmartFrictionConfig$p(SummaryActivity summaryActivity, SmartFrictionConfig smartFrictionConfig) {
        int i = L + 87;
        P = i % 128;
        char c = i % 2 == 0 ? ':' : ',';
        summaryActivity.whenAvailable = smartFrictionConfig;
        if (c != ':') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void access$setStateCheckboxShareFeed(SummaryActivity summaryActivity, String str) {
        int i = L + 1;
        P = i % 128;
        int i2 = i % 2;
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0(str);
        int i3 = P + 9;
        L = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.quote : '\t') != '\"') {
            return;
        }
        int i4 = 52 / 0;
    }

    public static final /* synthetic */ void access$setSummaryVersion$p(SummaryActivity summaryActivity, String str) {
        int i = P + 59;
        L = i % 128;
        int i2 = i % 2;
        summaryActivity.VerifyPinStateManager$executeRiskChallenge$2$1 = str;
        int i3 = P + 23;
        L = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$setVoucherEnable$p(SummaryActivity summaryActivity, boolean z) {
        try {
            int i = L + 19;
            P = i % 128;
            int i2 = i % 2;
            summaryActivity.VerifyPinStateManager$executeRiskChallenge$2$2 = z;
            int i3 = L + 103;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$showChargeFeeAmount(SummaryActivity summaryActivity, String str) {
        int i = P + 75;
        L = i % 128;
        boolean z = i % 2 != 0;
        Object obj = null;
        summaryActivity.getErrorConfigVersion(str);
        if (z) {
            obj.hashCode();
        }
        int i2 = P + 119;
        L = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 17 : '4') != 17) {
            return;
        }
        obj.hashCode();
    }

    public static final /* synthetic */ void access$showPaymentStickyAmountWarningMessage(SummaryActivity summaryActivity, String str, String str2) {
        int i = P + 109;
        L = i % 128;
        Object[] objArr = null;
        if (!(i % 2 != 0)) {
            summaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        } else {
            summaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
            int length = objArr.length;
        }
        int i2 = P + 19;
        L = i2 % 128;
        if ((i2 % 2 != 0 ? 'T' : '*') != '*') {
            int length2 = objArr.length;
        }
    }

    public static final /* synthetic */ void access$updateBottomSheetStickyHeader(SummaryActivity summaryActivity, boolean z) {
        int i = P + 67;
        L = i % 128;
        boolean z2 = i % 2 != 0;
        Object[] objArr = null;
        summaryActivity.PlaceComponentResult(z);
        if (z2) {
            int length = objArr.length;
        }
        int i2 = L + 9;
        P = i2 % 128;
        if ((i2 % 2 == 0 ? 'E' : '*') != '*') {
            objArr.hashCode();
        }
    }

    public static final /* synthetic */ void access$updateBottomSheetSummaryPeekHeight(SummaryActivity summaryActivity) {
        int i = P + 19;
        L = i % 128;
        int i2 = i % 2;
        summaryActivity.O();
        int i3 = L + 119;
        P = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void access$updateSelectedExpiredDuration(SummaryActivity summaryActivity) {
        try {
            int i = P + 21;
            L = i % 128;
            boolean z = i % 2 != 0;
            summaryActivity.P();
            if (z) {
                int i2 = 82 / 0;
            }
            int i3 = P + 101;
            L = i3 % 128;
            if (i3 % 2 == 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$updateSelectedExpiryTime(SummaryActivity summaryActivity, int i) {
        try {
            int i2 = P + 23;
            L = i2 % 128;
            int i3 = i2 % 2;
            summaryActivity.PlaceComponentResult(i);
            int i4 = L + 3;
            P = i4 % 128;
            if (!(i4 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0021, code lost:
    
        if ((r0 != null ? 2 : '1') != '1') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x002a, code lost:
    
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x002c, code lost:
    
        r5 = id.dana.sendmoney.summary.SummaryActivity.L + 117;
        id.dana.sendmoney.summary.SummaryActivity.P = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0035, code lost:
    
        if ((r5 % 2) != 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0038, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0039, code lost:
    
        if (r2 == true) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x003b, code lost:
    
        r1 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x003c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x003f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0040, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0045, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0046, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0047, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getSendMoneySummaryPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter getSendMoneySummaryPresenter() {
        /*
            r7 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 39
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r4 = 0
            if (r0 == r3) goto L28
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r0 = r7.sendMoneySummaryPresenter     // Catch: java.lang.Exception -> L26
            r5 = 87
            int r5 = r5 / r2
            r5 = 49
            if (r0 == 0) goto L1f
            r6 = 2
            goto L21
        L1f:
            r6 = 49
        L21:
            if (r6 == r5) goto L40
            goto L2c
        L24:
            r0 = move-exception
            throw r0
        L26:
            r0 = move-exception
            throw r0
        L28:
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r0 = r7.sendMoneySummaryPresenter
            if (r0 == 0) goto L40
        L2c:
            int r5 = id.dana.sendmoney.summary.SummaryActivity.L
            int r5 = r5 + 117
            int r6 = r5 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r6
            int r5 = r5 % r1
            if (r5 != 0) goto L38
            goto L39
        L38:
            r2 = 1
        L39:
            if (r2 == r3) goto L3f
            int r1 = r4.length     // Catch: java.lang.Throwable -> L3d
            return r0
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            return r0
        L40:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L46
            return r4
        L46:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getSendMoneySummaryPresenter():id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter");
    }

    @JvmName(name = "setSendMoneySummaryPresenter")
    public final void setSendMoneySummaryPresenter(SendMoneySummaryContract.Presenter presenter) {
        int i = L + 95;
        P = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.sendMoneySummaryPresenter = presenter;
            return;
        }
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendMoneySummaryPresenter = presenter;
        int i2 = 9 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0018, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x001f, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0023, code lost:
    
        r4 = id.dana.sendmoney.summary.SummaryActivity.P + 37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0027, code lost:
    
        id.dana.sendmoney.summary.SummaryActivity.L = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x002a, code lost:
    
        if ((r4 % 2) == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x002d, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x002e, code lost:
    
        if (r1 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0030, code lost:
    
        r2 = 2 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0031, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0034, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0035, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x003a, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 119;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0043, code lost:
    
        if ((r0 % 2) == 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0045, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0046, code lost:
    
        if (r3 == true) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0048, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0049, code lost:
    
        r0 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x004a, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getSendMoneyConfirmationPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.Presenter getSendMoneyConfirmationPresenter() {
        /*
            r6 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r2
            r2 = 2
            int r0 = r0 % r2
            r3 = 0
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            r4 = 0
            if (r0 == r1) goto L1d
            id.dana.sendmoney.confirmation.SendMoneyConfirmationContract$Presenter r0 = r6.sendMoneyConfirmationPresenter
            r4.hashCode()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L35
            goto L21
        L1b:
            r0 = move-exception
            throw r0
        L1d:
            id.dana.sendmoney.confirmation.SendMoneyConfirmationContract$Presenter r0 = r6.sendMoneyConfirmationPresenter
            if (r0 == 0) goto L35
        L21:
            int r4 = id.dana.sendmoney.summary.SummaryActivity.P     // Catch: java.lang.Exception -> L4d
            int r4 = r4 + 37
            int r5 = r4 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r5     // Catch: java.lang.Exception -> L4d
            int r4 = r4 % r2
            if (r4 == 0) goto L2d
            goto L2e
        L2d:
            r1 = 0
        L2e:
            if (r1 == 0) goto L34
            int r2 = r2 / r3
            return r0
        L32:
            r0 = move-exception
            throw r0
        L34:
            return r0
        L35:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L4d
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 119
            int r5 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r5
            int r0 = r0 % r2
            if (r0 == 0) goto L46
            r3 = 1
        L46:
            if (r3 == r1) goto L49
            return r4
        L49:
            int r0 = r4.length     // Catch: java.lang.Throwable -> L4b
            return r4
        L4b:
            r0 = move-exception
            throw r0
        L4d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getSendMoneyConfirmationPresenter():id.dana.sendmoney.confirmation.SendMoneyConfirmationContract$Presenter");
    }

    @JvmName(name = "setSendMoneyConfirmationPresenter")
    public final void setSendMoneyConfirmationPresenter(SendMoneyConfirmationContract.Presenter presenter) {
        int i = L + 15;
        P = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.sendMoneyConfirmationPresenter = presenter;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.sendMoneyConfirmationPresenter = presenter;
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = P + 9;
            L = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0018, code lost:
    
        if (r0 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0025, code lost:
    
        if ((r0 != null) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0027, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0028, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 89;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0037, code lost:
    
        if ((r0 % 2) != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0039, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x003c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003f, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getSendMoneyConfirmationBankPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract.Presenter getSendMoneyConfirmationBankPresenter() {
        /*
            r3 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 103
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r1 = 79
            if (r0 != 0) goto L11
            r0 = 79
            goto L13
        L11:
            r0 = 31
        L13:
            r2 = 0
            if (r0 == r1) goto L1b
            id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract$Presenter r0 = r3.sendMoneyConfirmationBankPresenter
            if (r0 == 0) goto L28
            goto L27
        L1b:
            id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract$Presenter r0 = r3.sendMoneyConfirmationBankPresenter
            r2.hashCode()     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L24
            r1 = 1
            goto L25
        L24:
            r1 = 0
        L25:
            if (r1 == 0) goto L28
        L27:
            return r0
        L28:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3f
            r2.hashCode()     // Catch: java.lang.Throwable -> L3d
            return r2
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            return r2
        L40:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getSendMoneyConfirmationBankPresenter():id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract$Presenter");
    }

    @JvmName(name = "setSendMoneyConfirmationBankPresenter")
    public final void setSendMoneyConfirmationBankPresenter(SendMoneyConfirmationBankContract.Presenter presenter) {
        int i = P + 55;
        L = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.sendMoneyConfirmationBankPresenter = presenter;
            return;
        }
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendMoneyConfirmationBankPresenter = presenter;
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0015, code lost:
    
        if ((r0 != null) != true) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0020, code lost:
    
        if ((r0 == null) != true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0022, code lost:
    
        r1 = id.dana.sendmoney.summary.SummaryActivity.P + 9;
        id.dana.sendmoney.summary.SummaryActivity.L = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x002e, code lost:
    
        if ((r1 % 2) == 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0030, code lost:
    
        r1 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0033, code lost:
    
        r1 = 'S';
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0035, code lost:
    
        if (r1 == 'S') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0037, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003e, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0043, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getExpiryPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.sendmoney.ExpiryContract.Presenter getExpiryPresenter() {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            id.dana.contract.sendmoney.ExpiryContract$Presenter r0 = r5.expiryPresenter
            int r4 = r2.length     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L15
            r1 = 1
        L15:
            if (r1 == r3) goto L22
            goto L3e
        L18:
            r0 = move-exception
            throw r0
        L1a:
            id.dana.contract.sendmoney.ExpiryContract$Presenter r0 = r5.expiryPresenter
            if (r0 == 0) goto L1f
            goto L20
        L1f:
            r1 = 1
        L20:
            if (r1 == r3) goto L3e
        L22:
            int r1 = id.dana.sendmoney.summary.SummaryActivity.P
            int r1 = r1 + 9
            int r3 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r3
            int r1 = r1 % 2
            r3 = 83
            if (r1 == 0) goto L33
            r1 = 33
            goto L35
        L33:
            r1 = 83
        L35:
            if (r1 == r3) goto L3d
            r2.hashCode()     // Catch: java.lang.Throwable -> L3b
            return r0
        L3b:
            r0 = move-exception
            throw r0
        L3d:
            return r0
        L3e:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getExpiryPresenter():id.dana.contract.sendmoney.ExpiryContract$Presenter");
    }

    @JvmName(name = "setExpiryPresenter")
    public final void setExpiryPresenter(ExpiryContract.Presenter presenter) {
        int i = L + 19;
        P = i % 128;
        if ((i % 2 == 0 ? '\r' : '_') != '_') {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.expiryPresenter = presenter;
            int i2 = 66 / 0;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.expiryPresenter = presenter;
        }
        int i3 = L + 45;
        P = i3 % 128;
        if ((i3 % 2 != 0 ? 'X' : '-') != 'X') {
            int i4 = 30 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x001b, code lost:
    
        if ((r0 != null ? '1' : '(') != '(') goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0027, code lost:
    
        if ((r0 == null) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0029, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x002e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x002f, code lost:
    
        r4 = id.dana.sendmoney.summary.SummaryActivity.L + 95;
        id.dana.sendmoney.summary.SummaryActivity.P = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0039, code lost:
    
        if ((r4 % 2) != 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x003c, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x003d, code lost:
    
        if (r1 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x003f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0040, code lost:
    
        r1 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0041, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getShareToFeedsPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.social.contract.share.ShareToFeedsContract.Presenter getShareToFeedsPresenter() {
        /*
            r6 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P     // Catch: java.lang.Exception -> L46
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1     // Catch: java.lang.Exception -> L44
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L20
            id.dana.social.contract.share.ShareToFeedsContract$Presenter r0 = r6.shareToFeedsPresenter
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1e
            r4 = 40
            if (r0 == 0) goto L19
            r5 = 49
            goto L1b
        L19:
            r5 = 40
        L1b:
            if (r5 == r4) goto L29
            goto L2f
        L1e:
            r0 = move-exception
            throw r0
        L20:
            id.dana.social.contract.share.ShareToFeedsContract$Presenter r0 = r6.shareToFeedsPresenter
            if (r0 == 0) goto L26
            r4 = 0
            goto L27
        L26:
            r4 = 1
        L27:
            if (r4 == 0) goto L2f
        L29:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r3
        L2f:
            int r4 = id.dana.sendmoney.summary.SummaryActivity.L
            int r4 = r4 + 95
            int r5 = r4 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L3c
            goto L3d
        L3c:
            r1 = 1
        L3d:
            if (r1 == 0) goto L40
            return r0
        L40:
            int r1 = r3.length     // Catch: java.lang.Throwable -> L42
            return r0
        L42:
            r0 = move-exception
            throw r0
        L44:
            r0 = move-exception
            throw r0
        L46:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getShareToFeedsPresenter():id.dana.social.contract.share.ShareToFeedsContract$Presenter");
    }

    @JvmName(name = "setShareToFeedsPresenter")
    public final void setShareToFeedsPresenter(ShareToFeedsContract.Presenter presenter) {
        try {
            int i = L + 83;
            try {
                P = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(presenter, "");
                this.shareToFeedsPresenter = presenter;
                int i3 = P + 79;
                L = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getSendMoneyAnalyticalTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticalTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticalTracker;
        if ((sendMoneyAnalyticTracker != null ? 'M' : 'W') == 'W') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i = L + 39;
        P = i % 128;
        if ((i % 2 == 0 ? 'L' : '(') != '(') {
            int i2 = 48 / 0;
        }
        int i3 = P + 71;
        L = i3 % 128;
        int i4 = i3 % 2;
        return sendMoneyAnalyticTracker;
    }

    @JvmName(name = "setSendMoneyAnalyticalTracker")
    public final void setSendMoneyAnalyticalTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        int i = P + 3;
        L = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
        try {
            int i3 = L + 3;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        int i = L + 75;
        P = i % 128;
        int i2 = i % 2;
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            int i3 = L + 93;
            P = i3 % 128;
            int i4 = i3 % 2;
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i5 = P + 63;
        L = i5 % 128;
        Object[] objArr = null;
        if ((i5 % 2 != 0 ? '%' : Typography.quote) != '\"') {
            int length = objArr.length;
            return null;
        }
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        int i = L + 43;
        P = i % 128;
        if ((i % 2 == 0 ? (char) 17 : (char) 24) != 17) {
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
        } else {
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = P + 1;
            L = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getOnBoardingScenario")
    private final boolean getOnBoardingScenario() {
        int i = P + 117;
        L = i % 128;
        int i2 = i % 2;
        boolean booleanValue = ((Boolean) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).booleanValue();
        int i3 = P + 19;
        L = i3 % 128;
        if ((i3 % 2 != 0 ? '*' : (char) 25) != '*') {
            return booleanValue;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return booleanValue;
    }

    @JvmName(name = "getPayMethodModel")
    public final PayMethodModel getPayMethodModel() {
        int i = P + 7;
        L = i % 128;
        if ((i % 2 != 0 ? (char) 6 : (char) 30) != 30) {
            PayMethodModel payMethodModel = this.payMethodModel;
            Object obj = null;
            obj.hashCode();
            return payMethodModel;
        }
        return this.payMethodModel;
    }

    @JvmName(name = "getAuthRequestContext")
    private final void getAuthRequestContext(String str) {
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str;
            NewShareToFeedsView newShareToFeedsView = (NewShareToFeedsView) _$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
            if ((newShareToFeedsView != null ? (char) 17 : '_') != 17) {
                return;
            }
            if (getOnBoardingScenario()) {
                int i = L + 23;
                P = i % 128;
                int i2 = i % 2;
                newShareToFeedsView.setCaption(str);
                int i3 = P + 15;
                L = i3 % 128;
                if (i3 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                return;
            }
            moveToNextValue(str);
            int i4 = L + 43;
            P = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda7")
    private final SendMoneyFeatureTime NetworkUserEntityData$$ExternalSyntheticLambda7() {
        int i = P + 55;
        L = i % 128;
        if ((i % 2 != 0 ? '#' : ':') != '#') {
            return (SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue();
        }
        int i2 = 73 / 0;
        return (SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue();
    }

    @JvmName(name = "getSendMoneySummaryFactory")
    public final SendMoneySummaryFactory getSendMoneySummaryFactory() {
        int i = L + 113;
        P = i % 128;
        int i2 = i % 2;
        SendMoneySummaryFactory sendMoneySummaryFactory = this.sendMoneySummaryFactory;
        if (sendMoneySummaryFactory != null) {
            int i3 = L + 45;
            P = i3 % 128;
            int i4 = i3 % 2;
            return sendMoneySummaryFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i5 = L + 51;
        P = i5 % 128;
        boolean z = i5 % 2 != 0;
        Object obj = null;
        if (z) {
            return null;
        }
        obj.hashCode();
        return null;
    }

    @JvmName(name = "setSendMoneySummaryFactory")
    public final void setSendMoneySummaryFactory(SendMoneySummaryFactory sendMoneySummaryFactory) {
        int i = L + 9;
        P = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(sendMoneySummaryFactory, "");
            this.sendMoneySummaryFactory = sendMoneySummaryFactory;
            int i3 = L + 11;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        int i = L + 9;
        P = i % 128;
        int i2 = i % 2;
        setMenuLeftButton(R.drawable.btn_arrow_left);
        int i3 = L + 85;
        P = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        AlipayConnectInitializer alipayConnectInitializer = getDanaApplication().getAlipayConnectInitializer();
        Intrinsics.checkNotNullExpressionValue(alipayConnectInitializer, "");
        this.MyBillsEntityDataFactory = alipayConnectInitializer;
        I();
        BottomSheetCardBindingView$watcherCardNumberView$1();
        A();
        SendMoneySummary sendMoneySummary = this.SubSequence;
        if (sendMoneySummary == null) {
            int i = P + 61;
            L = i % 128;
            int i2 = i % 2;
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                sendMoneySummary = null;
                int i3 = P + 125;
                L = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        setCenterTitle(getString(sendMoneySummary.getAuthRequestContext()));
        getSupportButtonTintMode();
        getCallingPid();
        VerifyPinStateManager$executeRiskChallenge$2$1();
        getValueOfTouchPositionAbsolute();
        D();
        B();
        DatabaseTableConfigUtil();
        M();
        DanaApplication danaApplication = getDanaApplication();
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
        int i5 = P + 35;
        L = i5 % 128;
        int i6 = i5 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0074, code lost:
    
        if ((r4 > 99999 ? 27 : 'W') != 27) goto L182;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r18) {
        /*
            Method dump skipped, instructions count: 1273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.onCreate(android.os.Bundle):void");
    }

    private final void M() {
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney.summary.SummaryActivity$setOnBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                BottomSheetBehavior access$getBottomSheetBehavior$p = SummaryActivity.access$getBottomSheetBehavior$p(SummaryActivity.this);
                if (!(access$getBottomSheetBehavior$p != null && access$getBottomSheetBehavior$p.getState() == 4)) {
                    BottomSheetBehavior access$getBottomSheetBehavior$p2 = SummaryActivity.access$getBottomSheetBehavior$p(SummaryActivity.this);
                    if (access$getBottomSheetBehavior$p2 != null) {
                        access$getBottomSheetBehavior$p2.setState(4);
                    }
                } else {
                    BottomSheetBehavior access$getCustomKeyboardBehavior$p = SummaryActivity.access$getCustomKeyboardBehavior$p(SummaryActivity.this);
                    if (access$getCustomKeyboardBehavior$p != null && access$getCustomKeyboardBehavior$p.getState() == 3) {
                        SummaryActivity.this.setCustomKeyboardVisibility(false);
                    } else {
                        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryActivity.access$getSendMoneyFeatureTime(SummaryActivity.this);
                        access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN SUMMARY PAGE");
                        access$getSendMoneyFeatureTime.getAuthRequestContext.remove("SUBMIT ON SUMMARY PAGE");
                        access$getSendMoneyFeatureTime.getAuthRequestContext.remove("INIT ON SEARCH SELECTION");
                        access$getSendMoneyFeatureTime.getAuthRequestContext.remove("INIT ON CONTACT PAGE SELECTION");
                        access$getSendMoneyFeatureTime.getAuthRequestContext.remove("SCANNER READY");
                        access$getSendMoneyFeatureTime.getAuthRequestContext.remove("SCAN TIME");
                        access$getSendMoneyFeatureTime.getAuthRequestContext.remove("DECODE TIME");
                        access$getSendMoneyFeatureTime.getAuthRequestContext();
                        SummaryActivity.this.finish();
                    }
                }
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(SummaryActivity.this);
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
        int i = L + 121;
        P = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x0025, code lost:
    
        if ((r0 != null ? '6' : '.') != '6') goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x002f, code lost:
    
        if (r0 != null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0031, code lost:
    
        r5 = (id.dana.sendmoney.model.RecipientModel) r0.getParcelable("data");
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0039, code lost:
    
        if (r5 == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x003d, code lost:
    
        if (r5.getErrorConfigVersion == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x003f, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0041, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0042, code lost:
    
        r7 = id.dana.domain.sendmoney.TransferScenario.PROFILE_QR;
        r8 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0046, code lost:
    
        if (r6 == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0048, code lost:
    
        r6 = r5.getErrorConfigVersion;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0057, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) "*", false, 2, (java.lang.Object) null) == false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0059, code lost:
    
        r6 = id.dana.sendmoney.summary.SummaryActivity.P + 109;
        id.dana.sendmoney.summary.SummaryActivity.L = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0062, code lost:
    
        if ((r6 % 2) == 0) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0066, code lost:
    
        r6 = 47 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x006a, code lost:
    
        r7 = r5.BottomSheetCardBindingView$watcherCardNumberView$1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x006d, code lost:
    
        r7 = r5.BottomSheetCardBindingView$watcherCardNumberView$1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x006f, code lost:
    
        r10.getValueOfTouchPositionAbsolute = r7;
        r10.NetworkUserEntityData$$ExternalSyntheticLambda6 = r5;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "");
        r6 = r0.getString("remarks", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x007e, code lost:
    
        if (r6 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0080, code lost:
    
        r9 = ')';
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0083, code lost:
    
        r9 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0085, code lost:
    
        if (r9 == ')') goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0088, code lost:
    
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0089, code lost:
    
        r10.BottomSheetCardBindingView$watcherCardNumberView$1 = new id.dana.sendmoney.summary.view.SummaryViewState(r5, r8, r0.getBoolean("isNewNumber", false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0096, code lost:
    
        r10.getOnBoardingScenario = (id.dana.sendmoney.model.WithdrawOTCModel) r0.getParcelable("BUNDLE_WITHDRAW_CHANNEL");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void I() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.I():void");
    }

    private final void DatabaseTableConfigUtil() {
        RecipientModel recipientModel = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (recipientModel != null) {
            SendMoneySummary sendMoneySummary = this.SubSequence;
            Object obj = null;
            if (!(sendMoneySummary != null)) {
                int i = L + 123;
                P = i % 128;
                if ((i % 2 == 0 ? 'K' : 'J') != 'K') {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    obj.hashCode();
                }
                sendMoneySummary = null;
            }
            sendMoneySummary.PlaceComponentResult(recipientModel);
            try {
                int i2 = P + 113;
                L = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private final void BottomSheetCardBindingView$watcherCardNumberView$1() {
        DaggerStickySummaryComponent.Builder PlaceComponentResult2 = DaggerStickySummaryComponent.PlaceComponentResult();
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (SendMoneySummaryModule) Preconditions.getAuthRequestContext(PrepareContext());
        PlaceComponentResult2.MyBillsEntityDataFactory = (ExpiryModule) Preconditions.getAuthRequestContext(NetworkUserEntityData$$ExternalSyntheticLambda1());
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ShareToFeedsModule) Preconditions.getAuthRequestContext(newProxyInstance());
        PlaceComponentResult2.PlaceComponentResult = (SendMoneyConfirmationModule) Preconditions.getAuthRequestContext(new SendMoneyConfirmationModule(lookAheadTest(), getErrorConfigVersion()));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, SendMoneySummaryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, SendMoneyConfirmationModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.MyBillsEntityDataFactory, ExpiryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0, ShareToFeedsModule.class);
        if (PlaceComponentResult2.getAuthRequestContext == null) {
            PlaceComponentResult2.getAuthRequestContext = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerStickySummaryComponent.StickySummaryComponentImpl(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.PlaceComponentResult, PlaceComponentResult2.MyBillsEntityDataFactory, PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getSendMoneySummaryPresenter(), getSendMoneyConfirmationPresenter(), getSendMoneyConfirmationBankPresenter(), getExpiryPresenter(), getShareToFeedsPresenter());
        try {
            int i = P + 15;
            L = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0031, code lost:
    
        if (r8 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0043, code lost:
    
        if ((r8 != null) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0046, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0049, code lost:
    
        r8 = null;
        r1 = id.dana.sendmoney.summary.SummaryActivity.L + 119;
        id.dana.sendmoney.summary.SummaryActivity.P = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0098, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0099, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(java.lang.String r8) {
        /*
            r7 = this;
            android.view.Window r0 = r7.getWindow()
            r1 = 32
            r0.setSoftInputMode(r1)
            int r0 = id.dana.R.id.res_0x7f0a129b_saferepresenter_representnull
            android.view.View r0 = r7._$_findCachedViewById(r0)
            id.dana.sendmoney.summary.view.SummaryView r0 = (id.dana.sendmoney.summary.view.SummaryView) r0
            if (r0 == 0) goto L9c
            int r1 = id.dana.sendmoney.summary.SummaryActivity.L
            int r1 = r1 + 17
            int r2 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r2
            r2 = 2
            int r1 = r1 % r2
            r3 = 68
            if (r1 != 0) goto L24
            r1 = 68
            goto L26
        L24:
            r1 = 44
        L26:
            java.lang.String r4 = ""
            r5 = 1
            r6 = 0
            if (r1 == r3) goto L36
            r0.setSummaryViewVersion(r8)     // Catch: java.lang.Exception -> L34
            id.dana.sendmoney.summary.view.SummaryViewState r8 = r7.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L34
            if (r8 != 0) goto L53
            goto L46
        L34:
            r8 = move-exception
            throw r8
        L36:
            r0.setSummaryViewVersion(r8)
            id.dana.sendmoney.summary.view.SummaryViewState r8 = r7.BottomSheetCardBindingView$watcherCardNumberView$1
            r1 = 97
            int r1 = r1 / r6
            if (r8 != 0) goto L42
            r1 = 0
            goto L43
        L42:
            r1 = 1
        L43:
            if (r1 == 0) goto L46
            goto L53
        L46:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch: java.lang.Exception -> L98
            r8 = 0
            int r1 = id.dana.sendmoney.summary.SummaryActivity.L
            int r1 = r1 + 119
            int r3 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r3
            int r1 = r1 % r2
        L53:
            r0.setSummaryViewState(r8)
            r7.PlaceComponentResult(r0)
            r7.BuiltInFictitiousFunctionClassFactory(r0)
            r7.H()
            java.lang.String r8 = r7.getSource()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)
            r0.setSummaryViewSource(r8)
            id.dana.sendmoney.model.RecipientModel r8 = r7.NetworkUserEntityData$$ExternalSyntheticLambda6
            r1 = 83
            if (r8 == 0) goto L71
            r3 = 2
            goto L73
        L71:
            r3 = 83
        L73:
            if (r3 == r1) goto L81
            int r1 = id.dana.sendmoney.summary.SummaryActivity.P
            int r1 = r1 + 27
            int r3 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r3
            int r1 = r1 % r2
            r0.setSummaryViewRecipientModel(r8)
        L81:
            id.dana.sendmoney.summary.view.SummaryViewState r8 = r0.getSummaryViewState()
            if (r8 == 0) goto L88
            goto L89
        L88:
            r6 = 1
        L89:
            if (r6 == r5) goto L9c
            int r1 = id.dana.sendmoney.summary.SummaryActivity.L
            int r1 = r1 + 41
            int r3 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r3
            int r1 = r1 % r2
            r0.checkEnableTransferInit(r8)
            goto L9c
        L98:
            r8 = move-exception
            throw r8
        L9a:
            r8 = move-exception
            throw r8
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.BuiltInFictitiousFunctionClassFactory(java.lang.String):void");
    }

    private final void readMicros() {
        int i = P + 75;
        L = i % 128;
        int i2 = i % 2;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnNextCashierNative);
        if (danaButtonPrimaryView != null) {
            try {
                danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SummaryActivity.$r8$lambda$T73tMUc0n1CaC3zm7xpkMbMACbk(SummaryActivity.this, view);
                    }
                });
                int i3 = P + 25;
                L = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static final void BuiltInFictitiousFunctionClassFactory(SummaryActivity summaryActivity) {
        Intrinsics.checkNotNullParameter(summaryActivity, "");
        RecipientModel recipientModel = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (!(recipientModel == null)) {
            try {
                int i = L + 59;
                P = i % 128;
                int i2 = i % 2;
                try {
                    recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = "";
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        SummaryValidateModel summaryValidateModel = new SummaryValidateModel(summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda6, summaryActivity.amountToSend(), summaryActivity.payMethodModel, summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda4, summaryActivity.FragmentBottomSheetPaymentSettingBinding, summaryActivity.getOnBoardingScenario);
        SendMoneySummary sendMoneySummary = summaryActivity.SubSequence;
        if (sendMoneySummary == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneySummary = null;
            int i3 = P + 125;
            L = i3 % 128;
            int i4 = i3 % 2;
        }
        sendMoneySummary.getAuthRequestContext(summaryValidateModel);
        summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda7().lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
    }

    private final void getSupportButtonTintMode() {
        int i = L + 39;
        P = i % 128;
        int i2 = i % 2;
        getSendMoneySummaryPresenter().BuiltInFictitiousFunctionClassFactory();
        int i3 = P + 77;
        L = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void BuiltInFictitiousFunctionClassFactory(final SummaryView summaryView) {
        int i = L + 91;
        P = i % 128;
        int i2 = i % 2;
        BottomSheetBehavior<View> bottomSheetBehavior = this.moveToNextValue;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.sendmoney.summary.SummaryActivity$listenToKeyboardVisibility$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onSlide(View p0, float p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onStateChanged(View p0, int p1) {
                    SummaryViewState summaryViewState;
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p1 == 5) {
                        if (((CurrencyEditText) SummaryView.this._$_findCachedViewById(R.id.res_0x7f0a02e2_basesocialfeedcontract_presenter)).isFocused() || ((DanaTextBoxView) this._$_findCachedViewById(R.id.res_0x7f0a0684_r8_lambda_7v3kt_ajfljz89nrm_iclzm3mwc)).isFocused()) {
                            String access$getAmountToSend$p = SummaryActivity.access$getAmountToSend$p(this);
                            if (!(access$getAmountToSend$p == null || access$getAmountToSend$p.length() == 0) && SummaryActivity.access$getVoucherEnable$p(this) && !SummaryActivity.access$isCashierEnable(this) && (summaryViewState = SummaryView.this.getSummaryViewState()) != null) {
                                String authRequestContext = summaryViewState.getAuthRequestContext();
                                SummaryActivity summaryActivity = this;
                                SummaryVoucherView summaryVoucherView = (SummaryVoucherView) summaryActivity._$_findCachedViewById(R.id.AutoRouteEntityRepository_Factory);
                                if (summaryVoucherView != null) {
                                    String str = summaryActivity.amountToSend().MyBillsEntityDataFactory;
                                    Intrinsics.checkNotNullExpressionValue(str, "");
                                    summaryVoucherView.initPrePay(str, authRequestContext);
                                }
                            }
                        }
                        SummaryActivity.access$removeAmountEditTextFocus(this);
                    }
                }
            });
        }
        int i3 = L + 33;
        P = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private final void J() {
        int i = P + 85;
        L = i % 128;
        int i2 = i % 2;
        ((CurrencyEditText) _$_findCachedViewById(R.id.res_0x7f0a02e2_basesocialfeedcontract_presenter)).clearFocus();
        int i3 = L + 109;
        P = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private final void H() {
        try {
            SummaryVoucherView summaryVoucherView = this.C;
            Object obj = null;
            if (!(summaryVoucherView != null)) {
                int i = L + 105;
                P = i % 128;
                int i2 = i % 2;
                Intrinsics.throwUninitializedPropertyAccessException("");
                summaryVoucherView = null;
            }
            summaryVoucherView.setSummaryVoucherListener(isLayoutRequested());
            int i3 = L + 81;
            try {
                P = i3 % 128;
                if ((i3 % 2 == 0 ? 'A' : ';') != ';') {
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void D() {
        String str;
        RecipientModel recipientModel = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if ((recipientModel != null ? (char) 30 : 'C') != 30) {
            str = null;
        } else {
            int i = P + 85;
            L = i % 128;
            int i2 = i % 2;
            str = recipientModel.readMicros;
        }
        if (Intrinsics.areEqual(str, "contact")) {
            initRecordTimeStamp();
            try {
                getShareToFeedsPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                NewShareToFeedsView newShareToFeedsView = (NewShareToFeedsView) _$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
                if ((newShareToFeedsView != null ? '6' : 'C') != 'C') {
                    int i3 = P + 105;
                    L = i3 % 128;
                    int i4 = i3 % 2;
                    if (getOnBoardingScenario()) {
                        newShareToFeedsView.renderFeedRevamp();
                        newShareToFeedsView.setCaption((String) null);
                    } else {
                        newShareToFeedsView.renderShareFeed();
                        newShareToFeedsView.setCaption(NetworkUserEntityData$$ExternalSyntheticLambda0());
                    }
                    newShareToFeedsView.setVisibility(0);
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        try {
            int i = L + 69;
            P = i % 128;
            if (i % 2 != 0) {
                getSendMoneySummaryPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            getSendMoneySummaryPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void initRecordTimeStamp() {
        int i = L + 77;
        P = i % 128;
        if ((i % 2 == 0 ? 'P' : '%') != 'P') {
            getSendMoneySummaryPresenter().lookAheadTest();
        } else {
            getSendMoneySummaryPresenter().lookAheadTest();
            int i2 = 25 / 0;
        }
        int i3 = P + 95;
        L = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001a, code lost:
    
        if ((r2 == null) != true) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x002e, code lost:
    
        if ((r2 == null ? 'V' : kotlin.text.Typography.amp) != '&') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0030, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r2 = id.dana.sendmoney.summary.SummaryActivity.P + 13;
        id.dana.sendmoney.summary.SummaryActivity.L = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0040, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L     // Catch: java.lang.Exception -> L49
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1     // Catch: java.lang.Exception -> L49
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1f
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r0 = r5.getSendMoneySummaryPresenter()
            id.dana.sendmoney.summary.view.SummaryViewState r2 = r5.BottomSheetCardBindingView$watcherCardNumberView$1
            int r3 = r1.length     // Catch: java.lang.Throwable -> L1d
            r3 = 1
            if (r2 != 0) goto L19
            r4 = 1
            goto L1a
        L19:
            r4 = 0
        L1a:
            if (r4 == r3) goto L30
            goto L40
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r0 = r5.getSendMoneySummaryPresenter()
            id.dana.sendmoney.summary.view.SummaryViewState r2 = r5.BottomSheetCardBindingView$watcherCardNumberView$1
            r3 = 38
            if (r2 != 0) goto L2c
            r4 = 86
            goto L2e
        L2c:
            r4 = 38
        L2e:
            if (r4 == r3) goto L40
        L30:
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            int r2 = id.dana.sendmoney.summary.SummaryActivity.P
            int r2 = r2 + 13
            int r3 = r2 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r3
            int r2 = r2 % 2
            goto L41
        L40:
            r1 = r2
        L41:
            boolean r1 = r1.getErrorConfigVersion()
            r0.BuiltInFictitiousFunctionClassFactory(r1)
            return
        L49:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda6():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0023, code lost:
    
        if ((r0 != null ? '\r' : kotlin.text.Typography.dollar) != '\r') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0035, code lost:
    
        if ((r0 == null) != true) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0037, code lost:
    
        r0.setEnabled(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003a, code lost:
    
        r0 = (androidx.constraintlayout.widget.ConstraintLayout) _$_findCachedViewById(id.dana.R.id.clStickySummaryFee);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0042, code lost:
    
        if (r0 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0044, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0046, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0047, code lost:
    
        if (r3 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x004a, code lost:
    
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0051, code lost:
    
        NetworkUserEntityData$$ExternalSyntheticLambda6();
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 17;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x005e, code lost:
    
        if ((r0 % 2) != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0060, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0062, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0063, code lost:
    
        if (r0 == true) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0067, code lost:
    
        r0 = 11 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0068, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x006b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L28
            int r0 = id.dana.R.id.R
            android.view.View r0 = r5._$_findCachedViewById(r0)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r0 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r0
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L26
            r3 = 13
            if (r0 == 0) goto L21
            r4 = 13
            goto L23
        L21:
            r4 = 36
        L23:
            if (r4 == r3) goto L37
            goto L3a
        L26:
            r0 = move-exception
            throw r0
        L28:
            int r0 = id.dana.R.id.R
            android.view.View r0 = r5._$_findCachedViewById(r0)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r0 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r0
            if (r0 == 0) goto L34
            r3 = 0
            goto L35
        L34:
            r3 = 1
        L35:
            if (r3 == r2) goto L3a
        L37:
            r0.setEnabled(r1)
        L3a:
            int r0 = id.dana.R.id.clStickySummaryFee
            android.view.View r0 = r5._$_findCachedViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L46
            r3 = 0
            goto L47
        L46:
            r3 = 1
        L47:
            if (r3 == 0) goto L4a
            goto L51
        L4a:
            android.view.View r0 = (android.view.View) r0
            r3 = 8
            r0.setVisibility(r3)
        L51:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda6()
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 17
            int r3 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L62
            r0 = 0
            goto L63
        L62:
            r0 = 1
        L63:
            if (r0 == r2) goto L6b
            r0 = 11
            int r0 = r0 / r1
            return
        L69:
            r0 = move-exception
            throw r0
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.VerifyPinStateManager$executeRiskChallenge$2$1():void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(TransferInit p0) {
        try {
            try {
                PayMethodView payMethodView = (PayMethodView) _$_findCachedViewById(R.id.maybeAnimateModeChange);
                if (payMethodView != null) {
                    int i = P + 23;
                    L = i % 128;
                    int i2 = i % 2;
                    RecipientModel recipientModel = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    String str = (recipientModel != null ? (char) 19 : '_') != '_' ? recipientModel.readMicros : null;
                    if (str == null) {
                        int i3 = P + 61;
                        L = i3 % 128;
                        int i4 = i3 % 2;
                        str = "";
                    }
                    payMethodView.fetchData(str, p0);
                    payMethodView.setChangePayMethodListener(new PayMethodView.PayMethodListener() { // from class: id.dana.sendmoney.summary.SummaryActivity$initDataPayMethodBottomSheet$1$1
                        @Override // id.dana.sendmoney_v2.paymethod.PayMethodView.PayMethodListener
                        public final void getAuthRequestContext(PayMethodModel p02) {
                            Intrinsics.checkNotNullParameter(p02, "");
                            SummaryActivity.access$hideShimmer(SummaryActivity.this);
                            SummaryActivity.access$measureViewHeight(SummaryActivity.this);
                            RecyclerView recyclerView = (RecyclerView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a1177_emptycontiguousset_serializedform);
                            if (recyclerView != null) {
                                recyclerView.setPadding(0, 0, 0, ((ConstraintLayout) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1)).getMeasuredHeight());
                            }
                            SummaryActivity.this.setPayMethodModel(p02);
                            String access$getAmountToSend$p = SummaryActivity.access$getAmountToSend$p(SummaryActivity.this);
                            if (!(access$getAmountToSend$p == null || StringsKt.isBlank(access$getAmountToSend$p)) && !SummaryActivity.this.amountToSend().KClassImpl$Data$declaredNonStaticMembers$2()) {
                                SummaryActivity summaryActivity = SummaryActivity.this;
                                String str2 = summaryActivity.amountToSend().MyBillsEntityDataFactory;
                                Intrinsics.checkNotNullExpressionValue(str2, "");
                                SummaryActivity.access$checkAmountToSent(summaryActivity, str2);
                            }
                            SummaryActivity.access$collapsePayMethodView(SummaryActivity.this);
                        }

                        @Override // id.dana.sendmoney_v2.paymethod.PayMethodView.PayMethodListener
                        public final void getAuthRequestContext() {
                            SummaryView summaryView;
                            SendMoneyContract.Presenter presenter;
                            if (SummaryActivity.access$getSmartFrictionConfig$p(SummaryActivity.this) == null || (summaryView = (SummaryView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull)) == null || (presenter = summaryView.getPresenter()) == null) {
                                return;
                            }
                            String str2 = SummaryActivity.this.amountToSend().MyBillsEntityDataFactory;
                            SmartFrictionConfig access$getSmartFrictionConfig$p = SummaryActivity.access$getSmartFrictionConfig$p(SummaryActivity.this);
                            if (access$getSmartFrictionConfig$p == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                access$getSmartFrictionConfig$p = null;
                            }
                            presenter.MyBillsEntityDataFactory(str2, access$getSmartFrictionConfig$p.getReachLimit());
                        }

                        @Override // id.dana.sendmoney_v2.paymethod.PayMethodView.PayMethodListener
                        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                            SummaryView summaryView = (SummaryView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull);
                            if (summaryView != null) {
                                SummaryViewState access$getSummaryViewState$p = SummaryActivity.access$getSummaryViewState$p(SummaryActivity.this);
                                if (access$getSummaryViewState$p == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    access$getSummaryViewState$p = null;
                                }
                                summaryView.initSummaryBiztransfer(access$getSummaryViewState$p.getAuthRequestContext(), SummaryActivity.access$getRecipientModel$p(SummaryActivity.this));
                            }
                        }
                    });
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void getValueOfTouchPositionAbsolute() {
        try {
            int i = P + 35;
            L = i % 128;
            int i2 = i % 2;
            if (((MaterialCardView) _$_findCachedViewById(R.id.SendCashierOneKlikOtpRequest)) != null) {
                BottomSheetBehavior<MaterialCardView> from = BottomSheetBehavior.from((MaterialCardView) _$_findCachedViewById(R.id.SendCashierOneKlikOtpRequest));
                AppCompatEmojiTextHelper();
                from.setPeekHeight(((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1)).getMeasuredHeight() + ((ConstraintLayout) _$_findCachedViewById(R.id.clPayMethodContainer)).getMeasuredHeight());
                from.setState(4);
                from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.sendmoney.summary.SummaryActivity$initStatePayMethodBottomSheet$1$1$1
                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
                    
                        if (r5 != 6) goto L15;
                     */
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void onStateChanged(android.view.View r4, int r5) {
                        /*
                            r3 = this;
                            java.lang.String r0 = ""
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            r0 = 3
                            if (r5 != r0) goto La
                            r1 = 0
                            goto Lc
                        La:
                            r1 = 1090519040(0x41000000, float:8.0)
                        Lc:
                            int r1 = id.dana.extension.view.ViewExtKt.PlaceComponentResult(r1)
                            r2 = 0
                            if (r5 == r0) goto L20
                            r0 = 4
                            if (r5 == r0) goto L1a
                            r0 = 6
                            if (r5 == r0) goto L20
                            goto L26
                        L1a:
                            id.dana.sendmoney.summary.SummaryActivity r5 = id.dana.sendmoney.summary.SummaryActivity.this
                            id.dana.sendmoney.summary.SummaryActivity.access$updateBottomSheetStickyHeader(r5, r2)
                            goto L26
                        L20:
                            id.dana.sendmoney.summary.SummaryActivity r5 = id.dana.sendmoney.summary.SummaryActivity.this
                            r0 = 1
                            id.dana.sendmoney.summary.SummaryActivity.access$updateBottomSheetStickyHeader(r5, r0)
                        L26:
                            r4.setPadding(r2, r1, r2, r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity$initStatePayMethodBottomSheet$1$1$1.onStateChanged(android.view.View, int):void");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onSlide(View p0, float p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        View _$_findCachedViewById = SummaryActivity.this._$_findCachedViewById(R.id.getMaxAppJavaHeapMemoryKb_res_0x7f0a0600);
                        if (_$_findCachedViewById != null) {
                            _$_findCachedViewById.setVisibility(0);
                        }
                        if (p1 < 0.0f) {
                            return;
                        }
                        p0.setPadding(0, ViewExtKt.PlaceComponentResult((1.0f - p1) * 8.0f), 0, 0);
                    }
                });
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = from;
                int i3 = L + 53;
                P = i3 % 128;
                int i4 = i3 % 2;
            }
            getNameOrBuilderList();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void PlaceComponentResult(final SummaryView summaryView) {
        summaryView.setSummaryListener(new SummaryView.SummaryListener() { // from class: id.dana.sendmoney.summary.SummaryActivity$listenToAmountChange$1
            @Override // id.dana.sendmoney.summary.view.SummaryView.SummaryListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                SummaryActivity.access$setAmountToSend$p(SummaryActivity.this, p0);
                SummaryActivity.access$checkAmountToSent(SummaryActivity.this, p1);
            }

            @Override // id.dana.sendmoney.summary.view.SummaryView.SummaryListener
            public final void PlaceComponentResult(String p0) {
                CurrencyAmountModel currencyAmountModel;
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity.access$setFreeMinAmount$p(SummaryActivity.this, p0);
                SummaryActivity summaryActivity = SummaryActivity.this;
                PayMethodModel payMethodModel = summaryActivity.getPayMethodModel();
                SummaryActivity.access$showChargeFeeAmount(summaryActivity, (payMethodModel == null || (currencyAmountModel = payMethodModel.BuiltInFictitiousFunctionClassFactory) == null) ? null : currencyAmountModel.MyBillsEntityDataFactory);
                SummaryActivity summaryActivity2 = SummaryActivity.this;
                String str = summaryActivity2.amountToSend().MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(str, "");
                SummaryActivity.access$checkAmountToSent(summaryActivity2, str);
            }

            @Override // id.dana.sendmoney.summary.view.SummaryView.SummaryListener
            public final void getAuthRequestContext() {
                PayMethodModel payMethodModel = SummaryActivity.this.getPayMethodModel();
                if (payMethodModel != null) {
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    if (payMethodModel.scheduleImpl()) {
                        LinearLayout linearLayout = (LinearLayout) summaryActivity._$_findCachedViewById(R.id.res_0x7f0a0d64_animatorkt_addlistener_2);
                        if (linearLayout != null) {
                            Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        SummaryView summaryView2 = (SummaryView) summaryActivity._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull);
                        if (summaryView2 != null) {
                            Intrinsics.checkNotNullExpressionValue(summaryView2, "");
                            SummaryView.showAmountWarningMessage$default(summaryView2, null, null, 0, 0, 15, null);
                        }
                    }
                    SummaryActivity.access$updateBottomSheetSummaryPeekHeight(summaryActivity);
                    RecyclerView recyclerView = (RecyclerView) summaryActivity._$_findCachedViewById(R.id.res_0x7f0a1177_emptycontiguousset_serializedform);
                    if (recyclerView != null) {
                        recyclerView.setPadding(0, 0, 0, ((ConstraintLayout) summaryActivity._$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1)).getMeasuredHeight());
                    }
                }
            }

            @Override // id.dana.sendmoney.summary.view.SummaryView.SummaryListener
            public final void MyBillsEntityDataFactory() {
                SummaryViewState access$getSummaryViewState$p = SummaryActivity.access$getSummaryViewState$p(SummaryActivity.this);
                if (access$getSummaryViewState$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getSummaryViewState$p = null;
                }
                access$getSummaryViewState$p.scheduleImpl.GetContactSyncConfig = true;
                FrameLayout frameLayout = (FrameLayout) SummaryActivity.this._$_findCachedViewById(R.id.getPreserveDeclarationsOrdering);
                if (frameLayout != null) {
                    frameLayout.setVisibility(SummaryActivity.access$isNeedToShowUnregisteredUserNotes(SummaryActivity.this) ? 0 : 8);
                }
            }

            @Override // id.dana.sendmoney.summary.view.SummaryView.SummaryListener
            public final void getAuthRequestContext(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                LinearLayout linearLayout = (LinearLayout) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a0d64_animatorkt_addlistener_2);
                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                if (!(linearLayout.getVisibility() == 0)) {
                    SummaryActivity.access$showChargeFeeAmount(SummaryActivity.this, p0);
                }
                PayMethodModel payMethodModel = SummaryActivity.this.getPayMethodModel();
                CurrencyAmountModel currencyAmountModel = payMethodModel != null ? payMethodModel.BuiltInFictitiousFunctionClassFactory : null;
                if (currencyAmountModel != null) {
                    currencyAmountModel.MyBillsEntityDataFactory = p0;
                }
                SummaryActivity.access$checkAmountToSent(SummaryActivity.this, p1);
            }

            @Override // id.dana.sendmoney.summary.view.SummaryView.SummaryListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel p0) {
                if (p0 != null) {
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    RecipientModel access$getRecipientModel$p = SummaryActivity.access$getRecipientModel$p(summaryActivity);
                    if (access$getRecipientModel$p != null) {
                        p0.whenAvailable = summaryActivity.getSource();
                        p0.SubSequence = access$getRecipientModel$p.SubSequence;
                        p0.getCallingPid = access$getRecipientModel$p.getCallingPid;
                        SummaryActivity.access$setRecipientModel$p(summaryActivity, p0);
                    }
                    SummaryActivity.access$onAmountValidAndActionConfirmed(summaryActivity);
                }
            }

            @Override // id.dana.sendmoney.summary.view.SummaryView.SummaryListener
            public final void PlaceComponentResult() {
                if (SummaryActivity.access$getSmartFrictionConfig$p(SummaryActivity.this) != null) {
                    SmartFrictionConfig access$getSmartFrictionConfig$p = SummaryActivity.access$getSmartFrictionConfig$p(SummaryActivity.this);
                    if (access$getSmartFrictionConfig$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        access$getSmartFrictionConfig$p = null;
                    }
                    if (access$getSmartFrictionConfig$p.getReachLimit()) {
                        summaryView.getSendMoneyAnalyticalTracker().PlaceComponentResult(TrackerKey.Property.REACH_LIMIT, SummaryActivity.access$getRecipientDestinationType(SummaryActivity.this));
                        SummaryView summaryView2 = (SummaryView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull);
                        if (summaryView2 != null) {
                            String string = SummaryActivity.this.getString(R.string.exceed_limit_smart_friction_description);
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            summaryView2.showAmountInfoMessage(string);
                        }
                        SummaryActivity summaryActivity = SummaryActivity.this;
                        String authRequestContext = summaryActivity.amountToSend().getAuthRequestContext();
                        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                        summaryActivity.setDisabledWithAmount(authRequestContext);
                    }
                }
            }
        });
        try {
            int i = P + 61;
            L = i % 128;
            if ((i % 2 != 0 ? 'V' : '0') != '0') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final CurrencyAmountModel amountToSend() {
        String replace$default;
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String BuiltInFictitiousFunctionClassFactory = NumberUtil.BuiltInFictitiousFunctionClassFactory(String.valueOf(this.PlaceComponentResult));
        if ((BuiltInFictitiousFunctionClassFactory != null ? (char) 25 : (char) 2) == 25) {
            int i = L + 105;
            P = i % 128;
            int i2 = i % 2;
            replace$default = StringsKt.replace$default(BuiltInFictitiousFunctionClassFactory, "Rp", "", false, 4, (Object) null);
        } else {
            replace$default = null;
            int i3 = L + 61;
            P = i3 % 128;
            int i4 = i3 % 2;
        }
        return new CurrencyAmountModel(replace$default, GlobalNetworkConstants.IDR_CURRENCY);
    }

    private final Spannable MyBillsEntityDataFactory(CharSequence p0, int p1, int p2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(p0);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.f27152131100507)), p1, p2, 33);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i = L + 9;
        P = i % 128;
        int i2 = i % 2;
        return spannableStringBuilder2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x002a, code lost:
    
        if (r0 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x003b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(java.util.Locale.getDefault().getDisplayLanguage(), "Indonesia") != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x003d, code lost:
    
        r0 = getString(id.dana.R.string.send_money_feed_summary_display_caption_default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r0 = MyBillsEntityDataFactory(r0, 5, 18);
        r3 = id.dana.sendmoney.summary.SummaryActivity.P + 55;
        id.dana.sendmoney.summary.SummaryActivity.L = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0058, code lost:
    
        r0 = getString(id.dana.R.string.send_money_feed_summary_display_caption_default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r0 = MyBillsEntityDataFactory(r0, 4, 14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.text.Spannable NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r7 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = ""
            r4 = 2131956877(0x7f13148d, float:1.9550322E38)
            r5 = 0
            java.lang.String r6 = "Indonesia"
            if (r0 == r2) goto L2f
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getDisplayLanguage()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)
            r5.hashCode()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L58
            goto L3d
        L2d:
            r0 = move-exception
            throw r0
        L2f:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getDisplayLanguage()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)
            if (r0 == 0) goto L58
        L3d:
            java.lang.String r0 = r7.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3 = 5
            r4 = 18
            android.text.Spannable r0 = r7.MyBillsEntityDataFactory(r0, r3, r4)
            int r3 = id.dana.sendmoney.summary.SummaryActivity.P
            int r3 = r3 + 55
            int r4 = r3 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r4
            int r3 = r3 % 2
            goto L68
        L58:
            java.lang.String r0 = r7.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3 = 4
            r4 = 14
            android.text.Spannable r0 = r7.MyBillsEntityDataFactory(r0, r3, r4)
        L68:
            int r3 = id.dana.sendmoney.summary.SummaryActivity.L
            int r3 = r3 + 97
            int r4 = r3 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L75
            r1 = 1
        L75:
            if (r1 == 0) goto L7b
            int r1 = r5.length     // Catch: java.lang.Throwable -> L79
            return r0
        L79:
            r0 = move-exception
            throw r0
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0():android.text.Spannable");
    }

    private final Spannable MyBillsEntityDataFactory(String p0) {
        int i = L + 73;
        P = i % 128;
        int i2 = i % 2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.send_money_feed_summary_display_caption);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{p0}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        if ((Intrinsics.areEqual(Locale.getDefault().getDisplayLanguage(), "Indonesia") ? '(' : (char) 4) == '(') {
            int i3 = P + 9;
            L = i3 % 128;
            int i4 = i3 % 2;
            return MyBillsEntityDataFactory(format, 5, 18);
        }
        return MyBillsEntityDataFactory(format, 4, 14);
    }

    @JvmName(name = "newProxyInstance")
    private final ShareToFeedsModule newProxyInstance() {
        ShareToFeedsModule shareToFeedsModule = new ShareToFeedsModule(new ShareToFeedsContract.View() { // from class: id.dana.sendmoney.summary.SummaryActivity$shareToFeedsModule$1
            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(boolean z) {
                ShareToFeedsContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                ShareToFeedsContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final void MyBillsEntityDataFactory() {
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

            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final void getAuthRequestContext(boolean p0) {
                if (p0) {
                    SummaryActivity.access$getStateShareFeed(SummaryActivity.this);
                }
                SummaryActivity.access$setShareFeedFeatureEnabled$p(SummaryActivity.this, p0);
                NewShareToFeedsView newShareToFeedsView = (NewShareToFeedsView) SummaryActivity.this._$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
                if (newShareToFeedsView != null) {
                    newShareToFeedsView.setShareFeedFeatureEnabled(SummaryActivity.access$isShareFeedFeatureEnabled$p(SummaryActivity.this));
                }
            }
        });
        int i = P + 65;
        L = i % 128;
        if ((i % 2 != 0 ? (char) 17 : (char) 15) != 15) {
            Object[] objArr = null;
            int length = objArr.length;
            return shareToFeedsModule;
        }
        return shareToFeedsModule;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda1")
    private final ExpiryModule NetworkUserEntityData$$ExternalSyntheticLambda1() {
        ExpiryModule expiryModule = new ExpiryModule(new ExpiryContract.View() { // from class: id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda2
            @Override // id.dana.contract.sendmoney.ExpiryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List list) {
                SummaryActivity.m2909$r8$lambda$qvrPAfJJ_e36dUuqQrQupnvkUg(SummaryActivity.this, list);
            }
        });
        int i = P + 59;
        L = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return expiryModule;
        }
        return expiryModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x001f, code lost:
    
        if (r0 > 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0032, code lost:
    
        if ((r13.size() > 0 ? 25 : '-') != '-') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0034, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 65;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
        r0 = r0 % 2;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "");
        r0 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x004c, code lost:
    
        if (r0.hasNext() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004e, code lost:
    
        r1 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0059, code lost:
    
        if (((id.dana.sendmoney.model.ExpiryInfoModel) r1).getAuthRequestContext() == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x005b, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 105;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0066, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 21;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0071, code lost:
    
        r1 = (id.dana.sendmoney.model.ExpiryInfoModel) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0073, code lost:
    
        if (r1 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0075, code lost:
    
        r1 = (id.dana.sendmoney.model.ExpiryInfoModel) kotlin.collections.CollectionsKt.first(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x007d, code lost:
    
        r1 = new id.dana.sendmoney.model.ExpiryInfoModel();
        r1.MyBillsEntityDataFactory(1);
        r13 = new java.lang.Object[1];
        a(android.graphics.Color.green(0) - 1192266553, (-64) - android.text.TextUtils.getCapsMode("", 0, 0), (short) (android.text.TextUtils.lastIndexOf("", '0', 0, 0) - 9), 2115028768 - (android.os.Process.myPid() >> 22), (byte) android.graphics.Color.red(0), r13);
        r1.BuiltInFictitiousFunctionClassFactory(((java.lang.String) r13[0]).intern());
        r13 = id.dana.sendmoney.summary.SummaryActivity.L + 11;
        id.dana.sendmoney.summary.SummaryActivity.P = r13 % 128;
        r13 = r13 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.sendmoney.summary.SummaryActivity r12, java.util.List r13) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.sendmoney.summary.SummaryActivity, java.util.List):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r5, int resultCode, Intent data) {
        super.onActivityResult(r5, resultCode, data);
        SummaryVoucherView summaryVoucherView = (SummaryVoucherView) _$_findCachedViewById(R.id.AutoRouteEntityRepository_Factory);
        if (summaryVoucherView != null) {
            summaryVoucherView.onActivityResult(r5, resultCode, data);
            int i = L + 7;
            P = i % 128;
            int i2 = i % 2;
        }
        int i3 = L + 91;
        P = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    @JvmName(name = "PrepareContext")
    private final SendMoneySummaryModule PrepareContext() {
        SendMoneySummaryModule sendMoneySummaryModule = new SendMoneySummaryModule(new SendMoneySummaryContract.View() { // from class: id.dana.sendmoney.summary.SummaryActivity$sendMoneySummaryModule$1
            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                CurrencyAmountModel currencyAmountModel;
                SummaryView summaryView;
                LinearLayout linearLayout = (LinearLayout) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a0d64_animatorkt_addlistener_2);
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                if (SummaryActivity.access$isCashierEnable(SummaryActivity.this) && (summaryView = (SummaryView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull)) != null) {
                    SummaryView.showAmountWarningMessage$default(summaryView, null, null, 0, 0, 15, null);
                }
                if (SummaryActivity.access$isFreeTransferAvailable(SummaryActivity.this) && SummaryActivity.access$getSelectedVoucher$p(SummaryActivity.this) != null && !SummaryActivity.this.amountToSend().KClassImpl$Data$declaredNonStaticMembers$2(new CurrencyAmountModel(SummaryActivity.access$getFreeMinAmount$p(SummaryActivity.this)))) {
                    SummaryActivity.access$showChargeFeeAmount(SummaryActivity.this, "0");
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    CurrencyAmountModel amountToSend = summaryActivity.amountToSend();
                    VoucherModel access$getSelectedVoucher$p = SummaryActivity.access$getSelectedVoucher$p(SummaryActivity.this);
                    summaryActivity.setEnableButtonWithAmount(AmountCalculationExtKt.getAuthRequestContext(amountToSend, access$getSelectedVoucher$p != null ? access$getSelectedVoucher$p.DatabaseTableConfigUtil : null));
                } else if (SummaryActivity.access$isFreeTransferAvailable(SummaryActivity.this) && !SummaryActivity.this.amountToSend().KClassImpl$Data$declaredNonStaticMembers$2(new CurrencyAmountModel(SummaryActivity.access$getFreeMinAmount$p(SummaryActivity.this)))) {
                    SummaryActivity.access$showChargeFeeAmount(SummaryActivity.this, "0");
                    SummaryActivity summaryActivity2 = SummaryActivity.this;
                    String authRequestContext = summaryActivity2.amountToSend().getAuthRequestContext();
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    summaryActivity2.setEnableButtonWithAmount(authRequestContext);
                } else {
                    SummaryActivity summaryActivity3 = SummaryActivity.this;
                    PayMethodModel payMethodModel = summaryActivity3.getPayMethodModel();
                    SummaryActivity.access$showChargeFeeAmount(summaryActivity3, (payMethodModel == null || (currencyAmountModel = payMethodModel.BuiltInFictitiousFunctionClassFactory) == null) ? null : currencyAmountModel.MyBillsEntityDataFactory);
                    SummaryActivity summaryActivity4 = SummaryActivity.this;
                    CurrencyAmountModel amountToSend2 = summaryActivity4.amountToSend();
                    PayMethodModel payMethodModel2 = SummaryActivity.this.getPayMethodModel();
                    CurrencyAmountModel currencyAmountModel2 = payMethodModel2 != null ? payMethodModel2.BuiltInFictitiousFunctionClassFactory : null;
                    VoucherModel access$getSelectedVoucher$p2 = SummaryActivity.access$getSelectedVoucher$p(SummaryActivity.this);
                    summaryActivity4.setEnableButtonWithAmount(AmountCalculationExtKt.KClassImpl$Data$declaredNonStaticMembers$2(amountToSend2, currencyAmountModel2, access$getSelectedVoucher$p2 != null ? access$getSelectedVoucher$p2.DatabaseTableConfigUtil : null));
                }
                Button button = (Button) SummaryActivity.this._$_findCachedViewById(R.id.JsonParseException_res_0x7f0a023e);
                if (button != null) {
                    button.setVisibility(8);
                }
                SummaryActivity.access$updateBottomSheetSummaryPeekHeight(SummaryActivity.this);
                RecyclerView recyclerView = (RecyclerView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a1177_emptycontiguousset_serializedform);
                if (recyclerView != null) {
                    recyclerView.setPadding(0, 0, 0, ((ConstraintLayout) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1)).getMeasuredHeight());
                }
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity.access$setStateCheckboxShareFeed(SummaryActivity.this, p0);
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void PlaceComponentResult(String p0) {
                SummaryView summaryView;
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity summaryActivity = SummaryActivity.this;
                String string = summaryActivity.getString(R.string.sendmoney_summary_max_amount_warning);
                Intrinsics.checkNotNullExpressionValue(string, "");
                SummaryActivity.access$showPaymentStickyAmountWarningMessage(summaryActivity, p0, string);
                if (SummaryActivity.access$isCashierEnable(SummaryActivity.this)) {
                    CurrencyAmountModel access$getTransferMinAmount$p = SummaryActivity.access$getTransferMinAmount$p(SummaryActivity.this);
                    if (access$getTransferMinAmount$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        access$getTransferMinAmount$p = null;
                    }
                    String str = access$getTransferMinAmount$p.MyBillsEntityDataFactory;
                    if (!(str == null || str.length() == 0) && (summaryView = (SummaryView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull)) != null) {
                        String string2 = SummaryActivity.this.getResources().getString(R.string.sm_max_transfer_amount);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        summaryView.showAmountWarningMessage(p0, string2, R.drawable.ic_warning_16, R.color.f26712131100373);
                    }
                }
                SummaryActivity.access$showChargeFeeAmount(SummaryActivity.this, null);
                if (SummaryActivity.access$isFreeTransferAvailable(SummaryActivity.this)) {
                    SummaryActivity summaryActivity2 = SummaryActivity.this;
                    String authRequestContext = summaryActivity2.amountToSend().getAuthRequestContext();
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    summaryActivity2.setDisabledWithAmount(authRequestContext);
                } else {
                    SummaryActivity summaryActivity3 = SummaryActivity.this;
                    CurrencyAmountModel amountToSend = summaryActivity3.amountToSend();
                    PayMethodModel payMethodModel = SummaryActivity.this.getPayMethodModel();
                    CurrencyAmountModel currencyAmountModel = payMethodModel != null ? payMethodModel.BuiltInFictitiousFunctionClassFactory : null;
                    VoucherModel access$getSelectedVoucher$p = SummaryActivity.access$getSelectedVoucher$p(SummaryActivity.this);
                    summaryActivity3.setDisabledWithAmount(AmountCalculationExtKt.KClassImpl$Data$declaredNonStaticMembers$2(amountToSend, currencyAmountModel, access$getSelectedVoucher$p != null ? access$getSelectedVoucher$p.DatabaseTableConfigUtil : null));
                }
                Button button = (Button) SummaryActivity.this._$_findCachedViewById(R.id.JsonParseException_res_0x7f0a023e);
                if (button != null) {
                    button.setVisibility(0);
                }
                SummaryActivity.access$updateBottomSheetSummaryPeekHeight(SummaryActivity.this);
                RecyclerView recyclerView = (RecyclerView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a1177_emptycontiguousset_serializedform);
                if (recyclerView != null) {
                    recyclerView.setPadding(0, 0, 0, ((ConstraintLayout) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1)).getMeasuredHeight());
                }
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void getAuthRequestContext(String p0) {
                SummaryView summaryView;
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity summaryActivity = SummaryActivity.this;
                String string = summaryActivity.getString(R.string.sendmoney_summary_min_amount_warning);
                Intrinsics.checkNotNullExpressionValue(string, "");
                SummaryActivity.access$showPaymentStickyAmountWarningMessage(summaryActivity, p0, string);
                if (SummaryActivity.access$isCashierEnable(SummaryActivity.this)) {
                    CurrencyAmountModel access$getTransferMinAmount$p = SummaryActivity.access$getTransferMinAmount$p(SummaryActivity.this);
                    if (access$getTransferMinAmount$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        access$getTransferMinAmount$p = null;
                    }
                    String str = access$getTransferMinAmount$p.MyBillsEntityDataFactory;
                    if (!(str == null || str.length() == 0) && (summaryView = (SummaryView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull)) != null) {
                        String string2 = SummaryActivity.this.getResources().getString(R.string.sm_min_transfer_amount);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        summaryView.showAmountWarningMessage(p0, string2, R.drawable.ic_warning_16, R.color.f26712131100373);
                    }
                }
                SummaryActivity.access$showChargeFeeAmount(SummaryActivity.this, null);
                SummaryActivity summaryActivity2 = SummaryActivity.this;
                String authRequestContext = summaryActivity2.amountToSend().getAuthRequestContext();
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                summaryActivity2.setDisabledWithAmount(authRequestContext);
                Button button = (Button) SummaryActivity.this._$_findCachedViewById(R.id.JsonParseException_res_0x7f0a023e);
                if (button != null) {
                    button.setVisibility(8);
                }
                SummaryActivity.access$updateBottomSheetSummaryPeekHeight(SummaryActivity.this);
                RecyclerView recyclerView = (RecyclerView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a1177_emptycontiguousset_serializedform);
                if (recyclerView != null) {
                    recyclerView.setPadding(0, 0, 0, ((ConstraintLayout) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1)).getMeasuredHeight());
                }
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0, SummaryActivity.FIRST_STATE_SHARE_FEED)) {
                    SummaryActivity.this.getSendMoneySummaryPresenter().getAuthRequestContext();
                } else {
                    SummaryActivity.access$setStateCheckboxShareFeed(SummaryActivity.this, p0);
                }
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void getAuthRequestContext(boolean p0) {
                SummaryActivity.access$setVoucherEnable$p(SummaryActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                SummaryActivity.this.dismissDanaLoadingDialog();
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(ConfirmationModel p0) {
                if (p0 != null) {
                    p0.I(SummaryActivity.access$getTransferScenario$p(SummaryActivity.this));
                    p0.PlaceComponentResult(new ShareActivityModel(((NewShareToFeedsView) SummaryActivity.this._$_findCachedViewById(R.id.getNearbyMeMapViewFeature)).isChecked(), ((NewShareToFeedsView) SummaryActivity.this._$_findCachedViewById(R.id.getNearbyMeMapViewFeature)).isNeedToActivateFeedsSharing()));
                    SendMoneySummary sendMoneySummary = null;
                    if (Intrinsics.areEqual(p0.getValueOfTouchPositionAbsolute(), "split_bill")) {
                        Intent intent = SummaryActivity.this.getIntent();
                        p0.getOnBoardingScenario(intent != null ? intent.getStringExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID) : null);
                        p0.I(TransferScenario.SPLIT_BILL);
                    }
                    SummaryActivity.access$setConfirmationModel$p(SummaryActivity.this, p0);
                    SummaryActivity.access$setAmount$p(SummaryActivity.this, new Amount(p0.getErrorConfigVersion()));
                    SummaryActivity.access$setOriginPayMethod$p(SummaryActivity.this, p0.readMicros());
                    SummaryActivity.access$setAcceptTimeoutUnit$p(SummaryActivity.this, p0.MyBillsEntityDataFactory());
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    String newProxyInstance = p0.newProxyInstance();
                    Intrinsics.checkNotNullExpressionValue(newProxyInstance, "");
                    String str = newProxyInstance;
                    int length = str.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    SummaryActivity.access$setExpiryTime$p(summaryActivity, str.subSequence(i, length + 1).toString());
                    SummaryActivity.access$setConfirmationTransferMethod(SummaryActivity.this, p0);
                    p0.getAuthRequestContext(p0.VerifyPinStateManager$executeRiskChallenge$2$2() + 1);
                    UnitSymbolModel access$createUnitSymbol = SummaryActivity.access$createUnitSymbol(SummaryActivity.this);
                    String access$getRemarks$p = SummaryActivity.access$getRemarks$p(SummaryActivity.this);
                    String str2 = SummaryActivity.this.amountToSend().MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(str2, "");
                    SummaryConfirmationModel summaryConfirmationModel = new SummaryConfirmationModel(p0, access$createUnitSymbol, access$getRemarks$p, str2);
                    SummaryActivity summaryActivity2 = SummaryActivity.this;
                    SummaryActivity.access$getSendMoneyFeatureTime(summaryActivity2).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    SendMoneySummary access$getSendMoneySummary$p = SummaryActivity.access$getSendMoneySummary$p(summaryActivity2);
                    if (access$getSendMoneySummary$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        sendMoneySummary = access$getSendMoneySummary$p;
                    }
                    sendMoneySummary.KClassImpl$Data$declaredNonStaticMembers$2(summaryConfirmationModel);
                }
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1, String p2, Throwable p3) {
                Intrinsics.checkNotNullParameter(p3, "");
                boolean z = false;
                if (p1 != null) {
                    if (p1.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(SummaryActivity.this.getApplicationContext(), p0, p1, p2, p3);
                }
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void MyBillsEntityDataFactory(UserInfoResponse p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (SummaryActivity.access$isFeedRevamp(SummaryActivity.this)) {
                    NewShareToFeedsView newShareToFeedsView = (NewShareToFeedsView) SummaryActivity.this._$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
                    if (newShareToFeedsView != null) {
                        newShareToFeedsView.displayUserInfo(p0.getAvatarUrl(), p0.getUsername());
                        return;
                    }
                    return;
                }
                NewShareToFeedsView newShareToFeedsView2 = (NewShareToFeedsView) SummaryActivity.this._$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
                if (newShareToFeedsView2 != null) {
                    newShareToFeedsView2.displayAvatar(p0.getAvatarUrl());
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                SummaryActivity.this.showWarningDialog(p0);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                SummaryActivity.this.showDanaLoadingDialog();
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void getAuthRequestContext(List<String> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity summaryActivity = SummaryActivity.this;
                SummaryActivity.access$setSummaryVersion$p(summaryActivity, SummaryActivity.access$getSummaryVersion(summaryActivity, p0));
                SummaryActivity summaryActivity2 = SummaryActivity.this;
                String access$getSummaryVersion$p = SummaryActivity.access$getSummaryVersion$p(summaryActivity2);
                String str = null;
                if (access$getSummaryVersion$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getSummaryVersion$p = null;
                }
                SummaryActivity.access$setBottomsheetCashier(summaryActivity2, access$getSummaryVersion$p);
                SummaryActivity summaryActivity3 = SummaryActivity.this;
                String access$getSummaryVersion$p2 = SummaryActivity.access$getSummaryVersion$p(summaryActivity3);
                if (access$getSummaryVersion$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    str = access$getSummaryVersion$p2;
                }
                SummaryActivity.access$initSummaryView(summaryActivity3, str);
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void getAuthRequestContext(SmartFrictionConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity.access$setSmartFrictionConfig$p(SummaryActivity.this, p0);
                SummaryView summaryView = (SummaryView) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull);
                if (summaryView != null) {
                    SmartFrictionConfig access$getSmartFrictionConfig$p = SummaryActivity.access$getSmartFrictionConfig$p(SummaryActivity.this);
                    if (access$getSmartFrictionConfig$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        access$getSmartFrictionConfig$p = null;
                    }
                    summaryView.setSmartFrictionEnable(access$getSmartFrictionConfig$p);
                }
                if (p0.getAccountFreeze() && SummaryActivity.access$getAccountFreeze$p(SummaryActivity.this) && !SummaryActivity.access$isAlreadyShowSmartFriction$p(SummaryActivity.this)) {
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory(SummaryActivity.this);
                    SummaryActivity.access$handleAccountFreezeSmartFriction(SummaryActivity.this);
                    SummaryActivity.this.getSendMoneyAnalyticalTracker().PlaceComponentResult("ACCOUNT_FREEZE", SummaryActivity.access$getRecipientDestinationType(SummaryActivity.this));
                } else if (p0.getBlackListAccount() && SummaryActivity.access$getBlacklistedAccount$p(SummaryActivity.this)) {
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory(SummaryActivity.this);
                    SummaryActivity.access$handleBlacklistAccountSmartFriction(SummaryActivity.this);
                }
            }

            @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<ExpiryTimeConfig> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if ((!p0.isEmpty()) == true) {
                    SummaryActivity.access$setExpiryTimeConfigList$p(SummaryActivity.this, p0);
                    SummaryActivity.access$initSendToLinkSummary(SummaryActivity.this);
                    SummaryActivity.access$updateSelectedExpiredDuration(SummaryActivity.this);
                }
            }
        });
        int i = L + 5;
        P = i % 128;
        int i2 = i % 2;
        return sendMoneySummaryModule;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        boolean areEqual = Intrinsics.areEqual(p0, "3.0");
        Float valueOf = Float.valueOf(0.0f);
        if ((areEqual ? '?' : (char) 16) != '?') {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.res_0x7f0a010f_networkuserentitydata_externalsyntheticlambda1);
            if (_$_findCachedViewById != null) {
                _$_findCachedViewById.setVisibility(8);
            }
            try {
                View _$_findCachedViewById2 = _$_findCachedViewById(R.id.DatabaseTableConfigUtil_res_0x7f0a0110);
                if (_$_findCachedViewById2 != null) {
                    _$_findCachedViewById2.setVisibility(0);
                }
                NestedScrollView nestedScrollView = (NestedScrollView) _$_findCachedViewById(R.id.GriverImageLoadCallback);
                if ((nestedScrollView != null ? 'H' : ',') != ',') {
                    int i = L + 89;
                    P = i % 128;
                    int i2 = i % 2;
                    try {
                        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(nestedScrollView, valueOf, valueOf, valueOf, Float.valueOf(150.0f));
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                return;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = P + 109;
        L = i3 % 128;
        int i4 = i3 % 2;
        View _$_findCachedViewById3 = _$_findCachedViewById(R.id.res_0x7f0a010f_networkuserentitydata_externalsyntheticlambda1);
        if ((_$_findCachedViewById3 != null ? 'U' : Typography.quote) == 'U') {
            int i5 = L + 43;
            P = i5 % 128;
            int i6 = i5 % 2;
            _$_findCachedViewById3.setVisibility(0);
        }
        View _$_findCachedViewById4 = _$_findCachedViewById(R.id.DatabaseTableConfigUtil_res_0x7f0a0110);
        if (_$_findCachedViewById4 != null) {
            int i7 = L + 91;
            P = i7 % 128;
            int i8 = i7 % 2;
            _$_findCachedViewById4.setVisibility(8);
        }
        NestedScrollView nestedScrollView2 = (NestedScrollView) _$_findCachedViewById(R.id.GriverImageLoadCallback);
        if (!(nestedScrollView2 == null)) {
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(nestedScrollView2, valueOf, valueOf, valueOf, Float.valueOf(75.0f));
        }
    }

    private final boolean E() {
        long j;
        PayMethodModel payMethodModel = this.payMethodModel;
        boolean z = false;
        Object[] objArr = null;
        if (payMethodModel != null) {
            int i = L + 19;
            P = i % 128;
            if (!(i % 2 != 0)) {
                j = payMethodModel.scheduleImpl;
                int length = objArr.length;
            } else {
                j = payMethodModel.scheduleImpl;
            }
        } else {
            j = 0;
        }
        if (j > 0) {
            int i2 = P + 85;
            L = i2 % 128;
            int i3 = i2 % 2;
            z = true;
        }
        int i4 = L + 83;
        P = i4 % 128;
        if ((i4 % 2 == 0 ? 'H' : ')') != 'H') {
            return z;
        }
        objArr.hashCode();
        return z;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
        NewShareToFeedsView newShareToFeedsView;
        NewShareToFeedsView newShareToFeedsView2;
        int i = L + 45;
        P = i % 128;
        int i2 = i % 2;
        if ((Intrinsics.areEqual(p0, CHECKED) ? (char) 16 : ')') != 16) {
            try {
                if ((Intrinsics.areEqual(p0, "false") ? false : true) || (newShareToFeedsView = (NewShareToFeedsView) _$_findCachedViewById(R.id.getNearbyMeMapViewFeature)) == null) {
                    return;
                }
                newShareToFeedsView.disableShareToFeed();
                int i3 = P + 103;
                L = i3 % 128;
                int i4 = i3 % 2;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        int i5 = L + 29;
        P = i5 % 128;
        if ((i5 % 2 == 0 ? '6' : '0') != '0') {
            newShareToFeedsView2 = (NewShareToFeedsView) _$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
            int i6 = 53 / 0;
            if (newShareToFeedsView2 == null) {
                return;
            }
        } else {
            newShareToFeedsView2 = (NewShareToFeedsView) _$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
            if (newShareToFeedsView2 == null) {
                return;
            }
        }
        newShareToFeedsView2.enableShareToFeed();
    }

    private final SendMoneyConfirmationContract.View lookAheadTest() {
        SendMoneyConfirmationContract.View view = new SendMoneyConfirmationContract.View() { // from class: id.dana.sendmoney.summary.SummaryActivity$getConfirmationContactView$1
            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(Long l) {
                Locale locale;
                long longValue = l.longValue();
                if (longValue > 0) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) SummaryActivity.this._$_findCachedViewById(R.id.clLastTransferInfo);
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                    }
                    TextView textView = (TextView) SummaryActivity.this._$_findCachedViewById(R.id.tvLastTransferInfo);
                    if (textView != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(SummaryActivity.this.getString(R.string.sendmoney_summary_last_transfer));
                        sb.append(InputCardNumberView.DIVIDER);
                        locale = Locale.getDefault();
                        sb.append(DateTimeUtil.BuiltInFictitiousFunctionClassFactory("dd MMM yyyy", locale, longValue));
                        textView.setText(sb.toString());
                    }
                }
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryActivity.access$getSendMoneyFeatureTime(SummaryActivity.this);
                access$getSendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
                SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = SummaryActivity.this.getSendMoneyAnalyticalTracker();
                ConfirmationModel access$getConfirmationModel$p = SummaryActivity.access$getConfirmationModel$p(SummaryActivity.this);
                if (access$getConfirmationModel$p == null) {
                    return;
                }
                sendMoneyAnalyticalTracker.MyBillsEntityDataFactory(access$getConfirmationModel$p, SummaryActivity.access$isCashierEnable(SummaryActivity.this));
                AlipayConnectInitializer access$getAlipayConnectInitializer$p = SummaryActivity.access$getAlipayConnectInitializer$p(SummaryActivity.this);
                if (access$getAlipayConnectInitializer$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getAlipayConnectInitializer$p = null;
                }
                SummaryActivity.this.addDisposable(IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(access$getAlipayConnectInitializer$p, new Function0<Unit>() { // from class: id.dana.sendmoney.summary.SummaryActivity$getConfirmationContactView$1$onCompleteSendMoney$disposable$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        DanaH5.startContainerFullUrl(p0);
                    }
                }));
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final void PlaceComponentResult(SendMoneyConfirm p0) {
                SummaryActivity.access$setSendMoneyConfirm$p(SummaryActivity.this, p0);
                SummaryViewState access$getSummaryViewState$p = SummaryActivity.access$getSummaryViewState$p(SummaryActivity.this);
                if (access$getSummaryViewState$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getSummaryViewState$p = null;
                }
                if (Intrinsics.areEqual(access$getSummaryViewState$p.NetworkUserEntityData$$ExternalSyntheticLambda0, "High")) {
                    SummaryActivity.access$handleSmartFrictionSuspiciousAccount(SummaryActivity.this);
                } else {
                    SummaryActivity.access$handleSendMoneySubmit(SummaryActivity.this);
                }
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                AlipayConnectInitializer access$getAlipayConnectInitializer$p = SummaryActivity.access$getAlipayConnectInitializer$p(SummaryActivity.this);
                if (access$getAlipayConnectInitializer$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getAlipayConnectInitializer$p = null;
                }
                final SummaryActivity summaryActivity = SummaryActivity.this;
                SummaryActivity.this.addDisposable(IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(access$getAlipayConnectInitializer$p, new Function0<Unit>() { // from class: id.dana.sendmoney.summary.SummaryActivity$getConfirmationContactView$1$onSendMoneyKycError$disposable$1
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
                        sb.append("https://m.dana.id");
                        sb.append(SummaryActivity.this.getDynamicUrlWrapper().getKycFromSendMoneyUrl());
                        DanaH5.startContainerFullUrl(sb.toString());
                    }
                }));
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                if (Intrinsics.areEqual(SummaryActivity.access$getOriginPayMethod$p(SummaryActivity.this), "BALANCE")) {
                    SummaryActivity.this.getSendMoneyConfirmationPresenter().BuiltInFictitiousFunctionClassFactory();
                }
                dismissProgress();
                if (p0) {
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    SummaryActivity.access$backToHomepage(summaryActivity, SummaryActivity.access$createSendMoneyBundleData(summaryActivity));
                }
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity summaryActivity = SummaryActivity.this;
                String str = p0;
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                SummaryActivity.access$setExpiryTime$p(summaryActivity, str.subSequence(i, length + 1).toString());
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                ConstraintLayout constraintLayout = (ConstraintLayout) SummaryActivity.this._$_findCachedViewById(R.id.clLastTransferInfo);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                SummaryActivity.this.showDanaLoadingDialog();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                SummaryActivity.this.dismissDanaLoadingDialog();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity.this.showWarningDialog(p0);
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, Throwable p3) {
                Intrinsics.checkNotNullParameter(p3, "");
                boolean z = false;
                if (p1 != null) {
                    if (p1.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(SummaryActivity.this.getApplicationContext(), p0, p1, p2, p3);
                }
            }
        };
        int i = P + 79;
        L = i % 128;
        int i2 = i % 2;
        return view;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x006d, code lost:
    
        if (r8 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0094, code lost:
    
        if ((r8 != null ? 5 : '(') != 5) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0096, code lost:
    
        r13 = r0;
        r9 = r3;
        r14 = null;
        r10 = r5;
        r11 = r6;
        r12 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x009d, code lost:
    
        r9 = id.dana.sendmoney.summary.SummaryActivity.P + 73;
        id.dana.sendmoney.summary.SummaryActivity.L = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00a7, code lost:
    
        r8 = r8.getOnBoardingScenario();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00ab, code lost:
    
        if (r9 == 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ad, code lost:
    
        r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00b4, code lost:
    
        r13 = r0;
        r9 = r3;
        r10 = r5;
        r11 = r6;
        r12 = r7;
        r14 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda3():void");
    }

    private final SendMoneyConfirmationBankContract.View getErrorConfigVersion() {
        SendMoneyConfirmationBankContract.View view = new SendMoneyConfirmationBankContract.View() { // from class: id.dana.sendmoney.summary.SummaryActivity$getConfirmBankView$1
            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryActivity.access$getSendMoneyFeatureTime(SummaryActivity.this);
                access$getSendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
                SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = SummaryActivity.this.getSendMoneyAnalyticalTracker();
                ConfirmationModel access$getConfirmationModel$p = SummaryActivity.access$getConfirmationModel$p(SummaryActivity.this);
                if (access$getConfirmationModel$p == null) {
                    return;
                }
                sendMoneyAnalyticalTracker.MyBillsEntityDataFactory(access$getConfirmationModel$p, SummaryActivity.access$isCashierEnable(SummaryActivity.this));
                DanaH5.startContainerFullUrl(p0);
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract.View
            public final void BuiltInFictitiousFunctionClassFactory(SendMoneyConfirm p0) {
                Intent PlaceComponentResult2;
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryActivity.access$getSendMoneyFeatureTime(SummaryActivity.this);
                access$getSendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
                SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = SummaryActivity.this.getSendMoneyAnalyticalTracker();
                ConfirmationModel access$getConfirmationModel$p = SummaryActivity.access$getConfirmationModel$p(SummaryActivity.this);
                if (access$getConfirmationModel$p == null) {
                    return;
                }
                sendMoneyAnalyticalTracker.MyBillsEntityDataFactory(access$getConfirmationModel$p, SummaryActivity.access$isCashierEnable(SummaryActivity.this));
                if (p0 != null) {
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    ActivityResultLauncher access$getCashierResultLauncher$p = SummaryActivity.access$getCashierResultLauncher$p(summaryActivity);
                    PayActivity.Companion companion = PayActivity.INSTANCE;
                    Context applicationContext = summaryActivity.getApplicationContext();
                    String cashierOrderId = p0.getCashierOrderId();
                    String fundOrderId = p0.getFundOrderId();
                    String groupOrderId = p0.getGroupOrderId();
                    String orderId = p0.getOrderId();
                    ConfirmationModel access$getConfirmationModel$p2 = SummaryActivity.access$getConfirmationModel$p(summaryActivity);
                    PlaceComponentResult2 = PayActivity.Companion.PlaceComponentResult(applicationContext, cashierOrderId, fundOrderId, groupOrderId, orderId, access$getConfirmationModel$p2 != null ? access$getConfirmationModel$p2.getOnBoardingScenario() : null, null, SummaryActivity.access$setOrderTitleCashierFromSummary(summaryActivity), "", 0L, SummaryActivity.access$getFeatureTime(summaryActivity));
                    access$getCashierResultLauncher$p.MyBillsEntityDataFactory(PlaceComponentResult2, null);
                }
            }

            @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                if (Intrinsics.areEqual(SummaryActivity.access$getOriginPayMethod$p(SummaryActivity.this), "BALANCE")) {
                    SummaryActivity.this.getSendMoneyConfirmationPresenter().BuiltInFictitiousFunctionClassFactory();
                }
                dismissProgress();
                if (p0) {
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    SummaryActivity.access$backToHomepage(summaryActivity, SummaryActivity.access$createSendMoneyBundleData(summaryActivity));
                    Bundle extras = SummaryActivity.this.getIntent().getExtras();
                    boolean z = false;
                    if (extras != null && extras.getBoolean("is_from_payroll")) {
                        z = true;
                    }
                    if (z) {
                        CloseSubAppBridge.INSTANCE.setForceEventTop(true);
                    }
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                SummaryActivity.this.showDanaLoadingDialog();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                SummaryActivity.this.dismissDanaLoadingDialog();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SummaryActivity.this.showWarningDialog(p0);
            }
        };
        int i = P + 51;
        L = i % 128;
        if (!(i % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
            return view;
        }
        return view;
    }

    private final FeatureTimeModel NetworkUserEntityData$$ExternalSyntheticLambda2() {
        FeatureTimeModel featureTimeModel;
        int i = P + 123;
        L = i % 128;
        int i2 = i % 2;
        ConfirmationModel confirmationModel = this.getErrorConfigVersion;
        if (confirmationModel != null) {
            NetworkUserEntityData$$ExternalSyntheticLambda7();
            featureTimeModel = new FeatureTimeModel(SendMoneyFeatureTime.PlaceComponentResult(confirmationModel), CollectionsKt.sumOfLong(NetworkUserEntityData$$ExternalSyntheticLambda7().getAuthRequestContext.values()));
        } else {
            featureTimeModel = new FeatureTimeModel(null, 0L, 3, null);
        }
        int i3 = L + 27;
        P = i3 % 128;
        if ((i3 % 2 == 0 ? '/' : '3') != '3') {
            int i4 = 52 / 0;
            return featureTimeModel;
        }
        return featureTimeModel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0019, code lost:
    
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0020, code lost:
    
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0022, code lost:
    
        r0 = r0.getOnBoardingScenario();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0027, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 9;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
        r0 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String K() {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.K():java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:135:0x00b6
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.sendmoney.model.ConfirmationModel r7) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.sendmoney.model.ConfirmationModel):void");
    }

    private static Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IntentKeySource.TransactionKey.ON_TRANSACTION_SUCCESS, true);
        int i = P + 9;
        L = i % 128;
        int i2 = i % 2;
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v6 */
    private final void PlaceComponentResult(String p0) {
        PayMethodModel payMethodModel;
        try {
            int i = L + 7;
            P = i % 128;
            CurrencyAmountModel currencyAmountModel = 0;
            if (i % 2 == 0) {
                payMethodModel = this.payMethodModel;
                int length = currencyAmountModel.length;
                if (payMethodModel == null) {
                    return;
                }
            } else {
                payMethodModel = this.payMethodModel;
                if ((payMethodModel != null ? 'R' : '\'') == '\'') {
                    return;
                }
            }
            if ((VerifyPinStateManager$executeRiskChallenge$2$2() ? (char) 18 : 'R') == 18) {
                int i2 = P + 119;
                L = i2 % 128;
                int i3 = i2 % 2;
                try {
                    CurrencyAmountModel currencyAmountModel2 = this.E;
                    if (currencyAmountModel2 == null) {
                        int i4 = L + 47;
                        P = i4 % 128;
                        int i5 = i4 % 2;
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        currencyAmountModel2 = null;
                    }
                    payMethodModel.DatabaseTableConfigUtil = currencyAmountModel2;
                    CurrencyAmountModel currencyAmountModel3 = this.A;
                    if (currencyAmountModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        currencyAmountModel = currencyAmountModel3;
                    }
                    payMethodModel.GetContactSyncConfig = currencyAmountModel;
                } catch (Exception e) {
                    throw e;
                }
            }
            boolean z = false;
            if (p0.length() > 0) {
                int i6 = P + 99;
                L = i6 % 128;
                int i7 = i6 % 2;
                z = true;
            }
            if (z) {
                getSendMoneySummaryPresenter().PlaceComponentResult(new CurrencyAmountModel(p0), payMethodModel);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0040, code lost:
    
        if ((r2 != null ? 'K' : 18) != 'K') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0043, code lost:
    
        r5 = r2.readMicros;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x004b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, "contact") != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x004d, code lost:
    
        r2 = (id.dana.richview.CurrencyTextView) _$_findCachedViewById(id.dana.R.id.OrderQueryResult);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0055, code lost:
    
        if (r2 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0057, code lost:
    
        r2.setText(r10);
        r2 = id.dana.sendmoney.summary.SummaryActivity.P + 67;
        id.dana.sendmoney.summary.SummaryActivity.L = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0066, code lost:
    
        r1 = (androidx.constraintlayout.widget.ConstraintLayout) _$_findCachedViewById(id.dana.R.id.clStickySummaryFee);
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0072, code lost:
    
        if (r1 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0074, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x007e, code lost:
    
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r10, "0")) == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0080, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0082, code lost:
    
        r7 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0084, code lost:
    
        r1.setVisibility(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0087, code lost:
    
        r1 = (id.dana.richview.CurrencyTextView) _$_findCachedViewById(id.dana.R.id.OrderQueryResult);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0091, code lost:
    
        if (r1 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0093, code lost:
    
        r8 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0096, code lost:
    
        r8 = '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0098, code lost:
    
        if (r8 == 'G') goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x009b, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00a5, code lost:
    
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r10, "0")) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00a7, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00a9, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00aa, code lost:
    
        if (r7 == true) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00ac, code lost:
    
        r6 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00af, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00b0, code lost:
    
        r1.setVisibility(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00b3, code lost:
    
        r1 = (androidx.appcompat.widget.AppCompatTextView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a13b4_defaultmeter_noopdoubleupdowncounter);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00bb, code lost:
    
        if (r1 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00bd, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00c6, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r10, "0") == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00c9, code lost:
    
        r5 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00cb, code lost:
    
        r1.setVisibility(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00ce, code lost:
    
        r5 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x002f, code lost:
    
        if (r2 != null) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getErrorConfigVersion(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getErrorConfigVersion(java.lang.String):void");
    }

    private final void getAuthRequestContext(AppCompatImageView appCompatImageView, String str, int i) {
        int i2 = P + 23;
        L = i2 % 128;
        Object[] objArr = null;
        if ((i2 % 2 != 0 ? (char) 28 : (char) 4) != 4) {
            GlideApp.PlaceComponentResult(this).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            objArr.hashCode();
        } else {
            GlideApp.PlaceComponentResult(this).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory((ImageView) appCompatImageView);
        }
        try {
            int i3 = L + 53;
            P = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 27 : '!') != '!') {
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0015, code lost:
    
        if (r0 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0026, code lost:
    
        if ((r0 == null) != true) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0039, code lost:
    
        if (r0.getState() == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0049, code lost:
    
        if ((r0.getState() == 4 ? 'B' : 31) != 'B') goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void PlaceComponentResult(id.dana.sendmoney.summary.SummaryActivity r5) {
        /*
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 49
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            java.lang.String r1 = ""
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1c
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch: java.lang.Exception -> L1a
            com.google.android.material.bottomsheet.BottomSheetBehavior<com.google.android.material.card.MaterialCardView> r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L1a
            if (r0 == 0) goto L18
            goto L28
        L18:
            r2 = 1
            goto L59
        L1a:
            r5 = move-exception
            throw r5
        L1c:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            com.google.android.material.bottomsheet.BottomSheetBehavior<com.google.android.material.card.MaterialCardView> r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r0 == 0) goto L25
            r1 = 0
            goto L26
        L25:
            r1 = 1
        L26:
            if (r1 == r3) goto L59
        L28:
            int r1 = id.dana.sendmoney.summary.SummaryActivity.P
            int r1 = r1 + 65
            int r4 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r4
            int r1 = r1 % 2
            r4 = 4
            if (r1 == 0) goto L3c
            int r0 = r0.getState()
            if (r0 != r4) goto L18
            goto L4c
        L3c:
            int r0 = r0.getState()
            r1 = 66
            if (r0 != r4) goto L47
            r0 = 66
            goto L49
        L47:
            r0 = 31
        L49:
            if (r0 == r1) goto L4c
            goto L59
        L4c:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P     // Catch: java.lang.Exception -> L57
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1     // Catch: java.lang.Exception -> L57
            int r0 = r0 % 2
            goto L18
        L57:
            r5 = move-exception
            throw r5
        L59:
            if (r2 == 0) goto L69
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            r5.moveToNextValue()
            return
        L69:
            r5.BuiltInFictitiousFunctionClassFactory()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.PlaceComponentResult(id.dana.sendmoney.summary.SummaryActivity):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x001f, code lost:
    
        if (r0 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x002c, code lost:
    
        if (r0 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x002e, code lost:
    
        r0.setOnClickListener(new id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda5(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0036, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 29;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0041, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0042, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void whenAvailable() {
        /*
            r2 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r1 = 23
            if (r0 != 0) goto L11
            r0 = 53
            goto L13
        L11:
            r0 = 23
        L13:
            if (r0 == r1) goto L24
            int r0 = id.dana.R.id.clPayMethodContainer
            android.view.View r0 = r2._$_findCachedViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L43
            goto L2e
        L22:
            r0 = move-exception
            throw r0
        L24:
            int r0 = id.dana.R.id.clPayMethodContainer
            android.view.View r0 = r2._$_findCachedViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L43
        L2e:
            id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda5 r1 = new id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda5
            r1.<init>()
            r0.setOnClickListener(r1)
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P     // Catch: java.lang.Exception -> L41
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1     // Catch: java.lang.Exception -> L41
            int r0 = r0 % 2
            goto L43
        L41:
            r0 = move-exception
            throw r0
        L43:
            r2.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.whenAvailable():void");
    }

    private final void G() {
        DanaButtonPrimaryView danaButtonPrimaryView;
        try {
            int i = L + 19;
            P = i % 128;
            if (i % 2 != 0) {
                danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.R);
                if (danaButtonPrimaryView == null) {
                    return;
                }
            } else {
                danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.R);
                Object[] objArr = null;
                int length = objArr.length;
                if (danaButtonPrimaryView == null) {
                    return;
                }
            }
            danaButtonPrimaryView.setOnClickListener(new SingleClickListener() { // from class: id.dana.sendmoney.summary.SummaryActivity$onAmountValidAndActionConfirmed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(SummaryActivity.this);
                }

                @Override // id.dana.base.SingleClickListener
                public final void PlaceComponentResult(View p0) {
                    RecipientModel access$getRecipientModel$p = SummaryActivity.access$getRecipientModel$p(SummaryActivity.this);
                    if (access$getRecipientModel$p != null) {
                        access$getRecipientModel$p.NetworkUserEntityData$$ExternalSyntheticLambda4 = "";
                    }
                    RecipientModel access$getRecipientModel$p2 = SummaryActivity.access$getRecipientModel$p(SummaryActivity.this);
                    if (access$getRecipientModel$p2 != null) {
                        PayMethodModel payMethodModel = SummaryActivity.this.getPayMethodModel();
                        Intrinsics.checkNotNull(payMethodModel);
                        access$getRecipientModel$p2.A = (int) payMethodModel.scheduleImpl;
                    }
                    SummaryValidateModel summaryValidateModel = new SummaryValidateModel(SummaryActivity.access$getRecipientModel$p(SummaryActivity.this), SummaryActivity.this.amountToSend(), SummaryActivity.this.getPayMethodModel(), SummaryActivity.access$getRemarks$p(SummaryActivity.this), SummaryActivity.access$getSelectedVoucher$p(SummaryActivity.this), SummaryActivity.access$getWithdrawOTCModel$p(SummaryActivity.this));
                    SendMoneySummary access$getSendMoneySummary$p = SummaryActivity.access$getSendMoneySummary$p(SummaryActivity.this);
                    if (access$getSendMoneySummary$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        access$getSendMoneySummary$p = null;
                    }
                    access$getSendMoneySummary$p.getAuthRequestContext(summaryValidateModel);
                    SummaryActivity.access$getSendMoneyFeatureTime(SummaryActivity.this).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                }
            });
            int i2 = P + 9;
            L = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        Object obj = null;
        this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String.MyBillsEntityDataFactory(new Intent(this, SuspiciousAccountActivity.class), null);
        int i = P + 43;
        L = i % 128;
        if ((i % 2 != 0 ? 'P' : 'L') != 'P') {
            return;
        }
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0014, code lost:
    
        if (((r5 & 1) == 0) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x001b, code lost:
    
        if (((r5 & 1) != 0) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x001d, code lost:
    
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void getAuthRequestContext$default(id.dana.sendmoney.summary.SummaryActivity r3, id.dana.sendmoney.model.ExpiryInfoModel r4, int r5, java.lang.Object r6) {
        /*
            int r6 = id.dana.sendmoney.summary.SummaryActivity.P
            int r6 = r6 + 15
            int r0 = r6 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r0
            int r6 = r6 % 2
            r0 = 0
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L17
            r5 = r5 & r2
            if (r5 == 0) goto L13
            goto L14
        L13:
            r1 = 1
        L14:
            if (r1 == 0) goto L1d
            goto L1e
        L17:
            r5 = r5 & r2
            if (r5 == 0) goto L1b
            r1 = 1
        L1b:
            if (r1 == 0) goto L1e
        L1d:
            r4 = r0
        L1e:
            r3.getAuthRequestContext(r4)
            int r3 = id.dana.sendmoney.summary.SummaryActivity.L
            int r3 = r3 + 101
            int r4 = r3 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L33
            r0.hashCode()     // Catch: java.lang.Throwable -> L31
            return
        L31:
            r3 = move-exception
            throw r3
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getAuthRequestContext$default(id.dana.sendmoney.summary.SummaryActivity, id.dana.sendmoney.model.ExpiryInfoModel, int, java.lang.Object):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0052, code lost:
    
        if ((r5 != null) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0073, code lost:
    
        if ((r5 == null ? kotlin.text.Typography.quote : '?') != '?') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0075, code lost:
    
        r1 = id.dana.sendmoney.summary.SummaryActivity.P + 11;
        id.dana.sendmoney.summary.SummaryActivity.L = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x007f, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0081, code lost:
    
        r1 = id.dana.sendmoney.summary.SummaryActivity.P + 75;
        id.dana.sendmoney.summary.SummaryActivity.L = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0091, code lost:
    
        r0.getAuthRequestContext(r2, r3, r4, r5, java.lang.String.valueOf(r9.KClassImpl$Data$declaredNonStaticMembers$2()), r8.NetworkUserEntityData$$ExternalSyntheticLambda4, r8.FragmentBottomSheetPaymentSettingBinding);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00a0, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.sendmoney.model.ExpiryInfoModel r9) {
        /*
            r8 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            r0 = 84
            if (r9 == 0) goto L11
            r1 = 84
            goto L13
        L11:
            r1 = 12
        L13:
            if (r1 == r0) goto L2c
            id.dana.contract.sendmoney.ExpiryContract$Presenter r9 = r8.getExpiryPresenter()     // Catch: java.lang.Exception -> L2a
            r9.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> L27
            int r9 = id.dana.sendmoney.summary.SummaryActivity.P
            int r9 = r9 + 43
            int r0 = r9 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r0
            int r9 = r9 % 2
            return
        L27:
            r9 = move-exception
            goto La1
        L2a:
            r9 = move-exception
            goto L8c
        L2c:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L57
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r0 = r8.getSendMoneySummaryPresenter()
            id.dana.sendmoney.model.RecipientModel r2 = r8.NetworkUserEntityData$$ExternalSyntheticLambda6
            id.dana.model.CurrencyAmountModel r3 = r8.amountToSend()
            id.dana.model.PayMethodModel r4 = r8.payMethodModel
            r5 = r8
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r5 = r9.KClassImpl$Data$declaredNonStaticMembers$2(r5)
            r6 = 17
            r7 = 0
            int r6 = r6 / r7
            if (r5 != 0) goto L52
            r1 = 0
        L52:
            if (r1 == 0) goto L75
            goto L8d
        L55:
            r9 = move-exception
            throw r9
        L57:
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r0 = r8.getSendMoneySummaryPresenter()
            id.dana.sendmoney.model.RecipientModel r2 = r8.NetworkUserEntityData$$ExternalSyntheticLambda6
            id.dana.model.CurrencyAmountModel r3 = r8.amountToSend()
            id.dana.model.PayMethodModel r4 = r8.payMethodModel
            r1 = r8
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r5 = r9.KClassImpl$Data$declaredNonStaticMembers$2(r1)
            r1 = 63
            if (r5 != 0) goto L71
            r6 = 34
            goto L73
        L71:
            r6 = 63
        L73:
            if (r6 == r1) goto L8d
        L75:
            int r1 = id.dana.sendmoney.summary.SummaryActivity.P
            int r1 = r1 + 11
            int r5 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r5
            int r1 = r1 % 2
            java.lang.String r5 = ""
            int r1 = id.dana.sendmoney.summary.SummaryActivity.P
            int r1 = r1 + 75
            int r6 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r6
            int r1 = r1 % 2
            goto L8d
        L8c:
            throw r9
        L8d:
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            int r9 = r9.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> L27
            java.lang.String r6 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4     // Catch: java.lang.Exception -> L27
            id.dana.sendmoney.model.VoucherModel r7 = r8.FragmentBottomSheetPaymentSettingBinding     // Catch: java.lang.Exception -> L27
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L27
            r0.getAuthRequestContext(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L27
            return
        La1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getAuthRequestContext(id.dana.sendmoney.model.ExpiryInfoModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0016, code lost:
    
        if (r0 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x001b, code lost:
    
        if (r0 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x001d, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 111;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0027, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x002a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x002c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002d, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x002e, code lost:
    
        r0 = KClassImpl$Data$declaredNonStaticMembers$2(r0).getUnit();
        r1 = r12.NetworkUserEntityData$$ExternalSyntheticLambda2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0039, code lost:
    
        if (r1 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x003b, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003d, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003e, code lost:
    
        if (r5 == true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0041, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0045, code lost:
    
        r8 = MyBillsEntityDataFactory(r0, KClassImpl$Data$declaredNonStaticMembers$2(r1).getValue());
        r4 = getSendMoneySummaryPresenter();
        r5 = r12.NetworkUserEntityData$$ExternalSyntheticLambda6;
        r6 = amountToSend();
        r7 = r12.payMethodModel;
        r0 = r12.NetworkUserEntityData$$ExternalSyntheticLambda2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0061, code lost:
    
        if (r0 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0063, code lost:
    
        r9 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0065, code lost:
    
        r9 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0067, code lost:
    
        if (r9 == 22) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0069, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 115;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0077, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0078, code lost:
    
        r4.getAuthRequestContext(r5, r6, r7, r8, KClassImpl$Data$declaredNonStaticMembers$2(r3).getValue(), r12.NetworkUserEntityData$$ExternalSyntheticLambda4, r12.FragmentBottomSheetPaymentSettingBinding);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0087, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void L() {
        /*
            r12 = this;
            java.util.List<id.dana.domain.featureconfig.model.ExpiryTimeConfig> r0 = r12.NetworkUserEntityData$$ExternalSyntheticLambda2
            if (r0 == 0) goto L8a
            int r1 = id.dana.sendmoney.summary.SummaryActivity.L     // Catch: java.lang.Exception -> L88
            int r1 = r1 + 109
            int r2 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r2
            int r1 = r1 % 2
            java.lang.String r2 = ""
            r3 = 0
            if (r1 != 0) goto L1b
            r3.hashCode()     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L2e
            goto L1d
        L19:
            r0 = move-exception
            throw r0
        L1b:
            if (r0 != 0) goto L2e
        L1d:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 111
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch: java.lang.Exception -> L2c
            r0 = r3
            goto L2e
        L2c:
            r0 = move-exception
            throw r0
        L2e:
            id.dana.domain.featureconfig.model.ExpiryTimeConfig r0 = KClassImpl$Data$declaredNonStaticMembers$2(r0)
            java.lang.String r0 = r0.getUnit()
            java.util.List<id.dana.domain.featureconfig.model.ExpiryTimeConfig> r1 = r12.NetworkUserEntityData$$ExternalSyntheticLambda2
            r4 = 1
            if (r1 != 0) goto L3d
            r5 = 1
            goto L3e
        L3d:
            r5 = 0
        L3e:
            if (r5 == r4) goto L41
            goto L45
        L41:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r3
        L45:
            id.dana.domain.featureconfig.model.ExpiryTimeConfig r1 = KClassImpl$Data$declaredNonStaticMembers$2(r1)
            java.lang.String r1 = r1.getValue()
            java.lang.String r8 = r12.MyBillsEntityDataFactory(r0, r1)
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r4 = r12.getSendMoneySummaryPresenter()
            id.dana.sendmoney.model.RecipientModel r5 = r12.NetworkUserEntityData$$ExternalSyntheticLambda6
            id.dana.model.CurrencyAmountModel r6 = r12.amountToSend()
            id.dana.model.PayMethodModel r7 = r12.payMethodModel
            java.util.List<id.dana.domain.featureconfig.model.ExpiryTimeConfig> r0 = r12.NetworkUserEntityData$$ExternalSyntheticLambda2
            r1 = 22
            if (r0 != 0) goto L65
            r9 = 7
            goto L67
        L65:
            r9 = 22
        L67:
            if (r9 == r1) goto L77
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L78
        L77:
            r3 = r0
        L78:
            id.dana.domain.featureconfig.model.ExpiryTimeConfig r0 = KClassImpl$Data$declaredNonStaticMembers$2(r3)
            java.lang.String r9 = r0.getValue()
            java.lang.String r10 = r12.NetworkUserEntityData$$ExternalSyntheticLambda4
            id.dana.sendmoney.model.VoucherModel r11 = r12.FragmentBottomSheetPaymentSettingBinding
            r4.getAuthRequestContext(r5, r6, r7, r8, r9, r10, r11)
            return
        L88:
            r0 = move-exception
            goto L92
        L8a:
            id.dana.sendmoney.namecheck.SendMoneySummaryContract$Presenter r0 = r12.getSendMoneySummaryPresenter()     // Catch: java.lang.Exception -> L88
            r0.PlaceComponentResult()     // Catch: java.lang.Exception -> L88
            return
        L92:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.L():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0020, code lost:
    
        if ((r0 != null ? 30 : 'E') != 'E') goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0031, code lost:
    
        if ((r0 != null ? 'c' : 7) != 'c') goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0034, code lost:
    
        r1 = id.dana.sendmoney.summary.SummaryActivity.P + 117;
        id.dana.sendmoney.summary.SummaryActivity.L = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x003f, code lost:
    
        if ((r1 % 2) == 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0041, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0043, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0044, code lost:
    
        if (r1 == true) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0047, code lost:
    
        r0.setState(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x004b, code lost:
    
        r0.setState(5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x004f, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 39;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0059, code lost:
    
        id.dana.utils.KeyboardHelper.BuiltInFictitiousFunctionClassFactory(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x005f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void moveToNextValue() {
        /*
            r3 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P     // Catch: java.lang.Exception -> L64
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1     // Catch: java.lang.Exception -> L64
            int r0 = r0 % 2
            r1 = 43
            if (r0 == 0) goto L11
            r0 = 43
            goto L13
        L11:
            r0 = 87
        L13:
            if (r0 == r1) goto L23
            com.google.android.material.bottomsheet.BottomSheetBehavior<com.google.android.material.card.MaterialCardView> r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0
            r1 = 69
            if (r0 == 0) goto L1e
            r2 = 30
            goto L20
        L1e:
            r2 = 69
        L20:
            if (r2 == r1) goto L59
            goto L34
        L23:
            com.google.android.material.bottomsheet.BottomSheetBehavior<com.google.android.material.card.MaterialCardView> r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L62
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L60
            r1 = 99
            if (r0 == 0) goto L30
            r2 = 99
            goto L31
        L30:
            r2 = 7
        L31:
            if (r2 == r1) goto L34
            goto L59
        L34:
            int r1 = id.dana.sendmoney.summary.SummaryActivity.P
            int r1 = r1 + 117
            int r2 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r2
            int r1 = r1 % 2
            r2 = 1
            if (r1 == 0) goto L43
            r1 = 1
            goto L44
        L43:
            r1 = 0
        L44:
            if (r1 == r2) goto L4b
            r1 = 3
            r0.setState(r1)     // Catch: java.lang.Exception -> L64
            goto L4f
        L4b:
            r1 = 5
            r0.setState(r1)
        L4f:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 39
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
        L59:
            r0 = r3
            android.app.Activity r0 = (android.app.Activity) r0
            id.dana.utils.KeyboardHelper.BuiltInFictitiousFunctionClassFactory(r0)
            return
        L60:
            r0 = move-exception
            throw r0
        L62:
            r0 = move-exception
            throw r0
        L64:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.moveToNextValue():void");
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        try {
            BottomSheetBehavior<MaterialCardView> bottomSheetBehavior = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (bottomSheetBehavior != null) {
                try {
                    int i = P + 75;
                    L = i % 128;
                    int i2 = i % 2;
                    bottomSheetBehavior.setState(4);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = L + 39;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void getNameOrBuilderList() {
        SkeletonScreen skeletonScreen = this.getSupportButtonTintMode;
        if (skeletonScreen != null) {
            if (!(skeletonScreen == null)) {
                skeletonScreen.MyBillsEntityDataFactory();
                int i = P + 45;
                L = i % 128;
                int i2 = i % 2;
            }
            int i3 = L + 119;
            P = i3 % 128;
            if ((i3 % 2 != 0 ? (byte) 1 : (byte) 0) != 1) {
                Object[] objArr = null;
                int length = objArr.length;
                return;
            }
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_pay_sticky;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, r1);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.getSupportButtonTintMode = viewSkeletonScreen;
        int i4 = P + 39;
        L = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0017, code lost:
    
        if (r0 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0027, code lost:
    
        if ((r0 != null ? 31 : 27) != 27) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0029, code lost:
    
        r0.PlaceComponentResult();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void SubSequence() {
        /*
            r3 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P     // Catch: java.lang.Exception -> L3c
            int r0 = r0 + 111
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1     // Catch: java.lang.Exception -> L3a
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 == 0) goto L1c
            com.ethanhua.skeleton.SkeletonScreen r0 = r3.getSupportButtonTintMode
            r2 = 66
            int r2 = r2 / r1
            if (r0 == 0) goto L2c
            goto L29
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            com.ethanhua.skeleton.SkeletonScreen r0 = r3.getSupportButtonTintMode
            r1 = 27
            if (r0 == 0) goto L25
            r2 = 31
            goto L27
        L25:
            r2 = 27
        L27:
            if (r2 == r1) goto L2c
        L29:
            r0.PlaceComponentResult()
        L2c:
            r0 = 0
            r3.getSupportButtonTintMode = r0
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 103
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            return
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.SubSequence():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0053, code lost:
    
        if (r0 != null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0069, code lost:
    
        if ((r0 != null ? 'B' : 'E') != 'E') goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x006b, code lost:
    
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x006e, code lost:
    
        r0 = (androidx.appcompat.widget.AppCompatImageView) _$_findCachedViewById(id.dana.R.id.ivAccountDetail);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0076, code lost:
    
        if (r0 == null) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0078, code lost:
    
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x007f, code lost:
    
        if (r11.getErrorConfigVersion() == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0081, code lost:
    
        r11 = (androidx.appcompat.widget.AppCompatImageView) _$_findCachedViewById(id.dana.R.id.unmodifiableSortedSetMultimap);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0089, code lost:
    
        if (r11 == null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x008b, code lost:
    
        getAuthRequestContext(r11, "", id.dana.R.drawable.ic_oneklik_v2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0092, code lost:
    
        r11 = (androidx.appcompat.widget.AppCompatImageView) _$_findCachedViewById(id.dana.R.id.unmodifiableSortedSetMultimap);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x009a, code lost:
    
        if (r11 == null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x009c, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 83;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
        getAuthRequestContext(r11, "", id.dana.R.drawable.ic_express_pay_v2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x00a9, code lost:
    
        r11 = (androidx.appcompat.widget.AppCompatImageView) _$_findCachedViewById(id.dana.R.id.unmodifiableSortedSetMultimap);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x00b1, code lost:
    
        if (r11 == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x00b3, code lost:
    
        r11.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x017f, code lost:
    
        if (r11 != null) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0193, code lost:
    
        if ((r11 != null ? '/' : '\b') != '/') goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0196, code lost:
    
        r11.setVisibility(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.model.PayMethodModel r11) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.getAuthRequestContext(id.dana.model.PayMethodModel):void");
    }

    private final boolean F() {
        try {
            int i = L + 109;
            P = i % 128;
            int i2 = i % 2;
            SummaryViewState summaryViewState = this.BottomSheetCardBindingView$watcherCardNumberView$1;
            SummaryViewState summaryViewState2 = null;
            if (summaryViewState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                summaryViewState = null;
            }
            if (summaryViewState.getErrorConfigVersion()) {
                SummaryViewState summaryViewState3 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
                if (summaryViewState3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    summaryViewState2 = summaryViewState3;
                }
                try {
                    if (summaryViewState2.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                        return false;
                    }
                    int i3 = L + 39;
                    P = i3 % 128;
                    return !(i3 % 2 == 0);
                } catch (Exception e) {
                    throw e;
                }
            }
            return false;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x001e, code lost:
    
        if (r0 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0028, code lost:
    
        if (r0 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002a, code lost:
    
        if (r0 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002c, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0030, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0037, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, "3.0") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0039, code lost:
    
        r6 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) _$_findCachedViewById(id.dana.R.id.btnNextCashierNative);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0041, code lost:
    
        if (r6 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0044, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0045, code lost:
    
        if (r1 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0047, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 51;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
        r6.setEnabled(false);
        r6.setDisabled(getString(id.dana.R.string.sendmoney_summary_continue));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x005e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setDisabledWithAmount(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            java.lang.String r4 = ""
            if (r0 == 0) goto L23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            java.lang.String r0 = r5.VerifyPinStateManager$executeRiskChallenge$2$1
            r3.hashCode()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L5f
            goto L2a
        L21:
            r6 = move-exception
            throw r6
        L23:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            java.lang.String r0 = r5.VerifyPinStateManager$executeRiskChallenge$2$1
            if (r0 == 0) goto L5f
        L2a:
            if (r0 != 0) goto L30
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L31
        L30:
            r3 = r0
        L31:
            java.lang.String r0 = "3.0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r0 == 0) goto L5f
            int r6 = id.dana.R.id.btnNextCashierNative
            android.view.View r6 = r5._$_findCachedViewById(r6)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r6 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r6
            if (r6 == 0) goto L44
            goto L45
        L44:
            r1 = 0
        L45:
            if (r1 == 0) goto L80
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 51
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r6.setEnabled(r2)
            r0 = 2131957011(0x7f131513, float:1.9550594E38)
            java.lang.String r0 = r5.getString(r0)
            r6.setDisabled(r0)
            return
        L5f:
            int r0 = id.dana.R.id.R
            android.view.View r0 = r5._$_findCachedViewById(r0)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r0 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r0
            if (r0 == 0) goto L80
            r0.setEnabled(r2)
            r1 = 2131957016(0x7f131518, float:1.9550604E38)
            java.lang.String r1 = r5.getString(r1)
            r0.setDisabledWithAmount(r1, r6)
            int r6 = id.dana.sendmoney.summary.SummaryActivity.L
            int r6 = r6 + 107
            int r0 = r6 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r0
            int r6 = r6 % 2
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.setDisabledWithAmount(java.lang.String):void");
    }

    public final void setEnableButtonWithAmount(String amount) {
        DanaButtonPrimaryView danaButtonPrimaryView;
        Intrinsics.checkNotNullParameter(amount, "");
        String str = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if ((str != null ? (char) 14 : (char) 23) != 23) {
            int i = L + 67;
            P = i % 128;
            int i2 = i % 2;
            Object obj = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            if (Intrinsics.areEqual(str, "3.0")) {
                int i3 = P + 119;
                L = i3 % 128;
                if (i3 % 2 != 0) {
                    danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnNextCashierNative);
                    obj.hashCode();
                    if (danaButtonPrimaryView == null) {
                        return;
                    }
                } else {
                    danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnNextCashierNative);
                    if (danaButtonPrimaryView == null) {
                        return;
                    }
                }
                danaButtonPrimaryView.setEnabled(true);
                danaButtonPrimaryView.setActiveButton(getString(R.string.sendmoney_summary_continue), null);
                readMicros();
                return;
            }
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.R);
        if ((danaButtonPrimaryView2 != null ? 'N' : ':') != ':') {
            danaButtonPrimaryView2.setEnabled(true);
            danaButtonPrimaryView2.setActiveButtonLeftAlignWithAmount(getString(R.string.sendmoney_summary_pay_button), amount);
        }
    }

    public final void showDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(this);
        this.GetContactSyncConfig = danaLoadingDialog;
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        int i = L + 81;
        P = i % 128;
        if ((i % 2 == 0 ? ':' : 'Q') != ':') {
            try {
                danaLoadingDialog.MyBillsEntityDataFactory.show();
                danaLoadingDialog.getAuthRequestContext.startRefresh();
            } catch (Exception e) {
                throw e;
            }
        } else {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = P + 51;
            L = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void dismissDanaLoadingDialog() {
        int i = L + 95;
        P = i % 128;
        int i2 = i % 2;
        DanaLoadingDialog danaLoadingDialog = this.GetContactSyncConfig;
        if ((danaLoadingDialog != null ? '#' : 'U') != 'U') {
            int i3 = L + 73;
            P = i3 % 128;
            char c = i3 % 2 == 0 ? 'b' : (char) 29;
            danaLoadingDialog.PlaceComponentResult();
            if (c == 'b') {
                int i4 = 24 / 0;
            }
        }
        int i5 = P + 73;
        L = i5 % 128;
        int i6 = i5 % 2;
    }

    private final void AppCompatEmojiTextHelper() {
        try {
            MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.SendCashierOneKlikOtpRequest);
            if ((materialCardView != null ? 'Z' : 'F') == 'Z') {
                materialCardView.measure(0, 0);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1);
            if (constraintLayout != null) {
                int i = P + 59;
                L = i % 128;
                int i2 = i % 2;
                constraintLayout.measure(0, 0);
            }
            int i3 = P + 111;
            L = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x001b, code lost:
    
        if ((r0 == null) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002e, code lost:
    
        if ((r0 != null ? 11 : '%') != 11) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0031, code lost:
    
        r0.setPeekHeight(((androidx.constraintlayout.widget.ConstraintLayout) _$_findCachedViewById(id.dana.R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1)).getMeasuredHeight() + ((androidx.constraintlayout.widget.ConstraintLayout) _$_findCachedViewById(id.dana.R.id.clPayMethodContainer)).getMeasuredHeight());
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x004d, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 111;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0057, code lost:
    
        if ((r0 % 2) == 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x005a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x005b, code lost:
    
        if (r2 == true) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x005d, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x005e, code lost:
    
        r0 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x005f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0062, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void O() {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L20
            r5.AppCompatEmojiTextHelper()
            com.google.android.material.bottomsheet.BottomSheetBehavior<com.google.android.material.card.MaterialCardView> r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            r3 = 12
            int r3 = r3 / r2
            if (r0 == 0) goto L1a
            r3 = 0
            goto L1b
        L1a:
            r3 = 1
        L1b:
            if (r3 == 0) goto L31
            goto L4d
        L1e:
            r0 = move-exception
            throw r0
        L20:
            r5.AppCompatEmojiTextHelper()
            com.google.android.material.bottomsheet.BottomSheetBehavior<com.google.android.material.card.MaterialCardView> r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            r3 = 11
            if (r0 == 0) goto L2c
            r4 = 11
            goto L2e
        L2c:
            r4 = 37
        L2e:
            if (r4 == r3) goto L31
            goto L4d
        L31:
            int r3 = id.dana.R.id.res_0x7f0a03dd_imagewithdescriptionview_showimage_1
            android.view.View r3 = r5._$_findCachedViewById(r3)
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            int r3 = r3.getMeasuredHeight()
            int r4 = id.dana.R.id.clPayMethodContainer
            android.view.View r4 = r5._$_findCachedViewById(r4)
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            int r4 = r4.getMeasuredHeight()
            int r3 = r3 + r4
            r0.setPeekHeight(r3)
        L4d:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 111
            int r3 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L5a
            goto L5b
        L5a:
            r2 = 1
        L5b:
            if (r2 == r1) goto L62
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L60
            return
        L60:
            r0 = move-exception
            throw r0
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.O():void");
    }

    private final void PlaceComponentResult(boolean p0) {
        try {
            if (p0) {
                int i = P + 121;
                L = i % 128;
                int i2 = i % 2;
                AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.Type);
                if (appCompatImageView != null) {
                    int i3 = L + 89;
                    P = i3 % 128;
                    if (!(i3 % 2 == 0)) {
                        appCompatImageView.setVisibility(4);
                    } else {
                        appCompatImageView.setVisibility(3);
                    }
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.BoundLongUpDownCounter);
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setVisibility(0);
                }
                View _$_findCachedViewById = _$_findCachedViewById(R.id.getMaxAppJavaHeapMemoryKb_res_0x7f0a0600);
                if ((_$_findCachedViewById != null ? JSONLexer.EOI : 'L') != 26) {
                    return;
                }
                int i4 = L + 49;
                P = i4 % 128;
                if ((i4 % 2 == 0 ? '_' : '6') != '_') {
                    _$_findCachedViewById.setVisibility(0);
                    return;
                } else {
                    _$_findCachedViewById.setVisibility(0);
                    return;
                }
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(R.id.Type);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setVisibility(0);
            }
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) _$_findCachedViewById(R.id.BoundLongUpDownCounter);
            if ((appCompatImageView4 != null ? JSONLexer.EOI : '\b') == 26) {
                appCompatImageView4.setVisibility(8);
            }
            View _$_findCachedViewById2 = _$_findCachedViewById(R.id.getMaxAppJavaHeapMemoryKb_res_0x7f0a0600);
            if (_$_findCachedViewById2 != null) {
                _$_findCachedViewById2.setVisibility(4);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0089, code lost:
    
        if (r0 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0092, code lost:
    
        if (r0 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0094, code lost:
    
        r1 = id.dana.sendmoney.summary.SummaryActivity.L + 75;
        id.dana.sendmoney.summary.SummaryActivity.P = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x009f, code lost:
    
        if ((r1 % 2) != 0) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00a1, code lost:
    
        r1 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00a4, code lost:
    
        r1 = '#';
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00a6, code lost:
    
        if (r1 == '#') goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00a8, code lost:
    
        r0.setState(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00ad, code lost:
    
        r0.setState(4);
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0027  */
    @Override // android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void getTransferInitCallback(TransferInit transferInit) {
        CurrencyAmount transferMaxAmount;
        int i = L + 73;
        P = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(transferInit, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = transferInit.isAccountFrozen();
            getSendMoneySummaryPresenter().MyBillsEntityDataFactory();
            getSendMoneySummaryPresenter().PlaceComponentResult();
            KClassImpl$Data$declaredNonStaticMembers$2(transferInit);
            boolean VerifyPinStateManager$executeRiskChallenge$2$2 = VerifyPinStateManager$executeRiskChallenge$2$2();
            int length = objArr.length;
            if (!(VerifyPinStateManager$executeRiskChallenge$2$2)) {
                return;
            }
        } else {
            try {
                Intrinsics.checkNotNullParameter(transferInit, "");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = transferInit.isAccountFrozen();
                getSendMoneySummaryPresenter().MyBillsEntityDataFactory();
                getSendMoneySummaryPresenter().PlaceComponentResult();
                KClassImpl$Data$declaredNonStaticMembers$2(transferInit);
                if (!VerifyPinStateManager$executeRiskChallenge$2$2()) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = P + 101;
        L = i2 % 128;
        int i3 = i2 % 2;
        TransferMethodView transferMethodView = transferInit.getTransferMethod().get(0);
        if (!(transferMethodView == null)) {
            int i4 = L + 69;
            P = i4 % 128;
            int i5 = i4 % 2;
            CurrencyAmount transferMinAmount = transferMethodView.getTransferMinAmount();
            if (transferMinAmount != null) {
                this.E = new CurrencyAmountModel(transferMinAmount);
            }
        }
        TransferMethodView transferMethodView2 = transferInit.getTransferMethod().get(0);
        if (transferMethodView2 == null) {
            return;
        }
        int i6 = P + 5;
        L = i6 % 128;
        if (i6 % 2 != 0) {
            transferMaxAmount = transferMethodView2.getTransferMaxAmount();
            int length2 = objArr.length;
            if (transferMaxAmount == null) {
                return;
            }
        } else {
            transferMaxAmount = transferMethodView2.getTransferMaxAmount();
            if (transferMaxAmount == null) {
                return;
            }
        }
        this.A = new CurrencyAmountModel(transferMaxAmount);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A() {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.A():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x002d, code lost:
    
        if (r0 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003f, code lost:
    
        if ((r0 != null ? 'I' : 'H') != 'H') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0041, code lost:
    
        r0 = r0.readMicros;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0044, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String PlaceComponentResult(java.util.List<java.lang.String> r4) {
        /*
            r3 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L5d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L5d
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r0 == 0) goto L17
            r1 = 0
        L17:
            if (r1 == 0) goto L1a
            goto L58
        L1a:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L32
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            id.dana.sendmoney.model.RecipientModel r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda6
            r1 = 93
            int r1 = r1 / r2
            if (r0 == 0) goto L44
            goto L41
        L30:
            r4 = move-exception
            throw r4
        L32:
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Exception -> L5d
            id.dana.sendmoney.model.RecipientModel r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda6     // Catch: java.lang.Exception -> L5b
            r1 = 72
            if (r0 == 0) goto L3d
            r2 = 73
            goto L3f
        L3d:
            r2 = 72
        L3f:
            if (r2 == r1) goto L44
        L41:
            java.lang.String r0 = r0.readMicros
            goto L45
        L44:
            r0 = 0
        L45:
            boolean r4 = kotlin.collections.CollectionsKt.contains(r4, r0)
            if (r4 == 0) goto L58
            int r4 = id.dana.sendmoney.summary.SummaryActivity.L
            int r4 = r4 + 11
            int r0 = r4 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r0
            int r4 = r4 % 2
            java.lang.String r4 = "3.0"
            goto L5a
        L58:
            java.lang.String r4 = "1.0"
        L5a:
            return r4
        L5b:
            r4 = move-exception
            throw r4
        L5d:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.PlaceComponentResult(java.util.List):java.lang.String");
    }

    private final UnitSymbolModel scheduleImpl() {
        String str;
        String string = getString(R.string.expiry_hour);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.expiry_hours);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = getString(R.string.expiry_day);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = getString(R.string.expiry_days);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        if ((str2 == null ? 'Q' : 'T') != 'Q') {
            str = str2;
        } else {
            int i = L + 107;
            P = i % 128;
            int i2 = i % 2;
            str = "";
        }
        UnitSymbolModel unitSymbolModel = new UnitSymbolModel(str, string, string2, string3, string4);
        int i3 = P + 51;
        L = i3 % 128;
        int i4 = i3 % 2;
        return unitSymbolModel;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.sendmoney.summary.SummaryActivity$getSummaryVoucherListener$1] */
    private final SummaryActivity$getSummaryVoucherListener$1 isLayoutRequested() {
        ?? r0 = new SummaryVoucherView.SummaryVoucherListener() { // from class: id.dana.sendmoney.summary.SummaryActivity$getSummaryVoucherListener$1
            @Override // id.dana.sendmoney.voucher.SummaryVoucherView.SummaryVoucherListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.sendmoney.voucher.SummaryVoucherView.SummaryVoucherListener
            public final void PlaceComponentResult(VoucherModel p0) {
                SummaryActivity.access$setSelectedVoucher$p(SummaryActivity.this, p0);
                SummaryActivity.access$updateBottomSheetSummaryPeekHeight(SummaryActivity.this);
                SummaryActivity summaryActivity = SummaryActivity.this;
                String str = summaryActivity.amountToSend().MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(str, "");
                SummaryActivity.access$checkAmountToSent(summaryActivity, str);
            }
        };
        try {
            int i = P + 41;
            L = i % 128;
            if ((i % 2 != 0 ? '.' : ']') != ']') {
                int i2 = 60 / 0;
                return r0;
            }
            return r0;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void moveToNextValue(String p0) {
        int i = P + 5;
        L = i % 128;
        int i2 = i % 2;
        NewShareToFeedsView newShareToFeedsView = (NewShareToFeedsView) _$_findCachedViewById(R.id.getNearbyMeMapViewFeature);
        if ((newShareToFeedsView != null ? '.' : (char) 31) == '.') {
            if ((StringsKt.isBlank(p0) ? 'S' : ')') != ')') {
                newShareToFeedsView.setCaption(NetworkUserEntityData$$ExternalSyntheticLambda0());
                int i3 = P + 45;
                L = i3 % 128;
                if (i3 % 2 != 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
                return;
            }
            newShareToFeedsView.setCaption(MyBillsEntityDataFactory(p0));
        }
        int i4 = P + 9;
        L = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        ?? r3 = 0;
        SmartFrictionBottomSheetFragment smartFrictionBottomSheetFragment = new SmartFrictionBottomSheetFragment(r3, new Function0<Unit>() { // from class: id.dana.sendmoney.summary.SummaryActivity$handleAccountFreezeSmartFriction$1
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
                SummaryActivity.this.finish();
            }
        }, 1, r3);
        Intrinsics.checkNotNullParameter("ACCOUNT_FREEZE", "");
        smartFrictionBottomSheetFragment.PlaceComponentResult = "ACCOUNT_FREEZE";
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        AndroidComponentUtilsKt.MyBillsEntityDataFactory(smartFrictionBottomSheetFragment, supportFragmentManager, "");
        int i = P + 99;
        L = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    private final void FragmentBottomSheetPaymentSettingBinding() {
        ?? r3 = 0;
        SmartFrictionBottomSheetFragment smartFrictionBottomSheetFragment = new SmartFrictionBottomSheetFragment(r3, new Function0<Unit>() { // from class: id.dana.sendmoney.summary.SummaryActivity$handleBlacklistAccountSmartFriction$1
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
                SummaryActivity.this.finish();
            }
        }, 1, r3);
        Intrinsics.checkNotNullParameter("BLACKLISTED_ACCOUNT", "");
        smartFrictionBottomSheetFragment.PlaceComponentResult = "BLACKLISTED_ACCOUNT";
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        AndroidComponentUtilsKt.MyBillsEntityDataFactory(smartFrictionBottomSheetFragment, supportFragmentManager, "");
        int i = P + 11;
        L = i % 128;
        int i2 = i % 2;
    }

    private final String GetContactSyncConfig() {
        String str;
        RecipientModel recipientModel = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        Object[] objArr = null;
        if (recipientModel != null) {
            int i = P + 119;
            L = i % 128;
            int i2 = i % 2;
            str = recipientModel.readMicros;
        } else {
            str = null;
        }
        if ((Intrinsics.areEqual(str, "contact") ? (char) 17 : '@') != '@') {
            int i3 = L + 31;
            P = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return "DANA Balance";
            }
            int length = objArr.length;
            return "DANA Balance";
        }
        if (Intrinsics.areEqual(str, "bank") ? false : true) {
            return "";
        }
        int i4 = P + 9;
        L = i4 % 128;
        int i5 = i4 % 2;
        return "BANK";
    }

    private final boolean VerifyPinStateManager$executeRiskChallenge$2$2() {
        String str = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if (str != null) {
            Object[] objArr = null;
            if (str == null) {
                int i = P + 9;
                L = i % 128;
                if (i % 2 == 0) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    int length = objArr.length;
                }
                int i2 = P + 77;
                L = i2 % 128;
                int i3 = i2 % 2;
                str = null;
            }
            if (Intrinsics.areEqual(str, "3.0")) {
                return true;
            }
        }
        int i4 = P + 93;
        L = i4 % 128;
        int i5 = i4 % 2;
        return false;
    }

    private final void getCallingPid() {
        try {
            this.moveToNextValue = BottomSheetBehavior.from((ConstraintLayout) _$_findCachedViewById(R.id.clCustomKeyboardBottomSheet));
            setCustomKeyboardVisibility(true);
            ((NumpadView) _$_findCachedViewById(R.id.showLoadingSearchBar)).setListener(new NumpadView.NumpadClickListener() { // from class: id.dana.sendmoney.summary.SummaryActivity$initCustomKeyboard$1
                @Override // id.dana.core.ui.richview.NumpadView.NumpadClickListener
                public final void MyBillsEntityDataFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.length() == 0) {
                        CurrencyEditText currencyEditText = (CurrencyEditText) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a02e2_basesocialfeedcontract_presenter);
                        if (currencyEditText != null) {
                            currencyEditText.clearAmount();
                        }
                        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) SummaryActivity.this._$_findCachedViewById(R.id.btnDoneNumpad);
                        if (danaButtonPrimaryView != null) {
                            danaButtonPrimaryView.setDisabled(SummaryActivity.this.getString(R.string.text_button_done));
                        }
                        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) SummaryActivity.this._$_findCachedViewById(R.id.btnDoneNumpad);
                        if (danaButtonPrimaryView2 != null) {
                            danaButtonPrimaryView2.setEnabled(false);
                        }
                    } else if (Long.parseLong(p0) == Long.parseLong("0")) {
                        CurrencyEditText currencyEditText2 = (CurrencyEditText) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a02e2_basesocialfeedcontract_presenter);
                        if (currencyEditText2 != null) {
                            currencyEditText2.setPrefixedAmount(Long.parseLong(p0));
                        }
                        DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) SummaryActivity.this._$_findCachedViewById(R.id.btnDoneNumpad);
                        if (danaButtonPrimaryView3 != null) {
                            danaButtonPrimaryView3.setDisabled(SummaryActivity.this.getString(R.string.text_button_done));
                        }
                        DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) SummaryActivity.this._$_findCachedViewById(R.id.btnDoneNumpad);
                        if (danaButtonPrimaryView4 != null) {
                            danaButtonPrimaryView4.setEnabled(false);
                        }
                    } else {
                        CurrencyEditText currencyEditText3 = (CurrencyEditText) SummaryActivity.this._$_findCachedViewById(R.id.res_0x7f0a02e2_basesocialfeedcontract_presenter);
                        if (currencyEditText3 != null) {
                            currencyEditText3.setPrefixedAmount(Long.parseLong(p0));
                        }
                        DanaButtonPrimaryView danaButtonPrimaryView5 = (DanaButtonPrimaryView) SummaryActivity.this._$_findCachedViewById(R.id.btnDoneNumpad);
                        if (danaButtonPrimaryView5 != null) {
                            danaButtonPrimaryView5.setActiveButton(SummaryActivity.this.getString(R.string.text_button_done), null);
                        }
                        DanaButtonPrimaryView danaButtonPrimaryView6 = (DanaButtonPrimaryView) SummaryActivity.this._$_findCachedViewById(R.id.btnDoneNumpad);
                        if (danaButtonPrimaryView6 != null) {
                            danaButtonPrimaryView6.setEnabled(true);
                        }
                    }
                }
            });
            ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnDoneNumpad)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SummaryActivity.$r8$lambda$pD3UzwOhVpDNv2ikqRz_oHgkLS4(SummaryActivity.this, view);
                }
            });
            CurrencyEditText currencyEditText = (CurrencyEditText) _$_findCachedViewById(R.id.res_0x7f0a02e2_basesocialfeedcontract_presenter);
            if (currencyEditText != null) {
                currencyEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.sendmoney.summary.SummaryActivity$initCustomKeyboard$3
                    @Override // android.text.TextWatcher
                    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    }

                    @Override // android.text.TextWatcher
                    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    }

                    @Override // android.text.TextWatcher
                    public final void afterTextChanged(Editable p0) {
                        String cleanAll = NumberUtils.getCleanAll(String.valueOf(p0));
                        Intrinsics.checkNotNullExpressionValue(cleanAll, "");
                        ((NumpadView) SummaryActivity.this._$_findCachedViewById(R.id.showLoadingSearchBar)).setAmount(StringsKt.replace$default(cleanAll, "Rp", "", false, 4, (Object) null));
                    }
                });
                int i = P + 117;
                L = i % 128;
                int i2 = i % 2;
            }
            int i3 = L + 119;
            P = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void MyBillsEntityDataFactory(SummaryActivity summaryActivity) {
        int i = P + 15;
        L = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(summaryActivity, "");
        summaryActivity.setCustomKeyboardVisibility(false);
        int i3 = P + 3;
        L = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0015, code lost:
    
        if (r0 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0021, code lost:
    
        if ((r0 == null) != true) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0023, code lost:
    
        r0.setDraggable(!r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0028, code lost:
    
        r0 = r4.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x002a, code lost:
    
        if (r0 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x002c, code lost:
    
        r1 = id.dana.sendmoney.summary.SummaryActivity.L + 51;
        id.dana.sendmoney.summary.SummaryActivity.P = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0036, code lost:
    
        if ((r1 % 2) != 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0038, code lost:
    
        r0.setHideable(r5 & true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0040, code lost:
    
        r0.setHideable(!r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0043, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 11;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x004d, code lost:
    
        if (r5 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004f, code lost:
    
        r5 = r4.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0053, code lost:
    
        if (r5 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0055, code lost:
    
        r1 = id.dana.cashier.view.InputCardNumberView.DIVIDER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0058, code lost:
    
        r1 = 'J';
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x005a, code lost:
    
        if (r1 == 'J') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005c, code lost:
    
        r5.setState(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0060, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0061, code lost:
    
        r5 = r4.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0063, code lost:
    
        if (r5 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0065, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 61;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
        r5.setState(5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setCustomKeyboardVisibility(boolean r5) {
        /*
            r4 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L18
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r0 = r4.moveToNextValue
            if (r0 == 0) goto L28
            goto L23
        L18:
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r0 = r4.moveToNextValue     // Catch: java.lang.Exception -> L76
            r3 = 51
            int r3 = r3 / r1
            if (r0 == 0) goto L20
            goto L21
        L20:
            r1 = 1
        L21:
            if (r1 == r2) goto L28
        L23:
            r1 = r5 ^ 1
            r0.setDraggable(r1)
        L28:
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r0 = r4.moveToNextValue     // Catch: java.lang.Exception -> L76
            if (r0 == 0) goto L4d
            int r1 = id.dana.sendmoney.summary.SummaryActivity.L
            int r1 = r1 + 51
            int r2 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L3e
            r1 = r5 & 1
            r0.setHideable(r1)
            goto L43
        L3e:
            r1 = r5 ^ 1
            r0.setHideable(r1)     // Catch: java.lang.Exception -> L76
        L43:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L     // Catch: java.lang.Exception -> L76
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1     // Catch: java.lang.Exception -> L76
            int r0 = r0 % 2
        L4d:
            if (r5 == 0) goto L61
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r5 = r4.moveToNextValue
            r0 = 74
            if (r5 == 0) goto L58
            r1 = 32
            goto L5a
        L58:
            r1 = 74
        L5a:
            if (r1 == r0) goto L73
            r0 = 3
            r5.setState(r0)
            return
        L61:
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r5 = r4.moveToNextValue
            if (r5 == 0) goto L73
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            r0 = 5
            r5.setState(r0)
        L73:
            return
        L74:
            r5 = move-exception
            throw r5
        L76:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.setCustomKeyboardVisibility(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x001b, code lost:
    
        if ((r0 != null ? 'P' : '.') != 'P') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002b, code lost:
    
        if ((r0 != null ? 'Z' : '\b') != '\b') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x002d, code lost:
    
        r2 = id.dana.sendmoney.summary.SummaryActivity.P + 27;
        id.dana.sendmoney.summary.SummaryActivity.L = r2 % 128;
        r2 = r2 % 2;
        r0 = r0.readMicros;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003a, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void C() {
        /*
            r4 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L20
            id.dana.sendmoney.model.RecipientModel r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda6
            r2 = 33
            int r2 = r2 / r1
            r2 = 80
            if (r0 == 0) goto L19
            r3 = 80
            goto L1b
        L19:
            r3 = 46
        L1b:
            if (r3 == r2) goto L2d
            goto L3a
        L1e:
            r0 = move-exception
            throw r0
        L20:
            id.dana.sendmoney.model.RecipientModel r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda6
            r2 = 8
            if (r0 == 0) goto L29
            r3 = 90
            goto L2b
        L29:
            r3 = 8
        L2b:
            if (r3 == r2) goto L3a
        L2d:
            int r2 = id.dana.sendmoney.summary.SummaryActivity.P
            int r2 = r2 + 27
            int r3 = r2 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r3
            int r2 = r2 % 2
            java.lang.String r0 = r0.readMicros
            goto L3b
        L3a:
            r0 = 0
        L3b:
            java.lang.String r2 = "link"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L65
            int r0 = id.dana.R.id.res_0x7f0a0e6e_windowinsetscontrollercompat_impl26
            android.view.View r0 = r4._$_findCachedViewById(r0)
            com.google.android.material.card.MaterialCardView r0 = (com.google.android.material.card.MaterialCardView) r0
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r1)
            int r0 = id.dana.R.id.res_0x7f0a1560_paymentcardsview_2
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda1 r2 = new id.dana.sendmoney.summary.SummaryActivity$$ExternalSyntheticLambda1
            r2.<init>()
            r0.setOnClickListener(r2)
        L65:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 63
            int r2 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r2
            int r0 = r0 % 2
            r2 = 66
            if (r0 == 0) goto L76
            r0 = 45
            goto L78
        L76:
            r0 = 66
        L78:
            if (r0 == r2) goto L80
            r0 = 35
            int r0 = r0 / r1
            return
        L7e:
            r0 = move-exception
            throw r0
        L80:
            return
        L81:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.C():void");
    }

    private static final void getAuthRequestContext(final SummaryActivity summaryActivity) {
        try {
            Intrinsics.checkNotNullParameter(summaryActivity, "");
            try {
                Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.summary.SummaryActivity$initSendToLinkSummary$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        SummaryActivity.access$updateSelectedExpiryTime(SummaryActivity.this, i);
                        SummaryActivity.access$updateSelectedExpiredDuration(SummaryActivity.this);
                    }
                };
                List<ExpiryTimeConfig> list = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if ((list == null ? '\f' : '@') == '\f') {
                    int i = L + 15;
                    P = i % 128;
                    int i2 = i % 2;
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    list = null;
                }
                ExpiryTimeBottomSheetFragment expiryTimeBottomSheetFragment = new ExpiryTimeBottomSheetFragment(function1, list);
                summaryActivity.initRecordTimeStamp = expiryTimeBottomSheetFragment;
                FragmentManager supportFragmentManager = summaryActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                AndroidComponentUtilsKt.MyBillsEntityDataFactory(expiryTimeBottomSheetFragment, supportFragmentManager, "");
                int i3 = L + 107;
                P = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0062 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static id.dana.domain.featureconfig.model.ExpiryTimeConfig KClassImpl$Data$declaredNonStaticMembers$2(java.util.List<id.dana.domain.featureconfig.model.ExpiryTimeConfig> r5) {
        /*
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Exception -> L78
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L78
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L78
            int r1 = id.dana.sendmoney.summary.SummaryActivity.P
            int r1 = r1 + 93
            int r2 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r2
            int r1 = r1 % 2
        L17:
            boolean r1 = r5.hasNext()
            r2 = 0
            if (r1 == 0) goto L6f
            int r1 = id.dana.sendmoney.summary.SummaryActivity.L
            int r1 = r1 + 51
            int r3 = r1 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r3
            int r1 = r1 % 2
            if (r1 != 0) goto L2b
            r2 = 1
        L2b:
            r1 = 0
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r5.next()
            r3 = r2
            id.dana.domain.featureconfig.model.ExpiryTimeConfig r3 = (id.dana.domain.featureconfig.model.ExpiryTimeConfig) r3
            boolean r3 = r3.isDefault()
            int r4 = r1.length     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L17
            goto L56
        L3d:
            r5 = move-exception
            throw r5
        L3f:
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Exception -> L6d
            r3 = r2
            id.dana.domain.featureconfig.model.ExpiryTimeConfig r3 = (id.dana.domain.featureconfig.model.ExpiryTimeConfig) r3     // Catch: java.lang.Exception -> L6d
            boolean r3 = r3.isDefault()     // Catch: java.lang.Exception -> L6d
            r4 = 61
            if (r3 == 0) goto L51
            r3 = 61
            goto L53
        L51:
            r3 = 53
        L53:
            if (r3 == r4) goto L56
            goto L17
        L56:
            int r3 = id.dana.sendmoney.summary.SummaryActivity.P
            int r3 = r3 + 21
            int r4 = r3 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L69
            r0.add(r2)
            int r1 = r1.length     // Catch: java.lang.Throwable -> L67
            goto L17
        L67:
            r5 = move-exception
            throw r5
        L69:
            r0.add(r2)
            goto L17
        L6d:
            r5 = move-exception
            throw r5
        L6f:
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r5 = r0.get(r2)
            id.dana.domain.featureconfig.model.ExpiryTimeConfig r5 = (id.dana.domain.featureconfig.model.ExpiryTimeConfig) r5
            return r5
        L78:
            r5 = move-exception
            goto L7b
        L7a:
            throw r5
        L7b:
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2(java.util.List):id.dana.domain.featureconfig.model.ExpiryTimeConfig");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x001f, code lost:
    
        if ((r0) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0028, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, id.dana.sendmoney.summary.SummaryActivity.HOURS) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x002a, code lost:
    
        r6 = id.dana.sendmoney.summary.SummaryActivity.L + 91;
        id.dana.sendmoney.summary.SummaryActivity.P = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x003a, code lost:
    
        if (java.lang.Integer.parseInt(r7) != 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x003c, code lost:
    
        r6 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x003f, code lost:
    
        r6 = 18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0041, code lost:
    
        if (r6 == 'O') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0043, code lost:
    
        r6 = getString(id.dana.R.string.expiry_hours);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x004b, code lost:
    
        r6 = id.dana.sendmoney.summary.SummaryActivity.L + 25;
        id.dana.sendmoney.summary.SummaryActivity.P = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0058, code lost:
    
        if ((r6 % 2) != 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x005a, code lost:
    
        r6 = getString(id.dana.R.string.expiry_hour);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0060, code lost:
    
        r7 = 50 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0064, code lost:
    
        r6 = getString(id.dana.R.string.expiry_hour);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0068, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0072, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, id.dana.sendmoney.summary.SummaryActivity.DAYS) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0074, code lost:
    
        r6 = getString(id.dana.R.string.expiry_days);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x007e, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x007f, code lost:
    
        r6 = id.dana.sendmoney.summary.SummaryActivity.L + 95;
        id.dana.sendmoney.summary.SummaryActivity.P = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0089, code lost:
    
        if ((r6 % 2) != 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x008c, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x008d, code lost:
    
        if (r2 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0091, code lost:
    
        r6 = 42 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0092, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0095, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String MyBillsEntityDataFactory(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            int r0 = r0 % 2
            java.lang.String r1 = "H"
            r2 = 1
            java.lang.String r3 = ""
            r4 = 0
            if (r0 != 0) goto L24
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 == 0) goto L6c
            goto L2a
        L22:
            r6 = move-exception
            throw r6
        L24:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r0 == 0) goto L6c
        L2a:
            int r6 = id.dana.sendmoney.summary.SummaryActivity.L
            int r6 = r6 + 91
            int r0 = r6 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r0
            int r6 = r6 % 2
            int r6 = java.lang.Integer.parseInt(r7)
            r7 = 79
            if (r6 != r2) goto L3f
            r6 = 79
            goto L41
        L3f:
            r6 = 18
        L41:
            if (r6 == r7) goto L4b
            r6 = 2131953504(0x7f130760, float:1.954348E38)
            java.lang.String r6 = r5.getString(r6)
            goto L68
        L4b:
            int r6 = id.dana.sendmoney.summary.SummaryActivity.L
            int r6 = r6 + 25
            int r7 = r6 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r7
            int r6 = r6 % 2
            r7 = 2131953503(0x7f13075f, float:1.9543479E38)
            if (r6 != 0) goto L64
            java.lang.String r6 = r5.getString(r7)
            r7 = 50
            int r7 = r7 / r4
            goto L68
        L62:
            r6 = move-exception
            throw r6
        L64:
            java.lang.String r6 = r5.getString(r7)
        L68:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            goto L7e
        L6c:
            java.lang.String r7 = "D"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto L7f
            r6 = 2131953502(0x7f13075e, float:1.9543477E38)
            java.lang.String r6 = r5.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
        L7e:
            r3 = r6
        L7f:
            int r6 = id.dana.sendmoney.summary.SummaryActivity.L
            int r6 = r6 + 95
            int r7 = r6 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L8c
            goto L8d
        L8c:
            r2 = 0
        L8d:
            if (r2 == 0) goto L95
            r6 = 42
            int r6 = r6 / r4
            return r3
        L93:
            r6 = move-exception
            throw r6
        L95:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.MyBillsEntityDataFactory(java.lang.String, java.lang.String):java.lang.String");
    }

    private final void PlaceComponentResult(int p0) {
        int i = P + 69;
        L = i % 128;
        int i2 = i % 2;
        List<ExpiryTimeConfig> list = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        List<ExpiryTimeConfig> list2 = null;
        if (!(list != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        try {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((ExpiryTimeConfig) it.next()).setDefault(false);
            }
            List<ExpiryTimeConfig> list3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (list3 == null) {
                int i3 = P + 81;
                L = i3 % 128;
                if (i3 % 2 != 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    list2.hashCode();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
            } else {
                list2 = list3;
            }
            list2.get(p0).setDefault(true);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x001f, code lost:
    
        if (r0 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0022, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x002d, code lost:
    
        if ((r0 == null) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0030, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 3;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003b, code lost:
    
        if ((r0 % 2) == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003d, code lost:
    
        r0 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0040, code lost:
    
        r0 = '6';
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0042, code lost:
    
        if (r0 == 'Q') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0044, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0048, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x004b, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x004c, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 73;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void P() {
        /*
            r8 = this;
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 82
            if (r0 != 0) goto L11
            r0 = 65
            goto L13
        L11:
            r0 = 82
        L13:
            r3 = 0
            java.lang.String r4 = ""
            r5 = 1
            r6 = 0
            if (r0 == r2) goto L26
            java.util.List<id.dana.domain.featureconfig.model.ExpiryTimeConfig> r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda2
            r2 = 69
            int r2 = r2 / r6
            if (r0 != 0) goto L22
            goto L30
        L22:
            r3 = r0
            goto L55
        L24:
            r0 = move-exception
            throw r0
        L26:
            java.util.List<id.dana.domain.featureconfig.model.ExpiryTimeConfig> r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda2
            if (r0 != 0) goto L2c
            r2 = 1
            goto L2d
        L2c:
            r2 = 0
        L2d:
            if (r2 == r5) goto L30
            goto L22
        L30:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 3
            int r2 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r2
            int r0 = r0 % r1
            r2 = 81
            if (r0 == 0) goto L40
            r0 = 81
            goto L42
        L40:
            r0 = 54
        L42:
            if (r0 == r2) goto L48
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L4c
        L48:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            int r0 = r3.length     // Catch: java.lang.Throwable -> L95
        L4c:
            int r0 = id.dana.sendmoney.summary.SummaryActivity.L
            int r0 = r0 + 73
            int r2 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.P = r2
            int r0 = r0 % r1
        L55:
            id.dana.domain.featureconfig.model.ExpiryTimeConfig r0 = KClassImpl$Data$declaredNonStaticMembers$2(r3)
            int r2 = id.dana.R.id.res_0x7f0a1449_observabletimeouttimed_fallbackobserver
            android.view.View r2 = r8._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r7 = r0.getValue()
            r3[r6] = r7
            java.lang.String r6 = r0.getUnit()
            java.lang.String r0 = r0.getValue()
            java.lang.String r0 = r8.MyBillsEntityDataFactory(r6, r0)
            r3[r5] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r1)
            java.lang.String r3 = "%s %s"
            java.lang.String r0 = java.lang.String.format(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            int r0 = id.dana.sendmoney.summary.SummaryActivity.P
            int r0 = r0 + 115
            int r2 = r0 % 128
            id.dana.sendmoney.summary.SummaryActivity.L = r2
            int r0 = r0 % r1
            return
        L95:
            r0 = move-exception
            goto L98
        L97:
            throw r0
        L98:
            goto L97
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.P():void");
    }

    private final void B() {
        DanaTextBoxView danaTextBoxView;
        int i = L + 73;
        P = i % 128;
        if (i % 2 == 0) {
            danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.res_0x7f0a0684_r8_lambda_7v3kt_ajfljz89nrm_iclzm3mwc);
            Object obj = null;
            obj.hashCode();
            if (danaTextBoxView == null) {
                return;
            }
        } else {
            danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.res_0x7f0a0684_r8_lambda_7v3kt_ajfljz89nrm_iclzm3mwc);
            if (danaTextBoxView == null) {
                return;
            }
        }
        try {
            danaTextBoxView.addTextChangedListener(new TextWatcher() { // from class: id.dana.sendmoney.summary.SummaryActivity$initNotesChanged$$inlined$doAfterTextChanged$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    SummaryActivity summaryActivity = SummaryActivity.this;
                    String obj2 = p0 != null ? p0.toString() : null;
                    if (obj2 == null) {
                        obj2 = "";
                    }
                    SummaryActivity.access$setRemarks(summaryActivity, obj2);
                }
            });
            int i2 = P + 75;
            L = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        int i = L + 55;
        P = i % 128;
        int i2 = i % 2;
        if (!TextUtils.isEmpty(p0)) {
            try {
                Object BuiltInFictitiousFunctionClassFactory = NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), new Amount(p0).getAuthRequestContext, "Rp");
                AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.SavingSummary);
                if (appCompatTextView != null) {
                    int i3 = L + 75;
                    P = i3 % 128;
                    int i4 = i3 % 2;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] objArr = new Object[2];
                    PayMethodModel payMethodModel = this.payMethodModel;
                    Object[] objArr2 = 0;
                    if (!(payMethodModel == null)) {
                        int i5 = P + 59;
                        try {
                            L = i5 % 128;
                            if ((i5 % 2 != 0 ? 'Q' : '*') != '*') {
                                String PlaceComponentResult2 = payMethodModel.PlaceComponentResult(this);
                                int length = objArr2.length;
                                objArr2 = PlaceComponentResult2;
                            } else {
                                objArr2 = payMethodModel.PlaceComponentResult(this);
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    objArr[0] = objArr2;
                    objArr[1] = BuiltInFictitiousFunctionClassFactory;
                    String format = String.format(p1, Arrays.copyOf(objArr, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    appCompatTextView.setText(format);
                }
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d64_animatorkt_addlistener_2);
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                SummaryView summaryView = (SummaryView) _$_findCachedViewById(R.id.res_0x7f0a129b_saferepresenter_representnull);
                if (summaryView != null) {
                    SummaryView.showAmountWarningMessage$default(summaryView, null, null, 0, 0, 15, null);
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i6 = P + 125;
        L = i6 % 128;
        int i7 = i6 % 2;
    }

    private static final void getAuthRequestContext(SummaryActivity summaryActivity, ActivityResult activityResult) {
        int i = P + 39;
        L = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(summaryActivity, "");
            int i2 = 34 / 0;
            if (activityResult.BuiltInFictitiousFunctionClassFactory != -1) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(summaryActivity, "");
            if (!(activityResult.BuiltInFictitiousFunctionClassFactory == -1)) {
                return;
            }
        }
        int i3 = P + 95;
        L = i3 % 128;
        if (i3 % 2 == 0) {
            SendMoneyFeatureTime NetworkUserEntityData$$ExternalSyntheticLambda7 = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda7();
            NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext.clear();
            NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext();
            return;
        }
        SendMoneyFeatureTime NetworkUserEntityData$$ExternalSyntheticLambda72 = summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda7();
        try {
            NetworkUserEntityData$$ExternalSyntheticLambda72.getAuthRequestContext.clear();
            NetworkUserEntityData$$ExternalSyntheticLambda72.getAuthRequestContext();
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void MyBillsEntityDataFactory(PayMethodModel p0) {
        int i;
        int i2 = P + 113;
        L = i2 % 128;
        int i3 = i2 % 2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.StreamConfigurationMap);
        if ((appCompatImageView != null ? ')' : '+') == ')') {
            if (p0.scheduleImpl()) {
                i = R.drawable.ic_dana_balance_v2;
                int i4 = L + 113;
                P = i4 % 128;
                int i5 = i4 % 2;
            } else if (p0.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                int i6 = L + 63;
                P = i6 % 128;
                int i7 = i6 % 2;
                i = R.drawable.ic_add_card;
            } else {
                i = PaymentIconFactory.MyBillsEntityDataFactory(p0.lookAheadTest);
            }
            getAuthRequestContext(appCompatImageView, "", i);
        }
        int i8 = L + 75;
        P = i8 % 128;
        int i9 = i8 % 2;
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(SummaryActivity summaryActivity, ActivityResult activityResult) {
        int i = L + 91;
        P = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(summaryActivity, "");
        if ((activityResult.BuiltInFictitiousFunctionClassFactory == -1 ? Typography.amp : 'A') == '&') {
            int i3 = L + 23;
            P = i3 % 128;
            int i4 = i3 % 2;
            summaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        int i5 = P + 99;
        L = i5 % 128;
        int i6 = i5 % 2;
    }

    public final void getTransferBalanceInitCallback(TransferInitResultModel transferInitResultModel) {
        Intrinsics.checkNotNullParameter(transferInitResultModel, "");
        this.lookAheadTest = transferInitResultModel.PlaceComponentResult.getPlaceComponentResult();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = transferInitResultModel.PlaceComponentResult.getMyBillsEntityDataFactory();
        getSendMoneySummaryPresenter().MyBillsEntityDataFactory();
        setPayMethodModel(new PayMethodModel());
        if (VerifyPinStateManager$executeRiskChallenge$2$2()) {
            try {
                this.E = new CurrencyAmountModel(transferInitResultModel.KClassImpl$Data$declaredNonStaticMembers$2.getCleanAmount(), transferInitResultModel.KClassImpl$Data$declaredNonStaticMembers$2.getCurrency());
                this.A = new CurrencyAmountModel(transferInitResultModel.MyBillsEntityDataFactory.getCleanAmount(), transferInitResultModel.MyBillsEntityDataFactory.getCurrency());
            } catch (Exception e) {
                throw e;
            }
        }
        int i = L + 109;
        P = i % 128;
        if ((i % 2 == 0 ? (char) 28 : '1') != '1') {
            int i2 = 82 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x001c, code lost:
    
        if ((r7 != null ? '[' : '\\') != '\\') goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0028, code lost:
    
        if ((r7 != null) != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x002a, code lost:
    
        r0 = (androidx.appcompat.widget.AppCompatTextView) _$_findCachedViewById(id.dana.R.id.AppBarLayout$Behavior);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0032, code lost:
    
        if (r0 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0034, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x003d, code lost:
    
        if (r7.scheduleImpl() == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x003f, code lost:
    
        r4 = 'U';
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0042, code lost:
    
        r4 = '`';
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0044, code lost:
    
        if (r4 == '`') goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0046, code lost:
    
        r3 = r3.getString(id.dana.R.string.dana_balance);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0052, code lost:
    
        if (r7.NetworkUserEntityData$$ExternalSyntheticLambda0() == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0054, code lost:
    
        r4 = id.dana.sendmoney.summary.SummaryActivity.P + 57;
        id.dana.sendmoney.summary.SummaryActivity.L = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0061, code lost:
    
        if ((r4 % 2) == 0) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0063, code lost:
    
        r3 = r3.getString(id.dana.R.string.add_card);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0069, code lost:
    
        r4 = 41 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x006d, code lost:
    
        r3 = r3.getString(id.dana.R.string.add_card);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0072, code lost:
    
        r3 = r3.getString(id.dana.R.string.debit_card);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0079, code lost:
    
        r0.setText(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x007e, code lost:
    
        r0 = (androidx.appcompat.widget.AppCompatTextView) _$_findCachedViewById(id.dana.R.id.ChipSearchCategoryViewHolder);
        r3 = 0;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0087, code lost:
    
        if (r0 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0089, code lost:
    
        r4 = id.dana.sendmoney.summary.SummaryActivity.L + 125;
        id.dana.sendmoney.summary.SummaryActivity.P = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0093, code lost:
    
        if ((r4 % 2) != 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0095, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0097, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0098, code lost:
    
        if (r4 == true) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x009a, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x00a1, code lost:
    
        if (r7.scheduleImpl() == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00a4, code lost:
    
        r4 = r6;
        r5 = r7.scheduleImpl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00ab, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x00ae, code lost:
    
        if (r5 == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x00b0, code lost:
    
        r4 = id.dana.sendmoney.summary.SummaryActivity.L + 21;
        id.dana.sendmoney.summary.SummaryActivity.P = r4 % 128;
        r4 = r4 % 2;
        r4 = r7.KClassImpl$Data$declaredNonStaticMembers$2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00bf, code lost:
    
        r4 = r7.KClassImpl$Data$declaredNonStaticMembers$2(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x00c3, code lost:
    
        r0.setText(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x00cb, code lost:
    
        MyBillsEntityDataFactory(r7);
        getAuthRequestContext(r7);
        r0 = (id.dana.sendmoney.voucher.SummaryVoucherView) _$_findCachedViewById(id.dana.R.id.AutoRouteEntityRepository_Factory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00d9, code lost:
    
        if (r0 == null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00db, code lost:
    
        r0.setPayMethod(r7.newProxyInstance);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00e0, code lost:
    
        r7 = (id.dana.sendmoney.voucher.SummaryVoucherView) _$_findCachedViewById(id.dana.R.id.AutoRouteEntityRepository_Factory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00e8, code lost:
    
        if (r7 == null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00ea, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.P + 59;
        id.dana.sendmoney.summary.SummaryActivity.L = r0 % 128;
        r0 = r0 % 2;
        r0 = r6.VerifyPinStateManager$executeRiskChallenge$2$1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00f6, code lost:
    
        if (r0 != null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x00f8, code lost:
    
        r0 = id.dana.sendmoney.summary.SummaryActivity.L + 9;
        id.dana.sendmoney.summary.SummaryActivity.P = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0104, code lost:
    
        if ((r0 % 2) != 0) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0106, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0109, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x010d, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0111, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0112, code lost:
    
        r7.setVoucherViewVersion(r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    @kotlin.jvm.JvmName(name = "setPayMethodModel")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setPayMethodModel(id.dana.model.PayMethodModel r7) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.SummaryActivity.setPayMethodModel(id.dana.model.PayMethodModel):void");
    }

    private static void b(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        try {
            char[] cArr = H;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                for (int i5 = 0; i5 < length; i5++) {
                    cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if ((bArr != null ? (char) 6 : 'A') == 6) {
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                int i6 = $10 + 89;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if (!(bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1)) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (i4 > 0) {
                int i8 = $10 + 71;
                $11 = i8 % 128;
                if ((i8 % 2 == 0 ? (char) 7 : 'c') != 7) {
                    char[] cArr5 = new char[i2];
                    System.arraycopy(cArr3, 0, cArr5, 0, i2);
                    int i9 = i2 - i4;
                    System.arraycopy(cArr5, 0, cArr3, i9, i4);
                    System.arraycopy(cArr5, i4, cArr3, 0, i9);
                } else {
                    char[] cArr6 = new char[i2];
                    System.arraycopy(cArr3, 0, cArr6, 0, i2);
                    System.arraycopy(cArr6, 0, cArr3, i2 / i4, i4);
                    System.arraycopy(cArr6, i4, cArr3, 0, i2 * i4);
                }
            }
            if (!(!z)) {
                char[] cArr7 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2)) {
                        break;
                    }
                    int i10 = $11 + 125;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr7[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr7;
            }
            if (i3 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                int i12 = $11 + 71;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        try {
            int i4 = i2 + ((int) (M ^ 3097486228508854431L));
            boolean z2 = !(i4 != -1);
            if (z2) {
                byte[] bArr = J;
                if (bArr != null) {
                    int i5 = $10 + 81;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    for (int i7 = 0; i7 < length; i7++) {
                        bArr2[i7] = (byte) (bArr[i7] ^ 3097486228508854431L);
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    try {
                        i4 = (byte) (((byte) (J[i3 + ((int) (I ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (M ^ 3097486228508854431L)));
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    i4 = (short) (((short) (getNameOrBuilderList[i3 + ((int) (I ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (M ^ 3097486228508854431L)));
                }
            }
            if (i4 > 0) {
                b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (I ^ 3097486228508854431L)) + ((z2 ? '/' : InputCardNumberView.DIVIDER) != '/' ? 0 : 1);
                b2.MyBillsEntityDataFactory = (char) (((int) (K ^ 3097486228508854431L)) + i);
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                byte[] bArr3 = J;
                if (bArr3 != null) {
                    int length2 = bArr3.length;
                    byte[] bArr4 = new byte[length2];
                    for (int i8 = 0; i8 < length2; i8++) {
                        bArr4[i8] = (byte) (bArr3[i8] ^ 3097486228508854431L);
                    }
                    bArr3 = bArr4;
                }
                if (bArr3 == null) {
                    z = false;
                } else {
                    int i9 = $11 + 47;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                    int i11 = $11 + 45;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                    z = true;
                }
                b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                while (true) {
                    if ((b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4 ? '5' : (char) 28) != '5') {
                        break;
                    }
                    if ((z ? (char) 19 : (char) 6) != 19) {
                        short[] sArr = getNameOrBuilderList;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    } else {
                        byte[] bArr5 = J;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Exception e2) {
            throw e2;
        }
    }
}
