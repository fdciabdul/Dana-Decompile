package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.nearbyme.model.ShopOpenHourModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/mapper/ShopOpenHourMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/ShopOpenHour;", "Lid/dana/nearbyme/model/ShopOpenHourModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ShopOpenHourMapper extends BaseMapper<ShopOpenHour, ShopOpenHourModel> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ ShopOpenHourModel map(ShopOpenHour shopOpenHour) {
        ShopOpenHour shopOpenHour2 = shopOpenHour;
        Intrinsics.checkNotNullParameter(shopOpenHour2, "");
        return new ShopOpenHourModel(shopOpenHour2.getDay(), shopOpenHour2.getOpenHour(), shopOpenHour2.getCloseHour());
    }

    @Inject
    public ShopOpenHourMapper() {
    }
}
