package id.dana.kyb.helper.service.strategy;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.kyb.helper.service.listener.KybServiceListener;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.KybServiceRedirectValueModel;
import id.dana.utils.UrlUtil;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/kyb/helper/service/strategy/KybServiceUrlActionStrategy;", "Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategy;", "Landroid/content/Context;", "p0", "Lid/dana/kyb/model/KybServiceModel;", "p1", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "p2", "", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/kyb/model/KybServiceModel;Lid/dana/kyb/helper/service/listener/KybServiceListener;)V", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceUrlActionStrategy implements KybServiceActionStrategy {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private KybServiceListener MyBillsEntityDataFactory;

    @Inject
    public KybServiceUrlActionStrategy() {
    }

    @Override // id.dana.kyb.helper.service.strategy.KybServiceActionStrategy
    public final void PlaceComponentResult(Context p0, KybServiceModel p1, KybServiceListener p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.MyBillsEntityDataFactory = p2;
        KybServiceRedirectValueModel kybServiceRedirectValueModel = p1.MyBillsEntityDataFactory;
        if (kybServiceRedirectValueModel != null) {
            String str = kybServiceRedirectValueModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str == null) {
                str = "";
            }
            List<String> list = kybServiceRedirectValueModel.PlaceComponentResult;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            StringBuilder sb = new StringBuilder(str);
            int i = 0;
            for (Object obj : list) {
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) obj;
                sb.append(i == 0 ? "?" : ContainerUtils.FIELD_DELIMITER);
                sb.append(str2);
                i++;
            }
            String obj2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj2, "");
            KybServiceListener kybServiceListener = this.MyBillsEntityDataFactory;
            if (kybServiceListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                kybServiceListener = null;
            }
            String authRequestContext = UrlUtil.getAuthRequestContext(obj2);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            kybServiceListener.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        }
    }
}
