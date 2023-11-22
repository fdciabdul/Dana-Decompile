package id.dana.richview.servicescard.mapper;

import android.content.Context;
import id.dana.R;
import id.dana.domain.services.model.CategoryServicesModel;
import id.dana.richview.category.model.CategoryModel;
import id.dana.utils.ResourceUtils;
import id.dana.utils.StringWrapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/richview/servicescard/mapper/ServiceCategoryMapper;", "", "Lid/dana/domain/services/model/CategoryServicesModel;", "p0", "Lid/dana/utils/StringWrapper;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/services/model/CategoryServicesModel;)Lid/dana/utils/StringWrapper;", "Lid/dana/richview/category/model/CategoryModel;", "MyBillsEntityDataFactory", "()Lid/dana/richview/category/model/CategoryModel;", "", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceCategoryMapper {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    @Inject
    public ServiceCategoryMapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    public final List<CategoryModel> PlaceComponentResult(List<CategoryServicesModel> p0) {
        ArrayList arrayList = new ArrayList();
        if (p0 != null) {
            arrayList.add(MyBillsEntityDataFactory());
            for (CategoryServicesModel categoryServicesModel : p0) {
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.MyBillsEntityDataFactory = categoryServicesModel.getCategory();
                categoryModel.moveToNextValue = BuiltInFictitiousFunctionClassFactory(categoryServicesModel);
                categoryModel.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(categoryServicesModel);
                categoryModel.scheduleImpl = 1;
                arrayList.add(categoryModel);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    private StringWrapper BuiltInFictitiousFunctionClassFactory(CategoryServicesModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.getEn().length() == 0) {
            if (p0.getId().length() == 0) {
                ResourceUtils resourceUtils = ResourceUtils.INSTANCE;
                ?? r2 = 0;
                return new StringWrapper.ResValue(ResourceUtils.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, p0.getCategory()), r2, 2, r2);
            }
        }
        return new StringWrapper.StringLocaleValue(p0.getEn(), p0.getId());
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    private static CategoryModel MyBillsEntityDataFactory() {
        CategoryModel categoryModel = new CategoryModel();
        int i = 2;
        int i2 = R.string.category_all;
        ?? r4 = 0;
        categoryModel.moveToNextValue = new StringWrapper.ResValue(i2, r4, i, r4);
        categoryModel.BuiltInFictitiousFunctionClassFactory = new StringWrapper.ResValue(i2, r4, i, r4);
        categoryModel.scheduleImpl = 1;
        categoryModel.PlaceComponentResult = true;
        return categoryModel;
    }
}
