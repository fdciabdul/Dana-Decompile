package id.dana.oauth.mapper;

import id.dana.domain.oauth.model.GnBindingBenefit;
import id.dana.oauth.model.BindingBenefitModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/oauth/mapper/BindingBenefitModelMapper;", "", "Lid/dana/domain/oauth/model/GnBindingBenefit;", "p0", "Lid/dana/oauth/model/BindingBenefitModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/oauth/model/GnBindingBenefit;)Lid/dana/oauth/model/BindingBenefitModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BindingBenefitModelMapper {
    public static BindingBenefitModel KClassImpl$Data$declaredNonStaticMembers$2(GnBindingBenefit p0) {
        return new BindingBenefitModel(p0.getIcon(), p0.getName(), p0.getNameInBahasa());
    }
}
