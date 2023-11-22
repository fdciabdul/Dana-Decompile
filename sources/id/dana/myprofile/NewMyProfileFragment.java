package id.dana.myprofile;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ethanhua.skeleton.SkeletonScreen;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.push.e;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingToolbarFragment;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.deeplink.path.FeatureSaving;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterViewListener;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.data.profilemenu.MyProfileMenuCategories;
import id.dana.data.util.DateTimeUtil;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.FragmentMyprofileMainBinding;
import id.dana.databinding.NewFragmentMyprofileBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNewMyProfileComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.DanaPlusModule;
import id.dana.di.modules.GoldInvestmentModule;
import id.dana.di.modules.InvestmentModule;
import id.dana.di.modules.MyProfileModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.UserStatementModule;
import id.dana.dialog.LoadingDialog;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.domain.model.KycStatus;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.domain.profilemenu.model.ProfileCompletion;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.model.UserConfigProfileNewFlag;
import id.dana.domain.statement.StatementType;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.familyaccount.util.FamilyStatusActionUtil;
import id.dana.familyaccount.util.TopUpUserConsultManager;
import id.dana.feeds.data.username.source.network.request.UpdateUserInfoRequest;
import id.dana.investment.contract.DanaPlusContract;
import id.dana.investment.contract.GoldInvestmentContract;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.listener.DanaPlusViewListener;
import id.dana.investment.model.UserInvestmentModel;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.ProfileServicesUrlMapper;
import id.dana.merchantmanagement.view.MerchantManagementActivity;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.ThirdPartyService;
import id.dana.model.UserInfo;
import id.dana.mybills.MyBillsActivity;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.adapter.MyProfileDiffutilAdapter;
import id.dana.myprofile.mapper.SavingSummarySettingMapper;
import id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity;
import id.dana.myprofile.model.QrisTciCoConfigModel;
import id.dana.onboarding.OnboardingActivity;
import id.dana.pay.PayCardInfo;
import id.dana.pay.model.PayCardConfigModel;
import id.dana.productpage.ProductPageManagerExtKt;
import id.dana.promoquest.activity.MissionListActivity;
import id.dana.pushverify.view.verificationlist.VerificationListActivity;
import id.dana.referral.MyReferralDetailActivity;
import id.dana.richview.NewSimpleProfileWithQrView;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.contract.SavingViewListener;
import id.dana.savings.model.SavingSummaryModel;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.service.ServiceMaintenanceUtil;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.target.Target;
import id.dana.social.utils.SaveContactSyncManagerKt;
import id.dana.social.utils.SocialSyncManagerKt;
import id.dana.social.view.activity.ChangeUsernameActivity;
import id.dana.statement.TimeUnitInterval;
import id.dana.statement.UserStatementContract;
import id.dana.statement.UserStatementListener;
import id.dana.statement.model.StatementSummaryInit;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.twilio.onboarding.TwilioIntroductionActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.BalanceUtil;
import id.dana.utils.CustomLinearLayoutManager;
import id.dana.utils.ErrorUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.SizeUtil;
import id.dana.utils.TagFormat;
import id.dana.utils.UrlUtil;
import id.dana.utils.VersionUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.handpick.HandPicked;
import id.dana.utils.handpick.HandPickedResultHandler;
import id.dana.utils.permission.PermissionHelper;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000Æ\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u009b\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u009b\u0002B\b¢\u0006\u0005\b\u009a\u0002\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0010\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010\u001fJ\u0011\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\nJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\t\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\nJ\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b5\u0010\u0015J\u000f\u00107\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b:\u0010;J\u0011\u0010=\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0016H\u0014¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bQ\u0010RJ\u0019\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0004H\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u00020WH\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0013H\u0002¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\\\u0010\nJ\u000f\u0010^\u001a\u00020]H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010\u000b\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u000b\u0010`J\u0017\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u000e\u0010`J\u0017\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u000f\u0010`J\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0004\b\u0010\u0010bJ\u000f\u0010c\u001a\u00020\u0006H\u0002¢\u0006\u0004\bc\u0010\nJ\u000f\u0010d\u001a\u00020\u0006H\u0002¢\u0006\u0004\bd\u0010\nJ\u000f\u0010e\u001a\u00020\u0006H\u0014¢\u0006\u0004\be\u0010\nJ\u000f\u0010f\u001a\u00020\u0006H\u0002¢\u0006\u0004\bf\u0010\nJ\u000f\u0010g\u001a\u00020\u0006H\u0002¢\u0006\u0004\bg\u0010\nJ\u000f\u0010h\u001a\u00020\u0006H\u0002¢\u0006\u0004\bh\u0010\nJ\u000f\u0010i\u001a\u00020\u0006H\u0002¢\u0006\u0004\bi\u0010\nJ\u000f\u0010j\u001a\u00020\u0006H\u0002¢\u0006\u0004\bj\u0010\nJ\u000f\u0010k\u001a\u00020\u0006H\u0002¢\u0006\u0004\bk\u0010\nJ\u000f\u0010l\u001a\u00020\u0006H\u0002¢\u0006\u0004\bl\u0010\nJ\u000f\u0010m\u001a\u00020\u0006H\u0002¢\u0006\u0004\bm\u0010\nJ\u000f\u0010n\u001a\u00020\u0006H\u0002¢\u0006\u0004\bn\u0010\nJ\u000f\u0010o\u001a\u00020\u0006H\u0002¢\u0006\u0004\bo\u0010\nJ\u000f\u0010p\u001a\u00020\u0006H\u0002¢\u0006\u0004\bp\u0010\nJ\u0017\u0010(\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020qH\u0014¢\u0006\u0004\b(\u0010rJ\u000f\u0010t\u001a\u00020sH\u0002¢\u0006\u0004\bt\u0010uJ\u0017\u0010\r\u001a\u00020s2\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\r\u0010vJ\u0017\u0010\f\u001a\u00020s2\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\f\u0010vJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0007\u0010*J\u0017\u0010w\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\bw\u0010*J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0012\u0010*J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020sH\u0016¢\u0006\u0004\b\u0010\u0010xJ\u0019\u0010y\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010qH\u0016¢\u0006\u0004\by\u0010zJ\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010*J\u0017\u0010{\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b{\u0010*J\u000f\u0010w\u001a\u00020\u0006H\u0016¢\u0006\u0004\bw\u0010\nJ\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020|H\u0016¢\u0006\u0004\b\u0010\u0010}J\u0017\u0010w\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020aH\u0016¢\u0006\u0004\bw\u0010bJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020~H\u0016¢\u0006\u0004\b\"\u0010\u007fJ\u0019\u0010w\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030\u0080\u0001H\u0016¢\u0006\u0005\bw\u0010\u0081\u0001J\u0019\u0010\"\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0005\b\"\u0010\u0083\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u001f\u0010\"\u001a\u00020\u00062\r\u0010\u0005\u001a\t\u0012\u0004\u0012\u00020\u00040\u0084\u0001H\u0016¢\u0006\u0005\b\"\u0010\u0085\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030\u0086\u0001H\u0016¢\u0006\u0005\b\u0007\u0010\u0087\u0001J\u0017\u0010w\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020sH\u0016¢\u0006\u0004\bw\u0010xJ\u0019\u0010\u0088\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020sH\u0016¢\u0006\u0005\b\u0088\u0001\u0010xJ\u0011\u0010\u0089\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0089\u0001\u0010\nJ\u0011\u0010\u008a\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u008a\u0001\u0010\nJ\u0019\u0010(\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030\u0086\u0001H\u0016¢\u0006\u0005\b(\u0010\u0087\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u008b\u0001\u0010\nJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020sH\u0016¢\u0006\u0004\b\"\u0010xJ\u0011\u0010\u008c\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u008c\u0001\u0010\nJ\u0019\u0010\"\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030\u008d\u0001H\u0016¢\u0006\u0005\b\"\u0010\u008e\u0001J$\u0010w\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0005\bw\u0010\u008f\u0001J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010*J\u0011\u0010\u0090\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0090\u0001\u0010\nJ-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020s2\b\u0010!\u001a\u0004\u0018\u00010\u00132\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0005\b\u0007\u0010\u0092\u0001J\u0011\u0010\u0093\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0093\u0001\u0010\nJ\u0011\u0010\u0094\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0094\u0001\u0010\nJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0011\u0010*J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\bJ\u0011\u0010\u0095\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0095\u0001\u0010\nJ\u0011\u0010\u0096\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0096\u0001\u0010\nJ\u0017\u0010w\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bw\u0010\bJ\u0011\u0010\u0097\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0097\u0001\u0010\nJ\u0017\u0010S\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bS\u0010\bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u0011\u0010\u0098\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0098\u0001\u0010\nJ\u0011\u0010\u0099\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0099\u0001\u0010\nJ\u0011\u0010\u009a\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u009a\u0001\u0010\nJ\u0011\u0010\u009b\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u009b\u0001\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0005\b\u0007\u0010\u009d\u0001J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010*J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0011\u0010\u009e\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u009e\u0001\u0010\nJ\u0011\u0010\u009f\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u009f\u0001\u0010\nJ&\u0010\u0010\u001a\t\u0012\u0004\u0012\u00020\u00040\u0084\u00012\r\u0010\u0005\u001a\t\u0012\u0004\u0012\u00020\u00040\u0084\u0001H\u0002¢\u0006\u0005\b\u0010\u0010 \u0001J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u0019\u0010&\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b&\u0010*J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020sH\u0002¢\u0006\u0004\b(\u0010xJ\u0019\u0010\"\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030¡\u0001H\u0002¢\u0006\u0005\b\"\u0010¢\u0001J\u0019\u0010(\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030¡\u0001H\u0002¢\u0006\u0005\b(\u0010¢\u0001J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b+\u0010*J\u0019\u0010£\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020sH\u0002¢\u0006\u0005\b£\u0001\u0010\nJ\u001b\u0010w\u001a\u00020\u00062\t\u0010\u0005\u001a\u0005\u0018\u00010¤\u0001H\u0002¢\u0006\u0005\bw\u0010¥\u0001J\u0011\u0010¦\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b¦\u0001\u0010\nJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010*J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010*J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010*J\u001a\u0010(\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0005\b(\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b¨\u0001\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0010\u0010*J\u0017\u0010$\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b$\u0010\u0015J\u0011\u0010©\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b©\u0001\u0010\nJ\u0011\u0010ª\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\bª\u0001\u0010\nJ\u0011\u0010«\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b«\u0001\u0010\nJ+\u0010(\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00132\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0005\b(\u0010¬\u0001J\u0019\u0010w\u001a\u00020\u00062\u0007\u0010\u0005\u001a\u00030¡\u0001H\u0002¢\u0006\u0005\bw\u0010¢\u0001J+\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00132\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0005\b\u0010\u0010¬\u0001J\u0011\u0010\u00ad\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u00ad\u0001\u0010\nJ\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0016H\u0002¢\u0006\u0004\b(\u0010\u0017J\u001c\u0010\"\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0005\b\"\u0010®\u0001R\u0016\u0010(\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R \u0010²\u0001\u001a\u00030±\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010\"\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b5\u0010·\u0001R\u0017\u0010\u0007\u001a\u00020|8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010¸\u0001R \u0010º\u0001\u001a\u00030¹\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001R \u0010¿\u0001\u001a\u00030¾\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0016\u0010w\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010°\u0001R\u0019\u0010\u0010\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0014\u0010Ä\u0001R \u0010Æ\u0001\u001a\u00030Å\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R\u001f\u0010Ë\u0001\u001a\u00030Ê\u00018\u0007X\u0087&¢\u0006\u000f\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0005\b\u0014\u0010Í\u0001R \u0010Ï\u0001\u001a\u00030Î\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R \u0010Ô\u0001\u001a\u00030Ó\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001R\u0016\u0010\u001c\u001a\u00030Ø\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\bS\u0010Ù\u0001R\u0016\u0010S\u001a\u00030Ú\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\t\u0010Û\u0001R\u0016\u0010\t\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\bÜ\u0001\u0010°\u0001R \u0010Þ\u0001\u001a\u00030Ý\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001R\u0017\u00105\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\r\u0010\u0090\u0001R\u0017\u0010\u0014\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010\u0090\u0001R\u0017\u0010\u000e\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\f\u0010\u0090\u0001R\u0017\u0010\u000f\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u000f\u0010\u0090\u0001R\u0015\u0010\r\u001a\u00020s8CX\u0082\u0004¢\u0006\u0007\u001a\u0005\bâ\u0001\u0010uR\u0017\u0010\u000b\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u000b\u0010\u0090\u0001R\u0017\u0010\f\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010\u0090\u0001R\u0016\u0010\u0019\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\bã\u0001\u0010°\u0001R\u0018\u0010\u0012\u001a\u00030ä\u00018\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\b\u0019\u0010å\u0001R\u0018\u0010\u0011\u001a\u00030æ\u00018\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\b\u0018\u0010ç\u0001R\u001a\u0010\u0018\u001a\u0005\u0018\u00010è\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010é\u0001R\u001f\u0010ë\u0001\u001a\u00030ê\u00018\u0007X\u0087&¢\u0006\u000f\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0005\b5\u0010í\u0001R \u0010ï\u0001\u001a\u00030î\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001R\u001a\u0010\u001a\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010·\u0001R \u0010ô\u0001\u001a\u00030ó\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bô\u0001\u0010õ\u0001\u001a\u0006\bö\u0001\u0010÷\u0001R\u0016\u0010$\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\bø\u0001\u0010°\u0001R\u0016\u0010\u001e\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\bù\u0001\u0010°\u0001R\u0017\u0010+\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u0090\u0001R \u0010û\u0001\u001a\u00030ú\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bû\u0001\u0010ü\u0001\u001a\u0006\bý\u0001\u0010þ\u0001R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b+\u0010ÿ\u0001R\u0016\u0010&\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0002\u0010°\u0001R \u0010\u0082\u0002\u001a\u00030\u0081\u00028\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u0082\u0002\u0010\u0083\u0002\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R \u0010\u0087\u0002\u001a\u00030\u0086\u00028\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R\u0016\u00100\u001a\u00020\u00068CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008b\u0002\u0010°\u0001R \u0010\u008d\u0002\u001a\u00030\u008c\u00028\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u008d\u0002\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0017\u0010-\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b&\u0010\u0090\u0001R\u001a\u00103\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010\u0092\u0002R\u001b\u0010¯\u0001\u001a\u0005\u0018\u00010\u0093\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b$\u0010\u0094\u0002R\u0015\u00107\u001a\u00020\u00048CX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010VR\u0018\u0010:\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0090\u0001R\u001b\u0010Ü\u0001\u001a\u0005\u0018\u00010\u0095\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b0\u0010\u0096\u0002R\u0017\u0010=\u001a\u00020q8\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\b-\u0010\u0097\u0002R\u0015\u0010@\u001a\u00020\u00138CX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0098\u0002\u0010[R\u0018\u0010Ã\u0001\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b3\u0010ÿ\u0001R\u0018\u0010ø\u0001\u001a\u00020s8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b7\u0010\u0090\u0001R\u0017\u0010E\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b:\u0010ÿ\u0001R\u0019\u0010H\u001a\u00030\u0086\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010\u0099\u0002"}, d2 = {"Lid/dana/myprofile/NewMyProfileFragment;", "Lid/dana/base/viewbinding/ViewBindingToolbarFragment;", "Lid/dana/databinding/NewFragmentMyprofileBinding;", "Lid/dana/myprofile/MyProfileContract$View;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "moveToNextValue", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "initRecordTimeStamp", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Ljava/lang/String;)Ljava/lang/String;", "", "(I)V", "newProxyInstance", "isLayoutRequested", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda4", "lookAheadTest", "Lid/dana/utils/danah5/DanaH5Listener;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()Lid/dana/utils/danah5/DanaH5Listener;", "Ljava/lang/Class;", "p1", "getAuthRequestContext", "(Lid/dana/domain/profilemenu/model/SettingModel;Ljava/lang/Class;)V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/showcase/target/Target;", "FragmentBottomSheetPaymentSettingBinding", "()Lid/dana/showcase/target/Target;", "MyBillsEntityDataFactory", "dismissProgress", "(Ljava/lang/String;)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkModule;", "readMicros", "()Lid/dana/contract/deeplink/generation/GenerateDeepLinkModule;", "Lid/dana/contract/user/GetBalanceModule;", "whenAvailable", "()Lid/dana/contract/user/GetBalanceModule;", "Lid/dana/di/modules/BottomSheetOnBoardingModule;", "getCallingPid", "()Lid/dana/di/modules/BottomSheetOnBoardingModule;", "getErrorConfigVersion", "Lid/dana/di/modules/DanaPlusModule;", "getSupportButtonTintMode", "()Lid/dana/di/modules/DanaPlusModule;", "Lid/dana/di/modules/GoldInvestmentModule;", "VerifyPinStateManager$executeRiskChallenge$2$1", "()Lid/dana/di/modules/GoldInvestmentModule;", "Lid/dana/home/tab/HomeTabFragment;", DiskFormatter.B, "()Lid/dana/home/tab/HomeTabFragment;", "Lid/dana/di/modules/InvestmentModule;", "C", "()Lid/dana/di/modules/InvestmentModule;", "getLayout", "()I", "Lid/dana/contract/paylater/PayLaterModule;", "E", "()Lid/dana/contract/paylater/PayLaterModule;", "Lid/dana/myprofile/NewMyProfileFragment$getPtrHandler$1;", "getOnBoardingScenario", "()Lid/dana/myprofile/NewMyProfileFragment$getPtrHandler$1;", "Lid/dana/myprofile/NewMyProfileFragment$getPtrUiHandler$1;", "I", "()Lid/dana/myprofile/NewMyProfileFragment$getPtrUiHandler$1;", "Lid/dana/contract/payasset/QueryPayMethodModule;", DiskFormatter.GB, "()Lid/dana/contract/payasset/QueryPayMethodModule;", "Lid/dana/di/modules/SavingModule;", LogConstants.RESULT_FALSE, "()Lid/dana/di/modules/SavingModule;", "scheduleImpl", "(Ljava/lang/String;)Lid/dana/domain/profilemenu/model/SettingModel;", DiskFormatter.MB, "()Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/contract/staticqr/GetStaticQrModule;", DiskFormatter.KB, "()Lid/dana/contract/staticqr/GetStaticQrModule;", "getNameOrBuilderList", "()Ljava/lang/String;", "Q", "Lid/dana/di/modules/UserStatementModule;", "SummaryVoucherView$$ExternalSyntheticLambda0", "()Lid/dana/di/modules/UserStatementModule;", "(Ljava/lang/String;)I", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "(Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;)V", "O", "N", IAPSyncCommand.COMMAND_INIT, "P", "S", "SummaryVoucherView$$ExternalSyntheticLambda2", "R", "SummaryVoucherView$$ExternalSyntheticLambda1", "isAuth", "T", "W", "U", "X", "V", "Landroid/view/View;", "(Landroid/view/View;)Lid/dana/databinding/NewFragmentMyprofileBinding;", "", "shouldRecycleViewType", "()Z", "(Ljava/lang/String;)Z", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "onClickLeftMenuButton", "(Landroid/view/View;)V", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "", "(J)V", "Lid/dana/utils/StringWrapper;", "(Lid/dana/utils/StringWrapper;)V", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)V", "Lid/dana/referral/referraltracker/model/ReferralTrackerModel;", "(Lid/dana/referral/referraltracker/model/ReferralTrackerModel;)V", "", "(Ljava/util/List;)V", "Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "(Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;)V", "onHiddenChanged", "onPause", "onResume", "onSelected", "onUnSelected", "Lid/dana/model/UserInfo;", "(Lid/dana/model/UserInfo;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Z", "p2", "(ZLjava/lang/String;Ljava/lang/String;)V", "flip", "isAuto", "c", d.f7256a, "b", "a", "QrExpiredActivity", "FillAnimation", "g", "Lid/dana/domain/profilemenu/model/ProfileCompletion;", "(Lid/dana/domain/profilemenu/model/ProfileCompletion;)V", "TypeProjectionImpl", f.f7258a, "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/investment/model/UserInvestmentModel;", "(Lid/dana/investment/model/UserInvestmentModel;)V", e.PlaceComponentResult, "Lid/dana/savings/model/SavingSummaryModel;", "(Lid/dana/savings/model/SavingSummaryModel;)V", "FlowViewUtil$textChanges$1", "(Lid/dana/showcase/target/Target;)V", "showProgress", "FlowViewUtil$textChanges$2", "h", i.MyBillsEntityDataFactory, "(Lid/dana/domain/profilemenu/model/SettingModel;Ljava/lang/String;Ljava/lang/String;)V", "connectForeground", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "SubSequence", "()Lkotlin/Unit;", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "bottomSheetOnBoardingPresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "l", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "J", "Lid/dana/investment/contract/DanaPlusContract$Presenter;", "danaPlusPresenter", "Lid/dana/investment/contract/DanaPlusContract$Presenter;", "j", "()Lid/dana/investment/contract/DanaPlusContract$Presenter;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "m", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "A", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getBalancePresenter", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "k", "()Lid/dana/contract/user/GetBalanceContract$Presenter;", "Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "getStaticQrPresenter", "Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "()Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "Lid/dana/statement/UserStatementContract$Presenter;", "getUserStatementPresenter", "Lid/dana/statement/UserStatementContract$Presenter;", "access$throwIllegalArgumentType", "()Lid/dana/statement/UserStatementContract$Presenter;", "Lid/dana/investment/contract/GoldInvestmentContract$Presenter;", "goldInvestmentPresenter", "Lid/dana/investment/contract/GoldInvestmentContract$Presenter;", "n", "()Lid/dana/investment/contract/GoldInvestmentContract$Presenter;", "Lid/dana/utils/handpick/HandPicked;", "Lid/dana/utils/handpick/HandPicked;", "Landroid/os/Handler;", "Landroid/os/Handler;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/investment/contract/InvestmentContract$Presenter;", "investmentPresenter", "Lid/dana/investment/contract/InvestmentContract$Presenter;", "o", "()Lid/dana/investment/contract/InvestmentContract$Presenter;", "Y", "getValueOfTouchPositionAbsolute", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lid/dana/dialog/LoadingDialog;", "Lid/dana/dialog/LoadingDialog;", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter;", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter;", "Lid/dana/myprofile/MyProfileContract$Presenter;", "myProfilePresenter", "Lid/dana/myprofile/MyProfileContract$Presenter;", "()Lid/dana/myprofile/MyProfileContract$Presenter;", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "payLaterPresenter", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "OtpRegistrationPresenter$input$2", "()Lid/dana/contract/paylater/PayLaterContract$Presenter;", "Lid/dana/lib/bio/productpage/ProductPageManager;", "productPageManager", "Lid/dana/lib/bio/productpage/ProductPageManager;", BranchLinkConstant.PayloadKey.PROMO_CODE, "()Lid/dana/lib/bio/productpage/ProductPageManager;", "VerifyPinStateManager$executeRiskChallenge$2$2", SummaryActivity.DAYS, "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "profileQrDeepLinkPresenter", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider", "()Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "Ljava/lang/String;", "AppCompatEmojiTextHelper", "Lid/dana/contract/payasset/QueryPayMethodContract$Presenter;", "queryPayPresenter", "Lid/dana/contract/payasset/QueryPayMethodContract$Presenter;", HereUrlConstant.QUERY, "()Lid/dana/contract/payasset/QueryPayMethodContract$Presenter;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", SecurityConstants.KEY_TEXT, "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", SummaryActivity.HOURS, "Lid/dana/savings/contract/SavingContract$Presenter;", "savingPresenter", "Lid/dana/savings/contract/SavingContract$Presenter;", "s", "()Lid/dana/savings/contract/SavingContract$Presenter;", "Lid/dana/showcase/Showcase;", "Lid/dana/showcase/Showcase;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/home/HomeTabActivity$SwitchFragment;", "Lid/dana/home/HomeTabActivity$SwitchFragment;", "Landroid/view/View;", "L", "Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewMyProfileFragment extends ViewBindingToolbarFragment<NewFragmentMyprofileBinding> implements MyProfileContract.View {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int[] B = null;
    private static int BottomSheetCardBindingView$watcherCardNumberView$1 = 0;
    private static int C = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final int KClassImpl$Data$declaredNonStaticMembers$2;
    private static final int MyBillsEntityDataFactory;

    /* renamed from: A  reason: from kotlin metadata */
    private UserConfigProfileNewFlag getOnBoardingScenario;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean readMicros;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ConsultFamilyAccountResult KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private SkeletonScreen SubSequence;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private Showcase getCallingPid;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private MyProfileDiffutilAdapter newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private FragmentPermissionRequest PrepareContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;
    @Inject
    public BottomSheetOnBoardingContract.Presenter bottomSheetOnBoardingPresenter;
    @Inject
    public DanaPlusContract.Presenter danaPlusPresenter;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public GetBalanceContract.Presenter getBalancePresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private FragmentPermissionRequest getAuthRequestContext;
    @Inject
    public GetStaticQrContract.Presenter getStaticQrPresenter;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean VerifyPinStateManager$executeRiskChallenge$2$2;
    @Inject
    public UserStatementContract.Presenter getUserStatementPresenter;
    @Inject
    public GoldInvestmentContract.Presenter goldInvestmentPresenter;
    private boolean initRecordTimeStamp;
    @Inject
    public InvestmentContract.Presenter investmentPresenter;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private long PlaceComponentResult;
    @Inject
    public MyProfileContract.Presenter myProfilePresenter;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private LoadingDialog NetworkUserEntityData$$ExternalSyntheticLambda8;
    @Inject
    public PayLaterContract.Presenter payLaterPresenter;
    @Inject
    public ProductPageManager productPageManager;
    @Inject
    public GenerateDeepLinkContract.ProfilePresenter profileQrDeepLinkPresenter;
    @Inject
    public QueryPayMethodContract.Presenter queryPayPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private View com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;
    @Inject
    public SavingContract.Presenter savingPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final HandPicked lookAheadTest;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private HomeTabActivity.SwitchFragment BottomSheetCardBindingView$watcherCardNumberView$1;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Handler scheduleImpl = new Handler(Looper.getMainLooper());

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean getErrorConfigVersion = true;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private String A = "";

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private String E = "";

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private boolean VerifyPinStateManager$executeRiskChallenge$2$1 = true;

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 113;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        C(newMyProfileFragment);
        try {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 105;
            C = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 29;
        C = i % 128;
        boolean z = i % 2 == 0;
        BottomSheetCardBindingView$watcherCardNumberView$1(newMyProfileFragment);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, String str) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 79;
        C = i % 128;
        int i2 = i % 2;
        boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(newMyProfileFragment, str);
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 35;
        C = i3 % 128;
        int i4 = i3 % 2;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment, int i) {
        int i2 = C + 115;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        if (i2 % 2 == 0) {
            try {
                PlaceComponentResult(newMyProfileFragment, i);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        PlaceComponentResult(newMyProfileFragment, i);
        Object obj = null;
        obj.hashCode();
    }

    public static /* synthetic */ void PlaceComponentResult(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 41;
        C = i % 128;
        if (!(i % 2 != 0)) {
            try {
                A(newMyProfileFragment);
                int i2 = 73 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            A(newMyProfileFragment);
        }
        int i3 = C + 9;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void getAuthRequestContext(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 85;
        C = i % 128;
        char c = i % 2 == 0 ? '.' : (char) 3;
        getSupportButtonTintMode(newMyProfileFragment);
        if (c != 3) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    static void scheduleImpl() {
        B = new int[]{1060438018, 1899118740, 1744929139, -1293480304, -1670673303, -1455963760, 795377934, -319331489, 2035956376, -1001222463, 86026074, 1558645998, 1786601570, 1551912619, 657548292, -676869891, 172255943, 1784506240};
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 1;
        C = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult.clear();
        try {
            int i3 = C + 81;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
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
        int i2 = C + 99;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if ((view == null ? (char) 5 : (char) 1) != 1) {
            try {
                View getAuthRequestContext = getGetAuthRequestContext();
                if (getAuthRequestContext != null) {
                    try {
                        view = getAuthRequestContext.findViewById(i);
                        if ((view != null ? Typography.amp : 'N') == '&') {
                            map.put(Integer.valueOf(i), view);
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                view = null;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 7;
        C = i4 % 128;
        int i5 = i4 % 2;
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 119;
        C = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 18 / 0;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 101;
        C = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 83 / 0;
            return R.layout.new_fragment_myprofile;
        }
        return R.layout.new_fragment_myprofile;
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment
    public final void onClickLeftMenuButton(View p0) {
        int i = C + 23;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        int i3 = C + 43;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if ((i3 % 2 != 0 ? '7' : (char) 28) != 28) {
            int i4 = 8 / 0;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 51;
            C = i % 128;
            boolean z = i % 2 == 0;
            Object[] objArr = null;
            super.onDestroyView();
            if (!z) {
                try {
                    _$_clearFindViewByIdCache();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                _$_clearFindViewByIdCache();
                int length = objArr.length;
            }
            int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 81;
            C = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int length2 = objArr.length;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public NewMyProfileFragment() {
        boolean z = false;
        this.getOnBoardingScenario = new UserConfigProfileNewFlag(z, z, 3, null);
        HandPicked.Builder builder = new HandPicked.Builder(this);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = GriverEnv.getApplicationContext().getString(R.string.pick_profile_photo_title);
        builder.PlaceComponentResult = new HandPickedResultHandler() { // from class: id.dana.myprofile.NewMyProfileFragment$handPicked$1
            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Exception p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void MyBillsEntityDataFactory(Uri p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                FragmentActivity activity = NewMyProfileFragment.this.getActivity();
                File MyBillsEntityDataFactory2 = FileUtil.MyBillsEntityDataFactory(activity != null ? activity.getApplicationContext() : null, p0.toString());
                if (MyBillsEntityDataFactory2 != null) {
                    NewMyProfileFragment.this.getErrorConfigVersion().BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2);
                }
            }
        };
        Application applicationContext = GriverEnv.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        builder.getAuthRequestContext = PermissionHelper.MyBillsEntityDataFactory(applicationContext, "android.permission.CAMERA");
        Application applicationContext2 = GriverEnv.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = PermissionHelper.getAuthRequestContext(applicationContext2);
        HandPicked handPicked = new HandPicked(builder, z ? (byte) 1 : (byte) 0);
        Intrinsics.checkNotNullExpressionValue(handPicked, "");
        this.lookAheadTest = handPicked;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment, SettingModel settingModel) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 91;
        C = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(settingModel);
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 73;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment, SettingModel settingModel, String str, String str2) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 35;
        C = i % 128;
        boolean z = i % 2 == 0;
        newMyProfileFragment.MyBillsEntityDataFactory(settingModel, str, str2);
        if (!z) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment, UserInvestmentModel userInvestmentModel) {
        int i = C + 63;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.MyBillsEntityDataFactory(userInvestmentModel);
        int i3 = C + 63;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ MyProfileDiffutilAdapter DatabaseTableConfigUtil(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 23;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        try {
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = newMyProfileFragment.newProxyInstance;
            int i3 = C + 33;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
            return myProfileDiffutilAdapter;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void FragmentBottomSheetPaymentSettingBinding(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 115;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            newMyProfileFragment.MyBillsEntityDataFactory(true);
        } else {
            newMyProfileFragment.MyBillsEntityDataFactory(false);
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
        C = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void GetContactSyncConfig(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 73;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 != 0) {
            newMyProfileFragment.AppCompatEmojiTextHelper();
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            newMyProfileFragment.AppCompatEmojiTextHelper();
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 113;
        C = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.less : '\'') != '\'') {
            int i3 = 76 / 0;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, UserInvestmentModel userInvestmentModel) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 39;
        C = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.BuiltInFictitiousFunctionClassFactory(userInvestmentModel);
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment newMyProfileFragment, SavingSummaryModel savingSummaryModel) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 79;
        C = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.BuiltInFictitiousFunctionClassFactory(savingSummaryModel);
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 47;
        C = i3 % 128;
        if ((i3 % 2 == 0 ? 'V' : '\\') != 'V') {
            return;
        }
        int i4 = 83 / 0;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 59;
        C = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.newProxyInstance();
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 97;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment, String str) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 63;
        C = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.PrepareContext(str);
        int i3 = C + 55;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 7 : 'Q') != 'Q') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment, boolean z) {
        int i = C + 13;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
        int i3 = C + 97;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if ((i3 % 2 != 0 ? '@' : ']') != ']') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment, boolean z, String str, String str2) {
        int i = C + 21;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 != 0)) {
            newMyProfileFragment.PlaceComponentResult(z, str, str2);
        } else {
            newMyProfileFragment.PlaceComponentResult(z, str, str2);
            int i2 = 70 / 0;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 121;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 63;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        boolean z = i % 2 == 0;
        newMyProfileFragment.getValueOfTouchPositionAbsolute();
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = C + 125;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda1(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 79;
        C = i % 128;
        int i2 = i % 2;
        LoadingLottieAnimationView loadingLottieAnimationView = newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 63;
        C = i3 % 128;
        int i4 = i3 % 2;
        return loadingLottieAnimationView;
    }

    public static final /* synthetic */ SettingModel NetworkUserEntityData$$ExternalSyntheticLambda2(NewMyProfileFragment newMyProfileFragment) {
        SettingModel J;
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 91;
            C = i % 128;
            if (!(i % 2 == 0)) {
                J = newMyProfileFragment.J();
            } else {
                J = newMyProfileFragment.J();
                Object obj = null;
                obj.hashCode();
            }
            int i2 = C + 29;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 22 / 0;
                return J;
            }
            return J;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean NetworkUserEntityData$$ExternalSyntheticLambda3(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = C + 113;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            boolean z = newMyProfileFragment.DatabaseTableConfigUtil;
            int i3 = C + 79;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda4(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 101;
            C = i % 128;
            int i2 = i % 2;
            newMyProfileFragment.TypeProjectionImpl();
            try {
                int i3 = C + 81;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda5(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 17;
        C = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.isAuto();
        int i3 = C + 81;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if ((i3 % 2 != 0 ? '\n' : ';') != ';') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda6(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 17;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.f();
        try {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 25;
            C = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean NetworkUserEntityData$$ExternalSyntheticLambda7(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = C + 27;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if ((i % 2 != 0 ? '\n' : '-') != '-') {
                boolean shouldRecycleViewType = newMyProfileFragment.shouldRecycleViewType();
                Object[] objArr = null;
                int length = objArr.length;
                return shouldRecycleViewType;
            }
            return newMyProfileFragment.shouldRecycleViewType();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean NetworkUserEntityData$$ExternalSyntheticLambda8(NewMyProfileFragment newMyProfileFragment) {
        boolean z;
        int i = C + 63;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 != 0 ? 'W' : InputCardNumberView.DIVIDER) != 'W') {
            try {
                z = newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            } catch (Exception e) {
                throw e;
            }
        } else {
            z = newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int i2 = 47 / 0;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 9;
        C = i3 % 128;
        if (i3 % 2 != 0) {
            return z;
        }
        int i4 = 34 / 0;
        return z;
    }

    public static final /* synthetic */ void PlaceComponentResult(NewMyProfileFragment newMyProfileFragment, String str) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 35;
            C = i % 128;
            int i2 = i % 2;
            newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = str;
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 61;
            C = i3 % 128;
            if ((i3 % 2 == 0 ? '8' : '-') != '-') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String PrepareContext(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 63;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        String nameOrBuilderList = newMyProfileFragment.getNameOrBuilderList();
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 13;
        C = i3 % 128;
        int i4 = i3 % 2;
        return nameOrBuilderList;
    }

    public static final /* synthetic */ void SubSequence(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = C + 125;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            newMyProfileFragment.DatabaseTableConfigUtil = (i % 2 != 0 ? (char) 2 : '\n') != '\n';
            int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 7;
            C = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(NewMyProfileFragment newMyProfileFragment, int i) {
        int i2 = C + 61;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
        newMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(i);
        int i4 = C + 3;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
        int i5 = i4 % 2;
    }

    public static final /* synthetic */ void getAuthRequestContext(NewMyProfileFragment newMyProfileFragment, SettingModel settingModel, String str, String str2) {
        int i = C + 27;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        char c = i % 2 != 0 ? 'Q' : '+';
        newMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(settingModel, str, str2);
        if (c == 'Q') {
            int i2 = 29 / 0;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 53;
        C = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(NewMyProfileFragment newMyProfileFragment, UserInvestmentModel userInvestmentModel) {
        try {
            int i = C + 5;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            boolean z = i % 2 != 0;
            newMyProfileFragment.getAuthRequestContext(userInvestmentModel);
            if (z) {
                int i2 = 38 / 0;
            }
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 59;
            C = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void getCallingPid(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 11;
            C = i % 128;
            int i2 = i % 2;
            newMyProfileFragment.readMicros = false;
            int i3 = C + 119;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            if ((i3 % 2 != 0 ? '(' : 'a') != 'a') {
                int i4 = 3 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ FragmentPermissionRequest getErrorConfigVersion(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = C + 69;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            char c = i % 2 != 0 ? 'c' : '\t';
            FragmentPermissionRequest fragmentPermissionRequest = newMyProfileFragment.getAuthRequestContext;
            if (c == 'c') {
                Object obj = null;
                obj.hashCode();
            }
            return fragmentPermissionRequest;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void initRecordTimeStamp(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 41;
        C = i % 128;
        if ((i % 2 == 0 ? (char) 30 : 'C') != 30) {
            newMyProfileFragment.D();
        } else {
            newMyProfileFragment.D();
            int i2 = 62 / 0;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 13;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void isLayoutRequested(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 21;
        C = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.Q();
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 49;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void lookAheadTest(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 85;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        newMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
        int i3 = C + 15;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ NewFragmentMyprofileBinding moveToNextValue(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 3;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) newMyProfileFragment.getBinding();
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
        C = i3 % 128;
        if ((i3 % 2 == 0 ? 'H' : Typography.amp) != '&') {
            Object[] objArr = null;
            int length = objArr.length;
            return newFragmentMyprofileBinding;
        }
        return newFragmentMyprofileBinding;
    }

    public static final /* synthetic */ boolean newProxyInstance(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = C + 45;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            boolean z = newMyProfileFragment.VerifyPinStateManager$executeRiskChallenge$2$1;
            int i3 = C + 15;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void readMicros(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 31;
            try {
                C = i % 128;
                int i2 = i % 2;
                newMyProfileFragment.getCallingPid = null;
                int i3 = C + 101;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ HandPicked scheduleImpl(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 105;
            C = i % 128;
            if (!(i % 2 == 0)) {
                return newMyProfileFragment.lookAheadTest;
            }
            int i2 = 35 / 0;
            return newMyProfileFragment.lookAheadTest;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void whenAvailable(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = C + 61;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            newMyProfileFragment.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
            try {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 29;
                C = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    int i4 = 80 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        NewFragmentMyprofileBinding MyBillsEntityDataFactory2;
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 115;
        C = i % 128;
        if (!(i % 2 == 0)) {
            try {
                MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(view);
            } catch (Exception e) {
                throw e;
            }
        } else {
            MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(view);
            int i2 = 84 / 0;
        }
        int i3 = C + 41;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        return MyBillsEntityDataFactory2;
    }

    @JvmName(name = "k")
    private GetBalanceContract.Presenter k() {
        try {
            int i = C + 123;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                GetBalanceContract.Presenter presenter = this.getBalancePresenter;
                Object[] objArr = null;
                if ((presenter != null ? 'A' : (char) 30) != 'A') {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    return null;
                }
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
                C = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 14 : 'M') == 14) {
                    int length = objArr.length;
                }
                return presenter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    public final GetStaticQrContract.Presenter NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 75;
        C = i % 128;
        int i2 = i % 2;
        GetStaticQrContract.Presenter presenter = this.getStaticQrPresenter;
        if ((presenter != null ? Typography.amp : (char) 27) == 27) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i3 = C + 45;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        return presenter;
    }

    @JvmName(name = "access$throwIllegalArgumentType")
    private UserStatementContract.Presenter access$throwIllegalArgumentType() {
        UserStatementContract.Presenter presenter = this.getUserStatementPresenter;
        if (presenter != null) {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 105;
            C = i % 128;
            int i2 = i % 2;
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = C + 47;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0021, code lost:
    
        if ((r0 != null ? 2 : 20) != 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0031, code lost:
    
        if ((r0 != null ? 'c' : '\f') != 'c') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0033, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0038, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
    
        r2 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 29;
        id.dana.myprofile.NewMyProfileFragment.C = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0042, code lost:
    
        if ((r2 % 2) != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0044, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004a, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = id.dana.data.constant.BranchLinkConstant.PayloadKey.PROMO_CODE)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.lib.bio.productpage.ProductPageManager p() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L4b
            int r0 = r0 + 33
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1     // Catch: java.lang.Exception -> L4b
            r1 = 2
            int r0 = r0 % r1
            r2 = 60
            if (r0 == 0) goto L11
            r0 = 51
            goto L13
        L11:
            r0 = 60
        L13:
            r3 = 0
            if (r0 == r2) goto L26
            id.dana.lib.bio.productpage.ProductPageManager r0 = r5.productPageManager
            r3.hashCode()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L1f
            r2 = 2
            goto L21
        L1f:
            r2 = 20
        L21:
            if (r2 == r1) goto L39
            goto L33
        L24:
            r0 = move-exception
            throw r0
        L26:
            id.dana.lib.bio.productpage.ProductPageManager r0 = r5.productPageManager
            r2 = 99
            if (r0 == 0) goto L2f
            r4 = 99
            goto L31
        L2f:
            r4 = 12
        L31:
            if (r4 == r2) goto L39
        L33:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r3
        L39:
            int r2 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r2 = r2 + 29
            int r4 = r2 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r4
            int r2 = r2 % r1
            if (r2 != 0) goto L4a
            r3.hashCode()     // Catch: java.lang.Throwable -> L48
            goto L4a
        L48:
            r0 = move-exception
            throw r0
        L4a:
            return r0
        L4b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.p():id.dana.lib.bio.productpage.ProductPageManager");
    }

    @JvmName(name = "getErrorConfigVersion")
    public final MyProfileContract.Presenter getErrorConfigVersion() {
        int i = C + 23;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        MyProfileContract.Presenter presenter = this.myProfilePresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 87;
        C = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return presenter;
        }
        int i4 = 71 / 0;
        return presenter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0015, code lost:
    
        if ((r0 == null) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0025, code lost:
    
        if ((r0 != null ? 'H' : kotlin.text.Typography.amp) != 'H') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0027, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x002c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x002d, code lost:
    
        r2 = id.dana.myprofile.NewMyProfileFragment.C + 103;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0037, code lost:
    
        if ((r2 % 2) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0039, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003f, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfilePresenter DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1a
            id.dana.contract.deeplink.generation.GenerateDeepLinkContract$ProfilePresenter r0 = r4.profileQrDeepLinkPresenter
            int r2 = r1.length     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L14
            r2 = 0
            goto L15
        L14:
            r2 = 1
        L15:
            if (r2 == 0) goto L2d
            goto L27
        L18:
            r0 = move-exception
            throw r0
        L1a:
            id.dana.contract.deeplink.generation.GenerateDeepLinkContract$ProfilePresenter r0 = r4.profileQrDeepLinkPresenter
            r2 = 72
            if (r0 == 0) goto L23
            r3 = 72
            goto L25
        L23:
            r3 = 38
        L25:
            if (r3 == r2) goto L2d
        L27:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        L2d:
            int r2 = id.dana.myprofile.NewMyProfileFragment.C
            int r2 = r2 + 103
            int r3 = r2 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L3f
            r1.hashCode()     // Catch: java.lang.Throwable -> L3d
            goto L3f
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider():id.dana.contract.deeplink.generation.GenerateDeepLinkContract$ProfilePresenter");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x001c, code lost:
    
        if ((r0 == null) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0022, code lost:
    
        if (r0 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0024, code lost:
    
        r1 = id.dana.myprofile.NewMyProfileFragment.C + 71;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002f, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0034, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = id.dana.data.here.model.HereUrlConstant.QUERY)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.contract.payasset.QueryPayMethodContract.Presenter q() {
        /*
            r3 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L37
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1     // Catch: java.lang.Exception -> L37
            int r0 = r0 % 2
            r1 = 62
            if (r0 != 0) goto L11
            r0 = 62
            goto L12
        L11:
            r0 = 4
        L12:
            r2 = 0
            if (r0 == r1) goto L1f
            id.dana.contract.payasset.QueryPayMethodContract$Presenter r0 = r3.queryPayPresenter
            if (r0 == 0) goto L1b
            r1 = 0
            goto L1c
        L1b:
            r1 = 1
        L1c:
            if (r1 == 0) goto L24
            goto L2f
        L1f:
            id.dana.contract.payasset.QueryPayMethodContract$Presenter r0 = r3.queryPayPresenter
            int r1 = r2.length     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto L2f
        L24:
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            int r1 = r1 + 71
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2
            int r1 = r1 % 2
            return r0
        L2f:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r2
        L35:
            r0 = move-exception
            throw r0
        L37:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.q():id.dana.contract.payasset.QueryPayMethodContract$Presenter");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0010, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0020, code lost:
    
        if ((r0 != null ? 'B' : '/') != 'B') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0022, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0027, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 89;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0032, code lost:
    
        if ((r0 % 2) == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0034, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0036, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0037, code lost:
    
        if (r0 == true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0039, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003a, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x003d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0040, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0041, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0042, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "l")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.usereducation.BottomSheetOnBoardingContract.Presenter l() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L15
            id.dana.usereducation.BottomSheetOnBoardingContract$Presenter r0 = r4.bottomSheetOnBoardingPresenter
            int r2 = r1.length     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L22
            goto L42
        L13:
            r0 = move-exception
            throw r0
        L15:
            id.dana.usereducation.BottomSheetOnBoardingContract$Presenter r0 = r4.bottomSheetOnBoardingPresenter
            r2 = 66
            if (r0 == 0) goto L1e
            r3 = 66
            goto L20
        L1e:
            r3 = 47
        L20:
            if (r3 == r2) goto L42
        L22:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L40
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 89
            int r2 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2
            int r0 = r0 % 2
            r2 = 1
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L36:
            r0 = 0
        L37:
            if (r0 == r2) goto L3a
            return r1
        L3a:
            r1.hashCode()     // Catch: java.lang.Throwable -> L3e
            return r1
        L3e:
            r0 = move-exception
            throw r0
        L40:
            r0 = move-exception
            throw r0
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.l():id.dana.usereducation.BottomSheetOnBoardingContract$Presenter");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0019, code lost:
    
        if ((r0 != null) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0027, code lost:
    
        if ((r0 != null ? '.' : 6) != '.') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0029, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002f, code lost:
    
        r1 = id.dana.myprofile.NewMyProfileFragment.C + 41;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0039, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "s")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.savings.contract.SavingContract.Presenter s() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L3c
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1     // Catch: java.lang.Exception -> L3c
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
            if (r0 == r2) goto L1c
            id.dana.savings.contract.SavingContract$Presenter r0 = r4.savingPresenter
            if (r0 == 0) goto L19
            r1 = 1
        L19:
            if (r1 == 0) goto L29
            goto L2f
        L1c:
            id.dana.savings.contract.SavingContract$Presenter r0 = r4.savingPresenter
            int r1 = r3.length     // Catch: java.lang.Throwable -> L3a
            r1 = 46
            if (r0 == 0) goto L26
            r2 = 46
            goto L27
        L26:
            r2 = 6
        L27:
            if (r2 == r1) goto L2f
        L29:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r3
        L2f:
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            int r1 = r1 + 41
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2
            int r1 = r1 % 2
            return r0
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.s():id.dana.savings.contract.SavingContract$Presenter");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001d, code lost:
    
        if ((r0 == null) != true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0025, code lost:
    
        if (r0 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0027, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0028, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 117;
        id.dana.myprofile.NewMyProfileFragment.C = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0038, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "m")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.data.dynamicurl.DynamicUrlWrapper m() {
        /*
            r3 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 19
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 71
            if (r0 == 0) goto L11
            r0 = 71
            goto L13
        L11:
            r0 = 65
        L13:
            r2 = 0
            if (r0 == r1) goto L20
            id.dana.data.dynamicurl.DynamicUrlWrapper r0 = r3.dynamicUrlWrapper
            r1 = 1
            if (r0 == 0) goto L1c
            goto L1d
        L1c:
            r2 = 1
        L1d:
            if (r2 == r1) goto L28
            goto L27
        L20:
            id.dana.data.dynamicurl.DynamicUrlWrapper r0 = r3.dynamicUrlWrapper     // Catch: java.lang.Exception -> L3b
            r1 = 62
            int r1 = r1 / r2
            if (r0 == 0) goto L28
        L27:
            return r0
        L28:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            int r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r1 = r1 + 117
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r2
            int r1 = r1 % 2
            return r0
        L39:
            r0 = move-exception
            throw r0
        L3b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.m():id.dana.data.dynamicurl.DynamicUrlWrapper");
    }

    @JvmName(name = "o")
    private InvestmentContract.Presenter o() {
        InvestmentContract.Presenter presenter = this.investmentPresenter;
        try {
            if ((presenter != null ? 'b' : 'c') != 'c') {
                int i = C + 69;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                return presenter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            try {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 111;
                C = i3 % 128;
                Object[] objArr = null;
                if ((i3 % 2 == 0 ? (char) 25 : (char) 5) != 5) {
                    int length = objArr.length;
                    return null;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "n")
    private GoldInvestmentContract.Presenter n() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 13;
        C = i % 128;
        int i2 = i % 2;
        GoldInvestmentContract.Presenter presenter = this.goldInvestmentPresenter;
        if ((presenter != null ? 'Y' : (char) 7) != 7) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        try {
            int i3 = C + 107;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            Object obj = null;
            if ((i3 % 2 != 0 ? Typography.quote : 'G') != 'G') {
                obj.hashCode();
                return null;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = SecurityConstants.KEY_TEXT)
    private ReadLinkPropertiesContract.Presenter t() {
        int i = C + 79;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        try {
            int i3 = C + 87;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            boolean z = i3 % 2 != 0;
            Object[] objArr = null;
            if (z) {
                int length = objArr.length;
                return null;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x001f, code lost:
    
        if ((r0 != null ? 7 : '3') != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0025, code lost:
    
        if (r0 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0027, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0028, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002d, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 25;
        id.dana.myprofile.NewMyProfileFragment.C = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0037, code lost:
    
        if ((r0 % 2) != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0039, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x003a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003f, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "OtpRegistrationPresenter$input$2")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.contract.paylater.PayLaterContract.Presenter OtpRegistrationPresenter$input$2() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 92
            if (r0 != 0) goto L11
            r0 = 92
            goto L13
        L11:
            r0 = 57
        L13:
            r2 = 0
            if (r0 == r1) goto L22
            id.dana.contract.paylater.PayLaterContract$Presenter r0 = r4.payLaterPresenter
            r1 = 7
            if (r0 == 0) goto L1d
            r3 = 7
            goto L1f
        L1d:
            r3 = 51
        L1f:
            if (r3 == r1) goto L27
            goto L28
        L22:
            id.dana.contract.paylater.PayLaterContract$Presenter r0 = r4.payLaterPresenter
            int r1 = r2.length     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L28
        L27:
            return r0
        L28:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L3e
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3d
            int r0 = r2.length     // Catch: java.lang.Throwable -> L3b
            return r2
        L3b:
            r0 = move-exception
            throw r0
        L3d:
            return r2
        L3e:
            r0 = move-exception
            throw r0
        L40:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.OtpRegistrationPresenter$input$2():id.dana.contract.paylater.PayLaterContract$Presenter");
    }

    @JvmName(name = "j")
    private DanaPlusContract.Presenter j() {
        DanaPlusContract.Presenter presenter = this.danaPlusPresenter;
        Object[] objArr = null;
        if ((presenter != null ? '\\' : 'S') == 'S') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 69;
            C = i % 128;
            int i2 = i % 2;
            return null;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
        C = i3 % 128;
        if (i3 % 2 == 0) {
            int length = objArr.length;
            return presenter;
        }
        return presenter;
    }

    private static NewFragmentMyprofileBinding MyBillsEntityDataFactory(View p0) {
        try {
            int i = C + 49;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(p0, "");
                NewFragmentMyprofileBinding PlaceComponentResult = NewFragmentMyprofileBinding.PlaceComponentResult(p0);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                int i3 = C + 67;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
                return PlaceComponentResult;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingToolbarFragment, id.dana.base.BaseFragment
    public final void init() {
        Bundle arguments = getArguments();
        boolean z = false;
        if (!(arguments == null)) {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 17;
            C = i % 128;
            if (!(i % 2 != 0) ? !arguments.getBoolean("IS_KYB_REVAMP") : arguments.getBoolean("IS_KYB_REVAMP")) {
                z = true;
            }
        }
        this.getErrorConfigVersion = z;
        setTitle(getResources().getString(R.string.my_account));
        SummaryVoucherView$$ExternalSyntheticLambda2();
        V();
        SummaryVoucherView$$ExternalSyntheticLambda1();
        isAuth();
        X();
        R();
        P();
        S();
        T();
        W();
        MyBillsEntityDataFactory(FragmentBottomSheetPaymentSettingBinding());
        getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda7();
        getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda8();
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 7;
        C = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void S() {
        AppCompatTextView appCompatTextView;
        DanaButtonSecondaryView danaButtonSecondaryView;
        int i = C + 111;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
        if ((newFragmentMyprofileBinding != null ? '[' : Typography.greater) != '[') {
            appCompatTextView = null;
            try {
                int i3 = C + 39;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } else {
            appCompatTextView = newFragmentMyprofileBinding.lookAheadTest;
        }
        if (appCompatTextView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Version ");
            sb.append(VersionUtil.BuiltInFictitiousFunctionClassFactory(requireContext()));
            appCompatTextView.setText(sb.toString());
        }
        NewFragmentMyprofileBinding newFragmentMyprofileBinding2 = (NewFragmentMyprofileBinding) getBinding();
        if ((newFragmentMyprofileBinding2 != null ? 'Z' : JSONLexer.EOI) == 26 || (danaButtonSecondaryView = newFragmentMyprofileBinding2.MyBillsEntityDataFactory) == null) {
            return;
        }
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMyProfileFragment.PlaceComponentResult(NewMyProfileFragment.this);
            }
        });
    }

    private static final void A(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 31;
        C = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
        newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda1();
        int i3 = C + 21;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        try {
            int i = C + 59;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            super.onResume();
            D();
            A();
            getErrorConfigVersion().initRecordTimeStamp();
            getErrorConfigVersion().lookAheadTest();
            int i3 = C + 111;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            if ((i3 % 2 != 0 ? '\'' : 'A') != 'A') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        int i = C + 33;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        e();
        super.onPause();
        int i3 = C + 79;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007a  */
    @Override // id.dana.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSelected() {
        /*
            r6 = this;
            r0 = 1
            r6.NetworkUserEntityData$$ExternalSyntheticLambda6 = r0
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r1 = r6.newProxyInstance
            r2 = 0
            if (r1 == 0) goto La
            r3 = 0
            goto Lb
        La:
            r3 = 1
        Lb:
            if (r3 == 0) goto Le
            goto L1e
        Le:
            int r3 = id.dana.myprofile.NewMyProfileFragment.C
            int r3 = r3 + 87
            int r4 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r4
            int r3 = r3 % 2
            boolean r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r1 == r0) goto L2a
        L1e:
            int r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r1 = r1 + 67
            int r3 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r3
            int r1 = r1 % 2
            r1 = 0
            goto L2b
        L2a:
            r1 = 1
        L2b:
            if (r1 == 0) goto L7a
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            int r1 = r1 + 99
            int r3 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L3b
            r1 = 1
            goto L3c
        L3b:
            r1 = 0
        L3c:
            r3 = 12
            java.lang.String r4 = ""
            if (r1 == 0) goto L5a
            id.dana.myprofile.MyProfileContract$Presenter r1 = r6.getErrorConfigVersion()
            r5 = 71
            int r4 = android.text.TextUtils.getOffsetAfter(r4, r2)
            int r5 = r5 % r4
            int[] r3 = new int[r3]
            r3 = {x009c: FILL_ARRAY_DATA , data: [-935569244, -1071540447, -943081810, 549448726, -1048437398, -1837066032, 1775486352, -1435193792, 347405359, 1482023832, 273537172, -1329999007} // fill-array
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r(r5, r3, r0)
            r0 = r0[r2]
            goto L70
        L5a:
            id.dana.myprofile.MyProfileContract$Presenter r1 = r6.getErrorConfigVersion()
            int r4 = android.text.TextUtils.getOffsetAfter(r4, r2)
            int r4 = 21 - r4
            int[] r3 = new int[r3]
            r3 = {x00b8: FILL_ARRAY_DATA , data: [-935569244, -1071540447, -943081810, 549448726, -1048437398, -1837066032, 1775486352, -1435193792, 347405359, 1482023832, 273537172, -1329999007} // fill-array
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r(r4, r3, r0)
            r0 = r0[r2]
        L70:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r1.getAuthRequestContext(r0)
            goto L86
        L7a:
            r6.getValueOfTouchPositionAbsolute()
            r6.BottomSheetCardBindingView$watcherCardNumberView$1()
            r6.TypeProjectionImpl()
            r6.Q()
        L86:
            id.dana.myprofile.MyProfileContract$Presenter r0 = r6.getErrorConfigVersion()
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0()
            r6.AppCompatEmojiTextHelper()
            id.dana.contract.staticqr.GetStaticQrContract$Presenter r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0()
            r0.MyBillsEntityDataFactory()
            r6.H()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.onSelected():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x001a, code lost:
    
        if ((!r5) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x002b, code lost:
    
        if ((!r5 ? 18 : 27) != 27) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x002d, code lost:
    
        isLayoutRequested();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0030, code lost:
    
        r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 101;
        id.dana.myprofile.NewMyProfileFragment.C = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x003a, code lost:
    
        if ((r5 % 2) != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003d, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003e, code lost:
    
        if (r1 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0040, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0041, code lost:
    
        r5 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0042, code lost:
    
        return;
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onHiddenChanged(boolean r5) {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 3
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1f
            super.onHiddenChanged(r5)
            r2.hashCode()     // Catch: java.lang.Throwable -> L1d
            if (r5 != 0) goto L19
            r5 = 1
            goto L1a
        L19:
            r5 = 0
        L1a:
            if (r5 == r3) goto L2d
            goto L30
        L1d:
            r5 = move-exception
            throw r5
        L1f:
            super.onHiddenChanged(r5)
            r0 = 27
            if (r5 != 0) goto L29
            r5 = 18
            goto L2b
        L29:
            r5 = 27
        L2b:
            if (r5 == r0) goto L30
        L2d:
            r4.isLayoutRequested()
        L30:
            int r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r5 = r5 + 101
            int r0 = r5 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L3d
            goto L3e
        L3d:
            r1 = 1
        L3e:
            if (r1 == 0) goto L41
            return
        L41:
            int r5 = r2.length     // Catch: java.lang.Throwable -> L43
            return
        L43:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.onHiddenChanged(boolean):void");
    }

    @Override // id.dana.base.BaseFragment
    public final void onUnSelected() {
        try {
            int i = C + 121;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                if ((i % 2 != 0 ? 'H' : (char) 25) != 'H') {
                    getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda4();
                    q().onDestroy();
                    this.scheduleImpl.removeCallbacksAndMessages(null);
                    return;
                }
                getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda4();
                q().onDestroy();
                this.scheduleImpl.removeCallbacksAndMessages(null);
                int i2 = 73 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "BottomSheetCardBindingView$watcherCardNumberView$1")
    private final Unit BottomSheetCardBindingView$watcherCardNumberView$1() {
        SettingModel settingModel;
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
        try {
            if ((myProfileDiffutilAdapter != null ? 'P' : '#') != '#') {
                int i = C + 57;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                settingModel = myProfileDiffutilAdapter.getAuthRequestContext("setting_investment");
            } else {
                settingModel = null;
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 9;
                try {
                    C = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (!(settingModel == null)) {
                int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 117;
                C = i5 % 128;
                int i6 = i5 % 2;
                o().getAuthRequestContext();
                int i7 = C + 31;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i7 % 128;
                int i8 = i7 % 2;
            }
            return Unit.INSTANCE;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void TypeProjectionImpl() {
        SettingModel authRequestContext;
        try {
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
            if (myProfileDiffutilAdapter == null) {
                authRequestContext = null;
            } else {
                authRequestContext = myProfileDiffutilAdapter.getAuthRequestContext("setting_emas");
                int i = C + 95;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
            }
            if (authRequestContext != null) {
                int i3 = C + 51;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
                n().PlaceComponentResult();
                int i5 = C + 7;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
                int i6 = i5 % 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void Q() {
        SettingModel settingModel;
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 43;
            C = i % 128;
            int i2 = i % 2;
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
            if ((myProfileDiffutilAdapter != null ? 'c' : (char) 24) != 24) {
                int i3 = C + 17;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
                settingModel = myProfileDiffutilAdapter.getAuthRequestContext("setting_dana_plus");
            } else {
                settingModel = null;
            }
            if (settingModel != null) {
                j().PlaceComponentResult();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getValueOfTouchPositionAbsolute")
    private final Unit getValueOfTouchPositionAbsolute() {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 105;
            C = i % 128;
            int i2 = i % 2;
            D();
            SubSequence();
            O();
            Unit unit = Unit.INSTANCE;
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 19;
            C = i3 % 128;
            if (i3 % 2 != 0) {
                return unit;
            }
            int i4 = 14 / 0;
            return unit;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void isLayoutRequested() {
        Object[] objArr = null;
        this.scheduleImpl.removeCallbacksAndMessages(null);
        this.scheduleImpl.postDelayed(new Runnable() { // from class: id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment.this);
            }
        }, 500L);
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 55;
        C = i % 128;
        if (!(i % 2 != 0)) {
            int length = objArr.length;
        }
    }

    private static final void C(NewMyProfileFragment newMyProfileFragment) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 19;
        C = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
        newMyProfileFragment.getErrorConfigVersion().MyBillsEntityDataFactory();
        int i3 = C + 109;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = SummaryActivity.HOURS)
    private final Unit H() {
        int i = C + 51;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        s().MyBillsEntityDataFactory();
        Unit unit = Unit.INSTANCE;
        int i3 = C + 99;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        return unit;
    }

    @JvmName(name = SummaryActivity.DAYS)
    private final Unit D() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 61;
        C = i % 128;
        int i2 = i % 2;
        getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda1();
        getErrorConfigVersion().newProxyInstance();
        getErrorConfigVersion().BuiltInFictitiousFunctionClassFactory("resolutionCenter");
        Unit unit = Unit.INSTANCE;
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 79;
        C = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return unit;
        }
        return unit;
    }

    @JvmName(name = "A")
    private final Unit A() {
        int i = C + 21;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            getErrorConfigVersion().PlaceComponentResult();
            return Unit.INSTANCE;
        }
        getErrorConfigVersion().PlaceComponentResult();
        Unit unit = Unit.INSTANCE;
        Object obj = null;
        obj.hashCode();
        return unit;
    }

    @JvmName(name = "VerifyPinStateManager$executeRiskChallenge$2$2")
    private final Unit VerifyPinStateManager$executeRiskChallenge$2$2() {
        this.scheduleImpl.removeCallbacksAndMessages(null);
        this.scheduleImpl.postDelayed(new Runnable() { // from class: id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                NewMyProfileFragment.getAuthRequestContext(NewMyProfileFragment.this);
            }
        }, 1000L);
        Unit unit = Unit.INSTANCE;
        int i = C + 113;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        return unit;
    }

    private static final void getSupportButtonTintMode(NewMyProfileFragment newMyProfileFragment) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 101;
            C = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
            newMyProfileFragment.getErrorConfigVersion().isLayoutRequested();
            int i3 = C + 83;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "SubSequence")
    private final Unit SubSequence() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 95;
        C = i % 128;
        if ((i % 2 == 0 ? 'G' : '^') != 'G') {
            k().PlaceComponentResult(Boolean.TRUE);
            return Unit.INSTANCE;
        }
        k().PlaceComponentResult(Boolean.TRUE);
        Unit unit = Unit.INSTANCE;
        Object[] objArr = null;
        int length = objArr.length;
        return unit;
    }

    @JvmName(name = "AppCompatEmojiTextHelper")
    private final Unit AppCompatEmojiTextHelper() {
        Unit unit;
        int i = C + 89;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 != 0)) {
            q().MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            q().MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = C + 65;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
        return unit;
    }

    private final void O() {
        int i = C + 115;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        boolean z = i % 2 == 0;
        NetworkUserEntityData$$ExternalSyntheticLambda6();
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 49;
        C = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int i3 = 93 / 0;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        try {
            access$throwIllegalArgumentType().PlaceComponentResult(new StatementSummaryInit(Calendar.getInstance().getTimeInMillis(), TimeUnitInterval.MONTH, StatementType.ALL));
            int i = C + 21;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void X() {
        NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
        if ((newFragmentMyprofileBinding != null ? (char) 24 : 'Z') != 24) {
            return;
        }
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 55;
        C = i % 128;
        int i2 = i % 2;
        RecyclerView recyclerView = newFragmentMyprofileBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if ((recyclerView != null ? (char) 14 : (char) 30) != 14) {
            return;
        }
        int i3 = C + 47;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        try {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
            }
            ((SimpleItemAnimator) itemAnimator).NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(this.newProxyInstance);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x001e, code lost:
    
        if ((r0 != null) != true) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x002b, code lost:
    
        if (r0 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x002f, code lost:
    
        r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0033, code lost:
    
        id.dana.myprofile.NewMyProfileFragment.C = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0037, code lost:
    
        r0 = r0.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0039, code lost:
    
        if (r0 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003b, code lost:
    
        r0.setOnScrollChangeListener(new id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda4(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0045, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0049, code lost:
    
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004b, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x004f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0050, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0051, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 115;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x005b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void R() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 57
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L25
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()     // Catch: java.lang.Exception -> L23
            id.dana.databinding.NewFragmentMyprofileBinding r0 = (id.dana.databinding.NewFragmentMyprofileBinding) r0
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L1e
            r1 = 1
        L1e:
            if (r1 == r2) goto L2d
            goto L51
        L21:
            r0 = move-exception
            throw r0
        L23:
            r0 = move-exception
            goto L4e
        L25:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.NewFragmentMyprofileBinding r0 = (id.dana.databinding.NewFragmentMyprofileBinding) r0
            if (r0 == 0) goto L51
        L2d:
            int r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L4f
            int r1 = r1 + 109
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r2     // Catch: java.lang.Exception -> L23
            int r1 = r1 % 2
            androidx.core.widget.NestedScrollView r0 = r0.PlaceComponentResult
            if (r0 == 0) goto L51
            id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda4 r1 = new id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda4
            r1.<init>()
            r0.setOnScrollChangeListener(r1)
            int r0 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L4f
            int r0 = r0 + 15
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1     // Catch: java.lang.Exception -> L4f
            int r0 = r0 % 2
            goto L51
        L4e:
            throw r0
        L4f:
            r0 = move-exception
            throw r0
        L51:
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.R():void");
    }

    private static final void PlaceComponentResult(NewMyProfileFragment newMyProfileFragment, int i) {
        boolean z;
        try {
            Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
            newMyProfileFragment.VerifyPinStateManager$executeRiskChallenge$2$2 = true;
            NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) newMyProfileFragment.getBinding();
            PtrClassicFrameLayout ptrClassicFrameLayout = (newFragmentMyprofileBinding != null ? '1' : Typography.less) != '<' ? newFragmentMyprofileBinding.getErrorConfigVersion : null;
            if (ptrClassicFrameLayout != null) {
                int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 93;
                C = i2 % 128;
                int i3 = i2 % 2;
                if (i != 0) {
                    int i4 = C + 5;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
                    int i5 = i4 % 2;
                    z = false;
                } else {
                    z = true;
                }
                ptrClassicFrameLayout.setEnabled(z);
            }
            if (i == 0) {
                int i6 = C + 45;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i6 % 128;
                int i7 = i6 % 2;
                newMyProfileFragment.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
                if ((newMyProfileFragment.readMicros ? '3' : (char) 1) != '3') {
                    return;
                }
                newMyProfileFragment.MyBillsEntityDataFactory(newMyProfileFragment.FragmentBottomSheetPaymentSettingBinding());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void SummaryVoucherView$$ExternalSyntheticLambda2() {
        DaggerNewMyProfileComponent.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DaggerNewMyProfileComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda2 = (MyProfileModule) Preconditions.getAuthRequestContext(new MyProfileModule(this));
        KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue = (GetStaticQrModule) Preconditions.getAuthRequestContext(K());
        KClassImpl$Data$declaredNonStaticMembers$22.lookAheadTest = (GetBalanceModule) Preconditions.getAuthRequestContext(whenAvailable());
        KClassImpl$Data$declaredNonStaticMembers$22.GetContactSyncConfig = (QueryPayMethodModule) Preconditions.getAuthRequestContext(G());
        KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda0 = (GenerateDeepLinkModule) Preconditions.getAuthRequestContext(readMicros());
        KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(getCallingPid());
        KClassImpl$Data$declaredNonStaticMembers$22.PrepareContext = (UserStatementModule) Preconditions.getAuthRequestContext(SummaryVoucherView$$ExternalSyntheticLambda0());
        KClassImpl$Data$declaredNonStaticMembers$22.isLayoutRequested = (SavingModule) Preconditions.getAuthRequestContext(F());
        KClassImpl$Data$declaredNonStaticMembers$22.scheduleImpl = (InvestmentModule) Preconditions.getAuthRequestContext(C());
        KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion = (GoldInvestmentModule) Preconditions.getAuthRequestContext(VerifyPinStateManager$executeRiskChallenge$2$1());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.MyBillsEntityDataFactory = requireActivity();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = "Me Page";
        KClassImpl$Data$declaredNonStaticMembers$23.PlaceComponentResult = NetworkUserEntityData$$ExternalSyntheticLambda5();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$23, r5));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda8 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, r5));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$24 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$24.getAuthRequestContext = getActivity();
        KClassImpl$Data$declaredNonStaticMembers$22.DatabaseTableConfigUtil = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$24, r5));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        MyBillsEntityDataFactory2.PlaceComponentResult = "Me Page";
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, r5));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda1 = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, r5));
        KClassImpl$Data$declaredNonStaticMembers$22.newProxyInstance = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.myprofile.NewMyProfileFragment$initComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
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
            public final /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$22.initRecordTimeStamp = (PayLaterModule) Preconditions.getAuthRequestContext(E());
        KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaPlusModule) Preconditions.getAuthRequestContext(getSupportButtonTintMode());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda2, MyProfileModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.lookAheadTest, GetBalanceModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue, GetStaticQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda0, GenerateDeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.GetContactSyncConfig, QueryPayMethodModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.PrepareContext, UserStatementModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.isLayoutRequested, SavingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.scheduleImpl, InvestmentModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion, GoldInvestmentModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda8, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.DatabaseTableConfigUtil, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda1, OauthModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$22.newProxyInstance == null) {
            KClassImpl$Data$declaredNonStaticMembers$22.newProxyInstance = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.initRecordTimeStamp, PayLaterModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2, DanaPlusModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerNewMyProfileComponent.NewMyProfileComponentImpl(KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda2, KClassImpl$Data$declaredNonStaticMembers$22.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda0, KClassImpl$Data$declaredNonStaticMembers$22.GetContactSyncConfig, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$22.PrepareContext, KClassImpl$Data$declaredNonStaticMembers$22.isLayoutRequested, KClassImpl$Data$declaredNonStaticMembers$22.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda8, KClassImpl$Data$declaredNonStaticMembers$22.DatabaseTableConfigUtil, KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda1, KClassImpl$Data$declaredNonStaticMembers$22.newProxyInstance, KClassImpl$Data$declaredNonStaticMembers$22.initRecordTimeStamp, KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(getErrorConfigVersion(), NetworkUserEntityData$$ExternalSyntheticLambda0(), DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider(), l(), s(), o(), n(), t(), OtpRegistrationPresenter$input$2());
        int i = C + 5;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? (byte) 1 : (byte) 0) != 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final GoldInvestmentModule VerifyPinStateManager$executeRiskChallenge$2$1() {
        try {
            GoldInvestmentModule goldInvestmentModule = new GoldInvestmentModule(new GoldInvestmentContract.View() { // from class: id.dana.myprofile.NewMyProfileFragment$getGoldInvestmentModule$1
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

                @Override // id.dana.investment.contract.GoldInvestmentContract.View
                public final void BuiltInFictitiousFunctionClassFactory(UserInvestmentModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment.this, p0);
                }

                @Override // id.dana.investment.contract.GoldInvestmentContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    NewMyProfileFragment newMyProfileFragment = NewMyProfileFragment.this;
                    UserInvestmentModel.Companion companion = UserInvestmentModel.INSTANCE;
                    NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(newMyProfileFragment, UserInvestmentModel.Companion.PlaceComponentResult());
                }
            });
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 1;
            C = i % 128;
            int i2 = i % 2;
            return goldInvestmentModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final GetStaticQrModule K() {
        try {
            GetStaticQrModule getStaticQrModule = new GetStaticQrModule(new GetStaticQrContract.View() { // from class: id.dana.myprofile.NewMyProfileFragment$getStaticQrModule$1
                @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                public final void PlaceComponentResult(String p0, String p1, String p2, String p3, String p4) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                public final void getAuthRequestContext(Long p0) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }

                @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewMyProfileFragment.PlaceComponentResult(NewMyProfileFragment.this, p0);
                }

                @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                public final void getAuthRequestContext(QrisTciCoConfigModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewMyProfileFragment.MyBillsEntityDataFactory(NewMyProfileFragment.this, p0.getPlaceComponentResult());
                    if (NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(NewMyProfileFragment.this)) {
                        return;
                    }
                    NewMyProfileFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0().KClassImpl$Data$declaredNonStaticMembers$2();
                }
            });
            int i = C + 25;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            return getStaticQrModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final GetBalanceModule whenAvailable() {
        GetBalanceModule getBalanceModule = new GetBalanceModule(new GetBalanceContract.View() { // from class: id.dana.myprofile.NewMyProfileFragment$getBalanceModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetAllBalanceState(List<Boolean> p0) {
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
            public final /* bridge */ /* synthetic */ void onGetBalanceState(Boolean bool) {
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetBalance(CurrencyAmountModel p0) {
                String KClassImpl$Data$declaredNonStaticMembers$22;
                String str = "";
                Intrinsics.checkNotNullParameter(p0, "");
                if (!p0.KClassImpl$Data$declaredNonStaticMembers$2() ? (KClassImpl$Data$declaredNonStaticMembers$22 = BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0)) != null : NewMyProfileFragment.this.getContext() != null && (KClassImpl$Data$declaredNonStaticMembers$22 = NewMyProfileFragment.this.getString(R.string.balance_subtitle)) != null) {
                    str = KClassImpl$Data$declaredNonStaticMembers$22;
                }
                NewMyProfileFragment.this.PlaceComponentResult(str);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                NewMyProfileFragment.FragmentBottomSheetPaymentSettingBinding(NewMyProfileFragment.this);
            }
        });
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 81;
        C = i % 128;
        if ((i % 2 == 0 ? '1' : 'S') != 'S') {
            Object obj = null;
            obj.hashCode();
            return getBalanceModule;
        }
        return getBalanceModule;
    }

    private final QueryPayMethodModule G() {
        try {
            QueryPayMethodModule queryPayMethodModule = new QueryPayMethodModule(new QueryPayMethodContract.View() { // from class: id.dana.myprofile.NewMyProfileFragment$getQueryPayMethodModule$1
                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, List<PayCardInfo> list) {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(Boolean bool) {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void PlaceComponentResult(PayCardConfigModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void getAuthRequestContext() {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void MyBillsEntityDataFactory(int p0) {
                    NewMyProfileFragment.getAuthRequestContext(NewMyProfileFragment.this, p0);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    NewMyProfileFragment.FragmentBottomSheetPaymentSettingBinding(NewMyProfileFragment.this);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    NewMyProfileFragment newMyProfileFragment = NewMyProfileFragment.this;
                    newMyProfileFragment.BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment.PrepareContext(newMyProfileFragment));
                    if (p0 == null) {
                        p0 = "";
                    }
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, DanaLogConstants.Prefix.QRCODE_QUERY_PAY_METHOD_PREFIX, p0);
                }
            });
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 67;
            C = i % 128;
            if ((i % 2 == 0 ? (char) 21 : (char) 11) != 11) {
                int i2 = 67 / 0;
                return queryPayMethodModule;
            }
            return queryPayMethodModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final GenerateDeepLinkModule readMicros() {
        GenerateDeepLinkModule generateDeepLinkModule = new GenerateDeepLinkModule(new GenerateDeepLinkContract.ProfileView() { // from class: id.dana.myprofile.NewMyProfileFragment$generateDeepLinkModule$1
            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void MyBillsEntityDataFactory(Long p0) {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void PlaceComponentResult() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                NewMyProfileFragment.MyBillsEntityDataFactory(NewMyProfileFragment.this, p0);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                NewMyProfileFragment.this.showToast(p0);
            }
        });
        int i = C + 25;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        return generateDeepLinkModule;
    }

    private final BottomSheetOnBoardingModule getCallingPid() {
        BottomSheetOnBoardingModule bottomSheetOnBoardingModule = new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.myprofile.NewMyProfileFragment$getBottomSheetOnBoardingModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                BottomSheetOnBoardingContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1, String p2) {
                NewMyProfileFragment.MyBillsEntityDataFactory(NewMyProfileFragment.this, p0, p1, p2);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append(", on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
            }
        });
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 95;
            C = i % 128;
            int i2 = i % 2;
            return bottomSheetOnBoardingModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final UserStatementModule SummaryVoucherView$$ExternalSyntheticLambda0() {
        UserStatementModule userStatementModule = new UserStatementModule(new UserStatementListener() { // from class: id.dana.myprofile.NewMyProfileFragment$getUserStatementModule$1
            @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                NewMyProfileFragment newMyProfileFragment = NewMyProfileFragment.this;
                NewMyProfileFragment.getAuthRequestContext(newMyProfileFragment, NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(newMyProfileFragment), p0, p1);
            }

            @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                NewMyProfileFragment newMyProfileFragment = NewMyProfileFragment.this;
                NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(newMyProfileFragment, NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(newMyProfileFragment), p0, p1);
            }
        });
        int i = C + 7;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        return userStatementModule;
    }

    private final SavingModule F() {
        SavingModule savingModule = new SavingModule(new SavingViewListener() { // from class: id.dana.myprofile.NewMyProfileFragment$getSavingModule$1
            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void MyBillsEntityDataFactory() {
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void PlaceComponentResult() {
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void MyBillsEntityDataFactory(SavingSummaryModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment.this, p0);
            }
        });
        int i = C + 103;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        return savingModule;
    }

    private final InvestmentModule C() {
        try {
            InvestmentModule investmentModule = new InvestmentModule(new InvestmentContract.View() { // from class: id.dana.myprofile.NewMyProfileFragment$getInvestmentModule$1
                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                }

                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void getAuthRequestContext(boolean p0) {
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

                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void MyBillsEntityDataFactory(UserInvestmentModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment.this, p0);
                }
            });
            try {
                int i = C + 49;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                if ((i % 2 != 0 ? 'W' : (char) 1) != 'W') {
                    return investmentModule;
                }
                int i2 = 63 / 0;
                return investmentModule;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static PayLaterModule E() {
        PayLaterModule payLaterModule = new PayLaterModule(new PayLaterViewListener() { // from class: id.dana.myprofile.NewMyProfileFragment$getPayLaterModule$1
        });
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 113;
        C = i % 128;
        if (i % 2 != 0) {
            return payLaterModule;
        }
        Object obj = null;
        obj.hashCode();
        return payLaterModule;
    }

    private final DanaPlusModule getSupportButtonTintMode() {
        DanaPlusModule danaPlusModule = new DanaPlusModule(new DanaPlusViewListener() { // from class: id.dana.myprofile.NewMyProfileFragment$getDanaPlusModule$1
            @Override // id.dana.investment.listener.DanaPlusViewListener, id.dana.investment.contract.DanaPlusContract.View
            public final void MyBillsEntityDataFactory(UserInvestmentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                NewMyProfileFragment.getAuthRequestContext(NewMyProfileFragment.this, p0);
            }
        });
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 1;
            C = i % 128;
            if (i % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                return danaPlusModule;
            }
            return danaPlusModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void P() {
        NewFragmentMyprofileBinding newFragmentMyprofileBinding;
        int i = C + 29;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 != 0) {
            newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
            int i2 = 37 / 0;
            if ((newFragmentMyprofileBinding != null ? (char) 31 : 'G') != 31) {
                return;
            }
        } else {
            newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
            if (newFragmentMyprofileBinding == null) {
                return;
            }
        }
        try {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 53;
            C = i3 % 128;
            int i4 = i3 % 2;
            AppCompatButton appCompatButton = newFragmentMyprofileBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            if (appCompatButton != null) {
                try {
                    appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment.this);
                        }
                    });
                    int i5 = C + 23;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void BottomSheetCardBindingView$watcherCardNumberView$1(NewMyProfileFragment newMyProfileFragment) {
        int i = C + 59;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
            newMyProfileFragment.b();
        } else {
            Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
            newMyProfileFragment.b();
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = C + 125;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return;
        }
        int i3 = 48 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0019, code lost:
    
        if ((r4) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0027, code lost:
    
        if ((r4 ? 14 : 'V') != 'V') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0029, code lost:
    
        l().MyBillsEntityDataFactory("loan_personal");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0030, code lost:
    
        r4 = id.dana.myprofile.NewMyProfileFragment.C + 123;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x003a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x003b, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x003c, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void FragmentBottomSheetPaymentSettingBinding(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 33
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            java.lang.String r1 = "loan_personal"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r0 == 0) goto L1e
            r0 = 10
            r2 = 0
            int r0 = r0 / r2
            if (r4 == 0) goto L19
            r2 = 1
        L19:
            if (r2 == 0) goto L30
            goto L29
        L1c:
            r4 = move-exception
            throw r4
        L1e:
            r0 = 86
            if (r4 == 0) goto L25
            r4 = 14
            goto L27
        L25:
            r4 = 86
        L27:
            if (r4 == r0) goto L30
        L29:
            id.dana.usereducation.BottomSheetOnBoardingContract$Presenter r4 = r3.l()
            r4.MyBillsEntityDataFactory(r1)
        L30:
            int r4 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L3b
            int r4 = r4 + 123
            int r0 = r4 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0     // Catch: java.lang.Exception -> L3b
            int r4 = r4 % 2
            return
        L3b:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.FragmentBottomSheetPaymentSettingBinding(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0015, code lost:
    
        if (r3 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x001a, code lost:
    
        if (r3 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x001c, code lost:
    
        r4 = id.dana.utils.UrlUtil.PlaceComponentResult(r4, id.dana.onboarding.OnboardingParams.FIRST_TIME_TOP_UP);
        FragmentBottomSheetPaymentSettingBinding(r5);
        r3 = id.dana.myprofile.NewMyProfileFragment.C + 61;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3 % 128;
        r3 = r3 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(boolean r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 87
            if (r0 != 0) goto L11
            r0 = 87
            goto L13
        L11:
            r0 = 45
        L13:
            if (r0 == r1) goto L18
            if (r3 == 0) goto L2f
            goto L1c
        L18:
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L33
            if (r3 == 0) goto L2f
        L1c:
            java.lang.String r3 = "firstTime=true"
            java.lang.String r4 = id.dana.utils.UrlUtil.PlaceComponentResult(r4, r3)
            r2.FragmentBottomSheetPaymentSettingBinding(r5)
            int r3 = id.dana.myprofile.NewMyProfileFragment.C
            int r3 = r3 + 61
            int r5 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r5
            int r3 = r3 % 2
        L2f:
            r2.NetworkUserEntityData$$ExternalSyntheticLambda8(r4)
            return
        L33:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.PlaceComponentResult(boolean, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0020, code lost:
    
        if ((getContext() != null ? 'U' : 24) != 'U') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002b, code lost:
    
        if (r0 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0031, code lost:
    
        if (isAdded() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0033, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0035, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0036, code lost:
    
        if (r0 == true) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0038, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 3;
        id.dana.myprofile.NewMyProfileFragment.C = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0046, code lost:
    
        if ((r0 % 2) != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0048, code lost:
    
        r0 = getResources();
        r1 = new java.lang.Object[0];
        r1[1] = java.lang.Integer.valueOf(r7);
        r7 = r0.getQuantityString(id.dana.R.plurals.f46612131820544, r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0059, code lost:
    
        r7 = getResources().getQuantityString(id.dana.R.plurals.f46612131820544, r7, java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0069, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "");
        BuiltInFictitiousFunctionClassFactory(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x006f, code lost:
    
        r7 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 125;
        id.dana.myprofile.NewMyProfileFragment.C = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0079, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(int r7) {
        /*
            r6 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r2) goto L23
            android.content.Context r0 = r6.getContext()
            r3 = 85
            if (r0 == 0) goto L1e
            r0 = 85
            goto L20
        L1e:
            r0 = 24
        L20:
            if (r0 == r3) goto L2d
            goto L6f
        L23:
            android.content.Context r0 = r6.getContext()
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L6f
        L2d:
            boolean r0 = r6.isAdded()
            if (r0 == 0) goto L35
            r0 = 0
            goto L36
        L35:
            r0 = 1
        L36:
            if (r0 == r2) goto L6f
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 3
            int r3 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r3
            int r0 = r0 % 2
            java.lang.String r3 = ""
            r4 = 2131820544(0x7f110000, float:1.9273806E38)
            if (r0 != 0) goto L59
            android.content.res.Resources r0 = r6.getResources()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r1[r2] = r5
            java.lang.String r7 = r0.getQuantityString(r4, r7, r1)
            goto L69
        L59:
            android.content.res.Resources r0 = r6.getResources()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r2[r1] = r5
            java.lang.String r7 = r0.getQuantityString(r4, r7, r2)
        L69:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            r6.BuiltInFictitiousFunctionClassFactory(r7)
        L6f:
            int r7 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r7 = r7 + 125
            int r0 = r7 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0
            int r7 = r7 % 2
            return
        L7a:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0024, code lost:
    
        if ((r3 != 0) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003a, code lost:
    
        if ((r0.length() == 0 ? 'C' : kotlin.text.Typography.dollar) != 'C') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003c, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0040, code lost:
    
        r2 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0044, code lost:
    
        id.dana.myprofile.NewMyProfileFragment.C = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0046, code lost:
    
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0050, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String getNameOrBuilderList() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 53
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L29
            java.lang.String r0 = r5.A
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r3 = r0.length()
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L27
            if (r3 != 0) goto L23
            r3 = 0
            goto L24
        L23:
            r3 = 1
        L24:
            if (r3 == 0) goto L3e
            goto L3c
        L27:
            r0 = move-exception
            throw r0
        L29:
            java.lang.String r0 = r5.A
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r3 = r0.length()
            r4 = 67
            if (r3 != 0) goto L38
            r3 = 67
            goto L3a
        L38:
            r3 = 36
        L3a:
            if (r3 == r4) goto L3e
        L3c:
            r1 = 0
            goto L48
        L3e:
            int r2 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L4f
            int r2 = r2 + 65
            int r3 = r2 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r3     // Catch: java.lang.Exception -> L4f
            int r2 = r2 % 2
        L48:
            if (r1 == 0) goto L4c
            java.lang.String r0 = "-"
        L4c:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L4f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.getNameOrBuilderList():java.lang.String");
    }

    private final void BuiltInFictitiousFunctionClassFactory(SavingSummaryModel p0) {
        if (p0 != null) {
            if ((this.newProxyInstance != null ? (char) 30 : Typography.quote) == 30) {
                int i = C + 5;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                if (M().isNullObject()) {
                    return;
                }
                Iterator<SettingModel> it = M().getSettingChilds().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SettingModel next = it.next();
                    if ((Intrinsics.areEqual(next.getName(), ProfileUserServiceType.SAVING) ? 'X' : '8') == 'X') {
                        SavingSummarySettingMapper savingSummarySettingMapper = SavingSummarySettingMapper.INSTANCE;
                        String string = getString(R.string.saving_subtitle);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        next.setSubtitle(SavingSummarySettingMapper.BuiltInFictitiousFunctionClassFactory(p0, string));
                        break;
                    }
                }
                NetworkUserEntityData$$ExternalSyntheticLambda7(MyProfileMenuCategories.PROFILE_USER_SERVICE);
            }
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 23;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x00c5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(id.dana.investment.model.UserInvestmentModel r8) {
        /*
            r7 = this;
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r7.newProxyInstance
            if (r0 != 0) goto L5
            return
        L5:
            id.dana.domain.profilemenu.model.SettingModel r0 = r7.M()
            boolean r1 = r0.isNullObject()
            if (r1 == 0) goto L10
            return
        L10:
            java.lang.String r1 = r0.getCollection()
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 65
            if (r2 == 0) goto L1e
            r4 = 65
            goto L20
        L1e:
            r4 = 71
        L20:
            r5 = 0
            r6 = 1
            if (r4 == r3) goto L25
            goto L30
        L25:
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 != 0) goto L2d
            r2 = 0
            goto L2e
        L2d:
            r2 = 1
        L2e:
            if (r2 == 0) goto L32
        L30:
            r2 = 1
            goto L45
        L32:
            int r2 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r2 = r2 + 75
            int r3 = r2 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L40
            r2 = 0
            goto L41
        L40:
            r2 = 1
        L41:
            if (r2 == r6) goto L44
            goto L30
        L44:
            r2 = 0
        L45:
            if (r2 != 0) goto Lc5
            int r2 = id.dana.myprofile.NewMyProfileFragment.C
            int r2 = r2 + 87
            int r3 = r2 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r2 = r2 % 2
            java.lang.String r2 = "setting_category_user_service"
            boolean r1 = kotlin.text.StringsKt.equals(r2, r1, r6)
            if (r1 == 0) goto L5b
            r1 = 0
            goto L5c
        L5b:
            r1 = 1
        L5c:
            if (r1 == 0) goto L5f
            goto Lc5
        L5f:
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            int r1 = r1 + 111
            int r3 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L6c
            r5 = 1
        L6c:
            if (r5 == 0) goto L7f
            java.util.List r0 = r0.getSettingChilds()     // Catch: java.lang.Exception -> L7d
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L7d
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L7b
            goto L87
        L7b:
            r8 = move-exception
            throw r8
        L7d:
            r8 = move-exception
            throw r8
        L7f:
            java.util.List r0 = r0.getSettingChilds()     // Catch: java.lang.Exception -> Lc3
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lc3
        L87:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb5
            java.lang.Object r1 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r1 = (id.dana.domain.profilemenu.model.SettingModel) r1
            java.lang.String r3 = r1.getName()
            java.lang.String r4 = "setting_investment"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto L87
            id.dana.domain.investment.AccountInvestmentStatus r0 = r8.PlaceComponentResult
            id.dana.domain.investment.model.UserInvestmentInfo r3 = new id.dana.domain.investment.model.UserInvestmentInfo
            r3.<init>(r0)
            android.content.Context r0 = r7.requireContext()
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            id.dana.myprofile.mapper.InvestmentSummaryMapperKt.BuiltInFictitiousFunctionClassFactory(r8, r0, r3, r1)
        Lb5:
            r7.NetworkUserEntityData$$ExternalSyntheticLambda7(r2)
            int r8 = id.dana.myprofile.NewMyProfileFragment.C
            int r8 = r8 + 115
            int r0 = r8 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            int r8 = r8 % 2
            goto Lc5
        Lc3:
            r8 = move-exception
            throw r8
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.MyBillsEntityDataFactory(id.dana.investment.model.UserInvestmentModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x006d, code lost:
    
        if (r1 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x007b, code lost:
    
        if ((r1 != null) != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x007d, code lost:
    
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0089, code lost:
    
        if (r1.hasNext() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x008b, code lost:
    
        r2 = 'A';
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x008e, code lost:
    
        r2 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0090, code lost:
    
        if (r2 == '?') goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0092, code lost:
    
        r2 = id.dana.myprofile.NewMyProfileFragment.C + 79;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2 % 128;
        r2 = r2 % 2;
        r2 = r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00ad, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(((id.dana.domain.profilemenu.model.SettingModel) r2).getName(), "setting_dana_plus") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00af, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00b0, code lost:
    
        r3 = (id.dana.domain.profilemenu.model.SettingModel) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00b2, code lost:
    
        if (r3 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00b4, code lost:
    
        r1 = new id.dana.domain.investment.model.UserInvestmentInfo(r8.PlaceComponentResult);
        r2 = requireContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "");
        id.dana.myprofile.mapper.DanaPlusSummaryMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(r8, r2, r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00c7, code lost:
    
        NetworkUserEntityData$$ExternalSyntheticLambda7(id.dana.data.profilemenu.MyProfileMenuCategories.PROFILE_USER_SERVICE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.investment.model.UserInvestmentModel r8) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.getAuthRequestContext(id.dana.investment.model.UserInvestmentModel):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:70:0x008c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void BuiltInFictitiousFunctionClassFactory(id.dana.investment.model.UserInvestmentModel r8) {
        /*
            r7 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r7.newProxyInstance
            if (r0 != 0) goto Lf
            return
        Lf:
            id.dana.domain.profilemenu.model.SettingModel r0 = r7.M()
            java.util.List r0 = r0.getSettingChilds()
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L71
            int r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r1 = r1 + 111
            int r5 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r5
            int r1 = r1 % 2
            java.lang.Object r1 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r1 = (id.dana.domain.profilemenu.model.SettingModel) r1
            java.lang.String r5 = r1.getName()
            java.lang.String r6 = "setting_emas"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L42
            r5 = 1
            goto L43
        L42:
            r5 = 0
        L43:
            if (r5 == 0) goto L1b
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 61
            int r5 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r5
            int r0 = r0 % 2
            java.lang.String r5 = ""
            if (r0 != 0) goto L64
            android.content.Context r0 = r7.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            id.dana.myprofile.mapper.GoldInvestmentSummaryMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(r8, r0, r1)
            int r8 = r2.length     // Catch: java.lang.Throwable -> L62
            goto L71
        L62:
            r8 = move-exception
            throw r8
        L64:
            android.content.Context r0 = r7.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            id.dana.myprofile.mapper.GoldInvestmentSummaryMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(r8, r0, r1)
        L71:
            java.lang.String r8 = "setting_category_user_service"
            r7.NetworkUserEntityData$$ExternalSyntheticLambda7(r8)
            int r8 = id.dana.myprofile.NewMyProfileFragment.C
            int r8 = r8 + 3
            int r0 = r8 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            int r8 = r8 % 2
            if (r8 == 0) goto L83
            r3 = 0
        L83:
            if (r3 == 0) goto L86
            return
        L86:
            r2.hashCode()     // Catch: java.lang.Throwable -> L8a
            return
        L8a:
            r8 = move-exception
            throw r8
        L8c:
            r8 = move-exception
            goto L8f
        L8e:
            throw r8
        L8f:
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(id.dana.investment.model.UserInvestmentModel):void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7(String p0) {
        try {
            NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
            if (newFragmentMyprofileBinding != null) {
                int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 41;
                C = i % 128;
                int i2 = i % 2;
                RecyclerView recyclerView = newFragmentMyprofileBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (!(recyclerView == null)) {
                    int i3 = C + 7;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                    if (i3 % 2 != 0) {
                        try {
                            int i4 = 7 / 0;
                            if (this.newProxyInstance == null) {
                                return;
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    } else if (this.newProxyInstance == null) {
                        return;
                    }
                    int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 93;
                    C = i5 % 128;
                    if ((i5 % 2 == 0 ? (char) 3 : '6') == 3) {
                        boolean isComputingLayout = recyclerView.isComputingLayout();
                        Object[] objArr = null;
                        int length = objArr.length;
                        if (!(!isComputingLayout)) {
                            return;
                        }
                    } else if (recyclerView.isComputingLayout()) {
                        return;
                    }
                    MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
                    if (myProfileDiffutilAdapter == null) {
                        return;
                    }
                    int i6 = C + 67;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i6 % 128;
                    int i7 = i6 % 2;
                    int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory(p0);
                    if (MyBillsEntityDataFactory2 != -1) {
                        myProfileDiffutilAdapter.notifyItemChanged(MyBillsEntityDataFactory2);
                        int i8 = C + 13;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i8 % 128;
                        int i9 = i8 % 2;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void PrepareContext(String p0) {
        try {
            int i = C + 21;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if (i % 2 == 0) {
                try {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda4 = p0;
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = p0;
            Object obj = null;
            obj.hashCode();
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        int i = C + 121;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            if (NumberUtils.isValidShowPhoneNumber(p0)) {
                p0 = MaskedTextUtil.PlaceComponentResult(p0, "••••");
            }
            NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
            if (newFragmentMyprofileBinding != null) {
                NewSimpleProfileWithQrView newSimpleProfileWithQrView = newFragmentMyprofileBinding.scheduleImpl;
                if ((newSimpleProfileWithQrView != null ? 'D' : 'N') != 'N') {
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 91;
                    C = i3 % 128;
                    int i4 = i3 % 2;
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                    newSimpleProfileWithQrView.setUserName(p0);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void getAuthRequestContext(String p0) {
        NewSimpleProfileWithQrView newSimpleProfileWithQrView;
        int i = C + 125;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(p0, "");
        NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
        if (newFragmentMyprofileBinding != null) {
            try {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 29;
                C = i3 % 128;
                if (i3 % 2 == 0) {
                    newSimpleProfileWithQrView = newFragmentMyprofileBinding.scheduleImpl;
                    Object obj = null;
                    obj.hashCode();
                    if (newSimpleProfileWithQrView == null) {
                        return;
                    }
                } else {
                    newSimpleProfileWithQrView = newFragmentMyprofileBinding.scheduleImpl;
                    if (newSimpleProfileWithQrView == null) {
                        return;
                    }
                }
                int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
                C = i4 % 128;
                if ((i4 % 2 == 0 ? 'E' : 'Q') == 'E') {
                    newSimpleProfileWithQrView.setPhoneNumber(p0);
                    int i5 = 40 / 0;
                    return;
                }
                try {
                    newSimpleProfileWithQrView.setPhoneNumber(p0);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    public final void PlaceComponentResult(String p0) {
        int i = C + 9;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            if ((!TextUtils.isEmpty(p0) ? 'S' : 'V') != 'V') {
                if (!(this.newProxyInstance == null)) {
                    try {
                        this.E = p0;
                        connectForeground();
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
            C = i3 % 128;
            if ((i3 % 2 == 0 ? '2' : '*') != '*') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                if (TextUtils.isEmpty(p0)) {
                    return;
                }
                int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 1;
                C = i % 128;
                int i2 = i % 2;
                if ((this.newProxyInstance != null ? (char) 20 : 'M') != 'M') {
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 65;
                    C = i3 % 128;
                    if (i3 % 2 != 0) {
                        this.A = p0;
                        connectForeground();
                        return;
                    }
                    this.A = p0;
                    connectForeground();
                    int i4 = 97 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x008c, code lost:
    
        if (id.dana.utils.extension.LanguageExtKt.getAuthRequestContext() != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0096, code lost:
    
        if (r6 != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0098, code lost:
    
        r6 = id.dana.myprofile.NewMyProfileFragment.C + 69;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r6 % 128;
        r6 = r6 % 2;
        r6 = getContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00a6, code lost:
    
        if (r6 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00a8, code lost:
    
        r6 = id.dana.utils.StringWrapperKt.getAuthRequestContext(r6, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00ad, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x00ae, code lost:
    
        r2.setSubtitle(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00b2, code lost:
    
        r6 = getContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00b6, code lost:
    
        if (r6 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00b8, code lost:
    
        r6 = id.dana.utils.StringWrapperKt.getAuthRequestContext(r6, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00bd, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00be, code lost:
    
        r2.setSubtitleEn(r6);
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(id.dana.utils.StringWrapper r9) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.getAuthRequestContext(id.dana.utils.StringWrapper):void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long p0) {
        try {
            int i = C + 125;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                char c = i % 2 != 0 ? 'H' : 'Y';
                this.PlaceComponentResult = p0;
                if (c != 'Y') {
                    int i2 = 88 / 0;
                }
                int i3 = C + 33;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0019, code lost:
    
        if (r0 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002a, code lost:
    
        if ((r5.isEnable()) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002c, code lost:
    
        r5 = r5.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0032, code lost:
    
        if (r5 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003a, code lost:
    
        if (r5.length() == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003c, code lost:
    
        r5 = '1';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003f, code lost:
    
        r5 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:
    
        if (r5 == '1') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0046, code lost:
    
        r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x004a, code lost:
    
        id.dana.myprofile.NewMyProfileFragment.C = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x004e, code lost:
    
        if ((r5 % 2) != 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0050, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0051, code lost:
    
        r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
        id.dana.myprofile.NewMyProfileFragment.C = r5 % 128;
        r5 = r5 % 2;
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x005d, code lost:
    
        r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 21;
        id.dana.myprofile.NewMyProfileFragment.C = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0067, code lost:
    
        if (r3 != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0069, code lost:
    
        initRecordTimeStamp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x006c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x006d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x006e, code lost:
    
        throw r5;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(id.dana.domain.homeinfo.ThirdPartyServiceResponse r5) {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 5
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = ""
            r3 = 1
            if (r0 != 0) goto L1e
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            boolean r0 = r5.isEnable()
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L6f
            goto L2c
        L1c:
            r5 = move-exception
            throw r5
        L1e:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            boolean r0 = r5.isEnable()
            if (r0 == 0) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L6f
        L2c:
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Exception -> L6d
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Exception -> L6d
            if (r5 == 0) goto L5d
            int r5 = r5.length()
            r0 = 49
            if (r5 == 0) goto L3f
            r5 = 49
            goto L41
        L3f:
            r5 = 78
        L41:
            if (r5 == r0) goto L44
            goto L5d
        L44:
            int r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L6d
            int r5 = r5 + 75
            int r0 = r5 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0     // Catch: java.lang.Exception -> L6d
            int r5 = r5 % 2
            if (r5 != 0) goto L51
            r1 = 1
        L51:
            int r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r5 = r5 + 103
            int r0 = r5 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0
            int r5 = r5 % 2
            r3 = r1
            goto L67
        L5d:
            int r5 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r5 = r5 + 21
            int r0 = r5 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0
            int r5 = r5 % 2
        L67:
            if (r3 != 0) goto L6f
            r4.initRecordTimeStamp()
            return
        L6d:
            r5 = move-exception
            throw r5
        L6f:
            a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(id.dana.domain.homeinfo.ThirdPartyServiceResponse):void");
    }

    private static void a() {
        int i = C + 107;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        ServiceMaintenanceUtil.getAuthRequestContext(TrackerKey.PromoCenterSourceType.PROMO_QUEST);
        int i3 = C + 21;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        try {
            int i = C + 109;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            a();
            try {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 11;
                C = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 20 : 'L') != 20) {
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x001d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void connectForeground() {
        /*
            r6 = this;
            id.dana.domain.profilemenu.model.SettingModel r0 = r6.M()
            boolean r1 = r0.isNullObject()
            if (r1 == 0) goto Lb
            return
        Lb:
            java.util.List r0 = r0.getSettingChilds()
            java.util.Iterator r0 = r0.iterator()
            int r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r1 = r1 + 55
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r2
            int r1 = r1 % 2
        L1d:
            boolean r1 = r0.hasNext()
            r2 = 11
            if (r1 == 0) goto L28
            r1 = 87
            goto L2a
        L28:
            r1 = 11
        L2a:
            if (r1 == r2) goto La0
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            r2 = 1
            int r1 = r1 + r2
            int r3 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r1 = r1 % 2
            r3 = 0
            java.lang.String r4 = "setting_my_payment_cards"
            if (r1 == 0) goto L5a
            java.lang.Object r1 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r1 = (id.dana.domain.profilemenu.model.SettingModel) r1
            java.lang.String r2 = r1.getName()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            r4 = 14
            int r4 = r4 / r3
            r3 = 66
            if (r2 == 0) goto L53
            r2 = 66
            goto L55
        L53:
            r2 = 71
        L55:
            if (r2 == r3) goto L6e
            goto L7a
        L58:
            r0 = move-exception
            throw r0
        L5a:
            java.lang.Object r1 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r1 = (id.dana.domain.profilemenu.model.SettingModel) r1
            java.lang.String r5 = r1.getName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r4)
            if (r4 == 0) goto L6b
            goto L6c
        L6b:
            r3 = 1
        L6c:
            if (r3 == r2) goto L7a
        L6e:
            java.lang.String r2 = r6.A     // Catch: java.lang.Exception -> L78
            java.lang.String r2 = NetworkUserEntityData$$ExternalSyntheticLambda3(r2)     // Catch: java.lang.Exception -> L78
            r1.setSubtitle(r2)     // Catch: java.lang.Exception -> L78
            goto L1d
        L78:
            r0 = move-exception
            throw r0
        L7a:
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = "setting_balance"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            r3 = 88
            if (r2 == 0) goto L8b
            r2 = 59
            goto L8d
        L8b:
            r2 = 88
        L8d:
            if (r2 == r3) goto L1d
            int r2 = id.dana.myprofile.NewMyProfileFragment.C
            int r2 = r2 + 13
            int r3 = r2 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r2 = r2 % 2
            java.lang.String r2 = r6.E
            r1.setSubtitle(r2)
            goto L1d
        La0:
            java.lang.String r0 = "setting_category_user_service"
            r6.NetworkUserEntityData$$ExternalSyntheticLambda7(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.connectForeground():void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void MyBillsEntityDataFactory() {
        int i = C + 45;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        N();
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 13;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x002b, code lost:
    
        if ((r2.newProxyInstance != null ? 22 : 'M') != 22) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0034, code lost:
    
        if (r0 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0036, code lost:
    
        moveToNextValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0039, code lost:
    
        r3 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
        id.dana.myprofile.NewMyProfileFragment.C = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0044, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0045, code lost:
    
        throw r3;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L48
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto L1d
            r0 = 1
            goto L1e
        L1d:
            r0 = 0
        L1e:
            if (r0 == r1) goto L2e
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r2.newProxyInstance
            r1 = 22
            if (r0 == 0) goto L29
            r0 = 22
            goto L2b
        L29:
            r0 = 77
        L2b:
            if (r0 == r1) goto L36
            goto L48
        L2e:
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r2.newProxyInstance
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L48
        L36:
            r2.moveToNextValue(r3)
            int r3 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L44
            int r3 = r3 + 103
            int r0 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0     // Catch: java.lang.Exception -> L44
            int r3 = r3 % 2
            goto L48
        L44:
            r3 = move-exception
            throw r3
        L46:
            r3 = move-exception
            throw r3
        L48:
            int r3 = id.dana.myprofile.NewMyProfileFragment.C
            int r3 = r3 + 123
            int r0 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            int r3 = r3 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.MyBillsEntityDataFactory(java.lang.String):void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        int i = C + 83;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 != 0)) {
            MyBillsEntityDataFactory(true);
        } else {
            MyBillsEntityDataFactory(false);
        }
        int i2 = C + 67;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.myprofile.MyProfileContract.View, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 47;
        C = i % 128;
        if (i % 2 == 0) {
            MyBillsEntityDataFactory(true);
            try {
                if (this.VerifyPinStateManager$executeRiskChallenge$2$1) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            MyBillsEntityDataFactory(false);
            if ((!this.VerifyPinStateManager$executeRiskChallenge$2$1 ? '\'' : 'c') != '\'') {
                return;
            }
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 81;
        C = i2 % 128;
        boolean z = i2 % 2 != 0;
        FlowViewUtil$textChanges$2();
        if (z) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Override // id.dana.myprofile.MyProfileContract.View, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 25;
        C = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(str, "");
        Toast.makeText(getActivity(), ErrorUtil.BuiltInFictitiousFunctionClassFactory(getBaseActivity()), 0).show();
        try {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 33;
            try {
                C = i3 % 128;
                if (i3 % 2 != 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0025, code lost:
    
        if (r0 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0036, code lost:
    
        if (r0 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0038, code lost:
    
        r0.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new java.util.ArrayList(r4), null);
        r4 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 51;
        id.dana.myprofile.NewMyProfileFragment.C = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0051, code lost:
    
        getValueOfTouchPositionAbsolute();
        BottomSheetCardBindingView$watcherCardNumberView$1();
        H();
        A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0061, code lost:
    
        getErrorConfigVersion().initRecordTimeStamp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0068, code lost:
    
        getErrorConfigVersion().lookAheadTest();
        FlowViewUtil$textChanges$1();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0070, code lost:
    
        throw r4;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(java.util.List<? extends id.dana.domain.profilemenu.model.SettingModel> r4) {
        /*
            r3 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L71
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 76
            if (r0 == 0) goto L11
            r0 = 76
            goto L13
        L11:
            r0 = 54
        L13:
            java.lang.String r2 = ""
            if (r0 == r1) goto L28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.util.List r4 = KClassImpl$Data$declaredNonStaticMembers$2(r4)
            r0 = 0
            java.util.List r4 = id.dana.mapper.SettingModelMapper.PlaceComponentResult(r4, r0)
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r3.newProxyInstance
            if (r0 == 0) goto L51
            goto L38
        L28:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.util.List r4 = KClassImpl$Data$declaredNonStaticMembers$2(r4)
            r0 = 1
            java.util.List r4 = id.dana.mapper.SettingModelMapper.PlaceComponentResult(r4, r0)
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r3.newProxyInstance
            if (r0 == 0) goto L51
        L38:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Collection r4 = (java.util.Collection) r4
            r1.<init>(r4)
            java.util.List r1 = (java.util.List) r1
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r4 = r0.getAuthRequestContext
            r0 = 0
            r4.KClassImpl$Data$declaredNonStaticMembers$2(r1, r0)
            int r4 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r4 = r4 + 51
            int r0 = r4 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0
            int r4 = r4 % 2
        L51:
            r3.getValueOfTouchPositionAbsolute()
            r3.BottomSheetCardBindingView$watcherCardNumberView$1()
            r3.H()
            r3.A()
            id.dana.myprofile.MyProfileContract$Presenter r4 = r3.getErrorConfigVersion()     // Catch: java.lang.Exception -> L71
            r4.initRecordTimeStamp()     // Catch: java.lang.Exception -> L6f
            id.dana.myprofile.MyProfileContract$Presenter r4 = r3.getErrorConfigVersion()     // Catch: java.lang.Exception -> L71
            r4.lookAheadTest()     // Catch: java.lang.Exception -> L6f
            r3.FlowViewUtil$textChanges$1()     // Catch: java.lang.Exception -> L6f
            return
        L6f:
            r4 = move-exception
            throw r4
        L71:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.getAuthRequestContext(java.util.List):void");
    }

    private static List<SettingModel> KClassImpl$Data$declaredNonStaticMembers$2(List<? extends SettingModel> p0) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = p0.iterator();
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 73;
        C = i % 128;
        int i2 = i % 2;
        while (true) {
            if (!(it.hasNext())) {
                return arrayList;
            }
            Object next = it.next();
            if ((true ^ Intrinsics.areEqual(((SettingModel) next).getAction(), "logout") ? Typography.greater : 'F') == '>') {
                int i3 = C + 71;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                if (i3 % 2 != 0) {
                    try {
                        arrayList.add(next);
                        int i4 = 50 / 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    arrayList.add(next);
                }
            }
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        i();
        Intent intent = new Intent(getBaseActivity(), MyReferralDetailActivity.class);
        intent.putExtra(MyReferralDetailActivity.BundleKey.BUNDLE_REFERRAL_CONSULT, getErrorConfigVersion().GetContactSyncConfig());
        intent.putExtra(MyReferralDetailActivity.BundleKey.BUNDLE_REFERRAL_DEEPLINK, getErrorConfigVersion().scheduleImpl());
        intent.putExtra(MyReferralDetailActivity.BundleKey.BUNDLE_SHOW_REFERRAL, p0);
        startActivity(intent);
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
            C = i % 128;
            if (i % 2 != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0035, code lost:
    
        if ((r0 > 0 ? ']' : 19) != ']') goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0041, code lost:
    
        if (r6.length() > 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0043, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 119;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
        r0 = r0 % 2;
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x004f, code lost:
    
        r0 = false;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L90
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1     // Catch: java.lang.Exception -> L90
            int r0 = r0 % 2
            r0 = 7
            if (r6 == 0) goto Lf
            r1 = 7
            goto L11
        Lf:
            r1 = 15
        L11:
            if (r1 == r0) goto L15
            goto L8f
        L15:
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L3a
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            int r4 = r2.length     // Catch: java.lang.Throwable -> L38
            r4 = 93
            if (r0 <= 0) goto L33
            r0 = 93
            goto L35
        L33:
            r0 = 19
        L35:
            if (r0 == r4) goto L43
            goto L4f
        L38:
            r6 = move-exception
            throw r6
        L3a:
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L4f
        L43:
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 119
            int r4 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r4
            int r0 = r0 % 2
            r0 = 1
            goto L50
        L4f:
            r0 = 0
        L50:
            if (r0 == 0) goto L8f
            boolean r6 = DatabaseTableConfigUtil(r6)
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6
            if (r6 == 0) goto L5b
            r1 = 1
        L5b:
            if (r1 == r3) goto L72
            r6 = 48
            if (r7 != 0) goto L64
            r0 = 48
            goto L66
        L64:
            r0 = 47
        L66:
            if (r0 == r6) goto L6c
            r5.newProxyInstance(r7)
            goto L88
        L6c:
            java.lang.String r6 = "UNDEFINED"
            r5.newProxyInstance(r6)
            goto L88
        L72:
            int r6 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r6 = r6 + 59
            int r7 = r6 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L85
            r5.Z()
            int r6 = r2.length     // Catch: java.lang.Throwable -> L83
            goto L88
        L83:
            r6 = move-exception
            throw r6
        L85:
            r5.Z()
        L88:
            boolean r6 = r5.NetworkUserEntityData$$ExternalSyntheticLambda6
            if (r6 == 0) goto L8f
            r5.VerifyPinStateManager$executeRiskChallenge$2$2()
        L8f:
            return
        L90:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String):void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void getAuthRequestContext() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
        C = i % 128;
        int i2 = i % 2;
        if ((getContext() != null ? (char) 24 : ':') != ':') {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            SocialSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(requireContext);
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "");
            SaveContactSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(requireContext2);
            try {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 43;
                try {
                    C = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        h();
        DeepLinkParser.getAuthRequestContext();
        TopUpUserConsultManager.MyBillsEntityDataFactory();
        OnboardingActivity.Companion companion = OnboardingActivity.INSTANCE;
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        BaseActivity baseActivity2 = baseActivity;
        Intrinsics.checkNotNullParameter(baseActivity2, "");
        Intent MyBillsEntityDataFactory2 = OnboardingActivity.Companion.MyBillsEntityDataFactory((Context) baseActivity2);
        MyBillsEntityDataFactory2.putExtra("FROM_LOGOUT", true);
        baseActivity2.startActivity(MyBillsEntityDataFactory2);
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void lookAheadTest() {
        LoadingDialog loadingDialog = new LoadingDialog(getBaseActivity());
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = loadingDialog;
        if (!(loadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing())) {
            try {
                int i = C + 41;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                try {
                    loadingDialog.BuiltInFictitiousFunctionClassFactory.show();
                    int i3 = C + 17;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception unused) {
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001a, code lost:
    
        if ((r0 != null) != true) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0024, code lost:
    
        if (r0 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0026, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 125;
        id.dana.myprofile.NewMyProfileFragment.C = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0036, code lost:
    
        r3 = r0;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
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
            if (r0 == r2) goto L1f
            id.dana.dialog.LoadingDialog r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L1d
            if (r0 != 0) goto L19
            goto L1a
        L19:
            r1 = 1
        L1a:
            if (r1 == r2) goto L36
            goto L26
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            id.dana.dialog.LoadingDialog r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            r3.hashCode()     // Catch: java.lang.Throwable -> L3b
            if (r0 != 0) goto L36
        L26:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            goto L37
        L36:
            r3 = r0
        L37:
            r3.KClassImpl$Data$declaredNonStaticMembers$2()
            return
        L3b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2():void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void getAuthRequestContext(boolean p0) {
        try {
            int i = C + 15;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                this.readMicros = p0;
                if (p0) {
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 75;
                    C = i3 % 128;
                    if ((i3 % 2 == 0 ? 'J' : '/') != 'J') {
                        PrepareContext();
                    } else {
                        PrepareContext();
                        Object obj = null;
                        obj.hashCode();
                    }
                }
                int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 7;
                C = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0038, code lost:
    
        if (((id.dana.domain.profilemenu.model.ProfileCompletion) r6).getCompletedTaskCount() == getErrorConfigVersion().getReadMicros()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0055, code lost:
    
        if ((((id.dana.domain.profilemenu.model.ProfileCompletion) r6).getCompletedTaskCount() == getErrorConfigVersion().getReadMicros() ? 'G' : '!') != 'G') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0058, code lost:
    
        NetworkUserEntityData$$ExternalSyntheticLambda4();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x005b, code lost:
    
        return;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(id.dana.domain.profilemenu.model.SettingModel r6) {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 51
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof id.dana.domain.profilemenu.model.ProfileCompletion
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L17
            r0 = 0
            goto L18
        L17:
            r0 = 1
        L18:
            if (r0 == r2) goto L5c
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 73
            int r3 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L3d
            r0 = r6
            id.dana.domain.profilemenu.model.ProfileCompletion r0 = (id.dana.domain.profilemenu.model.ProfileCompletion) r0
            int r0 = r0.getCompletedTaskCount()
            id.dana.myprofile.MyProfileContract$Presenter r3 = r5.getErrorConfigVersion()
            int r3 = r3.getReadMicros()
            r4 = 34
            int r4 = r4 / r1
            if (r0 != r3) goto L5c
            goto L58
        L3b:
            r6 = move-exception
            throw r6
        L3d:
            r0 = r6
            id.dana.domain.profilemenu.model.ProfileCompletion r0 = (id.dana.domain.profilemenu.model.ProfileCompletion) r0     // Catch: java.lang.Exception -> Lb1
            int r0 = r0.getCompletedTaskCount()     // Catch: java.lang.Exception -> Lb1
            id.dana.myprofile.MyProfileContract$Presenter r3 = r5.getErrorConfigVersion()     // Catch: java.lang.Exception -> Lb1
            int r3 = r3.getReadMicros()     // Catch: java.lang.Exception -> Lb1
            r4 = 71
            if (r0 != r3) goto L53
            r0 = 71
            goto L55
        L53:
            r0 = 33
        L55:
            if (r0 == r4) goto L58
            goto L5c
        L58:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda4()
            return
        L5c:
            r0 = 20
            r6.setViewType(r0)     // Catch: java.lang.Exception -> Lb1
            boolean r0 = r5.Y()     // Catch: java.lang.Exception -> Lb1
            if (r0 != 0) goto L69
            r0 = 0
            goto L6a
        L69:
            r0 = 1
        L6a:
            if (r0 == 0) goto L85
            boolean r0 = r5.Y()
            if (r0 == 0) goto L74
            r0 = 0
            goto L75
        L74:
            r0 = 1
        L75:
            if (r0 == r2) goto La5
            boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            r0 = r0 ^ r2
            r6.setKycRevoked(r0)
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r5.newProxyInstance
            if (r0 == 0) goto La5
            r0.getAuthRequestContext(r6)
            goto La5
        L85:
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 111
            int r3 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r3
            int r0 = r0 % 2
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r5.newProxyInstance
            if (r0 == 0) goto La5
            java.util.ArrayList r3 = new java.util.ArrayList
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r4 = r0.getAuthRequestContext
            java.util.List<T> r4 = r4.moveToNextValue
            r3.<init>(r4)
            r3.add(r1, r6)
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r6 = r0.getAuthRequestContext
            r0 = 0
            r6.KClassImpl$Data$declaredNonStaticMembers$2(r3, r0)
        La5:
            boolean r6 = r5.NetworkUserEntityData$$ExternalSyntheticLambda6
            if (r6 == 0) goto Laa
            r1 = 1
        Laa:
            if (r1 == r2) goto Lad
            goto Lb0
        Lad:
            r5.isLayoutRequested()
        Lb0:
            return
        Lb1:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.MyBillsEntityDataFactory(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void BuiltInFictitiousFunctionClassFactory(ConsultFamilyAccountResult p0) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
            C = i % 128;
            if ((i % 2 == 0 ? '^' : '\'') != '^') {
                Intrinsics.checkNotNullParameter(p0, "");
                KClassImpl$Data$declaredNonStaticMembers$2(p0);
                return;
            }
            Intrinsics.checkNotNullParameter(p0, "");
            KClassImpl$Data$declaredNonStaticMembers$2(p0);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 31;
        C = i % 128;
        int i2 = i % 2;
        this.GetContactSyncConfig = p0;
        int i3 = C + 57;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void PlaceComponentResult() {
        int i = C + 5;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        char c = i % 2 != 0 ? ']' : '?';
        MyBillsEntityDataFactory(-1);
        if (c == ']') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 59;
        C = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int i3 = 68 / 0;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void PlaceComponentResult(UserConfigProfileNewFlag p0) {
        try {
            int i = C + 27;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if (!(i % 2 != 0)) {
                Intrinsics.checkNotNullParameter(p0, "");
                this.getOnBoardingScenario = p0;
                return;
            }
            Intrinsics.checkNotNullParameter(p0, "");
            this.getOnBoardingScenario = p0;
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void MyBillsEntityDataFactory(UserConfigProfileNewFlag p0) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
            C = i % 128;
            if (i % 2 != 0) {
                try {
                    Intrinsics.checkNotNullParameter(p0, "");
                    this.getOnBoardingScenario = p0;
                    FlowViewUtil$textChanges$1();
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            Intrinsics.checkNotNullParameter(p0, "");
            this.getOnBoardingScenario = p0;
            FlowViewUtil$textChanges$1();
            Object obj = null;
            obj.hashCode();
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0043, code lost:
    
        r0 = r0.getSettingChilds().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x004f, code lost:
    
        if (r0.hasNext() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0051, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0053, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0054, code lost:
    
        if (r3 == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0056, code lost:
    
        r3 = id.dana.myprofile.NewMyProfileFragment.C + 65;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3 % 128;
        r3 = r3 % 2;
        r3 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0070, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3.getName(), "setting_referral") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0072, code lost:
    
        r5 = id.dana.myprofile.NewMyProfileFragment.C + 55;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x007e, code lost:
    
        if ((r5 % 2) == 0) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0080, code lost:
    
        r5 = 'Z';
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0083, code lost:
    
        r5 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0085, code lost:
    
        if (r5 == '\b') goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0087, code lost:
    
        r3.setReferralUserCount(r8);
        r3.setStartReferralLottie(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x008e, code lost:
    
        r3.setReferralUserCount(r8);
        r3.setStartReferralLottie(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0095, code lost:
    
        NetworkUserEntityData$$ExternalSyntheticLambda7(id.dana.data.profilemenu.MyProfileMenuCategories.PROFILE_REWARDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x002f, code lost:
    
        if ((r0 != null ? 'C' : '\n') != 'C') goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x003b, code lost:
    
        if (r0 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0041, code lost:
    
        if (r0.isNullObject() != false) goto L122;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(int r8) {
        /*
            r7 = this;
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r7.newProxyInstance
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8
            r0 = 0
            goto L9
        L8:
            r0 = 1
        L9:
            if (r0 == r2) goto L9f
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L9d
            int r0 = r0 + 63
            int r3 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r3     // Catch: java.lang.Exception -> L9b
            int r0 = r0 % 2
            r3 = 9
            if (r0 != 0) goto L1c
            r0 = 9
            goto L1e
        L1c:
            r0 = 46
        L1e:
            java.lang.String r4 = "setting_category_rewards"
            if (r0 == r3) goto L33
            id.dana.domain.profilemenu.model.SettingModel r0 = r7.scheduleImpl(r4)
            r3 = 67
            if (r0 == 0) goto L2d
            r5 = 67
            goto L2f
        L2d:
            r5 = 10
        L2f:
            if (r5 == r3) goto L3d
            goto L9f
        L33:
            id.dana.domain.profilemenu.model.SettingModel r0 = r7.scheduleImpl(r4)
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L9f
        L3d:
            boolean r3 = r0.isNullObject()     // Catch: java.lang.Exception -> L9b
            if (r3 != 0) goto L9f
            java.util.List r0 = r0.getSettingChilds()     // Catch: java.lang.Exception -> L9d
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L9d
        L4b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L53
            r3 = 1
            goto L54
        L53:
            r3 = 0
        L54:
            if (r3 == 0) goto L95
            int r3 = id.dana.myprofile.NewMyProfileFragment.C
            int r3 = r3 + 65
            int r5 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r5
            int r3 = r3 % 2
            java.lang.Object r3 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r3 = (id.dana.domain.profilemenu.model.SettingModel) r3
            java.lang.String r5 = r3.getName()
            java.lang.String r6 = "setting_referral"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L4b
            int r5 = id.dana.myprofile.NewMyProfileFragment.C
            int r5 = r5 + 55
            int r6 = r5 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r6
            int r5 = r5 % 2
            r6 = 8
            if (r5 == 0) goto L83
            r5 = 90
            goto L85
        L83:
            r5 = 8
        L85:
            if (r5 == r6) goto L8e
            r3.setReferralUserCount(r8)
            r3.setStartReferralLottie(r1)
            goto L4b
        L8e:
            r3.setReferralUserCount(r8)
            r3.setStartReferralLottie(r2)
            goto L4b
        L95:
            r7.NetworkUserEntityData$$ExternalSyntheticLambda7(r4)
            goto L9f
        L99:
            r8 = move-exception
            throw r8
        L9b:
            r8 = move-exception
            throw r8
        L9d:
            r8 = move-exception
            throw r8
        L9f:
            int r8 = id.dana.myprofile.NewMyProfileFragment.C
            int r8 = r8 + r2
            int r0 = r8 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            int r8 = r8 % 2
            if (r8 == 0) goto Lb0
            r8 = 64
            int r8 = r8 / r1
            return
        Lae:
            r8 = move-exception
            throw r8
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.MyBillsEntityDataFactory(int):void");
    }

    private final void PrepareContext() {
        if (!this.VerifyPinStateManager$executeRiskChallenge$2$2) {
            int i = C + 123;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            MyBillsEntityDataFactory(FragmentBottomSheetPaymentSettingBinding());
            return;
        }
        try {
            NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
            if (newFragmentMyprofileBinding != null) {
                NestedScrollView nestedScrollView = newFragmentMyprofileBinding.PlaceComponentResult;
                if (!(nestedScrollView != null)) {
                    return;
                }
                nestedScrollView.smoothScrollTo(0, 0);
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 35;
                C = i3 % 128;
                int i4 = i3 % 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void i() {
        try {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getBaseActivity().getApplicationContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.REFERRER_PAGE_OPEN;
            EventTrackerModel.Builder MyBillsEntityDataFactory2 = builder.MyBillsEntityDataFactory("Source", "Me Page");
            MyBillsEntityDataFactory2.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
            int i = C + 51;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void h() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getBaseActivity());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.LOGOUT;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = builder.MyBillsEntityDataFactory(TrackerKey.Property.LOGOUT_TYPE, "Normal");
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 121;
        C = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 81 / 0;
        }
    }

    private static boolean DatabaseTableConfigUtil(String p0) {
        try {
            int i = C + 37;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                char c = i % 2 != 0 ? Typography.less : '^';
                boolean areEqual = Intrinsics.areEqual("KYC2", p0);
                if (c == '<') {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                return areEqual;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void Z() {
        int i = C + 69;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        try {
            NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
            AppCompatButton appCompatButton = (newFragmentMyprofileBinding != null ? 'a' : 'C') != 'a' ? null : newFragmentMyprofileBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            if ((appCompatButton != null ? ')' : (char) 4) == ')') {
                int i3 = C + 35;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
                appCompatButton.setVisibility(8);
            }
            try {
                NewFragmentMyprofileBinding newFragmentMyprofileBinding2 = (NewFragmentMyprofileBinding) getBinding();
                if (newFragmentMyprofileBinding2 != null) {
                    NewSimpleProfileWithQrView newSimpleProfileWithQrView = newFragmentMyprofileBinding2.scheduleImpl;
                    if ((newSimpleProfileWithQrView != null ? InputCardNumberView.DIVIDER : (char) 7) != ' ') {
                        return;
                    }
                    newSimpleProfileWithQrView.onPremiumUser(true);
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void newProxyInstance(String p0) {
        NetworkUserEntityData$$ExternalSyntheticLambda4(p0);
        NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
        if ((newFragmentMyprofileBinding != null ? '_' : '!') != '!') {
            int i = C + 61;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            try {
                NewSimpleProfileWithQrView newSimpleProfileWithQrView = newFragmentMyprofileBinding.scheduleImpl;
                if (newSimpleProfileWithQrView != null) {
                    int i3 = C + 83;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                    int i4 = i3 % 2;
                    newSimpleProfileWithQrView.onPremiumUser(false);
                    int i5 = C + 119;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
                    int i6 = i5 % 2;
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0016, code lost:
    
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0021, code lost:
    
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0023, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0026, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 23;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
        r0 = r0 % 2;
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda4(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0029, code lost:
    
        if (r3.equals("IN_PROGRESS") == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0032, code lost:
    
        if (r3.equals(id.dana.domain.model.KycStatus.MANUAL_REVIEW) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003f, code lost:
    
        if (r1 != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0042, code lost:
    
        r3 = id.dana.R.drawable.ic_kyc_inreview_blue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1(java.lang.String r3) {
        /*
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L5e
            int r0 = r3.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1246945744: goto L35;
                case -652189199: goto L2c;
                case -604548089: goto L23;
                case 2066319421: goto L13;
                default: goto L12;
            }
        L12:
            goto L46
        L13:
            java.lang.String r0 = "FAILED"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r1 = 1
        L1d:
            if (r1 == r2) goto L50
            r3 = 2131233231(0x7f0809cf, float:1.8082594E38)
            goto L53
        L23:
            java.lang.String r0 = "IN_PROGRESS"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L42
            goto L50
        L2c:
            java.lang.String r0 = "MANUAL_REVIEW"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L42
            goto L50
        L35:
            java.lang.String r0 = "DUKCAPIL_INTEGRATION"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L3e
            goto L3f
        L3e:
            r1 = 1
        L3f:
            if (r1 == 0) goto L42
            goto L50
        L42:
            r3 = 2131233233(0x7f0809d1, float:1.8082598E38)
            goto L53
        L46:
            int r3 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r3 = r3 + 31
            int r0 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0
            int r3 = r3 % 2
        L50:
            r3 = 2131233230(0x7f0809ce, float:1.8082592E38)
        L53:
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            return r3
        L5e:
            r3 = 2131233968(0x7f080cb0, float:1.8084088E38)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(java.lang.String):int");
    }

    private static int initRecordTimeStamp(String p0) {
        int i = C + 9;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        if ((!TextUtils.isEmpty(p0) ? (char) 24 : 'A') != 'A') {
            switch (p0.hashCode()) {
                case -1667597306:
                    return (!p0.equals(KycStatus.WAITING_DOC) ? 'S' : (char) 18) != 18 ? R.string.kyc_0_title : R.string.kyc_waiting_doc_title;
                case -652189199:
                    return (!p0.equals(KycStatus.MANUAL_REVIEW) ? 'X' : 'P') != 'P' ? R.string.kyc_0_title : R.string.kyc_manual_review_title;
                case -604548089:
                    return !p0.equals("IN_PROGRESS") ? R.string.kyc_0_title : R.string.kyc_processing_title;
                case 2066319421:
                    if ((!p0.equals("FAILED") ? '.' : 'a') != '.') {
                        return R.string.kyc_failed_title;
                    }
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 35;
                    C = i3 % 128;
                    if (i3 % 2 == 0) {
                        Object[] objArr = null;
                        int length = objArr.length;
                        return R.string.kyc_0_title;
                    }
                    return R.string.kyc_0_title;
                default:
                    return R.string.kyc_0_title;
            }
        }
        return R.string.kyc_0_title;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0048 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int GetContactSyncConfig(java.lang.String r3) {
        /*
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L17
            r0 = 0
            goto L18
        L17:
            r0 = 1
        L18:
            if (r0 == r2) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L20
            r1 = 1
        L20:
            if (r1 == 0) goto L4c
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            java.lang.String r1 = "FAILED"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r0 == 0) goto L3d
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L3b
            if (r3 == 0) goto L4c
            goto L48
        L3b:
            r3 = move-exception
            throw r3
        L3d:
            r0 = 11
            if (r3 == 0) goto L44
            r3 = 11
            goto L45
        L44:
            r3 = 6
        L45:
            if (r3 == r0) goto L48
            goto L4c
        L48:
            r3 = 2131100373(0x7f0602d5, float:1.7813126E38)
            goto L4f
        L4c:
            r3 = 2131099753(0x7f060069, float:1.7811868E38)
        L4f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.GetContactSyncConfig(java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0033, code lost:
    
        if (r0 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0043, code lost:
    
        if ((r0 != null ? '`' : '3') != '3') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0045, code lost:
    
        r0 = r0.getUserProfileImageView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0049, code lost:
    
        if (r0 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004b, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x004d, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x004e, code lost:
    
        if (r3 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0051, code lost:
    
        id.dana.core.ui.glide.GlideApp.getAuthRequestContext(requireContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(r6).PlaceComponentResult((int) id.dana.R.drawable.avatar_placeholder).MyBillsEntityDataFactory(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void moveToNextValue(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.getContext()
            r1 = 77
            if (r0 == 0) goto Lb
            r0 = 20
            goto Ld
        Lb:
            r0 = 77
        Ld:
            if (r0 == r1) goto L89
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.NewFragmentMyprofileBinding r0 = (id.dana.databinding.NewFragmentMyprofileBinding) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L6b
            int r3 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r3 = r3 + 63
            int r4 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L38
            id.dana.richview.NewSimpleProfileWithQrView r0 = r0.scheduleImpl
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L6b
            goto L45
        L36:
            r6 = move-exception
            throw r6
        L38:
            id.dana.richview.NewSimpleProfileWithQrView r0 = r0.scheduleImpl
            r3 = 51
            if (r0 == 0) goto L41
            r4 = 96
            goto L43
        L41:
            r4 = 51
        L43:
            if (r4 == r3) goto L6b
        L45:
            android.widget.ImageView r0 = r0.getUserProfileImageView()
            if (r0 == 0) goto L4d
            r3 = 0
            goto L4e
        L4d:
            r3 = 1
        L4e:
            if (r3 == 0) goto L51
            goto L6b
        L51:
            android.content.Context r3 = r5.requireContext()
            id.dana.core.ui.glide.GlideRequests r3 = id.dana.core.ui.glide.GlideApp.getAuthRequestContext(r3)
            id.dana.core.ui.glide.GlideRequest r3 = r3.MyBillsEntityDataFactory()
            id.dana.core.ui.glide.GlideRequest r6 = r3.BuiltInFictitiousFunctionClassFactory(r6)
            r3 = 2131231788(0x7f08042c, float:1.8079667E38)
            id.dana.core.ui.glide.GlideRequest r6 = r6.PlaceComponentResult(r3)
            r6.MyBillsEntityDataFactory(r0)
        L6b:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.databinding.NewFragmentMyprofileBinding r6 = (id.dana.databinding.NewFragmentMyprofileBinding) r6
            if (r6 == 0) goto L89
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 41
            int r3 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r3
            int r0 = r0 % 2
            id.dana.richview.NewSimpleProfileWithQrView r6 = r6.scheduleImpl
            if (r6 == 0) goto L82
            goto L83
        L82:
            r1 = 1
        L83:
            if (r1 == 0) goto L86
            goto L89
        L86:
            r6.stopRefreshAnimation()
        L89:
            int r6 = id.dana.myprofile.NewMyProfileFragment.C
            int r6 = r6 + 81
            int r0 = r6 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            int r6 = r6 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.moveToNextValue(java.lang.String):void");
    }

    private final void N() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 119;
        C = i % 128;
        int i2 = i % 2;
        SkeletonScreen skeletonScreen = this.SubSequence;
        if ((skeletonScreen != null ? 'J' : (char) 15) != 'J') {
            return;
        }
        try {
            Intrinsics.checkNotNull(skeletonScreen);
            skeletonScreen.PlaceComponentResult();
            this.SubSequence = null;
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 89;
            C = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void isAuth() {
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = new MyProfileDiffutilAdapter();
        this.newProxyInstance = myProfileDiffutilAdapter;
        myProfileDiffutilAdapter.PlaceComponentResult = new GroupedSettingItemClickListener() { // from class: id.dana.myprofile.NewMyProfileFragment$initProfileAdapter$1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int p0) {
                SettingModel settingModel;
                NewMyProfileFragment newMyProfileFragment = NewMyProfileFragment.this;
                MyProfileDiffutilAdapter DatabaseTableConfigUtil = NewMyProfileFragment.DatabaseTableConfigUtil(newMyProfileFragment);
                if (DatabaseTableConfigUtil == null) {
                    settingModel = null;
                } else if (DatabaseTableConfigUtil.MyBillsEntityDataFactory(p0)) {
                    settingModel = DatabaseTableConfigUtil.getAuthRequestContext.moveToNextValue.get(p0);
                } else {
                    settingModel = SettingModel.empty();
                }
                NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(newMyProfileFragment, settingModel);
            }

            @Override // id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener
            public final void getAuthRequestContext(SettingModel p0) {
                if (p0 != null && p0.isHasReddot()) {
                    MyProfileContract.Presenter errorConfigVersion = NewMyProfileFragment.this.getErrorConfigVersion();
                    String name = p0.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "");
                    errorConfigVersion.MyBillsEntityDataFactory(name);
                }
                NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment.this, p0);
            }
        };
        MyProfileDiffutilAdapter myProfileDiffutilAdapter2 = this.newProxyInstance;
        if (myProfileDiffutilAdapter2 != null) {
            try {
                myProfileDiffutilAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = new MyProfileDiffutilAdapter.RedDotListener() { // from class: id.dana.myprofile.NewMyProfileFragment$$ExternalSyntheticLambda1
                    @Override // id.dana.myprofile.adapter.MyProfileDiffutilAdapter.RedDotListener
                    public final boolean getAuthRequestContext(String str) {
                        return NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment.this, str);
                    }
                };
                int i = C + 35;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static final boolean BuiltInFictitiousFunctionClassFactory(NewMyProfileFragment newMyProfileFragment, String str) {
        boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 121;
        C = i % 128;
        try {
            if (i % 2 != 0) {
                Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
                try {
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(str);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Intrinsics.checkNotNullParameter(newMyProfileFragment, "");
                Intrinsics.checkNotNullExpressionValue(str, "");
                NetworkUserEntityData$$ExternalSyntheticLambda2 = newMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(str);
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = C + 27;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            int i3 = i2 % 2;
            return NetworkUserEntityData$$ExternalSyntheticLambda2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda2(String p0) {
        long KClassImpl$Data$declaredNonStaticMembers$22 = getErrorConfigVersion().KClassImpl$Data$declaredNonStaticMembers$2(p0);
        if (!(KClassImpl$Data$declaredNonStaticMembers$22 > 0)) {
            int i = C + 109;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            return true;
        }
        try {
            if (!(DateTimeUtil.INSTANCE.getDifferenceInDays(new Date(), new Date(KClassImpl$Data$declaredNonStaticMembers$22)) <= 0)) {
                return true;
            }
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 21;
            C = i3 % 128;
            int i4 = i3 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:271:0x0187
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.domain.profilemenu.model.SettingModel r6) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0028, code lost:
    
        if ((r2 != -784346227) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0031, code lost:
    
        if (r2 != (-784346227)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0036, code lost:
    
        if (r2 == (-602817356)) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x003b, code lost:
    
        if (r2 != 516642788) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0043, code lost:
    
        if (r0.equals("setting_more") == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0045, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 81;
        id.dana.myprofile.NewMyProfileFragment.C = r0 % 128;
        r0 = r0 % 2;
        getAuthRequestContext(r8, id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0053, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x005a, code lost:
    
        if (r0.equals("setting_new_security_settings") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005d, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005e, code lost:
    
        if (r5 == true) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0060, code lost:
    
        getAuthRequestContext(r8, id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x006c, code lost:
    
        if (r0.equals("setting_new_smartpay") == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0074, code lost:
    
        if (r7.getOnBoardingScenario.getShouldShowSmartPayFlag() == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0076, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 33;
        id.dana.myprofile.NewMyProfileFragment.C = r0 % 128;
        r0 = r0 % 2;
        r7.getOnBoardingScenario.setShouldShowSmartPayFlag(false);
        getErrorConfigVersion().PlaceComponentResult(r7.getOnBoardingScenario, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x008d, code lost:
    
        getAuthRequestContext(r8, id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0092, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(id.dana.domain.profilemenu.model.SettingModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getName()
            r1 = 2
            if (r0 == 0) goto La
            r2 = 31
            goto Lb
        La:
            r2 = 2
        Lb:
            if (r2 == r1) goto L92
            int r2 = id.dana.myprofile.NewMyProfileFragment.C
            int r2 = r2 + 63
            int r3 = r2 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r2 = r2 % r1
            r3 = -784346227(0xffffffffd13fd38d, float:-5.1492999E10)
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L2d
            int r2 = r0.hashCode()
            r6 = 0
            int r6 = r6.length     // Catch: java.lang.Throwable -> L2b
            if (r2 == r3) goto L27
            r3 = 1
            goto L28
        L27:
            r3 = 0
        L28:
            if (r3 == 0) goto L66
            goto L33
        L2b:
            r8 = move-exception
            throw r8
        L2d:
            int r2 = r0.hashCode()
            if (r2 == r3) goto L66
        L33:
            r3 = -602817356(0xffffffffdc11bcb4, float:-1.64085412E17)
            if (r2 == r3) goto L54
            r3 = 516642788(0x1ecb57e4, float:2.1529812E-20)
            if (r2 != r3) goto L92
            java.lang.String r2 = "setting_more"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L92
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 81
            int r2 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r2
            int r0 = r0 % r1
            java.lang.Class<id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity> r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.class
            r7.getAuthRequestContext(r8, r0)
            return
        L54:
            java.lang.String r1 = "setting_new_security_settings"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5d
            goto L5e
        L5d:
            r5 = 1
        L5e:
            if (r5 == r4) goto L92
            java.lang.Class<id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity> r0 = id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.class
            r7.getAuthRequestContext(r8, r0)
            return
        L66:
            java.lang.String r2 = "setting_new_smartpay"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L92
            id.dana.domain.profilemenu.model.UserConfigProfileNewFlag r0 = r7.getOnBoardingScenario
            boolean r0 = r0.getShouldShowSmartPayFlag()
            if (r0 == 0) goto L8d
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 33
            int r2 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r2
            int r0 = r0 % r1
            id.dana.domain.profilemenu.model.UserConfigProfileNewFlag r0 = r7.getOnBoardingScenario
            r0.setShouldShowSmartPayFlag(r5)
            id.dana.myprofile.MyProfileContract$Presenter r0 = r7.getErrorConfigVersion()
            id.dana.domain.profilemenu.model.UserConfigProfileNewFlag r1 = r7.getOnBoardingScenario
            id.dana.myprofile.MyProfileContract.Presenter.CC.MyBillsEntityDataFactory(r0, r1)
        L8d:
            java.lang.Class<id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity> r0 = id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.class
            r7.getAuthRequestContext(r8, r0)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.PlaceComponentResult(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    private final void moveToNextValue() {
        FragmentPermissionRequest fragmentPermissionRequest;
        Context context = getContext();
        if (!(context == null)) {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 75;
            C = i % 128;
            int i2 = i % 2;
            ConsultFamilyAccountResult consultFamilyAccountResult = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (consultFamilyAccountResult != null) {
                int i3 = C + 75;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                if (i3 % 2 != 0) {
                    fragmentPermissionRequest = this.PrepareContext;
                    int i4 = 81 / 0;
                    if (fragmentPermissionRequest == null) {
                        return;
                    }
                } else {
                    try {
                        fragmentPermissionRequest = this.PrepareContext;
                        if ((fragmentPermissionRequest != null ? (char) 30 : '8') != 30) {
                            return;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                FamilyStatusActionUtil.getAuthRequestContext(context, consultFamilyAccountResult, fragmentPermissionRequest, m());
            }
        }
    }

    @Deprecated(message = "V1 MyBills will be removed soon", replaceWith = @ReplaceWith(expression = "actionMyBillsV2()", imports = {"id.dana.mybills.ui.v2.MyBillsHomeActivity"}))
    private final void DatabaseTableConfigUtil() {
        startActivity(new Intent(getBaseActivity(), MyBillsActivity.class));
        try {
            int i = C + 117;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if ((i % 2 != 0 ? (char) 22 : '/') != 22) {
                return;
            }
            int i2 = 69 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        Intent className = new Intent("android.intent.action.VIEW").setClassName(getBaseActivity().getPackageName(), "id.dana.mybills.ui.v2.MyBillsHomeActivity");
        className.putExtra(MyBillsHomeActivity.MY_BILLS_SUBSCRIPTION_LIST_OPEN_TRACKER_SOURCE, TrackerKey.SourceType.PROFILE_PAGE);
        startActivity(className);
        int i = C + 7;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
    }

    private final void getAuthRequestContext(SettingModel p0, Class<?> p1) {
        try {
            Intent intent = new Intent(getBaseActivity(), p1);
            intent.putExtra(MyProfileBundleKey.SETTING_MODEL, p0);
            startActivity(intent);
            int i = C + 59;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        new MaterialDialog(requireContext, MaterialDialog.INSTANCE.getDEFAULT_BEHAVIOR()).message(Integer.valueOf((int) R.string.logout_dialog_message), null, null).positiveButton(Integer.valueOf((int) R.string.dialog_positive), null, new Function1<MaterialDialog, Unit>() { // from class: id.dana.myprofile.NewMyProfileFragment$actionLogout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                invoke2(materialDialog);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog materialDialog) {
                Intrinsics.checkNotNullParameter(materialDialog, "");
                NewMyProfileFragment.this.getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda5();
            }
        }).negativeButton(Integer.valueOf((int) R.string.dialog_negative), null, null).show();
        int i = C + 43;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
    }

    private final void d() {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 33;
            C = i % 128;
            if ((i % 2 == 0 ? (char) 7 : '=') != 7) {
                ProductPageManager p = p();
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                String kycFromProfileUrl = m().getKycFromProfileUrl();
                Intrinsics.checkNotNullExpressionValue(kycFromProfileUrl, "");
                ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(p, requireActivity, kycFromProfileUrl);
            } else {
                ProductPageManager p2 = p();
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "");
                String kycFromProfileUrl2 = m().getKycFromProfileUrl();
                Intrinsics.checkNotNullExpressionValue(kycFromProfileUrl2, "");
                ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(p2, requireActivity2, kycFromProfileUrl2);
                Object obj = null;
                obj.hashCode();
            }
            try {
                int i2 = C + 23;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void initRecordTimeStamp() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 87;
        C = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            Intent intentClassWithTracking = getIntentClassWithTracking(MissionListActivity.class, "Me Page");
            Intrinsics.checkNotNullExpressionValue(intentClassWithTracking, "");
            startActivity(intentClassWithTracking);
        } else {
            try {
                Intent intentClassWithTracking2 = getIntentClassWithTracking(MissionListActivity.class, "Me Page");
                Intrinsics.checkNotNullExpressionValue(intentClassWithTracking2, "");
                startActivity(intentClassWithTracking2);
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = C + 121;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int length = objArr.length;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:42:0x002c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void GetContactSyncConfig() {
        /*
            r2 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            java.lang.Class<id.dana.promocode.views.RedeemPromoCodeActivity> r0 = id.dana.promocode.views.RedeemPromoCodeActivity.class
            java.lang.String r1 = "Me Page"
            android.content.Intent r0 = r2.getIntentClassWithTracking(r0, r1)     // Catch: java.lang.Exception -> L2e
            r2.startActivity(r0)     // Catch: java.lang.Exception -> L2e
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L23
            r0 = 0
            goto L24
        L23:
            r0 = 1
        L24:
            if (r0 == 0) goto L27
            return
        L27:
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L2a
            return
        L2a:
            r0 = move-exception
            throw r0
        L2c:
            r0 = move-exception
            throw r0
        L2e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.GetContactSyncConfig():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 77;
        C = i % 128;
        int i2 = i % 2;
        getErrorConfigVersion().BuiltInFictitiousFunctionClassFactory();
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 115;
        C = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        int i4 = 21 / 0;
    }

    private final void QrExpiredActivity() {
        startActivity(new Intent(requireContext(), MerchantManagementActivity.class));
        int i = C + 47;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private final void FillAnimation() {
        startActivity(new Intent(requireContext(), VerificationListActivity.class));
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
        C = i % 128;
        int i2 = i % 2;
    }

    private final void moveToNextValue(SettingModel p0) {
        ProfileCompletion profileCompletion = (ProfileCompletion) p0;
        String taskType = profileCompletion.getTaskType();
        switch (taskType.hashCode()) {
            case -1893766600:
                try {
                    if (!taskType.equals(TrackerKey.LoginType.DANA_VIZ)) {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
                break;
            case -512843026:
                if (!taskType.equals(SubtitleType.SECURITY_QUESTIONS)) {
                    return;
                }
                break;
            case 66081660:
                if (!taskType.equals(SubtitleType.EMAIL)) {
                    return;
                }
                int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
                C = i % 128;
                int i2 = i % 2;
                String authRequestContext = UrlUtil.getAuthRequestContext("/m/portal/emailSettings");
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext, NetworkUserEntityData$$ExternalSyntheticLambda3());
                return;
            case 516913366:
                if (taskType.equals(UpdateUserInfoRequest.USERNAME)) {
                    flip();
                    return;
                }
                return;
            case 648617662:
                if ((taskType.equals("TRUSTED_DEVICE") ? 'c' : '6') != '6') {
                    int i3 = C + 15;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                    int i4 = i3 % 2;
                    PlaceComponentResult(profileCompletion);
                    return;
                }
                return;
            case 853317742:
                if (taskType.equals("NICKNAME")) {
                    String authRequestContext2 = UrlUtil.getAuthRequestContext(DanaUrl.CHANGE_NAME);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
                    DanaH5.startContainerFullUrl(authRequestContext2, NetworkUserEntityData$$ExternalSyntheticLambda3());
                    return;
                }
                return;
            default:
                try {
                    int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 21;
                    C = i5 % 128;
                    int i6 = i5 % 2;
                    return;
                } catch (Exception e2) {
                    throw e2;
                }
        }
        getAuthRequestContext(p0, SecuritySettingsActivity.class);
    }

    private final void PlaceComponentResult(ProfileCompletion p0) {
        int i = C + 47;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            TwilioIntroductionActivity.Companion companion = TwilioIntroductionActivity.INSTANCE;
            BaseActivity baseActivity = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            startActivity(TwilioIntroductionActivity.Companion.getAuthRequestContext(baseActivity, TwilioIntroductionActivity.SETTING_PAGE, p0.getSecurityIdForTrustedDevice()));
            return;
        }
        TwilioIntroductionActivity.Companion companion2 = TwilioIntroductionActivity.INSTANCE;
        BaseActivity baseActivity2 = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
        startActivity(TwilioIntroductionActivity.Companion.getAuthRequestContext(baseActivity2, TwilioIntroductionActivity.SETTING_PAGE, p0.getSecurityIdForTrustedDevice()));
        Object obj = null;
        obj.hashCode();
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 53;
            C = i % 128;
            if (i % 2 != 0) {
                if ((Y() ? '\'' : InputCardNumberView.DIVIDER) != '\'') {
                    return;
                }
            } else {
                int i2 = 59 / 0;
                if (!Y()) {
                    return;
                }
            }
            int i3 = C + 89;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
            if (myProfileDiffutilAdapter != null) {
                ArrayList arrayList = new ArrayList(myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue);
                arrayList.remove(0);
                myProfileDiffutilAdapter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, null);
            }
            getErrorConfigVersion().MyBillsEntityDataFactory(true);
            int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 59;
            C = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        int i = C + 59;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 != 0)) {
            try {
                FragmentActivity requireActivity = requireActivity();
                try {
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                    FeatureSaving.BuiltInFictitiousFunctionClassFactory(requireActivity, MapsKt.mapOf(TuplesKt.to("source", "Me Page")));
                    return;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "");
        FeatureSaving.BuiltInFictitiousFunctionClassFactory(requireActivity2, MapsKt.mapOf(TuplesKt.to("source", "Me Page")));
        Object obj = null;
        obj.hashCode();
    }

    private static void g() {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 87;
            C = i % 128;
            int i2 = i % 2;
            String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            DanaH5.startContainerFullUrl(authRequestContext);
            int i3 = C + 13;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private final String getErrorConfigVersion(String p0) {
        long j = this.PlaceComponentResult / 1000;
        Map<String, String> DatabaseTableConfigUtil = UrlUtil.DatabaseTableConfigUtil(p0);
        String str = DatabaseTableConfigUtil.get("ymAuthenticationToken");
        boolean z = false;
        if (str != null) {
            int i = C + 45;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            try {
                if ((str.length() > 0 ? (char) 19 : '1') == 19) {
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 115;
                    C = i3 % 128;
                    int i4 = i3 % 2;
                    z = true;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(getErrorConfigVersion().getGetCallingPid());
            sb.append('_');
            sb.append(String.valueOf(j));
            sb.append('_');
            sb.append(DatabaseTableConfigUtil.get(SemanticAttributes.MessagingDestinationKindValues.TOPIC));
            sb.append('_');
            sb.append(DatabaseTableConfigUtil.get("subtopic"));
            p0 = StringsKt.replace$default(p0, "{token}", sb.toString(), false, 4, (Object) null);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("https://m.dana.id");
        sb2.append(p0);
        return sb2.toString();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(SettingModel p0) {
        String name = p0.getName();
        if (!(name == null)) {
            int i = C + 109;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            try {
                switch (name.hashCode()) {
                    case -2006050296:
                        if (name.equals("setting_my_bills")) {
                            l().PlaceComponentResult("my_bills", ProfileServicesUrlMapper.MyBillsEntityDataFactory(p0.getRedirectUrl()));
                            return;
                        }
                        break;
                    case -121893092:
                        if (name.equals("setting_aku")) {
                            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 85;
                            C = i3 % 128;
                            int i4 = i3 % 2;
                            lookAheadTest(p0);
                            return;
                        }
                        break;
                    case -121883067:
                        if ((name.equals("setting_kyb") ? 'P' : JSONLexer.EOI) != 26) {
                            try {
                                int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
                                C = i5 % 128;
                                int i6 = i5 % 2;
                                BuiltInFictitiousFunctionClassFactory(p0);
                                return;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        break;
                    case -121874758:
                        if (name.equals("setting_tnc")) {
                            int i7 = BottomSheetCardBindingView$watcherCardNumberView$1 + 33;
                            C = i7 % 128;
                            int i8 = i7 % 2;
                            g();
                            return;
                        }
                        break;
                    case -89626590:
                        if ((name.equals("setting_investment") ? (char) 6 : 'b') != 'b') {
                            getAuthRequestContext(p0);
                            return;
                        }
                        break;
                    case 101546777:
                        if (name.equals("setting_resolution_center")) {
                            this.DatabaseTableConfigUtil = true;
                            getErrorConfigVersion().KClassImpl$Data$declaredNonStaticMembers$2();
                            if (this.getOnBoardingScenario.getShouldShowResolutionCenterFlag()) {
                                this.getOnBoardingScenario.setShouldShowResolutionCenterFlag(false);
                                getErrorConfigVersion().PlaceComponentResult(this.getOnBoardingScenario, false);
                            }
                            NetworkUserEntityData$$ExternalSyntheticLambda8(p0.getRedirectUrl());
                            return;
                        }
                        break;
                    case 1215209638:
                        if (name.equals("setting_my_payment_cards")) {
                            int i9 = C + 43;
                            BottomSheetCardBindingView$watcherCardNumberView$1 = i9 % 128;
                            if ((i9 % 2 != 0 ? InputCardNumberView.DIVIDER : 'N') != ' ') {
                                String redirectUrl = p0.getRedirectUrl();
                                Intrinsics.checkNotNullExpressionValue(redirectUrl, "");
                                isLayoutRequested(redirectUrl);
                                return;
                            }
                            String redirectUrl2 = p0.getRedirectUrl();
                            Intrinsics.checkNotNullExpressionValue(redirectUrl2, "");
                            isLayoutRequested(redirectUrl2);
                            int i10 = 55 / 0;
                            return;
                        }
                        break;
                    case 1617823075:
                        if (name.equals(MyProfileMenuCategories.LOAN_PERSONAL_FEATURE)) {
                            scheduleImpl(p0);
                            return;
                        }
                        break;
                    case 1936814208:
                        if (name.equals("setting_chatbot")) {
                            String redirectUrl3 = p0.getRedirectUrl();
                            Intrinsics.checkNotNullExpressionValue(redirectUrl3, "");
                            NetworkUserEntityData$$ExternalSyntheticLambda8(getErrorConfigVersion(redirectUrl3));
                            return;
                        }
                        break;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        NetworkUserEntityData$$ExternalSyntheticLambda8(p0.getRedirectUrl());
    }

    private final void isLayoutRequested(String p0) {
        try {
            if (this.GetContactSyncConfig) {
                HomeTabFragment B2 = B();
                if ((B2 != null ? '\b' : (char) 20) != 20) {
                    try {
                        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 41;
                        C = i % 128;
                        if ((i % 2 == 0 ? '#' : (char) 14) != 14) {
                            B2.getAuthRequestContext(3, "Me Page");
                            return;
                        } else {
                            B2.getAuthRequestContext(4, "Me Page");
                            return;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                return;
            }
            this.initRecordTimeStamp = true;
            NetworkUserEntityData$$ExternalSyntheticLambda8(p0);
            int i2 = C + 119;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void getAuthRequestContext(SettingModel p0) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 105;
        C = i % 128;
        int i2 = i % 2;
        String redirectUrl = p0.getRedirectUrl();
        if (UrlUtil.getErrorConfigVersion(redirectUrl)) {
            ReadLinkPropertiesContract.Presenter t = t();
            Intrinsics.checkNotNullExpressionValue(redirectUrl, "");
            t.MyBillsEntityDataFactory(redirectUrl);
            int i3 = C + 61;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(redirectUrl);
        DanaH5.startContainerFullUrl(getAuthRequestContext(sb.toString(), "Me Page"), NetworkUserEntityData$$ExternalSyntheticLambda5());
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0019, code lost:
    
        if (r0 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0024, code lost:
    
        if (r6.isKycRevoked() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0026, code lost:
    
        c();
        r6 = id.dana.myprofile.NewMyProfileFragment.C + 113;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0033, code lost:
    
        if ((r6 % 2) == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0036, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0037, code lost:
    
        if (r1 == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0039, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003a, code lost:
    
        r6 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x003b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x003e, code lost:
    
        NetworkUserEntityData$$ExternalSyntheticLambda8(r6.getRedirectUrl());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0045, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(id.dana.domain.profilemenu.model.SettingModel r6) {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L46
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1     // Catch: java.lang.Exception -> L46
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
            if (r0 == r2) goto L20
            boolean r0 = r6.isKycRevoked()     // Catch: java.lang.Exception -> L1e
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L3e
            goto L26
        L1c:
            r6 = move-exception
            throw r6
        L1e:
            r6 = move-exception
            throw r6
        L20:
            boolean r0 = r6.isKycRevoked()
            if (r0 == 0) goto L3e
        L26:
            r5.c()
            int r6 = id.dana.myprofile.NewMyProfileFragment.C
            int r6 = r6 + 113
            int r0 = r6 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            int r6 = r6 % 2
            if (r6 == 0) goto L36
            goto L37
        L36:
            r1 = 1
        L37:
            if (r1 == 0) goto L3a
            return
        L3a:
            int r6 = r3.length     // Catch: java.lang.Throwable -> L3c
            return
        L3c:
            r6 = move-exception
            throw r6
        L3e:
            java.lang.String r6 = r6.getRedirectUrl()
            r5.NetworkUserEntityData$$ExternalSyntheticLambda8(r6)
            return
        L46:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.BuiltInFictitiousFunctionClassFactory(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8(String p0) {
        if (!(p0 != null)) {
            return;
        }
        Object obj = null;
        if (!(true ^ StringsKt.isBlank(p0))) {
            p0 = null;
        }
        if ((p0 != null ? '=' : '2') != '2') {
            try {
                if (UrlUtil.getErrorConfigVersion(p0)) {
                    int i = C + 69;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                    int i2 = i % 2;
                    try {
                        t().MyBillsEntityDataFactory(p0);
                        int i3 = C + 29;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                        if ((i3 % 2 != 0 ? '\n' : '#') != '#') {
                            obj.hashCode();
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                DanaH5.startContainerFullUrl(lookAheadTest(p0), NetworkUserEntityData$$ExternalSyntheticLambda5());
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final String lookAheadTest(String p0) {
        int i = C + 29;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        String authRequestContext = UrlUtil.getAuthRequestContext(p0);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        String NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(authRequestContext);
        UserLoanInfo PlaceComponentResult = OtpRegistrationPresenter$input$2().PlaceComponentResult(LoanInfo.LOAN_PERSONAL);
        String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, NetworkUserEntityData$$ExternalSyntheticLambda0);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        String KClassImpl$Data$declaredNonStaticMembers$22 = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        String correctedUrl = DanaH5.correctedUrl(KClassImpl$Data$declaredNonStaticMembers$22);
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 125;
        C = i3 % 128;
        if ((i3 % 2 == 0 ? 'V' : 'I') != 'I') {
            Object obj = null;
            obj.hashCode();
            return correctedUrl;
        }
        return correctedUrl;
    }

    private static String NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
        Object[] objArr = new Object[1];
        r(5 - (ViewConfiguration.getLongPressTimeout() >> 16), new int[]{-1431660199, 1229597249, -110333565, -603530570}, objArr);
        if ((StringsKt.contains$default((CharSequence) p0, (CharSequence) ((String) objArr[0]).intern(), false, 2, (Object) null) ? (char) 21 : (char) 29) != 21) {
            return p0;
        }
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 65;
        C = i % 128;
        int i2 = i % 2;
        String L = L();
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 119;
        C = i3 % 128;
        int i4 = i3 % 2;
        return L;
    }

    @JvmName(name = "L")
    private static String L() {
        int i = C + 109;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        String MyBillsEntityDataFactory2 = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}").MyBillsEntityDataFactory("entryPoint", TopupSource.PROFILE_PAGE).MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        int i3 = C + 95;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if (i3 % 2 == 0) {
            return MyBillsEntityDataFactory2;
        }
        int i4 = 61 / 0;
        return MyBillsEntityDataFactory2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x002c, code lost:
    
        if ((!kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) "entryPoint", false, 4, (java.lang.Object) null) ? 'V' : '_') != 'V') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0038, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) "entryPoint", false, 2, (java.lang.Object) null) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x003a, code lost:
    
        r6 = id.dana.utils.UrlUtil.getAuthRequestContext(id.dana.utils.UrlUtil.getAuthRequestContext(r6), r7);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "");
        r6 = id.dana.danah5.DanaH5.correctedUrl(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getAuthRequestContext(java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 39
            if (r0 == 0) goto L11
            r0 = 49
            goto L13
        L11:
            r0 = 39
        L13:
            r3 = 0
            r4 = 0
            java.lang.String r5 = "entryPoint"
            if (r0 == r2) goto L2f
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2 = 4
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r5, r4, r2, r3)
            r2 = 86
            if (r0 != 0) goto L2a
            r0 = 86
            goto L2c
        L2a:
            r0 = 95
        L2c:
            if (r0 == r2) goto L3a
            goto L4b
        L2f:
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r5, r4, r1, r3)
            if (r0 != 0) goto L4b
        L3a:
            java.lang.String r6 = id.dana.utils.UrlUtil.getAuthRequestContext(r6)
            java.lang.String r6 = id.dana.utils.UrlUtil.getAuthRequestContext(r6, r7)
            java.lang.String r7 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.String r6 = id.dana.danah5.DanaH5.correctedUrl(r6)
        L4b:
            int r7 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r7 = r7 + 89
            int r0 = r7 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r0
            int r7 = r7 % r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.getAuthRequestContext(java.lang.String, java.lang.String):java.lang.String");
    }

    private final void lookAheadTest(SettingModel p0) {
        Bundle bundle = new Bundle();
        String redirectUrl = p0.getRedirectUrl();
        Intrinsics.checkNotNullExpressionValue(redirectUrl, "");
        bundle.putString("url", getAuthRequestContext(redirectUrl, "Me Page"));
        bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
        DanaH5.startContainerActivity(bundle, NetworkUserEntityData$$ExternalSyntheticLambda5());
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 67;
            C = i % 128;
            if (!(i % 2 == 0)) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void scheduleImpl(SettingModel p0) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
        C = i % 128;
        if ((i % 2 == 0 ? (char) 30 : (char) 29) != 30) {
            PayLaterContract.Presenter OtpRegistrationPresenter$input$2 = OtpRegistrationPresenter$input$2();
            String name = p0.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            OtpRegistrationPresenter$input$2.MyBillsEntityDataFactory(name);
            l().PlaceComponentResult("loan_personal", p0.getRedirectUrl());
        } else {
            PayLaterContract.Presenter OtpRegistrationPresenter$input$22 = OtpRegistrationPresenter$input$2();
            String name2 = p0.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "");
            OtpRegistrationPresenter$input$22.MyBillsEntityDataFactory(name2);
            l().PlaceComponentResult("loan_personal", p0.getRedirectUrl());
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = C + 45;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
    }

    @JvmName(name = "J")
    private final SettingModel J() {
        SettingModel M;
        try {
            int i = C + 125;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            Object[] objArr = null;
            if (i % 2 != 0) {
                M = M();
                objArr.hashCode();
            } else {
                M = M();
            }
            int i2 = C + 1;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                int length = objArr.length;
                return M;
            }
            return M;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(SettingModel p0, String p1, String p2) {
        int i = C + 1;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        if (p0 != null) {
            try {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 85;
                try {
                    C = i3 % 128;
                    if (i3 % 2 == 0) {
                        List<SettingModel> settingChilds = p0.getSettingChilds();
                        Intrinsics.checkNotNullExpressionValue(settingChilds, "");
                        if ((settingChilds.isEmpty() | false ? ']' : 'a') == 'a') {
                            return;
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(p0.getSettingChilds(), "");
                        if ((!r0.isEmpty()) == false) {
                            return;
                        }
                    }
                    int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 23;
                    C = i4 % 128;
                    if (i4 % 2 == 0) {
                    }
                    List<SettingModel> settingChilds2 = p0.getSettingChilds();
                    Intrinsics.checkNotNullExpressionValue(settingChilds2, "");
                    Iterator<SettingModel> it = settingChilds2.iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i5 = -1;
                            break;
                        }
                        int i6 = C + 45;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i6 % 128;
                        int i7 = i6 % 2;
                        if (Intrinsics.areEqual(it.next().getName(), MyProfileMenuAction.SETTING_STATEMENT)) {
                            break;
                        }
                        i5++;
                    }
                    if (i5 >= 0) {
                        p0.getSettingChilds().get(i5).setIncome(p1);
                        p0.getSettingChilds().get(i5).setCurrency(p2);
                        p0.getSettingChilds().get(i5).setEnable(true);
                        NetworkUserEntityData$$ExternalSyntheticLambda7(MyProfileMenuCategories.PROFILE_USER_SERVICE);
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final void MyBillsEntityDataFactory(SettingModel p0, String p1, String p2) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 51;
            C = i % 128;
            int i2 = i % 2;
            if (p0 != null) {
                List<SettingModel> settingChilds = p0.getSettingChilds();
                Intrinsics.checkNotNullExpressionValue(settingChilds, "");
                if ((settingChilds.isEmpty() ^ true ? 'H' : '^') != 'H') {
                    return;
                }
                List<SettingModel> settingChilds2 = p0.getSettingChilds();
                Intrinsics.checkNotNullExpressionValue(settingChilds2, "");
                int i3 = 0;
                Iterator<SettingModel> it = settingChilds2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 47;
                    C = i4 % 128;
                    if (i4 % 2 == 0) {
                        boolean areEqual = Intrinsics.areEqual(it.next().getName(), MyProfileMenuAction.SETTING_STATEMENT);
                        Object[] objArr = null;
                        int length = objArr.length;
                        if (areEqual) {
                            break;
                        }
                        i3++;
                    } else {
                        if ((!Intrinsics.areEqual(it.next().getName(), MyProfileMenuAction.SETTING_STATEMENT) ? '%' : 'M') != '%') {
                            break;
                        }
                        i3++;
                    }
                }
                if (i3 >= 0) {
                    p0.getSettingChilds().get(i3).setExpense(p1);
                    p0.getSettingChilds().get(i3).setCurrency(p2);
                    p0.getSettingChilds().get(i3).setEnable(true);
                    NetworkUserEntityData$$ExternalSyntheticLambda7(MyProfileMenuCategories.PROFILE_USER_SERVICE);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final DanaH5Listener NetworkUserEntityData$$ExternalSyntheticLambda5() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.myprofile.NewMyProfileFragment$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                NewMyProfileFragment.MyBillsEntityDataFactory(NewMyProfileFragment.this);
                NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(NewMyProfileFragment.this);
                NewMyProfileFragment.lookAheadTest(NewMyProfileFragment.this);
                NewMyProfileFragment.GetContactSyncConfig(NewMyProfileFragment.this);
                if (!NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(NewMyProfileFragment.this)) {
                    FragmentActivity activity = NewMyProfileFragment.this.getActivity();
                    FileUtil.getAuthRequestContext(new File(activity != null ? activity.getCacheDir() : null, "/upload_file/"));
                    NewMyProfileFragment.SubSequence(NewMyProfileFragment.this);
                }
                NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(NewMyProfileFragment.this);
                NewMyProfileFragment.isLayoutRequested(NewMyProfileFragment.this);
            }
        };
        int i = C + 115;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        return danaH5Listener;
    }

    private final DanaH5Listener NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.myprofile.NewMyProfileFragment$createProfileCompletionH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                NewMyProfileFragment.initRecordTimeStamp(NewMyProfileFragment.this);
            }
        };
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
        C = i % 128;
        if (i % 2 != 0) {
            return danaH5Listener;
        }
        Object obj = null;
        obj.hashCode();
        return danaH5Listener;
    }

    private final void b() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(m().getKycFromProfileUrl());
        NetworkUserEntityData$$ExternalSyntheticLambda8(sb.toString());
        int i = C + 77;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private final void c() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 45;
        C = i % 128;
        int i2 = i % 2;
        try {
            NetworkUserEntityData$$ExternalSyntheticLambda8("https://m.dana.id/m/kyb?entryPoint=profile");
            int i3 = C + 125;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmName(name = "Y")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean Y() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L4f
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1     // Catch: java.lang.Exception -> L4f
            int r0 = r0 % 2
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r5.newProxyInstance     // Catch: java.lang.Exception -> L4d
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L12
            r3 = 0
            goto L13
        L12:
            r3 = 1
        L13:
            if (r3 == r2) goto L4c
            r3 = 56
            if (r0 == 0) goto L1b
            r4 = 1
            goto L1d
        L1b:
            r4 = 56
        L1d:
            if (r4 == r3) goto L3d
            int r0 = r0.getItemViewType(r1)
            r3 = 20
            r4 = 34
            if (r0 != r3) goto L2c
            r0 = 34
            goto L2e
        L2c:
            r0 = 47
        L2e:
            if (r0 == r4) goto L31
            goto L3d
        L31:
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 111
            int r3 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r0 = r0 % 2
            r0 = 1
            goto L48
        L3d:
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 117
            int r3 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r0 = r0 % 2
            r0 = 0
        L48:
            if (r0 != 0) goto L4b
            goto L4c
        L4b:
            r1 = 1
        L4c:
            return r1
        L4d:
            r0 = move-exception
            throw r0
        L4f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.Y():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00fb, code lost:
    
        r1 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00fc, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ff, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 77;
        id.dana.myprofile.NewMyProfileFragment.C = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0109, code lost:
    
        if ((r0 % 2) != 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x010b, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x010d, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x010e, code lost:
    
        if (r0 == true) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0110, code lost:
    
        r7 = 16 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0111, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0114, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0015, code lost:
    
        if (r0 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0029, code lost:
    
        if ((r0 != null ? 'R' : 28) != 'R') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x002c, code lost:
    
        r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0030, code lost:
    
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0032, code lost:
    
        r4 = ']';
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0035, code lost:
    
        r4 = 'J';
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0037, code lost:
    
        if (r4 == 'J') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0039, code lost:
    
        r0 = r0.findViewHolderForLayoutPosition(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x003e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x003f, code lost:
    
        if (r0 != null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0041, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 29;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x004c, code lost:
    
        r5 = r0.itemView.findViewById(id.dana.R.id.vg_profile_completion_container);
        r3 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0059, code lost:
    
        if (r5 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x005b, code lost:
    
        r4 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x005e, code lost:
    
        r4 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0063, code lost:
    
        if (r4 == 'Q') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0065, code lost:
    
        r0 = androidx.core.content.res.ResourcesCompat.BuiltInFictitiousFunctionClassFactory(requireContext().getResources(), id.dana.R.drawable.red_dot, null);
        r4 = getString(id.dana.R.string.lbl_profile_completion_tooltip_message);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        r4 = r4;
        r8 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r4, '*', 0, false, 6, (java.lang.Object) null);
        r9 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r4, ')', 0, false, 6, (java.lang.Object) null);
        r12 = new android.text.SpannableString(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x009b, code lost:
    
        if (r0 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x009d, code lost:
    
        r0.setBounds(0, 0, 16, 16);
        r12.setSpan(new android.text.style.ImageSpan(r0, 1), r8, r9, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00aa, code lost:
    
        r0 = new id.dana.showcase.target.TargetBuilder(getActivity()).BuiltInFictitiousFunctionClassFactory(r5);
        r7 = id.dana.myprofile.NewMyProfileFragment.MyBillsEntityDataFactory;
        r11 = id.dana.myprofile.NewMyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        r0 = r0.BuiltInFictitiousFunctionClassFactory(new id.dana.showcase.shape.RectangleShape(r5, r7, r7, r11, r11, r11, r11)).getAuthRequestContext(new id.dana.showcase.Content(getString(id.dana.R.string.lbl_profile_completion_tooltip_title), r12)).KClassImpl$Data$declaredNonStaticMembers$2();
        r1 = id.dana.myprofile.NewMyProfileFragment.C + 85;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00f4, code lost:
    
        if ((r1 % 2) == 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00f6, code lost:
    
        r3 = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f8, code lost:
    
        if (r3 == 24) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00fa, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.showcase.target.Target FragmentBottomSheetPaymentSettingBinding() {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.FragmentBottomSheetPaymentSettingBinding():id.dana.showcase.target.Target");
    }

    private final void MyBillsEntityDataFactory(Target p0) {
        HomeTabFragment B2;
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 41;
        C = i % 128;
        if (i % 2 == 0) {
            B2 = B();
            int i2 = 43 / 0;
            if ((p0 != null ? '\r' : 'M') != '\r') {
                return;
            }
        } else {
            B2 = B();
            if (p0 == null) {
                return;
            }
        }
        if (this.getCallingPid == null) {
            if ((B2 != null ? '\b' : (char) 28) == '\b' && B2.DatabaseTableConfigUtil()) {
                SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(getBaseActivity());
                simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
                this.getCallingPid = simpleShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(SizeUtil.getAuthRequestContext(16)).BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(getString(R.string.btn_got_it_tooltip)).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.myprofile.NewMyProfileFragment$showProfileCompletionTooltip$1
                    @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                    public final void onFinished(int p02) {
                        NewMyProfileFragment.readMicros(NewMyProfileFragment.this);
                        NewMyProfileFragment.getCallingPid(NewMyProfileFragment.this);
                        NewMyProfileFragment.this.getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda6();
                    }
                }).PlaceComponentResult();
                int i3 = C + 23;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0022, code lost:
    
        if ((r0 instanceof id.dana.myprofile.MyProfileMainFragment ? 'F' : 24) != 24) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x002e, code lost:
    
        if (r3 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0032, code lost:
    
        r3 = id.dana.myprofile.NewMyProfileFragment.C + 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0036, code lost:
    
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x003a, code lost:
    
        r0 = (id.dana.myprofile.MyProfileMainFragment) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x003d, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x003e, code lost:
    
        if (r0 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0040, code lost:
    
        r3 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 41;
        id.dana.myprofile.NewMyProfileFragment.C = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x004a, code lost:
    
        if ((r3 % 2) != 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x004c, code lost:
    
        r0 = r0.getParentFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0052, code lost:
    
        r3 = 95 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0056, code lost:
    
        r0 = r0.getParentFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x005b, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x005e, code lost:
    
        if ((r0 instanceof id.dana.animation.tab.HomeTabFragment) == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0060, code lost:
    
        r2 = (id.dana.animation.tab.HomeTabFragment) r0;
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 35;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x006d, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.animation.tab.HomeTabFragment B() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 33
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            r2 = 0
            if (r0 == 0) goto L25
            androidx.fragment.app.Fragment r0 = r5.getParentFragment()
            boolean r3 = r0 instanceof id.dana.myprofile.MyProfileMainFragment
            r4 = 24
            if (r3 == 0) goto L20
            r3 = 70
            goto L22
        L20:
            r3 = 24
        L22:
            if (r3 == r4) goto L3d
            goto L30
        L25:
            androidx.fragment.app.Fragment r0 = r5.getParentFragment()     // Catch: java.lang.Exception -> L72
            boolean r3 = r0 instanceof id.dana.myprofile.MyProfileMainFragment     // Catch: java.lang.Exception -> L70
            r2.hashCode()     // Catch: java.lang.Throwable -> L6e
            if (r3 == 0) goto L3d
        L30:
            int r3 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L70
            int r3 = r3 + 15
            int r4 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r4     // Catch: java.lang.Exception -> L70
            int r3 = r3 % 2
            id.dana.myprofile.MyProfileMainFragment r0 = (id.dana.myprofile.MyProfileMainFragment) r0
            goto L3e
        L3d:
            r0 = r2
        L3e:
            if (r0 == 0) goto L5b
            int r3 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r3 = r3 + 41
            int r4 = r3 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L56
            androidx.fragment.app.Fragment r0 = r0.getParentFragment()
            r3 = 95
            int r3 = r3 / r1
            goto L5c
        L54:
            r0 = move-exception
            throw r0
        L56:
            androidx.fragment.app.Fragment r0 = r0.getParentFragment()
            goto L5c
        L5b:
            r0 = r2
        L5c:
            boolean r1 = r0 instanceof id.dana.animation.tab.HomeTabFragment
            if (r1 == 0) goto L6d
            r2 = r0
            id.dana.home.tab.HomeTabFragment r2 = (id.dana.animation.tab.HomeTabFragment) r2
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
        L6d:
            return r2
        L6e:
            r0 = move-exception
            throw r0
        L70:
            r0 = move-exception
            throw r0
        L72:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.B():id.dana.home.tab.HomeTabFragment");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0049, code lost:
    
        if (r0 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0052, code lost:
    
        if (r0 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0054, code lost:
    
        r0.setProfilePictureClickListener(new id.dana.myprofile.NewMyProfileFragment$initProfileHeaderView$2(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void T() {
        /*
            r3 = this;
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.NewFragmentMyprofileBinding r0 = (id.dana.databinding.NewFragmentMyprofileBinding) r0
            r1 = 35
            if (r0 == 0) goto Ld
            r2 = 35
            goto Lf
        Ld:
            r2 = 56
        Lf:
            if (r2 == r1) goto L12
            goto L2a
        L12:
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            int r1 = r1 + 49
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2
            int r1 = r1 % 2
            id.dana.richview.NewSimpleProfileWithQrView r0 = r0.scheduleImpl
            if (r0 == 0) goto L2a
            id.dana.myprofile.NewMyProfileFragment$initProfileHeaderView$1 r1 = new id.dana.myprofile.NewMyProfileFragment$initProfileHeaderView$1
            r1.<init>()
            id.dana.richview.NewSimpleProfileWithQrView$OnQrCodeClickedListener r1 = (id.dana.richview.NewSimpleProfileWithQrView.OnQrCodeClickedListener) r1
            r0.setQrImageClickListener(r1)
        L2a:
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()     // Catch: java.lang.Exception -> L6e
            id.dana.databinding.NewFragmentMyprofileBinding r0 = (id.dana.databinding.NewFragmentMyprofileBinding) r0     // Catch: java.lang.Exception -> L6e
            if (r0 == 0) goto L63
            int r1 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L61
            int r1 = r1 + 69
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2     // Catch: java.lang.Exception -> L61
            int r1 = r1 % 2
            r2 = 79
            if (r1 == 0) goto L43
            r1 = 79
            goto L45
        L43:
            r1 = 58
        L45:
            if (r1 == r2) goto L4c
            id.dana.richview.NewSimpleProfileWithQrView r0 = r0.scheduleImpl
            if (r0 == 0) goto L63
            goto L54
        L4c:
            id.dana.richview.NewSimpleProfileWithQrView r0 = r0.scheduleImpl
            r1 = 47
            int r1 = r1 / 0
            if (r0 == 0) goto L63
        L54:
            id.dana.myprofile.NewMyProfileFragment$initProfileHeaderView$2 r1 = new id.dana.myprofile.NewMyProfileFragment$initProfileHeaderView$2
            r1.<init>()
            id.dana.richview.NewSimpleProfileWithQrView$OnProfilePictureClickListener r1 = (id.dana.richview.NewSimpleProfileWithQrView.OnProfilePictureClickListener) r1
            r0.setProfilePictureClickListener(r1)
            goto L63
        L5f:
            r0 = move-exception
            throw r0
        L61:
            r0 = move-exception
            throw r0
        L63:
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            return
        L6e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.T():void");
    }

    private final void V() {
        int i;
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 67;
        C = i2 % 128;
        int i3 = i2 % 2;
        View findViewById = requireView().findViewById(R.id.include_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        if ((this.getErrorConfigVersion ^ true ? 'K' : '?') != '?') {
            int i4 = C + 93;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
            if (i4 % 2 != 0) {
            }
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = findViewById;
    }

    private final void SummaryVoucherView$$ExternalSyntheticLambda1() {
        String[] strArr;
        if (!(!OSUtil.MyBillsEntityDataFactory())) {
            int i = C + 35;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if ((i % 2 != 0 ? '7' : 'C') != 'C') {
                strArr = new String[1];
                strArr[1] = "android.permission.CAMERA";
            } else {
                strArr = new String[]{"android.permission.CAMERA"};
            }
        } else {
            try {
                strArr = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
            } catch (Exception e) {
                throw e;
            }
        }
        NewMyProfileFragment newMyProfileFragment = this;
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(newMyProfileFragment);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.myprofile.NewMyProfileFragment$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    NewMyProfileFragment.scheduleImpl(NewMyProfileFragment.this).getAuthRequestContext();
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.getAuthRequestContext = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(newMyProfileFragment);
        String[] strArr3 = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr3, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr3);
        PermissionCallback permissionCallback2 = new PermissionCallback() { // from class: id.dana.myprofile.NewMyProfileFragment$initPermission$2
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                boolean MyBillsEntityDataFactory2 = p0.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory2) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(NewMyProfileFragment.this.getBaseActivity(), "1500445", MyBillsEntityDataFactory2);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback2, "");
        builder2.BuiltInFictitiousFunctionClassFactory = permissionCallback2;
        this.PrepareContext = builder2.PlaceComponentResult();
        int i2 = C + 107;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0013, code lost:
    
        if (r3.NetworkUserEntityData$$ExternalSyntheticLambda1 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x001a, code lost:
    
        if (r0 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x001c, code lost:
    
        r0 = new android.content.Intent(getBaseActivity(), id.dana.myprofile.ProfileQrisDialogActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x002a, code lost:
    
        r0 = new android.content.Intent(getBaseActivity(), id.dana.myprofile.ShareQrDialog.class);
        r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
        id.dana.myprofile.NewMyProfileFragment.C = r1 % 128;
        r1 = r1 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void isAuto() {
        /*
            r3 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            if (r0 == 0) goto L16
            boolean r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            if (r0 == 0) goto L2a
            goto L1c
        L16:
            boolean r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L2a
        L1c:
            android.content.Intent r0 = new android.content.Intent
            id.dana.base.BaseActivity r1 = r3.getBaseActivity()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<id.dana.myprofile.ProfileQrisDialogActivity> r2 = id.dana.myprofile.ProfileQrisDialogActivity.class
            r0.<init>(r1, r2)
            goto L41
        L2a:
            android.content.Intent r0 = new android.content.Intent
            id.dana.base.BaseActivity r1 = r3.getBaseActivity()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<id.dana.myprofile.ShareQrDialog> r2 = id.dana.myprofile.ShareQrDialog.class
            r0.<init>(r1, r2)
            int r1 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1
            int r1 = r1 + 15
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r2
            int r1 = r1 % 2
        L41:
            id.dana.myprofile.MyProfileContract$Presenter r1 = r3.getErrorConfigVersion()
            java.lang.String r1 = r1.NetworkUserEntityData$$ExternalSyntheticLambda2()
            java.lang.String r2 = "USER_ID"
            r0.putExtra(r2, r1)
            java.lang.String r1 = r3.NetworkUserEntityData$$ExternalSyntheticLambda4
            java.lang.String r2 = "QR_CODE"
            r0.putExtra(r2, r1)
            id.dana.myprofile.MyProfileContract$Presenter r1 = r3.getErrorConfigVersion()
            java.lang.String r1 = r1.getFragmentBottomSheetPaymentSettingBinding()
            java.lang.String r2 = "KYC_STATUS"
            r0.putExtra(r2, r1)
            id.dana.myprofile.MyProfileContract$Presenter r1 = r3.getErrorConfigVersion()
            java.lang.String r1 = r1.getErrorConfigVersion()
            java.lang.String r2 = "AVATAR_URI"
            r0.putExtra(r2, r1)
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r0.setFlags(r1)
            r3.startActivity(r0)
            return
        L78:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.isAuto():void");
    }

    private final void flip() {
        startActivity(new Intent(getBaseActivity(), ChangeUsernameActivity.class));
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 117;
        C = i % 128;
        int i2 = i % 2;
    }

    private final SettingModel M() {
        SettingModel settingModel;
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
        C = i % 128;
        int i2 = i % 2;
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
        Intrinsics.checkNotNull(myProfileDiffutilAdapter);
        int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyProfileMenuCategories.PROFILE_USER_SERVICE);
        if ((myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyBillsEntityDataFactory2) ? '1' : 'Y') != 'Y') {
            try {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 67;
                try {
                    C = i3 % 128;
                    if (i3 % 2 != 0) {
                        settingModel = myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue.get(MyBillsEntityDataFactory2);
                    } else {
                        settingModel = myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue.get(MyBillsEntityDataFactory2);
                        int i4 = 80 / 0;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            settingModel = SettingModel.empty();
        }
        Intrinsics.checkNotNullExpressionValue(settingModel, "");
        return settingModel;
    }

    private static String NetworkUserEntityData$$ExternalSyntheticLambda3(String p0) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 79;
        C = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            boolean areEqual = Intrinsics.areEqual(p0, "0 Cards");
            objArr.hashCode();
            if (!areEqual) {
                return p0;
            }
        } else {
            if (!Intrinsics.areEqual(p0, "0 Cards")) {
                return p0;
            }
        }
        int i2 = C + 79;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        if ((i2 % 2 != 0 ? '\'' : '.') != '.') {
            int length = objArr.length;
        }
        return "0 Card";
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(ConsultFamilyAccountResult p0) {
        SettingModel next;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        if (this.newProxyInstance != null) {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 77;
            C = i % 128;
            int i2 = i % 2;
            if (p0 != null) {
                SettingModel M = M();
                if (M.isNullObject()) {
                    return;
                }
                Iterator<SettingModel> it = M.getSettingChilds().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 113;
                    C = i3 % 128;
                    if (i3 % 2 == 0) {
                        try {
                            try {
                                next = it.next();
                                boolean areEqual = Intrinsics.areEqual(next.getName(), "setting_family_account");
                                Object obj = null;
                                obj.hashCode();
                                if (areEqual) {
                                    MyProfileContract.Presenter errorConfigVersion = getErrorConfigVersion();
                                    Intrinsics.checkNotNullExpressionValue(next, "");
                                    errorConfigVersion.PlaceComponentResult(next, p0, true);
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(next.getName(), "setting_family_account")) {
                            MyProfileContract.Presenter errorConfigVersion2 = getErrorConfigVersion();
                            Intrinsics.checkNotNullExpressionValue(next, "");
                            errorConfigVersion2.PlaceComponentResult(next, p0, true);
                        }
                    }
                }
                NetworkUserEntityData$$ExternalSyntheticLambda7(MyProfileMenuCategories.PROFILE_USER_SERVICE);
            }
        }
        int i4 = C + 107;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
        int i5 = i4 % 2;
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 17;
            C = i % 128;
            int i2 = i % 2;
            List<SettingModel> settingChilds = M().getSettingChilds();
            Intrinsics.checkNotNullExpressionValue(settingChilds, "");
            Iterator<T> it = settingChilds.iterator();
            while (true) {
                if (!(it.hasNext())) {
                    NetworkUserEntityData$$ExternalSyntheticLambda7(MyProfileMenuCategories.PROFILE_USER_SERVICE);
                    return;
                }
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 39;
                C = i3 % 128;
                if ((i3 % 2 == 0 ? 'K' : 'B') != 'B') {
                    ((SettingModel) it.next()).setShowShimmer(p0);
                    Object obj = null;
                    obj.hashCode();
                } else {
                    try {
                        ((SettingModel) it.next()).setShowShimmer(p0);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void newProxyInstance() {
        try {
            int i = C + 3;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if ((i % 2 != 0 ? 'T' : 'L') != 'L') {
                int i2 = 4 / 0;
                if ((this.initRecordTimeStamp ? '.' : (char) 23) == 23) {
                    return;
                }
            } else {
                if ((this.initRecordTimeStamp ? '9' : 'N') == 'N') {
                    return;
                }
            }
            this.initRecordTimeStamp = false;
            q().BuiltInFictitiousFunctionClassFactory(false);
            int i3 = C + 53;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e() {
        Iterator it;
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 125;
            C = i % 128;
            Object[] objArr = 0;
            if (i % 2 == 0) {
                MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
                int length = objArr.length;
                if (!(myProfileDiffutilAdapter != null)) {
                    return;
                }
            } else if (this.newProxyInstance == null) {
                return;
            }
            SettingModel scheduleImpl = scheduleImpl(MyProfileMenuCategories.PROFILE_REWARDS);
            if ((scheduleImpl != null ? 'M' : (char) 20) != 'M') {
                return;
            }
            if (scheduleImpl.isNullObject()) {
                return;
            }
            int i2 = C + 109;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            if (i2 % 2 != 0) {
                List<SettingModel> settingChilds = scheduleImpl.getSettingChilds();
                Intrinsics.checkNotNullExpressionValue(settingChilds, "");
                it = settingChilds.iterator();
                objArr.hashCode();
            } else {
                List<SettingModel> settingChilds2 = scheduleImpl.getSettingChilds();
                Intrinsics.checkNotNullExpressionValue(settingChilds2, "");
                it = settingChilds2.iterator();
            }
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((SettingModel) next).getName(), "setting_referral")) {
                    objArr = next;
                    break;
                }
            }
            SettingModel settingModel = (SettingModel) objArr;
            if (settingModel != null) {
                settingModel.setStartReferralLottie(false);
            }
            NetworkUserEntityData$$ExternalSyntheticLambda7(MyProfileMenuCategories.PROFILE_REWARDS);
        } catch (Exception e) {
            throw e;
        }
    }

    private final void FlowViewUtil$textChanges$1() {
        try {
            int i = C + 117;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            NetworkUserEntityData$$ExternalSyntheticLambda6(MyProfileMenuCategories.PROFILE_APP_SETTINGS);
            NetworkUserEntityData$$ExternalSyntheticLambda6(MyProfileMenuCategories.PROFILE_GENERAL_INFO);
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 63;
            C = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 5 : 'O') != 5) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda6(String p0) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 11;
        C = i % 128;
        if (!(i % 2 == 0)) {
            try {
                if ((this.newProxyInstance != null ? (char) 31 : ';') != 31) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
            Object obj = null;
            obj.hashCode();
            if ((myProfileDiffutilAdapter != null ? 'V' : '\r') != 'V') {
                return;
            }
        }
        SettingModel scheduleImpl = scheduleImpl(p0);
        if (scheduleImpl == null || scheduleImpl.isNullObject()) {
            return;
        }
        Iterator<SettingModel> it = scheduleImpl.getSettingChilds().iterator();
        while (true) {
            if ((it.hasNext() ? 'V' : 'B') != 'B') {
                int i2 = C + 69;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
                int i3 = i2 % 2;
                SettingModel next = it.next();
                if ((Intrinsics.areEqual(next.getName(), "setting_new_smartpay") ? '7' : ']') != ']') {
                    next.setShowNewBadge(this.getOnBoardingScenario.getShouldShowSmartPayFlag());
                    try {
                        int i4 = C + 109;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
                        int i5 = i4 % 2;
                    } catch (Exception e2) {
                        throw e2;
                    }
                } else if (Intrinsics.areEqual(next.getName(), "setting_resolution_center")) {
                    next.setShowNewBadge(this.getOnBoardingScenario.getShouldShowResolutionCenterFlag());
                }
            } else {
                NetworkUserEntityData$$ExternalSyntheticLambda7(p0);
                return;
            }
        }
    }

    private final void W() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 111;
        C = i % 128;
        int i2 = i % 2;
        NewFragmentMyprofileBinding newFragmentMyprofileBinding = (NewFragmentMyprofileBinding) getBinding();
        if ((newFragmentMyprofileBinding != null ? (char) 16 : Typography.less) != '<') {
            PtrClassicFrameLayout ptrClassicFrameLayout = newFragmentMyprofileBinding.getErrorConfigVersion;
            if ((ptrClassicFrameLayout != null ? JSONLexer.EOI : 'D') != 'D') {
                ptrClassicFrameLayout.setPtrHandler(getOnBoardingScenario());
                ptrClassicFrameLayout.addPtrUIHandler(I());
                ptrClassicFrameLayout.disableWhenHorizontalMove(true);
                try {
                    int i3 = C + 87;
                    try {
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                        int i4 = i3 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        U();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.myprofile.NewMyProfileFragment$getPtrHandler$1] */
    private final NewMyProfileFragment$getPtrHandler$1 getOnBoardingScenario() {
        ?? r0 = new PtrHandler() { // from class: id.dana.myprofile.NewMyProfileFragment$getPtrHandler$1
            @Override // in.srain.cube.views.ptr.PtrHandler
            public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                return true;
            }

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final void onRefreshBegin(PtrFrameLayout p0) {
                if (NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(NewMyProfileFragment.this)) {
                    LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda1 = NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(NewMyProfileFragment.this);
                    if (NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda1.playAnimation();
                }
                NewMyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda6(NewMyProfileFragment.this);
            }
        };
        int i = C + 59;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            return r0;
        }
        Object obj = null;
        obj.hashCode();
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.myprofile.NewMyProfileFragment$getPtrUiHandler$1] */
    private final NewMyProfileFragment$getPtrUiHandler$1 I() {
        ?? r0 = new PtrUIHandler() { // from class: id.dana.myprofile.NewMyProfileFragment$getPtrUiHandler$1
            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIPositionChange(PtrFrameLayout p0, boolean p1, byte p2, PtrIndicator p3) {
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIRefreshBegin(PtrFrameLayout p0) {
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIRefreshComplete(PtrFrameLayout p0) {
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIReset(PtrFrameLayout p0) {
                MyProfileMainFragment myProfileMainFragment;
                if (!(NewMyProfileFragment.this.getParentFragment() instanceof MyProfileMainFragment) || (myProfileMainFragment = (MyProfileMainFragment) NewMyProfileFragment.this.getParentFragment()) == null) {
                    return;
                }
                FragmentMyprofileMainBinding binding = myProfileMainFragment.getBinding();
                ViewPager2 viewPager2 = binding != null ? binding.MyBillsEntityDataFactory : null;
                if (viewPager2 != null) {
                    viewPager2.setUserInputEnabled(true);
                }
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIRefreshPrepare(PtrFrameLayout p0) {
                MyProfileMainFragment myProfileMainFragment;
                if (!(NewMyProfileFragment.this.getParentFragment() instanceof MyProfileMainFragment) || (myProfileMainFragment = (MyProfileMainFragment) NewMyProfileFragment.this.getParentFragment()) == null) {
                    return;
                }
                FragmentMyprofileMainBinding binding = myProfileMainFragment.getBinding();
                ViewPager2 viewPager2 = binding != null ? binding.MyBillsEntityDataFactory : null;
                if (viewPager2 != null) {
                    viewPager2.setUserInputEnabled(false);
                }
            }
        };
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 21;
            C = i % 128;
            if ((i % 2 == 0 ? ')' : 'X') != 'X') {
                int i2 = 44 / 0;
                return r0;
            }
            return r0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void U() {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.U():void");
    }

    private final void FlowViewUtil$textChanges$2() {
        int i = C + 5;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 != 0) {
            try {
                this.VerifyPinStateManager$executeRiskChallenge$2$1 = true;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = true;
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 109;
        C = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void f() {
        int i = C + 43;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 != 0 ? '`' : '?') != '`') {
            SubSequence();
            H();
            A();
            BottomSheetCardBindingView$watcherCardNumberView$1();
            D();
            TypeProjectionImpl();
            O();
            Q();
            return;
        }
        SubSequence();
        H();
        A();
        BottomSheetCardBindingView$watcherCardNumberView$1();
        D();
        TypeProjectionImpl();
        O();
        Q();
        Object obj = null;
        obj.hashCode();
    }

    private final boolean shouldRecycleViewType() {
        boolean z = false;
        if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null)) {
            try {
                int i = C + 55;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                if (i % 2 == 0) {
                }
                z = true;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = C + 83;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        if (i2 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return z;
        }
        return z;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\t"}, d2 = {"Lid/dana/myprofile/NewMyProfileFragment$Companion;", "", "", "p0", "Lid/dana/myprofile/NewMyProfileFragment;", "getAuthRequestContext", "(Z)Lid/dana/myprofile/NewMyProfileFragment;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "PlaceComponentResult", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static NewMyProfileFragment getAuthRequestContext(boolean p0) {
            NewMyProfileFragment newMyProfileFragment = new NewMyProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_KYB_REVAMP", p0);
            newMyProfileFragment.setArguments(bundle);
            return newMyProfileFragment;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        scheduleImpl();
        ?? r1 = 0;
        INSTANCE = new Companion(r1);
        MyBillsEntityDataFactory = SizeUtil.getAuthRequestContext(6);
        KClassImpl$Data$declaredNonStaticMembers$2 = SizeUtil.getAuthRequestContext(0);
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 59;
        C = i % 128;
        if (i % 2 != 0) {
            return;
        }
        int length = r1.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0049, code lost:
    
        if (r7.hasNext() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x004b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x004d, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x004e, code lost:
    
        if (r1 == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0050, code lost:
    
        r1 = (id.dana.referral.referraltracker.model.ReferralSummaryDTOModel) r7.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x005c, code lost:
    
        if (r1.PlaceComponentResult.getAuthRequestContext() != false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0064, code lost:
    
        if (r1.lookAheadTest.getAuthRequestContext() != false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0066, code lost:
    
        r4 = id.dana.myprofile.NewMyProfileFragment.C + 69;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0076, code lost:
    
        if (r1.getErrorConfigVersion.getAuthRequestContext() != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0078, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x007a, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x007b, code lost:
    
        if (r1 == true) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x007d, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x007f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0082, code lost:
    
        if (r1 == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0084, code lost:
    
        r1 = 'Z';
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0087, code lost:
    
        r1 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0089, code lost:
    
        if (r1 == 'X') goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x008b, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x008d, code lost:
    
        if (r0 >= 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x008f, code lost:
    
        r1 = id.dana.myprofile.NewMyProfileFragment.C + 47;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0099, code lost:
    
        if ((r1 % 2) == 0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x009b, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x009d, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x009e, code lost:
    
        if (r1 == true) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00a0, code lost:
    
        kotlin.collections.CollectionsKt.throwCountOverflow();
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00a4, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00aa, code lost:
    
        kotlin.collections.CollectionsKt.throwCountOverflow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00ae, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00af, code lost:
    
        MyBillsEntityDataFactory(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00b2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0022, code lost:
    
        if ((r7 instanceof java.util.Collection) != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0034, code lost:
    
        if ((r7 instanceof java.util.Collection) != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x003d, code lost:
    
        if (r7.isEmpty() != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x003f, code lost:
    
        r7 = r7.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0043, code lost:
    
        r0 = 0;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(id.dana.referral.referraltracker.model.ReferralTrackerModel r7) {
        /*
            r6 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> Lb4
            int r0 = r0 + 95
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.C = r1     // Catch: java.lang.Exception -> Lb4
            int r0 = r0 % 2
            r1 = 7
            if (r0 != 0) goto Lf
            r0 = 7
            goto L11
        Lf:
            r0 = 8
        L11:
            java.lang.String r2 = ""
            r3 = 0
            if (r0 == r1) goto L28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)     // Catch: java.lang.Exception -> L25
            java.util.List<id.dana.referral.referraltracker.model.ReferralSummaryDTOModel> r7 = r7.getAuthRequestContext     // Catch: java.lang.Exception -> L25
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch: java.lang.Exception -> L25
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Exception -> L25
            boolean r0 = r7 instanceof java.util.Collection     // Catch: java.lang.Exception -> L25
            if (r0 == 0) goto L3f
            goto L36
        L25:
            r7 = move-exception
            goto Lb3
        L28:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.util.List<id.dana.referral.referraltracker.model.ReferralSummaryDTOModel> r7 = r7.getAuthRequestContext
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r0 = r7 instanceof java.util.Collection
            if (r0 == 0) goto L3f
        L36:
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Laf
        L3f:
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Exception -> Lb4
            r0 = 0
        L44:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> L25
            r2 = 1
            if (r1 == 0) goto L4d
            r1 = 1
            goto L4e
        L4d:
            r1 = 0
        L4e:
            if (r1 == 0) goto Lae
            java.lang.Object r1 = r7.next()
            id.dana.referral.referraltracker.model.ReferralSummaryDTOModel r1 = (id.dana.referral.referraltracker.model.ReferralSummaryDTOModel) r1
            id.dana.referral.referraltracker.ReferralTaskStatus r4 = r1.PlaceComponentResult
            boolean r4 = r4.getAuthRequestContext()
            if (r4 != 0) goto L7f
            id.dana.referral.referraltracker.ReferralTaskStatus r4 = r1.lookAheadTest
            boolean r4 = r4.getAuthRequestContext()
            if (r4 != 0) goto L7f
            int r4 = id.dana.myprofile.NewMyProfileFragment.C
            int r4 = r4 + 69
            int r5 = r4 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r5
            int r4 = r4 % 2
            id.dana.referral.referraltracker.ReferralTaskStatus r1 = r1.getErrorConfigVersion
            boolean r1 = r1.getAuthRequestContext()
            if (r1 != 0) goto L7a
            r1 = 0
            goto L7b
        L7a:
            r1 = 1
        L7b:
            if (r1 == r2) goto L7f
            r1 = 0
            goto L80
        L7f:
            r1 = 1
        L80:
            r4 = 88
            if (r1 == 0) goto L87
            r1 = 90
            goto L89
        L87:
            r1 = 88
        L89:
            if (r1 == r4) goto L44
            int r0 = r0 + 1
            if (r0 >= 0) goto L44
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            int r1 = r1 + 47
            int r4 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r4
            int r1 = r1 % 2
            if (r1 == 0) goto L9d
            r1 = 0
            goto L9e
        L9d:
            r1 = 1
        L9e:
            if (r1 == r2) goto Laa
            kotlin.collections.CollectionsKt.throwCountOverflow()
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> La8
            goto L44
        La8:
            r7 = move-exception
            throw r7
        Laa:
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L44
        Lae:
            r3 = r0
        Laf:
            r6.MyBillsEntityDataFactory(r3)
            return
        Lb3:
            throw r7
        Lb4:
            r7 = move-exception
            goto Lb7
        Lb6:
            throw r7
        Lb7:
            goto Lb6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.getAuthRequestContext(id.dana.referral.referraltracker.model.ReferralTrackerModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0038, code lost:
    
        if ((r0.MyBillsEntityDataFactory(r5)) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0046, code lost:
    
        if (r0.MyBillsEntityDataFactory(r5) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0048, code lost:
    
        r5 = r0.getAuthRequestContext.moveToNextValue.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0052, code lost:
    
        r0 = id.dana.myprofile.NewMyProfileFragment.C + 113;
        id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x005d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005e, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0063, code lost:
    
        return id.dana.domain.profilemenu.model.SettingModel.empty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.domain.profilemenu.model.SettingModel scheduleImpl(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.NewMyProfileFragment.C     // Catch: java.lang.Exception -> L66
            int r0 = r0 + 45
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r4.newProxyInstance
            r1 = 26
            if (r0 == 0) goto L13
            r2 = 26
            goto L15
        L13:
            r2 = 78
        L15:
            if (r2 == r1) goto L19
            r5 = 0
            goto L63
        L19:
            int r1 = id.dana.myprofile.NewMyProfileFragment.C
            int r1 = r1 + 121
            int r2 = r1 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r2
            int r1 = r1 % 2
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L29
            r1 = 0
            goto L2a
        L29:
            r1 = 1
        L2a:
            if (r1 == 0) goto L3b
            int r5 = r0.MyBillsEntityDataFactory(r5)
            boolean r1 = r0.MyBillsEntityDataFactory(r5)
            if (r1 == 0) goto L37
            goto L38
        L37:
            r2 = 0
        L38:
            if (r2 == 0) goto L5f
            goto L48
        L3b:
            int r5 = r0.MyBillsEntityDataFactory(r5)
            boolean r1 = r0.MyBillsEntityDataFactory(r5)
            r2 = 9
            int r2 = r2 / r3
            if (r1 == 0) goto L5f
        L48:
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r0 = r0.getAuthRequestContext     // Catch: java.lang.Exception -> L5d
            java.util.List<T> r0 = r0.moveToNextValue     // Catch: java.lang.Exception -> L5d
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Exception -> L5d
            id.dana.domain.profilemenu.model.SettingModel r5 = (id.dana.domain.profilemenu.model.SettingModel) r5     // Catch: java.lang.Exception -> L5d
            int r0 = id.dana.myprofile.NewMyProfileFragment.C
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.myprofile.NewMyProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            goto L63
        L5d:
            r5 = move-exception
            throw r5
        L5f:
            id.dana.domain.profilemenu.model.SettingModel r5 = id.dana.domain.profilemenu.model.SettingModel.empty()
        L63:
            return r5
        L64:
            r5 = move-exception
            throw r5
        L66:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.NewMyProfileFragment.scheduleImpl(java.lang.String):id.dana.domain.profilemenu.model.SettingModel");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void getAuthRequestContext(UserInfo p0) {
        SettingModel settingModel;
        Intrinsics.checkNotNullParameter(p0, "");
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.newProxyInstance;
        if (myProfileDiffutilAdapter != null) {
            Intrinsics.checkNotNull(myProfileDiffutilAdapter);
            int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory("setting_kyb");
            if (!(myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyBillsEntityDataFactory2))) {
                settingModel = SettingModel.empty();
                int i = C + 99;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
            } else {
                settingModel = myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue.get(MyBillsEntityDataFactory2);
            }
            Intrinsics.checkNotNullExpressionValue(settingModel, "");
            if (settingModel.isNullObject()) {
                return;
            }
            getErrorConfigVersion().getAuthRequestContext(settingModel, p0);
            MyProfileDiffutilAdapter myProfileDiffutilAdapter2 = this.newProxyInstance;
            if (myProfileDiffutilAdapter2 != null) {
                try {
                    try {
                        myProfileDiffutilAdapter2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new ArrayList(myProfileDiffutilAdapter2.getAuthRequestContext.moveToNextValue), null);
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 99;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void r(int i, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        int i4;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        try {
            int[] iArr2 = B;
            if ((iArr2 != null ? '\t' : (char) 22) == '\t') {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i5 = 0;
                while (i5 < length) {
                    int i6 = $10 + 5;
                    $11 = i6 % 128;
                    if ((i6 % 2 == 0 ? (char) 17 : (char) 11) != 17) {
                        iArr3[i5] = (int) (iArr2[i5] ^ (-3152031022165484798L));
                        i5++;
                    } else {
                        iArr3[i5] = (int) (iArr2[i5] / (-3152031022165484798L));
                        i5 %= 0;
                    }
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = B;
            boolean z = true;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i7 = 0;
                while (i7 < length3) {
                    int i8 = $10 + 33;
                    $11 = i8 % 128;
                    if ((i8 % 2 == 0) != z) {
                        i4 = length3;
                        iArr6[i7] = (int) (iArr5[i7] ^ (-3152031022165484798L));
                        i7++;
                    } else {
                        i4 = length3;
                        iArr6[i7] = (int) (iArr5[i7] / (-3152031022165484798L));
                        i7 <<= 0;
                    }
                    length3 = i4;
                    z = true;
                }
                iArr5 = iArr6;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                    i2 = 1;
                    i3 = 0;
                } else {
                    i2 = 1;
                    i3 = 1;
                }
                if (i3 == i2) {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[i2] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + i2] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + i2];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[i2];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                int i9 = 0;
                while (true) {
                    if ((i9 < 16 ? '9' : 'G') != 'G') {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i9];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i10;
                        i9++;
                    }
                }
                int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i11;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
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
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
