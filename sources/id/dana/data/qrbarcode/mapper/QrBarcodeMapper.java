package id.dana.data.qrbarcode.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.qrbarcode.repository.source.network.result.DecodedQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.GenerateQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.QrDetail;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.domain.qrbarcode.QrUserResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/data/qrbarcode/mapper/QrBarcodeMapper;", "", "Lid/dana/data/qrbarcode/repository/source/network/result/DecodedQrResult;", "entity", "Lid/dana/domain/qrbarcode/DecodedScan;", "transform", "(Lid/dana/data/qrbarcode/repository/source/network/result/DecodedQrResult;)Lid/dana/domain/qrbarcode/DecodedScan;", "Lid/dana/data/qrbarcode/repository/source/network/result/GenerateQrResult;", "Lid/dana/domain/qrbarcode/QrUserResult;", "(Lid/dana/data/qrbarcode/repository/source/network/result/GenerateQrResult;)Lid/dana/domain/qrbarcode/QrUserResult;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QrBarcodeMapper {
    private static final String AC_DECODE_CONFIG = "acDecodeConfig";

    @Inject
    public QrBarcodeMapper() {
    }

    public final DecodedScan transform(DecodedQrResult entity) {
        DecodedScan decodedScan = new DecodedScan();
        if (entity == null) {
            return decodedScan;
        }
        BaseMapper.transform(decodedScan, entity);
        decodedScan.setMobileNumber(entity.mobileNumber);
        decodedScan.setBizType(entity.bizType);
        decodedScan.setBizNo(entity.bizNo);
        decodedScan.setReceiverId(entity.receiverId);
        decodedScan.setNickname(entity.nickname);
        decodedScan.setLoginId(entity.loginId);
        decodedScan.setBizInfo(entity.bizInfo);
        decodedScan.setAvatarUrl(entity.avatarUrl);
        decodedScan.setRedirectUrl(entity.redirectUrl);
        Map<String, String> map = entity.bizInfo;
        decodedScan.setAcDecodeConfig(map != null ? map.get("acDecodeConfig") : null);
        return decodedScan;
    }

    public final QrUserResult transform(GenerateQrResult entity) {
        QrUserResult qrUserResult = new QrUserResult();
        if (entity != null) {
            BaseMapper.transform(qrUserResult, entity);
            qrUserResult.setQrCode(entity.qrCode);
            ArrayList arrayList = new ArrayList();
            List<QrDetail> list = entity.qrCodeList;
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(list, "");
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((QrDetail) it.next()).getQrCode());
                }
            }
            qrUserResult.setQrCodeList(arrayList);
        }
        return qrUserResult;
    }
}
