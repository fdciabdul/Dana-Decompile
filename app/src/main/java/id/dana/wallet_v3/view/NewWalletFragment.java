package id.dana.wallet_v3.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ethanhua.skeleton.SkeletonScreen;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingToolbarFragment;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.payasset.SceneType;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.danah5.tooltip.TooltipEvent;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import id.dana.data.usereducation.repository.source.local.UserEducationPreference;
import id.dana.databinding.FragmentNewWalletBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.databinding.ViewWalletV3SearchStubBinding;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.domain.wallet_v3.constant.WalletSectionType;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.domain.wallet_v3.model.WalletV3AddAssetServices;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.ThirdPartyService;
import id.dana.pocket.model.PocketQueryListModel;
import id.dana.richview.wallet.BaseWalletCardView;
import id.dana.service.ServiceMaintenanceUtil;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.tracker.spm.ServicesTracker;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.RandomInteger;
import id.dana.utils.SizeUtil;
import id.dana.utils.TagFormat;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.di.component.DaggerNewWalletComponent;
import id.dana.wallet_v3.di.module.NewWalletModule;
import id.dana.wallet_v3.di.module.PersonalModule;
import id.dana.wallet_v3.factory.WalletCardFactory;
import id.dana.wallet_v3.factory.WalletIntentFactory;
import id.dana.wallet_v3.identity.IdentityToastAndDialogImpl;
import id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment;
import id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment;
import id.dana.wallet_v3.listener.DanaBalanceClickListener;
import id.dana.wallet_v3.listener.SectionTooltipClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.listener.WalletTabListener;
import id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment;
import id.dana.wallet_v3.model.IdentityCardModel;
import id.dana.wallet_v3.model.InsuranceAssetModel;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.KtpInfoModel;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.SectionStatus;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletSectionModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment;
import id.dana.wallet_v3.presenter.NewWalletContract;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.util.WalletV3ToastUtilKt;
import id.dana.wallet_v3.view.NewWalletFragment$danaBalanceClickListener$2;
import id.dana.wallet_v3.view.NewWalletFragment$sectionTooltipClickListener$2;
import id.dana.wallet_v3.view.NewWalletFragment$walletCardAssetClickListener$2;
import id.dana.wallet_v3.view.WalletTransitionListener;
import id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment;
import id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import j$.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000Ô\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 è\u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002è\u0003B\b¢\u0006\u0005\bç\u0003\u0010\u001aJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001f\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u001aJ\u001f\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u001aJ\u001d\u0010,\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014H\u0002¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0007¢\u0006\u0004\b.\u0010\u001aJ\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00105\u001a\u0004\u0018\u0001042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\u00072\u000e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010409H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001bH\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0007H\u0002¢\u0006\u0004\b@\u0010\u001aJ\u0017\u0010A\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\bA\u00108J\u000f\u0010B\u001a\u00020\u0007H\u0016¢\u0006\u0004\bB\u0010\u001aJ\u000f\u0010C\u001a\u00020\u0007H\u0002¢\u0006\u0004\bC\u0010\u001aJ\u000f\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020DH\u0002¢\u0006\u0004\bG\u0010FJ\u000f\u0010H\u001a\u00020DH\u0002¢\u0006\u0004\bH\u0010FJ\u000f\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bM\u0010NJ\u0019\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\bT\u0010NJ\u0019\u0010U\u001a\u0004\u0018\u00010\u00052\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bU\u0010VJ\u0019\u0010X\u001a\u00020\n2\b\b\u0001\u0010W\u001a\u00020\u001dH\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\nH\u0014¢\u0006\u0004\bZ\u0010[J\u000f\u0010]\u001a\u00020\\H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010`\u001a\u00020_H\u0002¢\u0006\u0004\b`\u0010aJ\u0019\u0010b\u001a\u0004\u0018\u00010\u001d2\u0006\u0010W\u001a\u00020\u001dH\u0002¢\u0006\u0004\bb\u0010cJ\u001f\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00142\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bd\u0010eJ\u0019\u0010g\u001a\u0004\u0018\u00010f2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bg\u0010hJ\u0019\u0010j\u001a\u0004\u0018\u00010i2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bj\u0010kJ\u0019\u0010l\u001a\u0004\u0018\u0001022\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bl\u0010mJ\u000f\u0010o\u001a\u00020nH\u0002¢\u0006\u0004\bo\u0010pJ\u0019\u0010q\u001a\u0004\u0018\u00010\u00052\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bq\u0010VJ\u001f\u0010r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00142\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\br\u0010eJ\u0017\u0010s\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bs\u0010NJ\u0011\u0010t\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\bt\u0010uJ\u0017\u0010v\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bv\u0010NJ\u0017\u0010w\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bw\u0010NJ\u0015\u0010x\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014H\u0002¢\u0006\u0004\bx\u0010yJ\u0019\u0010z\u001a\u0004\u0018\u00010O2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bz\u0010QJ\u0019\u0010|\u001a\u0004\u0018\u00010{2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\b|\u0010}J\u0019\u0010~\u001a\u0004\u0018\u00010O2\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\b~\u0010QJ'\u0010\u0081\u0001\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u001d2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u0083\u0001\u0010\u001aJ\u0011\u0010\u0084\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u001aJ\u0019\u0010\u0085\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0085\u0001\u00108J\u0019\u0010\u0086\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0086\u0001\u00108J\u0011\u0010\u0087\u0001\u001a\u00020\u0007H\u0014¢\u0006\u0005\b\u0087\u0001\u0010\u001aJ\u0011\u0010\u0088\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0088\u0001\u0010\u001aJ\u0011\u0010\u0089\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0089\u0001\u0010\u001aJ\u0011\u0010\u008a\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u008a\u0001\u0010\u001aJ\u0011\u0010\u008b\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u001aJ\u001a\u0010\u008c\u0001\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u000202H\u0014¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0011\u0010\u008e\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u008e\u0001\u0010\u001aJ\u0011\u0010\u008f\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u008f\u0001\u0010\u001aJ\u0011\u0010\u0090\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u001aJ\u001c\u0010\u0093\u0001\u001a\u00020\u001b2\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001H\u0002¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001e\u0010\u0097\u0001\u001a\u00020\u00072\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001e\u0010\u0099\u0001\u001a\u00020\u00072\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u0098\u0001J\u0011\u0010\u009a\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u009a\u0001\u0010\u001aJ0\u0010\u009f\u0001\u001a\u00020\u00072\u0007\u0010\u009b\u0001\u001a\u00020\n2\u0007\u0010\u009c\u0001\u001a\u00020\n2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u000f\u0010¡\u0001\u001a\u00020\u0007¢\u0006\u0005\b¡\u0001\u0010\u001aJ\u001b\u0010¢\u0001\u001a\u00020\u00072\u0007\u0010\u009e\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001c\u0010¤\u0001\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u001c\u0010¦\u0001\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0006\b¦\u0001\u0010¥\u0001J\u0017\u0010§\u0001\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\n¢\u0006\u0005\b§\u0001\u00108J\u000f\u0010¨\u0001\u001a\u00020\u0007¢\u0006\u0005\b¨\u0001\u0010\u001aJ\u0011\u0010©\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b©\u0001\u0010\u001aJ\u0011\u0010ª\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bª\u0001\u0010\u001aJ\u001a\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u001bH\u0016¢\u0006\u0005\b¬\u0001\u0010?J\u0011\u0010\u00ad\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b\u00ad\u0001\u0010\u001aJ\u0011\u0010®\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b®\u0001\u0010\u001aJ&\u0010±\u0001\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u0002022\n\u0010°\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0011\u0010³\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b³\u0001\u0010\u001aJ\u0011\u0010´\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b´\u0001\u0010\u001aJ\u001a\u0010¶\u0001\u001a\u00020\u00072\u0007\u0010µ\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b¶\u0001\u00108J\u001d\u0010¸\u0001\u001a\u00020\u00072\t\u0010·\u0001\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0006\b¸\u0001\u0010¹\u0001J'\u0010½\u0001\u001a\u00020\u00072\b\u0010»\u0001\u001a\u00030º\u00012\t\b\u0001\u0010¼\u0001\u001a\u00020\u001dH\u0002¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0011\u0010¿\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b¿\u0001\u0010\u001aJ\u001a\u0010Á\u0001\u001a\u00020\u00072\u0007\u0010À\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\bÁ\u0001\u00108J\u0011\u0010Â\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÂ\u0001\u0010\u001aJ\u001a\u0010Ä\u0001\u001a\u00020\u00072\u0007\u0010Ã\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\bÄ\u0001\u00108J\u0011\u0010Å\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÅ\u0001\u0010\u001aJ\u001a\u0010Ç\u0001\u001a\u00020\u00072\u0007\u0010Æ\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\bÇ\u0001\u00108J\u0011\u0010È\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÈ\u0001\u0010\u001aJ\u001a\u0010Ê\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\bÊ\u0001\u00108J\u001a\u0010Ë\u0001\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u001dH\u0002¢\u0006\u0006\bË\u0001\u0010¹\u0001J\u0011\u0010Ì\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÌ\u0001\u0010\u001aJ\u001a\u0010Î\u0001\u001a\u00020\u00072\u0007\u0010Í\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\bÎ\u0001\u00108J\u001b\u0010Ð\u0001\u001a\u00020\u00072\u0007\u0010Ï\u0001\u001a\u00020\u001dH\u0002¢\u0006\u0006\bÐ\u0001\u0010¹\u0001J\u000f\u0010Ñ\u0001\u001a\u00020\u0007¢\u0006\u0005\bÑ\u0001\u0010\u001aJ\u0011\u0010Ò\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÒ\u0001\u0010\u001aJ\u0011\u0010Ó\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÓ\u0001\u0010\u001aJ+\u0010Õ\u0001\u001a\u00020\u00072\b\u0010\u0092\u0001\u001a\u00030\u0091\u00012\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u000709H\u0002¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u0019\u0010×\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0005\b×\u0001\u00108J\u001c\u0010Ø\u0001\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J%\u0010Û\u0001\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u001d2\t\b\u0002\u0010Ú\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u0011\u0010Ý\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÝ\u0001\u0010\u001aJ\u0011\u0010Þ\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bÞ\u0001\u0010\u001aJ#\u0010à\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0007\u0010ß\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0011\u0010â\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bâ\u0001\u0010\u001aJ\u0011\u0010ã\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bã\u0001\u0010\u001aJ\u001b\u0010ä\u0001\u001a\u00020\u00072\u0007\u0010\u009e\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0006\bä\u0001\u0010£\u0001J\u0019\u0010å\u0001\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0005\bå\u0001\u0010)J\u0019\u0010æ\u0001\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0005\bæ\u0001\u0010)J\u001c\u0010é\u0001\u001a\u00020\u00072\b\u0010è\u0001\u001a\u00030ç\u0001H\u0002¢\u0006\u0006\bé\u0001\u0010ê\u0001J\u001c\u0010ë\u0001\u001a\u00020\u00072\b\u0010è\u0001\u001a\u00030ç\u0001H\u0002¢\u0006\u0006\bë\u0001\u0010ê\u0001J\u0019\u0010ì\u0001\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0005\bì\u0001\u0010)J\u0019\u0010í\u0001\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0005\bí\u0001\u0010)J\u0019\u0010î\u0001\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\nH\u0002¢\u0006\u0005\bî\u0001\u00108J#\u0010ð\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0007\u0010ï\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\bð\u0001\u0010á\u0001J\u0019\u0010ñ\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0005\bñ\u0001\u00108J\u0011\u0010ò\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bò\u0001\u0010\u001aJ#\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010ó\u0001\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0006\bô\u0001\u0010á\u0001J\u001a\u0010÷\u0001\u001a\u00020\u00072\b\u0010ö\u0001\u001a\u00030õ\u0001¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u001a\u0010ú\u0001\u001a\u00020\u00072\u0007\u0010ù\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bú\u0001\u0010?J\u0011\u0010û\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bû\u0001\u0010\u001aJ\u0011\u0010ü\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bü\u0001\u0010\u001aJ&\u0010þ\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\r\u0010ý\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0005\bþ\u0001\u0010\u0018J\u0017\u0010ÿ\u0001\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"¢\u0006\u0005\bÿ\u0001\u0010)J\u0017\u0010\u0080\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0005\b\u0080\u0002\u00108J\u0011\u0010\u0081\u0002\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0081\u0002\u0010\u001aJ\u001e\u0010\u0084\u0002\u001a\u00020\u00072\n\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0082\u0002H\u0002¢\u0006\u0006\b\u0084\u0002\u0010\u0085\u0002J\u0011\u0010\u0086\u0002\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0086\u0002\u0010\u001aJ\u0011\u0010\u0087\u0002\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0087\u0002\u0010\u001aJ\u0011\u0010\u0088\u0002\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0088\u0002\u0010\u001aJ\u0019\u0010\u0089\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0089\u0002\u00108J\u0019\u0010\u008a\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0005\b\u008a\u0002\u00108J\u001a\u0010\u008b\u0002\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u008b\u0002\u0010¹\u0001J\u001c\u0010\u008c\u0002\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J\u0019\u0010\u008e\u0002\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0005\b\u008e\u0002\u0010)J,\u0010\u0091\u0002\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0007\u0010\u008f\u0002\u001a\u00020\u001b2\u0007\u0010\u0090\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u001c\u0010\u0093\u0002\u001a\u00020\u00072\b\u0010è\u0001\u001a\u00030ç\u0001H\u0002¢\u0006\u0006\b\u0093\u0002\u0010ê\u0001J\u0019\u0010\u0094\u0002\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0094\u0002\u00108J\u001c\u0010\u0095\u0002\u001a\u00020\u00072\b\u0010è\u0001\u001a\u00030ç\u0001H\u0002¢\u0006\u0006\b\u0095\u0002\u0010ê\u0001J#\u0010\u0096\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0007\u0010ß\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0096\u0002\u0010á\u0001J#\u0010\u0097\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0007\u0010ß\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0097\u0002\u0010á\u0001J\u001a\u0010\u0098\u0002\u001a\u00020\u00072\u0007\u0010ß\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0098\u0002\u00108J#\u0010\u0099\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0007\u0010ß\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0099\u0002\u0010á\u0001J#\u0010\u009a\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0007\u0010ß\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u009a\u0002\u0010á\u0001J#\u0010\u009b\u0002\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0007\u0010ß\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u009b\u0002\u0010á\u0001J\u001c\u0010\u009e\u0002\u001a\u00020\u00072\b\u0010\u009d\u0002\u001a\u00030\u009c\u0002H\u0002¢\u0006\u0006\b\u009e\u0002\u0010\u009f\u0002J\"\u0010¡\u0002\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u001d2\u0007\u0010 \u0002\u001a\u00020\n¢\u0006\u0006\b¡\u0002\u0010¢\u0002J\u001c\u0010£\u0002\u001a\u00020\u00072\b\u0010è\u0001\u001a\u00030ç\u0001H\u0002¢\u0006\u0006\b£\u0002\u0010ê\u0001J\u001f\u0010¥\u0002\u001a\u00020\u00072\u000e\u0010ý\u0001\u001a\t\u0012\u0005\u0012\u00030¤\u00020\u0014¢\u0006\u0005\b¥\u0002\u0010-J\u001b\u0010¦\u0002\u001a\u00020\u00072\u0007\u0010\u009e\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0006\b¦\u0002\u0010£\u0001J(\u0010©\u0002\u001a\u00020\u0007*\u0002022\u0007\u0010§\u0002\u001a\u00020\n2\u0007\u0010¨\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b©\u0002\u0010ª\u0002R\u001b\u0010«\u0002\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010¬\u0002R+\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u001d8\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0002\u0010¬\u0002\u001a\u0006\b®\u0002\u0010¯\u0002\"\u0006\b°\u0002\u0010¹\u0001R\u0018\u0010²\u0002\u001a\u00030±\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b²\u0002\u0010³\u0002R\u001e\u0010µ\u0002\u001a\t\u0012\u0004\u0012\u00020\n0´\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R\u0019\u0010·\u0002\u001a\u00020D8\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R \u0010¹\u0002\u001a\t\u0012\u0004\u0012\u00020\n0´\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010¶\u0002R\u0019\u0010º\u0002\u001a\u00020D8\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\bº\u0002\u0010¸\u0002R \u0010¼\u0002\u001a\t\u0012\u0004\u0012\u00020\u00150»\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¼\u0002\u0010½\u0002R!\u0010Ã\u0002\u001a\u00030¾\u00028CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\b¿\u0002\u0010À\u0002\u001a\u0006\bÁ\u0002\u0010Â\u0002R!\u0010È\u0002\u001a\u00030Ä\u00028CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bÅ\u0002\u0010À\u0002\u001a\u0006\bÆ\u0002\u0010Ç\u0002R\u0019\u0010É\u0002\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010Ê\u0002R*\u0010Ì\u0002\u001a\u00030Ë\u00028\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÌ\u0002\u0010Í\u0002\u001a\u0006\bÎ\u0002\u0010Ï\u0002\"\u0006\bÐ\u0002\u0010Ñ\u0002R\u001b\u0010Ò\u0002\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010¸\u0002R*\u0010Ô\u0002\u001a\u00030Ó\u00028\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÔ\u0002\u0010Õ\u0002\u001a\u0006\bÖ\u0002\u0010×\u0002\"\u0006\bØ\u0002\u0010Ù\u0002R\u001a\u0010Û\u0002\u001a\u00030Ú\u00028\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\bÛ\u0002\u0010Ü\u0002R*\u0010Þ\u0002\u001a\u00030Ý\u00028\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÞ\u0002\u0010ß\u0002\u001a\u0006\bà\u0002\u0010á\u0002\"\u0006\bâ\u0002\u0010ã\u0002R!\u0010ä\u0002\u001a\n\u0012\u0005\u0012\u00030\u009c\u00020»\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bä\u0002\u0010½\u0002R\u0019\u0010å\u0002\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bå\u0002\u0010æ\u0002R*\u0010è\u0002\u001a\u00030ç\u00028\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bè\u0002\u0010é\u0002\u001a\u0006\bê\u0002\u0010ë\u0002\"\u0006\bì\u0002\u0010í\u0002R \u0010ï\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bï\u0002\u0010ð\u0002R \u0010ñ\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bñ\u0002\u0010ð\u0002R \u0010ò\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bò\u0002\u0010ð\u0002R \u0010ó\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bó\u0002\u0010ð\u0002R \u0010ô\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bô\u0002\u0010ð\u0002R \u0010õ\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bõ\u0002\u0010ð\u0002R \u0010ö\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bö\u0002\u0010ð\u0002R \u0010÷\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b÷\u0002\u0010ð\u0002R \u0010ø\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bø\u0002\u0010ð\u0002R \u0010ù\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bù\u0002\u0010ð\u0002R \u0010ú\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bú\u0002\u0010ð\u0002R \u0010û\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bû\u0002\u0010ð\u0002R \u0010ü\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bü\u0002\u0010ð\u0002R \u0010ý\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bý\u0002\u0010ð\u0002R \u0010þ\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bþ\u0002\u0010ð\u0002R \u0010ÿ\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0î\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÿ\u0002\u0010ð\u0002R\u0019\u0010\u0080\u0003\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0080\u0003\u0010æ\u0002R!\u0010\u0085\u0003\u001a\u00030\u0081\u00038CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\b\u0082\u0003\u0010À\u0002\u001a\u0006\b\u0083\u0003\u0010\u0084\u0003R \u0010\u0086\u0003\u001a\t\u0012\u0004\u0012\u00020\u001b0»\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0086\u0003\u0010½\u0002R\u0019\u0010\u0087\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0087\u0003\u0010\u0088\u0003R\u0019\u0010\u0089\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0089\u0003\u0010\u0088\u0003R\u0019\u0010\u008a\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u008a\u0003\u0010\u0088\u0003R\u0019\u0010\u008b\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u008b\u0003\u0010\u0088\u0003R\u0019\u0010\u008c\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u008c\u0003\u0010\u0088\u0003R\u0019\u0010\u008d\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u008d\u0003\u0010\u0088\u0003R \u0010\u008e\u0003\u001a\t\u0012\u0004\u0012\u00020\u001b0»\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u008e\u0003\u0010½\u0002R\u0019\u0010\u008f\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u008f\u0003\u0010\u0088\u0003R\u001b\u0010\u0090\u0003\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0090\u0003\u0010¬\u0002R+\u0010\u0091\u0003\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0091\u0003\u0010\u0092\u0003\u001a\u0006\b\u0093\u0003\u0010\u0094\u0003\"\u0006\b\u0095\u0003\u0010\u0096\u0003R+\u0010\u0097\u0003\u001a\u0004\u0018\u00010\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0097\u0003\u0010¬\u0002\u001a\u0006\b\u0098\u0003\u0010¯\u0002\"\u0006\b\u0099\u0003\u0010¹\u0001R\u001b\u0010\u009a\u0003\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u009a\u0003\u0010¬\u0002R\u0019\u0010\u009b\u0003\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u009b\u0003\u0010æ\u0002R*\u0010\u009d\u0003\u001a\u00030\u009c\u00038\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009d\u0003\u0010\u009e\u0003\u001a\u0006\b\u009f\u0003\u0010 \u0003\"\u0006\b¡\u0003\u0010¢\u0003R\u0019\u0010£\u0003\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b£\u0003\u0010æ\u0002R*\u0010¥\u0003\u001a\u00030¤\u00038\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¥\u0003\u0010¦\u0003\u001a\u0006\b§\u0003\u0010¨\u0003\"\u0006\b©\u0003\u0010ª\u0003R*\u0010¬\u0003\u001a\u00030«\u00038\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¬\u0003\u0010\u00ad\u0003\u001a\u0006\b®\u0003\u0010¯\u0003\"\u0006\b°\u0003\u0010±\u0003R\"\u0010³\u0003\u001a\u000b\u0012\u0004\u0012\u00020\n\u0018\u00010²\u00038\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b³\u0003\u0010´\u0003R\u0017\u0010#\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b#\u0010¬\u0002R!\u0010¹\u0003\u001a\u00030µ\u00038CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\b¶\u0003\u0010À\u0002\u001a\u0006\b·\u0003\u0010¸\u0003R\u001e\u0010\u001e\u001a\t\u0012\u0004\u0012\u00020\u001d0´\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010¶\u0002R\u0019\u0010º\u0003\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bº\u0003\u0010Ê\u0002R*\u0010¼\u0003\u001a\u00030»\u00038\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¼\u0003\u0010½\u0003\u001a\u0006\b¾\u0003\u0010¿\u0003\"\u0006\bÀ\u0003\u0010Á\u0003R\u0019\u0010Â\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÂ\u0003\u0010\u0088\u0003R&\u0010Ä\u0003\u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001b0Ã\u00038\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÄ\u0003\u0010Å\u0003R\u001c\u0010Ç\u0003\u001a\u0005\u0018\u00010Æ\u00038\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÇ\u0003\u0010È\u0003R#\u0010Ê\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010É\u00030»\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÊ\u0003\u0010½\u0002R(\u0010Ë\u0003\u001a\u00020\u001b8\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bË\u0003\u0010\u0088\u0003\u001a\u0006\bÌ\u0003\u0010Í\u0003\"\u0005\bÎ\u0003\u0010?R\u0019\u0010Ï\u0003\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÏ\u0003\u0010æ\u0002R!\u0010Ô\u0003\u001a\u00030Ð\u00038CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bÑ\u0003\u0010À\u0002\u001a\u0006\bÒ\u0003\u0010Ó\u0003R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010Õ\u0003R*\u0010×\u0003\u001a\u00030Ö\u00038\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b×\u0003\u0010Ø\u0003\u001a\u0006\bÙ\u0003\u0010Ú\u0003\"\u0006\bÛ\u0003\u0010Ü\u0003R\u001f\u0010Ý\u0003\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÝ\u0003\u0010½\u0002R\u001c\u0010ö\u0001\u001a\u0005\u0018\u00010õ\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bö\u0001\u0010Þ\u0003R*\u0010à\u0003\u001a\u00030ß\u00038\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bà\u0003\u0010á\u0003\u001a\u0006\bâ\u0003\u0010ã\u0003\"\u0006\bä\u0003\u0010å\u0003R\u001f\u0010æ\u0003\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bæ\u0003\u0010½\u0002"}, d2 = {"Lid/dana/wallet_v3/view/NewWalletFragment;", "Lid/dana/base/viewbinding/ViewBindingToolbarFragment;", "Lid/dana/databinding/FragmentNewWalletBinding;", "Lid/dana/richview/wallet/BaseWalletCardView;", "view", "Landroid/widget/FrameLayout;", "cardView", "", "addCardView", "(Lid/dana/richview/wallet/BaseWalletCardView;Landroid/widget/FrameLayout;)V", "", "sectionIndex", "addEmptyCardView", "(ILid/dana/richview/wallet/BaseWalletCardView;Landroid/widget/FrameLayout;)V", "Landroid/widget/Space;", "space", "", "margin", "addSpaceHeight", "(Landroid/widget/Space;F)V", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", SceneType.ASSETS, "adjustCardSpacing", "(ILjava/util/List;)V", "adjustViewPosition", "()V", "", "assetWatcher", "", "sectionWatcher", "checkAnyPendingOpenDeeplink", "(Ljava/util/List;Ljava/lang/String;)V", "checkIsNeedToShowSectionTooltip", "Lid/dana/wallet_v3/model/WalletSectionModel;", HomeTabActivity.WALLET_SECTION, "Lid/dana/wallet_v3/model/SectionStatus;", "newStatus", "checkIsReload", "(Lid/dana/wallet_v3/model/WalletSectionModel;Lid/dana/wallet_v3/model/SectionStatus;)V", "checkShouldShowErrorState", "(Lid/dana/wallet_v3/model/WalletSectionModel;)V", "checkShouldShowTooltip", "result", "checkToShowErrorToast", "(Ljava/util/List;)V", "checkWalletAddAssetTooltip", "Lid/dana/utils/danah5/DanaH5Listener;", "createH5AppListener", "()Lid/dana/utils/danah5/DanaH5Listener;", "Landroid/view/View;", "targetView", "Lid/dana/showcase/target/Target;", "createTooltipTarget", "(Landroid/view/View;)Lid/dana/showcase/target/Target;", "delayToShowAnimation", "(I)V", "Lkotlin/Function0;", "target", "delayToShowTooltip", "(Lkotlin/jvm/functions/Function0;)V", "swipeable", "disableSwipe", "(Z)V", "dismissLoadingSearchBar", "dismissLoadingStateSection", "dispose", "fetchIdentitySection", "Lio/reactivex/disposables/Disposable;", "getAllAssetErrorObserver", "()Lio/reactivex/disposables/Disposable;", "getAllAssetFromLocalObserver", "getAllAssetFromNetworkObserver", "Lid/dana/contract/user/GetBalanceModule;", "getBalanceModule", "()Lid/dana/contract/user/GetBalanceModule;", "index", "getCollapseTransition", "(I)I", "Landroidx/appcompat/widget/AppCompatImageView;", "getDivider", "(I)Landroidx/appcompat/widget/AppCompatImageView;", "getExpectedSection", "(I)Ljava/lang/String;", "getFirstCardHeight", "getFirstCardView", "(I)Landroid/widget/FrameLayout;", "sectionType", "getIndexBasedOnType", "(Ljava/lang/String;)I", "getLayout", "()I", "Lid/dana/wallet_v3/di/module/NewWalletModule;", "getNewWalletModule", "()Lid/dana/wallet_v3/di/module/NewWalletModule;", "Lid/dana/wallet_v3/di/module/PersonalModule;", "getPersonalModule", "()Lid/dana/wallet_v3/di/module/PersonalModule;", "getScenarioBasedSectionType", "(Ljava/lang/String;)Ljava/lang/String;", "getSectionCardView", "(I)Ljava/util/List;", "Lid/dana/wallet_v3/view/WalletSectionHeaderView;", "getSectionHeaderView", "(I)Lid/dana/wallet_v3/view/WalletSectionHeaderView;", "Lid/dana/wallet_v3/view/WalletSectionTooltipView;", "getSectionTooltipView", "(I)Lid/dana/wallet_v3/view/WalletSectionTooltipView;", "getSectionViewTop", "(I)Landroid/view/View;", "Lid/dana/contract/services/ServicesModule;", "getServicesModule", "()Lid/dana/contract/services/ServicesModule;", "getSkeletonView", "getSpaceView", "getTooltipConstraintSet", "getTooltipTarget", "()Lid/dana/showcase/target/Target;", "getTooltipTransition", "getTransition", "getVoucherAndTicketAssetTypes", "()Ljava/util/List;", "getWalletArrowButtonSection", "Lcom/airbnb/lottie/LottieAnimationView;", "getWalletLottieButtonSection", "(I)Lcom/airbnb/lottie/LottieAnimationView;", "getWalletReloadButtonSection", "key", "source", "goToServicePage", "(Ljava/lang/String;Ljava/lang/String;)V", "gotoTopupPage", "hideIdentitySection", "hideSection", "hideTitleSectionHeader", IAPSyncCommand.COMMAND_INIT, "initInjector", "initOnClickListener", "initScrollView", "initView", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/FragmentNewWalletBinding;", "initWatcher", "initializeCountDownTimerPublishSubject", "initializeCountUpTimerPublishSubject", "", "intervalTime", "isReloadWithinIntervalTime", "(J)Z", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "walletConfig", "loadData", "(Lid/dana/domain/wallet_v3/model/WalletV3Config;)V", "loadDataFromPersistence", "navigateToGlobalSearch", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onAddKtpAsset", "onCardClickedAction", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "onClickLeftMenuButton", "(Landroid/view/View;)V", "onClickRightMenuButton", "onCollapse", "onCollapseFromSearch", "onDestroyView", "onGetAccessTokenAndKycLevel", "hidden", "onHiddenChanged", "onResume", "onSelected", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "openAddLoyaltyCard", "openAddPaymentCard", "assetType", "openBottomSheetAddAsset", "pocketId", "openLoyaltyDetailH5", "(Ljava/lang/String;)V", "Landroidx/fragment/app/Fragment;", LoginTrackingConstants.LoginParam.TO, "tag", "openNewFragment", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "openWalletFinancialFragment", "financialSectionIndex", "openWalletFinancialSection", "openWalletIdentityFragment", "identitySectionIndex", "openWalletIdentitySection", "openWalletLoyaltyFragment", "loyaltySectionIndex", "openWalletLoyaltySection", "openWalletPaymentFragment", "paymentSectionIndex", "openWalletPaymentSection", "openWalletSection", "openWalletVoucherAndTicketFragment", "voucherAndTicketSectionIndex", "openWalletVoucherAndTicketSection", "url", "redirectToMerchantPage", "refreshDataBasedOnLatestAddedAssetType", "refreshRedDotBasedOnLastWalletSectionTypeDetailOpened", "reloadAllData", "action", "reloadOrShowErrorMessage", "(JLkotlin/jvm/functions/Function0;)V", "removeAllCardListView", "removeSpaceHeight", "(Landroid/widget/Space;)V", "backToInitial", "saveSectionTooltipShown", "(Ljava/lang/String;Z)V", "setAllAssetToErrorState", "setCardClickListener", "visibility", "setCardsViewVisibility", "(II)V", "setExpandedLayoutHeight", "setFullyExpanded", "setLastWalletSectionTypeDetailOpenedBasedOnType", "setSectionEmpty", "setSectionError", "Ljava/lang/Runnable;", "onComplete", "setSectionState", "(Ljava/lang/Runnable;)V", "setSectionStateAndSlideUp", "setSectionSuccess", "setSectionView", "setSelectedSection", GriverMonitorConstants.KEY_SIZE, "setSpaceVisibility", "setStackedCardPosition", "setTimeoutAllAssetFromNetworkObserver", "divider", "setTooltipConstraintSetMargin", "Lid/dana/wallet_v3/listener/WalletTabListener;", "walletTabListener", "setWalletTabListener", "(Lid/dana/wallet_v3/listener/WalletTabListener;)V", "isDefaultIndonesian", "setupLottieBasedOnLanguage", "setupSectionIndex", "setupToolbar", "list", "showCardList", "showEmptyState", "showErrorState", "showErrorStateInIdentity", "Landroid/view/ViewGroup;", "parent", "showGetAllAssetErrorSnackBar", "(Landroid/view/ViewGroup;)V", "showGetAssetErrorToast", "showIdentitySection", "showLoadingSearchBar", "showLoadingStateSection", "showSection", "showSectionTooltip", "showShowcase", "(Lid/dana/showcase/target/Target;)V", "showTitleSectionHeader", "isHasNewAsset", "totalAssets", "showTotalAssetSectionHeader", "(Lid/dana/wallet_v3/model/WalletSectionModel;ZI)V", "startAnimateSlideUp", "startExpandSectionAnimation", "startFadeOutCardShuffle", "toggleDividerVisibility", "toggleDropdownVisibility", "toggleIdentitySectionVisibility", "toggleReloadVisibility", "toggleSectionSkeletonVisibility", "toggleSectionVisibility", "Lid/dana/model/ThirdPartyService;", "it", "trackServiceOpen", "(Lid/dana/model/ThirdPartyService;)V", "danaDealsVersion", "trackWalletOpen", "(Ljava/lang/String;I)V", "transitionToExpand", "Lid/dana/wallet_v3/model/IdentityCardModel$KtpCard;", "updateIdentityCardState", "updateSectionTooltipVisibility", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "requestNewSize", "(Landroid/view/View;II)V", "accessToken", "Ljava/lang/String;", "assetOrder", "getAssetOrder", "()Ljava/lang/String;", "setAssetOrder", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/subjects/PublishSubject;", "countDownPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "countDownPublishSubjectDisposable", "Lio/reactivex/disposables/Disposable;", "countUpPublishSubject", "countUpPublishSubjectDisposable", "", "currentCardModelItems", "Ljava/util/List;", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener$delegate", "Lkotlin/Lazy;", "getDanaBalanceClickListener", "()Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener", "Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog$delegate", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog", "defaultHeight", "I", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "disposableTimeoutAllAssets", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "errorGetAllAssetSnackbar", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "financeServices", "financialSection", "Lid/dana/wallet_v3/model/WalletSectionModel;", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getBalancePresenter", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getGetBalancePresenter", "()Lid/dana/contract/user/GetBalanceContract$Presenter;", "setGetBalancePresenter", "(Lid/dana/contract/user/GetBalanceContract$Presenter;)V", "Lio/reactivex/subjects/Subject;", "getInvestmentAssetErrorWatcher", "Lio/reactivex/subjects/Subject;", "getInvestmentAssetFromLocalEmptyWatcher", "getInvestmentAssetFromLocalWatcher", "getInvestmentAssetWatcher", "getLoyaltyAssetErrorWatcher", "getLoyaltyAssetFromLocalEmptyWatcher", "getLoyaltyAssetFromLocalWatcher", "getLoyaltyAssetWatcher", "getPaymentAssetErrorWatcher", "getPaymentAssetFromLocalEmptyWatcher", "getPaymentAssetFromLocalWatcher", "getPaymentAssetWatcher", "getVoucherAssetErrorWatcher", "getVoucherAssetFromLocalEmptyWatcher", "getVoucherAssetFromLocalWatcher", "getVoucherAssetWatcher", "identitySection", "Lid/dana/wallet_v3/identity/IdentityToastAndDialogImpl;", "identityToastAndDialog$delegate", "getIdentityToastAndDialog", "()Lid/dana/wallet_v3/identity/IdentityToastAndDialogImpl;", "identityToastAndDialog", "isAssetsFromLocalEmpty", "isCheckTooltipVisibility", "Z", "isFetchDataAfterFromLocal", "isLottieShown", "isOpenDetail", "isOpenLoyaltyDetail", "isScrollable", "isShowSkeletonList", "ktpIsSaved", WalletConstant.KYC_LEVEL, "lastAddedAssetType", "Ljava/lang/Integer;", "getLastAddedAssetType", "()Ljava/lang/Integer;", "setLastAddedAssetType", "(Ljava/lang/Integer;)V", "lastWalletSectionTypeDetailOpened", "getLastWalletSectionTypeDetailOpened", "setLastWalletSectionTypeDetailOpened", "loyaltyPocketId", "loyaltySection", "Lid/dana/wallet_v3/presenter/NewWalletContract$Presenter;", "newWalletPresenter", "Lid/dana/wallet_v3/presenter/NewWalletContract$Presenter;", "getNewWalletPresenter", "()Lid/dana/wallet_v3/presenter/NewWalletContract$Presenter;", "setNewWalletPresenter", "(Lid/dana/wallet_v3/presenter/NewWalletContract$Presenter;)V", "paymentSection", "Lid/dana/wallet/personal/PersonalContract$Presenter;", "personalPresenter", "Lid/dana/wallet/personal/PersonalContract$Presenter;", "getPersonalPresenter", "()Lid/dana/wallet/personal/PersonalContract$Presenter;", "setPersonalPresenter", "(Lid/dana/wallet/personal/PersonalContract$Presenter;)V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "", "scrollPosition", "[Ljava/lang/Integer;", "Lid/dana/wallet_v3/listener/SectionTooltipClickListener;", "sectionTooltipClickListener$delegate", "getSectionTooltipClickListener", "()Lid/dana/wallet_v3/listener/SectionTooltipClickListener;", "sectionTooltipClickListener", "selectedIndex", "Lid/dana/contract/services/ServicesContract$Presenter;", "servicePresenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "getServicePresenter", "()Lid/dana/contract/services/ServicesContract$Presenter;", "setServicePresenter", "(Lid/dana/contract/services/ServicesContract$Presenter;)V", "shouldShowIdentityTooltip", "", "shouldShowSectionTooltip", "Ljava/util/Map;", "Lid/dana/showcase/Showcase;", TooltipEvent.SHOW_CASE, "Lid/dana/showcase/Showcase;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreenList", "skipLoadData", "getSkipLoadData", "()Z", "setSkipLoadData", "voucherAndTicketSection", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "walletH5ServicesImplementation", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "getWalletH5ServicesImplementation", "()Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "setWalletH5ServicesImplementation", "(Lid/dana/wallet_v3/WalletH5ServicesImplementation;)V", "walletSectionOrderingList", "Lid/dana/wallet_v3/listener/WalletTabListener;", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "walletV3TrackerImplementation", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "getWalletV3TrackerImplementation", "()Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "setWalletV3TrackerImplementation", "(Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;)V", "walletVoucherAndTicketSectionAssetType", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NewWalletFragment extends ViewBindingToolbarFragment<FragmentNewWalletBinding> {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final int DEFAULT_CACHE_DURATION_IN_MINUTES = 4320;
    public static final int FIFTH_SECTION_INDEX = 4;
    public static final int FIRST_SECTION_INDEX = 0;
    public static final int FOURTH_SECTION_INDEX = 3;
    private static final int IDENTITY_REQUEST_CODE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static final float MARGIN_BOTTOM_EMPTY_STATE = 0.0f;
    private static final float MARGIN_BOTTOM_WALLET_ASSET = 106.0f;
    private static final float MARGIN_SPACE_BIG = 56.0f;
    private static final float MARGIN_SPACE_SMALL = 8.0f;
    private static int[] MyBillsEntityDataFactory = null;
    private static int PlaceComponentResult = 0;
    public static final int SECOND_SECTION_INDEX = 1;
    private static final int SPOTLIGHT_SIZE = 20;
    public static final int THIRD_SECTION_INDEX = 2;
    public static final String WALLET_SECTION = "WALLET_SECTION";
    public Map<Integer, View> _$_findViewCache;
    private String accessToken;
    private String assetOrder;
    private final CompositeDisposable compositeDisposable;
    private final PublishSubject<Integer> countDownPublishSubject;
    private Disposable countDownPublishSubjectDisposable;
    private PublishSubject<Integer> countUpPublishSubject;
    private Disposable countUpPublishSubjectDisposable;
    private List<WalletV3CardModel> currentCardModelItems;

    /* renamed from: danaBalanceClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaBalanceClickListener;

    /* renamed from: danaLoadingDialog$delegate  reason: from kotlin metadata */
    private final Lazy danaLoadingDialog;
    private int defaultHeight;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    private Disposable disposableTimeoutAllAssets;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    private CustomSnackbar errorGetAllAssetSnackbar;
    @Inject
    public FeatureContract.Presenter featurePresenter;
    private List<ThirdPartyService> financeServices;
    private WalletSectionModel financialSection;
    @Inject
    public GetBalanceContract.Presenter getBalancePresenter;
    private Subject<Boolean> getInvestmentAssetErrorWatcher;
    private Subject<Boolean> getInvestmentAssetFromLocalEmptyWatcher;
    private Subject<Boolean> getInvestmentAssetFromLocalWatcher;
    private Subject<Boolean> getInvestmentAssetWatcher;
    private Subject<Boolean> getLoyaltyAssetErrorWatcher;
    private Subject<Boolean> getLoyaltyAssetFromLocalEmptyWatcher;
    private Subject<Boolean> getLoyaltyAssetFromLocalWatcher;
    private Subject<Boolean> getLoyaltyAssetWatcher;
    private Subject<Boolean> getPaymentAssetErrorWatcher;
    private Subject<Boolean> getPaymentAssetFromLocalEmptyWatcher;
    private Subject<Boolean> getPaymentAssetFromLocalWatcher;
    private Subject<Boolean> getPaymentAssetWatcher;
    private Subject<Boolean> getVoucherAssetErrorWatcher;
    private Subject<Boolean> getVoucherAssetFromLocalEmptyWatcher;
    private Subject<Boolean> getVoucherAssetFromLocalWatcher;
    private Subject<Boolean> getVoucherAssetWatcher;
    private WalletSectionModel identitySection;

    /* renamed from: identityToastAndDialog$delegate  reason: from kotlin metadata */
    private final Lazy identityToastAndDialog;
    private List<Boolean> isAssetsFromLocalEmpty;
    private boolean isCheckTooltipVisibility;
    private boolean isFetchDataAfterFromLocal;
    private boolean isLottieShown;
    private boolean isOpenDetail;
    private boolean isOpenLoyaltyDetail;
    private boolean isScrollable;
    private List<Boolean> isShowSkeletonList;
    private boolean ktpIsSaved;
    private String kycLevel;
    private Integer lastAddedAssetType;
    private String lastWalletSectionTypeDetailOpened;
    private String loyaltyPocketId;
    private WalletSectionModel loyaltySection;
    @Inject
    public NewWalletContract.Presenter newWalletPresenter;
    private WalletSectionModel paymentSection;
    @Inject
    public PersonalContract.Presenter personalPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    private Integer[] scrollPosition;
    private String section;

    /* renamed from: sectionTooltipClickListener$delegate  reason: from kotlin metadata */
    private final Lazy sectionTooltipClickListener;
    private PublishSubject<String> sectionWatcher;
    private int selectedIndex;
    @Inject
    public ServicesContract.Presenter servicePresenter;
    private boolean shouldShowIdentityTooltip;
    private Map<String, Boolean> shouldShowSectionTooltip;
    private Showcase showcase;
    private List<SkeletonScreen> skeletonScreenList;
    private boolean skipLoadData;
    private WalletSectionModel voucherAndTicketSection;

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener;
    private WalletV3Config walletConfig;
    @Inject
    public WalletH5ServicesImplementation walletH5ServicesImplementation;
    private List<String> walletSectionOrderingList;
    private WalletTabListener walletTabListener;
    @Inject
    public WalletV3TrackerImpl walletV3TrackerImplementation;
    private List<String> walletVoucherAndTicketSectionAssetType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SectionStatus.values().length];
            iArr[SectionStatus.SUCCESS.ordinal()] = 1;
            iArr[SectionStatus.EMPTY.ordinal()] = 2;
            iArr[SectionStatus.ERROR.ordinal()] = 3;
            iArr[SectionStatus.HIDDEN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: $r8$lambda$-hgNSnaV8odgjMAQNXnjTbRQJxs */
    public static /* synthetic */ void m3030$r8$lambda$hgNSnaV8odgjMAQNXnjTbRQJxs(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? 'S' : Typography.dollar;
        m3082openWalletIdentitySection$lambda43(newWalletFragment);
        if (c != '$') {
            int i2 = 59 / 0;
        }
    }

    /* renamed from: $r8$lambda$44-wm4P2OwTlAsJ6fNrskLeabRo */
    public static /* synthetic */ void m3031$r8$lambda$44wm4P2OwTlAsJ6fNrskLeabRo(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            m3064initOnClickListener$lambda34(newWalletFragment, view);
            Object obj = null;
            obj.hashCode();
        } else {
            try {
                m3064initOnClickListener$lambda34(newWalletFragment, view);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
    }

    /* renamed from: $r8$lambda$A8gBXR5ZLkHits_BGm-5AgrgreA */
    public static /* synthetic */ void m3032$r8$lambda$A8gBXR5ZLkHits_BGm5AgrgreA(NewWalletFragment newWalletFragment, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        PlaceComponentResult = i2 % 128;
        if (!(i2 % 2 != 0)) {
            try {
                m3092showLoadingStateSection$lambda84(newWalletFragment, i);
            } catch (Exception e) {
                throw e;
            }
        } else {
            m3092showLoadingStateSection$lambda84(newWalletFragment, i);
            Object obj = null;
            obj.hashCode();
        }
        int i3 = PlaceComponentResult + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void $r8$lambda$AmqrMP23KlQU_48553AzeG3OTW0(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        m3077onCollapse$lambda5(newWalletFragment);
        int i3 = PlaceComponentResult + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static /* synthetic */ void $r8$lambda$DrePuw08RFs_SMhxdprWUMGVw0U(NewWalletFragment newWalletFragment) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            m3086openWalletPaymentSection$lambda55(newWalletFragment);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$F-a_AuHPZCkDVcRouVZIxTn8UeQ */
    public static /* synthetic */ void m3033$r8$lambda$Fa_AuHPZCkDVcRouVZIxTn8UeQ() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        m3083openWalletLoyaltySection$lambda45();
        if (!z) {
            return;
        }
        int i2 = 54 / 0;
    }

    public static /* synthetic */ void $r8$lambda$FCY79l4XDKXiRWnlSONpI8oiBsU(NewWalletFragment newWalletFragment, Long l) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        m3072initializeCountDownTimerPublishSubject$lambda59(newWalletFragment, l);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$FLotG2OZ7Uolct0wE6lb3SK82bo(Runnable runnable) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            m3094transitionToExpand$lambda29(runnable);
            int i3 = PlaceComponentResult + 119;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$Foog-fZU53mCWBZmdlPFHPFp8xM */
    public static /* synthetic */ void m3034$r8$lambda$FoogfZU53mCWBZmdlPFHPFp8xM(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? Typography.quote : (char) 23) != 23) {
            m3089setTimeoutAllAssetFromNetworkObserver$lambda17(newWalletFragment);
            int i2 = 74 / 0;
        } else {
            try {
                m3089setTimeoutAllAssetFromNetworkObserver$lambda17(newWalletFragment);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = PlaceComponentResult + 89;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void $r8$lambda$FstULgomsywTW3PndmPrEs4hkIg(NewWalletFragment newWalletFragment, List list) {
        int i = PlaceComponentResult + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        char c = i % 2 == 0 ? ')' : '#';
        m3052getAllAssetErrorObserver$lambda11(newWalletFragment, list);
        if (c != '#') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static /* synthetic */ void $r8$lambda$G9BNZMtF6YBrhEDhCp_UlQhIPzQ(NewWalletFragment newWalletFragment) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            try {
                m3090setTimeoutAllAssetFromNetworkObserver$lambda17$lambda16(newWalletFragment);
                int i3 = PlaceComponentResult + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$JB-mF7UI__C8iEQRm6PqF6JgDbo */
    public static /* synthetic */ void m3035$r8$lambda$JBmF7UI__C8iEQRm6PqF6JgDbo(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            try {
                m3063initOnClickListener$lambda33(newWalletFragment, view);
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            m3063initOnClickListener$lambda33(newWalletFragment, view);
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? '_' : 'J') != '_') {
            return;
        }
        int length = objArr.length;
    }

    public static /* synthetic */ void $r8$lambda$JJWG9PHu951aw3KNd5bzStF7yWo(NewWalletFragment newWalletFragment) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            m3080openWalletFinancialSection$lambda49(newWalletFragment);
            int i3 = PlaceComponentResult + 105;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 3 : 'V') != 'V') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$JzvmLbQsL70lZU2UlrQrPPzKWc4(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            m3084openWalletLoyaltySection$lambda46(newWalletFragment);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$L6wAX1UzjG3auGC1S0LsdctPYXE(MotionLayout motionLayout, NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        m3078onCollapseFromSearch$lambda0(motionLayout, newWalletFragment);
        int i3 = PlaceComponentResult + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? '#' : 'P') != '#') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static /* synthetic */ void $r8$lambda$M5I_pzh9eLjKC9drsBRx2YuwSh0(NewWalletFragment newWalletFragment, Throwable th) {
        int i = PlaceComponentResult + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        m3059getAllAssetFromNetworkObserver$lambda21(newWalletFragment, th);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? ']' : ':') != ':') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$MsD5Ngf7evllfakg9ruMfbYdeh4(NewWalletFragment newWalletFragment, View view, MotionEvent motionEvent) {
        try {
            int i = PlaceComponentResult + 51;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 == 0) {
                try {
                    boolean m3071initScrollView$lambda6 = m3071initScrollView$lambda6(newWalletFragment, view, motionEvent);
                    Object obj = null;
                    obj.hashCode();
                    return m3071initScrollView$lambda6;
                } catch (Exception e) {
                    throw e;
                }
            }
            return m3071initScrollView$lambda6(newWalletFragment, view, motionEvent);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$N-iq7Ode7wpPPTktezzHW0tfnD0 */
    public static /* synthetic */ void m3036$r8$lambda$Niq7Ode7wpPPTktezzHW0tfnD0(NewWalletFragment newWalletFragment, Long l) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        m3073initializeCountUpTimerPublishSubject$lambda58(newWalletFragment, l);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    /* renamed from: $r8$lambda$OKfa7NDK_6liU50v8BNs-bXJzhk */
    public static /* synthetic */ void m3037$r8$lambda$OKfa7NDK_6liU50v8BNsbXJzhk() {
        int i = PlaceComponentResult + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? 'c' : Typography.greater) != '>') {
            m3087openWalletVoucherAndTicketSection$lambda51();
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            m3087openWalletVoucherAndTicketSection$lambda51();
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$ONtelD4Bp10ZAvtFKknc4uZXkXE(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        PlaceComponentResult = i % 128;
        try {
            if ((i % 2 != 0 ? '\t' : (char) 20) == 20) {
                m3070initOnClickListener$lambda40(newWalletFragment, view);
                return;
            }
            m3070initOnClickListener$lambda40(newWalletFragment, view);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$ObU8-8s79wx8ELGkuhP8h7ODP5w */
    public static /* synthetic */ void m3038$r8$lambda$ObU88s79wx8ELGkuhP8h7ODP5w() {
        int i = PlaceComponentResult + 71;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? '=' : 'R') != 'R') {
            m3081openWalletIdentitySection$lambda42();
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            m3081openWalletIdentitySection$lambda42();
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$PcSVn7HjrHseqBqTaU5l1LHIsnk(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? (char) 30 : '-';
        m3075onCollapse$lambda4$lambda2(newWalletFragment);
        if (c == 30) {
            int i2 = 86 / 0;
        }
        int i3 = PlaceComponentResult + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? 'Q' : (char) 22) != 22) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* renamed from: $r8$lambda$PrZkJZnqZ-vn0Zfr9uXwSmRdtjE */
    public static /* synthetic */ void m3039$r8$lambda$PrZkJZnqZvn0Zfr9uXwSmRdtjE() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? 'G' : 'b';
        m3079openWalletFinancialSection$lambda48();
        if (c != 'G') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static /* synthetic */ void $r8$lambda$Qk1R7K41NJS_f4XkC0CGYtEfyEk(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            m3067initOnClickListener$lambda37(newWalletFragment, view);
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            m3067initOnClickListener$lambda37(newWalletFragment, view);
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$S-mZZZOKWOrp4YMd7DieX0gMqm0 */
    public static /* synthetic */ Pair m3040$r8$lambda$SmZZZOKWOrp4YMd7DieX0gMqm0(NewWalletFragment newWalletFragment, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Pair m3053getAllAssetFromLocalObserver$lambda13 = m3053getAllAssetFromLocalObserver$lambda13(newWalletFragment, bool, bool2, bool3, bool4, bool5, bool6, bool7, bool8);
            int i3 = PlaceComponentResult + 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return m3053getAllAssetFromLocalObserver$lambda13;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$UItvaixpTaJa9oYaLuOCI7vLgQ8(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            m3055getAllAssetFromLocalObserver$lambda15$lambda14(newWalletFragment);
            int i2 = 10 / 0;
            return;
        }
        try {
            m3055getAllAssetFromLocalObserver$lambda15$lambda14(newWalletFragment);
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$WNjv5dEMwAG4YwBjJR0l55gRNeU(NewWalletFragment newWalletFragment, int i) {
        int i2 = PlaceComponentResult + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        try {
            m3049addEmptyCardView$lambda83(newWalletFragment, i);
            int i4 = PlaceComponentResult + 53;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$WzorE6Qocvd6yo5YmXt0YxdUOlI(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        m3065initOnClickListener$lambda35(newWalletFragment, view);
        if (z) {
            int i2 = 17 / 0;
        }
    }

    public static /* synthetic */ void $r8$lambda$YGGpeYEvXlPk8S6bXmGnFejBE4Q(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            m3069initOnClickListener$lambda39(newWalletFragment, view);
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$_XR1JdYtHkc-MTfrf7ix6TGOiwQ */
    public static /* synthetic */ void m3041$r8$lambda$_XR1JdYtHkcMTfrf7ix6TGOiwQ(NewWalletFragment newWalletFragment, Triple triple) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
            PlaceComponentResult = i % 128;
            char c = i % 2 != 0 ? Typography.less : '*';
            Object[] objArr = null;
            m3057getAllAssetFromNetworkObserver$lambda20(newWalletFragment, triple);
            if (c == '<') {
                int length = objArr.length;
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            PlaceComponentResult = i2 % 128;
            if ((i2 % 2 != 0 ? '+' : '#') != '+') {
                return;
            }
            int length2 = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Triple $r8$lambda$b5nNluiRXrnyqxJHSX2edneDWjw(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            try {
                Triple m3056getAllAssetFromNetworkObserver$lambda18 = m3056getAllAssetFromNetworkObserver$lambda18(bool, bool2, bool3, bool4, bool5, bool6, bool7, bool8, str);
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                PlaceComponentResult = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    return m3056getAllAssetFromNetworkObserver$lambda18;
                }
                Object obj = null;
                obj.hashCode();
                return m3056getAllAssetFromNetworkObserver$lambda18;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$bm8jIbxeO7g4GQkAKcUoGEfbk8g(NewWalletFragment newWalletFragment, View view) {
        try {
            int i = PlaceComponentResult + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (!(i % 2 == 0)) {
                m3060initOnClickListener$lambda30(newWalletFragment, view);
                return;
            }
            try {
                m3060initOnClickListener$lambda30(newWalletFragment, view);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$dkWCECZfAzBysBYR4LzS-83Gr2E */
    public static /* synthetic */ void m3042$r8$lambda$dkWCECZfAzBysBYR4LzS83Gr2E(NewWalletFragment newWalletFragment) {
        try {
            int i = PlaceComponentResult + 69;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            boolean z = i % 2 != 0;
            m3076onCollapse$lambda4$lambda3(newWalletFragment);
            if (!z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = PlaceComponentResult + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$drvo_AQB87Zo8cyw3TfPX-qiy0c */
    public static /* synthetic */ void m3043$r8$lambda$drvo_AQB87Zo8cyw3TfPXqiy0c(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        m3074navigateToGlobalSearch$lambda57(newWalletFragment);
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = PlaceComponentResult + 95;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int i3 = 75 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$eFZU-iwtFJvNBkvasLMj2tWN93w */
    public static /* synthetic */ void m3044$r8$lambda$eFZUiwtFJvNBkvasLMj2tWN93w(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        m3088openWalletVoucherAndTicketSection$lambda52(newWalletFragment);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void $r8$lambda$fwn2LFktOU767q0Tot21Vjhplb4(List list, NewWalletFragment newWalletFragment, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        try {
            m3050adjustCardSpacing$lambda86(list, newWalletFragment, i);
            int i4 = PlaceComponentResult + 21;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$hWoOJSJouJXIACW4lv9u9KBqcUI(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            m3068initOnClickListener$lambda38(newWalletFragment, view);
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            m3068initOnClickListener$lambda38(newWalletFragment, view);
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$jjFN7-i8nIAVckdy7pe54UGZSII */
    public static /* synthetic */ void m3045$r8$lambda$jjFN7i8nIAVckdy7pe54UGZSII(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            m3062initOnClickListener$lambda32(newWalletFragment, view);
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 != 0 ? 'U' : InputCardNumberView.DIVIDER) != 'U') {
                    return;
                }
                int i4 = 37 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$n2u2xQupgw47QRQG2yL7TbEAL0w(NewWalletFragment newWalletFragment, List list, List list2, String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
            PlaceComponentResult = i % 128;
            char c = i % 2 != 0 ? (char) 15 : Typography.amp;
            m3058getAllAssetFromNetworkObserver$lambda20$lambda19(newWalletFragment, list, list2, str);
            if (c != '&') {
                int i2 = 74 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$qY3RxZUkpsra42rpWaZCGi_vwkA() {
        try {
            int i = PlaceComponentResult + 97;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                m3085openWalletPaymentSection$lambda54();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 == 0) {
                    return;
                }
                int i4 = 22 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$tBkF4w2h45AwOPA0vWyBgpNpOaM(View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        m3093showShowcase$lambda65(view);
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* renamed from: $r8$lambda$uo3_z0hntWui-GyZ0vagn2c-u0A */
    public static /* synthetic */ void m3046$r8$lambda$uo3_z0hntWuiGyZ0vagn2cu0A(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        m3061initOnClickListener$lambda31(newWalletFragment, view);
        int i3 = PlaceComponentResult + 87;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        int i4 = 91 / 0;
    }

    /* renamed from: $r8$lambda$w2E4Upme7mX0GKRBg1-CohEJuLI */
    public static /* synthetic */ void m3047$r8$lambda$w2E4Upme7mX0GKRBg1CohEJuLI(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            m3066initOnClickListener$lambda36(newWalletFragment, view);
            int i3 = PlaceComponentResult + 103;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$xl4smRYBBEdKGuHJOPK4yFB5Hr0(NewWalletFragment newWalletFragment, int i, List list) {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
            try {
                PlaceComponentResult = i2 % 128;
                boolean z = i2 % 2 == 0;
                m3091showCardList$lambda77(newWalletFragment, i, list);
                if (!z) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$yeUO-swm3bZ_GsdSX6HhxUJmsTc */
    public static /* synthetic */ List m3048$r8$lambda$yeUOswm3bZ_GsdSX6HhxUJmsTc(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        try {
            int i = PlaceComponentResult + 53;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                List m3051getAllAssetErrorObserver$lambda10 = m3051getAllAssetErrorObserver$lambda10(bool, bool2, bool3, bool4);
                int i3 = PlaceComponentResult + 5;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return m3051getAllAssetErrorObserver$lambda10;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$zBxRbewggWPqMhQrUfQLUQ36jSU(NewWalletFragment newWalletFragment, Pair pair) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            try {
                m3054getAllAssetFromLocalObserver$lambda15(newWalletFragment, pair);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            m3054getAllAssetFromLocalObserver$lambda15(newWalletFragment, pair);
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = new int[]{-194290157, 32774916, 1529211637, 1657039949, -15976922, -360891036, -794361194, -896020846, -638074165, 441697314, 80199295, -717098910, 545287211, 390734329, -856680676, -1970313673, 1815172417, -1906166666};
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x001b, code lost:
    
        if ((r7 == 0) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0024, code lost:
    
        if ((r7 != 0) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0026, code lost:
    
        if (r7 == 1) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0028, code lost:
    
        if (r7 == 2) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002a, code lost:
    
        if (r7 == 3) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002d, code lost:
    
        if (r7 == 4) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002f, code lost:
    
        r7 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0031, code lost:
    
        r7 = id.dana.R.id.step2to1Section5back;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0035, code lost:
    
        r7 = id.dana.R.id.step2to1Section4back;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0039, code lost:
    
        r7 = id.dana.R.id.step2to1Section3back;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003d, code lost:
    
        r7 = id.dana.R.id.step2to1Section2back;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:
    
        r7 = id.dana.R.id.step2to1Section1back;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int getCollapseTransition(int r7) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 3
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2
            r2 = 2
            int r0 = r0 % r2
            r3 = 85
            if (r0 == 0) goto L11
            r0 = 85
            goto L13
        L11:
            r0 = 88
        L13:
            r4 = 1
            r5 = 0
            if (r0 == r3) goto L1e
            if (r7 == 0) goto L1a
            goto L1b
        L1a:
            r5 = 1
        L1b:
            if (r5 == 0) goto L26
            goto L41
        L1e:
            r0 = 43
            int r0 = r0 / r5
            if (r7 == 0) goto L24
            r5 = 1
        L24:
            if (r5 == 0) goto L41
        L26:
            if (r7 == r4) goto L3d
            if (r7 == r2) goto L39
            if (r7 == r1) goto L35
            r0 = 4
            if (r7 == r0) goto L31
            r7 = -1
            goto L44
        L31:
            r7 = 2131366538(0x7f0a128a, float:1.8352972E38)
            goto L44
        L35:
            r7 = 2131366537(0x7f0a1289, float:1.835297E38)
            goto L44
        L39:
            r7 = 2131366536(0x7f0a1288, float:1.8352968E38)
            goto L44
        L3d:
            r7 = 2131366535(0x7f0a1287, float:1.8352966E38)
            goto L44
        L41:
            r7 = 2131366534(0x7f0a1286, float:1.8352964E38)
        L44:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % r2
            return r7
        L4e:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getCollapseTransition(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x005b, code lost:
    
        return "loyalty";
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x005e, code lost:
    
        return "voucher_and_ticket";
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:?, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:?, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0034, code lost:
    
        if ((r7 != 5 ? 'K' : '@') != 'K') goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0040, code lost:
    
        if ((r7 != 2 ? 'I' : ',') != ',') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0043, code lost:
    
        if (r7 == 3) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0045, code lost:
    
        r7 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x004e, code lost:
    
        if ((r7 % 2) == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0050, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0051, code lost:
    
        if (r3 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0054, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0055, code lost:
    
        r7.hashCode();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String getExpectedSection(int r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            if (r7 == 0) goto L69
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L67
            int r1 = r1 + 93
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Exception -> L65
            r2 = 2
            int r1 = r1 % r2
            r1 = 68
            r3 = 1
            if (r7 == r3) goto L16
            r4 = 11
            goto L18
        L16:
            r4 = 68
        L18:
            if (r4 == r1) goto L62
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            r4 = 5
            int r1 = r1 + r4
            int r5 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5
            int r1 = r1 % r2
            r5 = 0
            if (r1 == 0) goto L28
            r1 = 0
            goto L29
        L28:
            r1 = 1
        L29:
            if (r1 == r3) goto L37
            r1 = 75
            if (r7 == r4) goto L32
            r4 = 75
            goto L34
        L32:
            r4 = 64
        L34:
            if (r4 == r1) goto L42
            goto L5e
        L37:
            r1 = 44
            if (r7 == r2) goto L3e
            r4 = 73
            goto L40
        L3e:
            r4 = 44
        L40:
            if (r4 == r1) goto L5e
        L42:
            r1 = 3
            if (r7 == r1) goto L5b
            int r7 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L67
            int r7 = r7 + 95
            int r1 = r7 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L67
            int r7 = r7 % r2
            if (r7 == 0) goto L51
            r3 = 0
        L51:
            if (r3 == 0) goto L54
            goto L6c
        L54:
            r7 = 0
            r7.hashCode()     // Catch: java.lang.Throwable -> L59
            goto L6c
        L59:
            r7 = move-exception
            throw r7
        L5b:
            java.lang.String r0 = "loyalty"
            goto L6c
        L5e:
            java.lang.String r0 = "voucher_and_ticket"
            goto L6c
        L62:
            java.lang.String r0 = "financial"
            goto L6c
        L65:
            r7 = move-exception
            throw r7
        L67:
            r7 = move-exception
            throw r7
        L69:
            java.lang.String r0 = "payment"
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getExpectedSection(int):java.lang.String");
    }

    private final int getTooltipConstraintSet(int index) {
        int i;
        int i2;
        if (index != 0) {
            if (index != 1) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                if (index == 2) {
                    return R.id.cs_tooltip_section_three;
                }
                if (index == 3) {
                    return R.id.cs_tooltip_section_four;
                }
                if (!(index != 4)) {
                    return R.id.cs_tooltip_section_five;
                }
                int i5 = PlaceComponentResult + 29;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if (i5 % 2 == 0) {
                    int i6 = 27 / 0;
                }
                i = -1;
                i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
            } else {
                i = R.id.cs_tooltip_section_two;
                i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
            }
            PlaceComponentResult = i2 % 128;
            int i7 = i2 % 2;
            return i;
        }
        return R.id.cs_tooltip_section_one;
    }

    private final int getTooltipTransition(int index) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (index != 0) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            if ((index != 1 ? Typography.amp : '@') != '&') {
                return R.id.slideOutTooltipSection2;
            }
            int i5 = PlaceComponentResult + 107;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
            if (index == 2) {
                return R.id.slideOutTooltipSection3;
            }
            int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
            PlaceComponentResult = i7 % 128;
            if ((i7 % 2 != 0 ? (char) 17 : ';') == ';' ? index == 3 : index == 5) {
                return R.id.slideOutTooltipSection4;
            }
            if (index != 4) {
                return -1;
            }
            return R.id.slideOutTooltipSection5;
        }
        return R.id.slideOutTooltipSection1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0024, code lost:
    
        if ((r6 == 2) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0027, code lost:
    
        if (r6 != 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0029, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 67;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0032, code lost:
    
        if ((r0 % 2) != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0034, code lost:
    
        if (r6 == 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0038, code lost:
    
        if (r6 == 3) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003b, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003d, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0048, code lost:
    
        return id.dana.R.id.step1to2Section5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x004c, code lost:
    
        return id.dana.R.id.step1to2Section4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0050, code lost:
    
        return id.dana.R.id.step1to2Section3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int getTransition(int r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 1
        L7:
            if (r2 == r1) goto L58
            if (r6 == r1) goto L54
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 47
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            r3 = 2
            int r2 = r2 % r3
            r4 = 85
            if (r2 == 0) goto L1c
            r2 = 85
            goto L1e
        L1c:
            r2 = 10
        L1e:
            if (r2 == r4) goto L27
            if (r6 == r3) goto L23
            goto L24
        L23:
            r0 = 1
        L24:
            if (r0 == 0) goto L29
            goto L50
        L27:
            if (r6 == r3) goto L50
        L29:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % r3
            if (r0 != 0) goto L37
            if (r6 == r3) goto L4c
            goto L3a
        L37:
            r0 = 3
            if (r6 == r0) goto L4c
        L3a:
            r0 = 4
            if (r6 == r0) goto L48
            r6 = -1
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 77
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % r3
            goto L5b
        L48:
            r6 = 2131366527(0x7f0a127f, float:1.835295E38)
            goto L5b
        L4c:
            r6 = 2131366526(0x7f0a127e, float:1.8352948E38)
            goto L5b
        L50:
            r6 = 2131366525(0x7f0a127d, float:1.8352946E38)
            goto L5b
        L54:
            r6 = 2131366524(0x7f0a127c, float:1.8352944E38)
            goto L5b
        L58:
            r6 = 2131366523(0x7f0a127b, float:1.8352942E38)
        L5b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getTransition(int):int");
    }

    /* renamed from: openWalletFinancialSection$lambda-48 */
    private static final void m3079openWalletFinancialSection$lambda48() {
        int i = PlaceComponentResult + 125;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    /* renamed from: openWalletIdentitySection$lambda-42 */
    private static final void m3081openWalletIdentitySection$lambda42() {
        try {
            int i = PlaceComponentResult + 13;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: openWalletLoyaltySection$lambda-45 */
    private static final void m3083openWalletLoyaltySection$lambda45() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* renamed from: openWalletPaymentSection$lambda-54 */
    private static final void m3085openWalletPaymentSection$lambda54() {
        int i = PlaceComponentResult + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    /* renamed from: openWalletVoucherAndTicketSection$lambda-51 */
    private static final void m3087openWalletVoucherAndTicketSection$lambda51() {
        try {
            int i = PlaceComponentResult + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 == 0 ? Typography.dollar : 'B') != 'B') {
                int i2 = 34 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: showShowcase$lambda-65 */
    private static final void m3093showShowcase$lambda65(View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        try {
            int i = PlaceComponentResult + 31;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            try {
                this._$_findViewCache.clear();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (!(getAuthRequestContext == null)) {
                try {
                    int i2 = PlaceComponentResult + 11;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                    int i3 = i2 % 2;
                    View findViewById = getAuthRequestContext.findViewById(i);
                    if ((findViewById != null ? 'X' : (char) 1) == 'X') {
                        map.put(Integer.valueOf(i), findViewById);
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        return findViewById;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        int i3 = PlaceComponentResult + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return R.layout.fragment_new_wallet;
    }

    public NewWalletFragment() {
        try {
            this._$_findViewCache = new LinkedHashMap();
            this.identityToastAndDialog = LazyKt.lazy(new Function0<IdentityToastAndDialogImpl>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$identityToastAndDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final IdentityToastAndDialogImpl invoke() {
                    return new IdentityToastAndDialogImpl(NewWalletFragment.this);
                }
            });
            PublishSubject<Integer> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            this.countUpPublishSubject = PlaceComponentResult2;
            PublishSubject<Integer> PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
            this.countDownPublishSubject = PlaceComponentResult3;
            PublishSubject PlaceComponentResult4 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
            this.getPaymentAssetErrorWatcher = PlaceComponentResult4;
            PublishSubject PlaceComponentResult5 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult5, "");
            this.getInvestmentAssetErrorWatcher = PlaceComponentResult5;
            PublishSubject PlaceComponentResult6 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult6, "");
            this.getVoucherAssetErrorWatcher = PlaceComponentResult6;
            PublishSubject PlaceComponentResult7 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult7, "");
            this.getLoyaltyAssetErrorWatcher = PlaceComponentResult7;
            PublishSubject PlaceComponentResult8 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult8, "");
            this.getPaymentAssetWatcher = PlaceComponentResult8;
            PublishSubject PlaceComponentResult9 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult9, "");
            this.getInvestmentAssetWatcher = PlaceComponentResult9;
            PublishSubject PlaceComponentResult10 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult10, "");
            this.getVoucherAssetWatcher = PlaceComponentResult10;
            PublishSubject PlaceComponentResult11 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult11, "");
            this.getLoyaltyAssetWatcher = PlaceComponentResult11;
            this.paymentSection = new WalletSectionModel(null, 0, 0L, null, null, 0, "PAYMENT", 63, null);
            this.financialSection = new WalletSectionModel(null, 0, 0L, null, null, 0, "FINANCIAL", 63, null);
            this.voucherAndTicketSection = new WalletSectionModel(null, 0, 0L, null, null, 0, "VOUCHER_AND_TICKET", 63, null);
            this.loyaltySection = new WalletSectionModel(null, 0, 0L, null, null, 0, "LOYALTY", 63, null);
            this.identitySection = new WalletSectionModel(null, 0, 0L, null, null, 0, "IDENTITY", 63, null);
            this.walletSectionOrderingList = CollectionsKt.emptyList();
            this.walletVoucherAndTicketSectionAssetType = CollectionsKt.emptyList();
            this.isCheckTooltipVisibility = true;
            this.shouldShowSectionTooltip = new LinkedHashMap();
            PublishSubject PlaceComponentResult12 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult12, "");
            this.getPaymentAssetFromLocalEmptyWatcher = PlaceComponentResult12;
            PublishSubject PlaceComponentResult13 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult13, "");
            this.getInvestmentAssetFromLocalEmptyWatcher = PlaceComponentResult13;
            PublishSubject PlaceComponentResult14 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult14, "");
            this.getVoucherAssetFromLocalEmptyWatcher = PlaceComponentResult14;
            PublishSubject PlaceComponentResult15 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult15, "");
            this.getLoyaltyAssetFromLocalEmptyWatcher = PlaceComponentResult15;
            PublishSubject PlaceComponentResult16 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult16, "");
            this.getPaymentAssetFromLocalWatcher = PlaceComponentResult16;
            PublishSubject PlaceComponentResult17 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult17, "");
            this.getInvestmentAssetFromLocalWatcher = PlaceComponentResult17;
            PublishSubject PlaceComponentResult18 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult18, "");
            this.getVoucherAssetFromLocalWatcher = PlaceComponentResult18;
            PublishSubject PlaceComponentResult19 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult19, "");
            this.getLoyaltyAssetFromLocalWatcher = PlaceComponentResult19;
            this.isAssetsFromLocalEmpty = new ArrayList();
            this.danaLoadingDialog = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$danaLoadingDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DanaLoadingDialog invoke() {
                    return new DanaLoadingDialog(NewWalletFragment.this.getActivity());
                }
            });
            this.compositeDisposable = new CompositeDisposable();
            this.section = "";
            PublishSubject<String> PlaceComponentResult20 = PublishSubject.PlaceComponentResult();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult20, "");
            this.sectionWatcher = PlaceComponentResult20;
            this.currentCardModelItems = new ArrayList();
            Boolean bool = Boolean.FALSE;
            this.skeletonScreenList = CollectionsKt.mutableListOf(null, null, null, null, null);
            this.isShowSkeletonList = CollectionsKt.mutableListOf(bool, bool, bool, bool, bool);
            this.selectedIndex = -1;
            this.defaultHeight = -1;
            this.skipLoadData = true;
            this.assetOrder = AssetStatus.EXPIRING_SOON.name();
            this.financeServices = new ArrayList();
            this.shouldShowIdentityTooltip = true;
            this.walletCardAssetClickListener = LazyKt.lazy(new Function0<NewWalletFragment$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$walletCardAssetClickListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.NewWalletFragment$walletCardAssetClickListener$2$1] */
                @Override // kotlin.jvm.functions.Function0
                public final AnonymousClass1 invoke() {
                    final NewWalletFragment newWalletFragment = NewWalletFragment.this;
                    return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$walletCardAssetClickListener$2.1
                        @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                        public final void onCardClicked(WalletV3CardModel data) {
                            Intrinsics.checkNotNullParameter(data, "");
                            NewWalletFragment.access$onCardClickedAction(NewWalletFragment.this, data);
                            NewWalletFragment.access$setLastWalletSectionTypeDetailOpenedBasedOnType(NewWalletFragment.this, data);
                            NewWalletFragment.access$updateSectionTooltipVisibility(NewWalletFragment.this, data);
                        }
                    };
                }
            });
            this.danaBalanceClickListener = LazyKt.lazy(new Function0<NewWalletFragment$danaBalanceClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$danaBalanceClickListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.NewWalletFragment$danaBalanceClickListener$2$1] */
                @Override // kotlin.jvm.functions.Function0
                public final AnonymousClass1 invoke() {
                    final NewWalletFragment newWalletFragment = NewWalletFragment.this;
                    return new DanaBalanceClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$danaBalanceClickListener$2.1
                        @Override // id.dana.wallet_v3.listener.DanaBalanceClickListener
                        public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                            WalletV3ToastUtilKt.showHideBalanceToast(isBalanceVisible, NewWalletFragment.this.getBaseActivity(), 1);
                        }

                        @Override // id.dana.wallet_v3.listener.DanaBalanceClickListener
                        public final void onTopUpClicked() {
                            NewWalletFragment.this.gotoTopupPage();
                        }
                    };
                }
            });
            this.sectionTooltipClickListener = LazyKt.lazy(new Function0<NewWalletFragment$sectionTooltipClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$sectionTooltipClickListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/wallet_v3/view/NewWalletFragment$sectionTooltipClickListener$2$1;", "Lid/dana/wallet_v3/listener/SectionTooltipClickListener;", "", "sectionType", "", "onCloseClicked", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
                /* renamed from: id.dana.wallet_v3.view.NewWalletFragment$sectionTooltipClickListener$2$1  reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass1 implements SectionTooltipClickListener {
                    final /* synthetic */ NewWalletFragment this$0;

                    AnonymousClass1(NewWalletFragment newWalletFragment) {
                        this.this$0 = newWalletFragment;
                    }

                    @Override // id.dana.wallet_v3.listener.SectionTooltipClickListener
                    public final void onCloseClicked(final String sectionType) {
                        int access$getTooltipTransition;
                        MotionLayout motionLayout;
                        MotionLayout motionLayout2;
                        Intrinsics.checkNotNullParameter(sectionType, "");
                        List access$getWalletSectionOrderingList$p = NewWalletFragment.access$getWalletSectionOrderingList$p(this.this$0);
                        String lowerCase = sectionType.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                        int indexOf = access$getWalletSectionOrderingList$p.indexOf(lowerCase);
                        if (indexOf == -1 || (access$getTooltipTransition = NewWalletFragment.access$getTooltipTransition(this.this$0, indexOf)) == -1) {
                            return;
                        }
                        FragmentNewWalletBinding access$getBinding = NewWalletFragment.access$getBinding(this.this$0);
                        if (access$getBinding != null && (motionLayout2 = access$getBinding.Y) != null) {
                            motionLayout2.setTransition(access$getTooltipTransition);
                        }
                        FragmentNewWalletBinding access$getBinding2 = NewWalletFragment.access$getBinding(this.this$0);
                        if (access$getBinding2 == null || (motionLayout = access$getBinding2.Y) == null) {
                            return;
                        }
                        final NewWalletFragment newWalletFragment = this.this$0;
                        motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$sectionTooltipClickListener$2$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                NewWalletFragment$sectionTooltipClickListener$2.AnonymousClass1.m3098onCloseClicked$lambda0(NewWalletFragment.this, sectionType);
                            }
                        });
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    /* renamed from: onCloseClicked$lambda-0  reason: not valid java name */
                    public static final void m3098onCloseClicked$lambda0(NewWalletFragment newWalletFragment, String str) {
                        Intrinsics.checkNotNullParameter(newWalletFragment, "");
                        Intrinsics.checkNotNullParameter(str, "");
                        NewWalletFragment.access$saveSectionTooltipShown(newWalletFragment, str, true);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final AnonymousClass1 invoke() {
                    return new AnonymousClass1(NewWalletFragment.this);
                }
            });
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$checkIsReload(NewWalletFragment newWalletFragment, WalletSectionModel walletSectionModel, SectionStatus sectionStatus) {
        int i = PlaceComponentResult + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        boolean z = i % 2 == 0;
        newWalletFragment.checkIsReload(walletSectionModel, sectionStatus);
        if (!z) {
            return;
        }
        int i2 = 66 / 0;
    }

    public static final /* synthetic */ void access$delayToShowTooltip(NewWalletFragment newWalletFragment, Function0 function0) {
        try {
            int i = PlaceComponentResult + 97;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                newWalletFragment.delayToShowTooltip(function0);
            } else {
                newWalletFragment.delayToShowTooltip(function0);
                int i2 = 92 / 0;
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$dismissLoadingStateSection(NewWalletFragment newWalletFragment, int i) {
        try {
            int i2 = PlaceComponentResult + 107;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            newWalletFragment.dismissLoadingStateSection(i);
            try {
                int i4 = PlaceComponentResult + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                if (!(i4 % 2 == 0)) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$fetchIdentitySection(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 125;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        newWalletFragment.fetchIdentitySection();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ FragmentNewWalletBinding access$getBinding(NewWalletFragment newWalletFragment) {
        FragmentNewWalletBinding fragmentNewWalletBinding;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'W' : (char) 22) != 'W') {
            fragmentNewWalletBinding = (FragmentNewWalletBinding) newWalletFragment.getBinding();
        } else {
            fragmentNewWalletBinding = (FragmentNewWalletBinding) newWalletFragment.getBinding();
            int i2 = 67 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? InputCardNumberView.DIVIDER : ']') != ' ') {
            return fragmentNewWalletBinding;
        }
        Object obj = null;
        obj.hashCode();
        return fragmentNewWalletBinding;
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        boolean z = i % 2 != 0;
        DanaLoadingDialog danaLoadingDialog = newWalletFragment.getDanaLoadingDialog();
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return danaLoadingDialog;
    }

    public static final /* synthetic */ WalletSectionModel access$getFinancialSection$p(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 17;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? 'K' : (char) 27) != 'K') {
            return newWalletFragment.financialSection;
        }
        WalletSectionModel walletSectionModel = newWalletFragment.financialSection;
        Object[] objArr = null;
        int length = objArr.length;
        return walletSectionModel;
    }

    public static final /* synthetic */ Subject access$getGetInvestmentAssetErrorWatcher$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            int i2 = 0 / 0;
            return newWalletFragment.getInvestmentAssetErrorWatcher;
        }
        try {
            return newWalletFragment.getInvestmentAssetErrorWatcher;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Subject access$getGetInvestmentAssetFromLocalEmptyWatcher$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Subject<Boolean> subject = newWalletFragment.getInvestmentAssetFromLocalEmptyWatcher;
        int i3 = PlaceComponentResult + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return subject;
    }

    public static final /* synthetic */ Subject access$getGetInvestmentAssetFromLocalWatcher$p(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        boolean z = i % 2 != 0;
        Subject<Boolean> subject = newWalletFragment.getInvestmentAssetFromLocalWatcher;
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return subject;
    }

    public static final /* synthetic */ Subject access$getGetInvestmentAssetWatcher$p(NewWalletFragment newWalletFragment) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            PlaceComponentResult = i % 128;
            char c = i % 2 != 0 ? 'Z' : '`';
            Subject<Boolean> subject = newWalletFragment.getInvestmentAssetWatcher;
            if (c == 'Z') {
                Object obj = null;
                obj.hashCode();
            }
            try {
                int i2 = PlaceComponentResult + 63;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                return subject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ Subject access$getGetLoyaltyAssetErrorWatcher$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        Subject<Boolean> subject = newWalletFragment.getLoyaltyAssetErrorWatcher;
        if (z) {
            int i2 = 47 / 0;
        }
        return subject;
    }

    public static final /* synthetic */ Subject access$getGetLoyaltyAssetFromLocalEmptyWatcher$p(NewWalletFragment newWalletFragment) {
        Subject<Boolean> subject;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
            try {
                PlaceComponentResult = i % 128;
                if ((i % 2 != 0 ? '[' : (char) 19) != 19) {
                    subject = newWalletFragment.getLoyaltyAssetFromLocalEmptyWatcher;
                    Object obj = null;
                    obj.hashCode();
                } else {
                    subject = newWalletFragment.getLoyaltyAssetFromLocalEmptyWatcher;
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                return subject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ Subject access$getGetLoyaltyAssetFromLocalWatcher$p(NewWalletFragment newWalletFragment) {
        try {
            int i = PlaceComponentResult + 81;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            Subject<Boolean> subject = newWalletFragment.getLoyaltyAssetFromLocalWatcher;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return subject;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Subject access$getGetLoyaltyAssetWatcher$p(NewWalletFragment newWalletFragment) {
        Subject<Boolean> subject;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if (!(i % 2 != 0)) {
            subject = newWalletFragment.getLoyaltyAssetWatcher;
        } else {
            try {
                subject = newWalletFragment.getLoyaltyAssetWatcher;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = PlaceComponentResult + 9;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 29 : 'Z') != 29) {
            return subject;
        }
        int length2 = objArr.length;
        return subject;
    }

    public static final /* synthetic */ Subject access$getGetPaymentAssetErrorWatcher$p(NewWalletFragment newWalletFragment) {
        try {
            int i = PlaceComponentResult + 71;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            boolean z = i % 2 != 0;
            Subject<Boolean> subject = newWalletFragment.getPaymentAssetErrorWatcher;
            if (!z) {
                int i2 = 41 / 0;
            }
            return subject;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Subject access$getGetPaymentAssetFromLocalEmptyWatcher$p(NewWalletFragment newWalletFragment) {
        Subject<Boolean> subject;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            PlaceComponentResult = i % 128;
            Object obj = null;
            if ((i % 2 != 0 ? '\\' : '8') != '8') {
                subject = newWalletFragment.getPaymentAssetFromLocalEmptyWatcher;
                obj.hashCode();
            } else {
                subject = newWalletFragment.getPaymentAssetFromLocalEmptyWatcher;
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
            try {
                PlaceComponentResult = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    obj.hashCode();
                    return subject;
                }
                return subject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ Subject access$getGetPaymentAssetFromLocalWatcher$p(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 67;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Subject<Boolean> subject = newWalletFragment.getPaymentAssetFromLocalWatcher;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? '-' : Typography.greater) != '>') {
            Object[] objArr = null;
            int length = objArr.length;
            return subject;
        }
        return subject;
    }

    public static final /* synthetic */ Subject access$getGetPaymentAssetWatcher$p(NewWalletFragment newWalletFragment) {
        Subject<Boolean> subject;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? ')' : 'B') != 'B') {
            subject = newWalletFragment.getPaymentAssetWatcher;
            Object obj = null;
            obj.hashCode();
        } else {
            try {
                subject = newWalletFragment.getPaymentAssetWatcher;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return subject;
    }

    public static final /* synthetic */ Subject access$getGetVoucherAssetErrorWatcher$p(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Subject<Boolean> subject = newWalletFragment.getVoucherAssetErrorWatcher;
            int i3 = PlaceComponentResult + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? '(' : '\b') != '(') {
                return subject;
            }
            Object obj = null;
            obj.hashCode();
            return subject;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Subject access$getGetVoucherAssetFromLocalEmptyWatcher$p(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Subject<Boolean> subject = newWalletFragment.getVoucherAssetFromLocalEmptyWatcher;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return subject;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Subject access$getGetVoucherAssetFromLocalWatcher$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            int i2 = 23 / 0;
            return newWalletFragment.getVoucherAssetFromLocalWatcher;
        }
        try {
            return newWalletFragment.getVoucherAssetFromLocalWatcher;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Subject access$getGetVoucherAssetWatcher$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Subject<Boolean> subject = newWalletFragment.getVoucherAssetWatcher;
        int i3 = PlaceComponentResult + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return subject;
    }

    public static final /* synthetic */ int access$getIDENTITY_REQUEST_CODE$cp() {
        int i = PlaceComponentResult + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int i3 = IDENTITY_REQUEST_CODE;
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i4 % 128;
        int i5 = i4 % 2;
        return i3;
    }

    public static final /* synthetic */ WalletSectionModel access$getIdentitySection$p(NewWalletFragment newWalletFragment) {
        WalletSectionModel walletSectionModel;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if (!(i % 2 != 0)) {
            try {
                walletSectionModel = newWalletFragment.identitySection;
            } catch (Exception e) {
                throw e;
            }
        } else {
            walletSectionModel = newWalletFragment.identitySection;
            int length = objArr.length;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 != 0) {
            objArr.hashCode();
            return walletSectionModel;
        }
        return walletSectionModel;
    }

    public static final /* synthetic */ IdentityToastAndDialogImpl access$getIdentityToastAndDialog(NewWalletFragment newWalletFragment) {
        IdentityToastAndDialogImpl identityToastAndDialog;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            identityToastAndDialog = newWalletFragment.getIdentityToastAndDialog();
        } else {
            identityToastAndDialog = newWalletFragment.getIdentityToastAndDialog();
            Object obj = null;
            obj.hashCode();
        }
        int i2 = PlaceComponentResult + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        return identityToastAndDialog;
    }

    public static final /* synthetic */ WalletSectionModel access$getLoyaltySection$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? '.' : 'T';
        WalletSectionModel walletSectionModel = newWalletFragment.loyaltySection;
        if (c == '.') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return walletSectionModel;
    }

    public static final /* synthetic */ WalletSectionModel access$getPaymentSection$p(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        char c = i % 2 == 0 ? (char) 20 : 'G';
        WalletSectionModel walletSectionModel = newWalletFragment.paymentSection;
        if (c == 20) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = PlaceComponentResult + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return walletSectionModel;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getSection$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? (char) 7 : '\b';
        String str = newWalletFragment.section;
        if (c != '\b') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 4 : '\n') != 4) {
            return str;
        }
        int i3 = 10 / 0;
        return str;
    }

    public static final /* synthetic */ Map access$getShouldShowSectionTooltip$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Map<String, Boolean> map = newWalletFragment.shouldShowSectionTooltip;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? 'M' : Typography.less) != 'M') {
                return map;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Target access$getTooltipTarget(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 43;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Target tooltipTarget = newWalletFragment.getTooltipTarget();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return tooltipTarget;
    }

    public static final /* synthetic */ int access$getTooltipTransition(NewWalletFragment newWalletFragment, int i) {
        int i2 = PlaceComponentResult + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        int tooltipTransition = newWalletFragment.getTooltipTransition(i);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        PlaceComponentResult = i4 % 128;
        int i5 = i4 % 2;
        return tooltipTransition;
    }

    public static final /* synthetic */ List access$getVoucherAndTicketAssetTypes(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 9 / 0;
            return newWalletFragment.getVoucherAndTicketAssetTypes();
        }
        return newWalletFragment.getVoucherAndTicketAssetTypes();
    }

    public static final /* synthetic */ WalletSectionModel access$getVoucherAndTicketSection$p(NewWalletFragment newWalletFragment) {
        WalletSectionModel walletSectionModel;
        try {
            int i = PlaceComponentResult + 93;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                    walletSectionModel = newWalletFragment.voucherAndTicketSection;
                } else {
                    walletSectionModel = newWalletFragment.voucherAndTicketSection;
                    Object obj = null;
                    obj.hashCode();
                }
                int i2 = PlaceComponentResult + 7;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                return walletSectionModel;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ AppCompatImageView access$getWalletArrowButtonSection(NewWalletFragment newWalletFragment, int i) {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            PlaceComponentResult = i2 % 128;
            boolean z = i2 % 2 == 0;
            AppCompatImageView walletArrowButtonSection = newWalletFragment.getWalletArrowButtonSection(i);
            if (!z) {
                Object obj = null;
                obj.hashCode();
            }
            return walletArrowButtonSection;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ LottieAnimationView access$getWalletLottieButtonSection(NewWalletFragment newWalletFragment, int i) {
        int i2 = PlaceComponentResult + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        boolean z = i2 % 2 == 0;
        LottieAnimationView walletLottieButtonSection = newWalletFragment.getWalletLottieButtonSection(i);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        int i3 = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return walletLottieButtonSection;
    }

    public static final /* synthetic */ List access$getWalletSectionOrderingList$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        List<String> list = newWalletFragment.walletSectionOrderingList;
        int i3 = PlaceComponentResult + 1;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? '1' : (char) 3) != 3) {
            Object[] objArr = null;
            int length = objArr.length;
            return list;
        }
        return list;
    }

    public static final /* synthetic */ WalletTabListener access$getWalletTabListener$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        WalletTabListener walletTabListener = newWalletFragment.walletTabListener;
        int i3 = PlaceComponentResult + 91;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return walletTabListener;
    }

    public static final /* synthetic */ void access$hideIdentitySection(NewWalletFragment newWalletFragment) {
        try {
            int i = PlaceComponentResult + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            newWalletFragment.hideIdentitySection();
            int i3 = PlaceComponentResult + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 63 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$initOnClickListener(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        newWalletFragment.initOnClickListener();
        if (z) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ boolean access$isFetchDataAfterFromLocal$p(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        boolean z = newWalletFragment.isFetchDataAfterFromLocal;
        int i3 = PlaceComponentResult + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? ':' : 'E') != ':') {
            return z;
        }
        int i4 = 89 / 0;
        return z;
    }

    public static final /* synthetic */ void access$loadDataFromPersistence(NewWalletFragment newWalletFragment, WalletV3Config walletV3Config) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? '\r' : '3';
        newWalletFragment.loadDataFromPersistence(walletV3Config);
        if (c != '3') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void access$onCardClickedAction(NewWalletFragment newWalletFragment, WalletV3CardModel walletV3CardModel) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        newWalletFragment.onCardClickedAction(walletV3CardModel);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$onGetAccessTokenAndKycLevel(NewWalletFragment newWalletFragment) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            PlaceComponentResult = i % 128;
            boolean z = i % 2 == 0;
            newWalletFragment.onGetAccessTokenAndKycLevel();
            if (!z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = PlaceComponentResult + 47;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$reloadAllData(NewWalletFragment newWalletFragment) {
        try {
            int i = PlaceComponentResult + 7;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            char c = i % 2 == 0 ? (char) 3 : '0';
            newWalletFragment.reloadAllData();
            if (c != '0') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$saveSectionTooltipShown(NewWalletFragment newWalletFragment, String str, boolean z) {
        try {
            int i = PlaceComponentResult + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            newWalletFragment.saveSectionTooltipShown(str, z);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setAccessToken$p(NewWalletFragment newWalletFragment, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        newWalletFragment.accessToken = str;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setCheckTooltipVisibility$p(NewWalletFragment newWalletFragment, boolean z) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        newWalletFragment.isCheckTooltipVisibility = z;
        int i3 = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setExpandedLayoutHeight(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        newWalletFragment.setExpandedLayoutHeight();
        int i3 = PlaceComponentResult + 95;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setFinanceServices$p(NewWalletFragment newWalletFragment, List list) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            newWalletFragment.financeServices = list;
            return;
        }
        try {
            newWalletFragment.financeServices = list;
            int i2 = 60 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setFullyExpanded(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? '%' : '!';
        newWalletFragment.setFullyExpanded();
        if (c != '!') {
            int i2 = 20 / 0;
        }
    }

    public static final /* synthetic */ void access$setKtpIsSaved$p(NewWalletFragment newWalletFragment, boolean z) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            newWalletFragment.ktpIsSaved = z;
        } else {
            newWalletFragment.ktpIsSaved = z;
            int i2 = 82 / 0;
        }
        int i3 = PlaceComponentResult + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setKycLevel$p(NewWalletFragment newWalletFragment, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        newWalletFragment.kycLevel = str;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setLastWalletSectionTypeDetailOpenedBasedOnType(NewWalletFragment newWalletFragment, WalletV3CardModel walletV3CardModel) {
        try {
            int i = PlaceComponentResult + 45;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            char c = i % 2 == 0 ? 'B' : '*';
            newWalletFragment.setLastWalletSectionTypeDetailOpenedBasedOnType(walletV3CardModel);
            if (c != '*') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = PlaceComponentResult + 81;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setSectionEmpty(NewWalletFragment newWalletFragment, WalletSectionModel walletSectionModel) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        newWalletFragment.setSectionEmpty(walletSectionModel);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setShouldShowIdentityTooltip$p(NewWalletFragment newWalletFragment, boolean z) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            try {
                PlaceComponentResult = i % 128;
                if ((i % 2 != 0 ? (char) 29 : 'b') == 'b') {
                    newWalletFragment.shouldShowIdentityTooltip = z;
                    return;
                }
                newWalletFragment.shouldShowIdentityTooltip = z;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setShowcase$p(NewWalletFragment newWalletFragment, Showcase showcase) {
        try {
            int i = PlaceComponentResult + 105;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            boolean z = i % 2 != 0;
            Object obj = null;
            newWalletFragment.showcase = showcase;
            if (!z) {
                obj.hashCode();
            }
            try {
                int i2 = PlaceComponentResult + 23;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if (i2 % 2 != 0) {
                    return;
                }
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setWalletConfig$p(NewWalletFragment newWalletFragment, WalletV3Config walletV3Config) {
        int i = PlaceComponentResult + 89;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? 'D' : '5') != '5') {
            newWalletFragment.walletConfig = walletV3Config;
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            newWalletFragment.walletConfig = walletV3Config;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setWalletSectionOrderingList$p(NewWalletFragment newWalletFragment, List list) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 21 : '[') != 21) {
            try {
                newWalletFragment.walletSectionOrderingList = list;
            } catch (Exception e) {
                throw e;
            }
        } else {
            newWalletFragment.walletSectionOrderingList = list;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = PlaceComponentResult + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 68 / 0;
        }
    }

    public static final /* synthetic */ void access$setWalletVoucherAndTicketSectionAssetType$p(NewWalletFragment newWalletFragment, List list) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        PlaceComponentResult = i % 128;
        try {
            if ((i % 2 != 0 ? (char) 27 : 'J') == 'J') {
                newWalletFragment.walletVoucherAndTicketSectionAssetType = list;
                return;
            }
            newWalletFragment.walletVoucherAndTicketSectionAssetType = list;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setupSectionIndex(NewWalletFragment newWalletFragment) {
        try {
            int i = PlaceComponentResult + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            newWalletFragment.setupSectionIndex();
            int i3 = PlaceComponentResult + 103;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 6 : (char) 4) != 4) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$showErrorStateInIdentity(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        newWalletFragment.showErrorStateInIdentity();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$showIdentitySection(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        newWalletFragment.showIdentitySection();
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
            try {
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$showLoadingStateSection(NewWalletFragment newWalletFragment, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        PlaceComponentResult = i2 % 128;
        if (!(i2 % 2 == 0)) {
            newWalletFragment.showLoadingStateSection(i);
            int i3 = 68 / 0;
        } else {
            newWalletFragment.showLoadingStateSection(i);
        }
        int i4 = PlaceComponentResult + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        int i5 = i4 % 2;
    }

    public static final /* synthetic */ void access$showShowcase(NewWalletFragment newWalletFragment, Target target) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            newWalletFragment.showShowcase(target);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? 'T' : 'Y') != 'T') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$showTotalAssetSectionHeader(NewWalletFragment newWalletFragment, WalletSectionModel walletSectionModel, boolean z, int i) {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
            PlaceComponentResult = i2 % 128;
            boolean z2 = i2 % 2 != 0;
            newWalletFragment.showTotalAssetSectionHeader(walletSectionModel, z, i);
            if (!z2) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$startAnimateSlideUp(NewWalletFragment newWalletFragment, Runnable runnable) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? '(' : (char) 18) == 18) {
                newWalletFragment.startAnimateSlideUp(runnable);
                return;
            }
            newWalletFragment.startAnimateSlideUp(runnable);
            int i2 = 27 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$startExpandSectionAnimation(NewWalletFragment newWalletFragment, int i) {
        try {
            int i2 = PlaceComponentResult + 99;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            newWalletFragment.startExpandSectionAnimation(i);
            int i4 = PlaceComponentResult + 79;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if ((i4 % 2 == 0 ? '=' : (char) 30) != '=') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$updateSectionTooltipVisibility(NewWalletFragment newWalletFragment, WalletV3CardModel walletV3CardModel) {
        int i = PlaceComponentResult + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            newWalletFragment.updateSectionTooltipVisibility(walletV3CardModel);
            return;
        }
        newWalletFragment.updateSectionTooltipVisibility(walletV3CardModel);
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? Typography.dollar : 'B') != 'B') {
            FragmentNewWalletBinding initViewBinding = initViewBinding(view);
            Object obj = null;
            obj.hashCode();
            return initViewBinding;
        }
        try {
            try {
                return initViewBinding(view);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getNewWalletPresenter")
    public final NewWalletContract.Presenter getNewWalletPresenter() {
        NewWalletContract.Presenter presenter = this.newWalletPresenter;
        if ((presenter != null ? (char) 4 : '7') == 4) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = PlaceComponentResult + 67;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    @JvmName(name = "setNewWalletPresenter")
    public final void setNewWalletPresenter(NewWalletContract.Presenter presenter) {
        int i = PlaceComponentResult + 105;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.newWalletPresenter = presenter;
        int i3 = PlaceComponentResult + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = "getGetBalancePresenter")
    public final GetBalanceContract.Presenter getGetBalancePresenter() {
        int i = PlaceComponentResult + 3;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        GetBalanceContract.Presenter presenter = this.getBalancePresenter;
        Object obj = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i3 = PlaceComponentResult + 73;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return null;
        }
        int i5 = PlaceComponentResult + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        if (i5 % 2 != 0) {
            return presenter;
        }
        obj.hashCode();
        return presenter;
    }

    @JvmName(name = "setGetBalancePresenter")
    public final void setGetBalancePresenter(GetBalanceContract.Presenter presenter) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.getBalancePresenter = presenter;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.getBalancePresenter = presenter;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = PlaceComponentResult + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
    }

    @JvmName(name = "getPersonalPresenter")
    public final PersonalContract.Presenter getPersonalPresenter() {
        PersonalContract.Presenter presenter = this.personalPresenter;
        if (!(presenter == null)) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = PlaceComponentResult + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        boolean z = i3 % 2 == 0;
        Object[] objArr = null;
        if (z) {
            int length = objArr.length;
            return null;
        }
        return null;
    }

    @JvmName(name = "setPersonalPresenter")
    public final void setPersonalPresenter(PersonalContract.Presenter presenter) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            try {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.personalPresenter = presenter;
                int i3 = PlaceComponentResult + 91;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 == 0 ? 'Q' : (char) 25) != 'Q') {
                    return;
                }
                int i4 = 1 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0012, code lost:
    
        if (r0 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x001e, code lost:
    
        if ((r0 == null) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0020, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0025, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0026, code lost:
    
        r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0032, code lost:
    
        if ((r2 % 2) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0034, code lost:
    
        r2 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0037, code lost:
    
        r2 = '8';
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0039, code lost:
    
        if (r2 == 'W') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003c, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003f, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getDynamicUrlWrapper")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.dynamicurl.DynamicUrlWrapper getDynamicUrlWrapper() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L42
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L42
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L17
            id.dana.data.dynamicurl.DynamicUrlWrapper r0 = r4.dynamicUrlWrapper
            r1.hashCode()     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L20
            goto L26
        L15:
            r0 = move-exception
            throw r0
        L17:
            id.dana.data.dynamicurl.DynamicUrlWrapper r0 = r4.dynamicUrlWrapper
            if (r0 == 0) goto L1d
            r2 = 0
            goto L1e
        L1d:
            r2 = 1
        L1e:
            if (r2 == 0) goto L26
        L20:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        L26:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 33
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % 2
            r3 = 87
            if (r2 == 0) goto L37
            r2 = 87
            goto L39
        L37:
            r2 = 56
        L39:
            if (r2 == r3) goto L3c
            return r0
        L3c:
            r1.hashCode()     // Catch: java.lang.Throwable -> L40
            return r0
        L40:
            r0 = move-exception
            throw r0
        L42:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getDynamicUrlWrapper():id.dana.data.dynamicurl.DynamicUrlWrapper");
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        try {
            int i = PlaceComponentResult + 21;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            int i4 = 22 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getServicePresenter")
    public final ServicesContract.Presenter getServicePresenter() {
        int i = PlaceComponentResult + 71;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        ServicesContract.Presenter presenter = this.servicePresenter;
        if ((presenter == null ? 'H' : 'G') == 'H') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            try {
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return presenter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setServicePresenter")
    public final void setServicePresenter(ServicesContract.Presenter presenter) {
        int i = PlaceComponentResult + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            try {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.servicePresenter = presenter;
                int i2 = 9 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.servicePresenter = presenter;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
        if ((presenter != null ? '3' : '%') == '3') {
            int i = PlaceComponentResult + 123;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        try {
            int i3 = PlaceComponentResult + 71;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
            return;
        }
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readLinkPropertiesPresenter = presenter;
        int i2 = 26 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0017, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x001e, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0020, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0021, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 123;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0030, code lost:
    
        if ((r0 % 2) == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0032, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0033, code lost:
    
        if (r1 == true) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0035, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0036, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0039, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getDeviceInformationProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.config.DeviceInformationProvider getDeviceInformationProvider() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 75
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == 0) goto L1c
            id.dana.data.config.DeviceInformationProvider r0 = r5.deviceInformationProvider
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L21
            goto L20
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            id.dana.data.config.DeviceInformationProvider r0 = r5.deviceInformationProvider
            if (r0 == 0) goto L21
        L20:
            return r0
        L21:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 123
            int r4 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r4
            int r0 = r0 % 2
            if (r0 == 0) goto L33
            r1 = 1
        L33:
            if (r1 == r2) goto L36
            return r3
        L36:
            r3.hashCode()     // Catch: java.lang.Throwable -> L3a
            return r3
        L3a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getDeviceInformationProvider():id.dana.data.config.DeviceInformationProvider");
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        try {
            int i = PlaceComponentResult + 43;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            try {
                Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
                this.deviceInformationProvider = deviceInformationProvider;
                int i3 = PlaceComponentResult + 31;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:57:0x0033
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "getWalletH5ServicesImplementation")
    public final id.dana.wallet_v3.WalletH5ServicesImplementation getWalletH5ServicesImplementation() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L22
            id.dana.wallet_v3.WalletH5ServicesImplementation r0 = r4.walletH5ServicesImplementation
            r1 = 80
            if (r0 == 0) goto L1d
            r2 = 23
            goto L1f
        L1d:
            r2 = 80
        L1f:
            if (r2 == r1) goto L2d
            goto L35
        L22:
            id.dana.wallet_v3.WalletH5ServicesImplementation r0 = r4.walletH5ServicesImplementation
            r3.hashCode()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L2a
            goto L2b
        L2a:
            r1 = 1
        L2b:
            if (r1 == 0) goto L35
        L2d:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L40
            return r3
        L33:
            r0 = move-exception
            throw r0
        L35:
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L40
            int r1 = r1 + 67
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Exception -> L40
            int r1 = r1 % 2
            return r0
        L40:
            r0 = move-exception
            throw r0
        L42:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getWalletH5ServicesImplementation():id.dana.wallet_v3.WalletH5ServicesImplementation");
    }

    @JvmName(name = "setWalletH5ServicesImplementation")
    public final void setWalletH5ServicesImplementation(WalletH5ServicesImplementation walletH5ServicesImplementation) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
        this.walletH5ServicesImplementation = walletH5ServicesImplementation;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getWalletV3TrackerImplementation")
    public final WalletV3TrackerImpl getWalletV3TrackerImplementation() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        WalletV3TrackerImpl walletV3TrackerImpl = this.walletV3TrackerImplementation;
        if ((walletV3TrackerImpl != null ? 'W' : (char) 2) == 'W') {
            int i3 = PlaceComponentResult + 67;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return walletV3TrackerImpl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        PlaceComponentResult = i5 % 128;
        int i6 = i5 % 2;
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x001c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "setWalletV3TrackerImplementation")
    public final void setWalletV3TrackerImplementation(id.dana.wallet_v3.tracker.WalletV3TrackerImpl r3) {
        /*
            r2 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L1e
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L1e
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L1e
            r2.walletV3TrackerImplementation = r3     // Catch: java.lang.Exception -> L1e
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 37
            int r0 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0
            int r3 = r3 % 2
            return
        L1c:
            r3 = move-exception
            throw r3
        L1e:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setWalletV3TrackerImplementation(id.dana.wallet_v3.tracker.WalletV3TrackerImpl):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0019, code lost:
    
        if ((r0 != null ? 'S' : '\f') != '\f') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0020, code lost:
    
        if (r0 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0022, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0023, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x002a, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x002e, code lost:
    
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0034, code lost:
    
        if ((r0 % 2) == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0036, code lost:
    
        r0 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0039, code lost:
    
        r0 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x003b, code lost:
    
        if (r0 == ';') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x003d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0040, code lost:
    
        r0 = 66 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0042, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0045, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0046, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getFeaturePresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.path.FeatureContract.Presenter getFeaturePresenter() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1e
            id.dana.contract.deeplink.path.FeatureContract$Presenter r0 = r4.featurePresenter
            int r2 = r1.length     // Catch: java.lang.Throwable -> L1c
            r2 = 12
            if (r0 == 0) goto L17
            r3 = 83
            goto L19
        L17:
            r3 = 12
        L19:
            if (r3 == r2) goto L23
            goto L22
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            id.dana.contract.deeplink.path.FeatureContract$Presenter r0 = r4.featurePresenter     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L23
        L22:
            return r0
        L23:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L45
            int r0 = r0 + 115
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2     // Catch: java.lang.Exception -> L47
            int r0 = r0 % 2
            r2 = 59
            if (r0 == 0) goto L39
            r0 = 59
            goto L3b
        L39:
            r0 = 8
        L3b:
            if (r0 == r2) goto L3e
            return r1
        L3e:
            r0 = 66
            int r0 = r0 / 0
            return r1
        L43:
            r0 = move-exception
            throw r0
        L45:
            r0 = move-exception
            throw r0
        L47:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getFeaturePresenter():id.dana.contract.deeplink.path.FeatureContract$Presenter");
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(presenter, "");
            this.featurePresenter = presenter;
            int i3 = PlaceComponentResult + 23;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getIdentityToastAndDialog")
    private final IdentityToastAndDialogImpl getIdentityToastAndDialog() {
        int i = PlaceComponentResult + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        IdentityToastAndDialogImpl identityToastAndDialogImpl = (IdentityToastAndDialogImpl) this.identityToastAndDialog.getValue();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return identityToastAndDialogImpl;
    }

    @JvmName(name = "getDanaLoadingDialog")
    private final DanaLoadingDialog getDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            danaLoadingDialog = (DanaLoadingDialog) this.danaLoadingDialog.getValue();
            int i2 = 30 / 0;
        } else {
            danaLoadingDialog = (DanaLoadingDialog) this.danaLoadingDialog.getValue();
        }
        int i3 = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return danaLoadingDialog;
        }
        return danaLoadingDialog;
    }

    @JvmName(name = "getLastWalletSectionTypeDetailOpened")
    public final String getLastWalletSectionTypeDetailOpened() {
        String str;
        int i = PlaceComponentResult + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 3 : (char) 28) != 3) {
            str = this.lastWalletSectionTypeDetailOpened;
        } else {
            str = this.lastWalletSectionTypeDetailOpened;
            int i2 = 50 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    @JvmName(name = "setLastWalletSectionTypeDetailOpened")
    public final void setLastWalletSectionTypeDetailOpened(String str) {
        try {
            int i = PlaceComponentResult + 123;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            this.lastWalletSectionTypeDetailOpened = str;
            int i3 = PlaceComponentResult + 27;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            int i4 = 62 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getSkipLoadData")
    public final boolean getSkipLoadData() {
        int i = PlaceComponentResult + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        boolean z = this.skipLoadData;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setSkipLoadData")
    public final void setSkipLoadData(boolean z) {
        int i = PlaceComponentResult + 99;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        this.skipLoadData = z;
        try {
            int i3 = PlaceComponentResult + 125;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getLastAddedAssetType")
    public final Integer getLastAddedAssetType() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'Q' : '.') != '.') {
            try {
                int i2 = 56 / 0;
                return this.lastAddedAssetType;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.lastAddedAssetType;
    }

    @JvmName(name = "setLastAddedAssetType")
    public final void setLastAddedAssetType(Integer num) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            this.lastAddedAssetType = num;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getAssetOrder")
    public final String getAssetOrder() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            String str = this.assetOrder;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setAssetOrder")
    public final void setAssetOrder(String str) {
        int i = PlaceComponentResult + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? '9' : 'B') != '9') {
            this.assetOrder = str;
        } else {
            try {
                this.assetOrder = str;
                int i2 = 94 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = PlaceComponentResult + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "");
        super.onViewCreated(view, savedInstanceState);
        DanaApplication BuiltInFictitiousFunctionClassFactory = AndroidComponentUtilsKt.BuiltInFictitiousFunctionClassFactory(this);
        if ((BuiltInFictitiousFunctionClassFactory != null ? 'E' : ')') != ')') {
            int i = PlaceComponentResult + 19;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            try {
                BuiltInFictitiousFunctionClassFactory.chckTmprdApp();
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = PlaceComponentResult + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? '[' : '.') != '.') {
            int i4 = 37 / 0;
        }
    }

    @JvmName(name = "getWalletCardAssetClickListener")
    private final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        WalletCardAssetClickListener walletCardAssetClickListener = (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return walletCardAssetClickListener;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return walletCardAssetClickListener;
    }

    @JvmName(name = "getDanaBalanceClickListener")
    private final DanaBalanceClickListener getDanaBalanceClickListener() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '%' : Typography.greater) != '%') {
            return (DanaBalanceClickListener) this.danaBalanceClickListener.getValue();
        }
        DanaBalanceClickListener danaBalanceClickListener = (DanaBalanceClickListener) this.danaBalanceClickListener.getValue();
        Object[] objArr = null;
        int length = objArr.length;
        return danaBalanceClickListener;
    }

    @JvmName(name = "getSectionTooltipClickListener")
    private final SectionTooltipClickListener getSectionTooltipClickListener() {
        try {
            int i = PlaceComponentResult + 5;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                SectionTooltipClickListener sectionTooltipClickListener = (SectionTooltipClickListener) this.sectionTooltipClickListener.getValue();
                int i3 = PlaceComponentResult + 25;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return sectionTooltipClickListener;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void gotoTopupPage() {
        try {
            int i = PlaceComponentResult + 69;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            String topupUrl = getDynamicUrlWrapper().getTopupUrl(TopupSource.DANA_WALLET);
            Intrinsics.checkNotNullExpressionValue(topupUrl, "");
            DanaH5.startContainerFullUrl(topupUrl);
            int i3 = PlaceComponentResult + 53;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? 'b' : 'S') != 'S') {
                int i4 = 53 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final FragmentNewWalletBinding initViewBinding(View view) {
        FragmentNewWalletBinding authRequestContext;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(view, "");
            authRequestContext = FragmentNewWalletBinding.getAuthRequestContext(view);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        } else {
            try {
                Intrinsics.checkNotNullParameter(view, "");
                authRequestContext = FragmentNewWalletBinding.getAuthRequestContext(view);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return authRequestContext;
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment
    public final void onClickLeftMenuButton(View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        DanaH5.startContainerFullUrl("https://m.dana.id/m/standalone/protection");
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment
    public final void onClickRightMenuButton(View view) {
        int i = PlaceComponentResult + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.DanaWalletAddSource.ADD_WALLET_HOME);
            openBottomSheetAddAsset(1);
        } else {
            getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.DanaWalletAddSource.ADD_WALLET_HOME);
            openBottomSheetAddAsset(0);
        }
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void onCollapseFromSearch() {
        FragmentNewWalletBinding fragmentNewWalletBinding;
        int i = PlaceComponentResult + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 11 : (char) 17) != 17) {
            fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            Object obj = null;
            obj.hashCode();
            if (!(fragmentNewWalletBinding != null)) {
                return;
            }
        } else {
            fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding == null) {
                return;
            }
        }
        final MotionLayout motionLayout = fragmentNewWalletBinding.flip;
        if (motionLayout != null) {
            motionLayout.setTransition(R.id.collapse_from_search);
            motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.$r8$lambda$L6wAX1UzjG3auGC1S0LsdctPYXE(MotionLayout.this, this);
                }
            });
            int i2 = PlaceComponentResult + 43;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    /* renamed from: onCollapseFromSearch$lambda-0 */
    private static final void m3078onCollapseFromSearch$lambda0(MotionLayout motionLayout, NewWalletFragment newWalletFragment) {
        WalletTabListener walletTabListener;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        PlaceComponentResult = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            try {
                Intrinsics.checkNotNullParameter(motionLayout, "");
                try {
                    Intrinsics.checkNotNullParameter(newWalletFragment, "");
                    motionLayout.setBackground(null);
                    walletTabListener = newWalletFragment.walletTabListener;
                    obj.hashCode();
                    if ((walletTabListener != null ? (char) 2 : '#') == '#') {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            Intrinsics.checkNotNullParameter(motionLayout, "");
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            motionLayout.setBackground(null);
            walletTabListener = newWalletFragment.walletTabListener;
            if (!(walletTabListener != null)) {
                return;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 == 0) {
            walletTabListener.showTabBarMenu();
            return;
        }
        walletTabListener.showTabBarMenu();
        obj.hashCode();
    }

    /* renamed from: onCollapse$lambda-4$lambda-2 */
    private static final void m3075onCollapse$lambda4$lambda2(NewWalletFragment newWalletFragment) {
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        Integer[] numArr = newWalletFragment.scrollPosition;
        if (numArr != null) {
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) newWalletFragment.getBinding();
            if (!(fragmentNewWalletBinding == null)) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                NestedScrollView nestedScrollView = fragmentNewWalletBinding.f8082a;
                if ((nestedScrollView != null ? 'c' : (char) 23) != 'c') {
                    return;
                }
                nestedScrollView.smoothScrollTo(numArr[0].intValue(), numArr[1].intValue());
                int i3 = PlaceComponentResult + 79;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0021, code lost:
    
        if ((r0 == null) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0024, code lost:
    
        id.dana.core.ui.extension.ViewExtKt.PlaceComponentResult(r0, 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x00e4, code lost:
    
        if (r0 != null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x00ec, code lost:
    
        if (r0 != null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00ee, code lost:
    
        r0.post(new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda25());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0013, code lost:
    
        if (r0 != null) goto L107;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCollapse(int r8) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.onCollapse(int):void");
    }

    /* renamed from: onCollapse$lambda-4$lambda-3 */
    private static final void m3076onCollapse$lambda4$lambda3(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 43;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.isOpenDetail = false;
        try {
            int i3 = PlaceComponentResult + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: onCollapse$lambda-5 */
    private static final void m3077onCollapse$lambda5(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            Integer num = newWalletFragment.lastAddedAssetType;
            Object[] objArr = null;
            int length = objArr.length;
            if (!(num != null)) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            if (newWalletFragment.lastAddedAssetType == null) {
                return;
            }
        }
        int i2 = PlaceComponentResult + 9;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        newWalletFragment.refreshDataBasedOnLatestAddedAssetType();
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        PlaceComponentResult = i4 % 128;
        int i5 = i4 % 2;
    }

    private final void delayToShowAnimation(final int r9) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        Scheduler KClassImpl$Data$declaredNonStaticMembers$23;
        Completable MyBillsEntityDataFactory2 = Completable.MyBillsEntityDataFactory();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$24 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(MyBillsEntityDataFactory2, 1000L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$22));
        KClassImpl$Data$declaredNonStaticMembers$23 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$23, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$25 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$24, KClassImpl$Data$declaredNonStaticMembers$23));
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$26 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$25, PlaceComponentResult2));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$26, "");
        Object obj = null;
        addDisposable(SubscribersKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$26, null, new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$delayToShowAnimation$1
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
                NewWalletFragment.access$startExpandSectionAnimation(NewWalletFragment.this, r9);
            }
        }, 1));
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return;
        }
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x001a, code lost:
    
        if (r0 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0028, code lost:
    
        if ((r0 == null) != true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002a, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 51;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        id.dana.core.ui.extension.ViewExtKt.PlaceComponentResult(r0, 0);
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startExpandSectionAnimation(final int r5) {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L1f
            com.airbnb.lottie.LottieAnimationView r0 = r4.getWalletLottieButtonSection(r5)
            r1 = 26
            int r1 = r1 / r2
            if (r0 == 0) goto L43
            goto L2a
        L1d:
            r5 = move-exception
            throw r5
        L1f:
            com.airbnb.lottie.LottieAnimationView r0 = r4.getWalletLottieButtonSection(r5)
            if (r0 == 0) goto L27
            r3 = 0
            goto L28
        L27:
            r3 = 1
        L28:
            if (r3 == r1) goto L43
        L2a:
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r1 = r1 + 51
            int r3 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r1 = r1 % 2
            android.view.View r0 = (android.view.View) r0
            id.dana.core.ui.extension.ViewExtKt.PlaceComponentResult(r0, r2)
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
        L43:
            com.airbnb.lottie.LottieAnimationView r0 = r4.getWalletLottieButtonSection(r5)
            if (r0 == 0) goto L53
            id.dana.wallet_v3.view.NewWalletFragment$startExpandSectionAnimation$1 r1 = new id.dana.wallet_v3.view.NewWalletFragment$startExpandSectionAnimation$1
            r1.<init>()
            android.animation.Animator$AnimatorListener r1 = (android.animation.Animator.AnimatorListener) r1
            r0.addAnimatorListener(r1)
        L53:
            com.airbnb.lottie.LottieAnimationView r5 = r4.getWalletLottieButtonSection(r5)
            if (r5 == 0) goto L66
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r5.playAnimation()
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.startExpandSectionAnimation(int):void");
    }

    public final void onAddKtpAsset() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        getPersonalPresenter().consultAgreementCenter();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        int i4 = 47 / 0;
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment, id.dana.base.BaseFragment
    public final void init() {
        try {
            int i = PlaceComponentResult + 37;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                getLifecycle().BuiltInFictitiousFunctionClassFactory(getIdentityToastAndDialog());
                disableSwipe(false);
                setupToolbar();
                initView();
                initInjector();
                initWatcher();
                initializeCountUpTimerPublishSubject();
                initializeCountDownTimerPublishSubject();
                getNewWalletPresenter().getWalletV3ConfigFromLocal();
                checkIsNeedToShowSectionTooltip();
                this.isScrollable = false;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        super.onDestroyView();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(getIdentityToastAndDialog());
        _$_clearFindViewByIdCache();
        int i3 = PlaceComponentResult + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void onSelected() {
        FragmentNewWalletBinding fragmentNewWalletBinding;
        NestedScrollView nestedScrollView;
        try {
            int i = PlaceComponentResult + 123;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                if (!this.skipLoadData) {
                    reloadAllData();
                    return;
                }
                int i3 = PlaceComponentResult + 105;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
                    int i4 = 87 / 0;
                    if (!(fragmentNewWalletBinding != null)) {
                        return;
                    }
                } else {
                    fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
                    if (fragmentNewWalletBinding == null) {
                        return;
                    }
                }
                int i5 = PlaceComponentResult + 35;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if (i5 % 2 != 0) {
                    nestedScrollView = fragmentNewWalletBinding.f8082a;
                    if ((nestedScrollView != null ? '`' : 'N') != '`') {
                        return;
                    }
                } else {
                    nestedScrollView = fragmentNewWalletBinding.f8082a;
                    Object[] objArr = null;
                    int length = objArr.length;
                    if (nestedScrollView == null) {
                        return;
                    }
                }
                nestedScrollView.smoothScrollTo(0, 0);
                int i6 = PlaceComponentResult + 121;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean hidden) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? (char) 22 : Typography.dollar) != 22) {
                disableSwipe(hidden);
                super.onHiddenChanged(hidden);
                refreshRedDotBasedOnLastWalletSectionTypeDetailOpened();
                return;
            }
            disableSwipe(hidden);
            super.onHiddenChanged(hidden);
            refreshRedDotBasedOnLastWalletSectionTypeDetailOpened();
            int i2 = 70 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        String str;
        Showcase showcase;
        super.onResume();
        refreshRedDotBasedOnLastWalletSectionTypeDetailOpened();
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments != null) {
            str = arguments.getString(WALLET_SECTION, "");
        } else {
            str = null;
            int i = PlaceComponentResult + 31;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        }
        if (str == null) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } else {
            str2 = str;
        }
        this.section = str2;
        this.sectionWatcher.onNext(str2);
        if ((this.section.length() > 0 ? '\r' : (char) 0) != '\r') {
            return;
        }
        int i5 = PlaceComponentResult + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        if (i5 % 2 == 0) {
            showcase = this.showcase;
            int i6 = 66 / 0;
            if (showcase == null) {
                return;
            }
        } else {
            showcase = this.showcase;
            if ((showcase != null ? ']' : '8') != ']') {
                return;
            }
        }
        showcase.PlaceComponentResult();
    }

    private final void disableSwipe(boolean swipeable) {
        if ((getActivity() instanceof HomeTabActivity ? 'R' : '\\') == 'R') {
            HomeTabActivity homeTabActivity = (HomeTabActivity) getActivity();
            if (!(homeTabActivity == null)) {
                try {
                    homeTabActivity.setSwipeable(swipeable);
                    int i = PlaceComponentResult + 101;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i3 = PlaceComponentResult + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void initView() {
        int i = PlaceComponentResult + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        adjustViewPosition();
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        setupLottieBasedOnLanguage(LocaleUtil.PlaceComponentResult());
        initScrollView();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void initScrollView() {
        int i = PlaceComponentResult + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
        if (!(fragmentNewWalletBinding == null)) {
            try {
                NestedScrollView nestedScrollView = fragmentNewWalletBinding.f8082a;
                if (nestedScrollView != null) {
                    nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda37
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return NewWalletFragment.$r8$lambda$MsD5Ngf7evllfakg9ruMfbYdeh4(NewWalletFragment.this, view, motionEvent);
                        }
                    });
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 23 : 'E') != 'E') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* renamed from: initScrollView$lambda-6 */
    private static final boolean m3071initScrollView$lambda6(NewWalletFragment newWalletFragment, View view, MotionEvent motionEvent) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        boolean z = !newWalletFragment.isScrollable;
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void setupToolbar() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        setTitle(getString(R.string.wallet_v3_page_title));
        setMenuLeftButton(R.drawable.ic_dana_protection_logo_2_line_white, (int) getResources().getDimension(R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f070055));
        setMenuRightButton(R.drawable.ic_rounded_plus_white, (int) getResources().getDimension(R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f070055));
        setMenuRightButtonContentDescription(R.string.wallet_btn_add_asset);
        int i3 = PlaceComponentResult + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:176:0x007e, code lost:
    
        if (r1 != null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0085, code lost:
    
        if (r1 != null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0087, code lost:
    
        r1.bringToFront();
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x00cd, code lost:
    
        if ((r1 != null) != false) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x00da, code lost:
    
        if ((r1 != null ? '6' : ';') != '6') goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x00dd, code lost:
    
        r1.bringToFront();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void adjustViewPosition() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.adjustViewPosition():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setStackedCardPosition(int r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.getSectionCardView(r5)
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Exception -> L88
            java.util.List r0 = kotlin.collections.CollectionsKt.reversed(r0)     // Catch: java.lang.Exception -> L88
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Exception -> L88
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L88
        L10:
            boolean r1 = r0.hasNext()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1a
            r1 = 0
            goto L1b
        L1a:
            r1 = 1
        L1b:
            if (r1 == r2) goto L6a
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L88
            int r1 = r1 + 87
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2     // Catch: java.lang.Exception -> L88
            int r1 = r1 % 2
            if (r1 == 0) goto L37
            java.lang.Object r1 = r0.next()
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            r2 = 43
            int r2 = r2 / r3
            if (r1 == 0) goto L10
            goto L3f
        L35:
            r5 = move-exception
            throw r5
        L37:
            java.lang.Object r1 = r0.next()
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            if (r1 == 0) goto L10
        L3f:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 15
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % 2
            r3 = 42
            if (r2 == 0) goto L50
            r2 = 42
            goto L52
        L50:
            r2 = 64
        L52:
            if (r2 == r3) goto L58
            r1.bringToFront()
            goto L5d
        L58:
            r1.bringToFront()
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L68
        L5d:
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r1 = r1 + 21
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            goto L10
        L68:
            r5 = move-exception
            throw r5
        L6a:
            android.widget.FrameLayout r5 = r4.getSkeletonView(r5)
            if (r5 == 0) goto L87
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 3
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L84
            r5.bringToFront()
            r5 = 7
            int r5 = r5 / r3
            goto L87
        L82:
            r5 = move-exception
            throw r5
        L84:
            r5.bringToFront()
        L87:
            return
        L88:
            r5 = move-exception
            goto L8b
        L8a:
            throw r5
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setStackedCardPosition(int):void");
    }

    private final void initInjector() {
        DaggerNewWalletComponent.Builder servicesModule = DaggerNewWalletComponent.builder().applicationComponent(getApplicationComponent()).newWalletModule(getNewWalletModule()).getBalanceModule(getBalanceModule()).personalModule(getPersonalModule()).servicesModule(getServicesModule());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getActivity();
        Object[] objArr = new Object[1];
        a(8 - (ViewConfiguration.getScrollBarSize() >> 8), new int[]{-1305954821, 1036226734, 1527178606, 389202309}, objArr);
        byte b = 0;
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        DaggerNewWalletComponent.Builder deepLinkModule = servicesModule.deepLinkModule(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        DaggerNewWalletComponent.Builder scanQrModule = deepLinkModule.scanQrModule(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getActivity();
        DaggerNewWalletComponent.Builder restoreUrlModule = scanQrModule.restoreUrlModule(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        DaggerNewWalletComponent.Builder featureModule = restoreUrlModule.featureModule(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        featureModule.oauthModule(new OauthModule(BuiltInFictitiousFunctionClassFactory, b)).build().inject(this);
        this.compositeDisposable.MyBillsEntityDataFactory();
        addDisposable(getAllAssetErrorObserver());
        addDisposable(getAllAssetFromLocalObserver());
        addDisposable(getAllAssetFromNetworkObserver());
        setTimeoutAllAssetFromNetworkObserver();
        int i = PlaceComponentResult + 53;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x001e, code lost:
    
        if ((r0 == r3) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002b, code lost:
    
        if (r6.getStatus() != id.dana.wallet_v3.model.SectionStatus.RELOAD) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0035, code lost:
    
        if (r6.getStatus() != id.dana.wallet_v3.model.SectionStatus.HIDDEN) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0037, code lost:
    
        r0 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003a, code lost:
    
        r0 = 'E';
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003c, code lost:
    
        if (r0 == 'E') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003f, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0040, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void checkIsReload(id.dana.wallet_v3.model.WalletSectionModel r6, id.dana.wallet_v3.model.SectionStatus r7) {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L25
            id.dana.wallet_v3.model.SectionStatus r0 = r6.getStatus()     // Catch: java.lang.Exception -> L23
            id.dana.wallet_v3.model.SectionStatus r3 = id.dana.wallet_v3.model.SectionStatus.RELOAD     // Catch: java.lang.Exception -> L23
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L21
            if (r0 == r3) goto L1e
            r1 = 0
        L1e:
            if (r1 == 0) goto L2d
            goto L41
        L21:
            r6 = move-exception
            throw r6
        L23:
            r6 = move-exception
            throw r6
        L25:
            id.dana.wallet_v3.model.SectionStatus r0 = r6.getStatus()
            id.dana.wallet_v3.model.SectionStatus r1 = id.dana.wallet_v3.model.SectionStatus.RELOAD
            if (r0 == r1) goto L41
        L2d:
            id.dana.wallet_v3.model.SectionStatus r0 = r6.getStatus()     // Catch: java.lang.Exception -> L3f
            id.dana.wallet_v3.model.SectionStatus r1 = id.dana.wallet_v3.model.SectionStatus.HIDDEN     // Catch: java.lang.Exception -> L3f
            r2 = 69
            if (r0 != r1) goto L3a
            r0 = 10
            goto L3c
        L3a:
            r0 = 69
        L3c:
            if (r0 == r2) goto L51
            goto L41
        L3f:
            r6 = move-exception
            throw r6
        L41:
            r6.setStatus(r7)
            r5.setSectionView(r6)
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 107
            int r7 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r7
            int r6 = r6 % 2
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.checkIsReload(id.dana.wallet_v3.model.WalletSectionModel, id.dana.wallet_v3.model.SectionStatus):void");
    }

    private final NewWalletModule getNewWalletModule() {
        NewWalletModule newWalletModule = new NewWalletModule(new NewWalletContract.View() { // from class: id.dana.wallet_v3.view.NewWalletFragment$getNewWalletModule$1
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

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onGetWalletV3Config(WalletV3Config walletConfig) {
                Intrinsics.checkNotNullParameter(walletConfig, "");
                NewWalletFragment.access$setWalletConfig$p(NewWalletFragment.this, walletConfig);
                NewWalletFragment.access$setWalletSectionOrderingList$p(NewWalletFragment.this, walletConfig.getSectionOrderingV3());
                NewWalletFragment.access$setWalletVoucherAndTicketSectionAssetType$p(NewWalletFragment.this, walletConfig.getWalletFinancialSection());
                NewWalletFragment.access$setupSectionIndex(NewWalletFragment.this);
                NewWalletFragment.access$loadDataFromPersistence(NewWalletFragment.this, walletConfig);
                NewWalletFragment.access$initOnClickListener(NewWalletFragment.this);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onFetchLoyaltyAccessTokenAndKycLevelSuccess(String accessToken, String kycLevel) {
                NewWalletFragment.access$setAccessToken$p(NewWalletFragment.this, accessToken);
                NewWalletFragment.access$setKycLevel$p(NewWalletFragment.this, kycLevel);
                NewWalletFragment.access$onGetAccessTokenAndKycLevel(NewWalletFragment.this);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onFetchLoyaltyAccessTokenAndKycLevelError() {
                NewWalletFragment.access$onGetAccessTokenAndKycLevel(NewWalletFragment.this);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onSuccessGetPaymentCardAssets(List<? extends PaymentCardModel> assets) {
                Intrinsics.checkNotNullParameter(assets, "");
                NewWalletFragment.access$getGetPaymentAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.valueOf(NewWalletFragment.access$isFetchDataAfterFromLocal$p(NewWalletFragment.this)));
                NewWalletFragment.access$getPaymentSection$p(NewWalletFragment.this).setAssets(assets);
                WalletSectionModel access$getPaymentSection$p = NewWalletFragment.access$getPaymentSection$p(NewWalletFragment.this);
                ArrayList arrayList = new ArrayList();
                for (Object obj : assets) {
                    if ((!(((PaymentCardModel) obj) instanceof PaymentCardModel.EmptyCard)) != false) {
                        arrayList.add(obj);
                    }
                }
                access$getPaymentSection$p.setTotalAssets(arrayList.size());
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getPaymentSection$p(newWalletFragment), SectionStatus.SUCCESS);
                NewWalletFragment.access$getPaymentSection$p(NewWalletFragment.this).setStatus(SectionStatus.SUCCESS);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onErrorGetPaymentCardAssets(String errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "");
                NewWalletFragment.this.getNewWalletPresenter().getAssetReloadIntervalTime("PAYMENT", errorCode);
                NewWalletFragment.access$getGetPaymentAssetErrorWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getPaymentSection$p(newWalletFragment), SectionStatus.ERROR);
                NewWalletFragment.access$getPaymentSection$p(NewWalletFragment.this).setStatus(SectionStatus.ERROR);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onEmptyGetPaymentCardAssets() {
                NewWalletFragment.access$getGetPaymentAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getPaymentSection$p(newWalletFragment), SectionStatus.EMPTY);
                NewWalletFragment.access$getPaymentSection$p(NewWalletFragment.this).setStatus(SectionStatus.EMPTY);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onLoadingGetPaymentCardAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$showLoadingStateSection(newWalletFragment, NewWalletFragment.access$getPaymentSection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onDismissLoadingGetPaymentCardAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$dismissLoadingStateSection(newWalletFragment, NewWalletFragment.access$getPaymentSection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onSuccessGetInvestmentCardAssets(List<? extends InvestmentCardModel> assets) {
                Intrinsics.checkNotNullParameter(assets, "");
                NewWalletFragment.access$getGetInvestmentAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.valueOf(NewWalletFragment.access$isFetchDataAfterFromLocal$p(NewWalletFragment.this)));
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setAssets(assets);
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setTotalAssets(assets.size());
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getFinancialSection$p(newWalletFragment), SectionStatus.SUCCESS);
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setStatus(SectionStatus.SUCCESS);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onErrorGetInvestmentCardAssets(String errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "");
                NewWalletFragment.this.getNewWalletPresenter().getAssetReloadIntervalTime("FINANCIAL", errorCode);
                NewWalletFragment.access$getGetInvestmentAssetErrorWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getFinancialSection$p(newWalletFragment), SectionStatus.ERROR);
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setStatus(SectionStatus.ERROR);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onEmptyGetInvestmentCardAssets() {
                ?? r2 = 0;
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setAssets(CollectionsKt.listOf(new InvestmentCardModel.EmptyInvestmentCard(r2, 1, r2)));
                NewWalletFragment.access$getGetInvestmentAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getFinancialSection$p(newWalletFragment), SectionStatus.EMPTY);
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setStatus(SectionStatus.EMPTY);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onLoadingGetInvestmentCardAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$showLoadingStateSection(newWalletFragment, NewWalletFragment.access$getFinancialSection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onDismissLoadingGetInvestmentCardAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$dismissLoadingStateSection(newWalletFragment, NewWalletFragment.access$getFinancialSection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onSuccessGetVoucherAndTicketAssets(NewPocketQueryListModel<VoucherAndTicketCardModel> assets) {
                Intrinsics.checkNotNullParameter(assets, "");
                NewWalletFragment.access$getGetVoucherAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.valueOf(NewWalletFragment.access$isFetchDataAfterFromLocal$p(NewWalletFragment.this)));
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setAssets(assets.getPockets());
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setTotalAssets(assets.getTotalCount() > 0 ? assets.getTotalCount() : assets.getPockets().size());
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getVoucherAndTicketSection$p(newWalletFragment), SectionStatus.SUCCESS);
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setStatus(SectionStatus.SUCCESS);
                NewWalletFragment.this.getNewWalletPresenter().getPocketRedDotTotalCount("VOUCHER_AND_TICKET", NewWalletFragment.access$getVoucherAndTicketAssetTypes(NewWalletFragment.this));
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onErrorGetVoucherAndTicketAssets(String errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "");
                NewWalletFragment.this.getNewWalletPresenter().getAssetReloadIntervalTime("VOUCHER_AND_TICKET", errorCode);
                NewWalletFragment.access$getGetVoucherAssetErrorWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getVoucherAndTicketSection$p(newWalletFragment), SectionStatus.ERROR);
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setStatus(SectionStatus.ERROR);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onEmptyGetVoucherAndTicketAssets() {
                ?? r2 = 0;
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setAssets(CollectionsKt.listOf(new VoucherAndTicketCardModel.EmptyState(r2, 1, r2)));
                NewWalletFragment.access$getGetVoucherAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getVoucherAndTicketSection$p(newWalletFragment), SectionStatus.EMPTY);
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setStatus(SectionStatus.EMPTY);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onLoadingGetVoucherAndTicketAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$showLoadingStateSection(newWalletFragment, NewWalletFragment.access$getVoucherAndTicketSection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onDismissLoadingGetVoucherAndTicketAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$dismissLoadingStateSection(newWalletFragment, NewWalletFragment.access$getVoucherAndTicketSection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onSuccessGetLoyaltyAssets(NewPocketQueryListModel<LoyaltyCardModel> assets) {
                Intrinsics.checkNotNullParameter(assets, "");
                NewWalletFragment.access$getGetLoyaltyAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.valueOf(NewWalletFragment.access$isFetchDataAfterFromLocal$p(NewWalletFragment.this)));
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setAssets(assets.getPockets());
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setTotalAssets(assets.getPockets().size());
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getLoyaltySection$p(newWalletFragment), SectionStatus.SUCCESS);
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setStatus(SectionStatus.SUCCESS);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onErrorGetLoyaltyAssets(String errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "");
                NewWalletFragment.this.getNewWalletPresenter().getAssetReloadIntervalTime("LOYALTY", errorCode);
                NewWalletFragment.access$getGetLoyaltyAssetErrorWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getLoyaltySection$p(newWalletFragment), SectionStatus.ERROR);
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setStatus(SectionStatus.ERROR);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onEmptyGetLoyaltyAssets() {
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setAssets(CollectionsKt.listOf(new LoyaltyCardModel.LoyaltyCard(null, null, null, false, 3, null, null, null, null, null, null, null, null, null, null, 32751, null)));
                NewWalletFragment.access$getGetLoyaltyAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getLoyaltySection$p(newWalletFragment), SectionStatus.EMPTY);
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setStatus(SectionStatus.EMPTY);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onLoadingGetLoyaltyAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$showLoadingStateSection(newWalletFragment, NewWalletFragment.access$getLoyaltySection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onDismissLoadingGetLoyaltyAssets() {
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$dismissLoadingStateSection(newWalletFragment, NewWalletFragment.access$getLoyaltySection$p(newWalletFragment).getIndex());
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onShowTooltip(String scenario, boolean isShowToolTip) {
                Intrinsics.checkNotNullParameter(scenario, "");
                switch (scenario.hashCode()) {
                    case -1805593239:
                        if (!scenario.equals(UserEducationPreference.WALLET_VOUCHER_TICKET_SECTION_TOOLTIP)) {
                            return;
                        }
                        break;
                    case -1342055514:
                        if (!scenario.equals(UserEducationPreference.WALLET_LOYALTY_SECTION_TOOLTIP)) {
                            return;
                        }
                        break;
                    case 188577036:
                        if (scenario.equals(UserEducationPreference.WALLET_ADD_ASSET_TOOLTIP)) {
                            NewWalletFragment.access$setCheckTooltipVisibility$p(NewWalletFragment.this, false);
                            if (isShowToolTip) {
                                if (NewWalletFragment.access$getSection$p(NewWalletFragment.this).length() == 0) {
                                    NewWalletFragment newWalletFragment = NewWalletFragment.this;
                                    final NewWalletFragment newWalletFragment2 = NewWalletFragment.this;
                                    NewWalletFragment.access$delayToShowTooltip(newWalletFragment, new Function0<Target>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$getNewWalletModule$1$onShowTooltip$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Target invoke() {
                                            return NewWalletFragment.access$getTooltipTarget(NewWalletFragment.this);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 824596458:
                        if (!scenario.equals(UserEducationPreference.WALLET_IDENTITY_SECTION_TOOLTIP)) {
                            return;
                        }
                        break;
                    case 1492777577:
                        if (!scenario.equals(UserEducationPreference.WALLET_FINANCIAL_SECTION_TOOLTIP)) {
                            return;
                        }
                        break;
                    case 1750239590:
                        if (!scenario.equals(UserEducationPreference.WALLET_PAYMENT_SECTION_TOOLTIP)) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                NewWalletFragment.access$getShouldShowSectionTooltip$p(NewWalletFragment.this).put(scenario, Boolean.valueOf(isShowToolTip));
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onSuccessGetVoucherAndTicketRedDotTotalCount(int totalCount) {
                if (totalCount <= 0) {
                    return;
                }
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$showTotalAssetSectionHeader(newWalletFragment, NewWalletFragment.access$getVoucherAndTicketSection$p(newWalletFragment), true, totalCount);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onHideInvestmentSection() {
                NewWalletFragment.access$getGetInvestmentAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setStatus(SectionStatus.HIDDEN);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getFinancialSection$p(newWalletFragment), SectionStatus.HIDDEN);
                NewWalletFragment.saveSectionTooltipShown$default(NewWalletFragment.this, "FINANCIAL", false, 2, null);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onHideVoucherSection() {
                NewWalletFragment.access$getGetVoucherAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setStatus(SectionStatus.HIDDEN);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getVoucherAndTicketSection$p(newWalletFragment), SectionStatus.HIDDEN);
                NewWalletFragment.saveSectionTooltipShown$default(NewWalletFragment.this, "VOUCHER_AND_TICKET", false, 2, null);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onHideLoyaltySection() {
                NewWalletFragment.access$getGetLoyaltyAssetWatcher$p(NewWalletFragment.this).onNext(Boolean.TRUE);
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setStatus(SectionStatus.HIDDEN);
                NewWalletFragment newWalletFragment = NewWalletFragment.this;
                NewWalletFragment.access$checkIsReload(newWalletFragment, NewWalletFragment.access$getLoyaltySection$p(newWalletFragment), SectionStatus.HIDDEN);
                NewWalletFragment.saveSectionTooltipShown$default(NewWalletFragment.this, "LOYALTY", false, 2, null);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onHideIdentitySection() {
                NewWalletFragment.access$getIdentitySection$p(NewWalletFragment.this).setStatus(SectionStatus.HIDDEN);
                NewWalletFragment.access$hideIdentitySection(NewWalletFragment.this);
                NewWalletFragment.saveSectionTooltipShown$default(NewWalletFragment.this, "IDENTITY", false, 2, null);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onGetPaymentReloadIntervalTime(long millis) {
                NewWalletFragment.access$getPaymentSection$p(NewWalletFragment.this).setIntervalTime(millis);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onGetFinancialReloadIntervalTime(long millis) {
                NewWalletFragment.access$getFinancialSection$p(NewWalletFragment.this).setIntervalTime(millis);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onGetVoucherAndTicketReloadIntervalTime(long millis) {
                NewWalletFragment.access$getVoucherAndTicketSection$p(NewWalletFragment.this).setIntervalTime(millis);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onGetLoyaltyReloadIntervalTime(long millis) {
                NewWalletFragment.access$getLoyaltySection$p(NewWalletFragment.this).setIntervalTime(millis);
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onSuccessGetAssetFromDatabase(String sectionType) {
                Intrinsics.checkNotNullParameter(sectionType, "");
                int hashCode = sectionType.hashCode();
                Boolean bool = Boolean.TRUE;
                switch (hashCode) {
                    case -1150817175:
                        if (sectionType.equals("FINANCIAL")) {
                            NewWalletFragment.access$getGetInvestmentAssetFromLocalWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    case -554006299:
                        if (sectionType.equals("VOUCHER_AND_TICKET")) {
                            NewWalletFragment.access$getGetVoucherAssetFromLocalWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    case -68698650:
                        if (sectionType.equals("PAYMENT")) {
                            NewWalletFragment.access$getGetPaymentAssetFromLocalWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    case 1076711462:
                        if (sectionType.equals("LOYALTY")) {
                            NewWalletFragment.access$getGetLoyaltyAssetFromLocalWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            @Override // id.dana.wallet_v3.presenter.NewWalletContract.View
            public final void onGetEmptyAssetFromDatabase(String sectionType) {
                Intrinsics.checkNotNullParameter(sectionType, "");
                int hashCode = sectionType.hashCode();
                Boolean bool = Boolean.TRUE;
                switch (hashCode) {
                    case -1150817175:
                        if (sectionType.equals("FINANCIAL")) {
                            NewWalletFragment.access$getGetInvestmentAssetFromLocalEmptyWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    case -554006299:
                        if (sectionType.equals("VOUCHER_AND_TICKET")) {
                            NewWalletFragment.access$getGetVoucherAssetFromLocalEmptyWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    case -68698650:
                        if (sectionType.equals("PAYMENT")) {
                            NewWalletFragment.access$getGetPaymentAssetFromLocalEmptyWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    case 1076711462:
                        if (sectionType.equals("LOYALTY")) {
                            NewWalletFragment.access$getGetLoyaltyAssetFromLocalEmptyWatcher$p(NewWalletFragment.this).onNext(bool);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        int i = PlaceComponentResult + 59;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            return newWalletModule;
        }
        Object obj = null;
        obj.hashCode();
        return newWalletModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x001f, code lost:
    
        if (r0 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0032, code lost:
    
        if (r0 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0034, code lost:
    
        showCardList(r6.getIndex(), r0);
        adjustCardSpacing(r6.getIndex(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x004b, code lost:
    
        if (r0.contains(new id.dana.wallet_v3.model.PaymentCardModel.EmptyCard(r3, r2, r3)) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x004d, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x004f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0050, code lost:
    
        if (r0 == true) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0052, code lost:
    
        showSectionTooltip(r6.getType());
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 11;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0063, code lost:
    
        showTotalAssetSectionHeader(r6, false, r6.getTotalAssets());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x006a, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setSectionSuccess(id.dana.wallet_v3.model.WalletSectionModel r6) {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L24
            int r0 = r6.getIndex()     // Catch: java.lang.Exception -> L22
            r5.showSection(r0)     // Catch: java.lang.Exception -> L22
            java.util.List r0 = r6.getAssets()     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto L63
            goto L34
        L22:
            r6 = move-exception
            goto L6d
        L24:
            int r0 = r6.getIndex()     // Catch: java.lang.Exception -> L6e
            r5.showSection(r0)
            java.util.List r0 = r6.getAssets()     // Catch: java.lang.Exception -> L22
            r3.hashCode()     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L63
        L34:
            int r4 = r6.getIndex()
            r5.showCardList(r4, r0)
            int r4 = r6.getIndex()
            r5.adjustCardSpacing(r4, r0)
            id.dana.wallet_v3.model.PaymentCardModel$EmptyCard r4 = new id.dana.wallet_v3.model.PaymentCardModel$EmptyCard
            r4.<init>(r3, r2, r3)
            boolean r0 = r0.contains(r4)
            if (r0 != 0) goto L4f
            r0 = 0
            goto L50
        L4f:
            r0 = 1
        L50:
            if (r0 == r2) goto L63
            java.lang.String r0 = r6.getType()
            r5.showSectionTooltip(r0)
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 11
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
        L63:
            int r0 = r6.getTotalAssets()
            r5.showTotalAssetSectionHeader(r6, r1, r0)
            return
        L6b:
            r6 = move-exception
            throw r6
        L6d:
            throw r6
        L6e:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setSectionSuccess(id.dana.wallet_v3.model.WalletSectionModel):void");
    }

    private final void setSectionEmpty(WalletSectionModel r4) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        toggleDropdownVisibility(r4.getIndex(), 0);
        toggleReloadVisibility(r4.getIndex(), 8);
        showEmptyState(r4);
        showTotalAssetSectionHeader(r4, false, 0);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private final void setSectionError(WalletSectionModel r3) {
        int i = PlaceComponentResult + 15;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        toggleDropdownVisibility(r3.getIndex(), 8);
        toggleReloadVisibility(r3.getIndex(), 0);
        showErrorState(r3.getIndex());
        showTotalAssetSectionHeader(r3, false, 0);
        int i3 = PlaceComponentResult + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void showErrorStateInIdentity() {
        try {
            int i = PlaceComponentResult + 83;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                toggleDropdownVisibility(this.identitySection.getIndex(), 8);
                toggleReloadVisibility(this.identitySection.getIndex(), 0);
                dismissLoadingStateSection(this.identitySection.getIndex());
                showErrorState(this.identitySection.getIndex());
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void setAllAssetToErrorState() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            try {
                checkShouldShowErrorState(this.paymentSection);
                checkShouldShowErrorState(this.financialSection);
                checkShouldShowErrorState(this.loyaltySection);
                checkShouldShowErrorState(this.voucherAndTicketSection);
                Object[] objArr = null;
                int length = objArr.length;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            checkShouldShowErrorState(this.paymentSection);
            checkShouldShowErrorState(this.financialSection);
            checkShouldShowErrorState(this.loyaltySection);
            checkShouldShowErrorState(this.voucherAndTicketSection);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0016, code lost:
    
        if (r0 == r1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002c, code lost:
    
        if ((r4.getStatus() == id.dana.wallet_v3.model.SectionStatus.INIT ? 'O' : '*') != 'O') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002f, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x003b, code lost:
    
        if ((r0 % 2) == 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003d, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0040, code lost:
    
        if (r0 == true) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0042, code lost:
    
        r4.setStatus(id.dana.wallet_v3.model.SectionStatus.ERROR);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0049, code lost:
    
        r0 = 45 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x004d, code lost:
    
        r4.setStatus(id.dana.wallet_v3.model.SectionStatus.ERROR);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0052, code lost:
    
        setSectionView(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0055, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void checkShouldShowErrorState(id.dana.wallet_v3.model.WalletSectionModel r4) {
        /*
            r3 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L1d
            id.dana.wallet_v3.model.SectionStatus r0 = r4.getStatus()     // Catch: java.lang.Exception -> L1b
            id.dana.wallet_v3.model.SectionStatus r1 = id.dana.wallet_v3.model.SectionStatus.INIT     // Catch: java.lang.Exception -> L1b
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L19
            if (r0 != r1) goto L52
            goto L2f
        L19:
            r4 = move-exception
            throw r4
        L1b:
            r4 = move-exception
            throw r4
        L1d:
            id.dana.wallet_v3.model.SectionStatus r0 = r4.getStatus()
            id.dana.wallet_v3.model.SectionStatus r1 = id.dana.wallet_v3.model.SectionStatus.INIT
            r2 = 79
            if (r0 != r1) goto L2a
            r0 = 79
            goto L2c
        L2a:
            r0 = 42
        L2c:
            if (r0 == r2) goto L2f
            goto L52
        L2f:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3f
            r0 = 0
            goto L40
        L3f:
            r0 = 1
        L40:
            if (r0 == r2) goto L4d
            id.dana.wallet_v3.model.SectionStatus r0 = id.dana.wallet_v3.model.SectionStatus.ERROR
            r4.setStatus(r0)
            r0 = 45
            int r0 = r0 / r1
            goto L52
        L4b:
            r4 = move-exception
            throw r4
        L4d:
            id.dana.wallet_v3.model.SectionStatus r0 = id.dana.wallet_v3.model.SectionStatus.ERROR
            r4.setStatus(r0)
        L52:
            r3.setSectionView(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.checkShouldShowErrorState(id.dana.wallet_v3.model.WalletSectionModel):void");
    }

    private final GetBalanceModule getBalanceModule() {
        GetBalanceModule getBalanceModule = new GetBalanceModule(new GetBalanceContract.View() { // from class: id.dana.wallet_v3.view.NewWalletFragment$getBalanceModule$1
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

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalance(CurrencyAmountModel currencyAmountModel) {
                GetBalanceContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceDanaPlusActive(String str, String str2, DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                GetBalanceContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceDanaPlusError() {
                GetBalanceContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceDanaPlusUnActive(DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                GetBalanceContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceError() {
                GetBalanceContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceState(Boolean bool) {
                GetBalanceContract.View.CC.moveToNextValue();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetAllBalanceState(List<Boolean> allBalanceVisibility) {
                WalletCardFactory.INSTANCE.setAllBalanceVisibility(allBalanceVisibility);
            }
        });
        int i = PlaceComponentResult + 121;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? 'A' : '9') != 'A') {
            return getBalanceModule;
        }
        int i2 = 24 / 0;
        return getBalanceModule;
    }

    private final PersonalModule getPersonalModule() {
        try {
            PersonalModule personalModule = new PersonalModule(new PersonalContract.View() { // from class: id.dana.wallet_v3.view.NewWalletFragment$getPersonalModule$1
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

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onGetInsuranceQueryListError() {
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onGetInsuranceQueryListSuccess(PocketQueryListModel<InsuranceAssetModel> pocketQueryList, boolean isNeedToReset) {
                    Intrinsics.checkNotNullParameter(pocketQueryList, "");
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onGetKtpInfoQueryError() {
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onGetKtpInfoQuerySuccess(PocketQueryListModel<KtpInfoModel> pocketQueryList, boolean isNeedToReset) {
                    Intrinsics.checkNotNullParameter(pocketQueryList, "");
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onKtpSaved(boolean isShowKtp) {
                    NewWalletFragment.access$setKtpIsSaved$p(NewWalletFragment.this, isShowKtp);
                    if (isShowKtp) {
                        NewWalletFragment.access$showIdentitySection(NewWalletFragment.this);
                        NewWalletFragment.this.updateIdentityCardState(CollectionsKt.listOf(new IdentityCardModel.KtpCard(null, null, null, 14, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194295, null)));
                        return;
                    }
                    NewWalletFragment.this.getNewWalletPresenter().updateTotalSectionQuery(5, false);
                    NewWalletFragment.access$getIdentitySection$p(NewWalletFragment.this).setAssets(CollectionsKt.listOf(new IdentityCardModel.KtpCard(null, null, null, 3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194295, null)));
                    NewWalletFragment newWalletFragment = NewWalletFragment.this;
                    NewWalletFragment.access$dismissLoadingStateSection(newWalletFragment, NewWalletFragment.access$getIdentitySection$p(newWalletFragment).getIndex());
                    NewWalletFragment newWalletFragment2 = NewWalletFragment.this;
                    newWalletFragment2.showEmptyState(NewWalletFragment.access$getIdentitySection$p(newWalletFragment2));
                    NewWalletFragment newWalletFragment3 = NewWalletFragment.this;
                    NewWalletFragment.access$showTotalAssetSectionHeader(newWalletFragment3, NewWalletFragment.access$getIdentitySection$p(newWalletFragment3), false, 0);
                    NewWalletFragment.this.getNewWalletPresenter().getTotalSectionQuery(5, CollectionsKt.listOf(AssetType.ID_CARD.getAsset()));
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onKtpNotSaved() {
                    NewWalletFragment.this.getNewWalletPresenter().updateTotalSectionQuery(5, false);
                    NewWalletFragment.access$setKtpIsSaved$p(NewWalletFragment.this, false);
                    NewWalletFragment.access$getIdentitySection$p(NewWalletFragment.this).setAssets(CollectionsKt.listOf(new IdentityCardModel.KtpCard(null, null, null, 3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194295, null)));
                    NewWalletFragment newWalletFragment = NewWalletFragment.this;
                    NewWalletFragment.access$dismissLoadingStateSection(newWalletFragment, NewWalletFragment.access$getIdentitySection$p(newWalletFragment).getIndex());
                    NewWalletFragment newWalletFragment2 = NewWalletFragment.this;
                    NewWalletFragment.access$setSectionEmpty(newWalletFragment2, NewWalletFragment.access$getIdentitySection$p(newWalletFragment2));
                    NewWalletFragment.this.getNewWalletPresenter().getTotalSectionQuery(5, CollectionsKt.listOf(AssetType.ID_CARD.getAsset()));
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onCheckKtpPopUpError(String errorCode) {
                    Intrinsics.checkNotNullParameter(errorCode, "");
                    NewWalletFragment.this.getPersonalPresenter().getAssetReloadIntervalTime(errorCode);
                    NewWalletFragment.access$showErrorStateInIdentity(NewWalletFragment.this);
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onSaveKtpSuccess() {
                    NewWalletFragment.access$showIdentitySection(NewWalletFragment.this);
                    NewWalletFragment.access$setKtpIsSaved$p(NewWalletFragment.this, true);
                    NewWalletFragment.access$setShouldShowIdentityTooltip$p(NewWalletFragment.this, false);
                    NewWalletFragment.access$getIdentityToastAndDialog(NewWalletFragment.this).showSuccessToast(NewWalletFragment.this);
                    NewWalletFragment.this.updateIdentityCardState(CollectionsKt.listOf(new IdentityCardModel.KtpCard(null, null, null, 14, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194295, null)));
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onSaveKtpError() {
                    NewWalletFragment.access$getIdentityToastAndDialog(NewWalletFragment.this).showErrorToast();
                    NewWalletFragment newWalletFragment = NewWalletFragment.this;
                    newWalletFragment.showEmptyState(NewWalletFragment.access$getIdentitySection$p(newWalletFragment));
                    NewWalletFragment newWalletFragment2 = NewWalletFragment.this;
                    NewWalletFragment.access$showTotalAssetSectionHeader(newWalletFragment2, NewWalletFragment.access$getIdentitySection$p(newWalletFragment2), false, 0);
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onGetUserKYCStatusSuccess(Map<String, String> extendInfo) {
                    Intrinsics.checkNotNullParameter(extendInfo, "");
                    IdentityToastAndDialogImpl access$getIdentityToastAndDialog = NewWalletFragment.access$getIdentityToastAndDialog(NewWalletFragment.this);
                    String kycLandingPageUrl = NewWalletFragment.this.getDynamicUrlWrapper().getKycLandingPageUrl();
                    Intrinsics.checkNotNullExpressionValue(kycLandingPageUrl, "");
                    final NewWalletFragment newWalletFragment = NewWalletFragment.this;
                    access$getIdentityToastAndDialog.checkKYCStatusAndCertType(extendInfo, kycLandingPageUrl, new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$getPersonalModule$1$onGetUserKYCStatusSuccess$1
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
                            NewWalletFragment.this.getPersonalPresenter().recordAgreement(true, true);
                        }
                    });
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onGetUserKYCStatusError() {
                    NewWalletFragment.access$getIdentityToastAndDialog(NewWalletFragment.this).showErrorToast();
                    NewWalletFragment.access$showErrorStateInIdentity(NewWalletFragment.this);
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onConsultAgreementCenterError() {
                    NewWalletFragment.access$getIdentityToastAndDialog(NewWalletFragment.this).showErrorToast();
                }

                @Override // id.dana.wallet.personal.PersonalContract.View
                public final void onGetIdentityReloadIntervalTime(long millis) {
                    NewWalletFragment.access$getIdentitySection$p(NewWalletFragment.this).setIntervalTime(millis);
                }
            });
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return personalModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void hideSection(int sectionIndex) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        toggleSectionVisibility(sectionIndex, 8);
        toggleDropdownVisibility(sectionIndex, 8);
        toggleReloadVisibility(sectionIndex, 8);
        toggleDividerVisibility(sectionIndex, 8);
        hideTitleSectionHeader(sectionIndex);
        setSpaceVisibility(sectionIndex, 1);
        int i3 = PlaceComponentResult + 43;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void hideIdentitySection() {
        int i = PlaceComponentResult + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        toggleIdentitySectionVisibility(8);
        toggleDropdownVisibility(this.identitySection.getIndex(), 8);
        toggleReloadVisibility(this.identitySection.getIndex(), 8);
        toggleDividerVisibility(this.identitySection.getIndex(), 8);
        hideTitleSectionHeader(this.identitySection.getIndex());
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void showIdentitySection() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            dismissLoadingStateSection(this.identitySection.getIndex());
            getNewWalletPresenter().updateTotalSectionQuery(5, true);
            toggleIdentitySectionVisibility(0);
            toggleDropdownVisibility(this.identitySection.getIndex(), 0);
            toggleReloadVisibility(this.identitySection.getIndex(), 8);
            toggleDividerVisibility(this.identitySection.getIndex(), 0);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void showSection(int sectionIndex) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        toggleSectionVisibility(sectionIndex, 0);
        toggleDropdownVisibility(sectionIndex, 0);
        toggleReloadVisibility(sectionIndex, 8);
        toggleDividerVisibility(sectionIndex, 0);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void loadData(WalletV3Config walletConfig) {
        WalletV3AddAssetServices walletV3AddAssetServices = null;
        if (((walletConfig != null ? 'c' : (char) 14) != 'c' ? null : walletConfig.getCategoryPayment()) != null) {
            try {
                int i = PlaceComponentResult + 21;
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    this.paymentSection.setEnabled(Boolean.TRUE);
                    getNewWalletPresenter().getPaymentCardAssets(this.isAssetsFromLocalEmpty.get(0).booleanValue());
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            this.paymentSection.setEnabled(Boolean.FALSE);
        }
        if ((!(walletConfig == null) ? walletConfig.getCategoryFinancial() : null) != null) {
            this.financialSection.setEnabled(Boolean.TRUE);
            getNewWalletPresenter().getInvestmentCardAssets(this.isAssetsFromLocalEmpty.get(1).booleanValue());
        } else {
            this.financialSection.setEnabled(Boolean.FALSE);
        }
        if ((walletConfig != null ? walletConfig.getCategoryVoucherAndTicket() : null) != null) {
            this.voucherAndTicketSection.setEnabled(Boolean.TRUE);
            getNewWalletPresenter().getVoucherAndTicketOrder(getVoucherAndTicketAssetTypes(), this.isAssetsFromLocalEmpty.get(2).booleanValue());
        } else {
            this.voucherAndTicketSection.setEnabled(Boolean.FALSE);
            int i3 = PlaceComponentResult + 39;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        }
        if ((walletConfig != null ? walletConfig.getCategoryLoyalty() : null) != null) {
            this.loyaltySection.setEnabled(Boolean.TRUE);
            getNewWalletPresenter().fetchLoyaltyAccessTokenAndKycLevel();
        } else {
            this.loyaltySection.setEnabled(Boolean.FALSE);
        }
        if (walletConfig != null) {
            int i5 = PlaceComponentResult + 85;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            if (i5 % 2 == 0) {
                walletV3AddAssetServices = walletConfig.getCategoryIdentity();
                int i6 = 72 / 0;
            } else {
                walletV3AddAssetServices = walletConfig.getCategoryIdentity();
            }
        }
        if ((walletV3AddAssetServices != null ? 'A' : (char) 11) == 'A') {
            this.identitySection.setEnabled(Boolean.TRUE);
            fetchIdentitySection();
        } else {
            this.identitySection.setEnabled(Boolean.FALSE);
        }
        getGetBalancePresenter().MyBillsEntityDataFactory();
        if ((this.financeServices.isEmpty() ? 'c' : (char) 15) != 15) {
            getServicePresenter().BuiltInFictitiousFunctionClassFactory(WalletConstant.CATEGORY_FINANCE, true);
        }
    }

    private final void setupSectionIndex() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        this.paymentSection.setIndex(getIndexBasedOnType("PAYMENT"));
        this.financialSection.setIndex(getIndexBasedOnType("FINANCIAL"));
        this.voucherAndTicketSection.setIndex(getIndexBasedOnType("VOUCHER_AND_TICKET"));
        this.loyaltySection.setIndex(getIndexBasedOnType("LOYALTY"));
        this.identitySection.setIndex(getIndexBasedOnType("IDENTITY"));
        int i3 = PlaceComponentResult + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0022, code lost:
    
        if (r1 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x002b, code lost:
    
        if (r1 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x002d, code lost:
    
        r1 = r1.intValue();
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void loadDataFromPersistence(id.dana.domain.wallet_v3.model.WalletV3Config r14) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.loadDataFromPersistence(id.dana.domain.wallet_v3.model.WalletV3Config):void");
    }

    private final ServicesModule getServicesModule() {
        ServicesModule servicesModule = new ServicesModule(new ServicesContract.View() { // from class: id.dana.wallet_v3.view.NewWalletFragment$getServicesModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetThirdPartyServices(List<ThirdPartyService> thirdPartyServices) {
                Intrinsics.checkNotNullParameter(thirdPartyServices, "");
                NewWalletFragment.access$setFinanceServices$p(NewWalletFragment.this, thirdPartyServices);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String errorMessage) {
                NewWalletFragment.access$getDanaLoadingDialog(NewWalletFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionFailed(String message) {
                NewWalletFragment.access$getDanaLoadingDialog(NewWalletFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                NewWalletFragment.access$getDanaLoadingDialog(NewWalletFragment.this).PlaceComponentResult();
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str != null) {
                    NewWalletFragment newWalletFragment = NewWalletFragment.this;
                    if (UrlUtil.getErrorConfigVersion(str)) {
                        newWalletFragment.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                        return;
                    }
                    WalletH5ServicesImplementation walletH5ServicesImplementation = newWalletFragment.getWalletH5ServicesImplementation();
                    String authRequestContext = UrlUtil.getAuthRequestContext(str);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, null, null);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService thirdPartyService, String authCode) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                NewWalletFragment.access$getDanaLoadingDialog(NewWalletFragment.this).PlaceComponentResult();
                WalletH5ServicesImplementation walletH5ServicesImplementation = NewWalletFragment.this.getWalletH5ServicesImplementation();
                String authRequestContext = UrlUtil.getAuthRequestContext(thirdPartyService.getCallingPid);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, authCode, NewWalletFragment.this.getDeviceInformationProvider().getDeviceUUID());
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                NewWalletFragment.access$getDanaLoadingDialog(NewWalletFragment.this).PlaceComponentResult();
                ServiceMaintenanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService thirdPartyService, Map<String, String> params) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                NewWalletFragment.access$getDanaLoadingDialog(NewWalletFragment.this).PlaceComponentResult();
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str != null) {
                    NewWalletFragment.this.getFeaturePresenter().getAuthRequestContext(str, params);
                }
            }
        });
        int i = PlaceComponentResult + 67;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return servicesModule;
        }
        return servicesModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x003a, code lost:
    
        if ((r0 != 3 ? '.' : 'P') != '.') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0043, code lost:
    
        if ((r0 == 4) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0045, code lost:
    
        r12.loyaltySection.setStatus(id.dana.wallet_v3.model.SectionStatus.RELOAD);
        id.dana.wallet_v3.presenter.NewWalletContract.Presenter.CC.getLoyaltyCardAssets$default(getNewWalletPresenter(), false, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0054, code lost:
    
        fetchIdentitySection();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void refreshDataBasedOnLatestAddedAssetType() {
        /*
            r12 = this;
            java.lang.Integer r0 = r12.lastAddedAssetType
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8
            r3 = 0
            goto L9
        L8:
            r3 = 1
        L9:
            if (r3 == 0) goto Ld
            goto La6
        Ld:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 == r2) goto L17
            r3 = 1
            goto L18
        L17:
            r3 = 0
        L18:
            r4 = 0
            if (r3 == 0) goto L96
            r3 = 2
            if (r0 == r3) goto L85
            r5 = 3
            if (r0 == r5) goto L58
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r6 = r6 + 115
            int r7 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r6 = r6 % r3
            if (r6 != 0) goto L2e
            r3 = 0
            goto L2f
        L2e:
            r3 = 1
        L2f:
            if (r3 == r2) goto L3d
            r3 = 46
            if (r0 == r5) goto L38
            r0 = 46
            goto L3a
        L38:
            r0 = 80
        L3a:
            if (r0 == r3) goto L54
            goto L45
        L3d:
            r3 = 4
            if (r0 == r3) goto L42
            r0 = 0
            goto L43
        L42:
            r0 = 1
        L43:
            if (r0 == 0) goto L54
        L45:
            id.dana.wallet_v3.model.WalletSectionModel r0 = r12.loyaltySection
            id.dana.wallet_v3.model.SectionStatus r3 = id.dana.wallet_v3.model.SectionStatus.RELOAD
            r0.setStatus(r3)
            id.dana.wallet_v3.presenter.NewWalletContract$Presenter r0 = r12.getNewWalletPresenter()
            id.dana.wallet_v3.presenter.NewWalletContract.Presenter.CC.getLoyaltyCardAssets$default(r0, r1, r2, r4)
            goto La4
        L54:
            r12.fetchIdentitySection()
            goto La4
        L58:
            id.dana.wallet_v3.model.WalletSectionModel r0 = r12.voucherAndTicketSection
            id.dana.wallet_v3.model.SectionStatus r5 = id.dana.wallet_v3.model.SectionStatus.RELOAD
            r0.setStatus(r5)
            id.dana.wallet_v3.presenter.NewWalletContract$Presenter r6 = r12.getNewWalletPresenter()
            java.util.List r7 = r12.getVoucherAndTicketAssetTypes()
            java.lang.String r0 = r12.assetOrder
            if (r0 != 0) goto L6c
            r1 = 1
        L6c:
            if (r1 == 0) goto L7d
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 57
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % r3
            id.dana.domain.pocket.model.AssetStatus r0 = id.dana.domain.pocket.model.AssetStatus.EXPIRING_SOON
            java.lang.String r0 = r0.name()
        L7d:
            r8 = r0
            r9 = 0
            r10 = 4
            r11 = 0
            id.dana.wallet_v3.presenter.NewWalletContract.Presenter.CC.getVoucherAndTicketAssets$default(r6, r7, r8, r9, r10, r11)
            goto La4
        L85:
            id.dana.wallet_v3.model.WalletSectionModel r0 = r12.financialSection     // Catch: java.lang.Exception -> L94
            id.dana.wallet_v3.model.SectionStatus r3 = id.dana.wallet_v3.model.SectionStatus.RELOAD     // Catch: java.lang.Exception -> L94
            r0.setStatus(r3)     // Catch: java.lang.Exception -> L94
            id.dana.wallet_v3.presenter.NewWalletContract$Presenter r0 = r12.getNewWalletPresenter()     // Catch: java.lang.Exception -> L94
            id.dana.wallet_v3.presenter.NewWalletContract.Presenter.CC.getInvestmentCardAssets$default(r0, r1, r2, r4)     // Catch: java.lang.Exception -> L94
            goto La4
        L94:
            r0 = move-exception
            throw r0
        L96:
            id.dana.wallet_v3.model.WalletSectionModel r0 = r12.paymentSection
            id.dana.wallet_v3.model.SectionStatus r3 = id.dana.wallet_v3.model.SectionStatus.RELOAD
            r0.setStatus(r3)
            id.dana.wallet_v3.presenter.NewWalletContract$Presenter r0 = r12.getNewWalletPresenter()
            id.dana.wallet_v3.presenter.NewWalletContract.Presenter.CC.getPaymentCardAssets$default(r0, r1, r2, r4)
        La4:
            r12.lastAddedAssetType = r4
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.refreshDataBasedOnLatestAddedAssetType():void");
    }

    private final void fetchIdentitySection() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            try {
                showLoadingStateSection(this.identitySection.getIndex());
                getPersonalPresenter().checkKtpPopUp();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 == 0) {
                    return;
                }
                int i4 = 84 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void initWatcher() {
        int i = PlaceComponentResult + 105;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Subject<Boolean> subject = this.getPaymentAssetErrorWatcher;
            Boolean bool = Boolean.FALSE;
            subject.onNext(bool);
            this.getInvestmentAssetErrorWatcher.onNext(bool);
            this.getVoucherAssetErrorWatcher.onNext(bool);
            this.getLoyaltyAssetErrorWatcher.onNext(bool);
            this.getPaymentAssetWatcher.onNext(bool);
            this.getLoyaltyAssetWatcher.onNext(bool);
            this.getInvestmentAssetWatcher.onNext(bool);
            this.getVoucherAssetWatcher.onNext(bool);
            this.getPaymentAssetFromLocalEmptyWatcher.onNext(bool);
            this.getInvestmentAssetFromLocalEmptyWatcher.onNext(bool);
            this.getVoucherAssetFromLocalEmptyWatcher.onNext(bool);
            this.getLoyaltyAssetFromLocalEmptyWatcher.onNext(bool);
            this.getPaymentAssetFromLocalWatcher.onNext(bool);
            this.getInvestmentAssetFromLocalWatcher.onNext(bool);
            this.getVoucherAssetFromLocalWatcher.onNext(bool);
            this.getLoyaltyAssetFromLocalWatcher.onNext(bool);
            int i3 = PlaceComponentResult + 105;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? 'S' : '\r') != 'S') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private final Disposable getAllAssetErrorObserver() {
        Disposable subscribe = Observable.combineLatest(this.getPaymentAssetErrorWatcher, this.getInvestmentAssetErrorWatcher, this.getVoucherAssetErrorWatcher, this.getLoyaltyAssetErrorWatcher, new Function4() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda32
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                return NewWalletFragment.m3048$r8$lambda$yeUOswm3bZ_GsdSX6HhxUJmsTc((Boolean) obj, (Boolean) obj2, (Boolean) obj3, (Boolean) obj4);
            }
        }).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda34
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewWalletFragment.$r8$lambda$FstULgomsywTW3PndmPrEs4hkIg(NewWalletFragment.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        int i = PlaceComponentResult + 125;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return subscribe;
    }

    /* renamed from: getAllAssetErrorObserver$lambda-10 */
    private static final List m3051getAllAssetErrorObserver$lambda10(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(bool3, "");
        Intrinsics.checkNotNullParameter(bool4, "");
        List listOf = CollectionsKt.listOf((Object[]) new Boolean[]{bool, bool2, bool3, bool4});
        int i3 = PlaceComponentResult + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? '3' : (char) 4) != 4) {
            Object obj = null;
            obj.hashCode();
            return listOf;
        }
        return listOf;
    }

    /* renamed from: getAllAssetErrorObserver$lambda-11 */
    private static final void m3052getAllAssetErrorObserver$lambda11(NewWalletFragment newWalletFragment, List list) {
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (!newWalletFragment.isLottieShown) {
            int i = PlaceComponentResult + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            newWalletFragment.checkToShowErrorToast(list);
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
            try {
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = 28 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0095, code lost:
    
        if (r3 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0098, code lost:
    
        showGetAllAssetErrorSnackBar(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x009b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00a8, code lost:
    
        if (r7.get(0).booleanValue() != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00aa, code lost:
    
        r0 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00ac, code lost:
    
        r0 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ae, code lost:
    
        if (r0 == '\n') goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00b0, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 19;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00c3, code lost:
    
        if (r7.get(1).booleanValue() != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00cf, code lost:
    
        if (r7.get(2).booleanValue() != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00d2, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00d3, code lost:
    
        if (r3 == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00e0, code lost:
    
        if (r7.get(3).booleanValue() == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00e2, code lost:
    
        showGetAssetErrorToast();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0022, code lost:
    
        if ((r7.get(1).booleanValue() ? '5' : '/') != '5') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0035, code lost:
    
        if ((r7.get(0).booleanValue()) != true) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0038, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 123;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0041, code lost:
    
        if ((r0 % 2) == 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0043, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0045, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0046, code lost:
    
        if (r0 == true) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0052, code lost:
    
        if (r7.get(1).booleanValue() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0061, code lost:
    
        if (r7.get(1).booleanValue() == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0063, code lost:
    
        r0 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0066, code lost:
    
        r0 = 'R';
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0068, code lost:
    
        if (r0 == 'R') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0074, code lost:
    
        if (r7.get(2).booleanValue() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0080, code lost:
    
        if (r7.get(3).booleanValue() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0082, code lost:
    
        r7 = getActivity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0086, code lost:
    
        if (r7 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0088, code lost:
    
        r7 = (android.view.ViewGroup) r7.findViewById(16908290);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0091, code lost:
    
        if (r7 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0094, code lost:
    
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void checkToShowErrorToast(java.util.List<java.lang.Boolean> r7) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.checkToShowErrorToast(java.util.List):void");
    }

    private final Disposable getAllAssetFromLocalObserver() {
        Disposable subscribe = Observable.combineLatest(this.getPaymentAssetFromLocalEmptyWatcher, this.getInvestmentAssetFromLocalEmptyWatcher, this.getVoucherAssetFromLocalEmptyWatcher, this.getLoyaltyAssetFromLocalEmptyWatcher, this.getPaymentAssetFromLocalWatcher, this.getInvestmentAssetFromLocalWatcher, this.getVoucherAssetFromLocalWatcher, this.getLoyaltyAssetFromLocalWatcher, new Function8() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda35
            @Override // io.reactivex.functions.Function8
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                return NewWalletFragment.m3040$r8$lambda$SmZZZOKWOrp4YMd7DieX0gMqm0(NewWalletFragment.this, (Boolean) obj, (Boolean) obj2, (Boolean) obj3, (Boolean) obj4, (Boolean) obj5, (Boolean) obj6, (Boolean) obj7, (Boolean) obj8);
            }
        }).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda36
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewWalletFragment.$r8$lambda$zBxRbewggWPqMhQrUfQLUQ36jSU(NewWalletFragment.this, (Pair) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return subscribe;
    }

    /* renamed from: getAllAssetFromLocalObserver$lambda-13 */
    private static final Pair m3053getAllAssetFromLocalObserver$lambda13(NewWalletFragment newWalletFragment, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8) {
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(bool3, "");
        Intrinsics.checkNotNullParameter(bool4, "");
        Intrinsics.checkNotNullParameter(bool5, "");
        Intrinsics.checkNotNullParameter(bool6, "");
        Intrinsics.checkNotNullParameter(bool7, "");
        Intrinsics.checkNotNullParameter(bool8, "");
        List listOf = CollectionsKt.listOf((Object[]) new Boolean[]{bool5, bool6, bool7, bool8});
        newWalletFragment.isAssetsFromLocalEmpty = CollectionsKt.mutableListOf(bool, bool2, bool3, bool4);
        Pair pair = new Pair(listOf, newWalletFragment.isAssetsFromLocalEmpty);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return pair;
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x0091, code lost:
    
        if (r12 != null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x009d, code lost:
    
        if (r12 != null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x009f, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 41;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
        r12 = r12.shouldRecycleViewType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00ab, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x00e4, code lost:
    
        if ((r12 != null) != false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00eb, code lost:
    
        if (r12 != null) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x00ed, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x00f6, code lost:
    
        if ((r0 % 2) == 0) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x00f8, code lost:
    
        r12.playAnimation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x00fb, code lost:
    
        r8.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0101, code lost:
    
        r12.playAnimation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x01df, code lost:
    
        if (r0 != null) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x01e8, code lost:
    
        if (r0 != null) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x01ea, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
        r1 = r1 % 2;
        r8 = r0.getString(id.dana.R.string.wallet_search_bar_hint_v3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x01fa, code lost:
    
        r12.setText(r8);
     */
    /* renamed from: getAllAssetFromLocalObserver$lambda-15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m3054getAllAssetFromLocalObserver$lambda15(id.dana.wallet_v3.view.NewWalletFragment r11, kotlin.Pair r12) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.m3054getAllAssetFromLocalObserver$lambda15(id.dana.wallet_v3.view.NewWalletFragment, kotlin.Pair):void");
    }

    /* renamed from: getAllAssetFromLocalObserver$lambda-15$lambda-14 */
    private static final void m3055getAllAssetFromLocalObserver$lambda15$lambda14(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 51;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.isScrollable = true;
            newWalletFragment.isFetchDataAfterFromLocal = true;
            newWalletFragment.reloadAllData();
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            try {
                newWalletFragment.isScrollable = true;
                newWalletFragment.isFetchDataAfterFromLocal = true;
                newWalletFragment.reloadAllData();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void reloadAllData() {
        int i = PlaceComponentResult + 71;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? JSONLexer.EOI : '^') != '^') {
            try {
                try {
                    this.paymentSection.setStatus(SectionStatus.RELOAD);
                    this.financialSection.setStatus(SectionStatus.RELOAD);
                    this.voucherAndTicketSection.setStatus(SectionStatus.RELOAD);
                    this.loyaltySection.setStatus(SectionStatus.RELOAD);
                    loadData(this.walletConfig);
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            this.paymentSection.setStatus(SectionStatus.RELOAD);
            this.financialSection.setStatus(SectionStatus.RELOAD);
            this.voucherAndTicketSection.setStatus(SectionStatus.RELOAD);
            this.loyaltySection.setStatus(SectionStatus.RELOAD);
            loadData(this.walletConfig);
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0021, code lost:
    
        if (r0 != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002a, code lost:
    
        if (r4.isLottieShown != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002c, code lost:
    
        r0 = io.reactivex.Completable.KClassImpl$Data$declaredNonStaticMembers$2(java.util.concurrent.TimeUnit.SECONDS, io.reactivex.schedulers.Schedulers.MyBillsEntityDataFactory());
        r1 = io.reactivex.android.schedulers.AndroidSchedulers.PlaceComponentResult();
        io.reactivex.internal.functions.ObjectHelper.PlaceComponentResult(r1, "scheduler is null");
        r4.disposableTimeoutAllAssets = io.reactivex.plugins.RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new io.reactivex.internal.operators.completable.CompletableObserveOn(r0, r1)).KClassImpl$Data$declaredNonStaticMembers$2(new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda20());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setTimeoutAllAssetFromNetworkObserver() {
        /*
            r4 = this;
            io.reactivex.disposables.Disposable r0 = r4.disposableTimeoutAllAssets
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            if (r0 == 0) goto L54
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 19
            int r3 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L18
            goto L19
        L18:
            r1 = 0
        L19:
            if (r1 == 0) goto L28
            boolean r0 = r4.isLottieShown     // Catch: java.lang.Exception -> L26
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L54
            goto L2c
        L24:
            r0 = move-exception
            throw r0
        L26:
            r0 = move-exception
            throw r0
        L28:
            boolean r0 = r4.isLottieShown
            if (r0 == 0) goto L54
        L2c:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.MyBillsEntityDataFactory()
            io.reactivex.Completable r0 = io.reactivex.Completable.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.PlaceComponentResult()
            java.lang.String r2 = "scheduler is null"
            io.reactivex.internal.functions.ObjectHelper.PlaceComponentResult(r1, r2)
            io.reactivex.internal.operators.completable.CompletableObserveOn r2 = new io.reactivex.internal.operators.completable.CompletableObserveOn
            r2.<init>(r0, r1)
            io.reactivex.Completable r0 = io.reactivex.plugins.RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda20 r1 = new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda20
            r1.<init>()
            io.reactivex.disposables.Disposable r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2(r1)
            r4.disposableTimeoutAllAssets = r0
        L54:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L5f
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L5f
            int r0 = r0 % 2
            return
        L5f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setTimeoutAllAssetFromNetworkObserver():void");
    }

    /* renamed from: setTimeoutAllAssetFromNetworkObserver$lambda-17$lambda-16 */
    private static final void m3090setTimeoutAllAssetFromNetworkObserver$lambda17$lambda16(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.dismissLoadingSearchBar();
            newWalletFragment.isScrollable = true;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0031, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0045, code lost:
    
        if ((r0 != null ? ')' : '0') != ')') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0048, code lost:
    
        r0 = r0.shouldRecycleViewType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x004c, code lost:
    
        if (r0 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004e, code lost:
    
        r2 = 'E';
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0051, code lost:
    
        r2 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0053, code lost:
    
        if (r2 == 'W') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0055, code lost:
    
        r0.pauseAnimation();
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* renamed from: setTimeoutAllAssetFromNetworkObserver$lambda-17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m3089setTimeoutAllAssetFromNetworkObserver$lambda17(id.dana.wallet_v3.view.NewWalletFragment r3) {
        /*
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L74
            boolean r0 = r3.isLottieShown     // Catch: java.lang.Exception -> L74
            r2 = 65
            if (r0 == 0) goto L17
            goto L19
        L17:
            r1 = 65
        L19:
            if (r1 == r2) goto L73
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 121
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L36
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L62
            goto L48
        L34:
            r3 = move-exception
            throw r3
        L36:
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()     // Catch: java.lang.Exception -> L74
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0     // Catch: java.lang.Exception -> L74
            r1 = 41
            if (r0 == 0) goto L43
            r2 = 41
            goto L45
        L43:
            r2 = 48
        L45:
            if (r2 == r1) goto L48
            goto L62
        L48:
            com.airbnb.lottie.LottieAnimationView r0 = r0.shouldRecycleViewType
            r1 = 87
            if (r0 == 0) goto L51
            r2 = 69
            goto L53
        L51:
            r2 = 87
        L53:
            if (r2 == r1) goto L62
            r0.pauseAnimation()
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 9
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
        L62:
            id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda19 r0 = new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda19
            r0.<init>()
            r3.startFadeOutCardShuffle(r0)
            r3.setAllAssetToErrorState()
            r0 = 1
            r3.isFetchDataAfterFromLocal = r0
            r0 = 0
            r3.isLottieShown = r0
        L73:
            return
        L74:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.m3089setTimeoutAllAssetFromNetworkObserver$lambda17(id.dana.wallet_v3.view.NewWalletFragment):void");
    }

    private final Disposable getAllAssetFromNetworkObserver() {
        Disposable subscribe = Observable.combineLatest(this.getPaymentAssetErrorWatcher, this.getInvestmentAssetErrorWatcher, this.getVoucherAssetErrorWatcher, this.getLoyaltyAssetErrorWatcher, this.getPaymentAssetWatcher, this.getInvestmentAssetWatcher, this.getVoucherAssetWatcher, this.getLoyaltyAssetWatcher, this.sectionWatcher, new Function9() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function9
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                return NewWalletFragment.$r8$lambda$b5nNluiRXrnyqxJHSX2edneDWjw((Boolean) obj, (Boolean) obj2, (Boolean) obj3, (Boolean) obj4, (Boolean) obj5, (Boolean) obj6, (Boolean) obj7, (Boolean) obj8, (String) obj9);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewWalletFragment.m3041$r8$lambda$_XR1JdYtHkcMTfrf7ix6TGOiwQ(NewWalletFragment.this, (Triple) obj);
            }
        }, new Consumer() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewWalletFragment.$r8$lambda$M5I_pzh9eLjKC9drsBRx2YuwSh0(NewWalletFragment.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        try {
            int i = PlaceComponentResult + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return subscribe;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getAllAssetFromNetworkObserver$lambda-18 */
    private static final Triple m3056getAllAssetFromNetworkObserver$lambda18(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, String str) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(bool3, "");
        Intrinsics.checkNotNullParameter(bool4, "");
        Intrinsics.checkNotNullParameter(bool5, "");
        Intrinsics.checkNotNullParameter(bool6, "");
        Intrinsics.checkNotNullParameter(bool7, "");
        Intrinsics.checkNotNullParameter(bool8, "");
        Intrinsics.checkNotNullParameter(str, "");
        Triple triple = new Triple(CollectionsKt.listOf((Object[]) new Boolean[]{bool5, bool6, bool7, bool8}), CollectionsKt.listOf((Object[]) new Boolean[]{bool, bool2, bool3, bool4}), str);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'T' : (char) 30) != 'T') {
            return triple;
        }
        Object obj = null;
        obj.hashCode();
        return triple;
    }

    /* renamed from: getAllAssetFromNetworkObserver$lambda-20 */
    private static final void m3057getAllAssetFromNetworkObserver$lambda20(NewWalletFragment newWalletFragment, Triple triple) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            final List<Boolean> list = (List) triple.component1();
            final List list2 = (List) triple.component2();
            final String str = (String) triple.component3();
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = list.get(0);
            Intrinsics.checkNotNullExpressionValue(bool2, "");
            if ((!bool2.booleanValue() ? '`' : (char) 15) != 15) {
                Object obj = list2.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "");
                if ((!((Boolean) obj).booleanValue() ? (char) 25 : 'G') == 25) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    if (!Intrinsics.areEqual(newWalletFragment.paymentSection.getIsEnabled(), bool)) {
                        return;
                    }
                }
            }
            Boolean bool3 = list.get(1);
            Intrinsics.checkNotNullExpressionValue(bool3, "");
            if (!bool3.booleanValue()) {
                Object obj2 = list2.get(1);
                Intrinsics.checkNotNullExpressionValue(obj2, "");
                if (!((Boolean) obj2).booleanValue()) {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                    PlaceComponentResult = i5 % 128;
                    int i6 = i5 % 2;
                    if (!(Intrinsics.areEqual(newWalletFragment.financialSection.getIsEnabled(), bool))) {
                        return;
                    }
                }
            }
            Boolean bool4 = list.get(2);
            Intrinsics.checkNotNullExpressionValue(bool4, "");
            if (!(bool4.booleanValue())) {
                Object obj3 = list2.get(2);
                Intrinsics.checkNotNullExpressionValue(obj3, "");
                if ((((Boolean) obj3).booleanValue() ? false : true) && !Intrinsics.areEqual(newWalletFragment.voucherAndTicketSection.getIsEnabled(), bool)) {
                    return;
                }
            }
            Boolean bool5 = list.get(3);
            Intrinsics.checkNotNullExpressionValue(bool5, "");
            if ((!bool5.booleanValue() ? '0' : '\t') == '0') {
                Object obj4 = list2.get(3);
                Intrinsics.checkNotNullExpressionValue(obj4, "");
                if (!((Boolean) obj4).booleanValue() && !Intrinsics.areEqual(newWalletFragment.loyaltySection.getIsEnabled(), bool)) {
                    return;
                }
            }
            Disposable disposable = newWalletFragment.disposableTimeoutAllAssets;
            if (disposable != null) {
                try {
                    disposable.dispose();
                } catch (Exception e) {
                    throw e;
                }
            }
            if (!newWalletFragment.isLottieShown) {
                Intrinsics.checkNotNullExpressionValue(str, "");
                newWalletFragment.checkAnyPendingOpenDeeplink(list, str);
                return;
            }
            int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            PlaceComponentResult = i7 % 128;
            int i8 = i7 % 2;
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) newWalletFragment.getBinding();
            if (fragmentNewWalletBinding != null) {
                LottieAnimationView lottieAnimationView = fragmentNewWalletBinding.shouldRecycleViewType;
                if ((lottieAnimationView != null ? (char) 14 : 'Z') != 'Z') {
                    lottieAnimationView.pauseAnimation();
                }
            }
            newWalletFragment.setSectionState(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.$r8$lambda$n2u2xQupgw47QRQG2yL7TbEAL0w(NewWalletFragment.this, list2, list, str);
                }
            });
            newWalletFragment.isLottieShown = false;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getAllAssetFromNetworkObserver$lambda-20$lambda-19 */
    private static final void m3058getAllAssetFromNetworkObserver$lambda20$lambda19(NewWalletFragment newWalletFragment, List list, List list2, String str) {
        try {
            int i = PlaceComponentResult + 23;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(list2, "");
            Intrinsics.checkNotNullParameter(str, "");
            newWalletFragment.dismissLoadingSearchBar();
            newWalletFragment.checkToShowErrorToast(list);
            newWalletFragment.checkShouldShowTooltip();
            newWalletFragment.checkAnyPendingOpenDeeplink(list2, str);
            newWalletFragment.isScrollable = true;
            int i3 = PlaceComponentResult + 5;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? JSONLexer.EOI : 'G') != 'G') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0016, code lost:
    
        if (r2 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0025, code lost:
    
        if ((r2 == null) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0028, code lost:
    
        r2.dispose();
        r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 39;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0037, code lost:
    
        r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x003b, code lost:
    
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0041, code lost:
    
        if ((r2 % 2) == 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0043, code lost:
    
        r2 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0046, code lost:
    
        r2 = 'C';
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0048, code lost:
    
        if (r2 == 'C') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004c, code lost:
    
        r2 = 28 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0050, code lost:
    
        return;
     */
    /* renamed from: getAllAssetFromNetworkObserver$lambda-21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m3059getAllAssetFromNetworkObserver$lambda21(id.dana.wallet_v3.view.NewWalletFragment r2, java.lang.Throwable r3) {
        /*
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L53
            int r3 = r3 + 61
            int r0 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L51
            int r3 = r3 % 2
            r0 = 0
            java.lang.String r1 = ""
            if (r3 != 0) goto L1b
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            io.reactivex.disposables.Disposable r2 = r2.disposableTimeoutAllAssets
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L35
            goto L28
        L19:
            r2 = move-exception
            throw r2
        L1b:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            io.reactivex.disposables.Disposable r2 = r2.disposableTimeoutAllAssets
            if (r2 == 0) goto L24
            r3 = 0
            goto L25
        L24:
            r3 = 1
        L25:
            if (r3 == 0) goto L28
            goto L35
        L28:
            r2.dispose()
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r2 = r2 + 39
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
        L35:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L53
            int r2 = r2 + 75
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3     // Catch: java.lang.Exception -> L51
            int r2 = r2 % 2
            r3 = 67
            if (r2 == 0) goto L46
            r2 = 30
            goto L48
        L46:
            r2 = 67
        L48:
            if (r2 == r3) goto L50
            r2 = 28
            int r2 = r2 / r0
            return
        L4e:
            r2 = move-exception
            throw r2
        L50:
            return
        L51:
            r2 = move-exception
            throw r2
        L53:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.m3059getAllAssetFromNetworkObserver$lambda21(id.dana.wallet_v3.view.NewWalletFragment, java.lang.Throwable):void");
    }

    private final void setSectionState(Runnable onComplete) {
        int i = PlaceComponentResult + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 30 : (char) 2) != 30) {
            startFadeOutCardShuffle(onComplete);
            setSectionView(this.paymentSection);
            setSectionView(this.financialSection);
            setSectionView(this.loyaltySection);
            setSectionView(this.voucherAndTicketSection);
        } else {
            startFadeOutCardShuffle(onComplete);
            setSectionView(this.paymentSection);
            setSectionView(this.financialSection);
            setSectionView(this.loyaltySection);
            setSectionView(this.voucherAndTicketSection);
            int i2 = 5 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void setSectionStateAndSlideUp(Runnable onComplete) {
        int i = PlaceComponentResult + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        setSectionView(this.paymentSection);
        setSectionView(this.financialSection);
        setSectionView(this.loyaltySection);
        setSectionView(this.voucherAndTicketSection);
        startAnimateSlideUp(onComplete);
        try {
            int i3 = PlaceComponentResult + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x001a, code lost:
    
        if (r0 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x002e, code lost:
    
        if ((r0 != 1) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0030, code lost:
    
        if (r0 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0032, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0034, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0035, code lost:
    
        if (r4 == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
    
        r4 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x003d, code lost:
    
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0041, code lost:
    
        if ((r4 % 2) == 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0043, code lost:
    
        if (r0 == 4) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0046, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0047, code lost:
    
        if (r2 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x004b, code lost:
    
        if (r0 == 3) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x004d, code lost:
    
        if (r0 != 4) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x004f, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 41;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
        hideSection(r7.getIndex());
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x005f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0060, code lost:
    
        setSectionError(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0064, code lost:
    
        setSectionEmpty(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0067, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0068, code lost:
    
        setSectionSuccess(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x006b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setSectionView(id.dana.wallet_v3.model.WalletSectionModel r7) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L6e
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L6c
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1d
            id.dana.wallet_v3.model.SectionStatus r0 = r7.getStatus()
            int[] r4 = id.dana.wallet_v3.view.NewWalletFragment.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r4[r0]
            if (r0 == 0) goto L68
            goto L30
        L1d:
            id.dana.wallet_v3.model.SectionStatus r0 = r7.getStatus()
            int[] r4 = id.dana.wallet_v3.view.NewWalletFragment.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r4[r0]
            if (r0 == r3) goto L2d
            r4 = 1
            goto L2e
        L2d:
            r4 = 0
        L2e:
            if (r4 == 0) goto L68
        L30:
            if (r0 == r1) goto L34
            r4 = 1
            goto L35
        L34:
            r4 = 0
        L35:
            if (r4 == 0) goto L64
            int r4 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L6c
            int r4 = r4 + 65
            int r5 = r4 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5     // Catch: java.lang.Exception -> L6e
            int r4 = r4 % r1
            r5 = 4
            if (r4 == 0) goto L4a
            if (r0 == r5) goto L46
            goto L47
        L46:
            r2 = 1
        L47:
            if (r2 == 0) goto L4d
            goto L60
        L4a:
            r2 = 3
            if (r0 == r2) goto L60
        L4d:
            if (r0 != r5) goto L6b
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 41
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % r1
            int r7 = r7.getIndex()
            r6.hideSection(r7)
            return
        L60:
            r6.setSectionError(r7)
            return
        L64:
            r6.setSectionEmpty(r7)
            return
        L68:
            r6.setSectionSuccess(r7)
        L6b:
            return
        L6c:
            r7 = move-exception
            throw r7
        L6e:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setSectionView(id.dana.wallet_v3.model.WalletSectionModel):void");
    }

    private final void showLoadingSearchBar() {
        String str;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding != null) {
            ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding = fragmentNewWalletBinding.x;
            if ((viewWalletV3SearchStubBinding != null ? JSONLexer.EOI : '2') != 26) {
                return;
            }
            int i3 = PlaceComponentResult + 79;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            AppCompatTextView appCompatTextView = viewWalletV3SearchStubBinding.PlaceComponentResult;
            Context context = getContext();
            if (context != null) {
                int i5 = PlaceComponentResult + 55;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
                str = context.getString(R.string.wallet_search_bar_loading);
            } else {
                str = null;
            }
            appCompatTextView.setText(str);
            viewWalletV3SearchStubBinding.BuiltInFictitiousFunctionClassFactory.setClickable(false);
            ConstraintLayout constraintLayout = viewWalletV3SearchStubBinding.BuiltInFictitiousFunctionClassFactory;
            Context context2 = getContext();
            constraintLayout.setBackground((context2 != null ? '.' : ')') != ')' ? ContextCompat.PlaceComponentResult(context2, (int) R.drawable.bg_rounded_8dp_grey20) : null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0085, code lost:
    
        if ((r6 % 2) != 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0087, code lost:
    
        r6 = 'V';
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x008a, code lost:
    
        r6 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x008f, code lost:
    
        if (r6 == 'V') goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0091, code lost:
    
        r4 = androidx.core.content.ContextCompat.PlaceComponentResult(r4, (int) id.dana.R.drawable.bg_rounded_8dp_border_grey20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0096, code lost:
    
        r4 = androidx.core.content.ContextCompat.PlaceComponentResult(r4, (int) id.dana.R.drawable.bg_rounded_8dp_border_grey20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x009a, code lost:
    
        r5 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x009e, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x009f, code lost:
    
        r0.setBackground(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x001c, code lost:
    
        if (r0 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x002c, code lost:
    
        if ((r0 != null ? '/' : 'G') != 'G') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x002e, code lost:
    
        r4 = r0.PlaceComponentResult;
        r6 = getContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0036, code lost:
    
        if (r6 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0038, code lost:
    
        r8 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x003b, code lost:
    
        r8 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x003d, code lost:
    
        if (r8 == 14) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x003f, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0041, code lost:
    
        r7 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 69;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x004e, code lost:
    
        if ((r7 % 2) != 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0050, code lost:
    
        r6 = r6.getString(id.dana.R.string.wallet_search_bar_hint_v3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0056, code lost:
    
        r7 = 95 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x005a, code lost:
    
        r6 = r6.getString(id.dana.R.string.wallet_search_bar_hint_v3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x005e, code lost:
    
        r7 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 9;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0068, code lost:
    
        r4.setText(r6);
        r0.BuiltInFictitiousFunctionClassFactory.setClickable(true);
        r0 = r0.BuiltInFictitiousFunctionClassFactory;
        r4 = getContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0078, code lost:
    
        if (r4 == null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x007a, code lost:
    
        r6 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 47;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void dismissLoadingSearchBar() {
        /*
            r9 = this;
            androidx.viewbinding.ViewBinding r0 = r9.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto La2
            int r4 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r4 = r4 + 15
            int r5 = r4 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % 2
            r5 = 47
            if (r4 != 0) goto L21
            id.dana.databinding.ViewWalletV3SearchStubBinding r0 = r0.x
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto La2
            goto L2e
        L1f:
            r0 = move-exception
            throw r0
        L21:
            id.dana.databinding.ViewWalletV3SearchStubBinding r0 = r0.x
            r4 = 71
            if (r0 == 0) goto L2a
            r6 = 47
            goto L2c
        L2a:
            r6 = 71
        L2c:
            if (r6 == r4) goto La2
        L2e:
            androidx.appcompat.widget.AppCompatTextView r4 = r0.PlaceComponentResult
            android.content.Context r6 = r9.getContext()
            r7 = 14
            if (r6 == 0) goto L3b
            r8 = 14
            goto L3d
        L3b:
            r8 = 38
        L3d:
            if (r8 == r7) goto L41
            r6 = r3
            goto L68
        L41:
            int r7 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r7 = r7 + 69
            int r8 = r7 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r8
            int r7 = r7 % 2
            r8 = 2131958056(0x7f131928, float:1.9552713E38)
            if (r7 != 0) goto L5a
            java.lang.String r6 = r6.getString(r8)
            r7 = 95
            int r7 = r7 / r1
            goto L5e
        L58:
            r0 = move-exception
            throw r0
        L5a:
            java.lang.String r6 = r6.getString(r8)
        L5e:
            int r7 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r7 = r7 + 9
            int r8 = r7 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r8
            int r7 = r7 % 2
        L68:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r0.BuiltInFictitiousFunctionClassFactory
            r4.setClickable(r2)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.BuiltInFictitiousFunctionClassFactory
            android.content.Context r4 = r9.getContext()
            if (r4 == 0) goto L9e
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r6 = r6 + r5
            int r5 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r6 = r6 % 2
            r5 = 86
            if (r6 != 0) goto L8a
            r6 = 86
            goto L8c
        L8a:
            r6 = 81
        L8c:
            r7 = 2131232102(0x7f080566, float:1.8080304E38)
            if (r6 == r5) goto L96
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.PlaceComponentResult(r4, r7)
            goto L9f
        L96:
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.PlaceComponentResult(r4, r7)
            int r5 = r3.length     // Catch: java.lang.Throwable -> L9c
            goto L9f
        L9c:
            r0 = move-exception
            throw r0
        L9e:
            r4 = r3
        L9f:
            r0.setBackground(r4)
        La2:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 41
            int r4 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r0 = r0 % 2
            if (r0 != 0) goto Laf
            r1 = 1
        Laf:
            if (r1 == r2) goto Lb2
            return
        Lb2:
            int r0 = r3.length     // Catch: java.lang.Throwable -> Lb4
            return
        Lb4:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.dismissLoadingSearchBar():void");
    }

    private final void startFadeOutCardShuffle(final Runnable onComplete) {
        LottieAnimationView lottieAnimationView;
        FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
        if ((fragmentNewWalletBinding != null ? '.' : 'S') != '.') {
            return;
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        PlaceComponentResult = i % 128;
        try {
            if (i % 2 != 0) {
                lottieAnimationView = fragmentNewWalletBinding.shouldRecycleViewType;
                Object[] objArr = null;
                int length = objArr.length;
                if ((lottieAnimationView != null ? (char) 14 : (char) 1) == 1) {
                    return;
                }
            } else {
                lottieAnimationView = fragmentNewWalletBinding.shouldRecycleViewType;
                if (lottieAnimationView == null) {
                    return;
                }
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            ViewPropertyAnimator animate = lottieAnimationView.animate();
            if (animate != null) {
                animate.alpha(0.0f);
                animate.setDuration(450L);
                animate.setListener(new LottieAnimatorListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$startFadeOutCardShuffle$1$1
                    @Override // id.dana.wallet_v3.view.LottieAnimatorListener, android.animation.Animator.AnimatorListener
                    public final /* synthetic */ void onAnimationCancel(Animator animator) {
                        Intrinsics.checkNotNullParameter(animator, "");
                    }

                    @Override // id.dana.wallet_v3.view.LottieAnimatorListener, android.animation.Animator.AnimatorListener
                    public final /* synthetic */ void onAnimationRepeat(Animator animator) {
                        Intrinsics.checkNotNullParameter(animator, "");
                    }

                    @Override // id.dana.wallet_v3.view.LottieAnimatorListener, android.animation.Animator.AnimatorListener
                    public final /* synthetic */ void onAnimationStart(Animator animator) {
                        Intrinsics.checkNotNullParameter(animator, "");
                    }

                    @Override // id.dana.wallet_v3.view.LottieAnimatorListener, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        NewWalletFragment.access$startAnimateSlideUp(NewWalletFragment.this, onComplete);
                    }
                });
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0021, code lost:
    
        if (r0 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0031, code lost:
    
        if ((r0 == null) != true) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0033, code lost:
    
        r0 = r0.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0035, code lost:
    
        if (r0 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0039, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x003d, code lost:
    
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0041, code lost:
    
        if ((r1 % 2) == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0043, code lost:
    
        r0 = r0.getHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0048, code lost:
    
        r1 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004c, code lost:
    
        r0 = r0.getHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0052, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0054, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0055, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0056, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 59;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
        r0 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0061, code lost:
    
        r1 = androidx.core.view.animation.PathInterpolatorCompat.KClassImpl$Data$declaredNonStaticMembers$2(0.01f, 1.0f, 0.8f, 1.0f);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r2 = new android.view.animation.TranslateAnimation(0.0f, 0.0f, r0, 0.0f);
        r2.setDuration(450);
        r2.setFillAfter(true);
        r2.setInterpolator(r1);
        r2.setAnimationListener(new id.dana.wallet_v3.view.NewWalletFragment$startAnimateSlideUp$animateUpScrollView$1$1());
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0092, code lost:
    
        if (r7 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0094, code lost:
    
        r7 = r7.f8082a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0096, code lost:
    
        if (r7 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0098, code lost:
    
        r7.startAnimation(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x009d, code lost:
    
        r7 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 23;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00a8, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00a9, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startAnimateSlideUp(final java.lang.Runnable r7) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 94
            if (r0 != 0) goto L11
            r0 = 96
            goto L13
        L11:
            r0 = 94
        L13:
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L26
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            r2.hashCode()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L56
            goto L33
        L24:
            r7 = move-exception
            throw r7
        L26:
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            if (r0 == 0) goto L30
            r1 = 0
            goto L31
        L30:
            r1 = 1
        L31:
            if (r1 == r3) goto L56
        L33:
            android.widget.FrameLayout r0 = r0.C
            if (r0 == 0) goto L56
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L54
            int r1 = r1 + 89
            int r5 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5     // Catch: java.lang.Exception -> L52
            int r1 = r1 % 2
            if (r1 == 0) goto L4c
            int r0 = r0.getHeight()
            float r0 = (float) r0
            int r1 = r2.length     // Catch: java.lang.Throwable -> L4a
            goto L61
        L4a:
            r7 = move-exception
            throw r7
        L4c:
            int r0 = r0.getHeight()
            float r0 = (float) r0
            goto L61
        L52:
            r7 = move-exception
            goto La8
        L54:
            r7 = move-exception
            throw r7
        L56:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r0 = 0
        L61:
            r1 = 1008981770(0x3c23d70a, float:0.01)
            r2 = 1061997773(0x3f4ccccd, float:0.8)
            r5 = 1065353216(0x3f800000, float:1.0)
            android.view.animation.Interpolator r1 = androidx.core.view.animation.PathInterpolatorCompat.KClassImpl$Data$declaredNonStaticMembers$2(r1, r5, r2, r5)
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.view.animation.TranslateAnimation r2 = new android.view.animation.TranslateAnimation
            r2.<init>(r4, r4, r0, r4)
            r4 = 450(0x1c2, double:2.223E-321)
            r2.setDuration(r4)
            r2.setFillAfter(r3)
            r2.setInterpolator(r1)
            id.dana.wallet_v3.view.NewWalletFragment$startAnimateSlideUp$animateUpScrollView$1$1 r0 = new id.dana.wallet_v3.view.NewWalletFragment$startAnimateSlideUp$animateUpScrollView$1$1
            r0.<init>()
            android.view.animation.Animation$AnimationListener r0 = (android.view.animation.Animation.AnimationListener) r0
            r2.setAnimationListener(r0)
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r7 = (id.dana.databinding.FragmentNewWalletBinding) r7
            if (r7 == 0) goto La9
            androidx.core.widget.NestedScrollView r7 = r7.f8082a     // Catch: java.lang.Exception -> L52
            if (r7 == 0) goto La9
            android.view.animation.Animation r2 = (android.view.animation.Animation) r2
            r7.startAnimation(r2)
            int r7 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L52
            int r7 = r7 + 23
            int r0 = r7 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L52
            int r7 = r7 % 2
            goto La9
        La8:
            throw r7
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.startAnimateSlideUp(java.lang.Runnable):void");
    }

    private final void toggleSectionVisibility(int sectionIndex, int visibility) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        toggleSectionSkeletonVisibility(sectionIndex, visibility);
        setCardsViewVisibility(sectionIndex, visibility);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void toggleIdentitySectionVisibility(int visibility) {
        WalletSectionModel walletSectionModel;
        int i;
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        if ((this.identitySection.getIndex() < 0 ? (char) 22 : (char) 19) != 19) {
            if ((visibility == 8 ? 'G' : '=') == 'G') {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                PlaceComponentResult = i4 % 128;
                if (i4 % 2 != 0) {
                    walletSectionModel = this.identitySection;
                    i = 3;
                } else {
                    walletSectionModel = this.identitySection;
                    i = 4;
                }
                walletSectionModel.setIndex(i);
                setSpaceVisibility(this.identitySection.getIndex(), 1);
            }
        }
        toggleSectionSkeletonVisibility(this.identitySection.getIndex(), visibility);
        setCardsViewVisibility(this.identitySection.getIndex(), visibility);
    }

    private final void toggleDividerVisibility(int sectionIndex, int visibility) {
        AppCompatImageView divider = getDivider(sectionIndex);
        if ((divider != null ? 'U' : '8') != '8') {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            ViewExtKt.PlaceComponentResult(divider, visibility);
        }
        int i3 = PlaceComponentResult + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void toggleDropdownVisibility(int sectionIndex, int visibility) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        AppCompatImageView walletArrowButtonSection = getWalletArrowButtonSection(sectionIndex);
        if ((walletArrowButtonSection != null ? ';' : (char) 2) == ';') {
            ViewExtKt.PlaceComponentResult(walletArrowButtonSection, visibility);
        }
        int i3 = PlaceComponentResult + 5;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void toggleReloadVisibility(int sectionIndex, int visibility) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        AppCompatImageView walletReloadButtonSection = getWalletReloadButtonSection(sectionIndex);
        if (walletReloadButtonSection != null) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? Typography.greater : (char) 30) != 30) {
                ViewExtKt.PlaceComponentResult(walletReloadButtonSection, visibility);
                int i4 = 78 / 0;
            } else {
                try {
                    ViewExtKt.PlaceComponentResult(walletReloadButtonSection, visibility);
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        PlaceComponentResult = i5 % 128;
        if ((i5 % 2 != 0 ? 'E' : Typography.dollar) != 'E') {
            return;
        }
        int i6 = 80 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0015, code lost:
    
        if (r0 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0020, code lost:
    
        if (r0 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0022, code lost:
    
        r0 = r0.flip;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0025, code lost:
    
        if (r0 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0027, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0029, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002a, code lost:
    
        if (r3 == true) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002c, code lost:
    
        r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
        r0.setTransition(id.dana.R.id.starFromInitialEndExpand);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void transitionToExpand(final java.lang.Runnable r5) {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 15
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1a
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L3c
            goto L22
        L18:
            r5 = move-exception
            throw r5
        L1a:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            if (r0 == 0) goto L3c
        L22:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.flip
            r2 = 1
            if (r0 == 0) goto L29
            r3 = 0
            goto L2a
        L29:
            r3 = 1
        L2a:
            if (r3 == r2) goto L3c
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 117
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % 2
            r2 = 2131366504(0x7f0a1268, float:1.8352903E38)
            r0.setTransition(r2)
        L3c:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            if (r0 == 0) goto L6e
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 25
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % 2
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.flip
            if (r2 == 0) goto L5a
            r2 = 32
            int r2 = r2 / r1
            if (r0 == 0) goto L6e
            goto L5c
        L58:
            r5 = move-exception
            throw r5
        L5a:
            if (r0 == 0) goto L6e
        L5c:
            id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda6 r1 = new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda6
            r1.<init>()
            r0.transitionToEnd(r1)
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 101
            int r0 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0
            int r5 = r5 % 2
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.transitionToExpand(java.lang.Runnable):void");
    }

    /* renamed from: transitionToExpand$lambda-29 */
    private static final void m3094transitionToExpand$lambda29(Runnable runnable) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '3' : 'D') == 'D') {
            Intrinsics.checkNotNullParameter(runnable, "");
            runnable.run();
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "");
        runnable.run();
        int i2 = 76 / 0;
    }

    private final void initOnClickListener() {
        setCardClickListener();
        AppCompatImageView walletArrowButtonSection = getWalletArrowButtonSection(this.paymentSection.getIndex());
        if (walletArrowButtonSection != null) {
            walletArrowButtonSection.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda40
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewWalletFragment.$r8$lambda$bm8jIbxeO7g4GQkAKcUoGEfbk8g(NewWalletFragment.this, view);
                }
            });
        }
        AppCompatImageView walletArrowButtonSection2 = getWalletArrowButtonSection(this.loyaltySection.getIndex());
        if (walletArrowButtonSection2 != null) {
            walletArrowButtonSection2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda42
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewWalletFragment.m3046$r8$lambda$uo3_z0hntWuiGyZ0vagn2cu0A(NewWalletFragment.this, view);
                }
            });
        }
        try {
            AppCompatImageView walletArrowButtonSection3 = getWalletArrowButtonSection(this.financialSection.getIndex());
            if (walletArrowButtonSection3 != null) {
                walletArrowButtonSection3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda43
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NewWalletFragment.m3045$r8$lambda$jjFN7i8nIAVckdy7pe54UGZSII(NewWalletFragment.this, view);
                    }
                });
            }
            try {
                AppCompatImageView walletArrowButtonSection4 = getWalletArrowButtonSection(this.voucherAndTicketSection.getIndex());
                if (walletArrowButtonSection4 != null) {
                    walletArrowButtonSection4.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda44
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewWalletFragment.m3035$r8$lambda$JBmF7UI__C8iEQRm6PqF6JgDbo(NewWalletFragment.this, view);
                        }
                    });
                }
                AppCompatImageView walletArrowButtonSection5 = getWalletArrowButtonSection(this.identitySection.getIndex());
                if (walletArrowButtonSection5 != null) {
                    walletArrowButtonSection5.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda45
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewWalletFragment.m3031$r8$lambda$44wm4P2OwTlAsJ6fNrskLeabRo(NewWalletFragment.this, view);
                        }
                    });
                }
                AppCompatImageView walletReloadButtonSection = getWalletReloadButtonSection(this.paymentSection.getIndex());
                if (walletReloadButtonSection != null) {
                    walletReloadButtonSection.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewWalletFragment.$r8$lambda$WzorE6Qocvd6yo5YmXt0YxdUOlI(NewWalletFragment.this, view);
                        }
                    });
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                }
                AppCompatImageView walletReloadButtonSection2 = getWalletReloadButtonSection(this.voucherAndTicketSection.getIndex());
                if (walletReloadButtonSection2 != null) {
                    walletReloadButtonSection2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewWalletFragment.m3047$r8$lambda$w2E4Upme7mX0GKRBg1CohEJuLI(NewWalletFragment.this, view);
                        }
                    });
                }
                AppCompatImageView walletReloadButtonSection3 = getWalletReloadButtonSection(this.financialSection.getIndex());
                if (walletReloadButtonSection3 != null) {
                    walletReloadButtonSection3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewWalletFragment.$r8$lambda$Qk1R7K41NJS_f4XkC0CGYtEfyEk(NewWalletFragment.this, view);
                        }
                    });
                }
                AppCompatImageView walletReloadButtonSection4 = getWalletReloadButtonSection(this.loyaltySection.getIndex());
                if (walletReloadButtonSection4 != null) {
                    walletReloadButtonSection4.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewWalletFragment.$r8$lambda$hWoOJSJouJXIACW4lv9u9KBqcUI(NewWalletFragment.this, view);
                        }
                    });
                }
                AppCompatImageView walletReloadButtonSection5 = getWalletReloadButtonSection(this.identitySection.getIndex());
                if (walletReloadButtonSection5 != null) {
                    walletReloadButtonSection5.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewWalletFragment.$r8$lambda$YGGpeYEvXlPk8S6bXmGnFejBE4Q(NewWalletFragment.this, view);
                        }
                    });
                }
                FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding != null) {
                    ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding = fragmentNewWalletBinding.x;
                    if ((viewWalletV3SearchStubBinding != null ? 'I' : 'C') != 'C') {
                        ConstraintLayout constraintLayout = viewWalletV3SearchStubBinding.BuiltInFictitiousFunctionClassFactory;
                        if (constraintLayout != null) {
                            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda41
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    NewWalletFragment.$r8$lambda$ONtelD4Bp10ZAvtFKknc4uZXkXE(NewWalletFragment.this, view);
                                }
                            });
                            int i3 = PlaceComponentResult + 39;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                            int i4 = i3 % 2;
                        }
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: initOnClickListener$lambda-30 */
    private static final void m3060initOnClickListener$lambda30(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 27 : 'A') == 'A') {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.openWalletPaymentSection(newWalletFragment.paymentSection.getIndex());
            return;
        }
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.openWalletPaymentSection(newWalletFragment.paymentSection.getIndex());
        int i2 = 83 / 0;
    }

    /* renamed from: initOnClickListener$lambda-31 */
    private static final void m3061initOnClickListener$lambda31(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            try {
                newWalletFragment.openWalletLoyaltySection(newWalletFragment.loyaltySection.getIndex());
                int i3 = PlaceComponentResult + 29;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 == 0)) {
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

    /* renamed from: initOnClickListener$lambda-32 */
    private static final void m3062initOnClickListener$lambda32(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.openWalletFinancialSection(newWalletFragment.financialSection.getIndex());
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: initOnClickListener$lambda-33 */
    private static final void m3063initOnClickListener$lambda33(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.openWalletVoucherAndTicketSection(newWalletFragment.voucherAndTicketSection.getIndex());
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? '/' : InputCardNumberView.DIVIDER) != ' ') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: initOnClickListener$lambda-34 */
    private static final void m3064initOnClickListener$lambda34(NewWalletFragment newWalletFragment, View view) {
        int i = PlaceComponentResult + 87;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.openWalletIdentitySection(newWalletFragment.identitySection.getIndex());
        try {
            int i3 = PlaceComponentResult + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: initOnClickListener$lambda-35 */
    private static final void m3065initOnClickListener$lambda35(NewWalletFragment newWalletFragment, View view) {
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.paymentSection.setStatus(SectionStatus.RELOAD);
            newWalletFragment.reloadOrShowErrorMessage(newWalletFragment.paymentSection.getIntervalTime(), new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$initOnClickListener$6$1
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
                    NewWalletContract.Presenter.CC.getPaymentCardAssets$default(NewWalletFragment.this.getNewWalletPresenter(), false, 1, null);
                }
            });
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: initOnClickListener$lambda-36 */
    private static final void m3066initOnClickListener$lambda36(NewWalletFragment newWalletFragment, View view) {
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.voucherAndTicketSection.setStatus(SectionStatus.RELOAD);
        newWalletFragment.reloadOrShowErrorMessage(newWalletFragment.voucherAndTicketSection.getIntervalTime(), new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$initOnClickListener$7$1
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
                NewWalletContract.Presenter.CC.getVoucherAndTicketOrder$default(NewWalletFragment.this.getNewWalletPresenter(), NewWalletFragment.access$getVoucherAndTicketAssetTypes(NewWalletFragment.this), false, 2, null);
            }
        });
        try {
            int i = PlaceComponentResult + 103;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: initOnClickListener$lambda-37 */
    private static final void m3067initOnClickListener$lambda37(NewWalletFragment newWalletFragment, View view) {
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.financialSection.setStatus(SectionStatus.RELOAD);
        newWalletFragment.reloadOrShowErrorMessage(newWalletFragment.financialSection.getIntervalTime(), new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$initOnClickListener$8$1
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
                NewWalletContract.Presenter.CC.getInvestmentCardAssets$default(NewWalletFragment.this.getNewWalletPresenter(), false, 1, null);
            }
        });
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? ')' : '2') != '2') {
            int i2 = 39 / 0;
        }
    }

    /* renamed from: initOnClickListener$lambda-38 */
    private static final void m3068initOnClickListener$lambda38(NewWalletFragment newWalletFragment, View view) {
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            try {
                newWalletFragment.loyaltySection.setStatus(SectionStatus.RELOAD);
                newWalletFragment.reloadOrShowErrorMessage(newWalletFragment.loyaltySection.getIntervalTime(), new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$initOnClickListener$9$1
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
                        NewWalletContract.Presenter.CC.getLoyaltyCardAssets$default(NewWalletFragment.this.getNewWalletPresenter(), false, 1, null);
                    }
                });
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
                PlaceComponentResult = i % 128;
                if ((i % 2 != 0 ? '%' : (char) 0) != '%') {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: initOnClickListener$lambda-39 */
    private static final void m3069initOnClickListener$lambda39(NewWalletFragment newWalletFragment, View view) {
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.reloadOrShowErrorMessage(newWalletFragment.identitySection.getIntervalTime(), new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$initOnClickListener$10$1
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
                NewWalletFragment.access$fetchIdentitySection(NewWalletFragment.this);
            }
        });
        int i = PlaceComponentResult + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    /* renamed from: initOnClickListener$lambda-40 */
    private static final void m3070initOnClickListener$lambda40(NewWalletFragment newWalletFragment, View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? ',' : '8') != ',') {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.navigateToGlobalSearch();
            return;
        }
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.navigateToGlobalSearch();
        Object obj = null;
        obj.hashCode();
    }

    private final void setCardClickListener() {
        try {
            int i = PlaceComponentResult + 43;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            WalletCardFactory walletCardFactory = WalletCardFactory.INSTANCE;
            walletCardFactory.setCountDownPublishSubject(walletCardFactory.getCountDownPublishSubject$app_productionRelease());
            walletCardFactory.setCountUpPublishSubject(walletCardFactory.getCountUpPublishSubject$app_productionRelease());
            walletCardFactory.setWalletCardAssetClickListener(getWalletCardAssetClickListener());
            walletCardFactory.setDanaBalanceClickListener(getDanaBalanceClickListener());
            int i3 = PlaceComponentResult + 11;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void reloadOrShowErrorMessage(long intervalTime, Function0<Unit> action) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if ((isReloadWithinIntervalTime(intervalTime) ? '0' : '*') == '0') {
            action.invoke();
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        showGetAssetErrorToast();
    }

    private final boolean isReloadWithinIntervalTime(long intervalTime) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            if ((System.currentTimeMillis() > intervalTime ? (char) 18 : 'O') != 'O') {
                return true;
            }
            int i3 = PlaceComponentResult + 5;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0020, code lost:
    
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x002e, code lost:
    
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0030, code lost:
    
        r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 119;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
        r3 = r3 % 2;
        r0.hideTabBarMenu();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void openWalletIdentitySection(int r6) {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = "IDENTITY"
            if (r0 == r2) goto L25
            id.dana.wallet_v3.tracker.WalletV3TrackerImpl r0 = r5.getWalletV3TrackerImplementation()
            r0.trackSectionExpanded(r3)
            id.dana.wallet_v3.listener.WalletTabListener r0 = r5.walletTabListener
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L3d
            goto L30
        L23:
            r6 = move-exception
            throw r6
        L25:
            id.dana.wallet_v3.tracker.WalletV3TrackerImpl r0 = r5.getWalletV3TrackerImplementation()
            r0.trackSectionExpanded(r3)
            id.dana.wallet_v3.listener.WalletTabListener r0 = r5.walletTabListener
            if (r0 == 0) goto L3d
        L30:
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r3 = r3 + 119
            int r4 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % 2
            r0.hideTabBarMenu()
        L3d:
            id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda28 r0 = new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda28
            r0.<init>()
            r5.transitionToExpand(r0)
            r5.setSelectedSection(r6)
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()     // Catch: java.lang.Exception -> L89
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0     // Catch: java.lang.Exception -> L87
            if (r0 == 0) goto L5e
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.Y
            if (r0 == 0) goto L55
            r1 = 1
        L55:
            if (r1 == 0) goto L5e
            int r6 = r5.getTransition(r6)
            r0.setTransition(r6)
        L5e:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r6 = (id.dana.databinding.FragmentNewWalletBinding) r6
            if (r6 == 0) goto L86
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L87
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L87
            int r0 = r0 % 2
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r6.Y     // Catch: java.lang.Exception -> L89
            if (r6 == 0) goto L86
            id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda29 r0 = new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda29
            r0.<init>()
            r6.transitionToEnd(r0)
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 19
            int r0 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0
            int r6 = r6 % 2
        L86:
            return
        L87:
            r6 = move-exception
            throw r6
        L89:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.openWalletIdentitySection(int):void");
    }

    /* renamed from: openWalletIdentitySection$lambda-43 */
    private static final void m3082openWalletIdentitySection$lambda43(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'Q' : '6') == 'Q') {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            saveSectionTooltipShown$default(newWalletFragment, "IDENTITY", true, 3, null);
        } else {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            saveSectionTooltipShown$default(newWalletFragment, "IDENTITY", false, 2, null);
        }
        newWalletFragment.setExpandedLayoutHeight();
        newWalletFragment.openWalletIdentityFragment();
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void openWalletIdentityFragment() {
        List<WalletV3CardModel> assets = this.identitySection.getAssets();
        Object[] objArr = null;
        if (assets != null) {
            int i = PlaceComponentResult + 73;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 == 0) {
                try {
                    openNewFragment(IdentityWalletDetailFragment.INSTANCE.newInstance(assets), "IdentityWalletDetailFragment");
                    objArr.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                openNewFragment(IdentityWalletDetailFragment.INSTANCE.newInstance(assets), "IdentityWalletDetailFragment");
            }
        }
        int i2 = PlaceComponentResult + 121;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int length = objArr.length;
        }
    }

    private final void openWalletLoyaltySection(int loyaltySectionIndex) {
        MotionLayout motionLayout;
        MotionLayout motionLayout2;
        try {
            getNewWalletPresenter().updateTotalSectionQuery(4, true);
            getWalletV3TrackerImplementation().trackSectionExpanded("LOYALTY");
            WalletTabListener walletTabListener = this.walletTabListener;
            Object[] objArr = null;
            if ((walletTabListener != null ? (char) 21 : '(') != '(') {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
                PlaceComponentResult = i % 128;
                if (!(i % 2 != 0)) {
                    walletTabListener.hideTabBarMenu();
                } else {
                    walletTabListener.hideTabBarMenu();
                    int length = objArr.length;
                }
                int i2 = PlaceComponentResult + 43;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
            }
            setSelectedSection(loyaltySectionIndex);
            transitionToExpand(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.m3033$r8$lambda$Fa_AuHPZCkDVcRouVZIxTn8UeQ();
                }
            });
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding != null) {
                MotionLayout motionLayout3 = fragmentNewWalletBinding.Y;
                if (motionLayout3 != null) {
                    motionLayout3.setTransition(getTransition(loyaltySectionIndex));
                }
            }
            FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
            if ((fragmentNewWalletBinding2 != null ? (char) 11 : '!') == 11 && (motionLayout2 = fragmentNewWalletBinding2.Y) != null) {
                motionLayout2.setTransitionListener(new NewWalletFragment$openWalletLoyaltySection$2(this));
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                PlaceComponentResult = i4 % 128;
                int i5 = i4 % 2;
            }
            FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding3 != null) {
                int i6 = PlaceComponentResult + 49;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                if (i6 % 2 == 0) {
                    motionLayout = fragmentNewWalletBinding3.Y;
                    objArr.hashCode();
                    if (motionLayout == null) {
                        return;
                    }
                } else {
                    motionLayout = fragmentNewWalletBinding3.Y;
                    if (motionLayout == null) {
                        return;
                    }
                }
                motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewWalletFragment.$r8$lambda$JzvmLbQsL70lZU2UlrQrPPzKWc4(NewWalletFragment.this);
                    }
                });
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: openWalletLoyaltySection$lambda-46 */
    private static final void m3084openWalletLoyaltySection$lambda46(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 115;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        Object[] objArr = null;
        saveSectionTooltipShown$default(newWalletFragment, "LOYALTY", false, 2, null);
        newWalletFragment.openWalletLoyaltyFragment();
        int i3 = PlaceComponentResult + 3;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? Typography.less : '\r') != '<') {
            return;
        }
        int length = objArr.length;
    }

    private final void openWalletLoyaltyFragment() {
        try {
            int i = PlaceComponentResult + 39;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                List<WalletV3CardModel> assets = this.loyaltySection.getAssets();
                if (!(assets != null)) {
                    return;
                }
                int i3 = PlaceComponentResult + 7;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                openNewFragment(LoyaltyWalletDetailFragment.INSTANCE.newInstance(assets, this.kycLevel, this.accessToken), "LoyaltyWalletDetailFragment");
                int i5 = PlaceComponentResult + 91;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void openWalletFinancialSection(int financialSectionIndex) {
        MotionLayout motionLayout;
        try {
            getNewWalletPresenter().updateTotalSectionQuery(2, true);
            getWalletV3TrackerImplementation().trackSectionExpanded("FINANCIAL");
            WalletTabListener walletTabListener = this.walletTabListener;
            if (walletTabListener != null) {
                walletTabListener.hideTabBarMenu();
            }
            setSelectedSection(financialSectionIndex);
            transitionToExpand(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.m3039$r8$lambda$PrZkJZnqZvn0Zfr9uXwSmRdtjE();
                }
            });
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding != null) {
                MotionLayout motionLayout2 = fragmentNewWalletBinding.Y;
                if (motionLayout2 != null) {
                    int i = PlaceComponentResult + 115;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    motionLayout2.setTransition(getTransition(financialSectionIndex));
                }
            }
            try {
                FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding2 != null && (motionLayout = fragmentNewWalletBinding2.Y) != null) {
                    motionLayout.setTransitionListener(new NewWalletFragment$openWalletFinancialSection$2(this));
                }
                FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding3 != null) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    MotionLayout motionLayout3 = fragmentNewWalletBinding3.Y;
                    if (motionLayout3 != null) {
                        motionLayout3.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda15
                            @Override // java.lang.Runnable
                            public final void run() {
                                NewWalletFragment.$r8$lambda$JJWG9PHu951aw3KNd5bzStF7yWo(NewWalletFragment.this);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: openWalletFinancialSection$lambda-49 */
    private static final void m3080openWalletFinancialSection$lambda49(NewWalletFragment newWalletFragment) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            saveSectionTooltipShown$default(newWalletFragment, "FINANCIAL", false, 3, null);
            newWalletFragment.openWalletFinancialFragment();
        } else {
            try {
                Intrinsics.checkNotNullParameter(newWalletFragment, "");
                try {
                    saveSectionTooltipShown$default(newWalletFragment, "FINANCIAL", false, 2, null);
                    newWalletFragment.openWalletFinancialFragment();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 19 : '8') != '8') {
            int length = objArr.length;
        }
    }

    private final void openWalletFinancialFragment() {
        List<WalletV3CardModel> assets = this.financialSection.getAssets();
        if ((assets != null ? 'Y' : '2') != '2') {
            try {
                int i = PlaceComponentResult + 121;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 == 0 ? (char) 16 : 'a') != 'a') {
                    openNewFragment(InvestmentWalletDetailFragment.INSTANCE.newInstance(assets), "InvestmentWalletDetailFragment");
                    int i2 = 40 / 0;
                } else {
                    openNewFragment(InvestmentWalletDetailFragment.INSTANCE.newInstance(assets), "InvestmentWalletDetailFragment");
                }
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void openWalletVoucherAndTicketSection(int voucherAndTicketSectionIndex) {
        MotionLayout motionLayout;
        getNewWalletPresenter().updateTotalSectionQuery(3, true);
        getWalletV3TrackerImplementation().trackSectionExpanded("VOUCHER_AND_TICKET");
        WalletTabListener walletTabListener = this.walletTabListener;
        if (walletTabListener != null) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
            PlaceComponentResult = i % 128;
            if (i % 2 != 0) {
                walletTabListener.hideTabBarMenu();
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                walletTabListener.hideTabBarMenu();
            }
        }
        setSelectedSection(voucherAndTicketSectionIndex);
        transitionToExpand(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                NewWalletFragment.m3037$r8$lambda$OKfa7NDK_6liU50v8BNsbXJzhk();
            }
        });
        FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
        if ((fragmentNewWalletBinding != null ? '\n' : 'Q') == '\n') {
            MotionLayout motionLayout2 = fragmentNewWalletBinding.Y;
            if (motionLayout2 != null) {
                motionLayout2.setTransition(getTransition(voucherAndTicketSectionIndex));
                int i2 = PlaceComponentResult + 63;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
            }
        }
        try {
            FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
            if (!(fragmentNewWalletBinding2 == null)) {
                MotionLayout motionLayout3 = fragmentNewWalletBinding2.Y;
                if (motionLayout3 != null) {
                    motionLayout3.setTransitionListener(new NewWalletFragment$openWalletVoucherAndTicketSection$2(this));
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                }
            }
            FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding3 == null || (motionLayout = fragmentNewWalletBinding3.Y) == null) {
                return;
            }
            motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.m3044$r8$lambda$eFZUiwtFJvNBkvasLMj2tWN93w(NewWalletFragment.this);
                }
            });
            try {
                int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                PlaceComponentResult = i6 % 128;
                int i7 = i6 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:48:0x0032
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    /* renamed from: openWalletVoucherAndTicketSection$lambda-52 */
    private static final void m3088openWalletVoucherAndTicketSection$lambda52(id.dana.wallet_v3.view.NewWalletFragment r4) {
        /*
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 103
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch: java.lang.Exception -> L30
            java.lang.String r0 = "VOUCHER_AND_TICKET"
            r2 = 0
            r3 = 0
            saveSectionTooltipShown$default(r4, r0, r3, r1, r2)     // Catch: java.lang.Exception -> L30
            r4.openWalletVoucherAndTicketFragment()     // Catch: java.lang.Exception -> L30
            int r4 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r4 = r4 + 81
            int r0 = r4 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r4 = r4 % r1
            if (r4 != 0) goto L26
            r4 = 1
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 == 0) goto L2f
            r4 = 74
            int r4 = r4 / r3
            return
        L2d:
            r4 = move-exception
            throw r4
        L2f:
            return
        L30:
            r4 = move-exception
            throw r4
        L32:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.m3088openWalletVoucherAndTicketSection$lambda52(id.dana.wallet_v3.view.NewWalletFragment):void");
    }

    private final void openWalletVoucherAndTicketFragment() {
        int i;
        List<WalletV3CardModel> assets = this.voucherAndTicketSection.getAssets();
        if (assets == null) {
            return;
        }
        VouchersAndTicketsDetailFragment.Companion companion = VouchersAndTicketsDetailFragment.INSTANCE;
        List<String> voucherAndTicketAssetTypes = getVoucherAndTicketAssetTypes();
        WalletV3Config walletV3Config = this.walletConfig;
        try {
            try {
                if (walletV3Config != null) {
                    int i2 = PlaceComponentResult + 121;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                    int i3 = i2 % 2;
                    Integer danaDealsVersion = walletV3Config.getDanaDealsVersion();
                    if ((danaDealsVersion != null ? 'A' : 'Z') != 'Z') {
                        int intValue = danaDealsVersion.intValue();
                        int i4 = PlaceComponentResult + 99;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                        int i5 = i4 % 2;
                        i = intValue;
                        openNewFragment(companion.newInstance(assets, true, false, voucherAndTicketAssetTypes, i), "VoucherWalletDetailFragment");
                        return;
                    }
                }
                openNewFragment(companion.newInstance(assets, true, false, voucherAndTicketAssetTypes, i), "VoucherWalletDetailFragment");
                return;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
        i = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0081, code lost:
    
        if (r5 != null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0089, code lost:
    
        if (r5 != null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x008b, code lost:
    
        requestNewSize(r5, r2.intValue(), r0.intValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x009a, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x003f, code lost:
    
        if ((r2 == null) != true) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0046, code lost:
    
        if (r2 != null) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0048, code lost:
    
        r2 = java.lang.Integer.valueOf(r2.getWidth());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setFullyExpanded() {
        /*
            r8 = this;
            androidx.viewbinding.ViewBinding r0 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            r1 = 0
            if (r0 == 0) goto L16
            androidx.core.widget.NestedScrollView r0 = r0.f8082a
            if (r0 == 0) goto L16
            int r0 = r0.getHeight()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L21
        L16:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 67
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2
            int r0 = r0 % 2
            r0 = r1
        L21:
            androidx.viewbinding.ViewBinding r2 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r2 = (id.dana.databinding.FragmentNewWalletBinding) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L53
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 79
            int r6 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L44
            androidx.core.widget.NestedScrollView r2 = r2.f8082a
            int r5 = r1.length     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L3e
            r5 = 0
            goto L3f
        L3e:
            r5 = 1
        L3f:
            if (r5 == r4) goto L53
            goto L48
        L42:
            r0 = move-exception
            throw r0
        L44:
            androidx.core.widget.NestedScrollView r2 = r2.f8082a
            if (r2 == 0) goto L53
        L48:
            int r2 = r2.getWidth()     // Catch: java.lang.Exception -> L51
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L51
            goto L54
        L51:
            r0 = move-exception
            goto La5
        L53:
            r2 = r1
        L54:
            if (r0 == 0) goto La6
            r5 = 21
            if (r2 == 0) goto L5d
            r6 = 21
            goto L5f
        L5d:
            r6 = 36
        L5f:
            if (r6 == r5) goto L62
            goto La6
        L62:
            androidx.viewbinding.ViewBinding r5 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r5 = (id.dana.databinding.FragmentNewWalletBinding) r5
            if (r5 == 0) goto La6
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L51
            int r6 = r6 + 123
            int r7 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r7     // Catch: java.lang.Exception -> L51
            int r6 = r6 % 2
            r7 = 95
            if (r6 == 0) goto L7b
            r6 = 95
            goto L7d
        L7b:
            r6 = 52
        L7d:
            if (r6 == r7) goto L84
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r5.Y
            if (r5 == 0) goto La6
            goto L8b
        L84:
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r5.Y
            r1.hashCode()     // Catch: java.lang.Throwable -> La3
            if (r5 == 0) goto La6
        L8b:
            android.view.View r5 = (android.view.View) r5
            int r2 = r2.intValue()
            int r0 = r0.intValue()
            r8.requestNewSize(r5, r2, r0)
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L51
            int r0 = r0 + 51
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2
            int r0 = r0 % 2
            goto La6
        La3:
            r0 = move-exception
            throw r0
        La5:
            throw r0
        La6:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 91
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
            if (r0 != 0) goto Lb3
            r3 = 1
        Lb3:
            if (r3 == 0) goto Lbb
            r1.hashCode()     // Catch: java.lang.Throwable -> Lb9
            return
        Lb9:
            r0 = move-exception
            throw r0
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setFullyExpanded():void");
    }

    private final void openWalletPaymentSection(int paymentSectionIndex) {
        MotionLayout motionLayout;
        try {
            try {
                getWalletV3TrackerImplementation().trackSectionExpanded("PAYMENT");
                WalletTabListener walletTabListener = this.walletTabListener;
                if (walletTabListener != null) {
                    walletTabListener.hideTabBarMenu();
                    int i = PlaceComponentResult + 85;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                }
                transitionToExpand(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewWalletFragment.$r8$lambda$qY3RxZUkpsra42rpWaZCGi_vwkA();
                    }
                });
                setSelectedSection(paymentSectionIndex);
                FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding != null) {
                    int i3 = PlaceComponentResult + 93;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    MotionLayout motionLayout2 = fragmentNewWalletBinding.Y;
                    if (motionLayout2 != null) {
                        motionLayout2.setTransition(getTransition(paymentSectionIndex));
                    }
                }
                FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding2 != null) {
                    MotionLayout motionLayout3 = fragmentNewWalletBinding2.Y;
                    if (motionLayout3 != null) {
                        motionLayout3.setTransitionListener(new WalletTransitionListener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$openWalletPaymentSection$2
                            @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final /* synthetic */ void onTransitionChange(MotionLayout motionLayout4, int i5, int i6, float f) {
                                WalletTransitionListener.CC.$default$onTransitionChange(this, motionLayout4, i5, i6, f);
                            }

                            @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final /* synthetic */ void onTransitionCompleted(MotionLayout motionLayout4, int i5) {
                                WalletTransitionListener.CC.$default$onTransitionCompleted(this, motionLayout4, i5);
                            }

                            @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final /* synthetic */ void onTransitionTrigger(MotionLayout motionLayout4, int i5, boolean z, float f) {
                                WalletTransitionListener.CC.$default$onTransitionTrigger(this, motionLayout4, i5, z, f);
                            }

                            @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final void onTransitionStarted(MotionLayout motionLayout4, int startId, int endId) {
                                NewWalletFragment.access$setExpandedLayoutHeight(NewWalletFragment.this);
                            }
                        });
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                        PlaceComponentResult = i5 % 128;
                        int i6 = i5 % 2;
                    }
                }
                FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
                if ((fragmentNewWalletBinding3 == null) || (motionLayout = fragmentNewWalletBinding3.Y) == null) {
                    return;
                }
                motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewWalletFragment.$r8$lambda$DrePuw08RFs_SMhxdprWUMGVw0U(NewWalletFragment.this);
                    }
                });
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: openWalletPaymentSection$lambda-55 */
    private static final void m3086openWalletPaymentSection$lambda55(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            saveSectionTooltipShown$default(newWalletFragment, "PAYMENT", true, 3, null);
            newWalletFragment.openWalletPaymentFragment();
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            try {
                saveSectionTooltipShown$default(newWalletFragment, "PAYMENT", false, 2, null);
                newWalletFragment.openWalletPaymentFragment();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void openWalletPaymentFragment() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            List<WalletV3CardModel> assets = this.paymentSection.getAssets();
            Object[] objArr = null;
            if ((assets != null ? InputCardNumberView.DIVIDER : Typography.less) != '<') {
                int i3 = PlaceComponentResult + 19;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (i3 % 2 == 0) {
                    openNewFragment(PaymentWalletDetailFragment.INSTANCE.newInstance(assets), "PaymentWalletDetailFragment");
                    int length = objArr.length;
                } else {
                    try {
                        openNewFragment(PaymentWalletDetailFragment.INSTANCE.newInstance(assets), "PaymentWalletDetailFragment");
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            int i4 = PlaceComponentResult + 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if ((i4 % 2 == 0 ? 'J' : ']') != 'J') {
                return;
            }
            int length2 = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void openWalletSection(String sectionType) {
        try {
            switch (sectionType.hashCode()) {
                case -786681338:
                    if (sectionType.equals("payment")) {
                        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
                        PlaceComponentResult = i % 128;
                        if (i % 2 == 0) {
                            openWalletPaymentSection(this.paymentSection.getIndex());
                        } else {
                            openWalletPaymentSection(this.paymentSection.getIndex());
                            Object[] objArr = null;
                            int length = objArr.length;
                        }
                    }
                    setArguments(new Bundle());
                    this.section = "";
                    this.sectionWatcher.onNext("");
                    return;
                case -135761730:
                    if (!(sectionType.equals("identity") ? false : true)) {
                        openWalletIdentitySection(this.identitySection.getIndex());
                    }
                    setArguments(new Bundle());
                    this.section = "";
                    this.sectionWatcher.onNext("");
                    return;
                case 357555337:
                    if ((sectionType.equals("financial") ? '\b' : Typography.dollar) != '$') {
                        openWalletFinancialSection(this.financialSection.getIndex());
                        int i2 = PlaceComponentResult + 37;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                        int i3 = i2 % 2;
                    }
                    setArguments(new Bundle());
                    this.section = "";
                    this.sectionWatcher.onNext("");
                    return;
                case 358728774:
                    if (sectionType.equals("loyalty")) {
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        try {
                            openWalletLoyaltySection(this.loyaltySection.getIndex());
                            int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                            PlaceComponentResult = i6 % 128;
                            int i7 = i6 % 2;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    setArguments(new Bundle());
                    this.section = "";
                    this.sectionWatcher.onNext("");
                    return;
                case 1018752165:
                    if ((sectionType.equals("voucher_and_ticket") ? (char) 29 : '?') == 29) {
                        openWalletVoucherAndTicketSection(this.voucherAndTicketSection.getIndex());
                        int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
                        PlaceComponentResult = i8 % 128;
                        int i9 = i8 % 2;
                    }
                    setArguments(new Bundle());
                    this.section = "";
                    this.sectionWatcher.onNext("");
                    return;
                default:
                    setArguments(new Bundle());
                    this.section = "";
                    this.sectionWatcher.onNext("");
                    return;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void navigateToGlobalSearch() {
        FragmentNewWalletBinding fragmentNewWalletBinding;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            Object[] objArr = null;
            int length = objArr.length;
            if (!(fragmentNewWalletBinding != null)) {
                return;
            }
        } else {
            fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if ((fragmentNewWalletBinding != null ? '7' : '8') != '7') {
                return;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        MotionLayout motionLayout = fragmentNewWalletBinding.flip;
        if (motionLayout != null) {
            motionLayout.setTransition(R.id.expand_to_search);
            motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.m3043$r8$lambda$drvo_AQB87Zo8cyw3TfPXqiy0c(NewWalletFragment.this);
                }
            });
        }
    }

    /* renamed from: navigateToGlobalSearch$lambda-57 */
    private static final void m3074navigateToGlobalSearch$lambda57(NewWalletFragment newWalletFragment) {
        int i = PlaceComponentResult + 37;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        WalletTabListener walletTabListener = newWalletFragment.walletTabListener;
        if (walletTabListener != null) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            walletTabListener.hideTabBarMenu();
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
        }
        WalletIntentFactory walletIntentFactory = WalletIntentFactory.INSTANCE;
        NewWalletFragment newWalletFragment2 = newWalletFragment;
        WalletSearchFragment.Companion companion = WalletSearchFragment.INSTANCE;
        Context context = newWalletFragment.getContext();
        Object[] objArr = null;
        walletIntentFactory.openNewFragmentWithAnimation(newWalletFragment2, companion.newInstance("general", (context != null ? (char) 16 : '7') != '7' ? context.getString(R.string.wallet_search_bar_hint_v3) : null, newWalletFragment.accessToken, newWalletFragment.kycLevel));
        int i7 = PlaceComponentResult + 21;
        KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
        if (i7 % 2 == 0) {
            int length = objArr.length;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setSelectedSection(int r8) {
        /*
            r7 = this;
            r7.selectedIndex = r8     // Catch: java.lang.Exception -> L87
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()     // Catch: java.lang.Exception -> L87
            id.dana.databinding.FragmentNewWalletBinding r8 = (id.dana.databinding.FragmentNewWalletBinding) r8     // Catch: java.lang.Exception -> L87
            r0 = 0
            if (r8 == 0) goto L18
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r8.Y
            if (r8 == 0) goto L18
            int r8 = r8.getHeight()     // Catch: java.lang.Exception -> L87
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L19
        L18:
            r8 = r0
        L19:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.intValue()
            r7.defaultHeight = r8
            r8 = 2
            java.lang.Integer[] r1 = new java.lang.Integer[r8]
            androidx.viewbinding.ViewBinding r2 = r7.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r2 = (id.dana.databinding.FragmentNewWalletBinding) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L31
            r5 = 0
            goto L32
        L31:
            r5 = 1
        L32:
            if (r5 == r4) goto L43
            androidx.core.widget.NestedScrollView r2 = r2.f8082a     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L43
            int r2 = r2.getScrollX()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L4d
        L41:
            r8 = move-exception
            throw r8
        L43:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 97
            int r5 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5
            int r2 = r2 % r8
            r2 = r0
        L4d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r1[r3] = r2
            androidx.viewbinding.ViewBinding r2 = r7.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r2 = (id.dana.databinding.FragmentNewWalletBinding) r2
            r5 = 83
            if (r2 == 0) goto L5f
            r6 = 83
            goto L60
        L5f:
            r6 = 7
        L60:
            if (r6 == r5) goto L63
            goto L7d
        L63:
            androidx.core.widget.NestedScrollView r2 = r2.f8082a
            if (r2 == 0) goto L68
            goto L69
        L68:
            r3 = 1
        L69:
            if (r3 == 0) goto L6c
            goto L7d
        L6c:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 99
            int r3 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r0 = r0 % r8
            int r8 = r2.getScrollY()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
        L7d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1[r4] = r0
            r7.scrollPosition = r1
            r7.isOpenDetail = r4
            return
        L87:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setSelectedSection(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0099, code lost:
    
        if (r2 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00a0, code lost:
    
        if (r2 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00a2, code lost:
    
        r3 = java.lang.Integer.valueOf(r2.getWidth());
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00aa, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 11;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
        r1 = r1 % 2;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x00b5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00b6, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0016, code lost:
    
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0021, code lost:
    
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0023, code lost:
    
        r0 = r0.f8082a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0025, code lost:
    
        if (r0 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0027, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0029, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x002a, code lost:
    
        if (r4 == true) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x002d, code lost:
    
        r4 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r4 % 128;
        r4 = r4 % 2;
        r0.fullScroll(33);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setExpandedLayoutHeight() {
        /*
            r8 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L1b
            androidx.viewbinding.ViewBinding r0 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            int r4 = r3.length     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L3c
            goto L23
        L19:
            r0 = move-exception
            throw r0
        L1b:
            androidx.viewbinding.ViewBinding r0 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            if (r0 == 0) goto L3c
        L23:
            androidx.core.widget.NestedScrollView r0 = r0.f8082a
            if (r0 == 0) goto L29
            r4 = 1
            goto L2a
        L29:
            r4 = 0
        L2a:
            if (r4 == r2) goto L2d
            goto L3c
        L2d:
            int r4 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 25
            int r5 = r4 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5
            int r4 = r4 % 2
            r4 = 33
            r0.fullScroll(r4)
        L3c:
            androidx.viewbinding.ViewBinding r0 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            if (r0 == 0) goto L47
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.Y
            goto L48
        L47:
            r0 = r3
        L48:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r4 = "mEndWrapHeight"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)
            r0.setAccessible(r2)
            androidx.viewbinding.ViewBinding r4 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r4 = (id.dana.databinding.FragmentNewWalletBinding) r4
            if (r4 == 0) goto L63
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r4.Y
            goto L64
        L63:
            r4 = r3
        L64:
            int r0 = r0.getInt(r4)
            androidx.viewbinding.ViewBinding r4 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r4 = (id.dana.databinding.FragmentNewWalletBinding) r4
            if (r4 == 0) goto L72
            r5 = 0
            goto L73
        L72:
            r5 = 1
        L73:
            if (r5 == 0) goto L76
            goto Lc3
        L76:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r4.Y
            if (r4 == 0) goto Lc3
            android.view.View r4 = (android.view.View) r4
            androidx.viewbinding.ViewBinding r5 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r5 = (id.dana.databinding.FragmentNewWalletBinding) r5
            if (r5 == 0) goto Lb9
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r6 = r6 + 93
            int r7 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L91
            goto L92
        L91:
            r2 = 0
        L92:
            if (r2 == 0) goto L9e
            androidx.constraintlayout.motion.widget.MotionLayout r2 = r5.Y
            r5 = 83
            int r5 = r5 / r1
            if (r2 == 0) goto Lb9
            goto La2
        L9c:
            r0 = move-exception
            throw r0
        L9e:
            androidx.constraintlayout.motion.widget.MotionLayout r2 = r5.Y     // Catch: java.lang.Exception -> Lb7
            if (r2 == 0) goto Lb9
        La2:
            int r1 = r2.getWidth()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Lb5
            int r1 = r1 + 11
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2     // Catch: java.lang.Exception -> Lb5
            int r1 = r1 % 2
            goto Lb9
        Lb5:
            r0 = move-exception
            throw r0
        Lb7:
            r0 = move-exception
            throw r0
        Lb9:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r1 = r3.intValue()
            r8.requestNewSize(r4, r1, r0)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.setExpandedLayoutHeight():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0037, code lost:
    
        if (r7 == 2) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x003a, code lost:
    
        if (r7 == 3) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x003d, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x003e, code lost:
    
        if (r2 == true) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0040, code lost:
    
        r7 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 117;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r7 % 128;
        r7 = r7 % 2;
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x004f, code lost:
    
        if (r7 == null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0054, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x005a, code lost:
    
        if (r7 == null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x005c, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0068, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x006e, code lost:
    
        if (r7 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0070, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0079, code lost:
    
        if ((r0 % 2) == 0) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x007b, code lost:
    
        r7 = r7.N;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x007d, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0085, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x008b, code lost:
    
        if (r7 == null) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x008f, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0093, code lost:
    
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0095, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0099, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x009a, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x009b, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x009c, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x009d, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00a3, code lost:
    
        if (r7 == null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00a5, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00b0, code lost:
    
        return r7.O;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:?, code lost:
    
        return r7.P;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:?, code lost:
    
        return r7.SummaryVoucherView$$ExternalSyntheticLambda0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:?, code lost:
    
        return r7.N;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:?, code lost:
    
        return r7.Q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0017, code lost:
    
        if ((r7 == 0) != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0026, code lost:
    
        if ((r7 != 0 ? '!' : 'J') != 'J') goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x002a, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0030, code lost:
    
        if ((r0 % 2) == 0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0032, code lost:
    
        if (r7 == 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0035, code lost:
    
        if (r7 == 1) goto L122;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.appcompat.widget.AppCompatImageView getDivider(int r7) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getDivider(int):androidx.appcompat.widget.AppCompatImageView");
    }

    private final void openNewFragment(Fragment r4, @WalletV3FragmentTag String tag) {
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        beginTransaction.isLayoutRequested = true;
        FragmentTransaction PlaceComponentResult2 = beginTransaction.PlaceComponentResult(this);
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2(R.id.fragment_container_view, r4, tag, 1);
        if (!(PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        PlaceComponentResult2.scheduleImpl = true;
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda8 = HomeTabFragment.FragmentTag.WALLET_FRAGMENT;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        int i5 = PlaceComponentResult + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        boolean z = i5 % 2 != 0;
        PlaceComponentResult2.getAuthRequestContext();
        if (!z) {
            int i6 = 59 / 0;
        }
    }

    private final void initializeCountUpTimerPublishSubject() {
        Disposable subscribe = Observable.interval(60L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewWalletFragment.m3036$r8$lambda$Niq7Ode7wpPPTktezzHW0tfnD0(NewWalletFragment.this, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.countUpPublishSubjectDisposable = subscribe;
        try {
            int i = PlaceComponentResult + 123;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (!(i % 2 != 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: initializeCountUpTimerPublishSubject$lambda-58 */
    private static final void m3073initializeCountUpTimerPublishSubject$lambda58(NewWalletFragment newWalletFragment, Long l) {
        int i = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.countUpPublishSubject.onNext(Integer.valueOf((int) l.longValue()));
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void initializeCountDownTimerPublishSubject() {
        Disposable subscribe = Observable.interval(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda38
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewWalletFragment.$r8$lambda$FCY79l4XDKXiRWnlSONpI8oiBsU(NewWalletFragment.this, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.countDownPublishSubjectDisposable = subscribe;
        int i = PlaceComponentResult + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    /* renamed from: initializeCountDownTimerPublishSubject$lambda-59 */
    private static final void m3072initializeCountDownTimerPublishSubject$lambda59(NewWalletFragment newWalletFragment, Long l) {
        int i = PlaceComponentResult + 3;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.countDownPublishSubject.onNext(Integer.valueOf((int) l.longValue()));
        } else {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.countDownPublishSubject.onNext(Integer.valueOf((int) l.longValue()));
            Object obj = null;
            obj.hashCode();
        }
        int i2 = PlaceComponentResult + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 == 0 ? 'N' : '\t') != 'N') {
            return;
        }
        int i3 = 98 / 0;
    }

    private final AppCompatImageView getWalletArrowButtonSection(int index) {
        AppCompatImageView appCompatImageView = null;
        if ((index != 0 ? Typography.less : (char) 4) != '<') {
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if ((fragmentNewWalletBinding != null ? '8' : '9') != '9') {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                try {
                    appCompatImageView = fragmentNewWalletBinding.getNameOrBuilderList;
                } catch (Exception e) {
                    throw e;
                }
            }
        } else {
            if (!(index != 1)) {
                FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding2 != null) {
                    appCompatImageView = fragmentNewWalletBinding2.J;
                }
            } else {
                if ((index != 2 ? '\r' : 'K') != '\r') {
                    FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
                    if (!(fragmentNewWalletBinding3 == null)) {
                        appCompatImageView = fragmentNewWalletBinding3.M;
                    }
                } else if (index != 3) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    FragmentNewWalletBinding fragmentNewWalletBinding4 = (FragmentNewWalletBinding) getBinding();
                    if (fragmentNewWalletBinding4 != null) {
                        appCompatImageView = fragmentNewWalletBinding4.L;
                    }
                } else {
                    FragmentNewWalletBinding fragmentNewWalletBinding5 = (FragmentNewWalletBinding) getBinding();
                    if (fragmentNewWalletBinding5 != null) {
                        appCompatImageView = fragmentNewWalletBinding5.K;
                    }
                }
            }
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        PlaceComponentResult = i5 % 128;
        int i6 = i5 % 2;
        return appCompatImageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.airbnb.lottie.LottieAnimationView] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.airbnb.lottie.LottieAnimationView] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.airbnb.lottie.LottieAnimationView] */
    /* JADX WARN: Type inference failed for: r4v8 */
    private final LottieAnimationView getWalletLottieButtonSection(int index) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ?? r4 = 0;
        r4 = 0;
        if (index == 0) {
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding != null) {
                return fragmentNewWalletBinding.U;
            }
            return null;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        try {
            if ((index != 1 ? '\f' : '0') != '\f') {
                FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding2 != null) {
                    r4 = fragmentNewWalletBinding2.isAuto;
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
                    PlaceComponentResult = i5 % 128;
                    int i6 = i5 % 2;
                }
            } else if (index == 2) {
                FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding3 != null) {
                    int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
                    PlaceComponentResult = i7 % 128;
                    if (!(i7 % 2 != 0)) {
                        return fragmentNewWalletBinding3.Z;
                    }
                    LottieAnimationView lottieAnimationView = fragmentNewWalletBinding3.Z;
                    int length = r4.length;
                    return lottieAnimationView;
                }
                return null;
            } else if (index == 3) {
                FragmentNewWalletBinding fragmentNewWalletBinding4 = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding4 != null) {
                    return fragmentNewWalletBinding4.X;
                }
                return null;
            } else {
                try {
                    FragmentNewWalletBinding fragmentNewWalletBinding5 = (FragmentNewWalletBinding) getBinding();
                    if ((fragmentNewWalletBinding5 != null ? (char) 31 : 'c') != 'c') {
                        r4 = fragmentNewWalletBinding5.V;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            return r4;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final AppCompatImageView getWalletReloadButtonSection(int index) {
        int i = PlaceComponentResult + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (index == 0) {
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if (!(fragmentNewWalletBinding != null)) {
                return null;
            }
            return fragmentNewWalletBinding.isAuth;
        }
        if (index == 1) {
            FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
            if ((fragmentNewWalletBinding2 != null ? 'c' : ',') != ',') {
                return fragmentNewWalletBinding2.SummaryVoucherView$$ExternalSyntheticLambda1;
            }
            return null;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        if (index == 2) {
            try {
                try {
                    FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
                    if (fragmentNewWalletBinding3 != null) {
                        return fragmentNewWalletBinding3.SummaryVoucherView$$ExternalSyntheticLambda2;
                    }
                    return null;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if ((index != 3 ? 'J' : (char) 15) != 15) {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
            FragmentNewWalletBinding fragmentNewWalletBinding4 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding4 != null) {
                return fragmentNewWalletBinding4.R;
            }
            return null;
        }
        FragmentNewWalletBinding fragmentNewWalletBinding5 = (FragmentNewWalletBinding) getBinding();
        if (!(fragmentNewWalletBinding5 != null)) {
            return null;
        }
        int i7 = PlaceComponentResult + 91;
        KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
        int i8 = i7 % 2;
        return fragmentNewWalletBinding5.S;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v4, types: [id.dana.wallet_v3.view.WalletSectionTooltipView] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8, types: [id.dana.wallet_v3.view.WalletSectionTooltipView] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private final WalletSectionTooltipView getSectionTooltipView(int index) {
        WalletSectionTooltipView walletSectionTooltipView;
        WalletSectionTooltipView walletSectionTooltipView2 = 0;
        walletSectionTooltipView2 = 0;
        if (index == 0) {
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding == null) {
                return null;
            }
            return fragmentNewWalletBinding.SubSequence;
        } else if (index == 1) {
            FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding2 != null) {
                return fragmentNewWalletBinding2.FlowViewUtil$textChanges$2;
            }
            return null;
        } else {
            int i = PlaceComponentResult + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            try {
                if (i % 2 != 0 ? index == 2 : index == 2) {
                    FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
                    if (!(fragmentNewWalletBinding3 != null)) {
                        return null;
                    }
                    int i2 = PlaceComponentResult + 35;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                    int i3 = i2 % 2;
                    walletSectionTooltipView2 = fragmentNewWalletBinding3.s;
                } else {
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                    try {
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        if (index != 3) {
                            FragmentNewWalletBinding fragmentNewWalletBinding4 = (FragmentNewWalletBinding) getBinding();
                            if (fragmentNewWalletBinding4 != null) {
                                int i6 = PlaceComponentResult + 115;
                                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                                if (i6 % 2 == 0) {
                                    walletSectionTooltipView = fragmentNewWalletBinding4.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                    int length = walletSectionTooltipView2.length;
                                } else {
                                    walletSectionTooltipView = fragmentNewWalletBinding4.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                }
                                walletSectionTooltipView2 = walletSectionTooltipView;
                            }
                        } else {
                            FragmentNewWalletBinding fragmentNewWalletBinding5 = (FragmentNewWalletBinding) getBinding();
                            if ((fragmentNewWalletBinding5 != null ? ',' : '\r') == ',') {
                                int i7 = PlaceComponentResult + 125;
                                KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                                int i8 = i7 % 2;
                                walletSectionTooltipView2 = fragmentNewWalletBinding5.H;
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                return walletSectionTooltipView2;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x002b, code lost:
    
        if (r6 == 3) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x002d, code lost:
    
        r6 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0033, code lost:
    
        if (r6 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0035, code lost:
    
        r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x003e, code lost:
    
        if ((r2 % 2) == 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0041, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0042, code lost:
    
        if (r0 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0044, code lost:
    
        r6 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0048, code lost:
    
        r0 = 12 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x004c, code lost:
    
        r6 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x004e, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0050, code lost:
    
        r6 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0056, code lost:
    
        if (r6 == null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0058, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0061, code lost:
    
        r3 = r6.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0064, code lost:
    
        r6 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x006a, code lost:
    
        if (r6 == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x006d, code lost:
    
        r4 = '=';
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x006f, code lost:
    
        if (r4 == 0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0072, code lost:
    
        r3 = r6.f8083o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0075, code lost:
    
        r6 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x007b, code lost:
    
        if (r6 == null) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0080, code lost:
    
        r6 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0086, code lost:
    
        if (r6 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0088, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 19;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0091, code lost:
    
        if ((r0 % 2) != 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0093, code lost:
    
        r3 = r6.FragmentBottomSheetPaymentSettingBinding;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0097, code lost:
    
        r6 = 68 / 0;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x009b, code lost:
    
        r3 = r6.FragmentBottomSheetPaymentSettingBinding;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:?, code lost:
    
        return r6.TypeProjectionImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x001f, code lost:
    
        if ((r6 != 0 ? 6 : 'R') != 'R') goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0023, code lost:
    
        if (r6 != 0) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0025, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0026, code lost:
    
        if (r6 == 1) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0028, code lost:
    
        if (r6 == 2) goto L120;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.wallet_v3.view.WalletSectionHeaderView getSectionHeaderView(int r6) {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 60
            if (r0 != 0) goto L11
            r0 = 60
            goto L13
        L11:
            r0 = 26
        L13:
            r3 = 0
            r4 = 0
            if (r0 == r2) goto L22
            r0 = 82
            if (r6 == 0) goto L1d
            r2 = 6
            goto L1f
        L1d:
            r2 = 82
        L1f:
            if (r2 == r0) goto L80
            goto L25
        L22:
            int r0 = r3.length     // Catch: java.lang.Throwable -> La1
            if (r6 == 0) goto L80
        L25:
            r0 = 1
            if (r6 == r0) goto L75
            if (r6 == r1) goto L64
            r2 = 3
            if (r6 == r2) goto L50
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()     // Catch: java.lang.Exception -> L9e
            id.dana.databinding.FragmentNewWalletBinding r6 = (id.dana.databinding.FragmentNewWalletBinding) r6     // Catch: java.lang.Exception -> L9e
            if (r6 == 0) goto La0
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 125
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % r1
            if (r2 == 0) goto L41
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L4c
            id.dana.wallet_v3.view.WalletSectionHeaderView r6 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0
            r0 = 12
            int r0 = r0 / r4
            goto L4e
        L4a:
            r6 = move-exception
            throw r6
        L4c:
            id.dana.wallet_v3.view.WalletSectionHeaderView r6 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0
        L4e:
            r3 = r6
            goto La0
        L50:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r6 = (id.dana.databinding.FragmentNewWalletBinding) r6
            if (r6 == 0) goto La0
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 99
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2
            int r0 = r0 % r1
            id.dana.wallet_v3.view.WalletSectionHeaderView r3 = r6.D     // Catch: java.lang.Exception -> L9e
            goto La0
        L64:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r6 = (id.dana.databinding.FragmentNewWalletBinding) r6
            if (r6 == 0) goto L6d
            goto L6f
        L6d:
            r4 = 61
        L6f:
            if (r4 == 0) goto L72
            goto La0
        L72:
            id.dana.wallet_v3.view.WalletSectionHeaderView r3 = r6.f8083o     // Catch: java.lang.Exception -> L9e
            goto La0
        L75:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r6 = (id.dana.databinding.FragmentNewWalletBinding) r6
            if (r6 == 0) goto La0
            id.dana.wallet_v3.view.WalletSectionHeaderView r3 = r6.TypeProjectionImpl
            goto La0
        L80:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r6 = (id.dana.databinding.FragmentNewWalletBinding) r6
            if (r6 == 0) goto La0
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L9e
            int r0 = r0 + 19
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Exception -> L9e
            int r0 = r0 % r1
            if (r0 != 0) goto L9b
            id.dana.wallet_v3.view.WalletSectionHeaderView r3 = r6.FragmentBottomSheetPaymentSettingBinding
            r6 = 68
            int r6 = r6 / r4
            goto La0
        L99:
            r6 = move-exception
            throw r6
        L9b:
            id.dana.wallet_v3.view.WalletSectionHeaderView r3 = r6.FragmentBottomSheetPaymentSettingBinding
            goto La0
        L9e:
            r6 = move-exception
            throw r6
        La0:
            return r3
        La1:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getSectionHeaderView(int):id.dana.wallet_v3.view.WalletSectionHeaderView");
    }

    private final List<String> getVoucherAndTicketAssetTypes() {
        AssetType assetType;
        String asset;
        AssetType assetType2;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.walletVoucherAndTicketSectionAssetType.iterator();
        while (true) {
            try {
                if ((it.hasNext() ? 'B' : 'R') != 'B') {
                    return arrayList;
                }
                String str = (String) it.next();
                if (Intrinsics.areEqual(str, AssetType.VOUCHER.getAsset())) {
                    assetType = AssetType.VOUCHER;
                } else if (Intrinsics.areEqual(str, AssetType.COUPON.getAsset())) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    assetType = AssetType.COUPON;
                } else {
                    if ((Intrinsics.areEqual(str, AssetType.DISCOUNT_COUPON.getAsset()) ? (char) 2 : '^') != '^') {
                        asset = AssetType.DISCOUNT_COUPON.getAsset();
                    } else {
                        if (Intrinsics.areEqual(str, AssetType.TRAVEL_TICKET.getAsset())) {
                            assetType2 = AssetType.TRAVEL_TICKET;
                        } else {
                            try {
                                if (Intrinsics.areEqual(str, AssetType.PARKING.getAsset())) {
                                    assetType = AssetType.PARKING;
                                } else if (Intrinsics.areEqual(str, AssetType.TICKET.getAsset())) {
                                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                                    PlaceComponentResult = i3 % 128;
                                    if (i3 % 2 != 0) {
                                        arrayList.add(AssetType.TICKET.getAsset());
                                        Object obj = null;
                                        obj.hashCode();
                                    } else {
                                        assetType2 = AssetType.TICKET;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        asset = assetType2.getAsset();
                    }
                    arrayList.add(asset);
                }
                arrayList.add(assetType.getAsset());
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void dispose() {
        super.dispose();
        Disposable disposable = this.countDownPublishSubjectDisposable;
        if (disposable == null) {
            int i = PlaceComponentResult + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                disposable = null;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        disposable.dispose();
        getAllAssetErrorObserver().dispose();
        getAllAssetFromLocalObserver().dispose();
        getAllAssetFromNetworkObserver().dispose();
        this.compositeDisposable.dispose();
        Disposable disposable2 = this.disposableTimeoutAllAssets;
        if ((disposable2 != null ? '5' : 'E') != '5') {
            return;
        }
        int i5 = PlaceComponentResult + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        int i6 = i5 % 2;
        disposable2.dispose();
    }

    private final void requestNewSize(View view, int i, int i2) {
        int i3 = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        try {
            view.getLayoutParams().width = i;
            try {
                view.getLayoutParams().height = i2;
                int i5 = PlaceComponentResult + 41;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if (i5 % 2 != 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:100:0x005d, code lost:
    
        r7 = 20 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x005e, code lost:
    
        if (r6 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0061, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0062, code lost:
    
        if (r5 == true) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0067, code lost:
    
        r6 = r7.getExtras();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x006b, code lost:
    
        if (r6 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x006f, code lost:
    
        r5 = r6.getString(id.dana.challenge.ChallengeControl.Key.CANCEL_REASON);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0074, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x007c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, id.dana.challenge.ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED) == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x007e, code lost:
    
        r5 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5 % 128;
        r5 = r5 % 2;
        getIdentityToastAndDialog().showErrorVerifyPinPopup();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x008f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0090, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0091, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0092, code lost:
    
        startActivityForResult(new android.content.Intent(getContext(), id.dana.wallet_v3.identity.view.KtpDetailActivity.class), id.dana.wallet_v3.view.NewWalletFragment.IDENTITY_REQUEST_CODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00a2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00a5, code lost:
    
        if (r5 != id.dana.wallet_v3.view.NewWalletFragment.IDENTITY_REQUEST_CODE) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00a7, code lost:
    
        if (r6 != (-1)) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00a9, code lost:
    
        r5 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 27;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00b3, code lost:
    
        getNewWalletPresenter().updateTotalSectionQuery(5, true);
        fetchIdentitySection();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00c1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0013, code lost:
    
        if (r5 == 30673) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0024, code lost:
    
        if ((r5 == 1012 ? ':' : 'U') != 'U') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0026, code lost:
    
        if (r6 == (-1)) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0028, code lost:
    
        r5 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5 % 128;
        r5 = r5 % 2;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0033, code lost:
    
        if (r6 != 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0035, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0037, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0038, code lost:
    
        if (r6 == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x003c, code lost:
    
        if (r7 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x003e, code lost:
    
        r0 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0041, code lost:
    
        r0 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0043, code lost:
    
        if (r0 == 16) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0046, code lost:
    
        r6 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 49;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0050, code lost:
    
        if ((r6 % 2) != 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0052, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0054, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0055, code lost:
    
        if (r6 == true) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0057, code lost:
    
        r6 = r7.getExtras();
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void updateIdentityCardState(List<IdentityCardModel.KtpCard> list) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(list, "");
        this.identitySection.setAssets(list);
        showCardList(this.identitySection.getIndex(), list);
        adjustCardSpacing(this.identitySection.getIndex(), list);
        showTotalAssetSectionHeader(this.identitySection, false, list.size());
        Object obj = null;
        if (!this.shouldShowIdentityTooltip) {
            saveSectionTooltipShown$default(this, "IDENTITY", false, 2, null);
            return;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        PlaceComponentResult = i3 % 128;
        char c = i3 % 2 != 0 ? '%' : InputCardNumberView.DIVIDER;
        showSectionTooltip("IDENTITY");
        if (c != ' ') {
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x00d1, code lost:
    
        if (r9.MyBillsEntityDataFactory.isShowing() == false) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x00e0, code lost:
    
        if (r9.MyBillsEntityDataFactory.isShowing() == false) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x00e2, code lost:
    
        r9.MyBillsEntityDataFactory.show();
        r9.getAuthRequestContext.startRefresh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x025d, code lost:
    
        if (r9 != null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0268, code lost:
    
        if (r9 != null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x026a, code lost:
    
        r1 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:304:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x02f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void onCardClickedAction(id.dana.wallet_v3.model.WalletV3CardModel r9) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.onCardClickedAction(id.dana.wallet_v3.model.WalletV3CardModel):void");
    }

    private final DanaH5Listener createH5AppListener() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                DanaH5.dispose();
                NewWalletFragment.this.setLastAddedAssetType(3);
                NewWalletFragment.this.refreshDataBasedOnLatestAddedAssetType();
            }
        };
        int i = PlaceComponentResult + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            return danaH5Listener;
        }
        Object obj = null;
        obj.hashCode();
        return danaH5Listener;
    }

    private final void setLastWalletSectionTypeDetailOpenedBasedOnType(WalletV3CardModel data) {
        int i = PlaceComponentResult + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if ((data instanceof VoucherAndTicketCardModel ? JSONLexer.EOI : (char) 28) != 28) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? '!' : '3') != '!') {
                this.lastWalletSectionTypeDetailOpened = "VOUCHER_AND_TICKET";
                return;
            }
            this.lastWalletSectionTypeDetailOpened = "VOUCHER_AND_TICKET";
            Object obj = null;
            obj.hashCode();
        }
    }

    private final void refreshRedDotBasedOnLastWalletSectionTypeDetailOpened() {
        String str;
        try {
            if (!(!isHidden())) {
                return;
            }
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
            PlaceComponentResult = i % 128;
            if (i % 2 != 0) {
                str = this.lastWalletSectionTypeDetailOpened;
                int i2 = 0 / 0;
                if ((str != null ? 'P' : ',') == ',') {
                    return;
                }
            } else {
                str = this.lastWalletSectionTypeDetailOpened;
                if (str == null) {
                    return;
                }
            }
            if (Intrinsics.areEqual(str, "VOUCHER_AND_TICKET")) {
                getNewWalletPresenter().getPocketRedDotTotalCount("VOUCHER_AND_TICKET", getVoucherAndTicketAssetTypes());
                int i3 = PlaceComponentResult + 39;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            }
            this.lastWalletSectionTypeDetailOpened = null;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void openBottomSheetAddAsset(int assetType) {
        List<String> list = this.walletSectionOrderingList;
        boolean z = this.ktpIsSaved;
        new BottomSheetAddAsset(new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$openBottomSheetAddAsset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NewWalletFragment.this.refreshDataBasedOnLatestAddedAssetType();
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, assetType, list, 0, this.accessToken, this.kycLevel, z, null, 136, null).show(getParentFragmentManager(), (String) null);
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void openAddPaymentCard() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'F' : '\b') == '\b') {
            getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(DanaUrl.CARD_BINDING_DEEPLINK_FROM_WALLET);
            return;
        }
        getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(DanaUrl.CARD_BINDING_DEEPLINK_FROM_WALLET);
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x001e, code lost:
    
        if ((r4.isOpenLoyaltyDetail) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0026, code lost:
    
        if (r4.isOpenLoyaltyDetail != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0028, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0032, code lost:
    
        if ((r0 % 2) == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0034, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0035, code lost:
    
        if (r2 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
    
        openLoyaltyDetailH5(r4.loyaltyPocketId);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x003d, code lost:
    
        openLoyaltyDetailH5(r4.loyaltyPocketId);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0044, code lost:
    
        r0 = 72 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0045, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0048, code lost:
    
        getNewWalletPresenter().getLoyaltyCardAssets(r4.isAssetsFromLocalEmpty.get(3).booleanValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x005c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void onGetAccessTokenAndKycLevel() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 53
            if (r0 == 0) goto L11
            r0 = 53
            goto L13
        L11:
            r0 = 17
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L21
            boolean r0 = r4.isOpenLoyaltyDetail
            if (r0 == 0) goto L1d
            r0 = 1
            goto L1e
        L1d:
            r0 = 0
        L1e:
            if (r0 == 0) goto L48
            goto L28
        L21:
            boolean r0 = r4.isOpenLoyaltyDetail     // Catch: java.lang.Exception -> L5f
            r1 = 16
            int r1 = r1 / r3
            if (r0 == 0) goto L48
        L28:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L35
            r2 = 0
        L35:
            if (r2 == 0) goto L3d
            java.lang.String r0 = r4.loyaltyPocketId
            r4.openLoyaltyDetailH5(r0)
            goto L45
        L3d:
            java.lang.String r0 = r4.loyaltyPocketId
            r4.openLoyaltyDetailH5(r0)
            r0 = 72
            int r0 = r0 / r3
        L45:
            return
        L46:
            r0 = move-exception
            throw r0
        L48:
            id.dana.wallet_v3.presenter.NewWalletContract$Presenter r0 = r4.getNewWalletPresenter()
            java.util.List<java.lang.Boolean> r1 = r4.isAssetsFromLocalEmpty
            r2 = 3
            java.lang.Object r1 = r1.get(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.getLoyaltyCardAssets(r1)
            return
        L5d:
            r0 = move-exception
            throw r0
        L5f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.onGetAccessTokenAndKycLevel():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0044, code lost:
    
        if (r1 > 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0056, code lost:
    
        if ((r1.length() > 0 ? ']' : '7') != ']') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0058, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 71;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0064, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void openLoyaltyDetailH5(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.openLoyaltyDetailH5(java.lang.String):void");
    }

    private final void openAddLoyaltyCard() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://web-loyalty.dana.id");
        sb.append(TagFormat.MyBillsEntityDataFactory(DanaUrl.CREATE_LOYALTY).PlaceComponentResult("token", this.accessToken).PlaceComponentResult(WalletConstant.KYC_LEVEL, this.kycLevel).MyBillsEntityDataFactory());
        DanaH5.startContainerFullUrl(sb.toString(), new DanaH5Listener() { // from class: id.dana.wallet_v3.view.NewWalletFragment$openAddLoyaltyCard$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                NewWalletContract.Presenter.CC.getLoyaltyCardAssets$default(NewWalletFragment.this.getNewWalletPresenter(), false, 1, null);
            }
        });
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    static /* synthetic */ void goToServicePage$default(NewWalletFragment newWalletFragment, String str, String str2, int i, Object obj) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        Object obj2 = null;
        if (!((i & 2) == 0)) {
            str2 = null;
        }
        newWalletFragment.goToServicePage(str, str2);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
        PlaceComponentResult = i4 % 128;
        if ((i4 % 2 != 0 ? '1' : '_') != '1') {
            return;
        }
        obj2.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x005e, code lost:
    
        if (r0 != 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0063, code lost:
    
        if (r0 != 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0065, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void goToServicePage(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.util.List<id.dana.model.ThirdPartyService> r0 = r7.financeServices
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L31
            java.lang.Object r1 = r0.next()
            r5 = r1
            id.dana.model.ThirdPartyService r5 = (id.dana.model.ThirdPartyService) r5
            java.lang.String r5 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r8)
            if (r5 == 0) goto L8
            int r8 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + r4
            int r0 = r8 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0
            int r8 = r8 % 2
            if (r8 == 0) goto L32
            r8 = 9
            int r8 = r8 / r3
            goto L32
        L2f:
            r8 = move-exception
            throw r8
        L31:
            r1 = r2
        L32:
            id.dana.model.ThirdPartyService r1 = (id.dana.model.ThirdPartyService) r1
            if (r1 == 0) goto L87
            r7.trackServiceOpen(r1)
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.util.Map r8 = (java.util.Map) r8
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L67
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 25
            int r6 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r6
            int r5 = r5 % 2
            r6 = 15
            if (r5 == 0) goto L55
            r5 = 0
            goto L57
        L55:
            r5 = 15
        L57:
            int r0 = r0.length()
            if (r5 == r6) goto L63
            int r2 = r2.length     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L67
            goto L65
        L61:
            r8 = move-exception
            throw r8
        L63:
            if (r0 == 0) goto L67
        L65:
            r0 = 0
            goto L68
        L67:
            r0 = 1
        L68:
            if (r0 != 0) goto L6b
            r3 = 1
        L6b:
            if (r3 == r4) goto L6e
            goto L74
        L6e:
            java.lang.String r0 = "source"
            r8.put(r0, r9)
        L74:
            id.dana.contract.services.ServicesContract$Presenter r9 = r7.getServicePresenter()
            r9.MyBillsEntityDataFactory(r1, r8)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            int r8 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 79
            int r9 = r8 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r9
            int r8 = r8 % 2
        L87:
            if (r2 != 0) goto L9a
            id.dana.dialog.DanaLoadingDialog r8 = r7.getDanaLoadingDialog()
            r8.PlaceComponentResult()
            int r8 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 83
            int r9 = r8 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r9
            int r8 = r8 % 2
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.goToServicePage(java.lang.String, java.lang.String):void");
    }

    private final void trackServiceOpen(ThirdPartyService it) {
        try {
            int i = PlaceComponentResult + 125;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (!(i % 2 != 0)) {
                    ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void setWalletTabListener(WalletTabListener walletTabListener) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(walletTabListener, "");
            this.walletTabListener = walletTabListener;
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void checkShouldShowTooltip() {
        try {
            int i = PlaceComponentResult + 67;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                if (!(this.isCheckTooltipVisibility)) {
                    return;
                }
                getNewWalletPresenter().checkIsNeedToShowTooltip(CollectionsKt.listOf(UserEducationPreference.WALLET_ADD_ASSET_TOOLTIP));
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final Target getTooltipTarget() {
        TextView textView;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            try {
                PlaceComponentResult = i % 128;
                Object[] objArr = null;
                if (i % 2 != 0) {
                    boolean isSafe = isSafe();
                    int length = objArr.length;
                    if ((isSafe ? 'S' : 'R') == 'R') {
                        return null;
                    }
                } else {
                    if (!isSafe()) {
                        return null;
                    }
                }
                FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
                if (fragmentNewWalletBinding != null) {
                    LayoutToolbarBinding layoutToolbarBinding = fragmentNewWalletBinding.W;
                    if (layoutToolbarBinding == null) {
                        return null;
                    }
                    int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
                    PlaceComponentResult = i2 % 128;
                    if (!(i2 % 2 != 0)) {
                        textView = layoutToolbarBinding.getErrorConfigVersion;
                        if (textView == null) {
                            return null;
                        }
                    } else {
                        textView = layoutToolbarBinding.getErrorConfigVersion;
                        objArr.hashCode();
                        if (textView == null) {
                            return null;
                        }
                    }
                    int i3 = PlaceComponentResult + 11;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    return createTooltipTarget(textView);
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final Target createTooltipTarget(View targetView) {
        Target KClassImpl$Data$declaredNonStaticMembers$22 = new TargetBuilder(getActivity()).BuiltInFictitiousFunctionClassFactory(targetView).BuiltInFictitiousFunctionClassFactory(new CircleShape(SizeUtil.getAuthRequestContext(20))).getAuthRequestContext(new Content(getString(R.string.wallet_add_asset_button_tooltip_title), getString(R.string.wallet_add_asset_button_tooltip_subtitle), (int) R.drawable.ic_tooltip_wallet_add_asset)).KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = true;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '(' : 'Q') != '(') {
            return KClassImpl$Data$declaredNonStaticMembers$22;
        }
        Object obj = null;
        obj.hashCode();
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private final void delayToShowTooltip(final Function0<? extends Target> target) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        Scheduler KClassImpl$Data$declaredNonStaticMembers$23;
        Completable MyBillsEntityDataFactory2 = Completable.MyBillsEntityDataFactory();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$24 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(MyBillsEntityDataFactory2, 1000L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$22));
        KClassImpl$Data$declaredNonStaticMembers$23 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$23, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$25 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$24, KClassImpl$Data$declaredNonStaticMembers$23));
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$26 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$25, PlaceComponentResult2));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$26, "");
        Object[] objArr = null;
        addDisposable(SubscribersKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$26, null, new Function0<Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$delayToShowTooltip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                NewWalletFragment.access$showShowcase(NewWalletFragment.this, target.invoke());
            }
        }, 1));
        try {
            int i = PlaceComponentResult + 97;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 == 0 ? '8' : (char) 31) != '8') {
                    return;
                }
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0053, code lost:
    
        if (r7.showcase == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x005d, code lost:
    
        if (r7.section.length() <= 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x005f, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
        r1 = r1 % 2;
        r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 97;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0075, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0076, code lost:
    
        if (r1 != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0078, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x007a, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x007b, code lost:
    
        if (r1 == true) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x007f, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0089, code lost:
    
        if ((r1 % 2) == 0) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x008b, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x008e, code lost:
    
        if (r0 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0093, code lost:
    
        if (r0 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0095, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0097, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0098, code lost:
    
        if (r1 == true) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x009e, code lost:
    
        if (r0.NetworkUserEntityData$$ExternalSyntheticLambda1() == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00a0, code lost:
    
        r0 = getBaseActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r2 = new id.dana.showcase.TwoButtonWithImageShowcaseBuilder(r0, r8);
        r8 = getString(id.dana.R.string.wallet_add_asset_button_tooltip_text);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "");
        r0 = new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda27();
        r6 = getString(id.dana.R.string.wallet_btn_got_it_tooltip_wallet);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "");
        r8 = r2.MyBillsEntityDataFactory(r8, r0, r6);
        r8.getAuthRequestContext = true;
        r8 = r8.BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(new id.dana.wallet_v3.view.NewWalletFragment$showShowcase$2());
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00e6, code lost:
    
        if (isSafe() == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00e8, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00e9, code lost:
    
        if (r4 == true) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00ec, code lost:
    
        r7.showcase = r8.PlaceComponentResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x004c, code lost:
    
        if (r7.showcase == null) goto L103;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showShowcase(id.dana.showcase.target.Target r8) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.showShowcase(id.dana.showcase.target.Target):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    private final void showGetAllAssetErrorSnackBar(ViewGroup parent) {
        String str;
        int i = PlaceComponentResult + 37;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        String str2 = 0;
        if (!(i % 2 != 0)) {
            int length = str2.length;
            if (parent == null) {
                return;
            }
        } else if (parent == null) {
            return;
        }
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder(parent);
        BaseActivity baseActivity = getBaseActivity();
        if ((baseActivity != null ? 'L' : 'U') != 'U') {
            str = baseActivity.getString(R.string.success_add_ktp__button_msg);
        } else {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            str = null;
        }
        builder.lookAheadTest = str;
        BaseActivity baseActivity2 = getBaseActivity();
        if ((baseActivity2 != null ? '#' : (char) 5) == '#') {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
            PlaceComponentResult = i4 % 128;
            if (i4 % 2 != 0) {
                str2 = baseActivity2.getString(R.string.failed_load_all_section_msg);
                int i5 = 62 / 0;
            } else {
                str2 = baseActivity2.getString(R.string.failed_load_all_section_msg);
            }
        }
        builder.initRecordTimeStamp = str2;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_close_red;
        builder.moveToNextValue = 0;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_red_50;
        Function1<CustomSnackbar, Unit> function1 = new Function1<CustomSnackbar, Unit>() { // from class: id.dana.wallet_v3.view.NewWalletFragment$showGetAllAssetErrorSnackBar$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CustomSnackbar customSnackbar) {
                invoke2(customSnackbar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CustomSnackbar customSnackbar) {
                Intrinsics.checkNotNullParameter(customSnackbar, "");
                NewWalletFragment.access$reloadAllData(NewWalletFragment.this);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        builder.getErrorConfigVersion = function1;
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        this.errorGetAllAssetSnackbar = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0019, code lost:
    
        if ((r0 != null) != true) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0025, code lost:
    
        if ((r0 != null) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0027, code lost:
    
        r1 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory;
        r1 = getString(id.dana.R.string.failed_load_section_msg);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        id.dana.core.ui.util.DANAToast.MyBillsEntityDataFactory(r0, r1, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x003a, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0044, code lost:
    
        if ((r0 % 2) == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0046, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0047, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x004a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showGetAssetErrorToast() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1e
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            r2.hashCode()     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L19
            r1 = 1
        L19:
            if (r1 == r3) goto L27
            goto L3a
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            if (r0 == 0) goto L25
            r1 = 1
        L25:
            if (r1 == 0) goto L3a
        L27:
            id.dana.core.ui.util.DANAToast r1 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2131953544(0x7f130788, float:1.9543562E38)
            java.lang.String r1 = r4.getString(r1)
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory(r0, r1)
        L3a:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L4a
            int r0 = r2.length     // Catch: java.lang.Throwable -> L48
            return
        L48:
            r0 = move-exception
            throw r0
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.showGetAssetErrorToast():void");
    }

    private final void checkIsNeedToShowSectionTooltip() {
        int i = PlaceComponentResult + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        getNewWalletPresenter().checkIsNeedToShowTooltip(CollectionsKt.listOf((Object[]) new String[]{UserEducationPreference.WALLET_FINANCIAL_SECTION_TOOLTIP, UserEducationPreference.WALLET_PAYMENT_SECTION_TOOLTIP, UserEducationPreference.WALLET_VOUCHER_TICKET_SECTION_TOOLTIP, UserEducationPreference.WALLET_LOYALTY_SECTION_TOOLTIP, UserEducationPreference.WALLET_IDENTITY_SECTION_TOOLTIP}));
        int i3 = PlaceComponentResult + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0041, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.InvestmentCardModel.DanaPlusCard) != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0046, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.VoucherCard) != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0048, code lost:
    
        r0 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x004b, code lost:
    
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x004c, code lost:
    
        if (r0 == 3) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0050, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.TravelTicketCard) != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0054, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.ParkingTicketCard) != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0058, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.LoyaltyCardModel.LoyaltyCard) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x005a, code lost:
    
        r7 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r7 % 128;
        r7 = r7 % 2;
        saveSectionTooltipShown$default(r6, "LOYALTY", false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0068, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x006d, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.IdentityCardModel) == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x006f, code lost:
    
        r0 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0072, code lost:
    
        r0 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0074, code lost:
    
        if (r0 == '?') goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x007a, code lost:
    
        if (r7.getViewType() != 14) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x007c, code lost:
    
        saveSectionTooltipShown$default(r6, "IDENTITY", false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0081, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0082, code lost:
    
        saveSectionTooltipShown$default(r6, "VOUCHER_AND_TICKET", false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0087, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0088, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0089, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x008a, code lost:
    
        saveSectionTooltipShown$default(r6, "FINANCIAL", false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x008f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0023, code lost:
    
        if ((!r0) != true) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x002b, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.PaymentCardModel.PaylaterCard) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x002f, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.InvestmentCardModel.DanaGoalsCard) != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0035, code lost:
    
        if ((r7 instanceof id.dana.wallet_v3.model.InvestmentCardModel.EmasCard) != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0037, code lost:
    
        r0 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x003a, code lost:
    
        r0 = '`';
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x003c, code lost:
    
        if (r0 == 14) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateSectionTooltipVisibility(id.dana.wallet_v3.model.WalletV3CardModel r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.PaymentCardModel.BankCard
            r1 = 53
            if (r0 != 0) goto L9
            r0 = 18
            goto Lb
        L9:
            r0 = 53
        Lb:
            r2 = 0
            r3 = 0
            r4 = 2
            if (r0 == r1) goto L90
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            r1 = 1
            int r0 = r0 + r1
            int r5 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r0 = r0 % r4
            if (r0 != 0) goto L29
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.PaymentCardModel.PaylaterCard
            int r5 = r2.length     // Catch: java.lang.Throwable -> L27
            if (r0 != 0) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 == r1) goto L2d
            goto L90
        L27:
            r7 = move-exception
            throw r7
        L29:
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.PaymentCardModel.PaylaterCard
            if (r0 != 0) goto L90
        L2d:
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.InvestmentCardModel.DanaGoalsCard
            if (r0 != 0) goto L8a
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.InvestmentCardModel.EmasCard
            r1 = 14
            if (r0 != 0) goto L3a
            r0 = 14
            goto L3c
        L3a:
            r0 = 96
        L3c:
            if (r0 == r1) goto L3f
            goto L8a
        L3f:
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.InvestmentCardModel.DanaPlusCard
            if (r0 != 0) goto L8a
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.VoucherCard     // Catch: java.lang.Exception -> L88
            r5 = 3
            if (r0 != 0) goto L4b
            r0 = 29
            goto L4c
        L4b:
            r0 = 3
        L4c:
            if (r0 == r5) goto L82
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.TravelTicketCard
            if (r0 != 0) goto L82
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.ParkingTicketCard     // Catch: java.lang.Exception -> L88
            if (r0 != 0) goto L82
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.LoyaltyCardModel.LoyaltyCard
            if (r0 == 0) goto L69
            int r7 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 115
            int r0 = r7 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0
            int r7 = r7 % r4
            java.lang.String r7 = "LOYALTY"
            saveSectionTooltipShown$default(r6, r7, r3, r4, r2)
            return
        L69:
            boolean r0 = r7 instanceof id.dana.wallet_v3.model.IdentityCardModel
            r5 = 63
            if (r0 == 0) goto L72
            r0 = 81
            goto L74
        L72:
            r0 = 63
        L74:
            if (r0 == r5) goto L9e
            int r7 = r7.getViewType()
            if (r7 != r1) goto L9e
            java.lang.String r7 = "IDENTITY"
            saveSectionTooltipShown$default(r6, r7, r3, r4, r2)
            return
        L82:
            java.lang.String r7 = "VOUCHER_AND_TICKET"
            saveSectionTooltipShown$default(r6, r7, r3, r4, r2)     // Catch: java.lang.Exception -> L9f
            return
        L88:
            r7 = move-exception
            throw r7
        L8a:
            java.lang.String r7 = "FINANCIAL"
            saveSectionTooltipShown$default(r6, r7, r3, r4, r2)
            return
        L90:
            java.lang.String r7 = "PAYMENT"
            saveSectionTooltipShown$default(r6, r7, r3, r4, r2)
            int r7 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L9f
            int r7 = r7 + 119
            int r0 = r7 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L9f
            int r7 = r7 % r4
        L9e:
            return
        L9f:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.updateSectionTooltipVisibility(id.dana.wallet_v3.model.WalletV3CardModel):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:72:0x004a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final java.lang.String getScenarioBasedSectionType(java.lang.String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()     // Catch: java.lang.Exception -> L97
            switch(r0) {
                case -1150817175: goto L6b;
                case -554006299: goto L4c;
                case -68698650: goto L3e;
                case 646865086: goto L28;
                case 1076711462: goto L9;
                default: goto L7;
            }
        L7:
            goto L8b
        L9:
            java.lang.String r0 = "LOYALTY"
            boolean r2 = r2.equals(r0)
            r0 = 1
            if (r2 == 0) goto L14
            r2 = 1
            goto L15
        L14:
            r2 = 0
        L15:
            if (r2 == r0) goto L19
            goto L95
        L19:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r2 = r2 + 83
            int r0 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r2 = r2 % 2
            java.lang.String r2 = "wallet_loyalty_section"
            goto L96
        L28:
            java.lang.String r0 = "IDENTITY"
            boolean r2 = r2.equals(r0)
            r0 = 79
            if (r2 == 0) goto L35
            r2 = 79
            goto L37
        L35:
            r2 = 25
        L37:
            if (r2 == r0) goto L3a
            goto L95
        L3a:
            java.lang.String r2 = "wallet_identity_section"
            goto L96
        L3e:
            java.lang.String r0 = "PAYMENT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L95
            java.lang.String r2 = "wallet_payment_section"
            goto L96
        L4a:
            r2 = move-exception
            throw r2
        L4c:
            java.lang.String r0 = "VOUCHER_AND_TICKET"
            boolean r2 = r2.equals(r0)
            r0 = 82
            if (r2 == 0) goto L59
            r2 = 47
            goto L5b
        L59:
            r2 = 82
        L5b:
            if (r2 == r0) goto L95
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r2 = r2 + 75
            int r0 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r2 = r2 % 2
            java.lang.String r2 = "wallet_voucher_ticket_section"
            goto L96
        L6b:
            java.lang.String r0 = "FINANCIAL"
            boolean r2 = r2.equals(r0)
            r0 = 60
            if (r2 == 0) goto L78
            r2 = 60
            goto L7a
        L78:
            r2 = 50
        L7a:
            if (r2 == r0) goto L7d
            goto L95
        L7d:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L97
            int r2 = r2 + 41
            int r0 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L97
            int r2 = r2 % 2
            java.lang.String r2 = "wallet_financial_section"
            goto L96
        L8b:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 63
            int r0 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0
            int r2 = r2 % 2
        L95:
            r2 = 0
        L96:
            return r2
        L97:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getScenarioBasedSectionType(java.lang.String):java.lang.String");
    }

    private final void showSectionTooltip(String sectionType) {
        String scenarioBasedSectionType;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            scenarioBasedSectionType = getScenarioBasedSectionType(sectionType);
            int i2 = 59 / 0;
            if ((scenarioBasedSectionType != null ? 'b' : (char) 2) != 'b') {
                return;
            }
        } else {
            scenarioBasedSectionType = getScenarioBasedSectionType(sectionType);
            if (!(scenarioBasedSectionType != null)) {
                return;
            }
        }
        if (((Boolean) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(this.shouldShowSectionTooltip, scenarioBasedSectionType, Boolean.FALSE)).booleanValue()) {
            int i3 = PlaceComponentResult + 91;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            List<String> list = this.walletSectionOrderingList;
            String lowerCase = sectionType.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            WalletSectionTooltipView sectionTooltipView = getSectionTooltipView(list.indexOf(lowerCase));
            if (sectionTooltipView != null) {
                ViewExtKt.PlaceComponentResult(sectionTooltipView, 0);
                sectionTooltipView.setTooltipView(sectionType);
                sectionTooltipView.setTooltipListener(getSectionTooltipClickListener());
            }
        }
    }

    private final void showTotalAssetSectionHeader(WalletSectionModel r4, boolean isHasNewAsset, int totalAssets) {
        try {
            int i = PlaceComponentResult + 25;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                WalletSectionHeaderView sectionHeaderView = getSectionHeaderView(r4.getIndex());
                if (sectionHeaderView != null) {
                    int i3 = PlaceComponentResult + 109;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    boolean z = i3 % 2 == 0;
                    sectionHeaderView.setTotalAssetHeaderView(r4.getType(), isHasNewAsset, totalAssets);
                    if (z) {
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                    int i4 = PlaceComponentResult + 105;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                    int i5 = i4 % 2;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0022, code lost:
    
        if (r0 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003a, code lost:
    
        if ((r0 != null ? 'V' : 'W') != 'W') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003c, code lost:
    
        r0.setTitleHeaderView(r6.getType());
        id.dana.core.ui.extension.ViewExtKt.PlaceComponentResult(r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0048, code lost:
    
        r6 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 41;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0052, code lost:
    
        if ((r6 % 2) != 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0055, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0056, code lost:
    
        if (r1 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x005a, code lost:
    
        r6 = 54 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x005e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x005f, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0060, code lost:
    
        throw r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showTitleSectionHeader(id.dana.wallet_v3.model.WalletSectionModel r6) {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2
            int r0 = r0 % 2
            r2 = 22
            if (r0 == 0) goto L11
            r0 = 81
            goto L13
        L11:
            r0 = 22
        L13:
            r3 = 0
            if (r0 == r2) goto L29
            int r0 = r6.getIndex()     // Catch: java.lang.Exception -> L27
            id.dana.wallet_v3.view.WalletSectionHeaderView r0 = r5.getSectionHeaderView(r0)
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L48
            goto L3c
        L25:
            r6 = move-exception
            throw r6
        L27:
            r6 = move-exception
            throw r6
        L29:
            int r0 = r6.getIndex()
            id.dana.wallet_v3.view.WalletSectionHeaderView r0 = r5.getSectionHeaderView(r0)
            r2 = 87
            if (r0 == 0) goto L38
            r4 = 86
            goto L3a
        L38:
            r4 = 87
        L3a:
            if (r4 == r2) goto L48
        L3c:
            java.lang.String r6 = r6.getType()
            r0.setTitleHeaderView(r6)
            android.view.View r0 = (android.view.View) r0
            id.dana.core.ui.extension.ViewExtKt.PlaceComponentResult(r0, r3)
        L48:
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L5f
            int r6 = r6 + 41
            int r0 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L5f
            int r6 = r6 % 2
            if (r6 != 0) goto L55
            goto L56
        L55:
            r1 = 0
        L56:
            if (r1 == 0) goto L5e
            r6 = 54
            int r6 = r6 / r3
            return
        L5c:
            r6 = move-exception
            throw r6
        L5e:
            return
        L5f:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.showTitleSectionHeader(id.dana.wallet_v3.model.WalletSectionModel):void");
    }

    private final void hideTitleSectionHeader(int sectionIndex) {
        int i = PlaceComponentResult + 115;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        WalletSectionHeaderView sectionHeaderView = getSectionHeaderView(sectionIndex);
        if (!(sectionHeaderView == null)) {
            ViewExtKt.PlaceComponentResult(sectionHeaderView, 8);
        }
        int i3 = PlaceComponentResult + 9;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void saveSectionTooltipShown$default(NewWalletFragment newWalletFragment, String str, boolean z, int i, Object obj) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        if (((i & 2) != 0 ? 'B' : 'b') != 'b') {
            z = false;
        }
        newWalletFragment.saveSectionTooltipShown(str, z);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        PlaceComponentResult = i4 % 128;
        if ((i4 % 2 != 0 ? 'K' : '/') != '/') {
            Object obj2 = null;
            obj2.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00af, code lost:
    
        r5 = r5.Y;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00b2, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00b5, code lost:
    
        if (r5 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00b8, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00b9, code lost:
    
        if (r1 == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00be, code lost:
    
        r5 = r5.Y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00c0, code lost:
    
        if (r5 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00c2, code lost:
    
        r5.transitionToEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0075, code lost:
    
        if (r5 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0089, code lost:
    
        if ((r5 != null ? '/' : 15) != '/') goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x008c, code lost:
    
        r5 = r5.Y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x008e, code lost:
    
        if (r5 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0090, code lost:
    
        r5.setTransition(id.dana.R.id.stepToInitial);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0096, code lost:
    
        r5 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x009c, code lost:
    
        if (r5 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x009e, code lost:
    
        r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00a8, code lost:
    
        if ((r2 % 2) == 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00aa, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00ac, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00ad, code lost:
    
        if (r2 == false) goto L109;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void saveSectionTooltipShown(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
            java.lang.String r0 = r4.getScenarioBasedSectionType(r5)
            if (r0 == 0) goto Lcc
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r4.shouldShowSectionTooltip
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            java.lang.Object r2 = j$.util.Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(r2, r0, r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r3 = 99
            if (r2 == 0) goto L25
            r2 = 76
            goto L27
        L25:
            r2 = 99
        L27:
            if (r2 == r3) goto Lcc
            id.dana.wallet_v3.presenter.NewWalletContract$Presenter r2 = r4.getNewWalletPresenter()
            r2.saveTooltipShown(r0)
            java.util.List<java.lang.String> r2 = r4.walletSectionOrderingList
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r3)
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            int r5 = r2.indexOf(r5)
            id.dana.wallet_v3.view.WalletSectionTooltipView r5 = r4.getSectionTooltipView(r5)
            if (r5 == 0) goto Lc5
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 43
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % 2
            android.view.View r5 = (android.view.View) r5
            r2 = 8
            id.dana.core.ui.extension.ViewExtKt.PlaceComponentResult(r5, r2)
            if (r6 == 0) goto Lc5
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 95
            int r6 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r6
            int r5 = r5 % 2
            r6 = 0
            if (r5 == 0) goto L69
            r5 = 1
            goto L6a
        L69:
            r5 = 0
        L6a:
            if (r5 == 0) goto L7a
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r5 = (id.dana.databinding.FragmentNewWalletBinding) r5
            r2 = 75
            int r2 = r2 / r6
            if (r5 == 0) goto L96
            goto L8c
        L78:
            r5 = move-exception
            throw r5
        L7a:
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r5 = (id.dana.databinding.FragmentNewWalletBinding) r5
            r2 = 47
            if (r5 == 0) goto L87
            r3 = 47
            goto L89
        L87:
            r3 = 15
        L89:
            if (r3 == r2) goto L8c
            goto L96
        L8c:
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r5.Y
            if (r5 == 0) goto L96
            r2 = 2131366546(0x7f0a1292, float:1.8352989E38)
            r5.setTransition(r2)
        L96:
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r5 = (id.dana.databinding.FragmentNewWalletBinding) r5
            if (r5 == 0) goto Lc5
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 91
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % 2
            if (r2 == 0) goto Lac
            r2 = 1
            goto Lad
        Lac:
            r2 = 0
        Lad:
            if (r2 == 0) goto Lbe
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r5.Y
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> Lbc
            if (r5 == 0) goto Lb8
            goto Lb9
        Lb8:
            r1 = 0
        Lb9:
            if (r1 == 0) goto Lc5
            goto Lc2
        Lbc:
            r5 = move-exception
            throw r5
        Lbe:
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r5.Y
            if (r5 == 0) goto Lc5
        Lc2:
            r5.transitionToEnd()
        Lc5:
            java.util.Map<java.lang.String, java.lang.Boolean> r5 = r4.shouldShowSectionTooltip
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.put(r0, r6)
        Lcc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.saveSectionTooltipShown(java.lang.String, boolean):void");
    }

    private final void setTooltipConstraintSetMargin(int divider, int margin) {
        ConstraintSet constraintSet;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        PlaceComponentResult = i % 128;
        int i2 = i % 2 != 0 ? 1 : 0;
        while (true) {
            if ((i2 < 5 ? (char) 15 : '3') != 15) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            if ((fragmentNewWalletBinding != null ? Typography.greater : InputCardNumberView.DIVIDER) == '>') {
                int i5 = PlaceComponentResult + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
                try {
                    MotionLayout motionLayout = fragmentNewWalletBinding.Y;
                    if (motionLayout != null && (constraintSet = motionLayout.getConstraintSet(getTooltipConstraintSet(i2))) != null) {
                        int i7 = PlaceComponentResult + 17;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                        if (i7 % 2 == 0) {
                            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(divider).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = margin;
                            Object[] objArr = null;
                            int length = objArr.length;
                        } else {
                            try {
                                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(divider).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = margin;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            i2++;
        }
    }

    private final void redirectToMerchantPage(String url) {
        boolean z;
        int i = PlaceComponentResult + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if ((url.length() > 0 ? '\b' : '3') != '\b') {
            z = false;
        } else {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            z = true;
        }
        if ((z ? 'N' : 'L') != 'L') {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
            DanaH5.startContainerFullUrl(url);
        }
    }

    public final void trackWalletOpen(String source, int danaDealsVersion) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                Intrinsics.checkNotNullParameter(source, "");
                getWalletV3TrackerImplementation().trackWalletV3Open(source, danaDealsVersion);
                return;
            }
            Intrinsics.checkNotNullParameter(source, "");
            getWalletV3TrackerImplementation().trackWalletV3Open(source, danaDealsVersion);
            int i2 = 30 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0024, code lost:
    
        if ((r0 == null) != true) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0032, code lost:
    
        if ((r0 != null ? 'C' : 'Z') != 'Z') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0036, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x003a, code lost:
    
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x003e, code lost:
    
        r0.PlaceComponentResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0042, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0043, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0044, code lost:
    
        r4.showcase = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0046, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkWalletAddAssetTooltip() {
        /*
            r4 = this;
            id.dana.showcase.Showcase r0 = r4.showcase
            r1 = 95
            if (r0 == 0) goto L9
            r2 = 95
            goto Lb
        L9:
            r2 = 8
        Lb:
            if (r2 == r1) goto Le
            goto L46
        Le:
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L47
            int r1 = r1 + 61
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Exception -> L47
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L29
            r2.hashCode()     // Catch: java.lang.Throwable -> L27
            r1 = 1
            if (r0 == 0) goto L23
            r3 = 0
            goto L24
        L23:
            r3 = 1
        L24:
            if (r3 == r1) goto L44
            goto L34
        L27:
            r0 = move-exception
            throw r0
        L29:
            r1 = 90
            if (r0 == 0) goto L30
            r3 = 67
            goto L32
        L30:
            r3 = 90
        L32:
            if (r3 == r1) goto L44
        L34:
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L42
            int r1 = r1 + 75
            int r3 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3     // Catch: java.lang.Exception -> L42
            int r1 = r1 % 2
            r0.PlaceComponentResult()     // Catch: java.lang.Exception -> L47
            goto L44
        L42:
            r0 = move-exception
            throw r0
        L44:
            r4.showcase = r2
        L46:
            return
        L47:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.checkWalletAddAssetTooltip():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<FrameLayout> getSectionCardView(int index) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6 = null;
        if (index == 0) {
            FrameLayout[] frameLayoutArr = new FrameLayout[5];
            FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
            frameLayoutArr[0] = fragmentNewWalletBinding != null ? fragmentNewWalletBinding.NetworkUserEntityData$$ExternalSyntheticLambda7 : null;
            FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
            frameLayoutArr[1] = fragmentNewWalletBinding2 != null ? fragmentNewWalletBinding2.PrepareContext : null;
            FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
            frameLayoutArr[2] = fragmentNewWalletBinding3 != null ? fragmentNewWalletBinding3.isLayoutRequested : null;
            FragmentNewWalletBinding fragmentNewWalletBinding4 = (FragmentNewWalletBinding) getBinding();
            frameLayoutArr[3] = fragmentNewWalletBinding4 != null ? fragmentNewWalletBinding4.NetworkUserEntityData$$ExternalSyntheticLambda4 : null;
            FragmentNewWalletBinding fragmentNewWalletBinding5 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding5 != null) {
                int i = PlaceComponentResult + 121;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 == 0 ? 'M' : (char) 2) != 2) {
                    frameLayout6 = fragmentNewWalletBinding5.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    int i2 = 42 / 0;
                } else {
                    frameLayout6 = fragmentNewWalletBinding5.NetworkUserEntityData$$ExternalSyntheticLambda5;
                }
            }
            frameLayoutArr[4] = frameLayout6;
            return CollectionsKt.listOf((Object[]) frameLayoutArr);
        }
        try {
            try {
                if (index == 1) {
                    FrameLayout[] frameLayoutArr2 = new FrameLayout[5];
                    FragmentNewWalletBinding fragmentNewWalletBinding6 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr2[0] = fragmentNewWalletBinding6 != null ? fragmentNewWalletBinding6.b : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding7 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr2[1] = fragmentNewWalletBinding7 != null ? fragmentNewWalletBinding7.QrExpiredActivity : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding8 = (FragmentNewWalletBinding) getBinding();
                    if (fragmentNewWalletBinding8 != null) {
                        int i3 = PlaceComponentResult + 39;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        int i4 = i3 % 2;
                        frameLayout = fragmentNewWalletBinding8.d;
                    } else {
                        frameLayout = null;
                    }
                    frameLayoutArr2[2] = frameLayout;
                    FragmentNewWalletBinding fragmentNewWalletBinding9 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr2[3] = fragmentNewWalletBinding9 != null ? fragmentNewWalletBinding9.e : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding10 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr2[4] = fragmentNewWalletBinding10 != null ? fragmentNewWalletBinding10.FillAnimation : 0;
                    return CollectionsKt.listOf((Object[]) frameLayoutArr2);
                }
                if ((index != 2 ? (char) 0 : Typography.amp) == '&') {
                    FrameLayout[] frameLayoutArr3 = new FrameLayout[5];
                    FragmentNewWalletBinding fragmentNewWalletBinding11 = (FragmentNewWalletBinding) getBinding();
                    if (fragmentNewWalletBinding11 != null) {
                        int i5 = PlaceComponentResult + 49;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        int i6 = i5 % 2;
                        frameLayout2 = fragmentNewWalletBinding11.access$throwIllegalArgumentType;
                    } else {
                        frameLayout2 = null;
                    }
                    frameLayoutArr3[0] = frameLayout2;
                    FragmentNewWalletBinding fragmentNewWalletBinding12 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr3[1] = !(fragmentNewWalletBinding12 != null) ? null : fragmentNewWalletBinding12.m;
                    FragmentNewWalletBinding fragmentNewWalletBinding13 = (FragmentNewWalletBinding) getBinding();
                    if (fragmentNewWalletBinding13 != null) {
                        int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                        PlaceComponentResult = i7 % 128;
                        int i8 = i7 % 2;
                        frameLayout3 = fragmentNewWalletBinding13.k;
                    } else {
                        frameLayout3 = null;
                    }
                    frameLayoutArr3[2] = frameLayout3;
                    FragmentNewWalletBinding fragmentNewWalletBinding14 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr3[3] = fragmentNewWalletBinding14 != null ? fragmentNewWalletBinding14.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding15 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr3[4] = fragmentNewWalletBinding15 != null ? fragmentNewWalletBinding15.OtpRegistrationPresenter$input$2 : null;
                    return CollectionsKt.listOf((Object[]) frameLayoutArr3);
                }
                int i9 = PlaceComponentResult + 105;
                KClassImpl$Data$declaredNonStaticMembers$2 = i9 % 128;
                if (i9 % 2 != 0 ? index == 3 : index == 5) {
                    FrameLayout[] frameLayoutArr4 = new FrameLayout[5];
                    FragmentNewWalletBinding fragmentNewWalletBinding16 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr4[0] = fragmentNewWalletBinding16 != null ? fragmentNewWalletBinding16.A : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding17 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr4[1] = fragmentNewWalletBinding17 != null ? fragmentNewWalletBinding17.BottomSheetCardBindingView$watcherCardNumberView$1 : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding18 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr4[2] = fragmentNewWalletBinding18 != null ? fragmentNewWalletBinding18.VerifyPinStateManager$executeRiskChallenge$2$1 : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding19 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr4[3] = fragmentNewWalletBinding19 != null ? fragmentNewWalletBinding19.E : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding20 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr4[4] = fragmentNewWalletBinding20 != null ? fragmentNewWalletBinding20.getOnBoardingScenario : null;
                    return CollectionsKt.listOf((Object[]) frameLayoutArr4);
                } else if (index != 4) {
                    return CollectionsKt.emptyList();
                } else {
                    FrameLayout[] frameLayoutArr5 = new FrameLayout[5];
                    FragmentNewWalletBinding fragmentNewWalletBinding21 = (FragmentNewWalletBinding) getBinding();
                    if ((fragmentNewWalletBinding21 != null ? (char) 2 : 'L') != 2) {
                        frameLayout4 = null;
                    } else {
                        int i10 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
                        PlaceComponentResult = i10 % 128;
                        if (i10 % 2 != 0) {
                            frameLayout4 = fragmentNewWalletBinding21.getAuthRequestContext;
                            int length = r6.length;
                        } else {
                            frameLayout4 = fragmentNewWalletBinding21.getAuthRequestContext;
                        }
                    }
                    frameLayoutArr5[0] = frameLayout4;
                    FragmentNewWalletBinding fragmentNewWalletBinding22 = (FragmentNewWalletBinding) getBinding();
                    if ((fragmentNewWalletBinding22 != null ? (char) 18 : '_') != '_') {
                        int i11 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                        PlaceComponentResult = i11 % 128;
                        if ((i11 % 2 != 0 ? '`' : 'O') != '`') {
                            frameLayout5 = fragmentNewWalletBinding22.MyBillsEntityDataFactory;
                        } else {
                            frameLayout5 = fragmentNewWalletBinding22.MyBillsEntityDataFactory;
                            int i12 = 38 / 0;
                        }
                    } else {
                        frameLayout5 = null;
                    }
                    frameLayoutArr5[1] = frameLayout5;
                    FragmentNewWalletBinding fragmentNewWalletBinding23 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr5[2] = fragmentNewWalletBinding23 != null ? fragmentNewWalletBinding23.moveToNextValue : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding24 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr5[3] = fragmentNewWalletBinding24 != null ? fragmentNewWalletBinding24.getErrorConfigVersion : null;
                    FragmentNewWalletBinding fragmentNewWalletBinding25 = (FragmentNewWalletBinding) getBinding();
                    frameLayoutArr5[4] = fragmentNewWalletBinding25 == null ? null : fragmentNewWalletBinding25.lookAheadTest;
                    return CollectionsKt.listOf((Object[]) frameLayoutArr5);
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0069, code lost:
    
        if (r8 != null) goto L129;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.view.View getSectionViewTop(int r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            if (r8 == r2) goto L7
            r3 = 0
            goto L8
        L7:
            r3 = 1
        L8:
            r4 = 2
            if (r3 == 0) goto L22
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r8 = (id.dana.databinding.FragmentNewWalletBinding) r8
            if (r8 == 0) goto L9d
            android.view.View r0 = r8.i
            int r8 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult     // Catch: java.lang.Exception -> L20
            int r8 = r8 + 63
            int r1 = r8 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L20
            int r8 = r8 % r4
            goto L9d
        L20:
            r8 = move-exception
            goto L6e
        L22:
            r3 = 45
            if (r8 == r4) goto L7d
            r5 = 3
            r6 = 24
            if (r8 == r5) goto L2d
            r3 = 24
        L2d:
            if (r3 == r6) goto L43
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r8 = (id.dana.databinding.FragmentNewWalletBinding) r8
            if (r8 == 0) goto L9d
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % r4
            android.view.View r0 = r8.I
            goto L9d
        L43:
            r3 = 4
            if (r8 != r3) goto L48
            r8 = 1
            goto L49
        L48:
            r8 = 0
        L49:
            if (r8 == r2) goto L4c
            goto L9d
        L4c:
            int r8 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 119
            int r2 = r8 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r2
            int r8 = r8 % r4
            r2 = 56
            if (r8 == 0) goto L5c
            r8 = 37
            goto L5e
        L5c:
            r8 = 56
        L5e:
            if (r8 == r2) goto L71
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()     // Catch: java.lang.Exception -> L6f
            id.dana.databinding.FragmentNewWalletBinding r8 = (id.dana.databinding.FragmentNewWalletBinding) r8     // Catch: java.lang.Exception -> L20
            r2 = 42
            int r2 = r2 / r1
            if (r8 == 0) goto L9d
            goto L79
        L6c:
            r8 = move-exception
            throw r8
        L6e:
            throw r8
        L6f:
            r8 = move-exception
            goto L7c
        L71:
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r8 = (id.dana.databinding.FragmentNewWalletBinding) r8
            if (r8 == 0) goto L9d
        L79:
            android.view.View r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L6f
            goto L9d
        L7c:
            throw r8
        L7d:
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r8 = (id.dana.databinding.FragmentNewWalletBinding) r8
            if (r8 == 0) goto L9d
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + r3
            int r3 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r0 = r0 % r4
            if (r0 == 0) goto L90
            r2 = 0
        L90:
            if (r2 == 0) goto L95
            android.view.View r0 = r8.q
            goto L9d
        L95:
            android.view.View r0 = r8.q
            r8 = 54
            int r8 = r8 / r1
            goto L9d
        L9b:
            r8 = move-exception
            throw r8
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getSectionViewTop(int):android.view.View");
    }

    private final FrameLayout getSkeletonView(int index) {
        FragmentNewWalletBinding fragmentNewWalletBinding;
        Object[] objArr = null;
        if ((index != 0 ? (char) 15 : (char) 29) != 15) {
            FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding2 != null) {
                int i = PlaceComponentResult + 79;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 == 0 ? '?' : (char) 16) != 16) {
                    FrameLayout frameLayout = fragmentNewWalletBinding2.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    int length = objArr.length;
                    return frameLayout;
                }
                return fragmentNewWalletBinding2.NetworkUserEntityData$$ExternalSyntheticLambda3;
            }
            return null;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        if (index == 1) {
            FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding3 != null) {
                try {
                    FrameLayout frameLayout2 = fragmentNewWalletBinding3.f;
                    try {
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        return frameLayout2;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            return null;
        }
        if ((index != 2 ? 'S' : (char) 30) != 'S') {
            FragmentNewWalletBinding fragmentNewWalletBinding4 = (FragmentNewWalletBinding) getBinding();
            if (fragmentNewWalletBinding4 != null) {
                return fragmentNewWalletBinding4.n;
            }
            return null;
        }
        int i6 = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
        int i7 = i6 % 2;
        if (index != 3) {
            if ((index != 4) || (fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding()) == null) {
                return null;
            }
            return fragmentNewWalletBinding.scheduleImpl;
        }
        FragmentNewWalletBinding fragmentNewWalletBinding5 = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding5 != null) {
            int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
            PlaceComponentResult = i8 % 128;
            int i9 = i8 % 2;
            return fragmentNewWalletBinding5.getValueOfTouchPositionAbsolute;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0013, code lost:
    
        if (r7 != 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0016, code lost:
    
        if (r7 == 1) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0018, code lost:
    
        r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 19;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0021, code lost:
    
        if (r7 == 2) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0023, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0025, code lost:
    
        if (r7 == 3) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0027, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0029, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x002a, code lost:
    
        if (r3 == true) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x002d, code lost:
    
        if (r7 != 4) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x002f, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0036, code lost:
    
        if (r7 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0038, code lost:
    
        r5 = 18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x003b, code lost:
    
        r5 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x003c, code lost:
    
        if (r5 == 6) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x003e, code lost:
    
        r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 55;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0047, code lost:
    
        if ((r3 % 2) != 0) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0049, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x004a, code lost:
    
        if (r4 == true) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x004f, code lost:
    
        r7 = r7.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0051, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0059, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x005b, code lost:
    
        if (r7 == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0060, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0066, code lost:
    
        if (r7 == null) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x006b, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0071, code lost:
    
        if (r7 == null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0076, code lost:
    
        r7 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x007e, code lost:
    
        if (r7 == null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0080, code lost:
    
        r3 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0083, code lost:
    
        r3 = '9';
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0085, code lost:
    
        if (r3 == '9') goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0087, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0090, code lost:
    
        if ((r0 % 2) == 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0092, code lost:
    
        r7 = r7.NetworkUserEntityData$$ExternalSyntheticLambda7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0094, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x009b, code lost:
    
        return r7.NetworkUserEntityData$$ExternalSyntheticLambda7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:?, code lost:
    
        return r7.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:?, code lost:
    
        return r7.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:?, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:?, code lost:
    
        return r7.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:?, code lost:
    
        return r7.access$throwIllegalArgumentType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x000e, code lost:
    
        if (r7 != 0) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.widget.FrameLayout getFirstCardView(int r7) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L9e
            int r0 = r0 + 121
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L9c
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            if (r0 == 0) goto L13
            int r0 = r2.length     // Catch: java.lang.Throwable -> L11
            if (r7 == 0) goto L76
            goto L15
        L11:
            r7 = move-exception
            throw r7
        L13:
            if (r7 == 0) goto L76
        L15:
            r0 = 1
            if (r7 == r0) goto L6b
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r3 = r3 + 19
            int r4 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % r1
            if (r7 == r1) goto L60
            r3 = 3
            r4 = 0
            if (r7 == r3) goto L29
            r3 = 0
            goto L2a
        L29:
            r3 = 1
        L2a:
            if (r3 == r0) goto L55
            r3 = 4
            if (r7 != r3) goto L9b
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r7 = (id.dana.databinding.FragmentNewWalletBinding) r7
            r3 = 6
            if (r7 == 0) goto L3b
            r5 = 18
            goto L3c
        L3b:
            r5 = 6
        L3c:
            if (r5 == r3) goto L9b
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r3 = r3 + 55
            int r5 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r3 = r3 % r1
            if (r3 != 0) goto L4a
            r4 = 1
        L4a:
            if (r4 == r0) goto L4f
            android.widget.FrameLayout r2 = r7.getAuthRequestContext
            goto L9b
        L4f:
            android.widget.FrameLayout r7 = r7.getAuthRequestContext
            int r0 = r2.length     // Catch: java.lang.Throwable -> L53
            goto L95
        L53:
            r7 = move-exception
            throw r7
        L55:
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()     // Catch: java.lang.Exception -> L9e
            id.dana.databinding.FragmentNewWalletBinding r7 = (id.dana.databinding.FragmentNewWalletBinding) r7
            if (r7 == 0) goto L9b
            android.widget.FrameLayout r2 = r7.A     // Catch: java.lang.Exception -> L9c
            goto L9b
        L60:
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r7 = (id.dana.databinding.FragmentNewWalletBinding) r7
            if (r7 == 0) goto L9b
            android.widget.FrameLayout r2 = r7.access$throwIllegalArgumentType     // Catch: java.lang.Exception -> L9c
            goto L9b
        L6b:
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r7 = (id.dana.databinding.FragmentNewWalletBinding) r7
            if (r7 == 0) goto L9b
            android.widget.FrameLayout r2 = r7.b
            goto L9b
        L76:
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r7 = (id.dana.databinding.FragmentNewWalletBinding) r7
            r0 = 57
            if (r7 == 0) goto L83
            r3 = 92
            goto L85
        L83:
            r3 = 57
        L85:
            if (r3 == r0) goto L9b
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 71
            int r3 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r0 = r0 % r1
            if (r0 == 0) goto L99
            android.widget.FrameLayout r7 = r7.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r2.length     // Catch: java.lang.Throwable -> L97
        L95:
            r2 = r7
            goto L9b
        L97:
            r7 = move-exception
            throw r7
        L99:
            android.widget.FrameLayout r2 = r7.NetworkUserEntityData$$ExternalSyntheticLambda7
        L9b:
            return r2
        L9c:
            r7 = move-exception
            throw r7
        L9e:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getFirstCardView(int):android.widget.FrameLayout");
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x0015, code lost:
    
        if (r10 != 0) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x001a, code lost:
    
        if (r10 != 0) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x001c, code lost:
    
        if (r10 == 1) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0020, code lost:
    
        if (r10 == 2) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0022, code lost:
    
        if (r10 == 3) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0024, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0026, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0027, code lost:
    
        if (r1 == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0029, code lost:
    
        r10 = new android.widget.Space[4];
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0031, code lost:
    
        if (r0 == null) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0033, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x003c, code lost:
    
        if ((r1 % 2) == 0) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x003e, code lost:
    
        r0 = r0.VerifyPinStateManager$executeRiskChallenge$2$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0040, code lost:
    
        r1 = r7.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0044, code lost:
    
        r0 = r0.VerifyPinStateManager$executeRiskChallenge$2$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0047, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0048, code lost:
    
        r10[0] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0050, code lost:
    
        if (r0 == null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0052, code lost:
    
        r0 = r0.G;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0055, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0056, code lost:
    
        r10[1] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x005e, code lost:
    
        if (r0 == null) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0060, code lost:
    
        r0 = r0.AppCompatEmojiTextHelper;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0063, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0064, code lost:
    
        r10[2] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x006c, code lost:
    
        if (r0 == null) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x006e, code lost:
    
        r7 = r0.F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0070, code lost:
    
        r10[3] = r7;
        r10 = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0078, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x007b, code lost:
    
        if (r10 == 4) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0083, code lost:
    
        r10 = new android.widget.Space[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0089, code lost:
    
        r1 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x008b, code lost:
    
        if (r1 == null) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x008d, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x008f, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0090, code lost:
    
        if (r4 == true) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0092, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0094, code lost:
    
        r1 = r1.NetworkUserEntityData$$ExternalSyntheticLambda2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0096, code lost:
    
        r10[0] = r1;
        r1 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x009e, code lost:
    
        if (r1 == null) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x00a0, code lost:
    
        r4 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 109;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x00a9, code lost:
    
        if ((r4 % 2) != 0) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x00ab, code lost:
    
        r1 = r1.DatabaseTableConfigUtil;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x00ad, code lost:
    
        r7.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x00b3, code lost:
    
        r1 = r1.DatabaseTableConfigUtil;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x00b6, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x00b7, code lost:
    
        r10[1] = r1;
        r1 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x00bf, code lost:
    
        if (r1 == null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x00c1, code lost:
    
        r1 = r1.GetContactSyncConfig;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x00c4, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x00c5, code lost:
    
        r10[2] = r1;
        r1 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x00cd, code lost:
    
        if (r1 == null) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x00cf, code lost:
    
        r4 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 29;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x00d7, code lost:
    
        if ((r4 % 2) != 0) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x00d9, code lost:
    
        r7 = r1.initRecordTimeStamp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x00dd, code lost:
    
        r0 = 73 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x00e1, code lost:
    
        r7 = r1.initRecordTimeStamp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x00e3, code lost:
    
        r10[3] = r7;
        r10 = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x00eb, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x00ec, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x00ed, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x00ee, code lost:
    
        r10 = new android.widget.Space[4];
        r1 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x00f6, code lost:
    
        if (r1 == null) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x00f8, code lost:
    
        r4 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x00fb, code lost:
    
        r4 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x00fd, code lost:
    
        if (r4 == 29) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x00ff, code lost:
    
        r0 = r1.p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0102, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0103, code lost:
    
        r10[0] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x010b, code lost:
    
        if (r0 == null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x010d, code lost:
    
        r0 = r0.SizeSelectors$OrSelector;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0110, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0111, code lost:
    
        r10[1] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0119, code lost:
    
        if (r0 == null) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x011c, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x011d, code lost:
    
        if (r5 == false) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x011f, code lost:
    
        r0 = r0.r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0122, code lost:
    
        r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 33;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x012c, code lost:
    
        r10[2] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0134, code lost:
    
        if (r0 == null) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0136, code lost:
    
        r7 = r0.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0138, code lost:
    
        r10[3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0140, code lost:
    
        r10 = new android.widget.Space[4];
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0148, code lost:
    
        if (r0 == null) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x014a, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
        r1 = r1 % 2;
        r0 = r0.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0156, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0157, code lost:
    
        r10[0] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0161, code lost:
    
        if (r0 == null) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0163, code lost:
    
        r4 = 27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0166, code lost:
    
        r4 = '%';
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0168, code lost:
    
        if (r4 == 27) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x016a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x016c, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 93;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r0 = r0.FlowViewUtil$textChanges$1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0177, code lost:
    
        r10[1] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x017f, code lost:
    
        if (r0 == null) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0181, code lost:
    
        r0 = r0.connectForeground;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0184, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0185, code lost:
    
        r10[2] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x018d, code lost:
    
        if (r0 == null) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x018f, code lost:
    
        r7 = r0.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0191, code lost:
    
        r10[3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0198, code lost:
    
        r10 = new android.widget.Space[4];
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x01a0, code lost:
    
        if (r0 == null) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x01a2, code lost:
    
        r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x01a5, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x01a6, code lost:
    
        r10[0] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x01ae, code lost:
    
        if (r0 == null) goto L292;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x01b0, code lost:
    
        r0 = r0.getCallingPid;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x01b3, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x01b4, code lost:
    
        r10[1] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x01be, code lost:
    
        if (r0 == null) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x01c1, code lost:
    
        r1 = '4';
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x01c3, code lost:
    
        if (r1 == '4') goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x01c5, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1 % 128;
        r1 = r1 % 2;
        r0 = r0.whenAvailable;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x01d1, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x01d2, code lost:
    
        r10[2] = r0;
        r0 = (id.dana.databinding.FragmentNewWalletBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x01da, code lost:
    
        if (r0 == null) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x01dc, code lost:
    
        r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 85;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r7 = r0.readMicros;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x01e7, code lost:
    
        r10[3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x01ed, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:?, code lost:
    
        return kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:?, code lost:
    
        return kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:?, code lost:
    
        return kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:?, code lost:
    
        return kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) r10);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<android.widget.Space> getSpaceView(int r10) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.getSpaceView(int):java.util.List");
    }

    private final void addCardView(BaseWalletCardView view, FrameLayout cardView) {
        FrameLayout frameLayout;
        int i = 0;
        if (cardView instanceof ViewGroup) {
            int i2 = PlaceComponentResult + 71;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            frameLayout = cardView;
        } else {
            frameLayout = null;
        }
        if (frameLayout == null) {
            return;
        }
        int childCount = frameLayout.getChildCount();
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
        PlaceComponentResult = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            if ((i < childCount ? '\n' : 'L') == '\n') {
                frameLayout.removeViewAt(i);
                i++;
            } else {
                frameLayout.addView(view);
                return;
            }
        }
    }

    public final void showCardList(final int sectionIndex, final List<? extends WalletV3CardModel> list) {
        MotionLayout motionLayout;
        Intrinsics.checkNotNullParameter(list, "");
        removeAllCardListView(sectionIndex);
        int i = 0;
        for (Object obj : getSectionCardView(sectionIndex)) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FrameLayout frameLayout = (FrameLayout) obj;
            if (i > list.size() - 1) {
                break;
            }
            this.currentCardModelItems.add(list.get(i));
            WalletCardFactory walletCardFactory = WalletCardFactory.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            BaseWalletCardView generateCardView = walletCardFactory.generateCardView(requireContext, list.get(i), i);
            if (generateCardView != null) {
                int i2 = PlaceComponentResult + 115;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if (i2 % 2 == 0) {
                    int i3 = 43 / 0;
                    if (frameLayout == null) {
                    }
                    addCardView(generateCardView, frameLayout);
                } else {
                    if ((frameLayout != null ? Typography.less : ':') != '<') {
                    }
                    addCardView(generateCardView, frameLayout);
                }
            }
            i++;
        }
        FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
        if (!(fragmentNewWalletBinding == null)) {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
            PlaceComponentResult = i4 % 128;
            if (i4 % 2 != 0) {
                motionLayout = fragmentNewWalletBinding.Y;
                int i5 = 89 / 0;
                if (motionLayout == null) {
                    return;
                }
            } else {
                motionLayout = fragmentNewWalletBinding.Y;
                if (motionLayout == null) {
                    return;
                }
            }
            motionLayout.post(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.$r8$lambda$xl4smRYBBEdKGuHJOPK4yFB5Hr0(NewWalletFragment.this, sectionIndex, list);
                }
            });
        }
    }

    /* renamed from: showCardList$lambda-77 */
    private static final void m3091showCardList$lambda77(NewWalletFragment newWalletFragment, int i, List list) {
        int i2 = PlaceComponentResult + 99;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 20 : (char) 23) != 20) {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            Intrinsics.checkNotNullParameter(list, "");
            newWalletFragment.setSpaceVisibility(i, list.size());
            return;
        }
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        Intrinsics.checkNotNullParameter(list, "");
        newWalletFragment.setSpaceVisibility(i, list.size());
        int i3 = 90 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0034, code lost:
    
        if (r1 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0041, code lost:
    
        if ((r0 instanceof android.view.ViewGroup) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0043, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void removeAllCardListView(int r6) {
        /*
            r5 = this;
            java.util.List<id.dana.wallet_v3.model.WalletV3CardModel> r0 = r5.currentCardModelItems
            r0.clear()
            java.util.List r6 = r5.getSectionCardView(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        Lf:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L69
            if (r0 == 0) goto L68
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 59
            if (r0 != 0) goto L26
            r0 = 27
            goto L28
        L26:
            r0 = 59
        L28:
            r2 = 0
            if (r0 == r1) goto L39
            java.lang.Object r0 = r6.next()
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            boolean r1 = r0 instanceof android.view.ViewGroup
            int r3 = r2.length     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L46
            goto L43
        L37:
            r6 = move-exception
            throw r6
        L39:
            java.lang.Object r0 = r6.next()
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L46
        L43:
            r2 = r0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch: java.lang.Exception -> L69
        L46:
            if (r2 == 0) goto Lf
            r0 = 0
            int r1 = r2.getChildCount()
        L4d:
            r3 = 20
            if (r0 >= r1) goto L54
            r4 = 20
            goto L55
        L54:
            r4 = 4
        L55:
            if (r4 == r3) goto L58
            goto Lf
        L58:
            r2.removeViewAt(r0)
            int r0 = r0 + 1
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r3 = r3 + 121
            int r4 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % 2
            goto L4d
        L68:
            return
        L69:
            r6 = move-exception
            goto L6c
        L6b:
            throw r6
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.removeAllCardListView(int):void");
    }

    public final void showErrorState(int sectionIndex) {
        FrameLayout firstCardView = getFirstCardView(sectionIndex);
        if (firstCardView != null) {
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
                try {
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    WalletCardFactory walletCardFactory = WalletCardFactory.INSTANCE;
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "");
                    addEmptyCardView(sectionIndex, walletCardFactory.generateErrorStateCardView(requireContext), firstCardView);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = PlaceComponentResult + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? ':' : '\n') != ':') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0026, code lost:
    
        if ((r0 != null ? 23 : '5') != '5') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x003f, code lost:
    
        if ((r0 != null ? '[' : '\b') != '\b') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0041, code lost:
    
        r2 = id.dana.wallet_v3.factory.WalletCardFactory.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0043, code lost:
    
        r3 = requireContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        addEmptyCardView(r5.getIndex(), r2.generateEmptyCardView(r3, r5.getType()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x005a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x005b, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x005c, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x005d, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showEmptyState(id.dana.wallet_v3.model.WalletSectionModel r5) {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            java.lang.String r1 = ""
            if (r0 != 0) goto L2b
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            int r0 = r5.getIndex()
            android.widget.FrameLayout r0 = r4.getFirstCardView(r0)
            r2 = 64
            int r2 = r2 / 0
            r2 = 53
            if (r0 == 0) goto L24
            r3 = 23
            goto L26
        L24:
            r3 = 53
        L26:
            if (r3 == r2) goto L5e
            goto L41
        L29:
            r5 = move-exception
            throw r5
        L2b:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            int r0 = r5.getIndex()
            android.widget.FrameLayout r0 = r4.getFirstCardView(r0)
            r2 = 8
            if (r0 == 0) goto L3d
            r3 = 91
            goto L3f
        L3d:
            r3 = 8
        L3f:
            if (r3 == r2) goto L5e
        L41:
            id.dana.wallet_v3.factory.WalletCardFactory r2 = id.dana.wallet_v3.factory.WalletCardFactory.INSTANCE     // Catch: java.lang.Exception -> L5c
            android.content.Context r3 = r4.requireContext()     // Catch: java.lang.Exception -> L5a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch: java.lang.Exception -> L5a
            java.lang.String r1 = r5.getType()     // Catch: java.lang.Exception -> L5a
            id.dana.richview.wallet.BaseWalletCardView r1 = r2.generateEmptyCardView(r3, r1)     // Catch: java.lang.Exception -> L5a
            int r5 = r5.getIndex()     // Catch: java.lang.Exception -> L5a
            r4.addEmptyCardView(r5, r1, r0)     // Catch: java.lang.Exception -> L5a
            goto L5e
        L5a:
            r5 = move-exception
            throw r5
        L5c:
            r5 = move-exception
            throw r5
        L5e:
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 19
            int r0 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r0
            int r5 = r5 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.showEmptyState(id.dana.wallet_v3.model.WalletSectionModel):void");
    }

    private final void addEmptyCardView(final int sectionIndex, BaseWalletCardView view, FrameLayout cardView) {
        FrameLayout frameLayout;
        MotionLayout motionLayout;
        int i = PlaceComponentResult + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Object obj = null;
        if (cardView instanceof ViewGroup) {
            int i3 = PlaceComponentResult + 115;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? '!' : (char) 29) != 29) {
                frameLayout = cardView;
                obj.hashCode();
            } else {
                try {
                    frameLayout = cardView;
                } catch (Exception e) {
                    throw e;
                }
            }
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            if (frameLayout.getChildCount() != 0) {
                int i4 = PlaceComponentResult + 121;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int childCount = !(i4 % 2 == 0) ? frameLayout.getChildCount() : frameLayout.getChildCount();
                int i5 = 0;
                while (i5 < childCount) {
                    int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
                    PlaceComponentResult = i6 % 128;
                    if (i6 % 2 != 0) {
                        frameLayout.removeViewAt(i5);
                        i5 += 8;
                    } else {
                        frameLayout.removeViewAt(i5);
                        i5++;
                    }
                }
            }
            frameLayout.addView(view);
        }
        FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding != null) {
            int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
            PlaceComponentResult = i7 % 128;
            if (!(i7 % 2 != 0)) {
                motionLayout = fragmentNewWalletBinding.Y;
                if (motionLayout == null) {
                    return;
                }
            } else {
                motionLayout = fragmentNewWalletBinding.Y;
                obj.hashCode();
                if (motionLayout == null) {
                    return;
                }
            }
            motionLayout.post(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment.$r8$lambda$WNjv5dEMwAG4YwBjJR0l55gRNeU(NewWalletFragment.this, sectionIndex);
                }
            });
            int i8 = PlaceComponentResult + 13;
            KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
            int i9 = i8 % 2;
        }
    }

    /* renamed from: addEmptyCardView$lambda-83 */
    private static final void m3049addEmptyCardView$lambda83(NewWalletFragment newWalletFragment, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        newWalletFragment.setSpaceVisibility(i, 1);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        PlaceComponentResult = i4 % 128;
        int i5 = i4 % 2;
    }

    private final void setSpaceVisibility(int sectionIndex, int r9) {
        int i = PlaceComponentResult + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        List<Space> spaceView = getSpaceView(sectionIndex);
        if (r9 == 1) {
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 0));
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 1));
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 2));
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 3));
            return;
        }
        int i3 = PlaceComponentResult + 109;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        if ((r9 != 2 ? Typography.less : (char) 17) != '<') {
            addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 0), MARGIN_SPACE_BIG);
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 1));
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 2));
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 3));
            int i5 = PlaceComponentResult + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            if (i5 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                return;
            }
            return;
        }
        if (!(r9 != 3)) {
            addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 0), MARGIN_SPACE_BIG);
            addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 1), MARGIN_SPACE_BIG);
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 2));
            removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 3));
            return;
        }
        try {
            int i6 = PlaceComponentResult + 87;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
                if (r9 == 4) {
                    addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 0), MARGIN_SPACE_BIG);
                    addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 1), MARGIN_SPACE_BIG);
                    addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 2), 8.0f);
                    removeSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 3));
                    return;
                }
                int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
                PlaceComponentResult = i8 % 128;
                int i9 = i8 % 2;
                addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 0), MARGIN_SPACE_BIG);
                addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 1), MARGIN_SPACE_BIG);
                addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 2), 8.0f);
                addSpaceHeight((Space) CollectionsKt.getOrNull(spaceView, 3), 8.0f);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x0039, code lost:
    
        if (r0 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0043, code lost:
    
        if ((r0 == null) != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0047, code lost:
    
        r0 = r0.getConstraintSet(id.dana.R.id.cs_initial);
        r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 49;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void removeSpaceHeight(android.widget.Space r7) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L17
            if (r7 == 0) goto La6
            goto L1c
        L17:
            r3.hashCode()     // Catch: java.lang.Throwable -> La7
            if (r7 == 0) goto La6
        L1c:
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            if (r0 == 0) goto L26
            r4 = 1
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 == r2) goto L2a
            goto L45
        L2a:
            int r4 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + r2
            int r5 = r4 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L3e
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.Y
            r2 = 6
            int r2 = r2 / r1
            if (r0 == 0) goto L45
            goto L47
        L3c:
            r7 = move-exception
            throw r7
        L3e:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.Y
            if (r0 == 0) goto L43
            r2 = 0
        L43:
            if (r2 == 0) goto L47
        L45:
            r0 = r3
            goto L58
        L47:
            r2 = 2131363114(0x7f0a052a, float:1.8346028E38)
            androidx.constraintlayout.widget.ConstraintSet r0 = r0.getConstraintSet(r2)
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r2 = r2 + 49
            int r4 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r2 = r2 % 2
        L58:
            r2 = 68
            if (r0 == 0) goto L5f
            r4 = 68
            goto L60
        L5f:
            r4 = 4
        L60:
            if (r4 == r2) goto L63
            goto L79
        L63:
            int r7 = r7.getId()
            androidx.constraintlayout.widget.ConstraintSet$Constraint r7 = r0.KClassImpl$Data$declaredNonStaticMembers$2(r7)
            androidx.constraintlayout.widget.ConstraintSet$Layout r7 = r7.BuiltInFictitiousFunctionClassFactory
            r7.G = r1
            int r7 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 43
            int r1 = r7 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r7 = r7 % 2
        L79:
            r7 = 45
            if (r0 == 0) goto L80
            r1 = 80
            goto L82
        L80:
            r1 = 45
        L82:
            if (r1 == r7) goto La6
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r7 = (id.dana.databinding.FragmentNewWalletBinding) r7
            if (r7 == 0) goto La1
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r1 = r1 + 47
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L9f
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r7.Y
            int r1 = r3.length     // Catch: java.lang.Throwable -> L9d
            r3 = r7
            goto La1
        L9d:
            r7 = move-exception
            throw r7
        L9f:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r7.Y
        La1:
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r3)
        La6:
            return
        La7:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.removeSpaceHeight(android.widget.Space):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addSpaceHeight(android.widget.Space r5, float r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L77
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            r1 = 31
            if (r0 == 0) goto Lf
            r2 = 31
            goto L11
        Lf:
            r2 = 48
        L11:
            r3 = 0
            if (r2 == r1) goto L15
            goto L34
        L15:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.Y
            r1 = 91
            if (r0 == 0) goto L1e
            r2 = 52
            goto L20
        L1e:
            r2 = 91
        L20:
            if (r2 == r1) goto L34
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r1 = r1 + 93
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            r1 = 2131363114(0x7f0a052a, float:1.8346028E38)
            androidx.constraintlayout.widget.ConstraintSet r0 = r0.getConstraintSet(r1)
            goto L3f
        L34:
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r0 = r3
        L3f:
            if (r0 == 0) goto L51
            int r5 = r5.getId()
            int r6 = id.dana.extension.view.ViewExtKt.PlaceComponentResult(r6)
            androidx.constraintlayout.widget.ConstraintSet$Constraint r5 = r0.KClassImpl$Data$declaredNonStaticMembers$2(r5)
            androidx.constraintlayout.widget.ConstraintSet$Layout r5 = r5.BuiltInFictitiousFunctionClassFactory
            r5.G = r6
        L51:
            if (r0 == 0) goto L77
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r5 = (id.dana.databinding.FragmentNewWalletBinding) r5
            if (r5 == 0) goto L72
            int r6 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 39
            int r1 = r6 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r1
            int r6 = r6 % 2
            if (r6 == 0) goto L70
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r5.Y
            r3.hashCode()     // Catch: java.lang.Throwable -> L6e
            r3 = r5
            goto L72
        L6e:
            r5 = move-exception
            throw r5
        L70:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r5.Y
        L72:
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r3)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.addSpaceHeight(android.widget.Space, float):void");
    }

    private final int getFirstCardHeight(int sectionIndex) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        FrameLayout firstCardView = getFirstCardView(sectionIndex);
        if (firstCardView == null) {
            return 0;
        }
        int height = firstCardView.getHeight();
        int i3 = PlaceComponentResult + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return height;
    }

    /* renamed from: showLoadingStateSection$lambda-84 */
    private static final void m3092showLoadingStateSection$lambda84(NewWalletFragment newWalletFragment, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? '5' : '\r') != '\r') {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.setSpaceVisibility(i, 0);
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(newWalletFragment, "");
            newWalletFragment.setSpaceVisibility(i, 1);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0019, code lost:
    
        if (r0 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x002e, code lost:
    
        if ((r0 != null ? 16 : 'O') != 16) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0031, code lost:
    
        r0 = r0.Y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0033, code lost:
    
        if (r0 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0035, code lost:
    
        r0.post(new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda39());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showLoadingStateSection(final int r7) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.showLoadingStateSection(int):void");
    }

    private final void dismissLoadingStateSection(int sectionIndex) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        FrameLayout skeletonView = getSkeletonView(sectionIndex);
        if (!(skeletonView == null)) {
            skeletonView.setVisibility(8);
        }
        try {
            SkeletonScreen skeletonScreen = (SkeletonScreen) CollectionsKt.getOrNull(this.skeletonScreenList, sectionIndex);
            if ((skeletonScreen != null ? Typography.dollar : (char) 17) != 17) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 != 0) {
                    skeletonScreen.PlaceComponentResult();
                    Object obj = null;
                    obj.hashCode();
                } else {
                    skeletonScreen.PlaceComponentResult();
                }
            }
            setCardsViewVisibility(sectionIndex, 0);
            try {
                this.isShowSkeletonList.set(sectionIndex, Boolean.FALSE);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0024, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0029, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x002b, code lost:
    
        r0.post(new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda8());
        r5 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult + 111;
        id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void adjustCardSpacing(final int r5, final java.util.List<? extends id.dana.wallet_v3.model.WalletV3CardModel> r6) {
        /*
            r4 = this;
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r0 = (id.dana.databinding.FragmentNewWalletBinding) r0
            r1 = 60
            if (r0 == 0) goto Ld
            r2 = 60
            goto Lf
        Ld:
            r2 = 33
        Lf:
            r3 = 0
            if (r2 == r1) goto L13
            goto L3d
        L13:
            int r1 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r1 = r1 + 115
            int r2 = r1 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.Y
            if (r1 != 0) goto L29
            r3.hashCode()     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L3d
            goto L2b
        L27:
            r5 = move-exception
            throw r5
        L29:
            if (r0 == 0) goto L3d
        L2b:
            id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda8 r1 = new id.dana.wallet_v3.view.NewWalletFragment$$ExternalSyntheticLambda8
            r1.<init>()
            r0.post(r1)
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r5 = r5 + 111
            int r6 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
        L3d:
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r5 = r5 + 101
            int r6 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L4d
            int r5 = r3.length     // Catch: java.lang.Throwable -> L4b
            return
        L4b:
            r5 = move-exception
            throw r5
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.adjustCardSpacing(int, java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0074, code lost:
    
        if (r2 != null) goto L94;
     */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* renamed from: adjustCardSpacing$lambda-86 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m3050adjustCardSpacing$lambda86(java.util.List r7, id.dana.wallet_v3.view.NewWalletFragment r8, int r9) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            id.dana.wallet_v3.model.PaymentCardModel$EmptyCard r0 = new id.dana.wallet_v3.model.PaymentCardModel$EmptyCard
            r1 = 0
            r2 = 1
            r0.<init>(r1, r2, r1)
            boolean r7 = r7.contains(r0)
            r0 = 13
            if (r7 == 0) goto L1a
            r7 = 59
            goto L1c
        L1a:
            r7 = 13
        L1c:
            if (r7 == r0) goto L24
            r7 = 0
            int r7 = id.dana.extension.view.ViewExtKt.PlaceComponentResult(r7)
            goto L2f
        L24:
            int r7 = r8.getFirstCardHeight(r9)
            r0 = 1121189888(0x42d40000, float:106.0)
            int r0 = id.dana.extension.view.ViewExtKt.PlaceComponentResult(r0)
            int r7 = r7 - r0
        L2f:
            androidx.appcompat.widget.AppCompatImageView r9 = r8.getDivider(r9)
            r0 = 0
            if (r9 == 0) goto L38
            r3 = 0
            goto L39
        L38:
            r3 = 1
        L39:
            if (r3 == r2) goto L4a
            int r9 = r9.getId()
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 105
            int r4 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r4
            int r3 = r3 % 2
            goto L4b
        L4a:
            r9 = 0
        L4b:
            androidx.viewbinding.ViewBinding r3 = r8.getBinding()
            id.dana.databinding.FragmentNewWalletBinding r3 = (id.dana.databinding.FragmentNewWalletBinding) r3
            r4 = 37
            if (r3 == 0) goto L58
            r5 = 54
            goto L5a
        L58:
            r5 = 37
        L5a:
            if (r5 == r4) goto Lb1
            int r5 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r5 = r5 + 99
            int r6 = r5 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            r6 = 4
            if (r5 != 0) goto L6c
            r5 = 98
            goto L6d
        L6c:
            r5 = 4
        L6d:
            if (r5 == r6) goto L79
            androidx.constraintlayout.motion.widget.MotionLayout r2 = r3.Y
            r3 = 93
            int r3 = r3 / r0
            if (r2 == 0) goto Lb1
            goto L82
        L77:
            r7 = move-exception
            throw r7
        L79:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r3.Y
            if (r3 == 0) goto L7e
            r0 = 1
        L7e:
            if (r0 == r2) goto L81
            goto Lb1
        L81:
            r2 = r3
        L82:
            r0 = 2131363114(0x7f0a052a, float:1.8346028E38)
            androidx.constraintlayout.widget.ConstraintSet r0 = r2.getConstraintSet(r0)
            if (r0 == 0) goto Lb1
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            r3 = 69
            int r2 = r2 + r3
            int r5 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r2 = r2 % 2
            if (r2 != 0) goto L9a
            r4 = 69
        L9a:
            if (r4 == r3) goto La5
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2(r9)
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r0.BuiltInFictitiousFunctionClassFactory
            r0.BuiltInFictitiousFunctionClassFactory = r7
            goto Lb1
        La5:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2(r9)
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r0.BuiltInFictitiousFunctionClassFactory
            r0.BuiltInFictitiousFunctionClassFactory = r7
            int r0 = r1.length     // Catch: java.lang.Throwable -> Laf
            goto Lb1
        Laf:
            r7 = move-exception
            throw r7
        Lb1:
            r8.setTooltipConstraintSetMargin(r9, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.m3050adjustCardSpacing$lambda86(java.util.List, id.dana.wallet_v3.view.NewWalletFragment, int):void");
    }

    private final void setCardsViewVisibility(int sectionIndex, int visibility) {
        FrameLayout frameLayout;
        Iterator<T> it = getSectionCardView(sectionIndex).iterator();
        while (true) {
            if (!it.hasNext()) {
                return;
            }
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? '\b' : '0') != '\b') {
                frameLayout = (FrameLayout) it.next();
                if (frameLayout != null) {
                    ViewExtKt.PlaceComponentResult(frameLayout, visibility);
                    int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                    PlaceComponentResult = i2 % 128;
                    int i3 = i2 % 2;
                }
            } else {
                frameLayout = (FrameLayout) it.next();
                Object obj = null;
                obj.hashCode();
                if ((frameLayout != null ? 'T' : '[') != '[') {
                    ViewExtKt.PlaceComponentResult(frameLayout, visibility);
                    int i22 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                    PlaceComponentResult = i22 % 128;
                    int i32 = i22 % 2;
                }
            }
        }
    }

    private final void toggleSectionSkeletonVisibility(int sectionIndex, int visibility) {
        FrameLayout skeletonView = getSkeletonView(sectionIndex);
        if (skeletonView != null) {
            int i = PlaceComponentResult + 49;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            ViewExtKt.PlaceComponentResult(skeletonView, visibility);
        }
        View sectionViewTop = getSectionViewTop(sectionIndex);
        if (sectionViewTop != null) {
            try {
                int i3 = PlaceComponentResult + 125;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                ViewExtKt.PlaceComponentResult(sectionViewTop, visibility);
                if (i4 == 0) {
                    int i5 = 23 / 0;
                }
                int i6 = PlaceComponentResult + 21;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private final int getIndexBasedOnType(@WalletSectionType String sectionType) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            List<String> list = this.walletSectionOrderingList;
            String lowerCase = sectionType.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            int indexOf = list.indexOf(lowerCase);
            int i3 = PlaceComponentResult + 47;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                return indexOf;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return indexOf;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void setupLottieBasedOnLanguage(boolean isDefaultIndonesian) {
        LottieAnimationView lottieAnimationView;
        String str = isDefaultIndonesian ? "json/lottie/wallet_expand_detail_page_id.lottie" : "json/lottie/wallet_expand_detail_page_en.lottie";
        FragmentNewWalletBinding fragmentNewWalletBinding = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding != null) {
            try {
                LottieAnimationView lottieAnimationView2 = fragmentNewWalletBinding.U;
                if ((lottieAnimationView2 != null ? '\n' : '\t') != '\t') {
                    int i = PlaceComponentResult + 25;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    if (i % 2 == 0) {
                        lottieAnimationView2.setAnimation(str);
                        Object obj = null;
                        obj.hashCode();
                    } else {
                        try {
                            lottieAnimationView2.setAnimation(str);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        FragmentNewWalletBinding fragmentNewWalletBinding2 = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding2 != null) {
            LottieAnimationView lottieAnimationView3 = fragmentNewWalletBinding2.isAuto;
            if (lottieAnimationView3 != null) {
                lottieAnimationView3.setAnimation(str);
            }
        }
        FragmentNewWalletBinding fragmentNewWalletBinding3 = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding3 != null) {
            LottieAnimationView lottieAnimationView4 = fragmentNewWalletBinding3.Z;
            if ((lottieAnimationView4 != null ? '4' : 'a') == '4') {
                lottieAnimationView4.setAnimation(str);
            }
        }
        FragmentNewWalletBinding fragmentNewWalletBinding4 = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding4 != null && (lottieAnimationView = fragmentNewWalletBinding4.X) != null) {
            int i2 = PlaceComponentResult + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            lottieAnimationView.setAnimation(str);
            int i4 = PlaceComponentResult + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
        }
        FragmentNewWalletBinding fragmentNewWalletBinding5 = (FragmentNewWalletBinding) getBinding();
        if (fragmentNewWalletBinding5 != null) {
            LottieAnimationView lottieAnimationView5 = fragmentNewWalletBinding5.V;
            if (lottieAnimationView5 != null) {
                int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                PlaceComponentResult = i6 % 128;
                int i7 = i6 % 2;
                lottieAnimationView5.setAnimation(str);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0083T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/wallet_v3/view/NewWalletFragment$Companion;", "", "", "DEFAULT_CACHE_DURATION_IN_MINUTES", "I", "FIFTH_SECTION_INDEX", "FIRST_SECTION_INDEX", "FOURTH_SECTION_INDEX", "IDENTITY_REQUEST_CODE", "getIDENTITY_REQUEST_CODE", "()I", "", "MARGIN_BOTTOM_EMPTY_STATE", LogConstants.RESULT_FALSE, "MARGIN_BOTTOM_WALLET_ASSET", "MARGIN_SPACE_BIG", "MARGIN_SPACE_SMALL", "SECOND_SECTION_INDEX", "SPOTLIGHT_SIZE", "THIRD_SECTION_INDEX", "", NewWalletFragment.WALLET_SECTION, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getIDENTITY_REQUEST_CODE")
        public final int getIDENTITY_REQUEST_CODE() {
            return NewWalletFragment.access$getIDENTITY_REQUEST_CODE$cp();
        }
    }

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
        IDENTITY_REQUEST_CODE = RandomInteger.BuiltInFictitiousFunctionClassFactory();
        int i = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0057, code lost:
    
        if (r2 == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0069, code lost:
    
        if ((kotlin.jvm.internal.Intrinsics.areEqual(r8, getExpectedSection(r1))) != false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void checkAnyPendingOpenDeeplink(java.util.List<java.lang.Boolean> r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r0 = 0
            r1 = 0
        L12:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto Lb1
            java.lang.Object r2 = r7.next()
            r3 = 63
            if (r1 >= 0) goto L30
            int r4 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L2d
            int r4 = r4 + r3
            int r5 = r4 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r5     // Catch: java.lang.Exception -> L2d
            int r4 = r4 % 2
            kotlin.collections.CollectionsKt.throwIndexOverflow()
            goto L30
        L2d:
            r7 = move-exception
            goto Lb0
        L30:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L3b
            r2 = 63
            goto L3d
        L3b:
            r2 = 80
        L3d:
            r4 = 0
            r5 = 1
            if (r2 == r3) goto L42
            goto L6c
        L42:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 89
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L5c
            java.lang.String r2 = r6.getExpectedSection(r1)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r2)
            int r3 = r4.length     // Catch: java.lang.Throwable -> L5a
            if (r2 != 0) goto L74
            goto L6c
        L5a:
            r7 = move-exception
            throw r7
        L5c:
            java.lang.String r2 = r6.getExpectedSection(r1)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r2)
            if (r2 != 0) goto L68
            r2 = 0
            goto L69
        L68:
            r2 = 1
        L69:
            if (r2 == 0) goto L6c
            goto L74
        L6c:
            java.lang.String r2 = "identity"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r2)     // Catch: java.lang.Exception -> L2d
            if (r2 == 0) goto Lac
        L74:
            r6.openWalletSection(r8)
            androidx.fragment.app.Fragment r2 = r6.getParentFragment()
            boolean r3 = r2 instanceof id.dana.animation.tab.HomeTabFragment
            if (r3 == 0) goto L81
            r3 = 0
            goto L82
        L81:
            r3 = 1
        L82:
            if (r3 == r5) goto L87
            id.dana.home.tab.HomeTabFragment r2 = (id.dana.animation.tab.HomeTabFragment) r2
            goto L88
        L87:
            r2 = r4
        L88:
            if (r2 == 0) goto Lac
            int r3 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r3 = r3 + 37
            int r5 = r3 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r3 = r3 % 2
            java.lang.String r5 = ""
            if (r3 != 0) goto La0
            r2.FragmentBottomSheetPaymentSettingBinding = r5     // Catch: java.lang.Exception -> L9e
            int r2 = r4.length     // Catch: java.lang.Throwable -> L9c
            goto La2
        L9c:
            r7 = move-exception
            throw r7
        L9e:
            r7 = move-exception
            throw r7
        La0:
            r2.FragmentBottomSheetPaymentSettingBinding = r5
        La2:
            int r2 = id.dana.wallet_v3.view.NewWalletFragment.PlaceComponentResult
            int r2 = r2 + 99
            int r3 = r2 % 128
            id.dana.wallet_v3.view.NewWalletFragment.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
        Lac:
            int r1 = r1 + 1
            goto L12
        Lb0:
            throw r7
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.NewWalletFragment.checkAnyPendingOpenDeeplink(java.util.List, java.lang.String):void");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = MyBillsEntityDataFactory;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i3 = 0;
            while (true) {
                if (!(i3 < length)) {
                    break;
                }
                int i4 = $10 + 51;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                iArr3[i3] = (int) (iArr2[i3] ^ (-3152031022165484798L));
                i3++;
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = MyBillsEntityDataFactory;
        if (!(iArr5 != null)) {
            i2 = length2;
        } else {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i6 = 0;
            while (true) {
                if (!(i6 < length3)) {
                    break;
                }
                iArr6[i6] = (int) (iArr5[i6] ^ (-3152031022165484798L));
                i6++;
                length2 = length2;
            }
            i2 = length2;
            iArr5 = iArr6;
        }
        try {
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length ? (char) 1 : Typography.amp) == '&') {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
                int i7 = $11 + 29;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                int i9 = $11 + 53;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                int i11 = 0;
                while (true) {
                    if (!(i11 < 16)) {
                        break;
                    }
                    int i12 = $11 + 61;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i11];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i14;
                    i11++;
                }
                int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i17 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                try {
                    int i18 = $10 + 21;
                    $11 = i18 % 128;
                    int i19 = i18 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
