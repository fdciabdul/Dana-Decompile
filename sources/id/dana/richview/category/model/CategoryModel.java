package id.dana.richview.category.model;

import id.dana.common.model.OptionModel;
import id.dana.utils.StringWrapper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0012\u0010\u0018\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/richview/category/model/CategoryModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/utils/StringWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/StringWrapper;", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/common/model/OptionModel;", "getAuthRequestContext", "Ljava/util/List;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "Z", "()Z", "moveToNextValue", "scheduleImpl", "getErrorConfigVersion", "I", "<init>", "()V", "ViewType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CategoryModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public StringWrapper BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;
    public boolean PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public int scheduleImpl;
    public StringWrapper moveToNextValue;
    public List<OptionModel> getAuthRequestContext = new ArrayList();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public List<OptionModel> getErrorConfigVersion = new ArrayList();

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final boolean equals(Object p0) {
        if (p0 instanceof CategoryModel) {
            if (p0 == this) {
                return true;
            }
            CategoryModel categoryModel = (CategoryModel) p0;
            String str = categoryModel.MyBillsEntityDataFactory;
            if (str == null) {
                int i = categoryModel.scheduleImpl;
                return i != 0 && i == this.scheduleImpl;
            }
            return Intrinsics.areEqual(str, this.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.MyBillsEntityDataFactory;
        return ((str != null ? str.hashCode() : 0) * 31) + this.scheduleImpl;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/richview/category/model/CategoryModel$ViewType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewType {
        public static final int CATEGORY_VIEW = 1;

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
        public static final int SHIMMER_VIEW = 2;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/richview/category/model/CategoryModel$ViewType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

            private Companion() {
            }
        }
    }
}
