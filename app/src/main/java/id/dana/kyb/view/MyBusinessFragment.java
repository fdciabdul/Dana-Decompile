package id.dana.kyb.view;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.perf.metrics.Trace;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesPresenter;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.util.ContextUtil;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.FragmentMyprofileMainBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerKybComponent;
import id.dana.di.modules.KybModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.SwitchFaceAuthenticationModule;
import id.dana.di.modules.TncSummaryModules;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.kyb.KybContract;
import id.dana.kyb.adapter.KybRejectReasonAdapter;
import id.dana.kyb.constant.KybDataSource;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.domain.model.KybUrlsConfig;
import id.dana.kyb.helper.KybUrlsDataManager;
import id.dana.kyb.helper.service.listener.KybServiceListener;
import id.dana.kyb.mapper.KybModelMapperKt;
import id.dana.kyb.model.BalanceModel;
import id.dana.kyb.model.KybCompleteInfoModel;
import id.dana.kyb.model.KybInfoModel;
import id.dana.kyb.model.KybMerchantInfoModel;
import id.dana.kyb.model.KybPageInfo;
import id.dana.kyb.model.KybQrisModel;
import id.dana.kyb.model.KybServiceMessageModel;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.MerchantContractInfoModel;
import id.dana.kyb.model.TransactionListQueryModel;
import id.dana.kyb.view.MyBusinessFragment$kybServiceListener$2;
import id.dana.kyb.view.bottomsheetdialog.KybWithdrawDestinationBottomSheet;
import id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet;
import id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet;
import id.dana.kyb.view.bottomsheetdialog.QrisBusinessBottomSheetDialog;
import id.dana.kyb.view.bottomsheetdialog.QrisEmptyStateBottomSheet;
import id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet;
import id.dana.kyb.view.richview.KybBenefitsView;
import id.dana.kyb.view.richview.KybServiceView;
import id.dana.kyb.view.richview.KybTransactionHistoryView;
import id.dana.kyb.view.richview.MyBusinessBalanceView;
import id.dana.kyb.view.richview.MyBusinessHeaderView;
import id.dana.kybcpm.view.KybCpmInputAmountActivity;
import id.dana.model.CdpContentModel;
import id.dana.model.PromotionModel;
import id.dana.myprofile.MyProfileMainFragment;
import id.dana.richview.NewBannerView;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.TagFormat;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import io.reactivex.functions.Consumer;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\u009f\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001d*\u000b \u0087\u0001\u008a\u0001\u008d\u0001\u009c\u0001\u009f\u0001\u0018\u0000 \u0082\u00022\u00020\u0001:\n\u0082\u0002\u0083\u0002\u0084\u0002\u0085\u0002\u0086\u0002B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010s\u001a\u00020t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010u\u001a\u00020t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010v\u001a\u00020t2\b\u0010w\u001a\u0004\u0018\u00010xH\u0002J\u0012\u0010y\u001a\u00020t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010z\u001a\u00020t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010{\u001a\u00020t2\u0006\u0010|\u001a\u00020}H\u0002J\u0013\u0010~\u001a\u00020t2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\t\u0010\u0081\u0001\u001a\u00020tH\u0002J\t\u0010\u0082\u0001\u001a\u00020tH\u0002J\t\u0010\u0083\u0001\u001a\u00020tH\u0002J\t\u0010\u0084\u0001\u001a\u00020tH\u0002J\t\u0010\u0085\u0001\u001a\u00020tH\u0002J\u0010\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002¢\u0006\u0003\u0010\u0088\u0001J\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0001J\u0010\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002¢\u0006\u0003\u0010\u008e\u0001J\t\u0010\u008f\u0001\u001a\u00020tH\u0002J\t\u0010\u0090\u0001\u001a\u00020tH\u0002J\t\u0010\u0091\u0001\u001a\u00020tH\u0002J\t\u0010\u0092\u0001\u001a\u00020tH\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\t\u0010\u0097\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0098\u0001\u001a\u00020jH\u0014J\n\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u0010\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0003\u0010\u009d\u0001J\u0010\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002¢\u0006\u0003\u0010 \u0001J\n\u0010¡\u0001\u001a\u00030\u009a\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0014\u0010¦\u0001\u001a\u00030\u0094\u00012\b\u0010§\u0001\u001a\u00030\u0094\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020tH\u0002J\t\u0010©\u0001\u001a\u00020tH\u0002J\t\u0010ª\u0001\u001a\u00020tH\u0002J\t\u0010«\u0001\u001a\u00020tH\u0002J\t\u0010¬\u0001\u001a\u00020tH\u0014J\t\u0010\u00ad\u0001\u001a\u00020tH\u0002J\t\u0010®\u0001\u001a\u00020tH\u0002J\t\u0010¯\u0001\u001a\u00020tH\u0002J\t\u0010°\u0001\u001a\u00020tH\u0002J\t\u0010±\u0001\u001a\u00020tH\u0002J\t\u0010²\u0001\u001a\u00020tH\u0002J\t\u0010³\u0001\u001a\u00020\u0011H\u0002J\u0011\u0010´\u0001\u001a\u00020\u00112\u0006\u0010i\u001a\u00020jH\u0002J\u0007\u0010µ\u0001\u001a\u00020tJ'\u0010¶\u0001\u001a\u00020t2\u0007\u0010·\u0001\u001a\u00020j2\u0007\u0010¸\u0001\u001a\u00020j2\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016J\t\u0010»\u0001\u001a\u00020tH\u0002J\u0013\u0010¼\u0001\u001a\u00020t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\t\u0010½\u0001\u001a\u00020tH\u0016J\t\u0010¾\u0001\u001a\u00020tH\u0002J\u001e\u0010¿\u0001\u001a\u00020t2\u0007\u0010À\u0001\u001a\u00020<2\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J\u0013\u0010Ã\u0001\u001a\u00020t2\b\u0010§\u0001\u001a\u00030\u0094\u0001H\u0002J'\u0010Ä\u0001\u001a\u00020t2\b\u0010§\u0001\u001a\u00030\u0094\u00012\u0012\b\u0002\u0010Å\u0001\u001a\u000b\u0012\u0004\u0012\u00020t\u0018\u00010Æ\u0001H\u0002J\t\u0010Ç\u0001\u001a\u00020tH\u0002J\t\u0010È\u0001\u001a\u00020tH\u0002J\t\u0010É\u0001\u001a\u00020tH\u0002J\t\u0010Ê\u0001\u001a\u00020tH\u0002J\t\u0010Ë\u0001\u001a\u00020tH\u0002J\u0011\u0010Ì\u0001\u001a\u00020t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\t\u0010Í\u0001\u001a\u00020tH\u0002J\u0013\u0010Î\u0001\u001a\u00020t2\b\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0002J\t\u0010Ñ\u0001\u001a\u00020tH\u0002J\u0011\u0010Ò\u0001\u001a\u00020t2\u0006\u0010i\u001a\u00020jH\u0002J\u0011\u0010Ó\u0001\u001a\u00020t2\u0006\u0010i\u001a\u00020jH\u0002J\u0011\u0010Ô\u0001\u001a\u00020t2\u0006\u0010i\u001a\u00020jH\u0002J\u0012\u0010Õ\u0001\u001a\u00020t2\u0007\u0010Ö\u0001\u001a\u00020\u0011H\u0016J\u0017\u0010×\u0001\u001a\u00020t2\f\b\u0002\u0010Ø\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0002J\u0010\u0010Ù\u0001\u001a\u00020t2\u0007\u0010Ú\u0001\u001a\u00020XJ\u001a\u0010Û\u0001\u001a\u00020t2\u0006\u0010i\u001a\u00020j2\u0007\u0010Ü\u0001\u001a\u00020\u0011H\u0002J\t\u0010Ý\u0001\u001a\u00020tH\u0002J\t\u0010Þ\u0001\u001a\u00020tH\u0002J\t\u0010ß\u0001\u001a\u00020tH\u0002J\t\u0010à\u0001\u001a\u00020tH\u0002J\u0012\u0010á\u0001\u001a\u00020t2\u0007\u0010Ü\u0001\u001a\u00020\u0011H\u0002J\t\u0010â\u0001\u001a\u00020tH\u0002J\t\u0010ã\u0001\u001a\u00020tH\u0002J\t\u0010ä\u0001\u001a\u00020tH\u0002J\t\u0010å\u0001\u001a\u00020tH\u0002J\t\u0010æ\u0001\u001a\u00020tH\u0002J\t\u0010ç\u0001\u001a\u00020tH\u0002J\u0015\u0010è\u0001\u001a\u00020t2\n\u0010é\u0001\u001a\u0005\u0018\u00010ê\u0001H\u0002J\t\u0010ë\u0001\u001a\u00020tH\u0002J\t\u0010ì\u0001\u001a\u00020tH\u0002J\u001a\u0010í\u0001\u001a\u00020t2\t\u0010î\u0001\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0003\u0010ï\u0001J\t\u0010ð\u0001\u001a\u00020tH\u0002J\t\u0010ñ\u0001\u001a\u00020tH\u0002J\t\u0010ò\u0001\u001a\u00020tH\u0002J\t\u0010ó\u0001\u001a\u00020tH\u0002J\u001b\u0010ô\u0001\u001a\u00020t2\u0007\u0010õ\u0001\u001a\u00020<2\u0007\u0010ö\u0001\u001a\u00020<H\u0002J\t\u0010÷\u0001\u001a\u00020tH\u0002J\t\u0010ø\u0001\u001a\u00020tH\u0002J\t\u0010ù\u0001\u001a\u00020tH\u0002J\u0013\u0010ú\u0001\u001a\u00020t2\b\u0010û\u0001\u001a\u00030\u0094\u0001H\u0002J\t\u0010ü\u0001\u001a\u00020tH\u0002J\t\u0010ý\u0001\u001a\u00020tH\u0002J\u0010\u0010þ\u0001\u001a\u0005\u0018\u00010\u0094\u0001*\u00020\u0018H\u0002J\u0010\u0010ÿ\u0001\u001a\u0005\u0018\u00010\u0094\u0001*\u00020\u0018H\u0002J\r\u0010\u0080\u0002\u001a\u00020\u0011*\u00020\u0018H\u0002J\r\u0010\u0081\u0002\u001a\u00020\u0011*\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010$\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010$\u001a\u0004\b2\u00103R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082.¢\u0006\u0002\n\u0000R$\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u000e\u0010K\u001a\u00020LX\u0082.¢\u0006\u0002\n\u0000R$\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR$\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\r\"\u0004\bT\u0010\u000fR\u000e\u0010U\u001a\u00020VX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\r\"\u0004\ba\u0010\u000fR$\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\r\"\u0004\be\u0010\u000fR\u000e\u0010f\u001a\u00020gX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020gX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\u00020jX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bk\u0010\u0002R\u000e\u0010l\u001a\u00020mX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010n\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010$\u001a\u0004\bp\u0010q¨\u0006\u0087\u0002"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment;", "Lid/dana/base/BaseFragment;", "()V", "btnStatusKyb", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "challengeControl", "Lid/dana/challenge/ChallengeControl;", "danaLoadingDialog", "Lid/dana/dialog/DanaLoadingDialog;", "dynamicUrlWrapper", "Ldagger/Lazy;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Ldagger/Lazy;", "setDynamicUrlWrapper", "(Ldagger/Lazy;)V", "isReactivateFaceVerificationFromPrompt", "", "ivBgKybUnregistered", "Landroid/widget/ImageView;", "ivStatusKyb", "kybBenefitsView", "Lid/dana/kyb/view/richview/KybBenefitsView;", "kybCompleteInfoModel", "Lid/dana/kyb/model/KybCompleteInfoModel;", "kybCompressQrConfig", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "kybPageInfo", "Lid/dana/kyb/model/KybPageInfo;", "kybQrisModel", "Lid/dana/kyb/model/KybQrisModel;", "kybServiceListener", "id/dana/kyb/view/MyBusinessFragment$kybServiceListener$2$1", "getKybServiceListener", "()Lid/dana/kyb/view/MyBusinessFragment$kybServiceListener$2$1;", "kybServiceListener$delegate", "Lkotlin/Lazy;", "kybServiceView", "Lid/dana/kyb/view/richview/KybServiceView;", "kybTabSelectionStartTime", "Ljava/util/Date;", "kybTransactionHistoryView", "Lid/dana/kyb/view/richview/KybTransactionHistoryView;", "kybWithdrawDestinationBottomSheet", "Lid/dana/kyb/view/bottomsheetdialog/KybWithdrawDestinationBottomSheet;", "getKybWithdrawDestinationBottomSheet", "()Lid/dana/kyb/view/bottomsheetdialog/KybWithdrawDestinationBottomSheet;", "kybWithdrawDestinationBottomSheet$delegate", "kycInProgressBottomSheet", "Lid/dana/kyb/view/bottomsheetdialog/KycInProgressBottomSheet;", "getKycInProgressBottomSheet", "()Lid/dana/kyb/view/bottomsheetdialog/KycInProgressBottomSheet;", "kycInProgressBottomSheet$delegate", "kycUpgradeBottomSheet", "Lid/dana/kyb/view/bottomsheetdialog/KycUpgradeBottomSheet;", "lavLoadingAnimation", "Lcom/airbnb/lottie/LottieAnimationView;", "myBusinessBalanceView", "Lid/dana/kyb/view/richview/MyBusinessBalanceView;", "myBusinessContent", "Landroid/view/View;", "myBusinessHeaderView", "Lid/dana/kyb/view/richview/MyBusinessHeaderView;", "needBackendUpdate", "needCheckTnc", "nestedScrollMybusiness", "Landroidx/core/widget/NestedScrollView;", "newBannerView", "Lid/dana/richview/NewBannerView;", "phonePermission", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "presenter", "Lid/dana/kyb/KybContract$Presenter;", "getPresenter", "setPresenter", "ptrKyb", "Lin/srain/cube/views/ptr/PtrClassicFrameLayout;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesPresenter;", "getReadLinkPropertiesPresenter", "setReadLinkPropertiesPresenter", "rejectReasonAdapter", "Lid/dana/kyb/adapter/KybRejectReasonAdapter;", "getRejectReasonAdapter", "setRejectReasonAdapter", "rvKybRejectReason", "Landroidx/recyclerview/widget/RecyclerView;", "settingsListener", "Lid/dana/myprofile/MyProfileMainFragment$SettingsListener;", "speedLoad", "", "startKybSkeletonScreen", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "stopRefreshAnimationOnRepeat", "switchFaceAuthPresenter", "Lid/dana/switchfaceauth/SwitchFaceAuthContract$Presenter;", "getSwitchFaceAuthPresenter", "setSwitchFaceAuthPresenter", "tncSummaryPresenter", "Lid/dana/tncsummary/TncSummaryContract$Presenter;", "getTncSummaryPresenter", "setTncSummaryPresenter", "tvKybStatusSubTitle", "Landroid/widget/TextView;", "tvKybStatusTitle", "variant", "", "getVariant$annotations", "viewKybShimmer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "withdrawBalanceFaceAuthActivationBottomSheet", "Lid/dana/kyb/view/bottomsheetdialog/WithdrawBalanceFaceAuthActivationBottomSheet;", "getWithdrawBalanceFaceAuthActivationBottomSheet", "()Lid/dana/kyb/view/bottomsheetdialog/WithdrawBalanceFaceAuthActivationBottomSheet;", "withdrawBalanceFaceAuthActivationBottomSheet$delegate", "bindRegisteredContent", "", "bindUnRegisteredContent", "bindingBalanceInfo", "balanceModel", "Lid/dana/kyb/model/BalanceModel;", "bindingContent", "bindingHeader", "bindingTransactionHistory", "transactionListQueryModel", "Lid/dana/kyb/model/TransactionListQueryModel;", "bindingTransactionLimit", "merchantInfoModel", "Lid/dana/kyb/model/KybMerchantInfoModel;", "checkErrorKybCpm", "checkKybSettingButtonVisibility", "checkOpenTransactionInProgress", "checkTncAvailability", "clearBundle", "createKybOpenH5Listener", "id/dana/kyb/view/MyBusinessFragment$createKybOpenH5Listener$1", "()Lid/dana/kyb/view/MyBusinessFragment$createKybOpenH5Listener$1;", "createKybTieringListener", "id/dana/kyb/view/MyBusinessFragment$createKybTieringListener$1", "()Lid/dana/kyb/view/MyBusinessFragment$createKybTieringListener$1;", "createKycUpgradeListener", "id/dana/kyb/view/MyBusinessFragment$createKycUpgradeListener$1", "()Lid/dana/kyb/view/MyBusinessFragment$createKycUpgradeListener$1;", "doWithdraw", "doWithdrawWithBalance", "doWithdrawWithBank", "generateMerchantQrCode", "getKybDataSource", "", "getKybModule", "Lid/dana/di/modules/KybModule;", "getKybPageInfoFromBundle", "getLayout", "getPinLockedListener", "Landroid/content/DialogInterface$OnClickListener;", "getPtrHandler", "id/dana/kyb/view/MyBusinessFragment$getPtrHandler$1", "()Lid/dana/kyb/view/MyBusinessFragment$getPtrHandler$1;", "getPtrUiHandler", "id/dana/kyb/view/MyBusinessFragment$getPtrUiHandler$1", "()Lid/dana/kyb/view/MyBusinessFragment$getPtrUiHandler$1;", "getRiskRejectDialogListener", "getSwitchFaceAuthenticationModule", "Lid/dana/di/modules/SwitchFaceAuthenticationModule;", "getTncSummaryModule", "Lid/dana/di/modules/TncSummaryModules;", "getUrlWithSpeedTimeLoad", "url", "hideButtonBenefit", "hideKybStatusButton", "hideKybStatusButtonAndRefreshData", "hideShimmer", IAPSyncCommand.COMMAND_INIT, "initArguments", "initComponent", "initPermission", "initPullToRefreshComponent", "initPullToRefreshHeaderView", "initSettingsClickListener", "isLoadingAnimationInitialized", "isNotRegisteredBusinessVariant", "loadData", "onActivityResult", RequestPermission.REQUEST_CODE, "resultCode", "data", "Landroid/content/Intent;", "onBalanceWithdrawClicked", "onClickButtonApplyBenefit", "onDestroyView", "onRiskReject", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "openDeepLink", "openH5Container", "onDestroy", "Lkotlin/Function0;", "openKybRegistrationContainer", "openKybRegistrationRejectContainer", "openKybRegistrationRevoke", "openKybTieringContainer", "openKycContainer", "openQrisBusinessBottomSheet", "openQrisEmptyStateBottomSheet", "openService", "service", "Lid/dana/kyb/model/KybServiceModel;", "sendPaymentRequest", "setBackgroundVariant", "setContentVariant", "setHeaderContentDescription", "setMenuVisibility", "menuVisible", "setQrisData", "nssCode", "setSettingsListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUIMerchantStatus", "kycRevoked", "setUIStatusFrozen", "setUIStatusGeneralError", "setUIStatusPending", "setUIStatusRejected", "setUIStatusRevoked", "showFailFaceActivationPopUp", "showGeneralErrorToastKybCpm", "showKycInProgressBottomSheet", "showKycUpgradeBottomSheet", "showPinLockedDialog", "showReactiveFaceVerificationPrompt", "showServiceRuleNotValidBottomSheet", "kybServiceMessageModel", "Lid/dana/kyb/model/KybServiceMessageModel;", "showShimmer", "showSuccessFaceActivation", "showToggleNotification", "faceAuthNew", "(Ljava/lang/Boolean;)V", "showWithdrawFaceAuthBottomSheet", "startLoadPerformance", "stopLoadPerformance", "stopRefresh", "swapView", "oldView", "newView", "trackBalanceWithdrawClicked", "trackFaceEnrollClick", "trackKybNativeHomepageOpen", "trackKybTabClick", "source", "trackRequestPaymentClick", "trackSettingsClick", "getAvatarUrl", "getMerchantName", "isFaceVerificationEnrolled", "isReActiveFaceVerification", "Companion", "KybOpenH5Listener", "KybTieringListener", "KycUpgradeListener", "RequestPaymentListener", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessFragment extends BaseFragment {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AppCompatEmojiTextHelper = 1;
    private static long F;
    private static int I;
    public static final Companion PlaceComponentResult;
    private FragmentPermissionRequest A;
    private RecyclerView B;
    private PtrClassicFrameLayout BottomSheetCardBindingView$watcherCardNumberView$1;
    private MyProfileMainFragment.SettingsListener C;
    private KybCompressQrConfig DatabaseTableConfigUtil;
    private ViewSkeletonScreen E;
    private View FragmentBottomSheetPaymentSettingBinding;
    private ConstraintLayout G;
    private KybQrisModel GetContactSyncConfig;
    private DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private KybCompleteInfoModel NetworkUserEntityData$$ExternalSyntheticLambda2;
    private LottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda3;
    private MyBusinessBalanceView NetworkUserEntityData$$ExternalSyntheticLambda4;
    private KycUpgradeBottomSheet NetworkUserEntityData$$ExternalSyntheticLambda6;
    private KybTransactionHistoryView NetworkUserEntityData$$ExternalSyntheticLambda8;
    private KybServiceView PrepareContext;
    private MyBusinessHeaderView SubSequence;
    private long VerifyPinStateManager$executeRiskChallenge$2$1;
    private TextView VerifyPinStateManager$executeRiskChallenge$2$2;
    @Inject
    public Lazy<DynamicUrlWrapper> dynamicUrlWrapper;
    private boolean getCallingPid;
    private ImageView getErrorConfigVersion;
    private TextView getOnBoardingScenario;
    private NestedScrollView getSupportButtonTintMode;
    private boolean getValueOfTouchPositionAbsolute;
    private KybBenefitsView initRecordTimeStamp;
    private Date isLayoutRequested;
    private DanaLoadingDialog lookAheadTest;
    private ChallengeControl moveToNextValue;
    @Inject
    public Lazy<KybContract.Presenter> presenter;
    @Inject
    public Lazy<ReadLinkPropertiesPresenter> readLinkPropertiesPresenter;
    @Inject
    public Lazy<KybRejectReasonAdapter> rejectReasonAdapter;
    private ImageView scheduleImpl;
    @Inject
    public Lazy<SwitchFaceAuthContract.Presenter> switchFaceAuthPresenter;
    @Inject
    public Lazy<TncSummaryContract.Presenter> tncSummaryPresenter;
    private NewBannerView whenAvailable;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();
    private int D = -1;
    private boolean readMicros = true;
    private KybPageInfo NetworkUserEntityData$$ExternalSyntheticLambda1 = new KybPageInfo(false, false, null, false, 15, null);
    private final kotlin.Lazy H = LazyKt.lazy(new Function0<WithdrawBalanceFaceAuthActivationBottomSheet>() { // from class: id.dana.kyb.view.MyBusinessFragment$withdrawBalanceFaceAuthActivationBottomSheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WithdrawBalanceFaceAuthActivationBottomSheet invoke() {
            final WithdrawBalanceFaceAuthActivationBottomSheet withdrawBalanceFaceAuthActivationBottomSheet = new WithdrawBalanceFaceAuthActivationBottomSheet();
            final MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$withdrawBalanceFaceAuthActivationBottomSheet$2$1$1
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
                    WithdrawBalanceFaceAuthActivationBottomSheet.this.dismiss();
                    MyBusinessFragment.K(myBusinessFragment);
                    MyBusinessFragment.AppCompatEmojiTextHelper(myBusinessFragment);
                    SwitchFaceAuthContract.Presenter presenter = myBusinessFragment.MyBillsEntityDataFactory().get();
                    FragmentActivity requireActivity = myBusinessFragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                    presenter.MyBillsEntityDataFactory(true, null, requireActivity);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            withdrawBalanceFaceAuthActivationBottomSheet.BuiltInFictitiousFunctionClassFactory = function0;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$withdrawBalanceFaceAuthActivationBottomSheet$2$1$2
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
                    MyBusinessBalanceView FragmentBottomSheetPaymentSettingBinding = MyBusinessFragment.FragmentBottomSheetPaymentSettingBinding(MyBusinessFragment.this);
                    if (FragmentBottomSheetPaymentSettingBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        FragmentBottomSheetPaymentSettingBinding = null;
                    }
                    FragmentBottomSheetPaymentSettingBinding.setBalanceWithdrawClickable(true);
                }
            };
            Intrinsics.checkNotNullParameter(function02, "");
            withdrawBalanceFaceAuthActivationBottomSheet.PlaceComponentResult = function02;
            return withdrawBalanceFaceAuthActivationBottomSheet;
        }
    });
    private final kotlin.Lazy newProxyInstance = LazyKt.lazy(new Function0<MyBusinessFragment$kybServiceListener$2.AnonymousClass1>() { // from class: id.dana.kyb.view.MyBusinessFragment$kybServiceListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kyb.view.MyBusinessFragment$kybServiceListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
            return new KybServiceListener() { // from class: id.dana.kyb.view.MyBusinessFragment$kybServiceListener$2.1
                @Override // id.dana.kyb.helper.service.listener.KybServiceListener
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, p0);
                }

                @Override // id.dana.kyb.helper.service.listener.KybServiceListener
                public final void MyBillsEntityDataFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    MyBusinessFragment.PlaceComponentResult(MyBusinessFragment.this, p0);
                }

                @Override // id.dana.kyb.helper.service.listener.KybServiceListener
                public final void PlaceComponentResult() {
                    MyBusinessFragment.H(MyBusinessFragment.this);
                }

                @Override // id.dana.kyb.helper.service.listener.KybServiceListener
                public final void getAuthRequestContext() {
                    Unit unit;
                    KybQrisModel isLayoutRequested = MyBusinessFragment.isLayoutRequested(MyBusinessFragment.this);
                    if (isLayoutRequested != null) {
                        MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment.this, isLayoutRequested);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        MyBusinessFragment.F(MyBusinessFragment.this);
                    }
                }

                @Override // id.dana.kyb.helper.service.listener.KybServiceListener
                public final void MyBillsEntityDataFactory() {
                    Context context = MyBusinessFragment.this.getContext();
                    if (context != null) {
                        ContextUtil contextUtil = ContextUtil.INSTANCE;
                        if (ContextUtil.getAuthRequestContext(context)) {
                            KybCpmInputAmountActivity.Companion companion = KybCpmInputAmountActivity.INSTANCE;
                            context.startActivity(KybCpmInputAmountActivity.Companion.getAuthRequestContext(context));
                        }
                    }
                }
            };
        }
    });
    private final kotlin.Lazy NetworkUserEntityData$$ExternalSyntheticLambda5 = LazyKt.lazy(new Function0<KycInProgressBottomSheet>() { // from class: id.dana.kyb.view.MyBusinessFragment$kycInProgressBottomSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KycInProgressBottomSheet invoke() {
            return new KycInProgressBottomSheet();
        }
    });
    private final kotlin.Lazy NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<KybWithdrawDestinationBottomSheet>() { // from class: id.dana.kyb.view.MyBusinessFragment$kybWithdrawDestinationBottomSheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KybWithdrawDestinationBottomSheet invoke() {
            final KybWithdrawDestinationBottomSheet kybWithdrawDestinationBottomSheet = new KybWithdrawDestinationBottomSheet();
            final MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$kybWithdrawDestinationBottomSheet$2$1$1
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
                    KybWithdrawDestinationBottomSheet.this.dismiss();
                    MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(myBusinessFragment);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            kybWithdrawDestinationBottomSheet.MyBillsEntityDataFactory = function0;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$kybWithdrawDestinationBottomSheet$2$1$2
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
                    KybWithdrawDestinationBottomSheet.this.dismiss();
                    MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(myBusinessFragment);
                }
            };
            Intrinsics.checkNotNullParameter(function02, "");
            kybWithdrawDestinationBottomSheet.getAuthRequestContext = function02;
            Function0<Unit> function03 = new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$kybWithdrawDestinationBottomSheet$2$1$3
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
                    MyBusinessBalanceView FragmentBottomSheetPaymentSettingBinding = MyBusinessFragment.FragmentBottomSheetPaymentSettingBinding(MyBusinessFragment.this);
                    if (FragmentBottomSheetPaymentSettingBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        FragmentBottomSheetPaymentSettingBinding = null;
                    }
                    FragmentBottomSheetPaymentSettingBinding.setBalanceWithdrawClickable(true);
                }
            };
            Intrinsics.checkNotNullParameter(function03, "");
            kybWithdrawDestinationBottomSheet.BuiltInFictitiousFunctionClassFactory = function03;
            return kybWithdrawDestinationBottomSheet;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface KybOpenH5Listener {
        void BuiltInFictitiousFunctionClassFactory(String p0);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment$KybTieringListener;", "", "", "PlaceComponentResult", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface KybTieringListener {
        void PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment$KycUpgradeListener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface KycUpgradeListener {
        void BuiltInFictitiousFunctionClassFactory();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment$RequestPaymentListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface RequestPaymentListener {
    }

    static {
        try {
            moveToNextValue();
            PlaceComponentResult = new Companion(null);
            int i = AppCompatEmojiTextHelper + 89;
            I = i % 128;
            if (!(i % 2 != 0)) {
                return;
            }
            int i2 = 13 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(KybQrisModel kybQrisModel, Bitmap bitmap) {
        int i = I + 1;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(kybQrisModel, bitmap);
        try {
            int i3 = AppCompatEmojiTextHelper + 49;
            I = i3 % 128;
            if ((i3 % 2 != 0 ? 'L' : ':') != ':') {
                int i4 = 59 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBusinessFragment myBusinessFragment) {
        int i = I + 31;
        AppCompatEmojiTextHelper = i % 128;
        if ((i % 2 == 0 ? '\r' : '@') != '\r') {
            try {
                O(myBusinessFragment);
            } catch (Exception e) {
                throw e;
            }
        } else {
            O(myBusinessFragment);
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = AppCompatEmojiTextHelper + 19;
        I = i2 % 128;
        int i3 = i2 % 2;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 101;
        I = i % 128;
        if (!(i % 2 == 0)) {
            try {
                N(myBusinessFragment);
                int i2 = 39 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            N(myBusinessFragment);
        }
        int i3 = AppCompatEmojiTextHelper + 59;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 35;
        I = i % 128;
        boolean z = i % 2 == 0;
        Object obj = null;
        S(myBusinessFragment);
        if (!z) {
            obj.hashCode();
        }
        int i2 = I + 123;
        AppCompatEmojiTextHelper = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 6 : '`') != '`') {
            obj.hashCode();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Ref.ObjectRef objectRef) {
        int i = I + 121;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        BuiltInFictitiousFunctionClassFactory(objectRef);
        int i3 = I + 115;
        AppCompatEmojiTextHelper = i3 % 128;
        if ((i3 % 2 == 0 ? '\'' : 'W') != '\'') {
            return;
        }
        int i4 = 75 / 0;
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(MyBusinessFragment myBusinessFragment) {
        int i = I + 35;
        AppCompatEmojiTextHelper = i % 128;
        if ((i % 2 == 0 ? (char) 4 : '=') == 4) {
            SummaryVoucherView$$ExternalSyntheticLambda1(myBusinessFragment);
            int i2 = 92 / 0;
            return;
        }
        try {
            SummaryVoucherView$$ExternalSyntheticLambda1(myBusinessFragment);
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(MyBusinessFragment myBusinessFragment) {
        int i = I + 81;
        AppCompatEmojiTextHelper = i % 128;
        if (!(i % 2 == 0)) {
            try {
                T(myBusinessFragment);
            } catch (Exception e) {
                throw e;
            }
        } else {
            T(myBusinessFragment);
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = AppCompatEmojiTextHelper + 5;
        I = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return;
        }
        int i3 = 48 / 0;
    }

    public static /* synthetic */ void PlaceComponentResult(MyBusinessFragment myBusinessFragment, int i) {
        try {
            int i2 = AppCompatEmojiTextHelper + 29;
            try {
                I = i2 % 128;
                int i3 = i2 % 2;
                getAuthRequestContext(myBusinessFragment, i);
                int i4 = I + 121;
                AppCompatEmojiTextHelper = i4 % 128;
                if ((i4 % 2 == 0 ? '+' : (char) 2) != '+') {
                    return;
                }
                int i5 = 46 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(MyBusinessFragment myBusinessFragment, DialogInterface dialogInterface, int i) {
        int i2 = AppCompatEmojiTextHelper + 37;
        I = i2 % 128;
        if ((i2 % 2 != 0 ? '\'' : '\b') == '\b') {
            MyBillsEntityDataFactory(myBusinessFragment, dialogInterface, i);
            return;
        }
        try {
            MyBillsEntityDataFactory(myBusinessFragment, dialogInterface, i);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(Ref.ObjectRef objectRef) {
        int i = I + 31;
        AppCompatEmojiTextHelper = i % 128;
        char c = i % 2 == 0 ? '\'' : 'b';
        getAuthRequestContext(objectRef);
        if (c != 'b') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private void d() {
        int i = I + 119;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        this.MyBillsEntityDataFactory.clear();
        int i3 = I + 73;
        AppCompatEmojiTextHelper = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void getAuthRequestContext(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 85;
        I = i % 128;
        char c = i % 2 != 0 ? '%' : '-';
        SummaryVoucherView$$ExternalSyntheticLambda2(myBusinessFragment);
        if (c != '%') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static /* synthetic */ void getAuthRequestContext(MyBusinessFragment myBusinessFragment, DialogInterface dialogInterface, int i) {
        try {
            int i2 = AppCompatEmojiTextHelper + 39;
            I = i2 % 128;
            boolean z = i2 % 2 != 0;
            KClassImpl$Data$declaredNonStaticMembers$2(myBusinessFragment, dialogInterface, i);
            if (z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(MyBusinessFragment myBusinessFragment, KybCompleteInfoModel kybCompleteInfoModel) {
        int i = I + 97;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        PlaceComponentResult(myBusinessFragment, kybCompleteInfoModel);
        int i3 = I + 41;
        AppCompatEmojiTextHelper = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private static boolean getAuthRequestContext(int i) {
        int i2 = AppCompatEmojiTextHelper + 77;
        I = i2 % 128;
        boolean z = true;
        if (i2 % 2 == 0 ? i != 2 : i != 3) {
            if (!(i == 3)) {
                if (!(i == 4) && i != 5) {
                    z = false;
                }
            }
        }
        try {
            int i3 = I + 11;
            AppCompatEmojiTextHelper = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 0 / 0;
                return z;
            }
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void getErrorConfigVersion(MyBusinessFragment myBusinessFragment) {
        try {
            int i = I + 31;
            AppCompatEmojiTextHelper = i % 128;
            int i2 = i % 2;
            SummaryVoucherView$$ExternalSyntheticLambda0(myBusinessFragment);
            int i3 = AppCompatEmojiTextHelper + 119;
            I = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void lookAheadTest(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 53;
            I = i % 128;
            if (i % 2 != 0) {
                R(myBusinessFragment);
                Object obj = null;
                obj.hashCode();
                return;
            }
            try {
                R(myBusinessFragment);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void moveToNextValue() {
        F = -8937752252894398101L;
    }

    public static /* synthetic */ void moveToNextValue(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 95;
        I = i % 128;
        int i2 = i % 2;
        isAuth(myBusinessFragment);
        int i3 = AppCompatEmojiTextHelper + 93;
        I = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static /* synthetic */ void scheduleImpl(MyBusinessFragment myBusinessFragment) {
        int i = I + 35;
        AppCompatEmojiTextHelper = i % 128;
        if ((i % 2 == 0 ? (char) 0 : (char) 27) != 0) {
            try {
                X(myBusinessFragment);
            } catch (Exception e) {
                throw e;
            }
        } else {
            X(myBusinessFragment);
            Object obj = null;
            obj.hashCode();
        }
        int i2 = AppCompatEmojiTextHelper + 21;
        I = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = AppCompatEmojiTextHelper + 103;
        I = i % 128;
        if (i % 2 == 0) {
            return R.layout.fragment_mybusiness;
        }
        int i2 = 12 / 0;
        return R.layout.fragment_mybusiness;
    }

    public static final /* synthetic */ void A(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 121;
        I = i % 128;
        char c = i % 2 != 0 ? (char) 4 : (char) 0;
        Object[] objArr = null;
        myBusinessFragment.C();
        if (c != 0) {
            int length = objArr.length;
        }
        int i2 = I + 75;
        AppCompatEmojiTextHelper = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        objArr.hashCode();
    }

    public static final /* synthetic */ void AppCompatEmojiTextHelper(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 105;
        I = i % 128;
        int i2 = i % 2;
        try {
            myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            int i3 = I + 33;
            try {
                AppCompatEmojiTextHelper = i3 % 128;
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

    public static final /* synthetic */ int B(MyBusinessFragment myBusinessFragment) {
        int i = I + 23;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        int i3 = myBusinessFragment.D;
        int i4 = AppCompatEmojiTextHelper + 23;
        I = i4 % 128;
        if ((i4 % 2 != 0 ? '%' : '_') != '%') {
            return i3;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return i3;
    }

    public static final /* synthetic */ void BottomSheetCardBindingView$watcherCardNumberView$1(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 119;
            I = i % 128;
            int i2 = i % 2;
            myBusinessFragment.B();
            int i3 = I + 51;
            AppCompatEmojiTextHelper = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 71 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBusinessFragment myBusinessFragment, int i) {
        int i2 = I + 113;
        AppCompatEmojiTextHelper = i2 % 128;
        int i3 = i2 % 2;
        myBusinessFragment.MyBillsEntityDataFactory(i);
        int i4 = AppCompatEmojiTextHelper + 71;
        I = i4 % 128;
        int i5 = i4 % 2;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBusinessFragment myBusinessFragment, KybCompleteInfoModel kybCompleteInfoModel) {
        int i = AppCompatEmojiTextHelper + 13;
        I = i % 128;
        int i2 = i % 2;
        myBusinessFragment.getAuthRequestContext(kybCompleteInfoModel);
        int i3 = AppCompatEmojiTextHelper + 23;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBusinessFragment myBusinessFragment, KybServiceModel kybServiceModel) {
        try {
            int i = I + 115;
            AppCompatEmojiTextHelper = i % 128;
            char c = i % 2 == 0 ? '(' : 'b';
            myBusinessFragment.getAuthRequestContext(kybServiceModel);
            if (c != '(') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBusinessFragment myBusinessFragment, TransactionListQueryModel transactionListQueryModel) {
        try {
            int i = I + 41;
            AppCompatEmojiTextHelper = i % 128;
            if (!(i % 2 != 0)) {
                myBusinessFragment.getAuthRequestContext(transactionListQueryModel);
                Object obj = null;
                obj.hashCode();
                return;
            }
            myBusinessFragment.getAuthRequestContext(transactionListQueryModel);
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean C(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 45;
            I = i % 128;
            int i2 = i % 2;
            boolean AppCompatEmojiTextHelper2 = myBusinessFragment.AppCompatEmojiTextHelper();
            int i3 = AppCompatEmojiTextHelper + 29;
            I = i3 % 128;
            int i4 = i3 % 2;
            return AppCompatEmojiTextHelper2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void D(MyBusinessFragment myBusinessFragment) {
        int i = I + 109;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        myBusinessFragment.G();
        int i3 = AppCompatEmojiTextHelper + 61;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void DatabaseTableConfigUtil(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 107;
        I = i % 128;
        int i2 = i % 2;
        myBusinessFragment.getErrorConfigVersion();
        int i3 = I + 73;
        AppCompatEmojiTextHelper = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void E(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 69;
        I = i % 128;
        char c = i % 2 != 0 ? ':' : (char) 15;
        Object[] objArr = null;
        myBusinessFragment.K();
        if (c != 15) {
            objArr.hashCode();
        }
        int i2 = AppCompatEmojiTextHelper + 81;
        I = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return;
        }
        int length = objArr.length;
    }

    public static final /* synthetic */ void F(MyBusinessFragment myBusinessFragment) {
        int i = I + 59;
        AppCompatEmojiTextHelper = i % 128;
        if (i % 2 == 0) {
            myBusinessFragment.L();
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            myBusinessFragment.L();
        }
        int i2 = I + 55;
        AppCompatEmojiTextHelper = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ MyBusinessBalanceView FragmentBottomSheetPaymentSettingBinding(MyBusinessFragment myBusinessFragment) {
        int i = I + 65;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        try {
            MyBusinessBalanceView myBusinessBalanceView = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda4;
            int i3 = I + 51;
            try {
                AppCompatEmojiTextHelper = i3 % 128;
                if ((i3 % 2 == 0 ? '\n' : (char) 1) != 1) {
                    int i4 = 52 / 0;
                    return myBusinessBalanceView;
                }
                return myBusinessBalanceView;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void G(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 69;
        I = i % 128;
        if (i % 2 != 0) {
        }
        myBusinessFragment.getCallingPid = true;
        int i2 = I + 69;
        AppCompatEmojiTextHelper = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void GetContactSyncConfig(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 91;
            I = i % 128;
            int i2 = i % 2;
            myBusinessFragment.lookAheadTest();
            int i3 = I + 47;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void H(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 3;
        I = i % 128;
        int i2 = i % 2;
        myBusinessFragment.Q();
        int i3 = AppCompatEmojiTextHelper + 57;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void I(MyBusinessFragment myBusinessFragment) {
        int i = I + 27;
        AppCompatEmojiTextHelper = i % 128;
        if (!(i % 2 != 0)) {
            myBusinessFragment.getValueOfTouchPositionAbsolute = true;
        } else {
            myBusinessFragment.getValueOfTouchPositionAbsolute = false;
        }
        int i2 = I + 101;
        AppCompatEmojiTextHelper = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void J(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 63;
        I = i % 128;
        char c = i % 2 != 0 ? ':' : 'Q';
        myBusinessFragment.flip();
        if (c != 'Q') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void K(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 107;
            I = i % 128;
            int i2 = i % 2;
            myBusinessFragment.isAuto();
            int i3 = I + 93;
            AppCompatEmojiTextHelper = i3 % 128;
            if ((i3 % 2 == 0 ? 'B' : (char) 7) != 'B') {
                return;
            }
            int i4 = 41 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment myBusinessFragment, int i) {
        try {
            int i2 = AppCompatEmojiTextHelper + 13;
            I = i2 % 128;
            Object[] objArr = null;
            if (!(i2 % 2 != 0)) {
                myBusinessFragment.D = i;
            } else {
                myBusinessFragment.D = i;
                objArr.hashCode();
            }
            int i3 = I + 19;
            AppCompatEmojiTextHelper = i3 % 128;
            if ((i3 % 2 == 0 ? '*' : (char) 21) != 21) {
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment myBusinessFragment, KybCompleteInfoModel kybCompleteInfoModel) {
        try {
            int i = I + 109;
            AppCompatEmojiTextHelper = i % 128;
            int i2 = i % 2;
            try {
                myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = kybCompleteInfoModel;
                int i3 = I + 81;
                AppCompatEmojiTextHelper = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 0 : '\\') != 0) {
                    return;
                }
                int i4 = 40 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment myBusinessFragment, KybQrisModel kybQrisModel) {
        int i = I + 85;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        myBusinessFragment.BuiltInFictitiousFunctionClassFactory(kybQrisModel);
        int i3 = I + 63;
        AppCompatEmojiTextHelper = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        int i4 = 67 / 0;
    }

    public static final /* synthetic */ void L(MyBusinessFragment myBusinessFragment) {
        try {
            int i = I + 9;
            AppCompatEmojiTextHelper = i % 128;
            int i2 = i % 2;
            myBusinessFragment.R();
            int i3 = I + 119;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void M(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 27;
        I = i % 128;
        if (i % 2 != 0) {
            myBusinessFragment.U();
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        myBusinessFragment.U();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MyBusinessFragment myBusinessFragment, int i) {
        try {
            int i2 = I + 21;
            try {
                AppCompatEmojiTextHelper = i2 % 128;
                int i3 = i2 % 2;
                myBusinessFragment.BuiltInFictitiousFunctionClassFactory(i);
                int i4 = I + 73;
                AppCompatEmojiTextHelper = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MyBusinessFragment myBusinessFragment, KybCompleteInfoModel kybCompleteInfoModel) {
        try {
            int i = AppCompatEmojiTextHelper + 21;
            try {
                I = i % 128;
                int i2 = i % 2;
                myBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(kybCompleteInfoModel);
                int i3 = AppCompatEmojiTextHelper + 79;
                I = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = 37 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MyBusinessFragment myBusinessFragment, KybServiceMessageModel kybServiceMessageModel) {
        int i = I + 49;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        myBusinessFragment.BuiltInFictitiousFunctionClassFactory(kybServiceMessageModel);
        try {
            int i3 = AppCompatEmojiTextHelper + 91;
            I = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MyBusinessFragment myBusinessFragment, String str) {
        try {
            int i = AppCompatEmojiTextHelper + 35;
            I = i % 128;
            int i2 = i % 2;
            myBusinessFragment.MyBillsEntityDataFactory(str);
            int i3 = I + 71;
            AppCompatEmojiTextHelper = i3 % 128;
            if ((i3 % 2 == 0 ? 'W' : ',') != 'W') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 63;
        I = i % 128;
        int i2 = i % 2;
        myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda7();
        int i3 = I + 79;
        AppCompatEmojiTextHelper = i3 % 128;
        if ((i3 % 2 == 0 ? '\r' : '.') != '\r') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(MyBusinessFragment myBusinessFragment) {
        int i = I + 99;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        myBusinessFragment.scheduleImpl();
        int i3 = AppCompatEmojiTextHelper + 125;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ KybTransactionHistoryView NetworkUserEntityData$$ExternalSyntheticLambda3(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 69;
        I = i % 128;
        int i2 = i % 2;
        try {
            KybTransactionHistoryView kybTransactionHistoryView = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int i3 = I + 29;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
            return kybTransactionHistoryView;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ LottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda4(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 79;
        I = i % 128;
        int i2 = i % 2;
        LottieAnimationView lottieAnimationView = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
        int i3 = I + 123;
        AppCompatEmojiTextHelper = i3 % 128;
        int i4 = i3 % 2;
        return lottieAnimationView;
    }

    public static final /* synthetic */ KybServiceView NetworkUserEntityData$$ExternalSyntheticLambda5(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 81;
            I = i % 128;
            int i2 = i % 2;
            KybServiceView kybServiceView = myBusinessFragment.PrepareContext;
            try {
                int i3 = AppCompatEmojiTextHelper + 111;
                I = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 0 : 'V') != 'V') {
                    int i4 = 59 / 0;
                    return kybServiceView;
                }
                return kybServiceView;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ KybWithdrawDestinationBottomSheet NetworkUserEntityData$$ExternalSyntheticLambda6(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 63;
            I = i % 128;
            int i2 = i % 2;
            KybWithdrawDestinationBottomSheet NetworkUserEntityData$$ExternalSyntheticLambda4 = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda4();
            int i3 = I + 95;
            AppCompatEmojiTextHelper = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 19 / 0;
                return NetworkUserEntityData$$ExternalSyntheticLambda4;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda4;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ ChallengeControl NetworkUserEntityData$$ExternalSyntheticLambda7(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 7;
        I = i % 128;
        if ((i % 2 != 0 ? '-' : 'a') != 'a') {
            try {
                ChallengeControl challengeControl = myBusinessFragment.moveToNextValue;
                Object[] objArr = null;
                int length = objArr.length;
                return challengeControl;
            } catch (Exception e) {
                throw e;
            }
        }
        return myBusinessFragment.moveToNextValue;
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda8(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 3;
        I = i % 128;
        char c = i % 2 != 0 ? (char) 19 : (char) 18;
        myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda8();
        if (c == 19) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = I + 93;
        AppCompatEmojiTextHelper = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void P(MyBusinessFragment myBusinessFragment) {
        int i = I + 1;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        myBusinessFragment.shouldRecycleViewType();
        try {
            int i3 = AppCompatEmojiTextHelper + 17;
            try {
                I = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(MyBusinessFragment myBusinessFragment, ChallengeControl challengeControl) {
        int i = AppCompatEmojiTextHelper + 119;
        I = i % 128;
        if ((i % 2 != 0 ? '6' : 'Q') == 'Q') {
            myBusinessFragment.moveToNextValue = challengeControl;
            return;
        }
        try {
            myBusinessFragment.moveToNextValue = challengeControl;
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(MyBusinessFragment myBusinessFragment, Boolean bool) {
        int i = I + 13;
        AppCompatEmojiTextHelper = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? '+' : '#') != '#') {
            myBusinessFragment.PlaceComponentResult(bool);
            objArr.hashCode();
        } else {
            myBusinessFragment.PlaceComponentResult(bool);
        }
        int i2 = I + 11;
        AppCompatEmojiTextHelper = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        int length = objArr.length;
    }

    public static final /* synthetic */ void PlaceComponentResult(MyBusinessFragment myBusinessFragment, String str) {
        int i = I + 29;
        AppCompatEmojiTextHelper = i % 128;
        boolean z = i % 2 == 0;
        myBusinessFragment.getAuthRequestContext(str);
        if (!z) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ KybCompleteInfoModel PrepareContext(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 63;
        I = i % 128;
        if (i % 2 == 0) {
            return myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        try {
            KybCompleteInfoModel kybCompleteInfoModel = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Object obj = null;
            obj.hashCode();
            return kybCompleteInfoModel;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void Q(MyBusinessFragment myBusinessFragment) {
        try {
            int i = I + 75;
            try {
                AppCompatEmojiTextHelper = i % 128;
                int i2 = i % 2;
                myBusinessFragment.b();
                int i3 = I + 25;
                AppCompatEmojiTextHelper = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ PtrClassicFrameLayout SubSequence(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 107;
            I = i % 128;
            int i2 = i % 2;
            PtrClassicFrameLayout ptrClassicFrameLayout = myBusinessFragment.BottomSheetCardBindingView$watcherCardNumberView$1;
            int i3 = AppCompatEmojiTextHelper + 117;
            I = i3 % 128;
            if ((i3 % 2 != 0 ? 'R' : 'V') != 'V') {
                int i4 = 38 / 0;
                return ptrClassicFrameLayout;
            }
            return ptrClassicFrameLayout;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void VerifyPinStateManager$executeRiskChallenge$2$1(MyBusinessFragment myBusinessFragment) {
        try {
            int i = I + 101;
            try {
                AppCompatEmojiTextHelper = i % 128;
                int i2 = i % 2;
                myBusinessFragment.A();
                int i3 = AppCompatEmojiTextHelper + 89;
                I = i3 % 128;
                if (i3 % 2 == 0) {
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

    public static final /* synthetic */ boolean VerifyPinStateManager$executeRiskChallenge$2$2(MyBusinessFragment myBusinessFragment) {
        int i = I + 91;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        try {
            boolean z = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = AppCompatEmojiTextHelper + 93;
            I = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 63 / 0;
                return z;
            }
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(MyBusinessFragment myBusinessFragment, DanaLoadingDialog danaLoadingDialog) {
        int i = AppCompatEmojiTextHelper + 95;
        I = i % 128;
        if (!(i % 2 == 0)) {
            myBusinessFragment.lookAheadTest = danaLoadingDialog;
            Object obj = null;
            obj.hashCode();
        } else {
            myBusinessFragment.lookAheadTest = danaLoadingDialog;
        }
        int i2 = I + 13;
        AppCompatEmojiTextHelper = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void getAuthRequestContext(MyBusinessFragment myBusinessFragment, KybCompressQrConfig kybCompressQrConfig) {
        int i = AppCompatEmojiTextHelper + 9;
        I = i % 128;
        boolean z = i % 2 != 0;
        myBusinessFragment.DatabaseTableConfigUtil = kybCompressQrConfig;
        if (!z) {
            return;
        }
        int i2 = 4 / 0;
    }

    public static final /* synthetic */ FragmentPermissionRequest getCallingPid(MyBusinessFragment myBusinessFragment) {
        int i = I + 29;
        AppCompatEmojiTextHelper = i % 128;
        char c = i % 2 == 0 ? 'P' : '5';
        Object[] objArr = null;
        FragmentPermissionRequest fragmentPermissionRequest = myBusinessFragment.A;
        if (c != '5') {
            objArr.hashCode();
        }
        int i2 = I + 107;
        AppCompatEmojiTextHelper = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int length = objArr.length;
            return fragmentPermissionRequest;
        }
        return fragmentPermissionRequest;
    }

    public static final /* synthetic */ void getNameOrBuilderList(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 115;
            try {
                I = i % 128;
                int i2 = i % 2;
                myBusinessFragment.SummaryVoucherView$$ExternalSyntheticLambda2();
                int i3 = AppCompatEmojiTextHelper + 39;
                I = i3 % 128;
                if ((i3 % 2 != 0 ? '#' : 'X') != '#') {
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

    public static final /* synthetic */ void getOnBoardingScenario(MyBusinessFragment myBusinessFragment) {
        int i = I + 37;
        AppCompatEmojiTextHelper = i % 128;
        char c = i % 2 == 0 ? (char) 15 : '=';
        myBusinessFragment.M();
        if (c == 15) {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = I + 55;
            try {
                AppCompatEmojiTextHelper = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ boolean getSupportButtonTintMode(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 117;
            try {
                I = i % 128;
                boolean z = i % 2 == 0;
                boolean z2 = myBusinessFragment.getValueOfTouchPositionAbsolute;
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                return z2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void getValueOfTouchPositionAbsolute(MyBusinessFragment myBusinessFragment) {
        try {
            int i = I + 49;
            AppCompatEmojiTextHelper = i % 128;
            char c = i % 2 == 0 ? (char) 1 : '\n';
            myBusinessFragment.H();
            if (c != '\n') {
                Object obj = null;
                obj.hashCode();
            }
            int i2 = I + 65;
            AppCompatEmojiTextHelper = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ MyBusinessFragment$createKybOpenH5Listener$1 initRecordTimeStamp(MyBusinessFragment myBusinessFragment) {
        try {
            int i = AppCompatEmojiTextHelper + 49;
            I = i % 128;
            char c = i % 2 != 0 ? 'D' : (char) 24;
            Object obj = null;
            MyBusinessFragment$createKybOpenH5Listener$1 NetworkUserEntityData$$ExternalSyntheticLambda1 = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda1();
            if (c == 'D') {
                obj.hashCode();
            }
            int i2 = I + 37;
            AppCompatEmojiTextHelper = i2 % 128;
            if ((i2 % 2 == 0 ? '5' : '%') != '%') {
                obj.hashCode();
                return NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ KybQrisModel isLayoutRequested(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 103;
        I = i % 128;
        if ((i % 2 != 0 ? 'S' : '\n') != '\n') {
            int i2 = 46 / 0;
            return myBusinessFragment.GetContactSyncConfig;
        }
        return myBusinessFragment.GetContactSyncConfig;
    }

    public static final /* synthetic */ DanaLoadingDialog newProxyInstance(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 123;
        I = i % 128;
        int i2 = i % 2;
        try {
            DanaLoadingDialog danaLoadingDialog = myBusinessFragment.lookAheadTest;
            int i3 = AppCompatEmojiTextHelper + 85;
            I = i3 % 128;
            if ((i3 % 2 != 0 ? '-' : '.') != '-') {
                return danaLoadingDialog;
            }
            int i4 = 90 / 0;
            return danaLoadingDialog;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ MyBusinessHeaderView readMicros(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 73;
        I = i % 128;
        int i2 = i % 2;
        MyBusinessHeaderView myBusinessHeaderView = myBusinessFragment.SubSequence;
        try {
            int i3 = AppCompatEmojiTextHelper + 45;
            I = i3 % 128;
            if ((i3 % 2 != 0 ? '\r' : Typography.quote) != '\"') {
                Object obj = null;
                obj.hashCode();
                return myBusinessHeaderView;
            }
            return myBusinessHeaderView;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ NewBannerView whenAvailable(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 67;
        I = i % 128;
        int i2 = i % 2;
        NewBannerView newBannerView = myBusinessFragment.whenAvailable;
        try {
            int i3 = I + 109;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
            return newBannerView;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getPresenter")
    public final Lazy<KybContract.Presenter> PlaceComponentResult() {
        try {
            int i = AppCompatEmojiTextHelper + 103;
            I = i % 128;
            int i2 = i % 2;
            Lazy<KybContract.Presenter> lazy = this.presenter;
            Object[] objArr = null;
            if (lazy != null) {
                try {
                    int i3 = I + 103;
                    AppCompatEmojiTextHelper = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        int length = objArr.length;
                    }
                    return lazy;
                } catch (Exception e) {
                    throw e;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i4 = AppCompatEmojiTextHelper + 95;
            I = i4 % 128;
            if ((i4 % 2 != 0 ? 'C' : '*') != 'C') {
                return null;
            }
            int length2 = objArr.length;
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0014, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x001a, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x001c, code lost:
    
        r2 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 123;
        id.dana.kyb.view.MyBusinessFragment.I = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0028, code lost:
    
        if ((r2 % 2) == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x002a, code lost:
    
        r2 = '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x002d, code lost:
    
        r2 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x002f, code lost:
    
        if (r2 == '7') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0031, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0032, code lost:
    
        r1 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0033, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0036, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003b, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getReadLinkPropertiesPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private dagger.Lazy<id.dana.contract.deeplink.ReadLinkPropertiesPresenter> a() {
        /*
            r4 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            r1 = 0
            if (r0 == 0) goto L17
            dagger.Lazy<id.dana.contract.deeplink.ReadLinkPropertiesPresenter> r0 = r4.readLinkPropertiesPresenter
            if (r0 == 0) goto L36
            goto L1c
        L17:
            dagger.Lazy<id.dana.contract.deeplink.ReadLinkPropertiesPresenter> r0 = r4.readLinkPropertiesPresenter
            int r2 = r1.length     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L36
        L1c:
            int r2 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r2 = r2 + 123
            int r3 = r2 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r3
            int r2 = r2 % 2
            r3 = 55
            if (r2 == 0) goto L2d
            r2 = 55
            goto L2f
        L2d:
            r2 = 87
        L2f:
            if (r2 == r3) goto L32
            return r0
        L32:
            int r1 = r1.length     // Catch: java.lang.Throwable -> L34
            return r0
        L34:
            r0 = move-exception
            throw r0
        L36:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        L3c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.a():dagger.Lazy");
    }

    @JvmName(name = "getSwitchFaceAuthPresenter")
    public final Lazy<SwitchFaceAuthContract.Presenter> MyBillsEntityDataFactory() {
        int i = AppCompatEmojiTextHelper + 55;
        I = i % 128;
        int i2 = i % 2;
        Lazy<SwitchFaceAuthContract.Presenter> lazy = this.switchFaceAuthPresenter;
        Object[] objArr = null;
        if (!(lazy != null)) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = AppCompatEmojiTextHelper + 91;
        I = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int length = objArr.length;
            return lazy;
        }
        return lazy;
    }

    @JvmName(name = "getTncSummaryPresenter")
    private Lazy<TncSummaryContract.Presenter> QrExpiredActivity() {
        int i = I + 57;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        Lazy<TncSummaryContract.Presenter> lazy = this.tncSummaryPresenter;
        Object[] objArr = null;
        if (lazy != null) {
            int i3 = I + 59;
            AppCompatEmojiTextHelper = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int length = objArr.length;
            }
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i4 = I + 1;
        AppCompatEmojiTextHelper = i4 % 128;
        if ((i4 % 2 == 0 ? 'L' : (char) 18) != 18) {
            int i5 = 85 / 0;
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0023, code lost:
    
        if (r0 != null) goto L44;
     */
    @kotlin.jvm.JvmName(name = "getRejectReasonAdapter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.kyb.adapter.KybRejectReasonAdapter> KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r4 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            if (r0 == 0) goto Le
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            r1 = 0
            if (r0 == 0) goto L20
            dagger.Lazy<id.dana.kyb.adapter.KybRejectReasonAdapter> r0 = r4.rejectReasonAdapter     // Catch: java.lang.Exception -> L38
            r2 = 25
            if (r0 == 0) goto L1b
            r3 = 25
            goto L1d
        L1b:
            r3 = 68
        L1d:
            if (r3 == r2) goto L25
            goto L26
        L20:
            dagger.Lazy<id.dana.kyb.adapter.KybRejectReasonAdapter> r0 = r4.rejectReasonAdapter     // Catch: java.lang.Exception -> L38
            int r2 = r1.length     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L26
        L25:
            return r0
        L26:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 101
            int r2 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r2
            int r0 = r0 % 2
            return r1
        L36:
            r0 = move-exception
            throw r0
        L38:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2():dagger.Lazy");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0022, code lost:
    
        if ((r0 == null) != true) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0034, code lost:
    
        if ((r0 != null ? '\r' : 20) != '\r') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0036, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 47;
        id.dana.kyb.view.MyBusinessFragment.I = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0045, code lost:
    
        if ((r0 % 2) == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0047, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0048, code lost:
    
        if (r2 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004a, code lost:
    
        r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x004d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0050, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0051, code lost:
    
        r1 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 93;
        id.dana.kyb.view.MyBusinessFragment.I = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005b, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getDynamicUrlWrapper")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.data.dynamicurl.DynamicUrlWrapper> getAuthRequestContext() {
        /*
            r6 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I     // Catch: java.lang.Exception -> L5c
            int r0 = r0 + 3
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            r1 = 33
            if (r0 != 0) goto L11
            r0 = 67
            goto L13
        L11:
            r0 = 33
        L13:
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L29
            dagger.Lazy<id.dana.data.dynamicurl.DynamicUrlWrapper> r0 = r6.dynamicUrlWrapper     // Catch: java.lang.Exception -> L27
            r4.hashCode()     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L21
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 == r3) goto L36
            goto L51
        L25:
            r0 = move-exception
            throw r0
        L27:
            r0 = move-exception
            throw r0
        L29:
            dagger.Lazy<id.dana.data.dynamicurl.DynamicUrlWrapper> r0 = r6.dynamicUrlWrapper
            r1 = 13
            if (r0 == 0) goto L32
            r5 = 13
            goto L34
        L32:
            r5 = 20
        L34:
            if (r5 == r1) goto L51
        L36:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L48
            r2 = 1
        L48:
            if (r2 == 0) goto L50
            r4.hashCode()     // Catch: java.lang.Throwable -> L4e
            return r4
        L4e:
            r0 = move-exception
            throw r0
        L50:
            return r4
        L51:
            int r1 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r1 = r1 + 93
            int r2 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r2
            int r1 = r1 % 2
            return r0
        L5c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.getAuthRequestContext():dagger.Lazy");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0019, code lost:
    
        if (r4.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0026, code lost:
    
        if ((r4.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) != true) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0028, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0029, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.I + 15;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0033, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean AppCompatEmojiTextHelper() {
        /*
            r4 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r1 = 60
            if (r0 == 0) goto L11
            r0 = 60
            goto L13
        L11:
            r0 = 75
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1c
            com.airbnb.lottie.LottieAnimationView r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda3
            if (r0 == 0) goto L28
            goto L29
        L1c:
            com.airbnb.lottie.LottieAnimationView r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda3
            r1 = 90
            int r1 = r1 / r3
            if (r0 == 0) goto L25
            r0 = 1
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 == r2) goto L29
        L28:
            r2 = 0
        L29:
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 15
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            return r2
        L34:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper():boolean");
    }

    @JvmName(name = "getWithdrawBalanceFaceAuthActivationBottomSheet")
    private final WithdrawBalanceFaceAuthActivationBottomSheet VerifyPinStateManager$executeRiskChallenge$2$1() {
        int i = AppCompatEmojiTextHelper + 105;
        I = i % 128;
        int i2 = i % 2;
        try {
            WithdrawBalanceFaceAuthActivationBottomSheet withdrawBalanceFaceAuthActivationBottomSheet = (WithdrawBalanceFaceAuthActivationBottomSheet) this.H.getValue();
            int i3 = I + 47;
            try {
                AppCompatEmojiTextHelper = i3 % 128;
                int i4 = i3 % 2;
                return withdrawBalanceFaceAuthActivationBottomSheet;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getKybServiceListener")
    private final MyBusinessFragment$kybServiceListener$2.AnonymousClass1 FragmentBottomSheetPaymentSettingBinding() {
        int i = I + 95;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        try {
            MyBusinessFragment$kybServiceListener$2.AnonymousClass1 anonymousClass1 = (MyBusinessFragment$kybServiceListener$2.AnonymousClass1) this.newProxyInstance.getValue();
            int i3 = AppCompatEmojiTextHelper + 17;
            I = i3 % 128;
            int i4 = i3 % 2;
            return anonymousClass1;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void isAuto() {
        try {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_FACE_ENROLL_CLICK;
            builder.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
            int i = I + 125;
            AppCompatEmojiTextHelper = i % 128;
            if ((i % 2 == 0 ? 'P' : '=') != 'P') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getKycInProgressBottomSheet")
    private final KycInProgressBottomSheet NetworkUserEntityData$$ExternalSyntheticLambda3() {
        KycInProgressBottomSheet kycInProgressBottomSheet;
        try {
            int i = I + 115;
            AppCompatEmojiTextHelper = i % 128;
            if ((i % 2 == 0 ? 'J' : (char) 29) != 'J') {
                kycInProgressBottomSheet = (KycInProgressBottomSheet) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue();
            } else {
                try {
                    kycInProgressBottomSheet = (KycInProgressBottomSheet) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue();
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = AppCompatEmojiTextHelper + 119;
            I = i2 % 128;
            if (!(i2 % 2 == 0)) {
                int i3 = 43 / 0;
                return kycInProgressBottomSheet;
            }
            return kycInProgressBottomSheet;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getKybWithdrawDestinationBottomSheet")
    private final KybWithdrawDestinationBottomSheet NetworkUserEntityData$$ExternalSyntheticLambda4() {
        int i = AppCompatEmojiTextHelper + 53;
        I = i % 128;
        if ((i % 2 != 0 ? '(' : 'B') != '(') {
            return (KybWithdrawDestinationBottomSheet) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
        }
        KybWithdrawDestinationBottomSheet kybWithdrawDestinationBottomSheet = (KybWithdrawDestinationBottomSheet) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
        Object[] objArr = null;
        int length = objArr.length;
        return kybWithdrawDestinationBottomSheet;
    }

    private final void b() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_SETTINGS_CLICK;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        int i = AppCompatEmojiTextHelper + 123;
        I = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        try {
            int i = AppCompatEmojiTextHelper + 121;
            try {
                I = i % 128;
                int i2 = i % 2;
                D();
                getValueOfTouchPositionAbsolute();
                VerifyPinStateManager$executeRiskChallenge$2$2();
                F();
                BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext);
                registerPresenter(PlaceComponentResult().get(), a().get(), MyBillsEntityDataFactory().get());
                int i3 = AppCompatEmojiTextHelper + 43;
                I = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void getAuthRequestContext(MyProfileMainFragment.SettingsListener settingsListener) {
        int i = I + 7;
        AppCompatEmojiTextHelper = i % 128;
        if ((i % 2 == 0 ? '\r' : '0') != '\r') {
            Intrinsics.checkNotNullParameter(settingsListener, "");
            this.C = settingsListener;
            return;
        }
        Intrinsics.checkNotNullParameter(settingsListener, "");
        this.C = settingsListener;
        Object obj = null;
        obj.hashCode();
    }

    private final void D() {
        Parcelable parcelable;
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = AppCompatEmojiTextHelper + 69;
            I = i % 128;
            int i2 = i % 2;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable("KYB_PAGE_INFO", KybPageInfo.class);
            } else {
                try {
                    Parcelable parcelable2 = arguments.getParcelable("KYB_PAGE_INFO");
                    try {
                        if ((!(parcelable2 instanceof KybPageInfo) ? 'J' : (char) 25) != 25) {
                            int i3 = AppCompatEmojiTextHelper + 67;
                            I = i3 % 128;
                            if (!(i3 % 2 == 0)) {
                                int i4 = 19 / 0;
                            }
                            parcelable2 = null;
                        }
                        parcelable = (KybPageInfo) parcelable2;
                        int i5 = I + 89;
                        AppCompatEmojiTextHelper = i5 % 128;
                        int i6 = i5 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            KybPageInfo kybPageInfo = (KybPageInfo) parcelable;
            if (kybPageInfo == null) {
                kybPageInfo = new KybPageInfo(false, false, null, false, 15, null);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = kybPageInfo;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r5, int resultCode, Intent data) {
        ChallengeControl challengeControl = this.moveToNextValue;
        if ((challengeControl != null ? '=' : (char) 16) != 16) {
            try {
                int i = I + 5;
                AppCompatEmojiTextHelper = i % 128;
                int i2 = i % 2;
                Object obj = null;
                if (challengeControl == null) {
                    int i3 = AppCompatEmojiTextHelper + 33;
                    I = i3 % 128;
                    boolean z = i3 % 2 == 0;
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    if (!z) {
                        obj.hashCode();
                    }
                    int i4 = AppCompatEmojiTextHelper + 39;
                    I = i4 % 128;
                    int i5 = i4 % 2;
                    challengeControl = null;
                }
                if (challengeControl.MyBillsEntityDataFactory(r5, resultCode, data)) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        super.onActivityResult(r5, resultCode, data);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        int i = I + 9;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(view, "");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.view_kyb_shimmer);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.G = (ConstraintLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.my_business_header);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        this.SubSequence = (MyBusinessHeaderView) findViewById2;
        View findViewById3 = view.findViewById(R.id.iv_bg_kyb_unregistered);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        this.scheduleImpl = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.my_business_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "");
        this.FragmentBottomSheetPaymentSettingBinding = findViewById4;
        View findViewById5 = view.findViewById(R.id.ptr_kyb);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "");
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = (PtrClassicFrameLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.nsv_mybusiness);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "");
        this.getSupportButtonTintMode = (NestedScrollView) findViewById6;
        V();
        E();
        int i3 = AppCompatEmojiTextHelper + 111;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void F() {
        int i = AppCompatEmojiTextHelper + 91;
        I = i % 128;
        int i2 = i % 2;
        MyProfileMainFragment.SettingsListener settingsListener = this.C;
        if (settingsListener != null) {
            settingsListener.PlaceComponentResult(new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$initSettingsClickListener$1
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
                    MyBusinessFragment.Q(MyBusinessFragment.this);
                    MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_SETTINGS));
                }
            });
        }
        int i3 = I + 63;
        AppCompatEmojiTextHelper = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void V() {
        int i = I + 79;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        ViewSkeletonScreen viewSkeletonScreen = this.E;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.MyBillsEntityDataFactory();
            return;
        }
        ConstraintLayout constraintLayout = this.G;
        Object[] objArr = null;
        if (constraintLayout == null) {
            int i3 = I + 27;
            AppCompatEmojiTextHelper = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int length = objArr.length;
            }
            constraintLayout = null;
        }
        ViewSkeletonScreen PlaceComponentResult2 = ShimmeringUtil.PlaceComponentResult(constraintLayout, R.layout.view_kyb_shimmer);
        this.E = PlaceComponentResult2;
        PlaceComponentResult2.MyBillsEntityDataFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View] */
    private final void C() {
        int i = AppCompatEmojiTextHelper + 119;
        I = i % 128;
        int i2 = i % 2;
        ViewSkeletonScreen viewSkeletonScreen = this.E;
        ?? r3 = 0;
        if (!(viewSkeletonScreen == null)) {
            int i3 = I + 125;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
            viewSkeletonScreen.PlaceComponentResult();
            if (i4 == 0) {
                int length = r3.length;
            }
        }
        ConstraintLayout constraintLayout = this.G;
        if ((constraintLayout == null ? '\b' : 'X') != 'X') {
            int i5 = AppCompatEmojiTextHelper + 5;
            I = i5 % 128;
            if (i5 % 2 != 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i6 = 2 / 0;
            } else {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } catch (Exception e) {
                    throw e;
                }
            }
            int i7 = I + 85;
            AppCompatEmojiTextHelper = i7 % 128;
            int i8 = i7 % 2;
        } else {
            r3 = constraintLayout;
        }
        r3.setVisibility(8);
    }

    private final void E() {
        NestedScrollView nestedScrollView = this.getSupportButtonTintMode;
        PtrClassicFrameLayout ptrClassicFrameLayout = null;
        if ((nestedScrollView == null ? 'J' : 'T') != 'T') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nestedScrollView = null;
        }
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda9
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void getAuthRequestContext(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
                MyBusinessFragment.PlaceComponentResult(MyBusinessFragment.this, i2);
            }
        });
        PtrClassicFrameLayout ptrClassicFrameLayout2 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (ptrClassicFrameLayout2 == null) {
            try {
                int i = AppCompatEmojiTextHelper + 55;
                I = i % 128;
                int i2 = i % 2;
                Intrinsics.throwUninitializedPropertyAccessException("");
                ptrClassicFrameLayout2 = null;
            } catch (Exception e) {
                throw e;
            }
        }
        ptrClassicFrameLayout2.addPtrUIHandler(getSupportButtonTintMode());
        PtrClassicFrameLayout ptrClassicFrameLayout3 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (!(ptrClassicFrameLayout3 != null)) {
            int i3 = AppCompatEmojiTextHelper + 9;
            I = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout3 = null;
        }
        ptrClassicFrameLayout3.setPtrHandler(whenAvailable());
        PtrClassicFrameLayout ptrClassicFrameLayout4 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if ((ptrClassicFrameLayout4 == null ? ')' : (char) 22) != 22) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            ptrClassicFrameLayout = ptrClassicFrameLayout4;
        }
        ptrClassicFrameLayout.disableWhenHorizontalMove(true);
        getOnBoardingScenario();
    }

    private static final void getAuthRequestContext(MyBusinessFragment myBusinessFragment, int i) {
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        PtrClassicFrameLayout ptrClassicFrameLayout = myBusinessFragment.BottomSheetCardBindingView$watcherCardNumberView$1;
        if ((ptrClassicFrameLayout == null ? 'A' : 'L') == 'A') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout = null;
            int i2 = AppCompatEmojiTextHelper + 47;
            I = i2 % 128;
            int i3 = i2 % 2;
        }
        try {
            ptrClassicFrameLayout.setEnabled(i == 0);
            int i4 = AppCompatEmojiTextHelper + 59;
            I = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void getOnBoardingScenario() {
        int i = AppCompatEmojiTextHelper + 111;
        I = i % 128;
        int i2 = i % 2;
        PtrClassicFrameLayout ptrClassicFrameLayout = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        Object obj = null;
        if (!(ptrClassicFrameLayout != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout = null;
        }
        ptrClassicFrameLayout.setHeaderView(getLayoutInflater().inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        PtrClassicFrameLayout ptrClassicFrameLayout2 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (!(ptrClassicFrameLayout2 != null)) {
            int i3 = AppCompatEmojiTextHelper + 67;
            I = i3 % 128;
            boolean z = i3 % 2 != 0;
            Intrinsics.throwUninitializedPropertyAccessException("");
            if (z) {
                obj.hashCode();
            }
            int i4 = AppCompatEmojiTextHelper + 89;
            I = i4 % 128;
            int i5 = i4 % 2;
            ptrClassicFrameLayout2 = null;
        }
        View findViewById = ptrClassicFrameLayout2.getHeaderView().findViewById(R.id.lav_loading_animation);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = lottieAnimationView;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lottieAnimationView = null;
        }
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.kyb.view.MyBusinessFragment$initPullToRefreshHeaderView$1
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PtrClassicFrameLayout SubSequence = MyBusinessFragment.SubSequence(MyBusinessFragment.this);
                if (SubSequence == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    SubSequence = null;
                }
                MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
                SubSequence.refreshComplete();
                MyBusinessFragment.I(myBusinessFragment);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (MyBusinessFragment.getSupportButtonTintMode(MyBusinessFragment.this) && MyBusinessFragment.C(MyBusinessFragment.this)) {
                    LottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda4 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(MyBusinessFragment.this);
                    if (NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda4.cancelAnimation();
                }
            }
        });
        int i6 = I + 107;
        AppCompatEmojiTextHelper = i6 % 128;
        if (!(i6 % 2 != 0)) {
            obj.hashCode();
        }
    }

    private final void flip() {
        int i = I + 11;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        try {
            this.getValueOfTouchPositionAbsolute = true;
            int i3 = AppCompatEmojiTextHelper + 75;
            I = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 19 : '_') != 19) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        this.isLayoutRequested = Calendar.getInstance().getTime();
        X();
        KybContract.Presenter presenter = PlaceComponentResult().get();
        presenter.MyBillsEntityDataFactory(this.getCallingPid);
        if (this.DatabaseTableConfigUtil == null) {
            int i = I + 53;
            AppCompatEmojiTextHelper = i % 128;
            int i2 = i % 2;
            presenter.KClassImpl$Data$declaredNonStaticMembers$2();
            int i3 = I + 3;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
        }
        try {
            presenter.moveToNextValue();
            try {
                if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda2 != null)) {
                    return;
                }
                int i5 = I + 25;
                AppCompatEmojiTextHelper = i5 % 128;
                if ((i5 % 2 == 0 ? (char) 27 : 'b') == 'b') {
                    getErrorConfigVersion();
                    return;
                }
                getErrorConfigVersion();
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0016, code lost:
    
        if (r3 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0027, code lost:
    
        if ((r3 ? '5' : 'P') != 'P') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0029, code lost:
    
        BuiltInFictitiousFunctionClassFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002c, code lost:
    
        r3 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 31;
        id.dana.kyb.view.MyBusinessFragment.I = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0036, code lost:
    
        return;
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setMenuVisibility(boolean r3) {
        /*
            r2 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I     // Catch: java.lang.Exception -> L39
            int r0 = r0 + 19
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1     // Catch: java.lang.Exception -> L37
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L1b
            super.setMenuVisibility(r3)
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L19
            if (r3 == 0) goto L2c
            goto L29
        L19:
            r3 = move-exception
            throw r3
        L1b:
            super.setMenuVisibility(r3)
            r0 = 80
            if (r3 == 0) goto L25
            r3 = 53
            goto L27
        L25:
            r3 = 80
        L27:
            if (r3 == r0) goto L2c
        L29:
            r2.BuiltInFictitiousFunctionClassFactory()
        L2c:
            int r3 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper     // Catch: java.lang.Exception -> L39
            int r3 = r3 + 31
            int r0 = r3 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r0     // Catch: java.lang.Exception -> L39
            int r3 = r3 % 2
            return
        L37:
            r3 = move-exception
            throw r3
        L39:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.setMenuVisibility(boolean):void");
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        int i = AppCompatEmojiTextHelper + 99;
        I = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            super.onDestroyView();
            this.isLayoutRequested = null;
            d();
            obj.hashCode();
            return;
        }
        super.onDestroyView();
        this.isLayoutRequested = null;
        d();
    }

    private final void getValueOfTouchPositionAbsolute() {
        DaggerKybComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerKybComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (KybModule) Preconditions.getAuthRequestContext(isLayoutRequested());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = requireActivity();
        byte b = 0;
        Object[] objArr = new Object[1];
        e(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 25302, new char[]{59515, 35480, 11760, 49185, 25365, 1634, 47283, 23432}, objArr);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = ((String) objArr[0]).intern();
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = requireActivity();
        BuiltInFictitiousFunctionClassFactory.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = requireActivity();
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = requireActivity();
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = requireActivity();
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = (SwitchFaceAuthenticationModule) Preconditions.getAuthRequestContext(getCallingPid());
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (FaceAuthenticationModule) Preconditions.getAuthRequestContext(new FaceAuthenticationModule());
        BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = (TncSummaryModules) Preconditions.getAuthRequestContext(SubSequence());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, KybModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.lookAheadTest, SwitchFaceAuthenticationModule.class);
        if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult == null) {
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = new FaceAuthenticationModule();
            int i = AppCompatEmojiTextHelper + 75;
            I = i % 128;
            int i2 = i % 2;
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.scheduleImpl, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, OauthModule.class);
        if (BuiltInFictitiousFunctionClassFactory.moveToNextValue == null) {
            BuiltInFictitiousFunctionClassFactory.moveToNextValue = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp, TncSummaryModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerKybComponent.KybComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.lookAheadTest, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.scheduleImpl, BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, BuiltInFictitiousFunctionClassFactory.moveToNextValue, BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    private final KybModule isLayoutRequested() {
        KybModule kybModule = new KybModule(new KybContract.View() { // from class: id.dana.kyb.view.MyBusinessFragment$getKybModule$1
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

            @Override // id.dana.kyb.KybContract.View
            public final void MyBillsEntityDataFactory(int p0, KybCompleteInfoModel p1) {
                MyBusinessFragment.A(MyBusinessFragment.this);
                MyBusinessFragment.J(MyBusinessFragment.this);
                MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment.this, p1);
                if (MyBusinessFragment.B(MyBusinessFragment.this) != p0) {
                    MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment.this, p0);
                    MyBusinessHeaderView readMicros = MyBusinessFragment.readMicros(MyBusinessFragment.this);
                    if (readMicros == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        readMicros = null;
                    }
                    readMicros.setVariant(p0);
                    MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, p0);
                    MyBusinessFragment.MyBillsEntityDataFactory(MyBusinessFragment.this, p0);
                }
                MyBusinessFragment.DatabaseTableConfigUtil(MyBusinessFragment.this);
                MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(MyBusinessFragment.this);
                MyBusinessFragment.MyBillsEntityDataFactory(MyBusinessFragment.this, p1);
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, p1);
                if (p0 != 1) {
                    MyBusinessFragment.P(MyBusinessFragment.this);
                }
            }

            @Override // id.dana.kyb.KybContract.View
            public final void PlaceComponentResult(List<KybServiceModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (MyBusinessFragment.B(MyBusinessFragment.this) == 1) {
                    MyBusinessBalanceView FragmentBottomSheetPaymentSettingBinding = MyBusinessFragment.FragmentBottomSheetPaymentSettingBinding(MyBusinessFragment.this);
                    if (FragmentBottomSheetPaymentSettingBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        FragmentBottomSheetPaymentSettingBinding = null;
                    }
                    final MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
                    FragmentBottomSheetPaymentSettingBinding.bindTopService(p0);
                    FragmentBottomSheetPaymentSettingBinding.setKybServiceClickListener(new Function1<KybServiceModel, Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$getKybModule$1$showTopServices$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(KybServiceModel kybServiceModel) {
                            invoke2(kybServiceModel);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(KybServiceModel kybServiceModel) {
                            Intrinsics.checkNotNullParameter(kybServiceModel, "");
                            MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, kybServiceModel);
                        }
                    });
                }
            }

            @Override // id.dana.kyb.KybContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                if (MyBusinessFragment.B(MyBusinessFragment.this) == 1) {
                    KybTransactionHistoryView NetworkUserEntityData$$ExternalSyntheticLambda3 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(MyBusinessFragment.this);
                    KybServiceView kybServiceView = null;
                    if (NetworkUserEntityData$$ExternalSyntheticLambda3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda3.showSkeleton();
                    MyBusinessFragment.this.PlaceComponentResult().get().KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    NewBannerView whenAvailable = MyBusinessFragment.whenAvailable(MyBusinessFragment.this);
                    if (whenAvailable == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        whenAvailable = null;
                    }
                    whenAvailable.showSkeleton();
                    MyBusinessFragment.this.PlaceComponentResult().get().PlaceComponentResult(p0);
                    KybServiceView NetworkUserEntityData$$ExternalSyntheticLambda5 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(MyBusinessFragment.this);
                    if (NetworkUserEntityData$$ExternalSyntheticLambda5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        kybServiceView = NetworkUserEntityData$$ExternalSyntheticLambda5;
                    }
                    kybServiceView.showSkeleton();
                    MyBusinessFragment.this.PlaceComponentResult().get().BuiltInFictitiousFunctionClassFactory();
                }
            }

            @Override // id.dana.kyb.KybContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                MyBusinessFragment.G(MyBusinessFragment.this);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void moveToNextValue() {
                if (MyBusinessFragment.B(MyBusinessFragment.this) == 1) {
                    MyBusinessFragment.this.PlaceComponentResult().get().NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
            }

            @Override // id.dana.kyb.KybContract.View
            public final void PlaceComponentResult(KybMerchantInfoModel p0, TransactionListQueryModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
                KybCompleteInfoModel PrepareContext = MyBusinessFragment.PrepareContext(myBusinessFragment);
                MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(myBusinessFragment, PrepareContext != null ? KybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory(PrepareContext, p0) : null);
                MyBusinessFragment myBusinessFragment2 = MyBusinessFragment.this;
                MyBusinessFragment.MyBillsEntityDataFactory(myBusinessFragment2, MyBusinessFragment.PrepareContext(myBusinessFragment2));
                MyBusinessFragment myBusinessFragment3 = MyBusinessFragment.this;
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(myBusinessFragment3, MyBusinessFragment.PrepareContext(myBusinessFragment3));
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, p1);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void MyBillsEntityDataFactory(KybCompressQrConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBusinessFragment.getAuthRequestContext(MyBusinessFragment.this, p0);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void getAuthRequestContext(List<String> p0) {
                if (MyBusinessFragment.B(MyBusinessFragment.this) == 5) {
                    MyBusinessFragment.this.KClassImpl$Data$declaredNonStaticMembers$2().get().setItems(p0);
                }
            }

            @Override // id.dana.kyb.KybContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (MyBusinessFragment.B(MyBusinessFragment.this) == 1) {
                    MyBusinessHeaderView readMicros = MyBusinessFragment.readMicros(MyBusinessFragment.this);
                    if (readMicros == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        readMicros = null;
                    }
                    readMicros.setBadge(p0);
                }
            }

            @Override // id.dana.kyb.KybContract.View
            public final void MyBillsEntityDataFactory(TransactionListQueryModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, p0);
                MyBusinessFragment.P(MyBusinessFragment.this);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void BuiltInFictitiousFunctionClassFactory(PromotionModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                NewBannerView whenAvailable = MyBusinessFragment.whenAvailable(MyBusinessFragment.this);
                NewBannerView newBannerView = null;
                if (whenAvailable == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    whenAvailable = null;
                }
                whenAvailable.hideSkeleton();
                NewBannerView whenAvailable2 = MyBusinessFragment.whenAvailable(MyBusinessFragment.this);
                if (whenAvailable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    newBannerView = whenAvailable2;
                }
                MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
                NewBannerView newBannerView2 = newBannerView;
                List<CdpContentModel> list = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                newBannerView2.setVisibility((list == null || list.isEmpty()) ^ true ? 0 : 8);
                if (newBannerView2.getVisibility() == 0) {
                    String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (str != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        newBannerView.setPromotionModel(p0);
                    }
                    List<CdpContentModel> list2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullExpressionValue(list2, "");
                    newBannerView.setContents(list2);
                    newBannerView.setNestedScroll(true);
                    newBannerView.setKybBannerType(MyBusinessFragment.initRecordTimeStamp(myBusinessFragment));
                }
                newBannerView.display();
            }

            @Override // id.dana.kyb.KybContract.View
            public final void scheduleImpl() {
                KybMerchantInfoModel kybMerchantInfoModel;
                KybMerchantInfoModel kybMerchantInfoModel2;
                KybMerchantInfoModel kybMerchantInfoModel3;
                MerchantContractInfoModel merchantContractInfoModel;
                KybMerchantInfoModel kybMerchantInfoModel4;
                MerchantContractInfoModel merchantContractInfoModel2;
                MyBusinessFragment myBusinessFragment = MyBusinessFragment.this;
                TagFormat MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory(KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_REQUEST_PAYMENT));
                KybCompleteInfoModel PrepareContext = MyBusinessFragment.PrepareContext(MyBusinessFragment.this);
                String str = null;
                TagFormat PlaceComponentResult2 = MyBillsEntityDataFactory.PlaceComponentResult("status", (PrepareContext == null || (kybMerchantInfoModel4 = PrepareContext.BuiltInFictitiousFunctionClassFactory) == null || (merchantContractInfoModel2 = kybMerchantInfoModel4.NetworkUserEntityData$$ExternalSyntheticLambda7) == null) ? null : merchantContractInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2);
                KybCompleteInfoModel PrepareContext2 = MyBusinessFragment.PrepareContext(MyBusinessFragment.this);
                TagFormat PlaceComponentResult3 = PlaceComponentResult2.PlaceComponentResult("productCode", (PrepareContext2 == null || (kybMerchantInfoModel3 = PrepareContext2.BuiltInFictitiousFunctionClassFactory) == null || (merchantContractInfoModel = kybMerchantInfoModel3.NetworkUserEntityData$$ExternalSyntheticLambda7) == null) ? null : merchantContractInfoModel.getAuthRequestContext);
                KybCompleteInfoModel PrepareContext3 = MyBusinessFragment.PrepareContext(MyBusinessFragment.this);
                TagFormat PlaceComponentResult4 = PlaceComponentResult3.PlaceComponentResult("merchantId", (PrepareContext3 == null || (kybMerchantInfoModel2 = PrepareContext3.BuiltInFictitiousFunctionClassFactory) == null) ? null : kybMerchantInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                KybCompleteInfoModel PrepareContext4 = MyBusinessFragment.PrepareContext(MyBusinessFragment.this);
                if (PrepareContext4 != null && (kybMerchantInfoModel = PrepareContext4.BuiltInFictitiousFunctionClassFactory) != null) {
                    str = kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
                }
                String MyBillsEntityDataFactory2 = PlaceComponentResult4.PlaceComponentResult("businessName", str).MyBillsEntityDataFactory();
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(myBusinessFragment, MyBillsEntityDataFactory2);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void MyBillsEntityDataFactory(List<KybServiceModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                KybServiceView NetworkUserEntityData$$ExternalSyntheticLambda5 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(MyBusinessFragment.this);
                if (NetworkUserEntityData$$ExternalSyntheticLambda5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
                }
                NetworkUserEntityData$$ExternalSyntheticLambda5.bindKybServiceList(p0);
                MyBusinessFragment.GetContactSyncConfig(MyBusinessFragment.this);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void lookAheadTest() {
                KybWithdrawDestinationBottomSheet NetworkUserEntityData$$ExternalSyntheticLambda6 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda6(MyBusinessFragment.this);
                Context context = MyBusinessFragment.this.getContext();
                if (context != null) {
                    NetworkUserEntityData$$ExternalSyntheticLambda6.show(((FragmentActivity) context).getSupportFragmentManager(), "KybWithdrawDestinationBottomSheet");
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }

            @Override // id.dana.kyb.KybContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                MyBusinessFragment.MyBillsEntityDataFactory(MyBusinessFragment.this, p0);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(MyBusinessFragment.this.getContext());
                builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_WITHDRAW_DESTINATION_CLICK;
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Destination", p0);
                MyBillsEntityDataFactory.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
            }

            @Override // id.dana.kyb.KybContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBusinessBalanceView FragmentBottomSheetPaymentSettingBinding = MyBusinessFragment.FragmentBottomSheetPaymentSettingBinding(MyBusinessFragment.this);
                if (FragmentBottomSheetPaymentSettingBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    FragmentBottomSheetPaymentSettingBinding = null;
                }
                FragmentBottomSheetPaymentSettingBinding.setBalanceWithdrawClickable(true);
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, p0);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void MyBillsEntityDataFactory() {
                MyBillsEntityDataFactory(99, null);
                MyBusinessFragment.G(MyBusinessFragment.this);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void getAuthRequestContext() {
                KybTransactionHistoryView NetworkUserEntityData$$ExternalSyntheticLambda3 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(MyBusinessFragment.this);
                if (NetworkUserEntityData$$ExternalSyntheticLambda3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
                }
                NetworkUserEntityData$$ExternalSyntheticLambda3.showEmptyState();
                MyBusinessFragment.P(MyBusinessFragment.this);
                MyBusinessFragment.G(MyBusinessFragment.this);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                KybServiceView NetworkUserEntityData$$ExternalSyntheticLambda5 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(MyBusinessFragment.this);
                if (NetworkUserEntityData$$ExternalSyntheticLambda5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
                }
                NetworkUserEntityData$$ExternalSyntheticLambda5.showEmptyState();
            }

            @Override // id.dana.kyb.KybContract.View
            public final void PlaceComponentResult(KybServiceMessageModel p0) {
                MyBusinessFragment.MyBillsEntityDataFactory(MyBusinessFragment.this, p0);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void PlaceComponentResult() {
                NewBannerView whenAvailable = MyBusinessFragment.whenAvailable(MyBusinessFragment.this);
                if (whenAvailable == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    whenAvailable = null;
                }
                whenAvailable.hideSkeleton();
                whenAvailable.setVisibility(8);
            }

            @Override // id.dana.kyb.KybContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(KybUrlsConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                KybUrlsDataManager.getAuthRequestContext(p0);
            }
        });
        try {
            int i = AppCompatEmojiTextHelper + 17;
            I = i % 128;
            int i2 = i % 2;
            return kybModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final SwitchFaceAuthenticationModule getCallingPid() {
        try {
            SwitchFaceAuthenticationModule switchFaceAuthenticationModule = new SwitchFaceAuthenticationModule(new MyBusinessFragment$getSwitchFaceAuthenticationModule$1(this));
            int i = AppCompatEmojiTextHelper + 75;
            I = i % 128;
            if (!(i % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return switchFaceAuthenticationModule;
            }
            return switchFaceAuthenticationModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final TncSummaryModules SubSequence() {
        TncSummaryModules tncSummaryModules = new TncSummaryModules(new MyBusinessFragment$getTncSummaryModule$1(this));
        int i = AppCompatEmojiTextHelper + 41;
        I = i % 128;
        if (i % 2 == 0) {
            return tncSummaryModules;
        }
        int i2 = 16 / 0;
        return tncSummaryModules;
    }

    private final void MyBillsEntityDataFactory(String str) {
        KybQrisModel kybQrisModel;
        int i = AppCompatEmojiTextHelper + 67;
        I = i % 128;
        int i2 = i % 2;
        KybCompleteInfoModel kybCompleteInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (!(kybCompleteInfoModel == null)) {
            try {
                int i3 = I + 87;
                AppCompatEmojiTextHelper = i3 % 128;
                int i4 = i3 % 2;
                KybMerchantInfoModel kybMerchantInfoModel = kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory;
                if (kybMerchantInfoModel != null) {
                    kybQrisModel = kybMerchantInfoModel.lookAheadTest;
                    if (kybQrisModel != null) {
                        kybQrisModel.MyBillsEntityDataFactory = str;
                        this.GetContactSyncConfig = kybQrisModel;
                        int i5 = AppCompatEmojiTextHelper + 83;
                        I = i5 % 128;
                        int i6 = i5 % 2;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        kybQrisModel = null;
        this.GetContactSyncConfig = kybQrisModel;
        int i52 = AppCompatEmojiTextHelper + 83;
        I = i52 % 128;
        int i62 = i52 % 2;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, id.dana.dialog.TwoButtonWithImageDialog] */
    private final void U() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_faceenrol_verify;
        builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.login_face_success_title);
        builder.getErrorConfigVersion = getResources().getString(R.string.login_face_success_desc);
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = getResources().getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.PlaceComponentResult(Ref.ObjectRef.this);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        objectRef.element = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if ((twoButtonWithImageDialog != null ? '=' : 'R') != '=') {
            return;
        }
        int i = I + 65;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        twoButtonWithImageDialog.MyBillsEntityDataFactory();
        int i3 = AppCompatEmojiTextHelper + 57;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x001d, code lost:
    
        if ((r5 == null) != true) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002d, code lost:
    
        if ((r5 == null) != true) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x002f, code lost:
    
        r5.getAuthRequestContext();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void getAuthRequestContext(kotlin.jvm.internal.Ref.ObjectRef r5) {
        /*
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            java.lang.String r3 = ""
            r4 = 1
            if (r0 != 0) goto L22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            T r5 = r5.element
            id.dana.dialog.TwoButtonWithImageDialog r5 = (id.dana.dialog.TwoButtonWithImageDialog) r5
            int r0 = r2.length     // Catch: java.lang.Throwable -> L20
            if (r5 == 0) goto L1c
            goto L1d
        L1c:
            r1 = 1
        L1d:
            if (r1 == r4) goto L32
            goto L2f
        L20:
            r5 = move-exception
            throw r5
        L22:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            T r5 = r5.element
            id.dana.dialog.TwoButtonWithImageDialog r5 = (id.dana.dialog.TwoButtonWithImageDialog) r5
            if (r5 == 0) goto L2c
            goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == r4) goto L32
        L2f:
            r5.getAuthRequestContext()
        L32:
            int r5 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r5 = r5 + 51
            int r0 = r5 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L44
            r2.hashCode()     // Catch: java.lang.Throwable -> L42
            return
        L42:
            r5 = move-exception
            throw r5
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.getAuthRequestContext(kotlin.jvm.internal.Ref$ObjectRef):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0019, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r13, java.lang.Boolean.TRUE) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0029, code lost:
    
        if ((kotlin.jvm.internal.Intrinsics.areEqual(r13, java.lang.Boolean.TRUE)) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x002b, code lost:
    
        r13 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 69;
        id.dana.kyb.view.MyBusinessFragment.I = r13 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0035, code lost:
    
        if ((r13 % 2) == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0038, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x003c, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x003e, code lost:
    
        r0 = getBaseActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r3 = r0;
        r6 = getResources().getString(id.dana.R.string.enabled_face_verification);
        r4 = id.dana.R.drawable.ic_success;
        r5 = id.dana.R.drawable.bg_rounded_toast_success;
        r7 = 39;
        r8 = 120;
        r9 = true;
        r10 = null;
        r11 = 3682;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005f, code lost:
    
        r0 = getBaseActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r3 = r0;
        r6 = getResources().getString(id.dana.R.string.enabled_face_verification);
        r4 = id.dana.R.drawable.ic_success;
        r5 = id.dana.R.drawable.bg_rounded_toast_success;
        r7 = 48;
        r8 = 60;
        r9 = false;
        r10 = null;
        r11 = 384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007f, code lost:
    
        id.dana.utils.CustomToastUtil.PlaceComponentResult(r3, r4, r5, r6, r7, r8, r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0082, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0083, code lost:
    
        r13 = getBaseActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "");
        id.dana.utils.CustomToastUtil.PlaceComponentResult(r13, id.dana.R.drawable.ic_success, id.dana.R.drawable.bg_rounded_toast_success, getResources().getString(id.dana.R.string.disabled_face_verification), 48, 60, false, null, 384);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a9, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(java.lang.Boolean r13) {
        /*
            r12 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r1 = 1
            java.lang.String r2 = ""
            r3 = 0
            if (r0 == 0) goto L1e
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r0)
            r0 = 61
            int r0 = r0 / r3
            if (r13 == 0) goto L83
            goto L2b
        L1c:
            r13 = move-exception
            throw r13
        L1e:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r0)
            if (r13 == 0) goto L28
            r13 = 1
            goto L29
        L28:
            r13 = 0
        L29:
            if (r13 == 0) goto L83
        L2b:
            int r13 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r13 = r13 + 69
            int r0 = r13 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r0
            int r13 = r13 % 2
            if (r13 == 0) goto L38
            goto L39
        L38:
            r1 = 0
        L39:
            r13 = 2131953329(0x7f1306b1, float:1.9543126E38)
            if (r1 == 0) goto L5f
            id.dana.base.BaseActivity r0 = r12.getBaseActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
            android.content.res.Resources r0 = r12.getResources()
            java.lang.String r6 = r0.getString(r13)
            r4 = 2131233733(0x7f080bc5, float:1.8083612E38)
            r5 = 2131232160(0x7f0805a0, float:1.8080421E38)
            r7 = 39
            r8 = 120(0x78, float:1.68E-43)
            r9 = 1
            r10 = 0
            r11 = 3682(0xe62, float:5.16E-42)
            goto L7f
        L5f:
            id.dana.base.BaseActivity r0 = r12.getBaseActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
            android.content.res.Resources r0 = r12.getResources()
            java.lang.String r6 = r0.getString(r13)
            r4 = 2131233733(0x7f080bc5, float:1.8083612E38)
            r5 = 2131232160(0x7f0805a0, float:1.8080421E38)
            r7 = 48
            r8 = 60
            r9 = 0
            r10 = 0
            r11 = 384(0x180, float:5.38E-43)
        L7f:
            id.dana.utils.CustomToastUtil.PlaceComponentResult(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        L83:
            id.dana.base.BaseActivity r13 = r12.getBaseActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r2)
            r3 = r13
            android.app.Activity r3 = (android.app.Activity) r3
            android.content.res.Resources r13 = r12.getResources()
            r0 = 2131953235(0x7f130653, float:1.9542935E38)
            java.lang.String r6 = r13.getString(r0)
            r4 = 2131233733(0x7f080bc5, float:1.8083612E38)
            r5 = 2131232160(0x7f0805a0, float:1.8080421E38)
            r7 = 48
            r8 = 60
            r9 = 0
            r10 = 0
            r11 = 384(0x180, float:5.38E-43)
            id.dana.utils.CustomToastUtil.PlaceComponentResult(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.PlaceComponentResult(java.lang.Boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x001d, code lost:
    
        if (NetworkUserEntityData$$ExternalSyntheticLambda5().getMyBillsEntityDataFactory() != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0030, code lost:
    
        if ((r0) != true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0033, code lost:
    
        GetContactSyncConfig();
        S();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r2 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            r1 = 83
            if (r0 != 0) goto L11
            r0 = 83
            goto L13
        L11:
            r0 = 39
        L13:
            if (r0 == r1) goto L20
            id.dana.kyb.model.KybPageInfo r0 = r2.NetworkUserEntityData$$ExternalSyntheticLambda5()
            boolean r0 = r0.getMyBillsEntityDataFactory()
            if (r0 == 0) goto L39
            goto L33
        L20:
            id.dana.kyb.model.KybPageInfo r0 = r2.NetworkUserEntityData$$ExternalSyntheticLambda5()
            boolean r0 = r0.getMyBillsEntityDataFactory()
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L44
            r1 = 1
            if (r0 == 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            if (r0 == r1) goto L33
            goto L39
        L33:
            r2.GetContactSyncConfig()
            r2.S()
        L39:
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            return
        L44:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda0():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0075, code lost:
    
        if (r1 == '\t') goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0077, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 81;
        id.dana.kyb.view.MyBusinessFragment.I = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0082, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0083, code lost:
    
        r0 = (id.dana.kyb.model.KybPageInfo) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0088, code lost:
    
        r0 = (id.dana.kyb.model.KybPageInfo) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x008a, code lost:
    
        if (r0 != null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0026, code lost:
    
        if ((r0 != null) != true) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0030, code lost:
    
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0032, code lost:
    
        r1 = id.dana.kyb.view.MyBusinessFragment.I + 21;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x003c, code lost:
    
        if ((r1 % 2) != 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x003f, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0040, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0043, code lost:
    
        if (r3 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0045, code lost:
    
        r3 = id.dana.core.ui.util.OSUtil.INSTANCE;
        r3 = id.dana.core.ui.util.OSUtil.PlaceComponentResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004b, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x004e, code lost:
    
        if (r3 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0053, code lost:
    
        r3 = id.dana.core.ui.util.OSUtil.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0059, code lost:
    
        if (id.dana.core.ui.util.OSUtil.PlaceComponentResult() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x005b, code lost:
    
        r0 = (android.os.Parcelable) r0.getParcelableExtra("KYB_PAGE_INFO", id.dana.kyb.model.KybPageInfo.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0064, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0065, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0066, code lost:
    
        r0 = r0.getParcelableExtra("KYB_PAGE_INFO");
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x006e, code lost:
    
        if ((r0 instanceof id.dana.kyb.model.KybPageInfo) != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0070, code lost:
    
        r1 = 'S';
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0073, code lost:
    
        r1 = '\t';
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.kyb.model.KybPageInfo NetworkUserEntityData$$ExternalSyntheticLambda5() {
        /*
            r5 = this;
            id.dana.base.BaseActivity r0 = r5.getBaseActivity()
            if (r0 == 0) goto L8f
            int r1 = id.dana.kyb.view.MyBusinessFragment.I
            int r1 = r1 + 69
            int r2 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r2
            int r1 = r1 % 2
            r2 = 45
            if (r1 != 0) goto L17
            r1 = 45
            goto L19
        L17:
            r1 = 94
        L19:
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L29
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L25
            r1 = 1
            goto L26
        L25:
            r1 = 0
        L26:
            if (r1 == r3) goto L32
            goto L8f
        L29:
            android.content.Intent r0 = r0.getIntent()
            r1 = 32
            int r1 = r1 / r4
            if (r0 == 0) goto L8f
        L32:
            int r1 = id.dana.kyb.view.MyBusinessFragment.I
            int r1 = r1 + 21
            int r2 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L3f
            goto L40
        L3f:
            r3 = 0
        L40:
            java.lang.String r1 = "KYB_PAGE_INFO"
            r2 = 0
            if (r3 == 0) goto L53
            id.dana.core.ui.util.OSUtil r3 = id.dana.core.ui.util.OSUtil.INSTANCE
            boolean r3 = id.dana.core.ui.util.OSUtil.PlaceComponentResult()
            r2.hashCode()     // Catch: java.lang.Throwable -> L51
            if (r3 == 0) goto L66
            goto L5b
        L51:
            r0 = move-exception
            throw r0
        L53:
            id.dana.core.ui.util.OSUtil r3 = id.dana.core.ui.util.OSUtil.INSTANCE
            boolean r3 = id.dana.core.ui.util.OSUtil.PlaceComponentResult()
            if (r3 == 0) goto L66
        L5b:
            java.lang.Class<id.dana.kyb.model.KybPageInfo> r2 = id.dana.kyb.model.KybPageInfo.class
            java.lang.Object r0 = r0.getParcelableExtra(r1, r2)     // Catch: java.lang.Exception -> L64
            android.os.Parcelable r0 = (android.os.Parcelable) r0     // Catch: java.lang.Exception -> L64
            goto L88
        L64:
            r0 = move-exception
            throw r0
        L66:
            android.os.Parcelable r0 = r0.getParcelableExtra(r1)
            boolean r1 = r0 instanceof id.dana.kyb.model.KybPageInfo
            r3 = 9
            if (r1 != 0) goto L73
            r1 = 83
            goto L75
        L73:
            r1 = 9
        L75:
            if (r1 == r3) goto L82
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            goto L83
        L82:
            r2 = r0
        L83:
            id.dana.kyb.model.KybPageInfo r2 = (id.dana.kyb.model.KybPageInfo) r2
            r0 = r2
            android.os.Parcelable r0 = (android.os.Parcelable) r0
        L88:
            id.dana.kyb.model.KybPageInfo r0 = (id.dana.kyb.model.KybPageInfo) r0
            if (r0 != 0) goto L91
            goto L8f
        L8d:
            r0 = move-exception
            throw r0
        L8f:
            id.dana.kyb.model.KybPageInfo r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda1
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda5():id.dana.kyb.model.KybPageInfo");
    }

    private final void GetContactSyncConfig() {
        Intent intent;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        int i = AppCompatEmojiTextHelper + 89;
        I = i % 128;
        if ((i % 2 != 0 ? 'b' : '9') != 'b') {
            try {
                intent = baseActivity.getIntent();
                if (intent == null) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            intent = baseActivity.getIntent();
            Object[] objArr = null;
            int length = objArr.length;
            if (intent == null) {
                return;
            }
        }
        try {
            intent.removeExtra("KYB_PAGE_INFO");
            int i2 = I + 57;
            AppCompatEmojiTextHelper = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void S() {
        String str;
        int i = AppCompatEmojiTextHelper + 121;
        I = i % 128;
        int i2 = i % 2;
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        BaseActivity baseActivity2 = baseActivity;
        Context context = getContext();
        if (context != null) {
            str = context.getString(R.string.general_error_info_kyb_cpm);
        } else {
            str = null;
            int i3 = I + 101;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
        }
        CustomToastUtil.PlaceComponentResult(baseActivity2, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_payment_auth, str, 48, 60, false, null, 384);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, id.dana.dialog.TwoButtonWithImageDialog] */
    private final void SummaryVoucherView$$ExternalSyntheticLambda2() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_faceenrol_invalid;
        builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.login_face_fail_title);
        builder.getErrorConfigVersion = getResources().getString(R.string.login_face_fail_desc);
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = getResources().getString(R.string.try_again);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.getAuthRequestContext(MyBusinessFragment.this);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = getResources().getString(R.string.later);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.MyBillsEntityDataFactory(Ref.ObjectRef.this);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
        objectRef.element = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if (twoButtonWithImageDialog != null) {
            int i = I + 59;
            AppCompatEmojiTextHelper = i % 128;
            char c = i % 2 == 0 ? (char) 4 : 'G';
            twoButtonWithImageDialog.MyBillsEntityDataFactory();
            if (c == 4) {
                Object obj = null;
                obj.hashCode();
            }
        }
        int i2 = AppCompatEmojiTextHelper + 89;
        I = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 82 / 0;
        }
    }

    private static final void SummaryVoucherView$$ExternalSyntheticLambda2(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 125;
        I = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        SwitchFaceAuthContract.Presenter presenter = myBusinessFragment.MyBillsEntityDataFactory().get();
        FragmentActivity requireActivity = myBusinessFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        presenter.MyBillsEntityDataFactory(true, null, requireActivity);
        int i3 = I + 55;
        AppCompatEmojiTextHelper = i3 % 128;
        int i4 = i3 % 2;
    }

    private static final void BuiltInFictitiousFunctionClassFactory(Ref.ObjectRef objectRef) {
        TwoButtonWithImageDialog twoButtonWithImageDialog;
        int i = I + 23;
        AppCompatEmojiTextHelper = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'Y' : 'R') != 'Y') {
            Intrinsics.checkNotNullParameter(objectRef, "");
            twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
            if ((twoButtonWithImageDialog != null ? (char) 25 : '\n') != 25) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(objectRef, "");
            twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
            objArr.hashCode();
            if (twoButtonWithImageDialog == null) {
                return;
            }
        }
        int i2 = I + 7;
        AppCompatEmojiTextHelper = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 0 : '#') != '#') {
            twoButtonWithImageDialog.getAuthRequestContext();
            int length = objArr.length;
            return;
        }
        try {
            twoButtonWithImageDialog.getAuthRequestContext();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void R() {
        int i = I + 105;
        AppCompatEmojiTextHelper = i % 128;
        if (!(i % 2 != 0)) {
            DialogWithImage.BuiltInFictitiousFunctionClassFactory(getBaseActivity(), NetworkUserEntityData$$ExternalSyntheticLambda6()).MyBillsEntityDataFactory();
            int i2 = 18 / 0;
            return;
        }
        DialogWithImage.BuiltInFictitiousFunctionClassFactory(getBaseActivity(), NetworkUserEntityData$$ExternalSyntheticLambda6()).MyBillsEntityDataFactory();
    }

    private final DialogInterface.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda6() {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyBusinessFragment.getAuthRequestContext(MyBusinessFragment.this, dialogInterface, i);
            }
        };
        try {
            int i = I + 63;
            AppCompatEmojiTextHelper = i % 128;
            if (i % 2 != 0) {
                return onClickListener;
            }
            Object obj = null;
            obj.hashCode();
            return onClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.kyb.view.MyBusinessFragment r6, android.content.DialogInterface r7, int r8) {
        /*
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 83
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r1 = -2
            r2 = 0
            r3 = 1
            if (r8 == r1) goto L19
            r1 = 0
            goto L1a
        L19:
            r1 = 1
        L1a:
            r4 = 0
            if (r1 == 0) goto L1e
            goto L44
        L1e:
            int r1 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r1 = r1 + 13
            int r5 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r5
            int r1 = r1 % 2
            r1 = -1
            if (r8 != r1) goto L4a
            com.anggrayudi.storage.permission.FragmentPermissionRequest r6 = r6.A     // Catch: java.lang.Exception -> L48
            if (r6 != 0) goto L30
            goto L31
        L30:
            r2 = 1
        L31:
            if (r2 == r3) goto L41
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r6 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r6 = r6 + 21
            int r8 = r6 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r8
            int r6 = r6 % 2
            r6 = r4
        L41:
            r6.check()
        L44:
            r7.dismiss()
            goto L4a
        L48:
            r6 = move-exception
            throw r6
        L4a:
            int r6 = id.dana.kyb.view.MyBusinessFragment.I
            int r6 = r6 + 49
            int r7 = r6 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r7
            int r6 = r6 % 2
            r7 = 29
            if (r6 != 0) goto L5b
            r6 = 29
            goto L5d
        L5b:
            r6 = 33
        L5d:
            if (r6 == r7) goto L60
            return
        L60:
            r4.hashCode()     // Catch: java.lang.Throwable -> L64
            return
        L64:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.kyb.view.MyBusinessFragment, android.content.DialogInterface, int):void");
    }

    private final void G() {
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.BuiltInFictitiousFunctionClassFactory = readMicros();
        builder.MyBillsEntityDataFactory = R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
        builder.moveToNextValue = getResources().getString(R.string.risk_reject_dialog_title);
        builder.PlaceComponentResult = getResources().getString(R.string.face_login_failed_cs);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = getResources().getString(R.string.risk_reject_positive_button_msg);
        new DialogWithImage(getBaseActivity(), builder.lookAheadTest, builder, (byte) 0).MyBillsEntityDataFactory();
        int i = AppCompatEmojiTextHelper + 11;
        I = i % 128;
        if ((i % 2 != 0 ? '\b' : '#') != '\b') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private final DialogInterface.OnClickListener readMicros() {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyBusinessFragment.PlaceComponentResult(MyBusinessFragment.this, dialogInterface, i);
            }
        };
        try {
            int i = AppCompatEmojiTextHelper + 43;
            I = i % 128;
            if (i % 2 == 0) {
                return onClickListener;
            }
            int i2 = 86 / 0;
            return onClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void MyBillsEntityDataFactory(MyBusinessFragment myBusinessFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (-1 == i) {
            try {
                int i2 = I + 93;
                AppCompatEmojiTextHelper = i2 % 128;
                int i3 = i2 % 2;
                FragmentPermissionRequest fragmentPermissionRequest = myBusinessFragment.A;
                if ((fragmentPermissionRequest == null ? 'T' : '`') != '`') {
                    int i4 = I + 85;
                    AppCompatEmojiTextHelper = i4 % 128;
                    int i5 = i4 % 2;
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        fragmentPermissionRequest = null;
                        int i6 = AppCompatEmojiTextHelper + 101;
                        I = i6 % 128;
                        int i7 = i6 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                fragmentPermissionRequest.check();
                dialogInterface.dismiss();
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final void getAuthRequestContext(KybServiceModel kybServiceModel) {
        Context context;
        try {
            int i = AppCompatEmojiTextHelper + 123;
            try {
                I = i % 128;
                if ((i % 2 != 0 ? '8' : '7') != '8') {
                    context = getContext();
                    if ((context == null ? 'A' : '7') == 'A') {
                        return;
                    }
                } else {
                    context = getContext();
                    Object obj = null;
                    obj.hashCode();
                    if ((context != null ? Typography.amp : '7') != '&') {
                        return;
                    }
                }
                ContextUtil contextUtil = ContextUtil.INSTANCE;
                if ((ContextUtil.getAuthRequestContext(context) ? 'S' : (char) 7) != 7) {
                    int i2 = AppCompatEmojiTextHelper + 33;
                    I = i2 % 128;
                    int i3 = i2 % 2;
                    PlaceComponentResult().get().BuiltInFictitiousFunctionClassFactory(context, kybServiceModel, FragmentBottomSheetPaymentSettingBinding());
                    int i4 = AppCompatEmojiTextHelper + 123;
                    I = i4 % 128;
                    int i5 = i4 % 2;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBusinessFragment myBusinessFragment, String str) {
        int i = I + 13;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        myBusinessFragment.PlaceComponentResult(str, (Function0<Unit>) null);
        int i3 = I + 21;
        AppCompatEmojiTextHelper = i3 % 128;
        if ((i3 % 2 == 0 ? Typography.less : '\f') != '\f') {
            int length = objArr.length;
        }
    }

    private final void PlaceComponentResult(String str, final Function0<Unit> function0) {
        String authRequestContext = UrlUtil.getAuthRequestContext(PlaceComponentResult(str));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.kyb.view.MyBusinessFragment$openH5Container$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                Function0 function02 = Function0.this;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
        int i = AppCompatEmojiTextHelper + 53;
        I = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x001d, code lost:
    
        if ((id.dana.utils.UrlUtil.getErrorConfigVersion(r4)) != true) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0027, code lost:
    
        if (id.dana.utils.UrlUtil.getErrorConfigVersion(r4) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0029, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 3;
        id.dana.kyb.view.MyBusinessFragment.I = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0033, code lost:
    
        if ((r0 % 2) == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0035, code lost:
    
        a().get().MyBillsEntityDataFactory(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0042, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0043, code lost:
    
        r4 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0047, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0048, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0049, code lost:
    
        a().get().MyBillsEntityDataFactory(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0057, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r1 = 10
            if (r0 == 0) goto L11
            r0 = 10
            goto L12
        L11:
            r0 = 6
        L12:
            r2 = 0
            if (r0 == r1) goto L22
            boolean r0 = id.dana.utils.UrlUtil.getErrorConfigVersion(r4)     // Catch: java.lang.Exception -> L20
            r1 = 1
            if (r0 == 0) goto L1d
            r2 = 1
        L1d:
            if (r2 == r1) goto L29
            goto L57
        L20:
            r4 = move-exception
            throw r4
        L22:
            boolean r0 = id.dana.utils.UrlUtil.getErrorConfigVersion(r4)
            int r1 = r1 / r2
            if (r0 == 0) goto L57
        L29:
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 3
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L49
            dagger.Lazy r0 = r3.a()     // Catch: java.lang.Exception -> L47
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L47
            id.dana.contract.deeplink.ReadLinkPropertiesPresenter r0 = (id.dana.contract.deeplink.ReadLinkPropertiesPresenter) r0     // Catch: java.lang.Exception -> L47
            r0.MyBillsEntityDataFactory(r4)     // Catch: java.lang.Exception -> L47
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L45
            goto L56
        L45:
            r4 = move-exception
            throw r4
        L47:
            r4 = move-exception
            throw r4
        L49:
            dagger.Lazy r0 = r3.a()
            java.lang.Object r0 = r0.get()
            id.dana.contract.deeplink.ReadLinkPropertiesPresenter r0 = (id.dana.contract.deeplink.ReadLinkPropertiesPresenter) r0
            r0.MyBillsEntityDataFactory(r4)
        L56:
            return
        L57:
            BuiltInFictitiousFunctionClassFactory(r3, r4)
            return
        L5b:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.getAuthRequestContext(java.lang.String):void");
    }

    private final void Q() {
        int i = I + 35;
        AppCompatEmojiTextHelper = i % 128;
        if ((i % 2 == 0 ? '3' : ')') != ')') {
            c();
            PlaceComponentResult().get().PlaceComponentResult();
            int i2 = 71 / 0;
        } else {
            c();
            try {
                try {
                    PlaceComponentResult().get().PlaceComponentResult();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = AppCompatEmojiTextHelper + 37;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void BuiltInFictitiousFunctionClassFactory(KybQrisModel kybQrisModel) {
        int i = AppCompatEmojiTextHelper + 33;
        I = i % 128;
        int i2 = i % 2;
        QrisBusinessBottomSheetDialog.Companion companion = QrisBusinessBottomSheetDialog.INSTANCE;
        QrisBusinessBottomSheetDialog authRequestContext = QrisBusinessBottomSheetDialog.Companion.getAuthRequestContext(kybQrisModel, KybModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil));
        Context context = getContext();
        if (!(context != null)) {
            try {
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            QrisBusinessBottomSheetDialog.Companion companion2 = QrisBusinessBottomSheetDialog.INSTANCE;
            authRequestContext.show(supportFragmentManager, QrisBusinessBottomSheetDialog.Companion.BuiltInFictitiousFunctionClassFactory());
            int i3 = I + 79;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void L() {
        QrisEmptyStateBottomSheet qrisEmptyStateBottomSheet = new QrisEmptyStateBottomSheet();
        qrisEmptyStateBottomSheet.getAuthRequestContext = new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$openQrisEmptyStateBottomSheet$1$1
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
                MyBusinessFragment.H(MyBusinessFragment.this);
            }
        };
        Context context = getContext();
        if ((context != null ? (char) 3 : '=') != 3) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
        int i = I + 11;
        AppCompatEmojiTextHelper = i % 128;
        if (i % 2 == 0) {
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            QrisEmptyStateBottomSheet.Companion companion = QrisEmptyStateBottomSheet.INSTANCE;
            qrisEmptyStateBottomSheet.show(supportFragmentManager, QrisEmptyStateBottomSheet.Companion.PlaceComponentResult());
            Object obj = null;
            obj.hashCode();
        } else {
            try {
                FragmentManager supportFragmentManager2 = ((FragmentActivity) context).getSupportFragmentManager();
                QrisEmptyStateBottomSheet.Companion companion2 = QrisEmptyStateBottomSheet.INSTANCE;
                qrisEmptyStateBottomSheet.show(supportFragmentManager2, QrisEmptyStateBottomSheet.Companion.PlaceComponentResult());
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = AppCompatEmojiTextHelper + 85;
        I = i2 % 128;
        int i3 = i2 % 2;
    }

    private final String PlaceComponentResult(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("speed=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        String PlaceComponentResult2 = UrlUtil.PlaceComponentResult(str, sb.toString());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        int i = AppCompatEmojiTextHelper + 85;
        I = i % 128;
        int i2 = i % 2;
        return PlaceComponentResult2;
    }

    private final void MyBillsEntityDataFactory(BalanceModel balanceModel) {
        int i = I + 57;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        if ((balanceModel != null ? (char) 4 : (char) 2) == 4) {
            try {
                MyBusinessBalanceView myBusinessBalanceView = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (!(myBusinessBalanceView != null)) {
                    int i3 = AppCompatEmojiTextHelper + 65;
                    I = i3 % 128;
                    int i4 = i3 % 2;
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    myBusinessBalanceView = null;
                }
                myBusinessBalanceView.bindBalanceInfo(balanceModel.MyBillsEntityDataFactory, balanceModel.KClassImpl$Data$declaredNonStaticMembers$2, balanceModel.BuiltInFictitiousFunctionClassFactory);
            } catch (Exception e) {
                throw e;
            }
        }
        int i5 = I + 41;
        AppCompatEmojiTextHelper = i5 % 128;
        int i6 = i5 % 2;
    }

    private final void PlaceComponentResult(KybMerchantInfoModel kybMerchantInfoModel) {
        if (!(kybMerchantInfoModel != null)) {
            return;
        }
        MyBusinessBalanceView myBusinessBalanceView = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (myBusinessBalanceView == null) {
            int i = I + 107;
            AppCompatEmojiTextHelper = i % 128;
            if (i % 2 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i2 = 98 / 0;
            } else {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } catch (Exception e) {
                    throw e;
                }
            }
            myBusinessBalanceView = null;
        }
        myBusinessBalanceView.bindTransactionLimit(kybMerchantInfoModel.isLayoutRequested, kybMerchantInfoModel.getErrorConfigVersion, kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
        int i3 = AppCompatEmojiTextHelper + 93;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void getAuthRequestContext(TransactionListQueryModel transactionListQueryModel) {
        KybTransactionHistoryView kybTransactionHistoryView = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        Object obj = null;
        if (kybTransactionHistoryView == null) {
            int i = AppCompatEmojiTextHelper + 85;
            I = i % 128;
            int i2 = i % 2;
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                kybTransactionHistoryView = null;
            } catch (Exception e) {
                throw e;
            }
        }
        kybTransactionHistoryView.bindTransactionHistory(transactionListQueryModel);
        int i3 = AppCompatEmojiTextHelper + 25;
        I = i3 % 128;
        if (!(i3 % 2 == 0)) {
            obj.hashCode();
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(KybCompleteInfoModel kybCompleteInfoModel) {
        String str;
        if (this.D != 0) {
            PlaceComponentResult().get().getErrorConfigVersion();
            MyBusinessHeaderView myBusinessHeaderView = this.SubSequence;
            if (myBusinessHeaderView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                myBusinessHeaderView = null;
            }
            if (kybCompleteInfoModel != null) {
                int i = I + 21;
                AppCompatEmojiTextHelper = i % 128;
                int i2 = i % 2;
                str = PlaceComponentResult(kybCompleteInfoModel);
                int i3 = AppCompatEmojiTextHelper + 35;
                I = i3 % 128;
                int i4 = i3 % 2;
            } else {
                str = null;
            }
            myBusinessHeaderView.setAvatar(str);
            String moveToNextValue = kybCompleteInfoModel != null ? moveToNextValue(kybCompleteInfoModel) : null;
            if (moveToNextValue == null) {
                int i5 = I + 73;
                AppCompatEmojiTextHelper = i5 % 128;
                int i6 = i5 % 2;
                moveToNextValue = "";
            }
            myBusinessHeaderView.setMerchantName(moveToNextValue);
            myBusinessHeaderView.setKybTieringListener(initRecordTimeStamp());
            int i7 = this.D;
            if (i7 != 2) {
                if ((i7 != 3 ? Typography.less : (char) 23) != '<') {
                    myBusinessHeaderView.setMerchantStatus(R.string.kyb_registration_frozen);
                    return;
                }
                if (i7 == 4) {
                    myBusinessHeaderView.setMerchantStatus(R.string.kyb_registration_revoked);
                    return;
                } else if (i7 == 5) {
                    myBusinessHeaderView.setMerchantStatus(R.string.kyb_registration_rejected);
                    return;
                } else {
                    if ((i7 == 99 ? 'R' : '-') != '-') {
                        String string = getString(R.string.kyb_error_merchant_name);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        myBusinessHeaderView.setMerchantName(string);
                        myBusinessHeaderView.setMerchantStatus(R.string.kyb_error_merchant_status);
                        return;
                    }
                }
            } else {
                myBusinessHeaderView.setMerchantStatus(R.string.kyb_registration_pending);
            }
        }
        int i8 = I + 55;
        AppCompatEmojiTextHelper = i8 % 128;
        int i9 = i8 % 2;
    }

    private final void BuiltInFictitiousFunctionClassFactory(int i) {
        int i2;
        LayoutInflater layoutInflater = getLayoutInflater();
        if (i == 0) {
            i2 = R.layout.view_my_business_content_unregistered;
        } else if (i != 1) {
            int i3 = AppCompatEmojiTextHelper + 27;
            I = i3 % 128;
            int i4 = i3 % 2;
            i2 = R.layout.view_my_business_content;
        } else {
            i2 = R.layout.view_my_business_content_registered;
        }
        View view = null;
        View inflate = layoutInflater.inflate(i2, (ViewGroup) null);
        View view2 = this.FragmentBottomSheetPaymentSettingBinding;
        if (view2 != null) {
            view = view2;
        } else {
            int i5 = AppCompatEmojiTextHelper + 49;
            I = i5 % 128;
            if (i5 % 2 != 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                view.hashCode();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        KClassImpl$Data$declaredNonStaticMembers$2(view, inflate);
        this.FragmentBottomSheetPaymentSettingBinding = inflate;
        int i6 = AppCompatEmojiTextHelper + 49;
        I = i6 % 128;
        int i7 = i6 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x00ea, code lost:
    
        if (r0 != 0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00f3, code lost:
    
        if (r0.length() != 0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00f5, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0107, code lost:
    
        if (r7 != null) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x010c, code lost:
    
        if (r7 != null) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x010e, code lost:
    
        r7 = r7.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0110, code lost:
    
        if (r7 == null) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0112, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.I + 63;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x011c, code lost:
    
        if ((r0 % 2) != 0) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x011e, code lost:
    
        r7 = r7.lookAheadTest;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0120, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0126, code lost:
    
        r7 = r7.lookAheadTest;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0128, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x012f, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, "FAILED") != false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0131, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0133, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0134, code lost:
    
        if (r7 == true) goto L198;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.kyb.model.KybCompleteInfoModel r7) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.getAuthRequestContext(id.dana.kyb.model.KybCompleteInfoModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0105, code lost:
    
        if (r0 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x010d, code lost:
    
        if (r0 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x010f, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x002b, code lost:
    
        if ((r0 == null) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0042, code lost:
    
        if (r0 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0044, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.kyb.view.MyBusinessFragment.I + 43;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0 % 128;
        r0 = r0 % 2;
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(id.dana.kyb.model.KybCompleteInfoModel r9) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.MyBillsEntityDataFactory(id.dana.kyb.model.KybCompleteInfoModel):void");
    }

    private final void PrepareContext() {
        KybMerchantInfoModel kybMerchantInfoModel;
        int i = I + 25;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        KybCompleteInfoModel kybCompleteInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (kybCompleteInfoModel != null) {
            try {
                int i3 = I + 117;
                AppCompatEmojiTextHelper = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    kybMerchantInfoModel = kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory;
                    Object obj = null;
                    obj.hashCode();
                    if (kybMerchantInfoModel == null) {
                        return;
                    }
                } else {
                    kybMerchantInfoModel = kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory;
                    if ((kybMerchantInfoModel != null ? 'N' : Typography.quote) != 'N') {
                        return;
                    }
                }
                final KybQrisModel kybQrisModel = kybMerchantInfoModel.lookAheadTest;
                if (kybQrisModel != null) {
                    addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(kybQrisModel.KClassImpl$Data$declaredNonStaticMembers$2).subscribe(new Consumer() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda15
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj2) {
                            MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(KybQrisModel.this, (Bitmap) obj2);
                        }
                    }, new Consumer() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda16
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj2) {
                            Throwable th = (Throwable) obj2;
                            MyBusinessFragment.getErrorConfigVersion(MyBusinessFragment.this);
                        }
                    }));
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static final void SummaryVoucherView$$ExternalSyntheticLambda0(MyBusinessFragment myBusinessFragment) {
        int i = I + 85;
        AppCompatEmojiTextHelper = i % 128;
        if ((i % 2 == 0 ? Typography.quote : InputCardNumberView.DIVIDER) != '\"') {
            try {
                Intrinsics.checkNotNullParameter(myBusinessFragment, "");
                myBusinessFragment.dispose();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        myBusinessFragment.dispose();
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x002f, code lost:
    
        if (r5.D != 0) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getErrorConfigVersion() {
        /*
            r5 = this;
            androidx.fragment.app.Fragment r0 = r5.getParentFragment()
            boolean r1 = r0 instanceof id.dana.myprofile.MyProfileMainFragment
            r2 = 0
            r3 = 1
            if (r1 == 0) goto Lc
            r1 = 0
            goto Ld
        Lc:
            r1 = 1
        Ld:
            if (r1 == 0) goto L11
            r0 = 0
            goto L1d
        L11:
            int r1 = id.dana.kyb.view.MyBusinessFragment.I
            int r1 = r1 + 35
            int r4 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r4
            int r1 = r1 % 2
            id.dana.myprofile.MyProfileMainFragment r0 = (id.dana.myprofile.MyProfileMainFragment) r0
        L1d:
            if (r0 == 0) goto L4e
            int r1 = id.dana.kyb.view.MyBusinessFragment.I
            int r1 = r1 + 73
            int r4 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r4
            int r1 = r1 % 2
            r4 = 49
            if (r1 != 0) goto L32
            int r1 = r5.D
            if (r1 == 0) goto L48
            goto L3d
        L32:
            int r1 = r5.D     // Catch: java.lang.Exception -> L4c
            if (r1 == r3) goto L39
            r1 = 86
            goto L3b
        L39:
            r1 = 49
        L3b:
            if (r1 == r4) goto L47
        L3d:
            int r1 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r1 = r1 + r4
            int r3 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r3
            int r1 = r1 % 2
            goto L48
        L47:
            r2 = 1
        L48:
            r0.getAuthRequestContext(r2)
            goto L4e
        L4c:
            r0 = move-exception
            throw r0
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.getErrorConfigVersion():void");
    }

    private final void scheduleImpl() {
        try {
            if (!(!this.readMicros)) {
                if ((this.D == 1 ? 'M' : (char) 20) != 20) {
                    try {
                        int i = AppCompatEmojiTextHelper + 33;
                        I = i % 128;
                        if (i % 2 != 0) {
                        }
                        this.readMicros = false;
                        QrExpiredActivity().get().getAuthRequestContext();
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            int i2 = I + 29;
            AppCompatEmojiTextHelper = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(final KybCompleteInfoModel kybCompleteInfoModel) {
        View view = this.FragmentBottomSheetPaymentSettingBinding;
        KybBenefitsView kybBenefitsView = null;
        if ((view == null ? (char) 17 : (char) 23) == 17) {
            int i = I + 57;
            AppCompatEmojiTextHelper = i % 128;
            if (i % 2 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i2 = 67 / 0;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            view = null;
        }
        View findViewById = view.findViewById(R.id.kyb_benefits_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        KybBenefitsView kybBenefitsView2 = (KybBenefitsView) findViewById;
        this.initRecordTimeStamp = kybBenefitsView2;
        if (kybBenefitsView2 != null) {
            kybBenefitsView = kybBenefitsView2;
        } else {
            int i3 = I + 35;
            AppCompatEmojiTextHelper = i3 % 128;
            if (i3 % 2 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i4 = 36 / 0;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) kybBenefitsView.findViewById(R.id.btn_kyb_benefits_apply);
        danaButtonPrimaryView.setVisibility(0);
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MyBusinessFragment.getAuthRequestContext(MyBusinessFragment.this, kybCompleteInfoModel);
            }
        });
    }

    private static final void PlaceComponentResult(MyBusinessFragment myBusinessFragment, KybCompleteInfoModel kybCompleteInfoModel) {
        try {
            int i = AppCompatEmojiTextHelper + 13;
            I = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(myBusinessFragment, "");
            myBusinessFragment.lookAheadTest(kybCompleteInfoModel);
            int i3 = I + 79;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x006f, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.getErrorConfigVersion, "KYC2") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0071, code lost:
    
        I();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0074, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0075, code lost:
    
        SummaryVoucherView$$ExternalSyntheticLambda1();
        r5 = id.dana.kyb.view.MyBusinessFragment.I + 117;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0082, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0083, code lost:
    
        isAuth();
        r5 = id.dana.kyb.view.MyBusinessFragment.I + 35;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0090, code lost:
    
        r5 = id.dana.kyb.view.MyBusinessFragment.I + 29;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x009a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0018, code lost:
    
        if ((r5 != null) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x001d, code lost:
    
        if (r5 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x001f, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.I + 11;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0029, code lost:
    
        if ((r0 % 2) != 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x002b, code lost:
    
        r5 = r5.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x002d, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0032, code lost:
    
        if (r5 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0034, code lost:
    
        r1 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0037, code lost:
    
        r1 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0039, code lost:
    
        if (r1 == '\f') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x003e, code lost:
    
        r5 = r5.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0040, code lost:
    
        if (r5 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x004a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.lookAheadTest, "IN_PROGRESS") != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x004c, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 45;
        id.dana.kyb.view.MyBusinessFragment.I = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x005c, code lost:
    
        if (r5.getKClassImpl$Data$declaredNonStaticMembers$2() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0064, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.getErrorConfigVersion, "KYC2") != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0067, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0068, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void lookAheadTest(id.dana.kyb.model.KybCompleteInfoModel r5) {
        /*
            r4 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
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
            if (r0 == r2) goto L1d
            int r0 = r3.length     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L18
            r1 = 1
        L18:
            if (r1 == 0) goto L90
            goto L1f
        L1b:
            r5 = move-exception
            throw r5
        L1d:
            if (r5 == 0) goto L90
        L1f:
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3e
            id.dana.kyb.model.UserInfoKybModel r5 = r5.MyBillsEntityDataFactory
            r3.hashCode()     // Catch: java.lang.Throwable -> L3c
            r0 = 12
            if (r5 == 0) goto L37
            r1 = 12
            goto L39
        L37:
            r1 = 84
        L39:
            if (r1 == r0) goto L42
            goto L90
        L3c:
            r5 = move-exception
            throw r5
        L3e:
            id.dana.kyb.model.UserInfoKybModel r5 = r5.MyBillsEntityDataFactory
            if (r5 == 0) goto L90
        L42:
            java.lang.String r0 = r5.lookAheadTest
            java.lang.String r1 = "IN_PROGRESS"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L83
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 45
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            boolean r0 = r5.getKClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.String r1 = "KYC2"
            if (r0 != 0) goto L69
            java.lang.String r0 = r5.getErrorConfigVersion     // Catch: java.lang.Exception -> L9b
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: java.lang.Exception -> L67
            if (r0 != 0) goto L83
            goto L69
        L67:
            r5 = move-exception
            throw r5
        L69:
            java.lang.String r5 = r5.getErrorConfigVersion
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r5 == 0) goto L75
            r4.I()
            return
        L75:
            r4.SummaryVoucherView$$ExternalSyntheticLambda1()
            int r5 = id.dana.kyb.view.MyBusinessFragment.I
            int r5 = r5 + 117
            int r0 = r5 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0
            int r5 = r5 % 2
            return
        L83:
            r4.isAuth()
            int r5 = id.dana.kyb.view.MyBusinessFragment.I
            int r5 = r5 + 35
            int r0 = r5 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0
            int r5 = r5 % 2
        L90:
            int r5 = id.dana.kyb.view.MyBusinessFragment.I     // Catch: java.lang.Exception -> L9b
            int r5 = r5 + 29
            int r0 = r5 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0     // Catch: java.lang.Exception -> L9b
            int r5 = r5 % 2
            return
        L9b:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.lookAheadTest(id.dana.kyb.model.KybCompleteInfoModel):void");
    }

    private final void I() {
        PlaceComponentResult(KybUrlsDataManager.BuiltInFictitiousFunctionClassFactory(), new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$openKybRegistrationContainer$1
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
                MyBusinessFragment.this.PlaceComponentResult().get().getAuthRequestContext();
                MyBusinessFragment.BottomSheetCardBindingView$watcherCardNumberView$1(MyBusinessFragment.this);
            }
        });
        try {
            int i = I + 67;
            AppCompatEmojiTextHelper = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void B() {
        int i = I + 73;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        KybBenefitsView kybBenefitsView = this.initRecordTimeStamp;
        if (!(kybBenefitsView != null)) {
            int i3 = AppCompatEmojiTextHelper + 45;
            I = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            kybBenefitsView = null;
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) kybBenefitsView.findViewById(R.id.btn_kyb_benefits_apply);
        if ((this.initRecordTimeStamp != null ? 'A' : '\\') != '\\') {
            danaButtonPrimaryView.setVisibility(8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0031, code lost:
    
        if ((r0 != null ? 'M' : '7') != 'M') goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0035, code lost:
    
        r1 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 13;
        id.dana.kyb.view.MyBusinessFragment.I = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x003e, code lost:
    
        if ((r1 % 2) == 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0040, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0042, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0043, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0044, code lost:
    
        if (r1 == true) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0046, code lost:
    
        r1 = r11.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0048, code lost:
    
        r7 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0049, code lost:
    
        if (r1 == 0) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x004e, code lost:
    
        r1 = r11.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0050, code lost:
    
        if (r1 == 0) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0052, code lost:
    
        if (r1 == 1) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0054, code lost:
    
        if (r1 == 2) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0056, code lost:
    
        r7 = id.dana.kyb.view.MyBusinessFragment.I + 101;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0060, code lost:
    
        if (r1 == 3) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0062, code lost:
    
        r7 = id.dana.kyb.view.MyBusinessFragment.I + 77;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x006b, code lost:
    
        if (r1 == 4) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x006d, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x006f, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0070, code lost:
    
        if (r3 == true) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0072, code lost:
    
        r1 = id.dana.kyb.constant.KybMixpanelState.REVOKED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0076, code lost:
    
        if (r1 == 5) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0078, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x007a, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x007b, code lost:
    
        if (r3 == true) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x007d, code lost:
    
        r3 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 105;
        id.dana.kyb.view.MyBusinessFragment.I = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0088, code lost:
    
        if (r1 == 99) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x008a, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x008c, code lost:
    
        r1 = id.dana.kyb.constant.KybMixpanelState.ERROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x008f, code lost:
    
        r1 = id.dana.kyb.constant.KybMixpanelState.REJECTED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0092, code lost:
    
        r1 = id.dana.kyb.constant.KybMixpanelState.FROZEN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0095, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0096, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0097, code lost:
    
        r1 = id.dana.kyb.view.MyBusinessFragment.I + 51;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1 % 128;
        r1 = r1 % 2;
        r1 = id.dana.kyb.constant.KybMixpanelState.KYB_IN_PROGRESS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x00a3, code lost:
    
        r1 = id.dana.kyb.constant.KybMixpanelState.REGISTERED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00a6, code lost:
    
        r1 = id.dana.kyb.constant.KybMixpanelState.UNREGISTERED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x00a8, code lost:
    
        r11.VerifyPinStateManager$executeRiskChallenge$2$1 = java.util.Calendar.getInstance().getTime().getTime() - r0.getTime();
        r0 = new id.dana.tracker.EventTrackerModel.Builder(getContext());
        r0.MyBillsEntityDataFactory = id.dana.analytics.tracker.TrackerKey.Event.KYB_NATIVE_HOMEPAGE_OPEN;
        r0 = r0.BuiltInFictitiousFunctionClassFactory("Duration", r11.VerifyPinStateManager$executeRiskChallenge$2$1).MyBillsEntityDataFactory(id.dana.analytics.tracker.TrackerKey.Property.STATE, r1).MyBillsEntityDataFactory(id.dana.analytics.tracker.TrackerKey.KybProperties.DATA_SOURCE, newProxyInstance());
        r0.PlaceComponentResult();
        id.dana.tracker.EventTracker.PlaceComponentResult(new id.dana.tracker.EventTrackerModel(r0, r4));
        Y();
        r11.isLayoutRequested = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x00f0, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.I + 75;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00f9, code lost:
    
        if ((r0 % 2) != 0) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x00fd, code lost:
    
        r0 = 28 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x00fe, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0101, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0102, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0103, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0022, code lost:
    
        if ((r0 == null) != false) goto L168;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void shouldRecycleViewType() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.shouldRecycleViewType():void");
    }

    private static void X() {
        try {
            int i = AppCompatEmojiTextHelper + 11;
            try {
                I = i % 128;
                int i2 = i % 2;
                FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("kyb_native_homepage_loading_time");
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("kyb_native_homepage_cache_loading_time");
                int i3 = AppCompatEmojiTextHelper + 37;
                I = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 2 : 'M') != 2) {
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

    private final void Y() {
        try {
            try {
                FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                if (!(this.getCallingPid)) {
                    Intrinsics.checkNotNullParameter("kyb_native_homepage_cache_loading_time", "");
                    Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get("kyb_native_homepage_cache_loading_time");
                    if (trace != null) {
                        trace.stop();
                    }
                    this.getCallingPid = true;
                    return;
                }
                int i = I + 43;
                AppCompatEmojiTextHelper = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter("kyb_native_homepage_loading_time", "");
                Trace trace2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get("kyb_native_homepage_loading_time");
                if (trace2 == null) {
                    return;
                }
                int i3 = AppCompatEmojiTextHelper + 63;
                I = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    trace2.stop();
                    return;
                }
                trace2.stop();
                int i4 = 61 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_TAB_CLICK;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", str);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
            int i = AppCompatEmojiTextHelper + 51;
            I = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final String newProxyInstance() {
        int i = I + 115;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        if ((this.getCallingPid ? 'Y' : 'X') != 'X') {
            try {
                int i3 = I + 45;
                AppCompatEmojiTextHelper = i3 % 128;
                int i4 = i3 % 2;
                int i5 = AppCompatEmojiTextHelper + 49;
                I = i5 % 128;
                int i6 = i5 % 2;
                return KybDataSource.API;
            } catch (Exception e) {
                throw e;
            }
        }
        return KybDataSource.CACHE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x002c, code lost:
    
        if ((r7 != 3) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x002f, code lost:
    
        if (r7 != 5) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0032, code lost:
    
        if (r7 == 4) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0034, code lost:
    
        r8 = id.dana.kyb.view.MyBusinessFragment.I + 31;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x003d, code lost:
    
        if ((r8 % 2) != 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x003f, code lost:
    
        if (r7 == 5) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0041, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0043, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0044, code lost:
    
        if (r8 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0047, code lost:
    
        if (r7 == 5) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0049, code lost:
    
        r8 = id.dana.kyb.view.MyBusinessFragment.I + 21;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0054, code lost:
    
        if (r7 != 99) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0057, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0058, code lost:
    
        if (r3 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x005a, code lost:
    
        P();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x005e, code lost:
    
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0062, code lost:
    
        MyBillsEntityDataFactory(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0066, code lost:
    
        N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0069, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(int r7, boolean r8) {
        /*
            r6 = this;
            r0 = 45
            r1 = 2
            if (r7 == r1) goto L8
            r2 = 45
            goto La
        L8:
            r2 = 9
        La:
            if (r2 == r0) goto L10
            r6.SummaryVoucherView$$ExternalSyntheticLambda0()
            goto L5d
        L10:
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 81
            int r2 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r2
            int r0 = r0 % r1
            r2 = 86
            if (r0 != 0) goto L20
            r0 = 86
            goto L21
        L20:
            r0 = 7
        L21:
            r3 = 1
            r4 = 0
            r5 = 5
            if (r0 == r2) goto L2f
            r0 = 3
            if (r7 == r0) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            if (r0 == 0) goto L66
            goto L31
        L2f:
            if (r7 == r5) goto L66
        L31:
            r0 = 4
            if (r7 == r0) goto L62
            int r8 = id.dana.kyb.view.MyBusinessFragment.I
            int r8 = r8 + 31
            int r0 = r8 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0
            int r8 = r8 % r1
            if (r8 != 0) goto L47
            if (r7 == r5) goto L43
            r8 = 0
            goto L44
        L43:
            r8 = 1
        L44:
            if (r8 == 0) goto L49
            goto L5e
        L47:
            if (r7 == r5) goto L5e
        L49:
            int r8 = id.dana.kyb.view.MyBusinessFragment.I
            int r8 = r8 + 21
            int r0 = r8 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0
            int r8 = r8 % r1
            r8 = 99
            if (r7 != r8) goto L57
            goto L58
        L57:
            r3 = 0
        L58:
            if (r3 == 0) goto L5d
            r6.P()
        L5d:
            return
        L5e:
            r6.O()
            return
        L62:
            r6.MyBillsEntityDataFactory(r8)
            return
        L66:
            r6.N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(int, boolean):void");
    }

    private final void PlaceComponentResult(int i) {
        int i2 = AppCompatEmojiTextHelper + 53;
        I = i2 % 128;
        int i3 = i2 % 2;
        if (getAuthRequestContext(i)) {
            int i4 = AppCompatEmojiTextHelper + 67;
            I = i4 % 128;
            int i5 = i4 % 2;
            MyBusinessHeaderView myBusinessHeaderView = this.SubSequence;
            Object[] objArr = null;
            if ((myBusinessHeaderView == null ? 'I' : Typography.dollar) != '$') {
                int i6 = AppCompatEmojiTextHelper + 51;
                I = i6 % 128;
                if ((i6 % 2 != 0 ? (char) 27 : '[') != '[') {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    int length = objArr.length;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                myBusinessHeaderView = null;
            }
            String string = getString(R.string.lbl_merchant_name_static);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = getString(R.string.lbl_merchant_status);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            myBusinessHeaderView.setHeaderContentDescription(string, string2);
        }
    }

    private final void N() {
        ImageView imageView = this.getErrorConfigVersion;
        if ((imageView == null ? 'H' : 'U') != 'U') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i = AppCompatEmojiTextHelper + 1;
            I = i % 128;
            int i2 = i % 2;
            imageView = null;
        }
        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_kyb_frozen);
        TextView textView = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setText(R.string.kyb_frozen_title);
        TextView textView2 = this.getOnBoardingScenario;
        if (textView2 == null) {
            int i3 = I + 59;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView2 = null;
        }
        textView2.setText(R.string.kyb_frozen_message);
        DanaButtonPrimaryView danaButtonPrimaryView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (danaButtonPrimaryView == null) {
            int i5 = AppCompatEmojiTextHelper + 71;
            I = i5 % 128;
            if (!(i5 % 2 != 0)) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i6 = 39 / 0;
            }
            danaButtonPrimaryView = null;
        }
        danaButtonPrimaryView.setContentDescription(getString(R.string.btn_call_cs_freeze));
        danaButtonPrimaryView.setActiveButton(getString(R.string.kyb_frozen_button), null);
        danaButtonPrimaryView.setVisibility(0);
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment.this);
            }
        });
    }

    private static final void N(MyBusinessFragment myBusinessFragment) {
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        FragmentPermissionRequest fragmentPermissionRequest = myBusinessFragment.A;
        Object obj = null;
        if (!(fragmentPermissionRequest != null)) {
            int i = AppCompatEmojiTextHelper + 115;
            I = i % 128;
            if ((i % 2 != 0 ? 'J' : '\r') != '\r') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                obj.hashCode();
            } else {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                int i2 = I + 27;
                AppCompatEmojiTextHelper = i2 % 128;
                int i3 = i2 % 2;
                fragmentPermissionRequest = null;
            } catch (Exception e2) {
                throw e2;
            }
        }
        fragmentPermissionRequest.check();
        int i4 = AppCompatEmojiTextHelper + 3;
        I = i4 % 128;
        int i5 = i4 % 2;
    }

    private final void MyBillsEntityDataFactory(boolean z) {
        int i = I + 119;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        ImageView imageView = this.getErrorConfigVersion;
        Object[] objArr = null;
        if ((imageView == null ? Typography.dollar : '1') == '$') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            imageView = null;
        }
        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_kyb_revoke);
        TextView textView = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (!(textView != null)) {
            int i3 = AppCompatEmojiTextHelper + 91;
            I = i3 % 128;
            if ((i3 % 2 != 0 ? 'H' : '\f') != '\f') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int length = objArr.length;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            textView = null;
        }
        textView.setText(R.string.kyb_revoke_title);
        DanaButtonPrimaryView danaButtonPrimaryView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(danaButtonPrimaryView != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaButtonPrimaryView = null;
        }
        danaButtonPrimaryView.setVisibility(0);
        if (z) {
            TextView textView2 = this.getOnBoardingScenario;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView2 = null;
            }
            textView2.setText(R.string.kyb_kyc_revoke_message);
            DanaButtonPrimaryView danaButtonPrimaryView2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (danaButtonPrimaryView2 == null) {
                int i4 = AppCompatEmojiTextHelper + 111;
                I = i4 % 128;
                int i5 = i4 % 2;
                Intrinsics.throwUninitializedPropertyAccessException("");
                danaButtonPrimaryView2 = null;
            }
            danaButtonPrimaryView2.setContentDescription(getString(R.string.btn_new_register_kyc));
            danaButtonPrimaryView2.setActiveButton(getString(R.string.kyb_kyc_revoke_button), null);
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyBusinessFragment.moveToNextValue(MyBusinessFragment.this);
                }
            });
            return;
        }
        TextView textView3 = this.getOnBoardingScenario;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView3 = null;
        }
        textView3.setText(R.string.kyb_revoke_message);
        DanaButtonPrimaryView danaButtonPrimaryView3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((danaButtonPrimaryView3 == null ? 'Z' : '*') == 'Z') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaButtonPrimaryView3 = null;
        }
        danaButtonPrimaryView3.setContentDescription(getString(R.string.btn_new_register_kyb));
        danaButtonPrimaryView3.setActiveButton(getString(R.string.kyb_revoke_button), null);
        danaButtonPrimaryView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.lookAheadTest(MyBusinessFragment.this);
            }
        });
    }

    private static final void isAuth(MyBusinessFragment myBusinessFragment) {
        int i = I + 119;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        myBusinessFragment.K();
        int i3 = AppCompatEmojiTextHelper + 103;
        I = i3 % 128;
        if ((i3 % 2 != 0 ? '@' : '3') != '3') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private static final void R(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 95;
        I = i % 128;
        if ((i % 2 != 0 ? '@' : '\r') != '@') {
            try {
                Intrinsics.checkNotNullParameter(myBusinessFragment, "");
                myBusinessFragment.J();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        myBusinessFragment.J();
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void J() {
        PlaceComponentResult(KybUrlsDataManager.getAuthRequestContext(), new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$openKybRegistrationRevoke$1
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
                MyBusinessFragment.VerifyPinStateManager$executeRiskChallenge$2$1(MyBusinessFragment.this);
            }
        });
        try {
            int i = I + 39;
            AppCompatEmojiTextHelper = i % 128;
            if ((i % 2 == 0 ? (char) 24 : JSONLexer.EOI) != 26) {
                int i2 = 90 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void A() {
        try {
            int i = AppCompatEmojiTextHelper + 111;
            I = i % 128;
            if (!(i % 2 != 0)) {
                PlaceComponentResult().get().getAuthRequestContext();
                BottomSheetCardBindingView$watcherCardNumberView$1();
                return;
            }
            try {
                PlaceComponentResult().get().getAuthRequestContext();
                BottomSheetCardBindingView$watcherCardNumberView$1();
                int i2 = 72 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void BottomSheetCardBindingView$watcherCardNumberView$1() {
        try {
            int i = AppCompatEmojiTextHelper + 91;
            I = i % 128;
            int i2 = i % 2;
            DanaButtonPrimaryView danaButtonPrimaryView = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if ((danaButtonPrimaryView != null ? '\\' : '`') != '`') {
                Object[] objArr = null;
                if (danaButtonPrimaryView == null) {
                    try {
                        int i3 = AppCompatEmojiTextHelper + 3;
                        I = i3 % 128;
                        int i4 = i3 % 2;
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        if (i4 != 0) {
                            int length = objArr.length;
                        }
                        int i5 = I + 61;
                        AppCompatEmojiTextHelper = i5 % 128;
                        int i6 = i5 % 2;
                        danaButtonPrimaryView = null;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                danaButtonPrimaryView.setVisibility(8);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0018, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x001e, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0020, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void SummaryVoucherView$$ExternalSyntheticLambda0() {
        /*
            r6 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r3 = ""
            r4 = 0
            if (r0 == r1) goto L1b
            android.widget.TextView r0 = r6.VerifyPinStateManager$executeRiskChallenge$2$2
            if (r0 != 0) goto L24
            goto L20
        L1b:
            android.widget.TextView r0 = r6.VerifyPinStateManager$executeRiskChallenge$2$2
            int r1 = r4.length     // Catch: java.lang.Throwable -> L78
            if (r0 != 0) goto L24
        L20:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L24:
            r1 = 2131954645(0x7f130bd5, float:1.9545795E38)
            r0.setText(r1)
            android.widget.TextView r0 = r6.getOnBoardingScenario
            if (r0 != 0) goto L3c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r0 = r4
        L3c:
            r1 = 2131954644(0x7f130bd4, float:1.9545793E38)
            r0.setText(r1)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 45
            if (r0 != 0) goto L4b
            r5 = 45
            goto L4d
        L4b:
            r5 = 10
        L4d:
            if (r5 == r1) goto L51
            r4 = r0
            goto L70
        L51:
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 9
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r1 = 94
            if (r0 == 0) goto L62
            r0 = 94
            goto L64
        L62:
            r0 = 64
        L64:
            if (r0 == r1) goto L6a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L70
        L6a:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = 37
            int r0 = r0 / r2
        L70:
            r0 = 8
            r4.setVisibility(r0)
            return
        L76:
            r0 = move-exception
            throw r0
        L78:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.SummaryVoucherView$$ExternalSyntheticLambda0():void");
    }

    private final void O() {
        RecyclerView recyclerView = this.B;
        Object[] objArr = null;
        if ((recyclerView == null ? 'J' : (char) 29) != 29) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recyclerView = null;
        }
        recyclerView.setAdapter(KClassImpl$Data$declaredNonStaticMembers$2().get());
        ImageView imageView = this.getErrorConfigVersion;
        if ((imageView == null ? 'A' : '_') == 'A') {
            int i = I + 105;
            AppCompatEmojiTextHelper = i % 128;
            if (!(i % 2 != 0)) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int length = objArr.length;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            int i2 = AppCompatEmojiTextHelper + 39;
            I = i2 % 128;
            int i3 = i2 % 2;
            imageView = null;
        }
        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_kyb_reject);
        TextView textView = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (textView == null) {
            int i4 = AppCompatEmojiTextHelper + 47;
            I = i4 % 128;
            if (i4 % 2 != 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i5 = 10 / 0;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            textView = null;
        }
        textView.setText(R.string.kyb_rejected_title);
        TextView textView2 = this.getOnBoardingScenario;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView2 = null;
        }
        textView2.setText(R.string.kyb_rejected_message);
        RecyclerView recyclerView2 = this.B;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(0);
        DanaButtonPrimaryView danaButtonPrimaryView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((danaButtonPrimaryView == null ? '[' : (char) 29) == '[') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaButtonPrimaryView = null;
        }
        danaButtonPrimaryView.setContentDescription(getString(R.string.btn_register_reject_kyb));
        danaButtonPrimaryView.setActiveButton(getString(R.string.kyb_rejected_button), null);
        danaButtonPrimaryView.setVisibility(0);
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.MyBillsEntityDataFactory(MyBusinessFragment.this);
            }
        });
    }

    private static final void S(MyBusinessFragment myBusinessFragment) {
        try {
            int i = I + 29;
            AppCompatEmojiTextHelper = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(myBusinessFragment, "");
            myBusinessFragment.getNameOrBuilderList();
            int i3 = AppCompatEmojiTextHelper + 11;
            I = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 80 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void getNameOrBuilderList() {
        try {
            PlaceComponentResult(KybUrlsDataManager.PlaceComponentResult(), new Function0<Unit>() { // from class: id.dana.kyb.view.MyBusinessFragment$openKybRegistrationRejectContainer$1
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
                    MyBusinessFragment.VerifyPinStateManager$executeRiskChallenge$2$1(MyBusinessFragment.this);
                }
            });
            int i = AppCompatEmojiTextHelper + 13;
            I = i % 128;
            if (!(i % 2 != 0)) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void P() {
        ImageView imageView = this.getErrorConfigVersion;
        Object obj = null;
        if (imageView == null) {
            int i = AppCompatEmojiTextHelper + 13;
            I = i % 128;
            int i2 = i % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            imageView = null;
        }
        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_kyb_general_error);
        TextView textView = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (textView == null) {
            int i3 = AppCompatEmojiTextHelper + 115;
            I = i3 % 128;
            if ((i3 % 2 != 0 ? '`' : (char) 20) != 20) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                obj.hashCode();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            int i4 = I + 23;
            AppCompatEmojiTextHelper = i4 % 128;
            int i5 = i4 % 2;
            textView = null;
        }
        textView.setText(R.string.kyb_error_title);
        TextView textView2 = this.getOnBoardingScenario;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView2 = null;
        }
        textView2.setText(R.string.kyb_error_message);
        DanaButtonPrimaryView danaButtonPrimaryView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (danaButtonPrimaryView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaButtonPrimaryView = null;
        }
        danaButtonPrimaryView.setActiveButton(getString(R.string.kyb_error_button), null);
        DanaButtonPrimaryView danaButtonPrimaryView2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (danaButtonPrimaryView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaButtonPrimaryView2 = null;
        }
        danaButtonPrimaryView2.setVisibility(0);
        DanaButtonPrimaryView danaButtonPrimaryView3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (danaButtonPrimaryView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaButtonPrimaryView3 = null;
        }
        danaButtonPrimaryView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this);
            }
        });
        int i6 = AppCompatEmojiTextHelper + 39;
        I = i6 % 128;
        if ((i6 % 2 != 0 ? 'N' : '\r') != 'N') {
            return;
        }
        obj.hashCode();
    }

    private static final void O(MyBusinessFragment myBusinessFragment) {
        int i = I + 7;
        AppCompatEmojiTextHelper = i % 128;
        if (i % 2 == 0) {
            try {
                Intrinsics.checkNotNullParameter(myBusinessFragment, "");
                myBusinessFragment.PlaceComponentResult().get().getAuthRequestContext();
                Object[] objArr = null;
                int length = objArr.length;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        myBusinessFragment.PlaceComponentResult().get().getAuthRequestContext();
    }

    private final void MyBillsEntityDataFactory(int i) {
        ImageView imageView = this.scheduleImpl;
        int i2 = 0;
        if (imageView == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView = null;
                try {
                    int i3 = I + 103;
                    AppCompatEmojiTextHelper = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        ImageView imageView2 = imageView;
        if (i == 0) {
            int i5 = I + 21;
            AppCompatEmojiTextHelper = i5 % 128;
            int i6 = i5 % 2;
        } else {
            i2 = 8;
        }
        imageView2.setVisibility(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0030, code lost:
    
        if (scheduleImpl(r0) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0040, code lost:
    
        if ((scheduleImpl(r0) ? kotlin.text.Typography.amp : '_') != '&') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0043, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void H() {
        /*
            r6 = this;
            r6.Z()
            id.dana.kyb.view.richview.MyBusinessBalanceView r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda4
            r1 = 78
            if (r0 != 0) goto Lc
            r2 = 60
            goto Le
        Lc:
            r2 = 78
        Le:
            r3 = 0
            if (r2 == r1) goto L17
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r3
        L17:
            r1 = 0
            r0.setBalanceWithdrawClickable(r1)
            id.dana.kyb.model.KybCompleteInfoModel r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            r2 = 1
            if (r0 == 0) goto L47
            int r4 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r4 = r4 + 119
            int r5 = r4 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L33
            boolean r0 = scheduleImpl(r0)
            if (r0 != 0) goto L47
            goto L43
        L33:
            boolean r0 = scheduleImpl(r0)     // Catch: java.lang.Exception -> L45
            r4 = 38
            if (r0 != r2) goto L3e
            r0 = 38
            goto L40
        L3e:
            r0 = 95
        L40:
            if (r0 == r4) goto L43
            goto L47
        L43:
            r0 = 1
            goto L48
        L45:
            r0 = move-exception
            throw r0
        L47:
            r0 = 0
        L48:
            if (r0 == 0) goto L4c
            r0 = 1
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 == 0) goto L66
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 33
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L62
            r6.DatabaseTableConfigUtil()
            int r0 = r3.length     // Catch: java.lang.Throwable -> L60
            goto L65
        L60:
            r0 = move-exception
            throw r0
        L62:
            r6.DatabaseTableConfigUtil()
        L65:
            return
        L66:
            id.dana.kyb.model.KybCompleteInfoModel r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            if (r0 == 0) goto L85
            boolean r0 = NetworkUserEntityData$$ExternalSyntheticLambda0(r0)
            r3 = 62
            if (r0 != r2) goto L75
            r0 = 62
            goto L77
        L75:
            r0 = 16
        L77:
            if (r0 == r3) goto L7a
            goto L85
        L7a:
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 111
            int r3 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r3
            int r0 = r0 % 2
            goto L86
        L85:
            r2 = 0
        L86:
            if (r2 == 0) goto L96
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r6.T()
            return
        L96:
            r6.W()
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 81
            int r2 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r2
            int r0 = r0 % 2
            if (r0 != 0) goto Lab
            r0 = 9
            int r0 = r0 / r1
            return
        La9:
            r0 = move-exception
            throw r0
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.H():void");
    }

    private final void Z() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_BALANCE_WITHDRAW_CLICK;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        int i = AppCompatEmojiTextHelper + 5;
        I = i % 128;
        if ((i % 2 != 0 ? (byte) 1 : (byte) 0) != 1) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x001f, code lost:
    
        if ((r0 != null ? ']' : 28) != 28) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x002c, code lost:
    
        if ((r0 == null) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002e, code lost:
    
        r1 = PlaceComponentResult().get();
        r2 = id.dana.kyb.helper.KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2.getWithdraw();
        r1.BuiltInFictitiousFunctionClassFactory(r2, r0.NetworkUserEntityData$$ExternalSyntheticLambda1, r0.GetContactSyncConfig);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0043, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 47;
        id.dana.kyb.view.MyBusinessFragment.I = r0 % 128;
        r0 = r0 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void DatabaseTableConfigUtil() {
        /*
            r4 = this;
            id.dana.kyb.model.KybCompleteInfoModel r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2
            if (r0 == 0) goto L4d
            int r1 = id.dana.kyb.view.MyBusinessFragment.I
            int r1 = r1 + 35
            int r2 = r1 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L24
            id.dana.kyb.model.KybMerchantInfoModel r0 = r0.BuiltInFictitiousFunctionClassFactory
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L22
            r1 = 28
            if (r0 == 0) goto L1d
            r2 = 93
            goto L1f
        L1d:
            r2 = 28
        L1f:
            if (r2 == r1) goto L4d
            goto L2e
        L22:
            r0 = move-exception
            throw r0
        L24:
            id.dana.kyb.model.KybMerchantInfoModel r0 = r0.BuiltInFictitiousFunctionClassFactory
            r1 = 1
            if (r0 == 0) goto L2b
            r2 = 0
            goto L2c
        L2b:
            r2 = 1
        L2c:
            if (r2 == r1) goto L4d
        L2e:
            dagger.Lazy r1 = r4.PlaceComponentResult()
            java.lang.Object r1 = r1.get()
            id.dana.kyb.KybContract$Presenter r1 = (id.dana.kyb.KybContract.Presenter) r1
            java.lang.String r2 = id.dana.kyb.helper.KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.String r3 = r0.NetworkUserEntityData$$ExternalSyntheticLambda1
            java.lang.String r0 = r0.GetContactSyncConfig
            r1.BuiltInFictitiousFunctionClassFactory(r2, r3, r0)
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper     // Catch: java.lang.Exception -> L58
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1     // Catch: java.lang.Exception -> L58
            int r0 = r0 % 2
        L4d:
            int r0 = id.dana.kyb.view.MyBusinessFragment.I     // Catch: java.lang.Exception -> L58
            int r0 = r0 + 57
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1     // Catch: java.lang.Exception -> L58
            int r0 = r0 % 2
            return
        L58:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.DatabaseTableConfigUtil():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i = I + 103;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        KybCompleteInfoModel kybCompleteInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if ((kybCompleteInfoModel != null ? 'U' : '1') != 'U') {
            return;
        }
        KybMerchantInfoModel kybMerchantInfoModel = kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory;
        if ((kybMerchantInfoModel != null ? 'O' : '0') != 'O') {
            return;
        }
        PlaceComponentResult().get().MyBillsEntityDataFactory(KybUrlsDataManager.NetworkUserEntityData$$ExternalSyntheticLambda0(), kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1, kybMerchantInfoModel.GetContactSyncConfig);
        int i3 = I + 67;
        AppCompatEmojiTextHelper = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0019, code lost:
    
        if ((r0 != null) != true) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x001f, code lost:
    
        if (r0 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0021, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0025, code lost:
    
        if (r0 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0027, code lost:
    
        r2 = 'C';
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002a, code lost:
    
        r2 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002c, code lost:
    
        if (r2 == 'C') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002f, code lost:
    
        PlaceComponentResult().get().PlaceComponentResult(id.dana.kyb.helper.KybUrlsDataManager.MyBillsEntityDataFactory(), r0.NetworkUserEntityData$$ExternalSyntheticLambda1, r0.GetContactSyncConfig);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0044, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.I + 93;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x004e, code lost:
    
        if ((r0 % 2) != 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0050, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0051, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0054, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        /*
            r5 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
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
            if (r0 == 0) goto L1c
            id.dana.kyb.model.KybCompleteInfoModel r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda2
            if (r0 == 0) goto L19
            r1 = 1
        L19:
            if (r1 == r2) goto L21
            goto L44
        L1c:
            id.dana.kyb.model.KybCompleteInfoModel r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r1 = r3.length     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L44
        L21:
            id.dana.kyb.model.KybMerchantInfoModel r0 = r0.BuiltInFictitiousFunctionClassFactory
            r1 = 67
            if (r0 == 0) goto L2a
            r2 = 67
            goto L2c
        L2a:
            r2 = 78
        L2c:
            if (r2 == r1) goto L2f
            goto L44
        L2f:
            dagger.Lazy r1 = r5.PlaceComponentResult()
            java.lang.Object r1 = r1.get()
            id.dana.kyb.KybContract$Presenter r1 = (id.dana.kyb.KybContract.Presenter) r1
            java.lang.String r2 = id.dana.kyb.helper.KybUrlsDataManager.MyBillsEntityDataFactory()
            java.lang.String r4 = r0.NetworkUserEntityData$$ExternalSyntheticLambda1
            java.lang.String r0 = r0.GetContactSyncConfig
            r1.PlaceComponentResult(r2, r4, r0)
        L44:
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            int r0 = r3.length     // Catch: java.lang.Throwable -> L52
            return
        L52:
            r0 = move-exception
            throw r0
        L54:
            return
        L55:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda7():void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kyb.view.MyBusinessFragment$createKybTieringListener$1] */
    private final MyBusinessFragment$createKybTieringListener$1 initRecordTimeStamp() {
        ?? r0 = new KybTieringListener() { // from class: id.dana.kyb.view.MyBusinessFragment$createKybTieringListener$1
            @Override // id.dana.kyb.view.MyBusinessFragment.KybTieringListener
            public final void PlaceComponentResult() {
                MyBusinessFragment.getOnBoardingScenario(MyBusinessFragment.this);
            }
        };
        int i = I + 13;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kyb.view.MyBusinessFragment$getPtrHandler$1] */
    private final MyBusinessFragment$getPtrHandler$1 whenAvailable() {
        ?? r0 = new PtrHandler() { // from class: id.dana.kyb.view.MyBusinessFragment$getPtrHandler$1
            @Override // in.srain.cube.views.ptr.PtrHandler
            public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                return true;
            }

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final void onRefreshBegin(PtrFrameLayout p0) {
                if (MyBusinessFragment.C(MyBusinessFragment.this)) {
                    LottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda4 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(MyBusinessFragment.this);
                    if (NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda4.playAnimation();
                }
                MyBusinessFragment.this.PlaceComponentResult().get().getAuthRequestContext();
            }
        };
        try {
            int i = AppCompatEmojiTextHelper + 3;
            I = i % 128;
            int i2 = i % 2;
            return r0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kyb.view.MyBusinessFragment$getPtrUiHandler$1] */
    private final MyBusinessFragment$getPtrUiHandler$1 getSupportButtonTintMode() {
        ?? r0 = new PtrUIHandler() { // from class: id.dana.kyb.view.MyBusinessFragment$getPtrUiHandler$1
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
                if (!(MyBusinessFragment.this.getParentFragment() instanceof MyProfileMainFragment) || (myProfileMainFragment = (MyProfileMainFragment) MyBusinessFragment.this.getParentFragment()) == null) {
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
                if (!(MyBusinessFragment.this.getParentFragment() instanceof MyProfileMainFragment) || (myProfileMainFragment = (MyProfileMainFragment) MyBusinessFragment.this.getParentFragment()) == null) {
                    return;
                }
                FragmentMyprofileMainBinding binding = myProfileMainFragment.getBinding();
                ViewPager2 viewPager2 = binding != null ? binding.MyBillsEntityDataFactory : null;
                if (viewPager2 != null) {
                    viewPager2.setUserInputEnabled(false);
                }
            }
        };
        int i = AppCompatEmojiTextHelper + 75;
        I = i % 128;
        if ((i % 2 != 0 ? (char) 4 : '%') != 4) {
            return r0;
        }
        int i2 = 12 / 0;
        return r0;
    }

    private final void c() {
        try {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
            try {
                builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_REQUEST_PAYMENT_CLICK;
                builder.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
                int i = AppCompatEmojiTextHelper + 17;
                I = i % 128;
                if ((i % 2 == 0 ? (byte) 1 : (byte) 0) != 0) {
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

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kyb.view.MyBusinessFragment$createKycUpgradeListener$1] */
    private final MyBusinessFragment$createKycUpgradeListener$1 NetworkUserEntityData$$ExternalSyntheticLambda2() {
        ?? r0 = new KycUpgradeListener() { // from class: id.dana.kyb.view.MyBusinessFragment$createKycUpgradeListener$1
            @Override // id.dana.kyb.view.MyBusinessFragment.KycUpgradeListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                MyBusinessFragment.E(MyBusinessFragment.this);
            }
        };
        int i = AppCompatEmojiTextHelper + 7;
        I = i % 128;
        int i2 = i % 2;
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kyb.view.MyBusinessFragment$createKybOpenH5Listener$1] */
    private final MyBusinessFragment$createKybOpenH5Listener$1 NetworkUserEntityData$$ExternalSyntheticLambda1() {
        ?? r0 = new KybOpenH5Listener() { // from class: id.dana.kyb.view.MyBusinessFragment$createKybOpenH5Listener$1
            @Override // id.dana.kyb.view.MyBusinessFragment.KybOpenH5Listener
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(MyBusinessFragment.this, p0);
            }
        };
        int i = I + 21;
        AppCompatEmojiTextHelper = i % 128;
        if (i % 2 == 0) {
            int i2 = 87 / 0;
            return r0;
        }
        return r0;
    }

    private final void K() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(getAuthRequestContext().get().getKycFromKybUrl());
        BuiltInFictitiousFunctionClassFactory(this, sb.toString());
        int i = AppCompatEmojiTextHelper + 51;
        I = i % 128;
        if ((i % 2 != 0 ? '%' : '`') != '%') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private final void M() {
        int i = AppCompatEmojiTextHelper + 97;
        I = i % 128;
        if (i % 2 != 0) {
            BuiltInFictitiousFunctionClassFactory(this, KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_TIERING));
            int i2 = 38 / 0;
        } else {
            BuiltInFictitiousFunctionClassFactory(this, KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_TIERING));
        }
        int i3 = I + 93;
        AppCompatEmojiTextHelper = i3 % 128;
        if ((i3 % 2 == 0 ? '=' : '[') != '=') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void SummaryVoucherView$$ExternalSyntheticLambda1() {
        /*
            r4 = this;
            id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda6
            if (r0 != 0) goto L22
            id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet r0 = new id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet
            r0.<init>()
            id.dana.kyb.view.MyBusinessFragment$createKycUpgradeListener$1 r1 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2()
            id.dana.kyb.view.MyBusinessFragment$KycUpgradeListener r1 = (id.dana.kyb.view.MyBusinessFragment.KycUpgradeListener) r1
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r4.NetworkUserEntityData$$ExternalSyntheticLambda6 = r0
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
        L22:
            id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda6     // Catch: java.lang.Exception -> L7c
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L48
            boolean r0 = r0.isVisible()
            if (r0 != 0) goto L30
            r0 = 0
            goto L31
        L30:
            r0 = 1
        L31:
            if (r0 == 0) goto L34
            goto L48
        L34:
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 115
            int r3 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r3
            int r0 = r0 % 2
            r3 = 92
            if (r0 != 0) goto L44
            r0 = 5
            goto L46
        L44:
            r0 = 92
        L46:
            r0 = 1
            goto L49
        L48:
            r0 = 0
        L49:
            if (r0 == 0) goto L7b
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 99
            int r3 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r3
            int r0 = r0 % 2
            id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda6     // Catch: java.lang.Exception -> L7c
            if (r0 == 0) goto L7b
            android.content.Context r3 = r4.getContext()
            if (r3 == 0) goto L60
            goto L61
        L60:
            r2 = 1
        L61:
            if (r2 == r1) goto L73
            androidx.fragment.app.FragmentActivity r3 = (androidx.fragment.app.FragmentActivity) r3
            androidx.fragment.app.FragmentManager r1 = r3.getSupportFragmentManager()
            id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet$Companion r2 = id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet.INSTANCE
            java.lang.String r2 = id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet.Companion.MyBillsEntityDataFactory()
            r0.show(r1, r2)
            return
        L73:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"
            r0.<init>(r1)
            throw r0
        L7b:
            return
        L7c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.SummaryVoucherView$$ExternalSyntheticLambda1():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0021, code lost:
    
        if ((r2 != null ? 'S' : ':') != ':') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0033, code lost:
    
        if ((r2 != null) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0035, code lost:
    
        r3 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 115;
        id.dana.kyb.view.MyBusinessFragment.I = r3 % 128;
        r3 = r3 % 2;
        r2 = ((androidx.fragment.app.FragmentActivity) r2).getSupportFragmentManager();
        r3 = id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet.INSTANCE;
        r0.show(r2, id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet.Companion.MyBillsEntityDataFactory());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x004e, code lost:
    
        r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 87;
        id.dana.kyb.view.MyBusinessFragment.I = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x005a, code lost:
    
        if ((r0 % 2) == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x005c, code lost:
    
        r0 = 'c';
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x005f, code lost:
    
        r0 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0061, code lost:
    
        if (r0 == 'c') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0066, code lost:
    
        r0 = 66 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0067, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x006a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x006b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0073, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void isAuth() {
        /*
            r5 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 103
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L26
            id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda3()
            android.content.Context r2 = r5.getContext()
            r3 = 91
            int r3 = r3 / r1
            r3 = 58
            if (r2 == 0) goto L1f
            r4 = 83
            goto L21
        L1f:
            r4 = 58
        L21:
            if (r4 == r3) goto L6c
            goto L35
        L24:
            r0 = move-exception
            throw r0
        L26:
            id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda3()
            android.content.Context r2 = r5.getContext()
            if (r2 == 0) goto L32
            r3 = 1
            goto L33
        L32:
            r3 = 0
        L33:
            if (r3 == 0) goto L6c
        L35:
            int r3 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper     // Catch: java.lang.Exception -> L6a
            int r3 = r3 + 115
            int r4 = r3 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r4     // Catch: java.lang.Exception -> L6a
            int r3 = r3 % 2
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2     // Catch: java.lang.Exception -> L6a
            androidx.fragment.app.FragmentManager r2 = r2.getSupportFragmentManager()     // Catch: java.lang.Exception -> L6a
            id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet$Companion r3 = id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet.INSTANCE     // Catch: java.lang.Exception -> L6a
            java.lang.String r3 = id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet.Companion.MyBillsEntityDataFactory()     // Catch: java.lang.Exception -> L6a
            r0.show(r2, r3)     // Catch: java.lang.Exception -> L6a
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 87
            int r2 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r2
            int r0 = r0 % 2
            r2 = 99
            if (r0 == 0) goto L5f
            r0 = 99
            goto L61
        L5f:
            r0 = 64
        L61:
            if (r0 == r2) goto L64
            return
        L64:
            r0 = 66
            int r0 = r0 / r1
            return
        L68:
            r0 = move-exception
            throw r0
        L6a:
            r0 = move-exception
            throw r0
        L6c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.isAuth():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0023, code lost:
    
        if ((r0 != null ? '!' : 31) != 31) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x003b, code lost:
    
        if ((r0 != null ? 23 : '-') == 23) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x003d, code lost:
    
        r0 = ((androidx.fragment.app.FragmentActivity) r0).getSupportFragmentManager();
        r1 = id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.Companion;
        r4.show(r0, id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x004c, code lost:
    
        r4 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper + 63;
        id.dana.kyb.view.MyBusinessFragment.I = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0057, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0058, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0060, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(id.dana.kyb.model.KybServiceMessageModel r4) {
        /*
            r3 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L28
            id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet$Companion r0 = id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.INSTANCE
            id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet r4 = id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r4)
            android.content.Context r0 = r3.getContext()
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L26
            r1 = 31
            if (r0 == 0) goto L21
            r2 = 33
            goto L23
        L21:
            r2 = 31
        L23:
            if (r2 == r1) goto L59
            goto L3d
        L26:
            r4 = move-exception
            throw r4
        L28:
            id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet$Companion r0 = id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.INSTANCE
            id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet r4 = id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r4)
            android.content.Context r0 = r3.getContext()
            r1 = 23
            if (r0 == 0) goto L39
            r2 = 23
            goto L3b
        L39:
            r2 = 45
        L3b:
            if (r2 != r1) goto L59
        L3d:
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0     // Catch: java.lang.Exception -> L57
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()     // Catch: java.lang.Exception -> L57
            id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet$Companion r1 = id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.INSTANCE     // Catch: java.lang.Exception -> L57
            java.lang.String r1 = id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet.Companion.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> L57
            r4.show(r0, r1)     // Catch: java.lang.Exception -> L57
            int r4 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r4 = r4 + 63
            int r0 = r4 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r0
            int r4 = r4 % 2
            return
        L57:
            r4 = move-exception
            throw r4
        L59:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(id.dana.kyb.model.KybServiceMessageModel):void");
    }

    private final void T() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
        builder.FragmentBottomSheetPaymentSettingBinding = getString(R.string.reactive_face_verification_title);
        String string = getString(R.string.lbl_enable_pop_up_title);
        String string2 = getString(R.string.lbl_enable_pop_up_desc);
        builder.SubSequence = string;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = string2;
        builder.getErrorConfigVersion = getString(R.string.reactive_face_verification_message);
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string3 = getString(R.string.reactive_face_verification_button_positive);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBusinessFragment.this);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string3;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        MyBillsEntityDataFactory.PrepareContext = getString(R.string.btn_enable_face_auth);
        String string4 = getString(R.string.reactive_face_verification_button_negative);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment.PlaceComponentResult(MyBusinessFragment.this);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string4;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
        MyBillsEntityDataFactory.GetContactSyncConfig = getString(R.string.btn_cancel_enable_face_auth);
        MyBillsEntityDataFactory.initRecordTimeStamp = true;
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = new DialogInterface.OnCancelListener() { // from class: id.dana.kyb.view.MyBusinessFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                MyBusinessFragment.scheduleImpl(MyBusinessFragment.this);
            }
        };
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
        int i = AppCompatEmojiTextHelper + 47;
        I = i % 128;
        if ((i % 2 != 0 ? ';' : 'c') != ';') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private static final void SummaryVoucherView$$ExternalSyntheticLambda1(MyBusinessFragment myBusinessFragment) {
        int i = I + 23;
        AppCompatEmojiTextHelper = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        MyBusinessBalanceView myBusinessBalanceView = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (!(myBusinessBalanceView != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBusinessBalanceView = null;
        }
        myBusinessBalanceView.setBalanceWithdrawClickable(true);
        myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        SwitchFaceAuthContract.Presenter presenter = myBusinessFragment.MyBillsEntityDataFactory().get();
        FragmentActivity requireActivity = myBusinessFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        presenter.MyBillsEntityDataFactory(true, null, requireActivity);
        int i3 = AppCompatEmojiTextHelper + 49;
        I = i3 % 128;
        int i4 = i3 % 2;
    }

    private static final void T(MyBusinessFragment myBusinessFragment) {
        int i = AppCompatEmojiTextHelper + 53;
        I = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        MyBusinessBalanceView myBusinessBalanceView = myBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (myBusinessBalanceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBusinessBalanceView = null;
            try {
                int i3 = AppCompatEmojiTextHelper + 35;
                I = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        myBusinessBalanceView.setBalanceWithdrawClickable(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0024, code lost:
    
        if ((r4 == null) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0037, code lost:
    
        if ((r4 == null ? 'Y' : '!') != '!') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0039, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void X(id.dana.kyb.view.MyBusinessFragment r4) {
        /*
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r1 = 13
            if (r0 == 0) goto L11
            r0 = 48
            goto L13
        L11:
            r0 = 13
        L13:
            r2 = 1
            java.lang.String r3 = ""
            if (r0 == r1) goto L29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            id.dana.kyb.view.richview.MyBusinessBalanceView r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4
            r0 = 69
            r1 = 0
            int r0 = r0 / r1
            if (r4 != 0) goto L24
            r1 = 1
        L24:
            if (r1 == 0) goto L3d
            goto L39
        L27:
            r4 = move-exception
            throw r4
        L29:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            id.dana.kyb.view.richview.MyBusinessBalanceView r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4
            r0 = 33
            if (r4 != 0) goto L35
            r1 = 89
            goto L37
        L35:
            r1 = 33
        L37:
            if (r1 == r0) goto L3d
        L39:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r4 = 0
        L3d:
            r4.setBalanceWithdrawClickable(r2)
            int r4 = id.dana.kyb.view.MyBusinessFragment.I
            int r4 = r4 + 55
            int r0 = r4 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r0
            int r4 = r4 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.X(id.dana.kyb.view.MyBusinessFragment):void");
    }

    private final void W() {
        int i = AppCompatEmojiTextHelper + 25;
        I = i % 128;
        int i2 = i % 2;
        WithdrawBalanceFaceAuthActivationBottomSheet VerifyPinStateManager$executeRiskChallenge$2$1 = VerifyPinStateManager$executeRiskChallenge$2$1();
        Context context = getContext();
        if ((context != null ? '6' : '\f') != '\f') {
            VerifyPinStateManager$executeRiskChallenge$2$1.show(((FragmentActivity) context).getSupportFragmentManager(), "WithdrawBalanceFaceAuthActivationBottomSheet");
            int i3 = I + 41;
            AppCompatEmojiTextHelper = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0040, code lost:
    
        r7 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0041, code lost:
    
        if (r6 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0043, code lost:
    
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0045, code lost:
    
        r7 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0047, code lost:
    
        if (r7 != 2) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x004c, code lost:
    
        r0 = (android.view.ViewGroup) r0;
        r5 = r0.indexOfChild(r9);
        r6 = r9.getLayoutParams();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0056, code lost:
    
        if (r6 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0058, code lost:
    
        r7 = id.dana.kyb.view.MyBusinessFragment.I + 53;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0061, code lost:
    
        if ((r7 % 2) != 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0063, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0065, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0066, code lost:
    
        if (r7 == true) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0068, code lost:
    
        r0.removeView(r9);
        r10.setId(r9.getId());
        r0.addView(r10, r5, (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x007b, code lost:
    
        r9 = 12 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x007f, code lost:
    
        r0.removeView(r9);
        r10.setId(r9.getId());
        r0.addView(r10, r5, (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0090, code lost:
    
        r9 = id.dana.kyb.view.MyBusinessFragment.I + 63;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0099, code lost:
    
        if ((r9 % 2) != 0) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x009b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x009c, code lost:
    
        if (r2 == true) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x009e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x009f, code lost:
    
        r9 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00a0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00aa, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00b2, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0018, code lost:
    
        if (r0 != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0022, code lost:
    
        if (r0 != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0024, code lost:
    
        r5 = id.dana.kyb.view.MyBusinessFragment.I + 39;
        id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x002e, code lost:
    
        if ((r5 % 2) != 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0030, code lost:
    
        r5 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0033, code lost:
    
        r5 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0034, code lost:
    
        if (r5 == 6) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0036, code lost:
    
        r0 = (android.view.ViewGroup) r0;
        r5 = r0.indexOfChild(r9);
        r6 = r9.getLayoutParams();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void KClassImpl$Data$declaredNonStaticMembers$2(android.view.View r9, android.view.View r10) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.KClassImpl$Data$declaredNonStaticMembers$2(android.view.View, android.view.View):void");
    }

    private static String moveToNextValue(KybCompleteInfoModel kybCompleteInfoModel) {
        try {
            int i = I + 57;
            AppCompatEmojiTextHelper = i % 128;
            int i2 = i % 2;
            KybMerchantInfoModel kybMerchantInfoModel = kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory;
            if (kybMerchantInfoModel != null) {
                try {
                    String str = kybMerchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (str != null) {
                        return str;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            KybInfoModel kybInfoModel = kybCompleteInfoModel.PlaceComponentResult;
            if (kybInfoModel != null) {
                int i3 = I + 65;
                AppCompatEmojiTextHelper = i3 % 128;
                int i4 = i3 % 2;
                String str2 = kybInfoModel.KClassImpl$Data$declaredNonStaticMembers$2;
                int i5 = I + 47;
                AppCompatEmojiTextHelper = i5 % 128;
                int i6 = i5 % 2;
                return str2;
            }
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v12 id.dana.kyb.model.KybMerchantInfoModel, still in use, count: 2, list:
          (r4v12 id.dana.kyb.model.KybMerchantInfoModel) from 0x0010: IF  (r4v12 id.dana.kyb.model.KybMerchantInfoModel) != (null id.dana.kyb.model.KybMerchantInfoModel)  -> B:47:0x0017 A[HIDDEN]
          (r4v12 id.dana.kyb.model.KybMerchantInfoModel) from 0x0017: PHI (r4v9 id.dana.kyb.model.KybMerchantInfoModel) = (r4v1 id.dana.kyb.model.KybMerchantInfoModel), (r4v12 id.dana.kyb.model.KybMerchantInfoModel) binds: [B:46:0x0015, B:43:0x0010] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:33)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:29)
        */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0052 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.kyb.model.KybCompleteInfoModel r4) {
        /*
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 95
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L13
            id.dana.kyb.model.KybMerchantInfoModel r4 = r4.BuiltInFictitiousFunctionClassFactory
            if (r4 == 0) goto L40
            goto L17
        L13:
            id.dana.kyb.model.KybMerchantInfoModel r4 = r4.BuiltInFictitiousFunctionClassFactory
            if (r4 == 0) goto L3f
        L17:
            boolean r0 = r4.getScheduleImpl()
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 == 0) goto L3f
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 33
            int r3 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L30
            r0 = 0
            goto L31
        L30:
            r0 = 1
        L31:
            if (r0 == r1) goto L38
            boolean r4 = r4.getGetAuthRequestContext()
            goto L40
        L38:
            boolean r4 = r4.getGetAuthRequestContext()
            if (r4 != 0) goto L3f
            goto L40
        L3f:
            r1 = 0
        L40:
            int r4 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper     // Catch: java.lang.Exception -> L53
            int r4 = r4 + 101
            int r0 = r4 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r0     // Catch: java.lang.Exception -> L53
            int r4 = r4 % 2
            if (r4 == 0) goto L52
            r4 = 24
            int r4 = r4 / r2
            return r1
        L50:
            r4 = move-exception
            throw r4
        L52:
            return r1
        L53:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.kyb.model.KybCompleteInfoModel):boolean");
    }

    private final void VerifyPinStateManager$executeRiskChallenge$2$2() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.kyb.view.MyBusinessFragment$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                boolean MyBillsEntityDataFactory = p0.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(MyBusinessFragment.this.getBaseActivity(), "1500445", MyBillsEntityDataFactory);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.A = builder.PlaceComponentResult();
        int i = AppCompatEmojiTextHelper + 45;
        I = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment$Companion;", "", "Lid/dana/kyb/model/KybPageInfo;", "p0", "Lid/dana/myprofile/MyProfileMainFragment$SettingsListener;", "p1", "Lid/dana/kyb/view/MyBusinessFragment;", "MyBillsEntityDataFactory", "(Lid/dana/kyb/model/KybPageInfo;Lid/dana/myprofile/MyProfileMainFragment$SettingsListener;)Lid/dana/kyb/view/MyBusinessFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static MyBusinessFragment MyBillsEntityDataFactory(KybPageInfo p0, MyProfileMainFragment.SettingsListener p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            MyBusinessFragment myBusinessFragment = new MyBusinessFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("KYB_PAGE_INFO", p0);
            myBusinessFragment.setArguments(bundle);
            myBusinessFragment.getAuthRequestContext(p1);
            return myBusinessFragment;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0020, code lost:
    
        if ((r0 ? '\b' : 'a') != 'a') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0030, code lost:
    
        if ((r3.NetworkUserEntityData$$ExternalSyntheticLambda1.getKClassImpl$Data$declaredNonStaticMembers$2()) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0032, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r3, id.dana.kyb.helper.KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.data.constant.DanaUrl.KYB_TRANSACTION_PROGRESS));
        r3.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void lookAheadTest() {
        /*
            r3 = this;
            int r0 = id.dana.kyb.view.MyBusinessFragment.I
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L25
            id.dana.kyb.model.KybPageInfo r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            boolean r0 = r0.getKClassImpl$Data$declaredNonStaticMembers$2()
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L23
            r2 = 97
            if (r0 == 0) goto L1e
            r0 = 8
            goto L20
        L1e:
            r0 = 97
        L20:
            if (r0 == r2) goto L3f
            goto L32
        L23:
            r0 = move-exception
            throw r0
        L25:
            id.dana.kyb.model.KybPageInfo r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            boolean r0 = r0.getKClassImpl$Data$declaredNonStaticMembers$2()
            if (r0 == 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            if (r0 == 0) goto L3f
        L32:
            java.lang.String r0 = "/transaction/progressing"
            java.lang.String r0 = id.dana.kyb.helper.KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            BuiltInFictitiousFunctionClassFactory(r3, r0)
            id.dana.kyb.model.KybPageInfo r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
        L3f:
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 75
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.lookAheadTest():void");
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(KybQrisModel kybQrisModel, Bitmap bitmap) {
        int i = AppCompatEmojiTextHelper + 33;
        I = i % 128;
        if ((i % 2 != 0 ? '6' : '[') != '[') {
            Intrinsics.checkNotNullParameter(kybQrisModel, "");
            kybQrisModel.moveToNextValue = bitmap;
            int i2 = 44 / 0;
        } else {
            try {
                Intrinsics.checkNotNullParameter(kybQrisModel, "");
                kybQrisModel.moveToNextValue = bitmap;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = AppCompatEmojiTextHelper + 83;
            I = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0026, code lost:
    
        if ((r0 != null) != true) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0032, code lost:
    
        if ((r0 != null) != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String PlaceComponentResult(id.dana.kyb.model.KybCompleteInfoModel r6) {
        /*
            id.dana.kyb.model.KybMerchantInfoModel r0 = r6.BuiltInFictitiousFunctionClassFactory
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L38
            int r4 = id.dana.kyb.view.MyBusinessFragment.I
            int r4 = r4 + 119
            int r5 = r4 % 128
            id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper = r5
            int r4 = r4 % 2
            r5 = 75
            if (r4 != 0) goto L18
            r4 = 91
            goto L1a
        L18:
            r4 = 75
        L1a:
            if (r4 == r5) goto L2b
            java.lang.String r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r1.hashCode()     // Catch: java.lang.Throwable -> L29
            if (r0 != 0) goto L25
            r4 = 0
            goto L26
        L25:
            r4 = 1
        L26:
            if (r4 == r3) goto L34
            goto L38
        L29:
            r6 = move-exception
            throw r6
        L2b:
            java.lang.String r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L36
            if (r0 != 0) goto L31
            r4 = 0
            goto L32
        L31:
            r4 = 1
        L32:
            if (r4 == 0) goto L38
        L34:
            r1 = r0
            goto L4b
        L36:
            r6 = move-exception
            throw r6
        L38:
            id.dana.kyb.model.KybInfoModel r6 = r6.PlaceComponentResult
            if (r6 == 0) goto L3d
            r2 = 1
        L3d:
            if (r2 == 0) goto L4b
            int r0 = id.dana.kyb.view.MyBusinessFragment.AppCompatEmojiTextHelper
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.kyb.view.MyBusinessFragment.I = r1
            int r0 = r0 % 2
            java.lang.String r1 = r6.MyBillsEntityDataFactory
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment.PlaceComponentResult(id.dana.kyb.model.KybCompleteInfoModel):java.lang.String");
    }

    private static boolean scheduleImpl(KybCompleteInfoModel kybCompleteInfoModel) {
        KybMerchantInfoModel kybMerchantInfoModel = kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory;
        if (kybMerchantInfoModel != null && kybMerchantInfoModel.getScheduleImpl()) {
            int i = AppCompatEmojiTextHelper + 35;
            I = i % 128;
            int i2 = i % 2;
            if (!(!kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext())) {
                int i3 = I + 7;
                AppCompatEmojiTextHelper = i3 % 128;
                if (i3 % 2 == 0) {
                    boolean myBillsEntityDataFactory = kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory();
                    Object obj = null;
                    obj.hashCode();
                    if ((!myBillsEntityDataFactory ? '\'' : '\f') == '\'') {
                        return false;
                    }
                } else if (!kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory()) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private static void e(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? ';' : 'Q') == 'Q') {
                break;
            }
            int i3 = $11 + 63;
            $10 = i3 % 128;
            if (i3 % 2 != 0) {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext | getonboardingscenario.MyBillsEntityDataFactory)) / (4796183387843776835L & F);
                i2 = getonboardingscenario.getAuthRequestContext >>> 0;
            } else {
                jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ F) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                i2 = getonboardingscenario.getAuthRequestContext + 1;
            }
            getonboardingscenario.getAuthRequestContext = i2;
        }
        char[] cArr2 = new char[length];
        try {
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i4 = $10 + 53;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                try {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext++;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
