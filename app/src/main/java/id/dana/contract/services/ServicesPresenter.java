package id.dana.contract.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.iap.ac.android.acs.plugin.utils.Constants;
import dagger.Lazy;
import id.dana.base.BasePresenter;
import id.dana.contract.services.ServicesContract;
import id.dana.danah5.DanaH5;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.Category;
import id.dana.domain.services.interactor.CheckFavoriteServicesFeature;
import id.dana.domain.services.interactor.GetDefaultServiceWithCategory;
import id.dana.domain.services.interactor.GetFavoriteServiceRemote;
import id.dana.domain.services.interactor.GetFavoriteServiceWithCacheFirst;
import id.dana.domain.services.interactor.GetFavoriteServices;
import id.dana.domain.services.interactor.GetRawServices;
import id.dana.domain.services.interactor.GetServiceHighlighted;
import id.dana.domain.services.interactor.GetServicesByKey;
import id.dana.domain.services.interactor.GetServicesByName;
import id.dana.domain.services.interactor.GetServicesWithCategory;
import id.dana.domain.services.interactor.UpdateServiceHighlighted;
import id.dana.domain.services.model.ThirdPartyAction;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.electronicmoney.RxEmoneyBus;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.miniprogram.ExtensionsKt;
import id.dana.miniprogram.tracker.MiniProgramTracker;
import id.dana.model.ThirdPartyService;
import id.dana.utils.ErrorUtil;
import id.dana.utils.ResourceUtils;
import id.dana.utils.UrlUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]Bë\u0001\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020-\u0012\u0006\u0010\t\u001a\u00020K\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002000(\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020F0(\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020C0(\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020G0(\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020A0(\u0012\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002020(\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u0002040(\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u00020?0(\u0012\f\u0010T\u001a\b\u0012\u0004\u0012\u00020=0(\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u0002080(\u0012\f\u0010V\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020:0(\u0012\f\u0010X\u001a\b\u0012\u0004\u0012\u0002060(\u0012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020;0(\u0012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020I0(¢\u0006\u0004\b[\u0010\\J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0004\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0004\u0010\fJ-\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\r2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0004\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0004\u0010\u0017J%\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0004\u0010\u0019J)\u0010\u0015\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0004\b\u0015\u0010\u001bJ\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u001b\u0010\u0014\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u001cJ\u001b\u0010\u0012\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\u0004\b\u0012\u0010\u0019J-\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0004\u0010\u001dJ\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u001eJ-\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0004\u0010\u001fJ3\u0010\u0014\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001a0 2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\"J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0004\u0010\u001cJ\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010\u0005J\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u001cJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0016J#\u0010\u0012\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u001dJ\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010\u0005R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010*R\u001b\u0010\u0010\u001a\f\u0012\b\u0012\u0006*\u00020\n0\n0+X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010,R\u0014\u0010\u0004\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010.R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010/R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002000(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010*R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010*R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u0002040(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010*R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u0002060(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010*R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u0002080(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010*R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020:0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010*R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020;0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010*R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020=0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010*R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020?0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010*R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020A0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010*R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020C0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010*R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010/R\u001b\u0010D\u001a\f\u0012\b\u0012\u0006*\u00020\n0\n0+X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010,R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020F0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010*R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020G0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010*R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020I0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010*R\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010L"}, d2 = {"Lid/dana/contract/services/ServicesPresenter;", "Lid/dana/contract/services/ServicesContract$Presenter;", "Lid/dana/base/BasePresenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroid/app/Activity;", "p0", "Landroid/content/Intent;", "p1", "", "p2", "(Landroid/content/Intent;Z)V", "Lid/dana/model/ThirdPartyService;", "", "", "MyBillsEntityDataFactory", "(Lid/dana/model/ThirdPartyService;Ljava/util/Map;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lid/dana/model/ThirdPartyService;)Z", "getAuthRequestContext", "PlaceComponentResult", "(Z)V", "(Ljava/lang/String;Z)V", "", "(Ljava/util/List;)V", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "(Ljava/util/List;Ljava/util/List;)V", "(Ljava/lang/String;)V", "(Ljava/util/List;Z)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/util/List;Ljava/lang/String;Z)V", "", "p3", "(Ljava/util/List;ZLjava/lang/String;Z)V", "getErrorConfigVersion", "lookAheadTest", "moveToNextValue", "onDestroy", "scheduleImpl", "Ldagger/Lazy;", "Lid/dana/domain/services/interactor/CheckFavoriteServicesFeature;", "Ldagger/Lazy;", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "Landroid/content/Context;", "Landroid/content/Context;", "Z", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/services/interactor/GetFavoriteServiceRemote;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/services/interactor/GetFavoriteServiceWithCacheFirst;", "DatabaseTableConfigUtil", "Lid/dana/domain/services/interactor/GetFavoriteServices;", "initRecordTimeStamp", "Lid/dana/domain/services/interactor/GetRawServices;", "Lid/dana/domain/services/interactor/GetServiceHighlighted;", "GetContactSyncConfig", "Lid/dana/domain/services/interactor/GetServicesByKey;", "PrepareContext", "Lid/dana/domain/services/interactor/GetServicesByName;", "newProxyInstance", "Lid/dana/domain/services/interactor/GetServicesWithCategory;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/domain/usereducation/interactor/IsNeedToShowToolTip;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "Lid/dana/mapper/ThirdPartyServicesMapper;", "Lid/dana/domain/usereducation/interactor/SaveShowToolTip;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/domain/services/interactor/UpdateServiceHighlighted;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/contract/services/ServicesContract$View;", "Lid/dana/contract/services/ServicesContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Landroid/content/Context;Lid/dana/contract/services/ServicesContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class ServicesPresenter extends BasePresenter implements ServicesContract.Presenter {
    private static final String lookAheadTest = "ServicesPresenter";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Lazy<GetDefaultServiceWithCategory> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy<GetFavoriteServiceWithCacheFirst> getErrorConfigVersion;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final Lazy<UpdateServiceHighlighted> isLayoutRequested;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy<GetServiceHighlighted> initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final PublishSubject<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Lazy<ThirdPartyServicesMapper> newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final ServicesContract.View NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy<GetFavoriteServiceRemote> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy<GetAuthCode> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final Lazy<SaveShowToolTip> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy<IsNeedToShowToolTip> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy<GetServicesWithCategory> DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy<GetRawServices> scheduleImpl;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy<GetServicesByKey> GetContactSyncConfig;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final PublishSubject<Boolean> MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<CheckFavoriteServicesFeature> PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<GetFavoriteServices> moveToNextValue;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean PrepareContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy<GetServicesByName> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final /* synthetic */ void MyBillsEntityDataFactory() {
        ServicesContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str) {
        ServicesContract.Presenter.CC.PlaceComponentResult(this, str);
    }

    @Inject
    public ServicesPresenter(Context context, ServicesContract.View view, Lazy<GetAuthCode> lazy, Lazy<ThirdPartyServicesMapper> lazy2, Lazy<IsNeedToShowToolTip> lazy3, Lazy<SaveShowToolTip> lazy4, Lazy<GetServicesWithCategory> lazy5, Lazy<GetDefaultServiceWithCategory> lazy6, Lazy<GetFavoriteServiceRemote> lazy7, Lazy<GetServicesByName> lazy8, Lazy<GetServicesByKey> lazy9, Lazy<GetFavoriteServices> lazy10, Lazy<CheckFavoriteServicesFeature> lazy11, Lazy<GetRawServices> lazy12, Lazy<GetFavoriteServiceWithCacheFirst> lazy13, Lazy<GetServiceHighlighted> lazy14, Lazy<UpdateServiceHighlighted> lazy15) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
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
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.newProxyInstance = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy4;
        this.DatabaseTableConfigUtil = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy6;
        this.lookAheadTest = lazy7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy8;
        this.GetContactSyncConfig = lazy9;
        this.moveToNextValue = lazy10;
        this.PlaceComponentResult = lazy11;
        this.scheduleImpl = lazy12;
        this.getErrorConfigVersion = lazy13;
        this.initRecordTimeStamp = lazy14;
        this.isLayoutRequested = lazy15;
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.MyBillsEntityDataFactory = PlaceComponentResult;
        PublishSubject<Boolean> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = PlaceComponentResult2;
        this.PrepareContext = true;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.GetContactSyncConfig.get().dispose();
        this.DatabaseTableConfigUtil.get().dispose();
        this.moveToNextValue.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.scheduleImpl.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.lookAheadTest.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.initRecordTimeStamp.get().dispose();
        this.isLayoutRequested.get().dispose();
        dispose();
        DanaH5.dispose();
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.showProgress();
        this.DatabaseTableConfigUtil.get().execute(GetServicesWithCategory.Params.INSTANCE.forFilterCategory(""), new Function1<List<? extends ThirdPartyCategoryService>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getInitThirdPartyServices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyCategoryService> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ThirdPartyCategoryService> list) {
                ServicesContract.View view;
                ServicesContract.View view2;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(list, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                ServicesPresenter.this.getAuthRequestContext(CollectionsKt.toMutableList((Collection) list), false, "", false);
                view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                lazy = ServicesPresenter.this.newProxyInstance;
                view2.onGetInitThirdPartyServices(CollectionsKt.toMutableList((Collection) ((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(list, true, false)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getInitThirdPartyServices$2
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
                ServicesContract.View view;
                ServicesContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                context = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p0;
        if (!TextUtils.isEmpty(str)) {
            Object[] array = StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                ServicesContract.Presenter.CC.getAuthRequestContext(this, CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)), p1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        ServicesContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(List<String> p0, String p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.showProgress();
        if (Intrinsics.areEqual("name", p1)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(new DefaultObserver<List<? extends ThirdPartyCategoryService>>() { // from class: id.dana.contract.services.ServicesPresenter$createFilteredServiceObserver$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    Lazy lazy;
                    ServicesContract.View view;
                    List<? extends ThirdPartyCategoryService> list = (List) obj;
                    Intrinsics.checkNotNullParameter(list, "");
                    lazy = ServicesPresenter.this.newProxyInstance;
                    List<ThirdPartyService> PlaceComponentResult = ((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(list, true, p2);
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.onGetFilteredThirdPartyServices(ServicesPresenter.PlaceComponentResult(PlaceComponentResult));
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p02) {
                    ServicesContract.View view;
                    ServicesContract.View view2;
                    Context context;
                    Intrinsics.checkNotNullParameter(p02, "");
                    super.onError(p02);
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.dismissProgress();
                    view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    context = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.onError(ErrorUtil.PlaceComponentResult(p02, context));
                }
            }, GetServicesByName.Params.forGetServicesByName(p0));
        } else if (Intrinsics.areEqual("key", p1)) {
            this.GetContactSyncConfig.get().execute(new DefaultObserver<List<? extends ThirdPartyCategoryService>>() { // from class: id.dana.contract.services.ServicesPresenter$createFilteredServiceObserver$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    Lazy lazy;
                    ServicesContract.View view;
                    List<? extends ThirdPartyCategoryService> list = (List) obj;
                    Intrinsics.checkNotNullParameter(list, "");
                    lazy = ServicesPresenter.this.newProxyInstance;
                    List<ThirdPartyService> PlaceComponentResult = ((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(list, true, p2);
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.onGetFilteredThirdPartyServices(ServicesPresenter.PlaceComponentResult(PlaceComponentResult));
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p02) {
                    ServicesContract.View view;
                    ServicesContract.View view2;
                    Context context;
                    Intrinsics.checkNotNullParameter(p02, "");
                    super.onError(p02);
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.dismissProgress();
                    view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    context = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.onError(ErrorUtil.PlaceComponentResult(p02, context));
                }
            }, GetServicesByKey.Params.forGetServicesByKey(p0));
        }
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void MyBillsEntityDataFactory(final ThirdPartyService p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!p0.getNetworkUserEntityData$$ExternalSyntheticLambda1()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.onMaintenanceAction(p0);
        } else if (p0.PlaceComponentResult != null) {
            DanaH5.openApp(p0);
        } else if (p0.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.onDirectOpen(p0, p1);
        } else if (Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, "POST") && p0.getCallingPid != null) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (p0.getSubSequence()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5.onActionPost(p0, null);
                return;
            }
            GetAuthCode getAuthCode = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
            String str = p0.getCallingPid;
            if (str == null) {
                str = "";
            }
            String str2 = p0.moveToNextValue;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = p0.VerifyPinStateManager$executeRiskChallenge$2$1;
            getAuthCode.execute(companion.forGetAuthCode(str, str2, str3 != null ? str3 : "", true), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$postAuthCode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                    invoke2(authCodeResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AuthCodeResult authCodeResult) {
                    ServicesContract.View view;
                    Intrinsics.checkNotNullParameter(authCodeResult, "");
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.onActionPost(p0, authCodeResult.getAuthCode());
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$postAuthCode$2
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
                    Context context;
                    Context context2;
                    ServicesContract.View view;
                    Context context3;
                    ServicesContract.View view2;
                    Intrinsics.checkNotNullParameter(th, "");
                    MiniProgramTracker miniProgramTracker = MiniProgramTracker.INSTANCE;
                    context = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    context2 = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    String PlaceComponentResult = ErrorUtil.PlaceComponentResult(th, context2);
                    String str4 = p0.FragmentBottomSheetPaymentSettingBinding;
                    if (str4 == null) {
                        str4 = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                    MiniProgramTracker.BuiltInFictitiousFunctionClassFactory(context, th, Constants.JS_API_GET_AUTH_CODE, PlaceComponentResult, str4);
                    if (!(th instanceof GetAuthCode.MissingRequiredUserInfoException)) {
                        view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        context3 = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view.onError(ErrorUtil.PlaceComponentResult(th, context3));
                    } else {
                        GetAuthCode.MissingRequiredUserInfoException missingRequiredUserInfoException = (GetAuthCode.MissingRequiredUserInfoException) th;
                        String str5 = p0.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        String str6 = p0.FragmentBottomSheetPaymentSettingBinding;
                        String str7 = str6 == null ? "" : str6;
                        String str8 = p0.GetContactSyncConfig;
                        String str9 = p0.VerifyPinStateManager$executeRiskChallenge$2$1;
                        ExtensionsKt.BuiltInFictitiousFunctionClassFactory(missingRequiredUserInfoException, str5, str7, str8, str9 == null ? "" : str9, "", "", false);
                    }
                    view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view2.onActionFailed(th.getMessage());
                }
            });
        } else if (Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, "GET") && p0.NetworkUserEntityData$$ExternalSyntheticLambda6 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.onActionGet(p0);
        } else if (!Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, ThirdPartyAction.MINIAPP) || p0.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.onActionMiniApp(p0);
        }
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final Intent intent, final boolean z) {
        this.DatabaseTableConfigUtil.get().execute(GetServicesWithCategory.Params.INSTANCE.forFilterCategory(""), new Function1<List<? extends ThirdPartyCategoryService>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$consultAndOpenEmoney$1
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $MyBillsEntityDataFactory = 0;
            private static int $PlaceComponentResult = 1;
            private static long getAuthRequestContext = 3514428433562885819L;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(List<? extends ThirdPartyCategoryService> list) {
                int i = $MyBillsEntityDataFactory + 77;
                $PlaceComponentResult = i % 128;
                boolean z2 = i % 2 == 0;
                invoke2(list);
                Unit unit = Unit.INSTANCE;
                if (z2) {
                    Object obj = null;
                    obj.hashCode();
                }
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ThirdPartyCategoryService> list) {
                ServicesContract.View view;
                Lazy lazy;
                Object obj;
                Object obj2;
                Intrinsics.checkNotNullParameter(list, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                lazy = ServicesPresenter.this.newProxyInstance;
                Iterator<T> it = ((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(list, true, false).iterator();
                int i = $MyBillsEntityDataFactory + 99;
                $PlaceComponentResult = i % 128;
                int i2 = i % 2;
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    int i3 = $PlaceComponentResult + 31;
                    $MyBillsEntityDataFactory = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        obj2 = it.next();
                        Object[] objArr = new Object[1];
                        a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 6101, new char[]{36747, 38984, 40992, 51441, 53445, 63666, 355, 10612, 12597, 23016, 25029, 35249, 37473, 47696}, objArr);
                        if (Intrinsics.areEqual(((String) objArr[0]).intern(), ((ThirdPartyService) obj2).NetworkUserEntityData$$ExternalSyntheticLambda8)) {
                            break;
                        }
                    } else {
                        obj2 = it.next();
                        Object[] objArr2 = new Object[1];
                        a(5473 >> (ViewConfiguration.getScrollBarFadeDuration() / 65), new char[]{36747, 38984, 40992, 51441, 53445, 63666, 355, 10612, 12597, 23016, 25029, 35249, 37473, 47696}, objArr2);
                        if (Intrinsics.areEqual(((String) objArr2[0]).intern(), ((ThirdPartyService) obj2).NetworkUserEntityData$$ExternalSyntheticLambda8)) {
                            break;
                        }
                    }
                }
                ThirdPartyService thirdPartyService = (ThirdPartyService) obj2;
                if (thirdPartyService == null) {
                    RxEmoneyBus.getAuthRequestContext().onNext("");
                    int i4 = $MyBillsEntityDataFactory + 9;
                    $PlaceComponentResult = i4 % 128;
                    if (!(i4 % 2 != 0)) {
                        obj.hashCode();
                    }
                } else if (thirdPartyService.getNetworkUserEntityData$$ExternalSyntheticLambda1()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6);
                    sb.append("?updateBalance=true");
                    String authRequestContext = UrlUtil.getAuthRequestContext(sb.toString());
                    RxEmoneyBus.getAuthRequestContext().onNext(authRequestContext);
                    if (z) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("android.nfc.extra.TAG", intent);
                        bundle.putString("url", authRequestContext);
                        DanaH5.startContainerActivity(bundle);
                    }
                }
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                int i2;
                getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
                getonboardingscenario.MyBillsEntityDataFactory = i;
                int length = cArr.length;
                long[] jArr = new long[length];
                getonboardingscenario.getAuthRequestContext = 0;
                while (true) {
                    if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                        break;
                    }
                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
                    getonboardingscenario.getAuthRequestContext++;
                }
                char[] cArr2 = new char[length];
                try {
                    getonboardingscenario.getAuthRequestContext = 0;
                    int i3 = $10 + 29;
                    $11 = i3 % 128;
                    int i4 = i3 % 2;
                    while (true) {
                        if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                            objArr[0] = new String(cArr2);
                            return;
                        }
                        int i5 = $11 + 21;
                        $10 = i5 % 128;
                        if (i5 % 2 != 0) {
                            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                            i2 = getonboardingscenario.getAuthRequestContext / 0;
                        } else {
                            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                            i2 = getonboardingscenario.getAuthRequestContext + 1;
                        }
                        getonboardingscenario.getAuthRequestContext = i2;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$consultAndOpenEmoney$2
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
                ServicesContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                ServicesPresenter.PlaceComponentResult(ServicesPresenter.this, DanaLogConstants.Prefix.CONSULT_AND_OPEN_ELECTRONICMONEY, th);
            }
        });
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void PlaceComponentResult(boolean p0) {
        Intrinsics.checkNotNullParameter("", "");
        List<String> singletonList = Collections.singletonList("");
        Intrinsics.checkNotNullExpressionValue(singletonList, "");
        BuiltInFictitiousFunctionClassFactory(singletonList, p0);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<String> singletonList = Collections.singletonList(p0);
        Intrinsics.checkNotNullExpressionValue(singletonList, "");
        BuiltInFictitiousFunctionClassFactory(singletonList, p1);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        BuiltInFictitiousFunctionClassFactory(list, true);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        List<String> listOf = CollectionsKt.listOf(Category.FEATURED);
        if (this.getAuthRequestContext) {
            PlaceComponentResult(listOf, CollectionsKt.emptyList());
        } else {
            getAuthRequestContext(listOf);
        }
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void PlaceComponentResult() {
        GetFavoriteServiceRemote getFavoriteServiceRemote = this.lookAheadTest.get();
        Intrinsics.checkNotNullExpressionValue(getFavoriteServiceRemote, "");
        BaseUseCase.execute$default(getFavoriteServiceRemote, NoParams.INSTANCE, new Function1<ThirdPartyCategoryService, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getFeatureServicesRemote$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ThirdPartyCategoryService thirdPartyCategoryService) {
                Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ThirdPartyCategoryService thirdPartyCategoryService) {
                invoke2(thirdPartyCategoryService);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.showProgress();
        this.DatabaseTableConfigUtil.get().execute(GetServicesWithCategory.Params.INSTANCE.forFilterCategory(""), new Function1<List<? extends ThirdPartyCategoryService>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getSearchedServices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyCategoryService> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ThirdPartyCategoryService> list) {
                ServicesContract.View view;
                Lazy lazy;
                ServicesContract.View view2;
                ServicesContract.View view3;
                Intrinsics.checkNotNullParameter(list, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                ServicesPresenter servicesPresenter = ServicesPresenter.this;
                String str = p0;
                lazy = servicesPresenter.newProxyInstance;
                ThirdPartyServicesMapper thirdPartyServicesMapper = (ThirdPartyServicesMapper) lazy.get();
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (true ^ Intrinsics.areEqual(((ThirdPartyCategoryService) obj).getKey(), Category.FEATURED)) {
                        arrayList.add(obj);
                    }
                }
                List KClassImpl$Data$declaredNonStaticMembers$2 = ServicesPresenter.KClassImpl$Data$declaredNonStaticMembers$2(servicesPresenter, str, CollectionsKt.toMutableList((Collection) thirdPartyServicesMapper.PlaceComponentResult(arrayList, true, false)));
                if (KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    view3 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view3.onEmptySearchService();
                    return;
                }
                view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view2.onGetThirdPartyServices(CollectionsKt.toMutableList((Collection) KClassImpl$Data$declaredNonStaticMembers$2));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getSearchedServices$2
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
                ServicesContract.View view;
                ServicesContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                context = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        CheckFavoriteServicesFeature checkFavoriteServicesFeature = this.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(checkFavoriteServicesFeature, "");
        BaseUseCase.execute$default(checkFavoriteServicesFeature, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$checkFavoriteServicesFeature$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                ServicesContract.View view;
                ServicesPresenter.this.getAuthRequestContext = z;
                lazy = ServicesPresenter.this.newProxyInstance;
                ((ThirdPartyServicesMapper) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2 = z;
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.onCheckFavoriteServicesFeature(z);
            }
        }, null, 4, null);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.services.ServicesPresenter$isNeedToShowToolTip$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ServicesContract.View view;
                ServicesContract.View view2;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view2.onShowTooltip(booleanValue);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                ServicesContract.View view;
                ServicesContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view2.onShowTooltip(false);
                ServicesPresenter.PlaceComponentResult(ServicesPresenter.this, DanaLogConstants.Prefix.IS_NEED_TO_SHOW_TOOLTIP_PREFIX, p02);
            }
        }, IsNeedToShowToolTip.Params.forShowTooltip(p0));
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.services.ServicesPresenter$saveShowToolTip$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServicesPresenter.PlaceComponentResult(ServicesPresenter.this, DanaLogConstants.Prefix.SAVE_SHOW_TOOLTIP_PREFIX, p0);
            }
        }, SaveShowToolTip.Params.forSaveShowToolTip(true, str));
    }

    private final boolean PlaceComponentResult(String p0, ThirdPartyService p1) {
        return getAuthRequestContext(p0, p1) || BuiltInFictitiousFunctionClassFactory(p0, p1) || KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    private final void BuiltInFictitiousFunctionClassFactory(final List<String> list, final boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.showProgress();
        final boolean z2 = false;
        this.DatabaseTableConfigUtil.get().execute(GetServicesWithCategory.Params.INSTANCE.forFilterCategory(list), new Function1<List<? extends ThirdPartyCategoryService>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getServicesByCategory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyCategoryService> list2) {
                invoke2(list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ThirdPartyCategoryService> list2) {
                ServicesContract.View view;
                Intrinsics.checkNotNullParameter(list2, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                if (1 >= list.size()) {
                    ServicesPresenter.this.getAuthRequestContext(CollectionsKt.toMutableList((Collection) list2), z2, list.isEmpty() ^ true ? list.get(0) : "", z);
                } else {
                    ServicesPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(list2, true);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getServicesByCategory$2
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
                ServicesContract.View view;
                ServicesContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                context = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
            }
        });
    }

    public final void getAuthRequestContext(final List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.DatabaseTableConfigUtil.get().execute(GetServicesWithCategory.Params.INSTANCE.forFilterCategory(p0), new Function1<List<? extends ThirdPartyCategoryService>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getFeaturedServicesDefault$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyCategoryService> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ThirdPartyCategoryService> list) {
                ServicesContract.View view;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(list, "");
                view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                view.dismissProgress();
                lazy = ServicesPresenter.this.newProxyInstance;
                ServicesPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(CollectionsKt.toMutableList((Collection) list)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getFeaturedServicesDefault$2
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
                final ServicesPresenter servicesPresenter = ServicesPresenter.this;
                List<String> list = p0;
                Intrinsics.checkNotNullParameter(list, "");
                servicesPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(GetDefaultServiceWithCategory.Params.INSTANCE.forFilterCategory(list), new Function1<List<? extends ThirdPartyCategoryService>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getFeaturedServicesConfigDefault$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyCategoryService> list2) {
                        invoke2(list2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends ThirdPartyCategoryService> list2) {
                        ServicesContract.View view;
                        Lazy lazy;
                        Intrinsics.checkNotNullParameter(list2, "");
                        view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        view.dismissProgress();
                        lazy = ServicesPresenter.this.newProxyInstance;
                        ServicesPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(CollectionsKt.toMutableList((Collection) list2)));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getFeaturedServicesConfigDefault$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th2) {
                        ServicesContract.View view;
                        ServicesContract.View view2;
                        Context context;
                        Intrinsics.checkNotNullParameter(th2, "");
                        view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        view.dismissProgress();
                        view2 = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        context = ServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view2.onError(ErrorUtil.PlaceComponentResult(th2, context));
                        CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th2);
                    }
                });
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
            }
        });
    }

    public final void getAuthRequestContext(final List<ThirdPartyCategoryService> p0, boolean p1, String p2, boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        final boolean isEmpty = TextUtils.isEmpty(p2);
        if (p1) {
            if (this.getAuthRequestContext) {
                PlaceComponentResult(CollectionsKt.listOf(p2), p0);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2(this.newProxyInstance.get().PlaceComponentResult(p0));
            }
        } else if (this.getAuthRequestContext && (isEmpty || Intrinsics.areEqual(Category.FEATURED, p2))) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.moveToNextValue.get().execute(new DefaultObserver<ThirdPartyCategoryService>() { // from class: id.dana.contract.services.ServicesPresenter$mergeWithFavoriteServices$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    Lazy lazy;
                    ServicesContract.View view;
                    ThirdPartyCategoryService thirdPartyCategoryService = (ThirdPartyCategoryService) obj;
                    Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
                    ServicesPresenter.MyBillsEntityDataFactory(p0, thirdPartyCategoryService);
                    lazy = ServicesPresenter.this.newProxyInstance;
                    List<ThirdPartyService> PlaceComponentResult = ((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(p0, isEmpty, false);
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.onGetThirdPartyServices(CollectionsKt.toMutableList((Collection) PlaceComponentResult));
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p02) {
                    ServicesContract.View view;
                    Lazy lazy;
                    Intrinsics.checkNotNullParameter(p02, "");
                    super.onError(p02);
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.FAVORITE_SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, p02);
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    lazy = ServicesPresenter.this.newProxyInstance;
                    view.onGetThirdPartyServices(CollectionsKt.toMutableList((Collection) ((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(p0, true, isEmpty)));
                }
            });
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(p0, p3);
        }
    }

    private void PlaceComponentResult(final List<String> p0, final List<? extends ThirdPartyCategoryService> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getErrorConfigVersion.get().execute(NoParams.INSTANCE, new Function1<ThirdPartyCategoryService, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getFavoriteServices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ThirdPartyCategoryService thirdPartyCategoryService) {
                invoke2(thirdPartyCategoryService);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ThirdPartyCategoryService thirdPartyCategoryService) {
                Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
                ServicesPresenter servicesPresenter = ServicesPresenter.this;
                Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
                ThirdPartyServicesMapper thirdPartyServicesMapper = servicesPresenter.newProxyInstance.get();
                Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
                servicesPresenter.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyServicesMapper.PlaceComponentResult(CollectionsKt.listOf(thirdPartyCategoryService)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getFavoriteServices$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Intrinsics.checkNotNullParameter(th, "");
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.FAVORITE_SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
                if (p1.isEmpty()) {
                    this.getAuthRequestContext(p0);
                    return;
                }
                ServicesPresenter servicesPresenter = this;
                lazy = servicesPresenter.newProxyInstance;
                servicesPresenter.KClassImpl$Data$declaredNonStaticMembers$2(CollectionsKt.toMutableList((Collection) ((ThirdPartyServicesMapper) lazy.get()).PlaceComponentResult(p1)));
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<ThirdPartyService> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final List mutableList = CollectionsKt.toMutableList((Collection) p0);
        this.initRecordTimeStamp.get().execute(NoParams.INSTANCE, new Function1<Optional<ThirdPartyServiceResponse>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getServiceHighlighted$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Optional<ThirdPartyServiceResponse> optional) {
                invoke2(optional);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Optional<ThirdPartyServiceResponse> optional) {
                boolean z;
                ServicesContract.View view;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(optional, "");
                if (optional.KClassImpl$Data$declaredNonStaticMembers$2() && (!mutableList.isEmpty()) != false) {
                    lazy = this.newProxyInstance;
                    ThirdPartyServicesMapper thirdPartyServicesMapper = (ThirdPartyServicesMapper) lazy.get();
                    Object obj = optional.PlaceComponentResult;
                    if (obj != null) {
                        ThirdPartyService MyBillsEntityDataFactory = ThirdPartyServicesMapper.MyBillsEntityDataFactory((ThirdPartyServiceResponse) obj);
                        if (MyBillsEntityDataFactory != null) {
                            mutableList.set(0, MyBillsEntityDataFactory);
                        }
                    } else {
                        throw new NoSuchElementException("No value present");
                    }
                }
                z = this.PrepareContext;
                if (z) {
                    view = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.onFeatureServices(ServicesPresenter.PlaceComponentResult(mutableList));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$getServiceHighlighted$2
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
                boolean z;
                ServicesContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                z = ServicesPresenter.this.PrepareContext;
                if (z) {
                    view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    view.onFeatureServices(ServicesPresenter.PlaceComponentResult(mutableList));
                }
            }
        });
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void scheduleImpl() {
        UpdateServiceHighlighted updateServiceHighlighted = this.isLayoutRequested.get();
        Intrinsics.checkNotNullExpressionValue(updateServiceHighlighted, "");
        CompletableUseCase.execute$default(updateServiceHighlighted, NoParams.INSTANCE, null, null, 6, null);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void getErrorConfigVersion() {
        addDisposable(Observable.combineLatest(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda7, new BiFunction() { // from class: id.dana.contract.services.ServicesPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                valueOf = Boolean.valueOf(r0 && r1);
                return valueOf;
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.contract.services.ServicesPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ServicesPresenter.MyBillsEntityDataFactory(ServicesPresenter.this, ((Boolean) obj).booleanValue());
            }
        }));
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void lookAheadTest() {
        this.MyBillsEntityDataFactory.onNext(Boolean.TRUE);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void moveToNextValue() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.onNext(Boolean.TRUE);
    }

    @Override // id.dana.contract.services.ServicesContract.Presenter
    public final void getAuthRequestContext(boolean p0) {
        this.PrepareContext = p0;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends ThirdPartyCategoryService> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.onGetThirdPartyServices(CollectionsKt.toMutableList((Collection) this.newProxyInstance.get().PlaceComponentResult(p0, true, p1)));
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ServicesPresenter servicesPresenter, boolean z) {
        Intrinsics.checkNotNullParameter(servicesPresenter, "");
        if (z) {
            servicesPresenter.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static final /* synthetic */ List PlaceComponentResult(List list) {
        String str;
        if (list.isEmpty() || list.size() == 1) {
            return CollectionsKt.toMutableList((Collection) list);
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ThirdPartyService thirdPartyService = (ThirdPartyService) obj;
            if (thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8.length() == 0) {
                str = thirdPartyService.FragmentBottomSheetPaymentSettingBinding;
            } else {
                str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8;
            }
            if (hashSet.add(str)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public static final /* synthetic */ void PlaceComponentResult(ServicesPresenter servicesPresenter, String str, Throwable th) {
        String str2 = lookAheadTest;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(servicesPresenter.getClass().getName());
        sb.append(" onError");
        DanaLog.BuiltInFictitiousFunctionClassFactory(str2, sb.toString(), th);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(List list, ThirdPartyCategoryService thirdPartyCategoryService) {
        if (Intrinsics.areEqual(Category.FEATURED, ((ThirdPartyCategoryService) list.get(0)).getKey())) {
            list.set(0, thirdPartyCategoryService);
        }
    }

    public static final /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(ServicesPresenter servicesPresenter, String str, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ThirdPartyService thirdPartyService = (ThirdPartyService) next;
            if (thirdPartyService.D != 3 && servicesPresenter.PlaceComponentResult(str, thirdPartyService)) {
                arrayList.add(next);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        if ((!mutableList.isEmpty()) != false && ((ThirdPartyService) mutableList.get(mutableList.size() - 1)).D == 3) {
            mutableList.remove(mutableList.get(mutableList.size() - 1));
        }
        return mutableList;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, ThirdPartyService p1) {
        String str = p1.lookAheadTest;
        if (str == null) {
            str = "";
        }
        return StringsKt.contains((CharSequence) str, (CharSequence) p0, true);
    }

    private static boolean getAuthRequestContext(String p0, ThirdPartyService p1) {
        List<String> list = p1.PrepareContext;
        if (list != null) {
            List<String> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains((CharSequence) ((String) it.next()), (CharSequence) p0, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(String p0, ThirdPartyService p1) {
        Set<String> ofNotNull = SetsKt.setOfNotNull((Object[]) new String[]{p1.FragmentBottomSheetPaymentSettingBinding, p1.NetworkUserEntityData$$ExternalSyntheticLambda3});
        if ((ofNotNull instanceof Collection) && ofNotNull.isEmpty()) {
            return false;
        }
        for (String str : ofNotNull) {
            String str2 = p0;
            if (StringsKt.contains((CharSequence) str, (CharSequence) str2, true) || StringsKt.contains((CharSequence) ResourceUtils.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, str, str), (CharSequence) str2, true)) {
                return true;
            }
        }
        return false;
    }
}
