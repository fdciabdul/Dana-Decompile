package id.dana.data.deeplink.mapper;

import android.util.Base64;
import id.dana.data.base.BaseMapper;
import id.dana.data.deeplink.model.SeamlessData;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.domain.deeplink.model.OauthParams;
import id.dana.utils.deeplink.BranchDeeplinkUtil;
import id.dana.utils.extension.JSONExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001!B\t\b\u0007¢\u0006\u0004\b\u001f\u0010 JC\u0010\b\u001a.\u0012\b\u0012\u0006*\u00020\u00060\u0006\u0012\b\u0012\u0006*\u00020\u00060\u0006*\u0016\u0012\b\u0012\u0006*\u00020\u00060\u0006\u0012\b\u0012\u0006*\u00020\u00060\u00060\u00070\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u0012"}, d2 = {"Lid/dana/data/deeplink/mapper/DeepLinkPayloadEntityMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadEntity;", "Lid/dana/domain/deeplink/model/DeepLinkPayload;", "oldItem", "", "", "", "createParams", "(Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadEntity;)Ljava/util/Map;", "attributes", "getAttributes", "(Ljava/lang/String;)Ljava/util/Map;", "payload", "Lorg/json/JSONObject;", "getExtendedInfo", "(Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadEntity;)Lorg/json/JSONObject;", "getPhoneNumber", "(Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadEntity;)Ljava/lang/String;", "map", "(Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadEntity;)Lid/dana/domain/deeplink/model/DeepLinkPayload;", "Lid/dana/domain/deeplink/model/OauthParams;", "mapOauthParams", "(Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadEntity;)Lid/dana/domain/deeplink/model/OauthParams;", "params", "encoding", "encodedParams", "", "processEncodedParams", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "acquireReferringLink", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeepLinkPayloadEntityMapper extends BaseMapper<DeepLinkPayloadEntity, DeepLinkPayload> {
    private static final String AUTH_CODE_KEY = "authCode";
    private static final String ENCODING_BASE64 = "base64";
    private static final String PARAMS = "params=";

    @Inject
    public DeepLinkPayloadEntityMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final DeepLinkPayload map(DeepLinkPayloadEntity oldItem) {
        if (oldItem != null) {
            DeepLinkPayload deepLinkPayload = new DeepLinkPayload();
            deepLinkPayload.setInnerUrl(oldItem.getInnerUrl());
            deepLinkPayload.setPath(oldItem.getPath());
            deepLinkPayload.setDestinationPath(oldItem.getDestinationPath());
            deepLinkPayload.setOrderId(oldItem.getOrderId());
            deepLinkPayload.setFullUrl(oldItem.getFullUrl());
            deepLinkPayload.setSkipHomePage(oldItem.isSkipHomePage());
            deepLinkPayload.setShortCode(oldItem.getShortCode());
            deepLinkPayload.setPromoCode(oldItem.getPromoCode());
            deepLinkPayload.setReferralCode(oldItem.getReferralCode());
            deepLinkPayload.setAction(oldItem.getAction());
            deepLinkPayload.setParams(createParams(oldItem));
            String fullUrl = oldItem.getFullUrl();
            if (!(fullUrl == null || fullUrl.length() == 0)) {
                Map<String, String> params = deepLinkPayload.getParams();
                Intrinsics.checkNotNullExpressionValue(params, "");
                String fullUrl2 = oldItem.getFullUrl();
                Intrinsics.checkNotNullExpressionValue(fullUrl2, "");
                deepLinkPayload.setParams(MapsKt.plus(params, BranchDeeplinkUtil.KClassImpl$Data$declaredNonStaticMembers$2(fullUrl2)));
            }
            deepLinkPayload.setOauthParams(mapOauthParams(oldItem));
            deepLinkPayload.setCodeValue(oldItem.getCodeValue());
            deepLinkPayload.setExtendedInfo(getExtendedInfo(oldItem));
            return deepLinkPayload;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Map<java.lang.String, java.lang.String> createParams(id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity r16) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.deeplink.mapper.DeepLinkPayloadEntityMapper.createParams(id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity):java.util.Map");
    }

    private final void processEncodedParams(Map<String, String> params, String encoding, String encodedParams) {
        if (StringsKt.equals(encoding, ENCODING_BASE64, true)) {
            byte[] decode = Base64.decode(encodedParams, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "");
            for (Map.Entry<String, String> entry : getAttributes(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(new String(decode, Charsets.UTF_8), PARAMS, "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null)).entrySet()) {
                params.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private final Map<String, String> getAttributes(String attributes) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Matcher matcher = Pattern.compile("(\\w+)=(.*?)(?=,\\w+=|$)").matcher(attributes);
        while (matcher.find()) {
            if (matcher.group(1) != null && matcher.group(2) != null) {
                String group = matcher.group(1);
                Intrinsics.checkNotNull(group);
                String group2 = matcher.group(2);
                Intrinsics.checkNotNull(group2);
                linkedHashMap.put(group, group2);
            }
        }
        return linkedHashMap;
    }

    private final JSONObject getExtendedInfo(DeepLinkPayloadEntity payload) {
        try {
            String extendedInfo = payload.getExtendedInfo();
            if (extendedInfo == null) {
                extendedInfo = "{}";
            }
            return new JSONObject(extendedInfo);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    private final OauthParams mapOauthParams(DeepLinkPayloadEntity oldItem) {
        String clientId = oldItem.getClientId();
        if (clientId != null) {
            OauthParams oauthParams = new OauthParams();
            oauthParams.setClientId(clientId);
            oauthParams.setResponseType(oldItem.getResponseType());
            oauthParams.setPhoneNumber(getPhoneNumber(oldItem));
            oauthParams.setState(oldItem.getState());
            oauthParams.setCodeChallenge(oldItem.getCodeChallenge());
            oauthParams.setNeedMobileToken(oldItem.isNeedMobileToken());
            oauthParams.setRedirectUrl(oldItem.getRedirectUrl());
            oauthParams.setMerchantName(oldItem.getMerchantName());
            oauthParams.setReferringLink(acquireReferringLink(oldItem));
            oauthParams.setMerchantId(oldItem.getMerchantId());
            oauthParams.setIpgBinding(oldItem.isIpgBinding());
            if (oldItem.getScopes() != null) {
                oauthParams.setScope(oldItem.getScopes());
                return oauthParams;
            }
            return oauthParams;
        }
        return null;
    }

    private final String getPhoneNumber(DeepLinkPayloadEntity oldItem) {
        String phoneNumber = oldItem.getPhoneNumber();
        if (!(phoneNumber == null || StringsKt.isBlank(phoneNumber))) {
            return oldItem.getPhoneNumber();
        }
        String seamlessData = oldItem.getSeamlessData();
        if (seamlessData == null || seamlessData.length() == 0) {
            return null;
        }
        Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(oldItem.getSeamlessData(), (Class<Object>) SeamlessData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "");
        return ((SeamlessData) fromJson).getMobile();
    }

    private final String acquireReferringLink(DeepLinkPayloadEntity deepLinkPayloadEntity) {
        return deepLinkPayloadEntity.getReferringLink() != null ? deepLinkPayloadEntity.getReferringLink() : deepLinkPayloadEntity.getUrl();
    }
}
