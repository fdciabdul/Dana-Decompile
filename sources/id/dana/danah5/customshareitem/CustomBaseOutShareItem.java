package id.dana.danah5.customshareitem;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.core.model.share.BaseOutShareItem;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import id.dana.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.extension.DanaGriverShareURLCreatorExtension;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.DefaultObserver;
import id.dana.utils.ObservableUtil;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.util.LinkProperties;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u00020\u0006*\u00020\u00028EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/danah5/customshareitem/CustomBaseOutShareItem;", "Lcom/alibaba/griver/core/model/share/BaseOutShareItem;", "Lcom/alibaba/griver/api/ui/share/ShareParam;", "shareParam", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "generateDeepLink", "(Lcom/alibaba/griver/api/ui/share/ShareParam;Landroid/content/Context;)Ljava/lang/String;", "Lio/branch/referral/util/LinkProperties;", "generateLinkProperties", "(Lcom/alibaba/griver/api/ui/share/ShareParam;)Lio/branch/referral/util/LinkProperties;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/alibaba/griver/api/ui/share/ShareResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "generateOnActivity", "(Landroid/app/Activity;Lcom/alibaba/griver/api/ui/share/ShareParam;Lcom/alibaba/griver/api/ui/share/ShareResultListener;)V", "onShare", "(Lcom/alibaba/griver/api/ui/share/ShareParam;Lcom/alibaba/griver/api/ui/share/ShareResultListener;)V", "message", "showToast", "(Landroid/content/Context;Ljava/lang/String;)V", "deeplink", "startShare", "(Lcom/alibaba/griver/api/ui/share/ShareParam;Ljava/lang/String;Lcom/alibaba/griver/api/ui/share/ShareResultListener;)V", "getPureDeeplink", "(Lcom/alibaba/griver/api/ui/share/ShareParam;)Ljava/lang/String;", "pureDeeplink", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class CustomBaseOutShareItem extends BaseOutShareItem {
    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onShare$lambda-0  reason: not valid java name */
    public static final android.app.Activity m650onShare$lambda0(android.app.Activity r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.customshareitem.CustomBaseOutShareItem.m650onShare$lambda0(android.app.Activity):android.app.Activity");
    }

    @Override // com.alibaba.griver.core.model.share.BaseOutShareItem, com.alibaba.griver.api.ui.share.BaseShareItem
    public void onShare(final ShareParam shareParam, final ShareResultListener listener) {
        final Activity activity = shareParam != null ? shareParam.activity : null;
        if (activity == null) {
            return;
        }
        if (this instanceof FeedsShareItem) {
            doShare(shareParam, listener);
        } else {
            ObservableUtil.MyBillsEntityDataFactory(new Callable() { // from class: id.dana.danah5.customshareitem.CustomBaseOutShareItem$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return CustomBaseOutShareItem.m650onShare$lambda0(activity);
                }
            }, new DefaultObserver<Activity>() { // from class: id.dana.danah5.customshareitem.CustomBaseOutShareItem$onShare$2
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onNext(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "");
                    CustomBaseOutShareItem.this.generateOnActivity(activity2, shareParam, listener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void generateOnActivity(final Activity activity, final ShareParam shareParam, final ShareResultListener listener) {
        final DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(activity);
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        ObservableUtil.MyBillsEntityDataFactory(new Callable() { // from class: id.dana.danah5.customshareitem.CustomBaseOutShareItem$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String m649generateOnActivity$lambda1;
                m649generateOnActivity$lambda1 = CustomBaseOutShareItem.m649generateOnActivity$lambda1(CustomBaseOutShareItem.this, shareParam, activity);
                return m649generateOnActivity$lambda1;
            }
        }, new DefaultObserver<String>() { // from class: id.dana.danah5.customshareitem.CustomBaseOutShareItem$generateOnActivity$2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(String deeplink) {
                Intrinsics.checkNotNullParameter(deeplink, "");
                DanaLoadingDialog.this.PlaceComponentResult();
                this.startShare(shareParam, deeplink, listener);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "");
                DanaLoadingDialog.this.PlaceComponentResult();
                CustomBaseOutShareItem customBaseOutShareItem = this;
                Activity activity2 = activity;
                Activity activity3 = activity2;
                String string = activity2.getString(R.string.failed_generate_miniporgram_deeplink);
                Intrinsics.checkNotNullExpressionValue(string, "");
                customBaseOutShareItem.showToast(activity3, string);
                this.doShare(null, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: generateOnActivity$lambda-1  reason: not valid java name */
    public static final String m649generateOnActivity$lambda1(CustomBaseOutShareItem customBaseOutShareItem, ShareParam shareParam, Activity activity) {
        Intrinsics.checkNotNullParameter(customBaseOutShareItem, "");
        Intrinsics.checkNotNullParameter(shareParam, "");
        Intrinsics.checkNotNullParameter(activity, "");
        return customBaseOutShareItem.generateDeepLink(shareParam, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startShare(ShareParam shareParam, String deeplink, ShareResultListener listener) {
        JsonObject asJsonObject = JsonParser.parseString(shareParam.url).getAsJsonObject();
        shareParam.url = deeplink;
        if (asJsonObject.has(DanaGriverShareURLCreatorExtension.FEEDS_PARAMS)) {
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject(DanaGriverShareURLCreatorExtension.FEEDS_PARAMS);
            if (asJsonObject2.size() > 0) {
                shareParam.url = Uri.parse(deeplink).buildUpon().appendQueryParameter(DanaGriverShareURLCreatorExtension.FEEDS_PARAMS, asJsonObject2.toString()).build().toString();
            }
        }
        doShare(shareParam, listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getPureDeeplink")
    public final String getPureDeeplink(ShareParam shareParam) {
        Intrinsics.checkNotNullParameter(shareParam, "");
        String str = shareParam.url;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return StringsKt.substringBefore$default(str, '?', (String) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void showToast(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(message, "");
        Toast.makeText(context, message, 0).show();
    }

    private final String generateDeepLink(ShareParam shareParam, Context context) {
        BranchUniversalObject branchUniversalObject = new BranchUniversalObject();
        branchUniversalObject.BuiltInFictitiousFunctionClassFactory = BranchLinkConstant.CanonicalIdStarter.MINI_PROGRAM;
        branchUniversalObject.lookAheadTest = shareParam.title;
        branchUniversalObject.getAuthRequestContext = shareParam.desc;
        branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2 = BranchUniversalObject.CONTENT_INDEX_MODE.PUBLIC;
        branchUniversalObject.MyBillsEntityDataFactory = BranchUniversalObject.CONTENT_INDEX_MODE.PUBLIC;
        return branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2(new BranchShortLinkBuilder(context), generateLinkProperties(shareParam)).getAuthRequestContext();
    }

    private final LinkProperties generateLinkProperties(ShareParam shareParam) {
        LinkProperties linkProperties = new LinkProperties();
        linkProperties.PlaceComponentResult.put("path", "miniprogram");
        linkProperties.PlaceComponentResult.put("action", BranchLinkConstant.ActionTarget.OPEN_APP);
        StringBuilder sb = new StringBuilder();
        sb.append("[appId=");
        String str = shareParam.params.get("_ariver_appid");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        linkProperties.PlaceComponentResult.put("params", sb.toString());
        JSONObject jSONObject = new JSONObject(shareParam.url);
        jSONObject.remove(DanaGriverShareURLCreatorExtension.FEEDS_PARAMS);
        linkProperties.PlaceComponentResult.put(BranchLinkConstant.PayloadKey.EXTENDED_INFO, jSONObject.toString());
        return linkProperties;
    }
}
