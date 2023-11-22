package id.dana.cashier.fragment;

import android.animation.Animator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.cashier.CashierBannerContract;
import id.dana.cashier.CashierBannerModule;
import id.dana.cashier.CashierCardBindingContract;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierFeedContract;
import id.dana.cashier.CashierFeedModule;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.GlobalNetworkViewListener;
import id.dana.cashier.PayResultContract;
import id.dana.cashier.bottomsheet.CashierShareBottomSheetDialog;
import id.dana.cashier.domain.interactor.AddAssetCardForUser;
import id.dana.cashier.domain.model.FetchBannerInfo;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment;
import id.dana.cashier.helper.CashierVariables;
import id.dana.cashier.helper.CreateInvoiceHelper;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.FetchBannerModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.ProcessingStatus;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.cashier.model.constants.PaymentResultBackToHomeStatus;
import id.dana.cashier.model.npssurvey.NpsSurveyModel;
import id.dana.cashier.model.npssurvey.NpsSurveyRequestModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitRequestModel;
import id.dana.cashier.presenter.CashierCardBindingPresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.utils.PaymentExecutionTimeUtil;
import id.dana.cashier.view.CashierPaymentResultAnimationView;
import id.dana.cashier.view.DiscreteSurveySlider;
import id.dana.cashier.view.NpsSurveyView;
import id.dana.cashier.view.TryAgainPayResultView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.deeplink.DeepLinkCallback;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PayResultModule;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.expresspurchase.di.ExpressPurchaseModule;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.expresspurchase.view.ExpressPurchaseActivity;
import id.dana.familyaccount.view.summary.OrganizerSummaryActivity;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.lib.drawbitmap.invoice.CreateInvoiceResultHandler;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.model.DeepLinkPayloadModel;
import id.dana.model.ThirdPartyService;
import id.dana.pay.PayActivity;
import id.dana.richview.LogoProgressView;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.utils.FeedUtils;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.SizeUtil;
import id.dana.utils.TagFormat;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.rpc.response.DefaultResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u009f\u0001\u0018\u0000 \u0090\u00022\u00020\u0001:\u0004\u008f\u0002\u0090\u0002B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0082\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0083\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0084\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0085\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0086\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0087\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0088\u0001\u001a\u00030\u0081\u0001H\u0002J\u0014\u0010\u0089\u0001\u001a\u00030\u0081\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u008c\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u008d\u0001\u001a\u00030\u0081\u0001H\u0002J\u0011\u0010\u008e\u0001\u001a\u00020[2\u0006\u0010e\u001a\u00020fH\u0002J\n\u0010\u008f\u0001\u001a\u00030\u0081\u0001H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\u00042\u0007\u0010\u0091\u0001\u001a\u00020\u0004H\u0002J\n\u0010\u0092\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0094\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0096\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020[H\u0002J\u001d\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u009a\u0001\u001a\u00020[2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u009d\u0001\u001a\u00020\u00042\u0007\u0010\u009a\u0001\u001a\u00020[H\u0002J\u0010\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002¢\u0006\u0003\u0010 \u0001J\n\u0010¡\u0001\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010¢\u0001\u001a\u00030\u0081\u00012\b\u0010e\u001a\u0004\u0018\u00010fH\u0002J\n\u0010£\u0001\u001a\u00030\u0099\u0001H\u0014J\u0013\u0010¤\u0001\u001a\u00030\u0081\u00012\u0007\u0010¥\u0001\u001a\u00020\u0004H\u0002J\u0014\u0010¦\u0001\u001a\u00020\u00042\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\t\u0010¨\u0001\u001a\u00020\u0004H\u0002J\n\u0010©\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010«\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010¬\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010\u00ad\u0001\u001a\u00030\u0081\u0001H\u0014J\n\u0010®\u0001\u001a\u00030\u0081\u0001H\u0014J\n\u0010¯\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010°\u0001\u001a\u00030\u0081\u0001H\u0014J\t\u0010±\u0001\u001a\u00020[H\u0002J\t\u0010²\u0001\u001a\u00020[H\u0002J\t\u0010³\u0001\u001a\u00020[H\u0002J\t\u0010´\u0001\u001a\u00020[H\u0002J\n\u0010µ\u0001\u001a\u00030\u0081\u0001H\u0002J\t\u0010¶\u0001\u001a\u00020[H\u0016J\u0013\u0010·\u0001\u001a\u00030\u0081\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J\n\u0010¹\u0001\u001a\u00030\u0081\u0001H\u0016J\n\u0010º\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010»\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010¼\u0001\u001a\u00030\u0081\u0001H\u0014J\n\u0010½\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010¾\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030\u0081\u0001H\u0002J\u0014\u0010À\u0001\u001a\u00030\u0081\u00012\b\u0010Á\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030\u0081\u0001H\u0002J\u0014\u0010Å\u0001\u001a\u00030\u0081\u00012\b\u0010e\u001a\u0004\u0018\u00010fH\u0002J\n\u0010Æ\u0001\u001a\u00030\u0081\u0001H\u0002J\u001b\u0010Ç\u0001\u001a\u00030\u0081\u00012\u000f\u0010È\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010É\u0001H\u0002J\u0017\u0010Ê\u0001\u001a\u00030\u0081\u00012\u000b\b\u0003\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010Ì\u0001\u001a\u00030\u0081\u00012\b\u0010Í\u0001\u001a\u00030\u0099\u0001H\u0002J\u0013\u0010Î\u0001\u001a\u00030\u0081\u00012\u0007\u0010Ï\u0001\u001a\u00020[H\u0002J\n\u0010Ð\u0001\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010Ñ\u0001\u001a\u00030\u0081\u00012\u0007\u0010¥\u0001\u001a\u00020\u0004H\u0002J\n\u0010Ò\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010Ó\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010Ô\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010Õ\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010Ö\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010×\u0001\u001a\u00030\u0081\u0001H\u0002J\u0014\u0010Ø\u0001\u001a\u00030\u0081\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010Û\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030\u0081\u0001H\u0002J\u001e\u0010Ý\u0001\u001a\u00030\u0081\u00012\u0007\u0010Þ\u0001\u001a\u00020\u00042\t\u0010ß\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010à\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010á\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010â\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010ã\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010ä\u0001\u001a\u00030\u0081\u0001H\u0002J \u0010å\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009a\u0001\u001a\u00020[2\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010æ\u0001\u001a\u00030\u0081\u00012\t\b\u0002\u0010ç\u0001\u001a\u00020\u00042\t\b\u0002\u0010è\u0001\u001a\u00020\u0004H\u0002J\u0014\u0010é\u0001\u001a\u00030\u0081\u00012\b\u0010ê\u0001\u001a\u00030ë\u0001H\u0002J\n\u0010ì\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010í\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010î\u0001\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010ï\u0001\u001a\u00030\u0081\u00012\u0007\u0010ð\u0001\u001a\u00020[H\u0002J\n\u0010ñ\u0001\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010ò\u0001\u001a\u00030\u0081\u00012\u0007\u0010ó\u0001\u001a\u00020\u0004H\u0002J\n\u0010ô\u0001\u001a\u00030\u0081\u0001H\u0002J\u0015\u0010ô\u0001\u001a\u00030\u0081\u00012\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010ö\u0001\u001a\u00030\u0081\u0001H\u0002J\n\u0010÷\u0001\u001a\u00030\u0081\u0001H\u0002J/\u0010ø\u0001\u001a\u00030\u0081\u0001*\u0005\u0018\u00010ù\u00012\t\b\u0002\u0010ú\u0001\u001a\u00020[2\u0011\b\u0002\u0010û\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010É\u0001H\u0002J/\u0010ü\u0001\u001a\u00030\u0081\u0001*\u0005\u0018\u00010ù\u00012\t\b\u0002\u0010ú\u0001\u001a\u00020[2\u0011\b\u0002\u0010û\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010É\u0001H\u0002J\u0011\u0010ý\u0001\u001a\u0005\u0018\u00010þ\u0001*\u00030Ú\u0001H\u0002J\u0013\u0010ÿ\u0001\u001a\b0\u0080\u0002j\u0003`\u0081\u0002*\u00020\u0004H\u0002J%\u0010\u0082\u0002\u001a\u00030\u0081\u0001*\u00030\u0083\u00022\u0007\u0010\u0091\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0004H\u0002J\u0011\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0086\u0002*\u00030\u0087\u0002H\u0002J\u000f\u0010\u0088\u0002\u001a\u00030\u0081\u0001*\u00030\u0089\u0002H\u0002J;\u0010\u008a\u0002\u001a\u00030\u0081\u0001*\u0005\u0018\u00010ù\u00012\n\b\u0001\u0010\u008b\u0002\u001a\u00030\u0099\u00012\t\b\u0002\u0010ú\u0001\u001a\u00020[2\u0011\b\u0002\u0010û\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010É\u0001H\u0002J\u000f\u0010\u008c\u0002\u001a\u00030\u0081\u0001*\u00030ù\u0001H\u0002J\u000f\u0010\u008d\u0002\u001a\u00030\u0081\u0001*\u00030\u0087\u0002H\u0002J\u000f\u0010\u008e\u0002\u001a\u00030\u0081\u0001*\u00030ù\u0001H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u00020:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020F8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001e\u0010I\u001a\u00020J8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020P8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u00108\u001a\u0004\ba\u0010bR\u000e\u0010d\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010e\u001a\u0004\u0018\u00010f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u00108\u001a\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u001e\u0010n\u001a\u00020o8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0014\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00040uX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010v\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u00108\u001a\u0004\bw\u0010xR\u001e\u0010z\u001a\u00020{8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007f¨\u0006\u0091\u0002"}, d2 = {"Lid/dana/cashier/fragment/PaymentResultFragment;", "Lid/dana/cashier/fragment/BaseCashierFragment;", "()V", "bannerName", "", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "getCashierAnalyticTracker", "()Lid/dana/cashier/tracker/CashierAnalyticTracker;", "setCashierAnalyticTracker", "(Lid/dana/cashier/tracker/CashierAnalyticTracker;)V", "cashierBannerModule", "Lid/dana/cashier/CashierBannerModule;", "getCashierBannerModule", "()Lid/dana/cashier/CashierBannerModule;", "cashierBannerPresenter", "Lid/dana/cashier/CashierBannerContract$Presenter;", "getCashierBannerPresenter", "()Lid/dana/cashier/CashierBannerContract$Presenter;", "setCashierBannerPresenter", "(Lid/dana/cashier/CashierBannerContract$Presenter;)V", "cashierCardBindingModule", "Lid/dana/cashier/CashierCardBindingModule;", "getCashierCardBindingModule", "()Lid/dana/cashier/CashierCardBindingModule;", "cashierCardBindingPresenter", "Lid/dana/cashier/presenter/CashierCardBindingPresenter;", "getCashierCardBindingPresenter", "()Lid/dana/cashier/presenter/CashierCardBindingPresenter;", "setCashierCardBindingPresenter", "(Lid/dana/cashier/presenter/CashierCardBindingPresenter;)V", "cashierFeedModule", "Lid/dana/cashier/CashierFeedModule;", "getCashierFeedModule", "()Lid/dana/cashier/CashierFeedModule;", "cashierFeedPresenter", "Lid/dana/cashier/CashierFeedContract$Presenter;", "getCashierFeedPresenter", "()Lid/dana/cashier/CashierFeedContract$Presenter;", "setCashierFeedPresenter", "(Lid/dana/cashier/CashierFeedContract$Presenter;)V", "cashierPayLaterModule", "Lid/dana/cashier/CashierPayLaterModule;", "getCashierPayLaterModule", "()Lid/dana/cashier/CashierPayLaterModule;", "cashierPayLaterPresenter", "Lid/dana/cashier/CashierPayLaterContract$Presenter;", "getCashierPayLaterPresenter", "()Lid/dana/cashier/CashierPayLaterContract$Presenter;", "setCashierPayLaterPresenter", "(Lid/dana/cashier/CashierPayLaterContract$Presenter;)V", "cashierResultBannerListener", "Lid/dana/cashier/fragment/PaymentResultFragment$CashierResultBannerListener;", "getCashierResultBannerListener", "()Lid/dana/cashier/fragment/PaymentResultFragment$CashierResultBannerListener;", "cashierResultBannerListener$delegate", "Lkotlin/Lazy;", "cashierUserRelatedModule", "Lid/dana/cashier/CashierUserRelatedModule;", "getCashierUserRelatedModule", "()Lid/dana/cashier/CashierUserRelatedModule;", "cashierUserRelatedPresenter", "Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "getCashierUserRelatedPresenter", "()Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "setCashierUserRelatedPresenter", "(Lid/dana/cashier/CashierUserRelatedContract$Presenter;)V", "countDownTimer", "Landroid/os/CountDownTimer;", "expressPurchaseModule", "Lid/dana/expresspurchase/di/ExpressPurchaseModule;", "getExpressPurchaseModule", "()Lid/dana/expresspurchase/di/ExpressPurchaseModule;", "expressPurchasePresenter", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "getExpressPurchasePresenter", "()Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "setExpressPurchasePresenter", "(Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;)V", "globalNetworkModule", "Lid/dana/di/modules/GlobalNetworkModule;", "getGlobalNetworkModule", "()Lid/dana/di/modules/GlobalNetworkModule;", "globalNetworkPresenter", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "getGlobalNetworkPresenter", "()Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "setGlobalNetworkPresenter", "(Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;)V", "invoiceFilePath", "isBannerClicked", "", "isBannerDeeplink", "isBannerShow", "isSendMoneyTransaction", "isShowingEpDeals", "isSuccessAnimationFinish", "isSuccessOrInnerRedirect", "()Z", "isSuccessOrInnerRedirect$delegate", "isSurveyShow", CashierKeyParams.PAY_RESULT_MODEL, "Lid/dana/cashier/model/PayResultModel;", "getPayResultModel", "()Lid/dana/cashier/model/PayResultModel;", "payResultModel$delegate", "payResultModule", "Lid/dana/di/modules/PayResultModule;", "getPayResultModule", "()Lid/dana/di/modules/PayResultModule;", "payResultPresenter", "Lid/dana/cashier/PayResultContract$Presenter;", "getPayResultPresenter", "()Lid/dana/cashier/PayResultContract$Presenter;", "setPayResultPresenter", "(Lid/dana/cashier/PayResultContract$Presenter;)V", "paymentSelectMethods", "", "paymentStatus", "getPaymentStatus", "()Ljava/lang/String;", "paymentStatus$delegate", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadDeepLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadDeepLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "activateLabelIndicator", "", "animateBannerSurvey", "animateBasicTransition", "animateBottomSection", "animateShowBannerOnly", "animateShowBannerSurvey", "animateShowSurveyOnly", "animateSuccessResult", "backToHomeWithBundle", HummerConstants.BUNDLE, "Landroid/os/Bundle;", "buildShareableInvoice", "checkPaymentStatusByBizOrderId", "checkTryAgainPaymentFailed", "configToolbar", "constructX2pTransactionName", "orderTitle", "disableShareButton", "disableShareToFeedButton", "enableShareToFeedButton", "endAnimationState", "fetchBanner", "fetchNpsSurvey", "getAddCardDialogIcon", "", TrackerKey.Property.IS_SUCCESS, "getAddCardDialogMessage", "errorMessage", "getAddCardDialogTitle", "getDeeplinkCallback", "id/dana/cashier/fragment/PaymentResultFragment$getDeeplinkCallback$1", "()Lid/dana/cashier/fragment/PaymentResultFragment$getDeeplinkCallback$1;", "getDeeplinkPaymentBundleData", "getExpressPurchaseOffer", "getLayout", "getOnClickBannerListener", "redirectUrl", "getPayStatus", "status", "getTitle", "getTransactionSuccessBundleData", "handleDanaKagetSharePage", "handleResultInfo", "handleTimer", IAPSyncCommand.COMMAND_INIT, "initComponent", "initSliderLabelListener", "initViews", "isFromDeeplinkPayment", "isFromMiniProgram", "isNeedToShowTimer", "isSendMoney", "navigateToFeed", "onBackPressed", "onClickCopyVa", "vaNumber", "onDestroyView", "openShareBottomSheet", "playSuccessSound", "prepareBundle", "processEventCheckoutFinish", "redirectToPayConfirmationPage", "reloadBalanceIfNeeded", "renderNpsSurvey", "npsSurveyModel", "Lid/dana/cashier/model/npssurvey/NpsSurveyModel;", "renderViewTryAgain", "saveShareFeedRequestId", "saveSuccessExpressPurchaseAction", "setBannerMarginTop", "setBannerOnClickListener", "onClickListener", "Lkotlin/Function0;", "setBasePaymentStatus", "sendPaymentStatus", "setIndicatorLabelPosition", "progress", "setNeedBackHomeOnDestroy", "isNeedToBackHome", "setOnClickBillerReminderRuleBanner", "setOnClickCommonRuleBanner", "setOnClickDone", "setOnClickEMoneyRuleBanner", "setOnClickSavingCardRuleBanner", "setOnClickSeeDetail", "setOnClickShareButton", "setOnClickSplitBillRuleBanner", "setPaymentSelectMethods", "selectedPaymentMethod", "Lid/dana/cashier/model/CashierPayMethodModel;", "setupAdditionalInfo", "setupAnimationWhenSuccessBanner", "setupBannerCtaButton", "htmlString", "bannerType", "setupLottie", "setupShareButton", "setupViewOnPaymentFailed", "setupViewOnPaymentProcessing", "setupViewOnPaymentRedirect", "showAddAssetCardDialog", "showAdditionalInfo", InvoiceConstant.HEADER, "content", "showAndStartTimer", "milestoneEnd", "", "showBottomSection", "showGuide", "startInnerRedirect", "toggleBtnShareLoading", GriverMonitorConstants.KEY_IS_LOADING, "trackPaymentResult", "trackPaymentResultAction", "actionType", "trackPaymentTryAgainAction", CashierKeyParams.CASHIER_ORDER_ID, "triggerTradePayCallback", "updatePayLaterLoanCache", "animateSlideDown", "Landroid/view/View;", "isVisibleOnStart", "onEnd", "animateSlideUp", "buildDialogParams", "Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment$Params;", "constructBankVaAgentNo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "constructTransactionName", "Landroid/widget/TextView;", "groupName", "getImageBannerByType", "", "Lid/dana/cashier/model/FetchBannerModel;", "initOnClickSubmitSurveyListener", "Lid/dana/cashier/view/NpsSurveyView;", "playAnimation", "animationResId", "removeMarginTopOnGone", "renderBanner", "setMarginTopOnVisible", "CashierResultBannerListener", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaymentResultFragment extends BaseCashierFragment {
    public static final Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion(null);
    private boolean DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private boolean PrepareContext;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierBannerContract.Presenter cashierBannerPresenter;
    @Inject
    public CashierCardBindingPresenter cashierCardBindingPresenter;
    @Inject
    public CashierFeedContract.Presenter cashierFeedPresenter;
    @Inject
    public CashierPayLaterContract.Presenter cashierPayLaterPresenter;
    @Inject
    public CashierUserRelatedContract.Presenter cashierUserRelatedPresenter;
    @Inject
    public ExpressPurchaseContract.Presenter expressPurchasePresenter;
    @Inject
    public GlobalNetworkContract.Presenter globalNetworkPresenter;
    private CountDownTimer initRecordTimeStamp;
    private boolean newProxyInstance;
    @Inject
    public PayResultContract.Presenter payResultPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    private final List<String> NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayList();
    private final Lazy FragmentBottomSheetPaymentSettingBinding = LazyKt.lazy(new Function0<PayResultModel>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$payResultModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PayResultModel invoke() {
            Bundle arguments = PaymentResultFragment.this.getArguments();
            if (arguments != null) {
                return (PayResultModel) arguments.getParcelable("arg_pay_result_model");
            }
            return null;
        }
    });
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda5 = LazyKt.lazy(new Function0<String>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$paymentStatus$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String str;
            String str2;
            PayResultModel NetworkUserEntityData$$ExternalSyntheticLambda8 = PaymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(PaymentResultFragment.this);
            if (NetworkUserEntityData$$ExternalSyntheticLambda8 == null || (str2 = NetworkUserEntityData$$ExternalSyntheticLambda8.getValueOfTouchPositionAbsolute) == null) {
                str = null;
            } else {
                str = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "");
            }
            return str == null ? "" : str;
        }
    });
    private final Lazy isLayoutRequested = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$isSuccessOrInnerRedirect$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(Intrinsics.areEqual(PaymentResultFragment.newProxyInstance(PaymentResultFragment.this), "success") || Intrinsics.areEqual(PaymentResultFragment.newProxyInstance(PaymentResultFragment.this), ProcessingStatus.INNER_REDIRECT_STATUS));
        }
    });
    private final Lazy moveToNextValue = LazyKt.lazy(new Function0<CashierResultBannerListener>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$cashierResultBannerListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaymentResultFragment.CashierResultBannerListener invoke() {
            BaseActivity baseActivity = PaymentResultFragment.this.getBaseActivity();
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null) {
                return payActivity.createCashierResultBannerListener();
            }
            return null;
        }
    });
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/fragment/PaymentResultFragment$CashierResultBannerListener;", "", "", "p0", "", "getAuthRequestContext", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface CashierResultBannerListener {
        void getAuthRequestContext(boolean p0);
    }

    public static /* synthetic */ void getCallingPid() {
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_payment_result;
    }

    @JvmName(name = "isSuccessOrInnerRedirect")
    private final boolean VerifyPinStateManager$executeRiskChallenge$2$2() {
        return ((Boolean) this.isLayoutRequested.getValue()).booleanValue();
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment
    public final void init() {
        boolean z;
        PaymentExecutionTimeUtil paymentExecutionTimeUtil = PaymentExecutionTimeUtil.INSTANCE;
        if (!PaymentExecutionTimeUtil.getAuthRequestContext()) {
            CashierVariables cashierVariables = CashierVariables.INSTANCE;
            z = CashierVariables.MyBillsEntityDataFactory;
            if (!z && !NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                BaseActivity baseActivity = getBaseActivity();
                if (baseActivity != null) {
                    baseActivity.finish();
                    return;
                }
                return;
            }
        }
        super.init();
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void PlaceComponentResult() {
        String str;
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            PayResultModule payResultModule = new PayResultModule(new PayResultContract.View() { // from class: id.dana.cashier.fragment.PaymentResultFragment$payResultModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                }

                @Override // id.dana.cashier.PayResultContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends CashierPayMethodModel> p0) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(p0, "");
                    TryAgainPayResultView tryAgainPayResultView = (TryAgainPayResultView) PaymentResultFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.ItemBillPaymentConfirmationBinding);
                    if (tryAgainPayResultView != null) {
                        tryAgainPayResultView.setPayMethodModels(p0);
                    }
                    z = PaymentResultFragment.this.newProxyInstance;
                    if (z || PaymentResultFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                        return;
                    }
                    PaymentResultFragment.FragmentBottomSheetPaymentSettingBinding(PaymentResultFragment.this);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    PaymentResultFragment.this.readMicros();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                    PaymentResultFragment.this.scheduleImpl();
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getBaseActivity();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = "Deeplink";
            KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2 = new DeepLinkCallback() { // from class: id.dana.cashier.fragment.PaymentResultFragment$getDeeplinkCallback$1
                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkPayloadModel p0) {
                }

                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void getAuthRequestContext() {
                    boolean z;
                    BaseActivity baseActivity;
                    z = PaymentResultFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (!z || (baseActivity = PaymentResultFragment.this.getBaseActivity()) == null) {
                        return;
                    }
                    baseActivity.finish();
                }

                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void PlaceComponentResult(String p0) {
                    PaymentResultFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                }
            };
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
            ScanQrModule scanQrModule = new ScanQrModule(authRequestContext, b);
            Intrinsics.checkNotNullExpressionValue(scanQrModule, "");
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getBaseActivity();
            RestoreUrlModule restoreUrlModule = new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b);
            Intrinsics.checkNotNullExpressionValue(restoreUrlModule, "");
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            FeatureModule featureModule = new FeatureModule(MyBillsEntityDataFactory, b);
            Intrinsics.checkNotNullExpressionValue(featureModule, "");
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            OauthModule oauthModule = new OauthModule(BuiltInFictitiousFunctionClassFactory, b);
            Intrinsics.checkNotNullExpressionValue(oauthModule, "");
            str = "";
            socialCommonComponent.KClassImpl$Data$declaredNonStaticMembers$2(payResultModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.cashier.fragment.PaymentResultFragment$initComponent$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionFailed(String str2) {
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
                public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str2) {
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
                public final /* synthetic */ void onError(String str2) {
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
            }), new ExpressPurchaseModule(new ExpressPurchaseContract.View() { // from class: id.dana.cashier.fragment.PaymentResultFragment$expressPurchaseModule$1
                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str2, ExpressPurchaseModel.Deals deals) {
                    ExpressPurchaseContract.View.CC.getAuthRequestContext(str2, deals);
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str2, ExpressPurchaseModel.Gold gold, List list, Map map, String str3) {
                    ExpressPurchaseContract.View.CC.MyBillsEntityDataFactory(str2, gold, list, map, str3);
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str2, String str3, String str4, ExpressPurchaseModel expressPurchaseModel) {
                    ExpressPurchaseContract.View.CC.getAuthRequestContext(str2, str3);
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                    ExpressPurchaseContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(DealsShopInfo dealsShopInfo) {
                    ExpressPurchaseContract.View.CC.getAuthRequestContext(dealsShopInfo);
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(String str2, ExpressPurchaseModel.Deals deals) {
                    ExpressPurchaseContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2(str2, deals);
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void PlaceComponentResult() {
                    ExpressPurchaseContract.View.CC.getAuthRequestContext();
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void PlaceComponentResult(String str2, ExpressPurchaseModel.Deals deals) {
                    ExpressPurchaseContract.View.CC.PlaceComponentResult(str2, deals);
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void PlaceComponentResult(String str2, String str3, ExpressPurchaseModel.Deals deals) {
                    ExpressPurchaseContract.View.CC.getAuthRequestContext(str2, str3, deals);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void getAuthRequestContext() {
                    ExpressPurchaseContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final /* synthetic */ void getAuthRequestContext(boolean z, String str2, ExpressPurchaseModel.Gold gold) {
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(str2, gold);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str2) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ExpressPurchaseActivity.Companion companion = ExpressPurchaseActivity.INSTANCE;
                    BaseActivity baseActivity = PaymentResultFragment.this.getBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                    Intrinsics.checkNotNullParameter(baseActivity, "");
                    Intrinsics.checkNotNullParameter(p0, "");
                    baseActivity.startActivity(ExpressPurchaseActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, p0));
                    if (p0 instanceof ExpressPurchaseModel.Deals) {
                        PaymentResultFragment.this.PrepareContext = true;
                        PaymentResultFragment.MyBillsEntityDataFactory(PaymentResultFragment.this, false);
                        PaymentResultFragment.this.getBaseActivity().finish();
                    }
                }
            }), new GlobalNetworkModule(new GlobalNetworkViewListener()), new CashierCardBindingModule(new CashierCardBindingContract.View() { // from class: id.dana.cashier.fragment.PaymentResultFragment$cashierCardBindingModule$1
                @Override // id.dana.cashier.CashierCardBindingContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                }

                @Override // id.dana.cashier.CashierCardBindingContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(QueryCardPolicyInfoModel p0, String p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                }

                @Override // id.dana.cashier.CashierCardBindingContract.View
                public final void MyBillsEntityDataFactory(Throwable p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.cashier.CashierCardBindingContract.View
                public final void PlaceComponentResult(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
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
                public final /* synthetic */ void onError(String str2) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.cashier.CashierCardBindingContract.View
                public final void PlaceComponentResult() {
                    PaymentResultFragment.this.BuiltInFictitiousFunctionClassFactory(true, (String) null);
                }

                @Override // id.dana.cashier.CashierCardBindingContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                    PaymentResultFragment.this.BuiltInFictitiousFunctionClassFactory(false, p0);
                }
            }), new CashierBannerModule(new CashierBannerContract.View() { // from class: id.dana.cashier.fragment.PaymentResultFragment$cashierBannerModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str2) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.cashier.CashierBannerContract.View
                public final void getAuthRequestContext(FetchBannerModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PaymentResultFragment paymentResultFragment = PaymentResultFragment.this;
                    Boolean bool = p0.scheduleImpl;
                    Boolean bool2 = Boolean.TRUE;
                    paymentResultFragment.GetContactSyncConfig = Intrinsics.areEqual(bool, bool2);
                    if (Intrinsics.areEqual(p0.scheduleImpl, bool2)) {
                        PaymentResultFragment.BuiltInFictitiousFunctionClassFactory(PaymentResultFragment.this, p0);
                        PaymentResultFragment.SubSequence(PaymentResultFragment.this);
                        return;
                    }
                    PaymentResultFragment.DatabaseTableConfigUtil(PaymentResultFragment.this);
                    PaymentResultFragment.readMicros(PaymentResultFragment.this);
                }

                @Override // id.dana.cashier.CashierBannerContract.View
                public final void PlaceComponentResult(NpsSurveyModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PaymentResultFragment paymentResultFragment = PaymentResultFragment.this;
                    Boolean bool = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    Boolean bool2 = Boolean.TRUE;
                    paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda7 = Intrinsics.areEqual(bool, bool2);
                    if (Intrinsics.areEqual(p0.KClassImpl$Data$declaredNonStaticMembers$2, bool2)) {
                        PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment.this, p0);
                    }
                    PaymentResultFragment.moveToNextValue(PaymentResultFragment.this);
                }

                @Override // id.dana.cashier.CashierBannerContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    PaymentResultFragment.DatabaseTableConfigUtil(PaymentResultFragment.this);
                    PaymentResultFragment.readMicros(PaymentResultFragment.this);
                }

                @Override // id.dana.cashier.CashierBannerContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    PaymentResultFragment.moveToNextValue(PaymentResultFragment.this);
                }
            }), new CashierFeedModule(new CashierFeedContract.View() { // from class: id.dana.cashier.fragment.PaymentResultFragment$cashierFeedModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str2) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.cashier.CashierFeedContract.View
                public final void getAuthRequestContext(PreviewActivityData p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.getShareable()) {
                        PaymentResultFragment.initRecordTimeStamp(PaymentResultFragment.this);
                    }
                }

                @Override // id.dana.cashier.CashierFeedContract.View
                public final void MyBillsEntityDataFactory() {
                    PaymentResultFragment.GetContactSyncConfig(PaymentResultFragment.this);
                }
            }), new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$cashierUserRelatedModule$1
            }), new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$cashierPayLaterModule$1
            })).getAuthRequestContext(this);
        } else {
            str = "";
        }
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[9];
        PayResultContract.Presenter presenter = this.payResultPresenter;
        GlobalNetworkContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        ReadLinkPropertiesContract.Presenter presenter3 = this.readDeepLinkPropertiesPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            presenter3 = null;
        }
        abstractPresenterArr[1] = presenter3;
        ExpressPurchaseContract.Presenter presenter4 = this.expressPurchasePresenter;
        if (presenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            presenter4 = null;
        }
        abstractPresenterArr[2] = presenter4;
        CashierCardBindingPresenter cashierCardBindingPresenter = this.cashierCardBindingPresenter;
        if (cashierCardBindingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            cashierCardBindingPresenter = null;
        }
        abstractPresenterArr[3] = cashierCardBindingPresenter;
        CashierFeedContract.Presenter presenter5 = this.cashierFeedPresenter;
        if (presenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            presenter5 = null;
        }
        abstractPresenterArr[4] = presenter5;
        CashierPayLaterContract.Presenter presenter6 = this.cashierPayLaterPresenter;
        if (presenter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            presenter6 = null;
        }
        abstractPresenterArr[5] = presenter6;
        CashierUserRelatedContract.Presenter presenter7 = this.cashierUserRelatedPresenter;
        if (presenter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            presenter7 = null;
        }
        abstractPresenterArr[6] = presenter7;
        CashierBannerContract.Presenter presenter8 = this.cashierBannerPresenter;
        if (presenter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            presenter8 = null;
        }
        abstractPresenterArr[7] = presenter8;
        GlobalNetworkContract.Presenter presenter9 = this.globalNetworkPresenter;
        if (presenter9 != null) {
            presenter2 = presenter9;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        abstractPresenterArr[8] = presenter2;
        registerPresenter(abstractPresenterArr);
    }

    @Override // id.dana.base.BaseFragment
    public final boolean onBackPressed() {
        getBaseActivity().finish();
        return true;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void moveToNextValue() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.getBoolean("reloadBalance")) {
            return;
        }
        CashierUserRelatedContract.Presenter presenter = this.cashierUserRelatedPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.isRestore2DEnabled);
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.forceSuggestionQuery);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        this.initRecordTimeStamp = new CountDownTimer(j - DateTimeUtil.BuiltInFictitiousFunctionClassFactory()) { // from class: id.dana.cashier.fragment.PaymentResultFragment$showAndStartTimer$1
            @Override // android.os.CountDownTimer
            public final void onTick(long p0) {
                long j2 = p0 / 3600000;
                long j3 = p0 % 3600000;
                long j4 = j3 / 60000;
                long j5 = (j3 % 60000) / 1000;
                TextView textView3 = (TextView) this.BuiltInFictitiousFunctionClassFactory(R.id.forceSuggestionQuery);
                if (textView3 != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = this.getString(R.string.result_pending_timer);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j5)}, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    textView3.setText(format);
                }
            }

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                TextView textView3 = (TextView) this.BuiltInFictitiousFunctionClassFactory(R.id.forceSuggestionQuery);
                if (textView3 != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = this.getString(R.string.result_pending_timer);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    String format = String.format(string, Arrays.copyOf(new Object[]{0, 0, 0}, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    textView3.setText(format);
                }
            }
        }.start();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.tvPaymentResultAdditionalInfoHeader);
        if (textView != null) {
            textView.setText(str);
            TextView textView2 = textView;
            CharSequence text = textView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "");
            textView2.setVisibility(text.length() > 0 ? 0 : 8);
        }
        TextView textView3 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.tvPaymentResultAdditionalInfo);
        if (textView3 != null) {
            textView3.setText(str2);
            TextView textView4 = textView3;
            CharSequence text2 = textView3.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "");
            textView4.setVisibility(text2.length() > 0 ? 0 : 8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a03b4_access_getfeaturedbanklistadapter_p);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    private final void A() {
        CashierPaymentResultAnimationView cashierPaymentResultAnimationView = (CashierPaymentResultAnimationView) BuiltInFictitiousFunctionClassFactory(R.id.lavPaymentResult);
        if (cashierPaymentResultAnimationView != null) {
            BuiltInFictitiousFunctionClassFactory(cashierPaymentResultAnimationView, R.anim.f5062130772057, false, PaymentResultFragment$animateSlideUp$1.INSTANCE);
        }
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.tvTransactionName);
        if (textView != null) {
            BuiltInFictitiousFunctionClassFactory(textView, R.anim.f5062130772057, false, PaymentResultFragment$animateSlideUp$1.INSTANCE);
        }
        TextView textView2 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.BlockPair);
        if (textView2 != null) {
            BuiltInFictitiousFunctionClassFactory(textView2, R.anim.f5062130772057, false, PaymentResultFragment$animateSlideUp$1.INSTANCE);
        }
        TextView textView3 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.MerchantReviewFormAnalyticTracker);
        if (textView3 != null) {
            BuiltInFictitiousFunctionClassFactory(textView3, R.anim.f5062130772057, false, PaymentResultFragment$animateSlideUp$1.INSTANCE);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a03b4_access_getfeaturedbanklistadapter_p);
        if (constraintLayout != null) {
            BuiltInFictitiousFunctionClassFactory(constraintLayout, R.anim.f5062130772057, false, PaymentResultFragment$animateSlideUp$1.INSTANCE);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn);
        if (constraintLayout2 != null) {
            BuiltInFictitiousFunctionClassFactory(constraintLayout2, R.anim.f5062130772057, false, PaymentResultFragment$animateSlideUp$1.INSTANCE);
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.clShareToFeedBtn);
        if (constraintLayout3 != null) {
            BuiltInFictitiousFunctionClassFactory(constraintLayout3, R.anim.f5062130772057, false, PaymentResultFragment$animateSlideUp$1.INSTANCE);
        }
    }

    private final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        NpsSurveyView npsSurveyView;
        CashierPaymentResultAnimationView cashierPaymentResultAnimationView = (CashierPaymentResultAnimationView) BuiltInFictitiousFunctionClassFactory(R.id.lavPaymentResult);
        if (cashierPaymentResultAnimationView != null) {
            CashierPaymentResultAnimationView cashierPaymentResultAnimationView2 = cashierPaymentResultAnimationView;
            ViewExtKt.MyBillsEntityDataFactory(cashierPaymentResultAnimationView2, false, ViewExtKt.getAuthRequestContext(cashierPaymentResultAnimationView2), null, ViewExtKt.getAuthRequestContext(cashierPaymentResultAnimationView2), null, null, ViewExtKt.getAuthRequestContext(cashierPaymentResultAnimationView2), null, 1972);
        }
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.tvTransactionName);
        if (textView != null) {
            TextView textView2 = textView;
            ViewExtKt.MyBillsEntityDataFactory(textView2, false, ViewExtKt.getAuthRequestContext(textView2), null, null, (CashierPaymentResultAnimationView) BuiltInFictitiousFunctionClassFactory(R.id.lavPaymentResult), null, ViewExtKt.getAuthRequestContext(textView2), null, 1964);
        }
        TextView textView3 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.BlockPair);
        if (textView3 != null) {
            TextView textView4 = textView3;
            ViewExtKt.MyBillsEntityDataFactory(textView4, false, ViewExtKt.getAuthRequestContext(textView4), null, null, (TextView) BuiltInFictitiousFunctionClassFactory(R.id.tvTransactionName), null, ViewExtKt.getAuthRequestContext(textView4), null, 1964);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a03b4_access_getfeaturedbanklistadapter_p);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = constraintLayout;
            ViewExtKt.MyBillsEntityDataFactory(constraintLayout2, false, ViewExtKt.getAuthRequestContext(constraintLayout2), null, null, (TextView) BuiltInFictitiousFunctionClassFactory(R.id.BlockPair), null, ViewExtKt.getAuthRequestContext(constraintLayout2), null, 1964);
            id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(constraintLayout2, null, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), null, null, 13);
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn);
        if (constraintLayout3 != null) {
            ConstraintLayout constraintLayout4 = constraintLayout3;
            ViewExtKt.MyBillsEntityDataFactory(constraintLayout4, false, ViewExtKt.getAuthRequestContext(constraintLayout4), null, null, (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a03b4_access_getfeaturedbanklistadapter_p), (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.clShareToFeedBtn), ViewExtKt.getAuthRequestContext(constraintLayout4), null, 1932);
            id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(constraintLayout4, null, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), null, null, 13);
        }
        ConstraintLayout constraintLayout5 = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.clShareToFeedBtn);
        if (constraintLayout5 != null) {
            ConstraintLayout constraintLayout6 = constraintLayout5;
            ViewExtKt.MyBillsEntityDataFactory(constraintLayout6, false, null, (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn), null, (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a03b4_access_getfeaturedbanklistadapter_p), null, ViewExtKt.getAuthRequestContext(constraintLayout6), null, 1962);
            id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(constraintLayout6, null, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), null, null, 13);
        }
        ConstraintLayout constraintLayout7 = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn);
        boolean z = false;
        if (constraintLayout7 != null) {
            if (constraintLayout7.getVisibility() == 0) {
                z = true;
            }
        }
        ConstraintLayout constraintLayout8 = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(z ? R.id.clShareBtn : R.id.clShareToFeedBtn);
        View BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(R.id.scheduleImpl);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BuiltInFictitiousFunctionClassFactory.setVisibility(8);
        }
        NpsSurveyView npsSurveyView2 = (NpsSurveyView) BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule);
        if (npsSurveyView2 != null) {
            npsSurveyView2.setVisibility(8);
        }
        View BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0ca6_r8_lambda_vr2gwstnvhkx6lb6xeyezwcqi_y);
        if (BuiltInFictitiousFunctionClassFactory2 != null) {
            BuiltInFictitiousFunctionClassFactory2.setVisibility(8);
        }
        boolean z2 = this.GetContactSyncConfig;
        if (z2 && this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            View BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(R.id.scheduleImpl);
            if (BuiltInFictitiousFunctionClassFactory3 != null) {
                ViewExtKt.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3, false, ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3), null, null, constraintLayout8, null, ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3), null, 1964);
                id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), null, 8);
            }
            NpsSurveyView npsSurveyView3 = (NpsSurveyView) BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule);
            if (npsSurveyView3 != null) {
                NpsSurveyView npsSurveyView4 = npsSurveyView3;
                ViewExtKt.MyBillsEntityDataFactory(npsSurveyView4, false, ViewExtKt.getAuthRequestContext(npsSurveyView4), null, null, BuiltInFictitiousFunctionClassFactory(R.id.scheduleImpl), null, ViewExtKt.getAuthRequestContext(npsSurveyView4), Float.valueOf(0.0f), 940);
                id.dana.extension.view.ViewExtKt.PlaceComponentResult(npsSurveyView4, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)));
            }
        } else if (z2) {
            View BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(R.id.scheduleImpl);
            if (BuiltInFictitiousFunctionClassFactory4 != null) {
                ViewExtKt.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory4, false, ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory4), null, null, constraintLayout8, null, ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory4), null, 1964);
                id.dana.extension.view.ViewExtKt.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory4, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)));
            }
        } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7 || (npsSurveyView = (NpsSurveyView) BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule)) == null) {
        } else {
            NpsSurveyView npsSurveyView5 = npsSurveyView;
            ViewExtKt.MyBillsEntityDataFactory(npsSurveyView5, false, ViewExtKt.getAuthRequestContext(npsSurveyView5), null, null, constraintLayout8, null, ViewExtKt.getAuthRequestContext(npsSurveyView5), Float.valueOf(0.0f), 940);
            id.dana.extension.view.ViewExtKt.PlaceComponentResult(npsSurveyView5, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)));
        }
    }

    public final void BottomSheetCardBindingView$watcherCardNumberView$1() {
        NpsSurveyView npsSurveyView = (NpsSurveyView) BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule);
        if (npsSurveyView != null) {
            BuiltInFictitiousFunctionClassFactory(npsSurveyView, R.anim.f5042130772053, true, new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$animateShowSurveyOnly$1$1
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
                    View BuiltInFictitiousFunctionClassFactory = PaymentResultFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0ca6_r8_lambda_vr2gwstnvhkx6lb6xeyezwcqi_y);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        final PaymentResultFragment paymentResultFragment = PaymentResultFragment.this;
                        PaymentResultFragment.BuiltInFictitiousFunctionClassFactory(paymentResultFragment, -1);
                        PaymentResultFragment.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.anim.f5042130772053, true, new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$animateShowSurveyOnly$1$1$1$1
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
                                BaseActivity baseActivity = PaymentResultFragment.this.getBaseActivity();
                                PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
                                if (payActivity != null) {
                                    payActivity.expandBottomSheet();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(final View view, int i, final boolean z, final Function0<Unit> function0) {
        if (view == null) {
            return;
        }
        view.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), i);
        loadAnimation.setFillAfter(true);
        loadAnimation.setDuration(300L);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$playAnimation$2$1
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation p0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation p0) {
                if (z) {
                    view.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation p0) {
                function0.invoke();
            }
        });
        view.setAnimation(loadAnimation);
        view.startAnimation(view.getAnimation());
    }

    private final void MyBillsEntityDataFactory(final Function0<Unit> function0) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a094f_glideexperiments_builder);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PaymentResultFragment.BuiltInFictitiousFunctionClassFactory(Function0.this, this);
                }
            });
        }
        MaterialCardView materialCardView = (MaterialCardView) BuiltInFictitiousFunctionClassFactory(R.id.readMicros);
        if (materialCardView != null) {
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(Function0.this, this);
                }
            });
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean z, String str) {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getBaseActivity());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = z ? R.drawable.ic_checklist : R.drawable.ic_close_red;
        int authRequestContext = SizeUtil.getAuthRequestContext(24);
        int authRequestContext2 = SizeUtil.getAuthRequestContext(24);
        builder.getSupportButtonTintMode = authRequestContext;
        builder.moveToNextValue = authRequestContext2;
        builder.FragmentBottomSheetPaymentSettingBinding = BuiltInFictitiousFunctionClassFactory(z);
        builder.getAuthRequestContext = R.color.f27072131100488;
        builder.getErrorConfigVersion = getAuthRequestContext(z, str);
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(false);
        Context context = getContext();
        String string = context != null ? context.getString(R.string.tooltip_ok) : null;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentResultFragment.getCallingPid();
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0010, code lost:
    
        if (r0 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0020, code lost:
    
        if (r0 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0022, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0026, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String BuiltInFictitiousFunctionClassFactory(boolean r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L13
            android.content.Context r2 = r1.getContext()
            if (r2 == 0) goto L10
            r0 = 2131955146(0x7f130dca, float:1.9546811E38)
            java.lang.String r0 = r2.getString(r0)
        L10:
            if (r0 != 0) goto L25
            goto L22
        L13:
            android.content.Context r2 = r1.getContext()
            if (r2 == 0) goto L20
            r0 = 2131955826(0x7f131072, float:1.954819E38)
            java.lang.String r0 = r2.getString(r0)
        L20:
            if (r0 != 0) goto L25
        L22:
            java.lang.String r2 = ""
            goto L26
        L25:
            r2 = r0
        L26:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.PaymentResultFragment.BuiltInFictitiousFunctionClassFactory(boolean):java.lang.String");
    }

    private final String getAuthRequestContext(boolean z, String str) {
        if (z) {
            Context context = getContext();
            String string = context != null ? context.getString(R.string.add_asset_card_success_dialog_message) : null;
            if (string != null) {
                return string;
            }
        } else if (str != null) {
            return str;
        } else {
            Context context2 = getContext();
            String string2 = context2 != null ? context2.getString(R.string.add_asset_card_failed_dialog_message) : null;
            if (string2 != null) {
                return string2;
            }
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x005f, code lost:
    
        if (r5.equals(id.dana.cashier.model.ProcessingStatus.INNER_REDIRECT_STATUS) != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0068, code lost:
    
        if (r5.equals("success") != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x006a, code lost:
    
        r5 = "SUCCESS";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(@id.dana.cashier.model.constants.PaymentResultBackToHomeStatus java.lang.String r5) {
        /*
            r4 = this;
            id.dana.base.BaseActivity r0 = r4.getBaseActivity()
            boolean r1 = r0 instanceof id.dana.pay.PayActivity
            r2 = 0
            if (r1 == 0) goto Lc
            id.dana.pay.PayActivity r0 = (id.dana.pay.PayActivity) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            if (r0 == 0) goto L72
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L1c
            int r1 = r1.length()
            if (r1 == 0) goto L1c
            r1 = 0
            goto L1d
        L1c:
            r1 = 1
        L1d:
            if (r1 == 0) goto L6f
            boolean r5 = r0.getIsReturnHome()
            id.dana.base.BaseActivity r1 = r4.getBaseActivity()
            boolean r3 = r1 instanceof id.dana.pay.PayActivity
            if (r3 == 0) goto L2e
            r2 = r1
            id.dana.pay.PayActivity r2 = (id.dana.pay.PayActivity) r2
        L2e:
            if (r2 == 0) goto L33
            r2.needToBackHomeOnDestroy(r5)
        L33:
            kotlin.Lazy r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda5
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            int r1 = r5.hashCode()
            switch(r1) {
                case -1867169789: goto L62;
                case -861234267: goto L59;
                case 3135262: goto L4e;
                case 422194963: goto L43;
                default: goto L42;
            }
        L42:
            goto L6d
        L43:
            java.lang.String r1 = "processing"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L6d
            java.lang.String r5 = "PENDING"
            goto L6f
        L4e:
            java.lang.String r1 = "fail"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L6d
            java.lang.String r5 = "FAILED"
            goto L6f
        L59:
            java.lang.String r1 = "inner_redirect"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L6d
            goto L6a
        L62:
            java.lang.String r1 = "success"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L6d
        L6a:
            java.lang.String r5 = "SUCCESS"
            goto L6f
        L6d:
            java.lang.String r5 = ""
        L6f:
            r0.setCurrentPaymentStatus(r5)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.PaymentResultFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String):void");
    }

    private final boolean E() {
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (!Intrinsics.areEqual(payActivity != null ? payActivity.getSource() : null, "Send Money")) {
            PayResultModel payResultModel = (PayResultModel) this.FragmentBottomSheetPaymentSettingBinding.getValue();
            String str = payResultModel != null ? payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String : null;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String upperCase = "send_money".toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            if (!Intrinsics.areEqual(str, upperCase) && !NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                return false;
            }
        }
        return true;
    }

    private final boolean B() {
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        return Intrinsics.areEqual(payActivity != null ? payActivity.getSource() : null, "Mini Program");
    }

    private final boolean C() {
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        return Intrinsics.areEqual(payActivity != null ? payActivity.getSource() : null, "Deeplink");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v28 java.lang.String, still in use, count: 2, list:
          (r0v28 java.lang.String) from 0x0094: IF  (r0v28 java.lang.String) == (null java.lang.String)  -> B:178:0x0096 A[HIDDEN]
          (r0v28 java.lang.String) from 0x0098: PHI (r0v16 java.lang.String) = (r0v15 java.lang.String), (r0v28 java.lang.String), (r0v31 java.lang.String) binds: [B:178:0x0096, B:177:0x0094, B:172:0x008b] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:125)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:53)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.PaymentResultFragment.onDestroyView():void");
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lid/dana/cashier/fragment/PaymentResultFragment$Companion;", "", "()V", "ANIMATION_DURATION", "", "ARG_PAY_RESULT_MODEL", "", ExpressPurchaseActivity.BIZ_ORDER_ID, "MERCHANT_TRANS_ID", "PREFIX_CHARACTER_COUNT", "", "PROCESSING_COUNTDOWN_INTERVAL", "RECEIVER_TEXT_SIZE", "REDIRECT_URL", "RELOAD_BALANCE", "TIMER_DELAY", "TRX_NAME_MASK", "VA_NUMBER", "WHITE_SPACE", "WHITE_SPACE_PER_DIGIT", "newInstance", "Lid/dana/cashier/fragment/PaymentResultFragment;", CashierKeyParams.PAY_RESULT_MODEL, "Lid/dana/cashier/model/PayResultModel;", "reloadBalance", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static PaymentResultFragment BuiltInFictitiousFunctionClassFactory(PayResultModel payResultModel, boolean z) {
            Intrinsics.checkNotNullParameter(payResultModel, "");
            PaymentResultFragment paymentResultFragment = new PaymentResultFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_pay_result_model", payResultModel);
            bundle.putBoolean("reloadBalance", z);
            paymentResultFragment.setArguments(bundle);
            return paymentResultFragment;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(PaymentResultFragment paymentResultFragment) {
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
        String str = payResultModel != null ? payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String : null;
        String str2 = str != null ? str : "";
        FragmentActivity activity = paymentResultFragment.getActivity();
        Object systemService = activity != null ? activity.getSystemService("clipboard") : null;
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        ClipData newPlainText = ClipData.newPlainText("vaNumber", str2);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(newPlainText);
        }
        paymentResultFragment.getBaseActivity().showToast(paymentResultFragment.getString(R.string.copied));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment paymentResultFragment) {
        String str;
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        String str2 = null;
        if (!paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
            CashierAnalyticTracker cashierAnalyticTracker = paymentResultFragment.cashierAnalyticTracker;
            if (cashierAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierAnalyticTracker = null;
            }
            cashierAnalyticTracker.PlaceComponentResult(TrackerKey.CashierResultActionType.CLOSE_OR_DONE);
        }
        if (!paymentResultFragment.B()) {
            if (paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                paymentResultFragment.getBaseActivity().setResult(-1, new Intent().putExtra(OrganizerSummaryActivity.PAYMENT_RESULT, (String) paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue()));
            }
        } else {
            GlobalNetworkContract.Presenter presenter = paymentResultFragment.globalNetworkPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            String str3 = payResultModel != null ? payResultModel.getValueOfTouchPositionAbsolute : null;
            if (str3 != null) {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "");
                str2 = str3.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(str2, "");
            }
            if (str2 != null) {
                int hashCode = str2.hashCode();
                if (hashCode != -1149187101) {
                    if (hashCode != -137465490) {
                        if (hashCode == 35394935 && str2.equals("PENDING")) {
                            str = "8000";
                            presenter.getAuthRequestContext(true, str);
                        }
                    } else if (str2.equals("USER_CANCEL")) {
                        str = "6001";
                        presenter.getAuthRequestContext(true, str);
                    }
                } else if (str2.equals("SUCCESS")) {
                    str = "9000";
                    presenter.getAuthRequestContext(true, str);
                }
            }
            str = "4000";
            presenter.getAuthRequestContext(true, str);
        }
        paymentResultFragment.getBaseActivity().finish();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment paymentResultFragment, NpsSurveyView npsSurveyView) {
        NpsSurveySubmitRequestModel constructSurveyRequest;
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        Intrinsics.checkNotNullParameter(npsSurveyView, "");
        View BuiltInFictitiousFunctionClassFactory = paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0ca6_r8_lambda_vr2gwstnvhkx6lb6xeyezwcqi_y);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        BuiltInFictitiousFunctionClassFactory.setVisibility(8);
        NpsSurveyView npsSurveyView2 = (NpsSurveyView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule);
        if (npsSurveyView2 != null && (constructSurveyRequest = npsSurveyView2.constructSurveyRequest()) != null) {
            CashierBannerContract.Presenter presenter = paymentResultFragment.cashierBannerPresenter;
            CashierAnalyticTracker cashierAnalyticTracker = null;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.BuiltInFictitiousFunctionClassFactory(constructSurveyRequest);
            CashierAnalyticTracker cashierAnalyticTracker2 = paymentResultFragment.cashierAnalyticTracker;
            if (cashierAnalyticTracker2 != null) {
                cashierAnalyticTracker = cashierAnalyticTracker2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            cashierAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        npsSurveyView.showSuccessSubmit();
    }

    public static /* synthetic */ void getAuthRequestContext(PaymentResultFragment paymentResultFragment) {
        String str;
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        if (!paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
            CashierAnalyticTracker cashierAnalyticTracker = paymentResultFragment.cashierAnalyticTracker;
            if (cashierAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierAnalyticTracker = null;
            }
            cashierAnalyticTracker.PlaceComponentResult(TrackerKey.CashierResultActionType.SEE_DETAILS);
        }
        BaseActivity baseActivity = paymentResultFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null && payActivity.isFromDanaKagetRevamp()) {
            PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            if (payResultModel != null) {
                str = payResultModel.MyBillsEntityDataFactory;
            }
            str = null;
        } else {
            PayResultModel payResultModel2 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            if (payResultModel2 != null) {
                str = payResultModel2.BuiltInFictitiousFunctionClassFactory;
            }
            str = null;
        }
        if (str != null) {
            String str2 = StringsKt.isBlank(str) ^ true ? str : null;
            if (str2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(DanaUrl.TRANSACTION_DETAIL, Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                sb.append(format);
                String obj = sb.toString();
                if (paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                    obj = DanaUrl.HISTORY_TRANSACTION_GROUP_SEND;
                }
                DanaH5.startContainerFullUrl(obj);
            }
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function0 function0, PaymentResultFragment paymentResultFragment) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        function0.invoke();
        CashierAnalyticTracker cashierAnalyticTracker = paymentResultFragment.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        String str = paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        cashierAnalyticTracker.MyBillsEntityDataFactory(str != null ? str : "");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment paymentResultFragment, boolean z) {
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn);
        if (constraintLayout != null) {
            constraintLayout.setEnabled(!z);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn);
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(z ^ true ? 0 : 8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.FeatureHoldLoginConfig);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(z ^ true ? 0 : 8);
        }
        TextView textView = (TextView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1572_npssurveyview_onprogresschangelistener);
        if (textView != null) {
            textView.setVisibility(z ^ true ? 0 : 8);
        }
        LogoProgressView logoProgressView = (LogoProgressView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.setSmoothScrollingEnabled);
        if (logoProgressView != null) {
            if (z) {
                logoProgressView.startRefresh();
            } else {
                logoProgressView.stopRefresh();
            }
            logoProgressView.setVisibility(z ? 0 : 8);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PaymentResultFragment paymentResultFragment) {
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        Context context = paymentResultFragment.getContext();
        Object systemService = context != null ? context.getSystemService(H5ResourceHandlerUtil.AUDIO) : null;
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        Context context2 = paymentResultFragment.getContext();
        MediaPlayer create = context2 != null ? MediaPlayer.create(context2, (int) R.raw.f47082131886125) : null;
        Integer valueOf = audioManager != null ? Integer.valueOf(audioManager.getRingerMode()) : null;
        boolean z = true;
        if ((valueOf == null || valueOf.intValue() != 0) && (valueOf == null || valueOf.intValue() != 1)) {
            z = false;
        }
        if (z) {
            if (create != null) {
                create.setVolume(0.0f, 0.0f);
            }
        } else if (valueOf != null && valueOf.intValue() == 2 && create != null) {
            create.setVolume(1.0f, 1.0f);
        }
        if (create != null) {
            create.start();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PaymentResultFragment paymentResultFragment) {
        CashierPayMethodModel cashierPayMethodModel;
        int i;
        CashierPayMethodModel cashierPayMethodModel2;
        CashierPayChannelModel moveToNextValue;
        CashierPayMethodModel cashierPayMethodModel3;
        CashierPayChannelModel moveToNextValue2;
        CashierPayMethodModel cashierPayMethodModel4;
        CashierPayChannelModel moveToNextValue3;
        CashierPayMethodModel cashierPayMethodModel5;
        CashierPayChannelModel moveToNextValue4;
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        if (paymentResultFragment.isAdded()) {
            PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            Unit unit = null;
            if (payResultModel != null && (cashierPayMethodModel = payResultModel.I) != null) {
                if (!((cashierPayMethodModel instanceof CashierPayMethodModel.OTCPayMethod) || (cashierPayMethodModel instanceof CashierPayMethodModel.VirtualAccountPayMethod))) {
                    cashierPayMethodModel = null;
                }
                if (cashierPayMethodModel != null) {
                    if (cashierPayMethodModel instanceof CashierPayMethodModel.OTCPayMethod) {
                        i = R.string.how_to_topup;
                    } else {
                        i = cashierPayMethodModel instanceof CashierPayMethodModel.VirtualAccountPayMethod ? R.string.how_to_transfer : 0;
                    }
                    String lookAheadTest = cashierPayMethodModel.lookAheadTest();
                    PayResultModel payResultModel2 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                    String str = (payResultModel2 == null || (cashierPayMethodModel5 = payResultModel2.I) == null || (moveToNextValue4 = CashierPayMethodModelKt.moveToNextValue(cashierPayMethodModel5)) == null) ? null : moveToNextValue4.isLayoutRequested;
                    String str2 = str == null ? "" : str;
                    PayResultModel payResultModel3 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                    String str3 = (payResultModel3 == null || (cashierPayMethodModel4 = payResultModel3.I) == null || (moveToNextValue3 = CashierPayMethodModelKt.moveToNextValue(cashierPayMethodModel4)) == null) ? null : moveToNextValue3.getOnBoardingScenario;
                    String str4 = str3 == null ? "" : str3;
                    PayResultModel payResultModel4 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                    String str5 = payResultModel4 != null ? payResultModel4.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String : null;
                    String str6 = str5 == null ? "" : str5;
                    PayResultModel payResultModel5 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                    String str7 = (payResultModel5 == null || (cashierPayMethodModel3 = payResultModel5.I) == null || (moveToNextValue2 = CashierPayMethodModelKt.moveToNextValue(cashierPayMethodModel3)) == null) ? null : moveToNextValue2.E;
                    String str8 = str7 == null ? "" : str7;
                    PayResultModel payResultModel6 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                    String str9 = (payResultModel6 == null || (cashierPayMethodModel2 = payResultModel6.I) == null || (moveToNextValue = CashierPayMethodModelKt.moveToNextValue(cashierPayMethodModel2)) == null) ? null : moveToNextValue.VerifyPinStateManager$executeRiskChallenge$2$2;
                    CashierGuideDialogFragment.Params params = ((lookAheadTest.length() == 0) || i == 0) ? null : new CashierGuideDialogFragment.Params("topup_guide", i, lookAheadTest, str2, str4, str6, str8, str9 == null ? "" : str9, (cashierPayMethodModel instanceof CashierPayMethodModel.VirtualAccountPayMethod) && (StringsKt.isBlank(str4) ^ true) && !StringsKt.equals(lookAheadTest, str4, true));
                    if (params != null) {
                        CashierGuideDialogFragment.Companion companion = CashierGuideDialogFragment.INSTANCE;
                        FragmentManager parentFragmentManager = paymentResultFragment.getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                        Intrinsics.checkNotNullParameter(params, "");
                        Fragment findFragmentByTag = parentFragmentManager.findFragmentByTag("HowToBottomSheetDialogFragment");
                        BaseBottomSheetDialogFragment baseBottomSheetDialogFragment = findFragmentByTag instanceof BaseBottomSheetDialogFragment ? (BaseBottomSheetDialogFragment) findFragmentByTag : null;
                        if (baseBottomSheetDialogFragment != null) {
                            if (baseBottomSheetDialogFragment.isAdded() && !baseBottomSheetDialogFragment.isVisible()) {
                                Bundle arguments = baseBottomSheetDialogFragment.getArguments();
                                if (arguments != null) {
                                    arguments.putParcelable("params", params);
                                }
                                parentFragmentManager.beginTransaction().BuiltInFictitiousFunctionClassFactory(baseBottomSheetDialogFragment);
                            }
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            CashierGuideDialogFragment.Companion.getAuthRequestContext(params).show(parentFragmentManager, "HowToBottomSheetDialogFragment");
                        }
                        unit = Unit.INSTANCE;
                    }
                }
            }
            if (unit == null) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(paymentResultFragment, paymentResultFragment.getString(R.string.how_to_error));
            }
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0, PaymentResultFragment paymentResultFragment) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        function0.invoke();
        CashierAnalyticTracker cashierAnalyticTracker = paymentResultFragment.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        String str = paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        cashierAnalyticTracker.MyBillsEntityDataFactory(str != null ? str : "");
    }

    public static /* synthetic */ void getErrorConfigVersion(PaymentResultFragment paymentResultFragment) {
        CashierPayMethodModel selectedPayMethod;
        Intrinsics.checkNotNullParameter(paymentResultFragment, "");
        BaseActivity baseActivity = paymentResultFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.needToBackHomeOnDestroy(false);
        }
        paymentResultFragment.BuiltInFictitiousFunctionClassFactory(PaymentResultBackToHomeStatus.CANCELLED);
        TryAgainPayResultView tryAgainPayResultView = (TryAgainPayResultView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.ItemBillPaymentConfirmationBinding);
        if (tryAgainPayResultView != null && (selectedPayMethod = tryAgainPayResultView.getSelectedPayMethod()) != null) {
            String initRecordTimeStamp = selectedPayMethod.initRecordTimeStamp();
            paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda6.clear();
            paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda6.add(initRecordTimeStamp);
            CashierAnalyticTracker cashierAnalyticTracker = paymentResultFragment.cashierAnalyticTracker;
            if (cashierAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierAnalyticTracker = null;
            }
            cashierAnalyticTracker.getAuthRequestContext(paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda6.toString());
            PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            String str = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
            if (!paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                CashierAnalyticTracker cashierAnalyticTracker2 = paymentResultFragment.cashierAnalyticTracker;
                if (cashierAnalyticTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierAnalyticTracker2 = null;
                }
                cashierAnalyticTracker2.KClassImpl$Data$declaredNonStaticMembers$2(str);
            }
        }
        TryAgainPayResultView tryAgainPayResultView2 = (TryAgainPayResultView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.ItemBillPaymentConfirmationBinding);
        if ((tryAgainPayResultView2 != null ? tryAgainPayResultView2.getSelectedPayMethod() : null) != null) {
            PayResultModel payResultModel2 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            String str2 = payResultModel2 != null ? payResultModel2.getErrorConfigVersion : null;
            PayResultModel payResultModel3 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            String str3 = payResultModel3 != null ? payResultModel3.lookAheadTest : null;
            CashierCheckoutRequestModel cashierCheckoutRequestModel = new CashierCheckoutRequestModel(str2, Boolean.TRUE, null, null, str3 == null ? "" : str3, null, null, null, null, null, null, false, null, 8172, null);
            BaseActivity baseActivity2 = paymentResultFragment.getBaseActivity();
            PayActivity payActivity2 = baseActivity2 instanceof PayActivity ? (PayActivity) baseActivity2 : null;
            if (payActivity2 != null) {
                TryAgainPayResultView tryAgainPayResultView3 = (TryAgainPayResultView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.ItemBillPaymentConfirmationBinding);
                payActivity2.retryPaymentFromResultPage(cashierCheckoutRequestModel, tryAgainPayResultView3 != null ? tryAgainPayResultView3.getSelectedPayMethod() : null);
            }
        }
    }

    public static final /* synthetic */ void scheduleImpl(PaymentResultFragment paymentResultFragment) {
        DiscreteSurveySlider discreteSurveySlider;
        View BuiltInFictitiousFunctionClassFactory = paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0ca6_r8_lambda_vr2gwstnvhkx6lb6xeyezwcqi_y);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BuiltInFictitiousFunctionClassFactory.setVisibility(0);
            AppCompatImageView appCompatImageView = (AppCompatImageView) BuiltInFictitiousFunctionClassFactory.findViewById(R.id.DateRetargetClass);
            if (appCompatImageView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(0);
            }
            TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory.findViewById(R.id.res_0x7f0a149e_daggersendmoneyexternalcomponent_sendmoneyexternalcomponentimpl_userrepositoryprovider);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setBackground(ContextCompat.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.getContext(), (int) R.drawable.bg_rounded_blue50_2dp));
                TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f54112132017907);
            }
            NpsSurveyView npsSurveyView = (NpsSurveyView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule);
            if (npsSurveyView == null || (discreteSurveySlider = (DiscreteSurveySlider) npsSurveyView._$_findCachedViewById(R.id.setRightEdgeEffectColor_res_0x7f0a063b)) == null) {
                return;
            }
            discreteSurveySlider.setupSliderThumb(true);
        }
    }

    public static final /* synthetic */ void moveToNextValue(PaymentResultFragment paymentResultFragment) {
        boolean z = paymentResultFragment.GetContactSyncConfig;
        if (z && paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            View BuiltInFictitiousFunctionClassFactory = paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.scheduleImpl);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.anim.f5062130772057, true, new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$animateShowBannerSurvey$1
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
                        PaymentResultFragment.this.BottomSheetCardBindingView$watcherCardNumberView$1();
                    }
                });
            }
        } else if (!z) {
            if (paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda7) {
                paymentResultFragment.VerifyPinStateManager$executeRiskChallenge$2$1();
                paymentResultFragment.A();
                BuiltInFictitiousFunctionClassFactory((CardView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.cardBottomSection), R.anim.f5062130772057, true, PaymentResultFragment$animateSlideUp$1.INSTANCE);
                paymentResultFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
            }
        } else {
            View BuiltInFictitiousFunctionClassFactory2 = paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.scheduleImpl);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.anim.f5062130772057, true, PaymentResultFragment$animateSlideUp$1.INSTANCE);
            }
        }
    }

    public static final /* synthetic */ void lookAheadTest(PaymentResultFragment paymentResultFragment) {
        paymentResultFragment.VerifyPinStateManager$executeRiskChallenge$2$1();
        paymentResultFragment.A();
        BuiltInFictitiousFunctionClassFactory((CardView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.cardBottomSection), R.anim.f5062130772057, true, PaymentResultFragment$animateSlideUp$1.INSTANCE);
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(PaymentResultFragment paymentResultFragment) {
        ConstraintLayout constraintLayout = (ConstraintLayout) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn);
        if (constraintLayout != null) {
            constraintLayout.post(new PaymentResultFragment$$ExternalSyntheticLambda9(paymentResultFragment, true));
        }
        CreateInvoiceHelper createInvoiceHelper = CreateInvoiceHelper.INSTANCE;
        BaseActivity baseActivity = paymentResultFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CreateInvoiceHelper.MyBillsEntityDataFactory(baseActivity, new CreateInvoiceResultHandler() { // from class: id.dana.cashier.fragment.PaymentResultFragment$buildShareableInvoice$1
            @Override // id.dana.lib.drawbitmap.invoice.CreateInvoiceResultHandler
            public final void onResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PaymentResultFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
                PaymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda6(PaymentResultFragment.this);
                PaymentResultFragment.B(PaymentResultFragment.this);
            }

            @Override // id.dana.lib.drawbitmap.invoice.CreateInvoiceResultHandler
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PaymentResultFragment.B(PaymentResultFragment.this);
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierShareTransaction]: cashier_native_fail");
                sb.append(p0.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), p0);
            }
        });
    }

    public static final /* synthetic */ void GetContactSyncConfig(PaymentResultFragment paymentResultFragment) {
        ConstraintLayout constraintLayout = (ConstraintLayout) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.clShareToFeedBtn);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public static final /* synthetic */ void initRecordTimeStamp(final PaymentResultFragment paymentResultFragment) {
        final ConstraintLayout constraintLayout = (ConstraintLayout) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.clShareToFeedBtn);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = constraintLayout;
            id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(constraintLayout2, null, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), null, null, 13);
            constraintLayout2.setVisibility(0);
            SafeClickListenerExtensionKt.MyBillsEntityDataFactory(constraintLayout2, new Function1<View, Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$enableShareToFeedButton$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (ConstraintLayout.this.isEnabled()) {
                        PaymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(paymentResultFragment);
                        PaymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(paymentResultFragment);
                    }
                }
            });
        }
        View BuiltInFictitiousFunctionClassFactory = paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.scheduleImpl);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, null, Integer.valueOf(id.dana.extension.view.ViewExtKt.PlaceComponentResult(16.0f)), null, null, 13);
        }
    }

    public static final /* synthetic */ void DatabaseTableConfigUtil(PaymentResultFragment paymentResultFragment) {
        PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
        if (payResultModel != null) {
            String str = payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String;
            if (str == null) {
                str = "";
            }
            String str2 = payResultModel.readMicros;
            CashierVariables cashierVariables = CashierVariables.INSTANCE;
            NpsSurveyRequestModel npsSurveyRequestModel = new NpsSurveyRequestModel(str, str2, CashierVariables.getAuthRequestContext(), true);
            CashierBannerContract.Presenter presenter = paymentResultFragment.cashierBannerPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.KClassImpl$Data$declaredNonStaticMembers$2(npsSurveyRequestModel);
        }
    }

    public static final /* synthetic */ CashierResultBannerListener NetworkUserEntityData$$ExternalSyntheticLambda1(PaymentResultFragment paymentResultFragment) {
        return (CashierResultBannerListener) paymentResultFragment.moveToNextValue.getValue();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment paymentResultFragment, String str) {
        paymentResultFragment.DatabaseTableConfigUtil = true;
        if (UrlUtil.getErrorConfigVersion(str)) {
            paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            ReadLinkPropertiesContract.Presenter presenter = paymentResultFragment.readDeepLinkPropertiesPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.MyBillsEntityDataFactory(str);
            return;
        }
        DanaH5.startContainerFullUrl(str, new DanaH5Listener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$getOnClickBannerListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                PaymentResultFragment.MyBillsEntityDataFactory(PaymentResultFragment.this, true);
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                BaseActivity baseActivity = PaymentResultFragment.this.getBaseActivity();
                if (baseActivity != null) {
                    baseActivity.finish();
                }
            }
        });
    }

    public static final /* synthetic */ PayResultModel NetworkUserEntityData$$ExternalSyntheticLambda8(PaymentResultFragment paymentResultFragment) {
        return (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
    }

    public static final /* synthetic */ String newProxyInstance(PaymentResultFragment paymentResultFragment) {
        return (String) paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda5(PaymentResultFragment paymentResultFragment) {
        ReadLinkPropertiesContract.Presenter presenter = paymentResultFragment.readDeepLinkPropertiesPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        FeedUtils.Companion companion = FeedUtils.INSTANCE;
        PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
        presenter.MyBillsEntityDataFactory(FeedUtils.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel != null ? payResultModel.BuiltInFictitiousFunctionClassFactory : null));
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda6(PaymentResultFragment paymentResultFragment) {
        if (paymentResultFragment.getBaseActivity().isFinishing()) {
            return;
        }
        Bundle bundle = new Bundle();
        String str = paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        bundle.putString("arg_image_filepath", str);
        CashierShareBottomSheetDialog.Companion companion = CashierShareBottomSheetDialog.INSTANCE;
        CashierShareBottomSheetDialog.Companion.KClassImpl$Data$declaredNonStaticMembers$2(bundle).show(paymentResultFragment.getBaseActivity().getSupportFragmentManager(), "CashierShareBottomSheetDialog");
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final PaymentResultFragment paymentResultFragment, final FetchBannerModel fetchBannerModel) {
        Object obj;
        PayResultModel payResultModel;
        CashierPayMethodModel cashierPayMethodModel;
        String str;
        String str2;
        GlideRequests KClassImpl$Data$declaredNonStaticMembers$22 = GlideApp.KClassImpl$Data$declaredNonStaticMembers$2(paymentResultFragment);
        String str3 = null;
        if (Intrinsics.areEqual(fetchBannerModel.BuiltInFictitiousFunctionClassFactory, "ELECTRONIC_MONEY_RULE")) {
            Context context = paymentResultFragment.getContext();
            obj = context != null ? ContextCompat.PlaceComponentResult(context, Intrinsics.areEqual(Locale.getDefault().getLanguage(), "in") ? R.drawable.bg_emoney_banner : R.drawable.bg_emoney_banner_en) : null;
            if (obj == null) {
                obj = Integer.valueOf((int) R.color.f23182131099816);
            }
        } else {
            obj = fetchBannerModel.getErrorConfigVersion;
        }
        GlideRequest<Drawable> PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory(obj).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.color.f23182131099816).PlaceComponentResult((int) R.color.f23182131099816);
        AppCompatImageView appCompatImageView = (AppCompatImageView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a094f_glideexperiments_builder);
        if (appCompatImageView != null) {
            PlaceComponentResult.MyBillsEntityDataFactory((ImageView) appCompatImageView);
            String str4 = fetchBannerModel.lookAheadTest.get(FetchBannerInfo.EXTEND_KEY_CTA_BUTTON_LABEL);
            if (str4 == null) {
                str4 = "";
            }
            String str5 = fetchBannerModel.BuiltInFictitiousFunctionClassFactory;
            TextView textView = (TextView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.tvBtnCta);
            if (textView != null) {
                textView.setText(str4.length() > 0 ? (str5 == null || !Intrinsics.areEqual(str5, "ELECTRONIC_MONEY_RULE")) ? TextUtil.lookAheadTest(str4) : paymentResultFragment.getString(R.string.banner_button_emoney_update_balance) : paymentResultFragment.getString(R.string.banner_button_default_text));
            }
            paymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = fetchBannerModel.PlaceComponentResult;
            if (Intrinsics.areEqual(fetchBannerModel.getAuthRequestContext, FetchBannerInfo.BANNER_SOURCE_BANNER_MANAGEMENT)) {
                paymentResultFragment.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$renderBanner$1
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
                        String str6 = FetchBannerModel.this.moveToNextValue;
                        String str7 = str6;
                        if ((!(str7 == null || str7.length() == 0)) == false) {
                            str6 = null;
                        }
                        if (str6 != null) {
                            PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(paymentResultFragment, str6);
                        }
                    }
                });
                return;
            }
            String str6 = fetchBannerModel.BuiltInFictitiousFunctionClassFactory;
            if (str6 != null) {
                switch (str6.hashCode()) {
                    case -1819417442:
                        if (str6.equals("BILLER_REMINDER_RULE")) {
                            PayResultModel payResultModel2 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                            if (payResultModel2 != null ? Intrinsics.areEqual(payResultModel2.moveToNextValue, Boolean.TRUE) : false) {
                                PayResultModel payResultModel3 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                                if (payResultModel3 != null) {
                                    str3 = payResultModel3.NetworkUserEntityData$$ExternalSyntheticLambda4;
                                }
                            } else {
                                str3 = "";
                            }
                            final String MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory(DanaUrl.CASHIER_BILLER_REMINDER_RULE_BANNER).MyBillsEntityDataFactory("merchantTransId", str3).MyBillsEntityDataFactory("bizOrderId", paymentResultFragment.scheduleImpl).MyBillsEntityDataFactory();
                            paymentResultFragment.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$setOnClickBillerReminderRuleBanner$1
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
                                    PaymentResultFragment paymentResultFragment2 = PaymentResultFragment.this;
                                    String str7 = MyBillsEntityDataFactory;
                                    Intrinsics.checkNotNullExpressionValue(str7, "");
                                    PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(paymentResultFragment2, str7);
                                }
                            });
                            return;
                        }
                        return;
                    case -1158828090:
                        if (!str6.equals("SAVING_CARD_RULE") || (payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue()) == null || (cashierPayMethodModel = payResultModel.I) == null) {
                            return;
                        }
                        if (CashierPayMethodModelKt.PrepareContext(cashierPayMethodModel) && !CashierPayMethodModelKt.FragmentBottomSheetPaymentSettingBinding(cashierPayMethodModel)) {
                            paymentResultFragment.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$setOnClickSavingCardRuleBanner$1$1
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
                                    final CashierCardBindingPresenter cashierCardBindingPresenter = PaymentResultFragment.this.cashierCardBindingPresenter;
                                    if (cashierCardBindingPresenter == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        cashierCardBindingPresenter = null;
                                    }
                                    PayResultModel NetworkUserEntityData$$ExternalSyntheticLambda8 = PaymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(PaymentResultFragment.this);
                                    String str7 = NetworkUserEntityData$$ExternalSyntheticLambda8 != null ? NetworkUserEntityData$$ExternalSyntheticLambda8.getErrorConfigVersion : null;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    Intrinsics.checkNotNullParameter(str7, "");
                                    cashierCardBindingPresenter.PlaceComponentResult.get().execute(AddAssetCardForUser.Params.INSTANCE.createAddAssetCardRequest(str7), new Function1<DefaultResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierCardBindingPresenter$addAssetCard$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(DefaultResponse defaultResponse) {
                                            invoke2(defaultResponse);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(DefaultResponse defaultResponse) {
                                            dagger.Lazy lazy;
                                            dagger.Lazy lazy2;
                                            Intrinsics.checkNotNullParameter(defaultResponse, "");
                                            if (defaultResponse.isSuccess()) {
                                                lazy2 = CashierCardBindingPresenter.this.lookAheadTest;
                                                ((CashierCardBindingContract.View) lazy2.get()).PlaceComponentResult();
                                                return;
                                            }
                                            lazy = CashierCardBindingPresenter.this.lookAheadTest;
                                            CashierCardBindingContract.View view = (CashierCardBindingContract.View) lazy.get();
                                            String errorMessage = defaultResponse.getErrorMessage();
                                            view.KClassImpl$Data$declaredNonStaticMembers$2(errorMessage != null ? errorMessage : "");
                                        }
                                    }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierCardBindingPresenter$addAssetCard$2
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
                                            dagger.Lazy lazy;
                                            Context context2;
                                            Intrinsics.checkNotNullParameter(th, "");
                                            DanaLog.BuiltInFictitiousFunctionClassFactory("CashierCardBindingPresenter", th.getMessage());
                                            lazy = CashierCardBindingPresenter.this.lookAheadTest;
                                            CashierCardBindingContract.View view = (CashierCardBindingContract.View) lazy.get();
                                            context2 = CashierCardBindingPresenter.this.getAuthRequestContext;
                                            view.KClassImpl$Data$declaredNonStaticMembers$2(ErrorUtil.PlaceComponentResult(th, context2));
                                        }
                                    });
                                }
                            });
                            return;
                        }
                        final String str7 = "https://m.dana.id/m/portal/bankcardadd?isClosable=true";
                        paymentResultFragment.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$setOnClickSavingCardRuleBanner$1$2
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
                                PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment.this, str7);
                            }
                        });
                        return;
                    case 257696976:
                        if (str6.equals("COMMON_RULE")) {
                            String str8 = fetchBannerModel.lookAheadTest.get("redirectUrl");
                            final String str9 = str8 != null ? str8 : "";
                            if (str9.length() > 0) {
                                paymentResultFragment.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$setOnClickCommonRuleBanner$1
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
                                        PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment.this, str9);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        return;
                    case 1318176047:
                        if (str6.equals("SPLIT_BILL_RULE")) {
                            PayResultModel payResultModel4 = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
                            if (payResultModel4 != null && (str2 = payResultModel4.AppCompatEmojiTextHelper) != null) {
                                String str10 = str2;
                                StringBuilder sb = new StringBuilder();
                                int length = str10.length();
                                for (int i = 0; i < length; i++) {
                                    char charAt = str10.charAt(i);
                                    if (Character.isDigit(charAt)) {
                                        sb.append(charAt);
                                    }
                                }
                                str3 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(str3, "");
                            }
                            if (str3 == null) {
                                str3 = "";
                            }
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            Object[] objArr = new Object[1];
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(BranchLinkConstant.ActionTarget.SPLIT_BILL);
                            if (str3.length() > 0) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("?params=[amount=");
                                sb3.append(str3);
                                sb3.append(']');
                                str = sb3.toString();
                            } else {
                                str = "";
                            }
                            sb2.append(str);
                            objArr[0] = sb2.toString();
                            final String format = String.format(DanaUrl.DEEPLINK_URL_WITH_PARAM, Arrays.copyOf(objArr, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "");
                            paymentResultFragment.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$setOnClickSplitBillRuleBanner$1
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
                                    PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment.this, format);
                                }
                            });
                            return;
                        }
                        return;
                    case 1475900638:
                        if (str6.equals("ELECTRONIC_MONEY_RULE")) {
                            final NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(paymentResultFragment.getContext());
                            paymentResultFragment.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.cashier.fragment.PaymentResultFragment$setOnClickEMoneyRuleBanner$1
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
                                    PaymentResultFragment.CashierResultBannerListener NetworkUserEntityData$$ExternalSyntheticLambda1 = PaymentResultFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(PaymentResultFragment.this);
                                    if (NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                                        NfcAdapter nfcAdapter = defaultAdapter;
                                        NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(nfcAdapter != null ? nfcAdapter.isEnabled() : false);
                                    }
                                    BaseActivity baseActivity = PaymentResultFragment.this.getBaseActivity();
                                    if (baseActivity != null) {
                                        baseActivity.finish();
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment paymentResultFragment, NpsSurveyModel npsSurveyModel) {
        final NpsSurveyView npsSurveyView = (NpsSurveyView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule);
        if (npsSurveyView != null) {
            npsSurveyView.setSurvey(npsSurveyModel);
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) npsSurveyView._$_findCachedViewById(R.id.btnSubmitSurvey);
            if (danaButtonPrimaryView != null) {
                danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment.this, npsSurveyView);
                    }
                });
            }
            CashierAnalyticTracker cashierAnalyticTracker = paymentResultFragment.cashierAnalyticTracker;
            if (cashierAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierAnalyticTracker = null;
            }
            cashierAnalyticTracker.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void FragmentBottomSheetPaymentSettingBinding(PaymentResultFragment paymentResultFragment) {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.btnSecondaryAction);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PaymentResultFragment.getErrorConfigVersion(PaymentResultFragment.this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.btnSecondaryAction);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setDanaButtonView(1, paymentResultFragment.getString(R.string.try_again), null, null);
        }
        DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.btnSecondaryAction);
        if (danaButtonPrimaryView3 != null) {
            danaButtonPrimaryView3.setContentDescription(paymentResultFragment.getString(R.string.sdet_btn_try_again));
        }
        DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.btnSecondaryAction);
        if (danaButtonPrimaryView4 != null) {
            danaButtonPrimaryView4.setVisibility(0);
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda4(PaymentResultFragment paymentResultFragment) {
        CashierFeedContract.Presenter presenter = paymentResultFragment.cashierFeedPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory(paymentResultFragment.scheduleImpl);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PaymentResultFragment paymentResultFragment, int i) {
        NpsSurveyView npsSurveyView;
        TextView textView;
        View BuiltInFictitiousFunctionClassFactory = paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0ca6_r8_lambda_vr2gwstnvhkx6lb6xeyezwcqi_y);
        if (BuiltInFictitiousFunctionClassFactory == null || (npsSurveyView = (NpsSurveyView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.DanaContactModule)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(npsSurveyView, "");
        if (i != -1 && (textView = (TextView) BuiltInFictitiousFunctionClassFactory.findViewById(R.id.res_0x7f0a149e_daggersendmoneyexternalcomponent_sendmoneyexternalcomponentimpl_userrepositoryprovider)) != null) {
            textView.setText(npsSurveyView.getSliderLabelMessage(i));
        }
        Float seekBarThumbPosX = npsSurveyView.getSeekBarThumbPosX(Integer.valueOf(i));
        BuiltInFictitiousFunctionClassFactory.setX(seekBarThumbPosX != null ? seekBarThumbPosX.floatValue() : 0.0f);
        Float seekBarThumbPosY = npsSurveyView.getSeekBarThumbPosY();
        BuiltInFictitiousFunctionClassFactory.setTranslationY(seekBarThumbPosY != null ? seekBarThumbPosY.floatValue() : 0.0f);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(PaymentResultFragment paymentResultFragment, boolean z) {
        BaseActivity baseActivity = paymentResultFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.needToBackHomeOnDestroy(z);
        }
    }

    public static final /* synthetic */ void SubSequence(PaymentResultFragment paymentResultFragment) {
        CashierPaymentResultAnimationView cashierPaymentResultAnimationView;
        LottieAnimationView lottieAnimationView;
        if (!paymentResultFragment.VerifyPinStateManager$executeRiskChallenge$2$2() || (cashierPaymentResultAnimationView = (CashierPaymentResultAnimationView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.lavPaymentResult)) == null || (lottieAnimationView = (LottieAnimationView) cashierPaymentResultAnimationView._$_findCachedViewById(R.id.lavResultSuccessDecor)) == null) {
            return;
        }
        lottieAnimationView.removeAllAnimatorListeners();
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.cashier.fragment.PaymentResultFragment$setupAnimationWhenSuccessBanner$1$1
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                boolean z;
                LottieAnimationView lottieAnimationView2;
                Intrinsics.checkNotNullParameter(p0, "");
                z = PaymentResultFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (!z) {
                    PaymentResultFragment.lookAheadTest(PaymentResultFragment.this);
                    PaymentResultFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
                    PaymentResultFragment.DatabaseTableConfigUtil(PaymentResultFragment.this);
                    return;
                }
                CashierPaymentResultAnimationView cashierPaymentResultAnimationView2 = (CashierPaymentResultAnimationView) PaymentResultFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.lavPaymentResult);
                if (cashierPaymentResultAnimationView2 == null || (lottieAnimationView2 = (LottieAnimationView) cashierPaymentResultAnimationView2._$_findCachedViewById(R.id.lavResultSuccessDecor)) == null) {
                    return;
                }
                lottieAnimationView2.setMinProgress(0.3f);
            }
        });
    }

    public static final /* synthetic */ void readMicros(PaymentResultFragment paymentResultFragment) {
        CardView cardView = (CardView) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.cardBottomSection);
        if (cardView != null) {
            cardView.setVisibility(0);
        }
    }

    public static final /* synthetic */ void getSupportButtonTintMode(PaymentResultFragment paymentResultFragment) {
        String str;
        PayResultModel payResultModel = (PayResultModel) paymentResultFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
        if (payResultModel == null || (str = payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
            return;
        }
        DanaH5.startContainerFullUrl(str);
    }

    public static final /* synthetic */ void B(PaymentResultFragment paymentResultFragment) {
        ConstraintLayout constraintLayout = (ConstraintLayout) paymentResultFragment.BuiltInFictitiousFunctionClassFactory(R.id.clShareBtn);
        if (constraintLayout != null) {
            constraintLayout.post(new PaymentResultFragment$$ExternalSyntheticLambda9(paymentResultFragment, false));
        }
    }

    private static boolean PlaceComponentResult(PayResultModel payResultModel) {
        return (payResultModel.getErrorConfigVersion.length() > 0) || Intrinsics.areEqual(payResultModel.isLayoutRequested, Boolean.FALSE);
    }

    private final boolean getOnBoardingScenario() {
        PayResultModel payResultModel = (PayResultModel) this.FragmentBottomSheetPaymentSettingBinding.getValue();
        if (payResultModel != null) {
            return (payResultModel.scheduleImpl() && payResultModel.getSupportButtonTintMode != null) || !(payResultModel.scheduleImpl() || payResultModel.getCallingPid == null);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0018, code lost:
    
        if (r0.equals(id.dana.cashier.model.ProcessingStatus.PROCESSING) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0031, code lost:
    
        if (r0.equals("redirect") != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0033, code lost:
    
        r0 = getString(id.dana.R.string.payment_processing);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0041, code lost:
    
        if (r0.equals(id.dana.cashier.model.ProcessingStatus.INNER_REDIRECT_STATUS) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004a, code lost:
    
        if (r0.equals("success") != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x004c, code lost:
    
        r0 = getString(id.dana.R.string.payment_success);
     */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext() {
        /*
            r3 = this;
            kotlin.Lazy r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda5
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.hashCode()
            java.lang.String r2 = ""
            switch(r1) {
                case -1867169789: goto L44;
                case -861234267: goto L3b;
                case -776144932: goto L2b;
                case 3135262: goto L1b;
                case 422194963: goto L12;
                default: goto L11;
            }
        L11:
            goto L54
        L12:
            java.lang.String r1 = "processing"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L33
            goto L54
        L1b:
            java.lang.String r1 = "fail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 2131956027(0x7f13113b, float:1.9548598E38)
            java.lang.String r0 = r3.getString(r0)
            goto L55
        L2b:
            java.lang.String r1 = "redirect"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
        L33:
            r0 = 2131956038(0x7f131146, float:1.954862E38)
            java.lang.String r0 = r3.getString(r0)
            goto L55
        L3b:
            java.lang.String r1 = "inner_redirect"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            goto L4c
        L44:
            java.lang.String r1 = "success"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
        L4c:
            r0 = 2131956061(0x7f13115d, float:1.9548667E38)
            java.lang.String r0 = r3.getString(r0)
            goto L55
        L54:
            r0 = r2
        L55:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r3.getAuthRequestContext(r0)
            int r0 = id.dana.R.id.res_0x7f0a093d_property_propertytype_1
            android.view.View r0 = r3.BuiltInFictitiousFunctionClassFactory(r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            if (r0 == 0) goto L6b
            android.view.View r0 = (android.view.View) r0
            r1 = 4
            r0.setVisibility(r1)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.PaymentResultFragment.getAuthRequestContext():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:1544:0x0218, code lost:
    
        if ((r0 == null || r0.length() == 0) != false) goto L1545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1548:0x0222, code lost:
    
        if (getSupportButtonTintMode() != false) goto L2116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1552:0x022c, code lost:
    
        if (FragmentBottomSheetPaymentSettingBinding() != false) goto L2116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1553:0x022e, code lost:
    
        r4 = new android.text.SpannableString(r8.getText().toString());
        r4.setSpan(new android.text.style.AbsoluteSizeSpan(16, true), 14, r7.length() + 14, 33);
        r4.setSpan(new android.text.style.StyleSpan(0), 14, r7.length() + 14, 33);
        r8.setText(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1555:0x0263, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1556:0x0264, code lost:
    
        r4 = id.dana.analytics.firebase.Crashlytics.INSTANCE;
        r4 = id.dana.analytics.firebase.Crashlytics.Companion.getAuthRequestContext();
        r10 = new java.lang.StringBuilder();
        r10.append(r0.getMessage());
        r10.append('\n');
        r10.append((java.lang.Object) r8.getText());
        r10.append('\n');
        r10.append(r8.getText().length());
        r10.append('\n');
        r10.append(r7);
        r0 = r10.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, "");
        r4.getAuthRequestContext.log(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1694:0x0427, code lost:
    
        if (r4 == null) goto L1700;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1699:0x0432, code lost:
    
        if (r4 == null) goto L1700;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1700:0x0434, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1835:0x06a9, code lost:
    
        if (r0.equals(id.dana.cashier.model.ProcessingStatus.INNER_REDIRECT_STATUS) != false) goto L1839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1838:0x06b0, code lost:
    
        if (r0.equals("success") != false) goto L1839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1839:0x06b2, code lost:
    
        r0 = r21.cashierFeedPresenter;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1840:0x06b4, code lost:
    
        if (r0 == null) goto L1842;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1842:0x06b7, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1843:0x06bb, code lost:
    
        r0.KClassImpl$Data$declaredNonStaticMembers$2(r21.scheduleImpl);
        r0 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1844:0x06c8, code lost:
    
        if (r0 == null) goto L1846;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1845:0x06ca, code lost:
    
        r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0.isLayoutRequested, java.lang.Boolean.TRUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1846:0x06d3, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1847:0x06d4, code lost:
    
        if (r0 == false) goto L1855;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1848:0x06d6, code lost:
    
        r0 = new java.lang.Object[1];
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1849:0x06e0, code lost:
    
        if (r4 == null) goto L1853;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1850:0x06e2, code lost:
    
        r4 = r4.I;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1851:0x06e4, code lost:
    
        if (r4 == null) goto L1853;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1852:0x06e6, code lost:
    
        r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1853:0x06eb, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1854:0x06ec, code lost:
    
        r0[0] = r4;
        r0 = getString(id.dana.R.string.mixpay_paymethod_combination, r0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        KClassImpl$Data$declaredNonStaticMembers$2("", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1855:0x06fd, code lost:
    
        r0 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1856:0x0705, code lost:
    
        if (r0 == null) goto L1860;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1858:0x070b, code lost:
    
        if (r0.moveToNextValue() != true) goto L1860;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1859:0x070d, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1860:0x070f, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1861:0x0710, code lost:
    
        if (r0 == false) goto L1869;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1862:0x0712, code lost:
    
        r0 = getString(id.dana.R.string.payment_result_converted_amount_in_rp_header);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1863:0x0724, code lost:
    
        if (r4 == null) goto L1865;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1864:0x0726, code lost:
    
        r4 = r4.AppCompatEmojiTextHelper;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1865:0x0729, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1866:0x072a, code lost:
    
        if (r4 != null) goto L1868;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1867:0x072c, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1868:0x072d, code lost:
    
        KClassImpl$Data$declaredNonStaticMembers$2(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1869:0x0732, code lost:
    
        r0 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1870:0x073a, code lost:
    
        if (r0 == null) goto L1872;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1871:0x073c, code lost:
    
        r0 = r0.getOnBoardingScenario;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1872:0x073f, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1874:0x0743, code lost:
    
        if (r0 == null) goto L1882;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1875:0x0745, code lost:
    
        r0 = getString(id.dana.R.string.payment_result_additional_fee_header);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r4 = getString(id.dana.R.string.payment_result_additional_fee_content);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        r6 = new java.lang.Object[1];
        r11 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1876:0x0760, code lost:
    
        if (r11 == null) goto L1880;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1877:0x0762, code lost:
    
        r11 = r11.getOnBoardingScenario;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1878:0x0764, code lost:
    
        if (r11 == null) goto L1880;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1879:0x0766, code lost:
    
        r11 = r11.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1880:0x0769, code lost:
    
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1881:0x076a, code lost:
    
        r6[0] = r11;
        r4 = java.lang.String.format(r4, java.util.Arrays.copyOf(r6, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        KClassImpl$Data$declaredNonStaticMembers$2(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1883:0x077f, code lost:
    
        if (NetworkUserEntityData$$ExternalSyntheticLambda4() == false) goto L1889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1884:0x0781, code lost:
    
        r0 = getString(id.dana.R.string.payment_result_additional_fee_header);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r4 = getString(id.dana.R.string.payment_result_transaction_fee_content);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        r6 = new java.lang.Object[1];
        r11 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1885:0x079c, code lost:
    
        if (r11 == null) goto L1887;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1886:0x079e, code lost:
    
        r11 = r11.AppCompatEmojiTextHelper;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1887:0x07a1, code lost:
    
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1888:0x07a2, code lost:
    
        r6[0] = r11;
        r4 = java.lang.String.format(r4, java.util.Arrays.copyOf(r6, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        KClassImpl$Data$declaredNonStaticMembers$2(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1889:0x07b3, code lost:
    
        r0 = (androidx.constraintlayout.widget.ConstraintLayout) BuiltInFictitiousFunctionClassFactory(id.dana.R.id.res_0x7f0a03b4_access_getfeaturedbanklistadapter_p);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1890:0x07bb, code lost:
    
        if (r0 == null) goto L1892;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1891:0x07bd, code lost:
    
        r0 = r0;
        id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(r0, null, 0, null, null, 13);
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1892:0x07cf, code lost:
    
        r0 = r21.cashierBannerPresenter;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1893:0x07d1, code lost:
    
        if (r0 == null) goto L1895;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1895:0x07d4, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1896:0x07d8, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1897:0x07e0, code lost:
    
        if (r4 == null) goto L1899;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1898:0x07e2, code lost:
    
        r4 = r4.getErrorConfigVersion;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1899:0x07e5, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1900:0x07e6, code lost:
    
        if (r4 != null) goto L1902;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1901:0x07e8, code lost:
    
        r12 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1902:0x07ea, code lost:
    
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1903:0x07eb, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1904:0x07f3, code lost:
    
        if (r4 == null) goto L1906;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1905:0x07f5, code lost:
    
        r4 = r4.J;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1906:0x07f8, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1907:0x07f9, code lost:
    
        if (r4 != null) goto L1909;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1908:0x07fb, code lost:
    
        r13 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1909:0x07fd, code lost:
    
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1910:0x07fe, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1911:0x0806, code lost:
    
        if (r4 == null) goto L1913;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1912:0x0808, code lost:
    
        r4 = r4.readMicros;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1913:0x080b, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1914:0x080c, code lost:
    
        if (r4 != null) goto L1916;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1915:0x080e, code lost:
    
        r14 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1916:0x0810, code lost:
    
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1917:0x0811, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1918:0x0819, code lost:
    
        if (r4 == null) goto L1920;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1919:0x081b, code lost:
    
        r4 = r4.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1920:0x081e, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1921:0x081f, code lost:
    
        if (r4 != null) goto L1923;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1922:0x0821, code lost:
    
        r15 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1923:0x0823, code lost:
    
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1924:0x0824, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1925:0x082c, code lost:
    
        if (r4 == null) goto L1929;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1926:0x082e, code lost:
    
        r4 = r4.whenAvailable;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1927:0x0830, code lost:
    
        if (r4 == null) goto L1929;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1928:0x0832, code lost:
    
        r4 = r4.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1929:0x0835, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1930:0x0836, code lost:
    
        if (r4 != null) goto L1932;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1931:0x0838, code lost:
    
        r16 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1932:0x083b, code lost:
    
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1933:0x083d, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1934:0x0845, code lost:
    
        if (r4 == null) goto L1936;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1935:0x0847, code lost:
    
        r4 = r4.PrepareContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1936:0x084a, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1937:0x084b, code lost:
    
        if (r4 != null) goto L1939;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1938:0x084d, code lost:
    
        r17 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1939:0x0850, code lost:
    
        r17 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1940:0x0852, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1941:0x085a, code lost:
    
        if (r4 == null) goto L1952;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1942:0x085c, code lost:
    
        r4 = r4.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1943:0x085e, code lost:
    
        if (r4 == null) goto L1952;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1944:0x0860, code lost:
    
        r4 = r4;
        r6 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, 10));
        r4 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1946:0x0875, code lost:
    
        if (r4.hasNext() == false) goto L2123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1947:0x0877, code lost:
    
        r9 = ((id.dana.cashier.model.CashierPayChannelModel) r4.next()).B;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1948:0x087f, code lost:
    
        if (r9 != null) goto L2125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1949:0x0881, code lost:
    
        r9 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1950:0x0882, code lost:
    
        r6.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1951:0x0886, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1952:0x088a, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1953:0x088b, code lost:
    
        if (r4 != 0) goto L1955;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1954:0x088d, code lost:
    
        r4 = kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1955:0x0891, code lost:
    
        r18 = r4;
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1956:0x089b, code lost:
    
        if (r4 == null) goto L1958;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1957:0x089d, code lost:
    
        r4 = r4.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1958:0x08a0, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1959:0x08a1, code lost:
    
        if (r4 != null) goto L1961;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1960:0x08a3, code lost:
    
        r19 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1961:0x08a6, code lost:
    
        r19 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1962:0x08a8, code lost:
    
        r0.PlaceComponentResult(new id.dana.cashier.model.FetchBannerRequestModel(r12, r13, r14, r15, r16, r17, r18, r19));
        r0 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1963:0x08b9, code lost:
    
        if (r0 == 0) goto L1979;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1965:0x08c4, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r0.lookAheadTest)) == false) goto L1970;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1967:0x08ce, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.J, "INSURANCE") != false) goto L1969;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1969:0x08d1, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1970:0x08d3, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1971:0x08d4, code lost:
    
        if (r4 != false) goto L1973;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1972:0x08d6, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1973:0x08d7, code lost:
    
        if (r0 == 0) goto L1979;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1974:0x08d9, code lost:
    
        r4 = r21.expressPurchasePresenter;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1975:0x08db, code lost:
    
        if (r4 == null) goto L1977;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1977:0x08de, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1978:0x08e2, code lost:
    
        r4.getAuthRequestContext(r0.lookAheadTest, id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseAction.SUCCESS.name(), id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseType.ADDON.name());
     */
    /* JADX WARN: Code restructure failed: missing block: B:1980:0x08f5, code lost:
    
        if (r21.newProxyInstance != false) goto L1983;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1982:0x08fb, code lost:
    
        if (NetworkUserEntityData$$ExternalSyntheticLambda7() == false) goto L1986;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1983:0x08fd, code lost:
    
        r0 = (androidx.cardview.widget.CardView) BuiltInFictitiousFunctionClassFactory(id.dana.R.id.cardBottomSection);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1984:0x0905, code lost:
    
        if (r0 == null) goto L1986;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1985:0x0907, code lost:
    
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1986:0x090c, code lost:
    
        r0 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1987:0x0914, code lost:
    
        if (r0 == 0) goto L2007;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1989:0x091f, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r0.PlaceComponentResult)) == false) goto L1994;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1991:0x092a, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r0.getErrorConfigVersion)) != false) goto L1993;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1993:0x092d, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1994:0x092f, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1995:0x0930, code lost:
    
        if (r4 != false) goto L1997;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1996:0x0932, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1997:0x0933, code lost:
    
        if (r0 == 0) goto L2007;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1998:0x0935, code lost:
    
        r12 = r0.PlaceComponentResult;
        r13 = r0.getErrorConfigVersion;
        r4 = id.dana.cashier.helper.CashierVariables.INSTANCE;
        r14 = id.dana.cashier.helper.CashierVariables.getAuthRequestContext();
        r15 = r0.PrepareContext;
        r4 = r0.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1999:0x0943, code lost:
    
        if (r4 != null) goto L2001;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2000:0x0945, code lost:
    
        r16 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:2001:0x0948, code lost:
    
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2002:0x094a, code lost:
    
        r9 = new id.dana.expresspurchase.model.OfferExpressPurchaseModel(r12, r13, r14, r15, r16, r0.BuiltInFictitiousFunctionClassFactory, r0.NetworkUserEntityData$$ExternalSyntheticLambda4, r0.I instanceof id.dana.cashier.model.CashierPayMethodModel.PaylaterPayMethod);
        r0 = r21.expressPurchasePresenter;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2003:0x0960, code lost:
    
        if (r0 == null) goto L2005;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2005:0x0963, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2006:0x0967, code lost:
    
        r0.KClassImpl$Data$declaredNonStaticMembers$2(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:2007:0x096a, code lost:
    
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new id.dana.cashier.fragment.PaymentResultFragment$$ExternalSyntheticLambda3(), 250);
        r0 = getBaseActivity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:2008:0x0983, code lost:
    
        if ((r0 instanceof id.dana.pay.PayActivity) == false) goto L2010;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2009:0x0985, code lost:
    
        r0 = (id.dana.pay.PayActivity) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2010:0x0988, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2011:0x0989, code lost:
    
        if (r0 == 0) goto L2015;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2013:0x098f, code lost:
    
        if (r0.isFromDanaKagetRevamp() == false) goto L2015;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2014:0x0991, code lost:
    
        r11 = java.util.concurrent.TimeUnit.SECONDS.convert(r0.getTimerDuration(), java.util.concurrent.TimeUnit.MILLISECONDS);
        ((android.widget.TextView) BuiltInFictitiousFunctionClassFactory(id.dana.R.id.tvPaymentResultAdditionalInfoHeader)).setText(getString(id.dana.R.string.cashier_dana_kaget_additional_header));
        ((android.widget.TextView) BuiltInFictitiousFunctionClassFactory(id.dana.R.id.tvPaymentResultAdditionalInfo)).setText(getString(id.dana.R.string.cashier_dana_kaget_additional_content, java.lang.String.valueOf(r11)));
        r4 = (androidx.constraintlayout.widget.ConstraintLayout) BuiltInFictitiousFunctionClassFactory(id.dana.R.id.res_0x7f0a03b4_access_getfeaturedbanklistadapter_p);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        r4.setVisibility(0);
        r0.listenCountDown(new id.dana.cashier.fragment.PaymentResultFragment$handleDanaKagetSharePage$1$1());
        r0.startCountDown();
     */
    /* JADX WARN: Code restructure failed: missing block: B:2015:0x09ea, code lost:
    
        r0 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:2016:0x09f2, code lost:
    
        if (r0 == null) goto L2018;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2017:0x09f4, code lost:
    
        r0 = r0.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2018:0x09f7, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2020:0x0a02, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, id.dana.domain.paylater.model.PaylaterRepaymentType.PAYLATER_CICIL.name()) == false) goto L2026;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2021:0x0a04, code lost:
    
        r0 = r21.cashierPayLaterPresenter;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2022:0x0a06, code lost:
    
        if (r0 == null) goto L2024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2024:0x0a09, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2025:0x0a0d, code lost:
    
        r0.PlaceComponentResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:2026:0x0a10, code lost:
    
        r0 = r21.payResultPresenter;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2027:0x0a12, code lost:
    
        if (r0 == null) goto L2029;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2029:0x0a15, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2030:0x0a19, code lost:
    
        r4 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:2031:0x0a21, code lost:
    
        if (r4 == null) goto L2033;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2032:0x0a23, code lost:
    
        r4 = r4.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2033:0x0a26, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2034:0x0a27, code lost:
    
        if (r4 != null) goto L2036;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2035:0x0a29, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:2036:0x0a2a, code lost:
    
        r6 = (id.dana.cashier.model.PayResultModel) r21.FragmentBottomSheetPaymentSettingBinding.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:2037:0x0a32, code lost:
    
        if (r6 == null) goto L2039;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2038:0x0a34, code lost:
    
        r6 = r6.J;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2039:0x0a37, code lost:
    
        r6 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2040:0x0a38, code lost:
    
        if (r6 != null) goto L2042;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2041:0x0a3a, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:2042:0x0a3b, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory("success", r4, r6);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1515:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:1516:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:1518:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:1519:0x01ab  */
    /* JADX WARN: Type inference failed for: r0v101, types: [id.dana.cashier.CashierBannerContract$Presenter] */
    /* JADX WARN: Type inference failed for: r0v104, types: [id.dana.cashier.model.PayResultModel] */
    /* JADX WARN: Type inference failed for: r0v112, types: [id.dana.cashier.model.PayResultModel] */
    /* JADX WARN: Type inference failed for: r0v115 */
    /* JADX WARN: Type inference failed for: r0v116, types: [id.dana.pay.PayActivity] */
    /* JADX WARN: Type inference failed for: r0v124, types: [id.dana.cashier.PayResultContract$Presenter] */
    /* JADX WARN: Type inference failed for: r0v125 */
    /* JADX WARN: Type inference failed for: r0v127, types: [id.dana.cashier.CashierPayLaterContract$Presenter] */
    /* JADX WARN: Type inference failed for: r0v128 */
    /* JADX WARN: Type inference failed for: r0v131, types: [id.dana.cashier.model.PayResultModel] */
    /* JADX WARN: Type inference failed for: r0v135, types: [id.dana.expresspurchase.presenter.ExpressPurchaseContract$Presenter] */
    /* JADX WARN: Type inference failed for: r0v136 */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v139, types: [id.dana.cashier.model.PayResultModel] */
    /* JADX WARN: Type inference failed for: r0v141 */
    /* JADX WARN: Type inference failed for: r0v142 */
    /* JADX WARN: Type inference failed for: r0v147 */
    /* JADX WARN: Type inference failed for: r0v66, types: [id.dana.cashier.tracker.CashierAnalyticTracker] */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r0v72, types: [id.dana.cashier.CashierFeedContract$Presenter] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [id.dana.cashier.model.AddOnTrackingModel] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [id.dana.cashier.model.featureTime.FeatureTimeModel] */
    /* JADX WARN: Type inference failed for: r4v147, types: [id.dana.expresspurchase.presenter.ExpressPurchaseContract$Presenter] */
    /* JADX WARN: Type inference failed for: r4v148 */
    /* JADX WARN: Type inference failed for: r4v153, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [id.dana.pay.PayActivity] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [id.dana.pay.PayActivity] */
    /* JADX WARN: Type inference failed for: r4v217, types: [id.dana.cashier.PayResultContract$Presenter] */
    /* JADX WARN: Type inference failed for: r4v218 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [id.dana.pay.PayActivity] */
    /* JADX WARN: Type inference failed for: r4v295 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [id.dana.pay.PayActivity] */
    /* JADX WARN: Type inference failed for: r4v91 */
    /* JADX WARN: Type inference failed for: r4v92 */
    /* JADX WARN: Type inference failed for: r6v32, types: [java.lang.StringBuilder, java.lang.Object] */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getErrorConfigVersion() {
        /*
            Method dump skipped, instructions count: 2976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.PaymentResultFragment.getErrorConfigVersion():void");
    }
}
