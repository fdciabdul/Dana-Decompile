package id.dana.cashier.fragment;

import android.view.View;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.firebase.perf.util.Constants;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.cashier.PaylaterCicilOnboardingDialog;
import id.dana.cashier.TncCardPaymentEventHandler;
import id.dana.cashier.adapter.CashierAdditionalFeeAdapter;
import id.dana.cashier.adapter.CashierPayMethodAdapter;
import id.dana.cashier.bottomsheet.CashierPromotionAppliedBottomSheetDialog;
import id.dana.cashier.bottomsheet.CashierSmartpayBottomSheetDialog;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierHighlightConfigModel;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.QueryInstallmentModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.presenter.CashierHighlightPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.tracker.PaylaterAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.di.component.CashierComponent;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.model.CurrencyAmountModel;
import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ProcessKotlinInternals
    java.lang.NullPointerException
    */
@Metadata(d1 = {"\u0000Ô\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 «\u00042\u00020\u0001:\u0002«\u0004B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010ß\u0001\u001a\u00030à\u0001H\u0002J,\u0010á\u0001\u001a\u00030à\u00012\u000f\u0010â\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\b2\u0006\u0010}\u001a\u00020y2\u0007\u0010ã\u0001\u001a\u00020yH\u0002J\u0013\u0010ä\u0001\u001a\u00030à\u00012\u0007\u0010å\u0001\u001a\u00020yH\u0002J\n\u0010æ\u0001\u001a\u00030à\u0001H\u0002J\t\u0010ç\u0001\u001a\u00020yH\u0002J\n\u0010è\u0001\u001a\u00030à\u0001H\u0002J\n\u0010é\u0001\u001a\u00030à\u0001H\u0016J\f\u0010ê\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0002J\f\u0010ì\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0002J\f\u0010í\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0002J\u001d\u0010î\u0001\u001a\u00030ï\u00012\u0007\u0010ð\u0001\u001a\u00020\u000b2\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030ë\u0001H\u0002Ja\u0010ô\u0001\u001a\u00030à\u00012\r\u0010õ\u0001\u001a\b\u0012\u0004\u0012\u00020o0\b2\u0007\u0010ö\u0001\u001a\u00020y2\u0007\u0010÷\u0001\u001a\u00020y2\u0007\u0010ø\u0001\u001a\u00020\u000b2\t\b\u0002\u0010ù\u0001\u001a\u00020\u000b2 \u0010ú\u0001\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020o0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020o0\b0û\u0001H\u0002J\n\u0010ü\u0001\u001a\u00030à\u0001H\u0016J'\u0010ý\u0001\u001a\u00030à\u00012\u0007\u0010þ\u0001\u001a\u00020o2\f\b\u0002\u0010ÿ\u0001\u001a\u0005\u0018\u00010\u0080\u0002H\u0002¢\u0006\u0003\u0010\u0081\u0002J\u0015\u0010\u0082\u0002\u001a\u00030à\u00012\t\u0010Ê\u0001\u001a\u0004\u0018\u00010oH\u0002J\n\u0010\u0083\u0002\u001a\u00030à\u0001H\u0002J%\u0010\u0083\u0002\u001a\u00030à\u00012\u0007\u0010\u0084\u0002\u001a\u00020y2\u0007\u0010\u0085\u0002\u001a\u00020\u000b2\u0007\u0010\u0086\u0002\u001a\u00020oH\u0002J\u0015\u0010\u0087\u0002\u001a\u00030à\u00012\t\u0010Ê\u0001\u001a\u0004\u0018\u00010oH\u0002J\n\u0010\u0088\u0002\u001a\u00030à\u0001H\u0002J \u0010\u0089\u0002\u001a\u00030à\u00012\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010o2\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010oH\u0002J\u0013\u0010\u008c\u0002\u001a\u00030à\u00012\u0007\u0010\u008d\u0002\u001a\u00020yH\u0002J\b\u0010\u008e\u0002\u001a\u00030à\u0001J\u0013\u0010\u008f\u0002\u001a\u00030à\u00012\u0007\u0010\u0090\u0002\u001a\u00020yH\u0002J\f\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0092\u0002H\u0002J\u0017\u0010\u0093\u0002\u001a\u0005\u0018\u00010ë\u00012\t\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010\u0095\u0002\u001a\u00030\u0080\u0002H\u0014J\n\u0010\u0096\u0002\u001a\u00030\u009e\u0001H\u0002J\t\u0010\u0097\u0002\u001a\u00020\u000bH\u0002J\u000f\u0010\u0098\u0002\u001a\b\u0012\u0004\u0012\u00020o0\bH\u0002J\u0012\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0080\u0002H\u0002¢\u0006\u0003\u0010\u009a\u0002J\u000b\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010\u009c\u0002\u001a\u00020\u000bH\u0002J9\u0010\u009d\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020y\u0018\u00010\u009e\u00022\u000f\u0010\u009f\u0002\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\bH\u0002J\u001a\u0010 \u0002\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0007\u0010¡\u0002\u001a\u00020yH\u0002J>\u0010¢\u0002\u001a\u00030£\u00022\t\u0010Ê\u0001\u001a\u0004\u0018\u00010o2\u0016\u0010¤\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020y\u0018\u00010\u009e\u00022\u000f\u0010¥\u0002\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0002J\u0011\u0010¦\u0002\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0002J\u0016\u0010§\u0002\u001a\u0004\u0018\u00010o2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010oH\u0002J\t\u0010¨\u0002\u001a\u00020\u000bH\u0002J\u0014\u0010©\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0094\u0002\u001a\u00020\u000bH\u0002J\t\u0010ª\u0002\u001a\u00020\u000bH\u0002J\t\u0010«\u0002\u001a\u00020\u000bH\u0002J\t\u0010¬\u0002\u001a\u00020\u000bH\u0002J\n\u0010\u00ad\u0002\u001a\u00030à\u0001H\u0002J\u0014\u0010®\u0002\u001a\u00030à\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002JD\u0010¯\u0002\u001a\u00030à\u00012\u0007\u0010°\u0002\u001a\u00020\u000b2\t\u0010±\u0002\u001a\u0004\u0018\u00010\u000b2\t\u0010²\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010³\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000b2\u0007\u0010µ\u0002\u001a\u00020yH\u0014J\n\u0010¶\u0002\u001a\u00030à\u0001H\u0002J\u0016\u0010·\u0002\u001a\u00030à\u00012\n\u0010¸\u0002\u001a\u0005\u0018\u00010¹\u0002H\u0002J\u0013\u0010º\u0002\u001a\u00030à\u00012\u0007\u0010Ê\u0001\u001a\u00020oH\u0002J\n\u0010»\u0002\u001a\u00030à\u0001H\u0002J'\u0010¼\u0002\u001a\u00020y2\u0006\u0010!\u001a\u00020\"2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010o2\t\b\u0002\u0010½\u0002\u001a\u00020\u000bH\u0002J\n\u0010¾\u0002\u001a\u00030à\u0001H\u0002J\n\u0010¿\u0002\u001a\u00030à\u0001H\u0014J\n\u0010À\u0002\u001a\u00030à\u0001H\u0002J\u001a\u0010Á\u0002\u001a\u00030à\u00012\u000e\u0010Â\u0002\u001a\t\u0012\u0005\u0012\u00030Ã\u00020\bH\u0002J\u0012\u0010Ä\u0002\u001a\u00030à\u00012\u0006\u0010!\u001a\u00020\"H\u0002J\n\u0010Å\u0002\u001a\u00030à\u0001H\u0002J\n\u0010Æ\u0002\u001a\u00030à\u0001H\u0014J\n\u0010Ç\u0002\u001a\u00030à\u0001H\u0002J\n\u0010È\u0002\u001a\u00030à\u0001H\u0002J\n\u0010É\u0002\u001a\u00030à\u0001H\u0014J\u0010\u0010Ê\u0002\u001a\u00030à\u00012\u0006\u0010!\u001a\u00020\"J\n\u0010Ë\u0002\u001a\u00030à\u0001H\u0002J\u0012\u0010Ì\u0002\u001a\u00030à\u00012\u0006\u0010!\u001a\u00020\"H\u0002J\n\u0010Í\u0002\u001a\u00030à\u0001H\u0002J\n\u0010Î\u0002\u001a\u00030à\u0001H\u0002J\n\u0010Ï\u0002\u001a\u00030à\u0001H\u0002J\n\u0010Ð\u0002\u001a\u00030à\u0001H\u0002J\n\u0010Ñ\u0002\u001a\u00030à\u0001H\u0002J\n\u0010Ò\u0002\u001a\u00030à\u0001H\u0014J\u0014\u0010Ó\u0002\u001a\u00030à\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\n\u0010Ô\u0002\u001a\u00030à\u0001H\u0002J\n\u0010Õ\u0002\u001a\u00030à\u0001H\u0014J/\u0010Ö\u0002\u001a\u00020y2\u0007\u0010×\u0002\u001a\u00020y2\u0010\u0010Ø\u0002\u001a\u000b\u0012\u0005\u0012\u00030Ù\u0002\u0018\u00010\b2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010oH\u0002J\t\u0010Ú\u0002\u001a\u00020yH\u0002J\u0015\u0010Û\u0002\u001a\u00020y2\n\u0010Ü\u0002\u001a\u0005\u0018\u00010Ý\u0002H\u0002J\u0012\u0010Þ\u0002\u001a\u00030à\u00012\u0006\u0010\u007f\u001a\u00020yH\u0002J'\u0010ß\u0002\u001a\u00020y2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010o2\u0006\u0010}\u001a\u00020y2\t\b\u0002\u0010½\u0002\u001a\u00020\u000bH\u0002J+\u0010à\u0002\u001a\u00030à\u00012\n\u0010á\u0002\u001a\u0005\u0018\u00010ë\u00012\u0007\u0010\u0094\u0002\u001a\u00020\u000b2\n\b\u0002\u0010â\u0002\u001a\u00030\u009e\u0001H\u0002J\t\u0010ã\u0002\u001a\u00020yH\u0016J\n\u0010ä\u0002\u001a\u00030à\u0001H\u0002J\n\u0010å\u0002\u001a\u00030à\u0001H\u0002J\n\u0010æ\u0002\u001a\u00030ç\u0002H\u0002J\n\u0010è\u0002\u001a\u00030à\u0001H\u0002J\n\u0010é\u0002\u001a\u00030à\u0001H\u0002J\u0015\u0010ê\u0002\u001a\u00030à\u00012\t\u0010ë\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010ì\u0002\u001a\u00030à\u0001H\u0016J\n\u0010í\u0002\u001a\u00030à\u0001H\u0014J\u0014\u0010î\u0002\u001a\u00030à\u00012\b\u0010ï\u0002\u001a\u00030ð\u0002H\u0016J\n\u0010ñ\u0002\u001a\u00030à\u0001H\u0014J\n\u0010ò\u0002\u001a\u00030à\u0001H\u0016J0\u0010ó\u0002\u001a\u00030»\u00012\u000f\u0010ô\u0002\u001a\n\u0012\u0005\u0012\u00030à\u00010õ\u00022\u0013\b\u0002\u0010ö\u0002\u001a\f\u0012\u0005\u0012\u00030à\u0001\u0018\u00010õ\u0002H\u0002J\n\u0010÷\u0002\u001a\u00030à\u0001H\u0014J1\u0010ø\u0002\u001a\b\u0012\u0004\u0012\u00020o0\b2\u0007\u0010ù\u0002\u001a\u00020y2\r\u0010ú\u0002\u001a\b\u0012\u0004\u0012\u00020o0\b2\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J\n\u0010û\u0002\u001a\u00030à\u0001H\u0002J\u0015\u0010ü\u0002\u001a\u00030à\u00012\t\u0010ý\u0002\u001a\u0004\u0018\u00010oH\u0002J \u0010þ\u0002\u001a\u00030à\u00012\t\u0010ý\u0002\u001a\u0004\u0018\u00010o2\t\u0010ÿ\u0002\u001a\u0004\u0018\u00010oH\u0002J\n\u0010\u0080\u0003\u001a\u00030à\u0001H\u0002J\u0014\u0010\u0081\u0003\u001a\u00030à\u00012\b\u0010\u0082\u0003\u001a\u00030\u0080\u0002H\u0002J\u0013\u0010\u0083\u0003\u001a\u00030à\u00012\u0007\u0010þ\u0001\u001a\u00020oH\u0002J(\u0010\u0084\u0003\u001a\u00030à\u00012\b\u0010\u0082\u0003\u001a\u00030\u0080\u00022\u0007\u0010\u0085\u0003\u001a\u00020y2\t\b\u0002\u0010\u0086\u0003\u001a\u00020yH\u0002J\u0013\u0010\u0087\u0003\u001a\u00030à\u00012\u0007\u0010\u0088\u0003\u001a\u00020yH\u0002J'\u0010\u0089\u0003\u001a\u00030ï\u00012\b\u0010\u008a\u0003\u001a\u00030ï\u00012\b\u0010\u008b\u0003\u001a\u00030\u008c\u00032\u0007\u0010ð\u0001\u001a\u00020\u000bH\u0002J8\u0010\u008d\u0003\u001a\u00020o2\u0007\u0010\u0086\u0002\u001a\u00020o2\u0007\u0010ö\u0001\u001a\u00020y2\u0007\u0010÷\u0001\u001a\u00020y2\u0007\u0010ø\u0001\u001a\u00020\u000b2\t\b\u0002\u0010ù\u0001\u001a\u00020\u000bH\u0002J6\u0010\u008e\u0003\u001a\u00030à\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\b2\u0007\u0010ö\u0001\u001a\u00020y2\u0007\u0010÷\u0001\u001a\u00020y2\u0007\u0010ø\u0001\u001a\u00020\u000bH\u0002J5\u0010\u008f\u0003\u001a\u00030à\u00012\u000b\b\u0002\u0010\u0090\u0003\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0091\u0003\u001a\u00030\u0092\u00032\u0007\u0010\u0093\u0003\u001a\u00020\u000b2\u0007\u0010\u0094\u0003\u001a\u00020\u000bH\u0002J,\u0010\u0095\u0003\u001a\u00030à\u00012\u0010\b\u0002\u0010\u0096\u0003\u001a\t\u0012\u0005\u0012\u00030Ã\u00020\b2\u000e\u0010\u0097\u0003\u001a\t\u0012\u0005\u0012\u00030Ã\u00020\bH\u0002J&\u0010\u0098\u0003\u001a\u00030à\u00012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\f\b\u0002\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u009a\u0003H\u0002J+\u0010\u009b\u0003\u001a\u00030à\u00012\u0007\u0010\u009c\u0003\u001a\u00020y2\u000b\b\u0002\u0010\u009d\u0003\u001a\u0004\u0018\u00010\u000b2\t\b\u0002\u0010\u009e\u0003\u001a\u00020yH\u0002J\u001d\u0010\u009f\u0003\u001a\u00030à\u00012\u0006\u0010!\u001a\u00020\"2\t\u0010þ\u0001\u001a\u0004\u0018\u00010oH\u0002J\u0015\u0010 \u0003\u001a\u00030à\u00012\t\u0010¡\u0003\u001a\u0004\u0018\u00010oH\u0002J\u0013\u0010¢\u0003\u001a\u00030à\u00012\u0007\u0010Ê\u0001\u001a\u00020oH\u0002J\n\u0010£\u0003\u001a\u00030à\u0001H\u0002J\u0013\u0010¤\u0003\u001a\u00030à\u00012\u0007\u0010\u0086\u0002\u001a\u00020oH\u0002J\u001f\u0010¥\u0003\u001a\u0004\u0018\u00010\u000b2\t\u0010¦\u0003\u001a\u0004\u0018\u00010\u000b2\u0007\u0010§\u0003\u001a\u00020\u000bH\u0002J\u0016\u0010¨\u0003\u001a\u00030à\u00012\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001H\u0002J\n\u0010©\u0003\u001a\u00030à\u0001H\u0002J\n\u0010ª\u0003\u001a\u00030à\u0001H\u0002J\u0013\u0010«\u0003\u001a\u00030à\u00012\u0007\u0010¬\u0003\u001a\u00020\u000bH\u0002J(\u0010\u00ad\u0003\u001a\b\u0012\u0004\u0012\u00020o0\b2\r\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020o0\b2\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\u0012\u0010®\u0003\u001a\u00030à\u00012\u0006\u0010!\u001a\u00020\"H\u0002J&\u0010¯\u0003\u001a\u00030à\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\b2\t\u0010°\u0003\u001a\u0004\u0018\u00010oH\u0002J,\u0010±\u0003\u001a\u00030à\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\b2\u0006\u0010}\u001a\u00020y2\u0007\u0010ã\u0001\u001a\u00020yH\u0002J/\u0010²\u0003\u001a\u00030à\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\b2\u0007\u0010\u0088\u0001\u001a\u00020y2\t\u0010°\u0003\u001a\u0004\u0018\u00010oH\u0002J(\u0010³\u0003\u001a\b\u0012\u0004\u0012\u00020o0\b2\r\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020o0\b2\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\n\u0010´\u0003\u001a\u00030à\u0001H\u0002J\n\u0010µ\u0003\u001a\u00030à\u0001H\u0002J&\u0010¶\u0003\u001a\u00030à\u00012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\f\b\u0002\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u009a\u0003H\u0002J&\u0010·\u0003\u001a\u00030à\u00012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\f\b\u0002\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u009a\u0003H\u0002J&\u0010¸\u0003\u001a\u00030à\u00012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\f\b\u0002\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u009a\u0003H\u0002J\n\u0010¹\u0003\u001a\u00030à\u0001H\u0002J\u001c\u0010º\u0003\u001a\u00030à\u00012\u0007\u0010»\u0003\u001a\u00020\u000b2\u0007\u0010¼\u0003\u001a\u00020yH\u0002J)\u0010½\u0003\u001a\u00030à\u00012\n\u0010¾\u0003\u001a\u0005\u0018\u00010¿\u00032\b\u0010\u0082\u0003\u001a\u00030\u0080\u00022\u0007\u0010\u0085\u0003\u001a\u00020yH\u0002J\u001d\u0010À\u0003\u001a\u00030à\u00012\b\u0010\u0082\u0003\u001a\u00030\u0080\u00022\u0007\u0010\u0085\u0003\u001a\u00020yH\u0002J\u001d\u0010Á\u0003\u001a\u00030à\u00012\b\u0010\u0082\u0003\u001a\u00030\u0080\u00022\u0007\u0010\u0085\u0003\u001a\u00020yH\u0002J%\u0010Â\u0003\u001a\u00030à\u00012\b\u0010Ã\u0003\u001a\u00030Ä\u00032\u000f\u0010Å\u0003\u001a\n\u0012\u0005\u0012\u00030à\u00010õ\u0002H\u0002J\n\u0010Æ\u0003\u001a\u00030à\u0001H\u0002J\n\u0010Ç\u0003\u001a\u00030à\u0001H\u0002J\n\u0010È\u0003\u001a\u00030à\u0001H\u0002J\n\u0010É\u0003\u001a\u00030à\u0001H\u0002J\n\u0010Ê\u0003\u001a\u00030à\u0001H\u0002J\n\u0010Ë\u0003\u001a\u00030à\u0001H\u0016J\u0013\u0010Ì\u0003\u001a\u00030à\u00012\u0007\u0010Í\u0003\u001a\u00020yH\u0002J\u0014\u0010Î\u0003\u001a\u00030à\u00012\b\u0010Ï\u0003\u001a\u00030Ð\u0003H\u0002J\u001e\u0010Ñ\u0003\u001a\u00030à\u00012\t\u0010±\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010Ò\u0003\u001a\u00020yH\u0002J%\u0010Ó\u0003\u001a\u00030à\u00012\u000f\u0010Ô\u0003\u001a\n\u0012\u0005\u0012\u00030à\u00010õ\u00022\b\u0010â\u0002\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010Õ\u0003\u001a\u00030à\u00012\u0007\u0010Ö\u0003\u001a\u00020yH\u0002J\u0013\u0010×\u0003\u001a\u00030à\u00012\u0007\u0010Ø\u0003\u001a\u00020yH\u0002J\u0013\u0010Ù\u0003\u001a\u00030à\u00012\u0007\u0010Ø\u0003\u001a\u00020yH\u0002J\n\u0010Ú\u0003\u001a\u00030à\u0001H\u0002J\u0014\u0010Û\u0003\u001a\u00030à\u00012\b\u0010Ü\u0003\u001a\u00030Ý\u0003H\u0002J\u001c\u0010Þ\u0003\u001a\u00030à\u00012\u0007\u0010ß\u0003\u001a\u00020y2\u0007\u0010à\u0003\u001a\u00020yH\u0002J\u0013\u0010á\u0003\u001a\u00030à\u00012\u0007\u0010\u0086\u0002\u001a\u00020oH\u0002J\u0013\u0010â\u0003\u001a\u00030à\u00012\u0007\u0010þ\u0001\u001a\u00020oH\u0014J\u0013\u0010ã\u0003\u001a\u00030à\u00012\u0007\u0010ä\u0003\u001a\u00020yH\u0014J\u0013\u0010å\u0003\u001a\u00030à\u00012\u0007\u0010Ê\u0001\u001a\u00020oH\u0002J4\u0010æ\u0003\u001a\u00030à\u00012\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010o2\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010o2\u0012\b\u0002\u0010ç\u0003\u001a\u000b\u0012\u0005\u0012\u00030Ã\u0002\u0018\u00010\bH\u0002J$\u0010è\u0003\u001a\u00030à\u00012\r\u0010é\u0003\u001a\b\u0012\u0004\u0012\u00020q0\b2\t\b\u0002\u0010ê\u0003\u001a\u00020yH\u0002J\n\u0010ë\u0003\u001a\u00030à\u0001H\u0002J\u001e\u0010ì\u0003\u001a\u00030à\u00012\u0007\u0010Ê\u0001\u001a\u00020o2\t\b\u0002\u0010í\u0003\u001a\u00020yH\u0002J\u001b\u0010î\u0003\u001a\u00030à\u00012\u000f\u0010ú\u0002\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\bH\u0002J\u0013\u0010ï\u0003\u001a\u00030à\u00012\u0007\u0010Ê\u0001\u001a\u00020oH\u0002J\u0016\u0010ð\u0003\u001a\u00030à\u00012\n\u0010ñ\u0003\u001a\u0005\u0018\u00010Ø\u0001H\u0002J\u001f\u0010ò\u0003\u001a\u00030à\u00012\n\u0010ó\u0003\u001a\u0005\u0018\u00010Ø\u00012\u0007\u0010ô\u0003\u001a\u00020yH\u0002J\u001f\u0010õ\u0003\u001a\u00030à\u00012\n\u0010ó\u0003\u001a\u0005\u0018\u00010Ø\u00012\u0007\u0010ô\u0003\u001a\u00020yH\u0002J\"\u0010ö\u0003\u001a\u00030à\u00012\n\u0010÷\u0003\u001a\u0005\u0018\u00010Ä\u00012\n\u0010ø\u0003\u001a\u0005\u0018\u00010Ä\u0001H\u0002J\r\u0010ù\u0003\u001a\u00020k*\u00020kH\u0002J\u000e\u0010ú\u0003\u001a\u00030à\u0001*\u00020oH\u0002J\u0017\u0010û\u0003\u001a\u00030à\u0001*\u00020o2\u0007\u0010\u0085\u0003\u001a\u00020yH\u0002J\u001b\u0010ü\u0003\u001a\u00030ý\u0003*\u00030þ\u00032\n\u0010á\u0002\u001a\u0005\u0018\u00010ë\u0001H\u0002J\u000e\u0010ÿ\u0003\u001a\u00030à\u0001*\u00020oH\u0002J\u001e\u0010\u0080\u0004\u001a\u00030à\u0001*\b\u0012\u0004\u0012\u00020\u000b0\b2\b\u0010þ\u0001\u001a\u00030\u0081\u0004H\u0002J\u000e\u0010\u0082\u0004\u001a\u00020\u000b*\u00030\u009a\u0003H\u0002J\u000f\u0010\u0083\u0004\u001a\u00020\u000b*\u0004\u0018\u00010oH\u0002J\u0011\u0010\u0084\u0004\u001a\u0005\u0018\u00010\u0085\u0004*\u00030\u009a\u0003H\u0002Jd\u0010\u0086\u0004\u001a\u00030à\u0001*\u00020&2\u0015\u0010\u0087\u0004\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0005\u0012\u00030à\u00010û\u00012\u0015\u0010\u0088\u0004\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0005\u0012\u00030à\u00010û\u00012\u000f\u0010\u0089\u0004\u001a\n\u0012\u0005\u0012\u00030à\u00010õ\u00022\b\u0010\u008a\u0004\u001a\u00030\u008b\u00042\r\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020o0\bJ\r\u0010\u008c\u0004\u001a\u00020y*\u00020oH\u0002J\u000f\u0010\u008d\u0004\u001a\u00030à\u0001*\u00030\u0081\u0004H\u0002J\u000f\u0010\u008e\u0004\u001a\u00030à\u0001*\u00030\u0081\u0004H\u0002J\u000f\u0010\u008f\u0004\u001a\u00030à\u0001*\u00030\u0081\u0004H\u0002J\u000f\u0010\u0090\u0004\u001a\u00030à\u0001*\u00030\u0081\u0004H\u0002J\u0014\u0010\u0091\u0004\u001a\u00030à\u0001*\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000f\u0010\u0092\u0004\u001a\u00030à\u0001*\u00030\u009a\u0003H\u0002J\u000e\u0010\u0093\u0004\u001a\u00030à\u0001*\u00020oH\u0002J\u000e\u0010\u0094\u0004\u001a\u00030à\u0001*\u00020oH\u0002J(\u0010\u0095\u0004\u001a\u0004\u0018\u00010\u000b*\u00020o2\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u00012\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u0096\u0004\u001a\u00030à\u0001*\u00020o2\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001H\u0002J?\u0010\u0097\u0004\u001a\u00030à\u0001*\u00020o2\n\u0010\u0098\u0004\u001a\u0005\u0018\u00010\u0099\u00042\n\u0010\u009a\u0004\u001a\u0005\u0018\u00010\u0099\u00042\n\u0010\u009b\u0004\u001a\u0005\u0018\u00010\u0099\u00042\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u000f\u0010\u009c\u0004\u001a\u00030à\u0001*\u00030\u009d\u0004H\u0002J\u000e\u0010\u009e\u0004\u001a\u00030à\u0001*\u00020oH\u0002J\u000f\u0010\u009f\u0004\u001a\u00030à\u0001*\u00030\u009a\u0003H\u0003J\u000e\u0010 \u0004\u001a\u00030à\u0001*\u00020oH\u0002J\u000e\u0010¡\u0004\u001a\u00030à\u0001*\u00020oH\u0002J\u000e\u0010¢\u0004\u001a\u00030à\u0001*\u00020oH\u0002J\u0018\u0010£\u0004\u001a\u00030à\u0001*\u00030\u009a\u00032\u0007\u0010¤\u0004\u001a\u00020yH\u0002J\u000e\u0010¥\u0004\u001a\u00030à\u0001*\u00020oH\u0002J\u000f\u0010¦\u0004\u001a\u00030à\u0001*\u00030§\u0004H\u0002J\u000f\u0010¨\u0004\u001a\u00030à\u0001*\u00030§\u0004H\u0002J\u001d\u0010©\u0004\u001a\u00030à\u0001*\b\u0012\u0004\u0012\u00020o0\b2\u0007\u0010ª\u0004\u001a\u00020yH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001e\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b7\u00108R\u0014\u00109\u001a\u00020:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010E\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bM\u0010NR\u0014\u0010Q\u001a\u00020R8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001e\u0010U\u001a\u00020V8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001b\u0010[\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010P\u001a\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u001e\u0010d\u001a\u00020e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010l\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010r\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\b2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bs\u0010tR\u000e\u0010u\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010z\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u007f\u001a\u00020y2\u0006\u00105\u001a\u00020y@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u000f\u0010\u0082\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0085\u0001\u001a\u00020y8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0087\u0001\u0010P\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u000f\u0010\u0088\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0089\u0001\u001a\u00020y2\u0006\u00105\u001a\u00020y@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\b\u008a\u0001\u0010\u0081\u0001R\u000f\u0010\u008b\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0093\u0001\u001a\u00020y2\u0006\u00105\u001a\u00020y@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\b\u0094\u0001\u0010\u0081\u0001R\u000f\u0010\u0095\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009c\u0001\u0010P\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0010\u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009f\u0001\u001a\u00030\u009e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010 \u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010¢\u0001\u001a\u0014\u0012\u0004\u0012\u00020o0£\u0001j\t\u0012\u0004\u0012\u00020o`¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010¨\u0001\u001a\u00030©\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\u0012\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010²\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0´\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010µ\u0001\u001a\u00030¶\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¹\u0001\u0010P\u001a\u0006\b·\u0001\u0010¸\u0001R\u0010\u0010º\u0001\u001a\u00030»\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010¼\u0001\u001a\u00030»\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010½\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010À\u0001\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010Á\u0001\u001a\u0004\u0018\u00010o2\b\u00105\u001a\u0004\u0018\u00010o@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\bÂ\u0001\u0010Ã\u0001R/\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u00012\t\u00105\u001a\u0005\u0018\u00010Ä\u0001@TX\u0094\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R%\u0010Ê\u0001\u001a\u0004\u0018\u00010o2\b\u00105\u001a\u0004\u0018\u00010o@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\bË\u0001\u0010Ã\u0001R\u0017\u0010Ì\u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Í\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010Î\u0001\u001a\u00030Ï\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R\u0018\u0010Ô\u0001\u001a\u00030Õ\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÖ\u0001\u0010×\u0001R'\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00012\t\u00105\u001a\u0005\u0018\u00010Ø\u0001@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\bÚ\u0001\u0010Û\u0001R'\u0010Ü\u0001\u001a\u0005\u0018\u00010Ø\u00012\t\u00105\u001a\u0005\u0018\u00010Ø\u0001@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\bÝ\u0001\u0010Û\u0001R\u0012\u0010Þ\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¬\u0004"}, d2 = {"Lid/dana/cashier/fragment/PayConfirmationFragment;", "Lid/dana/cashier/fragment/BaseCashierFragment;", "()V", "additionalFeeAdapter", "Lid/dana/cashier/adapter/CashierAdditionalFeeAdapter;", CashierKeyParams.AGREEMENT_INFO, "Lid/dana/domain/useragreement/model/AgreementInfo;", "agreementInfos", "", "availableShowcaseScenarios", "Ljava/util/Queue;", "", "bizScenario", "cashierAddOnModule", "Lid/dana/cashier/CashierAddOnModule;", "getCashierAddOnModule", "()Lid/dana/cashier/CashierAddOnModule;", "cashierAddOnPresenter", "Lid/dana/cashier/CashierAddOnContract$Presenter;", "getCashierAddOnPresenter", "()Lid/dana/cashier/CashierAddOnContract$Presenter;", "setCashierAddOnPresenter", "(Lid/dana/cashier/CashierAddOnContract$Presenter;)V", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "getCashierAnalyticTracker", "()Lid/dana/cashier/tracker/CashierAnalyticTracker;", "setCashierAnalyticTracker", "(Lid/dana/cashier/tracker/CashierAnalyticTracker;)V", "cashierCardBindingModule", "Lid/dana/cashier/CashierCardBindingModule;", "getCashierCardBindingModule", "()Lid/dana/cashier/CashierCardBindingModule;", "cashierCheckoutModel", "Lid/dana/cashier/model/CashierCheckoutModel;", "cashierComponent", "Lid/dana/di/component/CashierComponent;", "cashierHighlightConfigModel", "Lid/dana/cashier/model/CashierHighlightConfigModel;", "cashierHighlightModule", "Lid/dana/cashier/CashierHighlightModule;", "getCashierHighlightModule", "()Lid/dana/cashier/CashierHighlightModule;", "cashierHighlightPresenter", "Lid/dana/cashier/presenter/CashierHighlightPresenter;", "getCashierHighlightPresenter", "()Lid/dana/cashier/presenter/CashierHighlightPresenter;", "setCashierHighlightPresenter", "(Lid/dana/cashier/presenter/CashierHighlightPresenter;)V", "cashierModule", "Lid/dana/di/modules/CashierModule;", "getCashierModule", "()Lid/dana/di/modules/CashierModule;", "value", CashierKeyParams.CASHIER_ORDER_ID, "setCashierOrderId", "(Ljava/lang/String;)V", "cashierPayLaterModule", "Lid/dana/cashier/CashierPayLaterModule;", "getCashierPayLaterModule", "()Lid/dana/cashier/CashierPayLaterModule;", "cashierPayLaterPresenter", "Lid/dana/cashier/CashierPayLaterContract$Presenter;", "getCashierPayLaterPresenter", "()Lid/dana/cashier/CashierPayLaterContract$Presenter;", "setCashierPayLaterPresenter", "(Lid/dana/cashier/CashierPayLaterContract$Presenter;)V", "cashierPayMethodAdapter", "Lid/dana/cashier/adapter/CashierPayMethodAdapter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "getCashierPresenter", "()Lid/dana/cashier/CashierContract$Presenter;", "setCashierPresenter", "(Lid/dana/cashier/CashierContract$Presenter;)V", "cashierPromotionAppliedBottomSheetDialog", "Lid/dana/cashier/bottomsheet/CashierPromotionAppliedBottomSheetDialog;", "getCashierPromotionAppliedBottomSheetDialog", "()Lid/dana/cashier/bottomsheet/CashierPromotionAppliedBottomSheetDialog;", "cashierPromotionAppliedBottomSheetDialog$delegate", "Lkotlin/Lazy;", "cashierRiskChallengeModule", "Lid/dana/di/modules/CashierRiskChallengeModule;", "getCashierRiskChallengeModule", "()Lid/dana/di/modules/CashierRiskChallengeModule;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "getCashierRiskChallengePresenter", "()Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "setCashierRiskChallengePresenter", "(Lid/dana/cashier/presenter/CashierRiskChallengePresenter;)V", "cashierSmartpayBottomSheetDialog", "Lid/dana/cashier/bottomsheet/CashierSmartpayBottomSheetDialog;", "getCashierSmartpayBottomSheetDialog", "()Lid/dana/cashier/bottomsheet/CashierSmartpayBottomSheetDialog;", "cashierSmartpayBottomSheetDialog$delegate", "cashierUserRelatedModule", "Lid/dana/cashier/CashierUserRelatedModule;", "getCashierUserRelatedModule", "()Lid/dana/cashier/CashierUserRelatedModule;", "cashierUserRelatedPresenter", "Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "getCashierUserRelatedPresenter", "()Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "setCashierUserRelatedPresenter", "(Lid/dana/cashier/CashierUserRelatedContract$Presenter;)V", CashierKeyParams.CHECKOUT_EXTERNAL_INFO, "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "contentSkeletons", "Lcom/ethanhua/skeleton/SkeletonScreen;", "defaultFirstPaymentMethod", "Lid/dana/cashier/model/CashierPayMethodModel;", "defaultSecondPaymentMethod", "Lid/dana/cashier/model/CashierOrderGoodModel;", "displayableAddons", "setDisplayableAddons", "(Ljava/util/List;)V", "epAddonId", CashierKeyParams.EXCHANGE_RATE, "Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;", "hasAdditionalFees", "", "headerSkeletons", "isActivityBottomSheetAlreadyExpanded", "isAllSkeletonDismissed", "isAutoroutedAssetExist", "isCashierInfoFilled", "isCheckBoxMixPayBalanceChecked", "setCheckBoxMixPayBalanceChecked", "(Z)V", "isEnableUpdatePromo", "isFirstTimeQueryInstallment", "isFirstTimeShowOnboardingPaylaterCicil", "isFromCpm", "()Z", "isFromCpm$delegate", "isNeedToShowOnboardingPaylaterCicil", "isNeedToShowSmartPayLogo", "setNeedToShowSmartPayLogo", "isNeedToShowSmartpayDialog", "isNeedToShowTooltipHighlight", "isNeededToResetAddon", "isPromotionAppliedBottomSheetDialogShowed", "isQrisCrossBorder", "isQueryInstallmentFinish", "isReloadCashierSmartPayInfo", "isShowOnboardingPaylaterCicil", "isShowShimmerPayMethod", "setShowShimmerPayMethod", "isTooltipVersionUpdated", "isUserSelectOtherPaymentMethod", "merchantId", "merchantModel", "Lid/dana/cashier/model/CashierMerchantModel;", "getMerchantModel", "()Lid/dana/cashier/model/CashierMerchantModel;", "merchantModel$delegate", "payConfirmationInitTime", "", "payConfirmationReadyTime", "payMethodAmountSkeletons", "payMethodFilter", "payMethodModels", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "payMethodSkeletons", CashierKeyParams.PAY_RESULT_MODEL, "Lid/dana/cashier/model/PayResultModel;", "paylaterAnalyticTracker", "Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "getPaylaterAnalyticTracker", "()Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "setPaylaterAnalyticTracker", "(Lid/dana/cashier/tracker/PaylaterAnalyticTracker;)V", "paylaterCicilOnboardingDialog", "Lid/dana/cashier/PaylaterCicilOnboardingDialog;", "paylaterCicilRegistrationErrorDialog", "Lid/dana/dialog/TwoButtonWithImageDialog;", "paylaterRepaymentSource", "paymentSelectMethods", "", "permissionLocationAndPhoneRequestBuilder", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest$Builder;", "getPermissionLocationAndPhoneRequestBuilder", "()Lcom/anggrayudi/storage/permission/FragmentPermissionRequest$Builder;", "permissionLocationAndPhoneRequestBuilder$delegate", "permissionPaylaterOnceCheckAddon", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "permissionPaylaterOncePay", "previousCardbin", "queryInstallmentModel", "Lid/dana/cashier/model/QueryInstallmentModel;", "secondPayMethodOrderAmount", "selectedBalanceMixPaymentMethod", "setSelectedBalanceMixPaymentMethod", "(Lid/dana/cashier/model/CashierPayMethodModel;)V", "Lid/dana/cashier/model/VoucherCashierModel;", "selectedCashierPromo", "getSelectedCashierPromo", "()Lid/dana/cashier/model/VoucherCashierModel;", "setSelectedCashierPromo", "(Lid/dana/cashier/model/VoucherCashierModel;)V", "selectedPaymentMethod", "setSelectedPaymentMethod", "stickyButtonSkeletons", "tncAgreementDialog", "tncCardPaymentEventHandler", "Lid/dana/cashier/TncCardPaymentEventHandler;", "getTncCardPaymentEventHandler", "()Lid/dana/cashier/TncCardPaymentEventHandler;", "setTncCardPaymentEventHandler", "(Lid/dana/cashier/TncCardPaymentEventHandler;)V", "topUpAndPayModule", "Lid/dana/di/modules/TopUpAndPayModule;", "getTopUpAndPayModule", "()Lid/dana/di/modules/TopUpAndPayModule;", "Lid/dana/model/CurrencyAmountModel;", "totalAddOnAmount", "setTotalAddOnAmount", "(Lid/dana/model/CurrencyAmountModel;)V", "totalAmountCashier", "setTotalAmountCashier", "upgradeCardDialog", "animatePaymethodEntrance", "", "autoSelectPaymentMethod", "payMethodList", "isNeedToShowMixPayTooltip", "checkPayMethodShowcaseAvailability", "isMixPaymentAssetExist", "checkVerifyElements", "checkWhetherMixPayChecked", "clearCachePayLaterLoanWhitelistFromRepaymentIfFromRepayment", "configToolbar", "createInsufficientBalanceShowcaseContent", "Lid/dana/showcase/Content;", "createSmartpayAutoselectShowcaseContent", "createSmartpayAvailableShowcaseContent", "createSpannableString", "Landroid/text/SpannableString;", "description", "descriptionListener", "Landroid/view/View$OnClickListener;", "createTooltipHighlightShowcaseContent", "disablePaylaterCicilPayMethod", "cashierPayMethodModels", Constants.ENABLE_DISABLE, "isDisabledSticky", "disableDescription", "disableReason", "reRoutePayMethods", "Lkotlin/Function1;", "dismissSkeleton", "doCashierPay", "payMethod", CashierKeyParams.INSTALLMENT_PERIOD, "", "(Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/Integer;)V", "doGetQueryInstallment", "doRefreshCashierInfoAddOn", CustomDialogKey.Response.IS_CHECKED, "addOnId", "cashierPayMethodModel", "doRefreshQueryInstallment", "expandActivityBottomSheet", "expandBottomSheetForDanaCicil", "currentSelectedPayMethod", "newSelectedPayMethod", "expandLoanCredit", "isExpanded", "expandPaymentMethod", "expandStickyBottomMixPayMethod", "isNeedToExpandStickyBottomMixPay", "getCashierBalancePayMethodViewHolder", "Lid/dana/cashier/viewholder/GeneralPayMethodViewHolder;", "getContentFromScenario", "scenario", "getLayout", "getPayConfirmationReadyDuration", "getPayMethodTooltipHighlightScenario", "getPayMethodsWithBalanceStateUpdated", "getPaylaterInstallmentPeriod", "()Ljava/lang/Integer;", "getPaylaterRepaymentType", "getPaymentConfirmationSource", "getQueryInstallmentAddOn", "", "selectedAddOnIds", "getQueryInstallmentCouponId", "isFromPayButton", "getQueryInstallmentRequestModel", "Lid/dana/cashier/model/QueryInstallmentRequestModel;", "addOnIds", "couponIds", "getSelectedAddonIds", "getSelectedPayMethodQueryInstallment", "getTncCardPaymentUrl", "getTooltipActionBtnText", "getTopUpDialogDescription", "getTopUpDialogTitle", "getTopUpUrl", "goToAddNewCardPage", "goToInstallmentSelectionPage", "goToPaymentResultPage", "status", "errorMessage", "errorCode", "addonId", "transactionScenario", "reloadBalance", "goToTopUpPage", "handleRiskPhase", "attributeCashierPayModel", "Lid/dana/cashier/model/AttributeCashierPayModel;", "handleShowAddOnView", "handleSmartPayVisibility", "hasAutoRoutedToLoanCredit", "defaultOption", "hideRibbonHighlight", IAPSyncCommand.COMMAND_INIT, "initAdditionalFeeAdapter", "initAdditionalFeeRecyclerView", "fees", "Lid/dana/cashier/model/AdditionalFeeModel;", "initCashierAddOn", "initCashierInfo", "initCashierListener", "initCashierPromoSelectedListener", "initClickChangePayMethodListener", "initComponent", "initDanaPlusInfo", "initDanaProtectionLoading", "initLoanGetQueryInstallment", "initNestedScrollView", "initOnClickChangePromo", "initOnClickViewListener", "initPayMethodAdapter", "initPayMethodRecyclerView", "initPermission", "initProceedQueryInstallment", "initViewPaymentMethodLayoutChangeListener", "initViews", TrackerKey.CashierProperties.IS_AUTOROUTING, "autoroutedAssetExist", "autoroutedPayChannels", "Lid/dana/cashier/model/AssetCardModel;", TrackerKey.CashierProperties.IS_BALANCE_SUFFICIENT, "isExchangeRateDifferent", "currentExchangeRate", "Lid/dana/cashier/model/ExchangeRateModel;", "isPaylaterEligibleInPayment", "isSelectedPaymentMethodAutoRoutedToLoanCredit", "launchPayMethodShowcase", "content", "delay", "onBackPressed", "onClickCashierAddOnCheckBox", "onClickCashierAddOnInfo", "onClickCashierPromo", "Lid/dana/cashier/CashierPromoListener;", "onClickPay", "onClickSmartPayLogo", "onDanaPlusTncClicked", "tncUrl", "onDestroy", "onPermissionGrantedFaceAuth", "onRequestCashierSmileToPay", "riskParamsFactory", "Lid/dana/cashier/RiskParamsFactory;", "onRiskFaceAuthFallback", "onStart", "paylaterPermissionRequest", "actionAllPermissionsGranted", "Lkotlin/Function0;", "actionIfAnyPermissionNotGranted", "prepareBundle", "reRouteFailedRegistrationPaylaterCicil", "isInMixPaymentMode", "payMethods", "recordUserAgreementForTncCardPayment", "resetAddOnCheckboxState", "currentValue", "resetTotalAddonAmount", "newValue", "resetTotalAmountCashierWithAddOn", "saveDismissRegistrationCountAndDelayTime", "cacheCooldownCount", "sendOneKlikPhoneNumberToActivity", "setCancelPayLaterCicilDialog", "isFromSelectPayMethod", "isRegistrationErrorDialog", "setCashierPayViewWithRisk", "hasCvv2RiskChallenge", "setClickableSpan", "spannableString", "clickableSpan", "Landroid/text/style/ClickableSpan;", "setDisablePaylaterCicil", "setDisableSelectedAndListPaylaterCicilPayMethod", "setFailedRegistrationPaylaterCicil", "errorMsg", "throwable", "", "operationType", "source", "setFeeItems", "previousFees", "newFees", "setMerchantInfo", "attributeModel", "Lid/dana/cashier/model/AttributeModel;", "setPayButtonState", "isActive", "buttonTitle", "isShowAmount", "setPaymentInfo", "setPaymentMethod", "selectedPayMethod", "setPaymentSelectMethods", "setPreloadMerchantInfo", "setSelectedPayMethodState", "setSelectedPayMethodStickyLabel", "mixPayLabel", "normalPayLabel", "setTncAndLoanAgreement", "setTncCardPaymentListener", "setTncListener", "setTvMerchantTypeRollingTextLayout", "rollingText", "setupAutoRouteCashier", "setupCheckoutInfo", "setupOnBoardingPaylaterCicil", "loanCreditPayMethod", "setupPayMethod", "setupPaylaterCicilPayMethodAction", "setupPaylaterCicilPayMethodListAndSticky", "showBottomSheetSmartpayDialog", "showExchangeRateDialog", "showMerchantLogo", "showMerchantName", "showMerchantType", "showMixpayNotAvailableDialog", "showNewHighlight", "instId", "isNeedToShowHighlightNew", "showPaylaterCicilOnboardingDialog", "paylaterOnboardingContentModel", "Lid/dana/cashier/model/PaylaterOnboardingContentModel;", "showPaylaterCicilOnboardingDialogShimmer", "showPaylaterCicilRegistrationErrorDialog", "showPermissionConsentDialog", "request", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "actionNegativeButton", "showPopUpTncAgreement", "showPopUpTopUpBalance", "showPopUpUpgrade", "showPromotionAppliedBottomSheetDialog", "showRibbonHighlight", "showSkeleton", "showSomeCardNotSupportedMixPayInfo", "someCardNotSupport", "showViewGlobalSendDetail", "intlOrderInfoDTO", "Lid/dana/cashier/model/IntlOrderInfoDTOModel;", "showWarningToastAddOn", "isInsufficientPaylaterLimit", "startWithDelay", "block", "successRecordTncCardPaymentAgreement", "userAgreed", "toggleInstallmentDetailView", "isVisible", "toggleSubtotalGroup", "trackPaylaterRepaymentConfirmationOpen", "trackPaymentConfirmationOpen", "addOnTrackingModel", "Lid/dana/cashier/model/AddOnTrackingModel;", "trackPaymentConfirmationOpenWithCicil", "registered", "payMethodActive", "trackPaymentConfirmationOpenWithPayLaterCicil", "trackPaymentExecution", "trackPaymentFaceRiskChallenge", "isFaceVerificationSuccess", "trackPaymentSelectMethod", "updateAdditionalFees", "newAdditionalFees", "updateAddons", "addOns", "isFirstTime", "updateBalanceState", "updateDisplayedAddonState", "choosable", "updatePayMethodItems", "updatePromo", "updateSubtotal", "currentAddOnAmount", "updateTotalAddOnAmount", "selectedAddOnAmount", "isAddOnChecked", "updateTotalPriceWithAddOn", "updateTotalPriceWithPromo", "previousPromo", "newPromo", "applyAddOnAndSelectedPayOption", "checkNeedShowPaymentTypeLogo", "checkOnBoardingPaymentMethodPaylaterCicil", "createPayMethodShowcaseTarget", "Lid/dana/showcase/target/Target;", "Landroid/view/View;", "dismissShimmerFirstPayMethod", "doActionForVerifyElements", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "getCashierOrderTitle", "getPaylaterCicilUnregisDesc", "getTotalAmount", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "highlightShowMode", "ribbonMode", "tooltipMode", "onElse", "cashierHighlightCache", "Lid/dana/cashier/domain/model/CashierHighlightCache;", "isNeedQrisTncAgreement", "openEktpPhoneChallenge", "openLimitAmountDailyChallenge", "openPhoneNumberChallenge", "openVerifyElementsChallenge", "removeIfContainsSmartpayTooltip", "resetTotalAmountCashier", "setBottomLableFirstPaymentMethodInfo", "setBottomLableSecondPaymentMethodInfo", "setPaylaterCicilDescInfo", "setPaylaterCicilInfo", "setSelectedPayMethodLabel", "tvAccountSource", "Landroidx/appcompat/widget/AppCompatTextView;", "tvAccountNumber", "tvSecondaryDesc", "setSwipeListener", "Landroid/view/ViewGroup;", "showAdditionalInfo", "showExchangeRate", "showPaylaterPromoBadge", "showPaymentMethodExtraInfo", "showSecondaryDescription", "showSendMoneyInfo", "isBalanceFamily", "showTextUpgradeDirectDebit", "updateBalanceOrderAmount", "Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;", "updateBalancePayMethodLabel", "updatePayMethodListAndSticky", "isFromRefreshCashierAddOn", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayConfirmationFragment extends BaseCashierFragment {
    public static final Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion(null);
    private static PayConfirmationFragment moveToNextValue;
    private boolean A;
    private boolean AppCompatEmojiTextHelper;
    private boolean B;
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;
    private boolean C;
    private List<AgreementInfo> DatabaseTableConfigUtil;
    private boolean F;
    private CurrencyAmountModel FillAnimation;
    private CashierPayMethodModel FragmentBottomSheetPaymentSettingBinding;
    private boolean G;
    private boolean H;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private CashierAdditionalFeeAdapter NetworkUserEntityData$$ExternalSyntheticLambda0;
    private CashierCheckoutModel NetworkUserEntityData$$ExternalSyntheticLambda1;
    private AgreementInfo NetworkUserEntityData$$ExternalSyntheticLambda2;
    private CashierPayMethodModel NetworkUserEntityData$$ExternalSyntheticLambda4;
    private List<? extends SkeletonScreen> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private CheckoutExternalInfo NetworkUserEntityData$$ExternalSyntheticLambda6;
    private CashierPayMethodAdapter NetworkUserEntityData$$ExternalSyntheticLambda7;
    private long O;
    private boolean P;
    private String Q;
    private VoucherCashierModel QrExpiredActivity;
    private List<? extends SkeletonScreen> R;
    private String S;
    private CurrencyRateModel SubSequence;
    private boolean SummaryVoucherView$$ExternalSyntheticLambda0;
    private long SummaryVoucherView$$ExternalSyntheticLambda1;
    private List<? extends SkeletonScreen> SummaryVoucherView$$ExternalSyntheticLambda2;
    private TwoButtonWithImageDialog T;
    private CurrencyAmountModel TypeProjectionImpl;
    private PayResultModel V;
    private boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    private PaylaterCicilOnboardingDialog X;
    private FragmentPermissionRequest Y;

    /* renamed from: a */
    private String f8036a;
    private List<? extends SkeletonScreen> b;
    private CashierPayMethodModel c;
    @Inject
    public CashierAddOnContract.Presenter cashierAddOnPresenter;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierHighlightPresenter cashierHighlightPresenter;
    @Inject
    public CashierPayLaterContract.Presenter cashierPayLaterPresenter;
    @Inject
    public CashierContract.Presenter cashierPresenter;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;
    @Inject
    public CashierUserRelatedContract.Presenter cashierUserRelatedPresenter;
    private CashierPayMethodModel d;
    private TwoButtonWithImageDialog e;
    private FragmentPermissionRequest flip;
    private TwoButtonWithImageDialog g;
    private boolean getNameOrBuilderList;
    private List<CashierOrderGoodModel> getSupportButtonTintMode;
    private boolean getValueOfTouchPositionAbsolute;
    private QueryInstallmentModel isAuto;
    private CashierHighlightConfigModel isLayoutRequested;
    private CashierComponent newProxyInstance;
    @Inject
    public PaylaterAnalyticTracker paylaterAnalyticTracker;
    private boolean readMicros;
    @Inject
    public TncCardPaymentEventHandler tncCardPaymentEventHandler;
    private List<? extends SkeletonScreen> whenAvailable;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    private boolean getOnBoardingScenario = true;
    private boolean I = true;
    private boolean D = true;
    private boolean E = true;
    private String PrepareContext = "";
    private String getCallingPid = "";
    private String shouldRecycleViewType = "";
    private Queue<String> initRecordTimeStamp = new LinkedList();
    private final List<String> U = new ArrayList();
    private final Lazy VerifyPinStateManager$executeRiskChallenge$2$2 = LazyKt.lazy(new Function0<Boolean>;
    private String GetContactSyncConfig = "";
    private String W = "";
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda8 = LazyKt.lazy(new Function0<CashierPromotionAppliedBottomSheetDialog>;
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda3 = LazyKt.lazy(new Function0<CashierSmartpayBottomSheetDialog>;
    private ArrayList<CashierPayMethodModel> isAuth = new ArrayList<>();
    private final Lazy Z = LazyKt.lazy(new Function0<FragmentPermissionRequest.Builder>;
    private final Lazy N = LazyKt.lazy(new Function0<CashierMerchantModel>;

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void BottomSheetCardBindingView$watcherCardNumberView$1(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BottomSheetCardBindingView$watcherCardNumberView$1():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void Q(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.Q(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void S(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.S(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void SummaryVoucherView$$ExternalSyntheticLambda1(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.SummaryVoucherView$$ExternalSyntheticLambda1(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void getCallingPid(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getCallingPid():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final android.view.View BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(int):android.view.View, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.base.BaseFragment
    public final int getLayout(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getLayout():int, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.onDestroyView():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public PayConfirmationFragment(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.<init>():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, java.lang.String, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void DatabaseTableConfigUtil(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.DatabaseTableConfigUtil(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void DatabaseTableConfigUtil(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.DatabaseTableConfigUtil(id.dana.cashier.fragment.PayConfirmationFragment, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, com.anggrayudi.storage.permission.PermissionRequest, kotlin.jvm.functions.Function0):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.model.CurrencyAmountModel, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.model.CurrencyAmountModel, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.fragment.PayConfirmationFragment, int, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.PaylaterOnboardingContentModel, int, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void R(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.R(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void SummaryVoucherView$$ExternalSyntheticLambda2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.SummaryVoucherView$$ExternalSyntheticLambda2(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void moveToNextValue(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.moveToNextValue(id.dana.cashier.fragment.PayConfirmationFragment, int, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void scheduleImpl(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.scheduleImpl(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    @kotlin.jvm.JvmName(name = "getSelectedCashierPromo")
    /* renamed from: MyBillsEntityDataFactory */
    public final id.dana.cashier.model.VoucherCashierModel getQrExpiredActivity(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory():id.dana.cashier.model.VoucherCashierModel, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    @kotlin.jvm.JvmName(name = "setSelectedCashierPromo")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.model.VoucherCashierModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(java.util.List<id.dana.cashier.model.CashierOrderGoodModel>, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @kotlin.jvm.JvmName(name = "setSelectedPaymentMethod")
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.CashierPayMethodModel, java.util.List<id.dana.cashier.model.AdditionalFeeModel>):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.AttributeModel, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @kotlin.jvm.JvmName(name = "setSelectedBalanceMixPaymentMethod")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void GetContactSyncConfig(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.GetContactSyncConfig(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @kotlin.jvm.JvmName(name = "setCheckBoxMixPayBalanceChecked")
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @kotlin.jvm.JvmName(name = "isFromCpm")
    private final boolean L(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.L():boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @kotlin.jvm.JvmName(name = "setTotalAmountCashier")
    private final void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.model.CurrencyAmountModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @kotlin.jvm.JvmName(name = "setShowShimmerPayMethod")
    public final void scheduleImpl(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.scheduleImpl(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @kotlin.jvm.JvmName(name = "setNeedToShowSmartPayLogo")
    private final void lookAheadTest(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.lookAheadTest(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void lookAheadTest(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.lookAheadTest(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda0(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void scheduleImpl(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.scheduleImpl(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.CashierPayMethodModel, androidx.appcompat.widget.AppCompatTextView, androidx.appcompat.widget.AppCompatTextView, androidx.appcompat.widget.AppCompatTextView, java.lang.String):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.QueryInstallmentModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.QueryInstallmentModel, java.lang.String):java.lang.String, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(int, boolean, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final java.lang.String BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.model.CashierPayMethodModel):java.lang.String, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(int):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void AppCompatEmojiTextHelper(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.AppCompatEmojiTextHelper():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda7(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PrepareContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PrepareContext(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void DatabaseTableConfigUtil(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.DatabaseTableConfigUtil(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment
    public final void init(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.init():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void moveToNextValue(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.moveToNextValue():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void G(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.G():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.model.QueryInstallmentModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>, boolean, java.lang.String):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>, boolean, boolean, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1<? super java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>, ? extends java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>>):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final id.dana.cashier.model.CashierPayMethodModel MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.model.CashierPayMethodModel, boolean, boolean, java.lang.String, java.lang.String):id.dana.cashier.model.CashierPayMethodModel, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.Throwable, java.lang.String, java.lang.String):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.model.CashierCheckoutModel, id.dana.cashier.model.CashierPayMethodModel, java.lang.String):boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static boolean getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.model.CashierPayMethodModel, boolean, java.lang.String):boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel>):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String VerifyPinStateManager$executeRiskChallenge$2$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.VerifyPinStateManager$executeRiskChallenge$2$2():java.lang.String, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.CashierMerchantModel, id.dana.cashier.model.AttributeModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.model.CashierMerchantModel, id.dana.cashier.model.AttributeModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.model.CashierMerchantModel, id.dana.cashier.model.AttributeModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.CashierMerchantModel, id.dana.cashier.model.AttributeModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(java.lang.String):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(java.util.List<id.dana.cashier.model.AdditionalFeeModel>, java.util.List<id.dana.cashier.model.AdditionalFeeModel>):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void getErrorConfigVersion(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getErrorConfigVersion(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.base.BaseFragment
    public final boolean onBackPressed(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.onBackPressed():boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getErrorConfigVersion(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getErrorConfigVersion():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.RiskParamsFactory):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void J(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.J():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final id.dana.cashier.domain.model.CheckoutExternalInfo PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.domain.model.CheckoutExternalInfo):id.dana.cashier.domain.model.CheckoutExternalInfo, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(boolean, java.lang.String, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void getOnBoardingScenario(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getOnBoardingScenario():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.model.VoucherCashierModel, id.dana.cashier.model.VoucherCashierModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.model.CurrencyAmountModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.showcase.Content MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(java.lang.String):id.dana.showcase.Content, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final id.dana.showcase.Content VerifyPinStateManager$executeRiskChallenge$2$1(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.VerifyPinStateManager$executeRiskChallenge$2$1():id.dana.showcase.Content, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final id.dana.showcase.Content E(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.E():id.dana.showcase.Content, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final id.dana.showcase.Content C(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.C():id.dana.showcase.Content, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final id.dana.showcase.Content getValueOfTouchPositionAbsolute(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getValueOfTouchPositionAbsolute():id.dana.showcase.Content, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final boolean A(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.A():boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void lookAheadTest(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.lookAheadTest():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda0():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final java.lang.String I(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.I():java.lang.String, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(boolean, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.AddOnTrackingModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final java.lang.String F(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.F():java.lang.String, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(boolean, java.util.List<id.dana.cashier.model.AssetCardModel>, id.dana.cashier.model.CashierPayMethodModel):boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void getErrorConfigVersion(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getErrorConfigVersion(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final boolean getNameOrBuilderList(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getNameOrBuilderList():boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void initRecordTimeStamp(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.initRecordTimeStamp(id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(boolean, java.lang.String, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void M(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.M():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final java.util.List<id.dana.cashier.model.CashierPayMethodModel> D(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.D():java.util.List<id.dana.cashier.model.CashierPayMethodModel>, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final boolean moveToNextValue(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.moveToNextValue(id.dana.cashier.model.CashierPayMethodModel):boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final java.util.List<java.lang.String> H(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.H():java.util.List<java.lang.String>, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void whenAvailable(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.whenAvailable():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void initRecordTimeStamp(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.initRecordTimeStamp():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.onDestroy():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final com.anggrayudi.storage.permission.FragmentPermissionRequest getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.jvm.functions.Function0<kotlin.Unit>):com.anggrayudi.storage.permission.FragmentPermissionRequest, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void PrepareContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PrepareContext():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final java.util.Map<java.lang.String, java.lang.Boolean> BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(java.util.List<java.lang.String>, java.util.List<id.dana.cashier.model.CashierOrderGoodModel>):java.util.Map<java.lang.String, java.lang.Boolean>, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.cashier.model.QueryInstallmentRequestModel getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.model.CashierPayMethodModel, java.util.Map<java.lang.String, java.lang.Boolean>, java.util.List<java.lang.String>):id.dana.cashier.model.QueryInstallmentRequestModel, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final java.util.List<java.lang.String> KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(boolean):java.util.List<java.lang.String>, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.CashierCheckoutModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public final void K(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.K():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final java.lang.String MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.model.AttributeModel):java.lang.String, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    private final boolean PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.model.ExchangeRateModel):boolean, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    @Override // androidx.fragment.app.Fragment
    public final void onStart(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.onStart():void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/PayConfirmationFragment$Companion;", "", "Lid/dana/cashier/fragment/PayConfirmationFragment;", "moveToNextValue", "Lid/dana/cashier/fragment/PayConfirmationFragment;", "getAuthRequestContext", "()Lid/dana/cashier/fragment/PayConfirmationFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */
        public /* synthetic */ Companion(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.Companion.<init>(kotlin.jvm.internal.DefaultConstructorMarker):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            */
        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */

        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */
        private Companion(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.Companion.<init>():void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            */
        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */

        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */
        @kotlin.jvm.JvmName(name = "getAuthRequestContext")
        public static id.dana.cashier.fragment.PayConfirmationFragment getAuthRequestContext(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.Companion.getAuthRequestContext():id.dana.cashier.fragment.PayConfirmationFragment, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            */
        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */

        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */
        public static /* synthetic */ id.dana.cashier.fragment.PayConfirmationFragment PlaceComponentResult(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.Companion.PlaceComponentResult(id.dana.cashier.model.CashierCheckoutRequestModel, id.dana.cashier.model.CashierMerchantModel, id.dana.cashier.model.CashierPayMethodModel, boolean, id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel, int):id.dana.cashier.fragment.PayConfirmationFragment, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            */
        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException
            */
    }

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(kotlin.jvm.functions.Function0):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.fragment.PayConfirmationFragment, int, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, int, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.fragment.PayConfirmationFragment, int):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void getErrorConfigVersion(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getErrorConfigVersion(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, int, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.fragment.PayConfirmationFragment, int, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.fragment.PayConfirmationFragment, java.lang.Throwable):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void scheduleImpl(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.scheduleImpl(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, android.view.View):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.PayMethodInitModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void moveToNextValue(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.moveToNextValue(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.CashierCheckoutModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, java.lang.String, id.dana.cashier.model.PaylaterOnboardingContentModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ id.dana.showcase.target.Target BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, android.view.View, id.dana.showcase.Content):id.dana.showcase.target.Target, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void initRecordTimeStamp(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.initRecordTimeStamp(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void DatabaseTableConfigUtil(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.DatabaseTableConfigUtil(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.fragment.PayConfirmationFragment, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ id.dana.cashier.viewholder.GeneralPayMethodViewHolder GetContactSyncConfig(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.GetContactSyncConfig(id.dana.cashier.fragment.PayConfirmationFragment):id.dana.cashier.viewholder.GeneralPayMethodViewHolder, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, java.lang.String):java.lang.String, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void BottomSheetCardBindingView$watcherCardNumberView$1(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BottomSheetCardBindingView$watcherCardNumberView$1(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.QueryInstallmentModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.AttributeCashierPayModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void MyBillsEntityDataFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.MyBillsEntityDataFactory(id.dana.cashier.fragment.PayConfirmationFragment, id.dana.cashier.model.QueryInstallmentModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ id.dana.cashier.CashierPromoListener H(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.H(id.dana.cashier.fragment.PayConfirmationFragment):id.dana.cashier.CashierPromoListener, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ java.util.List BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, boolean, java.util.List, id.dana.cashier.model.CashierPayMethodModel):java.util.List, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(java.util.Queue):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.PayConfirmationFragment, java.util.List):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void O(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.O(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ java.util.List getAuthRequestContext(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.getAuthRequestContext(id.dana.cashier.fragment.PayConfirmationFragment, java.util.List, id.dana.cashier.model.QueryInstallmentModel):java.util.List, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.fragment.PayConfirmationFragment, java.util.List, id.dana.cashier.model.CashierPayMethodModel):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ java.util.List PlaceComponentResult(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.PlaceComponentResult(id.dana.cashier.fragment.PayConfirmationFragment, java.util.List, id.dana.cashier.model.QueryInstallmentModel):java.util.List, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void P(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.P(id.dana.cashier.fragment.PayConfirmationFragment):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */

    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.fragment.PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.PayConfirmationFragment, java.lang.String, boolean):void, class status: PROCESS_COMPLETE
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:155)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /*  JADX ERROR: NullPointerException in pass: InlineMethods
        java.lang.NullPointerException
        */
}
