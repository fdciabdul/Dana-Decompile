package id.dana.danah5.customshareitem;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import id.dana.R;
import id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager;
import id.dana.danah5.extension.DanaGriverShareURLCreatorExtension;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.share.interactor.GetPreviewActivity;
import id.dana.utils.CustomToastUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danah5/customshareitem/FeedsShareItem;", "Lid/dana/danah5/customshareitem/CustomBaseOutShareItem;", "Lcom/alibaba/griver/api/ui/share/ShareParam;", "shareParam", "Lcom/alibaba/griver/api/ui/share/ShareResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "doShare", "(Lcom/alibaba/griver/api/ui/share/ShareParam;Lcom/alibaba/griver/api/ui/share/ShareResultListener;)V", "Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "bottomSheetManager", "Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "<init>", "(Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FeedsShareItem extends CustomBaseOutShareItem {
    private final ShareFeedBottomSheetManager bottomSheetManager;

    public FeedsShareItem(ShareFeedBottomSheetManager shareFeedBottomSheetManager) {
        Intrinsics.checkNotNullParameter(shareFeedBottomSheetManager, "");
        this.bottomSheetManager = shareFeedBottomSheetManager;
        this.channelName = ShareItemChannel.FEEDS;
        this.iconDrawable = R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2;
    }

    @Override // com.alibaba.griver.core.model.share.BaseOutShareItem
    public final void doShare(ShareParam shareParam, ShareResultListener r14) {
        JsonObject asJsonObject;
        Set<Map.Entry<String, JsonElement>> entrySet;
        Set<Map.Entry<String, JsonElement>> entrySet2;
        Intrinsics.checkNotNullParameter(shareParam, "");
        try {
            JsonObject asJsonObject2 = JsonParser.parseString(shareParam.url).getAsJsonObject().getAsJsonObject(DanaGriverShareURLCreatorExtension.FEEDS_PARAMS);
            Intrinsics.checkNotNull(asJsonObject2);
            JsonElement jsonElement = asJsonObject2.get("contentType");
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            JsonElement jsonElement2 = asJsonObject2.get("contentCode");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            String str = asString;
            if (!(str == null || str.length() == 0)) {
                String str2 = asString2;
                if (!(str2 == null || str2.length() == 0)) {
                    HashMap hashMap = new HashMap();
                    if (asJsonObject2.get(ShareToFeedBridge.CONTENT_FORMATTER).isJsonPrimitive()) {
                        asJsonObject = JsonParser.parseString(asJsonObject2.get(ShareToFeedBridge.CONTENT_FORMATTER).getAsString()).getAsJsonObject();
                    } else {
                        asJsonObject = asJsonObject2.get(ShareToFeedBridge.CONTENT_FORMATTER).getAsJsonObject();
                    }
                    if (asJsonObject != null && (entrySet2 = asJsonObject.entrySet()) != null) {
                        Iterator<T> it = entrySet2.iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (!StringsKt.equals((String) entry.getKey(), ExtendInfoUtilKt.ACTOR_KEY, true)) {
                                Object key = entry.getKey();
                                Intrinsics.checkNotNullExpressionValue(key, "");
                                hashMap.put(key, MapsKt.mapOf(TuplesKt.to(ExtendInfoUtilKt.DISPLAY_NAME_KEY, ((JsonElement) entry.getValue()).toString())));
                            }
                        }
                    }
                    HashMap hashMap2 = new HashMap();
                    JsonObject asJsonObject3 = asJsonObject2.getAsJsonObject(ShareToFeedBridge.WIDGET);
                    if (asJsonObject3 != null && (entrySet = asJsonObject3.entrySet()) != null) {
                        Iterator<T> it2 = entrySet.iterator();
                        while (it2.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it2.next();
                            Object key2 = entry2.getKey();
                            Intrinsics.checkNotNullExpressionValue(key2, "");
                            String obj = ((JsonElement) entry2.getValue()).toString();
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                            hashMap2.put(key2, obj);
                        }
                    }
                    HashMap hashMap3 = hashMap;
                    hashMap3.put(ShareToFeedBridge.WIDGET, hashMap2);
                    GetPreviewActivity.Params params = new GetPreviewActivity.Params("", asString, asString2, hashMap3, null, 16, null);
                    ShareFeedBottomSheetManager shareFeedBottomSheetManager = this.bottomSheetManager;
                    Activity activity = shareParam.activity;
                    if (activity == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    }
                    String str3 = this.channelName;
                    Intrinsics.checkNotNullExpressionValue(str3, "");
                    shareFeedBottomSheetManager.showServicesBottomSheetDialog((FragmentActivity) activity, params, str3, r14);
                    return;
                }
            }
            Activity activity2 = shareParam.activity;
            String string = activity2.getString(R.string.share_to_feed_message_error);
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToastUtil customToastUtil = CustomToastUtil.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(activity2, "");
            CustomToastUtil.KClassImpl$Data$declaredNonStaticMembers$2(activity2, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, string);
            if (r14 != null) {
                r14.fail(this.channelName, "5", string);
            }
        } catch (Throwable th) {
            if (r14 != null) {
                r14.fail(this.channelName, "", th.getMessage());
            }
        }
    }
}
