package id.dana.contract.globalsearch;

import android.content.Context;
import android.location.Location;
import dagger.Lazy;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.danah5.DanaH5;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.SkuAttribute;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.merchant.interactor.GetMerchantSubcategories;
import id.dana.domain.merchant.model.MerchantSubcategory;
import id.dana.domain.notificationcenter.interactor.ConnectionType;
import id.dana.domain.services.interactor.GetRawServices;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig;
import id.dana.explore.domain.globalsearch.interactor.GetHintSwipeVisibilityState;
import id.dana.explore.domain.globalsearch.interactor.GetHomeSearchBarVisibility;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearch;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearchPlaceholder;
import id.dana.explore.domain.globalsearch.interactor.GetRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword;
import id.dana.explore.domain.globalsearch.interactor.IsFeatureGlobalSearchEnabled;
import id.dana.explore.domain.globalsearch.interactor.SaveLocationPermissionSuggestionState;
import id.dana.explore.domain.globalsearch.interactor.SaveRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.SetHintSwipeVisibilityState;
import id.dana.explore.domain.globalsearch.model.AutoCompleteResult;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.explore.domain.globalsearch.model.SearchResultResponse;
import id.dana.explore.domain.sku.interactor.GetPrepaidCheckoutUrl;
import id.dana.explore.domain.sku.interactor.GetSkuExplore;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization;
import id.dana.explore.domain.userpersonalization.model.ShouldOpenUserPersonalizationModelWrapper;
import id.dana.globalsearch.mapper.ConvertDataToRecentAutoCompleteKt;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.SearchPerCategoryRequestModel;
import id.dana.globalsearch.model.SearchResult;
import id.dana.globalsearch.model.SearchResultExtKt;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.miniprogram.ExtensionsKt;
import id.dana.util.permission.Permission;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 s2\u00020\u0001:\u0002stBÅ\u0002\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020,\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020G0(\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002020(\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020M0(\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002090(\u0012\f\u0010_\u001a\b\u0012\u0004\u0012\u00020C0(\u0012\f\u0010`\u001a\b\u0012\u0004\u0012\u0002050(\u0012\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\\0(\u0012\f\u0010b\u001a\b\u0012\u0004\u0012\u00020=0(\u0012\f\u0010c\u001a\b\u0012\u0004\u0012\u0002010(\u0012\f\u0010d\u001a\b\u0012\u0004\u0012\u00020T0(\u0012\f\u0010e\u001a\b\u0012\u0004\u0012\u00020+0(\u0012\f\u0010f\u001a\b\u0012\u0004\u0012\u00020^0(\u0012\f\u0010g\u001a\b\u0012\u0004\u0012\u00020E0(\u0012\f\u0010h\u001a\b\u0012\u0004\u0012\u00020V0(\u0012\f\u0010i\u001a\b\u0012\u0004\u0012\u00020?0(\u0012\f\u0010j\u001a\b\u0012\u0004\u0012\u0002030(\u0012\f\u0010k\u001a\b\u0012\u0004\u0012\u0002070(\u0012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020I0(\u0012\f\u0010m\u001a\b\u0012\u0004\u0012\u00020A0(\u0012\f\u0010n\u001a\b\u0012\u0004\u0012\u00020;0(\u0012\f\u0010o\u001a\b\u0012\u0004\u0012\u00020K0(\u0012\f\u0010p\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\u0004\bq\u0010rJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bJ?\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u000b\u0010\u0018J\u001f\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0004\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\bJ+\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\tH\u0000¢\u0006\u0004\b\u0010\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\bJE\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140!j\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014`\"2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020 0\u0014H\u0016¢\u0006\u0004\b\u000b\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\bJ\u0017\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0004\u0010\u000fJ\u0017\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020%H\u0016¢\u0006\u0004\b\u0004\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010*R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020+0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010*R\u0014\u0010\u000e\u001a\u00020,8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010-R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020 0\u0014X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010.R\u0018\u0010\u0004\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u00100R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002010(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010*R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002020(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010*R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002030(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b4\u0010*R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002050(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b6\u0010*R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002070(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b8\u0010*R\u001a\u00104\u001a\b\u0012\u0004\u0012\u0002090(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010*R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020;0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b<\u0010*R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020=0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b>\u0010*R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020?0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b@\u0010*R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020A0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bB\u0010*R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020C0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bD\u0010*R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020E0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bF\u0010*R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020G0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bH\u0010*R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020I0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bJ\u0010*R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020K0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bL\u0010*R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020M0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bN\u0010*R\u001a\u0010L\u001a\u00020\n8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0004\u0010O\u001a\u0004\b6\u0010PR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020R0QX\u0001¢\u0006\u0006\n\u0004\b\u0010\u0010.R\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010.R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020T0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bU\u0010*R\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020V0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bW\u0010*R\u0014\u0010[\u001a\u0004\u0018\u00010YX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010ZR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\\0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bX\u0010*R\u0012\u0010W\u001a\u00020\rX\u0087\"¢\u0006\u0006\n\u0004\b\u000b\u0010]R\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020^0(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b[\u0010*"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchPresenter;", "Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "Lid/dana/globalsearch/model/SearchResultModel;", "p0", "getAuthRequestContext", "(Lid/dana/globalsearch/model/SearchResultModel;)Lid/dana/globalsearch/model/SearchResultModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lkotlin/Function1;", "", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "", "p1", "p2", "", "p3", "Landroid/location/Location;", "p4", "(Ljava/lang/String;IILjava/util/List;Landroid/location/Location;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "(Lid/dana/globalsearch/model/SearchResultModel;Lkotlin/jvm/functions/Function1;)V", "moveToNextValue", "scheduleImpl", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/List;)Ljava/util/HashMap;", "onDestroy", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "(Lid/dana/globalsearch/model/PaySearchInfoModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ldagger/Lazy;", "Lid/dana/explore/domain/userpersonalization/interactor/CheckShouldShowUserPersonalization;", "Ldagger/Lazy;", "Lid/dana/explore/domain/globalsearch/interactor/CheckShouldSuggestLocationPermissionDialog;", "Landroid/content/Context;", "Landroid/content/Context;", "Ljava/util/List;", "Lid/dana/contract/globalsearch/GlobalSearchPresenter$SearchQuery;", "Lid/dana/contract/globalsearch/GlobalSearchPresenter$SearchQuery;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/explore/domain/globalsearch/interactor/GetAutoCompleteByKeyword;", "Lid/dana/explore/domain/globalsearch/interactor/GetGlobalSearchConfig;", "DatabaseTableConfigUtil", "Lid/dana/explore/domain/globalsearch/interactor/GetHintSwipeVisibilityState;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/explore/domain/globalsearch/interactor/GetHomeSearchBarVisibility;", "initRecordTimeStamp", "Lid/dana/domain/merchant/interactor/GetMerchantSubcategories;", "GetContactSyncConfig", "Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant;", "newProxyInstance", "Lid/dana/explore/domain/globalsearch/interactor/GetPopularSearch;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/explore/domain/globalsearch/interactor/GetPopularSearchPlaceholder;", "PrepareContext", "Lid/dana/explore/domain/sku/interactor/GetPrepaidCheckoutUrl;", "isLayoutRequested", "Lid/dana/domain/services/interactor/GetRawServices;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/explore/domain/globalsearch/interactor/GetRecentSearch;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/explore/domain/globalsearch/interactor/GetSearchByKeyword;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/explore/domain/sku/interactor/GetSkuExplore;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/domain/account/interactor/GetUserId;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/explore/domain/globalsearch/interactor/IsFeatureGlobalSearchEnabled;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Z", "()Z", "", "Lid/dana/domain/merchant/model/MerchantSubcategory;", "readMicros", "Lid/dana/explore/domain/globalsearch/interactor/SaveLocationPermissionSuggestionState;", "SubSequence", "Lid/dana/explore/domain/globalsearch/interactor/SaveRecentSearch;", "getSupportButtonTintMode", "getCallingPid", "Lid/dana/globalsearch/model/SearchPerCategoryRequestModel;", "Lid/dana/globalsearch/model/SearchPerCategoryRequestModel;", "whenAvailable", "Lid/dana/explore/domain/globalsearch/interactor/SetHintSwipeVisibilityState;", "Ljava/lang/String;", "Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "<init>", "(Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion", "SearchQuery"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class GlobalSearchPresenter implements GlobalSearchContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final List<MerchantSubcategory> NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy<GetGlobalSearchConfig> moveToNextValue;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final Lazy<GetUserId> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy<GetMerchantSubcategories> DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    SearchPerCategoryRequestModel whenAvailable;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    List<ThirdPartyServiceResponse> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy<GetAutoCompleteByKeyword> scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy<GetHintSwipeVisibilityState> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy<GetSkuExplore> PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final Lazy<GetSearchByKeyword> isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final Lazy<GetRecentSearch> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy<IsFeatureGlobalSearchEnabled> NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy<GetRawServices> newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy<GetPopularSearch> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String getSupportButtonTintMode;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy<GetPopularSearchPlaceholder> initRecordTimeStamp;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final Lazy<SaveLocationPermissionSuggestionState> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy<SetHintSwipeVisibilityState> SubSequence;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<CheckShouldShowUserPersonalization> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private final Lazy<SaveRecentSearch> getCallingPid;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<GetHomeSearchBarVisibility> lookAheadTest;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy<GetPrepaidCheckoutUrl> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<GetAuthCode> getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private SearchQuery getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy<GetOnlineMerchant> GetContactSyncConfig;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private List<String> NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<CheckShouldSuggestLocationPermissionDialog> PlaceComponentResult;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy<GlobalSearchContract.View> readMicros;

    @Inject
    public GlobalSearchPresenter(Context context, Lazy<GetSearchByKeyword> lazy, Lazy<GetAutoCompleteByKeyword> lazy2, Lazy<IsFeatureGlobalSearchEnabled> lazy3, Lazy<GetMerchantSubcategories> lazy4, Lazy<GetRawServices> lazy5, Lazy<GetHintSwipeVisibilityState> lazy6, Lazy<SetHintSwipeVisibilityState> lazy7, Lazy<GetPopularSearch> lazy8, Lazy<GetAuthCode> lazy9, Lazy<SaveLocationPermissionSuggestionState> lazy10, Lazy<CheckShouldSuggestLocationPermissionDialog> lazy11, Lazy<GlobalSearchContract.View> lazy12, Lazy<GetRecentSearch> lazy13, Lazy<SaveRecentSearch> lazy14, Lazy<GetPopularSearchPlaceholder> lazy15, Lazy<GetGlobalSearchConfig> lazy16, Lazy<GetHomeSearchBarVisibility> lazy17, Lazy<GetSkuExplore> lazy18, Lazy<GetPrepaidCheckoutUrl> lazy19, Lazy<GetOnlineMerchant> lazy20, Lazy<GetUserId> lazy21, Lazy<CheckShouldShowUserPersonalization> lazy22) {
        Intrinsics.checkNotNullParameter(context, "");
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
        Intrinsics.checkNotNullParameter(lazy16, "");
        Intrinsics.checkNotNullParameter(lazy17, "");
        Intrinsics.checkNotNullParameter(lazy18, "");
        Intrinsics.checkNotNullParameter(lazy19, "");
        Intrinsics.checkNotNullParameter(lazy20, "");
        Intrinsics.checkNotNullParameter(lazy21, "");
        Intrinsics.checkNotNullParameter(lazy22, "");
        this.MyBillsEntityDataFactory = context;
        this.isLayoutRequested = lazy;
        this.scheduleImpl = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = lazy3;
        this.DatabaseTableConfigUtil = lazy4;
        this.newProxyInstance = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy6;
        this.SubSequence = lazy7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy8;
        this.getErrorConfigVersion = lazy9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = lazy10;
        this.PlaceComponentResult = lazy11;
        this.readMicros = lazy12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy13;
        this.getCallingPid = lazy14;
        this.initRecordTimeStamp = lazy15;
        this.moveToNextValue = lazy16;
        this.lookAheadTest = lazy17;
        this.PrepareContext = lazy18;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy19;
        this.GetContactSyncConfig = lazy20;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy21;
        this.BuiltInFictitiousFunctionClassFactory = lazy22;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = CollectionsKt.emptyList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().execute(new DefaultObserver<String>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getCurrentUserId$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                GlobalSearchPresenter globalSearchPresenter = GlobalSearchPresenter.this;
                Intrinsics.checkNotNullParameter(str, "");
                globalSearchPresenter.getSupportButtonTintMode = str;
            }
        });
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda2")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from getter */
    public final boolean getFragmentBottomSheetPaymentSettingBinding() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void scheduleImpl() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$isFeatureEnabled$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final boolean z) {
                Lazy lazy;
                lazy = GlobalSearchPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                GetHintSwipeVisibilityState getHintSwipeVisibilityState = (GetHintSwipeVisibilityState) lazy.get();
                NoParams noParams = NoParams.INSTANCE;
                final GlobalSearchPresenter globalSearchPresenter = GlobalSearchPresenter.this;
                getHintSwipeVisibilityState.execute(noParams, new Function1<Boolean, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$isFeatureEnabled$1.1
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
                        Lazy lazy2;
                        lazy2 = GlobalSearchPresenter.this.readMicros;
                        ((GlobalSearchContract.View) lazy2.get()).MyBillsEntityDataFactory(z);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$isFeatureEnabled$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
                    }
                });
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$isFeatureEnabled$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, exc.toString());
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void getErrorConfigVersion() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            this.newProxyInstance.get().execute(NoParams.INSTANCE, new Function1<List<? extends ThirdPartyServiceResponse>, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getAvailableServices$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyServiceResponse> list) {
                    invoke2((List<ThirdPartyServiceResponse>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<ThirdPartyServiceResponse> list) {
                    Intrinsics.checkNotNullParameter(list, "");
                    GlobalSearchPresenter globalSearchPresenter = GlobalSearchPresenter.this;
                    Intrinsics.checkNotNullParameter(list, "");
                    globalSearchPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = list;
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getAvailableServices$2
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
                }
            });
        }
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void getAuthRequestContext() {
        this.isLayoutRequested.get().dispose();
        this.DatabaseTableConfigUtil.get().dispose();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().dispose();
        this.isLayoutRequested.get().dispose();
        this.scheduleImpl.get().dispose();
        this.DatabaseTableConfigUtil.get().dispose();
        this.newProxyInstance.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.initRecordTimeStamp.get().dispose();
        this.moveToNextValue.get().dispose();
        this.lookAheadTest.get().dispose();
        this.PrepareContext.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
        this.GetContactSyncConfig.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        DanaH5.dispose();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void PlaceComponentResult(final String p0, int p1, int p2, List<String> p3, Location p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.FragmentBottomSheetPaymentSettingBinding = true;
        this.getAuthRequestContext = new SearchQuery(p0, p1, p2, p3, false, 16, null);
        this.readMicros.get().showProgress();
        this.readMicros.get().PlaceComponentResult(CollectionsKt.emptyList());
        GetSearchByKeyword getSearchByKeyword = this.isLayoutRequested.get();
        GetSearchByKeyword.Params.Companion companion = GetSearchByKeyword.Params.INSTANCE;
        String str = this.getSupportButtonTintMode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        getSearchByKeyword.execute(GetSearchByKeyword.Params.Companion.BuiltInFictitiousFunctionClassFactory(p0, p1, p2, p3, p4, str), new Function1<List<? extends SearchResultResponse>, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchResultResponse> list) {
                invoke2((List<SearchResultResponse>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<SearchResultResponse> list) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Context context;
                Lazy lazy4;
                Context context2;
                Lazy lazy5;
                Context context3;
                Context context4;
                Lazy lazy6;
                Lazy lazy7;
                Context context5;
                Intrinsics.checkNotNullParameter(list, "");
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).dismissProgress();
                lazy2 = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy2.get()).KClassImpl$Data$declaredNonStaticMembers$2();
                lazy3 = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy3.get()).KClassImpl$Data$declaredNonStaticMembers$2(p0);
                GlobalSearchPresenter globalSearchPresenter = GlobalSearchPresenter.this;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    SearchResult PlaceComponentResult = SearchResultExtKt.PlaceComponentResult((SearchResultResponse) it.next());
                    String PlaceComponentResult2 = SearchResultExtKt.PlaceComponentResult(PlaceComponentResult);
                    switch (PlaceComponentResult2.hashCode()) {
                        case -1592831339:
                            if (!PlaceComponentResult2.equals("SERVICE")) {
                                break;
                            } else {
                                context = globalSearchPresenter.MyBillsEntityDataFactory;
                                GlobalSearchPresenter.KClassImpl$Data$declaredNonStaticMembers$2(globalSearchPresenter, SearchResultExtKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, context, true, 0, 12));
                                break;
                            }
                        case -667013580:
                            if (!PlaceComponentResult2.equals("ONLINE_MERCHANT")) {
                                break;
                            } else {
                                lazy4 = globalSearchPresenter.readMicros;
                                GlobalSearchContract.View view = (GlobalSearchContract.View) lazy4.get();
                                context2 = globalSearchPresenter.MyBillsEntityDataFactory;
                                view.PlaceComponentResult(SearchResultExtKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, context2, true, 0, 12));
                                break;
                            }
                        case 2178:
                            if (!PlaceComponentResult2.equals("DF")) {
                                break;
                            } else {
                                lazy5 = globalSearchPresenter.readMicros;
                                GlobalSearchContract.View view2 = (GlobalSearchContract.View) lazy5.get();
                                context3 = globalSearchPresenter.MyBillsEntityDataFactory;
                                view2.BuiltInFictitiousFunctionClassFactory(SearchResultExtKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, context3, true, 0, 12));
                                break;
                            }
                        case 1016896708:
                            if (!PlaceComponentResult2.equals("OFFLINE_MERCHANT")) {
                                break;
                            } else {
                                context4 = globalSearchPresenter.MyBillsEntityDataFactory;
                                SearchResultModel BuiltInFictitiousFunctionClassFactory = SearchResultExtKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, context4, true, 0, 12);
                                lazy6 = globalSearchPresenter.readMicros;
                                Object obj = lazy6.get();
                                Intrinsics.checkNotNullExpressionValue(obj, "");
                                GlobalSearchPresenter.getAuthRequestContext(globalSearchPresenter, BuiltInFictitiousFunctionClassFactory, new GlobalSearchPresenter$fetchSearch$1$1$1(obj));
                                break;
                            }
                        case 2014341056:
                            if (!PlaceComponentResult2.equals("DF_SKU")) {
                                break;
                            } else {
                                lazy7 = globalSearchPresenter.readMicros;
                                GlobalSearchContract.View view3 = (GlobalSearchContract.View) lazy7.get();
                                context5 = globalSearchPresenter.MyBillsEntityDataFactory;
                                view3.MyBillsEntityDataFactory(SearchResultExtKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, context5, false, 7, 8));
                                break;
                            }
                    }
                }
                GlobalSearchPresenter.getAuthRequestContext(GlobalSearchPresenter.this, list);
                GlobalSearchPresenter.this.FragmentBottomSheetPaymentSettingBinding = false;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchSearch$2
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
                Intrinsics.checkNotNullParameter(th, "");
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).dismissProgress();
                lazy2 = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy2.get()).KClassImpl$Data$declaredNonStaticMembers$2();
                lazy3 = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy3.get()).onError(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
                GlobalSearchPresenter.this.FragmentBottomSheetPaymentSettingBinding = false;
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        SaveRecentSearch saveRecentSearch = this.getCallingPid.get();
        SaveRecentSearch.Params.Companion companion2 = SaveRecentSearch.Params.INSTANCE;
        saveRecentSearch.execute(SaveRecentSearch.Params.Companion.getAuthRequestContext(p0, currentTimeMillis), new Function1<Unit, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$saveRecentSearch$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$saveRecentSearch$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
            }
        });
    }

    public final SearchResultModel getAuthRequestContext(SearchResultModel p0) {
        Object obj;
        for (ThirdPartyServiceResponse thirdPartyServiceResponse : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Iterator<T> it = p0.getAuthRequestContext.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(thirdPartyServiceResponse.getKey(), ((PaySearchInfoModel) obj).getErrorConfigVersion.get(DanaH5.SERVICE_KEY))) {
                    break;
                }
            }
            PaySearchInfoModel paySearchInfoModel = (PaySearchInfoModel) obj;
            if (paySearchInfoModel != null) {
                paySearchInfoModel.lookAheadTest = thirdPartyServiceResponse.isEnable();
            }
        }
        return p0;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchPopularSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(list, "");
                if (GlobalSearchPresenter.this.getFragmentBottomSheetPaymentSettingBinding()) {
                    lazy2 = GlobalSearchPresenter.this.readMicros;
                    ((GlobalSearchContract.View) lazy2.get()).MyBillsEntityDataFactory(CollectionsKt.emptyList());
                    return;
                }
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).MyBillsEntityDataFactory(CollectionsKt.take(list, 10));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchPopularSearch$2
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
                Intrinsics.checkNotNullParameter(th, "");
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).MyBillsEntityDataFactory(CollectionsKt.emptyList());
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().execute(NoParams.INSTANCE, new Function1<HashMap<String, Long>, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchRecentSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Long> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, Long> hashMap) {
                Lazy lazy;
                List<String> list;
                Intrinsics.checkNotNullParameter(hashMap, "");
                GlobalSearchPresenter globalSearchPresenter = GlobalSearchPresenter.this;
                List sortedWith = CollectionsKt.sortedWith(MapsKt.toList(hashMap), new Comparator() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchRecentSearch$1$invoke$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((Long) ((Pair) t2).getSecond(), (Long) ((Pair) t).getSecond());
                    }
                });
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
                Iterator it = sortedWith.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                globalSearchPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3 = arrayList;
                lazy = GlobalSearchPresenter.this.readMicros;
                GlobalSearchContract.View view = (GlobalSearchContract.View) lazy.get();
                list = GlobalSearchPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                view.getAuthRequestContext(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchRecentSearch$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GetAutoCompleteByKeyword getAutoCompleteByKeyword = this.scheduleImpl.get();
        GetAutoCompleteByKeyword.Params.Companion companion = GetAutoCompleteByKeyword.Params.INSTANCE;
        getAutoCompleteByKeyword.execute(GetAutoCompleteByKeyword.Params.Companion.KClassImpl$Data$declaredNonStaticMembers$2(p0), new Function1<AutoCompleteResult, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchAutoComplete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AutoCompleteResult autoCompleteResult) {
                invoke2(autoCompleteResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AutoCompleteResult autoCompleteResult) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(autoCompleteResult, "");
                if (!autoCompleteResult.getSuccess() || (!autoCompleteResult.getSearchResultList().isEmpty()) == false) {
                    lazy = GlobalSearchPresenter.this.readMicros;
                    ((GlobalSearchContract.View) lazy.get()).scheduleImpl();
                } else {
                    GlobalSearchPresenter.MyBillsEntityDataFactory(GlobalSearchPresenter.this, p0, autoCompleteResult.getSearchResultList());
                }
                DanaLog.getAuthRequestContext(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, autoCompleteResult.toString());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchAutoComplete$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x002f, code lost:
    
        if (r0 == null) goto L39;
     */
    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(java.lang.String r9, final java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            id.dana.globalsearch.model.SearchPerCategoryRequestModel r1 = r8.whenAvailable
            r2 = 0
            if (r1 == 0) goto L10
            int r1 = r1.PlaceComponentResult
            goto L11
        L10:
            r1 = 0
        L11:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            id.dana.globalsearch.model.SearchPerCategoryRequestModel r0 = r8.whenAvailable
            if (r0 == 0) goto L31
            java.lang.String r3 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r9)
            if (r3 == 0) goto L2c
            java.lang.String r3 = r0.BuiltInFictitiousFunctionClassFactory
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r10)
            if (r3 == 0) goto L2c
            r2 = 1
        L2c:
            if (r2 != 0) goto L2f
            r0 = 0
        L2f:
            if (r0 != 0) goto L38
        L31:
            id.dana.globalsearch.model.SearchPerCategoryRequestModel r0 = new id.dana.globalsearch.model.SearchPerCategoryRequestModel
            r0.<init>(r9, r10)
            r8.whenAvailable = r0
        L38:
            int r9 = r0.MyBillsEntityDataFactory
            int r2 = r9 + 1
            r0.MyBillsEntityDataFactory = r2
            if (r1 == 0) goto L43
            if (r1 >= r9) goto L43
            return
        L43:
            dagger.Lazy<id.dana.contract.globalsearch.GlobalSearchContract$View> r1 = r8.readMicros
            java.lang.Object r1 = r1.get()
            id.dana.contract.globalsearch.GlobalSearchContract$View r1 = (id.dana.contract.globalsearch.GlobalSearchContract.View) r1
            r1.showProgress()
            java.lang.String r3 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r1 = r0.BuiltInFictitiousFunctionClassFactory
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r1)
            id.dana.contract.globalsearch.GlobalSearchPresenter$SearchQuery r1 = new id.dana.contract.globalsearch.GlobalSearchPresenter$SearchQuery
            r5 = 10
            r7 = 1
            r2 = r1
            r4 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r8.getAuthRequestContext = r1
            dagger.Lazy<id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword> r1 = r8.isLayoutRequested
            java.lang.Object r1 = r1.get()
            id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword r1 = (id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword) r1
            id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword$Params$Companion r2 = id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword.Params.INSTANCE
            java.lang.String r2 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = r0.BuiltInFictitiousFunctionClassFactory
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r0)
            r4 = 10
            r6 = 0
            r7 = 0
            r3 = r9
            id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword$Params r9 = id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword.Params.Companion.BuiltInFictitiousFunctionClassFactory(r2, r3, r4, r5, r6, r7)
            id.dana.contract.globalsearch.GlobalSearchPresenter$fetchSearchByCategory$1 r0 = new id.dana.contract.globalsearch.GlobalSearchPresenter$fetchSearchByCategory$1
            r0.<init>()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            id.dana.contract.globalsearch.GlobalSearchPresenter$fetchSearchByCategory$2 r10 = new id.dana.contract.globalsearch.GlobalSearchPresenter$fetchSearchByCategory$2
            r10.<init>()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r1.execute(r9, r0, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.globalsearch.GlobalSearchPresenter.getAuthRequestContext(java.lang.String, java.lang.String):void");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SaveRecentSearch saveRecentSearch = this.getCallingPid.get();
        SaveRecentSearch.Params.Companion companion = SaveRecentSearch.Params.INSTANCE;
        saveRecentSearch.execute(SaveRecentSearch.Params.Companion.getAuthRequestContext(p0, -1L), new Function1<Unit, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$removeRecentItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
                GlobalSearchPresenter.this.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$removeRecentItem$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        SearchQuery searchQuery = this.getAuthRequestContext;
        if (searchQuery != null) {
            if (searchQuery.getPlaceComponentResult()) {
                getAuthRequestContext(searchQuery.KClassImpl$Data$declaredNonStaticMembers$2, (String) CollectionsKt.first((List) searchQuery.MyBillsEntityDataFactory));
            } else {
                GlobalSearchContract.Presenter.CC.getAuthRequestContext(this, searchQuery.KClassImpl$Data$declaredNonStaticMembers$2, searchQuery.getAuthRequestContext, searchQuery.BuiltInFictitiousFunctionClassFactory, searchQuery.MyBillsEntityDataFactory, null, 16);
            }
        }
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void getAuthRequestContext(PaySearchInfoModel p0) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ThirdPartyServiceResponse) obj).getKey(), p0.getErrorConfigVersion.get(DanaH5.SERVICE_KEY))) {
                break;
            }
        }
        final ThirdPartyServiceResponse thirdPartyServiceResponse = (ThirdPartyServiceResponse) obj;
        if (thirdPartyServiceResponse != null) {
            if (!thirdPartyServiceResponse.isEnable()) {
                this.readMicros.get().getAuthRequestContext();
                return;
            }
            String appId = thirdPartyServiceResponse.getAppId();
            if (!(appId == null || appId.length() == 0)) {
                String appId2 = thirdPartyServiceResponse.getAppId();
                Intrinsics.checkNotNull(appId2);
                DanaH5.openApp$default(appId2, null, thirdPartyServiceResponse.getScreenOrientation(), 2, null);
            } else if (Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "POST")) {
                final String redirectUrl = thirdPartyServiceResponse.getRedirectUrl();
                if (redirectUrl == null) {
                    redirectUrl = "";
                }
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                Intrinsics.checkNotNullParameter(redirectUrl, "");
                if (thirdPartyServiceResponse.getNeedConsult()) {
                    this.readMicros.get().PlaceComponentResult(thirdPartyServiceResponse, redirectUrl, null);
                    return;
                }
                this.readMicros.get().showProgress();
                GetAuthCode getAuthCode = this.getErrorConfigVersion.get();
                GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
                String redirectUrl2 = thirdPartyServiceResponse.getRedirectUrl();
                if (redirectUrl2 == null) {
                    redirectUrl2 = "";
                }
                String clientId = thirdPartyServiceResponse.getClientId();
                if (clientId == null) {
                    clientId = "";
                }
                String scopes = thirdPartyServiceResponse.getScopes();
                getAuthCode.execute(companion.forGetAuthCode(redirectUrl2, clientId, scopes != null ? scopes : "", true), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$postAuthCode$1
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
                        Lazy lazy;
                        Lazy lazy2;
                        Lazy lazy3;
                        Intrinsics.checkNotNullParameter(authCodeResult, "");
                        lazy = GlobalSearchPresenter.this.readMicros;
                        ((GlobalSearchContract.View) lazy.get()).dismissProgress();
                        String authCode = authCodeResult.getAuthCode();
                        Intrinsics.checkNotNullExpressionValue(authCode, "");
                        if (authCode.length() > 0) {
                            lazy3 = GlobalSearchPresenter.this.readMicros;
                            ((GlobalSearchContract.View) lazy3.get()).PlaceComponentResult(thirdPartyServiceResponse, redirectUrl, authCodeResult.getAuthCode());
                            return;
                        }
                        lazy2 = GlobalSearchPresenter.this.readMicros;
                        ((GlobalSearchContract.View) lazy2.get()).onError("004");
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$postAuthCode$2
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
                        Intrinsics.checkNotNullParameter(th, "");
                        lazy = GlobalSearchPresenter.this.readMicros;
                        ((GlobalSearchContract.View) lazy.get()).dismissProgress();
                        if (!(th instanceof GetAuthCode.MissingRequiredUserInfoException)) {
                            lazy2 = GlobalSearchPresenter.this.readMicros;
                            ((GlobalSearchContract.View) lazy2.get()).onError("004");
                            return;
                        }
                        GetAuthCode.MissingRequiredUserInfoException missingRequiredUserInfoException = (GetAuthCode.MissingRequiredUserInfoException) th;
                        String key = thirdPartyServiceResponse.getKey();
                        String name = thirdPartyServiceResponse.getName();
                        String str = name == null ? "" : name;
                        String icon = thirdPartyServiceResponse.getIcon();
                        String scopes2 = thirdPartyServiceResponse.getScopes();
                        ExtensionsKt.BuiltInFictitiousFunctionClassFactory(missingRequiredUserInfoException, key, str, icon, scopes2 == null ? "" : scopes2, "", "", false);
                    }
                });
            } else if (Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "GET")) {
                GlobalSearchContract.View view = this.readMicros.get();
                String link = thirdPartyServiceResponse.getLink();
                view.getAuthRequestContext(thirdPartyServiceResponse, link != null ? link : "");
            }
        }
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void PlaceComponentResult(Function1<? super Boolean, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Permission.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, "android.permission.ACCESS_FINE_LOCATION")) {
            p0.invoke(Boolean.FALSE);
            return;
        }
        CheckShouldSuggestLocationPermissionDialog checkShouldSuggestLocationPermissionDialog = this.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(checkShouldSuggestLocationPermissionDialog, "");
        BaseUseCase.execute$default(checkShouldSuggestLocationPermissionDialog, NoParams.INSTANCE, p0, null, 4, null);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.initRecordTimeStamp.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchPopularSearchPlaceholder$1
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(str, "");
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$fetchPopularSearchPlaceholder$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1<GlobalSearchConfig, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getGlobalSearchConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GlobalSearchConfig globalSearchConfig) {
                invoke2(globalSearchConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GlobalSearchConfig globalSearchConfig) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(globalSearchConfig, "");
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).MyBillsEntityDataFactory(globalSearchConfig);
                if (globalSearchConfig.getExploreSkuWidget()) {
                    r2.PrepareContext.get().execute(NoParams.INSTANCE, new Function1<List<? extends ThirdPartyServiceResponse>, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getDefaultSkuExploreConfig$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyServiceResponse> list) {
                            invoke2((List<ThirdPartyServiceResponse>) list);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(List<ThirdPartyServiceResponse> list) {
                            Lazy lazy2;
                            Intrinsics.checkNotNullParameter(list, "");
                            lazy2 = GlobalSearchPresenter.this.readMicros;
                            ((GlobalSearchContract.View) lazy2.get()).KClassImpl$Data$declaredNonStaticMembers$2(list);
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getDefaultSkuExploreConfig$2
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "");
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_SKU_EXPLORE, th.toString());
                        }
                    });
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getGlobalSearchConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_GLOBAL_SEARCH_CONFIG_TAG, th.toString());
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void lookAheadTest() {
        this.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getHomeSearchBarVisibility$1
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
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).getAuthRequestContext(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getHomeSearchBarVisibility$2
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
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_HOME_SEARCH_BAR, th.toString());
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).getAuthRequestContext(false);
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final HashMap<String, List<String>> PlaceComponentResult(List<ThirdPartyServiceResponse> p0) {
        SkuAttribute skuAttr;
        List<String> postpaidKey;
        Intrinsics.checkNotNullParameter(p0, "");
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (ThirdPartyServiceResponse thirdPartyServiceResponse : p0) {
            SkuAttribute skuAttr2 = thirdPartyServiceResponse.getSkuAttr();
            List<String> postpaidKey2 = skuAttr2 != null ? skuAttr2.getPostpaidKey() : null;
            if (!(postpaidKey2 == null || postpaidKey2.isEmpty()) && (skuAttr = thirdPartyServiceResponse.getSkuAttr()) != null && (postpaidKey = skuAttr.getPostpaidKey()) != null) {
                hashMap.put(thirdPartyServiceResponse.getKey(), postpaidKey);
            }
        }
        return hashMap;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(new DefaultObserver<String>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$openPrepaidPage$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                super.onNext(str);
                if (str.length() > 0) {
                    lazy = GlobalSearchPresenter.this.readMicros;
                    ((GlobalSearchContract.View) lazy.get()).PlaceComponentResult(str);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_PREPAID_URL, p02.toString());
            }
        }, p0);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void moveToNextValue() {
        this.GetContactSyncConfig.get().execute(new GetOnlineMerchant.Params(null, 1, 8, GetOnlineMerchant.OnlineMerchantType.TRENDING, 1, null), new Function1<SearchResultResponse, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getTrendingOnlineMerchant$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SearchResultResponse searchResultResponse) {
                invoke2(searchResultResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SearchResultResponse searchResultResponse) {
                Lazy lazy;
                Context context;
                Intrinsics.checkNotNullParameter(searchResultResponse, "");
                lazy = GlobalSearchPresenter.this.readMicros;
                GlobalSearchContract.View view = (GlobalSearchContract.View) lazy.get();
                SearchResult PlaceComponentResult = SearchResultExtKt.PlaceComponentResult(searchResultResponse);
                context = GlobalSearchPresenter.this.MyBillsEntityDataFactory;
                view.scheduleImpl(SearchResultExtKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, context, false, 8, 8));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getTrendingOnlineMerchant$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_ONLINE_MERCHANT, th.toString());
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<ShouldOpenUserPersonalizationModelWrapper, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$checkShouldShowUserPersonalization$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ShouldOpenUserPersonalizationModelWrapper shouldOpenUserPersonalizationModelWrapper) {
                invoke2(shouldOpenUserPersonalizationModelWrapper);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ShouldOpenUserPersonalizationModelWrapper shouldOpenUserPersonalizationModelWrapper) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(shouldOpenUserPersonalizationModelWrapper, "");
                if (shouldOpenUserPersonalizationModelWrapper.getIsFirstTime() && !shouldOpenUserPersonalizationModelWrapper.getHasFillForm()) {
                    lazy3 = GlobalSearchPresenter.this.readMicros;
                    ((GlobalSearchContract.View) lazy3.get()).moveToNextValue();
                } else if (!shouldOpenUserPersonalizationModelWrapper.getIsFirstTime() && !shouldOpenUserPersonalizationModelWrapper.getHasFillForm()) {
                    lazy2 = GlobalSearchPresenter.this.readMicros;
                    ((GlobalSearchContract.View) lazy2.get()).lookAheadTest();
                } else if (shouldOpenUserPersonalizationModelWrapper.getIsFirstTime() || !shouldOpenUserPersonalizationModelWrapper.getHasFillForm()) {
                } else {
                    lazy = GlobalSearchPresenter.this.readMicros;
                    ((GlobalSearchContract.View) lazy.get()).MyBillsEntityDataFactory();
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$checkShouldShowUserPersonalization$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_SUBMITTED_USER_PREFERENCE, th.toString());
            }
        });
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\r8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchPresenter$SearchQuery;", "", "", "", "PlaceComponentResult", "Ljava/util/List;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "I", "getAuthRequestContext", "", "Z", "()Z", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;IILjava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class SearchQuery {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private boolean PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        List<String> MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final int BuiltInFictitiousFunctionClassFactory;

        public SearchQuery(String str, int i, int i2, List<String> list, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.MyBillsEntityDataFactory = list;
            this.PlaceComponentResult = z;
        }

        public /* synthetic */ SearchQuery(String str, int i, int i2, List list, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, list, (i3 & 16) != 0 ? false : z);
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchPresenter globalSearchPresenter, SearchResultModel searchResultModel) {
        List<PaySearchInfoModel> list = searchResultModel.getAuthRequestContext;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            PaySearchInfoModel paySearchInfoModel = (PaySearchInfoModel) obj;
            List<ThirdPartyServiceResponse> list2 = globalSearchPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            boolean z = false;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (Intrinsics.areEqual(((ThirdPartyServiceResponse) it.next()).getKey(), paySearchInfoModel.getErrorConfigVersion.get(DanaH5.SERVICE_KEY))) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(arrayList2, "");
        searchResultModel.getAuthRequestContext = arrayList2;
        globalSearchPresenter.readMicros.get().lookAheadTest(globalSearchPresenter.getAuthRequestContext(searchResultModel));
    }

    public static final /* synthetic */ void getAuthRequestContext(GlobalSearchPresenter globalSearchPresenter, List list) {
        List list2 = list;
        boolean z = false;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                List<PaySearchInfo> searchResultList = ((SearchResultResponse) it.next()).getSearchResultList();
                if (!(searchResultList == null || searchResultList.isEmpty())) {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            globalSearchPresenter.readMicros.get().onError("003");
        } else {
            globalSearchPresenter.readMicros.get().BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(GlobalSearchPresenter globalSearchPresenter, String str, List list) {
        ArrayList arrayList = new ArrayList();
        ConvertDataToRecentAutoCompleteKt.getAuthRequestContext(globalSearchPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3, str, arrayList);
        ConvertDataToRecentAutoCompleteKt.KClassImpl$Data$declaredNonStaticMembers$2(list, arrayList);
        if (globalSearchPresenter.FragmentBottomSheetPaymentSettingBinding) {
            return;
        }
        globalSearchPresenter.readMicros.get().PlaceComponentResult(CollectionsKt.take(CollectionsKt.toList(arrayList), 5));
    }

    public static final /* synthetic */ void getAuthRequestContext(final GlobalSearchPresenter globalSearchPresenter, final SearchResultModel searchResultModel, final Function1 function1) {
        if ((!globalSearchPresenter.NetworkUserEntityData$$ExternalSyntheticLambda6.isEmpty()) != false) {
            globalSearchPresenter.BuiltInFictitiousFunctionClassFactory(searchResultModel, function1);
            return;
        }
        globalSearchPresenter.readMicros.get().showProgress();
        globalSearchPresenter.DatabaseTableConfigUtil.get().execute(NoParams.INSTANCE, new Function1<List<? extends MerchantSubcategory>, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getMerchantSubcategories$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends MerchantSubcategory> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MerchantSubcategory> list) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(list, "");
                List<? extends MerchantSubcategory> list2 = list;
                if ((!list2.isEmpty()) != false) {
                    GlobalSearchPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6.addAll(list2);
                    GlobalSearchPresenter.this.BuiltInFictitiousFunctionClassFactory(searchResultModel, function1);
                }
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).dismissProgress();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchPresenter$getMerchantSubcategories$2
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
                Intrinsics.checkNotNullParameter(th, "");
                lazy = GlobalSearchPresenter.this.readMicros;
                ((GlobalSearchContract.View) lazy.get()).dismissProgress();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, th.toString());
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory(SearchResultModel p0, Function1<? super SearchResultModel, Unit> p1) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        for (PaySearchInfoModel paySearchInfoModel : p0.getAuthRequestContext) {
            String str2 = (String) CollectionsKt.firstOrNull((List) paySearchInfoModel.DatabaseTableConfigUtil);
            String str3 = str2;
            if (!(str3 == null || str3.length() == 0)) {
                Iterator<T> it = this.NetworkUserEntityData$$ExternalSyntheticLambda6.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((MerchantSubcategory) obj).getMcc(), str2)) {
                        break;
                    }
                }
                MerchantSubcategory merchantSubcategory = (MerchantSubcategory) obj;
                str = merchantSubcategory != null ? merchantSubcategory.getName() : null;
                if (str != null) {
                    Intrinsics.checkNotNullParameter(str, "");
                    paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
                }
            }
            str = ConnectionType.OTHERS;
            Intrinsics.checkNotNullParameter(str, "");
            paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        }
        p1.invoke(p0);
    }
}
