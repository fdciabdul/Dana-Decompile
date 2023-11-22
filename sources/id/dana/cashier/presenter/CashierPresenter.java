package id.dana.cashier.presenter;

import android.content.Context;
import com.alibaba.ariver.kernel.RVEvents;
import dagger.Lazy;
import id.dana.R;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierParamsFactory;
import id.dana.cashier.domain.interactor.CashierUpdateOrder;
import id.dana.cashier.domain.interactor.CheckNeedToShowSmartpayDialog;
import id.dana.cashier.domain.interactor.CreateCashierOrder;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo;
import id.dana.cashier.domain.interactor.GetCashierKybProduct;
import id.dana.cashier.domain.interactor.GetCurrencyFromCdn;
import id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls;
import id.dana.cashier.domain.interactor.GetQueryPromotion;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.SaveLastSmartpayActivationShow;
import id.dana.cashier.domain.model.CashierCurrencyFromCdn;
import id.dana.cashier.domain.model.CashierKybOrderDetail;
import id.dana.cashier.domain.model.CashierKybProductInfo;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CreateOrderInfo;
import id.dana.cashier.domain.model.QueryPromotionInfo;
import id.dana.cashier.helper.CashierCheckoutModelExt;
import id.dana.cashier.helper.CashierErrorHelper;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierErrorType;
import id.dana.cashier.helper.CashierInitParamHelper;
import id.dana.cashier.helper.CashierPayMethodModelExt;
import id.dana.cashier.mapper.CashierCheckoutModelMapper;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.QueryPromotionModelMapper;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierFaceAuthModel;
import id.dana.cashier.model.CashierKybOrderDetailModelKt;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.CashierUpdateOrderRequestModel;
import id.dana.cashier.model.PaylaterCashierRequestCheckoutModel;
import id.dana.cashier.model.QueryPromotionModel;
import id.dana.cashier.model.QueryPromotionRequestModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.utils.AddOnAttributeCacheManager;
import id.dana.cashier.utils.CashierPayQueryCounter;
import id.dana.cashier.utils.CashierPromoVoucherManager;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.model.UserAutoRouteConfigStore;
import id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckAutoRouteSmartPayFeature;
import id.dana.domain.featureconfig.interactor.CheckMixPayFeature;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.qrbarcode.PreCreateOrderRequest;
import id.dana.domain.qrbarcode.interactor.PreCreateCashierOrder;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.rpc.response.DefaultResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 \u009b\u00012\u00020\u00012\u00020\u0002:\u0002\u009b\u0001Bö\u0002\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020Z\u0012\r\u0010\u0006\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010Q\u0012\u0006\u0010\u0007\u001a\u00020I\u0012\u0006\u0010\f\u001a\u00020K\u0012\u0006\u0010-\u001a\u00020N\u0012\u0006\u0010.\u001a\u00020~\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020h0Q\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020u0Q\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020w0Q\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020]0Q\u0012\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020a0Q\u0012\r\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020T0Q\u0012\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020e0Q\u0012\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020c0Q\u0012\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020V0Q\u0012\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020n0Q\u0012\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020s0Q\u0012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010Q\u0012\r\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020R0Q\u0012\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020j0Q\u0012\u0007\u0010\u0092\u0001\u001a\u00020_\u0012\r\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020}0Q\u0012\r\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020l0Q\u0012\u000e\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010Q\u0012\r\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020X0Q\u0012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010Q\u0012\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020k0Q¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0016J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\t\u0010\u0018JG\u0010\r\u001a\u00020\b2\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0019j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\r\u0010\u001bJ)\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010!J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010!J\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020#H\u0016¢\u0006\u0004\b\u0013\u0010$J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0011\u0010%J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\r\u0010%J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\t\u0010%J!\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010(J\u000f\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u0014J1\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020#2\b\u0010\u0006\u001a\u0004\u0018\u00010+2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001f\u0010,J_\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020#2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\u00052\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010.\u001a\u0004\u0018\u00010#2\b\u0010/\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b\u001f\u00102Jq\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020#2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\u001d2\u0006\u0010.\u001a\u00020\u00052\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u00101\u001a\u0004\u0018\u0001002\b\u00103\u001a\u0004\u0018\u00010#2\b\u00104\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u00105J?\u0010\r\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u0001062\b\u0010-\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\r\u00107J+\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\r\u00108J/\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020#H\u0016¢\u0006\u0004\b\u0013\u00109J_\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020#2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u001d2\b\u0010.\u001a\u0004\u0018\u0001002\b\u0010/\u001a\u0004\u0018\u00010#2\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\r\u0010:J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010!J\u001f\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\t\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010<J#\u0010\r\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\r\u0010=J\u0019\u0010\r\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\r\u0010!J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u000206H\u0016¢\u0006\u0004\b\u0013\u0010>J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\t\u0010!J\u000f\u0010?\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010\u0014J\u0018\u0010A\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020@H\u0096\u0001¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020#H\u0016¢\u0006\u0004\b\u001f\u0010CJ\u000f\u0010D\u001a\u00020\bH\u0016¢\u0006\u0004\bD\u0010\u0014J!\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\r\u0010ER\u0013\u0010\t\u001a\u00020FX\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010GR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010HR\u0014\u0010\u001f\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010JR\u0014\u0010\u0011\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010\r\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010OR\u0013\u0010?\u001a\u00020PX\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010GR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020R0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010SR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020T0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010SR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020V0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010SR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020X0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010SR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020]0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010SR\u0014\u0010U\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010`R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020a0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010SR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020c0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010SR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020e0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010SR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020h0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010SR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020j0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010SR\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020k0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010SR\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020l0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010SR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020n0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010SR\u0014\u0010m\u001a\u00020\u00058\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\bq\u0010rR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020s0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010SR\u0014\u0010o\u001a\u00020\u00058\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\bp\u0010rR\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020u0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010SR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020w0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010SR\u0016\u0010|\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010z\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010{R\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020}0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010SR\u0015\u0010v\u001a\u00020~8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001d\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010Q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010SR\u001d\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010Q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010SR\u001d\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010Q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010SR\u001b\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010S"}, d2 = {"Lid/dana/cashier/presenter/CashierPresenter;", "Lid/dana/cashier/CashierContract$Presenter;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "Lid/dana/cashier/model/CashierCheckoutModel;", "p0", "", "p1", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/CashierCheckoutModel;Z)V", "Lkotlin/Function0;", "p3", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/CashierCheckoutModel;Lkotlin/jvm/functions/Function0;)V", "", "", "getAuthRequestContext", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "()V", "Lid/dana/cashier/model/CashierMerchantModel;", "(Lid/dana/cashier/model/CashierMerchantModel;Ljava/lang/String;)V", "Lid/dana/cashier/model/CashierFaceAuthModel;", "(Lid/dana/cashier/model/CashierFaceAuthModel;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/cashier/model/CashierCheckoutRequestModel;", "Lid/dana/cashier/model/VoucherCashierModel;", "(Lid/dana/cashier/model/CashierCheckoutRequestModel;Lid/dana/cashier/model/VoucherCashierModel;Z)V", "PlaceComponentResult", "(Lid/dana/cashier/model/CashierCheckoutRequestModel;Z)V", "(Ljava/lang/String;)V", "Lid/dana/cashier/model/QueryPromotionRequestModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "(Lid/dana/cashier/model/QueryPromotionRequestModel;Lid/dana/cashier/model/CashierPayMethodModel;)V", "()Ljava/util/List;", "(Lid/dana/cashier/model/CashierCheckoutModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Z", "getErrorConfigVersion", "onDestroy", "Lid/dana/cashier/model/AttributeModel;", "(Lid/dana/cashier/model/CashierPayMethodModel;Lid/dana/cashier/model/AttributeModel;ZLjava/lang/String;)V", "p4", "p5", "p6", "Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;", "p7", "(Ljava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;Lid/dana/cashier/model/VoucherCashierModel;ZLjava/util/List;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;)V", "p8", "p9", "(Ljava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/model/VoucherCashierModel;ZLjava/util/List;Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Lid/dana/cashier/model/CashierCheckoutRequestModel;ZLjava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;)V", "(Ljava/lang/String;Lid/dana/cashier/model/CashierCheckoutRequestModel;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/util/List;Lid/dana/cashier/model/VoucherCashierModel;Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;)V", "Lid/dana/cashier/model/CashierOrderGoodModel;", "(Z)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "(J)V", "scheduleImpl", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "(Lid/dana/cashier/model/CashierPayMethodModel;)V", "lookAheadTest", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/cashier/utils/AddOnAttributeCacheManager;", "Lkotlin/Lazy;", "Lid/dana/cashier/model/CashierCheckoutModel;", "Lid/dana/cashier/mapper/CashierCheckoutModelMapper;", "Lid/dana/cashier/mapper/CashierCheckoutModelMapper;", "Lid/dana/cashier/mapper/CashierPayMethodModelMapper;", "moveToNextValue", "Lid/dana/cashier/mapper/CashierPayMethodModelMapper;", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "Lid/dana/cashier/utils/CashierPromoVoucherManager;", "Ldagger/Lazy;", "Lid/dana/cashier/domain/interactor/CashierUpdateOrder;", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/CheckAutoRouteSmartPayFeature;", "GetContactSyncConfig", "Lid/dana/domain/featureconfig/interactor/CheckMixPayFeature;", "initRecordTimeStamp", "Lid/dana/cashier/domain/interactor/CheckNeedToShowSmartpayDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/content/Context;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroid/content/Context;", "Lid/dana/cashier/domain/interactor/CreateCashierOrder;", "DatabaseTableConfigUtil", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/data/config/DeviceInformationProvider;", "newProxyInstance", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "isLayoutRequested", "Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/cashier/domain/interactor/GetCashierKybProduct;", "Lid/dana/cashier/domain/interactor/GetCurrencyFromCdn;", "Lid/dana/cashier/domain/interactor/GetCustomLoading3dsUrls;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/cashier/domain/interactor/GetQueryPromotion;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Z", "Lid/dana/domain/usereducation/interactor/IsNeedToShowToolTip;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/cashier/domain/interactor/PayCashier;", "getCallingPid", "Lid/dana/cashier/domain/interactor/PayQueryCashier;", "whenAvailable", "getSupportButtonTintMode", "readMicros", "J", "SubSequence", "Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder;", "Lid/dana/cashier/mapper/QueryPromotionModelMapper;", "A", "Lid/dana/cashier/mapper/QueryPromotionModelMapper;", "Lid/dana/cashier/domain/interactor/SaveLastSmartpayActivationShow;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/domain/usereducation/interactor/SaveShowToolTip;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;", "C", "Lid/dana/cashier/CashierContract$View;", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "<init>", "(Landroid/content/Context;Ldagger/Lazy;Lid/dana/cashier/mapper/CashierCheckoutModelMapper;Lid/dana/cashier/mapper/CashierPayMethodModelMapper;Lid/dana/cashier/mapper/CashierPayModelMapper;Lid/dana/cashier/mapper/QueryPromotionModelMapper;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class CashierPresenter implements CashierContract.Presenter, DanaVizTracker {

    /* renamed from: A  reason: from kotlin metadata */
    private final QueryPromotionModelMapper getCallingPid;
    private final Lazy<SaveLastSmartpayActivationShow> BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final kotlin.Lazy scheduleImpl;
    private final Lazy<SwitchAutoRouting> C;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy<CreateCashierOrder> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy<CheckAutoRouteSmartPayFeature> getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Lazy<GetCashierCheckoutInfo> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Lazy<CashierContract.View> A;
    private final Lazy<CashierUpdateOrder> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Context NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy<CheckNeedToShowSmartpayDialog> moveToNextValue;
    private final Lazy<IsNeedToShowToolTip> NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final Lazy<GetQueryPromotion> FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy<GetCustomLoading3dsUrls> newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy<GetCurrencyFromCdn> isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy<GetCashierKybProduct> PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final DanaVizTrackerImpl GetContactSyncConfig;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy<GetAutoRouteInitialSetting> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private long readMicros;
    private final Lazy<SaveShowToolTip> VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final kotlin.Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy<PayCashier> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CashierCheckoutModel MyBillsEntityDataFactory;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private final Lazy<PreCreateCashierOrder> whenAvailable;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<CheckMixPayFeature> lookAheadTest;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy<FaceAuthentication> DatabaseTableConfigUtil;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CashierPayModelMapper KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final CashierPayMethodModelMapper getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy<DeviceInformationProvider> initRecordTimeStamp;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private long SubSequence;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final CashierCheckoutModelMapper PlaceComponentResult;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy<PayQueryCashier> getSupportButtonTintMode;

    @Override // id.dana.analytics.tracker.danaviz.DanaVizTracker
    public final void setSource(DanaVizTracker.Source p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.setSource(p0);
    }

    @Inject
    public CashierPresenter(Context context, Lazy<CashierContract.View> lazy, CashierCheckoutModelMapper cashierCheckoutModelMapper, CashierPayMethodModelMapper cashierPayMethodModelMapper, CashierPayModelMapper cashierPayModelMapper, QueryPromotionModelMapper queryPromotionModelMapper, Lazy<GetCashierCheckoutInfo> lazy2, Lazy<PayCashier> lazy3, Lazy<PayQueryCashier> lazy4, Lazy<CreateCashierOrder> lazy5, Lazy<DeviceInformationProvider> lazy6, Lazy<CheckAutoRouteSmartPayFeature> lazy7, Lazy<GetAutoRouteInitialSetting> lazy8, Lazy<FaceAuthentication> lazy9, Lazy<CheckMixPayFeature> lazy10, Lazy<GetQueryPromotion> lazy11, Lazy<IsNeedToShowToolTip> lazy12, Lazy<SaveShowToolTip> lazy13, Lazy<CashierUpdateOrder> lazy14, Lazy<GetCashierKybProduct> lazy15, DanaVizTrackerImpl danaVizTrackerImpl, Lazy<PreCreateCashierOrder> lazy16, Lazy<GetCustomLoading3dsUrls> lazy17, Lazy<SwitchAutoRouting> lazy18, Lazy<CheckNeedToShowSmartpayDialog> lazy19, Lazy<SaveLastSmartpayActivationShow> lazy20, Lazy<GetCurrencyFromCdn> lazy21) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(cashierCheckoutModelMapper, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodModelMapper, "");
        Intrinsics.checkNotNullParameter(cashierPayModelMapper, "");
        Intrinsics.checkNotNullParameter(queryPromotionModelMapper, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        Intrinsics.checkNotNullParameter(lazy11, "");
        Intrinsics.checkNotNullParameter(lazy12, "");
        Intrinsics.checkNotNullParameter(lazy13, "");
        Intrinsics.checkNotNullParameter(lazy14, "");
        Intrinsics.checkNotNullParameter(lazy15, "");
        Intrinsics.checkNotNullParameter(danaVizTrackerImpl, "");
        Intrinsics.checkNotNullParameter(lazy16, "");
        Intrinsics.checkNotNullParameter(lazy17, "");
        Intrinsics.checkNotNullParameter(lazy18, "");
        Intrinsics.checkNotNullParameter(lazy19, "");
        Intrinsics.checkNotNullParameter(lazy20, "");
        Intrinsics.checkNotNullParameter(lazy21, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = context;
        this.A = lazy;
        this.PlaceComponentResult = cashierCheckoutModelMapper;
        this.getAuthRequestContext = cashierPayMethodModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierPayModelMapper;
        this.getCallingPid = queryPromotionModelMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = lazy3;
        this.getSupportButtonTintMode = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy5;
        this.initRecordTimeStamp = lazy6;
        this.getErrorConfigVersion = lazy7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy8;
        this.DatabaseTableConfigUtil = lazy9;
        this.lookAheadTest = lazy10;
        this.FragmentBottomSheetPaymentSettingBinding = lazy11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = lazy12;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = lazy13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy14;
        this.PrepareContext = lazy15;
        this.GetContactSyncConfig = danaVizTrackerImpl;
        this.whenAvailable = lazy16;
        this.newProxyInstance = lazy17;
        this.C = lazy18;
        this.moveToNextValue = lazy19;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = lazy20;
        this.isLayoutRequested = lazy21;
        setSource(DanaVizTracker.Source.CASHIER);
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<AddOnAttributeCacheManager>() { // from class: id.dana.cashier.presenter.CashierPresenter$addOnAttributeCacheManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AddOnAttributeCacheManager invoke() {
                return new AddOnAttributeCacheManager();
            }
        });
        this.scheduleImpl = LazyKt.lazy(new Function0<CashierPromoVoucherManager>() { // from class: id.dana.cashier.presenter.CashierPresenter$cashierPromoVoucherManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CashierPromoVoucherManager invoke() {
                return new CashierPromoVoucherManager();
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void PlaceComponentResult(CashierCheckoutRequestModel p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p1) {
            this.A.get().DatabaseTableConfigUtil();
        } else {
            this.A.get().showProgress();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = false;
        GetCashierCheckoutInfo getCashierCheckoutInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda8.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        getCashierCheckoutInfo.execute(CashierParamsFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.A.get().KClassImpl$Data$declaredNonStaticMembers$2()), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCashierInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                CashierCheckoutModelMapper cashierCheckoutModelMapper;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                cashierCheckoutModelMapper = CashierPresenter.this.PlaceComponentResult;
                CashierCheckoutModel apply = cashierCheckoutModelMapper.apply(cashierPay);
                CashierPresenter cashierPresenter = CashierPresenter.this;
                Intrinsics.checkNotNullExpressionValue(apply, "");
                cashierPresenter.PlaceComponentResult(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCashierInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).PlaceComponentResult(CashierPresenter.KClassImpl$Data$declaredNonStaticMembers$2(th));
                lazy3 = CashierPresenter.this.A;
                CashierContract.View view = (CashierContract.View) lazy3.get();
                UiTextModel uiTextModel = CashierPresenter.KClassImpl$Data$declaredNonStaticMembers$2(th).getAuthRequestContext;
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.MyBillsEntityDataFactory("cashierMain", uiTextModel.asString(context), th);
                StringBuilder sb = new StringBuilder();
                sb.append("[CheckoutCashierMain]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, CashierCheckoutRequestModel p1, final CashierPayMethodModel p2, final List<String> p3, final VoucherCashierModel p4, final PaylaterCashierRequestCheckoutModel p5, final CashierPayMethodModel p6, final String p7) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.A.get().showProgress();
        p1.GetContactSyncConfig = p3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        GetCashierCheckoutInfo getCashierCheckoutInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda8.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        getCashierCheckoutInfo.execute(CashierParamsFactory.KClassImpl$Data$declaredNonStaticMembers$2(p1, this.A.get().KClassImpl$Data$declaredNonStaticMembers$2()), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$refreshCashierInfoAndPay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Intrinsics.checkNotNullParameter(cashierPay, "");
                CashierPresenter.this.PlaceComponentResult(p0, p2, p4, true, p3, p6, p7, p5);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$refreshCashierInfoAndPay$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Context context;
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(th, "");
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                UiTextModel uiTextModel = CashierErrorHelper.MyBillsEntityDataFactory(th).getAuthRequestContext;
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String asString = uiTextModel.asString(context);
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).onError(asString);
                lazy3 = CashierPresenter.this.A;
                ((CashierContract.View) lazy3.get()).MyBillsEntityDataFactory("cashierMain", asString, th);
                StringBuilder sb = new StringBuilder();
                sb.append("[CheckoutCashierMain]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void PlaceComponentResult(String p0, CashierPayMethodModel p1, VoucherCashierModel p2, boolean p3, List<String> p4, CashierPayMethodModel p5, String p6, PaylaterCashierRequestCheckoutModel p7) {
        PayCashier.Params MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CashierPayQueryCounter cashierPayQueryCounter = CashierPayQueryCounter.INSTANCE;
        CashierPayQueryCounter.PlaceComponentResult();
        if (!p3) {
            this.A.get().showProgress();
        }
        PayCashier payCashier = this.NetworkUserEntityData$$ExternalSyntheticLambda4.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.A.get().KClassImpl$Data$declaredNonStaticMembers$2();
        Integer num = p7 != null ? p7.MyBillsEntityDataFactory : null;
        boolean kClassImpl$Data$declaredNonStaticMembers$2 = p5 != null ? p5.getKClassImpl$Data$declaredNonStaticMembers$2() : false;
        String androidId = this.initRecordTimeStamp.get().getAndroidId(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        MyBillsEntityDataFactory = CashierParamsFactory.MyBillsEntityDataFactory(p0, p1, p2, p4, null, null, "1.0", num, KClassImpl$Data$declaredNonStaticMembers$2, kClassImpl$Data$declaredNonStaticMembers$2, p5, p6, p7, androidId == null ? "" : androidId);
        payCashier.execute(MyBillsEntityDataFactory, new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payCashier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Intrinsics.checkNotNullParameter(cashierPay, "");
                CashierPresenter.PlaceComponentResult(CashierPresenter.this, cashierPay);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payCashier$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Lazy lazy;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                CashierPresenter.PlaceComponentResult(CashierPresenter.this, th);
                lazy = CashierPresenter.this.A;
                CashierContract.View view = (CashierContract.View) lazy.get();
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                UiTextModel uiTextModel = CashierErrorHelper.MyBillsEntityDataFactory(th).getAuthRequestContext;
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.MyBillsEntityDataFactory("cashierPay", uiTextModel.asString(context), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory(CashierMerchantModel p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.A.get().showProgress();
        CreateCashierOrder createCashierOrder = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        String deviceUUID = this.initRecordTimeStamp.get().getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        createCashierOrder.execute(CashierParamsFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, deviceUUID), new Function1<CreateOrderInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$createCashierOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CreateOrderInfo createOrderInfo) {
                invoke2(createOrderInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CreateOrderInfo createOrderInfo) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(createOrderInfo, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).dismissProgress();
                lazy3 = CashierPresenter.this.A;
                CashierContract.View view = (CashierContract.View) lazy3.get();
                String checkoutUrl = createOrderInfo.getCheckoutUrl();
                view.getAuthRequestContext(checkoutUrl != null ? checkoutUrl : "");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$createCashierOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Lazy lazy;
                Lazy lazy2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                CashierContract.View view = (CashierContract.View) lazy2.get();
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.onError(ErrorUtil.PlaceComponentResult(th, context));
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierCreateOrder]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, CashierPayMethodModel p1, String p2, String p3, VoucherCashierModel p4, boolean p5, List<String> p6, PaylaterCashierRequestCheckoutModel p7, CashierPayMethodModel p8, String p9) {
        CashierPayMethodModel.NewCardData scheduleImpl;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        CashierPayQueryCounter cashierPayQueryCounter = CashierPayQueryCounter.INSTANCE;
        CashierPayQueryCounter.PlaceComponentResult();
        this.A.get().showProgress();
        if (p5 && (scheduleImpl = CashierPayMethodModelKt.scheduleImpl(p1)) != null) {
            scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0 = p2;
        }
        PayCashier payCashier = this.NetworkUserEntityData$$ExternalSyntheticLambda4.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.A.get().KClassImpl$Data$declaredNonStaticMembers$2();
        boolean kClassImpl$Data$declaredNonStaticMembers$2 = p8 != null ? p8.getKClassImpl$Data$declaredNonStaticMembers$2() : false;
        String androidId = this.initRecordTimeStamp.get().getAndroidId(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        payCashier.execute(CashierParamsFactory.MyBillsEntityDataFactory(p0, p1, p4, p6, p2, p3, "1.0", p7 != null ? p7.MyBillsEntityDataFactory : null, KClassImpl$Data$declaredNonStaticMembers$2, kClassImpl$Data$declaredNonStaticMembers$2, p8, p9, p7, androidId == null ? "" : androidId), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payCashierWithRisk$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Intrinsics.checkNotNullParameter(cashierPay, "");
                CashierPresenter.PlaceComponentResult(CashierPresenter.this, cashierPay);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payCashierWithRisk$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Lazy lazy;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                CashierPresenter.PlaceComponentResult(CashierPresenter.this, th);
                lazy = CashierPresenter.this.A;
                CashierContract.View view = (CashierContract.View) lazy.get();
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                UiTextModel uiTextModel = CashierErrorHelper.MyBillsEntityDataFactory(th).getAuthRequestContext;
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.MyBillsEntityDataFactory("cashierPay", uiTextModel.asString(context), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1, boolean p2, Long p3, String p4) {
        PayQueryCashier.Params createPayQueryRequest;
        this.getSupportButtonTintMode.get().dispose();
        if (!p2) {
            this.A.get().showProgress();
        }
        this.readMicros = System.currentTimeMillis();
        PayQueryCashier payQueryCashier = this.getSupportButtonTintMode.get();
        PayQueryCashier.Params.Companion companion = PayQueryCashier.Params.INSTANCE;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.A.get().KClassImpl$Data$declaredNonStaticMembers$2();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        String androidId = this.initRecordTimeStamp.get().getAndroidId(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (androidId == null) {
            androidId = "";
        }
        createPayQueryRequest = companion.createPayQueryRequest(p0, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? null : null, (r27 & 16) != 0 ? null : p1, KClassImpl$Data$declaredNonStaticMembers$2, (r27 & 64) != 0 ? null : CashierParamsFactory.PlaceComponentResult(androidId), (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? false : p2, (r27 & 512) != 0 ? null : p4, (r27 & 1024) != 0 ? null : p3);
        payQueryCashier.execute(createPayQueryRequest, new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payQueryCashier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Intrinsics.checkNotNullParameter(cashierPay, "");
                CashierPresenter.BuiltInFictitiousFunctionClassFactory(CashierPresenter.this, cashierPay, p0, p1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payQueryCashier$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                CashierPresenter.getAuthRequestContext(CashierPresenter.this, th);
            }
        });
        CashierPayQueryCounter cashierPayQueryCounter = CashierPayQueryCounter.INSTANCE;
        CashierPayQueryCounter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, String p1, String p2) {
        PayQueryCashier.Params createPayQueryRequest;
        Intrinsics.checkNotNullParameter(p0, "");
        this.A.get().showProgress();
        PayQueryCashier payQueryCashier = this.getSupportButtonTintMode.get();
        PayQueryCashier.Params.Companion companion = PayQueryCashier.Params.INSTANCE;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.A.get().KClassImpl$Data$declaredNonStaticMembers$2();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        String androidId = this.initRecordTimeStamp.get().getAndroidId(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        createPayQueryRequest = companion.createPayQueryRequest(p0, (r27 & 2) != 0 ? null : p1, (r27 & 4) != 0 ? null : p2, (r27 & 8) != 0 ? null : null, (r27 & 16) != 0 ? null : null, KClassImpl$Data$declaredNonStaticMembers$2, (r27 & 64) != 0 ? null : CashierParamsFactory.PlaceComponentResult(androidId != null ? androidId : ""), (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? false : false, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null);
        payQueryCashier.execute(createPayQueryRequest, new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payQueryCashierWithRisk$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Intrinsics.checkNotNullParameter(cashierPay, "");
                CashierPresenter.BuiltInFictitiousFunctionClassFactory(CashierPresenter.this, cashierPay, p0, null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$payQueryCashierWithRisk$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                CashierPresenter.getAuthRequestContext(CashierPresenter.this, th);
            }
        });
        CashierPayQueryCounter cashierPayQueryCounter = CashierPayQueryCounter.INSTANCE;
        CashierPayQueryCounter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory(QueryPromotionRequestModel p0, final CashierPayMethodModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        GetQueryPromotion getQueryPromotion = this.FragmentBottomSheetPaymentSettingBinding.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        getQueryPromotion.execute(CashierParamsFactory.getAuthRequestContext(p0), new Function1<QueryPromotionInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getQueryPromotion$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryPromotionInfo queryPromotionInfo) {
                invoke2(queryPromotionInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryPromotionInfo queryPromotionInfo) {
                QueryPromotionModelMapper queryPromotionModelMapper;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(queryPromotionInfo, "");
                queryPromotionModelMapper = CashierPresenter.this.getCallingPid;
                QueryPromotionModel apply = queryPromotionModelMapper.apply(queryPromotionInfo);
                CashierPromoVoucherManager cashierPromoVoucherManager = (CashierPromoVoucherManager) CashierPresenter.this.scheduleImpl.getValue();
                Set set = CollectionsKt.toSet(apply.MyBillsEntityDataFactory);
                Intrinsics.checkNotNullParameter(set, "");
                cashierPromoVoucherManager.KClassImpl$Data$declaredNonStaticMembers$2.addAll(set);
                List<VoucherCashierModel> second = ((CashierPromoVoucherManager) CashierPresenter.this.scheduleImpl.getValue()).MyBillsEntityDataFactory(p1).getSecond();
                Intrinsics.checkNotNullParameter(second, "");
                apply.MyBillsEntityDataFactory = second;
                lazy = CashierPresenter.this.A;
                CashierContract.View view = (CashierContract.View) lazy.get();
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.PlaceComponentResult(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getQueryPromotion$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void getAuthRequestContext(final List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final ArrayList arrayList = new ArrayList();
        final Ref.IntRef intRef = new Ref.IntRef();
        for (final String str : p0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.cashier.presenter.CashierPresenter$checkShowcaseAvailability$1$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p02) {
                    Intrinsics.checkNotNullParameter(p02, "");
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    Lazy lazy;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    Ref.IntRef.this.element++;
                    if (booleanValue) {
                        arrayList.add(str);
                    }
                    if (Ref.IntRef.this.element == p0.size()) {
                        lazy = this.A;
                        ((CashierContract.View) lazy.get()).MyBillsEntityDataFactory(arrayList);
                    }
                }
            }, IsNeedToShowToolTip.Params.forShowTooltip(str));
        }
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.VerifyPinStateManager$executeRiskChallenge$2$1.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.cashier.presenter.CashierPresenter$saveShowcaseShowed$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
            }
        }, SaveShowToolTip.Params.forSaveShowToolTip(true, p0));
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(CashierCheckoutModel cashierCheckoutModel, boolean z) {
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        KClassImpl$Data$declaredNonStaticMembers$2(cashierCheckoutModel, new CashierPresenter$checkAutoRouteOnSuccessCashierInfo$1(this, cashierCheckoutModel, z, false));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final CashierCheckoutModel cashierCheckoutModel, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.getErrorConfigVersion.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$checkAutorouteSplitFeatureEnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                AttributeModel attributeModel = CashierCheckoutModel.this.getAuthRequestContext;
                if (attributeModel != null) {
                    attributeModel.getAuthRequestContext = z;
                }
                function0.invoke();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$checkAutorouteSplitFeatureEnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                function0.invoke();
                StringBuilder sb = new StringBuilder();
                sb.append("[CheckoutCashierMain]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        CashierUpdateOrder cashierUpdateOrder = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        cashierUpdateOrder.execute(CashierParamsFactory.PlaceComponentResult(new CashierUpdateOrderRequestModel(p0, ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(), p1)), new Function1<DefaultResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$updateOrder$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DefaultResponse defaultResponse) {
                Intrinsics.checkNotNullParameter(defaultResponse, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DefaultResponse defaultResponse) {
                invoke2(defaultResponse);
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$updateOrder$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierUpdateOrder]: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    /* renamed from: getErrorConfigVersion  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda5() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierCheckoutRequestModel p0, final VoucherCashierModel p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.A.get().showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        GetCashierCheckoutInfo getCashierCheckoutInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda8.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        getCashierCheckoutInfo.execute(CashierParamsFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.A.get().KClassImpl$Data$declaredNonStaticMembers$2()), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$doReconsultMixPayPromo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).getAuthRequestContext(p1, p2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$doReconsultMixPayPromo$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Context context;
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(th, "");
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                UiTextModel uiTextModel = CashierErrorHelper.MyBillsEntityDataFactory(th).getAuthRequestContext;
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String asString = uiTextModel.asString(context);
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).onError(asString);
                lazy3 = CashierPresenter.this.A;
                ((CashierContract.View) lazy3.get()).MyBillsEntityDataFactory("cashierMain", asString, th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void PlaceComponentResult() {
        this.newProxyInstance.get().execute(NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCustomLoading3dsUrls$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCustomLoading3dsUrls$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.A.get().DatabaseTableConfigUtil();
        this.PrepareContext.get().execute(GetCashierKybProduct.Params.INSTANCE.createGetCashierKybProductRequest(str), new Function1<CashierKybProductInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCashierKybProduct$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierKybProductInfo cashierKybProductInfo) {
                invoke2(cashierKybProductInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierKybProductInfo cashierKybProductInfo) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(cashierKybProductInfo, "");
                String merchantName = cashierKybProductInfo.getMerchantName();
                String merchantAddress = cashierKybProductInfo.getMerchantAddress();
                String logoUrl = cashierKybProductInfo.getLogoUrl();
                CashierKybOrderDetail orderDetail = cashierKybProductInfo.getOrderDetail();
                CashierMerchantModel cashierMerchantModel = new CashierMerchantModel(null, null, null, merchantName, merchantAddress, null, null, null, null, null, logoUrl, orderDetail != null ? CashierKybOrderDetailModelKt.BuiltInFictitiousFunctionClassFactory(orderDetail) : null, false, null, null, null, null, null, false, 521191, null);
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(cashierMerchantModel);
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).dismissProgress();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCashierKybProduct$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Lazy lazy;
                Lazy lazy2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                CashierContract.View view = (CashierContract.View) lazy2.get();
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.onError(ErrorUtil.PlaceComponentResult(th, context));
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierGetKybProduct]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    public final void PlaceComponentResult(CashierPayMethodModel p0, AttributeModel p1, boolean p2, String p3) {
        List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$2 = p1 != null ? this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(p1) : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
        }
        CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
        CashierPayMethodModel PlaceComponentResult = CashierPayMethodModelExt.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
        if (PlaceComponentResult != null) {
            PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }
        CashierPayMethodModelExt cashierPayMethodModelExt2 = CashierPayMethodModelExt.INSTANCE;
        CashierPayMethodModelExt.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, p0);
        CashierPayMethodModelExt cashierPayMethodModelExt3 = CashierPayMethodModelExt.INSTANCE;
        if (CashierPayMethodModelExt.KClassImpl$Data$declaredNonStaticMembers$2(p0, KClassImpl$Data$declaredNonStaticMembers$2)) {
            this.A.get().getAuthRequestContext(p1, p2, p3, KClassImpl$Data$declaredNonStaticMembers$2);
            return;
        }
        CashierContract.View view = this.A.get();
        CashierPayMethodModelExt cashierPayMethodModelExt4 = CashierPayMethodModelExt.INSTANCE;
        CashierPayMethodModel PlaceComponentResult2 = CashierPayMethodModelExt.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
        view.getAuthRequestContext(p3, (String) null, PlaceComponentResult2 != null ? CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda1(PlaceComponentResult2) : false);
        ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(!p2, p3);
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(HashMap<String, String> p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        CashierInitParamHelper cashierInitParamHelper = CashierInitParamHelper.INSTANCE;
        CashierMerchantModel PlaceComponentResult = CashierInitParamHelper.PlaceComponentResult(p0, null, p1, null);
        this.whenAvailable.get().execute(PreCreateCashierOrder.Params.INSTANCE.preCreateCashierOrder(new PreCreateOrderRequest(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8, p2, PlaceComponentResult.GetContactSyncConfig, null, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.scheduleImpl, null)), new Function1<DefaultResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$doPreCreateCashierOrder$1$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DefaultResponse defaultResponse) {
                Intrinsics.checkNotNullParameter(defaultResponse, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DefaultResponse defaultResponse) {
                invoke2(defaultResponse);
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$doPreCreateCashierOrder$1$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Boolean p0, Boolean p1) {
        boolean booleanValue = p0 != null ? p0.booleanValue() : false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = booleanValue;
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = booleanValue;
        boolean booleanValue2 = p1 != null ? p1.booleanValue() : false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = booleanValue2;
        this.getAuthRequestContext.getAuthRequestContext = booleanValue2;
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void lookAheadTest() {
        this.A.get().showProgress();
        UserAutoRouteConfigStore userAutoRouteConfigStore = new UserAutoRouteConfigStore(null, null, null, null, null, 31, null);
        Boolean bool = Boolean.TRUE;
        userAutoRouteConfigStore.setAutoroute(bool);
        userAutoRouteConfigStore.setFromCashierFlow(bool);
        this.C.get().execute(userAutoRouteConfigStore, new Function1<UserAutoRouteConfigSwitch, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$switchAutoRouteState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserAutoRouteConfigSwitch userAutoRouteConfigSwitch) {
                invoke2(userAutoRouteConfigSwitch);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserAutoRouteConfigSwitch userAutoRouteConfigSwitch) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(userAutoRouteConfigSwitch, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).moveToNextValue();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$switchAutoRouteState$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                ((CashierContract.View) lazy2.get()).MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void scheduleImpl() {
        SaveLastSmartpayActivationShow saveLastSmartpayActivationShow = this.BottomSheetCardBindingView$watcherCardNumberView$1.get();
        Intrinsics.checkNotNullExpressionValue(saveLastSmartpayActivationShow, "");
        CompletableUseCase.execute$default(saveLastSmartpayActivationShow, NoParams.INSTANCE, null, null, 6, null);
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.isLayoutRequested.get().execute(NoParams.INSTANCE, new Function1<Map<String, ? extends CashierCurrencyFromCdn>, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCurrencyFromCdn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends CashierCurrencyFromCdn> map) {
                invoke2((Map<String, CashierCurrencyFromCdn>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, CashierCurrencyFromCdn> map) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(map, "");
                String str = "Rp";
                if (map.containsKey(p0)) {
                    String str2 = p0;
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                    Iterator<T> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        Object key = entry.getKey();
                        if (Intrinsics.areEqual(entry.getKey(), str2)) {
                            str = String.valueOf(((CashierCurrencyFromCdn) entry.getValue()).getCurrencySymbolString());
                        }
                        linkedHashMap.put(key, Unit.INSTANCE);
                    }
                }
                lazy = this.A;
                ((CashierContract.View) lazy.get()).MyBillsEntityDataFactory(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCurrencyFromCdn$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.getSupportButtonTintMode.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().dispose();
        this.lookAheadTest.get().dispose();
        this.FragmentBottomSheetPaymentSettingBinding.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().dispose();
        this.VerifyPinStateManager$executeRiskChallenge$2$1.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.PrepareContext.get().dispose();
        CashierPromoVoucherManager cashierPromoVoucherManager = (CashierPromoVoucherManager) this.scheduleImpl.getValue();
        cashierPromoVoucherManager.BuiltInFictitiousFunctionClassFactory = null;
        cashierPromoVoucherManager.getAuthRequestContext.clear();
        cashierPromoVoucherManager.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        this.MyBillsEntityDataFactory = null;
        this.newProxyInstance.get().dispose();
        this.BottomSheetCardBindingView$watcherCardNumberView$1.get().dispose();
        this.isLayoutRequested.get().dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierPresenter cashierPresenter, CashierCheckoutModel cashierCheckoutModel, boolean z, boolean z2) {
        Object obj;
        ?? r2;
        List<? extends CashierPayMethodModel> apply = cashierPresenter.getAuthRequestContext.apply(cashierCheckoutModel);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        List<? extends CashierPayMethodModel> list = apply;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CashierPayMethodModel) obj) instanceof CashierPayMethodModel.PaylaterCicilPayMethod) {
                break;
            }
        }
        cashierCheckoutModel.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (obj instanceof CashierPayMethodModel.PaylaterCicilPayMethod ? (CashierPayMethodModel.PaylaterCicilPayMethod) obj : null) != null;
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                r2 = 0;
                break;
            }
            r2 = it2.next();
            if (CashierPayMethodModelKt.newProxyInstance((CashierPayMethodModel) r2)) {
                break;
            }
        }
        CashierPayMethodModel.DanaPlusPayMethod danaPlusPayMethod = r2 instanceof CashierPayMethodModel.DanaPlusPayMethod ? r2 : null;
        if (danaPlusPayMethod != null) {
            danaPlusPayMethod.KClassImpl$Data$declaredNonStaticMembers$2 = cashierCheckoutModel.BuiltInFictitiousFunctionClassFactory;
        }
        cashierPresenter.A.get().dismissProgress();
        cashierPresenter.A.get().MyBillsEntityDataFactory(cashierCheckoutModel);
        cashierPresenter.A.get().getAuthRequestContext(apply, z, z2);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    public static final /* synthetic */ CashierErrorState KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        String message = th.getMessage();
        int i = 2;
        boolean z = false;
        ?? r4 = 0;
        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "PayLaterMethodConfig", false, 2, (Object) null)) {
            z = true;
        }
        if (z) {
            return new CashierErrorState(CashierErrorType.DEX_GUARD, new UiTextModel.StringResource(R.string.error_msg_dexguard_fresh_install, r4, i, r4), "");
        }
        CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
        return CashierErrorHelper.MyBillsEntityDataFactory(th);
    }

    public static final /* synthetic */ void PlaceComponentResult(CashierPresenter cashierPresenter, Throwable th) {
        cashierPresenter.A.get().dismissProgress();
        CashierContract.View view = cashierPresenter.A.get();
        CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
        view.getAuthRequestContext(CashierErrorHelper.MyBillsEntityDataFactory(th));
        StringBuilder sb = new StringBuilder();
        sb.append("[CashierPay]: cashier_native_fail");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierPresenter cashierPresenter, Throwable th) {
        cashierPresenter.A.get().dismissProgress();
        CashierContract.View view = cashierPresenter.A.get();
        CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
        view.BuiltInFictitiousFunctionClassFactory(CashierErrorHelper.MyBillsEntityDataFactory(th));
        StringBuilder sb = new StringBuilder();
        sb.append("[PayQuery]: cashier_native_fail");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
    }

    public static final /* synthetic */ void PlaceComponentResult(CashierPresenter cashierPresenter, CashierPay cashierPay) {
        CashierPayModel apply = cashierPresenter.KClassImpl$Data$declaredNonStaticMembers$2.apply(cashierPay);
        if (!Intrinsics.areEqual(apply.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
            cashierPresenter.A.get().dismissProgress();
        }
        AttributeCashierPayModel attributeCashierPayModel = apply.KClassImpl$Data$declaredNonStaticMembers$2;
        if (attributeCashierPayModel != null) {
            attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2();
            cashierPresenter.A.get().dismissProgress();
        }
        CashierContract.View view = cashierPresenter.A.get();
        Intrinsics.checkNotNullExpressionValue(apply, "");
        view.KClassImpl$Data$declaredNonStaticMembers$2(apply);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierPresenter cashierPresenter, CashierPay cashierPay, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        cashierPresenter.SubSequence = currentTimeMillis;
        long j = currentTimeMillis - cashierPresenter.readMicros;
        long j2 = j >= 1000 ? 0L : 1000 - j;
        StringBuilder sb = new StringBuilder();
        sb.append("[PayQuery] : Next API Delay ");
        sb.append(j2);
        sb.append("ms");
        DanaLog.getAuthRequestContext(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString());
        CashierPayModel apply = cashierPresenter.KClassImpl$Data$declaredNonStaticMembers$2.apply(cashierPay);
        if (apply != null) {
            if (!Intrinsics.areEqual(apply.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
                cashierPresenter.A.get().dismissProgress();
            }
            AttributeCashierPayModel attributeCashierPayModel = apply.KClassImpl$Data$declaredNonStaticMembers$2;
            if (attributeCashierPayModel != null) {
                if (Intrinsics.areEqual(attributeCashierPayModel.Q, Boolean.TRUE)) {
                    CashierPresenter cashierPresenter2 = cashierPresenter;
                    if (str == null && (str = cashierPay.getCashierOrderId()) == null) {
                        str = "";
                    }
                    cashierPresenter2.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, (r12 & 4) != 0 ? false : true, (r12 & 8) != 0 ? null : Long.valueOf(j2), (r12 & 16) != 0 ? null : null);
                    return;
                }
                cashierPresenter.A.get().dismissProgress();
                cashierPresenter.A.get().MyBillsEntityDataFactory(apply);
            }
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierPresenter cashierPresenter, boolean z) {
        cashierPresenter.NetworkUserEntityData$$ExternalSyntheticLambda6 = z;
        cashierPresenter.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = z;
    }

    public static final /* synthetic */ void PlaceComponentResult(CashierPresenter cashierPresenter, boolean z) {
        cashierPresenter.NetworkUserEntityData$$ExternalSyntheticLambda5 = z;
        cashierPresenter.getAuthRequestContext.getAuthRequestContext = z;
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory() {
        ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final CashierFaceAuthModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.getErrorConfigVersion();
        this.DatabaseTableConfigUtil.get().PlaceComponentResult(p0.PlaceComponentResult, p0.KClassImpl$Data$declaredNonStaticMembers$2, new FaceAuthenticationCallback() { // from class: id.dana.cashier.presenter.CashierPresenter$doFaceAuth$1
            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onCancel() {
                Lazy lazy;
                CashierPresenter.this.GetContactSyncConfig.lookAheadTest();
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).getAuthRequestContext();
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onFailed(DanaBioException.FaceAuthenticationException p02) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(p02, "");
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).scheduleImpl();
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.UAP_FACE_AUTHENTICATION_PREFIX);
                sb.append(getClass().getName());
                sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.UAP_FACE_AUTHENTICATION, sb.toString(), p02);
                CashierPresenter cashierPresenter = CashierPresenter.this;
                int errorCode = p02.getErrorCode();
                String message = p02.getMessage();
                Intrinsics.checkNotNullParameter(message, "");
                cashierPresenter.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(errorCode, message);
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onSuccess(String p02) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(p02, "");
                CashierPresenter cashierPresenter = CashierPresenter.this;
                CashierFaceAuthModel cashierFaceAuthModel = p0;
                lazy = cashierPresenter.A;
                ((CashierContract.View) lazy.get()).getErrorConfigVersion();
                cashierPresenter.MyBillsEntityDataFactory(cashierFaceAuthModel.BuiltInFictitiousFunctionClassFactory, cashierFaceAuthModel.scheduleImpl, p02, cashierFaceAuthModel.lookAheadTest, cashierFaceAuthModel.NetworkUserEntityData$$ExternalSyntheticLambda0, (r24 & 32) != 0 ? false : false, cashierFaceAuthModel.getAuthRequestContext, (r24 & 128) != 0 ? null : new PaylaterCashierRequestCheckoutModel(cashierFaceAuthModel.MyBillsEntityDataFactory, null, null, null, 14, null), (r24 & 256) != 0 ? null : null, (r24 & 512) != 0 ? null : cashierFaceAuthModel.moveToNextValue);
                CashierPresenter.this.GetContactSyncConfig.scheduleImpl();
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final List<String> getAuthRequestContext() {
        return CollectionsKt.toList(((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2() {
        return ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory();
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final List<String> BuiltInFictitiousFunctionClassFactory() {
        return CollectionsKt.toList(((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory);
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void PlaceComponentResult(final CashierCheckoutModel cashierCheckoutModel) {
        LinkedHashSet linkedHashSet;
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        AttributeModel attributeModel = cashierCheckoutModel.getAuthRequestContext;
        List<AssetCardModel> list = attributeModel != null ? attributeModel.moveToNextValue : null;
        final boolean z = !(list == null || list.isEmpty());
        AttributeModel attributeModel2 = cashierCheckoutModel.getAuthRequestContext;
        final boolean areEqual = attributeModel2 != null ? Intrinsics.areEqual(attributeModel2.TypeProjectionImpl, Boolean.TRUE) : false;
        ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
        CashierPromoVoucherManager cashierPromoVoucherManager = (CashierPromoVoucherManager) this.scheduleImpl.getValue();
        AttributeModel attributeModel3 = cashierCheckoutModel.getAuthRequestContext;
        if (attributeModel3 != null) {
            linkedHashSet = new LinkedHashSet();
            List<CashierPayChannelModel> list2 = attributeModel3.SummaryVoucherView$$ExternalSyntheticLambda1;
            if (list2 != null) {
                for (CashierPayChannelModel cashierPayChannelModel : list2) {
                    List<VoucherCashierModel> list3 = cashierPayChannelModel.I;
                    if (!(list3 == null || list3.isEmpty())) {
                        linkedHashSet.addAll(cashierPayChannelModel.I);
                    }
                }
            }
        } else {
            linkedHashSet = null;
        }
        if (linkedHashSet == null) {
            linkedHashSet = SetsKt.emptySet();
        }
        Intrinsics.checkNotNullParameter(linkedHashSet, "");
        cashierPromoVoucherManager.KClassImpl$Data$declaredNonStaticMembers$2.addAll(linkedHashSet);
        AttributeModel attributeModel4 = cashierCheckoutModel.getAuthRequestContext;
        List<CashierOrderGoodModel> list4 = attributeModel4 != null ? attributeModel4.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        AddOnAttributeCacheManager addOnAttributeCacheManager = (AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue();
        if (list4 != null) {
            addOnAttributeCacheManager.BuiltInFictitiousFunctionClassFactory.clear();
            addOnAttributeCacheManager.BuiltInFictitiousFunctionClassFactory.addAll(list4);
        }
        this.moveToNextValue.get().execute(new CheckNeedToShowSmartpayDialog.Params(areEqual), new Function1<Boolean, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$isNeedToShowSmartpayDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                Lazy lazy;
                if (z2) {
                    lazy = CashierPresenter.this.A;
                    ((CashierContract.View) lazy.get()).lookAheadTest();
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$isNeedToShowSmartpayDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("[IsNeedToShowSmartpayDialog]: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
        if (!cashierCheckoutModel.BuiltInFictitiousFunctionClassFactory()) {
            BuiltInFictitiousFunctionClassFactory(cashierCheckoutModel, z);
            return;
        }
        final String str = cashierCheckoutModel.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        this.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getFeatureConfigMixPay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                if (!z2) {
                    CashierPresenter.this.BuiltInFictitiousFunctionClassFactory(cashierCheckoutModel, z);
                    return;
                }
                final CashierPresenter cashierPresenter = CashierPresenter.this;
                String str2 = str;
                final CashierCheckoutModel cashierCheckoutModel2 = cashierCheckoutModel;
                final boolean z3 = z;
                Intrinsics.checkNotNullParameter(cashierCheckoutModel2, "");
                cashierPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
                GetCashierCheckoutInfo getCashierCheckoutInfo = cashierPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.get();
                CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
                getCashierCheckoutInfo.execute(CashierParamsFactory.KClassImpl$Data$declaredNonStaticMembers$2(new CashierCheckoutRequestModel(str2, null, null, null, null, null, null, Boolean.TRUE, null, null, null, false, null, 8062, null), cashierPresenter.A.get().KClassImpl$Data$declaredNonStaticMembers$2()), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCashierInfoForMixPay$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                        invoke2(cashierPay);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(CashierPay cashierPay) {
                        CashierCheckoutModelMapper cashierCheckoutModelMapper;
                        boolean z4;
                        boolean z5;
                        ArrayList arrayList;
                        Lazy lazy;
                        Lazy lazy2;
                        List<CashierPayChannelModel> list5;
                        AttributeModel attributeModel5;
                        List<CashierPayChannelModel> list6;
                        AttributeModel attributeModel6;
                        List<CashierPayChannelModel> list7;
                        Intrinsics.checkNotNullParameter(cashierPay, "");
                        CashierPresenter.getAuthRequestContext(CashierPresenter.this, true);
                        cashierCheckoutModelMapper = CashierPresenter.this.PlaceComponentResult;
                        CashierCheckoutModel apply = cashierCheckoutModelMapper.apply(cashierPay);
                        CashierPresenter cashierPresenter2 = CashierPresenter.this;
                        if (apply != null && (attributeModel6 = apply.getAuthRequestContext) != null && (list7 = attributeModel6.SummaryVoucherView$$ExternalSyntheticLambda1) != null) {
                            List<CashierPayChannelModel> list8 = list7;
                            if (!(list8 instanceof Collection) || !list8.isEmpty()) {
                                Iterator<T> it = list8.iterator();
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual(((CashierPayChannelModel) it.next()).B, "ONLINE_CREDIT")) {
                                        z4 = true;
                                        break;
                                    }
                                }
                            }
                        }
                        z4 = false;
                        CashierPresenter.PlaceComponentResult(cashierPresenter2, z4);
                        if (apply != null && (attributeModel5 = apply.getAuthRequestContext) != null && (list6 = attributeModel5.SummaryVoucherView$$ExternalSyntheticLambda1) != null) {
                            List<CashierPayChannelModel> list9 = list6;
                            if (!(list9 instanceof Collection) || !list9.isEmpty()) {
                                Iterator<T> it2 = list9.iterator();
                                while (it2.hasNext()) {
                                    if (Intrinsics.areEqual(((CashierPayChannelModel) it2.next()).B, PayMethod.LOAN_CREDIT)) {
                                        z5 = true;
                                        break;
                                    }
                                }
                            }
                        }
                        z5 = false;
                        if (!z5) {
                            CashierPresenter cashierPresenter3 = CashierPresenter.this;
                            CashierCheckoutModelExt cashierCheckoutModelExt = CashierCheckoutModelExt.INSTANCE;
                            CashierPresenter.getAuthRequestContext(cashierPresenter3, !CashierCheckoutModelExt.KClassImpl$Data$declaredNonStaticMembers$2(cashierCheckoutModel2));
                            AttributeModel attributeModel7 = cashierCheckoutModel2.getAuthRequestContext;
                            if (attributeModel7 != null && (list5 = attributeModel7.SummaryVoucherView$$ExternalSyntheticLambda1) != null) {
                                CashierCheckoutModel cashierCheckoutModel3 = cashierCheckoutModel2;
                                ArrayList arrayList2 = new ArrayList();
                                for (Object obj : list5) {
                                    CashierPayChannelModel cashierPayChannelModel2 = (CashierPayChannelModel) obj;
                                    CashierCheckoutModelExt cashierCheckoutModelExt2 = CashierCheckoutModelExt.INSTANCE;
                                    if (!CashierCheckoutModelExt.KClassImpl$Data$declaredNonStaticMembers$2(cashierCheckoutModel3) ? cashierPayChannelModel2.KClassImpl$Data$declaredNonStaticMembers$2() : cashierPayChannelModel2.scheduleImpl() && cashierPayChannelModel2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                        arrayList2.add(obj);
                                    }
                                }
                                arrayList = arrayList2;
                            }
                            arrayList = null;
                        } else {
                            AttributeModel attributeModel8 = cashierCheckoutModel2.getAuthRequestContext;
                            if (attributeModel8 != null) {
                                arrayList = attributeModel8.SummaryVoucherView$$ExternalSyntheticLambda1;
                            }
                            arrayList = null;
                        }
                        AttributeModel attributeModel9 = cashierCheckoutModel2.getAuthRequestContext;
                        if (attributeModel9 != null) {
                            AttributeModel attributeModel10 = apply.getAuthRequestContext;
                            attributeModel9.moveToNextValue = attributeModel10 != null ? attributeModel10.moveToNextValue : null;
                            AttributeModel attributeModel11 = apply.getAuthRequestContext;
                            attributeModel9.K = attributeModel11 != null ? attributeModel11.K : null;
                            AttributeModel attributeModel12 = apply.getAuthRequestContext;
                            attributeModel9.PlaceComponentResult = attributeModel12 != null ? attributeModel12.PlaceComponentResult : null;
                            attributeModel9.SummaryVoucherView$$ExternalSyntheticLambda1 = arrayList;
                        }
                        if (cashierPay.isNeedToShowDialog()) {
                            lazy2 = CashierPresenter.this.A;
                            ((CashierContract.View) lazy2.get()).NetworkUserEntityData$$ExternalSyntheticLambda0();
                        }
                        lazy = CashierPresenter.this.A;
                        ((CashierContract.View) lazy.get()).PlaceComponentResult(cashierPay.isSomeCardNotSupportedForMixPay());
                        CashierPresenter cashierPresenter4 = CashierPresenter.this;
                        CashierCheckoutModel cashierCheckoutModel4 = cashierCheckoutModel2;
                        boolean z6 = z3;
                        boolean isNeedToShowMixPayTooltip = cashierPay.isNeedToShowMixPayTooltip();
                        Intrinsics.checkNotNullParameter(cashierCheckoutModel4, "");
                        cashierPresenter4.KClassImpl$Data$declaredNonStaticMembers$2(cashierCheckoutModel4, new CashierPresenter$checkAutoRouteOnSuccessCashierInfo$1(cashierPresenter4, cashierCheckoutModel4, z6, isNeedToShowMixPayTooltip));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getCashierInfoForMixPay$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        CashierPresenter.this.BuiltInFictitiousFunctionClassFactory(cashierCheckoutModel2, z3);
                        StringBuilder sb = new StringBuilder();
                        sb.append("[CheckoutCashierMain] FOR MIXPAY: cashier_native_fail");
                        sb.append(th.getMessage());
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$getFeatureConfigMixPay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                CashierPresenter.this.BuiltInFictitiousFunctionClassFactory(cashierCheckoutModel, z);
                StringBuilder sb = new StringBuilder();
                sb.append("[CheckMixPaymentFeature]: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory(CashierCheckoutRequestModel p0, final boolean p1, final String p2, final CashierPayMethodModel p3) {
        AttributeModel attributeModel;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        AddOnAttributeCacheManager addOnAttributeCacheManager = (AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue();
        Intrinsics.checkNotNullParameter(p2, "");
        if (p1) {
            attributeModel = addOnAttributeCacheManager.getAuthRequestContext.get(p2);
        } else {
            attributeModel = addOnAttributeCacheManager.PlaceComponentResult.get(p2);
        }
        boolean z = attributeModel == null;
        ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(p1, p2);
        if (!z) {
            PlaceComponentResult(p3, attributeModel, p1, p2);
            return;
        }
        this.A.get().showProgress();
        p0.GetContactSyncConfig = ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        GetCashierCheckoutInfo getCashierCheckoutInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda8.get();
        CashierParamsFactory cashierParamsFactory = CashierParamsFactory.PlaceComponentResult;
        getCashierCheckoutInfo.execute(CashierParamsFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.A.get().KClassImpl$Data$declaredNonStaticMembers$2()), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$doRefreshCashierInfoAddOn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                CashierCheckoutModelMapper cashierCheckoutModelMapper;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                cashierCheckoutModelMapper = CashierPresenter.this.PlaceComponentResult;
                final CashierCheckoutModel apply = cashierCheckoutModelMapper.apply(cashierPay);
                AddOnAttributeCacheManager addOnAttributeCacheManager2 = (AddOnAttributeCacheManager) CashierPresenter.this.BuiltInFictitiousFunctionClassFactory.getValue();
                AttributeModel attributeModel2 = apply.getAuthRequestContext;
                boolean z2 = p1;
                String str = p2;
                Intrinsics.checkNotNullParameter(str, "");
                if (z2) {
                    addOnAttributeCacheManager2.getAuthRequestContext.put(str, attributeModel2);
                } else {
                    addOnAttributeCacheManager2.PlaceComponentResult.put(str, attributeModel2);
                }
                AttributeModel attributeModel3 = apply.getAuthRequestContext;
                List<AssetCardModel> list = attributeModel3 != null ? attributeModel3.moveToNextValue : null;
                if (list != null) {
                    list.isEmpty();
                }
                final CashierPresenter cashierPresenter = CashierPresenter.this;
                Intrinsics.checkNotNullExpressionValue(apply, "");
                final CashierPayMethodModel cashierPayMethodModel = p3;
                final boolean z3 = p1;
                final String str2 = p2;
                Intrinsics.checkNotNullParameter(apply, "");
                Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
                Intrinsics.checkNotNullParameter(str2, "");
                cashierPresenter.KClassImpl$Data$declaredNonStaticMembers$2(apply, new Function0<Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$checkAutoRouteOnSuccessRefreshCashier$1
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
                        CashierPresenter.this.PlaceComponentResult(cashierPayMethodModel, apply.getAuthRequestContext, z3, str2);
                    }
                });
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPresenter$doRefreshCashierInfoAddOn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Lazy lazy;
                Lazy lazy2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                ((AddOnAttributeCacheManager) CashierPresenter.this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(!p1, p2);
                lazy = CashierPresenter.this.A;
                ((CashierContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierPresenter.this.A;
                Object obj = lazy2.get();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                String str = p2;
                context = CashierPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                ((CashierContract.View) obj).getAuthRequestContext(str, ErrorUtil.PlaceComponentResult(th, context), false);
                StringBuilder sb = new StringBuilder();
                sb.append("[CheckoutCashierMain]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(List<CashierOrderGoodModel> p0) {
        AddOnAttributeCacheManager addOnAttributeCacheManager = (AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue();
        if (p0 != null) {
            addOnAttributeCacheManager.BuiltInFictitiousFunctionClassFactory.clear();
            addOnAttributeCacheManager.BuiltInFictitiousFunctionClassFactory.addAll(p0);
        }
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory(boolean p0) {
        ((CashierPromoVoucherManager) this.scheduleImpl.getValue()).PlaceComponentResult = p0;
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void MyBillsEntityDataFactory(long p0) {
        ((CashierPromoVoucherManager) this.scheduleImpl.getValue()).MyBillsEntityDataFactory = p0;
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ((AddOnAttributeCacheManager) this.BuiltInFictitiousFunctionClassFactory.getValue()).getAuthRequestContext(p0);
    }

    @Override // id.dana.cashier.CashierContract.Presenter
    public final void PlaceComponentResult(CashierPayMethodModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Pair<VoucherCashierModel, List<VoucherCashierModel>> MyBillsEntityDataFactory = ((CashierPromoVoucherManager) this.scheduleImpl.getValue()).MyBillsEntityDataFactory(p0);
        this.A.get().getAuthRequestContext(MyBillsEntityDataFactory.getFirst(), MyBillsEntityDataFactory.getSecond());
    }
}
