package id.dana.data.pushverify.mapper;

import id.dana.data.pushverify.source.model.PushVerificationDetailResult;
import id.dana.data.pushverify.source.model.PushVerificationListResult;
import id.dana.data.pushverify.source.model.PushVerifyChallengeRequest;
import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import id.dana.data.pushverify.source.model.VerificationDetailItemDTO;
import id.dana.domain.pushverify.model.PushVerificationDetail;
import id.dana.domain.pushverify.model.PushVerificationList;
import id.dana.domain.pushverify.model.PushVerifyAnnouncement;
import id.dana.domain.pushverify.model.PushVerifyChallenge;
import id.dana.domain.pushverify.model.PushVerifyParam;
import id.dana.domain.pushverify.model.VerificationDetailItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0000¢\u0006\u0004\b\u000e\u0010\u0011\u001a\u0011\u0010\u0013\u001a\u00020\u0012*\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0017\u001a\u00020\u0016*\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u0019\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"", "Lid/dana/data/pushverify/source/model/VerificationDetailItemDTO;", "Lid/dana/domain/pushverify/model/VerificationDetailItem;", "toListVerificationDetailItem", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;", "Lid/dana/domain/pushverify/model/PushVerificationDetail;", "toPushVerificationDetail", "(Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;)Lid/dana/domain/pushverify/model/PushVerificationDetail;", "Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "Lid/dana/domain/pushverify/model/PushVerificationList;", "toPushVerificationList", "(Lid/dana/data/pushverify/source/model/PushVerificationListResult;)Lid/dana/domain/pushverify/model/PushVerificationList;", "Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "toPushVerifyAnnouncement", "(Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;)Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "(Ljava/util/List;)Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "Lid/dana/domain/pushverify/model/PushVerifyChallenge;", "toPushVerifyChallenge", "(Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;)Lid/dana/domain/pushverify/model/PushVerifyChallenge;", "Lid/dana/domain/pushverify/model/PushVerifyParam;", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "toPushVerifyChallengeRequest", "(Lid/dana/domain/pushverify/model/PushVerifyParam;)Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "toVerificationDetailItem", "(Lid/dana/data/pushverify/source/model/VerificationDetailItemDTO;)Lid/dana/domain/pushverify/model/VerificationDetailItem;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PushVerifyChallengeMapperKt {
    public static final PushVerifyChallengeRequest toPushVerifyChallengeRequest(PushVerifyParam pushVerifyParam) {
        Intrinsics.checkNotNullParameter(pushVerifyParam, "");
        return new PushVerifyChallengeRequest(pushVerifyParam.getTransactionId(), pushVerifyParam.getCacheKey());
    }

    public static final VerificationDetailItem toVerificationDetailItem(VerificationDetailItemDTO verificationDetailItemDTO) {
        Intrinsics.checkNotNullParameter(verificationDetailItemDTO, "");
        String merchantName = verificationDetailItemDTO.getMerchantName();
        String requestTime = verificationDetailItemDTO.getRequestTime();
        String requestType = verificationDetailItemDTO.getRequestType();
        String logoUrl = verificationDetailItemDTO.getLogoUrl();
        String str = logoUrl == null ? "" : logoUrl;
        String verificationStatus = verificationDetailItemDTO.getVerificationStatus();
        Integer expiryTime = verificationDetailItemDTO.getExpiryTime();
        int intValue = expiryTime != null ? expiryTime.intValue() : 0;
        String trxId = verificationDetailItemDTO.getTrxId();
        String str2 = trxId == null ? "" : trxId;
        String token = verificationDetailItemDTO.getToken();
        String str3 = token == null ? "" : token;
        String cacheKey = verificationDetailItemDTO.getCacheKey();
        return new VerificationDetailItem(merchantName, requestTime, requestType, str, verificationStatus, intValue, str2, str3, cacheKey == null ? "" : cacheKey);
    }

    public static final List<VerificationDetailItem> toListVerificationDetailItem(List<VerificationDetailItemDTO> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<VerificationDetailItemDTO> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toVerificationDetailItem((VerificationDetailItemDTO) it.next()));
        }
        return arrayList;
    }

    public static final PushVerificationList toPushVerificationList(PushVerificationListResult pushVerificationListResult) {
        Intrinsics.checkNotNullParameter(pushVerificationListResult, "");
        return new PushVerificationList(toListVerificationDetailItem(pushVerificationListResult.getVerificationList()), pushVerificationListResult.getHasMore());
    }

    public static final PushVerifyAnnouncement toPushVerifyAnnouncement(List<PushVerifyChallengeResult> list) {
        PushVerifyChallengeResult pushVerifyChallengeResult;
        PushVerificationDetailResult verificationDetail;
        if (list == null || (pushVerifyChallengeResult = (PushVerifyChallengeResult) CollectionsKt.firstOrNull((List) list)) == null || (verificationDetail = pushVerifyChallengeResult.getVerificationDetail()) == null) {
            return null;
        }
        return toPushVerifyAnnouncement(verificationDetail);
    }

    public static final PushVerifyChallenge toPushVerifyChallenge(PushVerifyChallengeResult pushVerifyChallengeResult) {
        Intrinsics.checkNotNullParameter(pushVerifyChallengeResult, "");
        String tokenPair = pushVerifyChallengeResult.getTokenPair();
        String str = tokenPair != null ? tokenPair : "";
        PushVerificationDetailResult verificationDetail = pushVerifyChallengeResult.getVerificationDetail();
        return new PushVerifyChallenge(str, verificationDetail != null ? toPushVerificationDetail(verificationDetail) : null);
    }

    public static final PushVerificationDetail toPushVerificationDetail(PushVerificationDetailResult pushVerificationDetailResult) {
        Intrinsics.checkNotNullParameter(pushVerificationDetailResult, "");
        String merchantId = pushVerificationDetailResult.getMerchantId();
        String str = merchantId == null ? "" : merchantId;
        String merchantName = pushVerificationDetailResult.getMerchantName();
        String str2 = merchantName == null ? "" : merchantName;
        String device = pushVerificationDetailResult.getDevice();
        String str3 = device == null ? "" : device;
        String requestTime = pushVerificationDetailResult.getRequestTime();
        String str4 = requestTime == null ? "" : requestTime;
        String requestType = pushVerificationDetailResult.getRequestType();
        String str5 = requestType == null ? "" : requestType;
        String logoUrl = pushVerificationDetailResult.getLogoUrl();
        String str6 = logoUrl == null ? "" : logoUrl;
        Integer expiryTime = pushVerificationDetailResult.getExpiryTime();
        return new PushVerificationDetail(str, str2, str3, str4, str5, str6, expiryTime != null ? expiryTime.intValue() : 0);
    }

    public static final PushVerifyAnnouncement toPushVerifyAnnouncement(PushVerificationDetailResult pushVerificationDetailResult) {
        Intrinsics.checkNotNullParameter(pushVerificationDetailResult, "");
        String trxId = pushVerificationDetailResult.getTrxId();
        if (trxId == null) {
            trxId = "";
        }
        String token = pushVerificationDetailResult.getToken();
        if (token == null) {
            token = "";
        }
        String cacheKey = pushVerificationDetailResult.getCacheKey();
        return new PushVerifyAnnouncement(trxId, token, cacheKey != null ? cacheKey : "");
    }
}
