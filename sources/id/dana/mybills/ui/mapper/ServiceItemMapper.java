package id.dana.mybills.ui.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.homeinfo.SkuAttribute;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.Category;
import id.dana.mybills.ui.model.service.CategoryServiceMapper;
import id.dana.mybills.ui.model.service.SkuAttributeModelKt;
import id.dana.mybills.ui.model.service.ThirdPartyService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\"\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\nJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\b\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/mybills/ui/mapper/ServiceItemMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "Lid/dana/mybills/ui/model/service/ThirdPartyService;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)Z", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)Lid/dana/mybills/ui/model/service/ThirdPartyService;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/util/List;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;)Lid/dana/mybills/ui/model/service/ThirdPartyService$SpmId;", "Z", "Lid/dana/mybills/ui/model/service/CategoryServiceMapper;", "getAuthRequestContext", "Lid/dana/mybills/ui/model/service/CategoryServiceMapper;", "<init>", "(Lid/dana/mybills/ui/model/service/CategoryServiceMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceItemMapper extends BaseMapper<List<? extends ThirdPartyServiceResponse>, List<? extends ThirdPartyService>> {
    public boolean PlaceComponentResult;
    public final CategoryServiceMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends ThirdPartyService> map(List<? extends ThirdPartyServiceResponse> list) {
        List<? extends ThirdPartyServiceResponse> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            ThirdPartyService PlaceComponentResult = PlaceComponentResult((ThirdPartyServiceResponse) it.next());
            if (PlaceComponentResult != null) {
                arrayList.add(PlaceComponentResult);
            }
        }
        return arrayList;
    }

    @Inject
    public ServiceItemMapper(CategoryServiceMapper categoryServiceMapper) {
        Intrinsics.checkNotNullParameter(categoryServiceMapper, "");
        this.getAuthRequestContext = categoryServiceMapper;
    }

    public static ThirdPartyService PlaceComponentResult(ThirdPartyServiceResponse p0) {
        if (p0 != null) {
            ThirdPartyService.Builder spaceCodes = new ThirdPartyService.Builder().action(p0.getAction()).clientId(p0.getClientId()).appId(p0.getAppId()).enable(p0.isEnable()).icon(p0.getIcon()).key(p0.getKey()).link(p0.getLink()).name(p0.getName()).nameInd(p0.getNameInd()).nameTag(p0.getNameTag()).operationType(p0.getOperationType()).redirectUrl(p0.getRedirectUrl()).scopes(p0.getScopes()).type(0).userAction(p0.getUserAction()).description(p0.getDescription()).buttonTitle(p0.getButtonTitle()).keywords(MyBillsEntityDataFactory(p0.getKeyword())).ribbonText(p0.getRibbonText()).hasRedDot(p0.isHasRedDot()).spmId(PlaceComponentResult(p0.getSpmId())).needConsult(p0.getNeedConsult()).spaceCodes(p0.getSpaceCodes());
            SkuAttribute skuAttr = p0.getSkuAttr();
            return spaceCodes.skuAttributeModel(skuAttr != null ? SkuAttributeModelKt.toSkuAttributeModel(skuAttr) : null).screenOrientation(p0.getScreenOrientation()).isBiller(p0.isBiller()).build();
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private static ThirdPartyService.SpmId PlaceComponentResult(ThirdPartyServiceResponse.SpmId p0) {
        ?? r0 = 0;
        if (p0 != null) {
            ThirdPartyService.SpmId spmId = new ThirdPartyService.SpmId(r0, r0, 3, r0);
            spmId.setHome(p0.getHome());
            spmId.setAll(p0.getAll());
            return spmId;
        }
        return null;
    }

    private static List<String> MyBillsEntityDataFactory(String p0) {
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

    public static boolean PlaceComponentResult(String p0) {
        return StringsKt.equals(Category.FEATURED, p0, true);
    }
}
