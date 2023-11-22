package id.dana;

import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.PerActivity;
import id.dana.utils.TagFormat;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/H5Launcher;", "", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "PlaceComponentResult", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class H5Launcher {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final DynamicUrlWrapper KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public H5Launcher(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dynamicUrlWrapper;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        TagFormat MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory(str);
        for (Map.Entry entry : map.entrySet()) {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory((String) entry.getKey(), (String) entry.getValue());
        }
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory2 != null) {
            str = MyBillsEntityDataFactory2;
        }
        DanaH5.startContainerFullUrl(str, null);
    }
}
