package id.dana.contract.deeplink;

import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.google.gson.JsonSyntaxException;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.tracker.AbstractDeeplinkTrackerFactory;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.deeplink.DeeplinkException;
import id.dana.data.util.NumberUtils;
import id.dana.domain.DefaultObserver;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.tracker.constant.TrackerType;
import id.dana.utils.RSAUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public class DeepLinkObserver extends DefaultObserver<DeepLinkPayload> {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "DeepLinkObserver";
    private final DeepLinkPayloadModelMapper BuiltInFictitiousFunctionClassFactory;
    private AbstractDeeplinkTrackerFactory MyBillsEntityDataFactory;
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private DeeplinkTracker PlaceComponentResult;
    private final boolean getAuthRequestContext;
    private String getErrorConfigVersion;
    private Intent lookAheadTest;
    private final DeepLinkContract.View scheduleImpl;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00fe, code lost:
    
        if (r0.equals(id.dana.data.constant.BranchLinkConstant.PathTarget.DECODE) != false) goto L169;
     */
    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void onNext(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkObserver.onNext(java.lang.Object):void");
    }

    public DeepLinkObserver(DeepLinkContract.View view, AbstractDeeplinkTrackerFactory abstractDeeplinkTrackerFactory, boolean z, String str, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper) {
        this(view, z, str, deepLinkPayloadModelMapper, abstractDeeplinkTrackerFactory.BuiltInFictitiousFunctionClassFactory(TrackerType.MIXPANEL));
        this.MyBillsEntityDataFactory = abstractDeeplinkTrackerFactory;
    }

    public DeepLinkObserver(DeepLinkContract.View view, AbstractDeeplinkTrackerFactory abstractDeeplinkTrackerFactory, String str, String str2, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper) {
        this(view, str, deepLinkPayloadModelMapper, str2, abstractDeeplinkTrackerFactory.BuiltInFictitiousFunctionClassFactory(TrackerType.MIXPANEL));
        this.MyBillsEntityDataFactory = abstractDeeplinkTrackerFactory;
    }

    private DeepLinkObserver(DeepLinkContract.View view, boolean z, String str, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper) {
        this.scheduleImpl = view;
        this.getAuthRequestContext = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.BuiltInFictitiousFunctionClassFactory = deepLinkPayloadModelMapper;
    }

    public DeepLinkObserver(DeepLinkContract.View view, String str, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper, Intent intent, DeeplinkTracker deeplinkTracker) {
        this(view, false, str, deepLinkPayloadModelMapper);
        this.lookAheadTest = intent;
        this.PlaceComponentResult = deeplinkTracker;
    }

    public DeepLinkObserver(DeepLinkContract.View view, boolean z, String str, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper, DeeplinkTracker deeplinkTracker) {
        this(view, z, str, deepLinkPayloadModelMapper);
        this.PlaceComponentResult = deeplinkTracker;
    }

    private DeepLinkObserver(DeepLinkContract.View view, String str, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper, String str2, DeeplinkTracker deeplinkTracker) {
        this(view, false, str, deepLinkPayloadModelMapper);
        this.PlaceComponentResult = deeplinkTracker;
        this.getErrorConfigVersion = str2 == null ? null : NumberUtils.replaceIndoPhoneNumberPrefixWithZero(str2);
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public void onError(Throwable th) {
        super.onError(th);
        this.scheduleImpl.dismissProgress();
        this.scheduleImpl.onError(th.getMessage());
        DeeplinkTracker deeplinkTracker = this.PlaceComponentResult;
        if (deeplinkTracker != null) {
            deeplinkTracker.KClassImpl$Data$declaredNonStaticMembers$2(th);
        }
        if (MyBillsEntityDataFactory(th)) {
            DeeplinkSaveDataManager.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2 = true;
            DeeplinkTracker deeplinkTracker2 = this.PlaceComponentResult;
            if (deeplinkTracker2 != null) {
                deeplinkTracker2.MyBillsEntityDataFactory(th);
            }
        }
    }

    private static boolean MyBillsEntityDataFactory(Throwable th) {
        return (th instanceof DeeplinkException) || (th instanceof TimeoutException) || (th instanceof IOException) || (th instanceof JSONException) || (th instanceof JsonSyntaxException);
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkPayload deepLinkPayload) {
        String fullUrl = deepLinkPayload.getFullUrl();
        String innerUrl = deepLinkPayload.getInnerUrl();
        if (innerUrl != null && !innerUrl.equals(fullUrl)) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(innerUrl);
            fullUrl = sb.toString();
        }
        return fullUrl == null ? "" : fullUrl;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(DeepLinkPayload deepLinkPayload) {
        return BranchLinkConstant.PathTarget.FEATURE.equals(deepLinkPayload.getPath());
    }

    private Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null && !map.containsKey("source")) {
            map.put("source", this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        return map;
    }

    private boolean MyBillsEntityDataFactory(DeepLinkPayload deepLinkPayload) {
        if (TextUtils.isEmpty(deepLinkPayload.getInnerUrl())) {
            return deepLinkPayload.getFullUrl() != null;
        } else if (deepLinkPayload.getParams() == null || !deepLinkPayload.getParams().containsKey(BranchLinkConstant.Params.LOGIN_ID)) {
            return true;
        } else {
            return PlaceComponentResult(deepLinkPayload);
        }
    }

    private boolean PlaceComponentResult(DeepLinkPayload deepLinkPayload) {
        String str = deepLinkPayload.getParams().get(BranchLinkConstant.Params.LOGIN_ID);
        return (this.getErrorConfigVersion == null || TextUtils.isEmpty(str) || !NumberUtils.replaceIndoPhoneNumberPrefixWithZero(this.getErrorConfigVersion).equals(RSAUtil.BuiltInFictitiousFunctionClassFactory(str))) ? false : true;
    }
}
