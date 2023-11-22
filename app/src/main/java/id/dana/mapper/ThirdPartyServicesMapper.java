package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.homeinfo.BannerLottie;
import id.dana.domain.homeinfo.SkuAttribute;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.Category;
import id.dana.domain.services.model.CategoryServicesModel;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.model.BannerLottieModelKt;
import id.dana.model.SkuAttributeModelKt;
import id.dana.model.ThirdPartyService;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.utils.ResourceUtils;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002 \u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0015J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\u0016J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0016J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0019\u001a\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001bR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001cR\u0014\u0010\u0013\u001a\u00020\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0014\u0010\t\u001a\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u001b"}, d2 = {"Lid/dana/mapper/ThirdPartyServicesMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "Lid/dana/model/ThirdPartyService;", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "p0", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/services/model/ThirdPartyCategoryService;Z)Lid/dana/model/ThirdPartyService;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/Collection;", "MyBillsEntityDataFactory", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)Lid/dana/model/ThirdPartyService;", "p2", "PlaceComponentResult", "(Ljava/util/List;ZZ)Ljava/util/List;", "(Ljava/lang/String;)Ljava/util/List;", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "Lid/dana/model/ThirdPartyService$SpmId;", "getAuthRequestContext", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;)Lid/dana/model/ThirdPartyService$SpmId;", "()Lid/dana/model/ThirdPartyService;", "Z", "Lid/dana/richview/servicescard/mapper/ServiceCategoryMapper;", "Lid/dana/richview/servicescard/mapper/ServiceCategoryMapper;", "<init>", "(Lid/dana/richview/servicescard/mapper/ServiceCategoryMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThirdPartyServicesMapper extends BaseMapper<List<? extends ThirdPartyServiceResponse>, List<? extends ThirdPartyService>> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ServiceCategoryMapper PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends ThirdPartyService> map(List<? extends ThirdPartyServiceResponse> list) {
        List<? extends ThirdPartyServiceResponse> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            ThirdPartyService MyBillsEntityDataFactory = MyBillsEntityDataFactory((ThirdPartyServiceResponse) it.next());
            if (MyBillsEntityDataFactory != null) {
                arrayList.add(MyBillsEntityDataFactory);
            }
        }
        return arrayList;
    }

    @Inject
    public ThirdPartyServicesMapper(ServiceCategoryMapper serviceCategoryMapper) {
        Intrinsics.checkNotNullParameter(serviceCategoryMapper, "");
        this.PlaceComponentResult = serviceCategoryMapper;
    }

    private static Collection<ThirdPartyService> BuiltInFictitiousFunctionClassFactory(List<ThirdPartyServiceResponse> p0, String p1) {
        if (p0 == null) {
            p0 = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = p0.iterator();
        while (it.hasNext()) {
            ThirdPartyService MyBillsEntityDataFactory = MyBillsEntityDataFactory((ThirdPartyServiceResponse) it.next());
            if (MyBillsEntityDataFactory != null) {
                MyBillsEntityDataFactory.newProxyInstance = p1;
            } else {
                MyBillsEntityDataFactory = null;
            }
            if (MyBillsEntityDataFactory != null) {
                arrayList.add(MyBillsEntityDataFactory);
            }
        }
        return arrayList;
    }

    public static List<ThirdPartyService> KClassImpl$Data$declaredNonStaticMembers$2(List<ThirdPartyServiceResponse> p0) {
        ArrayList arrayList;
        if (p0 != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = p0.iterator();
            while (it.hasNext()) {
                ThirdPartyService MyBillsEntityDataFactory = MyBillsEntityDataFactory((ThirdPartyServiceResponse) it.next());
                if (MyBillsEntityDataFactory != null) {
                    arrayList2.add(MyBillsEntityDataFactory);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public static ThirdPartyService MyBillsEntityDataFactory(ThirdPartyServiceResponse p0) {
        if (p0 != null) {
            ThirdPartyService.Builder builder = new ThirdPartyService.Builder();
            builder.getAuthRequestContext = p0.getAction();
            builder.getErrorConfigVersion = p0.getClientId();
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getAppId();
            builder.moveToNextValue = p0.isEnable();
            builder.initRecordTimeStamp = p0.getIcon();
            String key = p0.getKey();
            Intrinsics.checkNotNullParameter(key, "");
            builder.isLayoutRequested = key;
            builder.PrepareContext = p0.getLink();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = p0.getName();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = p0.getNameInd();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = p0.getNameTag();
            builder.readMicros = p0.getOperationType();
            builder.getCallingPid = p0.getRedirectUrl();
            builder.SubSequence = p0.getScopes();
            builder.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = 0;
            builder.getValueOfTouchPositionAbsolute = p0.getUserAction();
            builder.scheduleImpl = p0.getDescription();
            builder.E = p0.getSubtitleColor();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0.getButtonTitle();
            builder.A = p0.getSubtitleBorderColor();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = PlaceComponentResult(p0.getKeyword());
            builder.getSupportButtonTintMode = p0.getRibbonText();
            builder.GetContactSyncConfig = p0.isHasRedDot();
            builder.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = getAuthRequestContext(p0.getSpmId());
            builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = p0.getNeedConsult();
            builder.VerifyPinStateManager$executeRiskChallenge$2$1 = p0.getSpaceCodes();
            SkuAttribute skuAttr = p0.getSkuAttr();
            builder.BottomSheetCardBindingView$watcherCardNumberView$1 = skuAttr != null ? SkuAttributeModelKt.KClassImpl$Data$declaredNonStaticMembers$2(skuAttr) : null;
            builder.C = p0.getScreenOrientation();
            builder.FragmentBottomSheetPaymentSettingBinding = p0.getNeedOauth();
            builder.PlaceComponentResult = p0.getBizType();
            builder.newProxyInstance = p0.getIndexOfHighlighted();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda7 = p0.isBiller();
            Integer rotationDelayTime = p0.getRotationDelayTime();
            builder.whenAvailable = rotationDelayTime != null ? rotationDelayTime.intValue() : 0;
            builder.lookAheadTest = p0.getDirectOpen();
            BannerLottie bannerLottie = p0.getBannerLottie();
            builder.BuiltInFictitiousFunctionClassFactory = bannerLottie != null ? BannerLottieModelKt.KClassImpl$Data$declaredNonStaticMembers$2(bannerLottie) : null;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0.getIconLottie();
            builder.DatabaseTableConfigUtil = p0.getHeaderBackgroundColor();
            Boolean alwaysConsult = p0.getAlwaysConsult();
            builder.MyBillsEntityDataFactory = alwaysConsult != null ? alwaysConsult.booleanValue() : false;
            return builder.PlaceComponentResult();
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private static ThirdPartyService.SpmId getAuthRequestContext(ThirdPartyServiceResponse.SpmId p0) {
        ?? r0 = 0;
        if (p0 != null) {
            ThirdPartyService.SpmId spmId = new ThirdPartyService.SpmId(r0, r0, 3, r0);
            spmId.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getHome();
            spmId.getAuthRequestContext = p0.getAll();
            return spmId;
        }
        return null;
    }

    private static List<String> PlaceComponentResult(String p0) {
        if (p0 == null) {
            p0 = "";
        }
        List split$default = StringsKt.split$default((CharSequence) p0, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!(((String) obj).length() == 0)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<ThirdPartyService> PlaceComponentResult(List<? extends ThirdPartyCategoryService> p0, boolean p1, boolean p2) {
        ArrayList arrayList = new ArrayList();
        if (p0 == null) {
            p0 = CollectionsKt.emptyList();
        }
        List<ThirdPartyCategoryService> filterNotNull = CollectionsKt.filterNotNull(p0);
        for (ThirdPartyCategoryService thirdPartyCategoryService : filterNotNull) {
            String key = thirdPartyCategoryService.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "");
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(key);
            if (!p2) {
                arrayList.add(BuiltInFictitiousFunctionClassFactory(thirdPartyCategoryService, KClassImpl$Data$declaredNonStaticMembers$2));
            }
            arrayList.addAll(BuiltInFictitiousFunctionClassFactory(thirdPartyCategoryService.getThirdPartyServices(), thirdPartyCategoryService.getKey()));
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (arrayList.size() > 1) {
                        arrayList.remove(1);
                    }
                    if (p1) {
                        arrayList.add(MyBillsEntityDataFactory());
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ThirdPartyService) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
                }
            }
        }
        if (filterNotNull.size() > 1) {
            arrayList.add(PlaceComponentResult());
        }
        return arrayList;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return StringsKt.equals(Category.FEATURED, p0, true);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static ThirdPartyService MyBillsEntityDataFactory() {
        ThirdPartyService.Builder builder = new ThirdPartyService.Builder();
        builder.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = 5;
        Intrinsics.checkNotNullParameter(SemanticAttributes.FaasDocumentOperationValues.EDIT, "");
        builder.isLayoutRequested = SemanticAttributes.FaasDocumentOperationValues.EDIT;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        return builder.PlaceComponentResult();
    }

    @JvmName(name = "PlaceComponentResult")
    private static ThirdPartyService PlaceComponentResult() {
        ThirdPartyService.Builder builder = new ThirdPartyService.Builder();
        builder.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = 4;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        return builder.PlaceComponentResult();
    }

    public final ThirdPartyService BuiltInFictitiousFunctionClassFactory(ThirdPartyCategoryService p0, boolean p1) {
        String capitalize;
        ThirdPartyService.Builder builder = new ThirdPartyService.Builder();
        CategoryServicesModel categoryServicesModel = p0.getCategoryServicesModel();
        if (categoryServicesModel == null || (capitalize = categoryServicesModel.getEn()) == null) {
            ServiceCategoryMapper serviceCategoryMapper = this.PlaceComponentResult;
            String key = p0.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "");
            Intrinsics.checkNotNullParameter(key, "");
            ResourceUtils resourceUtils = ResourceUtils.INSTANCE;
            int PlaceComponentResult = ResourceUtils.PlaceComponentResult(serviceCategoryMapper.BuiltInFictitiousFunctionClassFactory, key);
            if (PlaceComponentResult > 0) {
                capitalize = serviceCategoryMapper.BuiltInFictitiousFunctionClassFactory.getString(PlaceComponentResult);
                Intrinsics.checkNotNullExpressionValue(capitalize, "");
            } else {
                capitalize = StringsKt.capitalize(new Regex("_").replace(new Regex("category_").replaceFirst(key, ""), " "));
            }
        }
        builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = capitalize;
        CategoryServicesModel categoryServicesModel2 = p0.getCategoryServicesModel();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = categoryServicesModel2 != null ? categoryServicesModel2.getId() : null;
        builder.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = 3;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = p1;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        return builder.PlaceComponentResult();
    }

    public final List<ThirdPartyService> PlaceComponentResult(List<? extends ThirdPartyCategoryService> p0) {
        if (p0 == null) {
            p0 = CollectionsKt.emptyList();
        }
        List<? extends ThirdPartyCategoryService> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ThirdPartyCategoryService thirdPartyCategoryService : list) {
            String str = null;
            List<ThirdPartyServiceResponse> thirdPartyServices = thirdPartyCategoryService != null ? thirdPartyCategoryService.getThirdPartyServices() : null;
            if (thirdPartyCategoryService != null) {
                str = thirdPartyCategoryService.getKey();
            }
            arrayList.add(BuiltInFictitiousFunctionClassFactory(thirdPartyServices, str));
        }
        return CollectionsKt.flatten(arrayList);
    }
}
