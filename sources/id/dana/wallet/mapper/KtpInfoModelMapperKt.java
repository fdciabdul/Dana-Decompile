package id.dana.wallet.mapper;

import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.wallet_v3.model.KtpInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/wallet_v3/model/KtpInfo;", "Lid/dana/wallet_v3/model/KtpInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/wallet_v3/model/KtpInfo;)Lid/dana/wallet_v3/model/KtpInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KtpInfoModelMapperKt {
    public static final KtpInfoModel BuiltInFictitiousFunctionClassFactory(KtpInfo ktpInfo) {
        Intrinsics.checkNotNullParameter(ktpInfo, "");
        return new KtpInfoModel(ktpInfo.getBackgroundUrl(), ktpInfo.getCreatedDate(), ktpInfo.getIconUrl(), ktpInfo.getLogoUrl(), ktpInfo.getPocketId(), ktpInfo.getPocketStatus(), ktpInfo.getPocketType(), ktpInfo.getCertNo(), ktpInfo.getCertName(), ktpInfo.getDateOfBirth(), ktpInfo.getPlaceOfBirth(), ktpInfo.getHomeAddress(), ktpInfo.getReligion(), ktpInfo.getGender(), ktpInfo.getRt(), ktpInfo.getRw(), ktpInfo.getMarriage(), ktpInfo.getNationality(), ktpInfo.getOccupation(), ktpInfo.getDistrict(), ktpInfo.getSubdistrict(), ktpInfo.getCardTitle());
    }
}
