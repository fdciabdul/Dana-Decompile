package id.dana.data.wallet.mapper;

import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.domain.wallet_v3.model.KtpInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "Lid/dana/domain/wallet_v3/model/KtpInfo;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;)Lid/dana/domain/wallet_v3/model/KtpInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KtpInfoMapperKt {
    public static final KtpInfo BuiltInFictitiousFunctionClassFactory(KtpResult ktpResult) {
        Intrinsics.checkNotNullParameter(ktpResult, "");
        String backgroundUrl = ktpResult.getBackgroundUrl();
        Long createdDate = ktpResult.getCreatedDate();
        String iconUrl = ktpResult.getIconUrl();
        String str = iconUrl == null ? "" : iconUrl;
        String logoUrl = ktpResult.getLogoUrl();
        String str2 = logoUrl == null ? "" : logoUrl;
        String pocketId = ktpResult.getPocketId();
        String str3 = pocketId == null ? "" : pocketId;
        String pocketStatus = ktpResult.getPocketStatus();
        String pocketType = ktpResult.getPocketType();
        String str4 = ktpResult.extendInfo.get("CERT_NO");
        String str5 = str4 == null ? "" : str4;
        String str6 = ktpResult.extendInfo.get("CERT_NAME");
        String str7 = str6 == null ? "" : str6;
        String str8 = ktpResult.extendInfo.get("DATE_OF_BIRTH");
        String str9 = str8 == null ? "" : str8;
        String str10 = ktpResult.extendInfo.get("PLACE_OF_BIRTH");
        String str11 = str10 == null ? "" : str10;
        String str12 = ktpResult.extendInfo.get("HOME_ADDRESS");
        String str13 = str12 == null ? "" : str12;
        String str14 = ktpResult.extendInfo.get("RELIGION");
        String str15 = str14 == null ? "" : str14;
        String str16 = ktpResult.extendInfo.get("GENDER");
        if (str16 == null) {
            str16 = "";
        }
        String str17 = str16;
        String str18 = ktpResult.extendInfo.get("RT");
        if (str18 == null) {
            str18 = "";
        }
        String str19 = str18;
        String str20 = ktpResult.extendInfo.get("RW");
        if (str20 == null) {
            str20 = "";
        }
        String str21 = str20;
        String str22 = ktpResult.extendInfo.get("MARRIAGE");
        if (str22 == null) {
            str22 = "";
        }
        String str23 = str22;
        String str24 = ktpResult.extendInfo.get("NATIONALITY");
        if (str24 == null) {
            str24 = "";
        }
        String str25 = str24;
        String str26 = ktpResult.extendInfo.get("OCCUPATION");
        if (str26 == null) {
            str26 = "";
        }
        String str27 = str26;
        String str28 = ktpResult.extendInfo.get("DISTRICT");
        if (str28 == null) {
            str28 = "";
        }
        String str29 = ktpResult.extendInfo.get("SUB_DISTRICT");
        String str30 = str29 == null ? "" : str29;
        String cardTitle = ktpResult.getCardTitle();
        return new KtpInfo(backgroundUrl, createdDate, str, str2, str3, pocketStatus, pocketType, str5, str7, str9, str11, str13, str15, str17, str19, str21, str23, str25, str27, str28, str30, cardTitle == null ? "" : cardTitle);
    }
}
