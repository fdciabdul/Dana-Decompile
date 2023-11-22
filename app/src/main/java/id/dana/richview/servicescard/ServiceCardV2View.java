package id.dana.richview.servicescard;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Lazy;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.SingleItemClickListener;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterViewListener;
import id.dana.contract.services.ServicesContract;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.data.constant.UrlParam;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.databinding.ViewServiceCardV2Binding;
import id.dana.di.component.NewServiceCardComponent;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkListener;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.lib.gcontainer.GContainer;
import id.dana.mapper.ThirdPartyServicesUrlMapper;
import id.dana.model.BannerLottieModel;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.OnboardingParams;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.richview.servicescard.adapter.ServiceShimmerRecycleView;
import id.dana.richview.servicescard.adapter.ServiceV2Adapter;
import id.dana.richview.servicescard.adapter.viewholder.PromotedServiceV2ViewHolder;
import id.dana.richview.servicescard.decorator.ServiceItemDecorator;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.service.ServiceMaintenanceUtil;
import id.dana.service.ServicesActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.spm.ServicesTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.SizeUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.CompletableSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.E;

@Metadata(d1 = {"\u0000§\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b+*\u0001Y\u0018\u0000 ¹\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002¹\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0014\u0010H\u001a\u0004\u0018\u00010\f2\b\u0010I\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010J\u001a\u00020\f2\b\u0010I\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020PH\u0002J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\b\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020\bH\u0016J\b\u0010V\u001a\u00020WH\u0002J\r\u0010X\u001a\u00020YH\u0002¢\u0006\u0002\u0010ZJ\n\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\b\u0010]\u001a\u00020^H\u0002J*\u0010_\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010c\u001a\u00020\u000eH\u0002J\u0010\u0010d\u001a\u00020N2\u0006\u0010e\u001a\u00020\bH\u0002Jx\u0010f\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020j0i2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020N0l2\u001a\u0010m\u001a\u0016\u0012\u0004\u0012\u00020a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020N0n2\u0014\u0010o\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020N0l2\u0018\u0010p\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0q\u0012\u0004\u0012\u00020N0lH\u0002J\b\u0010r\u001a\u00020NH\u0002J\u0006\u0010s\u001a\u00020NJ\u0006\u0010t\u001a\u00020NJ\b\u0010u\u001a\u00020NH\u0002J\u0010\u0010v\u001a\u00020\u00022\u0006\u0010w\u001a\u00020xH\u0014J\u0012\u0010y\u001a\u00020N2\b\u0010z\u001a\u0004\u0018\u00010{H\u0016J\u001c\u0010|\u001a\u00020}2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010~\u001a\u00020NJ\b\u0010\u007f\u001a\u00020NH\u0014J\u0014\u0010\u0080\u0001\u001a\u00020N2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010xH\u0014J\u001d\u0010\u0082\u0001\u001a\u00020N2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0084\u0001\u001a\u00020\u000eH\u0002J0\u0010\u0085\u0001\u001a\u00020N2\u0007\u0010\u0086\u0001\u001a\u00020j2\u0006\u0010I\u001a\u00020\f2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\fH\u0002J\t\u0010\u0089\u0001\u001a\u00020NH\u0002J\t\u0010\u008a\u0001\u001a\u00020NH\u0002J\u0007\u0010\u008b\u0001\u001a\u00020NJ\u0014\u0010\u008c\u0001\u001a\u00020N2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\fH\u0002J0\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\u0092\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J'\u0010\u0093\u0001\u001a\u00020N2\b\u0010I\u001a\u0004\u0018\u00010\f2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\u001b\u0010\u0094\u0001\u001a\u00020N2\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\t\u0010\u0095\u0001\u001a\u00020NH\u0002J\u0011\u0010\u0096\u0001\u001a\u00020N2\b\u0010F\u001a\u0004\u0018\u00010GJ\u001b\u0010\u0097\u0001\u001a\u00020N2\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0098\u0001\u001a\u00020N2\u0007\u0010\u0086\u0001\u001a\u00020jH\u0002J\u0012\u0010\u0099\u0001\u001a\u00020N2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0099\u0001\u001a\u00020N2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\fJ\t\u0010\u009c\u0001\u001a\u00020NH\u0016J\t\u0010\u009d\u0001\u001a\u00020NH\u0002J\u001d\u0010\u009e\u0001\u001a\u00020N2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\u0013\u0010\u009f\u0001\u001a\u00020N2\b\u0010b\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010 \u0001\u001a\u00020N2\r\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020j0qH\u0002J\t\u0010¢\u0001\u001a\u00020NH\u0002J\u0007\u0010£\u0001\u001a\u00020NJ\u0007\u0010¤\u0001\u001a\u00020NJ\t\u0010¥\u0001\u001a\u00020NH\u0002J\t\u0010¦\u0001\u001a\u00020NH\u0002J\"\u0010§\u0001\u001a\u00020N2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020j0q2\t\b\u0002\u0010¨\u0001\u001a\u00020\fH\u0002J\u0012\u0010©\u0001\u001a\u00020N2\u0007\u0010ª\u0001\u001a\u00020\fH\u0002J\u0012\u0010«\u0001\u001a\u00020N2\u0007\u0010¬\u0001\u001a\u00020\fH\u0002J\t\u0010\u00ad\u0001\u001a\u00020NH\u0002J\u0018\u0010®\u0001\u001a\u00020N2\r\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020j0qH\u0002J-\u0010°\u0001\u001a\u00020N2\u0007\u0010±\u0001\u001a\u00020\b2\u0007\u0010²\u0001\u001a\u00020\b2\u0007\u0010³\u0001\u001a\u00020\b2\u0007\u0010´\u0001\u001a\u00020\bH\u0002J\u001b\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020j0i*\n\u0012\u0004\u0012\u00020j\u0018\u00010iH\u0002J.\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020j0q*\b\u0012\u0004\u0012\u00020j0q2\u0013\u0010·\u0001\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020j0lH\u0002J\r\u0010¸\u0001\u001a\u00020j*\u00020jH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R$\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R$\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R$\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u000e\u0010.\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R$\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R$\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R$\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R$\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010\u0018R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006º\u0001"}, d2 = {"Lid/dana/richview/servicescard/ServiceCardV2View;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewServiceCardV2Binding;", HummerConstants.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "bannerUrl", "", "checkSessionFinish", "", "checkoutH5EventSuccess", "component", "Lid/dana/di/component/NewServiceCardComponent;", "deviceInformationProvider", "Ldagger/Lazy;", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Ldagger/Lazy;", "setDeviceInformationProvider", "(Ldagger/Lazy;)V", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "setFeaturePresenter", "fullUrl", "globalNetworkPresenter", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "getGlobalNetworkPresenter", "setGlobalNetworkPresenter", "h5EventPresenter", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "getH5EventPresenter", "setH5EventPresenter", "homeTrackerImpl", "Lid/dana/home/tracker/HomeTrackerImpl;", "getHomeTrackerImpl", "setHomeTrackerImpl", "homeWidgetCache", "Lid/dana/data/config/source/HomeWidgetEntityData;", "getHomeWidgetCache", "setHomeWidgetCache", "isFirstTimeAnimateBannerService", "isWidgetTracked", "onBoardingServicePresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingServicePresenter", "setOnBoardingServicePresenter", "payLaterPresenter", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "getPayLaterPresenter", "setPayLaterPresenter", "playStoreReviewPresenter", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "getPlayStoreReviewPresenter", "setPlayStoreReviewPresenter", "presenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "getPresenter", "setPresenter", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "setReadLinkPropertiesPresenter", "serviceAdapter", "Lid/dana/richview/servicescard/adapter/ServiceV2Adapter;", "serviceCardListener", "Lid/dana/richview/servicescard/ServiceCardListener;", "addEntryPoint", "url", "composeUrl", "createH5AppListener", "Lid/dana/utils/danah5/DanaH5Listener;", "doOnOpenH5", "", "getBottomSheetOnBoardingView", "Lid/dana/usereducation/BottomSheetOnBoardingContract$View;", "getDanaApplication", "Lid/dana/DanaApplication;", "getGlobalNetworkListener", "Lid/dana/globalnetwork/currency/GlobalNetworkListener;", "getLayout", "getOnItemClickListener", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "getPayLaterViewListener", "id/dana/richview/servicescard/ServiceCardV2View$getPayLaterViewListener$1", "()Lid/dana/richview/servicescard/ServiceCardV2View$getPayLaterViewListener$1;", "getPromotedServiceV2ViewHolder", "Lid/dana/richview/servicescard/adapter/viewholder/PromotedServiceV2ViewHolder;", "getServicesView", "Lid/dana/contract/services/ServicesContract$View;", "handleHeaderBackgroundColor", "bannerLottieModel", "Lid/dana/model/BannerLottieModel;", RVParams.AROME_BG_COLOR, "isShowBanner", "handleOpenService", "position", "handleServiceCard", "Lio/reactivex/Completable;", "services", "", "Lid/dana/model/ThirdPartyService;", "onUpdateBackgroundColor", "Lkotlin/Function1;", "onBannerMode", "Lkotlin/Function2;", "onServiceMode", "onUpdateServiceCard", "", "handleViewAllServiceButton", "hideShimmerOnPromotedService", "hideSkeleton", "initServiceList", "initViewBinding", "view", "Landroid/view/View;", "injectComponent", "applicationComponent", "Lid/dana/di/component/ApplicationComponent;", "lottieBannerServiceAnimatorListener", "Landroid/animation/Animator$AnimatorListener;", "notifyFinishCheckSession", "onDetachedFromWindow", "onSingleClick", SecurityConstants.KEY_VALUE, "openAcService", "urlBuilder", SummaryActivity.FIRST_STATE_SHARE_FEED, "openH5", "thirdPartyService", "authCode", UrlParam.REQUEST_ID, "openPromotedServiceMenu", "pauseIconPromotedServiceAnimation", "refreshView", "saveBottomSheetOnBoarding", "scenario", "serviceCardWithBannerAnimatorListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "initialPaddingTop", "finalPaddingTop", "serviceCardWithoutBannerAnimatorListener", "setBannerServiceAnimation", "setBannerServiceByLocale", "setHideBannerService", "setServiceCardListener", "setShownBannerService", "setThirdPartyService", "setViewHeaderBackgroundColor", "color", "customColor", "setup", "setupHideBannerService", "setupServiceCardWithBanner", "setupServiceCardWithoutBanner", "setupServiceList", "thirdPartyServices", "showServicesFromInMemoryCache", "showShimmerOnPromotedService", "showSkeleton", "startIconPromotedServiceAnimation", "stopLoadTime", "trackPromotedService", "uiVersion", "trackSavingsGoalOpen", "serviceName", "trackSendMoneyOpen", DanaH5.SERVICE_KEY, "trackViewAllButtonIsClicked", "updateInMemoryCache", "previewedServices", "updatePaddingServiceCard", "left", "top", "right", "bottom", "getPreviewedServices", "handlePromotedService", "onLoanService", "resetCachedRotationDelayTime", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServiceCardV2View extends ViewBindingRichView<ViewServiceCardV2Binding> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int DatabaseTableConfigUtil = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static long getErrorConfigVersion = 0;
    private static int initRecordTimeStamp = 1;
    private String BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private NewServiceCardComponent MyBillsEntityDataFactory;
    private ServiceCardListener NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public Lazy<DeviceInformationProvider> deviceInformationProvider;
    @Inject
    public Lazy<FeatureContract.Presenter> featurePresenter;
    private boolean getAuthRequestContext;
    @Inject
    public Lazy<GlobalNetworkContract.Presenter> globalNetworkPresenter;
    @Inject
    public Lazy<CheckoutH5EventContract.Presenter> h5EventPresenter;
    @Inject
    public Lazy<HomeTrackerImpl> homeTrackerImpl;
    @Inject
    public Lazy<HomeWidgetEntityData> homeWidgetCache;
    private ServiceV2Adapter lookAheadTest;
    private boolean moveToNextValue;
    @Inject
    public Lazy<BottomSheetOnBoardingContract.Presenter> onBoardingServicePresenter;
    @Inject
    public Lazy<PayLaterContract.Presenter> payLaterPresenter;
    @Inject
    public Lazy<PlayStoreReviewContract.Presenter> playStoreReviewPresenter;
    @Inject
    public Lazy<ServicesContract.Presenter> presenter;
    @Inject
    public Lazy<ReadLinkPropertiesContract.Presenter> readLinkPropertiesPresenter;
    private boolean scheduleImpl;

    /* renamed from: $r8$lambda$-8wDeQ3BJKD8-C6YZjCPRAo63kY  reason: not valid java name */
    public static /* synthetic */ void m2852$r8$lambda$8wDeQ3BJKD8C6YZjCPRAo63kY(ServiceCardV2View serviceCardV2View, int i, String str, int i2, ValueAnimator valueAnimator) {
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 75;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
        try {
            PlaceComponentResult(serviceCardV2View, i, str, i2, valueAnimator);
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 123;
            initRecordTimeStamp = i5 % 128;
            if (!(i5 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$3VyPQON58V_BnjwjAMvekw3Y6Yc(ServiceCardV2View serviceCardV2View, boolean z) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 31;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(serviceCardV2View, z);
        int i3 = initRecordTimeStamp + 91;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void $r8$lambda$Beo7dghaEgXshMsRwKHzp5UN7Xw(ServiceCardV2View serviceCardV2View, Throwable th) {
        try {
            int i = initRecordTimeStamp + 99;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            BuiltInFictitiousFunctionClassFactory(serviceCardV2View);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 15;
            try {
                initRecordTimeStamp = i3 % 128;
                if (!(i3 % 2 == 0)) {
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

    public static /* synthetic */ void $r8$lambda$GPEOqfXsKxRA5t7CJPNj4hqXPeA(ServiceCardV2View serviceCardV2View, int i, BannerLottieModel bannerLottieModel, String str, int i2, ValueAnimator valueAnimator) {
        int i3 = initRecordTimeStamp + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        MyBillsEntityDataFactory(serviceCardV2View, i, bannerLottieModel, str, i2, valueAnimator);
        int i5 = initRecordTimeStamp + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
        int i6 = i5 % 2;
    }

    /* renamed from: $r8$lambda$MhCwGHgY-4AunM-1qj362g7I5J8  reason: not valid java name */
    public static /* synthetic */ void m2853$r8$lambda$MhCwGHgY4AunM1qj362g7I5J8(Function1 function1, String str, Function1 function12, List list, CompletableSubject completableSubject, Disposable disposable) {
        try {
            int i = initRecordTimeStamp + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            if (!(i % 2 != 0)) {
                PlaceComponentResult(function1, str, function12, list, completableSubject);
                return;
            }
            PlaceComponentResult(function1, str, function12, list, completableSubject);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$XSQguWzvtPgH7geOswZJJMKOzhM(Function2 function2, BannerLottieModel bannerLottieModel, ThirdPartyService thirdPartyService, CompletableSubject completableSubject, Disposable disposable) {
        try {
            int i = initRecordTimeStamp + 61;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            BuiltInFictitiousFunctionClassFactory(function2, bannerLottieModel, thirdPartyService, completableSubject);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 57;
            initRecordTimeStamp = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 61 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$jGTag1Ew1ohbJc-GtuI6RCtqV7A  reason: not valid java name */
    public static /* synthetic */ void m2854$r8$lambda$jGTag1Ew1ohbJcGtuI6RCtqV7A(Function1 function1, ThirdPartyService thirdPartyService, CompletableSubject completableSubject, Disposable disposable) {
        int i = initRecordTimeStamp + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 != 0;
        BuiltInFictitiousFunctionClassFactory(function1, thirdPartyService, completableSubject);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = initRecordTimeStamp + 1;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$xKKVBh1ctYWRs8u-QHkU4rh3M6Y  reason: not valid java name */
    public static /* synthetic */ void m2855$r8$lambda$xKKVBh1ctYWRs8uQHkU4rh3M6Y(Function1 function1, String str, Function1 function12, List list, CompletableSubject completableSubject, Disposable disposable) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 57;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            BuiltInFictitiousFunctionClassFactory(function1, str, function12, list, completableSubject);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 51;
            initRecordTimeStamp = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            int i4 = 62 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        try {
            PlaceComponentResult();
            try {
                INSTANCE = new Companion(null);
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 71;
                initRecordTimeStamp = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0013
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public ServiceCardV2View(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)     // Catch: java.lang.Exception -> L11
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 14
            r7 = 0
            r1 = r8
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        L11:
            r9 = move-exception
            throw r9
        L13:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.<init>(android.content.Context):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceCardV2View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        try {
            Intrinsics.checkNotNullParameter(context, "");
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceCardV2View(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 13492;
        getErrorConfigVersion = 4360990799332652212L;
        DatabaseTableConfigUtil = -662445924;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        if ((r3 != null ? '4' : kotlin.text.Typography.amp) != '&') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r5 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        r5 = 27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
    
        r5 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
    
        if (r5 == 22) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if ((r3 != null) != true) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getAuthRequestContext(id.dana.model.BannerLottieModel r3, java.lang.String r4, boolean r5) {
        /*
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r0 = r0 + 51
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1b
            r1.hashCode()     // Catch: java.lang.Throwable -> L19
            r0 = 1
            if (r3 == 0) goto L15
            r2 = 1
            goto L16
        L15:
            r2 = 0
        L16:
            if (r2 == r0) goto L26
            goto L31
        L19:
            r3 = move-exception
            throw r3
        L1b:
            r0 = 38
            if (r3 == 0) goto L22
            r2 = 52
            goto L24
        L22:
            r2 = 38
        L24:
            if (r2 == r0) goto L31
        L26:
            r0 = 22
            if (r5 != 0) goto L2d
            r5 = 27
            goto L2f
        L2d:
            r5 = 22
        L2f:
            if (r5 == r0) goto L34
        L31:
            if (r3 == 0) goto L34
            r4 = r1
        L34:
            int r3 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r3 = r3 + 121
            int r5 = r3 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r5
            int r3 = r3 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.getAuthRequestContext(id.dana.model.BannerLottieModel, java.lang.String, boolean):java.lang.String");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        int i = initRecordTimeStamp + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        this._$_findViewCache.clear();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 61;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById == null) {
                return null;
            }
            int i2 = initRecordTimeStamp + 31;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
            try {
                map.put(Integer.valueOf(i), findViewById);
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 113;
                initRecordTimeStamp = i4 % 128;
                int i5 = i4 % 2;
                return findViewById;
            } catch (Exception e) {
                throw e;
            }
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        int i = initRecordTimeStamp + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        int i3 = initRecordTimeStamp + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? 'K' : '@') != '@') {
            Object[] objArr = null;
            int length = objArr.length;
            return R.layout.view_service_card_v2;
        }
        return R.layout.view_service_card_v2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceCardV2View(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.moveToNextValue = true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ServiceCardV2View(android.content.Context r4, android.util.AttributeSet r5, int r6, int r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r3 = this;
            r9 = r8 & 2
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L8
            r9 = 0
            goto L9
        L8:
            r9 = 1
        L9:
            r2 = 0
            if (r9 == 0) goto Ld
            goto L20
        Ld:
            int r5 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r5 = r5 + 67
            int r9 = r5 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r9
            int r5 = r5 % 2
            if (r5 == 0) goto L1f
            r5 = 11
            int r5 = r5 / r1
            goto L1f
        L1d:
            r4 = move-exception
            throw r4
        L1f:
            r5 = r2
        L20:
            r9 = r8 & 4
            if (r9 == 0) goto L26
            r9 = 0
            goto L27
        L26:
            r9 = 1
        L27:
            if (r9 == r0) goto L38
            int r6 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r6 = r6 + 35
            int r9 = r6 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r9
            int r6 = r6 % 2
            if (r6 != 0) goto L37
            r6 = 1
            goto L38
        L37:
            r6 = 0
        L38:
            r8 = r8 & 8
            if (r8 == 0) goto L47
            int r7 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r7 = r7 + 3
            int r8 = r7 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r8
            int r7 = r7 % 2
            r7 = 0
        L47:
            r3.<init>(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.<init>(android.content.Context, android.util.AttributeSet, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static final /* synthetic */ DanaH5Listener access$createH5AppListener(ServiceCardV2View serviceCardV2View) {
        int i = initRecordTimeStamp + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 != 0 ? '\b' : 'O';
        DanaH5Listener MyBillsEntityDataFactory = serviceCardV2View.MyBillsEntityDataFactory();
        if (c == '\b') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 101;
        initRecordTimeStamp = i2 % 128;
        int i3 = i2 % 2;
        return MyBillsEntityDataFactory;
    }

    public static final /* synthetic */ void access$doOnOpenH5(ServiceCardV2View serviceCardV2View) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 63;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        serviceCardV2View.KClassImpl$Data$declaredNonStaticMembers$2();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
        initRecordTimeStamp = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$enableClick(ServiceCardV2View serviceCardV2View) {
        int i = initRecordTimeStamp + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? '7' : (char) 30) != '7') {
            serviceCardV2View.enableClick();
        } else {
            try {
                serviceCardV2View.enableClick();
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = initRecordTimeStamp + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ ViewServiceCardV2Binding access$getBinding(ServiceCardV2View serviceCardV2View) {
        int i = initRecordTimeStamp + 101;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        ViewServiceCardV2Binding binding = serviceCardV2View.getBinding();
        try {
            int i3 = initRecordTimeStamp + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? 'Z' : '#') != '#') {
                Object[] objArr = null;
                int length = objArr.length;
                return binding;
            }
            return binding;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean access$getCheckoutH5EventSuccess$p(ServiceCardV2View serviceCardV2View) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        boolean z = serviceCardV2View.getAuthRequestContext;
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 111;
            initRecordTimeStamp = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 7 : '1') != '1') {
                Object[] objArr = null;
                int length = objArr.length;
                return z;
            }
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getFullUrl$p(ServiceCardV2View serviceCardV2View) {
        int i = initRecordTimeStamp + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        try {
            if ((i % 2 != 0 ? (char) 3 : 'J') != 3) {
                return serviceCardV2View.BuiltInFictitiousFunctionClassFactory;
            }
            int i2 = 13 / 0;
            return serviceCardV2View.BuiltInFictitiousFunctionClassFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ ServiceV2Adapter access$getServiceAdapter$p(ServiceCardV2View serviceCardV2View) {
        int i = initRecordTimeStamp + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        ServiceV2Adapter serviceV2Adapter = serviceCardV2View.lookAheadTest;
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 109;
            try {
                initRecordTimeStamp = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 99 / 0;
                    return serviceV2Adapter;
                }
                return serviceV2Adapter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ ServiceCardListener access$getServiceCardListener$p(ServiceCardV2View serviceCardV2View) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
        initRecordTimeStamp = i % 128;
        boolean z = i % 2 == 0;
        ServiceCardListener serviceCardListener = serviceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return serviceCardListener;
    }

    public static final /* synthetic */ void access$handleOpenService(ServiceCardV2View serviceCardV2View, int i) {
        int i2 = initRecordTimeStamp + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
        serviceCardV2View.BuiltInFictitiousFunctionClassFactory(i);
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 77;
        initRecordTimeStamp = i4 % 128;
        if (!(i4 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ Completable access$handleServiceCard(ServiceCardV2View serviceCardV2View, List list, Function1 function1, Function2 function2, Function1 function12, Function1 function13) {
        int i = initRecordTimeStamp + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 == 0;
        Completable authRequestContext = serviceCardV2View.getAuthRequestContext(list, function1, function2, function12, function13);
        if (!z) {
            int i2 = 27 / 0;
        }
        return authRequestContext;
    }

    public static final /* synthetic */ void access$handleViewAllServiceButton(ServiceCardV2View serviceCardV2View) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 67;
            try {
                initRecordTimeStamp = i % 128;
                if ((i % 2 == 0 ? (char) 11 : '(') != '(') {
                    serviceCardV2View.GetContactSyncConfig();
                    Object[] objArr = null;
                    int length = objArr.length;
                } else {
                    serviceCardV2View.GetContactSyncConfig();
                }
                int i2 = initRecordTimeStamp + 11;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ boolean access$isFirstTimeAnimateBannerService$p(ServiceCardV2View serviceCardV2View) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 35;
            initRecordTimeStamp = i % 128;
            if (!(i % 2 != 0)) {
                boolean z = serviceCardV2View.moveToNextValue;
                Object[] objArr = null;
                int length = objArr.length;
                return z;
            }
            return serviceCardV2View.moveToNextValue;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$openAcService(ServiceCardV2View serviceCardV2View, String str, boolean z) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 7;
            initRecordTimeStamp = i % 128;
            boolean z2 = i % 2 == 0;
            serviceCardV2View.KClassImpl$Data$declaredNonStaticMembers$2(str, z);
            if (!z2) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$openH5(ServiceCardV2View serviceCardV2View, ThirdPartyService thirdPartyService, String str, String str2, String str3) {
        try {
            int i = initRecordTimeStamp + 47;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                char c = i % 2 != 0 ? 'U' : InputCardNumberView.DIVIDER;
                serviceCardV2View.getAuthRequestContext(thirdPartyService, str, str2, str3);
                if (c != ' ') {
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

    public static final /* synthetic */ ThirdPartyService access$resetCachedRotationDelayTime(ServiceCardV2View serviceCardV2View, ThirdPartyService thirdPartyService) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 43;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        ThirdPartyService KClassImpl$Data$declaredNonStaticMembers$2 = serviceCardV2View.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 65;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static final /* synthetic */ void access$saveBottomSheetOnBoarding(ServiceCardV2View serviceCardV2View, String str) {
        int i = initRecordTimeStamp + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        serviceCardV2View.PlaceComponentResult(str);
        int i3 = initRecordTimeStamp + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void access$setFirstTimeAnimateBannerService$p(ServiceCardV2View serviceCardV2View, boolean z) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 95;
        initRecordTimeStamp = i % 128;
        boolean z2 = i % 2 != 0;
        serviceCardV2View.moveToNextValue = z;
        if (!z2) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = initRecordTimeStamp + 71;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setShownBannerService(ServiceCardV2View serviceCardV2View, BannerLottieModel bannerLottieModel, String str) {
        try {
            int i = initRecordTimeStamp + 91;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                boolean z = i % 2 == 0;
                serviceCardV2View.KClassImpl$Data$declaredNonStaticMembers$2(bannerLottieModel, str);
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 35;
                initRecordTimeStamp = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setupHideBannerService(ServiceCardV2View serviceCardV2View) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 19;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        serviceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda8();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 19;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setupServiceCardWithBanner(ServiceCardV2View serviceCardV2View, BannerLottieModel bannerLottieModel, String str) {
        try {
            int i = initRecordTimeStamp + 39;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            boolean z = i % 2 == 0;
            serviceCardV2View.getAuthRequestContext(bannerLottieModel, str);
            if (!z) {
                Object obj = null;
                obj.hashCode();
            }
            int i2 = initRecordTimeStamp + 61;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 85 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setupServiceCardWithoutBanner(ServiceCardV2View serviceCardV2View, String str) {
        try {
            int i = initRecordTimeStamp + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            serviceCardV2View.getAuthRequestContext(str);
            int i3 = initRecordTimeStamp + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setupServiceList(ServiceCardV2View serviceCardV2View, List list) {
        int i = initRecordTimeStamp + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        serviceCardV2View.KClassImpl$Data$declaredNonStaticMembers$2(list);
        int i3 = initRecordTimeStamp + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$stopLoadTime(ServiceCardV2View serviceCardV2View) {
        int i = initRecordTimeStamp + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 != 0;
        serviceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda6();
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = initRecordTimeStamp + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        int i3 = 56 / 0;
    }

    public static final /* synthetic */ void access$trackPromotedService(ServiceCardV2View serviceCardV2View, List list, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 89;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? (char) 18 : '^') != 18) {
            serviceCardV2View.MyBillsEntityDataFactory(list, str);
            return;
        }
        serviceCardV2View.MyBillsEntityDataFactory(list, str);
        int i2 = 42 / 0;
    }

    public static final /* synthetic */ void access$updateInMemoryCache(ServiceCardV2View serviceCardV2View, List list) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
            try {
                initRecordTimeStamp = i % 128;
                boolean z = i % 2 != 0;
                serviceCardV2View.BuiltInFictitiousFunctionClassFactory(list);
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = initRecordTimeStamp + 83;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final /* bridge */ /* synthetic */ ViewServiceCardV2Binding initViewBinding(View view) {
        ViewServiceCardV2Binding initViewBinding;
        int i = initRecordTimeStamp + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? (char) 22 : Typography.less) != '<') {
            initViewBinding = initViewBinding(view);
            int i2 = 50 / 0;
        } else {
            try {
                initViewBinding = initViewBinding(view);
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = initRecordTimeStamp + 75;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 21 : (char) 1) != 1) {
                int i4 = 80 / 0;
                return initViewBinding;
            }
            return initViewBinding;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    protected final ViewServiceCardV2Binding initViewBinding(View view) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 39;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? '\n' : '=') != '=') {
            try {
                Intrinsics.checkNotNullParameter(view, "");
                ViewServiceCardV2Binding MyBillsEntityDataFactory = ViewServiceCardV2Binding.MyBillsEntityDataFactory(view);
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                Object[] objArr = null;
                int length = objArr.length;
                return MyBillsEntityDataFactory;
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(view, "");
        ViewServiceCardV2Binding MyBillsEntityDataFactory2 = ViewServiceCardV2Binding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        return MyBillsEntityDataFactory2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        if ((r0 == null ? 11 : 0) != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
        id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if ((r0 % 2) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if ((r0 != null ? 1 : 0) != 1) goto L18;
     */
    @kotlin.jvm.JvmName(name = "getDeviceInformationProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.data.config.DeviceInformationProvider> getDeviceInformationProvider() {
        /*
            r4 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L1c
            dagger.Lazy<id.dana.data.config.DeviceInformationProvider> r0 = r4.deviceInformationProvider
            r2.hashCode()     // Catch: java.lang.Throwable -> L1a
            r3 = 1
            if (r0 == 0) goto L17
            r1 = 1
        L17:
            if (r1 == r3) goto L3f
            goto L25
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            dagger.Lazy<id.dana.data.config.DeviceInformationProvider> r0 = r4.deviceInformationProvider
            if (r0 == 0) goto L21
            goto L23
        L21:
            r1 = 11
        L23:
            if (r1 == 0) goto L3f
        L25:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L3d
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> L3d
            int r0 = r0 % 2
            if (r0 != 0) goto L3c
            r2.hashCode()     // Catch: java.lang.Throwable -> L3a
            return r2
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            return r2
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.getDeviceInformationProvider():dagger.Lazy");
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(Lazy<DeviceInformationProvider> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 9;
        initRecordTimeStamp = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.deviceInformationProvider = lazy;
            return;
        }
        Intrinsics.checkNotNullParameter(lazy, "");
        this.deviceInformationProvider = lazy;
        Object obj = null;
        obj.hashCode();
    }

    @JvmName(name = "getGlobalNetworkPresenter")
    public final Lazy<GlobalNetworkContract.Presenter> getGlobalNetworkPresenter() {
        int i = initRecordTimeStamp + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Lazy<GlobalNetworkContract.Presenter> lazy = this.globalNetworkPresenter;
        if (!(lazy != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i3 = initRecordTimeStamp + 115;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setGlobalNetworkPresenter")
    public final void setGlobalNetworkPresenter(Lazy<GlobalNetworkContract.Presenter> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 115;
        initRecordTimeStamp = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            try {
                Intrinsics.checkNotNullParameter(lazy, "");
                this.globalNetworkPresenter = lazy;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.globalNetworkPresenter = lazy;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 83;
        initRecordTimeStamp = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.amp : '\\') != '&') {
            return;
        }
        obj.hashCode();
    }

    @JvmName(name = "getH5EventPresenter")
    public final Lazy<CheckoutH5EventContract.Presenter> getH5EventPresenter() {
        Lazy<CheckoutH5EventContract.Presenter> lazy = this.h5EventPresenter;
        Object obj = null;
        if ((lazy != null ? '-' : 'U') != '-') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i = initRecordTimeStamp + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            return null;
        }
        try {
            int i3 = initRecordTimeStamp + 91;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                obj.hashCode();
            }
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setH5EventPresenter")
    public final void setH5EventPresenter(Lazy<CheckoutH5EventContract.Presenter> lazy) {
        try {
            int i = initRecordTimeStamp + 107;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(lazy, "");
            this.h5EventPresenter = lazy;
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 13;
                initRecordTimeStamp = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 1 : (char) 20) != 20) {
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

    @JvmName(name = "getOnBoardingServicePresenter")
    public final Lazy<BottomSheetOnBoardingContract.Presenter> getOnBoardingServicePresenter() {
        Lazy<BottomSheetOnBoardingContract.Presenter> lazy = this.onBoardingServicePresenter;
        if ((lazy != null ? '\'' : (char) 4) != 4) {
            int i = initRecordTimeStamp + 81;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            if (!(i % 2 != 0)) {
                return lazy;
            }
            int i2 = 80 / 0;
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 27;
        initRecordTimeStamp = i3 % 128;
        Object[] objArr = null;
        if (i3 % 2 == 0) {
            int length = objArr.length;
            return null;
        }
        return null;
    }

    @JvmName(name = "setOnBoardingServicePresenter")
    public final void setOnBoardingServicePresenter(Lazy<BottomSheetOnBoardingContract.Presenter> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
        initRecordTimeStamp = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            try {
                Intrinsics.checkNotNullParameter(lazy, "");
                this.onBoardingServicePresenter = lazy;
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.onBoardingServicePresenter = lazy;
            int length = objArr.length;
        }
        int i2 = initRecordTimeStamp + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        if ((i2 % 2 != 0 ? '0' : (char) 19) != 19) {
            objArr.hashCode();
        }
    }

    @JvmName(name = "getPlayStoreReviewPresenter")
    public final Lazy<PlayStoreReviewContract.Presenter> getPlayStoreReviewPresenter() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 15;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        Lazy<PlayStoreReviewContract.Presenter> lazy = this.playStoreReviewPresenter;
        Object obj = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i3 = initRecordTimeStamp + 101;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 21 : '[') != '[') {
                obj.hashCode();
            }
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setPlayStoreReviewPresenter")
    public final void setPlayStoreReviewPresenter(Lazy<PlayStoreReviewContract.Presenter> lazy) {
        int i = initRecordTimeStamp + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? '^' : 'L') != '^') {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.playStoreReviewPresenter = lazy;
            return;
        }
        Intrinsics.checkNotNullParameter(lazy, "");
        this.playStoreReviewPresenter = lazy;
        Object[] objArr = null;
        int length = objArr.length;
    }

    @JvmName(name = "getPresenter")
    public final Lazy<ServicesContract.Presenter> getPresenter() {
        int i = initRecordTimeStamp + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            Lazy<ServicesContract.Presenter> lazy = this.presenter;
            if ((lazy != null ? '7' : '-') == '-') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 49;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<ServicesContract.Presenter> lazy) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 67;
            try {
                initRecordTimeStamp = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(lazy, "");
                this.presenter = lazy;
                int i3 = initRecordTimeStamp + 97;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if (!(i3 % 2 == 0)) {
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:30:0x003e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "getReadLinkPropertiesPresenter")
    public final dagger.Lazy<id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter> getReadLinkPropertiesPresenter() {
        /*
            r4 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
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
            if (r0 == r2) goto L21
            dagger.Lazy<id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter> r0 = r4.readLinkPropertiesPresenter
            r3.hashCode()     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L1c
            r1 = 1
        L1c:
            if (r1 == 0) goto L36
            goto L25
        L1f:
            r0 = move-exception
            throw r0
        L21:
            dagger.Lazy<id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter> r0 = r4.readLinkPropertiesPresenter
            if (r0 == 0) goto L36
        L25:
            int r1 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r1 = r1 + 125
            int r2 = r1 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L35
            int r1 = r3.length     // Catch: java.lang.Throwable -> L33
            return r0
        L33:
            r0 = move-exception
            throw r0
        L35:
            return r0
        L36:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L3c
            return r3
        L3c:
            r0 = move-exception
            throw r0
        L3e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.getReadLinkPropertiesPresenter():dagger.Lazy");
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 79;
        initRecordTimeStamp = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.readLinkPropertiesPresenter = lazy;
            int i2 = 87 / 0;
        } else {
            try {
                Intrinsics.checkNotNullParameter(lazy, "");
                try {
                    this.readLinkPropertiesPresenter = lazy;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        r1 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
        id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        if ((r1 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        r1 = '9';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        r1 = kotlin.text.Typography.less;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r1 == '<') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getPayLaterPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.contract.paylater.PayLaterContract.Presenter> getPayLaterPresenter() {
        /*
            r4 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L48
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> L48
            int r0 = r0 % 2
            r1 = 72
            if (r0 != 0) goto L11
            r0 = 82
            goto L13
        L11:
            r0 = 72
        L13:
            r2 = 0
            if (r0 == r1) goto L20
            dagger.Lazy<id.dana.contract.paylater.PayLaterContract$Presenter> r0 = r4.payLaterPresenter
            r2.hashCode()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L40
            goto L24
        L1e:
            r0 = move-exception
            throw r0
        L20:
            dagger.Lazy<id.dana.contract.paylater.PayLaterContract$Presenter> r0 = r4.payLaterPresenter
            if (r0 == 0) goto L40
        L24:
            int r1 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 55
            int r3 = r1 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r3
            int r1 = r1 % 2
            r3 = 60
            if (r1 != 0) goto L35
            r1 = 57
            goto L37
        L35:
            r1 = 60
        L37:
            if (r1 == r3) goto L3f
            r2.hashCode()     // Catch: java.lang.Throwable -> L3d
            return r0
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            return r0
        L40:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L46
            return r2
        L46:
            r0 = move-exception
            throw r0
        L48:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.getPayLaterPresenter():dagger.Lazy");
    }

    @JvmName(name = "setPayLaterPresenter")
    public final void setPayLaterPresenter(Lazy<PayLaterContract.Presenter> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 19;
        initRecordTimeStamp = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.payLaterPresenter = lazy;
        } else {
            try {
                Intrinsics.checkNotNullParameter(lazy, "");
                this.payLaterPresenter = lazy;
                int i2 = 87 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 105;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getHomeWidgetCache")
    public final Lazy<HomeWidgetEntityData> getHomeWidgetCache() {
        Lazy<HomeWidgetEntityData> lazy = this.homeWidgetCache;
        if (lazy == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        int i = initRecordTimeStamp + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        int i3 = initRecordTimeStamp + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return lazy;
    }

    @JvmName(name = "setHomeWidgetCache")
    public final void setHomeWidgetCache(Lazy<HomeWidgetEntityData> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 51;
        initRecordTimeStamp = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.homeWidgetCache = lazy;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.homeWidgetCache = lazy;
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
            initRecordTimeStamp = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getFeaturePresenter")
    public final Lazy<FeatureContract.Presenter> getFeaturePresenter() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 23;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            Lazy<FeatureContract.Presenter> lazy = this.featurePresenter;
            if (!(lazy == null)) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 45;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
                return lazy;
            }
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i5 = initRecordTimeStamp + 39;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
                int i6 = i5 % 2;
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(Lazy<FeatureContract.Presenter> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 33;
        initRecordTimeStamp = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? (char) 5 : 'a') != 'a') {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.featurePresenter = lazy;
            int length = objArr.length;
        } else {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.featurePresenter = lazy;
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 85;
            initRecordTimeStamp = i2 % 128;
            if (i2 % 2 == 0) {
                int length2 = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:24:0x0045
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "getHomeTrackerImpl")
    public final dagger.Lazy<id.dana.animation.tracker.HomeTrackerImpl> getHomeTrackerImpl() {
        /*
            r3 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L1a
            dagger.Lazy<id.dana.home.tracker.HomeTrackerImpl> r0 = r3.homeTrackerImpl
            r1 = 33
            r2 = 0
            int r1 = r1 / r2
            if (r0 == 0) goto L15
            r2 = 1
        L15:
            if (r2 == 0) goto L32
            goto L27
        L18:
            r0 = move-exception
            throw r0
        L1a:
            dagger.Lazy<id.dana.home.tracker.HomeTrackerImpl> r0 = r3.homeTrackerImpl
            r1 = 64
            if (r0 == 0) goto L23
            r2 = 29
            goto L25
        L23:
            r2 = 64
        L25:
            if (r2 == r1) goto L32
        L27:
            int r1 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 53
            int r2 = r1 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r2
            int r1 = r1 % 2
            return r0
        L32:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L43
            r0 = 0
            int r1 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L43
            int r1 = r1 + 53
            int r2 = r1 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r2     // Catch: java.lang.Exception -> L43
            int r1 = r1 % 2
            return r0
        L43:
            r0 = move-exception
            throw r0
        L45:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.getHomeTrackerImpl():dagger.Lazy");
    }

    @JvmName(name = "setHomeTrackerImpl")
    public final void setHomeTrackerImpl(Lazy<HomeTrackerImpl> lazy) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 85;
        initRecordTimeStamp = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.homeTrackerImpl = lazy;
            int i2 = 72 / 0;
        } else {
            Intrinsics.checkNotNullParameter(lazy, "");
            this.homeTrackerImpl = lazy;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 79;
        initRecordTimeStamp = i3 % 128;
        if ((i3 % 2 == 0 ? 'c' : '#') != 'c') {
            return;
        }
        int i4 = 30 / 0;
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(ServiceCardV2View serviceCardV2View, boolean z) {
        int i = initRecordTimeStamp + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? 'L' : 'J') != 'J') {
            Intrinsics.checkNotNullParameter(serviceCardV2View, "");
            serviceCardV2View.getAuthRequestContext = z;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            Intrinsics.checkNotNullParameter(serviceCardV2View, "");
            serviceCardV2View.getAuthRequestContext = z;
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 59;
            initRecordTimeStamp = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r20.MyBillsEntityDataFactory == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        r0 = id.dana.di.component.DaggerNewServiceCardComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        r0.getAuthRequestContext = (id.dana.di.component.ApplicationComponent) dagger.internal.Preconditions.getAuthRequestContext(r21);
        r4 = id.dana.contract.deeplink.DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        r4.MyBillsEntityDataFactory = getBaseActivity();
        r13 = new java.lang.Object[1];
        a(new char[]{40309, 12876, 2683, 8528, 47430, 25767, 50237, 3502}, new char[]{3594, 10934, 52507, 20630}, (char) android.graphics.Color.argb(0, 0, 0, 0), new char[]{0, 0, 0, 0}, android.view.MotionEvent.axisFromString("") + 1, r13);
        r4.getAuthRequestContext = ((java.lang.String) r13[0]).intern();
        r0.PlaceComponentResult = (id.dana.contract.deeplink.DeepLinkModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.deeplink.DeepLinkModule(r4, r3));
        r4 = id.dana.contract.staticqr.ScanQrModule.getAuthRequestContext();
        r4.MyBillsEntityDataFactory = getBaseActivity();
        r0.NetworkUserEntityData$$ExternalSyntheticLambda2 = (id.dana.contract.staticqr.ScanQrModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.staticqr.ScanQrModule(r4, r3));
        r4 = id.dana.contract.shortener.RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        r4.getAuthRequestContext = getBaseActivity();
        r0.getErrorConfigVersion = (id.dana.contract.shortener.RestoreUrlModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.shortener.RestoreUrlModule(r4, r3));
        r4 = id.dana.contract.deeplink.FeatureModule.MyBillsEntityDataFactory();
        r4.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        r6 = new java.lang.Object[1];
        a(new char[]{40309, 12876, 2683, 8528, 47430, 25767, 50237, 3502}, new char[]{3594, 10934, 52507, 20630}, (char) (1 - (android.media.AudioTrack.getMaxVolume() > 0.0f ? 1 : (android.media.AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), new char[]{0, 0, 0, 0}, android.view.KeyEvent.getMaxKeyCode() >> 16, r6);
        r4.PlaceComponentResult = ((java.lang.String) r6[0]).intern();
        r0.BuiltInFictitiousFunctionClassFactory = (id.dana.contract.deeplink.FeatureModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.deeplink.FeatureModule(r4, r3));
        r4 = id.dana.di.modules.OauthModule.BuiltInFictitiousFunctionClassFactory();
        r4.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        r0.lookAheadTest = (id.dana.di.modules.OauthModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.OauthModule(r4, r3));
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = (id.dana.di.modules.CheckoutH5EventModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.CheckoutH5EventModule(new id.dana.richview.servicescard.ServiceCardV2View$$ExternalSyntheticLambda2(r20)));
        r0.scheduleImpl = (id.dana.di.modules.PlayStoreReviewModules) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.PlayStoreReviewModules(new id.dana.playstorereview.PlayStoreReviewContractView(getBaseActivity())));
        r0.NetworkUserEntityData$$ExternalSyntheticLambda1 = (id.dana.contract.services.ServicesModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.services.ServicesModule(lookAheadTest()));
        r0.MyBillsEntityDataFactory = (id.dana.di.modules.BottomSheetOnBoardingModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.BottomSheetOnBoardingModule(getAuthRequestContext()));
        r0.moveToNextValue = (id.dana.di.modules.GlobalNetworkModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.GlobalNetworkModule(NetworkUserEntityData$$ExternalSyntheticLambda0()));
        r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = (id.dana.contract.paylater.PayLaterModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.paylater.PayLaterModule(getErrorConfigVersion()));
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.scheduleImpl, id.dana.di.modules.PlayStoreReviewModules.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.KClassImpl$Data$declaredNonStaticMembers$2, id.dana.di.modules.CheckoutH5EventModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.MyBillsEntityDataFactory, id.dana.di.modules.BottomSheetOnBoardingModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.PlaceComponentResult, id.dana.contract.deeplink.DeepLinkModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.NetworkUserEntityData$$ExternalSyntheticLambda2, id.dana.contract.staticqr.ScanQrModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.getErrorConfigVersion, id.dana.contract.shortener.RestoreUrlModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.BuiltInFictitiousFunctionClassFactory, id.dana.contract.deeplink.FeatureModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.lookAheadTest, id.dana.di.modules.OauthModule.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x01b8, code lost:
    
        if (r0.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x01ba, code lost:
    
        r0.NetworkUserEntityData$$ExternalSyntheticLambda1 = new id.dana.contract.services.ServicesModule();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x01c1, code lost:
    
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.moveToNextValue, id.dana.di.modules.GlobalNetworkModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.NetworkUserEntityData$$ExternalSyntheticLambda0, id.dana.contract.paylater.PayLaterModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.getAuthRequestContext, id.dana.di.component.ApplicationComponent.class);
        r20.MyBillsEntityDataFactory = new id.dana.di.component.DaggerNewServiceCardComponent.NewServiceCardComponentImpl(r0.scheduleImpl, r0.KClassImpl$Data$declaredNonStaticMembers$2, r0.MyBillsEntityDataFactory, r0.PlaceComponentResult, r0.NetworkUserEntityData$$ExternalSyntheticLambda2, r0.getErrorConfigVersion, r0.BuiltInFictitiousFunctionClassFactory, r0.lookAheadTest, r0.NetworkUserEntityData$$ExternalSyntheticLambda1, r0.moveToNextValue, r0.NetworkUserEntityData$$ExternalSyntheticLambda0, r0.getAuthRequestContext, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r20.MyBillsEntityDataFactory == null) goto L13;
     */
    @Override // id.dana.base.BaseRichView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void injectComponent(id.dana.di.component.ApplicationComponent r21) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.injectComponent(id.dana.di.component.ApplicationComponent):void");
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        try {
            AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.SERVICES);
            getPresenter().get().getErrorConfigVersion();
            initRecordTimeStamp();
            newProxyInstance();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.richview.servicescard.ServiceCardV2View$setup$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public final int PlaceComponentResult(int p0) {
                    return p0 == 0 ? 4 : 1;
                }
            };
            int authRequestContext = SizeUtil.getAuthRequestContext(2);
            ViewServiceCardV2Binding binding = getBinding();
            binding.KClassImpl$Data$declaredNonStaticMembers$2.addItemDecoration(new ServiceItemDecorator(authRequestContext, authRequestContext, authRequestContext, authRequestContext));
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setShimmerDuration(1500);
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setShimmerLayoutManager(ServiceShimmerRecycleView.LayoutManagerType.GRID);
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setGridChildCount(4);
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setShimmerChildCount(9);
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setLayoutManager(gridLayoutManager);
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setItemAnimator(null);
            if (getBaseActivity().getIntent().getData() == null) {
                try {
                    int i = initRecordTimeStamp + 31;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                    int i2 = i % 2;
                    ServicesContract.Presenter presenter = getPresenter().get();
                    getBaseActivity();
                    presenter.BuiltInFictitiousFunctionClassFactory((Intent) null, false);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = initRecordTimeStamp + 121;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void initRecordTimeStamp() {
        ServiceV2Adapter serviceV2Adapter = new ServiceV2Adapter(true, getSingleItemClickListener(), null, 4, null);
        this.lookAheadTest = serviceV2Adapter;
        BaseRecyclerViewHolder.OnItemClickListener scheduleImpl = scheduleImpl();
        Intrinsics.checkNotNullParameter(scheduleImpl, "");
        serviceV2Adapter.PlaceComponentResult = scheduleImpl;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setAdapter(this.lookAheadTest);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.smoothScrollToPosition(0);
        int i = initRecordTimeStamp + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (!(i % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private final ServicesContract.View lookAheadTest() {
        ServicesContract.View view = new ServicesContract.View() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getServicesView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
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
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceCardV2View.this.getPayLaterPresenter().get().MyBillsEntityDataFactory(p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
                ServiceCardV2View serviceCardV2View = ServiceCardV2View.this;
                String authRequestContext = UrlUtil.getAuthRequestContext(p0.getCallingPid);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                ServiceCardV2View.access$openH5(serviceCardV2View, p0, authRequestContext, p1, ServiceCardV2View.this.getDeviceInformationProvider().get().getDeviceUUID());
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionFailed(String p0) {
                ServiceCardV2View.access$enableClick(ServiceCardV2View.this);
                ServiceCardV2View.access$stopLoadTime(ServiceCardV2View.this);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onFeatureServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceCardV2View.access$setupServiceList(ServiceCardV2View.this, p0);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onCheckFavoriteServicesFeature(boolean p0) {
                ServiceCardV2View.this.getPresenter().get().getAuthRequestContext(true);
                ServiceCardV2View.this.getPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onMaintenanceAction(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceMaintenanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                ServiceCardV2View.access$enableClick(ServiceCardV2View.this);
                ServiceCardV2View.access$stopLoadTime(ServiceCardV2View.this);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
                    return;
                }
                ServiceCardV2View.this.getPayLaterPresenter().get().MyBillsEntityDataFactory(p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str != null) {
                    ServiceCardV2View serviceCardV2View = ServiceCardV2View.this;
                    if (UrlUtil.getErrorConfigVersion(str)) {
                        serviceCardV2View.getReadLinkPropertiesPresenter().get().MyBillsEntityDataFactory(str);
                        return;
                    }
                    String authRequestContext = UrlUtil.getAuthRequestContext(str);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    ServiceCardV2View.access$openH5(serviceCardV2View, p0, authRequestContext, null, null);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionMiniApp(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
                    return;
                }
                Uri.Builder buildUpon = Uri.parse(p0.NetworkUserEntityData$$ExternalSyntheticLambda6).buildUpon();
                if (p0.MyBillsEntityDataFactory != null) {
                    buildUpon.appendQueryParameter("bizType", p0.MyBillsEntityDataFactory);
                }
                if (p0.getSupportButtonTintMode != null) {
                    buildUpon.appendQueryParameter(BranchLinkConstant.MiniAppParams.NEED_OAUTH, p0.getSupportButtonTintMode);
                }
                if (p0.getCallingPid != null) {
                    buildUpon.appendQueryParameter("redirectUrl", p0.getCallingPid);
                }
                if (p0.VerifyPinStateManager$executeRiskChallenge$2$1 != null) {
                    buildUpon.appendQueryParameter("scopes", p0.VerifyPinStateManager$executeRiskChallenge$2$1);
                }
                if (p0.moveToNextValue != null) {
                    buildUpon.appendQueryParameter("clientId", p0.moveToNextValue);
                }
                String obj = buildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                if (UrlUtil.getErrorConfigVersion(obj)) {
                    ServiceCardV2View.this.getReadLinkPropertiesPresenter().get().MyBillsEntityDataFactory(obj);
                    return;
                }
                ServiceCardV2View serviceCardV2View = ServiceCardV2View.this;
                String authRequestContext = UrlUtil.getAuthRequestContext(obj);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                ServiceCardV2View.access$openH5(serviceCardV2View, p0, authRequestContext, null, null);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService p0, Map<String, String> p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                    ServiceCardV2View.this.getFeaturePresenter().get().getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, p1);
                }
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        return view;
    }

    private final GlobalNetworkListener NetworkUserEntityData$$ExternalSyntheticLambda0() {
        GlobalNetworkListener globalNetworkListener = new GlobalNetworkListener() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getGlobalNetworkListener$1
            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                if (TextUtils.isEmpty(ServiceCardV2View.access$getFullUrl$p(ServiceCardV2View.this))) {
                    return;
                }
                ServiceCardV2View serviceCardV2View = ServiceCardV2View.this;
                ServiceCardV2View.access$openAcService(serviceCardV2View, ServiceCardV2View.access$getFullUrl$p(serviceCardV2View), p0);
            }
        };
        int i = initRecordTimeStamp + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        return globalNetworkListener;
    }

    private final BottomSheetOnBoardingContract.View getAuthRequestContext() {
        BottomSheetOnBoardingContract.View view = new BottomSheetOnBoardingContract.View() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getBottomSheetOnBoardingView$1
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
                if (p0) {
                    p1 = UrlUtil.PlaceComponentResult(p1, OnboardingParams.FIRST_TIME_TOP_UP);
                    ServiceCardV2View.access$saveBottomSheetOnBoarding(ServiceCardV2View.this, p2);
                }
                DanaH5.startContainerFullUrlWithSendCredentials$default(p1, ServiceCardV2View.access$createH5AppListener(ServiceCardV2View.this), null, null, 12, null);
                ServiceCardV2View.access$doOnOpenH5(ServiceCardV2View.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append("on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
            }
        };
        int i = initRecordTimeStamp + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        return view;
    }

    private final void PlaceComponentResult(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            if ((Intrinsics.areEqual(str, "loan_personal") ? 'c' : '5') != '5') {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 3;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
                getOnBoardingServicePresenter().get().MyBillsEntityDataFactory("loan_personal");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        int i = initRecordTimeStamp + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        super.onDetachedFromWindow();
        try {
            getPresenter().get().onDestroy();
            getPlayStoreReviewPresenter().get().onDestroy();
            getReadLinkPropertiesPresenter().get().onDestroy();
            getOnBoardingServicePresenter().get().onDestroy();
            getGlobalNetworkPresenter().get().onDestroy();
            getPayLaterPresenter().get().onDestroy();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 39;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (r6.getId() == id.dana.R.id.btn_service_action) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // id.dana.base.BaseRichView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSingleClick(android.view.View r6) {
        /*
            r5 = this;
            r0 = 93
            if (r6 == 0) goto L7
            r1 = 19
            goto L9
        L7:
            r1 = 93
        L9:
            r2 = 1
            r3 = 0
            if (r1 == r0) goto L31
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 48
            if (r0 != 0) goto L1d
            r0 = 7
            goto L1f
        L1d:
            r0 = 48
        L1f:
            r4 = 2131362343(0x7f0a0227, float:1.8344464E38)
            if (r0 == r1) goto L2a
            int r6 = r6.getId()
        L28:
            r6 = 1
            goto L32
        L2a:
            int r6 = r6.getId()
            if (r6 != r4) goto L31
            goto L28
        L31:
            r6 = 0
        L32:
            if (r6 == 0) goto L35
            r2 = 0
        L35:
            if (r2 == 0) goto L38
            goto L69
        L38:
            int r6 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r6 = r6 + 73
            int r0 = r6 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r6 = r6 % 2
            if (r6 == 0) goto L59
            r5.NetworkUserEntityData$$ExternalSyntheticLambda2()
            dagger.Lazy r6 = r5.getPresenter()
            java.lang.Object r6 = r6.get()
            id.dana.contract.services.ServicesContract$Presenter r6 = (id.dana.contract.services.ServicesContract.Presenter) r6
            r6.scheduleImpl()
            r6 = 0
            int r6 = r6.length     // Catch: java.lang.Throwable -> L57
            goto L69
        L57:
            r6 = move-exception
            throw r6
        L59:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda2()
            dagger.Lazy r6 = r5.getPresenter()
            java.lang.Object r6 = r6.get()
            id.dana.contract.services.ServicesContract$Presenter r6 = (id.dana.contract.services.ServicesContract.Presenter) r6
            r6.scheduleImpl()
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.onSingleClick(android.view.View):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void newProxyInstance() {
        /*
            r5 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            r1 = 3
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r2
            int r0 = r0 % 2
            id.dana.DanaApplication r0 = r5.BuiltInFictitiousFunctionClassFactory()
            r2 = 77
            if (r0 == 0) goto L13
            goto L15
        L13:
            r1 = 77
        L15:
            r3 = 0
            if (r1 == r2) goto L1b
            java.util.List<id.dana.model.ThirdPartyService> r0 = r0.servicesData
            goto L1c
        L1b:
            r0 = r3
        L1c:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            r2 = 0
            if (r1 == 0) goto L3d
            boolean r1 = r1.isEmpty()
            r4 = 10
            if (r1 != 0) goto L2d
            r1 = 12
            goto L2f
        L2d:
            r1 = 10
        L2f:
            if (r1 == r4) goto L3d
            int r1 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 71
            int r4 = r1 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r4
            int r1 = r1 % 2
            r1 = 0
            goto L3e
        L3d:
            r1 = 1
        L3e:
            if (r1 != 0) goto L64
            dagger.Lazy r1 = r5.getPresenter()     // Catch: java.lang.Exception -> L62
            java.lang.Object r1 = r1.get()
            id.dana.contract.services.ServicesContract$Presenter r1 = (id.dana.contract.services.ServicesContract.Presenter) r1
            r1.getAuthRequestContext(r2)
            id.dana.richview.servicescard.adapter.ServiceV2Adapter r1 = r5.lookAheadTest
            if (r1 == 0) goto L5e
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)     // Catch: java.lang.Exception -> L5c
            androidx.recyclerview.widget.AsyncListDiffer<T> r1 = r1.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L5c
            r1.KClassImpl$Data$declaredNonStaticMembers$2(r0, r3)     // Catch: java.lang.Exception -> L5c
            goto L5e
        L5c:
            r0 = move-exception
            throw r0
        L5e:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda6()
            goto L67
        L62:
            r0 = move-exception
            throw r0
        L64:
            r5.showSkeleton()
        L67:
            dagger.Lazy r0 = r5.getPresenter()
            java.lang.Object r0 = r0.get()
            id.dana.contract.services.ServicesContract$Presenter r0 = (id.dana.contract.services.ServicesContract.Presenter) r0
            r0.moveToNextValue()
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 121
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 88
            if (r0 != 0) goto L85
            r0 = 88
            goto L87
        L85:
            r0 = 21
        L87:
            if (r0 == r1) goto L8a
            return
        L8a:
            int r0 = r3.length     // Catch: java.lang.Throwable -> L8c
            return
        L8c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.newProxyInstance():void");
    }

    private final BaseRecyclerViewHolder.OnItemClickListener scheduleImpl() {
        final BaseActivity baseActivity = getBaseActivity();
        SingleItemClickListener singleItemClickListener = new SingleItemClickListener(baseActivity) { // from class: id.dana.richview.servicescard.ServiceCardV2View$getOnItemClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(baseActivity);
            }

            @Override // id.dana.base.SingleItemClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                ServiceV2Adapter access$getServiceAdapter$p = ServiceCardV2View.access$getServiceAdapter$p(ServiceCardV2View.this);
                if (access$getServiceAdapter$p != null) {
                    int placeComponentResult = access$getServiceAdapter$p.getPlaceComponentResult();
                    ServiceCardV2View serviceCardV2View = ServiceCardV2View.this;
                    if (p0 >= placeComponentResult - 1) {
                        ServiceCardV2View.access$handleViewAllServiceButton(serviceCardV2View);
                    } else {
                        ServiceCardV2View.access$handleOpenService(serviceCardV2View, p0);
                    }
                }
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 45;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        return singleItemClickListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        if (r14 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r0.NetworkUserEntityData$$ExternalSyntheticLambda6 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        r14 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp + 49;
        id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r14 % 128;
        r14 = r14 % 2;
        r14 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(int r14) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.BuiltInFictitiousFunctionClassFactory(int):void");
    }

    private static void moveToNextValue(String str) {
        try {
            try {
                if (!(!Intrinsics.areEqual(str, "service_send_money_bank"))) {
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 103;
                    initRecordTimeStamp = i % 128;
                    int i2 = i % 2;
                    FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
                    FirstActionTracker.PlaceComponentResult("Transfer via Bank Open");
                    int i3 = initRecordTimeStamp + 117;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                    if ((i3 % 2 != 0 ? 'C' : (char) 18) != 18) {
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                } else if (Intrinsics.areEqual(str, "service_send_money_chat")) {
                    int i4 = initRecordTimeStamp + 51;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i4 % 128;
                    int i5 = i4 % 2;
                    FirstActionTracker firstActionTracker2 = FirstActionTracker.INSTANCE;
                    FirstActionTracker.PlaceComponentResult("Transfer via Chat Open");
                } else {
                    FirstActionTracker firstActionTracker3 = FirstActionTracker.INSTANCE;
                    FirstActionTracker.MyBillsEntityDataFactory();
                    int i6 = initRecordTimeStamp + 21;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i6 % 128;
                    int i7 = i6 % 2;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void GetContactSyncConfig() {
        int i = initRecordTimeStamp + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        if (getContext() != null) {
            FragmentBottomSheetPaymentSettingBinding();
            getContext().startActivity(new Intent(getContext(), ServicesActivity.class));
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 79;
                try {
                    initRecordTimeStamp = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = initRecordTimeStamp + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        byte b = 0;
        boolean z = i % 2 == 0;
        boolean areEqual = Intrinsics.areEqual("service_goals", str);
        if (!z) {
            Object obj = null;
            obj.hashCode();
            if (!areEqual) {
                return;
            }
        } else if (!areEqual) {
            return;
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.SAVINGS_GOAL_OPEN;
        Object[] objArr = new Object[1];
        a(new char[]{40309, 12876, 2683, 8528, 47430, 25767, 50237, 3502}, new char[]{3594, 10934, 52507, 20630}, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{0, 0, 0, 0}, View.MeasureSpec.getMode(0), objArr);
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", ((String) objArr[0]).intern());
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
        int i2 = initRecordTimeStamp + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void FragmentBottomSheetPaymentSettingBinding() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.ALL_SERVICE_OPEN;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 115;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
    }

    private final void getAuthRequestContext(ThirdPartyService thirdPartyService, String str, String str2, String str3) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 83;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        GContainer.closeAllContainers();
        if ((!GContainer.isOpeningH5() ? 'Q' : (char) 3) != 'Q') {
            return;
        }
        try {
            int i3 = initRecordTimeStamp + 117;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    this.BuiltInFictitiousFunctionClassFactory = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, thirdPartyService);
                    PlaceComponentResult(thirdPartyService);
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                this.BuiltInFictitiousFunctionClassFactory = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, thirdPartyService);
                PlaceComponentResult(thirdPartyService);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final ThirdPartyService KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyService thirdPartyService) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 29;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? (char) 15 : 'Q') != 'Q') {
            getPayLaterPresenter().get().getAuthRequestContext(thirdPartyService.BottomSheetCardBindingView$watcherCardNumberView$1);
            int i2 = 37 / 0;
        } else {
            try {
                getPayLaterPresenter().get().getAuthRequestContext(thirdPartyService.BottomSheetCardBindingView$watcherCardNumberView$1);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = initRecordTimeStamp + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? 'D' : '8') != 'D') {
            return thirdPartyService;
        }
        int i4 = 99 / 0;
        return thirdPartyService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r0 == null) != true) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        r0.servicesData = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        r5 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp + 97;
        id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if ((r5 % 2) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        r5 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if ((r0 != null) != true) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(java.util.List<id.dana.model.ThirdPartyService> r5) {
        /*
            r4 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r2
            int r0 = r0 % 2
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L1d
            id.dana.DanaApplication r0 = r4.BuiltInFictitiousFunctionClassFactory()
            r3.hashCode()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L18
            r2 = 1
        L18:
            if (r2 == r1) goto L27
            goto L29
        L1b:
            r5 = move-exception
            throw r5
        L1d:
            id.dana.DanaApplication r0 = r4.BuiltInFictitiousFunctionClassFactory()
            if (r0 == 0) goto L24
            goto L25
        L24:
            r2 = 1
        L25:
            if (r2 == r1) goto L29
        L27:
            r0.servicesData = r5
        L29:
            int r5 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r5 = r5 + 97
            int r0 = r5 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L39
            int r5 = r3.length     // Catch: java.lang.Throwable -> L37
            return
        L37:
            r5 = move-exception
            throw r5
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.BuiltInFictitiousFunctionClassFactory(java.util.List):void");
    }

    private final DanaH5Listener MyBillsEntityDataFactory() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.richview.servicescard.ServiceCardV2View$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                ServiceCardV2View.this.getH5EventPresenter().get().BuiltInFictitiousFunctionClassFactory();
                DanaH5.dispose();
                if (ServiceCardV2View.access$getCheckoutH5EventSuccess$p(ServiceCardV2View.this)) {
                    ServiceCardV2View.this.getPlayStoreReviewPresenter().get().PlaceComponentResult();
                }
            }
        };
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 9;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            return danaH5Listener;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 93;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        this.getAuthRequestContext = false;
        getH5EventPresenter().get().MyBillsEntityDataFactory();
        int i3 = initRecordTimeStamp + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String str, boolean z) {
        int i = initRecordTimeStamp + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (!(i % 2 != 0)) {
            if ((str != null ? (char) 16 : (char) 1) == 1) {
                return;
            }
        } else {
            Object[] objArr = null;
            int length = objArr.length;
            if (str == null) {
                return;
            }
        }
        if (!z) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(str);
                try {
                    sb.append(GlobalNetworkConstants.FOREX_EXCHANGE);
                    str = sb.toString();
                    int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 13;
                    initRecordTimeStamp = i2 % 128;
                    int i3 = i2 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        DanaH5.startContainerFullUrl(str, MyBillsEntityDataFactory());
        KClassImpl$Data$declaredNonStaticMembers$2();
        getGlobalNetworkPresenter().get().getAuthRequestContext();
    }

    private static String MyBillsEntityDataFactory(String str) {
        Object[] objArr = null;
        if (str != null) {
            if ((!StringsKt.contains$default((CharSequence) str, (CharSequence) "entryPoint", false, 2, (Object) null) ? 'c' : 'Y') != 'Y') {
                try {
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 7;
                    initRecordTimeStamp = i % 128;
                    boolean z = i % 2 != 0;
                    str = UrlUtil.getAuthRequestContext(str, "Home");
                    if (!z) {
                        objArr.hashCode();
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        try {
            int i2 = initRecordTimeStamp + 123;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            if (i2 % 2 != 0) {
                int length = objArr.length;
                return str;
            }
            return str;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final String BuiltInFictitiousFunctionClassFactory(String str) {
        int i = initRecordTimeStamp + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            String MyBillsEntityDataFactory = MyBillsEntityDataFactory(str);
            UserLoanInfo PlaceComponentResult = getPayLaterPresenter().get().PlaceComponentResult(LoanInfo.LOAN_PERSONAL);
            String correctedUrl = DanaH5.correctedUrl(UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, UrlUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, MyBillsEntityDataFactory)));
            int i3 = initRecordTimeStamp + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? 'H' : '0') != 'H') {
                return correctedUrl;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return correctedUrl;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void PlaceComponentResult(ThirdPartyService thirdPartyService) {
        Bundle bundle = new Bundle();
        bundle.putString(DanaH5.SERVICE_KEY, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8);
        try {
            if (StringsKt.equals("service_akulaku", thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
                int i = initRecordTimeStamp + 63;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
                DanaH5.startContainerFullUrlWithSendCredentials$default(MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), MyBillsEntityDataFactory(), bundle, null, 8, null);
                KClassImpl$Data$declaredNonStaticMembers$2();
            } else if (StringsKt.equals("service_paylater_loan_personal", thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
                getOnBoardingServicePresenter().get().PlaceComponentResult("loan_personal", BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory));
            } else if (StringsKt.equals("service_danakaget", thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 35;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
                getOnBoardingServicePresenter().get().PlaceComponentResult("dana_kaget", this.BuiltInFictitiousFunctionClassFactory);
            } else if (StringsKt.equals("service_my_bills", thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
                getOnBoardingServicePresenter().get().PlaceComponentResult("my_bills", this.BuiltInFictitiousFunctionClassFactory);
            } else if (StringsKt.equals(GlobalNetworkConstants.GLOBAL_NETWORK_SERVICE, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
                getGlobalNetworkPresenter().get().BuiltInFictitiousFunctionClassFactory();
            } else {
                if ((StringsKt.equals("service_danafood", thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, true) ? 'J' : InputCardNumberView.DIVIDER) != 'J') {
                    try {
                        DanaH5.startContainerFullUrlWithSendCredentials$default(BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory), MyBillsEntityDataFactory(), bundle, null, 8, null);
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i5 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 61;
                initRecordTimeStamp = i5 % 128;
                if ((i5 % 2 == 0 ? '8' : 'B') == 'B') {
                    getOnBoardingServicePresenter().get().PlaceComponentResult("dana_food", this.BuiltInFictitiousFunctionClassFactory);
                    return;
                }
                getOnBoardingServicePresenter().get().PlaceComponentResult("dana_food", this.BuiltInFictitiousFunctionClassFactory);
                int i6 = 47 / 0;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r4 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        return new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (r4.size() <= 8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        r0 = '(';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        r0 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if (r0 == '(') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 + 91;
        id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r0 % 128;
        r0 = r0 % 2;
        r4 = r4.subList(0, 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r0 = new id.dana.model.ThirdPartyService.Builder();
        r0.NetworkUserEntityData$$ExternalSyntheticLambda3 = getContext().getString(id.dana.R.string.key_view_all);
        r0.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = 1;
        r4.add(r0.PlaceComponentResult());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r4 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<id.dana.model.ThirdPartyService> PlaceComponentResult(java.util.List<id.dana.model.ThirdPartyService> r4) {
        /*
            r3 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 99
            if (r0 != 0) goto L11
            r0 = 32
            goto L13
        L11:
            r0 = 99
        L13:
            if (r0 == r1) goto L1c
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L1a
            if (r4 != 0) goto L26
            goto L1e
        L1a:
            r4 = move-exception
            throw r4
        L1c:
            if (r4 != 0) goto L26
        L1e:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            return r4
        L26:
            int r0 = r4.size()
            r1 = 40
            r2 = 8
            if (r0 <= r2) goto L33
            r0 = 40
            goto L35
        L33:
            r0 = 71
        L35:
            if (r0 == r1) goto L38
            goto L47
        L38:
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r0 = 0
            java.util.List r4 = r4.subList(r0, r2)
        L47:
            id.dana.model.ThirdPartyService$Builder r0 = new id.dana.model.ThirdPartyService$Builder
            r0.<init>()
            android.content.Context r1 = r3.getContext()
            r2 = 2131954592(0x7f130ba0, float:1.9545688E38)
            java.lang.String r1 = r1.getString(r2)
            r0.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            r1 = 1
            r0.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = r1
            id.dana.model.ThirdPartyService r0 = r0.PlaceComponentResult()
            r4.add(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.PlaceComponentResult(java.util.List):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showShimmerOnPromotedService() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.showShimmerOnPromotedService():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void hideShimmerOnPromotedService() {
        /*
            r8 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L8a
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> L8a
            r1 = 2
            int r0 = r0 % r1
            id.dana.richview.servicescard.adapter.viewholder.PromotedServiceV2ViewHolder r0 = r8.moveToNextValue()
            if (r0 == 0) goto L89
            java.lang.String r2 = r0.getAuthRequestContext
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L89
            java.lang.String r2 = r0.getAuthRequestContext
            r3 = 0
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3a
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> L8a
            java.lang.String r6 = "service_paylater"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch: java.lang.Exception -> L38
            boolean r2 = kotlin.text.StringsKt.contains$default(r2, r6, r5, r1, r3)     // Catch: java.lang.Exception -> L38
            r6 = 9
            if (r2 == r4) goto L32
            r2 = 9
            goto L34
        L32:
            r2 = 81
        L34:
            if (r2 == r6) goto L3a
            r2 = 1
            goto L3b
        L38:
            r0 = move-exception
            throw r0
        L3a:
            r2 = 0
        L3b:
            if (r2 == 0) goto L89
            java.lang.Object r2 = r0.getBinding()
            id.dana.databinding.ItemPromotedServiceV2Binding r2 = (id.dana.databinding.ItemPromotedServiceV2Binding) r2
            com.ethanhua.skeleton.SkeletonScreen r6 = r0.lookAheadTest
            if (r6 == 0) goto L49
            r7 = 1
            goto L4a
        L49:
            r7 = 0
        L4a:
            if (r7 == 0) goto L4f
            r6.PlaceComponentResult()
        L4f:
            android.widget.ImageView r6 = r2.getErrorConfigVersion
            r7 = 8
            r6.setVisibility(r7)
            id.dana.richview.EllipseTextView r6 = r2.NetworkUserEntityData$$ExternalSyntheticLambda0
            r6.setVisibility(r5)
            com.ethanhua.skeleton.SkeletonScreen r0 = r0.PlaceComponentResult
            if (r0 == 0) goto L60
            r4 = 0
        L60:
            if (r4 == 0) goto L63
            goto L7f
        L63:
            int r4 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r4 = r4 + 123
            int r6 = r4 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r6
            int r4 = r4 % r1
            r1 = 99
            if (r4 == 0) goto L72
            r4 = 3
            goto L74
        L72:
            r4 = 99
        L74:
            r0.PlaceComponentResult()
            if (r4 == r1) goto L7f
            r3.hashCode()     // Catch: java.lang.Throwable -> L7d
            goto L7f
        L7d:
            r0 = move-exception
            throw r0
        L7f:
            android.widget.ImageView r0 = r2.KClassImpl$Data$declaredNonStaticMembers$2
            r0.setVisibility(r7)
            android.widget.Button r0 = r2.BuiltInFictitiousFunctionClassFactory
            r0.setVisibility(r5)
        L89:
            return
        L8a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.hideShimmerOnPromotedService():void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.richview.servicescard.ServiceCardV2View$getPayLaterViewListener$1] */
    private final ServiceCardV2View$getPayLaterViewListener$1 getErrorConfigVersion() {
        ?? r0 = new PayLaterViewListener() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getPayLaterViewListener$1
            @Override // id.dana.contract.paylater.PayLaterViewListener, id.dana.contract.paylater.PayLaterContract.View
            public final void BuiltInFictitiousFunctionClassFactory(final List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceCardV2View serviceCardV2View = ServiceCardV2View.this;
                final ServiceCardV2View serviceCardV2View2 = ServiceCardV2View.this;
                Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getPayLaterViewListener$1$onComposedPromotedService$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        ServiceCardListener access$getServiceCardListener$p = ServiceCardV2View.access$getServiceCardListener$p(ServiceCardV2View.this);
                        if (access$getServiceCardListener$p != null) {
                            access$getServiceCardListener$p.MyBillsEntityDataFactory(str);
                        }
                    }
                };
                final ServiceCardV2View serviceCardV2View3 = ServiceCardV2View.this;
                Function2<BannerLottieModel, String, Unit> function2 = new Function2<BannerLottieModel, String, Unit>() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getPayLaterViewListener$1$onComposedPromotedService$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(BannerLottieModel bannerLottieModel, String str) {
                        invoke2(bannerLottieModel, str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BannerLottieModel bannerLottieModel, String str) {
                        Object m3179constructorimpl;
                        Intrinsics.checkNotNullParameter(bannerLottieModel, "");
                        ServiceCardV2View serviceCardV2View4 = serviceCardV2View3;
                        List<ThirdPartyService> list = p0;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            ServiceCardV2View.access$setShownBannerService(serviceCardV2View4, bannerLottieModel, str);
                            ServiceCardV2View.access$trackPromotedService(serviceCardV2View4, list, ThirdPartyService.UIVersion.VERSION_2);
                            m3179constructorimpl = Result.m3179constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
                        }
                        ServiceCardV2View serviceCardV2View5 = serviceCardV2View3;
                        List<ThirdPartyService> list2 = p0;
                        if (Result.m3182exceptionOrNullimpl(m3179constructorimpl) != null) {
                            ServiceCardV2View.access$setupServiceCardWithoutBanner(serviceCardV2View5, null);
                            ServiceCardV2View.access$setupHideBannerService(serviceCardV2View5);
                            ServiceCardV2View.trackPromotedService$default(serviceCardV2View5, list2, null, 2, null);
                        }
                    }
                };
                final ServiceCardV2View serviceCardV2View4 = ServiceCardV2View.this;
                Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getPayLaterViewListener$1$onComposedPromotedService$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        ServiceCardV2View.access$setupServiceCardWithoutBanner(ServiceCardV2View.this, str);
                        ServiceCardV2View.access$setupHideBannerService(ServiceCardV2View.this);
                        ServiceCardV2View.trackPromotedService$default(ServiceCardV2View.this, p0, null, 2, null);
                    }
                };
                final ServiceCardV2View serviceCardV2View5 = ServiceCardV2View.this;
                ServiceCardV2View.access$handleServiceCard(serviceCardV2View, p0, function1, function2, function12, new Function1<List<? extends ThirdPartyService>, Unit>() { // from class: id.dana.richview.servicescard.ServiceCardV2View$getPayLaterViewListener$1$onComposedPromotedService$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyService> list) {
                        invoke2((List<ThirdPartyService>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<ThirdPartyService> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                        ServiceV2Adapter access$getServiceAdapter$p = ServiceCardV2View.access$getServiceAdapter$p(ServiceCardV2View.this);
                        if (access$getServiceAdapter$p != null) {
                            Intrinsics.checkNotNullParameter(list, "");
                            access$getServiceAdapter$p.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(list, null);
                        }
                        ServiceCardV2View.this.getPresenter().get().PlaceComponentResult();
                        HomeWidgetEntityData homeWidgetEntityData = ServiceCardV2View.this.getHomeWidgetCache().get();
                        ThirdPartyService.Companion companion = ThirdPartyService.INSTANCE;
                        homeWidgetEntityData.saveServices(ThirdPartyService.Companion.PlaceComponentResult(list));
                        ServiceCardV2View.access$updateInMemoryCache(ServiceCardV2View.this, list);
                        ServiceCardV2View.this.hideSkeleton();
                        ServiceCardV2View.this.getPresenter().get().getAuthRequestContext(false);
                    }
                }).q_();
                ServiceCardV2View.access$stopLoadTime(ServiceCardV2View.this);
            }
        };
        int i = initRecordTimeStamp + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        return r0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if ((!(r6.isEmpty() ^ true)) != true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if ((r6.isEmpty() | false) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(java.util.List<id.dana.model.ThirdPartyService> r6) {
        /*
            r5 = this;
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 91
            r2 = 1
            if (r0 != 0) goto L11
            r0 = 1
            goto L13
        L11:
            r0 = 91
        L13:
            r3 = 0
            r4 = 0
            if (r0 == r1) goto L22
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 | r4
            if (r0 != 0) goto L33
            goto L32
        L22:
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != 0) goto L2e
            r0 = 1
            goto L2f
        L2e:
            r0 = 0
        L2f:
            if (r0 == r2) goto L32
            goto L33
        L32:
            r6 = r3
        L33:
            if (r6 == 0) goto L74
            id.dana.richview.servicescard.ServiceCardV2View$setupServiceList$2 r0 = new id.dana.richview.servicescard.ServiceCardV2View$setupServiceList$2
            r0.<init>()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch: java.lang.Exception -> L72
            java.util.List r6 = KClassImpl$Data$declaredNonStaticMembers$2(r6, r0)     // Catch: java.lang.Exception -> L70
            java.util.Collection r6 = (java.util.Collection) r6     // Catch: java.lang.Exception -> L72
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r6)     // Catch: java.lang.Exception -> L72
            if (r6 == 0) goto L4a
            r0 = 1
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r0 == r2) goto L4e
            goto L74
        L4e:
            java.util.List r6 = r5.PlaceComponentResult(r6)
            if (r6 == 0) goto L55
            goto L56
        L55:
            r2 = 0
        L56:
            if (r2 == 0) goto L74
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r1
            int r0 = r0 % 2
            dagger.Lazy r0 = r5.getPayLaterPresenter()
            java.lang.Object r0 = r0.get()
            id.dana.contract.paylater.PayLaterContract$Presenter r0 = (id.dana.contract.paylater.PayLaterContract.Presenter) r0
            r0.MyBillsEntityDataFactory(r6)
            goto L74
        L70:
            r6 = move-exception
            throw r6
        L72:
            r6 = move-exception
            throw r6
        L74:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda6()
            int r6 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r6 = r6 + 45
            int r0 = r6 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r6 = r6 % 2
            if (r6 == 0) goto L89
            r3.hashCode()     // Catch: java.lang.Throwable -> L87
            return
        L87:
            r6 = move-exception
            throw r6
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.KClassImpl$Data$declaredNonStaticMembers$2(java.util.List):void");
    }

    private static List<ThirdPartyService> KClassImpl$Data$declaredNonStaticMembers$2(List<ThirdPartyService> list, Function1<? super ThirdPartyService, ThirdPartyService> function1) {
        List<ThirdPartyService> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        int i = 0;
        while (true) {
            if ((it.hasNext() ? Typography.dollar : 'Y') == '$') {
                int i2 = initRecordTimeStamp + 107;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
                try {
                    Object next = it.next();
                    if ((i < 0 ? ';' : 'B') != 'B') {
                        CollectionsKt.throwIndexOverflow();
                    }
                    try {
                        ThirdPartyService thirdPartyService = (ThirdPartyService) next;
                        if (i == 0) {
                            int i4 = initRecordTimeStamp + 59;
                            NetworkUserEntityData$$ExternalSyntheticLambda1 = i4 % 128;
                            int i5 = i4 % 2;
                            if (thirdPartyService.getErrorConfigVersion()) {
                                thirdPartyService = function1.invoke(thirdPartyService);
                                int i6 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 85;
                                initRecordTimeStamp = i6 % 128;
                                int i7 = i6 % 2;
                            }
                        }
                        arrayList.add(thirdPartyService);
                        i++;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                return arrayList;
            }
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final io.reactivex.Completable getAuthRequestContext(final java.util.List<id.dana.model.ThirdPartyService> r17, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r18, final kotlin.jvm.functions.Function2<? super id.dana.model.BannerLottieModel, ? super java.lang.String, kotlin.Unit> r19, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r20, final kotlin.jvm.functions.Function1<? super java.util.List<id.dana.model.ThirdPartyService>, kotlin.Unit> r21) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.getAuthRequestContext(java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):io.reactivex.Completable");
    }

    private static final void PlaceComponentResult(Function1 function1, String str, Function1 function12, List list, CompletableSubject completableSubject) {
        int i = initRecordTimeStamp + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(completableSubject, "");
        function1.invoke(str);
        function12.invoke(list);
        completableSubject.onComplete();
        try {
            int i3 = initRecordTimeStamp + 109;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void BuiltInFictitiousFunctionClassFactory(Function1 function1, String str, Function1 function12, List list, CompletableSubject completableSubject) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 107;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(completableSubject, "");
        function1.invoke(str);
        function12.invoke(list);
        completableSubject.onComplete();
        int i3 = initRecordTimeStamp + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if ((r4 != null ? ']' : '\b') != ']') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r4 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 + 107;
        id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r1 = r4.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if ((r4 != null) != false) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void BuiltInFictitiousFunctionClassFactory(kotlin.jvm.functions.Function1 r3, id.dana.model.ThirdPartyService r4, io.reactivex.subjects.CompletableSubject r5) {
        /*
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r1.length     // Catch: java.lang.Throwable -> L1e
            if (r4 == 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 == 0) goto L31
            goto L3c
        L1e:
            r3 = move-exception
            throw r3
        L20:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)     // Catch: java.lang.Exception -> L45
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)     // Catch: java.lang.Exception -> L45
            r0 = 93
            if (r4 == 0) goto L2d
            r2 = 93
            goto L2f
        L2d:
            r2 = 8
        L2f:
            if (r2 == r0) goto L3c
        L31:
            int r4 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r4 = r4 + 107
            int r0 = r4 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r0
            int r4 = r4 % 2
            goto L3e
        L3c:
            java.lang.String r1 = r4.scheduleImpl
        L3e:
            r3.invoke(r1)
            r5.onComplete()
            return
        L45:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.BuiltInFictitiousFunctionClassFactory(kotlin.jvm.functions.Function1, id.dana.model.ThirdPartyService, io.reactivex.subjects.CompletableSubject):void");
    }

    private final ValueAnimator.AnimatorUpdateListener BuiltInFictitiousFunctionClassFactory(final int i, final int i2, final BannerLottieModel bannerLottieModel, final String str) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.richview.servicescard.ServiceCardV2View$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ServiceCardV2View.$r8$lambda$GPEOqfXsKxRA5t7CJPNj4hqXPeA(ServiceCardV2View.this, i, bannerLottieModel, str, i2, valueAnimator);
            }
        };
        int i3 = initRecordTimeStamp + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return animatorUpdateListener;
    }

    private static final void MyBillsEntityDataFactory(ServiceCardV2View serviceCardV2View, int i, BannerLottieModel bannerLottieModel, String str, int i2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(serviceCardV2View, "");
        Intrinsics.checkNotNullParameter(valueAnimator, "");
        ViewServiceCardV2Binding binding = serviceCardV2View.getBinding();
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (!(animatedValue != null)) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        serviceCardV2View.getAuthRequestContext(binding.getAuthRequestContext.getPaddingLeft(), intValue, binding.getAuthRequestContext.getPaddingRight(), binding.getAuthRequestContext.getPaddingBottom());
        if (intValue == i) {
            int i3 = initRecordTimeStamp + 95;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            ServiceV2Adapter serviceV2Adapter = serviceCardV2View.lookAheadTest;
            if ((serviceV2Adapter != null ? '/' : '\'') == '/') {
                int i5 = initRecordTimeStamp + 115;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
                int i6 = i5 % 2;
                try {
                    serviceV2Adapter.BuiltInFictitiousFunctionClassFactory = true;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (serviceCardV2View.lookAheadTest != null) {
                Completable PlaceComponentResult = ServiceV2Adapter.PlaceComponentResult(serviceCardV2View.moveToNextValue());
                if (!(PlaceComponentResult == null)) {
                    try {
                        int i7 = initRecordTimeStamp + 29;
                        NetworkUserEntityData$$ExternalSyntheticLambda1 = i7 % 128;
                        if (i7 % 2 != 0) {
                            PlaceComponentResult.q_();
                            Object obj = null;
                            obj.hashCode();
                        } else {
                            PlaceComponentResult.q_();
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
            ServiceCardListener serviceCardListener = serviceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (serviceCardListener != null) {
                int i8 = initRecordTimeStamp + 87;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i8 % 128;
                int i9 = i8 % 2;
                serviceCardListener.MyBillsEntityDataFactory(getAuthRequestContext(bannerLottieModel, str, true));
            }
            serviceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (intValue == i2) {
            int i10 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 29;
            initRecordTimeStamp = i10 % 128;
            int i11 = i10 % 2;
            binding.BuiltInFictitiousFunctionClassFactory.playAnimation();
        }
    }

    private final ValueAnimator.AnimatorUpdateListener PlaceComponentResult(final int i, final int i2, final String str) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.richview.servicescard.ServiceCardV2View$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ServiceCardV2View.m2852$r8$lambda$8wDeQ3BJKD8C6YZjCPRAo63kY(ServiceCardV2View.this, i, str, i2, valueAnimator);
            }
        };
        try {
            int i3 = initRecordTimeStamp + 125;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if (i3 % 2 == 0) {
                    return animatorUpdateListener;
                }
                int i4 = 66 / 0;
                return animatorUpdateListener;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void PlaceComponentResult(ServiceCardV2View serviceCardV2View, int i, String str, int i2, ValueAnimator valueAnimator) {
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 33;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(serviceCardV2View, "");
        Intrinsics.checkNotNullParameter(valueAnimator, "");
        ViewServiceCardV2Binding binding = serviceCardV2View.getBinding();
        Object animatedValue = valueAnimator.getAnimatedValue();
        if ((animatedValue != null ? '.' : '+') != '.') {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int i5 = initRecordTimeStamp + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
        int i6 = i5 % 2;
        int intValue = ((Integer) animatedValue).intValue();
        serviceCardV2View.getAuthRequestContext(binding.getAuthRequestContext.getPaddingLeft(), intValue, binding.getAuthRequestContext.getPaddingRight(), binding.getAuthRequestContext.getPaddingBottom());
        if (intValue == i) {
            try {
                int i7 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 37;
                try {
                    initRecordTimeStamp = i7 % 128;
                    int i8 = i7 % 2;
                    ServiceV2Adapter serviceV2Adapter = serviceCardV2View.lookAheadTest;
                    if (serviceV2Adapter != null) {
                        int i9 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 17;
                        initRecordTimeStamp = i9 % 128;
                        int i10 = i9 % 2;
                        serviceV2Adapter.BuiltInFictitiousFunctionClassFactory = false;
                    }
                    ServiceCardListener serviceCardListener = serviceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (serviceCardListener != null) {
                        serviceCardListener.MyBillsEntityDataFactory(handleHeaderBackgroundColor$default(serviceCardV2View, null, str, false, 1, null));
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (intValue == i2) {
            binding.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
            serviceCardV2View.PrepareContext();
            int i11 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 63;
            initRecordTimeStamp = i11 % 128;
            int i12 = i11 % 2;
        }
    }

    private final Animator.AnimatorListener MyBillsEntityDataFactory(final BannerLottieModel bannerLottieModel, final String str) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: id.dana.richview.servicescard.ServiceCardV2View$lottieBannerServiceAnimatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (ServiceCardV2View.access$isFirstTimeAnimateBannerService$p(ServiceCardV2View.this)) {
                    ServiceCardV2View.access$setFirstTimeAnimateBannerService$p(ServiceCardV2View.this, false);
                    ServiceCardV2View.access$getBinding(ServiceCardV2View.this).BuiltInFictitiousFunctionClassFactory.pauseAnimation();
                    ServiceCardV2View.access$setupServiceCardWithBanner(ServiceCardV2View.this, bannerLottieModel, str);
                }
            }
        };
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 85;
            try {
                initRecordTimeStamp = i % 128;
                if (i % 2 != 0) {
                    return animatorListener;
                }
                Object obj = null;
                obj.hashCode();
                return animatorListener;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void getAuthRequestContext(BannerLottieModel bannerLottieModel, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 69;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            try {
                int paddingTop = getBinding().getAuthRequestContext.getPaddingTop();
                int authRequestContext = ViewExtKt.getAuthRequestContext(90.0f);
                ValueAnimator ofInt = ValueAnimator.ofInt(paddingTop, authRequestContext);
                ofInt.addUpdateListener(BuiltInFictitiousFunctionClassFactory(paddingTop, authRequestContext, bannerLottieModel, str));
                ofInt.setDuration(700L);
                ofInt.start();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 65;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void getAuthRequestContext(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 73;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        int paddingTop = getBinding().getAuthRequestContext.getPaddingTop();
        int authRequestContext = ViewExtKt.getAuthRequestContext(0.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(paddingTop, authRequestContext);
        ofInt.addUpdateListener(PlaceComponentResult(paddingTop, authRequestContext, str));
        ofInt.setDuration(700L);
        ofInt.start();
        try {
            int i3 = initRecordTimeStamp + 47;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 83;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        this.moveToNextValue = true;
        this.PlaceComponentResult = null;
        DatabaseTableConfigUtil();
        int i3 = initRecordTimeStamp + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.dollar : 'H') != '$') {
            return;
        }
        int i4 = 49 / 0;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(BannerLottieModel bannerLottieModel, String str) {
        ViewServiceCardV2Binding binding = getBinding();
        binding.BuiltInFictitiousFunctionClassFactory.setClickable(true);
        LottieAnimationView lottieAnimationView = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        SafeClickListenerExtensionKt.MyBillsEntityDataFactory(lottieAnimationView, new Function1<View, Unit>() { // from class: id.dana.richview.servicescard.ServiceCardV2View$setShownBannerService$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                ServiceCardV2View.access$handleOpenService(ServiceCardV2View.this, 0);
            }
        });
        BuiltInFictitiousFunctionClassFactory(bannerLottieModel, str);
        int i = initRecordTimeStamp + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? (char) 2 : '1') != 2) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void DatabaseTableConfigUtil() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 69;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? 'X' : 'B') != 'B') {
            ViewServiceCardV2Binding binding = getBinding();
            binding.BuiltInFictitiousFunctionClassFactory.setClickable(true);
            binding.BuiltInFictitiousFunctionClassFactory.cancelAnimation();
            binding.BuiltInFictitiousFunctionClassFactory.clearAnimation();
            return;
        }
        try {
            ViewServiceCardV2Binding binding2 = getBinding();
            binding2.BuiltInFictitiousFunctionClassFactory.setClickable(false);
            binding2.BuiltInFictitiousFunctionClassFactory.cancelAnimation();
            binding2.BuiltInFictitiousFunctionClassFactory.clearAnimation();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(BannerLottieModel bannerLottieModel, String str) {
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        if (LocaleUtil.PlaceComponentResult()) {
            int i = initRecordTimeStamp + 115;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            if ((!Intrinsics.areEqual(this.PlaceComponentResult, bannerLottieModel.KClassImpl$Data$declaredNonStaticMembers$2) ? '/' : (char) 6) != 6) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 117;
                initRecordTimeStamp = i3 % 128;
                if (i3 % 2 != 0) {
                    String str2 = bannerLottieModel.KClassImpl$Data$declaredNonStaticMembers$2;
                    this.PlaceComponentResult = str2;
                    getAuthRequestContext(str2, bannerLottieModel, str);
                    return;
                }
                String str3 = bannerLottieModel.KClassImpl$Data$declaredNonStaticMembers$2;
                this.PlaceComponentResult = str3;
                getAuthRequestContext(str3, bannerLottieModel, str);
                int i4 = 26 / 0;
                return;
            }
        } else {
            try {
                if (!Intrinsics.areEqual(this.PlaceComponentResult, bannerLottieModel.getAuthRequestContext)) {
                    try {
                        int i5 = initRecordTimeStamp + 75;
                        NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
                        int i6 = i5 % 2;
                        String str4 = bannerLottieModel.getAuthRequestContext;
                        this.PlaceComponentResult = str4;
                        getAuthRequestContext(str4, bannerLottieModel, str);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i7 = initRecordTimeStamp + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i7 % 128;
        if (!(i7 % 2 != 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void getAuthRequestContext(String str, BannerLottieModel bannerLottieModel, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 79;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        ViewServiceCardV2Binding binding = getBinding();
        binding.BuiltInFictitiousFunctionClassFactory.setAnimationFromUrl(str);
        binding.BuiltInFictitiousFunctionClassFactory.clearAnimation();
        Object[] objArr = null;
        if ((!binding.BuiltInFictitiousFunctionClassFactory.isAnimating() ? '\r' : '\'') != '\'') {
            int i3 = initRecordTimeStamp + 101;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if (i3 % 2 != 0) {
                binding.BuiltInFictitiousFunctionClassFactory.addAnimatorListener(MyBillsEntityDataFactory(bannerLottieModel, str2));
                int length = objArr.length;
            } else {
                try {
                    binding.BuiltInFictitiousFunctionClassFactory.addAnimatorListener(MyBillsEntityDataFactory(bannerLottieModel, str2));
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 75;
                initRecordTimeStamp = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        binding.BuiltInFictitiousFunctionClassFactory.setFailureListener(new LottieListener() { // from class: id.dana.richview.servicescard.ServiceCardV2View$$ExternalSyntheticLambda0
            @Override // com.airbnb.lottie.LottieListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                ServiceCardV2View.$r8$lambda$Beo7dghaEgXshMsRwKHzp5UN7Xw(ServiceCardV2View.this, (Throwable) obj);
            }
        });
        binding.BuiltInFictitiousFunctionClassFactory.playAnimation();
        binding.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
        int i6 = initRecordTimeStamp + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i6 % 128;
        if ((i6 % 2 != 0 ? '_' : 'G') != 'G') {
            int length2 = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if ((r4 == null) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        if (r0.KClassImpl$Data$declaredNonStaticMembers$2 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r0.getBinding().getAuthRequestContext.playAnimation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 + 117;
        id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PrepareContext() {
        /*
            r6 = this;
            id.dana.richview.servicescard.adapter.viewholder.PromotedServiceV2ViewHolder r0 = r6.moveToNextValue()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L47
            int r4 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r4 = r4 + 99
            int r5 = r4 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L17
            r4 = 1
            goto L18
        L17:
            r4 = 0
        L18:
            if (r4 == 0) goto L29
            java.lang.String r4 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r1.hashCode()     // Catch: java.lang.Throwable -> L27
            if (r4 == 0) goto L23
            r4 = 0
            goto L24
        L23:
            r4 = 1
        L24:
            if (r4 == r3) goto L47
            goto L2d
        L27:
            r0 = move-exception
            throw r0
        L29:
            java.lang.String r4 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L45
            if (r4 == 0) goto L47
        L2d:
            java.lang.Object r0 = r0.getBinding()
            id.dana.databinding.ItemPromotedServiceV2Binding r0 = (id.dana.databinding.ItemPromotedServiceV2Binding) r0
            com.airbnb.lottie.LottieAnimationView r0 = r0.getAuthRequestContext
            r0.playAnimation()
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L43
            int r0 = r0 + 117
            int r4 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r4     // Catch: java.lang.Exception -> L43
            int r0 = r0 % 2
            goto L47
        L43:
            r0 = move-exception
            throw r0
        L45:
            r0 = move-exception
            throw r0
        L47:
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 109
            int r4 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r4
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            goto L55
        L54:
            r2 = 1
        L55:
            if (r2 == r3) goto L5b
            int r0 = r1.length     // Catch: java.lang.Throwable -> L59
            return
        L59:
            r0 = move-exception
            throw r0
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.PrepareContext():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        int i = initRecordTimeStamp + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        PromotedServiceV2ViewHolder moveToNextValue = moveToNextValue();
        if ((moveToNextValue != null ? ']' : 'E') != 'E') {
            if ((moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 != null ? ',' : 'A') != ',') {
                return;
            }
            try {
                try {
                    moveToNextValue.getBinding().getAuthRequestContext.pauseAnimation();
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 3;
                    initRecordTimeStamp = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final void getAuthRequestContext(int i, int i2, int i3, int i4) {
        int i5 = initRecordTimeStamp + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
        if (!(i5 % 2 != 0)) {
            getBinding().getAuthRequestContext.setPadding(i, i2, i3, i4);
            return;
        }
        getBinding().getAuthRequestContext.setPadding(i, i2, i3, i4);
        int i6 = 42 / 0;
    }

    private final PromotedServiceV2ViewHolder moveToNextValue() {
        int i = initRecordTimeStamp + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.findViewHolderForLayoutPosition(0);
            PromotedServiceV2ViewHolder promotedServiceV2ViewHolder = null;
            if (findViewHolderForLayoutPosition instanceof PromotedServiceV2ViewHolder) {
                int i3 = initRecordTimeStamp + 121;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if ((i3 % 2 != 0 ? 'F' : 'C') != 'C') {
                    PromotedServiceV2ViewHolder promotedServiceV2ViewHolder2 = (PromotedServiceV2ViewHolder) findViewHolderForLayoutPosition;
                    promotedServiceV2ViewHolder.hashCode();
                    promotedServiceV2ViewHolder = promotedServiceV2ViewHolder2;
                } else {
                    promotedServiceV2ViewHolder = (PromotedServiceV2ViewHolder) findViewHolderForLayoutPosition;
                }
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 1;
            initRecordTimeStamp = i4 % 128;
            if ((i4 % 2 == 0 ? (char) 11 : 'Z') != 11) {
                return promotedServiceV2ViewHolder;
            }
            int i5 = 60 / 0;
            return promotedServiceV2ViewHolder;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void setViewHeaderBackgroundColor(String customColor) {
        if (!TextUtils.isEmpty(customColor)) {
            try {
                getBinding().MyBillsEntityDataFactory.setBackgroundColor(Color.parseColor(customColor));
                return;
            } catch (IllegalArgumentException unused) {
                NetworkUserEntityData$$ExternalSyntheticLambda7();
                return;
            }
        }
        int i = initRecordTimeStamp + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda7();
        try {
            int i3 = initRecordTimeStamp + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? '_' : 'T') != '_') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        int i = initRecordTimeStamp + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 != 0) {
            getBinding().MyBillsEntityDataFactory.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23182131099816));
            int i2 = 93 / 0;
        } else {
            getBinding().MyBillsEntityDataFactory.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23182131099816));
        }
        int i3 = initRecordTimeStamp + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void setServiceCardListener(ServiceCardListener serviceCardListener) {
        int i = initRecordTimeStamp + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = serviceCardListener;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = serviceCardListener;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = initRecordTimeStamp + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void hideSkeleton() {
        int i = initRecordTimeStamp + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.hideShimmerAdapter();
        int i3 = initRecordTimeStamp + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public final void refreshView() {
        int i = initRecordTimeStamp + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            getBinding().getAuthRequestContext.setVisibility(0);
            if (!(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return;
            }
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 71;
                initRecordTimeStamp = i3 % 128;
                if ((i3 % 2 == 0 ? '1' : '+') != '1') {
                    getPresenter().get().BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                getPresenter().get().BuiltInFictitiousFunctionClassFactory();
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void showSkeleton() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? '!' : (char) 19) != '!') {
            try {
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.showShimmerAdapter();
            } catch (Exception e) {
                throw e;
            }
        } else {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.showShimmerAdapter();
            Object obj = null;
            obj.hashCode();
        }
        int i2 = initRecordTimeStamp + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
    }

    private final DanaApplication BuiltInFictitiousFunctionClassFactory() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 39;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            Context applicationContext = getContext().getApplicationContext();
            if (!(applicationContext instanceof DanaApplication)) {
                int i3 = initRecordTimeStamp + 125;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                return null;
            }
            return (DanaApplication) applicationContext;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (((r7 & 1) == 0) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (((r7 | 1) != 0 ? 'G' : '6') != '6') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.String handleHeaderBackgroundColor$default(id.dana.richview.servicescard.ServiceCardV2View r3, id.dana.model.BannerLottieModel r4, java.lang.String r5, boolean r6, int r7, java.lang.Object r8) {
        /*
            int r3 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L4f
            int r3 = r3 + 25
            int r8 = r3 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r8     // Catch: java.lang.Exception -> L4f
            int r3 = r3 % 2
            r8 = 68
            r0 = 4
            if (r3 != 0) goto L12
            r3 = 68
            goto L13
        L12:
            r3 = 4
        L13:
            r1 = 0
            r2 = 1
            if (r3 == r8) goto L21
            r3 = r7 & 1
            if (r3 == 0) goto L1d
            r3 = 0
            goto L1e
        L1d:
            r3 = 1
        L1e:
            if (r3 == r2) goto L2f
            goto L2e
        L21:
            r3 = r7 | 1
            r8 = 54
            if (r3 == 0) goto L2a
            r3 = 71
            goto L2c
        L2a:
            r3 = 54
        L2c:
            if (r3 == r8) goto L2f
        L2e:
            r4 = 0
        L2f:
            r3 = r7 & 4
            if (r3 == 0) goto L4a
            int r3 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp     // Catch: java.lang.Exception -> L48
            int r3 = r3 + 13
            int r6 = r3 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r6     // Catch: java.lang.Exception -> L48
            int r3 = r3 % 2
            if (r3 == 0) goto L41
            r3 = 0
            goto L42
        L41:
            r3 = 1
        L42:
            if (r3 == 0) goto L46
            r6 = 0
            goto L4a
        L46:
            r6 = 1
            goto L4a
        L48:
            r3 = move-exception
            throw r3
        L4a:
            java.lang.String r3 = getAuthRequestContext(r4, r5, r6)
            return r3
        L4f:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.handleHeaderBackgroundColor$default(id.dana.richview.servicescard.ServiceCardV2View, id.dana.model.BannerLottieModel, java.lang.String, boolean, int, java.lang.Object):java.lang.String");
    }

    public final void notifyFinishCheckSession() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 35;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? 'A' : Typography.dollar) != 'A') {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            getPresenter().get().lookAheadTest();
        } else {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                getPresenter().get().lookAheadTest();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 109;
        initRecordTimeStamp = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 23;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        if ((!this.scheduleImpl ? JSONLexer.EOI : 'E') != 26) {
            return;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 65;
        initRecordTimeStamp = i3 % 128;
        if (i3 % 2 != 0) {
            getHomeTrackerImpl().get().getAuthRequestContext();
            this.scheduleImpl = true;
            return;
        }
        try {
            getHomeTrackerImpl().get().getAuthRequestContext();
            this.scheduleImpl = false;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void trackPromotedService$default(ServiceCardV2View serviceCardV2View, List list, String str, int i, Object obj) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 1;
        initRecordTimeStamp = i2 % 128;
        int i3 = i2 % 2;
        if ((i & 2) != 0) {
            int i4 = initRecordTimeStamp + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i4 % 128;
            if (i4 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i5 = initRecordTimeStamp + 23;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
            int i6 = i5 % 2;
            str = ThirdPartyService.UIVersion.VERSION_1;
        }
        serviceCardV2View.MyBillsEntityDataFactory(list, str);
    }

    private final void MyBillsEntityDataFactory(List<ThirdPartyService> list, String str) {
        ThirdPartyService thirdPartyService;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
        initRecordTimeStamp = i % 128;
        if (!(i % 2 == 0)) {
            thirdPartyService = (ThirdPartyService) CollectionsKt.getOrNull(list, 0);
            if (thirdPartyService == null) {
                return;
            }
        } else {
            thirdPartyService = (ThirdPartyService) CollectionsKt.getOrNull(list, 1);
            if ((thirdPartyService != null ? (char) 5 : '9') != 5) {
                return;
            }
        }
        try {
            Intrinsics.checkNotNullParameter(str, "");
            thirdPartyService.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String = str;
            HomeTrackerImpl homeTrackerImpl = getHomeTrackerImpl().get();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            homeTrackerImpl.KClassImpl$Data$declaredNonStaticMembers$2(context, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, list, thirdPartyService.readMicros, thirdPartyService.initRecordTimeStamp);
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 39;
            initRecordTimeStamp = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void BuiltInFictitiousFunctionClassFactory(Function2 function2, BannerLottieModel bannerLottieModel, ThirdPartyService thirdPartyService, CompletableSubject completableSubject) {
        int i = initRecordTimeStamp + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(completableSubject, "");
        function2.invoke(bannerLottieModel, thirdPartyService.scheduleImpl);
        completableSubject.onComplete();
        int i3 = initRecordTimeStamp + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v4 */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        ServiceV2Adapter serviceV2Adapter;
        List list;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 31;
        initRecordTimeStamp = i % 128;
        if (i % 2 == 0) {
            serviceV2Adapter = this.lookAheadTest;
            int i2 = 37 / 0;
            if (serviceV2Adapter == null) {
                return;
            }
        } else {
            serviceV2Adapter = this.lookAheadTest;
            if (serviceV2Adapter == null) {
                return;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 91;
        initRecordTimeStamp = i3 % 128;
        String str = 0;
        if ((i3 % 2 == 0 ? 'N' : (char) 22) != 22) {
            list = serviceV2Adapter.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(list, "");
            int length = str.length;
            if (list == null) {
                return;
            }
        } else {
            list = serviceV2Adapter.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(list, "");
            if (list == null) {
                return;
            }
        }
        ThirdPartyService thirdPartyService = (ThirdPartyService) CollectionsKt.getOrNull(list, 0);
        if (thirdPartyService != null) {
            ServicesTracker.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, thirdPartyService.newProxyInstance, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda0);
            if (StringsKt.equals("service_paylater_loan_personal", thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
                if (thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6 != null) {
                    String str2 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    if (str2 != null) {
                        Object[] objArr = new Object[1];
                        a(new char[]{40309, 12876, 2683, 8528, 47430, 25767, 50237, 3502}, new char[]{3594, 10934, 52507, 20630}, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), new char[]{0, 0, 0, 0}, TextUtils.lastIndexOf("", '0', 0, 0) + 1, objArr);
                        str = StringsKt.replace$default(str2, ((String) objArr[0]).intern(), DanaUrl.ENTRY_POINT_HIGHLIGHT, false, 4, (Object) null);
                    }
                    thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6 = str;
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ServicesContract.Presenter presenter = getPresenter().get();
            Intrinsics.checkNotNullExpressionValue(presenter, "");
            presenter.MyBillsEntityDataFactory(thirdPartyService, (Map<String, String>) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r3 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 + 103;
        id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if (r0 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void BuiltInFictitiousFunctionClassFactory(id.dana.richview.servicescard.ServiceCardV2View r6) {
        /*
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            java.lang.String r3 = ""
            r4 = 0
            if (r0 == 0) goto L23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            r6.getAuthRequestContext(r4)
            r6.NetworkUserEntityData$$ExternalSyntheticLambda8()
            id.dana.richview.servicescard.adapter.ServiceV2Adapter r0 = r6.lookAheadTest
            r5 = 96
            int r5 = r5 / r2
            if (r0 == 0) goto L41
            goto L30
        L21:
            r6 = move-exception
            throw r6
        L23:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            r6.getAuthRequestContext(r4)
            r6.NetworkUserEntityData$$ExternalSyntheticLambda8()
            id.dana.richview.servicescard.adapter.ServiceV2Adapter r0 = r6.lookAheadTest
            if (r0 == 0) goto L41
        L30:
            androidx.recyclerview.widget.AsyncListDiffer<T> r0 = r0.BuiltInFictitiousFunctionClassFactory
            java.util.List<T> r0 = r0.moveToNextValue
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            int r3 = id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r3 = r3 + 103
            int r5 = r3 % 128
            id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp = r5
            int r3 = r3 % r1
            goto L42
        L41:
            r0 = r4
        L42:
            r3 = 1
            if (r0 != 0) goto L47
            r5 = 1
            goto L48
        L47:
            r5 = 0
        L48:
            if (r5 == 0) goto L6f
            int r0 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r0 = r0 + 59
            int r5 = r0 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r5
            int r0 = r0 % r1
            r5 = 33
            if (r0 == 0) goto L5a
            r0 = 33
            goto L5c
        L5a:
            r0 = 9
        L5c:
            if (r0 == r5) goto L65
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()     // Catch: java.lang.Exception -> L63
            goto L6f
        L63:
            r6 = move-exception
            throw r6
        L65:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r4.hashCode()     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r6 = move-exception
            throw r6
        L6f:
            trackPromotedService$default(r6, r0, r4, r1, r4)
            int r6 = id.dana.richview.servicescard.ServiceCardV2View.initRecordTimeStamp
            int r6 = r6 + 15
            int r0 = r6 % 128
            id.dana.richview.servicescard.ServiceCardV2View.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r6 = r6 % r1
            if (r6 == 0) goto L7e
            goto L7f
        L7e:
            r2 = 1
        L7f:
            if (r2 == 0) goto L82
            return
        L82:
            r4.hashCode()     // Catch: java.lang.Throwable -> L86
            return
        L86:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.ServiceCardV2View.BuiltInFictitiousFunctionClassFactory(id.dana.richview.servicescard.ServiceCardV2View):void");
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? (char) 23 : '\r') != '\r') {
                int i2 = $10 + 67;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getErrorConfigVersion ^ 4360990799332652212L)) ^ ((int) (DatabaseTableConfigUtil ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i6 = $10 + 119;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
