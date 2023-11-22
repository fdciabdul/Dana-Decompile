package id.dana.wallet_v3.view.search.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
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
import id.dana.danah5.DanaH5;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.FragmentWalletSearchBinding;
import id.dana.databinding.ViewInitialSearchWalletV3Binding;
import id.dana.di.ComponentHolder;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.ThirdPartyService;
import id.dana.tracker.spm.ServicesTracker;
import id.dana.utils.KeyboardHeightProvider;
import id.dana.utils.TagFormat;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.WalletDetailBaseImplementation;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.di.component.DaggerWalletSearchComponent;
import id.dana.wallet_v3.di.module.WalletSearchModule;
import id.dana.wallet_v3.identity.IdentityToastAndDialogImpl;
import id.dana.wallet_v3.identity.view.KtpDetailActivity;
import id.dana.wallet_v3.listener.AssetRecommendationClickListener;
import id.dana.wallet_v3.listener.DanaBalanceClickListener;
import id.dana.wallet_v3.listener.DanaEmasClickListener;
import id.dana.wallet_v3.listener.DanaPlusClickListener;
import id.dana.wallet_v3.listener.GoalsClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.listener.WalletDetailBaseFunction;
import id.dana.wallet_v3.listener.WalletSearchCategoryViewListener;
import id.dana.wallet_v3.loyalty.di.LoyaltyWalletDetailModule;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.util.WalletV3ToastUtilKt;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.view.search.adapter.SearchCardAdapter;
import id.dana.wallet_v3.view.search.model.SearchCategoryModel;
import id.dana.wallet_v3.view.search.presenter.WalletSearchContract;
import id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment$assetRecommendationClickListener$2;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaBalanceClickListener$2;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaEmasClickListener$2;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaGoalsClickListener$2;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaPlusClickListener$2;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment$walletCardAssetClickListener$2;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
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
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ö\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004÷\u0001ö\u0001B\b¢\u0006\u0005\bõ\u0001\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\rH\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u001a\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010\u001bJ\u000f\u0010=\u001a\u00020\bH\u0002¢\u0006\u0004\b=\u0010\u001bJ\u000f\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010\u001bJ\u000f\u0010?\u001a\u00020\bH\u0014¢\u0006\u0004\b?\u0010\u001bJ\u000f\u0010@\u001a\u00020\bH\u0002¢\u0006\u0004\b@\u0010\u001bJ\u000f\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010\u001bJ\u000f\u0010B\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010\u001bJ\u000f\u0010C\u001a\u00020\bH\u0002¢\u0006\u0004\bC\u0010\u001bJ\u0017\u0010F\u001a\u00020\u00022\u0006\u0010E\u001a\u00020DH\u0014¢\u0006\u0004\bF\u0010GJ\u0018\u0010K\u001a\u00020J2\u0006\u0010I\u001a\u00020HH\u0096\u0001¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020\b¢\u0006\u0004\bM\u0010\u001bJ)\u0010Q\u001a\u00020\b2\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\bH\u0002¢\u0006\u0004\bS\u0010\u001bJ\u000f\u0010T\u001a\u00020\bH\u0016¢\u0006\u0004\bT\u0010\u001bJ\u000f\u0010U\u001a\u00020\bH\u0016¢\u0006\u0004\bU\u0010\u001bJ\u000f\u0010V\u001a\u00020\bH\u0002¢\u0006\u0004\bV\u0010\u001bJ\u000f\u0010W\u001a\u00020\bH\u0002¢\u0006\u0004\bW\u0010\u001bJ\u0019\u0010Y\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bY\u0010;J\u0017\u0010[\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\rH\u0002¢\u0006\u0004\b[\u0010\\J\r\u0010]\u001a\u00020\b¢\u0006\u0004\b]\u0010\u001bJ\r\u0010^\u001a\u00020\b¢\u0006\u0004\b^\u0010\u001bJ\u001d\u0010b\u001a\u00020\b2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020`0_H\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\bH\u0002¢\u0006\u0004\bd\u0010\u001bJ\u001f\u0010g\u001a\u00020\b2\u0006\u0010e\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u0006H\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010k\u001a\u00020\b2\u0006\u0010j\u001a\u00020iH\u0002¢\u0006\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020o8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001b\u0010y\u001a\u00020u8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bv\u0010q\u001a\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020z8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b{\u0010q\u001a\u0004\b|\u0010}R\u001f\u0010\u0083\u0001\u001a\u00020\u007f8CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\u0080\u0001\u0010q\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R \u0010\u0088\u0001\u001a\u00030\u0084\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0001\u0010q\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010\u008d\u0001\u001a\u00030\u0089\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\u008a\u0001\u0010q\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R*\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R*\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R*\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010£\u0001\u001a\u00020J8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R \u0010°\u0001\u001a\u00030¬\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\u00ad\u0001\u0010q\u001a\u0006\b®\u0001\u0010¯\u0001R \u0010µ\u0001\u001a\u00030±\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b²\u0001\u0010q\u001a\u0006\b³\u0001\u0010´\u0001R\u001a\u0010¶\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b¶\u0001\u0010nR\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R*\u0010»\u0001\u001a\u00030º\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R\u0018\u0010Â\u0001\u001a\u00030Á\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bÄ\u0001\u0010nR\u0018\u0010X\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bX\u0010nR\u0019\u0010Å\u0001\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R*\u0010È\u0001\u001a\u00030Ç\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R \u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020i0Ñ\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R*\u0010Õ\u0001\u001a\u00030Ô\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001\"\u0006\bÙ\u0001\u0010Ú\u0001R \u0010ß\u0001\u001a\u00030Û\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\bÜ\u0001\u0010q\u001a\u0006\bÝ\u0001\u0010Þ\u0001R*\u0010á\u0001\u001a\u00030à\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001R*\u0010è\u0001\u001a\u00030ç\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R*\u0010ï\u0001\u001a\u00030î\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001"}, d2 = {"Lid/dana/wallet_v3/view/search/view/WalletSearchFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentWalletSearchBinding;", "Lid/dana/wallet_v3/listener/WalletDetailBaseFunction;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "backFromSearch", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", HomeTabActivity.WALLET_SECTION, "backToMainPage", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;I)V", "backToNewWalletFragment", "(Landroidx/fragment/app/FragmentManager;)V", "Lid/dana/utils/danah5/DanaH5Listener;", "createH5AppListener", "()Lid/dana/utils/danah5/DanaH5Listener;", "Lkotlin/Function0;", "action", "delayToSearch", "(Lkotlin/jvm/functions/Function0;)V", "disableSwipe", "()V", "dismissSearchView", "Lid/dana/contract/user/GetBalanceModule;", "getBalanceModule", "()Lid/dana/contract/user/GetBalanceModule;", "Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$getChipCategoryListener$1;", "getChipCategoryListener", "()Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$getChipCategoryListener$1;", "Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;", "data", "getChipTitle", "(Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;)Ljava/lang/String;", "getLayout", "()I", "Lid/dana/wallet_v3/loyalty/di/LoyaltyWalletDetailModule;", "getLoyaltyWalletDetailModule", "()Lid/dana/wallet_v3/loyalty/di/LoyaltyWalletDetailModule;", "Lid/dana/contract/services/ServicesModule;", "getServicesModule", "()Lid/dana/contract/services/ServicesModule;", "", "text", "getUserAssets", "(Ljava/lang/CharSequence;)V", "Lid/dana/wallet_v3/view/NewWalletFragment;", "getWalletFragment", "(Landroidx/fragment/app/FragmentManager;)Lid/dana/wallet_v3/view/NewWalletFragment;", "Lid/dana/wallet_v3/di/module/WalletSearchModule;", "getWalletSearchModule", "()Lid/dana/wallet_v3/di/module/WalletSearchModule;", "key", "goToServicePage", "(Ljava/lang/String;)V", "gotoTopupPage", "hideKeyboard", "hideSearchCategory", IAPSyncCommand.COMMAND_INIT, "initBundle", "initInjector", "initOnClickListener", "initView", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/FragmentWalletSearchBinding;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isFromDeeplinkWallet", "(Landroid/app/Activity;)Z", "loadData", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "onActivityResult", "(IILandroid/content/Intent;)V", "onCancelOrBackPressed", "onDestroyView", "onResume", "openLoyalty", "openLoyaltyAddH5", "pocketId", "openLoyaltyDetailH5", "sectionIndex", "setLastAddedAssetType", "(I)V", "showInitState", "showInitStateWithRecommendation", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", SceneType.ASSETS, "showWalletAsset", "(Ljava/util/List;)V", "trackSearchPageOpen", "triggerSource", "keyword", "trackSearchSubmit", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/model/ThirdPartyService;", "it", "trackServiceOpen", "(Lid/dana/model/ThirdPartyService;)V", "accessToken", "Ljava/lang/String;", "Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;", "assetRecommendationClickListener$delegate", "Lkotlin/Lazy;", "getAssetRecommendationClickListener", "()Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;", "assetRecommendationClickListener", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener$delegate", "getDanaBalanceClickListener", "()Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener$delegate", "getDanaEmasClickListener", "()Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "danaGoalsClickListener$delegate", "getDanaGoalsClickListener", "()Lid/dana/wallet_v3/listener/GoalsClickListener;", "danaGoalsClickListener", "Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog$delegate", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "danaPlusClickListener$delegate", "getDanaPlusClickListener", "()Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "danaPlusClickListener", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "filterBasedOnChip", "Z", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getBalancePresenter", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getGetBalancePresenter", "()Lid/dana/contract/user/GetBalanceContract$Presenter;", "setGetBalancePresenter", "(Lid/dana/contract/user/GetBalanceContract$Presenter;)V", "Lid/dana/wallet_v3/identity/IdentityToastAndDialogImpl;", "identityToastAndDialog$delegate", "getIdentityToastAndDialog", "()Lid/dana/wallet_v3/identity/IdentityToastAndDialogImpl;", "identityToastAndDialog", "Lid/dana/utils/KeyboardHeightProvider;", "keyboardHeightProvider$delegate", "getKeyboardHeightProvider", "()Lid/dana/utils/KeyboardHeightProvider;", "keyboardHeightProvider", WalletConstant.KYC_LEVEL, "Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$Action;", "loyaltyAction", "Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$Action;", "Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "loyaltyPresenter", "Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "getLoyaltyPresenter", "()Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "setLoyaltyPresenter", "(Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;)V", "Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$onBackPressedCallback$1;", "onBackPressedCallback", "Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$onBackPressedCallback$1;", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "query", "Ljava/lang/CharSequence;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/wallet_v3/view/search/adapter/SearchCardAdapter;", "searchCardAdapter", "Lid/dana/wallet_v3/view/search/adapter/SearchCardAdapter;", "", "services", "Ljava/util/List;", "Lid/dana/contract/services/ServicesContract$Presenter;", "servicesPresenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "getServicesPresenter", "()Lid/dana/contract/services/ServicesContract$Presenter;", "setServicesPresenter", "(Lid/dana/contract/services/ServicesContract$Presenter;)V", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "walletH5ServicesImplementation", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "getWalletH5ServicesImplementation", "()Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "setWalletH5ServicesImplementation", "(Lid/dana/wallet_v3/WalletH5ServicesImplementation;)V", "Lid/dana/wallet_v3/view/search/presenter/WalletSearchPresenter;", "walletSearchPresenter", "Lid/dana/wallet_v3/view/search/presenter/WalletSearchPresenter;", "getWalletSearchPresenter", "()Lid/dana/wallet_v3/view/search/presenter/WalletSearchPresenter;", "setWalletSearchPresenter", "(Lid/dana/wallet_v3/view/search/presenter/WalletSearchPresenter;)V", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "walletV3TrackerImplementation", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "getWalletV3TrackerImplementation", "()Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "setWalletV3TrackerImplementation", "(Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;)V", "<init>", "Companion", "Action"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSearchFragment extends ViewBindingFragment<FragmentWalletSearchBinding> implements WalletDetailBaseFunction {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    public static final String LANGUAGE_IN = "in";
    private static int MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static final String PAGE_SOURCE = "PAGE_SOURCE";
    private static boolean PlaceComponentResult = false;
    private static final String SEARCH_BAR_HINT = "SEARCH_BAR_HINT";
    private static final String TRIGGER_SOURCE_BUBBLE = "Bubble";
    private static final String TRIGGER_SOURCE_USER_TYPING = "Enter (user typing)";
    private static boolean lookAheadTest;
    private static int scheduleImpl;
    private String accessToken;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public FeatureContract.Presenter featurePresenter;
    private boolean filterBasedOnChip;
    @Inject
    public GetBalanceContract.Presenter getBalancePresenter;
    private String kycLevel;
    private Action loyaltyAction;
    @Inject
    public LoyaltyWalletContract.Presenter loyaltyPresenter;
    private String pageSource;
    private String pocketId;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    private SearchCardAdapter searchCardAdapter;
    @Inject
    public ServicesContract.Presenter servicesPresenter;
    @Inject
    public WalletH5ServicesImplementation walletH5ServicesImplementation;
    @Inject
    public WalletSearchPresenter walletSearchPresenter;
    @Inject
    public WalletV3TrackerImpl walletV3TrackerImplementation;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final /* synthetic */ WalletDetailBaseImplementation $$delegate_0 = new WalletDetailBaseImplementation();

    /* renamed from: identityToastAndDialog$delegate  reason: from kotlin metadata */
    private final Lazy identityToastAndDialog = LazyKt.lazy(new Function0<IdentityToastAndDialogImpl>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$identityToastAndDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IdentityToastAndDialogImpl invoke() {
            return new IdentityToastAndDialogImpl(WalletSearchFragment.this);
        }
    });

    /* renamed from: keyboardHeightProvider$delegate  reason: from kotlin metadata */
    private final Lazy keyboardHeightProvider = LazyKt.lazy(new Function0<KeyboardHeightProvider>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$keyboardHeightProvider$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KeyboardHeightProvider invoke() {
            return new KeyboardHeightProvider(WalletSearchFragment.this.getActivity());
        }
    });
    private List<ThirdPartyService> services = new ArrayList();
    private CharSequence query = "";

    /* renamed from: danaLoadingDialog$delegate  reason: from kotlin metadata */
    private final Lazy danaLoadingDialog = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(WalletSearchFragment.this.getActivity());
        }
    });
    private final WalletSearchFragment$onBackPressedCallback$1 onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$onBackPressedCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            WalletSearchFragment.access$onCancelOrBackPressed(WalletSearchFragment.this);
        }
    };

    /* renamed from: danaGoalsClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaGoalsClickListener = LazyKt.lazy(new Function0<WalletSearchFragment$danaGoalsClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaGoalsClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaGoalsClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
            return new GoalsClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaGoalsClickListener$2.1
                @Override // id.dana.wallet_v3.listener.GoalsClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                    WalletSearchFragment.this.getGetBalancePresenter().MyBillsEntityDataFactory("goals");
                    SearchCardAdapter access$getSearchCardAdapter$p = WalletSearchFragment.access$getSearchCardAdapter$p(WalletSearchFragment.this);
                    if (access$getSearchCardAdapter$p != null) {
                        access$getSearchCardAdapter$p.setGoalsBalanceVisibility(Boolean.valueOf(isBalanceVisible));
                    }
                    WalletV3ToastUtilKt.showHideBalanceToast(isBalanceVisible, WalletSearchFragment.this.getBaseActivity(), 6);
                }
            };
        }
    });

    /* renamed from: assetRecommendationClickListener$delegate  reason: from kotlin metadata */
    private final Lazy assetRecommendationClickListener = LazyKt.lazy(new Function0<WalletSearchFragment$assetRecommendationClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$assetRecommendationClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.search.view.WalletSearchFragment$assetRecommendationClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
            return new AssetRecommendationClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$assetRecommendationClickListener$2.1
                @Override // id.dana.wallet_v3.listener.AssetRecommendationClickListener
                public final void onCardClicked(ThirdPartyService data, String sectionType) {
                    Intrinsics.checkNotNullParameter(data, "");
                    Intrinsics.checkNotNullParameter(sectionType, "");
                    switch (sectionType.hashCode()) {
                        case -1150817175:
                            if (sectionType.equals("FINANCIAL")) {
                                DanaLoadingDialog access$getDanaLoadingDialog = WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this);
                                if (!access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                                    access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                                    access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
                                }
                                WalletSearchFragment.this.getServicesPresenter().MyBillsEntityDataFactory(data, (Map<String, String>) null);
                                WalletSearchFragment.access$setLastAddedAssetType(WalletSearchFragment.this, 2);
                                return;
                            }
                            return;
                        case -554006299:
                            if (sectionType.equals("VOUCHER_AND_TICKET")) {
                                DanaLoadingDialog access$getDanaLoadingDialog2 = WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this);
                                if (!access$getDanaLoadingDialog2.MyBillsEntityDataFactory.isShowing()) {
                                    access$getDanaLoadingDialog2.MyBillsEntityDataFactory.show();
                                    access$getDanaLoadingDialog2.getAuthRequestContext.startRefresh();
                                }
                                WalletSearchFragment.this.getServicesPresenter().MyBillsEntityDataFactory(data, (Map<String, String>) null);
                                WalletSearchFragment.access$setLastAddedAssetType(WalletSearchFragment.this, 3);
                                return;
                            }
                            return;
                        case -68698650:
                            if (sectionType.equals("PAYMENT")) {
                                DanaLoadingDialog access$getDanaLoadingDialog3 = WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this);
                                if (!access$getDanaLoadingDialog3.MyBillsEntityDataFactory.isShowing()) {
                                    access$getDanaLoadingDialog3.MyBillsEntityDataFactory.show();
                                    access$getDanaLoadingDialog3.getAuthRequestContext.startRefresh();
                                }
                                WalletSearchFragment.this.getServicesPresenter().MyBillsEntityDataFactory(data, (Map<String, String>) null);
                                WalletSearchFragment.access$setLastAddedAssetType(WalletSearchFragment.this, 1);
                                return;
                            }
                            return;
                        case 646865086:
                            if (sectionType.equals("IDENTITY") && Intrinsics.areEqual(data.NetworkUserEntityData$$ExternalSyntheticLambda8, "service_ektp")) {
                                Fragment findFragmentByTag = WalletSearchFragment.this.getParentFragmentManager().findFragmentByTag(HomeTabFragment.FragmentTag.WALLET_FRAGMENT);
                                NewWalletFragment newWalletFragment = findFragmentByTag instanceof NewWalletFragment ? (NewWalletFragment) findFragmentByTag : null;
                                if (newWalletFragment != null) {
                                    newWalletFragment.onAddKtpAsset();
                                }
                                WalletSearchFragment.access$setLastAddedAssetType(WalletSearchFragment.this, 5);
                                return;
                            }
                            return;
                        case 1076711462:
                            if (sectionType.equals("LOYALTY")) {
                                DanaLoadingDialog access$getDanaLoadingDialog4 = WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this);
                                if (!access$getDanaLoadingDialog4.MyBillsEntityDataFactory.isShowing()) {
                                    access$getDanaLoadingDialog4.MyBillsEntityDataFactory.show();
                                    access$getDanaLoadingDialog4.getAuthRequestContext.startRefresh();
                                }
                                if (WalletSearchFragment.access$getKycLevel$p(WalletSearchFragment.this) == null || WalletSearchFragment.access$getAccessToken$p(WalletSearchFragment.this) == null) {
                                    WalletSearchFragment.access$setLoyaltyAction$p(WalletSearchFragment.this, WalletSearchFragment.Action.ADD);
                                    WalletSearchFragment.this.getLoyaltyPresenter().fetchLoyaltyAccessTokenAndKycLevel();
                                    return;
                                }
                                WalletSearchFragment.access$openLoyaltyAddH5(WalletSearchFragment.this);
                                WalletSearchFragment.access$setLastAddedAssetType(WalletSearchFragment.this, 3);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            };
        }
    });

    /* renamed from: danaBalanceClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaBalanceClickListener = LazyKt.lazy(new Function0<WalletSearchFragment$danaBalanceClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaBalanceClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaBalanceClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
            return new DanaBalanceClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaBalanceClickListener$2.1
                @Override // id.dana.wallet_v3.listener.DanaBalanceClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                }

                @Override // id.dana.wallet_v3.listener.DanaBalanceClickListener
                public final void onTopUpClicked() {
                    WalletSearchFragment.access$gotoTopupPage(WalletSearchFragment.this);
                }
            };
        }
    });

    /* renamed from: danaEmasClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaEmasClickListener = LazyKt.lazy(new Function0<WalletSearchFragment$danaEmasClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaEmasClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaEmasClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
            return new DanaEmasClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaEmasClickListener$2.1
                @Override // id.dana.wallet_v3.listener.DanaEmasClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                    WalletSearchFragment.this.getGetBalancePresenter().MyBillsEntityDataFactory(AccountEntityRepository.BalanceType.EMAS);
                    SearchCardAdapter access$getSearchCardAdapter$p = WalletSearchFragment.access$getSearchCardAdapter$p(WalletSearchFragment.this);
                    if (access$getSearchCardAdapter$p != null) {
                        access$getSearchCardAdapter$p.setEmasBalanceVisibility(Boolean.valueOf(isBalanceVisible));
                    }
                    WalletV3ToastUtilKt.showHideBalanceToast(isBalanceVisible, WalletSearchFragment.this.getBaseActivity(), 5);
                }
            };
        }
    });

    /* renamed from: danaPlusClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaPlusClickListener = LazyKt.lazy(new Function0<WalletSearchFragment$danaPlusClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaPlusClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaPlusClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
            return new DanaPlusClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$danaPlusClickListener$2.1
                @Override // id.dana.wallet_v3.listener.DanaPlusClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                    WalletSearchFragment.this.getGetBalancePresenter().MyBillsEntityDataFactory(AccountEntityRepository.BalanceType.INVESTMENT);
                    SearchCardAdapter access$getSearchCardAdapter$p = WalletSearchFragment.access$getSearchCardAdapter$p(WalletSearchFragment.this);
                    if (access$getSearchCardAdapter$p != null) {
                        access$getSearchCardAdapter$p.setDanaPlusBalanceVisibility(Boolean.valueOf(isBalanceVisible));
                    }
                    WalletV3ToastUtilKt.showHideBalanceToast(isBalanceVisible, WalletSearchFragment.this.getBaseActivity(), 4);
                }
            };
        }
    });

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener = LazyKt.lazy(new Function0<WalletSearchFragment$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$walletCardAssetClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.search.view.WalletSearchFragment$walletCardAssetClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
            return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$walletCardAssetClickListener$2.1
                private static int $10 = 0;
                private static int $11 = 1;
                private static int BuiltInFictitiousFunctionClassFactory = 0;
                private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                private static char[] PlaceComponentResult = {35496, 35575, 35575, 35566, 35568, 35567, 35556, 35565, 35564, 35557, 35560, 35571};

                /* JADX WARN: Code restructure failed: missing block: B:68:0x0137, code lost:
                
                    if (r0 != null) goto L73;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:72:0x0142, code lost:
                
                    if (r0 != null) goto L73;
                 */
                /* JADX WARN: Removed duplicated region for block: B:62:0x011e  */
                /* JADX WARN: Removed duplicated region for block: B:63:0x0121  */
                /* JADX WARN: Removed duplicated region for block: B:65:0x0125  */
                /* JADX WARN: Removed duplicated region for block: B:93:0x01de  */
                /* JADX WARN: Removed duplicated region for block: B:94:0x01e1  */
                /* JADX WARN: Removed duplicated region for block: B:96:0x01e5  */
                @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void onCardClicked(id.dana.wallet_v3.model.WalletV3CardModel r7) {
                    /*
                        Method dump skipped, instructions count: 560
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment$walletCardAssetClickListener$2.AnonymousClass1.onCardClicked(id.dana.wallet_v3.model.WalletV3CardModel):void");
                }

                private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
                    int i;
                    int length;
                    char[] cArr;
                    int i2;
                    int i3;
                    VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                    int i4 = iArr[0];
                    int i5 = iArr[1];
                    int i6 = 2;
                    int i7 = iArr[2];
                    int i8 = iArr[3];
                    char[] cArr2 = PlaceComponentResult;
                    if ((cArr2 != null ? '+' : (char) 2) != 2) {
                        int i9 = $11 + 45;
                        $10 = i9 % 128;
                        if (i9 % 2 != 0) {
                            length = cArr2.length;
                            cArr = new char[length];
                            i2 = 1;
                        } else {
                            length = cArr2.length;
                            cArr = new char[length];
                            i2 = 0;
                        }
                        while (i2 < length) {
                            int i10 = $10 + 45;
                            $11 = i10 % 128;
                            if (i10 % i6 == 0) {
                                i3 = i7;
                                cArr[i2] = (char) (cArr2[i2] % 5097613533456403102L);
                                i2 <<= 1;
                            } else {
                                i3 = i7;
                                cArr[i2] = (char) (cArr2[i2] ^ 5097613533456403102L);
                                i2++;
                            }
                            i7 = i3;
                            i6 = 2;
                        }
                        i = i7;
                        cArr2 = cArr;
                    } else {
                        i = i7;
                    }
                    char[] cArr3 = new char[i5];
                    System.arraycopy(cArr2, i4, cArr3, 0, i5);
                    if (bArr != null) {
                        int i11 = $10 + 73;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                        char[] cArr4 = new char[i5];
                        try {
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                            char c = 0;
                            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                                try {
                                    if (!(bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] != 1)) {
                                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                                    } else {
                                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                                    }
                                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                            cArr3 = cArr4;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    if (i8 > 0) {
                        int i13 = $10 + 111;
                        $11 = i13 % 128;
                        if (i13 % 2 != 0) {
                            char[] cArr5 = new char[i5];
                            System.arraycopy(cArr3, 0, cArr5, 0, i5);
                            int i14 = i5 - i8;
                            System.arraycopy(cArr5, 0, cArr3, i14, i8);
                            System.arraycopy(cArr5, i8, cArr3, 0, i14);
                        } else {
                            char[] cArr6 = new char[i5];
                            System.arraycopy(cArr3, 0, cArr6, 0, i5);
                            System.arraycopy(cArr6, 0, cArr3, i5 / i8, i8);
                            System.arraycopy(cArr6, i8, cArr3, 1, i5 - i8);
                        }
                    }
                    if (z) {
                        char[] cArr7 = new char[i5];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                            int i15 = $11 + 125;
                            $10 = i15 % 128;
                            if (!(i15 % 2 == 0)) {
                                cArr7[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory * i5) << 0];
                            } else {
                                cArr7[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i5 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                            }
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                        cArr3 = cArr7;
                    }
                    if ((i > 0 ? 'U' : '`') != '`') {
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                            cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                    }
                    String str = new String(cArr3);
                    int i16 = $10 + 13;
                    $11 = i16 % 128;
                    int i17 = i16 % 2;
                    objArr[0] = str;
                }
            };
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$Action;", "", "<init>", "(Ljava/lang/String;I)V", "DETAIL", "ADD"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public enum Action {
        DETAIL,
        ADD
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Action.values().length];
            iArr[Action.DETAIL.ordinal()] = 1;
            iArr[Action.ADD.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void $r8$lambda$NIufdHrsb5Hw3UyLihLul4N9ILk(WalletSearchFragment walletSearchFragment, int i) {
        int i2 = scheduleImpl + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        char c = i2 % 2 == 0 ? '!' : (char) 7;
        m3108initView$lambda3$lambda2(walletSearchFragment, i);
        if (c != 7) {
            int i3 = 10 / 0;
        }
        int i4 = scheduleImpl + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        if (!(i4 % 2 != 0)) {
            int i5 = 84 / 0;
        }
    }

    public static /* synthetic */ void $r8$lambda$dOoRsOrmoISl2EvzZKMHeXz7YQE(WalletSearchFragment walletSearchFragment, View view) {
        try {
            int i = scheduleImpl + 63;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            m3107initOnClickListener$lambda4(walletSearchFragment, view);
            int i3 = scheduleImpl + 55;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if ((i3 % 2 == 0 ? 'a' : '%') != '%') {
                int i4 = 4 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$jrlAqUzSyW5_oZlsQiLfUHlm5zw(WalletSearchFragment walletSearchFragment, View view) {
        int i = scheduleImpl + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 != 0) {
            m3106dismissSearchView$lambda9(walletSearchFragment, view);
            return;
        }
        try {
            m3106dismissSearchView$lambda9(walletSearchFragment, view);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 31;
        scheduleImpl = i % 128;
        int i2 = i % 2;
    }

    static void MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{39448, 39430, 39547, 39543, 39426, 39432, 39544};
        PlaceComponentResult = true;
        lookAheadTest = true;
        MyBillsEntityDataFactory = 909155309;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        int i = scheduleImpl + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? 'a' : '/') != 'a') {
            this._$_findViewCache.clear();
            return;
        }
        this._$_findViewCache.clear();
        int i2 = 89 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if ((r3 != null ? 'K' : 0) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r2 = getView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        r4 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r4 = 'c';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        if (r4 == 15) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        r2 = r2.findViewById(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r2);
        r6 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl + 63;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        r6 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl + 85;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if ((r3 != null ? 1 : 0) != 0) goto L20;
     */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r6) {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r0 = r0 + 95
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L26
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache     // Catch: java.lang.Exception -> L24
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L24
            java.lang.Object r3 = r0.get(r3)     // Catch: java.lang.Exception -> L24
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Exception -> L24
            int r4 = r1.length     // Catch: java.lang.Throwable -> L22
            if (r3 != 0) goto L1e
            goto L1f
        L1e:
            r2 = 1
        L1f:
            if (r2 == 0) goto L3b
            goto L39
        L22:
            r6 = move-exception
            throw r6
        L24:
            r6 = move-exception
            throw r6
        L26:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            java.lang.Object r3 = r0.get(r3)
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L35
            goto L37
        L35:
            r2 = 75
        L37:
            if (r2 == 0) goto L3b
        L39:
            r1 = r3
            goto L6e
        L3b:
            android.view.View r2 = r5.getGetAuthRequestContext()
            r3 = 15
            if (r2 == 0) goto L46
            r4 = 15
            goto L48
        L46:
            r4 = 99
        L48:
            if (r4 == r3) goto L4b
            goto L64
        L4b:
            android.view.View r2 = r2.findViewById(r6)
            if (r2 == 0) goto L64
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r6, r2)
            int r6 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r6 = r6 + 63
            int r0 = r6 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            int r6 = r6 % 2
            r1 = r2
            goto L6e
        L64:
            int r6 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r6 = r6 + 85
            int r0 = r6 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            int r6 = r6 % 2
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment._$_findCachedViewById(int):android.view.View");
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backFromSearch(FragmentManager fragmentManager, String tag) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 37;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            try {
                Intrinsics.checkNotNullParameter(fragmentManager, "");
                Intrinsics.checkNotNullParameter(tag, "");
                this.$$delegate_0.backFromSearch(fragmentManager, tag);
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(fragmentManager, "");
            Intrinsics.checkNotNullParameter(tag, "");
            this.$$delegate_0.backFromSearch(fragmentManager, tag);
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = scheduleImpl + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backToMainPage(RecyclerView recyclerView, FragmentManager fragmentManager, int section) {
        int i = scheduleImpl + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.$$delegate_0.backToMainPage(recyclerView, fragmentManager, section);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 125;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
            return R.layout.fragment_wallet_search;
        }
        return R.layout.fragment_wallet_search;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final NewWalletFragment getWalletFragment(FragmentManager fragmentManager) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(fragmentManager, "");
            NewWalletFragment walletFragment = this.$$delegate_0.getWalletFragment(fragmentManager);
            int i3 = scheduleImpl + 93;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return walletFragment;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final boolean isFromDeeplinkWallet(Activity activity) {
        boolean isFromDeeplinkWallet;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 7;
            scheduleImpl = i % 128;
            if ((i % 2 != 0 ? '!' : '\r') != '\r') {
                Intrinsics.checkNotNullParameter(activity, "");
                isFromDeeplinkWallet = this.$$delegate_0.isFromDeeplinkWallet(activity);
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                Intrinsics.checkNotNullParameter(activity, "");
                isFromDeeplinkWallet = this.$$delegate_0.isFromDeeplinkWallet(activity);
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
            return isFromDeeplinkWallet;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$delayToSearch(WalletSearchFragment walletSearchFragment, Function0 function0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        walletSearchFragment.delayToSearch(function0);
        int i3 = scheduleImpl + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ String access$getAccessToken$p(WalletSearchFragment walletSearchFragment) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 99;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String str = walletSearchFragment.accessToken;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 41;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public static final /* synthetic */ FragmentWalletSearchBinding access$getBinding(WalletSearchFragment walletSearchFragment) {
        FragmentWalletSearchBinding binding;
        int i = scheduleImpl + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? (char) 30 : '@') != '@') {
            try {
                try {
                    binding = walletSearchFragment.getBinding();
                    objArr.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            binding = walletSearchFragment.getBinding();
        }
        int i2 = scheduleImpl + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if (i2 % 2 != 0) {
            return binding;
        }
        int length = objArr.length;
        return binding;
    }

    public static final /* synthetic */ String access$getChipTitle(WalletSearchFragment walletSearchFragment, SearchCategoryModel searchCategoryModel) {
        int i = scheduleImpl + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        String chipTitle = walletSearchFragment.getChipTitle(searchCategoryModel);
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return chipTitle;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(WalletSearchFragment walletSearchFragment) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        DanaLoadingDialog danaLoadingDialog = walletSearchFragment.getDanaLoadingDialog();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 115;
            try {
                scheduleImpl = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 27 : '=') != 27) {
                    return danaLoadingDialog;
                }
                Object obj = null;
                obj.hashCode();
                return danaLoadingDialog;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ IdentityToastAndDialogImpl access$getIdentityToastAndDialog(WalletSearchFragment walletSearchFragment) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 125;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        IdentityToastAndDialogImpl identityToastAndDialog = walletSearchFragment.getIdentityToastAndDialog();
        int i3 = scheduleImpl + 73;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (i3 % 2 != 0) {
            return identityToastAndDialog;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return identityToastAndDialog;
    }

    public static final /* synthetic */ String access$getKycLevel$p(WalletSearchFragment walletSearchFragment) {
        int i = scheduleImpl + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        String str = walletSearchFragment.kycLevel;
        int i3 = scheduleImpl + 95;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? '!' : (char) 24) != 24) {
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return str;
    }

    public static final /* synthetic */ String access$getPageSource$p(WalletSearchFragment walletSearchFragment) {
        int i = scheduleImpl + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        boolean z = i % 2 != 0;
        String str = walletSearchFragment.pageSource;
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
        scheduleImpl = i2 % 128;
        if ((i2 % 2 != 0 ? ':' : '@') != ':') {
            return str;
        }
        int i3 = 26 / 0;
        return str;
    }

    public static final /* synthetic */ CharSequence access$getQuery$p(WalletSearchFragment walletSearchFragment) {
        try {
            int i = scheduleImpl + 7;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if (i % 2 == 0) {
                    CharSequence charSequence = walletSearchFragment.query;
                    Object obj = null;
                    obj.hashCode();
                    return charSequence;
                }
                return walletSearchFragment.query;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ SearchCardAdapter access$getSearchCardAdapter$p(WalletSearchFragment walletSearchFragment) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            SearchCardAdapter searchCardAdapter = walletSearchFragment.searchCardAdapter;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 57;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return searchCardAdapter;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$getUserAssets(WalletSearchFragment walletSearchFragment, CharSequence charSequence) {
        int i = scheduleImpl + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.getUserAssets(charSequence);
        try {
            int i3 = scheduleImpl + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$goToServicePage(WalletSearchFragment walletSearchFragment, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        walletSearchFragment.goToServicePage(str);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
        scheduleImpl = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$gotoTopupPage(WalletSearchFragment walletSearchFragment) {
        int i = scheduleImpl + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.gotoTopupPage();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$hideKeyboard(WalletSearchFragment walletSearchFragment) {
        int i = scheduleImpl + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.hideKeyboard();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
        scheduleImpl = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 58 / 0;
        }
    }

    public static final /* synthetic */ void access$hideSearchCategory(WalletSearchFragment walletSearchFragment) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 33;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            walletSearchFragment.hideSearchCategory();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$onCancelOrBackPressed(WalletSearchFragment walletSearchFragment) {
        int i = scheduleImpl + 91;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.onCancelOrBackPressed();
        int i3 = scheduleImpl + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        int i4 = 39 / 0;
    }

    public static final /* synthetic */ void access$openLoyalty(WalletSearchFragment walletSearchFragment) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 113;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        walletSearchFragment.openLoyalty();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
            try {
                scheduleImpl = i3 % 128;
                if ((i3 % 2 != 0 ? '.' : '9') != '.') {
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

    public static final /* synthetic */ void access$openLoyaltyAddH5(WalletSearchFragment walletSearchFragment) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        walletSearchFragment.openLoyaltyAddH5();
        try {
            int i3 = scheduleImpl + 123;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setAccessToken$p(WalletSearchFragment walletSearchFragment, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 25;
        scheduleImpl = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            walletSearchFragment.accessToken = str;
        } else {
            try {
                walletSearchFragment.accessToken = str;
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
        scheduleImpl = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return;
        }
        int length = objArr.length;
    }

    public static final /* synthetic */ void access$setFilterBasedOnChip$p(WalletSearchFragment walletSearchFragment, boolean z) {
        int i = scheduleImpl + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.filterBasedOnChip = z;
        int i3 = scheduleImpl + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? '=' : '^') != '=') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void access$setKycLevel$p(WalletSearchFragment walletSearchFragment, String str) {
        int i = scheduleImpl + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.kycLevel = str;
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
            try {
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setLastAddedAssetType(WalletSearchFragment walletSearchFragment, int i) {
        int i2 = scheduleImpl + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        walletSearchFragment.setLastAddedAssetType(i);
        try {
            int i4 = scheduleImpl + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setLoyaltyAction$p(WalletSearchFragment walletSearchFragment, Action action) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
        scheduleImpl = i % 128;
        char c = i % 2 != 0 ? '9' : '?';
        walletSearchFragment.loyaltyAction = action;
        if (c != '9') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void access$setPocketId$p(WalletSearchFragment walletSearchFragment, String str) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 103;
            try {
                scheduleImpl = i % 128;
                boolean z = i % 2 == 0;
                walletSearchFragment.pocketId = str;
                if (z) {
                    return;
                }
                int i2 = 14 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setQuery$p(WalletSearchFragment walletSearchFragment, CharSequence charSequence) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 59;
        scheduleImpl = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            try {
                walletSearchFragment.query = charSequence;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                walletSearchFragment.query = charSequence;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 113;
        scheduleImpl = i2 % 128;
        if (i2 % 2 != 0) {
            objArr.hashCode();
        }
    }

    public static final /* synthetic */ void access$setServices$p(WalletSearchFragment walletSearchFragment, List list) {
        int i = scheduleImpl + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.services = list;
        try {
            int i3 = scheduleImpl + 23;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$showWalletAsset(WalletSearchFragment walletSearchFragment, List list) {
        int i = scheduleImpl + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        walletSearchFragment.showWalletAsset(list);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 67;
        scheduleImpl = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static final /* synthetic */ void access$trackSearchSubmit(WalletSearchFragment walletSearchFragment, String str, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 109;
        scheduleImpl = i % 128;
        char c = i % 2 != 0 ? 'P' : Typography.amp;
        walletSearchFragment.trackSearchSubmit(str, str2);
        if (c != '&') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* bridge */ /* synthetic */ FragmentWalletSearchBinding initViewBinding(View view) {
        try {
            int i = scheduleImpl + 43;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 == 0 ? (char) 27 : 'Z') != 27) {
                return initViewBinding(view);
            }
            try {
                int i2 = 92 / 0;
                return initViewBinding(view);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getWalletSearchPresenter")
    public final WalletSearchPresenter getWalletSearchPresenter() {
        WalletSearchPresenter walletSearchPresenter = this.walletSearchPresenter;
        Object obj = null;
        if (walletSearchPresenter != null) {
            int i = scheduleImpl + 83;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (!(i % 2 != 0)) {
                obj.hashCode();
            }
            return walletSearchPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i2 = scheduleImpl + 5;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if ((i2 % 2 == 0 ? '^' : '!') != '^') {
            return null;
        }
        int i3 = 45 / 0;
        return null;
    }

    @JvmName(name = "setWalletSearchPresenter")
    public final void setWalletSearchPresenter(WalletSearchPresenter walletSearchPresenter) {
        try {
            int i = scheduleImpl + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(walletSearchPresenter, "");
            this.walletSearchPresenter = walletSearchPresenter;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
            scheduleImpl = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if ((r0 == null) != true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 57;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        if ((r1 % 2) == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r1 = 56 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0043, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getServicesPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.services.ServicesContract.Presenter getServicesPresenter() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 49
            if (r0 == 0) goto L11
            r0 = 49
            goto L13
        L11:
            r0 = 41
        L13:
            r2 = 0
            if (r0 == r1) goto L21
            id.dana.contract.services.ServicesContract$Presenter r0 = r4.servicesPresenter
            r1 = 1
            if (r0 == 0) goto L1d
            r3 = 0
            goto L1e
        L1d:
            r3 = 1
        L1e:
            if (r3 == r1) goto L3b
            goto L28
        L21:
            id.dana.contract.services.ServicesContract$Presenter r0 = r4.servicesPresenter     // Catch: java.lang.Exception -> L46
            r1 = 57
            int r1 = r1 / r2
            if (r0 == 0) goto L3b
        L28:
            int r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 57
            int r3 = r1 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L3a
            r1 = 56
            int r1 = r1 / r2
            goto L3a
        L38:
            r0 = move-exception
            throw r0
        L3a:
            return r0
        L3b:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L42
            r0 = 0
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.getServicesPresenter():id.dana.contract.services.ServicesContract$Presenter");
    }

    @JvmName(name = "setServicesPresenter")
    public final void setServicesPresenter(ServicesContract.Presenter presenter) {
        int i = scheduleImpl + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.servicesPresenter = presenter;
        int i3 = scheduleImpl + 91;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if ((r0 != null ? '/' : 14) != 14) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getReadLinkPropertiesPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        /*
            r3 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl     // Catch: java.lang.Exception -> L3f
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> L3f
            int r0 = r0 % 2
            r1 = 48
            if (r0 != 0) goto L11
            r0 = 48
            goto L13
        L11:
            r0 = 45
        L13:
            if (r0 == r1) goto L23
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r3.readLinkPropertiesPresenter
            r1 = 14
            if (r0 == 0) goto L1e
            r2 = 47
            goto L20
        L1e:
            r2 = 14
        L20:
            if (r2 == r1) goto L2c
            goto L2b
        L23:
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r3.readLinkPropertiesPresenter
            r1 = 43
            int r1 = r1 / 0
            if (r0 == 0) goto L2c
        L2b:
            return r0
        L2c:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            int r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 123
            int r2 = r1 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r2
            int r1 = r1 % 2
            return r0
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.getReadLinkPropertiesPresenter():id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x001e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter r3) {
        /*
            r2 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L1c
            r2.readLinkPropertiesPresenter = r3     // Catch: java.lang.Exception -> L1c
            int r3 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r3 = r3 + 107
            int r0 = r3 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r0
            int r3 = r3 % 2
            return
        L1c:
            r3 = move-exception
            throw r3
        L1e:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.setReadLinkPropertiesPresenter(id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter):void");
    }

    @JvmName(name = "getLoyaltyPresenter")
    public final LoyaltyWalletContract.Presenter getLoyaltyPresenter() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 95;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                LoyaltyWalletContract.Presenter presenter = this.loyaltyPresenter;
                if (!(presenter != null)) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    return null;
                }
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return presenter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setLoyaltyPresenter")
    public final void setLoyaltyPresenter(LoyaltyWalletContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 101;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.loyaltyPresenter = presenter;
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.loyaltyPresenter = presenter;
            int i2 = 27 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getGetBalancePresenter")
    public final GetBalanceContract.Presenter getGetBalancePresenter() {
        GetBalanceContract.Presenter presenter = this.getBalancePresenter;
        Object obj = null;
        if (presenter != null) {
            int i = scheduleImpl + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 == 0 ? '_' : InputCardNumberView.DIVIDER) != ' ') {
                obj.hashCode();
            }
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i2 = scheduleImpl + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.amp : (char) 27) != '&') {
            return null;
        }
        int i3 = 85 / 0;
        return null;
    }

    @JvmName(name = "setGetBalancePresenter")
    public final void setGetBalancePresenter(GetBalanceContract.Presenter presenter) {
        int i = scheduleImpl + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.getBalancePresenter = presenter;
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if ((dynamicUrlWrapper != null ? '@' : (char) 28) == '@') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 59;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = scheduleImpl + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
            return;
        }
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
        int i2 = 38 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r0 != null ? '-' : 2) != '-') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        r2 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r0 != null) goto L21;
     */
    @kotlin.jvm.JvmName(name = "getDeviceInformationProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.config.DeviceInformationProvider getDeviceInformationProvider() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r2) goto L18
            id.dana.data.config.DeviceInformationProvider r0 = r4.deviceInformationProvider
            if (r0 == 0) goto L27
            goto L30
        L18:
            id.dana.data.config.DeviceInformationProvider r0 = r4.deviceInformationProvider
            r2 = 20
            int r2 = r2 / r3
            r2 = 45
            if (r0 == 0) goto L24
            r3 = 45
            goto L25
        L24:
            r3 = 2
        L25:
            if (r3 == r2) goto L30
        L27:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L2e
            r0 = 0
            return r0
        L2e:
            r0 = move-exception
            goto L3c
        L30:
            int r2 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L2e
            int r2 = r2 + 103
            int r3 = r2 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r3     // Catch: java.lang.Exception -> L3a
            int r2 = r2 % r1
            return r0
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            throw r0
        L3d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.getDeviceInformationProvider():id.dana.data.config.DeviceInformationProvider");
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
            this.deviceInformationProvider = deviceInformationProvider;
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
            this.deviceInformationProvider = deviceInformationProvider;
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getWalletH5ServicesImplementation")
    public final WalletH5ServicesImplementation getWalletH5ServicesImplementation() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                WalletH5ServicesImplementation walletH5ServicesImplementation = this.walletH5ServicesImplementation;
                if ((walletH5ServicesImplementation != null ? 'a' : '%') != 'a') {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    return null;
                }
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return walletH5ServicesImplementation;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setWalletH5ServicesImplementation")
    public final void setWalletH5ServicesImplementation(WalletH5ServicesImplementation walletH5ServicesImplementation) {
        int i = scheduleImpl + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
        this.walletH5ServicesImplementation = walletH5ServicesImplementation;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = "getWalletV3TrackerImplementation")
    public final WalletV3TrackerImpl getWalletV3TrackerImplementation() {
        WalletV3TrackerImpl walletV3TrackerImpl = this.walletV3TrackerImplementation;
        if ((walletV3TrackerImpl != null ? '\'' : '4') == '4') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i = scheduleImpl + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            return null;
        }
        int i3 = scheduleImpl + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return walletV3TrackerImpl;
        }
        int i4 = 26 / 0;
        return walletV3TrackerImpl;
    }

    @JvmName(name = "setWalletV3TrackerImplementation")
    public final void setWalletV3TrackerImplementation(WalletV3TrackerImpl walletV3TrackerImpl) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 115;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? '\'' : (char) 20) != 20) {
            try {
                Intrinsics.checkNotNullParameter(walletV3TrackerImpl, "");
                this.walletV3TrackerImplementation = walletV3TrackerImpl;
                int i2 = 27 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                Intrinsics.checkNotNullParameter(walletV3TrackerImpl, "");
                this.walletV3TrackerImplementation = walletV3TrackerImpl;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = scheduleImpl + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if ((r0 % 2) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        r0 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r0 = '.';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if (r0 == '.') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if ((r0 != null) != false) goto L14;
     */
    @kotlin.jvm.JvmName(name = "getFeaturePresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.path.FeatureContract.Presenter getFeaturePresenter() {
        /*
            r3 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 57
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L1a
            id.dana.contract.deeplink.path.FeatureContract$Presenter r0 = r3.featurePresenter
            r1 = 96
            r2 = 0
            int r1 = r1 / r2
            if (r0 == 0) goto L15
            r2 = 1
        L15:
            if (r2 == 0) goto L1f
            goto L1e
        L18:
            r0 = move-exception
            throw r0
        L1a:
            id.dana.contract.deeplink.path.FeatureContract$Presenter r0 = r3.featurePresenter
            if (r0 == 0) goto L1f
        L1e:
            return r0
        L1f:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 46
            if (r0 == 0) goto L35
            r0 = 94
            goto L37
        L35:
            r0 = 46
        L37:
            r2 = 0
            if (r0 == r1) goto L40
            r2.hashCode()     // Catch: java.lang.Throwable -> L3e
            return r2
        L3e:
            r0 = move-exception
            throw r0
        L40:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.getFeaturePresenter():id.dana.contract.deeplink.path.FeatureContract$Presenter");
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        int i = scheduleImpl + 33;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.featurePresenter = presenter;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.featurePresenter = presenter;
            objArr.hashCode();
        }
        int i2 = scheduleImpl + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if ((i2 % 2 == 0 ? '6' : 'Y') != 'Y') {
            int length = objArr.length;
        }
    }

    @JvmName(name = "getIdentityToastAndDialog")
    private final IdentityToastAndDialogImpl getIdentityToastAndDialog() {
        IdentityToastAndDialogImpl identityToastAndDialogImpl;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
        scheduleImpl = i % 128;
        if (!(i % 2 != 0)) {
            try {
                try {
                    identityToastAndDialogImpl = (IdentityToastAndDialogImpl) this.identityToastAndDialog.getValue();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            identityToastAndDialogImpl = (IdentityToastAndDialogImpl) this.identityToastAndDialog.getValue();
            Object obj = null;
            obj.hashCode();
        }
        int i2 = scheduleImpl + 49;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        return identityToastAndDialogImpl;
    }

    @JvmName(name = "getKeyboardHeightProvider")
    private final KeyboardHeightProvider getKeyboardHeightProvider() {
        int i = scheduleImpl + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        KeyboardHeightProvider keyboardHeightProvider = (KeyboardHeightProvider) this.keyboardHeightProvider.getValue();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
            try {
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return keyboardHeightProvider;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getDanaLoadingDialog")
    private final DanaLoadingDialog getDanaLoadingDialog() {
        int i = scheduleImpl + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? 'E' : 'M') != 'E') {
            return (DanaLoadingDialog) this.danaLoadingDialog.getValue();
        }
        try {
            DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.danaLoadingDialog.getValue();
            Object obj = null;
            obj.hashCode();
            return danaLoadingDialog;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final FragmentWalletSearchBinding initViewBinding(View view) {
        FragmentWalletSearchBinding MyBillsEntityDataFactory2;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? 'O' : 'a') != 'O') {
            Intrinsics.checkNotNullParameter(view, "");
            MyBillsEntityDataFactory2 = FragmentWalletSearchBinding.MyBillsEntityDataFactory(view);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        } else {
            Intrinsics.checkNotNullParameter(view, "");
            MyBillsEntityDataFactory2 = FragmentWalletSearchBinding.MyBillsEntityDataFactory(view);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 91;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        return MyBillsEntityDataFactory2;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        getLifecycle().BuiltInFictitiousFunctionClassFactory(getIdentityToastAndDialog());
        initBundle();
        initInjector();
        initView();
        initOnClickListener();
        loadData();
        FragmentActivity activity = getActivity();
        Object[] objArr = null;
        if (!(activity == null)) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            try {
                OnBackPressedDispatcher onBackPressedDispatcher = activity.getOnBackPressedDispatcher();
                if (!(onBackPressedDispatcher == null)) {
                    int i3 = scheduleImpl + 13;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        onBackPressedDispatcher.PlaceComponentResult(this, this.onBackPressedCallback);
                        objArr.hashCode();
                    } else {
                        onBackPressedDispatcher.PlaceComponentResult(this, this.onBackPressedCallback);
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        trackSearchPageOpen();
        disableSwipe();
        int i4 = scheduleImpl + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        if (i4 % 2 == 0) {
            int length = objArr.length;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        WalletV3SearchView walletV3SearchView;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        super.onResume();
        FragmentWalletSearchBinding binding = getBinding();
        if ((binding != null) && (walletV3SearchView = binding.lookAheadTest) != null) {
            walletV3SearchView.enableEditText();
        }
        FragmentWalletSearchBinding binding2 = getBinding();
        if ((binding2 != null ? '=' : '0') != '0') {
            WalletV3SearchView walletV3SearchView2 = binding2.lookAheadTest;
            if (!(walletV3SearchView2 == null)) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
                scheduleImpl = i3 % 128;
                if (i3 % 2 == 0) {
                    walletV3SearchView2.setEditTextFocus();
                    return;
                }
                try {
                    walletV3SearchView2.setEditTextFocus();
                    int i4 = 5 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        int i = scheduleImpl + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        super.onDestroyView();
        Object obj = null;
        this.pageSource = null;
        setEnabled(false);
        remove();
        getKeyboardHeightProvider().dismiss();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(getIdentityToastAndDialog());
        _$_clearFindViewByIdCache();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 != 0 ? '.' : Typography.amp) != '&') {
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1012 ? (char) 19 : '.') != '.') {
            try {
                if (resultCode == -1) {
                    try {
                        startActivityForResult(new Intent(getContext(), KtpDetailActivity.class), NewWalletFragment.INSTANCE.getIDENTITY_REQUEST_CODE());
                    } catch (Exception e) {
                        throw e;
                    }
                } else if (resultCode == 0) {
                    Object[] objArr = 0;
                    objArr = 0;
                    if (data != null && (extras = data.getExtras()) != null) {
                        int i = scheduleImpl + 67;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                        if (i % 2 == 0) {
                            String string = extras.getString(ChallengeControl.Key.CANCEL_REASON);
                            int length = objArr.length;
                            objArr = string;
                        } else {
                            objArr = extras.getString(ChallengeControl.Key.CANCEL_REASON);
                        }
                    }
                    if (!(Intrinsics.areEqual(objArr, ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED) ? false : true)) {
                        int i2 = scheduleImpl + 31;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                        int i3 = i2 % 2;
                        getIdentityToastAndDialog().showErrorVerifyPinPopup();
                        return;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
        scheduleImpl = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void loadData() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        getServicesPresenter().BuiltInFictitiousFunctionClassFactory(WalletConstant.CATEGORY_FINANCE, true);
        getGetBalancePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getGetBalancePresenter().MyBillsEntityDataFactory();
        WalletSearchPresenter walletSearchPresenter = getWalletSearchPresenter();
        String str = this.pageSource;
        if (!(str != null)) {
            str = "";
        }
        try {
            walletSearchPresenter.getDefaultRecommendation(str);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
            scheduleImpl = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void initInjector() {
        DaggerWalletSearchComponent.Builder balanceModule = DaggerWalletSearchComponent.builder().applicationComponent(ComponentHolder.getAuthRequestContext()).walletSearchModule(getWalletSearchModule()).servicesModule(getServicesModule()).getBalanceModule(getBalanceModule());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getActivity();
        byte b = 0;
        Object[] objArr = new Object[1];
        a(Color.green(0) + 127, new byte[]{-121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr);
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        DaggerWalletSearchComponent.Builder deepLinkModule = balanceModule.deepLinkModule(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        DaggerWalletSearchComponent.Builder scanQrModule = deepLinkModule.scanQrModule(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getActivity();
        DaggerWalletSearchComponent.Builder restoreUrlModule = scanQrModule.restoreUrlModule(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        MyBillsEntityDataFactory2.PlaceComponentResult = TrackerKey.SourceType.WALLET_SEARCH;
        DaggerWalletSearchComponent.Builder featureModule = restoreUrlModule.featureModule(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        featureModule.oauthModule(new OauthModule(BuiltInFictitiousFunctionClassFactory, b)).loyaltyWalletDetailModule(getLoyaltyWalletDetailModule()).build().inject(this);
        registerPresenter(getWalletSearchPresenter(), getServicesPresenter(), getReadLinkPropertiesPresenter(), getLoyaltyPresenter(), getGetBalancePresenter());
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? (char) 15 : 'O') != 15) {
            return;
        }
        int i2 = 79 / 0;
    }

    private final WalletSearchModule getWalletSearchModule() {
        WalletSearchModule walletSearchModule = new WalletSearchModule(new WalletSearchContract.View() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$getWalletSearchModule$1
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

            @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.View
            public final void onGetChipSearchCategory(List<SearchCategoryModel> searchGeneralModel) {
                WalletSearchCategoryView walletSearchCategoryView;
                Intrinsics.checkNotNullParameter(searchGeneralModel, "");
                WalletSearchFragment.access$hideSearchCategory(WalletSearchFragment.this);
                FragmentWalletSearchBinding access$getBinding = WalletSearchFragment.access$getBinding(WalletSearchFragment.this);
                if (access$getBinding == null || (walletSearchCategoryView = access$getBinding.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                    return;
                }
                walletSearchCategoryView.setCategoryItem(searchGeneralModel);
            }

            @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.View
            public final void onErrorGetChipSearchCategory() {
                FragmentWalletSearchBinding access$getBinding = WalletSearchFragment.access$getBinding(WalletSearchFragment.this);
                WalletSearchCategoryView walletSearchCategoryView = access$getBinding != null ? access$getBinding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
                if (walletSearchCategoryView != null) {
                    walletSearchCategoryView.setVisibility(8);
                }
            }

            @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.View
            public final void onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(List<? extends WalletV3CardModel> assets) {
                Intrinsics.checkNotNullParameter(assets, "");
                WalletSearchFragment.access$showWalletAsset(WalletSearchFragment.this, assets);
            }

            @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.View
            public final void onSuccessGetAllAssets(List<? extends WalletV3CardModel> assets) {
                Intrinsics.checkNotNullParameter(assets, "");
                WalletSearchFragment.access$showWalletAsset(WalletSearchFragment.this, assets);
            }

            @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.View
            public final void onInitialStateWithRecommendation() {
                WalletSearchFragment.this.showInitStateWithRecommendation();
            }

            @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.View
            public final void onInitialState() {
                WalletSearchFragment.this.showInitState();
            }
        });
        try {
            int i = scheduleImpl + 25;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            return walletSearchModule;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077 A[Catch: Exception -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x006d, blocks: (B:29:0x0069, B:35:0x0077), top: B:62:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0098 A[Catch: Exception -> 0x008e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x008e, blocks: (B:37:0x007d, B:52:0x0098, B:54:0x009e), top: B:60:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showInitState() {
        /*
            r7 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            r1 = 0
            if (r0 == 0) goto L16
            androidx.recyclerview.widget.RecyclerView r0 = r0.PlaceComponentResult
            goto L17
        L16:
            r0 = r1
        L17:
            r2 = 8
            if (r0 == 0) goto L1e
            r0.setVisibility(r2)
        L1e:
            r7.hideSearchCategory()
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            r3 = 0
            if (r0 == 0) goto L40
            id.dana.databinding.ViewInitialSearchWalletV3Binding r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r0 == 0) goto L30
            r4 = 1
            goto L31
        L30:
            r4 = 0
        L31:
            if (r4 == 0) goto L40
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r4 = r4 + 91
            int r5 = r4 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r5
            int r4 = r4 % 2
            goto L41
        L40:
            r0 = r1
        L41:
            if (r0 == 0) goto L50
            int r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r4 = r4 + 101
            int r5 = r4 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r5
            int r4 = r4 % 2
            r0.setVisibility(r3)
        L50:
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            if (r0 == 0) goto L5b
            androidx.appcompat.widget.AppCompatTextView r0 = r0.getAuthRequestContext
            goto L5c
        L5b:
            r0 = r1
        L5c:
            r4 = 90
            r5 = 73
            if (r0 == 0) goto L65
            r6 = 73
            goto L67
        L65:
            r6 = 90
        L67:
            if (r6 == r4) goto L6f
            r0.setVisibility(r3)     // Catch: java.lang.Exception -> L6d
            goto L6f
        L6d:
            r0 = move-exception
            goto L90
        L6f:
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            if (r0 == 0) goto L91
            int r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl     // Catch: java.lang.Exception -> L6d
            int r1 = r1 + 57
            int r4 = r1 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4     // Catch: java.lang.Exception -> L8e
            int r1 = r1 % 2
            if (r1 != 0) goto L8b
            id.dana.wallet_v3.view.search.view.DoneSearchWalletView r1 = r0.BuiltInFictitiousFunctionClassFactory
            r0 = 51
            int r0 = r0 / r3
            goto L91
        L89:
            r0 = move-exception
            throw r0
        L8b:
            id.dana.wallet_v3.view.search.view.DoneSearchWalletView r1 = r0.BuiltInFictitiousFunctionClassFactory
            goto L91
        L8e:
            r0 = move-exception
            goto Lae
        L90:
            throw r0
        L91:
            if (r1 == 0) goto L95
            r3 = 73
        L95:
            if (r3 == r5) goto L98
            goto Lad
        L98:
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L8e
            int r0 = r0 + 117
            int r3 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r3     // Catch: java.lang.Exception -> L8e
            int r0 = r0 % 2
            if (r0 == 0) goto Laa
            r0 = 22
            r1.setVisibility(r0)
            goto Lad
        Laa:
            r1.setVisibility(r2)
        Lad:
            return
        Lae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.showInitState():void");
    }

    public final void showInitStateWithRecommendation() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        ViewInitialSearchWalletV3Binding viewInitialSearchWalletV3Binding;
        FragmentWalletSearchBinding binding = getBinding();
        DoneSearchWalletView doneSearchWalletView = null;
        if (binding != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            try {
                recyclerView = binding.PlaceComponentResult;
            } catch (Exception e) {
                throw e;
            }
        } else {
            recyclerView = null;
        }
        if (recyclerView != null) {
            try {
                recyclerView.setVisibility(0);
            } catch (Exception e2) {
                throw e2;
            }
        }
        hideSearchCategory();
        FragmentWalletSearchBinding binding2 = getBinding();
        if (binding2 == null || (viewInitialSearchWalletV3Binding = binding2.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            constraintLayout = null;
        } else {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            constraintLayout = viewInitialSearchWalletV3Binding.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        FragmentWalletSearchBinding binding3 = getBinding();
        AppCompatTextView appCompatTextView = binding3 != null ? binding3.getAuthRequestContext : null;
        if ((appCompatTextView != null ? (char) 27 : JSONLexer.EOI) == 27) {
            appCompatTextView.setVisibility(0);
        }
        FragmentWalletSearchBinding binding4 = getBinding();
        if (binding4 != null) {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 101;
            scheduleImpl = i5 % 128;
            int i6 = i5 % 2;
            doneSearchWalletView = binding4.BuiltInFictitiousFunctionClassFactory;
        }
        if (doneSearchWalletView != null) {
            int i7 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 67;
            scheduleImpl = i7 % 128;
            if ((i7 % 2 != 0 ? JSONLexer.EOI : '9') != 26) {
                doneSearchWalletView.setVisibility(8);
            } else {
                doneSearchWalletView.setVisibility(61);
            }
            int i8 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
            scheduleImpl = i8 % 128;
            int i9 = i8 % 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        r0.setItems(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl + 73;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if (r0 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if ((r4 % 2) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r4 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r4 = '/';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        if (r4 == '/') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        r0 = r0.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        r0 = r0.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005d, code lost:
    
        r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl + 85;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        if ((r4 % 2) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0069, code lost:
    
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
    
        hideSearchCategory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if (r0 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        if (r0 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl + 29;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4 % 128;
        r4 = r4 % 2;
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008c, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
    
        if (r0 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:
    
        r5 = 'A';
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
    
        r5 = '2';
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0096, code lost:
    
        if (r5 == '2') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0098, code lost:
    
        r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 23;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        if ((r4 % 2) == 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a6, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a7, code lost:
    
        if (r4 == true) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
    
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00af, code lost:
    
        r0.setVisibility(80);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bb, code lost:
    
        if ((!r7.isEmpty()) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bd, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bf, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c0, code lost:
    
        if (r7 == true) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c2, code lost:
    
        r7 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c8, code lost:
    
        if (r7 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ca, code lost:
    
        r1 = r7.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cc, code lost:
    
        if (r1 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ce, code lost:
    
        r1.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d2, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d3, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if ((r0 == null) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showWalletAsset(java.util.List<? extends id.dana.wallet_v3.model.WalletV3CardModel> r7) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.showWalletAsset(java.util.List):void");
    }

    private final ServicesModule getServicesModule() {
        ServicesModule servicesModule = new ServicesModule(new ServicesContract.View() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$getServicesModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
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
            public final void onGetFilteredThirdPartyServices(List<ThirdPartyService> thirdPartyServices) {
                Intrinsics.checkNotNullParameter(thirdPartyServices, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
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

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetThirdPartyServices(List<ThirdPartyService> thirdPartyServices) {
                Intrinsics.checkNotNullParameter(thirdPartyServices, "");
                WalletSearchFragment.access$setServices$p(WalletSearchFragment.this, thirdPartyServices);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str != null) {
                    WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
                    if (UrlUtil.getErrorConfigVersion(str)) {
                        walletSearchFragment.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                        return;
                    }
                    WalletH5ServicesImplementation walletH5ServicesImplementation = walletSearchFragment.getWalletH5ServicesImplementation();
                    String authRequestContext = UrlUtil.getAuthRequestContext(str);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, null, null);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService thirdPartyService, String authCode) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
                WalletH5ServicesImplementation walletH5ServicesImplementation = WalletSearchFragment.this.getWalletH5ServicesImplementation();
                String authRequestContext = UrlUtil.getAuthRequestContext(thirdPartyService.getCallingPid);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                Intrinsics.checkNotNull(authCode);
                walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, authCode, WalletSearchFragment.this.getDeviceInformationProvider().getDeviceUUID());
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionFailed(String message) {
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionMiniApp(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService thirdPartyService, Map<String, String> params) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str != null) {
                    WalletSearchFragment.this.getFeaturePresenter().getAuthRequestContext(str, params);
                }
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        return servicesModule;
    }

    private final GetBalanceModule getBalanceModule() {
        try {
            GetBalanceModule getBalanceModule = new GetBalanceModule(new GetBalanceContract.View() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$getBalanceModule$1
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
                    SearchCardAdapter access$getSearchCardAdapter$p = WalletSearchFragment.access$getSearchCardAdapter$p(WalletSearchFragment.this);
                    if (access$getSearchCardAdapter$p != null) {
                        access$getSearchCardAdapter$p.setGoalsBalanceVisibility(allBalanceVisibility != null ? allBalanceVisibility.get(1) : null);
                    }
                    SearchCardAdapter access$getSearchCardAdapter$p2 = WalletSearchFragment.access$getSearchCardAdapter$p(WalletSearchFragment.this);
                    if (access$getSearchCardAdapter$p2 != null) {
                        access$getSearchCardAdapter$p2.setEmasBalanceVisibility(allBalanceVisibility != null ? allBalanceVisibility.get(3) : null);
                    }
                }
            });
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 103;
            scheduleImpl = i % 128;
            if ((i % 2 != 0 ? 'O' : 'Y') != 'O') {
                return getBalanceModule;
            }
            Object obj = null;
            obj.hashCode();
            return getBalanceModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void openLoyalty() {
        int i;
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 77;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
            Action action = this.loyaltyAction;
            if (action == null) {
                int i4 = scheduleImpl + 103;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                if ((i4 % 2 == 0 ? (char) 11 : '\'') == 11) {
                    int i5 = 20 / 0;
                }
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
            }
            if (i == 1) {
                openLoyaltyDetailH5(this.pocketId);
                int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 109;
                scheduleImpl = i6 % 128;
                int i7 = i6 % 2;
                return;
            }
            int i8 = scheduleImpl + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i8 % 128;
            int i9 = i8 % 2;
            if (i == 2) {
                openLoyaltyAddH5();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final LoyaltyWalletDetailModule getLoyaltyWalletDetailModule() {
        LoyaltyWalletDetailModule loyaltyWalletDetailModule = new LoyaltyWalletDetailModule(new LoyaltyWalletContract.View() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$getLoyaltyWalletDetailModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onDismissLoadingGetLoyaltyAsset() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onErrorGetLoyaltyAsset() {
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onLoadingGetLoyaltyAsset() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onGetLoyaltyAccessToken(String token) {
                WalletSearchFragment.access$setAccessToken$p(WalletSearchFragment.this, token);
                String access$getKycLevel$p = WalletSearchFragment.access$getKycLevel$p(WalletSearchFragment.this);
                if (access$getKycLevel$p == null || access$getKycLevel$p.length() == 0) {
                    return;
                }
                WalletSearchFragment.access$openLoyalty(WalletSearchFragment.this);
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onGetKycLevel(String kycLevel) {
                WalletSearchFragment.access$setKycLevel$p(WalletSearchFragment.this, kycLevel);
                String access$getAccessToken$p = WalletSearchFragment.access$getAccessToken$p(WalletSearchFragment.this);
                if (access$getAccessToken$p == null || access$getAccessToken$p.length() == 0) {
                    return;
                }
                WalletSearchFragment.access$openLoyalty(WalletSearchFragment.this);
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onErrorGetLoyaltyAccessToken() {
                WalletSearchFragment.access$setLoyaltyAction$p(WalletSearchFragment.this, null);
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onErrorKycLevel() {
                WalletSearchFragment.access$setLoyaltyAction$p(WalletSearchFragment.this, null);
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onSuccessGetLoyaltyAsset(NewPocketQueryListModel<LoyaltyCardModel> assets, int pageNumber) {
                Intrinsics.checkNotNullParameter(assets, "");
                SearchCardAdapter access$getSearchCardAdapter$p = WalletSearchFragment.access$getSearchCardAdapter$p(WalletSearchFragment.this);
                if (access$getSearchCardAdapter$p != null) {
                    access$getSearchCardAdapter$p.appendItems(assets.getPockets());
                }
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        return loyaltyWalletDetailModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if ((r0 != null ? '\f' : 6) != '\f') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r0.setWalletSearchCategoryViewListener(getChipCategoryListener());
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r0 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initView() {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.initView():void");
    }

    /* renamed from: initView$lambda-3$lambda-2  reason: not valid java name */
    private static final void m3108initView$lambda3$lambda2(WalletSearchFragment walletSearchFragment, int i) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Integer valueOf;
        int i2;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(walletSearchFragment, "");
        FragmentWalletSearchBinding binding = walletSearchFragment.getBinding();
        if (binding != null) {
            try {
                int i5 = scheduleImpl + 77;
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
                    Object obj = null;
                    if (i5 % 2 != 0) {
                        recyclerView = binding.PlaceComponentResult;
                        if (recyclerView == null) {
                            return;
                        }
                    } else {
                        recyclerView = binding.PlaceComponentResult;
                        obj.hashCode();
                        if (!(recyclerView != null)) {
                            return;
                        }
                    }
                    int i6 = scheduleImpl + 113;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
                    if (i6 % 2 == 0) {
                        recyclerView2 = recyclerView;
                        valueOf = Integer.valueOf(i);
                        i2 = 21;
                    } else {
                        recyclerView2 = recyclerView;
                        valueOf = Integer.valueOf(i);
                        i2 = 7;
                    }
                    ViewExtKt.MyBillsEntityDataFactory(recyclerView2, (Integer) null, (Integer) null, valueOf, i2);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0098 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getUserAssets(java.lang.CharSequence r9) {
        /*
            r8 = this;
            java.lang.String r9 = r9.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.CharSequence r9 = kotlin.text.StringsKt.trim(r9)
            java.lang.String r9 = r9.toString()
            androidx.viewbinding.ViewBinding r0 = r8.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            r1 = 44
            if (r0 == 0) goto L1b
            r2 = 56
            goto L1d
        L1b:
            r2 = 44
        L1d:
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == r1) goto L43
            int r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 11
            int r2 = r1 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r2
            int r1 = r1 % r3
            id.dana.wallet_v3.view.search.view.WalletV3SearchView r0 = r0.lookAheadTest
            if (r0 == 0) goto L43
            int r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 55
            int r2 = r1 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r2
            int r1 = r1 % r3
            boolean r0 = r0.isEnabled()     // Catch: java.lang.Exception -> L41
            if (r0 == r5) goto L3f
            goto L43
        L3f:
            r0 = 1
            goto L44
        L41:
            r9 = move-exception
            throw r9
        L43:
            r0 = 0
        L44:
            if (r0 == 0) goto L48
            r0 = 1
            goto L49
        L48:
            r0 = 0
        L49:
            if (r0 == 0) goto L98
            int r0 = r9.length()
            if (r0 < r3) goto L53
            r0 = 0
            goto L54
        L53:
            r0 = 1
        L54:
            java.lang.String r1 = ""
            if (r0 == 0) goto L67
            id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter r9 = r8.getWalletSearchPresenter()     // Catch: java.lang.Exception -> L65
            java.lang.String r0 = r8.pageSource     // Catch: java.lang.Exception -> L65
            if (r0 == 0) goto L61
            r1 = r0
        L61:
            r9.getDefaultRecommendation(r1)
            goto L98
        L65:
            r9 = move-exception
            goto L97
        L67:
            id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter r0 = r8.getWalletSearchPresenter()
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r9)
            java.lang.String r6 = r8.pageSource
            if (r6 != 0) goto L75
            r7 = 1
            goto L76
        L75:
            r7 = 0
        L76:
            if (r7 == r5) goto L79
            goto L83
        L79:
            int r6 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r6 = r6 + 65
            int r7 = r6 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r7
            int r6 = r6 % r3
            r6 = r1
        L83:
            r0.getAllCardAssets(r2, r9, r6)     // Catch: java.lang.Exception -> L65
            id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter r0 = r8.getWalletSearchPresenter()     // Catch: java.lang.Exception -> L65
            java.lang.String r2 = r8.pageSource     // Catch: java.lang.Exception -> L65
            if (r2 == 0) goto L8f
            r4 = 1
        L8f:
            if (r4 == r5) goto L92
            goto L93
        L92:
            r1 = r2
        L93:
            r0.getDynamicRecommendation(r9, r1)
            return
        L97:
            throw r9
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.getUserAssets(java.lang.CharSequence):void");
    }

    private final void delayToSearch(final Function0<Unit> action) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        Scheduler KClassImpl$Data$declaredNonStaticMembers$23;
        Completable MyBillsEntityDataFactory2 = Completable.MyBillsEntityDataFactory();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$24 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(MyBillsEntityDataFactory2, 500L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$22));
        KClassImpl$Data$declaredNonStaticMembers$23 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$23, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$25 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$24, KClassImpl$Data$declaredNonStaticMembers$23));
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$26 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$25, PlaceComponentResult2));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$26, "");
        addDisposable(SubscribersKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$26, null, new Function0<Unit>() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$delayToSearch$1
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
                action.invoke();
            }
        }, 1));
        int i = scheduleImpl + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? 'U' : '^') != '^') {
            int i2 = 52 / 0;
        }
    }

    private final void initOnClickListener() {
        DoneSearchWalletView doneSearchWalletView;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            FragmentWalletSearchBinding binding = getBinding();
            if ((binding != null ? 'K' : '\r') != '\r' && (doneSearchWalletView = binding.BuiltInFictitiousFunctionClassFactory) != null) {
                doneSearchWalletView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WalletSearchFragment.$r8$lambda$dOoRsOrmoISl2EvzZKMHeXz7YQE(WalletSearchFragment.this, view);
                    }
                });
            }
            int i3 = scheduleImpl + 55;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: initOnClickListener$lambda-4  reason: not valid java name */
    private static final void m3107initOnClickListener$lambda4(WalletSearchFragment walletSearchFragment, View view) {
        int i = scheduleImpl + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(walletSearchFragment, "");
        walletSearchFragment.onCancelOrBackPressed();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.search.view.WalletSearchFragment$getChipCategoryListener$1] */
    private final WalletSearchFragment$getChipCategoryListener$1 getChipCategoryListener() {
        ?? r0 = new WalletSearchCategoryViewListener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$getChipCategoryListener$1
            @Override // id.dana.wallet_v3.listener.WalletSearchCategoryViewListener
            public final void onClickChipCategory(SearchCategoryModel searchCategoryModel) {
                WalletV3SearchView walletV3SearchView;
                Intrinsics.checkNotNullParameter(searchCategoryModel, "");
                WalletSearchFragment.access$setFilterBasedOnChip$p(WalletSearchFragment.this, true);
                String access$getChipTitle = WalletSearchFragment.access$getChipTitle(WalletSearchFragment.this, searchCategoryModel);
                FragmentWalletSearchBinding access$getBinding = WalletSearchFragment.access$getBinding(WalletSearchFragment.this);
                if (access$getBinding != null && (walletV3SearchView = access$getBinding.lookAheadTest) != null) {
                    walletV3SearchView.setTextAndDisableEditText(access$getChipTitle);
                }
                WalletSearchFragment.this.getWalletSearchPresenter().getPaymentOrPocketAssetsBasedOnAssetType(searchCategoryModel.getAssetTypes());
                WalletSearchPresenter walletSearchPresenter = WalletSearchFragment.this.getWalletSearchPresenter();
                String access$getPageSource$p = WalletSearchFragment.access$getPageSource$p(WalletSearchFragment.this);
                walletSearchPresenter.getDynamicRecommendation(access$getChipTitle, access$getPageSource$p != null ? access$getPageSource$p : "");
                WalletSearchFragment.access$hideKeyboard(WalletSearchFragment.this);
                WalletSearchFragment walletSearchFragment = WalletSearchFragment.this;
                WalletSearchFragment.access$trackSearchSubmit(walletSearchFragment, "Bubble", WalletSearchFragment.access$getChipTitle(walletSearchFragment, searchCategoryModel));
            }
        };
        int i = scheduleImpl + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return r0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        if ((r0 != null) != true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
    
        r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        r0 = r0.getSystemService("input_method");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        if (r1 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void hideKeyboard() {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl     // Catch: java.lang.Exception -> L82
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> L80
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L19
            android.content.Context r0 = r6.getContext()
            int r4 = r3.length     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L24
            goto L30
        L17:
            r0 = move-exception
            throw r0
        L19:
            android.content.Context r0 = r6.getContext()
            if (r0 == 0) goto L21
            r4 = 1
            goto L22
        L21:
            r4 = 0
        L22:
            if (r4 == r1) goto L30
        L24:
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 123
            int r4 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r4
            int r0 = r0 % 2
            r0 = r3
            goto L36
        L30:
            java.lang.String r4 = "input_method"
            java.lang.Object r0 = r0.getSystemService(r4)
        L36:
            if (r0 == 0) goto L78
            int r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L80
            int r4 = r4 + 3
            int r5 = r4 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r5     // Catch: java.lang.Exception -> L80
            int r4 = r4 % 2
            r5 = 19
            if (r4 == 0) goto L49
            r4 = 58
            goto L4b
        L49:
            r4 = 19
        L4b:
            if (r4 == r5) goto L59
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
            android.view.View r1 = r6.getGetAuthRequestContext()
            int r3 = r3.length     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L6d
            goto L66
        L57:
            r0 = move-exception
            throw r0
        L59:
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
            android.view.View r3 = r6.getGetAuthRequestContext()
            if (r3 == 0) goto L62
            r1 = 0
        L62:
            if (r1 == 0) goto L65
            goto L6d
        L65:
            r1 = r3
        L66:
            android.os.IBinder r1 = r1.getWindowToken()
            r0.hideSoftInputFromWindow(r1, r2)
        L6d:
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            return
        L78:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L80
            throw r0     // Catch: java.lang.Exception -> L80
        L80:
            r0 = move-exception
            throw r0
        L82:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.hideKeyboard():void");
    }

    @JvmName(name = "getDanaGoalsClickListener")
    private final GoalsClickListener getDanaGoalsClickListener() {
        GoalsClickListener goalsClickListener;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
            scheduleImpl = i % 128;
            if (!(i % 2 != 0)) {
                goalsClickListener = (GoalsClickListener) this.danaGoalsClickListener.getValue();
            } else {
                goalsClickListener = (GoalsClickListener) this.danaGoalsClickListener.getValue();
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = scheduleImpl + 31;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            return goalsClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getAssetRecommendationClickListener")
    private final AssetRecommendationClickListener getAssetRecommendationClickListener() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        AssetRecommendationClickListener assetRecommendationClickListener = (AssetRecommendationClickListener) this.assetRecommendationClickListener.getValue();
        int i3 = scheduleImpl + 41;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 16 : 'E') != 16) {
            return assetRecommendationClickListener;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return assetRecommendationClickListener;
    }

    private final DanaH5Listener createH5AppListener() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.wallet_v3.view.search.view.WalletSearchFragment$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
                WalletSearchFragment.access$getDanaLoadingDialog(WalletSearchFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                DanaH5.dispose();
            }
        };
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
            scheduleImpl = i % 128;
            if (i % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return danaH5Listener;
            }
            return danaH5Listener;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void setLastAddedAssetType(int sectionIndex) {
        NewWalletFragment newWalletFragment;
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag(HomeTabFragment.FragmentTag.WALLET_FRAGMENT);
        if ((findFragmentByTag instanceof NewWalletFragment ? 'Y' : '^') != '^') {
            newWalletFragment = (NewWalletFragment) findFragmentByTag;
            int i = scheduleImpl + 31;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
        } else {
            newWalletFragment = null;
        }
        if (newWalletFragment != null) {
            int i3 = scheduleImpl + 43;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            newWalletFragment.setLastAddedAssetType(Integer.valueOf(sectionIndex));
        }
    }

    @JvmName(name = "getDanaBalanceClickListener")
    private final DanaBalanceClickListener getDanaBalanceClickListener() {
        DanaBalanceClickListener danaBalanceClickListener;
        int i = scheduleImpl + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? '7' : 'R') != '7') {
            try {
                danaBalanceClickListener = (DanaBalanceClickListener) this.danaBalanceClickListener.getValue();
            } catch (Exception e) {
                throw e;
            }
        } else {
            danaBalanceClickListener = (DanaBalanceClickListener) this.danaBalanceClickListener.getValue();
            Object obj = null;
            obj.hashCode();
        }
        int i2 = scheduleImpl + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if ((i2 % 2 == 0 ? '9' : '#') != '#') {
            int i3 = 98 / 0;
            return danaBalanceClickListener;
        }
        return danaBalanceClickListener;
    }

    @JvmName(name = "getDanaEmasClickListener")
    private final DanaEmasClickListener getDanaEmasClickListener() {
        try {
            int i = scheduleImpl + 7;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            DanaEmasClickListener danaEmasClickListener = (DanaEmasClickListener) this.danaEmasClickListener.getValue();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 15 : (char) 17) != 17) {
                Object obj = null;
                obj.hashCode();
                return danaEmasClickListener;
            }
            return danaEmasClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getDanaPlusClickListener")
    private final DanaPlusClickListener getDanaPlusClickListener() {
        int i = scheduleImpl + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 == 0) {
            DanaPlusClickListener danaPlusClickListener = (DanaPlusClickListener) this.danaPlusClickListener.getValue();
            Object obj = null;
            obj.hashCode();
            return danaPlusClickListener;
        }
        return (DanaPlusClickListener) this.danaPlusClickListener.getValue();
    }

    @JvmName(name = "getWalletCardAssetClickListener")
    private final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        WalletCardAssetClickListener walletCardAssetClickListener;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 7;
            try {
                scheduleImpl = i % 128;
                if (i % 2 != 0) {
                    walletCardAssetClickListener = (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
                    Object obj = null;
                    obj.hashCode();
                } else {
                    walletCardAssetClickListener = (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
                }
                int i2 = scheduleImpl + 99;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                if (!(i2 % 2 != 0)) {
                    int i3 = 74 / 0;
                    return walletCardAssetClickListener;
                }
                return walletCardAssetClickListener;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0024
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void gotoTopupPage() {
        /*
            r2 = this;
            id.dana.data.dynamicurl.DynamicUrlWrapper r0 = r2.getDynamicUrlWrapper()     // Catch: java.lang.Exception -> L26
            java.lang.String r1 = "danaWallet"
            java.lang.String r0 = r0.getTopupUrl(r1)     // Catch: java.lang.Exception -> L26
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L26
            id.dana.wallet_v3.view.search.view.WalletSearchFragment$gotoTopupPage$1 r1 = new id.dana.wallet_v3.view.search.view.WalletSearchFragment$gotoTopupPage$1     // Catch: java.lang.Exception -> L26
            r1.<init>()     // Catch: java.lang.Exception -> L26
            id.dana.utils.danah5.DanaH5Listener r1 = (id.dana.utils.danah5.DanaH5Listener) r1     // Catch: java.lang.Exception -> L26
            id.dana.danah5.DanaH5.startContainerFullUrl(r0, r1)     // Catch: java.lang.Exception -> L26
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            return
        L24:
            r0 = move-exception
            throw r0
        L26:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.gotoTopupPage():void");
    }

    private final void goToServicePage(String key) {
        Object obj;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Iterator<T> it = this.services.iterator();
        while (true) {
            if (!(it.hasNext())) {
                obj = null;
                int i3 = scheduleImpl + 3;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
                break;
            }
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 67;
            scheduleImpl = i5 % 128;
            int i6 = i5 % 2;
            Object next = it.next();
            if (Intrinsics.areEqual(((ThirdPartyService) next).NetworkUserEntityData$$ExternalSyntheticLambda8, key)) {
                int i7 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
                scheduleImpl = i7 % 128;
                int i8 = i7 % 2;
                obj = next;
                break;
            }
        }
        ThirdPartyService thirdPartyService = (ThirdPartyService) obj;
        if (thirdPartyService != null) {
            trackServiceOpen(thirdPartyService);
            getServicesPresenter().MyBillsEntityDataFactory(thirdPartyService, (Map<String, String>) null);
        }
        int i9 = scheduleImpl + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i9 % 128;
        int i10 = i9 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        if (r0 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        if ((r0 != null ? kotlin.text.Typography.greater : '_') != '>') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        r1 = getArguments();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
    
        r1 = r1.getString(id.dana.wallet_v3.view.search.view.WalletSearchFragment.SEARCH_BAR_HINT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
    
        r0.setSearchBarHint(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initBundle() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            android.os.Bundle r0 = r5.getArguments()
            r1 = 30
            r2 = 39
            if (r0 == 0) goto L17
            r3 = 30
            goto L19
        L17:
            r3 = 39
        L19:
            r4 = 0
            if (r3 == r2) goto L27
            java.lang.String r2 = "PAGE_SOURCE"
            java.lang.String r0 = r0.getString(r2)     // Catch: java.lang.Exception -> L23
            goto L28
        L23:
            r0 = move-exception
            throw r0
        L25:
            r0 = move-exception
            goto L70
        L27:
            r0 = r4
        L28:
            r5.pageSource = r0
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            if (r0 == 0) goto L71
            int r2 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 111
            int r3 = r2 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r3
            int r2 = r2 % 2
            r3 = 86
            if (r2 == 0) goto L41
            goto L43
        L41:
            r1 = 86
        L43:
            if (r1 == r3) goto L50
            id.dana.wallet_v3.view.search.view.WalletV3SearchView r0 = r0.lookAheadTest
            r1 = 16
            int r1 = r1 / 0
            if (r0 == 0) goto L71
            goto L5e
        L4e:
            r0 = move-exception
            throw r0
        L50:
            id.dana.wallet_v3.view.search.view.WalletV3SearchView r0 = r0.lookAheadTest
            r1 = 62
            if (r0 == 0) goto L59
            r2 = 62
            goto L5b
        L59:
            r2 = 95
        L5b:
            if (r2 == r1) goto L5e
            goto L71
        L5e:
            android.os.Bundle r1 = r5.getArguments()
            if (r1 == 0) goto L6b
            java.lang.String r2 = "SEARCH_BAR_HINT"
            java.lang.String r1 = r1.getString(r2)
            goto L6c
        L6b:
            r1 = r4
        L6c:
            r0.setSearchBarHint(r1)     // Catch: java.lang.Exception -> L25
            goto L71
        L70:
            throw r0
        L71:
            android.os.Bundle r0 = r5.getArguments()
            if (r0 == 0) goto L7e
            java.lang.String r1 = "KYC_LEVEL"
            java.lang.String r0 = r0.getString(r1)
            goto L7f
        L7e:
            r0 = r4
        L7f:
            r5.kycLevel = r0
            android.os.Bundle r0 = r5.getArguments()
            if (r0 == 0) goto L97
            int r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 47
            int r2 = r1 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r2
            int r1 = r1 % 2
            java.lang.String r1 = "ACCESS_TOKEN"
            java.lang.String r4 = r0.getString(r1)
        L97:
            r5.accessToken = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.initBundle():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if ((r0 != null) != true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r0 = r0.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r0.setOnClickListener(new id.dana.wallet_v3.view.search.view.WalletSearchFragment$$ExternalSyntheticLambda1(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r0 != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void dismissSearchView() {
        /*
            r3 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L22
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L3a
            goto L2e
        L20:
            r0 = move-exception
            throw r0
        L22:
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.FragmentWalletSearchBinding r0 = (id.dana.databinding.FragmentWalletSearchBinding) r0
            if (r0 == 0) goto L2b
            r1 = 1
        L2b:
            if (r1 == r2) goto L2e
            goto L3a
        L2e:
            androidx.appcompat.widget.AppCompatTextView r0 = r0.getAuthRequestContext     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L3a
            id.dana.wallet_v3.view.search.view.WalletSearchFragment$$ExternalSyntheticLambda1 r1 = new id.dana.wallet_v3.view.search.view.WalletSearchFragment$$ExternalSyntheticLambda1
            r1.<init>()
            r0.setOnClickListener(r1)
        L3a:
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            return
        L45:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.dismissSearchView():void");
    }

    /* renamed from: dismissSearchView$lambda-9  reason: not valid java name */
    private static final void m3106dismissSearchView$lambda9(WalletSearchFragment walletSearchFragment, View view) {
        WalletV3SearchView walletV3SearchView;
        Intrinsics.checkNotNullParameter(walletSearchFragment, "");
        FragmentWalletSearchBinding binding = walletSearchFragment.getBinding();
        if ((binding != null) && (walletV3SearchView = binding.lookAheadTest) != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
            scheduleImpl = i % 128;
            if (i % 2 != 0) {
                walletV3SearchView.disableEditText();
                Object obj = null;
                obj.hashCode();
            } else {
                try {
                    walletV3SearchView.disableEditText();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 115;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
        }
        walletSearchFragment.onCancelOrBackPressed();
    }

    private final void hideSearchCategory() {
        WalletSearchCategoryView walletSearchCategoryView = null;
        try {
            try {
                if (this.filterBasedOnChip) {
                    FragmentWalletSearchBinding binding = getBinding();
                    if (binding != null) {
                        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
                        scheduleImpl = i % 128;
                        int i2 = i % 2;
                        walletSearchCategoryView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                    if ((walletSearchCategoryView != null ? 'Z' : '*') != 'Z') {
                        return;
                    }
                    walletSearchCategoryView.setVisibility(8);
                    return;
                }
                FragmentWalletSearchBinding binding2 = getBinding();
                if (binding2 != null) {
                    int i3 = scheduleImpl + 87;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    if (i3 % 2 == 0) {
                        WalletSearchCategoryView walletSearchCategoryView2 = binding2.KClassImpl$Data$declaredNonStaticMembers$2;
                        walletSearchCategoryView.hashCode();
                        walletSearchCategoryView = walletSearchCategoryView2;
                    } else {
                        walletSearchCategoryView = binding2.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                }
                if (walletSearchCategoryView != null) {
                    WalletSearchCategoryView walletSearchCategoryView3 = walletSearchCategoryView;
                    boolean z = true;
                    if (this.query.length() == 0) {
                        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
                        scheduleImpl = i4 % 128;
                        int i5 = i4 % 2;
                    } else {
                        int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 29;
                        scheduleImpl = i6 % 128;
                        int i7 = i6 % 2;
                        z = false;
                    }
                    walletSearchCategoryView3.setVisibility((z ? 'Y' : 'L') != 'L' ? 0 : 8);
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void backToNewWalletFragment(FragmentManager fragmentManager) {
        String str;
        try {
            String str2 = this.pageSource;
            if (str2 != null) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
                scheduleImpl = i % 128;
                int i2 = i % 2;
                switch (str2.hashCode()) {
                    case -786681338:
                        try {
                            if (str2.equals("payment")) {
                                str = "PaymentWalletDetailFragment";
                                break;
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                        break;
                    case -135761730:
                        if (str2.equals("identity")) {
                            int i3 = scheduleImpl + 13;
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                            int i4 = i3 % 2;
                            str = "IdentityWalletDetailFragment";
                            break;
                        }
                        break;
                    case 357555337:
                        if (str2.equals("financial")) {
                            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
                            scheduleImpl = i5 % 128;
                            int i6 = i5 % 2;
                            str = "InvestmentWalletDetailFragment";
                            break;
                        }
                        break;
                    case 358728774:
                        if (str2.equals("loyalty")) {
                            str = "LoyaltyWalletDetailFragment";
                            break;
                        }
                        break;
                    case 1018752165:
                        if ((str2.equals("voucher_and_ticket") ? '^' : Typography.less) != '<') {
                            str = "VoucherWalletDetailFragment";
                            break;
                        }
                        break;
                }
                backFromSearch(fragmentManager, str);
            }
            str = HomeTabFragment.FragmentTag.WALLET_FRAGMENT;
            backFromSearch(fragmentManager, str);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final String getChipTitle(SearchCategoryModel data) {
        try {
            if ((Intrinsics.areEqual(Locale.getDefault().getLanguage(), new Locale("in").getLanguage()) ? '`' : 'a') == '`') {
                int i = scheduleImpl + 91;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                return data.getTitleId();
            }
            String titleEn = data.getTitleEn();
            int i3 = scheduleImpl + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return titleEn;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void openLoyaltyDetailH5(String pocketId) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://web-loyalty.dana.id");
        TagFormat MyBillsEntityDataFactory2 = TagFormat.MyBillsEntityDataFactory(DanaUrl.LOYALTY_DETAIL);
        if (pocketId == null) {
            int i = scheduleImpl + 9;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            int i3 = scheduleImpl + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            pocketId = "";
        }
        sb.append(MyBillsEntityDataFactory2.PlaceComponentResult("id", pocketId).PlaceComponentResult("token", this.accessToken).PlaceComponentResult("token", this.kycLevel).MyBillsEntityDataFactory());
        DanaH5.startContainerFullUrl(sb.toString());
        this.loyaltyAction = null;
        getDanaLoadingDialog().PlaceComponentResult();
    }

    private final void openLoyaltyAddH5() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("https://web-loyalty.dana.id");
            sb.append(TagFormat.MyBillsEntityDataFactory(DanaUrl.CREATE_LOYALTY).PlaceComponentResult("token", this.accessToken).PlaceComponentResult("token", this.kycLevel).MyBillsEntityDataFactory());
            DanaH5.startContainerFullUrl(sb.toString(), createH5AppListener());
            getDanaLoadingDialog().PlaceComponentResult();
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 103;
            scheduleImpl = i % 128;
            if ((i % 2 != 0 ? (char) 21 : '\r') != 21) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        if ((r4 <= 0) != true) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
    
        if (r8.length() > 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005c, code lost:
    
        if (r1 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005e, code lost:
    
        r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 + 25;
        id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
    
        if ((r1 % 2) == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006a, code lost:
    
        getWalletV3TrackerImplementation().trackSearchBarSubmit(r7, r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0071, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0077, code lost:
    
        getWalletV3TrackerImplementation().trackSearchBarSubmit(r7, r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void trackSearchSubmit(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r1
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
            if (r0 == 0) goto L27
            java.lang.String r0 = r6.pageSource
            r3.hashCode()     // Catch: java.lang.Throwable -> L25
            r4 = 41
            if (r0 == 0) goto L20
            r5 = 41
            goto L22
        L20:
            r5 = 45
        L22:
            if (r5 == r4) goto L2b
            goto L81
        L25:
            r7 = move-exception
            throw r7
        L27:
            java.lang.String r0 = r6.pageSource
            if (r0 == 0) goto L81
        L2b:
            int r4 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl     // Catch: java.lang.Exception -> L7f
            int r4 = r4 + 79
            int r5 = r4 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = r5     // Catch: java.lang.Exception -> L7f
            int r4 = r4 % 2
            r5 = 11
            if (r4 != 0) goto L3c
            r4 = 44
            goto L3e
        L3c:
            r4 = 11
        L3e:
            if (r4 == r5) goto L52
            r4 = r8
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            int r5 = r3.length     // Catch: java.lang.Throwable -> L50
            if (r4 <= 0) goto L4c
            r4 = 0
            goto L4d
        L4c:
            r4 = 1
        L4d:
            if (r4 == r2) goto L5c
            goto L5b
        L50:
            r7 = move-exception
            throw r7
        L52:
            r4 = r8
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch: java.lang.Exception -> L7f
            int r4 = r4.length()
            if (r4 <= 0) goto L5c
        L5b:
            r1 = 1
        L5c:
            if (r1 == 0) goto L81
            int r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 25
            int r2 = r1 % 128
            id.dana.wallet_v3.view.search.view.WalletSearchFragment.scheduleImpl = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L77
            id.dana.wallet_v3.tracker.WalletV3TrackerImpl r1 = r6.getWalletV3TrackerImplementation()
            r1.trackSearchBarSubmit(r7, r8, r0)
            r3.hashCode()     // Catch: java.lang.Throwable -> L75
            goto L81
        L75:
            r7 = move-exception
            throw r7
        L77:
            id.dana.wallet_v3.tracker.WalletV3TrackerImpl r1 = r6.getWalletV3TrackerImplementation()     // Catch: java.lang.Exception -> L7f
            r1.trackSearchBarSubmit(r7, r8, r0)     // Catch: java.lang.Exception -> L7f
            goto L81
        L7f:
            r7 = move-exception
            throw r7
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.view.WalletSearchFragment.trackSearchSubmit(java.lang.String, java.lang.String):void");
    }

    private final void trackSearchPageOpen() {
        String str = this.pageSource;
        if ((str != null ? ')' : '5') != ')') {
            return;
        }
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        getWalletV3TrackerImplementation().trackOpenSearchBar(str);
        int i3 = scheduleImpl + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void disableSwipe() {
        HomeTabActivity homeTabActivity;
        FragmentActivity activity = getActivity();
        if (!(activity instanceof HomeTabActivity)) {
            homeTabActivity = null;
        } else {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 67;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            homeTabActivity = (HomeTabActivity) activity;
        }
        if (!(homeTabActivity == null)) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
            scheduleImpl = i3 % 128;
            if (i3 % 2 != 0) {
                homeTabActivity.setSwipeable(true);
            } else {
                homeTabActivity.setSwipeable(false);
            }
        }
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
        scheduleImpl = i4 % 128;
        int i5 = i4 % 2;
    }

    private final void onCancelOrBackPressed() {
        int i = scheduleImpl + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        backToNewWalletFragment(parentFragmentManager);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void trackServiceOpen(ThirdPartyService it) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
        scheduleImpl = i % 128;
        if (i % 2 != 0) {
            ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            try {
                ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/wallet_v3/view/search/view/WalletSearchFragment$Companion;", "", "", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "searchBarHint", "accessToken", WalletConstant.KYC_LEVEL, "Lid/dana/wallet_v3/view/search/view/WalletSearchFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/view/search/view/WalletSearchFragment;", "LANGUAGE_IN", "Ljava/lang/String;", "PAGE_SOURCE", WalletSearchFragment.SEARCH_BAR_HINT, "TRIGGER_SOURCE_BUBBLE", "TRIGGER_SOURCE_USER_TYPING", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ WalletSearchFragment newInstance$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            return companion.newInstance(str, str2, str3, str4);
        }

        public final WalletSearchFragment newInstance(String pageSource, String searchBarHint, String accessToken, String kycLevel) {
            Intrinsics.checkNotNullParameter(pageSource, "");
            Bundle bundle = new Bundle();
            bundle.putString("PAGE_SOURCE", pageSource);
            bundle.putString(WalletSearchFragment.SEARCH_BAR_HINT, searchBarHint);
            bundle.putString(WalletConstant.ACCESS_TOKEN, accessToken);
            bundle.putString(WalletConstant.KYC_LEVEL_BUNDLE, kycLevel);
            WalletSearchFragment walletSearchFragment = new WalletSearchFragment();
            walletSearchFragment.setArguments(bundle);
            return walletSearchFragment;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        char[] cArr2;
        char[] cArr3;
        int length;
        char[] cArr4;
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        try {
            char[] cArr5 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (cArr5 != null) {
                int i3 = $10 + 61;
                $11 = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 29 : (char) 16) != 29) {
                    length = cArr5.length;
                    cArr4 = new char[length];
                    i2 = 0;
                } else {
                    length = cArr5.length;
                    cArr4 = new char[length];
                    i2 = 1;
                }
                while (i2 < length) {
                    cArr4[i2] = (char) (cArr5[i2] ^ 4571606982258105150L);
                    i2++;
                }
                cArr5 = cArr4;
            }
            int i4 = (int) (4571606982258105150L ^ MyBillsEntityDataFactory);
            if (lookAheadTest) {
                int i5 = $10 + 37;
                try {
                    $11 = i5 % 128;
                    if (i5 % 2 == 0) {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                        cArr3 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 1;
                    } else {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                        cArr3 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    }
                    while (true) {
                        if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                            objArr[0] = new String(cArr3);
                            return;
                        }
                        int i6 = $11 + 93;
                        $10 = i6 % 128;
                        if (i6 % 2 != 0) {
                            cArr3[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr5[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult >>> 0) + bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] << i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory += 0;
                        } else {
                            cArr3[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr5[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } else if (PlaceComponentResult) {
                int i7 = $11 + 121;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                    cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 1;
                } else {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                    cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                }
                while (true) {
                    if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        objArr[0] = new String(cArr2);
                        return;
                    }
                    int i8 = $11 + 123;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr2[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr5[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                        objArr[0] = new String(cArr6);
                        return;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr5[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
