package id.dana.kyb;

import android.content.Context;
import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.UrlParam;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawMethodOptionResult;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.KybResponse;
import id.dana.domain.promotion.Space;
import id.dana.kyb.KybContract;
import id.dana.kyb.KybPresenter;
import id.dana.kyb.constant.KybServiceRedirectType;
import id.dana.kyb.data.error.KybMerchantInfoException;
import id.dana.kyb.domain.interactor.GetKybBanner;
import id.dana.kyb.domain.interactor.GetKybCompressQrConfig;
import id.dana.kyb.domain.interactor.GetKybMerchantInfo;
import id.dana.kyb.domain.interactor.GetKybPaymentRequest;
import id.dana.kyb.domain.interactor.GetKybQrisPoster;
import id.dana.kyb.domain.interactor.GetKybServiceList;
import id.dana.kyb.domain.interactor.GetKybStartupConfig;
import id.dana.kyb.domain.interactor.GetKybTopServices;
import id.dana.kyb.domain.interactor.GetKybTransactionHistory;
import id.dana.kyb.domain.interactor.GetKybUrlsConfig;
import id.dana.kyb.domain.interactor.RefreshKybInfo;
import id.dana.kyb.domain.interactor.SaveLastKybTransactionId;
import id.dana.kyb.domain.model.KybCompleteInfo;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.KybRequestPayment;
import id.dana.kyb.domain.model.KybService;
import id.dana.kyb.domain.model.KybStartupConfig;
import id.dana.kyb.domain.model.KybUrlsConfig;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import id.dana.kyb.helper.service.KybServiceRuleManager;
import id.dana.kyb.helper.service.listener.KybServiceListener;
import id.dana.kyb.helper.service.strategy.KybServiceActionStrategyFactory;
import id.dana.kyb.helper.service.strategy.KybServiceActionTypeStrategy;
import id.dana.kyb.helper.service.strategy.KybServiceAuthActionStrategy;
import id.dana.kyb.helper.service.strategy.KybServiceDeepLinkActionStrategy;
import id.dana.kyb.helper.service.strategy.KybServiceJsApiActionStrategy;
import id.dana.kyb.helper.service.strategy.KybServiceUrlActionStrategy;
import id.dana.kyb.mapper.KybModelMapperKt;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.KybServiceValidationResult;
import id.dana.kyb.model.TransactionListQueryModel;
import id.dana.kyb.tracker.KybRenderQrTracker;
import id.dana.kyb.tracker.KybTracker;
import id.dana.mapper.PromotionMapper;
import id.dana.model.PromotionModel;
import id.dana.utils.TagFormat;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 g2\u00020\u0001:\u0001gB§\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0015\u0012\u0006\u0010\u0004\u001a\u00020T\u0012\u0006\u0010\u0005\u001a\u00020-\u0012\u0006\u0010\u0006\u001a\u00020#\u0012\u0006\u0010\u0007\u001a\u00020#\u0012\u0006\u0010W\u001a\u00020!\u0012\u0006\u0010X\u001a\u000200\u0012\u0006\u0010Y\u001a\u000203\u0012\u0006\u0010Z\u001a\u00020E\u0012\u0006\u0010[\u001a\u00020\u001f\u0012\u0006\u0010\\\u001a\u00020&\u0012\u0006\u0010]\u001a\u00020+\u0012\u0006\u0010^\u001a\u00020)\u0012\u0006\u0010_\u001a\u00020\u001d\u0012\u0006\u0010`\u001a\u00020B\u0012\u0006\u0010a\u001a\u00020H\u0012\u0006\u0010b\u001a\u000207\u0012\u0006\u0010c\u001a\u00020<\u0012\f\u0010d\u001a\b\u0012\u0004\u0012\u00020Q0P¢\u0006\u0004\be\u0010fJ9\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ'\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\r\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u001aJ'\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u001bJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u001bJ'\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0014\u0010\r\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0014\u0010\u0011\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010 R\u0014\u0010\u000f\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0014\u0010\b\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0019\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u0013\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010*R\u0014\u0010\u0012\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010,R\u0014\u0010'\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010$\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010.\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00108R\u0014\u00104\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010%R\u0014\u00101\u001a\u0004\u0018\u00010:X\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010;R\u0014\u00109\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001a\u0004\u0018\u00010?X\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010@R\u0014\u0010=\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010IR\u0016\u0010C\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010U"}, d2 = {"Lid/dana/kyb/KybPresenter;", "Lid/dana/kyb/KybContract$Presenter;", "", "p0", "p1", "p2", "p3", "p4", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "()V", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getErrorConfigVersion", "moveToNextValue", "onDestroy", "Landroid/content/Context;", "Lid/dana/kyb/model/KybServiceModel;", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "(Landroid/content/Context;Lid/dana/kyb/model/KybServiceModel;Lid/dana/kyb/helper/service/listener/KybServiceListener;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/kyb/domain/interactor/GetKybBanner;", "Lid/dana/kyb/domain/interactor/GetKybBanner;", "Lid/dana/kyb/domain/interactor/GetKybCompressQrConfig;", "Lid/dana/kyb/domain/interactor/GetKybCompressQrConfig;", "Lid/dana/kyb/domain/interactor/GetKybMerchantInfo;", "lookAheadTest", "Lid/dana/kyb/domain/interactor/GetKybMerchantInfo;", "Lid/dana/kyb/domain/interactor/GetKybPaymentRequest;", "scheduleImpl", "Lid/dana/kyb/domain/interactor/GetKybPaymentRequest;", "Lid/dana/kyb/domain/interactor/GetKybQrisPoster;", "Lid/dana/kyb/domain/interactor/GetKybQrisPoster;", "Lid/dana/kyb/domain/interactor/GetKybServiceList;", "Lid/dana/kyb/domain/interactor/GetKybServiceList;", "Lid/dana/kyb/domain/interactor/GetKybStartupConfig;", "initRecordTimeStamp", "Lid/dana/kyb/domain/interactor/GetKybStartupConfig;", "Lid/dana/kyb/domain/interactor/GetKybTopServices;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/kyb/domain/interactor/GetKybTopServices;", "Lid/dana/kyb/domain/interactor/GetKybTransactionHistory;", "GetContactSyncConfig", "Lid/dana/kyb/domain/interactor/GetKybTransactionHistory;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/kyb/domain/interactor/GetKybUrlsConfig;", "Lid/dana/kyb/domain/interactor/GetKybUrlsConfig;", "DatabaseTableConfigUtil", "Lid/dana/kyb/domain/model/KybCompleteInfo;", "Lid/dana/kyb/domain/model/KybCompleteInfo;", "Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategyFactory;", "PrepareContext", "Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategyFactory;", "Lid/dana/kyb/domain/model/KybStartupConfig;", "Lid/dana/kyb/domain/model/KybStartupConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/mapper/PromotionMapper;", "newProxyInstance", "Lid/dana/mapper/PromotionMapper;", "Lid/dana/kyb/domain/interactor/RefreshKybInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/kyb/domain/interactor/RefreshKybInfo;", "Lid/dana/kyb/domain/interactor/SaveLastKybTransactionId;", "Lid/dana/kyb/domain/interactor/SaveLastKybTransactionId;", "isLayoutRequested", "Ljava/lang/String;", "", "NetworkUserEntityData$$ExternalSyntheticLambda6", "I", "FragmentBottomSheetPaymentSettingBinding", "Ldagger/Lazy;", "Lid/dana/kyb/tracker/KybTracker;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Ldagger/Lazy;", "Lid/dana/kyb/KybContract$View;", "Lid/dana/kyb/KybContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "<init>", "(Landroid/content/Context;Lid/dana/kyb/KybContract$View;Lid/dana/kyb/domain/interactor/GetKybStartupConfig;Lid/dana/kyb/domain/interactor/GetKybMerchantInfo;Lid/dana/kyb/domain/interactor/GetKybMerchantInfo;Lid/dana/kyb/domain/interactor/GetKybCompressQrConfig;Lid/dana/kyb/domain/interactor/GetKybTopServices;Lid/dana/kyb/domain/interactor/GetKybTransactionHistory;Lid/dana/kyb/domain/interactor/RefreshKybInfo;Lid/dana/kyb/domain/interactor/GetKybBanner;Lid/dana/kyb/domain/interactor/GetKybPaymentRequest;Lid/dana/kyb/domain/interactor/GetKybServiceList;Lid/dana/kyb/domain/interactor/GetKybQrisPoster;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/mapper/PromotionMapper;Lid/dana/kyb/domain/interactor/SaveLastKybTransactionId;Lid/dana/kyb/domain/interactor/GetKybUrlsConfig;Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategyFactory;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybPresenter implements KybContract.Presenter {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DeviceInformationProvider BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final GetKybMerchantInfo GetContactSyncConfig;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final KybContract.View NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final GetKybTransactionHistory NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetKybBanner MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetKybServiceList getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final GetKybTopServices lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final GetKybUrlsConfig initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy<KybTracker> NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private int FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final SaveLastKybTransactionId isLayoutRequested;
    private final RefreshKybInfo NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    KybStartupConfig NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final KybServiceActionStrategyFactory DatabaseTableConfigUtil;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    KybCompleteInfo NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GetKybQrisPoster moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final GetKybStartupConfig scheduleImpl;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final String newProxyInstance;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetKybMerchantInfo getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetKybCompressQrConfig PlaceComponentResult;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final PromotionMapper PrepareContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetKybPaymentRequest NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public KybPresenter(Context context, KybContract.View view, GetKybStartupConfig getKybStartupConfig, GetKybMerchantInfo getKybMerchantInfo, GetKybMerchantInfo getKybMerchantInfo2, GetKybCompressQrConfig getKybCompressQrConfig, GetKybTopServices getKybTopServices, GetKybTransactionHistory getKybTransactionHistory, RefreshKybInfo refreshKybInfo, GetKybBanner getKybBanner, GetKybPaymentRequest getKybPaymentRequest, GetKybServiceList getKybServiceList, GetKybQrisPoster getKybQrisPoster, DeviceInformationProvider deviceInformationProvider, PromotionMapper promotionMapper, SaveLastKybTransactionId saveLastKybTransactionId, GetKybUrlsConfig getKybUrlsConfig, KybServiceActionStrategyFactory kybServiceActionStrategyFactory, Lazy<KybTracker> lazy) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getKybStartupConfig, "");
        Intrinsics.checkNotNullParameter(getKybMerchantInfo, "");
        Intrinsics.checkNotNullParameter(getKybMerchantInfo2, "");
        Intrinsics.checkNotNullParameter(getKybCompressQrConfig, "");
        Intrinsics.checkNotNullParameter(getKybTopServices, "");
        Intrinsics.checkNotNullParameter(getKybTransactionHistory, "");
        Intrinsics.checkNotNullParameter(refreshKybInfo, "");
        Intrinsics.checkNotNullParameter(getKybBanner, "");
        Intrinsics.checkNotNullParameter(getKybPaymentRequest, "");
        Intrinsics.checkNotNullParameter(getKybServiceList, "");
        Intrinsics.checkNotNullParameter(getKybQrisPoster, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(promotionMapper, "");
        Intrinsics.checkNotNullParameter(saveLastKybTransactionId, "");
        Intrinsics.checkNotNullParameter(getKybUrlsConfig, "");
        Intrinsics.checkNotNullParameter(kybServiceActionStrategyFactory, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = view;
        this.scheduleImpl = getKybStartupConfig;
        this.getAuthRequestContext = getKybMerchantInfo;
        this.GetContactSyncConfig = getKybMerchantInfo2;
        this.PlaceComponentResult = getKybCompressQrConfig;
        this.lookAheadTest = getKybTopServices;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getKybTransactionHistory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = refreshKybInfo;
        this.MyBillsEntityDataFactory = getKybBanner;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getKybPaymentRequest;
        this.getErrorConfigVersion = getKybServiceList;
        this.moveToNextValue = getKybQrisPoster;
        this.BuiltInFictitiousFunctionClassFactory = deviceInformationProvider;
        this.PrepareContext = promotionMapper;
        this.isLayoutRequested = saveLastKybTransactionId;
        this.initRecordTimeStamp = getKybUrlsConfig;
        this.DatabaseTableConfigUtil = kybServiceActionStrategyFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = lazy;
        this.newProxyInstance = Reflection.getOrCreateKotlinClass(KybPresenter.class).getSimpleName();
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void MyBillsEntityDataFactory() {
        BaseUseCase.execute$default(this.scheduleImpl, NoParams.INSTANCE, new Function1<KybStartupConfig, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybStartupConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(KybStartupConfig kybStartupConfig) {
                invoke2(kybStartupConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KybStartupConfig kybStartupConfig) {
                Intrinsics.checkNotNullParameter(kybStartupConfig, "");
                KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = kybStartupConfig;
            }
        }, null, 4, null);
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory(false);
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<KybCompressQrConfig, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybCompressQrConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(KybCompressQrConfig kybCompressQrConfig) {
                invoke2(kybCompressQrConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KybCompressQrConfig kybCompressQrConfig) {
                KybContract.View view;
                Intrinsics.checkNotNullParameter(kybCompressQrConfig, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.MyBillsEntityDataFactory(kybCompressQrConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybCompressQrConfig$2
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
                KybContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.MyBillsEntityDataFactory(KybCompressQrConfig.INSTANCE.getDefault());
            }
        });
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void moveToNextValue() {
        BaseUseCase.execute$default(this.initRecordTimeStamp, NoParams.INSTANCE, new Function1<KybUrlsConfig, Unit>() { // from class: id.dana.kyb.KybPresenter$getUrlsConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(KybUrlsConfig kybUrlsConfig) {
                invoke2(kybUrlsConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KybUrlsConfig kybUrlsConfig) {
                KybContract.View view;
                Intrinsics.checkNotNullParameter(kybUrlsConfig, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.KClassImpl$Data$declaredNonStaticMembers$2(kybUrlsConfig);
            }
        }, null, 4, null);
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(new GetKybTransactionHistory.Param(p0), new Function1<TransactionListQueryInfo, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybTransactionHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TransactionListQueryInfo transactionListQueryInfo) {
                invoke2(transactionListQueryInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionListQueryInfo transactionListQueryInfo) {
                Context context;
                KybContract.View view;
                Intrinsics.checkNotNullParameter(transactionListQueryInfo, "");
                context = KybPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                TransactionListQueryModel BuiltInFictitiousFunctionClassFactory = KybModelMapperKt.BuiltInFictitiousFunctionClassFactory(transactionListQueryInfo, context);
                KybPresenter.this.FragmentBottomSheetPaymentSettingBinding = transactionListQueryInfo.getTotal();
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybTransactionHistory$2
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
                KybContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.execute(NoParams.INSTANCE, new Function1<Pair<? extends KybMerchantInfo, ? extends TransactionListQueryInfo>, Unit>() { // from class: id.dana.kyb.KybPresenter$refreshKybInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Pair<? extends KybMerchantInfo, ? extends TransactionListQueryInfo> pair) {
                invoke2((Pair<KybMerchantInfo, TransactionListQueryInfo>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<KybMerchantInfo, TransactionListQueryInfo> pair) {
                Context context;
                KybContract.View view;
                Intrinsics.checkNotNullParameter(pair, "");
                KybMerchantInfo component1 = pair.component1();
                TransactionListQueryInfo component2 = pair.component2();
                context = KybPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                TransactionListQueryModel BuiltInFictitiousFunctionClassFactory = KybModelMapperKt.BuiltInFictitiousFunctionClassFactory(component2, context);
                KybPresenter.this.FragmentBottomSheetPaymentSettingBinding = component2.getTotal();
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.PlaceComponentResult(KybModelMapperKt.PlaceComponentResult(component1), BuiltInFictitiousFunctionClassFactory);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$refreshKybInfo$2
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
                KybContract.View view;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                if (th instanceof KybMerchantInfoException) {
                    lazy = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    ((KybTracker) lazy.get()).getAuthRequestContext(th);
                }
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseUseCase.execute$default(this.isLayoutRequested, new SaveLastKybTransactionId.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.kyb.KybPresenter$saveLastTransactionId$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void PlaceComponentResult(boolean p0) {
        this.MyBillsEntityDataFactory.execute(new GetKybBanner.Param(p0), new Function1<Space, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybBanner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Space space) {
                invoke2(space);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Space space) {
                KybContract.View view;
                PromotionMapper promotionMapper;
                Intrinsics.checkNotNullParameter(space, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                promotionMapper = KybPresenter.this.PrepareContext;
                PromotionModel apply = promotionMapper.apply(space);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.BuiltInFictitiousFunctionClassFactory(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybBanner$2
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
                KybContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(NoParams.INSTANCE, new Function1<KybRequestPayment, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybPaymentRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(KybRequestPayment kybRequestPayment) {
                invoke2(kybRequestPayment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KybRequestPayment kybRequestPayment) {
                KybContract.View view;
                Intrinsics.checkNotNullParameter(kybRequestPayment, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.scheduleImpl();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybPaymentRequest$2
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
                String str;
                KybContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                str = KybPresenter.this.newProxyInstance;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getErrorConfigVersion.execute(NoParams.INSTANCE, new Function1<List<? extends KybService>, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybAllServiceList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends KybService> list) {
                invoke2((List<KybService>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<KybService> list) {
                KybContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                List<KybService> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(KybModelMapperKt.PlaceComponentResult((KybService) it.next()));
                }
                view.MyBillsEntityDataFactory(arrayList);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybAllServiceList$2
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
                KybContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        KybStartupConfig kybStartupConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (kybStartupConfig != null && kybStartupConfig.getCashOutV2()) {
            if (p0.length() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(p0);
                Uri parse = Uri.parse(sb.toString());
                Intrinsics.checkNotNullExpressionValue(parse, "");
                Uri.Builder buildUpon = parse.buildUpon();
                buildUpon.appendQueryParameter("merchantId", p1);
                buildUpon.appendQueryParameter("merchantType", p2);
                String obj = buildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                this.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult("New UI");
                this.NetworkUserEntityData$$ExternalSyntheticLambda5.MyBillsEntityDataFactory(obj);
                return;
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.lookAheadTest();
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void PlaceComponentResult(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String deviceUUID = this.BuiltInFictitiousFunctionClassFactory.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        String authRequestContext = getAuthRequestContext(p0, deviceUUID, "WITHDRAW_BALANCE", p1, p2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult("DANA Balance");
        KybContract.View view = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(authRequestContext);
        view.MyBillsEntityDataFactory(sb.toString());
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String deviceUUID = this.BuiltInFictitiousFunctionClassFactory.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        String authRequestContext = getAuthRequestContext(p0, deviceUUID, WithdrawMethodOptionResult.WithdrawMethod.WITHDRAW_BANKCARD, p1, p2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult(TrackerKey.KybWithDrawTypeProperty.BANK_ACCOUNT);
        KybContract.View view = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(authRequestContext);
        view.MyBillsEntityDataFactory(sb.toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // id.dana.kyb.KybContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(Context p0, KybServiceModel p1, KybServiceListener p2) {
        KybServiceUrlActionStrategy kybServiceUrlActionStrategy;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        KybCompleteInfo kybCompleteInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String merchantTier = kybCompleteInfo != null ? kybCompleteInfo.getMerchantTier() : null;
        if (merchantTier == null) {
            merchantTier = "";
        }
        int i = this.FragmentBottomSheetPaymentSettingBinding;
        Intrinsics.checkNotNullParameter(merchantTier, "");
        KybServiceValidationResult KClassImpl$Data$declaredNonStaticMembers$2 = KybServiceRuleManager.KClassImpl$Data$declaredNonStaticMembers$2(p1, merchantTier, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.get().PlaceComponentResult(p1.KClassImpl$Data$declaredNonStaticMembers$2, p1.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
        if (!KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
            return;
        }
        KybServiceActionStrategyFactory kybServiceActionStrategyFactory = this.DatabaseTableConfigUtil;
        String str = p1.BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "");
        switch (str.hashCode()) {
            case 2020776:
                if (str.equals(KybServiceRedirectType.AUTH)) {
                    KybServiceAuthActionStrategy kybServiceAuthActionStrategy = kybServiceActionStrategyFactory.PlaceComponentResult.get();
                    Intrinsics.checkNotNullExpressionValue(kybServiceAuthActionStrategy, "");
                    kybServiceUrlActionStrategy = kybServiceAuthActionStrategy;
                    break;
                }
                KybServiceUrlActionStrategy kybServiceUrlActionStrategy2 = kybServiceActionStrategyFactory.getAuthRequestContext.get();
                Intrinsics.checkNotNullExpressionValue(kybServiceUrlActionStrategy2, "");
                kybServiceUrlActionStrategy = kybServiceUrlActionStrategy2;
                break;
            case 70878225:
                if (str.equals("JSAPI")) {
                    KybServiceJsApiActionStrategy kybServiceJsApiActionStrategy = kybServiceActionStrategyFactory.KClassImpl$Data$declaredNonStaticMembers$2.get();
                    Intrinsics.checkNotNullExpressionValue(kybServiceJsApiActionStrategy, "");
                    kybServiceUrlActionStrategy = kybServiceJsApiActionStrategy;
                    break;
                }
                KybServiceUrlActionStrategy kybServiceUrlActionStrategy22 = kybServiceActionStrategyFactory.getAuthRequestContext.get();
                Intrinsics.checkNotNullExpressionValue(kybServiceUrlActionStrategy22, "");
                kybServiceUrlActionStrategy = kybServiceUrlActionStrategy22;
                break;
            case 1411860198:
                if (str.equals("DEEPLINK")) {
                    KybServiceDeepLinkActionStrategy kybServiceDeepLinkActionStrategy = kybServiceActionStrategyFactory.BuiltInFictitiousFunctionClassFactory.get();
                    Intrinsics.checkNotNullExpressionValue(kybServiceDeepLinkActionStrategy, "");
                    kybServiceUrlActionStrategy = kybServiceDeepLinkActionStrategy;
                    break;
                }
                KybServiceUrlActionStrategy kybServiceUrlActionStrategy222 = kybServiceActionStrategyFactory.getAuthRequestContext.get();
                Intrinsics.checkNotNullExpressionValue(kybServiceUrlActionStrategy222, "");
                kybServiceUrlActionStrategy = kybServiceUrlActionStrategy222;
                break;
            case 1925345846:
                if (str.equals("ACTION")) {
                    KybServiceActionTypeStrategy kybServiceActionTypeStrategy = kybServiceActionStrategyFactory.MyBillsEntityDataFactory.get();
                    Intrinsics.checkNotNullExpressionValue(kybServiceActionTypeStrategy, "");
                    kybServiceUrlActionStrategy = kybServiceActionTypeStrategy;
                    break;
                }
                KybServiceUrlActionStrategy kybServiceUrlActionStrategy2222 = kybServiceActionStrategyFactory.getAuthRequestContext.get();
                Intrinsics.checkNotNullExpressionValue(kybServiceUrlActionStrategy2222, "");
                kybServiceUrlActionStrategy = kybServiceUrlActionStrategy2222;
                break;
            default:
                KybServiceUrlActionStrategy kybServiceUrlActionStrategy22222 = kybServiceActionStrategyFactory.getAuthRequestContext.get();
                Intrinsics.checkNotNullExpressionValue(kybServiceUrlActionStrategy22222, "");
                kybServiceUrlActionStrategy = kybServiceUrlActionStrategy22222;
                break;
        }
        kybServiceUrlActionStrategy.PlaceComponentResult(p0, p1, p2);
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void getErrorConfigVersion() {
        this.moveToNextValue.execute(NoParams.INSTANCE, new Function1<Space, Unit>() { // from class: id.dana.kyb.KybPresenter$getNssCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Space space) {
                invoke2(space);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Space space) {
                KybContract.View view;
                Intrinsics.checkNotNullParameter(space, "");
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.KClassImpl$Data$declaredNonStaticMembers$2(KybModelMapperKt.BuiltInFictitiousFunctionClassFactory(space));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getNssCode$2
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
                String str;
                KybContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                str = KybPresenter.this.newProxyInstance;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.KClassImpl$Data$declaredNonStaticMembers$2((String) null);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.scheduleImpl.dispose();
        this.getAuthRequestContext.dispose();
        this.GetContactSyncConfig.dispose();
        this.PlaceComponentResult.dispose();
        this.lookAheadTest.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.moveToNextValue.dispose();
        this.isLayoutRequested.dispose();
        this.initRecordTimeStamp.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        this.getAuthRequestContext.execute(new GetKybMerchantInfo.Param(true, p0), new Function1<KybCompleteInfo, Unit>() { // from class: id.dana.kyb.KybPresenter$fetchKybMerchantInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(KybCompleteInfo kybCompleteInfo) {
                invoke2(kybCompleteInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KybCompleteInfo kybCompleteInfo) {
                Intrinsics.checkNotNullParameter(kybCompleteInfo, "");
                KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = kybCompleteInfo;
                KybPresenter.Companion companion = KybPresenter.INSTANCE;
                if (KybPresenter.Companion.getAuthRequestContext(kybCompleteInfo) != 1) {
                    KybPresenter.KClassImpl$Data$declaredNonStaticMembers$2(KybPresenter.this, true);
                } else {
                    r2.lookAheadTest.execute(NoParams.INSTANCE, new Function1<List<? extends KybService>, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybTopServices$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(List<? extends KybService> list) {
                            invoke2((List<KybService>) list);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(List<KybService> list) {
                            KybContract.View view;
                            Intrinsics.checkNotNullParameter(list, "");
                            KybPresenter.KClassImpl$Data$declaredNonStaticMembers$2(KybPresenter.this, r2);
                            view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                            view.PlaceComponentResult(KybModelMapperKt.BuiltInFictitiousFunctionClassFactory(list));
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybTopServices$2
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
                            KybContract.View view;
                            Intrinsics.checkNotNullParameter(th, "");
                            KybPresenter.KClassImpl$Data$declaredNonStaticMembers$2(KybPresenter.this, r2);
                            view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                            view.PlaceComponentResult(CollectionsKt.emptyList());
                        }
                    });
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$fetchKybMerchantInfo$2
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
                KybContract.View view;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                if (th instanceof KybMerchantInfoException) {
                    lazy = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    ((KybTracker) lazy.get()).getAuthRequestContext(th);
                }
                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    private static String getAuthRequestContext(String p0, String p1, String p2, String p3, String p4) {
        return TagFormat.MyBillsEntityDataFactory(p0).PlaceComponentResult("merchantId", p3).PlaceComponentResult("merchantType", p4).PlaceComponentResult(UrlParam.REQUEST_ID, p1).PlaceComponentResult("withdrawType", p2).MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/kyb/KybPresenter$Companion;", "", "Lid/dana/kyb/domain/model/KybCompleteInfo;", "", "getAuthRequestContext", "(Lid/dana/kyb/domain/model/KybCompleteInfo;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static int getAuthRequestContext(KybCompleteInfo kybCompleteInfo) {
            Intrinsics.checkNotNullParameter(kybCompleteInfo, "");
            KybResponse kybResponse = kybCompleteInfo.getUserInfoResponse().getKybResponse();
            String orderStatus = kybResponse != null ? kybResponse.getOrderStatus() : null;
            KybMerchantInfo kybMerchantInfo = kybCompleteInfo.getKybMerchantInfo();
            String merchantStatus = kybMerchantInfo != null ? kybMerchantInfo.getMerchantStatus() : null;
            KybMerchantInfo kybMerchantInfo2 = kybCompleteInfo.getKybMerchantInfo();
            boolean freezeFundIn = kybMerchantInfo2 != null ? kybMerchantInfo2.getFreezeFundIn() : false;
            KybMerchantInfo kybMerchantInfo3 = kybCompleteInfo.getKybMerchantInfo();
            boolean freezeFundOut = kybMerchantInfo3 != null ? kybMerchantInfo3.getFreezeFundOut() : false;
            if (Intrinsics.areEqual(orderStatus, "FAILED")) {
                return 5;
            }
            if (Intrinsics.areEqual(orderStatus, "REVOKED")) {
                return 4;
            }
            if (!Intrinsics.areEqual(orderStatus, "INIT")) {
                if (!freezeFundIn && !freezeFundOut) {
                    if (Intrinsics.areEqual(merchantStatus, "ACTIVE")) {
                        return 1;
                    }
                    if (!Intrinsics.areEqual(merchantStatus, "PENDING")) {
                        if (!Intrinsics.areEqual(merchantStatus, "FROZEN")) {
                            return 0;
                        }
                    }
                }
                return 3;
            }
            return 2;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(KybPresenter kybPresenter, boolean z) {
        KybCompleteInfo kybCompleteInfo = kybPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (kybCompleteInfo != null) {
            KybContract.View view = kybPresenter.NetworkUserEntityData$$ExternalSyntheticLambda5;
            view.MyBillsEntityDataFactory(Companion.getAuthRequestContext(kybCompleteInfo), KybModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(kybCompleteInfo));
            view.getAuthRequestContext(kybCompleteInfo.getMerchantTier());
            KybResponse kybResponse = kybCompleteInfo.getUserInfoResponse().getKybResponse();
            String failedReason = kybResponse != null ? kybResponse.getFailedReason() : null;
            Gson create = new GsonBuilder().disableHtmlEscaping().create();
            Type type = new TypeToken<List<? extends String>>() { // from class: id.dana.kyb.KybPresenter$getRejectReason$listType$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            view.getAuthRequestContext((List) create.fromJson(failedReason, type));
            view.BuiltInFictitiousFunctionClassFactory(z);
        }
    }

    @Override // id.dana.kyb.KybContract.Presenter
    public final void MyBillsEntityDataFactory(boolean p0) {
        if (!p0) {
            boolean z = false;
            this.GetContactSyncConfig.execute(new GetKybMerchantInfo.Param(z, z, 2, null), new Function1<KybCompleteInfo, Unit>() { // from class: id.dana.kyb.KybPresenter$fetchLocalKybMerchantInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(KybCompleteInfo kybCompleteInfo) {
                    invoke2(kybCompleteInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(KybCompleteInfo kybCompleteInfo) {
                    Intrinsics.checkNotNullParameter(kybCompleteInfo, "");
                    KybRenderQrTracker.MyBillsEntityDataFactory();
                    KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = kybCompleteInfo;
                    KybPresenter.Companion companion = KybPresenter.INSTANCE;
                    if (KybPresenter.Companion.getAuthRequestContext(kybCompleteInfo) != 1) {
                        KybPresenter.KClassImpl$Data$declaredNonStaticMembers$2(KybPresenter.this, false);
                    } else {
                        r3.lookAheadTest.execute(NoParams.INSTANCE, new Function1<List<? extends KybService>, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybTopServices$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends KybService> list) {
                                invoke2((List<KybService>) list);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(List<KybService> list) {
                                KybContract.View view;
                                Intrinsics.checkNotNullParameter(list, "");
                                KybPresenter.KClassImpl$Data$declaredNonStaticMembers$2(KybPresenter.this, r2);
                                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                                view.PlaceComponentResult(KybModelMapperKt.BuiltInFictitiousFunctionClassFactory(list));
                            }
                        }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$getKybTopServices$2
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
                                KybContract.View view;
                                Intrinsics.checkNotNullParameter(th, "");
                                KybPresenter.KClassImpl$Data$declaredNonStaticMembers$2(KybPresenter.this, r2);
                                view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                                view.PlaceComponentResult(CollectionsKt.emptyList());
                            }
                        });
                    }
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.KybPresenter$fetchLocalKybMerchantInfo$2
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
                    KybContract.View view;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = KybPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            });
        }
        BuiltInFictitiousFunctionClassFactory(true);
    }
}
