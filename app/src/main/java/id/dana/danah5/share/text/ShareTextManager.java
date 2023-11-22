package id.dana.danah5.share.text;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Patterns;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.anggrayudi.storage.extension.ContextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.share.constant.StringDefaultValue;
import id.dana.danah5.share.directtext.ShareDirectTextEntity;
import id.dana.danah5.share.directtext.ShareDirectTextResultFactory;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiverListener;
import id.dana.data.socialshare.ShareAppKey;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.app.bridge.share.text.ShareTextEntity;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import id.dana.richview.socialshare.model.SocialShareModel;
import id.dana.richview.socialshare.model.SocialShareModelFactory;
import id.dana.util.MinApiUtils;
import id.dana.utils.OSUtil;
import id.dana.utils.RandomInteger;
import id.dana.utils.android.IntentUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B\u001f\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b/\u00100J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u0019\u0010\u001f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u0019\u0010\u001f\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001f\u0010\u0019J!\u0010\"\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/danah5/share/text/ShareTextManager;", "", "", "text", "extractLinks", "(Ljava/lang/String;)Ljava/lang/String;", "extraMessage", "bizCode", "Landroid/app/PendingIntent;", "getReceiverPendingIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/app/PendingIntent;", "resultType", "Lcom/alibaba/fastjson/JSONObject;", "getResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "title", "", "openChooseDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/danah5/share/directtext/ShareDirectTextEntity;", "shareDirectTextEntity", "processEvent", "(Lid/dana/danah5/share/directtext/ShareDirectTextEntity;)V", "Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextEntity;", "shareTextEntity", "(Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextEntity;)V", "registerReceiver", "()V", "sendUnknownError", "shareNoApplicationFound", "shareNoMessageResult", "shareText", "message", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "shareToExternalApp", "(Ljava/lang/String;Ljava/lang/String;)V", "shareWithSms", "(Ljava/lang/String;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;", "shareTextBroadcastReceiver", "Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;", "<init>", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareTextManager {
    private static final String ACTION = "broadcast_risk_event";
    private final Activity activity;
    private final BridgeCallback bridgeCallback;
    private final ShareTextBroadcastReceiver shareTextBroadcastReceiver;
    private static final String TAG = "ShareTextManager";
    private static final int SHARE_TEXT_REQUEST_CODE = RandomInteger.BuiltInFictitiousFunctionClassFactory();

    public ShareTextManager(Activity activity, BridgeCallback bridgeCallback, ShareTextBroadcastReceiver shareTextBroadcastReceiver) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(shareTextBroadcastReceiver, "");
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        this.shareTextBroadcastReceiver = shareTextBroadcastReceiver;
    }

    public final void processEvent(ShareTextEntity shareTextEntity) {
        if (shareTextEntity != null) {
            shareText(shareTextEntity);
        } else {
            this.bridgeCallback.sendJSONResponse(getResult("NO_CONTENT_INFO"));
        }
    }

    public final void processEvent(ShareDirectTextEntity shareDirectTextEntity) {
        if (shareDirectTextEntity != null) {
            shareText(shareDirectTextEntity);
        } else {
            this.bridgeCallback.sendJSONResponse(getResult("NO_CONTENT_INFO"));
        }
    }

    private final void shareText(ShareTextEntity shareTextEntity) {
        String title;
        String message = shareTextEntity != null ? shareTextEntity.getMessage() : null;
        if (message == null || message.length() == 0) {
            shareNoMessageResult();
            return;
        }
        String title2 = shareTextEntity != null ? shareTextEntity.getTitle() : null;
        if (title2 == null || title2.length() == 0) {
            title = StringDefaultValue.SHARE_TITLE;
        } else {
            Intrinsics.checkNotNull(shareTextEntity);
            title = shareTextEntity.getTitle();
        }
        Intrinsics.checkNotNull(shareTextEntity);
        openChooseDialog(shareTextEntity.getMessage(), title, shareTextEntity.getBizCode());
    }

    private final void shareText(ShareDirectTextEntity shareDirectTextEntity) {
        String message = shareDirectTextEntity != null ? shareDirectTextEntity.getMessage() : null;
        if (message == null || message.length() == 0) {
            shareNoMessageResult();
        } else if (shareDirectTextEntity != null) {
            if (Intrinsics.areEqual(shareDirectTextEntity.getExternalApp(), ShareAppKey.SMS)) {
                shareWithSms(shareDirectTextEntity.getMessage());
            }
            SocialShareModel BuiltInFictitiousFunctionClassFactory = SocialShareModelFactory.BuiltInFictitiousFunctionClassFactory(this.activity.getApplicationContext(), shareDirectTextEntity.getExternalApp());
            if (BuiltInFictitiousFunctionClassFactory != null) {
                String message2 = shareDirectTextEntity.getMessage();
                String str = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(str, "");
                shareToExternalApp(message2, str);
            }
        }
    }

    private final void shareWithSms(String message) {
        Intent MyBillsEntityDataFactory = IntentUtil.MyBillsEntityDataFactory(message);
        if (MyBillsEntityDataFactory.resolveActivity(this.activity.getPackageManager()) != null) {
            this.activity.startActivity(MyBillsEntityDataFactory);
        }
    }

    private final void shareToExternalApp(String message, String r3) {
        try {
            Intent KClassImpl$Data$declaredNonStaticMembers$2 = IntentUtil.KClassImpl$Data$declaredNonStaticMembers$2(message);
            if (IntentUtil.PlaceComponentResult(this.activity, r3)) {
                KClassImpl$Data$declaredNonStaticMembers$2.setPackage(r3);
                this.activity.startActivity(KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            shareNoApplicationFound();
        } catch (ActivityNotFoundException unused) {
            shareNoApplicationFound();
        }
    }

    private final void shareNoMessageResult() {
        this.bridgeCallback.sendJSONResponse(ShareDirectTextResultFactory.INSTANCE.getResult("NO_MESSAGE"));
    }

    private final void shareNoApplicationFound() {
        this.bridgeCallback.sendJSONResponse(ShareDirectTextResultFactory.INSTANCE.getResult("APPLICATION_NOT_FOUND"));
    }

    private final void openChooseDialog(String extraMessage, String title, String bizCode) {
        registerReceiver();
        Intent addFlags = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", extraMessage).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Intrinsics.checkNotNullExpressionValue(addFlags, "");
        if (ContentExtKt.hasActivityHandler(addFlags, GContainer.getApplicationContext())) {
            if (OSUtil.lookAheadTest()) {
                this.activity.startActivity(Intent.createChooser(addFlags, title, getReceiverPendingIntent(extraMessage, bizCode).getIntentSender()));
                return;
            } else {
                this.activity.startActivity(Intent.createChooser(addFlags, title));
                return;
            }
        }
        sendUnknownError();
    }

    private final void registerReceiver() {
        try {
            this.activity.registerReceiver(this.shareTextBroadcastReceiver, new IntentFilter(ACTION));
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, "registerReceiver", e);
        }
        this.shareTextBroadcastReceiver.setListener(new ShareTextBroadcastReceiverListener() { // from class: id.dana.danah5.share.text.ShareTextManager$$ExternalSyntheticLambda0
            @Override // id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiverListener
            public final void onReceive(boolean z) {
                ShareTextManager.m721registerReceiver$lambda2(ShareTextManager.this, z);
            }
        });
    }

    /* renamed from: registerReceiver$lambda-2 */
    public static final void m721registerReceiver$lambda2(ShareTextManager shareTextManager, boolean z) {
        Intrinsics.checkNotNullParameter(shareTextManager, "");
        shareTextManager.bridgeCallback.sendJSONResponse(shareTextManager.getResult("SUCCESS"));
        ContextUtils.MyBillsEntityDataFactory(shareTextManager.activity, shareTextManager.shareTextBroadcastReceiver);
    }

    private final PendingIntent getReceiverPendingIntent(String extraMessage, String bizCode) {
        Intent putExtra = new Intent(ACTION).putExtra("URL", extractLinks(extraMessage)).putExtra("bizCode", bizCode);
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.activity, SHARE_TEXT_REQUEST_CODE, putExtra, MinApiUtils.PlaceComponentResult() ? 167772160 : 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "");
        return broadcast;
    }

    private final void sendUnknownError() {
        this.bridgeCallback.sendJSONResponse(getResult("UNKNOWN_ERROR"));
    }

    private final JSONObject getResult(String resultType) {
        String str;
        if (Intrinsics.areEqual(resultType, "SUCCESS")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject2;
        jSONObject3.put((JSONObject) "success", (String) Boolean.FALSE);
        if (Intrinsics.areEqual(resultType, "NO_CONTENT_INFO")) {
            str = "002";
        } else {
            str = Intrinsics.areEqual(resultType, "NO_MESSAGE") ? "003" : "001";
        }
        jSONObject3.put((JSONObject) "error", str);
        return jSONObject2;
    }

    private final String extractLinks(String text) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Patterns.WEB_URL.matcher(text);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        ArrayList arrayList2 = arrayList;
        Object[] array = arrayList2.toArray(new String[0]);
        if (array != null) {
            if ((!(array.length == 0)) == true) {
                Object[] array2 = arrayList2.toArray(new String[0]);
                if (array2 != null) {
                    return ((String[]) array2)[0];
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            return "";
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
